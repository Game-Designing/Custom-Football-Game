package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.reward.mediation.InitializableMediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.mopub.common.AdType;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
public final class zzanl extends zzamt {

    /* renamed from: b */
    private final Object f24489b;

    /* renamed from: c */
    private zzano f24490c;

    /* renamed from: d */
    private zzatk f24491d;

    /* renamed from: e */
    private IObjectWrapper f24492e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public MediationRewardedAd f24493f;

    public zzanl(MediationAdapter mediationAdapter) {
        this.f24489b = mediationAdapter;
    }

    public zzanl(Adapter adapter) {
        this.f24489b = adapter;
    }

    /* renamed from: Ca */
    public final IObjectWrapper mo29837Ca() throws RemoteException {
        Object obj = this.f24489b;
        if (obj instanceof MediationBannerAdapter) {
            try {
                return ObjectWrapper.m22188a(((MediationBannerAdapter) obj).getBannerView());
            } catch (Throwable th) {
                zzbad.m26356b("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = this.f24489b.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.m26359d(sb.toString());
            throw new RemoteException();
        }
    }

    /* renamed from: a */
    public final void mo29847a(IObjectWrapper iObjectWrapper, zzyd zzyd, zzxz zzxz, String str, zzamv zzamv) throws RemoteException {
        mo29848a(iObjectWrapper, zzyd, zzxz, str, null, zzamv);
    }

    /* renamed from: a */
    public final void mo29848a(IObjectWrapper iObjectWrapper, zzyd zzyd, zzxz zzxz, String str, String str2, zzamv zzamv) throws RemoteException {
        Date date;
        Bundle bundle;
        zzyd zzyd2 = zzyd;
        zzxz zzxz2 = zzxz;
        String str3 = str;
        if (this.f24489b instanceof MediationBannerAdapter) {
            zzbad.m26352a("Requesting banner ad from adapter.");
            try {
                MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.f24489b;
                Set hashSet = zzxz2.f29727e != null ? new HashSet(zzxz2.f29727e) : null;
                if (zzxz2.f29724b == -1) {
                    date = null;
                } else {
                    date = new Date(zzxz2.f29724b);
                }
                zzank zzank = new zzank(date, zzxz2.f29726d, hashSet, zzxz2.f29733k, m25449c(zzxz), zzxz2.f29729g, zzxz2.f29740r, zzxz2.f29742t, m25448a(str3, zzxz2));
                if (zzxz2.f29735m != null) {
                    bundle = zzxz2.f29735m.getBundle(mediationBannerAdapter.getClass().getName());
                } else {
                    bundle = null;
                }
                mediationBannerAdapter.requestBannerAd((Context) ObjectWrapper.m22187H(iObjectWrapper), new zzano(zzamv), m25446a(str3, zzxz2, str2), zzb.zza(zzyd2.f29772e, zzyd2.f29769b, zzyd2.f29768a), zzank, bundle);
            } catch (Throwable th) {
                zzbad.m26356b("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = this.f24489b.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.m26359d(sb.toString());
            throw new RemoteException();
        }
    }

    public final Bundle zzsh() {
        Object obj = this.f24489b;
        if (obj instanceof zzbjk) {
            return ((zzbjk) obj).zzsh();
        }
        String canonicalName = zzbjk.class.getCanonicalName();
        String canonicalName2 = this.f24489b.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzbad.m26359d(sb.toString());
        return new Bundle();
    }

    /* renamed from: b */
    public final void mo29851b(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, zzamv zzamv) throws RemoteException {
        mo29845a(iObjectWrapper, zzxz, str, (String) null, zzamv);
    }

    /* renamed from: a */
    public final void mo29845a(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, String str2, zzamv zzamv) throws RemoteException {
        Date date;
        Bundle bundle;
        zzxz zzxz2 = zzxz;
        String str3 = str;
        if (this.f24489b instanceof MediationInterstitialAdapter) {
            zzbad.m26352a("Requesting interstitial ad from adapter.");
            try {
                MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.f24489b;
                Set hashSet = zzxz2.f29727e != null ? new HashSet(zzxz2.f29727e) : null;
                if (zzxz2.f29724b == -1) {
                    date = null;
                } else {
                    date = new Date(zzxz2.f29724b);
                }
                zzank zzank = new zzank(date, zzxz2.f29726d, hashSet, zzxz2.f29733k, m25449c(zzxz), zzxz2.f29729g, zzxz2.f29740r, zzxz2.f29742t, m25448a(str3, zzxz2));
                if (zzxz2.f29735m != null) {
                    bundle = zzxz2.f29735m.getBundle(mediationInterstitialAdapter.getClass().getName());
                } else {
                    bundle = null;
                }
                mediationInterstitialAdapter.requestInterstitialAd((Context) ObjectWrapper.m22187H(iObjectWrapper), new zzano(zzamv), m25446a(str3, zzxz2, str2), zzank, bundle);
            } catch (Throwable th) {
                zzbad.m26356b("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = this.f24489b.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.m26359d(sb.toString());
            throw new RemoteException();
        }
    }

    public final Bundle getInterstitialAdapterInfo() {
        Object obj = this.f24489b;
        if (obj instanceof zzbjl) {
            return ((zzbjl) obj).getInterstitialAdapterInfo();
        }
        String canonicalName = zzbjl.class.getCanonicalName();
        String canonicalName2 = this.f24489b.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzbad.m26359d(sb.toString());
        return new Bundle();
    }

    /* renamed from: a */
    public final void mo29846a(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, String str2, zzamv zzamv, zzady zzady, List<String> list) throws RemoteException {
        Date date;
        zzxz zzxz2 = zzxz;
        String str3 = str;
        Object obj = this.f24489b;
        if (obj instanceof MediationNativeAdapter) {
            try {
                MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) obj;
                Bundle bundle = null;
                Set hashSet = zzxz2.f29727e != null ? new HashSet(zzxz2.f29727e) : null;
                if (zzxz2.f29724b == -1) {
                    date = null;
                } else {
                    date = new Date(zzxz2.f29724b);
                }
                zzans zzans = new zzans(date, zzxz2.f29726d, hashSet, zzxz2.f29733k, m25449c(zzxz), zzxz2.f29729g, zzady, list, zzxz2.f29740r, zzxz2.f29742t, m25448a(str3, zzxz2));
                if (zzxz2.f29735m != null) {
                    bundle = zzxz2.f29735m.getBundle(mediationNativeAdapter.getClass().getName());
                }
                this.f24490c = new zzano(zzamv);
                mediationNativeAdapter.requestNativeAd((Context) ObjectWrapper.m22187H(iObjectWrapper), this.f24490c, m25446a(str3, zzxz2, str2), zzans, bundle);
            } catch (Throwable th) {
                zzbad.m26356b("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationNativeAdapter.class.getCanonicalName();
            String canonicalName2 = this.f24489b.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.m26359d(sb.toString());
            throw new RemoteException();
        }
    }

    /* renamed from: Oa */
    public final Bundle mo29838Oa() {
        return new Bundle();
    }

    /* renamed from: eb */
    public final zzana mo29855eb() {
        NativeAdMapper a = this.f24490c.mo29952a();
        if (a instanceof NativeAppInstallAdMapper) {
            return new zzanq((NativeAppInstallAdMapper) a);
        }
        return null;
    }

    /* renamed from: S */
    public final zzang mo29839S() {
        UnifiedNativeAdMapper b = this.f24490c.mo29953b();
        if (b != null) {
            return new zzaoi(b);
        }
        return null;
    }

    /* renamed from: bb */
    public final zzand mo29852bb() {
        NativeAdMapper a = this.f24490c.mo29952a();
        if (a instanceof NativeContentAdMapper) {
            return new zzanr((NativeContentAdMapper) a);
        }
        return null;
    }

    /* renamed from: Y */
    public final zzafe mo29840Y() {
        NativeCustomTemplateAd c = this.f24490c.mo29954c();
        if (c instanceof zzafh) {
            return ((zzafh) c).mo29696a();
        }
        return null;
    }

    /* renamed from: da */
    public final boolean mo29853da() {
        return this.f24489b instanceof InitializableMediationRewardedVideoAdAdapter;
    }

    /* renamed from: a */
    public final void mo29844a(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, zzatk zzatk, String str2) throws RemoteException {
        Bundle bundle;
        zzank zzank;
        Date date;
        zzxz zzxz2 = zzxz;
        zzatk zzatk2 = zzatk;
        String str3 = str2;
        Object obj = this.f24489b;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzbad.m26352a("Initialize rewarded video adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.f24489b;
                Bundle a = m25446a(str3, zzxz2, (String) null);
                if (zzxz2 != null) {
                    Set hashSet = zzxz2.f29727e != null ? new HashSet(zzxz2.f29727e) : null;
                    if (zzxz2.f29724b == -1) {
                        date = null;
                    } else {
                        date = new Date(zzxz2.f29724b);
                    }
                    zzank zzank2 = new zzank(date, zzxz2.f29726d, hashSet, zzxz2.f29733k, m25449c(zzxz), zzxz2.f29729g, zzxz2.f29740r, zzxz2.f29742t, m25448a(str3, zzxz2));
                    if (zzxz2.f29735m != null) {
                        bundle = zzxz2.f29735m.getBundle(mediationRewardedVideoAdAdapter.getClass().getName());
                        zzank = zzank2;
                    } else {
                        bundle = null;
                        zzank = zzank2;
                    }
                } else {
                    zzank = null;
                    bundle = null;
                }
                mediationRewardedVideoAdAdapter.initialize((Context) ObjectWrapper.m22187H(iObjectWrapper), zzank, str, new zzatn(zzatk2), a, bundle);
            } catch (Throwable th) {
                zzbad.m26356b("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            this.f24492e = iObjectWrapper;
            this.f24491d = zzatk2;
            zzatk2.mo29307w(ObjectWrapper.m22188a(obj));
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.f24489b.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzbad.m26359d(sb.toString());
            throw new RemoteException();
        }
    }

    /* renamed from: a */
    public final void mo29842a(IObjectWrapper iObjectWrapper, zzatk zzatk, List<String> list) throws RemoteException {
        if (this.f24489b instanceof InitializableMediationRewardedVideoAdAdapter) {
            zzbad.m26352a("Initialize rewarded video adapter.");
            try {
                InitializableMediationRewardedVideoAdAdapter initializableMediationRewardedVideoAdAdapter = (InitializableMediationRewardedVideoAdAdapter) this.f24489b;
                ArrayList arrayList = new ArrayList();
                for (String a : list) {
                    arrayList.add(m25446a(a, (zzxz) null, (String) null));
                }
                initializableMediationRewardedVideoAdAdapter.initialize((Context) ObjectWrapper.m22187H(iObjectWrapper), new zzatn(zzatk), arrayList);
            } catch (Throwable th) {
                zzbad.m26358c("Could not initialize rewarded video adapter.", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = InitializableMediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = this.f24489b.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.m26359d(sb.toString());
            throw new RemoteException();
        }
    }

    /* renamed from: a */
    public final void mo29849a(zzxz zzxz, String str) throws RemoteException {
        mo29850a(zzxz, str, (String) null);
    }

    /* renamed from: a */
    public final void mo29850a(zzxz zzxz, String str, String str2) throws RemoteException {
        Date date;
        zzxz zzxz2 = zzxz;
        String str3 = str;
        Object obj = this.f24489b;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzbad.m26352a("Requesting rewarded video ad from adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.f24489b;
                Bundle bundle = null;
                Set hashSet = zzxz2.f29727e != null ? new HashSet(zzxz2.f29727e) : null;
                if (zzxz2.f29724b == -1) {
                    date = null;
                } else {
                    date = new Date(zzxz2.f29724b);
                }
                zzank zzank = new zzank(date, zzxz2.f29726d, hashSet, zzxz2.f29733k, m25449c(zzxz), zzxz2.f29729g, zzxz2.f29740r, zzxz2.f29742t, m25448a(str3, zzxz2));
                if (zzxz2.f29735m != null) {
                    bundle = zzxz2.f29735m.getBundle(mediationRewardedVideoAdAdapter.getClass().getName());
                }
                mediationRewardedVideoAdAdapter.loadAd(zzank, m25446a(str3, zzxz2, str2), bundle);
            } catch (Throwable th) {
                zzbad.m26356b("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            mo29843a(this.f24492e, zzxz2, str3, new zzanp((Adapter) obj, this.f24491d));
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.f24489b.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzbad.m26359d(sb.toString());
            throw new RemoteException();
        }
    }

    public final void showVideo() throws RemoteException {
        Object obj = this.f24489b;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzbad.m26352a("Show rewarded video ad from adapter.");
            try {
                ((MediationRewardedVideoAdAdapter) this.f24489b).showVideo();
            } catch (Throwable th) {
                zzbad.m26356b("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            MediationRewardedAd mediationRewardedAd = this.f24493f;
            if (mediationRewardedAd != null) {
                mediationRewardedAd.showAd((Context) ObjectWrapper.m22187H(this.f24492e));
            } else {
                zzbad.m26355b("Can not show null mediated rewarded ad.");
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.f24489b.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzbad.m26359d(sb.toString());
            throw new RemoteException();
        }
    }

    public final boolean isInitialized() throws RemoteException {
        Object obj = this.f24489b;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzbad.m26352a("Check if adapter is initialized.");
            try {
                return ((MediationRewardedVideoAdAdapter) this.f24489b).isInitialized();
            } catch (Throwable th) {
                zzbad.m26356b("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            return this.f24491d != null;
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.f24489b.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzbad.m26359d(sb.toString());
            throw new RemoteException();
        }
    }

    /* renamed from: a */
    public final void mo29843a(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, zzamv zzamv) throws RemoteException {
        Bundle bundle;
        zzxz zzxz2 = zzxz;
        String str2 = str;
        if (this.f24489b instanceof Adapter) {
            zzbad.m26352a("Requesting rewarded ad from adapter.");
            try {
                Adapter adapter = (Adapter) this.f24489b;
                C9142Ta ta = new C9142Ta(this, zzamv, adapter);
                Context context = (Context) ObjectWrapper.m22187H(iObjectWrapper);
                String str3 = "";
                Bundle a = m25446a(str2, zzxz2, (String) null);
                if (zzxz2.f29735m != null) {
                    Bundle bundle2 = zzxz2.f29735m.getBundle(this.f24489b.getClass().getName());
                    if (bundle2 != null) {
                        bundle = bundle2;
                        MediationRewardedAdConfiguration mediationRewardedAdConfiguration = new MediationRewardedAdConfiguration(context, str3, a, bundle, m25449c(zzxz), zzxz2.f29733k, zzxz2.f29729g, zzxz2.f29742t, m25448a(str2, zzxz2));
                        adapter.loadRewardedAd(mediationRewardedAdConfiguration, ta);
                    }
                }
                bundle = new Bundle();
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration2 = new MediationRewardedAdConfiguration(context, str3, a, bundle, m25449c(zzxz), zzxz2.f29733k, zzxz2.f29729g, zzxz2.f29742t, m25448a(str2, zzxz2));
                adapter.loadRewardedAd(mediationRewardedAdConfiguration2, ta);
            } catch (Exception e) {
                zzbad.m26356b("", e);
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.f24489b.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.m26359d(sb.toString());
            throw new RemoteException();
        }
    }

    /* renamed from: l */
    public final void mo29859l(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.f24489b instanceof Adapter) {
            zzbad.m26352a("Show rewarded ad from adapter.");
            MediationRewardedAd mediationRewardedAd = this.f24493f;
            if (mediationRewardedAd != null) {
                mediationRewardedAd.showAd((Context) ObjectWrapper.m22187H(iObjectWrapper));
            } else {
                zzbad.m26355b("Can not show null mediation rewarded ad.");
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.f24489b.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.m26359d(sb.toString());
            throw new RemoteException();
        }
    }

    public final void setImmersiveMode(boolean z) throws RemoteException {
        Object obj = this.f24489b;
        if (!(obj instanceof OnImmersiveModeUpdatedListener)) {
            String canonicalName = OnImmersiveModeUpdatedListener.class.getCanonicalName();
            String canonicalName2 = this.f24489b.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.m26359d(sb.toString());
            return;
        }
        try {
            ((OnImmersiveModeUpdatedListener) obj).onImmersiveModeUpdated(z);
        } catch (Throwable th) {
            zzbad.m26356b("", th);
        }
    }

    public final zzaar getVideoController() {
        Object obj = this.f24489b;
        if (!(obj instanceof zza)) {
            return null;
        }
        try {
            return ((zza) obj).getVideoController();
        } catch (Throwable th) {
            zzbad.m26356b("", th);
            return null;
        }
    }

    public final void showInterstitial() throws RemoteException {
        if (this.f24489b instanceof MediationInterstitialAdapter) {
            zzbad.m26352a("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.f24489b).showInterstitial();
            } catch (Throwable th) {
                zzbad.m26356b("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = this.f24489b.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.m26359d(sb.toString());
            throw new RemoteException();
        }
    }

    public final void destroy() throws RemoteException {
        Object obj = this.f24489b;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onDestroy();
            } catch (Throwable th) {
                zzbad.m26356b("", th);
                throw new RemoteException();
            }
        }
    }

    public final void pause() throws RemoteException {
        Object obj = this.f24489b;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onPause();
            } catch (Throwable th) {
                zzbad.m26356b("", th);
                throw new RemoteException();
            }
        }
    }

    public final void resume() throws RemoteException {
        Object obj = this.f24489b;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onResume();
            } catch (Throwable th) {
                zzbad.m26356b("", th);
                throw new RemoteException();
            }
        }
    }

    /* renamed from: m */
    public final void mo29860m(IObjectWrapper iObjectWrapper) throws RemoteException {
        Context context = (Context) ObjectWrapper.m22187H(iObjectWrapper);
        Object obj = this.f24489b;
        if (obj instanceof OnContextChangedListener) {
            ((OnContextChangedListener) obj).onContextChanged(context);
        }
    }

    /* renamed from: a */
    public final void mo29841a(IObjectWrapper iObjectWrapper, zzaiq zzaiq, List<zzaiw> list) throws RemoteException {
        AdFormat adFormat;
        if (this.f24489b instanceof Adapter) {
            C9163Ua ua = new C9163Ua(this, zzaiq);
            ArrayList arrayList = new ArrayList();
            for (zzaiw zzaiw : list) {
                String str = zzaiw.f24369a;
                char c = 65535;
                switch (str.hashCode()) {
                    case -1396342996:
                        if (str.equals("banner")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -1052618729:
                        if (str.equals("native")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -239580146:
                        if (str.equals("rewarded")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 604727084:
                        if (str.equals(AdType.INTERSTITIAL)) {
                            c = 1;
                            break;
                        }
                        break;
                }
                if (c == 0) {
                    adFormat = AdFormat.BANNER;
                } else if (c == 1) {
                    adFormat = AdFormat.INTERSTITIAL;
                } else if (c == 2) {
                    adFormat = AdFormat.REWARDED;
                } else if (c == 3) {
                    adFormat = AdFormat.NATIVE;
                } else {
                    throw new RemoteException();
                }
                arrayList.add(new MediationConfiguration(adFormat, zzaiw.f24370b));
            }
            ((Adapter) this.f24489b).initialize((Context) ObjectWrapper.m22187H(iObjectWrapper), ua, arrayList);
            return;
        }
        throw new RemoteException();
    }

    /* renamed from: a */
    private final Bundle m25446a(String str, zzxz zzxz, String str2) throws RemoteException {
        Bundle bundle;
        String valueOf = String.valueOf(str);
        String str3 = "Server parameters: ";
        zzbad.m26352a(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        try {
            Bundle bundle2 = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                bundle = new Bundle();
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str4 = (String) keys.next();
                    bundle.putString(str4, jSONObject.getString(str4));
                }
            } else {
                bundle = bundle2;
            }
            if (this.f24489b instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (zzxz != null) {
                    bundle.putInt("tagForChildDirectedTreatment", zzxz.f29729g);
                }
            }
            bundle.remove("max_ad_content_rating");
            return bundle;
        } catch (Throwable th) {
            zzbad.m26356b("", th);
            throw new RemoteException();
        }
    }

    /* renamed from: c */
    private static boolean m25449c(zzxz zzxz) {
        if (!zzxz.f29728f) {
            zzyt.m31532a();
            if (!zzazt.m26311a()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static String m25448a(String str, zzxz zzxz) {
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException e) {
            return zzxz.f29743u;
        }
    }
}
