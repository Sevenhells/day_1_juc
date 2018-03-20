package com.zzm.com;

import java.util.concurrent.locks.ReentrantReadWriteLock;

class ReadAndWrite{
	private Object obj;
	private ReentrantReadWriteLock rwlock=new ReentrantReadWriteLock();
	public void wirteObj(Object obj){
		rwlock.writeLock().lock();
		try {
			this.obj=obj;
			System.out.println(Thread.currentThread().getName()+"\t write"+obj);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			rwlock.writeLock().unlock();
		}
	}
	public void readObj(){
		rwlock.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName()+"\t read"+obj);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			rwlock.readLock().unlock();
		}
	}
	
}
/**
 * 
 * @Description: 一个线程写入,100个线程读取
 * @author zzyy
 * @date 2018年3月17日
 */
public class ReadWriteLockDemo {
	public static void main(String[] args) throws InterruptedException {
		ReadAndWrite raw=new ReadAndWrite();
		new Thread(()->{
			raw.wirteObj("I am the King");
		}, "Writer").start();
		Thread.sleep(100);
		for (int i =1; i <=100; i++) {
			new Thread(()->{
				raw.readObj();
			}, String.valueOf(i)).start();
			
		}
	}
	
}
