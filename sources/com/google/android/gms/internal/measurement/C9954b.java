package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.measurement.b */
final class C9954b extends C10018b {

    /* renamed from: e */
    private final /* synthetic */ Context f30079e;

    /* renamed from: f */
    private final /* synthetic */ String f30080f;

    /* renamed from: g */
    private final /* synthetic */ String f30081g;

    /* renamed from: h */
    private final /* synthetic */ Bundle f30082h;

    /* renamed from: i */
    private final /* synthetic */ zzea f30083i;

    C9954b(zzea zzea, Context context, String str, String str2, Bundle bundle) {
        this.f30083i = zzea;
        this.f30079e = context;
        this.f30080f = str;
        this.f30081g = str2;
        this.f30082h = bundle;
        super(zzea);
    }

    /* renamed from: a */
    public final void mo32712a() {
        String str;
        String str2;
        String str3;
        try {
            this.f30083i.f30228f = new HashMap();
            this.f30083i.f30232j = this.f30083i.mo32803a(this.f30079e);
            if (this.f30083i.f30232j == null) {
                Log.w(this.f30083i.f30224b, "Failed to connect to measurement client.");
                return;
            }
            if (zzea.m32339b(this.f30080f, this.f30081g)) {
                String str4 = this.f30081g;
                str2 = this.f30080f;
                str = str4;
                str3 = this.f30083i.f30224b;
            } else {
                str3 = null;
                str2 = null;
                str = null;
            }
            int b = zzea.m32344f(this.f30079e);
            int c = zzea.m32343e(this.f30079e);
            zzdy zzdy = new zzdy(13001, (long) Math.max(b, c), c < b, str3, str2, str, this.f30082h);
            this.f30083i.f30232j.mo32763a(ObjectWrapper.m22188a(this.f30079e), zzdy, this.f30236a);
        } catch (RemoteException e) {
            this.f30083i.m32333a((Exception) e, true, false);
        }
    }
}
