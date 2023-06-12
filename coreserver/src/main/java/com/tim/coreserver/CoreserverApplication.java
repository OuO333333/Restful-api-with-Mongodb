package com.tim.coreserver;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.tim.coreserver.task.Task1;

@SpringBootApplication
public class CoreserverApplication {

	public static void main(String[] args) {
		// SpringApplication.run(CoreserverApplication.class, args);
		Task1 task1 = new Task1(1000);
		Task1 task2 = new Task1(3000);

		// 將任務封裝到一個由執行者調度的FutureTask對象
		FutureTask<String> futureTask1 = new FutureTask<>(task1);
		FutureTask<String> futureTask2 = new FutureTask<>(task2);

		ExecutorService executor = Executors.newFixedThreadPool(2); // 创建线程池并返回ExecutorService实例
		executor.execute(futureTask1); // 执行任务
		executor.execute(futureTask2);

		while (true) {
			try {
				if(futureTask1.isDone() && futureTask2.isDone()){

					//  兩個任務都完成
                    System.out.println("Done");
                    executor.shutdown();

					// 關閉線程池和服務
                    return;
                }
				// futureTask1.get(): 等待，直到futureTask1完成
				// !futureTask1.isDone(): futureTask1沒有完成
				// futureTask1.get(200L, TimeUnit.MILLISECONDS): 等待futureTask1 200 miliseconds

				if(!futureTask1.isDone()){
					System.out.println("Waiting for FutureTask1 to complete");
				}
				if(!futureTask2.isDone()){
					System.out.println("Waiting for FutureTask2 to complete");

				}
				Thread.sleep(200L);
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}

	}

}
