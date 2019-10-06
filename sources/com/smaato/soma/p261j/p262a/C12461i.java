package com.smaato.soma.p261j.p262a;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import java.util.concurrent.Executor;

/* renamed from: com.smaato.soma.j.a.i */
/* compiled from: SmaatoAsyncTasks */
public class C12461i {

    /* renamed from: a */
    private static Executor f38908a;

    static {
        m40987a();
    }

    @TargetApi(11)
    /* renamed from: a */
    private static void m40987a() {
        f38908a = AsyncTask.THREAD_POOL_EXECUTOR;
    }

    @TargetApi(11)
    /* renamed from: a */
    public static <P> void m40988a(AsyncTask<P, ?, ?> asyncTask, P... params) {
        asyncTask.executeOnExecutor(f38908a, params);
    }
}
