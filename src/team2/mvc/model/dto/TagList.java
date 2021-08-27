package team2.mvc.model.dto;

public class TagList {
	private int tagNo;
	private String tagName;

	public TagList() {

	}

	public TagList(int tagNo, String tagName) {
		super();
		this.tagNo = tagNo;
		this.tagName = tagName;
	}

	public int getTagNo() {
		return tagNo;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagNo(int tagNo) {
		this.tagNo = tagNo;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TagListDTO [tagNo=");
		builder.append(tagNo);
		builder.append(", tagName=");
		builder.append(tagName);
		builder.append("]");
		return builder.toString();
	}

}
