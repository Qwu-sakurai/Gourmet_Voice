package model.entity;

import java.io.Serializable;

public class ReviewBean implements Serializable{

	private int id;
	private int review_num;
	private int shop_id;
	private String review_name;
	private int review_point;
	private String review_text;
	private String review_day;

	public ReviewBean() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getReview_num() {
		return review_num;
	}

	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}

	public int getShop_id() {
		return shop_id;
	}

	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}

	public String getReview_name() {
		return review_name;
	}

	public void setReview_name(String review_name) {
		this.review_name = review_name;
	}

	public int getReview_point() {
		return review_point;
	}

	public void setReview_point(int review_point) {
		this.review_point = review_point;
	}

	public String getReview_text() {
		return review_text;
	}

	public void setReview_text(String review_text) {
		this.review_text = review_text;
	}

	public String getReview_day() {
		return review_day;
	}

	public void setReview_day(String review_day) {
		this.review_day = review_day;
	}

	public ReviewBean(int review_num,int shop_id, String review_name, int review_point, String review_text, String review_day) {
		super();
		this.review_num = review_num;
		this.shop_id = shop_id;
		this.review_name = review_name;
		this.review_point = review_point;
		this.review_text = review_text;
		this.review_day = review_day;
	}


}
