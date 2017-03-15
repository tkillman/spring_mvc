package spring.service;

public class NewArticleCommand {
	
	// NewArticleComand command 의 프로퍼티 값과 같음
	private String title;
	private String content;
	private int parentId;
	//parameter값은 String이기 때문에 int 값은 타입 변환이 가능할 때만 바꿔서 집어넣어준다. 
	//자동화 끝내주네.
	// 타입 변환이 안될 때는 400 에러가 발생한다. type-mismatch
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return "NewArticleCommand [content=" + content + ", parentId=" + parentId + ", title=" + title + "]";
	}
}
