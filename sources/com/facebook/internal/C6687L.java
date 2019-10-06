package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

/* renamed from: com.facebook.internal.L */
/* compiled from: PlatformServiceClient */
public abstract class C6687L implements ServiceConnection {

    /* renamed from: a */
    private final Context f12201a;

    /* renamed from: b */
    private final Handler f12202b;

    /* renamed from: c */
    private C6688a f12203c;

    /* renamed from: d */
    private boolean f12204d;

    /* renamed from: e */
    private Messenger f12205e;

    /* renamed from: f */
    private int f12206f;

    /* renamed from: g */
    private int f12207g;

    /* renamed from: h */
    private final String f12208h;

    /* renamed from: i */
    private final int f12209i;

    /* renamed from: com.facebook.internal.L$a */
    /* compiled from: PlatformServiceClient */
    public interface C6688a {
        /* renamed from: a */
        void mo19905a(Bundle bundle);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo19899a(Bundle bundle);

    public C6687L(Context context, int requestMessage, int replyMessage, int protocolVersion, String applicationId) {
        Context applicationContext = context.getApplicationContext();
        this.f12201a = applicationContext != null ? applicationContext : context;
        this.f12206f = requestMessage;
        this.f12207g = replyMessage;
        this.f12208h = applicationId;
        this.f12209i = protocolVersion;
        this.f12202b = new C6686K(this);
    }

    /* renamed from: a */
    public void mo19901a(C6688a listener) {
        this.f12203c = listener;
    }

    /* renamed from: b */
    public boolean mo19902b() {
        if (this.f12204d || C6678J.m13333a(this.f12209i) == -1) {
            return false;
        }
        Intent intent = C6678J.m13335a(this.f12201a);
        if (intent == null) {
            return false;
        }
        this.f12204d = true;
        this.f12201a.bindService(intent, this, 1);
        return true;
    }

    /* renamed from: a */
    public void mo19898a() {
        this.f12204d = false;
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        this.f12205e = new Messenger(service);
        m13378c();
    }

    public void onServiceDisconnected(ComponentName name) {
        this.f12205e = null;
        try {
            this.f12201a.unbindService(this);
        } catch (IllegalArgumentException e) {
        }
        m13377b(null);
    }

    /* renamed from: c */
    private void m13378c() {
        Bundle data = new Bundle();
        data.putString("com.facebook.platform.extra.APPLICATION_ID", this.f12208h);
        mo19899a(data);
        Message request = Message.obtain(null, this.f12206f);
        request.arg1 = this.f12209i;
        request.setData(data);
        request.replyTo = new Messenger(this.f12202b);
        try {
            this.f12205e.send(request);
        } catch (RemoteException e) {
            m13377b(null);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo19900a(Message message) {
        if (message.what == this.f12207g) {
            Bundle extras = message.getData();
            if (extras.getString("com.facebook.platform.status.ERROR_TYPE") != null) {
                m13377b(null);
            } else {
                m13377b(extras);
            }
            try {
                this.f12201a.unbindService(this);
            } catch (IllegalArgumentException e) {
            }
        }
    }

    /* renamed from: b */
    private void m13377b(Bundle result) {
        if (this.f12204d) {
            this.f12204d = false;
            C6688a callback = this.f12203c;
            if (callback != null) {
                callback.mo19905a(result);
            }
        }
    }
}
