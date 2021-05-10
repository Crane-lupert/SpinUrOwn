package ll.VO;

public class llVO {
	private String Nickname;
	private String URLLINK;
	private String LisTime;
	private String DisAtmos;
	private String Disgenre;
	private int IsSatisfied;
	public llVO(String nickname, String uRLLINK, String disAtmos) {
		super();
		Nickname = nickname;
		URLLINK = uRLLINK;
		DisAtmos = disAtmos;
	}
	public llVO() {
		super();
	}
	public String getNickname() {
		return Nickname;
	}
	public void setNickname(String nickname) {
		Nickname = nickname;
	}
	public String getURLLINK() {
		return URLLINK;
	}
	public void setURLLINK(String uRLLINK) {
		URLLINK = uRLLINK;
	}
	public String getLisTime() {
		return LisTime;
	}
	public void setLisTime(String lisTime) {
		LisTime = lisTime;
	}
	public String getDisAtmos() {
		return DisAtmos;
	}
	public void setDisAtmos(String disAtmos) {
		DisAtmos = disAtmos;
	}
	public int getIsSatisfied() {
		return IsSatisfied;
	}
	public void setIsSatisfied(int isSatisfied) {
		IsSatisfied = isSatisfied;
	}
	public String getDisgenre() {
		return Disgenre;
	}
	public void setDisgenre(String disgenre) {
		Disgenre = disgenre;
	}
	
}
