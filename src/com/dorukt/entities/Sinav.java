package com.dorukt.entities;

import java.io.Serializable;

public class Sinav implements Serializable {

	private static final long serialVersionUID = 1L;
	private String sinavAdi;
	private Integer sinavNotu;

	public Sinav(String sinavAdi) {
		super();
		this.sinavAdi = sinavAdi;
		this.sinavNotu = null;
	}

	public String getSinavAdi() {
		return sinavAdi;
	}

	public void setSinavAdi(String sinavAdi) {
		this.sinavAdi = sinavAdi;
	}

	public Integer getSinavNotu() {
		return sinavNotu;
	}

	public void setSinavNotu(Integer sinavNotu) {
		this.sinavNotu = sinavNotu;
	}

}
