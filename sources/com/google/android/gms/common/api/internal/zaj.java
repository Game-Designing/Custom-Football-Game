package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zaj extends zal {

    /* renamed from: f */
    private final SparseArray<C8687a> f19896f = new SparseArray<>();

    /* renamed from: com.google.android.gms.common.api.internal.zaj$a */
    private class C8687a implements OnConnectionFailedListener {

        /* renamed from: a */
        public final int f19897a;

        /* renamed from: b */
        public final GoogleApiClient f19898b;

        /* renamed from: c */
        public final OnConnectionFailedListener f19899c;

        public C8687a(int i, GoogleApiClient googleApiClient, OnConnectionFailedListener onConnectionFailedListener) {
            this.f19897a = i;
            this.f19898b = googleApiClient;
            this.f19899c = onConnectionFailedListener;
            googleApiClient.mo27378a((OnConnectionFailedListener) this);
        }

        public final void onConnectionFailed(ConnectionResult connectionResult) {
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("beginFailureResolution for ");
            sb.append(valueOf);
            Log.d("AutoManageHelper", sb.toString());
            zaj.this.mo27631b(connectionResult, this.f19897a);
        }
    }

    /* renamed from: b */
    public static zaj m21619b(LifecycleActivity lifecycleActivity) {
        LifecycleFragment a = LifecycleCallback.m21320a(lifecycleActivity);
        zaj zaj = (zaj) a.mo27523a("AutoManageHelper", zaj.class);
        if (zaj != null) {
            return zaj;
        }
        return new zaj(a);
    }

    private zaj(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.f19696a.mo27524a("AutoManageHelper", (LifecycleCallback) this);
    }

    /* renamed from: a */
    public final void mo27627a(int i, GoogleApiClient googleApiClient, OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.m21858a(googleApiClient, (Object) "GoogleApiClient instance cannot be null");
        boolean z = this.f19896f.indexOfKey(i) < 0;
        StringBuilder sb = new StringBuilder(54);
        sb.append("Already managing a GoogleApiClient with id ");
        sb.append(i);
        Preconditions.m21868b(z, sb.toString());
        C8649N n = (C8649N) this.f19907c.get();
        boolean z2 = this.f19906b;
        String valueOf = String.valueOf(n);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 49);
        sb2.append("starting AutoManage for client ");
        sb2.append(i);
        String str = " ";
        sb2.append(str);
        sb2.append(z2);
        sb2.append(str);
        sb2.append(valueOf);
        String str2 = "AutoManageHelper";
        Log.d(str2, sb2.toString());
        this.f19896f.put(i, new C8687a(i, googleApiClient, onConnectionFailedListener));
        if (this.f19906b && n == null) {
            String valueOf2 = String.valueOf(googleApiClient);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 11);
            sb3.append("connecting ");
            sb3.append(valueOf2);
            Log.d(str2, sb3.toString());
            googleApiClient.mo27385c();
        }
    }

    /* renamed from: a */
    public final void mo27626a(int i) {
        C8687a aVar = (C8687a) this.f19896f.get(i);
        this.f19896f.remove(i);
        if (aVar != null) {
            aVar.f19898b.mo27384b((OnConnectionFailedListener) aVar);
            aVar.f19898b.mo27386d();
        }
    }

    /* renamed from: d */
    public void mo27520d() {
        super.mo27520d();
        boolean z = this.f19906b;
        String valueOf = String.valueOf(this.f19896f);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14);
        sb.append("onStart ");
        sb.append(z);
        sb.append(" ");
        sb.append(valueOf);
        Log.d("AutoManageHelper", sb.toString());
        if (this.f19907c.get() == null) {
            for (int i = 0; i < this.f19896f.size(); i++) {
                C8687a b = m21618b(i);
                if (b != null) {
                    b.f19898b.mo27385c();
                }
            }
        }
    }

    /* renamed from: e */
    public void mo27521e() {
        super.mo27521e();
        for (int i = 0; i < this.f19896f.size(); i++) {
            C8687a b = m21618b(i);
            if (b != null) {
                b.f19898b.mo27386d();
            }
        }
    }

    /* renamed from: a */
    public void mo27516a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i = 0; i < this.f19896f.size(); i++) {
            C8687a b = m21618b(i);
            if (b != null) {
                printWriter.append(str).append("GoogleApiClient #").print(b.f19897a);
                printWriter.println(":");
                b.f19898b.mo27380a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo27586a(ConnectionResult connectionResult, int i) {
        String str = "AutoManageHelper";
        Log.w(str, "Unresolved error while connecting client. Stopping auto-manage.");
        if (i < 0) {
            Log.wtf(str, "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        C8687a aVar = (C8687a) this.f19896f.get(i);
        if (aVar != null) {
            mo27626a(i);
            OnConnectionFailedListener onConnectionFailedListener = aVar.f19899c;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public final void mo27587f() {
        for (int i = 0; i < this.f19896f.size(); i++) {
            C8687a b = m21618b(i);
            if (b != null) {
                b.f19898b.mo27385c();
            }
        }
    }

    /* renamed from: b */
    private final C8687a m21618b(int i) {
        if (this.f19896f.size() <= i) {
            return null;
        }
        SparseArray<C8687a> sparseArray = this.f19896f;
        return (C8687a) sparseArray.get(sparseArray.keyAt(i));
    }
}
