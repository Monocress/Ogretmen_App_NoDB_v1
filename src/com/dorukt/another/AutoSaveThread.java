package com.dorukt.another;

import com.dorukt.entities.DosyaIslemleri;
import com.dorukt.entities.Ogretmen;

public class AutoSaveThread extends Thread {

	Ogretmen ogretmen;
	volatile boolean threadCanliMi;

	@Override
	public void run() {
		DosyaIslemleri.autoSave(ogretmen);

	}

//	public AutoSaveThread(Ogretmen ogretmen) {
//		super();
//		this.ogretmen = ogretmen;
//	}

}
