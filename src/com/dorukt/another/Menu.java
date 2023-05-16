package com.dorukt.another;

import java.util.Random;
import java.util.Scanner;

import com.dorukt.entities.EHoscakal;
import com.dorukt.entities.EHosgeldinMevcut;
import com.dorukt.entities.EHosgeldinYeni;
import com.dorukt.entities.Ogretmen;

public class Menu {
	private static Random rnd = new Random();
	private static Scanner sc = new Scanner(System.in);

	public static void yeniKullaniciHosgeldin() {
		// 10-15
		System.out.println(EHosgeldinYeni.values()[rnd.nextInt(0, 5)].getMesaj());
	}

	public static void mevcutKullaniciHosgeldin(String isim) {
		System.out.printf(EHosgeldinMevcut.values()[rnd.nextInt(0, 10)].getMesaj() + "%n", isim);
	}

	public static void hoscakalMesajlari(String isim) {
		System.out.printf(EHoscakal.values()[rnd.nextInt(0, 10)].getMesaj() + "%n", isim);
	}

	public static void isimIste() {
		System.out.println(
				"Seni tekrar geldiğinde tanıyabilmek için bir kaç bilgine ihtiyacımız var ismini yazabilir misin?");
	}

	public static void soyisimIste() {
		System.out.println("İhtiyacım olan bilgiler arasında soyadın da var, onu da yazabilir misin?");
	}

	public static void sifreIste() {
		System.out.println("Sifreni girebilir misin? (Merak etme kimseye söylemeyeceğiz)");
	}


	/**
	 * @param sayac
	 * @param ad
	 * @param soyad
	 * @param sifre
	 */
	public static void duzeltmeMenu(int sayac, String ad, String soyad, String sifre) {
		if (sayac == 0) {
			System.out.println("Bilgilerin şöyle: ");
			System.out.printf("Adın: %s, Soyadın: %s, Sifren: %s%n", ad, soyad, sifre);
			System.out.println(
					"Düzeltmek istediğin bir bilgi varsa ad, soyad ya da sifre yazarak düzeltmeleri yapabilirsin.");
			System.out.println("Eğer her şey doğruysa tamam yazarak programı başlatabilirsin.");
		} else {
			System.out.println("Düzeltilmiş Bilgilerin şöyle: ");
			System.out.printf("Adın: %s, Soyadın: %s, Sifren: %s%n", ad, soyad, sifre);
			System.out.println(
					"Eğer hala düzeltmek istediğin başka bir bilgi varsa ad, soyad ya da sifre yazarak düzeltmeleri yapabilirsin.");
			System.out.println("Eğer her şey doğruysa tamam yazarak programı başlatabilirsin.");
		}
	}

	public static void sifremiUnuttumMenu(Ogretmen ogretmen, int sayac) {

		switch (sayac) {
		case 0:
			System.out.println(
					"Bu kısım henüz kodlanmamış olabilir.(Ya da belki kodlanmışta olabilir belki bir daha denemelisin.)");
			break;
		case 1:
			System.out.println(
					"Sanırım bir şeyler kodlanmış ama tam olarak çalışıyor mu emin değilim. Bence şifreni hatırlamaya çalışırsan daha kolay olur ama tabi tekrar da deneyebilirsin");
			break;
		case 2:
			System.out.println(
					"Peki tamam bu kısımda bişeyler var. Ama henüz nasıl mail atabilirim bunu bilmiyorum. (Ama belki biraz daha denersen pes edebilirim.)");
			break;
		case 3:
			System.out.println("Tamam sen kazandın madem mail atamıyorum şifreni burdan yazayım o zaman işte şifren: "
					+ ogretmen.getPassword());
			break;
		default:
			System.out.println(
					"Şifreni zaten söyledim bundan sonra gerçekten yeni bişeyler yok. Bir kez daha söylemem gerekiyorsa şifren: "
							+ ogretmen.getPassword());
			break;
		}
	}

	public static void hataliGirisMenu(int yanlisGirisler) {
		switch (yanlisGirisler) {
		case 0:
			System.out.println(
					"Şifreni hatalı girdin. Bu ilk hatan ve toplamda 3 kez daha hatalı şifre girme hakkın var.");
			break;
		case 1:
			System.out.println("Şifreni yine hatalı girdin ve bu senin 2. hatan. Lütfen daha dikkatli ol.");
			break;
		case 2:
			System.out.println("Şifreni yine hatalı girdin ve bu senin 3. hatan. Lütfen dikkatli bu son şansın.");
			break;
		case 3:
			System.out.println(
					"Üzgünüm sanırım şifreni unuttun. Merak etme şifreni hatırladığında tekrar deneyebilirsin. Anlayışın için teşekkür ederim.");
			System.exit(0);
			break;

		default:
			System.out.println("Yolunda gitmeyen bişeyler var. Lütfen kodu kontrol etmemi söyle.");
			System.exit(0);
			break;
		}
	}

	public static void anaMenuStandart() {

		System.out.println("1- Öğrenci ekle");
		System.out.println("2- Öğrenci sil");
		System.out.println("3- Öğrenci güncelle");
		System.out.println("4- Öğrenci devamsızlık işlemleri");
		System.out.println("5- Sınav Notu işlemleri");
		System.out.println("6- Öğrencileri listele");
		System.out.println("7- Sınıfları listele");
		System.out.println("8- Yeni Sınıf oluştur");
		System.out.println("9- Sınıf güncelle");
		System.out.println("10- Sınıf sil");
		System.out.println("11- Kaydımı sil");
		System.out.println("0- Çıkış");
		System.out.println("Lütfen yapmak istediğin işlemi gir");

	}

	public static void ogrenciGuncellemeMenu() {
		System.out.println("1- Ogrencinin Ad-Soyad bilgisini düzelt");
		System.out.println("2- Ogrencinin şehir bilgisini düzelt");
		System.out.println("0- Önceki menüye dön.");

	}

	public static void devamsizlikIslemleri() {
		System.out.println("1- Sınıf yoklaması al");
		System.out.println("2- Ogrenci devamsızlık durumu");
		System.out.println("0- Önceki menüye dön.");
	}

	public static void sinifGuncellemeMenu() {
		System.out.println("1- Sınıfın adını düzelt");
		System.out.println("2- Sınıfı boşalt");
		System.out.println("0- Önceki menüye dön.");

	}

	public static void sinavNotuIslemleri() {
		System.out.println("1- Yeni sınav notunu sırayla gir.");
		System.out.println("2- Öğrencinin notlarını göster.");
		System.out.println("3- Bir öğrencinin notunu düzelt.");
		System.out.println("0- Önceki menüye dön.");

	}

}
