package song.BIZ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import song.DAO.songDAO;
import song.VO.songVO;

@Service("songBIZ")
public class songBIZ{
	
	@Autowired(required = true)
	@Qualifier("songDAO")
	private songDAO songdao;
	
	//사용자-대상노래 분위기 차이 계산
	public String DisAtmoscal(String memAtmos, String songAtmos) {
		String[] memberAtmos = memAtmos.split(" ");
		String[] songsAtmos = songAtmos.split(" ");
		String Disresult = "";
		if(memberAtmos.length!=5 ||songsAtmos.length!=5) {
			return "error";
		}
		for(int k =0;k<5;k++) {
			double j = Double.parseDouble(memberAtmos[k])
					-Double.parseDouble(songsAtmos[k]);
			Disresult+=(j*j);
			Disresult+=" ";
		}
		return Disresult.trim();
	}
	
	//사용자-대상노래 장르차이 계산
	public String Disgenrecal(String memgenre, String songgenre) {
		//System.out.println("BIZ DISMEM : "+memgenre);
		//System.out.println("BIZ DISSONG : "+songgenre);
		String[] memberAtmos = memgenre.split(" ");
		String[] songsAtmos = songgenre.split(" ");
		String Disresult = "";
		if(memberAtmos.length!=7 ||songsAtmos.length!=7) {
			return "error";
		}
		for(int k =0;k<7;k++) {
			int j = Integer.parseInt(memberAtmos[k])
					-Integer.parseInt(songsAtmos[k]);
			Disresult+=j*j;
			Disresult+=" ";
		}
		return Disresult.trim();
	}
	
	//사용자-대상노래 분위기차이 세부화 for 정렬
	public static double seeAtmosdetail(String Atmos) {
		String[] detailAtmos = Atmos.split(" ");
		double result=0;
		if(detailAtmos.length!=5) {
			return 999999;
		}
		for(String detail : detailAtmos) {
			result+=Double.parseDouble(detail);
		}
		return result;
	}
	
	//사용자-대상노래 장르차이 세부화 for 정렬
	public static int seegenredetail(String genre) {
		String[] detailgenre = genre.split(" ");
		int result=0;
		if(detailgenre.length!=7) {
			return 999999;
		}
		for(String detail : detailgenre) {
			result+=Integer.parseInt(detail);
		}
		return result;
	}	
	
	public List<songVO> showsongall(String memAtmos, String memgenre,
			int genreaccept){
		List<songVO> ko = songdao.showsongall();
		List<songVO> remove = new ArrayList<songVO>();
		for(songVO vo : ko) {//모든 노래에 대해 느낌별/장르별 거리 체크
			//System.out.println("BIZ : "+vo.getGenre());
			vo.setDisAtmos(String.valueOf(
					seeAtmosdetail(DisAtmoscal(
							memAtmos, vo.getAtmos()))));
			vo.setDisgenre(String.valueOf(
					Math.sqrt(seegenredetail(
							Disgenrecal(memgenre, vo.getGenre())))));
			System.out.println(vo.getURLLINK()+" : "+(vo.getDisAtmos()+vo.getDisgenre()));
			/*if(Double.parseDouble(vo.getDisgenre())>Math.pow(genreaccept, 2)*1.0) {
				//허용수치 이상의 장르차이가 있는 노래일 경우
				remove.add(vo);//삭제명단에 등재된다.
			}*/
		}
		/*for(songVO vo : remove) {//NONO song
			ko.remove(vo);//듣지않습니다. 넘기지도 않습니다.
		}*/
		//살아남은 자들은
		Collections.sort(ko, new Mybizlogic());//배틀로얄 시작
		System.out.println("after sorting");
		for(songVO vo : ko) {
			System.out.println(vo.getURLLINK()+" : "+(vo.getDisAtmos()+vo.getDisgenre()));
		}
		return ko;
	}

}
