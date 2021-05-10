package ll.CTRL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ll.BIZ.llBIZ;
import ll.VO.llVO;

@Controller
public class llCTRL {
	
	@Autowired
	@Qualifier("llBIZ")
	private llBIZ llbiz;
	
	@RequestMapping("/showLLall.ma")
	public ModelAndView showLLall() {
		List<llVO> lvo = llbiz.showllall();
		return new ModelAndView("/ll/showLLall", "lvo", lvo);
	}
	

}
