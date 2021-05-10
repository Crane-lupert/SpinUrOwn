package spmem.CTRL;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import spmem.BIZ.spmemBiz;
import spmem.VO.spmemVO;

@Controller
@SessionAttributes("vo")
public class Spmemmain {
	@Autowired
	@Qualifier("spmemBiz")
	private spmemBiz biz;
	
	@RequestMapping("/logout.ma")
	public ModelAndView logout(SessionStatus st) {
		//System.out.println(st.isComplete()); //문제 발생하면 이걸 넣자 .
		st.setComplete();
		return new ModelAndView("/index");
	}
	
	@RequestMapping("/main.ma")
	public ModelAndView reconnect(@ModelAttribute("vo")spmemVO vo) {
		return new ModelAndView("/main2");
	}
	
	@RequestMapping("/genreUpdate.ma")
	public ModelAndView regpregenre(@ModelAttribute("vo")spmemVO vo,
			HttpServletRequest req, Model mo,
			HttpServletResponse resp) throws IOException {
		System.out.println(vo.getPrefergenre());
		String genre=vo.getPrefergenre().toString().trim();
		String gen[] = new String[7];
		if(!genre.equals("0")) {
			gen = genre.split(" ");
		}
		if ((!genre.equals("0")) && (gen.length==7) ) {//제대로된 기존 입력값 존재
			req.setAttribute("classic", gen[0]);
			req.setAttribute("Jazz", gen[1]);
			req.setAttribute("Rock", gen[2]);
			req.setAttribute("Metal", gen[3]);
			req.setAttribute("Rap", gen[4]);
			req.setAttribute("Electronic", gen[5]);
			req.setAttribute("Meaningful_Joyful", gen[6]);
		}else if(genre.equals("0")) {//초기입력
			req.setAttribute("classic", 0);
			req.setAttribute("Jazz", 0);
			req.setAttribute("Rock", 0);
			req.setAttribute("Metal", 0);
			req.setAttribute("Rap", 0);
			req.setAttribute("Electronic", 0);
			req.setAttribute("Meaningful_Joyful", 0);
		}else {//제대로된 기존 입력값 부재
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out_email = resp.getWriter();
			out_email.println("<script>alert('your genreDB is"
					+ " Corrupted, so we initalize that');"
					+ "</script>");
			out_email.flush();
			req.setAttribute("classic", 0);
			req.setAttribute("Jazz", 0);
			req.setAttribute("Rock", 0);
			req.setAttribute("Metal", 0);
			req.setAttribute("Rap", 0);
			req.setAttribute("Electronic", 0);
			req.setAttribute("Meaningful_Joyful", 0);
		}
		ModelAndView mav = new ModelAndView("/Spmem/genreUpdate");
		return mav;
	}
	
	@RequestMapping(value = "/reggenre.ma", method = RequestMethod.POST)
	public ModelAndView regpostgenre(@ModelAttribute("vo")spmemVO vo,
			@RequestParam("Classic")String Classic,
			@RequestParam("Jazz")String Jazz,
			@RequestParam("Rock")String Rock,
			@RequestParam("Metal")String Metal,
			@RequestParam("Rap")String Rap,
			@RequestParam("Electronic")String Electronic,
			@RequestParam("Meaningful_Joyful")String Meaningful_Joyful,
			HttpServletResponse resp) throws IOException{
		String Prefergenre = Classic+" "+Jazz+" "+
			Rock+" "+Metal+" "+Rap+" "+Electronic+
			" "+Meaningful_Joyful;
		String Nick = vo.getNickname().trim();
		spmemVO vgo = biz.updategenre(Nick, Prefergenre);
		if(vgo.getPrefergenre().equals(Prefergenre)) {//제대로 들어감
			vo.setPrefergenre(Prefergenre.trim());
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out_email = resp.getWriter();
			out_email.println("<script>alert('"+Nick+","
					+ " your genremodify is received!');"
					+ "</script>");
			out_email.flush();
			
		}else {//제대로 안들어감
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out_email = resp.getWriter();
			out_email.println("<script>alert('"+Nick+","
					+ "there's an error on register. plz try again');"
					+ "</script>");
			out_email.flush();
		}
		return new ModelAndView("/Spmem/genreUpdate");
	}
	
