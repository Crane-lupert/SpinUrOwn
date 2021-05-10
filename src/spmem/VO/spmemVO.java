package spmem.VO;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
public class spmemVO {
	private String Nickname;
	private String Email;
	private String ID;
	private String Password;
	private int Point;
	private String Prefergenre;
	private String PreferAtmos;
	private String PreferAtmos2;
	private String PreferAtmos3;
	
	public spmemVO() {
		super();
	}
	
	public spmemVO(String nickname, String email, String iD, String password) {
		super();
		Nickname = nickname;
		Email = email;
		ID = iD;
		Password = password;
	}

	public String getNickname() {
		return Nickname;
	}

	public void setNickname(String nickname) {
		Nickname = nickname;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public int getPoint() {
		return Point;
	}

	public void setPoint(int point) {
		Point = point;
	}

	public String getPrefergenre() {
		return Prefergenre;
	}

	public void setPrefergenre(String prefergenre) {
		Prefergenre = prefergenre;
	}

	public String getPreferAtmos() {
		return PreferAtmos;
	}

	public void setPreferAtmos(String preferAtmos) {
		PreferAtmos = preferAtmos;
	}

	public String getPreferAtmos2() {
		return PreferAtmos2;
	}

	public void setPreferAtmos2(String preferAtmos2) {
		PreferAtmos2 = preferAtmos2;
	}

	public String getPreferAtmos3() {
		return PreferAtmos3;
	}

	public void setPreferAtmos3(String preferAtmos3) {
		PreferAtmos3 = preferAtmos3;
	}
}
