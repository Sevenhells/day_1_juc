package com.zzm.com;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//线程   操作  资源类
//判断，干活 ， 通知
class ShareResource{
	private int flag=1;
	private Lock lock=new ReentrantLock();
	Condition c1=lock.newCondition();
	Condition c2=lock.newCondition();
	Condition c3=lock.newCondition();
	public void print5(int totalLoop){
		lock.lock();
		try {
			//1.判断
			while(flag!=1){
				c1.await();
			}
			//2.干活
			for (int i = 1; i <=5; i++) {
				System.out.println(Thread.currentThread().getName()+"\t"+i+"\t"+totalLoop);
			}
			//3.通知
			flag=2;
			c2.signal();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	public void print10(int totalLoop){
		lock.lock();
		try {
			//1.判断
			while(flag!=2){
				c2.await();
			}
			//2.干活
			for (int i = 1; i <=10; i++) {
				System.out.println(Thread.currentThread().getName()+"\t"+i+"\t"+totalLoop);
			}
			//3.通知
			flag=3;
			c3.signal();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	public void print15(int totalLoop){
		lock.lock();
		try {
			//1.判断
			while(flag!=3){
				c3.await();
			}
			//2.干活
			for (int i = 1; i <=15; i++) {
				System.out.println(Thread.currentThread().getName()+"\t"+i+"\t"+totalLoop);
			}
			//3.通知
			flag=1;
			c1.signal();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
}
/**
 * 
 * @Description: 
 * 多线程之间按顺序调用，实现A->B->C
 * 三个线程启动，要求如下：
 * 
 * AA打印5次，BB打印10次，CC打印15次
 * 接着
 * AA打印5次，BB打印10次，CC打印15次
 * ......来10轮  
 * @author zzm
 * @date 2018年3月18日
 */
public class ThreadOrderAccess {
	public static void main(String[] args) {
		ShareResource sr=new ShareResource();
		new Thread(()->{
			for (int i = 1; i <=10; i++) {
				sr.print5(i);
			}
		}, "AAA").start();
		new Thread(()->{
			for (int i = 1; i <=10; i++) {
				sr.print10(i);
			}
		}, "BBB").start();
		new Thread(()->{
			for (int i = 1; i <=10; i++) {
				sr.print15(i);
			}
		}, "CCC").start();
	}
}
