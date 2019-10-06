package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* renamed from: com.google.android.gms.internal.measurement.n */
final class C9990n extends C10018b {

    /* renamed from: e */
    private final /* synthetic */ int f30140e = 5;

    /* renamed from: f */
    private final /* synthetic */ String f30141f;

    /* renamed from: g */
    private final /* synthetic */ Object f30142g;

    /* renamed from: h */
    private final /* synthetic */ Object f30143h;

    /* renamed from: i */
    private final /* synthetic */ Object f30144i;

    /* renamed from: j */
    private final /* synthetic */ zzea f30145j;

    C9990n(zzea zzea, boolean z, int i, String str, Object obj, Object obj2, Object obj3) {
        this.f30145j = zzea;
        this.f30141f = str;
        this.f30142g = obj;
        this.f30143h = obj2;
        this.f30144i = obj3;
        super(false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo32712a() throws RemoteException {
        this.f30145j.f30232j.mo32756a(this.f30140e, this.f30141f, ObjectWrapper.m22188a(this.f30142g), ObjectWrapper.m22188a(this.f30143h), ObjectWrapper.m22188a(this.f30144i));
    }
}
