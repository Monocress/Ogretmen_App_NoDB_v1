package com.dorukt.entities;

public enum EHoscakal {
	MESAJ1("Güle güle %s, umarız tekrar görüşürüz."), MESAJ2("Seninle çalışmak harikaydı %s, hoşçakal!"),
	MESAJ3("Hoşçakal %s, bizimle geçirdiğin zaman için teşekkür ederiz ve başarılar dileriz."),
	MESAJ4("Bugün seni uğurlamanın üzüntüsünü yaşıyoruz %s, başka zaman görüşmek üzere hoşça kal."),
	MESAJ5("Seni yarın tekrar görmeyi dört gözle bekliyoruz %s, bugün bizimle olduğun için teşekkür ederiz."),
	MESAJ6("Bugün seni uğurlamanın üzüntüsünü yaşıyoruz ama yarın tekrar görüşeceğiz %s, hoşça kal."),
	MESAJ7("İşini başarıyla tamamladığın ve programı bitirdiğin için teşekkür ederiz %s, yarın tekrar görüşmek üzere hoşça kal."),
	MESAJ8("Bugünkü katkın ve işin için teşekkür ederiz %s, yarın yine uygulamamızda olmanı dört gözle bekliyoruz, hoşça kal."),
	MESAJ9("Bugün bize verdiğin her şey için teşekkür ederiz %s, yarın tekrar görüşmek üzere hoşça kal."),
	MESAJ10("İşini bugün tamamlayarak harika bir iş çıkardın %s, yarın tekrar görüşmek dileğiyle hoşça kal.");

	private String mesaj;

	private EHoscakal(String mesaj) {
		this.mesaj = mesaj;
	}

	public String getMesaj() {
		return mesaj;
	}
}
