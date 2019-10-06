package com.mopub.common.util;

import android.os.AsyncTask;

/* renamed from: com.mopub.common.util.a */
/* compiled from: AsyncTasks */
class C11289a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AsyncTask f34613a;

    /* renamed from: b */
    final /* synthetic */ Object[] f34614b;

    C11289a(AsyncTask asyncTask, Object[] objArr) {
        this.f34613a = asyncTask;
        this.f34614b = objArr;
    }

    public void run() {
        this.f34613a.executeOnExecutor(AsyncTasks.f34581a, this.f34614b);
    }
}
