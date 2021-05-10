package song.DAO;

import java.math.BigDecimal;
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

import rto.VO.rtoVO;
import song.VO.songVO;
import song.VO.songVO;

@Repository("songDAO")
public class songDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SimpleJdbcCall simpleJdbcCall;
	
	public SimpleJdbcCall createSimpleJdbcCall() {
		return new SimpleJdbcCall(this.jdbcTemplate);
	}
	
	public List<songVO> showsongall(){
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("SHOWSONGALL");
		Map<String, Object> out = call.execute();
		List<Map<String, String>> all = (List<Map<String, String>>) out.get("VO_RES");
		List<songVO> tall = new ArrayList<songVO>();
		for(Map<String, String> mall : all) {
			songVO vo = new songVO();
			vo.setURLLINK(mall.get("URLLINK"));
			vo.setGenre(mall.get("SendNick"));
			vo.setAtmos(mall.get("Atmos"));
			vo.setGenre(mall.get("genre"));
			tall.add(vo);
		}
		return tall;
	}
}
