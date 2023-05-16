package com.dorukt.entities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DosyaIslemleri {

	private static File ogretmenDosyasi = new File("ogretmen.bin");
	private static File autosaveDosyasi = new File("autosave.bin");
	private static Thread autosaver;

	public static boolean dosyaVarMi() {
		return ogretmenDosyasi.exists();
	}

	public static void dosyaYaz(String dosya, Object object) {

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dosya))) {
			oos.writeObject(object);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Object dosyaOku(String dosya) {
		Object object = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dosya))) {
			object = ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return object;

	}

	public static void ogretmenDosyasiniOlustur(Ogretmen ogretmen) {
		dosyaYaz(ogretmenDosyasi.getAbsolutePath(), ogretmen);
	}

	public static void ogretmenDosyasiniSil() {
		ogretmenDosyasi.delete();

	}
	public static Ogretmen ogretmenDosyasiniOku() {
		return (Ogretmen) dosyaOku(ogretmenDosyasi.getAbsolutePath());
	}

	public static void autoSave(Ogretmen ogretmen) {
		autosaver = new Thread(() -> {
			dosyaYaz(autosaveDosyasi.getAbsolutePath(), ogretmen);
		});
		autosaver.start();
	}

	public static Ogretmen autoSaveKullan() {
		return (Ogretmen) dosyaOku(autosaveDosyasi.getAbsolutePath());
	}

	public static boolean autoSaveVarMi() {
		return autosaveDosyasi.exists();
	}

	public static void autoSaveSil() {
		autosaveDosyasi.delete();
	}
}
