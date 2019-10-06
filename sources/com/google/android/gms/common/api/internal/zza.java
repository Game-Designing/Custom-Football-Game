package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.internal.common.zze;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;
import p002b.p003c.p053g.p061f.C1253b;

public final class zza extends Fragment implements LifecycleFragment {

    /* renamed from: a */
    private static WeakHashMap<Activity, WeakReference<zza>> f19935a = new WeakHashMap<>();

    /* renamed from: b */
    private Map<String, LifecycleCallback> f19936b = new C1253b();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f19937c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Bundle f19938d;

    /* renamed from: a */
    public static zza m21680a(Activity activity) {
        String str = "LifecycleFragmentImpl";
        WeakReference weakReference = (WeakReference) f19935a.get(activity);
        if (weakReference != null) {
            zza zza = (zza) weakReference.get();
            if (zza != null) {
                return zza;
            }
        }
        try {
            zza zza2 = (zza) activity.getFragmentManager().findFragmentByTag(str);
            if (zza2 == null || zza2.isRemoving()) {
                zza2 = new zza();
                activity.getFragmentManager().beginTransaction().add(zza2, str).commitAllowingStateLoss();
            }
            f19935a.put(activity, new WeakReference(zza2));
            return zza2;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e);
        }
    }

    /* renamed from: a */
    public final <T extends LifecycleCallback> T mo27523a(String str, Class<T> cls) {
        return (LifecycleCallback) cls.cast(this.f19936b.get(str));
    }

    /* renamed from: a */
    public final void mo27524a(String str, LifecycleCallback lifecycleCallback) {
        if (!this.f19936b.containsKey(str)) {
            this.f19936b.put(str, lifecycleCallback);
            if (this.f19937c > 0) {
                new zze(Looper.getMainLooper()).post(new C8659Y(this, lifecycleCallback, str));
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

    /* renamed from: a */
    public final Activity mo27522a() {
        return getActivity();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f19937c = 1;
        this.f19938d = bundle;
        for (Entry entry : this.f19936b.entrySet()) {
            ((LifecycleCallback) entry.getValue()).mo27515a(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public final void onStart() {
        super.onStart();
        this.f19937c = 2;
        for (LifecycleCallback d : this.f19936b.values()) {
            d.mo27520d();
        }
    }

    public final void onResume() {
        super.onResume();
        this.f19937c = 3;
        for (LifecycleCallback c : this.f19936b.values()) {
            c.mo27519c();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (LifecycleCallback a : this.f19936b.values()) {
            a.mo27514a(i, i2, intent);
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Entry entry : this.f19936b.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) entry.getValue()).mo27518b(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public final void onStop() {
        super.onStop();
        this.f19937c = 4;
        for (LifecycleCallback e : this.f19936b.values()) {
            e.mo27521e();
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f19937c = 5;
        for (LifecycleCallback b : this.f19936b.values()) {
            b.mo27517b();
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback a : this.f19936b.values()) {
            a.mo27516a(str, fileDescriptor, printWriter, strArr);
        }
    }
}
