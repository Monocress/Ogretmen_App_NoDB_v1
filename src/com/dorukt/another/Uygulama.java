package com.dorukt.another;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;

import com.dorukt.entities.DosyaIslemleri;
import com.dorukt.entities.EDevamsizlik;
import com.dorukt.entities.Ogrenci;
import com.dorukt.entities.Ogretmen;
import com.dorukt.entities.Sinav;
import com.dorukt.entities.Sinif;

public class Uygulama {
	boolean atamalarBittiMi = true;
	boolean ilkKontrolMu = true;
	Sinif sonGuncellenenSinif = null;
	Ogrenci sonGuncellenenOgrenci = null;
	Sinav sonGuncellenenSinav = null;
	int sinavIndex = 0;
	Scanner sc = new Scanner(System.in);

	public void uygulamayiBaslat() {
		Ogretmen ogretmen = loginIslemleri();
		anaMenu(ogretmen);


	}


	public Ogretmen loginIslemleri() {
		Ogretmen ogretmen;
		if (!DosyaIslemleri.dosyaVarMi()) {
			ogretmen = yeniOgretmenOlustur();
			ogretmen.getSiniflar().add(defaultOgreciler());
			System.out.println(
					"Kaydınız oluşturuldu ve Java 9 isimli sınıfınız öğrencileri ile birlikte sisteminize eklendi!");
			DosyaIslemleri.ogretmenDosyasiniOlustur(ogretmen);
		} else {
			ogretmen = DosyaIslemleri.ogretmenDosyasiniOku();
			Menu.mevcutKullaniciHosgeldin(ogretmen.getName());
			boolean girisUygunMu = false;
			int sayac = 0;
			int yanlisGirisler=0;
			System.out.println(
					"Sen olduğunu onaylamamız için şifreni girmene ihtiyacımız var ya da şifreni unuttuysan \"sifremi unuttum\" yazabilirsin.");
			do {
				if (sayac != 0 || yanlisGirisler != 0) {
					System.out.println(
							"Şifreni tekrar girmelisin ya da tekrar \"sifremi unuttum\" kısmını deneyebilirsin.");
				}
				String input = sc.nextLine();
				if (sifremiUnuttumCheck(input)) {
					Menu.sifremiUnuttumMenu(ogretmen, sayac);
					sayac++;
				} else if (input.equals(ogretmen.getPassword())) {
					girisUygunMu = true;
					System.out.println("Giriş başarılı! Tekrar hoşgeldin " + ogretmen.getName() + "!");
				} else {
					Menu.hataliGirisMenu(yanlisGirisler);
					yanlisGirisler++;
				}
			} while (!girisUygunMu);
		}
		if (DosyaIslemleri.autoSaveVarMi()) {
			System.out.println("Bazı değişiklikler yaptığın ve programı beklenildiği gibi kapatmadığını fark ettik");
			System.out.println("Senin için bu değişiklikleri yüklememizi ister misin?(Evet/Hayır)");
			String cevap = sc.nextLine();
			switch (cevap.toLowerCase()) {
			case "evet":
				ogretmen = DosyaIslemleri.autoSaveKullan();
				degisiklikYapiliyorHolder();
				System.out.println("Başlamaya hazırız!");
				break;
			case "hayır", "hayir":

				break;

			default:
				System.out.println("Tamam o zaman ben her şeyi kaydettiğini varsayıyorum.");
				break;
			}
		}
		return ogretmen;
	}

