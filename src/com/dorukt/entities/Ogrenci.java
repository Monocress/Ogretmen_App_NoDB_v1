package com.dorukt.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Ogrenci implements Serializable {

	private static final long serialVersionUID = 1L;
	private String adSoyad;
	private String sehir;
	private Map<LocalDate, EDevamsizlik> devamDurumu;
	private List<Sinav> ogrenciSinav;

	public String getAdSoyad() {
		return adSoyad;
	}

	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}

	public String getSehir() {
		return sehir;
	}

	public void setSehir(String sehir) {
		this.sehir = sehir;
	}

	public Map<LocalDate, EDevamsizlik> getDevamDurumu() {
		return devamDurumu;
	}

	public void setDevamDurumu(Map<LocalDate, EDevamsizlik> devamDurumu) {
		this.devamDurumu = devamDurumu;
	}

	public List<Sinav> getOgrenciSinav() {
		return ogrenciSinav;
	}

	public void setOgrenciSinav(List<Sinav> ogrenciSinav) {
		this.ogrenciSinav = ogrenciSinav;
	}

	public Ogrenci(String adSoyad, String sehir) {
		super();
		this.adSoyad = adSoyad;
		this.sehir = sehir;
		devamDurumu = new TreeMap<>();
		ogrenciSinav = new LinkedList<>();
	}

}
