package com.cloudera.flume.flumelog4jtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.nio.charset.Charset;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.flume.FlumeException;
import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LogTestApp implements Runnable {
	// static Logger logger = Logger.getRootLogger();

	public static void main(String[] args) throws IOException,
			InterruptedException {
		// System.out.println("Main starts");
		// app2.mt=Thread.currentThread();
		// app2 t = new app2();
		// t.start();

		// Thread.currentThread().sleep( 100 );
		// logger.shutdown();

		// Thread.sleep(2000);

		LogTestApp obj = new LogTestApp();
		Thread t1 = new Thread(obj);
		t1.start();
		ExecutorService service = Executors.newFixedThreadPool(10);

		// submit as many tasks as you want.
		// tasks must honour interrupts to be stopped externally.
		Future future = service.submit(new LogTestApp());

		// to cancel an individual task
		future.cancel(true);

		// when finished shutdown
		service.shutdown();
		

		// System.out.println("Main ends");
	}

	@Override
	public void run() {
		final Logger logger = LogManager.getLogger(LogTestApp.class);
		int i = 0;
		while (i <= 10) {
			logger.info("Hello this is an info message" + i);
			System.out.println("message sent no:" + i);
			i++;
		}
		System.out.println("The current Thread is running:"
				+ Thread.currentThread().getName());
		Set<Thread> threadSet = Thread.getAllStackTraces().keySet();

		for (Thread t : threadSet) {

			System.out.println("Thread :" + t.getName() + "\t Thread Id:"
					+ t.getId() + ":" + "\t state:" + t.getState());

		}
	}

}
// class app2 extends Thread{
// static Thread mt;
// public void run(){
// try {
// mt.join();//waits till main thread dies.
// } catch (InterruptedException e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }
// System.out.println("child thread");
// }
// }