	public void degisiklikYapiliyorHolder() {
		try {
			System.out.print("Hemen değişiklikleri yapıyorum. ");
			Thread.sleep(800);
			System.out.print(". ");
			Thread.sleep(800);
			System.out.println(". ");
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private boolean sifremiUnuttumCheck(String input) {
		return (input.equalsIgnoreCase("sifremi unuttum") || input.equalsIgnoreCase("şifremi unuttum")
				|| input.equalsIgnoreCase("sifremiunuttum") || input.equalsIgnoreCase("şifremiunuttum"));
	}

	public Ogretmen yeniOgretmenOlustur() {
		int sayac=0;
		Ogretmen ogretmen;
		Menu.yeniKullaniciHosgeldin();
		Menu.isimIste();
		String ad = sc.nextLine();
		Menu.soyisimIste();
		String soyad = sc.nextLine();
		Menu.sifreIste();
		String sifre = sc.nextLine();
		boolean tamamMi=true;
		while (tamamMi) {
			Menu.duzeltmeMenu(sayac, ad, soyad, sifre);
				String duzelt = sc.nextLine();
			switch (duzelt.toLowerCase()) {
				case "ad":
					System.out.println("Lütfen yeni adı girin.");
					ad = sc.nextLine();
					sayac++;
					break;
				case "soyad":
					System.out.println("Lütfen yeni soyadı girin.");
					soyad = sc.nextLine();
					sayac++;
					break;
				case "sifre":
					System.out.println("Lütfen yeni şifreyi girin.");
					sifre = sc.nextLine();
					sayac++;
					break;
				case "tamam":
					tamamMi = false;
					System.out.println("Kaydın tamamlandı. Lütfen girdiğin şifreyi unutma!");
					break;
				default:
					System.out.println("Hatalı giriş yaptınız.");
					break;
				}
		}
		ogretmen = new Ogretmen(ad, soyad, sifre);
		return ogretmen;
	}


	public Sinif defaultOgreciler() {
		Sinif java9 = new Sinif("Java 9");
		Ogrenci ogr1 = new Ogrenci("Doruk Tokinan", "Ankara");
		Ogrenci ogr2 = new Ogrenci("Berk Aktaş", "Antalya");
		Ogrenci ogr3 = new Ogrenci("Berk Aktaş", "İstanbul");
		Ogrenci ogr4 = new Ogrenci("Engin Akalın ", "Ankara");
		Ogrenci ogr5 = new Ogrenci("Emre Sefa Özcan", "Antalya");
		Ogrenci ogr6 = new Ogrenci("Atamert Çakır", "Tekirdağ");
		Ogrenci ogr7 = new Ogrenci("Selim Furkan Gülnihal", "İstanbul");
		Ogrenci ogr8 = new Ogrenci("Engin Ertikmen", "Dubai");
		Ogrenci ogr9 = new Ogrenci("Hülya Büşra Martlı", "Ankara");
		Ogrenci ogr10 = new Ogrenci("Levent Tarik Koyuncu", "Ankara");
		Ogrenci ogr11 = new Ogrenci("Alperen Sertoğlu", "Karabük");
		Ogrenci ogr12 = new Ogrenci("Ali Cemal Erzincan", "Ankara");
		Ogrenci ogr13 = new Ogrenci("Murat Can Cürebal", "Ankara");
		Ogrenci ogr14 = new Ogrenci("Recep Efe Aksoy", "İzmir");
		Ogrenci ogr15 = new Ogrenci("Ata Mert Okay", "İstanbul");
		Ogrenci ogr16 = new Ogrenci("Gülsu Fındık", "İstanbul");
		java9.getOgrenciListesi().add(ogr16);
		java9.getOgrenciListesi().add(ogr15);
		java9.getOgrenciListesi().add(ogr14);
		java9.getOgrenciListesi().add(ogr13);
		java9.getOgrenciListesi().add(ogr12);
		java9.getOgrenciListesi().add(ogr11);
		java9.getOgrenciListesi().add(ogr10);
		java9.getOgrenciListesi().add(ogr9);
		java9.getOgrenciListesi().add(ogr8);
		java9.getOgrenciListesi().add(ogr7);
		java9.getOgrenciListesi().add(ogr6);
		java9.getOgrenciListesi().add(ogr5);
		java9.getOgrenciListesi().add(ogr4);
		java9.getOgrenciListesi().add(ogr3);
		java9.getOgrenciListesi().add(ogr2);
		java9.getOgrenciListesi().add(ogr1);

		return java9;
	}

	public void anaMenu(Ogretmen ogretmen) {
		String secim = "";
		Sinif tempSinif = null;
		Ogrenci tempOgrenci = null;
		atamaKontrol2(ogretmen);
		do {
			System.out.println("Tarih: " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			if (!atamalarBittiMi) {
				if (!ilkKontrolMu) {
					atamaKontrol2(ogretmen);
				}

				if (!atamalarBittiMi) {
				System.out.println(sonGuncellenenSinif.getSinifAdi() + " sınıfındaki "
						+ sonGuncellenenOgrenci.getAdSoyad() + "(" + sonGuncellenenOgrenci.getSehir() + ")"
						+ " isimli öğrencinin " + sonGuncellenenSinav.getSinavAdi()
						+ " sınavı için not girişi henüz yapılmamış not vermeye devam etmek için \"devam\" yazabilirsin!");
				}
			}
			Menu.anaMenuStandart();
			secim = sc.nextLine();
			switch (secim.toLowerCase()) {
			case "1":// ogrenci ekle
				tempSinif = sinifSec(ogretmen);
				System.out.println("Öğrencinin adını ve soyadını girebilir misin?");
				String adSoyad = sc.nextLine();
				System.out.println("Öğrencinin yaşadığı şehri girebilir misin?");
				String sehir = sc.nextLine();
				tempSinif.getOgrenciListesi().add(new Ogrenci(adSoyad, sehir));
				if (tempSinif.getOgrenciListesi().size() != 1) {
					for (int i = 0; i < tempSinif.getOgrenciListesi().get(0).getOgrenciSinav().size(); i++) {
						tempSinif.getOgrenciListesi().get(tempSinif.getOgrenciListesi().size() - 1).getOgrenciSinav()
								.add(new Sinav(
										tempSinif.getOgrenciListesi().get(0).getOgrenciSinav().get(i).getSinavAdi()));
					}

				}
				for (Sinav sinav : tempSinif.getOgrenciListesi().get(tempSinif.getOgrenciListesi().size() - 1)
						.getOgrenciSinav()) {
					sinav.setSinavNotu(null);
				}
				DosyaIslemleri.autoSave(ogretmen);
				ilkKontrolMu = false;
				atamalarBittiMi = false;
				break;
			case "2":// ogrenci sil
				tempSinif = sinifSec(ogretmen);
				if (tempSinif.getOgrenciListesi().size() == 0) {
					System.out.println("Güncelleyecek öğrenci henüz yok öğrenci ekleyip tekrar deneyebilirsin.");
				} else {
					tempOgrenci = ogrenciSec(tempSinif);
					System.out.println(tempOgrenci.getAdSoyad()
							+ " isimli öğrenciyi silmek istiyorsan \"evet\", işlemi iptal etmek için lütfen \"back\" yaz");
					String girdi = sc.nextLine();
					if (girdi.equalsIgnoreCase("back")) {
						System.out.println("İşlem iptal edildi.");
					} else if (girdi.equalsIgnoreCase("evet")) {
						tempSinif.getOgrenciListesi().remove(tempOgrenci);
						DosyaIslemleri.autoSave(ogretmen);
					} else {
						System.out.println("Hatalı işlem gerçekleşti işlem iptal edildi.");
					}
				}

				ilkKontrolMu = false;
				atamalarBittiMi = false;

				break;
			case "3":// ogrenci güncelle
				tempSinif = sinifSec(ogretmen);
				if (tempSinif.getOgrenciListesi().size() == 0) {
					System.out.println("Güncelleyecek öğrenci henüz yok öğrenci ekleyip tekrar deneyebilirsin.");
				} else {
					tempOgrenci = ogrenciSec(tempSinif);
					Menu.ogrenciGuncellemeMenu();
					int input = sc.nextInt();
					sc.nextLine();
					switch (input) {
					case 1:
						System.out.println("Öğrencinin yeni adını ve soyadını girin");
						tempOgrenci.setAdSoyad(sc.nextLine());
						DosyaIslemleri.autoSave(ogretmen);
						break;
					case 2:
						System.out.println("Öğrencinin yeni şehrini girin");
						tempOgrenci.setSehir(sc.nextLine());
						DosyaIslemleri.autoSave(ogretmen);
						break;
					case 0:
						System.out.println("Önceki menüye dönülüyor");
						break;

					default:
						System.out.println("Hatalı giriş yaptınız.");
						break;
					}
				}

				break;
			case "4":// ogrenci devamsızlık islemleri
				Menu.devamsizlikIslemleri();
				int input = sc.nextInt();
				switch (input) {
				case 1:
					tempSinif = sinifSec(ogretmen);
					if (tempSinif.getOgrenciListesi().size() != 0) {
					if (tempSinif.getOgrenciListesi().get(0).getDevamDurumu().containsKey(LocalDate.now())) {
						System.out.println("Bugünün yoklamasını zaten aldınız.");
					} else {
						for (Ogrenci ogrenci : tempSinif.getOgrenciListesi()) {
							System.out.println(ogrenci.getAdSoyad() + "bugün derse:");
							System.out.println("1- Geldi.");
							System.out.println("2- Gelmedi.");
							ogrenci.getDevamDurumu().put(LocalDate.now(), EDevamsizlik.values()[sc.nextInt() - 1]);
						}
						DosyaIslemleri.autoSave(ogretmen);
					}
				} else {
					System.out.println("Sınıfta hiç kayıtlı öğrenci yok! Yoklama işini başka bi zamana mı bıraksak?");
				}

					break;
				case 2:
					int yoklama = 0;
					tempSinif = sinifSec(ogretmen);
					if (tempSinif.getOgrenciListesi().size() == 0) {
						System.out
								.println("Sınıfta hiç kayıtlı öğrenci yok! Yoklama işini başka bi zamana mı bıraksak?");
					} else {
						tempOgrenci = ogrenciSec(tempSinif);
						for (Map.Entry<LocalDate, EDevamsizlik> durum : tempOgrenci.getDevamDurumu().entrySet()) {
							if (durum.getValue().equals(EDevamsizlik.GELMEDI))
								yoklama++;
						}
						System.out.println(
								tempOgrenci.getAdSoyad() + " isimli öğrencinin devamsızlık sayısı: " + yoklama);
						yoklama = 0;
					}

					break;
				case 0:
					System.out.println("Önceki menüye dönülüyor");
					break;

				default:
					System.out.println("Hatalı giriş. Önceki menüye dönülüyor.");
					break;
				}

				break;
			case "5":// Sınav notu işlemleri
				tempSinif = sinifSec(ogretmen);
				if (tempSinif.getOgrenciListesi().size() == 0) {
					System.out.println(
							"Bu sınıfta kimseyi bulamıyorum. Sınıftaki öğrenciler saklanma konusunda baya iyiler herhalde.");
				} else {
					Menu.sinavNotuIslemleri();
					int notSecim = sc.nextInt();
					sc.nextLine();
					switch (notSecim) {
					case 1:
						boolean eksikVarMi = false;
						for (Ogrenci ogrenci : tempSinif.getOgrenciListesi()) {
							for (int i = 0; i < ogrenci.getOgrenciSinav().size(); i++) {
								if (ogrenci.getOgrenciSinav().get(i).getSinavNotu() == null) {
									if (!eksikVarMi) {
										System.out.println(
												"Eksik notların tamamlanması gerekiyor. Önce eksik notları tamamlamalısın.");
										System.out.println(ogrenci.getAdSoyad() + " isimli öğrencinin "
												+ ogrenci.getOgrenciSinav().get(i).getSinavAdi()
												+ " sinavi için notunu girin.");
										ogrenci.getOgrenciSinav().get(i).setSinavNotu(sc.nextInt());
										eksikVarMi = true;
									} else {
										System.out.println(ogrenci.getAdSoyad() + " isimli öğrencinin "
												+ ogrenci.getOgrenciSinav().get(i).getSinavAdi()
												+ " sinavi için notunu girin.");
										ogrenci.getOgrenciSinav().get(i).setSinavNotu(sc.nextInt());
									}
								}
							}
						}
						if (!eksikVarMi) {
							System.out.println("Harika bir sınav hazırlamışsın. Peki bu sınavın adı nedir?");
							String sinavAdi = sc.nextLine();
							for (Ogrenci ogrenci : tempSinif.getOgrenciListesi()) {
								ogrenci.getOgrenciSinav().add(new Sinav(sinavAdi));
							}
							for (Ogrenci ogrenci : tempSinif.getOgrenciListesi()) {
								System.out.println(ogrenci.getAdSoyad()
										+ " sinavdan kaç aldı? Daha sonrada devam edebilirsin daha sonra devam etmek için tamam yazabilirsin.");
								String not = sc.nextLine();
								if (not.equalsIgnoreCase("tamam")) {
									atamalarBittiMi = false;
									ilkKontrolMu = false;
									System.out.println("Dinlendiğinde not verme işlemini tamamlamayı unutma!");
									break;
								} else {
									int notValue = Integer.parseInt(not);
									Sinav tempSinav = ogrenci.getOgrenciSinav()
											.get(ogrenci.getOgrenciSinav().size() - 1);
									tempSinav.setSinavNotu(notValue);
									}
							}
						}
						eksikVarMi = false;
						DosyaIslemleri.autoSave(ogretmen);
						break;
					case 2:
						tempOgrenci = ogrenciSec(tempSinif);
						System.out.println(tempOgrenci.getAdSoyad() + " için sinav sonucları:");
						for (Sinav sinav : tempOgrenci.getOgrenciSinav()) {
							System.out.println(sinav.getSinavAdi() + ": " + sinav.getSinavNotu());
						}
						break;
					case 3:
						int sayac = 0;
						tempOgrenci = ogrenciSec(tempSinif);
						System.out.println(tempOgrenci.getAdSoyad() + " için sinav sonucları:");
						for (Sinav sinav : tempOgrenci.getOgrenciSinav()) {
							System.out.println(++sayac + " - " + sinav.getSinavAdi() + ": " + sinav.getSinavNotu());
						}
						sayac = 0;
						System.out.println("Lütfen kac numaralı sınavı istediğiniz girin.");
						input = sc.nextInt() - 1;
						sc.nextLine();
						Sinav tempSinav = tempOgrenci.getOgrenciSinav().get(input);
						System.out.println("Lütfen " + tempSinav.getSinavAdi() + " sınavı için yeni notu girin.");
						tempSinav.setSinavNotu(sc.nextInt());
						sc.nextLine();
						atamalarBittiMi = false;
						ilkKontrolMu = false;
						DosyaIslemleri.autoSave(ogretmen);
						break;
					case 0:
						System.out.println("Ana Menüye dönülüyor...");
						break;
					default:
						System.out.println("Hatalı giriş ana menüye dönülüyor...");
						break;
					}
				}
				break;
			case "6":// Ogrencileri listele
				tempSinif = sinifSec(ogretmen);
				ogrencileriListele(tempSinif, 0);
				break;
			case "7":// siniflari listele
				siniflariListele(ogretmen, 0);
				break;
			case "8":// yeni sinif olustur
				System.out.println(
						"Yeni bir sınıf mı? Bunun için sadece yeni bi isme ihtiyacım var. Sınıfının adı nedir?");
				ogretmen.getSiniflar().add(new Sinif(sc.nextLine()));
				DosyaIslemleri.autoSave(ogretmen);
				break;
			case "9":// siniflari guncelle
				tempSinif = sinifSec(ogretmen);
				Menu.sinifGuncellemeMenu();
				input = sc.nextInt();
				sc.nextLine();
				switch (input) {
				case 1:
					System.out.println("Sınıfın yeni adı ne olsun?");
					tempSinif.setSinifAdi(sc.nextLine());
					System.out.println("Gerçekten harika bir seçim");
					degisiklikYapiliyorHolder();
					DosyaIslemleri.autoSave(ogretmen);
					break;
				case 2:
					System.out.println(
							"Bu işlem " + tempSinif.getSinifAdi()
									+ " sınıfındaki tüm öğrencilerini silecek devam etmek istediğine emin misin?(Evet/Hayır)");
					String onay = sc.nextLine();
					switch (onay.toLowerCase()) {
					case "evet":
						tempSinif.getOgrenciListesi().clear();
						DosyaIslemleri.autoSave(ogretmen);
						System.out.println("Elveda " + tempSinif.getSinifAdi());
						degisiklikYapiliyorHolder();
						break;
					case "hayir", "hayır":
						System.out.println(
								"Bi an bütün sınıfı sileceksin diye çok korktum! Bence en doğru kararı verdin!");
						break;
					default:
						System.out.println(
								"Beklenen dışında bir giriş yaptın. Seni Ana Menüye döndürüp öğrencilerini bu hazin sondan kurtarıyorum.");
						break;
					}
					break;
				case 0:
					System.out.println("Geri dönülüyor...");
					break;

				default:
					System.out.println("Hatalı giriş. Geri dönülüyor.");
					break;
				}
				break;
			case "10":// sinif sil
				tempSinif = sinifSec(ogretmen);
				System.out.println("Bu işlem " + tempSinif.getSinifAdi()
						+ "sınıfını ve içindeki tüm öğrencilerini silecek devam etmek istediğine emin misin?(Evet/Hayır)");
				String onay = sc.nextLine();
				switch (onay.toLowerCase()) {
				case "evet":
					ogretmen.getSiniflar().remove(tempSinif);
					DosyaIslemleri.autoSave(ogretmen);
					System.out.println("Elveda " + tempSinif.getSinifAdi());
					degisiklikYapiliyorHolder();
					break;
				case "hayir", "hayır":
					System.out.println("Bi an bütün sınıfı sileceksin diye çok korktum! Bence en doğru kararı verdin!");
					break;
				default:
					System.out.println(
							"Beklenen dışında bir giriş yaptın. Seni Ana Menüye döndürüp öğrencilerini bu hazin sondan kurtarıyorum.");
					break;
				}
				break;
			case "11":// kaydımı sil
				System.out.println("AMAN TANRIM! BUNU GERÇEKTEN İSTİYOR OLAMAZSIN!");
				bekle(2000);
				System.out.println("ya da istiyor olabilir misin?");
				bekle(1000);
				System.out.println("Sanırım bunu anlamanın bir yolu var.");
				System.out.println("Eğer gerçekten kaydını silmek istiyorsan lütfen adını gir");
				onay=sc.nextLine();
				if(onay.equalsIgnoreCase(ogretmen.getName())) {
					System.out.println("Şimdi de şifreni gir lütfen ama unutma eğer kaydını silersen tüm ilerlemelerin kaybolacak.");
					onay = sc.nextLine();
					if(onay.equals(ogretmen.getPassword())) {
						System.out.println("Tamam sen kazandın.");
						bekle(800);
						System.out.println("Kayıt silme işlemini başlatıyorum. Kendine iyi bak "+ogretmen.getName());
						degisiklikYapiliyorHolder();
						System.out.println("Sistemden çıkışını yapıyorum");
						DosyaIslemleri.autoSaveSil();
						DosyaIslemleri.ogretmenDosyasiniSil();
						degisiklikYapiliyorHolder();
						System.out.println("Tüm bilgilerin sistemden kaldırıldı. " + ogretmen.getName()
								+ ", Umarım seni en yakın zamanda tekrar görebilirim. Kendine iyi bak.");
						System.exit(0);
					} else {
						System.out.println("Biliyordum! Seninde aslında kaydını silmek istemediğini biliyordum!");
						System.out
								.println("O zaman seni ana menüye döndürüyorum ki bu tehlikeli yerden uzaklaşmış ol!");
					}
					
				} else {
					System.out.println("Biliyordum! Seninde aslında kaydını silmek istemediğini biliyordum!");
					System.out.println("O zaman seni ana menüye döndürüyorum ki bu tehlikeli yerden uzaklaşmış ol!");
				}
				

				break;
			case "0":// cikis
				if (DosyaIslemleri.autoSaveVarMi()) {
					System.out.println("Yapmış olduğun değişiklikleri kaydetmek ister misin? Evet/Hayır");

				onay = sc.nextLine();
				if (onay.equalsIgnoreCase("evet")) {
					DosyaIslemleri.ogretmenDosyasiniOlustur(ogretmen);
					DosyaIslemleri.autoSaveSil();
					degisiklikYapiliyorHolder();
					System.out.println("İşlem tamam!");
					bekle(1000);
					Menu.hoscakalMesajlari(ogretmen.getName());
				} else if (onay.equalsIgnoreCase("hayir") || onay.equalsIgnoreCase("hayır")) {
					DosyaIslemleri.autoSaveSil();
					Menu.hoscakalMesajlari(ogretmen.getName());
				} else {
					System.out.println("Ana menüye döndürülüyor");
					secim = "1";
				}
			} else {
				Menu.hoscakalMesajlari(ogretmen.getName());
				}
				break;
			case "devam":
				for (Ogrenci ogrenci : sonGuncellenenSinif.getOgrenciListesi()) {
					if (ogrenci.getOgrenciSinav().get(sinavIndex).getSinavNotu() == null) {
						System.out.println(ogrenci.getAdSoyad() + "(" + ogrenci.getSehir() + ")" + " isimli öğrencinin "
								+ sonGuncellenenSinav.getSinavAdi() + " isimli sınavının notu nedir?");
						ogrenci.getOgrenciSinav().get(sinavIndex).setSinavNotu(sc.nextInt());
						sc.nextLine();
					}
				}
				atamalarBittiMi = true;
				ilkKontrolMu = true;
				for (Sinav sinav : sonGuncellenenOgrenci.getOgrenciSinav()) {
					if (sinav.getSinavNotu() == null) {
						atamalarBittiMi = false;
						ilkKontrolMu = false;
						break;
					}
				}
				DosyaIslemleri.autoSave(ogretmen);
				break;

			default:
				System.out.println("Hatalı giriş");
				break;
			}

		} while (!secim.equals("0"));

	}

	public void bekle(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



public void atamaKontrol2(Ogretmen ogretmen) {
	ilkKontrolMu = true;
	int sinavSayisi = 0;
	if (ogretmen.getSiniflar().size() != 0) {
		all: for (Sinif sinif : ogretmen.getSiniflar()) {
			if (sinif.getOgrenciListesi().size() != 0) {
				sinavSayisi = sinif.getOgrenciListesi().get(0).getOgrenciSinav().size();
				if (sinavSayisi != 0) {
					for (Ogrenci ogrenci : sinif.getOgrenciListesi()) {
						for (Sinav sinav : ogrenci.getOgrenciSinav()) {
							if (sinav.getSinavNotu() == null) {
								sonGuncellenenOgrenci = ogrenci;
								sonGuncellenenSinav = sinav;
								sonGuncellenenSinif = sinif;
								atamalarBittiMi = false;
								break all;
							} else {
								atamalarBittiMi = true;
							}
						}
					}
				} else {
					atamalarBittiMi = true;
				}


			} else {
				System.out.println(
						"Sınıfta hiç öğrenci yok önce " + sinif.getSinifAdi() + " sinifina öğrenci eklemelisin.");
			}
		}
	}

}

	public Sinif sinifSec(Ogretmen ogretmen) {
		int index = 0;
		siniflariListele(ogretmen, index);
		System.out.println("Hangi sınıfla çalışmak istiyorsan sıra numarasını girebilirsin.");
		index = sc.nextInt() - 1;
		sc.nextLine();
		return ogretmen.getSiniflar().get(index);

	}

	/**
	 * @param ogretmen
	 * @param index
	 */
	public void siniflariListele(Ogretmen ogretmen, int index) {
		if (ogretmen.getSiniflar().size() == 0) {
			System.out.println(ogretmen.getName() + " şu an için hiç sınıfa sahip değil.");
		} else {
			for (Sinif sinif : ogretmen.getSiniflar()) {
				System.out.println(++index + " - " + sinif.getSinifAdi());
			}
		}

	}

	public Ogrenci ogrenciSec(Sinif sinif) {
		int index = 0;
		ogrencileriListele(sinif, index);
		System.out.println("Sectiğiniz öğrencinin sıra numarasını girebilirsin.");
		index = sc.nextInt() - 1;
		sc.nextLine();
		return sinif.getOgrenciListesi().get(index);
	}


	/**
	 * @param sinif
	 * @param index
	 */
	public void ogrencileriListele(Sinif sinif, int index) {
		if (sinif.getOgrenciListesi().size() == 0) {
			System.out.println("Henüz " + sinif.getSinifAdi() + " sınıfında hiç öğrenci yok");
		} else {
			for (Ogrenci ogrenci : sinif.getOgrenciListesi()) {
				System.out.println(++index + " - " + ogrenci.getAdSoyad() + "(" + ogrenci.getSehir() + ")");
			}
		}


	}
}
