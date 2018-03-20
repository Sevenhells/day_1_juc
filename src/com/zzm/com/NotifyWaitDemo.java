package com.zzm.com;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Number{
	int number=0;
	private Lock lock=new ReentrantLock();
	private Condition condition=lock.newCondition();
	int i=1;
	int b=0;
	public void printNumber(){
		lock.lock();
		try {
			while(number!=0){
				condition.await();
			}
			++number;
			System.out.print(Thread.currentThread().getName()+i+","+(++i)+",");
			System.out.println(          );
			++i;
			condition.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	public void printWord(){
		lock.lock();
		try {
			while(number==0){
				condition.await();
			}
			--number;
			System.out.print(Thread.currentThread().getName()+(char)(97+b)+",");
			System.out.println(          );
			++b;
			condition.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
}
/** 1 多线程编写套路------上
* 		1.1	线程		操作(实例方法)		资源类
* 		1.2  高内聚  低耦合
* 
* 2 多线程编写套路------下
* 		2.1 判断
* 		2.2 干活
* 		2.3 通知
* 要求：有52个数字1-52,26个小写英文字母a-z，
* 实现两个进程依次输出1,2，a，3,4，b，5，6c...
* */
public class NotifyWaitDemo {
	public static void main(String[] args) {
		Number num=new Number();
		new Thread(()->{for(int i=1;i<=26;i++)num.printNumber();}, "AAA").start();
		new Thread(()->{for(int i=1;i<=26;i++)num.printWord();}, "BBB").start();
	}
}
