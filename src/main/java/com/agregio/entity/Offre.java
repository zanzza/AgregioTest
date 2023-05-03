package com.agregio.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Offre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Blocs blocs;
	
	private Reserve reserve;
	
	private Type type;
	
	private String fournisseur;
	
	private int megawat;

	public Blocs getBlocs() {
		return blocs;
	}

	public void setBlocs(Blocs blocs) {
		this.blocs = blocs;
	}

	public Reserve getReserve() {
		return reserve;
	}

	public void setReserve(Reserve reserve) {
		this.reserve = reserve;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}

	public int getMegawat() {
		return megawat;
	}

	public void setMegawat(int megawat) {
		this.megawat = megawat;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Offre() {
		super();
	}

	public Offre(long id, Blocs blocs, Reserve reserve, Type type, String fournisseur, int megawat) {
		super();
		this.id = id;
		this.blocs = blocs;
		this.reserve = reserve;
		this.type = type;
		this.fournisseur = fournisseur;
		this.megawat = megawat;
	}

	@Override
	public int hashCode() {
		return Objects.hash(blocs, fournisseur, id, megawat, reserve, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Offre other = (Offre) obj;
		return blocs == other.blocs && Objects.equals(fournisseur, other.fournisseur) && id == other.id
				&& megawat == other.megawat && reserve == other.reserve && type == other.type;
	}

	@Override
	public String toString() {
		return "Offre [id=" + id + ", blocs=" + blocs + ", reserve=" + reserve + ", type=" + type + ", fournisseur="
				+ fournisseur + ", megawat=" + megawat + "]";
	}
	
	

}
