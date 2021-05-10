package rto.CTRL;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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

import rto.BIZ.rtoBIZ;
import rto.VO.rtoVO;
import song.VO.songVO;
import spmem.VO.spmemVO;

@Controller
@SessionAttributes("vo")
public class rtoCTRL {
	
	@Autowired
	@Qualifier("rtoBIZ")
	private rtoBIZ rtobiz;
	
	@SessionScope
	@RequestMapping("/rtowrite.ma")
	public ModelAndView showrtoform() {
		List<spmemVO> spmvo = rtobiz.showmemberall();
		//List<songVO> sonvo = rtobiz.showsongforrto();
		ModelAndView mvo = new ModelAndView("/rto/rtotoother","spmvo", spmvo);
		return mvo;
	}
	
	@SessionScope
	@RequestMapping(value = "/rtosend.ma", method = RequestMethod.POST)
	public ModelAndView insertRTO(
			@RequestParam("SNICK")String SNick, 
			@RequestParam("RNICK")String RNick, 
			@RequestParam("URLLINK")String URLLINK,
			HttpServletResponse resp) throws IOException {
		List<songVO> sonvo = rtobiz.showsongforrto();
		System.out.println(SNick);
		System.out.println(RNick);
		System.out.println(URLLINK);
		for(songVO svo : sonvo) {
			if(svo.getURLLINK().equals(URLLINK)) {
				System.out.println("52라인");
				boolean RTOsend = rtobiz.insertRTO(SNick, RNick, URLLINK);
				System.out.println("55라인");
				if(RTOsend) {
					resp.setContentType("text/html; charset=UTF-8");
					PrintWriter out_email = resp.getWriter();
					out_email.println("<script>alert('your Recommandation"
							+ " to "+RNick+" sent in success!"
							+ "now moving to main page');"
							+ "</script>");
					out_email.flush();
					return new ModelAndView("/rto/rtotoother");
				}else {
					resp.setContentType("text/html; charset=UTF-8");
					PrintWriter out_email = resp.getWriter();
					out_email.println("<script>alert('your Recommandation"
							+ " to "+RNick+" failed"
							+ " : error about songLink');"
							+ "</script>");
					out_email.flush();
					return new ModelAndView("/rto/rtotoother");
				}
			}
		}
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out_email = resp.getWriter();
		out_email.println("<script>alert('your Recommandation"
				+ " to "+RNick+" failed"
				+ " : error about URLLINK. it's invalid');"
				+ "</script>");
		out_email.flush();
		return new ModelAndView("forward:/rtowrite.ma");
	}
	
	@SessionScope
	@RequestMapping("/rtoread.ma")
	public ModelAndView rtoreadmine(@ModelAttribute("vo")spmemVO vo,
			HttpServletResponse resp) throws IOException {
		List<rtoVO> rvo= rtobiz.showmyrto(vo.getNickname());
		if(rvo==null) {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out_email = resp.getWriter();
			out_email.println("<script>alert('There's nothing"
					+ " on your recommandation list. "
					+ "plz try later');"
					+ "</script>");
			out_email.flush();
			return new ModelAndView("forward:/main");
		}
		return new ModelAndView("/rto/showmyrto", "rvo", rvo);
	}
	
	@SessionScope
	@RequestMapping("/showRTOall.ma")
	public ModelAndView showRTOall() {
		List<rtoVO> rvo = rtobiz.showrtoall();
		return new ModelAndView("/rto/showrtoall", "rvo", rvo);
	}
	
	@RequestMapping("/backtomain.ma")
	public ModelAndView backtomain() {
		return new ModelAndView("/main2");
	}
}
