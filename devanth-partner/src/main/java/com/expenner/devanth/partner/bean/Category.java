package com.expenner.devanth.partner.bean;

import java.util.List;

public class Category {
	private String name;// name of the Category like Veg, Non Veg, Ice Creams
	private int code;// unique code for Category
	private List<Item> items;
	private int position;// position of category on list

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}
