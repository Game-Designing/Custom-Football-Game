package com.facebook.login;

import com.facebook.AccessToken;
import java.util.Set;

/* renamed from: com.facebook.login.D */
/* compiled from: LoginResult */
public class C6748D {

    /* renamed from: a */
    private final AccessToken f12350a;

    /* renamed from: b */
    private final Set<String> f12351b;

    /* renamed from: c */
    private final Set<String> f12352c;

    public C6748D(AccessToken accessToken, Set<String> recentlyGrantedPermissions, Set<String> recentlyDeniedPermissions) {
        this.f12350a = accessToken;
        this.f12351b = recentlyGrantedPermissions;
        this.f12352c = recentlyDeniedPermissions;
    }

    /* renamed from: a */
    public AccessToken mo20005a() {
        return this.f12350a;
    }

    /* renamed from: b */
    public Set<String> mo20006b() {
        return this.f12351b;
    }
}
