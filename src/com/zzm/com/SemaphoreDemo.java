package com.zzm.com;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
	public static void main(String[] args) {
		Semaphore sp=new Semaphore(3);
		for (int i = 1; i <=6; i++) {
			new Thread(()->{
				try {
					sp.acquire();
					System.out.println(Thread.currentThread().getName()+"\t号车进入停车位");
					TimeUnit.SECONDS.sleep(new Random().nextInt(8));
					System.out.println(Thread.currentThread().getName()+"\t号车离开了停车位");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					sp.release();
					
				}
			}, String.valueOf(i)).start();
		}
	}
}
