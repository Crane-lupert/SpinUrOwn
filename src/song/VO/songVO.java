package song.VO;

public class songVO {
	private String URLLINK;
	private String genre;
	private String Atmos;
	private int RecTime;
	private String DisAtmos;
	private String Disgenre;
	private int rowrow;
	public songVO() {
		super();
	}
	public songVO(String uRLLINK, String genre, String atmos, int recTime) {
		super();
		URLLINK = uRLLINK;
		this.genre = genre;
		Atmos = atmos;
		RecTime = recTime;
	}
	public String getURLLINK() {
		return URLLINK;
	}
	public void setURLLINK(String uRLLINK) {
		URLLINK = uRLLINK;
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
	public int getRecTime() {
		return RecTime;
	}
	public void setRecTime(int i) {
		RecTime = i;
	}
	public String getDisAtmos() {
		return DisAtmos;
	}
	public void setDisAtmos(String disAtmos) {
		DisAtmos = disAtmos;
	}
	public String getDisgenre() {
		return Disgenre;
	}
	public void setDisgenre(String disgenre) {
		Disgenre = disgenre;
	}
	public int getRowrow() {
		return rowrow;
	}
	public void setRowrow(int rowrow) {
		this.rowrow = rowrow;
	}
	
}
