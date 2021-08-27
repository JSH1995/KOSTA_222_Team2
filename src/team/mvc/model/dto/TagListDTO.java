package team.mvc.model.dto;

public class TagListDTO {
	private int tagNo;
	private String tagName;

	public TagListDTO() {

	}

	public TagListDTO(int tagNo, String tagName) {
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
