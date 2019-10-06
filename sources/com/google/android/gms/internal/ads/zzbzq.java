package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class zzbzq implements OnClickListener {

    /* renamed from: a */
    private final zzccj f26210a;

    /* renamed from: b */
    private final Clock f26211b;

    /* renamed from: c */
    private zzagd f26212c;

    /* renamed from: d */
    private zzaho f26213d;

    /* renamed from: e */
    String f26214e;

    /* renamed from: f */
    Long f26215f;

    /* renamed from: g */
    WeakReference<View> f26216g;

    public zzbzq(zzccj zzccj, Clock clock) {
        this.f26210a = zzccj;
        this.f26211b = clock;
    }

    /* renamed from: a */
    public final void mo31073a(zzagd zzagd) {
        this.f26212c = zzagd;
        zzaho zzaho = this.f26213d;
        String str = "/unconfirmedClick";
        if (zzaho != null) {
            this.f26210a.mo31118b(str, zzaho);
        }
        this.f26213d = new C9793wh(this, zzagd);
        this.f26210a.mo31114a(str, this.f26213d);
    }

    /* renamed from: i */
    public final zzagd mo31075i() {
        return this.f26212c;
    }

    /* renamed from: h */
    public final void mo31074h() {
        if (this.f26212c != null && this.f26215f != null) {
            m28127j();
            try {
                this.f26212c.onUnconfirmedClickCancelled();
            } catch (RemoteException e) {
                zzbad.m26360d("#007 Could not call remote method.", e);
            }
        }
    }

    public final void onClick(View view) {
        WeakReference<View> weakReference = this.f26216g;
        if (weakReference != null && weakReference.get() == view) {
            if (!(this.f26214e == null || this.f26215f == null)) {
                HashMap hashMap = new HashMap();
                hashMap.put("id", this.f26214e);
                hashMap.put("time_interval", String.valueOf(this.f26211b.mo27935b() - this.f26215f.longValue()));
                hashMap.put("messageType", "onePointFiveClick");
                this.f26210a.mo31115a("sendMessageToNativeJs", (Map<String, ?>) hashMap);
            }
            m28127j();
        }
    }

    /* renamed from: j */
    private final void m28127j() {
        this.f26214e = null;
        this.f26215f = null;
        WeakReference<View> weakReference = this.f26216g;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (view != null) {
                view.setClickable(false);
                view.setOnClickListener(null);
                this.f26216g = null;
            }
        }
    }
}
