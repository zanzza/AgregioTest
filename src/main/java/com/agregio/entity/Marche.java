package com.agregio.entity;

public enum Marche {
	PRIMAIRE,
	SECONDAIRE,
	RAPIDE;
	public static Marche getValue(String marche) {
		return valueOf(marche);
	}
}
