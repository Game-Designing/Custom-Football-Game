package com.vungle.warren;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.vungle.warren.tasks.JobCreator;
import com.vungle.warren.tasks.JobInfo;
import com.vungle.warren.tasks.JobRunner;
import com.vungle.warren.tasks.runnable.JobRunnable;
import com.vungle.warren.tasks.runnable.PriorityRunnable;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class VungleJobRunner implements JobRunner {
    private static int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    private static final String TAG = VungleJobRunner.class.getSimpleName();
    private static Handler handler = new Handler(Looper.getMainLooper());
    private JobCreator creator;
    /* access modifiers changed from: private */
    public Executor executor;

    VungleJobRunner(JobCreator jobCreator) {
        int i = NUMBER_OF_CORES;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 1, TimeUnit.SECONDS, new PriorityBlockingQueue());
        this(jobCreator, threadPoolExecutor);
    }

    VungleJobRunner(JobCreator jobCreator, Executor executor2) {
        this.creator = jobCreator;
        this.executor = executor2;
    }

    public void execute(JobInfo jobInfo) {
        JobInfo jobInfoCopy = jobInfo.copy();
        String jobTag = jobInfoCopy.getJobTag();
        long delay = jobInfoCopy.getDelay();
        jobInfoCopy.setDelay(0);
        final PriorityRunnable jobRunnable = new JobRunnable(jobInfoCopy, this.creator, this);
        if (delay <= 0) {
            this.executor.execute(jobRunnable);
            return;
        }
        if (jobInfoCopy.getUpdateCurrent()) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("replacing pending job with new ");
            sb.append(jobTag);
            Log.d(str, sb.toString());
            handler.removeCallbacksAndMessages(jobTag);
        }
        handler.postAtTime(new Runnable() {
            public void run() {
                VungleJobRunner.this.executor.execute(jobRunnable);
            }
        }, jobTag, SystemClock.uptimeMillis() + delay);
    }
}
