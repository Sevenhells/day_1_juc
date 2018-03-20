package com.zzm.com;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ExecutorsDemo {
	public static void main(String[] args) {
		ScheduledExecutorService service=Executors.newScheduledThreadPool(5);
		ScheduledFuture<Integer> result=null;
		try {
			for (int i = 0; i <=15; i++) {
				result=service.schedule(()->{
					System.out.print(Thread.currentThread().getName());
					return new Random().nextInt(10);
				}, 2, TimeUnit.SECONDS);
				System.out.println("****result:"+result.get());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			service.shutdown();
		}
	}

	private static void TestExecutors() {
		//ExecutorService service = Executors.newFixedThreadPool(5);//一池5线程
		//ExecutorService service=Executors.newFixedThreadPool(5);
		//ExecutorService service=Executors.newSingleThreadExecutor();//一池一线程
		ExecutorService service=Executors.newCachedThreadPool();
		Future<Integer> result=null;
		try {
			for (int i = 1; i <=15; i++) {
				result=service.submit(()->{
					System.out.print(Thread.currentThread().getName());
					return new Random().nextInt(10);
				});
				System.out.println("****result:"+result.get());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			service.shutdown();
		}
	}
}
