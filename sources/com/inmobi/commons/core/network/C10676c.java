package com.inmobi.commons.core.network;

import android.util.Base64;
import com.inmobi.commons.core.configs.C10639a;
import com.inmobi.commons.core.configs.C10641b;
import com.inmobi.commons.core.configs.C10641b.C10644c;
import com.inmobi.commons.core.configs.C10651g;
import com.inmobi.commons.core.utilities.C10700d;
import com.inmobi.commons.core.utilities.p224a.C10687b;
import com.inmobi.commons.core.utilities.p224a.C10688c;
import com.inmobi.commons.core.utilities.p225b.C10690a;
import com.inmobi.commons.core.utilities.p225b.C10691b;
import com.inmobi.commons.core.utilities.p225b.C10694e;
import com.inmobi.commons.core.utilities.p225b.C10696f;
import com.inmobi.commons.core.utilities.uid.C10709c;
import com.inmobi.commons.core.utilities.uid.C10711d;
import com.inmobi.commons.p217a.C10619a;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;

/* renamed from: com.inmobi.commons.core.network.c */
/* compiled from: NetworkRequest */
public class C10676c {

    /* renamed from: a */
    private static final String f32568a = C10676c.class.getSimpleName();

    /* renamed from: A */
    public boolean f32569A;

    /* renamed from: b */
    private C10711d f32570b;

    /* renamed from: c */
    private boolean f32571c;

    /* renamed from: d */
    private byte[] f32572d;

    /* renamed from: e */
    private byte[] f32573e;

    /* renamed from: f */
    private boolean f32574f;

    /* renamed from: m */
    protected Map<String, String> f32575m;

    /* renamed from: n */
    protected Map<String, String> f32576n;

    /* renamed from: o */
    public Map<String, String> f32577o;

    /* renamed from: p */
    String f32578p;

    /* renamed from: q */
    public String f32579q;

    /* renamed from: r */
    public int f32580r;

    /* renamed from: s */
    public int f32581s;

    /* renamed from: t */
    public boolean f32582t;

    /* renamed from: u */
    public boolean f32583u;

    /* renamed from: v */
    public long f32584v;

    /* renamed from: w */
    boolean f32585w;

    /* renamed from: x */
    public int f32586x;

    /* renamed from: y */
    public boolean f32587y;

    /* renamed from: z */
    public C10651g f32588z;

    public C10676c(String str, String str2, boolean z, C10711d dVar) {
        this(str, str2, z, dVar, false, 0);
    }

    public C10676c(String str, String str2) {
        this(str, str2, false, null, false, 0);
        this.f32574f = false;
    }

    public C10676c(String str, String str2, C10711d dVar, int i) {
        this(str, str2, true, dVar, false, i);
    }

    public C10676c(String str, String str2, boolean z, C10711d dVar, boolean z2, int i) {
        this.f32575m = new HashMap();
        this.f32580r = 60000;
        this.f32581s = 60000;
        this.f32582t = true;
        this.f32583u = true;
        this.f32584v = -1;
        this.f32586x = 0;
        this.f32574f = true;
        this.f32587y = false;
        this.f32569A = true;
        this.f32578p = str;
        this.f32579q = str2;
        this.f32571c = z;
        this.f32570b = dVar;
        this.f32575m.put("User-Agent", C10619a.m34848f());
        this.f32585w = z2;
        this.f32586x = i;
        if ("GET".equals(str)) {
            this.f32576n = new HashMap();
        } else if ("POST".equals(str)) {
            this.f32577o = new HashMap();
        }
        this.f32588z = new C10651g();
        C10641b.m34915a().mo34452a((C10639a) this.f32588z, (C10644c) null);
    }

    /* renamed from: a */
    public final void mo34502a(Map<String, String> map) {
        if (map != null) {
            this.f32575m.putAll(map);
        }
    }

    /* renamed from: b */
    public final void mo34504b(Map<String, String> map) {
        if (map != null) {
            this.f32576n.putAll(map);
        }
    }

    /* renamed from: c */
    public final void mo34505c(Map<String, String> map) {
        this.f32577o.putAll(map);
    }

    /* renamed from: d */
    public final Map<String, String> mo34506d() {
        C10700d.m35145a(this.f32575m);
        return this.f32575m;
    }

