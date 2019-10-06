package com.facebook.p127a;

import com.facebook.AccessToken;
import com.facebook.C6787r;
import com.facebook.internal.C6694S;
import java.io.Serializable;

/* renamed from: com.facebook.a.b */
/* compiled from: AccessTokenAppIdPair */
class C6593b implements Serializable {

    /* renamed from: a */
    private final String f11973a;

    /* renamed from: b */
    private final String f11974b;

    /* renamed from: com.facebook.a.b$a */
    /* compiled from: AccessTokenAppIdPair */
    static class C6594a implements Serializable {

        /* renamed from: a */
        private final String f11975a;

        /* renamed from: b */
        private final String f11976b;

        private C6594a(String accessTokenString, String appId) {
            this.f11975a = accessTokenString;
            this.f11976b = appId;
        }

        private Object readResolve() {
            return new C6593b(this.f11975a, this.f11976b);
        }
    }

    public C6593b(AccessToken accessToken) {
        this(accessToken.mo19631k(), C6787r.m13816f());
    }

    public C6593b(String accessTokenString, String applicationId) {
        this.f11973a = C6694S.m13436b(accessTokenString) ? null : accessTokenString;
        this.f11974b = applicationId;
    }

    /* renamed from: a */
    public String mo19778a() {
        return this.f11973a;
    }

    /* renamed from: b */
    public String mo19779b() {
        return this.f11974b;
    }

    public int hashCode() {
        String str = this.f11973a;
        int i = 0;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.f11974b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode ^ i;
    }

    public boolean equals(Object o) {
        boolean z = false;
        if (!(o instanceof C6593b)) {
            return false;
        }
        C6593b p = (C6593b) o;
        if (C6694S.m13429a(p.f11973a, this.f11973a) && C6694S.m13429a(p.f11974b, this.f11974b)) {
            z = true;
        }
        return z;
    }

    private Object writeReplace() {
        return new C6594a(this.f11973a, this.f11974b);
    }
}
