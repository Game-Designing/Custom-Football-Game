package com.integralads.avid.library.mopub.walking.async;

import com.integralads.avid.library.mopub.walking.async.AvidAsyncTask.AvidAsyncTaskListener;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AvidAsyncTaskQueue implements AvidAsyncTaskListener {
    private static final int THREAD_COUNT = 1;
    private AvidAsyncTask currentTask = null;
    private final ArrayDeque<AvidAsyncTask> pendingTasks = new ArrayDeque<>();
    private final ThreadPoolExecutor threadPoolExecutor;
    private final BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue();

    public AvidAsyncTaskQueue() {
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.workQueue);
        this.threadPoolExecutor = threadPoolExecutor2;
    }

    public void submitTask(AvidAsyncTask task) {
        task.setListener(this);
        this.pendingTasks.add(task);
        if (this.currentTask == null) {
            executeNextTask();
        }
    }

    private void executeNextTask() {
        this.currentTask = (AvidAsyncTask) this.pendingTasks.poll();
        AvidAsyncTask avidAsyncTask = this.currentTask;
        if (avidAsyncTask != null) {
            avidAsyncTask.start(this.threadPoolExecutor);
        }
    }

    public void onTaskCompleted(AvidAsyncTask task) {
        this.currentTask = null;
        executeNextTask();
    }

    /* access modifiers changed from: 0000 */
    public AvidAsyncTask getCurrentTask() {
        return this.currentTask;
    }

    /* access modifiers changed from: 0000 */
    public ArrayDeque<AvidAsyncTask> getPendingTasks() {
        return this.pendingTasks;
    }
}
