package com.zzm.com;

import java.util.concurrent.CountDownLatch;

import com.atguigu.enums.CountryEnums;

/** 解释：5个同学陆续离开教室后值班同学才可以关门。
* 也即	秦灭6国，一统华夏
* main主线程必须要等前面5个线程完成全部工作后，自己才能开干
*/
public class CountDownLatchDemo {
	public static void main(String[] args) throws InterruptedException {
		TestCloseDoor();
		System.out.println("***********************************");
		CountDownLatch cd=new CountDownLatch(6);
		for (int i = 1; i <=6; i++) {
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"国被灭");
				cd.countDown();
			}, CountryEnums.forEachCountryEnums(i).getRetMsg()).start();
		}
		cd.await();
		System.out.println(Thread.currentThread().getName()+"秦灭6国，一统华夏");

	}

	private static void TestCloseDoor() throws InterruptedException {
		CountDownLatch cd=new CountDownLatch(6);
		for (int i = 1; i <=6; i++) {
			new Thread(()->{
				System.out.println("第"+Thread.currentThread().getName()+"号学生离开教室");
				cd.countDown();
			}, String.valueOf(i)).start();
		}
		cd.await();
		System.out.println(Thread.currentThread().getName()+"锁门走人");
	}
}
