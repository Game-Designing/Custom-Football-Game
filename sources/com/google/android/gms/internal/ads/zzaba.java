package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public final class zzaba {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final HashSet<String> f23816a = new HashSet<>();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Bundle f23817b = new Bundle();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final HashMap<Class<? extends NetworkExtras>, NetworkExtras> f23818c = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final HashSet<String> f23819d = new HashSet<>();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Bundle f23820e = new Bundle();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final HashSet<String> f23821f = new HashSet<>();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Date f23822g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public String f23823h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f23824i = -1;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Location f23825j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f23826k = false;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public String f23827l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public String f23828m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f23829n = -1;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f23830o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f23831p = -1;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public String f23832q;

    /* renamed from: a */
    public final void mo29411a(String str) {
        this.f23816a.add(str);
    }

    @Deprecated
    /* renamed from: a */
    public final void mo29409a(NetworkExtras networkExtras) {
        if (networkExtras instanceof AdMobExtras) {
            mo29410a(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
        } else {
            this.f23818c.put(networkExtras.getClass(), networkExtras);
        }
    }

    /* renamed from: a */
    public final void mo29410a(Class<? extends MediationExtrasReceiver> cls, Bundle bundle) {
        this.f23817b.putBundle(cls.getName(), bundle);
    }

    /* renamed from: b */
    public final void mo29416b(Class<? extends CustomEvent> cls, Bundle bundle) {
        String str = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
        if (this.f23817b.getBundle(str) == null) {
            this.f23817b.putBundle(str, new Bundle());
        }
        this.f23817b.getBundle(str).putBundle(cls.getName(), bundle);
    }

    /* renamed from: b */
    public final void mo29417b(String str) {
        this.f23819d.add(str);
    }

    /* renamed from: c */
    public final void mo29419c(String str) {
        this.f23819d.remove(str);
    }

    @Deprecated
    /* renamed from: a */
    public final void mo29413a(Date date) {
        this.f23822g = date;
    }

    /* renamed from: d */
    public final void mo29421d(String str) {
        this.f23823h = str;
    }

    @Deprecated
    /* renamed from: a */
    public final void mo29407a(int i) {
        this.f23824i = i;
    }

    /* renamed from: a */
    public final void mo29408a(Location location) {
        this.f23825j = location;
    }

    /* renamed from: a */
    public final void mo29414a(boolean z) {
        this.f23826k = z;
    }

    /* renamed from: e */
    public final void mo29422e(String str) {
        this.f23827l = str;
    }

    /* renamed from: f */
    public final void mo29423f(String str) {
        this.f23828m = str;
    }

    /* renamed from: b */
    public final void mo29418b(boolean z) {
        int i;
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        this.f23829n = i;
    }

    /* renamed from: a */
    public final void mo29412a(String str, String str2) {
        this.f23820e.putString(str, str2);
    }

    /* renamed from: g */
    public final void mo29424g(String str) {
        this.f23821f.add(str);
    }

    @Deprecated
    /* renamed from: c */
    public final void mo29420c(boolean z) {
        this.f23830o = z;
    }

    /* renamed from: b */
    public final void mo29415b(int i) {
        if (i == -1 || i == 0 || i == 1) {
            this.f23831p = i;
        }
    }

    /* renamed from: h */
    public final void mo29425h(String str) {
        if ("G".equals(str) || "PG".equals(str) || "T".equals(str) || "MA".equals(str)) {
            this.f23832q = str;
        }
    }
}
