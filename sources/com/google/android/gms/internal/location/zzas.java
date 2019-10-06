package com.google.android.gms.internal.location;

import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.zzu;
import com.google.android.gms.location.zzx;
import java.util.HashMap;
import java.util.Map;

public final class zzas {

    /* renamed from: a */
    private final zzbj<zzao> f29937a;

    /* renamed from: b */
    private final Context f29938b;

    /* renamed from: c */
    private ContentProviderClient f29939c = null;

    /* renamed from: d */
    private boolean f29940d = false;

    /* renamed from: e */
    private final Map<ListenerKey<LocationListener>, C9891e> f29941e = new HashMap();

    /* renamed from: f */
    private final Map<ListenerKey<Object>, C9890d> f29942f = new HashMap();

    /* renamed from: g */
    private final Map<ListenerKey<LocationCallback>, C9887a> f29943g = new HashMap();

    public zzas(Context context, zzbj<zzao> zzbj) {
        this.f29938b = context;
        this.f29937a = zzbj;
    }

    /* renamed from: a */
    public final Location mo32503a() throws RemoteException {
        this.f29937a.mo32485b();
        return ((zzao) this.f29937a.mo32484a()).mo32500c(this.f29938b.getPackageName());
    }

    /* renamed from: a */
    public final void mo32504a(boolean z) throws RemoteException {
        this.f29937a.mo32485b();
        ((zzao) this.f29937a.mo32484a()).mo32501d(z);
        this.f29940d = z;
    }

    /* renamed from: b */
    public final void mo32505b() throws RemoteException {
        synchronized (this.f29941e) {
            for (C9891e eVar : this.f29941e.values()) {
                if (eVar != null) {
                    ((zzao) this.f29937a.mo32484a()).mo32498a(zzbf.m31752a((zzx) eVar, (zzaj) null));
                }
            }
            this.f29941e.clear();
        }
        synchronized (this.f29943g) {
            for (C9887a aVar : this.f29943g.values()) {
                if (aVar != null) {
                    ((zzao) this.f29937a.mo32484a()).mo32498a(zzbf.m31751a((zzu) aVar, (zzaj) null));
                }
            }
            this.f29943g.clear();
        }
        synchronized (this.f29942f) {
            for (C9890d dVar : this.f29942f.values()) {
                if (dVar != null) {
                    ((zzao) this.f29937a.mo32484a()).mo32499a(new zzo(2, null, dVar.asBinder(), null));
                }
            }
            this.f29942f.clear();
        }
    }

    /* renamed from: c */
    public final void mo32506c() throws RemoteException {
        if (this.f29940d) {
            mo32504a(false);
        }
    }
}
