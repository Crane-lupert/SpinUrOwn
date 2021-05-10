package spmem.CTRL;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spmem.BIZ.spmemBiz;
import spmem.VO.spmemVO;

@Controller
public class spmemInsert {
	
	@Autowired
	@Qualifier("spmemBiz")
	private spmemBiz biz;
	
	//계정생성
	@RequestMapping(value = "/spmemInsert.me", method = RequestMethod.POST)
	public String insert(HttpServletRequest req,
			@SessionAttribute("vo")spmemVO vo,
			HttpServletResponse resp) throws IOException {
		System.out.println(vo.getEmail());
		boolean result=biz.insert(vo);
		if(result) {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out_email = resp.getWriter();
			out_email.println("<script>alert('Account Registration"
					+ " Complete!');</script>");
			out_email.flush();
			return "/index";
		}else {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out_email = resp.getWriter();
			out_email.println("<script>alert('Account Registration"
					+ " Failed! Soon move to intro. "
					+ "Did you check your nickname and ID?');</script>");
			out_email.flush();
			return "/index";
		}
	}
}
