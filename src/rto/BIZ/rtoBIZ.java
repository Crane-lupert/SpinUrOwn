package rto.BIZ;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import rto.DAO.rtoDAO;
import rto.VO.rtoVO;
import song.VO.songVO;
import spmem.VO.spmemVO;

@Service("rtoBIZ")
public class rtoBIZ {
	
	@Autowired
	@Qualifier("rtoDAO")
	private rtoDAO rtobiz;
	
	public boolean insertRTO(String SNick, String RNick, String URLLINK) {
		return rtobiz.insertRTO(SNick, RNick, URLLINK);
	}
	
	public List<rtoVO> showmyrto(String RNick){
		return rtobiz.showmyrto(RNick);
	}
	
	public List<rtoVO> showrtoall(){
		return rtobiz.showrtoall();
	}
	
	public List<spmemVO> showmemberall(){
		return rtobiz.showmemberall();
	}
	public List<songVO> showsongforrto(){
		return rtobiz.showsongforrto();
	}
	
	public boolean pointforRTO(String Nick) {
		return rtobiz.pointforRTO(Nick);
	}
}

