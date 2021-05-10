package spmem.CTRL;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spmem.BIZ.spmemBiz;
import spmem.VO.spmemVO;

@Controller
public class SpmemSearch {
	
	@Autowired
	@Qualifier("spmemBiz")
	private spmemBiz biz;
	
	@RequestMapping("/spmemSearch.do")
	public ModelAndView search(
			@RequestParam("ID") String id) {
		//String id = request.getParameter("id");
		//이거 안쓰려면 위의 @를 써야 한다.
		spmemVO vo1 = biz.searchspmem(id);
		ModelAndView mav=new ModelAndView("spmem/view","vo1",vo1);
		return mav;
	}
	//닉네임 중복 체크
	@RequestMapping(value = "/checkNick.me", method = RequestMethod.POST)
	public @ResponseBody String AjaxViewNick(  
		   @RequestParam("Nickname") String nick){
		String str = "";
		if(biz.checkNick(nick)){ //이미 존재하는 계정
			str = "NO";	
		}else{	//사용 가능한 계정
			str = "YES";	
		}
		return str;
	}
	
	//아이디 중복체크
	@RequestMapping(value = "/checkID.me", method = RequestMethod.POST)
	public @ResponseBody String AjaxViewID(  
		   @RequestParam("ID") String ID){
		String str = "";
		if(biz.checkID(ID)){ //이미 존재하는 계정
			str = "NO";	
		}else{	//사용 가능한 계정
			str = "YES";	
		}
		return str;
	}
}
