package spmem.VO;

public class nlpcom {
	private String video_id;
	private String content_text;
	public nlpcom(String video_id, String content_text) {
		super();
		this.video_id = video_id;
		this.content_text = content_text;
	}
	public String getVideo_id() {
		return video_id;
	}
	public void setVideo_id(String video_id) {
		this.video_id = video_id;
	}
	public String getContent_text() {
		return content_text;
	}
	public void setContent_text(String content_text) {
		this.content_text = content_text;
	}
}
