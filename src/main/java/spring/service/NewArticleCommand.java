package spring.service;

public class NewArticleCommand {
	// NewArticleComand command 의 프로퍼티 값과 같음
	private String title;
	private String content;
	private int parentId;

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
