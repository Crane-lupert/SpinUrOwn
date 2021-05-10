package spmem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.DependsOn;

import spmem.VO.*;

//이전에 있던 user-mapper를 없애주는 개념

public interface Mymapper {
	//로그인용
	@Select("select * from Spmem where ID=#{ID} and Password=#{Password}")
	public spmemVO selectspmem();
	
	//닉네임 중복체크용
	@Select("select Nickname from Spmem where Nickname=#{nickname}")
	public boolean checkNick();
	
	//닉네임 중복체크용
	@Select("select ID from Spmem where ID=#{ID}")
	public boolean checkID();
	
	//계정생성용
	@Insert("insert into Spmem(Nickname,Email,ID,Password)"+ 
			" values(#{Nickname},#{Email},#{ID},#{Password})")
	public int insertspmem(spmemVO vo);

	//접속성공
	@Select("select * from Spmem where ID=#{ID}")
	public spmemVO searchspmem(String ID);
}