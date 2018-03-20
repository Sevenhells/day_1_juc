package com.zzm.com;

import java.util.concurrent.CyclicBarrier;

//集齐七颗龙珠，召唤神龙

public class CyclicBarrierDemo {
	private static final int NUMBER = 7;
	public static void main(String[] args) {
		CyclicBarrier cb=new CyclicBarrier(NUMBER, ()->{System.out.println("龙珠集齐，召唤神龙");});
		for(int i=1;i<=NUMBER;i++){
			int temp=i;
			new Thread(()->{
				try {
					System.out.println(temp+"星球已找到");
					cb.await();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}, String.valueOf(i)).start();
		}
	}
}
