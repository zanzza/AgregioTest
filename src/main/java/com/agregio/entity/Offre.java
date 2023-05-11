package com.agregio.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Offre offre = (Offre) o;
		return prix == offre.prix && Objects.equals(id, offre.id) && Objects.equals(name, offre.name) && Objects.equals(bloc, offre.bloc) && marche == offre.marche && Objects.equals(parcs, offre.parcs);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, bloc, marche, prix, parcs);
	}

	@Override
	public String toString() {
		return "Offre{" +
				"id=" + id +
				", name='" + name + '\'' +
				", bloc=" + bloc +
				", marche=" + marche +
				", prix=" + prix +
				", parcs=" + parcs +
				'}';
	}
}
