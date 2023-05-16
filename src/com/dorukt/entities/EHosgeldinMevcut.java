package com.dorukt.entities;

public enum EHosgeldinMevcut {
	MESAJ1("Merhaba %s! Öğrencilerimiz seni dört gözle bekliyor, hoş geldin!"),
	MESAJ2("Hey %s! Okulumuzun yeni ve harika öğretmeni, seni aramızda görmek gerçekten harika."),
	MESAJ3("Selam %s! Burada senin gibi deneyimli bir öğretmenin olması gerçekten büyük bir şans, hoş geldin."),
	MESAJ4("Hoş geldin %s! Okulumuza katıldığın için gerçekten mutluyuz, umarız burada harika zaman geçirirsin"),
	MESAJ5("Merhaba %s! Öğrencilerimizin ve diğer öğretmenlerimizin yanı sıra seni de aramızda görmek gerçekten harika, hoş geldin."),
	MESAJ6("Hey %s! Senin gibi vizyon sahibi bir öğretmenin okulumuza katılması gerçekten büyük bir mutluluk, hoş geldin"),
	MESAJ7("Selam %s! Okulumuzun renkli dünyasına hoş geldin, senin burada olman gerçekten büyük bir avantaj."),
	MESAJ8("Hoş geldin %s! Okulumuzun yıldız öğretmenleri arasında seni de görmek gerçekten harika, umarız sen de bizimle mutlu olursun"),
	MESAJ9("Merhaba %s! Senin gibi başarılı bir öğretmenin okulumuza katılması gerçekten harika, aramıza hoş geldin"),
	MESAJ10("Hey %s! Öğrencilerimiz ve diğer öğretmenlerimiz seni dört gözle bekliyordu, sonunda burada olduğuna göre hoş geldin!");

	private String mesaj;

	private EHosgeldinMevcut(String mesaj) {
		this.mesaj = mesaj;
	}

	public String getMesaj() {
		return mesaj;
	}


}
