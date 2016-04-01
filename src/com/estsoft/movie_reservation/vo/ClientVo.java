package com.estsoft.movie_reservation.vo;

public class ClientVo {
	
	private Long no;
	private String phone;
	private String title;
	private Long count;
	private Long movieNo;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Long getMovieNo() {
		return movieNo;
	}
	public void setMovieNo(Long movieNo) {
		this.movieNo = movieNo;
	}
	@Override
	public String toString() {
		return "ClientVo [no=" + no + ", phone=" + phone + ", title=" + title
				+ ", count=" + count + ", movieNo=" + movieNo + "]";
	}
	

	
	

	
}
