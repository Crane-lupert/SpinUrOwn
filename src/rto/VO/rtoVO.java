package rto.VO;

public class rtoVO {
	private String SendNick;
	private String RecNick;
	private String URLLINK;
	private String RecTime;
	public rtoVO() {
		super();
	}
	public rtoVO(String sendNick, String recNick, String uRLLINK, String recTime) {
		super();
		SendNick = sendNick;
		RecNick = recNick;
		URLLINK = uRLLINK;
		RecTime = recTime;
	}
	public String getSendNick() {
		return SendNick;
	}
	public void setSendNick(String sendNick) {
		SendNick = sendNick;
	}
	public String getRecNick() {
		return RecNick;
	}
	public void setRecNick(String recNick) {
		RecNick = recNick;
	}
	public String getURLLINK() {
		return URLLINK;
	}
	public void setURLLINK(String uRLLINK) {
		URLLINK = uRLLINK;
	}
	public String getRecTime() {
		return RecTime;
	}
	public void setRecTime(String recTime) {
		RecTime = recTime;
	}
	
}
