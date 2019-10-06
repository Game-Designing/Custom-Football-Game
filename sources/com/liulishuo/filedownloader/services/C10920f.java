package com.liulishuo.filedownloader.services;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import java.lang.ref.WeakReference;
import p019d.p307j.p308a.C13139r;
import p019d.p307j.p308a.p311c.C13097a;
import p019d.p307j.p308a.p311c.C13100b.C13101a;

/* renamed from: com.liulishuo.filedownloader.services.f */
/* compiled from: FDServiceSharedHandler */
public class C10920f extends C13101a implements C10926k {

    /* renamed from: a */
    private final C10923h f33365a;

    /* renamed from: b */
    private final WeakReference<FileDownloadService> f33366b;

    /* renamed from: com.liulishuo.filedownloader.services.f$a */
    /* compiled from: FDServiceSharedHandler */
    public interface C10921a {
        /* renamed from: a */
        void mo35794a(C10920f fVar);

        void onDisconnected();
    }

    C10920f(WeakReference<FileDownloadService> wService, C10923h manager) {
        this.f33366b = wService;
        this.f33365a = manager;
    }

    /* renamed from: b */
    public void mo35785b(C13097a callback) {
    }

    /* renamed from: a */
    public void mo35781a(C13097a callback) {
    }

    /* renamed from: a */
    public boolean mo35784a(String url, String path) {
        return this.f33365a.mo35800a(url, path);
    }

    /* renamed from: a */
    public void mo35782a(String url, String path, boolean pathAsDirectory, int callbackProgressTimes, int callbackProgressMinIntervalMillis, int autoRetryTimes, boolean forceReDownload, FileDownloadHeader header, boolean isWifiRequired) {
        this.f33365a.mo35797a(url, path, pathAsDirectory, callbackProgressTimes, callbackProgressMinIntervalMillis, autoRetryTimes, forceReDownload, header, isWifiRequired);
    }

    /* renamed from: b */
    public boolean mo35786b(int downloadId) {
        return this.f33365a.mo35807f(downloadId);
    }

    /* renamed from: k */
    public void mo35791k() {
        this.f33365a.mo35804c();
    }

    /* renamed from: f */
    public boolean mo35789f(int count) {
        return this.f33365a.mo35808g(count);
    }

    /* renamed from: g */
    public long mo35790g(int downloadId) {
        return this.f33365a.mo35801b(downloadId);
    }

    /* renamed from: e */
    public long mo35788e(int downloadId) {
        return this.f33365a.mo35805d(downloadId);
    }

    /* renamed from: a */
    public byte mo35777a(int downloadId) {
        return this.f33365a.mo35803c(downloadId);
    }

    /* renamed from: D */
    public boolean mo35776D() {
        return this.f33365a.mo35802b();
    }

    /* renamed from: a */
    public void mo35779a(int id, Notification notification) {
        WeakReference<FileDownloadService> weakReference = this.f33366b;
        if (weakReference != null && weakReference.get() != null) {
            ((FileDownloadService) this.f33366b.get()).startForeground(id, notification);
        }
    }

    /* renamed from: a */
    public void mo35783a(boolean removeNotification) {
        WeakReference<FileDownloadService> weakReference = this.f33366b;
        if (weakReference != null && weakReference.get() != null) {
            ((FileDownloadService) this.f33366b.get()).stopForeground(removeNotification);
        }
    }

    /* renamed from: c */
    public boolean mo35787c(int id) {
        return this.f33365a.mo35798a(id);
    }

    /* renamed from: z */
    public void mo35793z() {
        this.f33365a.mo35796a();
    }

    /* renamed from: a */
    public void mo35780a(Intent intent, int flags, int startId) {
        C13139r.m42868a().mo35794a(this);
    }

    /* renamed from: a */
    public IBinder mo35778a(Intent intent) {
        return null;
    }

    public void onDestroy() {
        C13139r.m42868a().onDisconnected();
    }
}
