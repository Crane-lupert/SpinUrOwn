package spmem.CTRL;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spmem.BIZ.spmemBiz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.*;

@Controller
public class Spmememail {
	@Inject // 서비스를 호출하기 위해서 의존성을 주입
	JavaMailSender mailSender; // 메일 서비스를 사용하기 위해 의존성을 주입함.
	spmemBiz spmembiz; // 서비스를 호출하기 위해 의존성을 주입
	
	// 로깅을 위한 변수
	private static final Logger logger 
		= LoggerFactory.getLogger(Spmememail.class);
	private static final String String = null;

	// mailSending 코드
	@RequestMapping(value = "/mailauth.me", method = RequestMethod.POST)
	public ModelAndView mailSending(HttpServletRequest request, String e_mail, 
			HttpServletResponse response_email) throws IOException {

		Random r = new Random();
		int dice = r.nextInt(4589362) + 49311; // 이메일로 받는 인증코드 부분 (난수)
		System.out.println("input email is : "+e_mail);
		request.setAttribute("email", e_mail);
		String setfrom = "chosen158@naver.com";
		String tomail = request.getParameter("e_mail"); // 받는 사람 이메일
		String title = "Account E-mail Validation from SpinUrOwn!"; // 제목
		String content =

				System.getProperty("line.separator") + // 한줄씩 줄간격을 두기위해 작성

					System.getProperty("line.separator") +

					"Thank you for join SpinUrOwn!"

					+ System.getProperty("line.separator") +

					System.getProperty("line.separator") +

					" Your Validation Code is " + dice

					+ System.getProperty("line.separator") +

					System.getProperty("line.separator") +

					"if you type your Validation Code, we'll "
					+ "take you to next phase!"; // 내용

		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

			messageHelper.setFrom(setfrom); // 보내는사람 생략하면 정상작동을 안함
			messageHelper.setTo(tomail); // 받는사람 이메일
			messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
			messageHelper.setText(content); // 메일 내용

			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView mv = new ModelAndView(); // ModelAndView로 보낼 페이지를 지정하고, 보낼 값을 지정한다.
		mv.setViewName("email_injeung"); // 뷰의이름
		mv.addObject("dice", dice);

		System.out.println("mv : " + mv);

		response_email.setContentType("text/html; charset=UTF-8");
		PrintWriter out_email = response_email.getWriter();
		out_email.println("<script>alert('Validation Code sent. Please check your E-mail');</script>");
		out_email.flush();

		return mv;

	}

	// 이메일 인증 페이지 맵핑 메소드
	@RequestMapping("email.me")
	public String email() {
		return "/email";
	}

	// 이메일로 받은 인증번호를 입력하고 전송 버튼을 누르면 맵핑되는 메소드.
	// 내가 입력한 인증번호와 메일로 입력한 인증번호가 맞는지 확인해서 맞으면 회원가입 페이지로 넘어가고,
	// 틀리면 다시 원래 페이지로 돌아오는 메소드
	@RequestMapping(value = "join_injeung.me", method = RequestMethod.POST)
	public ModelAndView join_injeung(String email_injeung, String dice, 
			String email, HttpServletResponse response_equals)
			throws IOException {
		System.out.println("마지막 : email_injeung : " + email_injeung);

		System.out.println("마지막 : dice : " + dice);

		// 페이지이동과 자료를 동시에 하기위해 ModelAndView를 사용해서 이동할 페이지와 자료를 담음
		
		ModelAndView mv = new ModelAndView();

		mv.setViewName("join.me");

		mv.addObject("e_mail", email_injeung);

		if (email_injeung.equals(dice)) {

			// 인증번호가 일치할 경우 인증번호가 맞다는 창을 출력하고 회원가입창으로 이동함

			mv.setViewName("join");

			mv.addObject("e_mail", email);

			// 만약 인증번호가 같다면 이메일을 회원가입 페이지로 같이 넘겨서 이메일을
			// 한번더 입력할 필요가 없게 한다.

			response_equals.setContentType("text/html; charset=UTF-8");
			PrintWriter out_equals = response_equals.getWriter();
			out_equals.println("<script>alert('Validation success. Now moving to registration page.');</script>");
			out_equals.flush();

			return mv;

		} else if (email_injeung != dice) {
			System.out.println("you wrong!");
			ModelAndView mv2 = new ModelAndView();

			mv2.setViewName("email_injeung");

			response_equals.setContentType("text/html; charset=UTF-8");
			PrintWriter out_equals = response_equals.getWriter();
			out_equals.println("<script>alert('Validation code is not matched. plz try again'); history.go(-1);</script>");
			out_equals.flush();

			return mv2;

		}

		return mv;
	}
}
