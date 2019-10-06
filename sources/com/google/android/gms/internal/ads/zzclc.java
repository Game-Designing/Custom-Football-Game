package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzclc {

    /* renamed from: a */
    private final AtomicReference<zzamp> f26973a = new AtomicReference<>();

    zzclc() {
    }

    /* renamed from: a */
    public final void mo31202a(zzamp zzamp) {
        this.f26973a.compareAndSet(null, zzamp);
    }

    /* renamed from: a */
    public final zzams mo31200a(String str, JSONObject jSONObject) throws RemoteException {
        if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
            return new zzanl((MediationAdapter) new AdMobAdapter());
        }
        if ("com.google.ads.mediation.AdUrlAdapter".equals(str)) {
            return new zzanl((MediationAdapter) new AdUrlAdapter());
        }
        if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(str)) {
            return new zzanl((MediationAdapter) new zzapl());
        }
        return m28559b(str, jSONObject);
    }

    /* renamed from: a */
    public final zzaov mo31201a(String str) throws RemoteException {
        return m28558b().mo29836q(str);
    }

    /* renamed from: a */
    public final boolean mo31203a() {
        return this.f26973a.get() != null;
    }

    /* renamed from: b */
    private final zzams m28559b(String str, JSONObject jSONObject) throws RemoteException {
        zzamp b = m28558b();
        String str2 = "com.google.ads.mediation.customevent.CustomEventAdapter";
        String str3 = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
        if (str2.equals(str) || str3.equals(str)) {
            try {
                if (b.mo29835k(jSONObject.getString("class_name"))) {
                    return b.mo29834j(str3);
                }
                return b.mo29834j(str2);
            } catch (JSONException e) {
                zzbad.m26356b("Invalid custom event.", e);
            }
        }
        return b.mo29834j(str);
    }

    /* renamed from: b */
    private final zzamp m28558b() throws RemoteException {
        zzamp zzamp = (zzamp) this.f26973a.get();
        if (zzamp != null) {
            return zzamp;
        }
        zzbad.m26359d("Unexpected call to adapter creator.");
        throw new RemoteException();
    }
}
