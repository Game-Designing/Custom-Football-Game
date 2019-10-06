package com.liulishuo.filedownloader.services;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.liulishuo.filedownloader.message.C10904d;
import com.liulishuo.filedownloader.message.C10904d.C10906b;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import java.lang.ref.WeakReference;
import p019d.p307j.p308a.p311c.C13097a;
import p019d.p307j.p308a.p311c.C13100b.C13101a;
import p019d.p307j.p308a.p313e.C13117d;

/* renamed from: com.liulishuo.filedownloader.services.e */
/* compiled from: FDServiceSeparateHandler */
public class C10919e extends C13101a implements C10906b, C10926k {

    /* renamed from: a */
    private final RemoteCallbackList<C13097a> f33362a = new RemoteCallbackList<>();

    /* renamed from: b */
    private final C10923h f33363b;

    /* renamed from: c */
    private final WeakReference<FileDownloadService> f33364c;

    /* renamed from: b */
    private synchronized int m35833b(MessageSnapshot snapShot) {
        int n;
        n = this.f33362a.beginBroadcast();
        int i = 0;
        while (i < n) {
            try {
                ((C13097a) this.f33362a.getBroadcastItem(i)).mo42070a(snapShot);
                i++;
            } catch (RemoteException e) {
                C13117d.m42779a((Object) this, (Throwable) e, "callback error", new Object[0]);
                this.f33362a.finishBroadcast();
            } catch (Throwable th) {
                th = th;
                this.f33362a.finishBroadcast();
                throw th;
            }
        }
        this.f33362a.finishBroadcast();
        return n;
    }

    C10919e(WeakReference<FileDownloadService> wService, C10923h manager) {
        this.f33364c = wService;
        this.f33363b = manager;
        C10904d.m35756a().mo35706a((C10906b) this);
    }

    /* renamed from: b */
    public void mo35785b(C13097a callback) throws RemoteException {
        this.f33362a.register(callback);
    }

    /* renamed from: a */
    public void mo35781a(C13097a callback) throws RemoteException {
        this.f33362a.unregister(callback);
    }

    /* renamed from: a */
    public boolean mo35784a(String url, String path) throws RemoteException {
        return this.f33363b.mo35800a(url, path);
    }

    /* renamed from: a */
    public void mo35782a(String url, String path, boolean pathAsDirectory, int callbackProgressTimes, int callbackProgressMinIntervalMillis, int autoRetryTimes, boolean forceReDownload, FileDownloadHeader header, boolean isWifiRequired) throws RemoteException {
        this.f33363b.mo35797a(url, path, pathAsDirectory, callbackProgressTimes, callbackProgressMinIntervalMillis, autoRetryTimes, forceReDownload, header, isWifiRequired);
    }

    /* renamed from: b */
    public boolean mo35786b(int downloadId) throws RemoteException {
        return this.f33363b.mo35807f(downloadId);
    }

    /* renamed from: k */
    public void mo35791k() throws RemoteException {
        this.f33363b.mo35804c();
    }

    /* renamed from: f */
    public boolean mo35789f(int count) throws RemoteException {
        return this.f33363b.mo35808g(count);
    }

    /* renamed from: g */
    public long mo35790g(int downloadId) throws RemoteException {
        return this.f33363b.mo35801b(downloadId);
    }

    /* renamed from: e */
    public long mo35788e(int downloadId) throws RemoteException {
        return this.f33363b.mo35805d(downloadId);
    }

    /* renamed from: a */
    public byte mo35777a(int downloadId) throws RemoteException {
        return this.f33363b.mo35803c(downloadId);
    }

    /* renamed from: D */
    public boolean mo35776D() throws RemoteException {
        return this.f33363b.mo35802b();
    }

    /* renamed from: a */
    public void mo35779a(int id, Notification notification) throws RemoteException {
        WeakReference<FileDownloadService> weakReference = this.f33364c;
        if (weakReference != null && weakReference.get() != null) {
            ((FileDownloadService) this.f33364c.get()).startForeground(id, notification);
        }
    }

    /* renamed from: a */
    public void mo35783a(boolean removeNotification) throws RemoteException {
        WeakReference<FileDownloadService> weakReference = this.f33364c;
        if (weakReference != null && weakReference.get() != null) {
            ((FileDownloadService) this.f33364c.get()).stopForeground(removeNotification);
        }
    }

    /* renamed from: c */
    public boolean mo35787c(int id) throws RemoteException {
        return this.f33363b.mo35798a(id);
    }

    /* renamed from: z */
    public void mo35793z() throws RemoteException {
        this.f33363b.mo35796a();
    }

    /* renamed from: a */
    public void mo35780a(Intent intent, int flags, int startId) {
    }

    /* renamed from: a */
    public IBinder mo35778a(Intent intent) {
        return this;
    }

    public void onDestroy() {
        C10904d.m35756a().mo35706a((C10906b) null);
    }

    /* renamed from: a */
    public void mo35707a(MessageSnapshot snapShot) {
        m35833b(snapShot);
    }
}
