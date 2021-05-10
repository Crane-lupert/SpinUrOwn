package spmem.CTRL;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import spmem.BIZ.spmemBiz;
import spmem.VO.spmemVO;

@Controller
@SessionAttributes("vo")
public class spmemSelect {
	@Autowired
	@Qualifier("spmemBiz")
	private spmemBiz biz;
	
	//로그인용
	@RequestMapping(value = "/splogin.me", method = RequestMethod.POST)
	public ModelAndView select(@SessionAttribute("vo")spmemVO vo, HttpServletRequest req,
			@RequestParam("ID")String ID, 
			@RequestParam("Password")String Password,
			HttpServletResponse resp
			) throws IOException {
		System.out.println(ID);
		vo = biz.select(ID, Password);
		ModelAndView mav = new ModelAndView();
		if(vo==null) {//로그인 실패!
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out_email = resp.getWriter();
			out_email.println("<script>alert('"
					+ "Login failed : invaild');"
					+ "</script>");
			out_email.flush();
			mav.setViewName("/index");
		}else {
			mav.setViewName("/main2");
			mav.addObject("vo", vo);
		}
		return mav;
	}

}