	@SessionScope
	@RequestMapping(value = "/delaccount.ma")
	public ModelAndView deleteaccount() {
		System.out.println("과연 여긴 올까? 두둥탁");
		return new ModelAndView("/Spmem/deleteaccount");
	}
	
	@SessionScope
	@RequestMapping(value = "/farewell.ma", method = RequestMethod.POST)
	public ModelAndView spmemdelete(SessionStatus st,
			@ModelAttribute("vo")spmemVO vo,
			@RequestParam("pw")String pw, 
			HttpServletResponse resp) throws IOException {
		String Nick = vo.getNickname().trim();
		String realpw = vo.getPassword().trim();
		if(realpw.equals(pw)) {//비번입력 성공
			if(biz.deletespmem(Nick, realpw)) {
				resp.setContentType("text/html; charset=UTF-8");
				PrintWriter out_email = resp.getWriter();
				out_email.println("<script>alert('"+Nick+","
						+ "thanks for your devotion. farewell');"
						+ "</script>");
				out_email.flush();
				st.setComplete();
			}else {
				resp.setContentType("text/html; charset=UTF-8");
				PrintWriter out_email = resp.getWriter();
				out_email.println("<script>alert('"+Nick+","
						+ "there's an error about deleting your account');"
						+ "</script>");
				out_email.flush();
				st.setComplete();
			}
			return new ModelAndView("index");
		}else {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out_email = resp.getWriter();
			out_email.println("<script>alert('"+Nick+","
					+ "there's a problem in password, plz type again');"
					+ "</script>");
			out_email.flush();
			return new ModelAndView("/Spmem/deleteaccount");
		}
	}
	
	@SessionScope
	@RequestMapping(value = "/AtmosUpdate.ma")
	public ModelAndView regpreAtmos(@ModelAttribute("vo")spmemVO vo,
			HttpServletResponse resp) throws IOException {
		System.out.println(vo.getNickname());
		String Nick = vo.getNickname().trim();
		String Atmos = biz.selectAtmos(Nick).trim();
		ModelAndView mav = new ModelAndView();
		if(Atmos.equals("0")) {//처음이니?
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out_email = resp.getWriter();
			out_email.println("<script>alert('"+Nick+","
					+ "welcome to SpinUrOwn, as you enlist Atmos,"
					+ "we can recommand song that fits to you');"
					+ "</script>");
			out_email.flush();
			mav.setViewName("/Spmem/AtmosUpdate");
			mav.addObject("Atmos", 0);
		}else if(Atmos.trim().split(" ").length!=5) {//망가져버렸!
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out_email = resp.getWriter();
			out_email.println("<script>alert('"+Nick+","
					+ "your atmosphere data is corrupted"
					+ "so we initalized that');"
					+ "</script>");
			out_email.flush();
			mav.setViewName("/Spmem/AtmosUpdate");
			mav.addObject("Atmos", 0);
		}else {//드디어 제대로 됨
			String[] Atmosgroup = Atmos.split(" ");
			mav.setViewName("/Spmem/AtmosUpdate");
			mav.addObject("Atmos", Atmosgroup);
		}
		return mav;
	}
	
