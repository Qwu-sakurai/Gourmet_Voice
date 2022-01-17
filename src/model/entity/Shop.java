package model.entity;

import java.io.Serializable;

public class Shop implements Serializable{

	private int id;
	private String shop_name;
	private String shop_map;
	private String shop_num;
	private String aveprice;
	private String shop_text;
	private String avereview;
	private int review_sum;

	public int getReview_sum() {
		return review_sum;
	}

	public void setReview_sum(int review_sum) {
		this.review_sum = review_sum;
	}

	public String getAvereview() {
		return avereview;
	}

	public void setAvereview(String avereview) {
		this.avereview = avereview;
	}

	public Shop() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShop_name() {
		return shop_name;
	}

	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}

	public String getShop_map() {
		return shop_map;
	}

	public void setShop_map(String shop_map) {
		this.shop_map = shop_map;
	}

	public String getShop_num() {
		return shop_num;
	}

	public void setShop_num(String shop_num) {
		this.shop_num = shop_num;
	}

	public String getAveprice() {
		return aveprice;
	}

	public void setAveprice(String aveprice) {
		this.aveprice = aveprice;
	}

	public String getShop_text() {
		return shop_text;
	}

	public void setShop_text(String shop_text) {
		this.shop_text = shop_text;
	}

}
