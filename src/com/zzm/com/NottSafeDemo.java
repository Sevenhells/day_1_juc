package com.zzm.com;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

//arraylist线程不安全
public class NottSafeDemo {
	public static void main(String[] args) {
		List<String> list=new CopyOnWriteArrayList<String>();
		for (int i = 1; i <=30; i++) {
			 new Thread(() -> {
				list.add(UUID.randomUUID().toString().substring(0, 4));
				System.out.println(list);
			}, String.valueOf(i)).start();
		}
	}
}
