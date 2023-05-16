package com.dorukt.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ogretmen implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String surname;
	private String password;
	private List<Sinif> siniflar;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Ogretmen(String name, String surname, String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.password = password;
		siniflar = new ArrayList<>();
	}

	public List<Sinif> getSiniflar() {
		return siniflar;
	}

}
