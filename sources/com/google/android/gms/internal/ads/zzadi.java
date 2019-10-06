package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@zzard
public final class zzadi {
    @VisibleForTesting

    /* renamed from: a */
    boolean f24235a = true;

    /* renamed from: b */
    private final List<zzadg> f24236b = new LinkedList();

    /* renamed from: c */
    private final Map<String, String> f24237c = new LinkedHashMap();

    /* renamed from: d */
    private final Object f24238d = new Object();

    /* renamed from: e */
    private zzadi f24239e;

    public zzadi(boolean z, String str, String str2) {
        this.f24237c.put("action", str);
        this.f24237c.put("ad_format", str2);
    }

    /* renamed from: a */
    public final void mo29619a(zzadi zzadi) {
        synchronized (this.f24238d) {
            this.f24239e = zzadi;
        }
    }

    /* renamed from: a */
    public final zzadg mo29617a(long j) {
        if (!this.f24235a) {
            return null;
        }
        return new zzadg(j, null, null);
    }

    /* renamed from: a */
    public final boolean mo29621a(zzadg zzadg, long j, String... strArr) {
        synchronized (this.f24238d) {
            for (String zzadg2 : strArr) {
                this.f24236b.add(new zzadg(j, zzadg2, zzadg));
            }
        }
        return true;
    }

    /* renamed from: a */
    public final String mo29618a() {
        String sb;
        StringBuilder sb2 = new StringBuilder();
        synchronized (this.f24238d) {
            for (zzadg zzadg : this.f24236b) {
                long a = zzadg.mo29611a();
                String b = zzadg.mo29612b();
                zzadg c = zzadg.mo29613c();
                if (c != null && a > 0) {
                    long a2 = a - c.mo29611a();
                    sb2.append(b);
                    sb2.append('.');
                    sb2.append(a2);
                    sb2.append(',');
                }
            }
            this.f24236b.clear();
            if (!TextUtils.isEmpty(null)) {
                sb2.append(null);
            } else if (sb2.length() > 0) {
                sb2.setLength(sb2.length() - 1);
            }
            sb = sb2.toString();
        }
        return sb;
    }

    /* renamed from: a */
    public final void mo29620a(String str, String str2) {
        if (this.f24235a && !TextUtils.isEmpty(str2)) {
            zzacy c = zzk.zzlk().mo30171c();
            if (c != null) {
                synchronized (this.f24238d) {
                    zzadc a = c.mo29607a(str);
                    Map<String, String> map = this.f24237c;
                    map.put(str, a.mo29196a((String) map.get(str), str2));
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: b */
    public final Map<String, String> mo29622b() {
        synchronized (this.f24238d) {
            zzacy c = zzk.zzlk().mo30171c();
            if (c != null) {
                if (this.f24239e != null) {
                    Map<String, String> a = c.mo29608a(this.f24237c, this.f24239e.mo29622b());
                    return a;
                }
            }
            Map<String, String> map = this.f24237c;
            return map;
        }
    }
}
