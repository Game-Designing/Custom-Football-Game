package com.liulishuo.filedownloader.services;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import p019d.p307j.p308a.p313e.C13111b;
import p019d.p307j.p308a.p313e.C13117d;
import p019d.p307j.p308a.p313e.C13119f;

/* renamed from: com.liulishuo.filedownloader.services.j */
/* compiled from: FileDownloadThreadPool */
class C10925j {

    /* renamed from: a */
    private SparseArray<C10924i> f33396a = new SparseArray<>();

    /* renamed from: b */
    private ThreadPoolExecutor f33397b;

    /* renamed from: c */
    private final String f33398c;

    /* renamed from: d */
    private int f33399d;

    /* renamed from: e */
    private int f33400e;

    C10925j(int maxNetworkThreadCount) {
        String str = "Network";
        this.f33398c = str;
        this.f33400e = 0;
        this.f33397b = C13111b.m42766a(maxNetworkThreadCount, str);
        this.f33399d = maxNetworkThreadCount;
    }

    /* renamed from: c */
    public synchronized boolean mo35822c(int count) {
        if (mo35817a() > 0) {
            C13117d.m42783e(this, "Can't change the max network thread count, because the  network thread pool isn't in IDLE, please try again after all running tasks are completed or invoking FileDownloader#pauseAll directly.", new Object[0]);
            return false;
        }
        int validCount = C13119f.m42784a(count);
        if (C13117d.f40139a) {
            C13117d.m42778a(this, "change the max network thread count, from %d to %d", Integer.valueOf(this.f33399d), Integer.valueOf(validCount));
        }
        List<Runnable> taskQueue = this.f33397b.shutdownNow();
        this.f33397b = C13111b.m42766a(validCount, "Network");
        if (taskQueue.size() > 0) {
            C13117d.m42783e(this, "recreate the network thread pool and discard %d tasks", Integer.valueOf(taskQueue.size()));
        }
        this.f33399d = validCount;
        return true;
    }

    /* renamed from: a */
    public void mo35819a(C10924i runnable) {
        runnable.mo35815g();
        synchronized (this) {
            this.f33396a.put(runnable.mo35810b(), runnable);
        }
        this.f33397b.execute(runnable);
        int i = this.f33400e;
        if (i >= 600) {
            m35925c();
            this.f33400e = 0;
            return;
        }
        this.f33400e = i + 1;
    }

    /* renamed from: a */
    public void mo35818a(int id) {
        m35925c();
        synchronized (this) {
            C10924i r = (C10924i) this.f33396a.get(id);
            if (r != null) {
                r.mo35809a();
                boolean result = this.f33397b.remove(r);
                if (C13117d.f40139a) {
                    C13117d.m42778a(this, "successful cancel %d %B", Integer.valueOf(id), Boolean.valueOf(result));
                }
            }
            this.f33396a.remove(id);
        }
    }

    /* renamed from: c */
    private synchronized void m35925c() {
        SparseArray<FileDownloadRunnable> correctedRunnablePool = new SparseArray<>();
        for (int i = 0; i < this.f33396a.size(); i++) {
            int key = this.f33396a.keyAt(i);
            C10924i runnable = (C10924i) this.f33396a.get(key);
            if (runnable.mo35813e()) {
                correctedRunnablePool.put(key, runnable);
            }
        }
        this.f33396a = correctedRunnablePool;
    }

    /* renamed from: b */
    public boolean mo35821b(int downloadId) {
        C10924i runnable = (C10924i) this.f33396a.get(downloadId);
        return runnable != null && runnable.mo35813e();
    }

    /* renamed from: a */
    public synchronized int mo35817a() {
        m35925c();
        return this.f33396a.size();
    }

    /* renamed from: b */
    public synchronized List<Integer> mo35820b() {
        List<Integer> list;
        m35925c();
        list = new ArrayList<>();
        for (int i = 0; i < this.f33396a.size(); i++) {
            list.add(Integer.valueOf(((C10924i) this.f33396a.get(this.f33396a.keyAt(i))).mo35810b()));
        }
        return list;
    }
}
