package bookshop.main;

public class BookVo {
	private Long no;
	private String rent;
	private String title;
	private Long authorNo;
	private String authorName;

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getRent() {
		return rent;
	}

	public void setRent(String rent) {
		this.rent = rent;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getAuthorNo() {
		return authorNo;
	}

	public void setAuthorNo(Long authorNo) {
		this.authorNo = authorNo;
	}

	public void setCategoryNo(int i) {
		// TODO Auto-generated method stub
		
	}

}
