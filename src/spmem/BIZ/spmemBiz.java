package spmem.BIZ;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import spmem.DAO.spmemDao;
import spmem.VO.spmemVO;

@Service("spmemBiz")
public class spmemBiz{
	
	@Autowired(required = true)
	@Qualifier("spmemdao")
	private spmemDao spmemdao;
	
	//계정생성
	public boolean insert(spmemVO vo) {
		return spmemdao.insert(vo);
	}
	
	//로그인용
	public spmemVO select(String ID, String Password) {
		return spmemdao.select(ID, Password);
	}
	
	public boolean checkNick(String Nick) {
		return spmemdao.checkNick(Nick);
	}	

	public boolean checkID(String ID) {
		return spmemdao.checkID(ID);
	}	
	
	public spmemVO searchspmem(String id) {
		return spmemdao.searchspmem(id);
	}
	
	public boolean deletespmem
		(String Nick, String Password) {
		return spmemdao.deletespmem(Nick, Password);
	}
	
	public String selectgenre(String Nick) {
		return spmemdao.selectgenre(Nick);
	}
	
	public spmemVO updategenre(String Nick, String Prefergenre) {
		return spmemdao.updategenre(Nick, Prefergenre);
	}
	
	public String selectAtmos(String Nick) {
		return spmemdao.selectAtmos(Nick);
	}
	
	public spmemVO updateAtmos(String Nick, String PreferAtmos) {
		return spmemdao.updateAtmos(Nick, PreferAtmos);
	}
	
	public String selectAtmos2(String Nick) {
		return spmemdao.selectAtmos2(Nick);
	}
	
	public spmemVO updateAtmos2(String Nick, String PreferAtmos) {
		return spmemdao.updateAtmos2(Nick, PreferAtmos);
	}
	
	public String selectAtmos3(String Nick) {
		return spmemdao.selectAtmos3(Nick);
	}
	
	public spmemVO updateAtmos3(String Nick, String PreferAtmos) {
		return spmemdao.updateAtmos3(Nick, PreferAtmos);
	}
}
