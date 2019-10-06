package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class Storage {

    /* renamed from: a */
    private static final Lock f19478a = new ReentrantLock();

    /* renamed from: b */
    private static Storage f19479b;

    /* renamed from: c */
    private final Lock f19480c = new ReentrantLock();

    /* renamed from: d */
    private final SharedPreferences f19481d;

    @KeepForSdk
    /* renamed from: a */
    public static Storage m20992a(Context context) {
        Preconditions.m21857a(context);
        f19478a.lock();
        try {
            if (f19479b == null) {
                f19479b = new Storage(context.getApplicationContext());
            }
            return f19479b;
        } finally {
            f19478a.unlock();
        }
    }

    @VisibleForTesting
    private Storage(Context context) {
        this.f19481d = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    @KeepForSdk
    /* renamed from: a */
    public void mo27228a(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        Preconditions.m21857a(googleSignInAccount);
        Preconditions.m21857a(googleSignInOptions);
        m20993a("defaultGoogleSignInAccount", googleSignInAccount.mo27183w());
        Preconditions.m21857a(googleSignInAccount);
        Preconditions.m21857a(googleSignInOptions);
        String w = googleSignInAccount.mo27183w();
        m20993a(m20995b("googleSignInAccount", w), googleSignInAccount.mo27185x());
        m20993a(m20995b("googleSignInOptions", w), googleSignInOptions.mo27200i());
    }

    /* renamed from: a */
    private final void m20993a(String str, String str2) {
        this.f19480c.lock();
        try {
            this.f19481d.edit().putString(str, str2).apply();
        } finally {
            this.f19480c.unlock();
        }
    }

    @KeepForSdk
    /* renamed from: b */
    public GoogleSignInAccount mo27229b() {
        return m20991a(m20996c("defaultGoogleSignInAccount"));
    }

    @VisibleForTesting
    /* renamed from: a */
    private final GoogleSignInAccount m20991a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String c = m20996c(m20995b("googleSignInAccount", str));
        if (c == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.m20927a(c);
        } catch (JSONException e) {
            return null;
        }
    }

    @KeepForSdk
    /* renamed from: c */
    public GoogleSignInOptions mo27230c() {
        return m20994b(m20996c("defaultGoogleSignInAccount"));
    }

    @VisibleForTesting
    /* renamed from: b */
    private final GoogleSignInOptions m20994b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String c = m20996c(m20995b("googleSignInOptions", str));
        if (c == null) {
            return null;
        }
        try {
            return GoogleSignInOptions.m20948a(c);
        } catch (JSONException e) {
            return null;
        }
    }

    @KeepForSdk
    /* renamed from: d */
    public String mo27231d() {
        return m20996c("refreshToken");
    }

    /* renamed from: c */
    private final String m20996c(String str) {
        this.f19480c.lock();
        try {
            return this.f19481d.getString(str, null);
        } finally {
            this.f19480c.unlock();
        }
    }

    /* renamed from: e */
    public final void mo27232e() {
        String str = "defaultGoogleSignInAccount";
        String c = m20996c(str);
        m20997d(str);
        if (!TextUtils.isEmpty(c)) {
            m20997d(m20995b("googleSignInAccount", c));
            m20997d(m20995b("googleSignInOptions", c));
        }
    }

    /* renamed from: d */
    private final void m20997d(String str) {
        this.f19480c.lock();
        try {
            this.f19481d.edit().remove(str).apply();
        } finally {
            this.f19480c.unlock();
        }
    }

    @KeepForSdk
    /* renamed from: a */
    public void mo27227a() {
        this.f19480c.lock();
        try {
            this.f19481d.edit().clear().apply();
        } finally {
            this.f19480c.unlock();
        }
    }

    /* renamed from: b */
    private static String m20995b(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        return sb.toString();
    }
}
