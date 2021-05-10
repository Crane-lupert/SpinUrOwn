package asl.CTRL;

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

import asl.BIZ.aslBIZ;
import asl.VO.aslVO;
import spmem.VO.spmemVO;

@Controller
@SessionAttributes("vo")
public class aslCTRL {

	@Autowired
	@Qualifier("aslBIZ")
	private aslBIZ biz;
	
	@SessionScope
	@RequestMapping(value = "/ASLUpdate.ma")
	public ModelAndView ASLupdate(@ModelAttribute("vo")spmemVO vo) {
		return new ModelAndView("/asl/ASLupdate");
	}
	
	@SessionScope
	@RequestMapping(value = "/ASLregister.ma", method = RequestMethod.POST)
	public ModelAndView ASLregister(@ModelAttribute("vo")spmemVO vo,
			@RequestParam("URLLINK")String URLLINK,
			@RequestParam("cent1option")String cen1,
			@RequestParam("cent2option")String cen2,
			@RequestParam("cent3option")String cen3,
			@RequestParam("cent4option")String cen4,
			@RequestParam("cent5option")String cen5,
			@RequestParam("cent6option")String cen6,
			@RequestParam("cent1")double cent1,
			@RequestParam("cent2")double cent2,
			@RequestParam("cent3")double cent3,
			@RequestParam("cent4")double cent4,
			@RequestParam("cent5")double cent5,
			@RequestParam("cent6")double cent6,
			@RequestParam("Classic")String Classic,
			@RequestParam("Jazz")String Jazz,
			@RequestParam("Rock")String Rock,
			@RequestParam("Metal")String Metal,
			@RequestParam("Rap")String Rap,
			@RequestParam("Electronic")String Electronic,
			@RequestParam("Meaningful_Joyful")String Meaningful_Joyful,
			HttpServletResponse resp) throws IOException {
		System.out.println(Classic);
		System.out.println(Meaningful_Joyful);
		String genre = Classic.trim()+" "+Jazz.trim()+" "+
				Rock.trim()+" "+Metal.trim()+" "+Rap.trim()+" "+Electronic.trim()+
				" "+Meaningful_Joyful.trim();
		String Nick = vo.getNickname().trim();
		int Point = vo.getPoint();
		double pure = 0;
		double deep = 0;
		double happy = 0;
		double sad = 0;
		double hard = 0;
		switch(Integer.parseInt(cen1)) {
		case 1 : 
			pure+=(cent1*0.3141744681); 
			deep+=(cent1*0.1804489253); 
			happy+=(cent1*0.3543189835);
			sad+=(cent1*0.133286138);
			hard+=(cent1*0.01777148507); 
			break;
		case 2 :
			pure+=(cent1*0.1039599053); 
			deep+=(cent1*0.3256925704); 
			happy+=(cent1*0.2535991629);
			sad+=(cent1*0.2044831195);
			hard+=(cent1*0.1122652421);
			break;
		case 3 :
			pure+=(cent1*0.0730067788); 
			deep+=(cent1*0.3669058627); 
			happy+=(cent1*0.1987406756);
			sad+=(cent1*0.2168080098);
			hard+=(cent1*0.1445386732);
			break;
		case 4 : 
			pure+=(cent1*0.2002930992); 
			deep+=(cent1*0.2971870258); 
			happy+=(cent1*0.1324159934);
			sad+=(cent1*0.2379239239);
			hard+=(cent1*0.1321799577);
			break;
		}
		switch(Integer.parseInt(cen2)) {
		case 1 : 
			pure+=(cent2*0.4162421773); 
			deep+=(cent2*0.358608645); 
			happy+=(cent2*0.04856158735);
			sad+=(cent2*0.1059525542);
			hard+=(cent2*0.07063503614);
			break;
		case 2 :
			pure+=(cent2*0.3763653112); 
			deep+=(cent2*0.3242531912); 
			happy+=(cent2*0.04390928631);
			sad+=(cent2*0.1916041584);
			hard+=(cent2*0.06386805281);
			break;
		case 3 :
			pure+=(cent2*0.05789669017); 
			deep+=(cent2*0.3741016903); 
			happy+=(cent2*0.3715037619);
			sad+=(cent2*0.1473733932);
			hard+=(cent2*0.04912446439);
			break;
		case 4 : 
			pure+=(cent2*0.2264748581); 
			deep+=(cent2*0.2090537152); 
			happy+=(cent2*0.2076019533);
			sad+=(cent2*0.1647089877);
			hard+=(cent2*0.1921604857);
			break;
		}
		switch(Integer.parseInt(cen3)) {
		case 1 : 
			pure+=(cent3*0.4601523115); 
			deep+=(cent3*0.1982194573); 
			happy+=(cent3*0.1073688727);
			sad+=(cent3*0.2342593586);
			hard+=(cent3*0);
			break;
		case 2 :
			pure+=(cent3*0.5549446996); 
			deep+=(cent3*0.2390531014); 
			happy+=(cent3*0.06474354828);
			sad+=(cent3*0.1412586508);
			hard+=(cent3*0);
			break;
		case 3 :
			pure+=(cent3*0.4367078943); 
			deep+=(cent3*0.1881203237); 
			happy+=(cent3*0.152847763);
			sad+=(cent3*0.2223240189);
			hard+=(cent3*0);
			break;
		case 4 : 
			pure+=(cent3*0.0834914611); 
			deep+=(cent3*0); 
			happy+=(cent3*0.63314358);
			sad+=(cent3*0.2125237192);
			hard+=(cent3*0.07084123972);
			break;
		}
		switch(Integer.parseInt(cen4)) {
		case 1 : 
			pure+=(cent4*0); 
			deep+=(cent4*0.2482369535); 
			happy+=(cent4*0.06723084156);
			sad+=(cent4*0.58674189);
			hard+=(cent4*0.097790315);
			break;
		case 2 :
			pure+=(cent4*0.3083003953); 
			deep+=(cent4*0.3320158103); 
			happy+=(cent4*0.3596837945);
			sad+=(cent4*0);
			hard+=(cent4*0);
			break;
		case 3 :
			pure+=(cent4*0); 
			deep+=(cent4*0.1529105126); 
			happy+=(cent4*0.1242397915);
			sad+=(cent4*0.5421372719);
			hard+=(cent4*0.180712424);
			break;
		case 4 : 
			pure+=(cent4*0); 
			deep+=(cent4*0.1975308642); 
			happy+=(cent4*0.3744855967);
			sad+=(cent4*0.3501683502);
			hard+=(cent4*0.07781518893);
			break;
		}
		switch(Integer.parseInt(cen5)) {
		case 1 : 
			pure+=(cent5*0.1764705882); 
			deep+=(cent5*0); 
			happy+=(cent5*0.4117647059);
			sad+=(cent5*0.1122994652);
			hard+=(cent5*0.2994652406);
			break;
		case 2 :
			pure+=(cent5*0); 
			deep+=(cent5*0.5517241379); 
			happy+=(cent5*0.1494252874);
			sad+=(cent5*0.08150470219);
			hard+=(cent5*0.2173458725);
			break;
		case 3 :
			pure+=(cent5*0.123364486); 
			deep+=(cent5*0); 
			happy+=(cent5*0.7196261682);
			sad+=(cent5*0.1570093458);
			hard+=(cent5*0);
			break;
		case 4 : 
			pure+=(cent5*0); 
			deep+=(cent5*0.2188147534); 
			happy+=(cent5*0.1777869872);
			sad+=(cent5*0.258599254);
			hard+=(cent5*0.3447990054);
			break;
		}
		switch(Integer.parseInt(cen6)) {
		case 1 : 
			pure+=(cent6*0); 
			deep+=(cent6*0.5371312309); 
			happy+=(cent6*0.1454730417);
			sad+=(cent6*0);
			hard+=(cent6*0.3173957274);
			break;
		case 2 :
			pure+=(cent6*0); 
			deep+=(cent6*0.5038167939); 
			happy+=(cent6*0);
			sad+=(cent6*0.2977099237);
			hard+=(cent6*0.1984732824);
			break;
		case 3 :
			pure+=(cent6*0); 
			deep+=(cent6*0.6285714286); 
			happy+=(cent6*0);
			sad+=(cent6*0.3714285714);
			hard+=(cent6*0);
			break;
		case 4 : 
			pure+=(cent6*0); 
			deep+=(cent6*0); 
			happy+=(cent6*0.4074074074);
			sad+=(cent6*0.5925925926);
			hard+=(cent6*0);
			break;
		}
		String Atmos = ""+pure+" "+deep+" "+happy+" "+sad+" "+hard;
		System.out.println("=====");
		System.out.println(biz.showSongforASL(URLLINK));
		System.out.println("=====");
		if(biz.showSongforASL(URLLINK).size()==0) {//song테이블에해당 URL이 없는 경우
			biz.addSong(URLLINK, genre, Atmos);//추가하고 시작하자.
		}
		boolean asladd = biz.insertasl(URLLINK, Nick, genre, Atmos);
		if(asladd) {//넣는데에 성공하였다!
			boolean pointadd = biz.pointforaslreg(Nick);
			aslVO lvo = biz.aslURLgather(URLLINK);//biz에서 평균치로 뽑아주는 놈
			if((lvo.getAtmos()==null) || (lvo.getGenre()==null)) {
				resp.setContentType("text/html; charset=UTF-8");
				PrintWriter out_email = resp.getWriter();
				out_email.println("<script>alert('"+Nick+","
						+ "your sond assessment register"
						+ "completed. but there's an error on song DB update');"
						+ "</script>");
				out_email.flush();
				return new ModelAndView("/asl/ASLupdate");
			}
			if(!pointadd) {//포인트는 넣어지지 않았다.
				resp.setContentType("text/html; charset=UTF-8");
				PrintWriter out_email = resp.getWriter();
				out_email.println("<script>alert('"+Nick+","
						+ "your sond assessment register"
						+ "completed. but there's an error on point return');"
						+ "</script>");
				out_email.flush();
				return new ModelAndView("/asl/ASLupdate");
			}
			vo.setPoint(Point+10);
			boolean fw = biz.songavgupdate(URLLINK, lvo.getGenre(), lvo.getAtmos());
			if(!fw) {//업데이트 실패일 경우
				resp.setContentType("text/html; charset=UTF-8");
				PrintWriter out_email = resp.getWriter();
				out_email.println("<script>alert('"+Nick+","
						+ "your sond assessment register"
						+ "completed, but there's problem on updating songDB');"
						+ "</script>");
				out_email.flush();
				return new ModelAndView("/asl/ASLupdate");
			}
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out_email = resp.getWriter();
			out_email.println("<script>alert('"+Nick+","
					+ "your sond assessment register"
					+ "completed! now moving to main page');"
					+ "</script>");
			out_email.flush();
			return new ModelAndView("/asl/ASLupdate");
		}else {//넣는데에 실패하였다. 그냥 다 망했으면 좋겠다.
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out_email = resp.getWriter();
			out_email.println("<script>alert('"+Nick+","
					+ "your sond assessment register"
					+ "failed! plz try again');"
					+ "</script>");
			out_email.flush();
			return new ModelAndView("/asl/ASLupdate");
		}
	}
	
	@SessionScope
	@RequestMapping("/showASLall.ma")
	public ModelAndView showASLall() {
		List<aslVO> avo = biz.showaslall();
		return new ModelAndView("/asl/showASLall", "avo", avo);
	}
}
