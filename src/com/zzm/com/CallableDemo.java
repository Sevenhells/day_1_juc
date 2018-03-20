package com.zzm.com;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*class Mythred implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		System.out.println("**************call***********");
		return 1018;
	}
	
}*/


public class CallableDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
	
		FutureTask<Integer> ft1=new FutureTask<Integer>(()->{
			System.out.println("**************call***********");
			return 1018;
		});
		new Thread(ft1, "AAA").start(); 
		Integer re=ft1.get();
		System.out.println(re);
	}
}
