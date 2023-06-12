package com.tim.coreserver.task;

import com.tim.coreserver.base.thread.BaseTask;

public class Task1 extends BaseTask {

    private long waitTime = 0;

    public Task1() {
    }

    public Task1(int timeInMillis) {
        this.waitTime = timeInMillis;
    }

    @Override
    public boolean check() {
        if (this.waitTime >= 0)
            return true;
        return false;
    }

    @Override
    public String handle() throws InterruptedException {
        Thread.sleep(waitTime);
        return Thread.currentThread().getName();
    }

    @Override
    public void postHandle(String output) {
    }

}
