package spmem.DAO;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import spmem.VO.*;;

//1.SqlSessionFactory로 환경설정[db연동,sql]대입받는다.
//2.SqlSessionFactory.openSession()으로 SqlSession의 crud 메소드를 호출하여
// 	매퍼의 Id를 찾아 리턴한다.
@Repository("spmemdao")
public class spmemDao{
	
	@Autowired//자동연결, 생성자나 setget을 전부 받아옴
	//@Qualifier("spmemDao")
	private SqlSessionFactory factory;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SimpleJdbcCall simpleJdbcCall;
	
	public SimpleJdbcCall createSimpleJdbcCall() {
		return new SimpleJdbcCall(this.jdbcTemplate);
	}
	
	//계정생성
	public Boolean insert(spmemVO vo) {
		SqlSession session=factory.openSession();
		boolean fw = false;
		String result=null;
		try {
			int n = session.insert("spmem.mapper.Mymapper.insertspmem", vo);
			//패키지 밑에 Mapper class-method이름 루트 그대로 가져온다.
			if(n>0) {
				System.out.println("createaccount");
				session.commit();
				fw = true;
			}else {
				System.out.println("accfail");
				session.rollback();
				fw = false;
			}
		}catch(Exception e) {
			session.rollback();
			fw = false;
		}finally {
			session.close();
		}
		return fw;
	}
	
	//로그인용
	public spmemVO select(String ID, String Password){
		SqlSession session=factory.openSession();
		spmemVO list=null;
		spmemVO vo = new spmemVO();
		vo.setID(ID);
		vo.setPassword(Password);
		try {
			list = session.selectOne("spmem.mapper.Mymapper.selectspmem",vo);
		}catch(Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
	
	//Nickname 체크
	public boolean checkNick(String Nick){
		SqlSession session=factory.openSession();
		spmemVO list=null;
		spmemVO vo = new spmemVO();
		vo.setNickname(Nick);
		try {
			list = session.selectOne("spmem.mapper.Mymapper.checkNick", vo);
			if(list!=null) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return false;
	}	
	
	//ID 중복 체크
	public boolean checkID(String ID){
		SqlSession session=factory.openSession();
		spmemVO list=null;
		spmemVO vo = new spmemVO();
		vo.setID(ID);
		try {
			list = session.selectOne("spmem.mapper.Mymapper.checkID", vo);
			if(list!=null) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return false;
	}	
	
	public spmemVO searchspmem(String vo) {//id값을 받아
		SqlSession session=factory.openSession();
		spmemVO vo1=null;
		try {
			vo1 = session.selectOne("spmem.mapper.Mymapper.searchspmem", vo);
			//객체로 리턴한다.
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return vo1;
	}

	public boolean deletespmem(String Nick, String Password) {
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("DELSPMEM");
		SqlParameterSource in = new MapSqlParameterSource()
                .addValue("NICK_R", Nick)
                .addValue("PASSWORD_R", Password);
		Map out = call.execute(in);
		if(out!=null) {
			return true;
		}else {
			return false;
		}
	}

	public String selectgenre(String Nick) {
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("SHOWGEN");
		SqlParameterSource in = new MapSqlParameterSource()
                .addValue("NICK_R", Nick);
		Map out = call.execute(in);
		return (String)out.get("PREFERGENRE_R");
	}
	
	public spmemVO updategenre(String Nick, String Prefergenre) {
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("UPGEN");
		SqlParameterSource in = new MapSqlParameterSource()
                .addValue("NICK_R", Nick)
                .addValue("PREFERGENRE_R", Prefergenre);
		Map out = call.execute(in);
		spmemVO vo = new spmemVO();
		vo.setNickname(Nick);
		vo.setPrefergenre(Prefergenre);
		return vo;
	}

	public String selectAtmos(String Nick) {
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("SHOWATMOS");
		SqlParameterSource in = new MapSqlParameterSource()
                .addValue("NICK_R", Nick);
		Map out = call.execute(in);
		return (String)out.get("PREFERATMOS_R");
	}

	public spmemVO updateAtmos(String Nick, String PreferAtmos) {
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("UPATMOS");
		SqlParameterSource in = new MapSqlParameterSource()
                .addValue("NICK_R", Nick)
                .addValue("PREFERATMOS_R", PreferAtmos);
		Map out = call.execute(in);
		spmemVO vo = new spmemVO();
		vo.setNickname(Nick);
		vo.setPreferAtmos(PreferAtmos);
		return vo;
	}
	
	public String selectAtmos2(String Nick) {
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("SHOWATMOS2");
		SqlParameterSource in = new MapSqlParameterSource()
                .addValue("NICK_R", Nick);
		Map out = call.execute(in);
		return (String)out.get("PREFERATMOS2_R");
	}
	
	public spmemVO updateAtmos2(String Nick, String PreferAtmos) {
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("UPATMOS2");
		SqlParameterSource in = new MapSqlParameterSource()
                .addValue("NICK_R", Nick)
                .addValue("PREFERATMOS2_R", PreferAtmos);
		Map out = call.execute(in);
		spmemVO vo = new spmemVO();
		vo.setNickname(Nick);
		vo.setPreferAtmos2(PreferAtmos);
		return vo;
	}
	public String selectAtmos3(String Nick) {
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("SHOWATMOS3");
		SqlParameterSource in = new MapSqlParameterSource()
                .addValue("NICK_R", Nick);
		Map out = call.execute(in);
		return (String)out.get("PREFERATMOS3_R");
	}
	
	public spmemVO updateAtmos3(String Nick, String PreferAtmos) {
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("UPATMOS3");
		SqlParameterSource in = new MapSqlParameterSource()
                .addValue("NICK_R", Nick)
                .addValue("PREFERATMOS3_R", PreferAtmos);
		Map out = call.execute(in);
		spmemVO vo = new spmemVO();
		vo.setNickname(Nick);
		vo.setPreferAtmos3(PreferAtmos);
		return vo;
	}
}
