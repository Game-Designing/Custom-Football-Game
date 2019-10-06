package com.mopub.common.util;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import java.util.concurrent.Executor;

public class AsyncTasks {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static Executor f34581a;

    /* renamed from: b */
    private static Handler f34582b;

    static {
        m37186b();
    }

    /* renamed from: b */
    private static void m37186b() {
        f34581a = AsyncTask.THREAD_POOL_EXECUTOR;
        f34582b = new Handler(Looper.getMainLooper());
    }

    @VisibleForTesting
    public static void setExecutor(Executor executor) {
        f34581a = executor;
    }

    public static <P> void safeExecuteOnExecutor(AsyncTask<P, ?, ?> asyncTask, P... params) {
        Preconditions.checkNotNull(asyncTask, "Unable to execute null AsyncTask.");
        if (Looper.getMainLooper() == Looper.myLooper()) {
            asyncTask.executeOnExecutor(f34581a, params);
            return;
        }
        MoPubLog.log(SdkLogEvent.CUSTOM, "Posting AsyncTask to main thread for execution.");
        f34582b.post(new C11289a(asyncTask, params));
    }
}
