package com.tim.coreserver.base.thread;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.concurrent.Callable;

import com.tim.common.entity.Task;

import lombok.Getter;
import lombok.Setter;

public abstract class BaseTask implements Callable<String> {

    /**
     * task
     */
    @Getter
    @Setter
    private Task task;

    @Getter
    @Setter
    private String message;

    /**
     * 檢查輸入參數，返回結果為true才會執行該任務
     *
     * @return true/false
     */
    public abstract boolean check();

    /**
     * 處理任務
     *
     * @return String
     * @throws InterruptedException
     * @throws Exception 異常
     */
    public abstract String handle() throws InterruptedException;

    /**
     * 處理完成後執行的操作,即在handle之後執行的操作
     *
     * @param String handle方法返回的處理結果
     */
    public abstract void postHandle(String output);

    @Override
    public String call() throws Exception {
        String result = null;

        // 先進行參數檢查
        boolean checkRs = this.check();
        if (!checkRs) {
            return "Invalid input parameters for the task";
        }
        try {
            // 處理任務
            result = this.handle();
        } catch (InterruptedException e) {
            System.out.println("---handle() error---");
            Thread.currentThread().interrupt();
            e.printStackTrace();
        } finally {
            // 執行postHandle方法
            try {
                this.postHandle(result);
            } catch (Exception e) {
                System.out.println("---postHandle() error---");
                e.printStackTrace();
            }
        }
        return result;
    }

}
