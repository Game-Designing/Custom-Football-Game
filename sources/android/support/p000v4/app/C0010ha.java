package android.support.p000v4.app;

import android.app.Activity;
import android.arch.lifecycle.C0001f;
import android.arch.lifecycle.C0148d;
import android.arch.lifecycle.C0148d.C0149b;
import android.arch.lifecycle.C0152h;
import android.arch.lifecycle.C0160p;
import android.os.Bundle;
import p002b.p003c.p053g.p061f.C1273q;

/* renamed from: android.support.v4.app.ha */
/* compiled from: SupportActivity */
public class C0010ha extends Activity implements C0001f {
    private C1273q<Class<? extends C0011a>, C0011a> mExtraDataMap = new C1273q<>();
    private C0152h mLifecycleRegistry = new C0152h(this);

    /* renamed from: android.support.v4.app.ha$a */
    /* compiled from: SupportActivity */
    public static class C0011a {
    }

    public void putExtraData(C0011a extraData) {
        this.mExtraDataMap.put(extraData.getClass(), extraData);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        C0160p.m869a((Activity) this);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle outState) {
        this.mLifecycleRegistry.mo3754a(C0149b.CREATED);
        super.onSaveInstanceState(outState);
    }

    public <T extends C0011a> T getExtraData(Class<T> extraDataClass) {
        return (C0011a) this.mExtraDataMap.get(extraDataClass);
    }

    public C0148d getLifecycle() {
        return this.mLifecycleRegistry;
    }
}
