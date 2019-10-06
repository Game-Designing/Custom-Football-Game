package com.liulishuo.filedownloader.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import p019d.p307j.p308a.C13066A;
import p019d.p307j.p308a.C13124h;
import p019d.p307j.p308a.p310b.C13091c;
import p019d.p307j.p308a.p310b.C13091c.C13092a;
import p019d.p307j.p308a.p313e.C13117d;
import p019d.p307j.p308a.p313e.C13121g;

/* renamed from: com.liulishuo.filedownloader.services.a */
/* compiled from: BaseFileServiceUIGuard */
public abstract class C10914a<CALLBACK extends Binder, INTERFACE extends IInterface> implements C13066A, ServiceConnection {

    /* renamed from: a */
    private final CALLBACK f33349a;

    /* renamed from: b */
    private volatile INTERFACE f33350b;

    /* renamed from: c */
    private final Class<?> f33351c;

    /* renamed from: d */
    private final HashMap<String, Object> f33352d = new HashMap<>();

    /* renamed from: e */
    private final List<Context> f33353e = new ArrayList();

    /* renamed from: f */
    private final ArrayList<Runnable> f33354f = new ArrayList<>();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract CALLBACK mo35747a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract INTERFACE mo35748a(IBinder iBinder);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo35751a(INTERFACE interfaceR, CALLBACK callback) throws RemoteException;

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo35753b(INTERFACE interfaceR, CALLBACK callback) throws RemoteException;

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public INTERFACE mo35752b() {
        return this.f33350b;
    }

    protected C10914a(Class<?> serviceClass) {
        this.f33351c = serviceClass;
        this.f33349a = mo35747a();
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        this.f33350b = mo35748a(service);
        if (C13117d.f40139a) {
            C13117d.m42778a(this, "onServiceConnected %s %s", name, this.f33350b);
        }
        try {
            mo35751a(this.f33350b, this.f33349a);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        List<Runnable> runnableList = (List) this.f33354f.clone();
        this.f33354f.clear();
        for (Runnable runnable : runnableList) {
            runnable.run();
        }
        C13124h.m42817a().mo42064a(new C13091c(C13092a.connected, this.f33351c));
    }

    public void onServiceDisconnected(ComponentName name) {
        if (C13117d.f40139a) {
            C13117d.m42778a(this, "onServiceDisconnected %s %s", name, this.f33350b);
        }
        m35802a(true);
    }

    /* renamed from: a */
    private void m35802a(boolean isLost) {
        if (!isLost && this.f33350b != null) {
            try {
                mo35753b(this.f33350b, this.f33349a);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        if (C13117d.f40139a) {
            C13117d.m42778a(this, "release connect resources %s", this.f33350b);
        }
        this.f33350b = null;
        C13124h.m42817a().mo42064a(new C13091c(isLost ? C13092a.lost : C13092a.disconnected, this.f33351c));
    }

    /* renamed from: a */
    public void mo35749a(Context context) {
        mo35750a(context, (Runnable) null);
    }

    /* renamed from: a */
    public void mo35750a(Context context, Runnable connectedRunnable) {
        if (!C13121g.m42799b(context)) {
            if (C13117d.f40139a) {
                C13117d.m42778a(this, "bindStartByContext %s", context.getClass().getSimpleName());
            }
            Intent i = new Intent(context, this.f33351c);
            if (connectedRunnable != null && !this.f33354f.contains(connectedRunnable)) {
                this.f33354f.add(connectedRunnable);
            }
            if (!this.f33353e.contains(context)) {
                this.f33353e.add(context);
            }
            context.bindService(i, this, 1);
            context.startService(i);
            return;
        }
        throw new IllegalStateException("Fatal-Exception: You can't bind the FileDownloadService in :filedownloader process.\n It's the invalid operation, and is likely to cause unexpected problems.\n Maybe you want to use non-separate process mode for FileDownloader, More detail about non-separate mode, please move to wiki manually: https://github.com/lingochamp/FileDownloader/wiki/filedownloader.properties");
    }

    public boolean isConnected() {
        return mo35752b() != null;
    }
}
