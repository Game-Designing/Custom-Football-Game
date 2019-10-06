package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;

public class zzcoj extends zzamw {

    /* renamed from: b */
    private final zzbri f27116b;

    /* renamed from: c */
    private final zzbrt f27117c;

    /* renamed from: d */
    private final zzbse f27118d;

    /* renamed from: e */
    private final zzbso f27119e;

    /* renamed from: f */
    private final zzbtp f27120f;

    /* renamed from: g */
    private final zzbsv f27121g;

    /* renamed from: h */
    private final zzbvq f27122h;

    public zzcoj(zzbri zzbri, zzbrt zzbrt, zzbse zzbse, zzbso zzbso, zzbtp zzbtp, zzbsv zzbsv, zzbvq zzbvq) {
        this.f27116b = zzbri;
        this.f27117c = zzbrt;
        this.f27118d = zzbse;
        this.f27119e = zzbso;
        this.f27120f = zzbtp;
        this.f27121g = zzbsv;
        this.f27122h = zzbvq;
    }

    public final void onAdClicked() {
        this.f27116b.onAdClicked();
    }

    public final void onAdClosed() {
        this.f27121g.zzsz();
    }

    public final void onAdLeftApplication() {
        this.f27118d.mo30883H();
    }

    public final void onAdOpened() {
        this.f27121g.zzta();
    }

    public final void onAppEvent(String str, String str2) {
        this.f27120f.onAppEvent(str, str2);
    }

    public final void onAdLoaded() {
        this.f27119e.onAdLoaded();
    }

    public final void onAdImpression() {
        this.f27117c.mo30877G();
    }

    public final void onVideoPause() {
        this.f27122h.mo30928H();
    }

    /* renamed from: N */
    public void mo29868N() {
        this.f27122h.mo30930J();
    }

    /* renamed from: M */
    public void mo29867M() {
        this.f27122h.mo30927G();
    }

    public final void onVideoPlay() throws RemoteException {
        this.f27122h.mo30929I();
    }

    /* renamed from: a */
    public final void mo29869a(zzafe zzafe, String str) {
    }

    public final void onAdFailedToLoad(int i) {
    }

    /* renamed from: a */
    public final void mo29870a(zzamy zzamy) {
    }

    /* renamed from: r */
    public final void mo29884r(String str) {
    }

    /* renamed from: a */
    public void mo29871a(zzato zzato) {
    }

    /* renamed from: a */
    public void mo29872a(zzatq zzatq) throws RemoteException {
    }

    /* renamed from: d */
    public void mo29873d(int i) throws RemoteException {
    }

    /* renamed from: wa */
    public void mo29885wa() throws RemoteException {
    }

    public void zzb(Bundle bundle) throws RemoteException {
    }
}
