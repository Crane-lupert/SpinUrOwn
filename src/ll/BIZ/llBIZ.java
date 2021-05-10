package ll.BIZ;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ll.DAO.llDAO;
import ll.VO.llVO;

@Service("llBIZ")
public class llBIZ {
	
	@Autowired(required = true)
	@Qualifier("llDAO")
	private llDAO lldao;
	
	public List<llVO> showllall(){
		return lldao.showllall();
	}
	
	public boolean insertll(String URLLINK, String Nick, String DisAtmos, String Disgenre) {
		return lldao.insertll(URLLINK, Nick, DisAtmos, Disgenre);
	}
	
	public boolean updatell(String Nick, String URLLINK, String LisTime, String IsSatisfied) {
		return lldao.updatell(Nick, URLLINK, LisTime, IsSatisfied);
	}
}