    /* renamed from: e */
    public final String mo34507e() {
        String str = this.f32579q;
        if (this.f32576n == null) {
            return str;
        }
        String c = mo34265c();
        if (c == null || c.trim().length() == 0) {
            return str;
        }
        String str2 = "?";
        if (!str.contains(str2)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            str = sb.toString();
        }
        String str3 = "&";
        if (!str.endsWith(str3) && !str.endsWith(str2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(str3);
            str = sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(c);
        return sb3.toString();
    }

    /* renamed from: a */
    public void mo34263a() {
        C10694e.m35113c();
        boolean z = true;
        if (this.f32586x != 1) {
            z = false;
        }
        this.f32586x = C10694e.m35108a(z);
        String str = "POST";
        String str2 = "GET";
        if (this.f32583u) {
            if (str2.equals(this.f32578p)) {
                m35045d(this.f32576n);
            } else if (str.equals(this.f32578p)) {
                m35045d(this.f32577o);
            }
        }
        if (this.f32574f) {
            JSONObject a = C10694e.m35110a();
            if (a != null) {
                String str3 = "consentObject";
                if (str2.equals(this.f32578p)) {
                    this.f32576n.put(str3, a.toString());
                } else if (str.equals(this.f32578p)) {
                    this.f32577o.put(str3, a.toString());
                }
            }
        }
        if (this.f32569A) {
            boolean equals = str2.equals(this.f32578p);
            String str4 = "u-appsecure";
            if (equals) {
                this.f32576n.put(str4, Integer.toString(C10690a.m35097a().f32622c));
            } else if (str.equals(this.f32578p)) {
                this.f32577o.put(str4, Integer.toString(C10690a.m35097a().f32622c));
            }
        }
    }

    /* renamed from: c */
    private String mo34265c() {
        C10700d.m35145a(this.f32576n);
        return C10700d.m35143a(this.f32576n, "&");
    }

    /* renamed from: f */
    public final String mo34508f() {
        C10700d.m35145a(this.f32577o);
        String str = "&";
        String a = C10700d.m35143a(this.f32577o, str);
        new StringBuilder("Post body url: ").append(this.f32579q);
        if (!mo34264b()) {
            return a;
        }
        this.f32572d = C10687b.m35080a(16);
        this.f32573e = C10687b.m35079a();
        byte[] bArr = this.f32572d;
        byte[] bArr2 = this.f32573e;
        C10651g gVar = this.f32588z;
        byte[] a2 = C10687b.m35080a(8);
        HashMap hashMap = new HashMap();
        hashMap.put("sm", C10687b.m35078a(a, bArr2, bArr, a2, gVar.f32467b, gVar.f32466a));
        hashMap.put("sn", gVar.f32468c);
        return C10700d.m35143a((Map<String, String>) hashMap, str);
    }

    /* renamed from: b */
    public boolean mo34264b() {
        return this.f32571c;
    }

    /* renamed from: d */
    private void m35045d(Map<String, String> map) {
        map.putAll(C10690a.m35097a().f32621b);
        map.putAll(C10691b.m35101a(this.f32587y));
        map.putAll(C10696f.m35118a());
        if (this.f32570b != null) {
            String str = "u-id-map";
            if (mo34264b()) {
                C10711d dVar = this.f32570b;
                HashMap hashMap = new HashMap();
                hashMap.put(str, new JSONObject(dVar.mo34531a((String) null, false)).toString());
                map.putAll(hashMap);
                return;
            }
            C10711d dVar2 = this.f32570b;
            String num = Integer.toString(new Random().nextInt());
            String a = C10688c.m35088a(new JSONObject(dVar2.mo34531a(num, true)).toString());
            HashMap hashMap2 = new HashMap();
            hashMap2.put(str, a);
            hashMap2.put("u-id-key", num);
            C10709c.m35160a();
            hashMap2.put("u-key-ver", C10709c.m35163d());
            map.putAll(hashMap2);
        }
    }

    /* renamed from: a */
    public final byte[] mo34503a(byte[] bArr) {
        try {
            return C10687b.m35084a(Base64.decode(bArr, 0), this.f32573e, this.f32572d);
        } catch (IllegalArgumentException e) {
            new StringBuilder("Msg : ").append(e.getMessage());
            return null;
        }
    }

    /* renamed from: g */
    public final long mo34509g() {
        try {
            if ("GET".equals(this.f32578p)) {
                return 0 + ((long) mo34265c().length());
            }
            if ("POST".equals(this.f32578p)) {
                return ((long) mo34508f().length()) + 0;
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }
}
