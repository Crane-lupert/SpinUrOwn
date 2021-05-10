package ll.DAO;

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

import ll.VO.llVO;
import rto.VO.rtoVO;

@Repository("llDAO")
public class llDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SimpleJdbcCall simpleJdbcCall;
	
	public SimpleJdbcCall createSimpleJdbcCall() {
		return new SimpleJdbcCall(this.jdbcTemplate);
	}
	
	public List<llVO> showllall(){
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("SHOWLL");
		Map<String, Object> out = call.execute();
		System.out.println(out);
		List<Map<String, String>> all = (List<Map<String, String>>) out.get("VO_RES");
		List<llVO> tall = new ArrayList<llVO>();
		for(Map<String, String> mall : all) {
			llVO vo = new llVO();
			vo.setURLLINK(mall.get("URLLINK"));
			vo.setNickname(mall.get("Nickname"));
			vo.setLisTime(mall.get("LisTime"));
			vo.setDisAtmos(mall.get("DisAtmos"));
			vo.setIsSatisfied(Integer.parseInt(mall.get("IsSatisfied")));
			tall.add(vo);
		}
		return tall;
	}
	
	public boolean insertll(String URLLINK, String Nick, String DisAtmos, String Disgenre) {
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("ADDLISLOG");
		SqlParameterSource in = new MapSqlParameterSource()
                .addValue("NICKNAME_R", Nick)
                .addValue("URLLINK_R", URLLINK)
                .addValue("DISATMOS_R", DisAtmos)
                .addValue("DISGENRE_R", Disgenre);
		Map out = call.execute(in);
		if(out!=null) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean updatell(String Nick, String URLLINK, String LisTime, String IsSatisfied) {
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("UPLISLOG");
		SqlParameterSource in = new MapSqlParameterSource()
                .addValue("NICKNAME_R", Nick)
                .addValue("URLLINK_R", URLLINK)
                .addValue("LISTIME_R", LisTime)
                .addValue("ISSATISFIED_R", IsSatisfied);
		Map out = call.execute(in);
		if(out!=null) {
			return true;
		}else {
			return false;
		}
	}
}