	@SessionScope
	@RequestMapping(value = "/regAtmos.ma", method = RequestMethod.POST)
	public ModelAndView updateAtmos(@ModelAttribute("vo") spmemVO vo,
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
			SessionStatus st,
			HttpServletResponse resp) throws IOException {
		System.out.println(st.isComplete());
		String Nick = vo.getNickname().trim();
		double pure = 0;
		double deep = 0;
		double happy = 0;
		double sad = 0;
		double hard = 0;
		switch(Integer.parseInt(cen1.trim())) {
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
		switch(Integer.parseInt(cen2.trim())) {
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
		switch(Integer.parseInt(cen3.trim())) {
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
		switch(Integer.parseInt(cen4.trim())) {
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
		switch(Integer.parseInt(cen5.trim())) {
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
		switch(Integer.parseInt(cen6.trim())) {
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
		String Ps = ""+pure+" "+deep+" "+happy+" "+sad+" "+hard;
		spmemVO vAo = biz.updateAtmos(
				Nick, Ps);
		ModelAndView mav = new ModelAndView();
		if((vAo!=null) && (vAo.getPreferAtmos().trim().equals(Ps))) {//수정에 성공함
			vo.setPreferAtmos(Ps);
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out_email = resp.getWriter();
			out_email.println("<script>alert('"+Nick+","
					+ "your atmosphere data change"
					+ "completed! now moving to main page');"
					+ "</script>");
			out_email.flush();
			mav.setViewName("/Spmem/AtmosUpdate");
		}else {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out_email = resp.getWriter();
			out_email.println("<script>alert('"+Nick+","
					+ "your atmosphere data change"
					+ "failed! plz try again');"
					+ "</script>");
			out_email.flush();
			mav.setViewName("/Spmem/AtmosUpdate");
		}
		return mav;
	}
	
	@SessionScope
	@RequestMapping("/AtmosUpdate2.ma")
	public ModelAndView regpreAtmos2(@ModelAttribute("vo")spmemVO vo,
			HttpServletResponse resp) throws IOException {
		String Nick = vo.getNickname().trim();
		String Atmos = biz.selectAtmos(Nick).trim();
		ModelAndView mav = new ModelAndView();
		if(Atmos.equals("0")) {//처음이니?
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out_email = resp.getWriter();
			out_email.println("<script>alert('"+Nick+","
					+ "welcome to SpinUrOwn, as you enlist Atmos,"
					+ "we can recommand song that fits to you');"
					+ "</script>");
			out_email.flush();
			mav.setViewName("/Spmem/AtmosUpdate2");
			mav.addObject(Atmos, 0);
		}else if(Atmos.trim().split(" ").length!=5) {//망가져버렸!
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out_email = resp.getWriter();
			out_email.println("<script>alert('"+Nick+","
					+ "your atmosphere data is corrupted"
					+ "so we initalized that');"
					+ "</script>");
			out_email.flush();
			mav = new ModelAndView("/Spmem/AtmosUpdate2", "Atmos", 0);
		}else {//드디어 제대로 됨
			String[] Atmosgroup = Atmos.split(" ");
			mav = new ModelAndView("/Spmem/AtmosUpdate2", "Atmos", Atmosgroup);
		}
		return mav;
	}
	
	@SessionScope
	@RequestMapping(value = "/regAtmos2.ma", method = RequestMethod.POST)
	public ModelAndView updateAtmos2(@ModelAttribute("vo")spmemVO vo,
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
			HttpServletResponse resp) throws IOException {
		String Nick = vo.getNickname().trim();
		double pure = 0;
		double deep = 0;
		double happy = 0;
		double sad = 0;
		double hard = 0;
		switch(Integer.parseInt(cen1.trim())) {
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
		switch(Integer.parseInt(cen2.trim())) {
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
		switch(Integer.parseInt(cen3.trim())) {
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
		switch(Integer.parseInt(cen4.trim())) {
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
		switch(Integer.parseInt(cen5.trim())) {
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
		switch(Integer.parseInt(cen6.trim())) {
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
		String Ps = ""+pure+" "+deep+" "+happy+" "+sad+" "+hard;
		spmemVO vAo = biz.updateAtmos2(
				Nick, Ps);
		System.out.println("vAo" + vAo);
		System.out.println("vAo.getPreferAtmos2().trim()" + vAo.getPreferAtmos2().trim());
		ModelAndView mav = new ModelAndView();
		if((vAo!=null) && (vAo.getPreferAtmos2().trim().equals(Ps))) {//수정에 성공함
			vo.setPreferAtmos2(Ps);
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out_email = resp.getWriter();
			out_email.println("<script>alert('"+Nick+","
					+ "your atmosphere2 data change"
					+ "completed! now moving to main page');"
					+ "</script>");
			out_email.flush();
			mav.setViewName("/main");
		}else {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out_email = resp.getWriter();
			out_email.println("<script>alert('"+Nick+","
					+ "your atmosphere2 data change"
					+ "failed! plz try again');"
					+ "</script>");
			out_email.flush();
			mav.setViewName("/main");
		}
		return mav;
	}
	
	@SessionScope
	@RequestMapping("/AtmosUpdate3.ma")
	public ModelAndView regpreAtmos3(@ModelAttribute("vo")spmemVO vo,
			HttpServletResponse resp) throws IOException {
		String Nick = vo.getNickname().trim();
		String Atmos = biz.selectAtmos(Nick).trim();
		ModelAndView mav = new ModelAndView();
		if(Atmos.equals("0")) {//처음이니?
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out_email = resp.getWriter();
			out_email.println("<script>alert('"+Nick+","
					+ "welcome to SpinUrOwn, as you enlist Atmos,"
					+ "we can recommand song that fits to you');"
					+ "</script>");
			out_email.flush();
			mav.setViewName("/Spmem/AtmosUpdate3");
			mav.addObject(Atmos, 0);
		}else if(Atmos.trim().split(" ").length!=5) {//망가져버렸!
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out_email = resp.getWriter();
			out_email.println("<script>alert('"+Nick+","
					+ "your atmosphere data is corrupted"
					+ "so we initalized that');"
					+ "</script>");
			out_email.flush();
			mav = new ModelAndView("/Spmem/AtmosUpdate3", "Atmos", 0);
		}else {//드디어 제대로 됨
			String[] Atmosgroup = Atmos.split(" ");
			mav = new ModelAndView("/Spmem/AtmosUpdate3", "Atmos", Atmosgroup);
		}
		return mav;
	}
	
	@SessionScope
	@RequestMapping(value = "/regAtmos3.ma", method = RequestMethod.POST)
	public ModelAndView updateAtmos3(@ModelAttribute("vo")spmemVO vo,
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
			HttpServletResponse resp) throws IOException {
		String Nick = vo.getNickname().trim();
		double pure = 0;
		double deep = 0;
		double happy = 0;
		double sad = 0;
		double hard = 0;
		switch(Integer.parseInt(cen1.trim())) {
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
		switch(Integer.parseInt(cen2.trim())) {
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
		switch(Integer.parseInt(cen3.trim())) {
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
		switch(Integer.parseInt(cen4.trim())) {
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
		switch(Integer.parseInt(cen5.trim())) {
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
		switch(Integer.parseInt(cen6.trim())) {
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
		String Ps = ""+pure+" "+deep+" "+happy+" "+sad+" "+hard;
		spmemVO vAo = biz.updateAtmos3(
				Nick, Ps);
		ModelAndView mav = new ModelAndView();
		if((vAo!=null) && (vAo.getPreferAtmos3().trim().equals(Ps))) {//수정에 성공함
			vo.setPreferAtmos3(Ps);
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out_email = resp.getWriter();
			out_email.println("<script>alert('"+Nick+","
					+ "your atmosphere2 data change"
					+ "completed! now moving to main page');"
					+ "</script>");
			out_email.flush();
			mav.setViewName("/main");
		}else {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out_email = resp.getWriter();
			out_email.println("<script>alert('"+Nick+","
					+ "your atmosphere2 data change"
					+ "failed! plz try again');"
					+ "</script>");
			out_email.flush();
			mav.setViewName("/main");
		}
		return mav;
	}
}
