package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@zzard
public final class zzami extends zzbjg {

    /* renamed from: b */
    private static final AtomicBoolean f24426b = new AtomicBoolean(false);

    /* renamed from: c */
    private final AppMeasurementSdk f24427c;

    private zzami(AppMeasurementSdk appMeasurementSdk) {
        this.f24427c = appMeasurementSdk;
    }

    /* renamed from: a */
    public static void m25219a(Context context, String str) {
        if (f24426b.compareAndSet(false, true)) {
            new Thread(new C9096Ra(context, str)).start();
        }
    }

    /* renamed from: e */
    public final void mo29826e(Bundle bundle) throws RemoteException {
        this.f24427c.mo33104a(bundle);
    }

    /* renamed from: g */
    public final Bundle mo29828g(Bundle bundle) throws RemoteException {
        return this.f24427c.mo33108b(bundle);
    }

    /* renamed from: a */
    public final void mo29821a(String str, String str2, Bundle bundle) throws RemoteException {
        this.f24427c.mo33111b(str, str2, bundle);
    }

    /* renamed from: a */
    public final void mo29822a(String str, String str2, IObjectWrapper iObjectWrapper) throws RemoteException {
        this.f24427c.mo33107a(str, str2, iObjectWrapper != null ? ObjectWrapper.m22187H(iObjectWrapper) : null);
    }

    /* renamed from: a */
    public final Map mo29820a(String str, String str2, boolean z) throws RemoteException {
        return this.f24427c.mo33102a(str, str2, z);
    }

    /* renamed from: s */
    public final int mo29832s(String str) throws RemoteException {
        return this.f24427c.mo33112c(str);
    }

    /* renamed from: f */
    public final void mo29827f(Bundle bundle) throws RemoteException {
        this.f24427c.mo33114c(bundle);
    }

    /* renamed from: b */
    public final void mo29824b(String str, String str2, Bundle bundle) throws RemoteException {
        this.f24427c.mo33106a(str, str2, bundle);
    }

    /* renamed from: c */
    public final List mo29825c(String str, String str2) throws RemoteException {
        return this.f24427c.mo33101a(str, str2);
    }

    /* renamed from: W */
    public final String mo29818W() throws RemoteException {
        return this.f24427c.mo33113c();
    }

    /* renamed from: ja */
    public final String mo29830ja() throws RemoteException {
        return this.f24427c.mo33117f();
    }

    /* renamed from: Ia */
    public final long mo29815Ia() throws RemoteException {
        return this.f24427c.mo33100a();
    }

    /* renamed from: i */
    public final void mo29829i(String str) throws RemoteException {
        this.f24427c.mo33105a(str);
    }

    /* renamed from: l */
    public final void mo29831l(String str) throws RemoteException {
        this.f24427c.mo33110b(str);
    }

    /* renamed from: b */
    public final void mo29823b(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        this.f24427c.mo33103a(iObjectWrapper != null ? (Activity) ObjectWrapper.m22187H(iObjectWrapper) : null, str, str2);
    }

    /* renamed from: Z */
    public final String mo29819Z() throws RemoteException {
        return this.f24427c.mo33116e();
    }

    /* renamed from: Ua */
    public final String mo29817Ua() throws RemoteException {
        return this.f24427c.mo33115d();
    }

    /* renamed from: La */
    public final String mo29816La() throws RemoteException {
        return this.f24427c.mo33109b();
    }

    /* renamed from: b */
    static final /* synthetic */ void m25220b(Context context, String str) {
        boolean z;
        zzacu.m24782a(context);
        if (!((Boolean) zzyt.m31536e().mo29599a(zzacu.f23939Ha)).booleanValue()) {
            if (!((Boolean) zzyt.m31536e().mo29599a(zzacu.f23933Ga)).booleanValue()) {
                z = false;
                Bundle bundle = new Bundle();
                bundle.putBoolean("measurementEnabled", z);
                ((zzbjh) zzbae.m26364a(context, "com.google.android.gms.ads.measurement.DynamiteMeasurementManager", C9117Sa.f21687a)).mo30689a(new zzami(AppMeasurementSdk.m32696a(context, "Ads", "am", str, bundle)));
            }
        }
        z = true;
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("measurementEnabled", z);
        try {
            ((zzbjh) zzbae.m26364a(context, "com.google.android.gms.ads.measurement.DynamiteMeasurementManager", C9117Sa.f21687a)).mo30689a(new zzami(AppMeasurementSdk.m32696a(context, "Ads", "am", str, bundle2)));
        } catch (RemoteException | zzbag | NullPointerException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }
}
