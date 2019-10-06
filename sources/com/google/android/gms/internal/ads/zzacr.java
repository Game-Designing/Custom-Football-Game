package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.ConditionVariable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
public final class zzacr implements OnSharedPreferenceChangeListener {

    /* renamed from: a */
    private final Object f23888a = new Object();

    /* renamed from: b */
    private final ConditionVariable f23889b = new ConditionVariable();

    /* renamed from: c */
    private volatile boolean f23890c = false;
    @VisibleForTesting

    /* renamed from: d */
    private volatile boolean f23891d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public SharedPreferences f23892e = null;

    /* renamed from: f */
    private Bundle f23893f = new Bundle();

    /* renamed from: g */
    private Context f23894g;

    /* renamed from: h */
    private JSONObject f23895h = new JSONObject();

    /* renamed from: a */
    public final void mo29601a(Context context) {
        if (!this.f23890c) {
            synchronized (this.f23888a) {
                if (!this.f23890c) {
                    if (!this.f23891d) {
                        this.f23891d = true;
                    }
                    this.f23894g = context.getApplicationContext() == null ? context : context.getApplicationContext();
                    try {
                        this.f23893f = Wrappers.m22139a(this.f23894g).mo27944a(this.f23894g.getPackageName(), 128).metaData;
                    } catch (NameNotFoundException | NullPointerException e) {
                    }
                    try {
                        Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
                        if (remoteContext == null && context != null) {
                            remoteContext = context.getApplicationContext();
                            if (remoteContext == null) {
                                remoteContext = context;
                            }
                        }
                        if (remoteContext != null) {
                            zzyt.m31534c();
                            this.f23892e = remoteContext.getSharedPreferences("google_ads_flags", 0);
                            if (this.f23892e != null) {
                                this.f23892e.registerOnSharedPreferenceChangeListener(this);
                            }
                            m24777b();
                            this.f23890c = true;
                            this.f23891d = false;
                            this.f23889b.open();
                        }
                    } finally {
                        this.f23891d = false;
                        this.f23889b.open();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public final <T> T mo29599a(zzacj<T> zzacj) {
        if (!this.f23889b.block(5000)) {
            synchronized (this.f23888a) {
                if (!this.f23891d) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.f23890c || this.f23892e == null) {
            synchronized (this.f23888a) {
                if (this.f23890c) {
                    if (this.f23892e == null) {
                    }
                }
                T c = zzacj.mo29592c();
                return c;
            }
        }
        if (zzacj.mo29591b() == 2) {
            Bundle bundle = this.f23893f;
            if (bundle == null) {
                return zzacj.mo29592c();
            }
            return zzacj.mo29054a(bundle);
        } else if (zzacj.mo29591b() != 1 || !this.f23895h.has(zzacj.mo29590a())) {
            return zzazl.m26284a(this.f23894g, new C9680r(this, zzacj));
        } else {
            return zzacj.mo29055a(this.f23895h);
        }
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            m24777b();
        }
    }

    /* renamed from: b */
    private final void m24777b() {
        if (this.f23892e != null) {
            try {
                this.f23895h = new JSONObject((String) zzazl.m26284a(this.f23894g, new C9659q(this)));
            } catch (JSONException e) {
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ String mo29600a() throws Exception {
        return this.f23892e.getString("flag_configuration", "{}");
    }
}
