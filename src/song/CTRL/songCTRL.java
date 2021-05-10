package song.CTRL;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import ll.BIZ.llBIZ;
import song.BIZ.songBIZ;
import song.VO.songVO;
import spmem.VO.spmemVO;

@Controller
@SessionAttributes("vo")
public class songCTRL {
	
	@Autowired
	@Qualifier("songBIZ")
	private songBIZ biz;
	
	@Autowired
	@Qualifier("llBIZ")
	private llBIZ llbiz;
	
	@SessionScope
	@RequestMapping(value = "/discovermuse.ma", method = RequestMethod.POST)
	public ModelAndView findurmuse(@RequestParam("Atmosphere")String Atmosphere,
			@RequestParam("genreaccept")String genreaccept,
			@ModelAttribute("vo")spmemVO vo,
			@RequestParam("count")String count,
			HttpServletResponse resp,
			HttpServletRequest req) throws IOException {
		int con = Integer.parseInt(count);
		String Nick = vo.getNickname();
		String Prefergenre = vo.getPrefergenre();
		String Atmos = vo.getPreferAtmos();
		String Atmos2 = vo.getPreferAtmos2();
		String Atmos3 = vo.getPreferAtmos3();
		String URLLINK = "";
		String genre = "";
		int genreacc = Integer.parseInt(genreaccept);
		List<songVO> llcandidate=null;
		switch(Integer.parseInt(Atmosphere)) {
		case 1 : llcandidate =
				biz.showsongall(Atmos, Prefergenre, genreacc); break;
		case 2 : llcandidate =
				biz.showsongall(Atmos2, Prefergenre, genreacc); break;
		case 3 : llcandidate =
				biz.showsongall(Atmos3, Prefergenre, genreacc); break;
		}
		if(con>=llcandidate.size()) {
			req.setAttribute("count", 0);
			con = 0;
		}
		int k = 0;
		for(songVO ve : llcandidate) {
			if(k==con) {
				Atmos = ve.getDisAtmos();
				URLLINK = ve.getURLLINK();
				genre = ve.getDisgenre();
			}
			k++;
		}
		boolean fw = llbiz.insertll(URLLINK, Nick, Atmos, genre);
		if((!fw) ||con>=llcandidate.size()) {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out_email2 = resp.getWriter();
			out_email2.println("<script>alert('"+Nick+","
					+ "Error happened. we recommand login again');"
					+ "</script>");
			out_email2.flush();
			req.getSession().removeAttribute("ver");
			return new ModelAndView("/main");
		}
		songVO svo = new songVO();
		svo.setURLLINK(URLLINK);
		svo.setDisAtmos(Atmos);
		return new ModelAndView("/song/finduryoutube", "svo", svo);
	}
}
