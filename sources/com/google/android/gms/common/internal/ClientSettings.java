package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import p002b.p003c.p053g.p061f.C1255d;

@KeepForSdk
@VisibleForTesting
public final class ClientSettings {

    /* renamed from: a */
    private final Account f20052a;

    /* renamed from: b */
    private final Set<Scope> f20053b;

    /* renamed from: c */
    private final Set<Scope> f20054c;

    /* renamed from: d */
    private final Map<Api<?>, OptionalApiSettings> f20055d;

    /* renamed from: e */
    private final int f20056e;

    /* renamed from: f */
    private final View f20057f;

    /* renamed from: g */
    private final String f20058g;

    /* renamed from: h */
    private final String f20059h;

    /* renamed from: i */
    private final SignInOptions f20060i;

    /* renamed from: j */
    private final boolean f20061j;

    /* renamed from: k */
    private Integer f20062k;

    @KeepForSdk
    public static final class Builder {

        /* renamed from: a */
        private Account f20063a;

        /* renamed from: b */
        private C1255d<Scope> f20064b;

        /* renamed from: c */
        private Map<Api<?>, OptionalApiSettings> f20065c;

        /* renamed from: d */
        private int f20066d = 0;

        /* renamed from: e */
        private View f20067e;

        /* renamed from: f */
        private String f20068f;

        /* renamed from: g */
        private String f20069g;

        /* renamed from: h */
        private SignInOptions f20070h = SignInOptions.f30583a;

        /* renamed from: i */
        private boolean f20071i;

        /* renamed from: a */
        public final Builder mo27771a(Account account) {
            this.f20063a = account;
            return this;
        }

        /* renamed from: a */
        public final Builder mo27773a(Collection<Scope> collection) {
            if (this.f20064b == null) {
                this.f20064b = new C1255d<>();
            }
            this.f20064b.addAll(collection);
            return this;
        }

        @KeepForSdk
        /* renamed from: b */
        public final Builder mo27775b(String str) {
            this.f20068f = str;
            return this;
        }

        /* renamed from: a */
        public final Builder mo27772a(String str) {
            this.f20069g = str;
            return this;
        }

        @KeepForSdk
        /* renamed from: a */
        public final ClientSettings mo27774a() {
            ClientSettings clientSettings = new ClientSettings(this.f20063a, this.f20064b, this.f20065c, this.f20066d, this.f20067e, this.f20068f, this.f20069g, this.f20070h, this.f20071i);
            return clientSettings;
        }
    }

    public static final class OptionalApiSettings {

        /* renamed from: a */
        public final Set<Scope> f20072a;
    }

    @KeepForSdk
    /* renamed from: a */
    public static ClientSettings m21779a(Context context) {
        return new com.google.android.gms.common.api.GoogleApiClient.Builder(context).mo27396b();
    }

    public ClientSettings(Account account, Set<Scope> set, Map<Api<?>, OptionalApiSettings> map, int i, View view, String str, String str2, SignInOptions signInOptions, boolean z) {
        this.f20052a = account;
        this.f20053b = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        if (map == null) {
            map = Collections.EMPTY_MAP;
        }
        this.f20055d = map;
        this.f20057f = view;
        this.f20056e = i;
        this.f20058g = str;
        this.f20059h = str2;
        this.f20060i = signInOptions;
        this.f20061j = z;
        HashSet hashSet = new HashSet(this.f20053b);
        for (OptionalApiSettings optionalApiSettings : this.f20055d.values()) {
            hashSet.addAll(optionalApiSettings.f20072a);
        }
        this.f20054c = Collections.unmodifiableSet(hashSet);
    }

    @KeepForSdk
    @Deprecated
    /* renamed from: b */
    public final String mo27761b() {
        Account account = this.f20052a;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    @KeepForSdk
    /* renamed from: a */
    public final Account mo27758a() {
        return this.f20052a;
    }

    @KeepForSdk
    /* renamed from: c */
    public final Account mo27762c() {
        Account account = this.f20052a;
        if (account != null) {
            return account;
        }
        return new Account(BaseGmsClient.DEFAULT_ACCOUNT, "com.google");
    }

    @KeepForSdk
    /* renamed from: i */
    public final Set<Scope> mo27768i() {
        return this.f20053b;
    }

    @KeepForSdk
    /* renamed from: d */
    public final Set<Scope> mo27763d() {
        return this.f20054c;
    }

    /* renamed from: f */
    public final Map<Api<?>, OptionalApiSettings> mo27765f() {
        return this.f20055d;
    }

    @KeepForSdk
    /* renamed from: h */
    public final String mo27767h() {
        return this.f20058g;
    }

    /* renamed from: g */
    public final String mo27766g() {
        return this.f20059h;
    }

    /* renamed from: j */
    public final SignInOptions mo27769j() {
        return this.f20060i;
    }

    /* renamed from: e */
    public final Integer mo27764e() {
        return this.f20062k;
    }

    /* renamed from: a */
    public final void mo27760a(Integer num) {
        this.f20062k = num;
    }

    @KeepForSdk
    /* renamed from: a */
    public final Set<Scope> mo27759a(Api<?> api) {
        OptionalApiSettings optionalApiSettings = (OptionalApiSettings) this.f20055d.get(api);
        if (optionalApiSettings == null || optionalApiSettings.f20072a.isEmpty()) {
            return this.f20053b;
        }
        HashSet hashSet = new HashSet(this.f20053b);
        hashSet.addAll(optionalApiSettings.f20072a);
        return hashSet;
    }

    /* renamed from: k */
    public final boolean mo27770k() {
        return this.f20061j;
    }
}
