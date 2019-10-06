package com.vungle.warren.tasks.runnable;

import android.os.Bundle;
import android.util.Log;
import com.vungle.warren.tasks.JobCreator;
import com.vungle.warren.tasks.JobInfo;
import com.vungle.warren.tasks.JobRunner;

public class JobRunnable extends PriorityRunnable {
    private static final String TAG = JobRunnable.class.getSimpleName();
    private final JobCreator creator;
    private final JobRunner jobRunner;
    private final JobInfo jobinfo;

    public JobRunnable(JobInfo jobInfo, JobCreator jobCreator, JobRunner jobRunner2) {
        this.jobinfo = jobInfo;
        this.creator = jobCreator;
        this.jobRunner = jobRunner2;
    }

    public Integer getPriority() {
        return Integer.valueOf(this.jobinfo.getPriority());
    }

    public void run() {
        try {
            String jobTag = this.jobinfo.getJobTag();
            Bundle params = this.jobinfo.getExtras();
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Start job ");
            sb.append(jobTag);
            sb.append("Thread ");
            sb.append(Thread.currentThread().getName());
            Log.d(str, sb.toString());
            int result = this.creator.create(jobTag).onRunJob(params, this.jobRunner);
            String str2 = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("On job finished ");
            sb2.append(jobTag);
            sb2.append(" with result ");
            sb2.append(result);
            Log.d(str2, sb2.toString());
            if (result == 2) {
                long nextReschedule = this.jobinfo.makeNextRescedule();
                if (nextReschedule > 0) {
                    this.jobinfo.setDelay(nextReschedule);
                    this.jobRunner.execute(this.jobinfo);
                    String str3 = TAG;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Rescheduling ");
                    sb3.append(jobTag);
                    sb3.append(" in ");
                    sb3.append(nextReschedule);
                    Log.d(str3, sb3.toString());
                }
            }
        } catch (Throwable th) {
            Log.e(TAG, "Can't start job", th);
        }
    }
}
