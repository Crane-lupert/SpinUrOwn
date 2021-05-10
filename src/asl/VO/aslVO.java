package asl.VO;

public class aslVO {
	private String URLLINK;
	private String Nickname;
	private String genre;
	private String Atmos;
	public aslVO() {
		super();
	}
	public aslVO(String uRLLINK, String nickname, String genre, String atmos) {
		super();
		URLLINK = uRLLINK;
		Nickname = nickname;
		this.genre = genre;
		Atmos = atmos;
	}
	public String getURLLINK() {
		return URLLINK;
	}
	public void setURLLINK(String uRLLINK) {
		URLLINK = uRLLINK;
	}
	public String getNickname() {
		return Nickname;
	}
	public void setNickname(String nickname) {
		Nickname = nickname;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAtmos() {
		return Atmos;
	}
	public void setAtmos(String atmos) {
		Atmos = atmos;
	}
	@Override
	public String toString() {
		return "aslVO [URLLINK=" + URLLINK + ", Nickname=" + Nickname + ", genre=" + genre + ", Atmos=" + Atmos + "]";
	}
}
