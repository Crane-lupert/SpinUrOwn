package asl.BIZ;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import asl.DAO.aslDAO;
import asl.VO.aslVO;
import song.VO.songVO;

@Service("aslBIZ")
public class aslBIZ {
	
	@Autowired(required = true)
	@Qualifier("aslDAO")
	private aslDAO aslbiz;
	
	public List<aslVO> showaslall(){
		return aslbiz.showaslall();
	}
	
	public boolean insertasl(String URLLINK, String Nick, String genre, String Atmos) {
		return aslbiz.insertasl(URLLINK, Nick, genre, Atmos);
	}
	
	public boolean pointforaslreg(String Nick) {
		return aslbiz.pointforaslreg(Nick);
	}
	
	public boolean songavgupdate(String URLLINK, String genre, String Atmos) {
		return aslbiz.songavgupdate(URLLINK, genre, Atmos);
	}
	
	public aslVO aslURLgather(String URLLINK){
		List<aslVO> volist = aslbiz.aslURLgather(URLLINK);
		int cnt = 0;
		String genre = "";
		String Atmos = "";
		int[] genresplit =new int[7];
		double[] Atmossplit =new double[5];
		for(aslVO vSo : volist) {//리스트를 각 vo객체로 나눈다.
			cnt++;
			//각 vo의 장르/분위기를 쪼개준다.
			String[] genredetail = vSo.getGenre().trim().split(" ");
			String[] Atmosdetail = vSo.getAtmos().trim().split(" ");
			//에러가 있다면 짤라줘야 한다.
			if((genredetail.length!=7) || (Atmosdetail.length!=5)) {
				return new aslVO();
			}
			//자른건 일단 총합을 해준다.
			for(int k = 0;k<7;k++) {
				genresplit[k]+=Integer.parseInt(genredetail[k]);
			}
			for(int j = 0;j<5;j++) {
				Atmossplit[j]+=Double.parseDouble(Atmosdetail[j]);
			}
		}
		//다 담겼으니 이제 나눠준다.+한 곳에 담아주자
		for(int k = 0;k<7;k++) {
			genresplit[k]/=(cnt*1.0);
			genre+=genresplit[k]+" ";
		}
		for(int j = 0;j<5;j++) {
			Atmossplit[j]/=(cnt*1.0);
			Atmos+=Atmossplit[j]+" ";
		}
		aslVO lvo = new aslVO();
		lvo.setGenre(genre.trim());
		lvo.setAtmos(Atmos.trim());
		return lvo;
	}
	
	public List<songVO>showSongforASL(String URLLINK){
		return aslbiz.showSongforASL(URLLINK);
	}
	
	public boolean addSong(String URLLINK, String genre, String Atmos) {
		return aslbiz.addSong(URLLINK, genre, Atmos);
	}
}
