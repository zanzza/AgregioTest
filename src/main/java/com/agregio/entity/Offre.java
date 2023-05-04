package com.agregio.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Offre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	
	private Set<Blocs> bloc;
	
	private Marche marche;

	private int prix;

	@OneToMany
	private List<Parc> parcs = new ArrayList<>();

	public List<Parc> getParcs() {
		return parcs;
	}

	public void setParcs(List<Parc> parcs) {
		this.parcs = parcs;
	}

	public int getPrix() {
		return prix;
	}

	public Offre() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Blocs> getBloc() {
		return bloc;
	}

	public void setBloc(Set<Blocs> bloc) {
		this.bloc = bloc;
	}

	public Marche getMarche() {
		return marche;
	}

	public void setMarche(Marche marche) {
		this.marche = marche;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}
}
