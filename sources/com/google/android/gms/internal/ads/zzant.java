package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.C8082b;
import com.google.ads.mediation.C8092e;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import p019d.p271g.p272a.C12722c;

@zzard
public final class zzant<NETWORK_EXTRAS extends C8092e, SERVER_PARAMETERS extends MediationServerParameters> extends zzamt {

    /* renamed from: b */
    private final C8082b<NETWORK_EXTRAS, SERVER_PARAMETERS> f24514b;

    /* renamed from: c */
    private final NETWORK_EXTRAS f24515c;

    public zzant(C8082b<NETWORK_EXTRAS, SERVER_PARAMETERS> bVar, NETWORK_EXTRAS network_extras) {
        this.f24514b = bVar;
        this.f24515c = network_extras;
    }

    /* renamed from: Ca */
    public final IObjectWrapper mo29837Ca() throws RemoteException {
        C8082b<NETWORK_EXTRAS, SERVER_PARAMETERS> bVar = this.f24514b;
        if (!(bVar instanceof MediationBannerAdapter)) {
            String str = "Not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(bVar.getClass().getCanonicalName());
            zzbad.m26359d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
        try {
            return ObjectWrapper.m22188a(((MediationBannerAdapter) bVar).getBannerView());
        } catch (Throwable th) {
            zzbad.m26356b("", th);
            throw new RemoteException();
        }
    }

    /* renamed from: a */
    public final void mo29847a(IObjectWrapper iObjectWrapper, zzyd zzyd, zzxz zzxz, String str, zzamv zzamv) throws RemoteException {
        mo29848a(iObjectWrapper, zzyd, zzxz, str, null, zzamv);
    }

    /* renamed from: a */
    public final void mo29848a(IObjectWrapper iObjectWrapper, zzyd zzyd, zzxz zzxz, String str, String str2, zzamv zzamv) throws RemoteException {
        C12722c cVar;
        C8082b<NETWORK_EXTRAS, SERVER_PARAMETERS> bVar = this.f24514b;
        if (!(bVar instanceof MediationBannerAdapter)) {
            String str3 = "Not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(bVar.getClass().getCanonicalName());
            zzbad.m26359d(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
        zzbad.m26352a("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.f24514b;
            zzanu zzanu = new zzanu(zzamv);
            Activity activity = (Activity) ObjectWrapper.m22187H(iObjectWrapper);
            MediationServerParameters t = m25517t(str);
            int i = 0;
            C12722c[] cVarArr = {C12722c.f39040a, C12722c.f39041b, C12722c.f39042c, C12722c.f39043d, C12722c.f39044e, C12722c.f39045f};
            while (true) {
                if (i < 6) {
                    if (cVarArr[i].mo41139b() == zzyd.f29772e && cVarArr[i].mo41138a() == zzyd.f29769b) {
                        cVar = cVarArr[i];
                        break;
                    }
                    i++;
                } else {
                    cVar = new C12722c(zzb.zza(zzyd.f29772e, zzyd.f29769b, zzyd.f29768a));
                    break;
                }
            }
            mediationBannerAdapter.requestBannerAd(zzanu, activity, t, cVar, zzaog.m25542a(zzxz, m25516c(zzxz)), this.f24515c);
        } catch (Throwable th) {
            zzbad.m26356b("", th);
            throw new RemoteException();
        }
    }

    public final Bundle zzsh() {
        return new Bundle();
    }

    /* renamed from: b */
    public final void mo29851b(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, zzamv zzamv) throws RemoteException {
        mo29845a(iObjectWrapper, zzxz, str, (String) null, zzamv);
    }

    /* renamed from: a */
    public final void mo29845a(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, String str2, zzamv zzamv) throws RemoteException {
        C8082b<NETWORK_EXTRAS, SERVER_PARAMETERS> bVar = this.f24514b;
        if (!(bVar instanceof MediationInterstitialAdapter)) {
            String str3 = "Not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(bVar.getClass().getCanonicalName());
            zzbad.m26359d(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
        zzbad.m26352a("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter) this.f24514b).requestInterstitialAd(new zzanu(zzamv), (Activity) ObjectWrapper.m22187H(iObjectWrapper), m25517t(str), zzaog.m25542a(zzxz, m25516c(zzxz)), this.f24515c);
        } catch (Throwable th) {
            zzbad.m26356b("", th);
            throw new RemoteException();
        }
    }

    public final Bundle getInterstitialAdapterInfo() {
        return new Bundle();
    }

    public final void setImmersiveMode(boolean z) {
    }

    public final zzaar getVideoController() {
        return null;
    }

    public final void showInterstitial() throws RemoteException {
        C8082b<NETWORK_EXTRAS, SERVER_PARAMETERS> bVar = this.f24514b;
        if (!(bVar instanceof MediationInterstitialAdapter)) {
            String str = "Not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(bVar.getClass().getCanonicalName());
            zzbad.m26359d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
        zzbad.m26352a("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.f24514b).showInterstitial();
        } catch (Throwable th) {
            zzbad.m26356b("", th);
            throw new RemoteException();
        }
    }

    /* renamed from: a */
    public final void mo29846a(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, String str2, zzamv zzamv, zzady zzady, List<String> list) {
    }

    /* renamed from: Oa */
    public final Bundle mo29838Oa() {
        return new Bundle();
    }

    /* renamed from: eb */
    public final zzana mo29855eb() {
        return null;
    }

    /* renamed from: bb */
    public final zzand mo29852bb() {
        return null;
    }

    /* renamed from: S */
    public final zzang mo29839S() {
        return null;
    }

    /* renamed from: Y */
    public final zzafe mo29840Y() {
        return null;
    }

    /* renamed from: a */
    public final void mo29844a(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, zzatk zzatk, String str2) throws RemoteException {
    }

    /* renamed from: a */
    public final void mo29842a(IObjectWrapper iObjectWrapper, zzatk zzatk, List<String> list) {
    }

    /* renamed from: da */
    public final boolean mo29853da() {
        return false;
    }

    /* renamed from: a */
    public final void mo29850a(zzxz zzxz, String str, String str2) {
    }

    /* renamed from: a */
    public final void mo29849a(zzxz zzxz, String str) {
    }

    public final void showVideo() {
    }

    public final boolean isInitialized() {
        return true;
    }

    /* renamed from: a */
    public final void mo29843a(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, zzamv zzamv) throws RemoteException {
    }

    /* renamed from: l */
    public final void mo29859l(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void destroy() throws RemoteException {
        try {
            this.f24514b.destroy();
        } catch (Throwable th) {
            zzbad.m26356b("", th);
            throw new RemoteException();
        }
    }

    public final void pause() throws RemoteException {
        throw new RemoteException();
    }

    public final void resume() throws RemoteException {
        throw new RemoteException();
    }

    /* renamed from: m */
    public final void mo29860m(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    /* renamed from: a */
    public final void mo29841a(IObjectWrapper iObjectWrapper, zzaiq zzaiq, List<zzaiw> list) throws RemoteException {
    }

    /* renamed from: t */
    private final SERVER_PARAMETERS m25517t(String str) throws RemoteException {
        HashMap hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    hashMap.put(str2, jSONObject.getString(str2));
                }
            } catch (Throwable th) {
                zzbad.m26356b("", th);
                throw new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class serverParametersType = this.f24514b.getServerParametersType();
        if (serverParametersType == null) {
            return null;
        }
        SERVER_PARAMETERS server_parameters = (MediationServerParameters) serverParametersType.newInstance();
        server_parameters.mo24944a(hashMap);
        return server_parameters;
    }

    /* renamed from: c */
    private static boolean m25516c(zzxz zzxz) {
        if (!zzxz.f29728f) {
            zzyt.m31532a();
            if (!zzazt.m26311a()) {
                return false;
            }
        }
        return true;
    }
}
