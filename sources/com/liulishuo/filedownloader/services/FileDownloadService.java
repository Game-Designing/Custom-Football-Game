package com.liulishuo.filedownloader.services;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.lang.ref.WeakReference;
import p019d.p307j.p308a.C13139r;
import p019d.p307j.p308a.p313e.C13119f;
import p019d.p307j.p308a.p313e.C13121g;

@SuppressLint({"Registered"})
public class FileDownloadService extends Service {

    /* renamed from: a */
    private C10926k f33348a;

    public static class SeparateProcessService extends FileDownloadService {
    }

    public static class SharedMainProcessService extends FileDownloadService {
    }

    public void onCreate() {
        super.onCreate();
        try {
            C13121g.m42793a(C13119f.m42785a().f40140a);
            C13121g.m42794a(C13119f.m42785a().f40141b);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        C10923h manager = new C10923h(C13139r.m42869c().mo42139b());
        if (C13119f.m42785a().f40143d) {
            this.f33348a = new C10920f(new WeakReference(this), manager);
        } else {
            this.f33348a = new C10919e(new WeakReference(this), manager);
        }
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        this.f33348a.mo35780a(intent, flags, startId);
        return 1;
    }

    public void onDestroy() {
        this.f33348a.onDestroy();
        super.onDestroy();
    }

    public IBinder onBind(Intent intent) {
        return this.f33348a.mo35778a(intent);
    }
}
