package com.febryo.model;

public class UserModel {
	private String id;
	private String name;
	private String email;

	public UserModel() {
	}

	public UserModel(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserModel [id=").append(id).append(", name=").append(name).append(", email=").append(email)
				.append("]");
		return builder.toString();
	}

}
