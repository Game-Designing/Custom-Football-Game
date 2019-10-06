package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.ads.Wa */
final class C9205Wa {

    /* renamed from: a */
    long f21878a;

    /* renamed from: b */
    final String f21879b;

    /* renamed from: c */
    final String f21880c;

    /* renamed from: d */
    final long f21881d;

    /* renamed from: e */
    final long f21882e;

    /* renamed from: f */
    final long f21883f;

    /* renamed from: g */
    final long f21884g;

    /* renamed from: h */
    final List<zzl> f21885h;

    private C9205Wa(String str, String str2, long j, long j2, long j3, long j4, List<zzl> list) {
        this.f21879b = str;
        if ("".equals(str2)) {
            str2 = null;
        }
        this.f21880c = str2;
        this.f21881d = j;
        this.f21882e = j2;
        this.f21883f = j3;
        this.f21884g = j4;
        this.f21885h = list;
    }

    C9205Wa(String str, zzc zzc) {
        List<zzl> list;
        String str2 = zzc.f26225b;
        long j = zzc.f26226c;
        long j2 = zzc.f26227d;
        long j3 = zzc.f26228e;
        long j4 = zzc.f26229f;
        List<zzl> list2 = zzc.f26231h;
        if (list2 != null) {
            list = list2;
        } else {
            Map<String, String> map = zzc.f26230g;
            ArrayList arrayList = new ArrayList(map.size());
            for (Entry entry : map.entrySet()) {
                arrayList.add(new zzl((String) entry.getKey(), (String) entry.getValue()));
            }
            list = arrayList;
        }
        this(str, str2, j, j2, j3, j4, list);
    }

    /* renamed from: a */
    static C9205Wa m23164a(C9268Za za) throws IOException {
        if (zzan.m25312a((InputStream) za) == 538247942) {
            C9205Wa wa = new C9205Wa(zzan.m25314a(za), zzan.m25314a(za), zzan.m25321b((InputStream) za), zzan.m25321b((InputStream) za), zzan.m25321b((InputStream) za), zzan.m25321b((InputStream) za), zzan.m25322b(za));
            return wa;
        }
        throw new IOException();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final boolean mo28675a(OutputStream outputStream) {
        try {
            zzan.m25315a(outputStream, 538247942);
            zzan.m25317a(outputStream, this.f21879b);
            zzan.m25317a(outputStream, this.f21880c == null ? "" : this.f21880c);
            zzan.m25316a(outputStream, this.f21881d);
            zzan.m25316a(outputStream, this.f21882e);
            zzan.m25316a(outputStream, this.f21883f);
            zzan.m25316a(outputStream, this.f21884g);
            List<zzl> list = this.f21885h;
            if (list != null) {
                zzan.m25315a(outputStream, list.size());
                for (zzl zzl : list) {
                    zzan.m25317a(outputStream, zzl.mo31933a());
                    zzan.m25317a(outputStream, zzl.mo31934b());
                }
            } else {
                zzan.m25315a(outputStream, 0);
            }
            outputStream.flush();
            return true;
        } catch (IOException e) {
            zzag.m24966a("%s", e.toString());
            return false;
        }
    }
}
