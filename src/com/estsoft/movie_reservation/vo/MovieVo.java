package com.estsoft.movie_reservation.vo;

public class MovieVo {
	
	private long no;
	private String title;
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "MovieVo [no=" + no + ", title=" + title + "]";
	}
	
	
}
