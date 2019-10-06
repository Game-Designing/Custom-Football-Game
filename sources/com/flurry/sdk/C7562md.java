package com.flurry.sdk;

import android.content.Context;
import com.flurry.sdk.C7531hd.C7532a;
import com.flurry.sdk.C7537id.C7538a;
import java.lang.ref.WeakReference;

/* renamed from: com.flurry.sdk.md */
class C7562md extends C7364Cd {

    /* renamed from: d */
    final /* synthetic */ C7531hd f14949d;

    /* renamed from: e */
    final /* synthetic */ Context f14950e;

    /* renamed from: f */
    final /* synthetic */ C7585qd f14951f;

    C7562md(C7585qd qdVar, C7531hd hdVar, Context context) {
        this.f14951f = qdVar;
        this.f14949d = hdVar;
        this.f14950e = context;
    }

    /* renamed from: a */
    public final void mo23803a() {
        this.f14949d.mo23959a(C7532a.f14873c);
        C7537id idVar = new C7537id();
        idVar.f14883b = new WeakReference<>(this.f14950e);
        idVar.f14884c = this.f14949d;
        idVar.f14885d = C7538a.f14891e;
        idVar.mo23885b();
    }
}
