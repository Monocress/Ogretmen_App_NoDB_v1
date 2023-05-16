package com.dorukt.entities;

public enum EHosgeldinYeni {
	MESAJ1("Merhaba! Kayıt işlemleri için seni burada görmek gerçekten harika, hoş geldin!"),
	MESAJ2("Hey! Kayıt işlemleri konusunda uzman bir öğretmenin burada olması gerçekten büyük bir şans, aramıza hoş geldin!"),
	MESAJ3("Selam! Yeni öğrencilerimizin kayıt işlemlerini senin gibi deneyimli bir öğretmenin yapacak olması gerçekten harika, hoş geldin!"),
	MESAJ4("Hoş geldin! Kayıt işlemleri konusunda senin kadar uzman bir öğretmenin burada olması gerçekten mutluluk verici, aramıza hoş geldin!"),
	MESAJ5("Merhaba! Yeni öğrencilerimizin kayıt işlemlerini senin gibi profesyonel bir öğretmenin yapması gerçekten harika, hoş geldin!");

	private String mesaj;

	private EHosgeldinYeni(String mesaj) {
		this.mesaj = mesaj;
	}

	public String getMesaj() {
		return mesaj;
	}

}
