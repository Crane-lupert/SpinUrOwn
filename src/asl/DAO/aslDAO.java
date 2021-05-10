package asl.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import asl.VO.aslVO;
import rto.VO.rtoVO;
import song.VO.songVO;

@Repository("aslDAO")
public class aslDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SimpleJdbcCall simpleJdbcCall;
	
	public SimpleJdbcCall createSimpleJdbcCall() {
		return new SimpleJdbcCall(this.jdbcTemplate);
	}
	
	public List<aslVO> showaslall(){
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("SHOWASL");
		Map<String, Object> out = call.execute();
		System.out.println(out);
		List<Map<String, String>> all = (List<Map<String, String>>) out.get("VO_RES");
		List<aslVO> tall = new ArrayList<aslVO>();
		for(Map<String, String> mall : all) {
			aslVO vo = new aslVO();
			vo.setURLLINK(mall.get("URLLINK"));
			vo.setNickname(mall.get("Nickname"));
			vo.setGenre(mall.get("genre"));
			vo.setAtmos(mall.get("Atmos"));
			tall.add(vo);
		}
		return tall;
	}
	
	public boolean insertasl(String URLLINK, String Nick, String genre, String Atmos) {
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("ADDASL");
		SqlParameterSource in = new MapSqlParameterSource()
                .addValue("NICKNAME_R", Nick)
                .addValue("URLLINK_R", URLLINK)
                .addValue("GENRE_R", genre)
                .addValue("ATMOS_R", Atmos);
		try {
			Map out = call.execute(in);
			if(out!=null) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean pointforaslreg(String Nick) {
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("POINTFORASL");
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("NICK_R", Nick);
		Map out = call.execute(in);
		if(out!=null) {
			return true;
		}else{
			return false;
		}
	}
	
	public List<aslVO> aslURLgather(String URLLINK){
		SimpleJdbcCall call = createSimpleJdbcCall();
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("URLLINK_R", URLLINK);
		call.withProcedureName("ASLURLGATHER");
		
		Map<String, Object> out = call.execute(in);
		System.out.println(out);
		List<Map<String, String>> all = (List<Map<String, String>>) out.get("VO_RES");
		List<aslVO> tall = new ArrayList<aslVO>();
		for(Map<String, String> mall : all) {
			aslVO vo = new aslVO();
			vo.setURLLINK(mall.get("URLLINK"));
			vo.setGenre(mall.get("genre"));
			vo.setAtmos(mall.get("Atmos"));
			System.out.println(mall.get("URLLINK"));
			System.out.println(vo);
			tall.add(vo);
		}
		return tall;
	}
	
	public boolean songavgupdate(String URLLINK, String genre, String Atmos) {
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("SONGAVGUPDATE");
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("URLLINK_R", URLLINK)
				.addValue("GENRE_R", genre)
				.addValue("ATMOS_R", Atmos);
		Map out = call.execute(in);
		if(out!=null) {
			return true;
		}else{
			return false;
		}
	}
	
	public boolean addSong(String URLLINK, String genre, String Atmos) {
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("ADDSONG");
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("URLLINK_R", URLLINK)
				.addValue("GENRE_R", genre)
				.addValue("ATMOS_R", Atmos);
		Map out = call.execute(in);
		if(out!=null) {
			return true;
		}else{
			return false;
		}
	}
	
	public List<songVO> showSongforASL(String URLLINK){
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("SHOWSONGFORASL");
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("URLLINK_R", URLLINK);
		Map<String, Object> out = call.execute(in);
		List<Map<String, String>> all = (List<Map<String, String>>) out.get("VO_RES");
		List<songVO> tall = new ArrayList<songVO>();
		for(Map<String, String> mall : all) {
			songVO vo = new songVO();
			vo.setURLLINK(mall.get("URLLINK"));
			tall.add(vo);
		}
		return tall;
	}
}
