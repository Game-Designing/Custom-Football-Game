package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.C8082b;
import com.google.ads.mediation.C8092e;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.mediation.customevent.CustomEventAdapter;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import java.util.Map;

@zzard
public final class zzamo extends zzamq {

    /* renamed from: b */
    private static final zzapb f24472b = new zzapb();

    /* renamed from: c */
    private Map<Class<? extends NetworkExtras>, NetworkExtras> f24473c;

    /* renamed from: j */
    public final zzams mo29834j(String str) throws RemoteException {
        return m25240t(str);
    }

    /* renamed from: k */
    public final boolean mo29835k(String str) throws RemoteException {
        try {
            return CustomEvent.class.isAssignableFrom(Class.forName(str, false, zzamo.class.getClassLoader()));
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 80);
            sb.append("Could not load custom event implementation class: ");
            sb.append(str);
            sb.append(", assuming old implementation.");
            zzbad.m26359d(sb.toString());
            return false;
        }
    }

    /* renamed from: b */
    public final void mo29833b(Map<Class<? extends NetworkExtras>, NetworkExtras> map) {
        this.f24473c = map;
    }

    /* renamed from: t */
    private final <NetworkExtrasT extends C8092e, ServerParametersT extends MediationServerParameters> zzams m25240t(String str) throws RemoteException {
        try {
            Class cls = Class.forName(str, false, zzamo.class.getClassLoader());
            if (C8082b.class.isAssignableFrom(cls)) {
                C8082b bVar = (C8082b) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                return new zzant(bVar, (C8092e) this.f24473c.get(bVar.getAdditionalParametersType()));
            } else if (MediationAdapter.class.isAssignableFrom(cls)) {
                return new zzanl((MediationAdapter) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } else {
                if (Adapter.class.isAssignableFrom(cls)) {
                    return new zzanl((Adapter) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                }
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 64);
                sb.append("Could not instantiate mediation adapter: ");
                sb.append(str);
                sb.append(" (not a valid adapter).");
                zzbad.m26359d(sb.toString());
                throw new RemoteException();
            }
        } catch (Throwable th) {
            return m25241u(str);
        }
    }

    /* renamed from: u */
    private final zzams m25241u(String str) throws RemoteException {
        try {
            zzbad.m26352a("Reflection failed, retrying using direct instantiation");
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                return new zzanl((MediationAdapter) new AdMobAdapter());
            }
            if ("com.google.ads.mediation.AdUrlAdapter".equals(str)) {
                return new zzanl((MediationAdapter) new AdUrlAdapter());
            }
            if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                return new zzanl((MediationAdapter) new CustomEventAdapter());
            }
            if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                com.google.ads.mediation.customevent.CustomEventAdapter customEventAdapter = new com.google.ads.mediation.customevent.CustomEventAdapter();
                return new zzant(customEventAdapter, (CustomEventExtras) this.f24473c.get(customEventAdapter.getAdditionalParametersType()));
            }
            throw new RemoteException();
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 43);
            sb.append("Could not instantiate mediation adapter: ");
            sb.append(str);
            sb.append(". ");
            zzbad.m26358c(sb.toString(), th);
        }
    }

    /* renamed from: q */
    public final zzaov mo29836q(String str) throws RemoteException {
        return zzapb.m25606a(str);
    }
}
