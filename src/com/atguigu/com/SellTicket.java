package com.atguigu.com;

public class SellTicket {
	public static void main(String[] args) {
		
		Ticket ticket = new Ticket();
		//lambda Express
		new Thread(()->{for (int i = 1; i <=40; i++) ticket.sale();}, "AA").start();
		new Thread(()->{for (int i = 1; i <=40; i++) ticket.sale();}, "BB").start();
		new Thread(()->{for (int i = 1; i <=40; i++) ticket.sale();}, "CC").start();
		new Thread(()->{for (int i = 1; i <=40; i++) ticket.sale();}, "DD").start();
		
		
		
		
		//匿名内部类
/*		new Thread(new Runnable() {
			@Override
			public void run()
			{
				for (int i = 1; i <=40; i++) 
				{
					ticket.sellTickets();
				}
			}
		}, "AA").start();
		new Thread(new Runnable() {
			@Override
			public void run()
			{
				for (int i = 1; i <=40; i++) 
				{
					ticket.sellTickets();
				}
			}
		}, "BB").start();
		new Thread(new Runnable() {
			@Override
			public void run()
			{
				for (int i = 1; i <=40; i++) 
				{
					ticket.sellTickets();
				}
			}
		}, "CC").start();*/
	}
}
