package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.p000v4.app.C0014p;
import android.support.p000v4.app.C0424G;
import android.support.p000v4.app.Fragment;
import com.google.android.gms.internal.common.zze;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;
import p002b.p003c.p053g.p061f.C1253b;

public final class zzc extends Fragment implements LifecycleFragment {

    /* renamed from: a */
    private static WeakHashMap<C0014p, WeakReference<zzc>> f19939a = new WeakHashMap<>();

    /* renamed from: b */
    private Map<String, LifecycleCallback> f19940b = new C1253b();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f19941c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Bundle f19942d;

    /* renamed from: a */
    public static zzc m21686a(C0014p pVar) {
        String str = "SupportLifecycleFragmentImpl";
        WeakReference weakReference = (WeakReference) f19939a.get(pVar);
        if (weakReference != null) {
            zzc zzc = (zzc) weakReference.get();
            if (zzc != null) {
                return zzc;
            }
        }
        try {
            zzc zzc2 = (zzc) pVar.getSupportFragmentManager().mo4908a(str);
            if (zzc2 == null || zzc2.isRemoving()) {
                zzc2 = new zzc();
                C0424G a = pVar.getSupportFragmentManager().mo4909a();
                a.mo5037a((Fragment) zzc2, str);
                a.mo5039b();
            }
            f19939a.put(pVar, new WeakReference(zzc2));
            return zzc2;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e);
        }
    }

    /* renamed from: a */
    public final <T extends LifecycleCallback> T mo27523a(String str, Class<T> cls) {
        return (LifecycleCallback) cls.cast(this.f19940b.get(str));
    }

    /* renamed from: a */
    public final void mo27524a(String str, LifecycleCallback lifecycleCallback) {
        if (!this.f19940b.containsKey(str)) {
            this.f19940b.put(str, lifecycleCallback);
            if (this.f19941c > 0) {
                new zze(Looper.getMainLooper()).post(new C8660Z(this, lifecycleCallback, str));
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59);
        sb.append("LifecycleCallback with tag ");
        sb.append(str);
        sb.append(" already added to this fragment.");
        throw new IllegalArgumentException(sb.toString());
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f19941c = 1;
        this.f19942d = bundle;
        for (Entry entry : this.f19940b.entrySet()) {
            ((LifecycleCallback) entry.getValue()).mo27515a(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public final void onStart() {
        super.onStart();
        this.f19941c = 2;
        for (LifecycleCallback d : this.f19940b.values()) {
            d.mo27520d();
        }
    }

    public final void onResume() {
        super.onResume();
        this.f19941c = 3;
        for (LifecycleCallback c : this.f19940b.values()) {
            c.mo27519c();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (LifecycleCallback a : this.f19940b.values()) {
            a.mo27514a(i, i2, intent);
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Entry entry : this.f19940b.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) entry.getValue()).mo27518b(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public final void onStop() {
        super.onStop();
        this.f19941c = 4;
        for (LifecycleCallback e : this.f19940b.values()) {
            e.mo27521e();
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f19941c = 5;
        for (LifecycleCallback b : this.f19940b.values()) {
            b.mo27517b();
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback a : this.f19940b.values()) {
            a.mo27516a(str, fileDescriptor, printWriter, strArr);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ Activity mo27522a() {
        return getActivity();
    }
}
