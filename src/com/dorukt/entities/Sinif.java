package com.dorukt.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sinif implements Serializable {


	private static final long serialVersionUID = 1L;
	private String sinifAdi;
	private List<Ogrenci> ogrenciListesi;

	public Sinif(String sinifAdi) {
		super();
		this.sinifAdi = sinifAdi;
		ogrenciListesi = new ArrayList<>();
	}

	public String getSinifAdi() {
		return sinifAdi;
	}

	public void setSinifAdi(String sinifAdi) {
		this.sinifAdi = sinifAdi;
	}

	public List<Ogrenci> getOgrenciListesi() {
		return ogrenciListesi;
	}

}
