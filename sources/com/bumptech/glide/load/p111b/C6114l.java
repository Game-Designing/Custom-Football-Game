package com.bumptech.glide.load.p111b;

import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.C6344g;
import com.bumptech.glide.p107h.C6024i;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.b.l */
/* compiled from: GlideUrl */
public class C6114l implements C6344g {

    /* renamed from: a */
    private final C6116n f10786a;

    /* renamed from: b */
    private final URL f10787b;

    /* renamed from: c */
    private final String f10788c;

    /* renamed from: d */
    private String f10789d;

    /* renamed from: e */
    private URL f10790e;

    /* renamed from: f */
    private volatile byte[] f10791f;

    /* renamed from: g */
    private int f10792g;

    public C6114l(URL url) {
        this(url, C6116n.f10794b);
    }

    public C6114l(String url) {
        this(url, C6116n.f10794b);
    }

    public C6114l(URL url, C6116n headers) {
        C6024i.m11264a(url);
        this.f10787b = url;
        this.f10788c = null;
        C6024i.m11264a(headers);
        this.f10786a = headers;
    }

    public C6114l(String url, C6116n headers) {
        this.f10787b = null;
        C6024i.m11266a(url);
        this.f10788c = url;
        C6024i.m11264a(headers);
        this.f10786a = headers;
    }

    /* renamed from: c */
    public URL mo18932c() throws MalformedURLException {
        return m11540f();
    }

    /* renamed from: f */
    private URL m11540f() throws MalformedURLException {
        if (this.f10790e == null) {
            this.f10790e = new URL(m11539e());
        }
        return this.f10790e;
    }

    /* renamed from: e */
    private String m11539e() {
        if (TextUtils.isEmpty(this.f10789d)) {
            String unsafeStringUrl = this.f10788c;
            if (TextUtils.isEmpty(unsafeStringUrl)) {
                URL url = this.f10787b;
                C6024i.m11264a(url);
                unsafeStringUrl = url.toString();
            }
            this.f10789d = Uri.encode(unsafeStringUrl, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f10789d;
    }

    /* renamed from: b */
    public Map<String, String> mo18931b() {
        return this.f10786a.mo18934a();
    }

    /* renamed from: a */
    public String mo18930a() {
        String str = this.f10788c;
        if (str != null) {
            return str;
        }
        URL url = this.f10787b;
        C6024i.m11264a(url);
        return url.toString();
    }

    public String toString() {
        return mo18930a();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(m11538d());
    }

    /* renamed from: d */
    private byte[] m11538d() {
        if (this.f10791f == null) {
            this.f10791f = mo18930a().getBytes(C6344g.f11318a);
        }
        return this.f10791f;
    }

    public boolean equals(Object o) {
        boolean z = false;
        if (!(o instanceof C6114l)) {
            return false;
        }
        C6114l other = (C6114l) o;
        if (mo18930a().equals(other.mo18930a()) && this.f10786a.equals(other.f10786a)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        if (this.f10792g == 0) {
            this.f10792g = mo18930a().hashCode();
            this.f10792g = (this.f10792g * 31) + this.f10786a.hashCode();
        }
        return this.f10792g;
    }
}
