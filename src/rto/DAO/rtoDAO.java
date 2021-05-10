package rto.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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
import spmem.VO.spmemVO;

@Repository("rtoDAO")
public class rtoDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SimpleJdbcCall simpleJdbcCall;
	
	public SimpleJdbcCall createSimpleJdbcCall() {
		return new SimpleJdbcCall(this.jdbcTemplate);
	}
	
	public boolean insertRTO(String SNick, String RNick, String URLLINK) {
		System.out.println("등록다오");
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("UPRECTOOTHER");
		SqlParameterSource in = new MapSqlParameterSource()
                .addValue("SENDNICK_R", SNick)
                .addValue("URLLINK_R", URLLINK)
                .addValue("RECNICK_R", RNick);
		Map out = call.execute(in);
		System.out.println("out : "+out);
		if(out!=null) {
			return true;
		}else {
			return false;
		}
	}
	public List<rtoVO> showmyrto(String RNick){
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("SHOWRTO");
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("RECNICK_R", RNick);
		Map<String, Object> out = new HashMap<String, Object>();
		try{
			out = call.execute();
		}catch(ArrayIndexOutOfBoundsException e) {
			List<rtoVO> tall = new ArrayList<rtoVO>();
			tall.add(new rtoVO("there's", "nobody", "nobody", "to send rec."));
			return tall;
		}
		List<Map<String, String>> all = (List<Map<String, String>>) out.get("VO_RES");
		List<rtoVO> tall = new ArrayList<rtoVO>();
		for(Map<String, String> mall : all) {
			rtoVO vo = new rtoVO();
			vo.setURLLINK(mall.get("URLLINK"));
			vo.setSendNick(mall.get("SendNick"));
			vo.setRecTime(mall.get("RecTime"));
			tall.add(vo);
		}
		return tall;
	}
	
	public List<rtoVO> showrtoall(){
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("SHOWRTOALL");
		Map<String, Object> out = call.execute();
		System.out.println(out);
		List<Map<String, String>> all = (List<Map<String, String>>) out.get("VO_RES");
		List<rtoVO> tall = new ArrayList<rtoVO>();
		for(Map<String, String> mall : all) {
			rtoVO vo = new rtoVO();
			vo.setSendNick(mall.get("SendNick"));
			vo.setRecNick(mall.get("RecNick"));
			vo.setURLLINK(mall.get("URLLINK"));
			vo.setRecTime(mall.get("RecTime"));
			tall.add(vo);
		}
		return tall;
	}
	
	public List<spmemVO> showmemberall(){
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("SHOWMEMBERALL");
		Map<String, Object> out = call.execute();
		System.out.println(out);
		List<Map<String, String>> all = (List<Map<String, String>>) out.get("VO_RES");
		List<spmemVO> tall = new ArrayList<spmemVO>();
		for(Map<String, String> mall : all) {
			spmemVO vo = new spmemVO();
			vo.setNickname(mall.get("Nickname"));
			tall.add(vo);
		}
		return tall;
	}
	public List<songVO> showsongforrto(){
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("SHOWSONGFORRTO");
		Map<String, Object> out = call.execute();
		//System.out.println(out);
		List<Map<String, String>> all = (List<Map<String, String>>) out.get("VO_RES");
		List<songVO> tall = new ArrayList<songVO>();
		for(Map<String, String> mall : all) {
			songVO vo = new songVO();
			vo.setURLLINK(mall.get("URLLINK"));
			tall.add(vo);
		}
		return tall;
	}
	
	public boolean pointforRTO(String Nick) {
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("POINTFORRTO");
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("NICK_R", Nick);
		Map out = call.execute(in);
		if(out!=null) {
			return true;
		}else{
			return false;
		}
	}
}
