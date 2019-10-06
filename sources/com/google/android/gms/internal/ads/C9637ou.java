package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* renamed from: com.google.android.gms.internal.ads.ou */
abstract class C9637ou<T> {

    /* renamed from: a */
    private static final zzzv f22855a = m24006c();

    C9637ou() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract T mo28933a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract T mo28934a(zzzv zzzv) throws RemoteException;

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract T mo28935b() throws RemoteException;

    /* renamed from: c */
    private static zzzv m24006c() {
        try {
            Object newInstance = zzyh.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi2").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!(newInstance instanceof IBinder)) {
                zzbad.m26359d("ClientApi class is not an instance of IBinder.");
                return null;
            }
            IBinder iBinder = (IBinder) newInstance;
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
            if (queryLocalInterface instanceof zzzv) {
                return (zzzv) queryLocalInterface;
            }
            return new zzzx(iBinder);
        } catch (Exception e) {
            zzbad.m26359d("Failed to instantiate ClientApi class.");
            return null;
        }
    }

    /* renamed from: d */
    private final T m24007d() {
        zzzv zzzv = f22855a;
        if (zzzv == null) {
            zzbad.m26359d("ClientApi class cannot be loaded.");
            return null;
        }
        try {
            return mo28934a(zzzv);
        } catch (RemoteException e) {
            zzbad.m26358c("Cannot invoke local loader using ClientApi class.", e);
            return null;
        }
    }

    /* renamed from: e */
    private final T m24008e() {
        try {
            return mo28935b();
        } catch (RemoteException e) {
            zzbad.m26358c("Cannot invoke remote loader.", e);
            return null;
        }
    }

    /* renamed from: a */
    public final T mo29114a(Context context, boolean z) {
        T t;
        boolean z2 = true;
        if (!z) {
            zzyt.m31532a();
            if (!zzazt.m26318c(context, 12451000)) {
                zzbad.m26352a("Google Play Services is not available.");
                z = true;
            }
        }
        String str = ModuleDescriptor.MODULE_ID;
        if (DynamiteModule.m22213a(context, str) > DynamiteModule.m22219b(context, str)) {
            z = true;
        }
        zzacu.m24782a(context);
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24026Vd)).booleanValue()) {
            z = false;
        }
        if (z) {
            t = m24007d();
            if (t == null) {
                t = m24008e();
            }
        } else {
            T e = m24008e();
            int i = e == null ? 1 : 0;
            if (i != 0) {
                if (zzyt.m31539h().nextInt(((Integer) zzyt.m31536e().mo29599a(zzacu.f24021Ue)).intValue()) != 0) {
                    z2 = false;
                }
                if (z2) {
                    Bundle bundle = new Bundle();
                    bundle.putString("action", "dynamite_load");
                    bundle.putInt("is_missing", i);
                    zzyt.m31532a().mo30312a(context, zzyt.m31538g().f25057a, "gmob-apps", bundle, true);
                }
            }
            if (e == null) {
                t = m24007d();
            } else {
                t = e;
            }
        }
        if (t == null) {
            return mo28933a();
        }
        return t;
    }
}
