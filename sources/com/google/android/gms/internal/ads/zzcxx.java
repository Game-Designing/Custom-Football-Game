package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class zzcxx {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public zzxz f27612a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public zzyd f27613b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public zzzy f27614c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f27615d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public zzacd f27616e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f27617f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ArrayList<String> f27618g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ArrayList<String> f27619h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public zzady f27620i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public PublisherAdViewOptions f27621j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public zzzs f27622k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public String f27623l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public String f27624m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f27625n = 1;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public zzaiy f27626o;

    /* renamed from: p */
    public final Set<String> f27627p = new HashSet();

    /* renamed from: a */
    public final zzcxx mo31291a(zzxz zzxz) {
        this.f27612a = zzxz;
        return this;
    }

    /* renamed from: a */
    public final zzxz mo31297a() {
        return this.f27612a;
    }

    /* renamed from: a */
    public final zzcxx mo31292a(zzyd zzyd) {
        this.f27613b = zzyd;
        return this;
    }

    /* renamed from: d */
    public final zzyd mo31303d() {
        return this.f27613b;
    }

    /* renamed from: a */
    public final zzcxx mo31293a(zzzy zzzy) {
        this.f27614c = zzzy;
        return this;
    }

    /* renamed from: a */
    public final zzcxx mo31294a(String str) {
        this.f27615d = str;
        return this;
    }

    /* renamed from: b */
    public final String mo31300b() {
        return this.f27615d;
    }

    /* renamed from: a */
    public final zzcxx mo31288a(zzacd zzacd) {
        this.f27616e = zzacd;
        return this;
    }

    /* renamed from: a */
    public final zzcxx mo31296a(boolean z) {
        this.f27617f = z;
        return this;
    }

    /* renamed from: a */
    public final zzcxx mo31286a(int i) {
        this.f27625n = i;
        return this;
    }

    /* renamed from: a */
    public final zzcxx mo31295a(ArrayList<String> arrayList) {
        this.f27618g = arrayList;
        return this;
    }

    /* renamed from: b */
    public final zzcxx mo31299b(ArrayList<String> arrayList) {
        this.f27619h = arrayList;
        return this;
    }

    /* renamed from: a */
    public final zzcxx mo31289a(zzady zzady) {
        this.f27620i = zzady;
        return this;
    }

    /* renamed from: a */
    public final zzcxx mo31290a(zzaiy zzaiy) {
        this.f27626o = zzaiy;
        this.f27616e = new zzacd(false, true, false);
        return this;
    }

    /* renamed from: b */
    public final zzcxx mo31298b(String str) {
        this.f27623l = str;
        return this;
    }

    /* renamed from: c */
    public final zzcxx mo31302c(String str) {
        this.f27624m = str;
        return this;
    }

    /* renamed from: a */
    public final zzcxx mo31287a(PublisherAdViewOptions publisherAdViewOptions) {
        this.f27621j = publisherAdViewOptions;
        if (publisherAdViewOptions != null) {
            this.f27617f = publisherAdViewOptions.getManualImpressionsEnabled();
            this.f27622k = publisherAdViewOptions.zzkt();
        }
        return this;
    }

    /* renamed from: c */
    public final zzcxv mo31301c() {
        Preconditions.m21858a(this.f27615d, (Object) "ad unit must not be null");
        Preconditions.m21858a(this.f27613b, (Object) "ad size must not be null");
        Preconditions.m21858a(this.f27612a, (Object) "ad request must not be null");
        return new zzcxv(this);
    }
}
