package com.zzm.com;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Tickets{
	int number=30;
	private Lock lock=new ReentrantLock();
	public void sell(){
		lock.lock();
		try {
			if(number>0){
				System.out.println(Thread.currentThread().getName()+"\t正在卖第"+number--+"\t张票，还剩"+number+"张票");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
}



/*1 多线程编写套路------上
 		1.1	线程		操作(实例方法)		资源类
 		1.2  高内聚  低耦合*/
public class SellTickets {
	public static void main(String[] args) {
		Tickets ti=new Tickets();
		new Thread(()->{for(int i=1;i<=40;i++)ti.sell();}, "AAAA").start();
		new Thread(()->{for(int i=1;i<=40;i++)ti.sell();}, "BBBB").start();
		new Thread(()->{for(int i=1;i<=40;i++)ti.sell();}, "CCCC").start();
		
/*		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=1;i<=40;i++){
					ti.sell();
				}
				
			}
		}, "AAAA").start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=1;i<=40;i++){
					ti.sell();
				}
				
			}
		}, "BBBB").start();
		new Thread(new Runnable() {
	
			@Override
			public void run() {
				for(int i=1;i<=40;i++){
					ti.sell();
				}
		
			}
		}, "CCCC").start();*/
	}
}
