package p002b.p003c.p053g.p059d;

import android.util.Base64;
import java.util.List;
import p002b.p003c.p053g.p061f.C1272p;

/* renamed from: b.c.g.d.a */
/* compiled from: FontRequest */
public final class C1227a {

    /* renamed from: a */
    private final String f3959a;

    /* renamed from: b */
    private final String f3960b;

    /* renamed from: c */
    private final String f3961c;

    /* renamed from: d */
    private final List<List<byte[]>> f3962d;

    /* renamed from: e */
    private final int f3963e = 0;

    /* renamed from: f */
    private final String f3964f;

    public C1227a(String providerAuthority, String providerPackage, String query, List<List<byte[]>> certificates) {
        C1272p.m5959a(providerAuthority);
        this.f3959a = providerAuthority;
        C1272p.m5959a(providerPackage);
        this.f3960b = providerPackage;
        C1272p.m5959a(query);
        this.f3961c = query;
        C1272p.m5959a(certificates);
        this.f3962d = certificates;
        StringBuilder sb = new StringBuilder(this.f3959a);
        String str = "-";
        sb.append(str);
        sb.append(this.f3960b);
        sb.append(str);
        sb.append(this.f3961c);
        this.f3964f = sb.toString();
    }

    /* renamed from: d */
    public String mo8990d() {
        return this.f3959a;
    }

    /* renamed from: e */
    public String mo8991e() {
        return this.f3960b;
    }

    /* renamed from: f */
    public String mo8992f() {
        return this.f3961c;
    }

    /* renamed from: a */
    public List<List<byte[]>> mo8987a() {
        return this.f3962d;
    }

    /* renamed from: b */
    public int mo8988b() {
        return this.f3963e;
    }

    /* renamed from: c */
    public String mo8989c() {
        return this.f3964f;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: ");
        sb.append(this.f3959a);
        sb.append(", mProviderPackage: ");
        sb.append(this.f3960b);
        sb.append(", mQuery: ");
        sb.append(this.f3961c);
        sb.append(", mCertificates:");
        builder.append(sb.toString());
        for (int i = 0; i < this.f3962d.size(); i++) {
            builder.append(" [");
            List<byte[]> set = (List) this.f3962d.get(i);
            for (int j = 0; j < set.size(); j++) {
                builder.append(" \"");
                builder.append(Base64.encodeToString((byte[]) set.get(j), 0));
                builder.append("\"");
            }
            builder.append(" ]");
        }
        builder.append("}");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("mCertificatesArray: ");
        sb2.append(this.f3963e);
        builder.append(sb2.toString());
        return builder.toString();
    }
}
