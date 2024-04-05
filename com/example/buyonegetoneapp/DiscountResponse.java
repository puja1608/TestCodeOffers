package com.example.buyonegetoneapp;
import java.util.List;

public class DiscountResponse {
	 
      private List<Integer> discountedItems;
	    private List<Integer> payableItems;

	public DiscountResponse(List<Integer> discountedItems2, List<Integer> payableItems2) {
		// TODO Auto-generated constructor stub
		this.discountedItems = discountedItems2;
		this.payableItems = payableItems2;
	}

	public DiscountResponse() {
		// TODO Auto-generated constructor stub
	}

	public List<Integer> getDiscountedItems() {
		return discountedItems;
	}

	public void setDiscountedItems(List<Integer> discountedItems) {
		this.discountedItems = discountedItems;
	}

	public List<Integer> getPayableItems() {
		return payableItems;
	}

	public void setPayableItems(List<Integer> payableItems) {
		this.payableItems = payableItems;
	}

}
