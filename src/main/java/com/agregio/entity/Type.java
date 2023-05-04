package com.agregio.entity;

public enum Type {
	SOLAIRE,
	EOLIEN,
	HYDROLIQUE;

	public static Type getValue(String type) {
		return Type.valueOf(type.toUpperCase());

	}
}

