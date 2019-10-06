package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.deprecated.tables.Updates;

@zzard
public final class zzaxc implements zzaxb {

    /* renamed from: a */
    private final Object f24933a = new Object();

    /* renamed from: b */
    private boolean f24934b;

    /* renamed from: c */
    private final List<Runnable> f24935c = new ArrayList();

    /* renamed from: d */
    private zzbbh<?> f24936d;

    /* renamed from: e */
    private zzuu f24937e = null;

    /* renamed from: f */
    private SharedPreferences f24938f;

    /* renamed from: g */
    private Editor f24939g;

    /* renamed from: h */
    private boolean f24940h = false;

    /* renamed from: i */
    private boolean f24941i = true;

    /* renamed from: j */
    private String f24942j;

    /* renamed from: k */
    private String f24943k;

    /* renamed from: l */
    private boolean f24944l = false;

    /* renamed from: m */
    private String f24945m = "";

    /* renamed from: n */
    private long f24946n = 0;

    /* renamed from: o */
    private long f24947o = 0;

    /* renamed from: p */
    private long f24948p = 0;

    /* renamed from: q */
    private int f24949q = -1;

    /* renamed from: r */
    private int f24950r = 0;

    /* renamed from: s */
    private Set<String> f24951s = Collections.emptySet();

    /* renamed from: t */
    private JSONObject f24952t = new JSONObject();

    /* renamed from: u */
    private boolean f24953u = true;

    /* renamed from: v */
    private boolean f24954v = true;

    /* renamed from: w */
    private String f24955w = null;

    /* renamed from: a */
    public final void mo30227a(Context context, String str, boolean z) {
        String str2;
        if (str == null) {
            str2 = "admob";
        } else {
            String valueOf = String.valueOf("admob__");
            String valueOf2 = String.valueOf(str);
            str2 = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        this.f24936d = zzaxg.m26094a((Runnable) new C9311ac(this, context, str2));
        this.f24934b = z;
    }

    /* renamed from: o */
    private final void m26036o() {
        zzbbh<?> zzbbh = this.f24936d;
        if (zzbbh != null && !zzbbh.isDone()) {
            try {
                this.f24936d.get(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                zzbad.m26358c("Interrupted while waiting for preferences loaded.", e);
            } catch (CancellationException | ExecutionException | TimeoutException e2) {
                zzbad.m26356b("Fail to initialize AdSharedPreferenceManager.", e2);
            }
        }
    }

    /* renamed from: p */
    private final Bundle m26037p() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("listener_registration_bundle", true);
        synchronized (this.f24933a) {
            bundle.putBoolean("use_https", this.f24941i);
            bundle.putBoolean("content_url_opted_out", this.f24953u);
            bundle.putBoolean("content_vertical_opted_out", this.f24954v);
            bundle.putBoolean("auto_collect_location", this.f24944l);
            bundle.putInt(Updates.COLUMN_VERCODE, this.f24950r);
            bundle.putStringArray("never_pool_slots", (String[]) this.f24951s.toArray(new String[0]));
            bundle.putString("app_settings_json", this.f24945m);
            bundle.putLong("app_settings_last_update_ms", this.f24946n);
            bundle.putLong("app_last_background_time_ms", this.f24947o);
            bundle.putInt("request_in_session_count", this.f24949q);
            bundle.putLong("first_ad_req_time_ms", this.f24948p);
            bundle.putString("native_advanced_settings", this.f24952t.toString());
            bundle.putString("display_cutout", this.f24955w);
            if (this.f24942j != null) {
                bundle.putString("content_url_hashes", this.f24942j);
            }
            if (this.f24943k != null) {
                bundle.putString("content_vertical_hashes", this.f24943k);
            }
        }
        return bundle;
    }

    /* renamed from: a */
    private final void m26035a(Bundle bundle) {
        zzaxg.f24958a.execute(new C9333bc(this));
    }

    /* renamed from: j */
    public final zzuu mo30221j() {
        if (!this.f24934b || !PlatformVersion.m22107a()) {
            return null;
        }
        if (mo30220i() && mo30219h()) {
            return null;
        }
        if (!((Boolean) zzyt.m31536e().mo29599a(zzacu.f24101ha)).booleanValue()) {
            return null;
        }
        synchronized (this.f24933a) {
            if (Looper.getMainLooper() == null) {
                return null;
            }
            if (this.f24937e == null) {
                this.f24937e = new zzuu();
            }
            this.f24937e.mo32291b();
            zzbad.m26357c("start fetching content...");
            zzuu zzuu = this.f24937e;
            return zzuu;
        }
    }

    /* renamed from: a */
    public final void mo30205a(boolean z) {
        m26036o();
        synchronized (this.f24933a) {
            if (this.f24953u != z) {
                this.f24953u = z;
                if (this.f24939g != null) {
                    this.f24939g.putBoolean("content_url_opted_out", z);
                    this.f24939g.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("content_url_opted_out", this.f24953u);
                bundle.putBoolean("content_vertical_opted_out", this.f24954v);
                m26035a(bundle);
            }
        }
    }

    /* renamed from: i */
    public final boolean mo30220i() {
        boolean z;
        m26036o();
        synchronized (this.f24933a) {
            z = this.f24953u;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        return;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo30212c(java.lang.String r4) {
        /*
            r3 = this;
            r3.m26036o()
            java.lang.Object r0 = r3.f24933a
            monitor-enter(r0)
            if (r4 == 0) goto L_0x0032
            java.lang.String r1 = r3.f24942j     // Catch:{ all -> 0x0034 }
            boolean r1 = r4.equals(r1)     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0011
            goto L_0x0032
        L_0x0011:
            r3.f24942j = r4     // Catch:{ all -> 0x0034 }
            android.content.SharedPreferences$Editor r1 = r3.f24939g     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0023
            android.content.SharedPreferences$Editor r1 = r3.f24939g     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "content_url_hashes"
            r1.putString(r2, r4)     // Catch:{ all -> 0x0034 }
            android.content.SharedPreferences$Editor r1 = r3.f24939g     // Catch:{ all -> 0x0034 }
            r1.apply()     // Catch:{ all -> 0x0034 }
        L_0x0023:
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ all -> 0x0034 }
            r1.<init>()     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "content_url_hashes"
            r1.putString(r2, r4)     // Catch:{ all -> 0x0034 }
            r3.m26035a(r1)     // Catch:{ all -> 0x0034 }
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            return
        L_0x0032:
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            return
        L_0x0034:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaxc.mo30212c(java.lang.String):void");
    }

    /* renamed from: b */
    public final String mo30206b() {
        String str;
        m26036o();
        synchronized (this.f24933a) {
            str = this.f24942j;
        }
        return str;
    }

    /* renamed from: b */
    public final void mo30210b(boolean z) {
        m26036o();
        synchronized (this.f24933a) {
            if (this.f24954v != z) {
                this.f24954v = z;
                if (this.f24939g != null) {
                    this.f24939g.putBoolean("content_vertical_opted_out", z);
                    this.f24939g.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("content_url_opted_out", this.f24953u);
                bundle.putBoolean("content_vertical_opted_out", this.f24954v);
                m26035a(bundle);
            }
        }
    }

    /* renamed from: h */
    public final boolean mo30219h() {
        boolean z;
        m26036o();
        synchronized (this.f24933a) {
            z = this.f24954v;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        return;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo30215d(java.lang.String r4) {
        /*
            r3 = this;
            r3.m26036o()
            java.lang.Object r0 = r3.f24933a
            monitor-enter(r0)
            if (r4 == 0) goto L_0x0032
            java.lang.String r1 = r3.f24943k     // Catch:{ all -> 0x0034 }
            boolean r1 = r4.equals(r1)     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0011
            goto L_0x0032
        L_0x0011:
            r3.f24943k = r4     // Catch:{ all -> 0x0034 }
            android.content.SharedPreferences$Editor r1 = r3.f24939g     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0023
            android.content.SharedPreferences$Editor r1 = r3.f24939g     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "content_vertical_hashes"
            r1.putString(r2, r4)     // Catch:{ all -> 0x0034 }
            android.content.SharedPreferences$Editor r1 = r3.f24939g     // Catch:{ all -> 0x0034 }
            r1.apply()     // Catch:{ all -> 0x0034 }
        L_0x0023:
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ all -> 0x0034 }
            r1.<init>()     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "content_vertical_hashes"
            r1.putString(r2, r4)     // Catch:{ all -> 0x0034 }
            r3.m26035a(r1)     // Catch:{ all -> 0x0034 }
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            return
        L_0x0032:
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            return
        L_0x0034:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaxc.mo30215d(java.lang.String):void");
    }

    /* renamed from: n */
    public final String mo30225n() {
        String str;
        m26036o();
        synchronized (this.f24933a) {
            str = this.f24943k;
        }
        return str;
    }

    /* renamed from: c */
    public final void mo30213c(boolean z) {
        m26036o();
        synchronized (this.f24933a) {
            if (this.f24944l != z) {
                this.f24944l = z;
                if (this.f24939g != null) {
                    this.f24939g.putBoolean("auto_collect_location", z);
                    this.f24939g.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("auto_collect_location", z);
                m26035a(bundle);
            }
        }
    }

    /* renamed from: m */
    public final boolean mo30224m() {
        boolean z;
        m26036o();
        synchronized (this.f24933a) {
            z = this.f24944l;
        }
        return z;
    }

    /* renamed from: a */
    public final void mo30200a(int i) {
        m26036o();
        synchronized (this.f24933a) {
            if (this.f24950r != i) {
                this.f24950r = i;
                if (this.f24939g != null) {
                    this.f24939g.putInt(Updates.COLUMN_VERCODE, i);
                    this.f24939g.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putInt(Updates.COLUMN_VERCODE, i);
                m26035a(bundle);
            }
        }
    }

    /* renamed from: l */
    public final int mo30223l() {
        int i;
        m26036o();
        synchronized (this.f24933a) {
            i = this.f24950r;
        }
        return i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005f, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo30203a(java.lang.String r6) {
        /*
            r5 = this;
            r5.m26036o()
            java.lang.Object r0 = r5.f24933a
            monitor-enter(r0)
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzk.zzln()     // Catch:{ all -> 0x0060 }
            long r1 = r1.mo27935b()     // Catch:{ all -> 0x0060 }
            r5.f24946n = r1     // Catch:{ all -> 0x0060 }
            if (r6 == 0) goto L_0x005e
            java.lang.String r3 = r5.f24945m     // Catch:{ all -> 0x0060 }
            boolean r3 = r6.equals(r3)     // Catch:{ all -> 0x0060 }
            if (r3 == 0) goto L_0x001b
            goto L_0x005e
        L_0x001b:
            r5.f24945m = r6     // Catch:{ all -> 0x0060 }
            android.content.SharedPreferences$Editor r3 = r5.f24939g     // Catch:{ all -> 0x0060 }
            if (r3 == 0) goto L_0x0034
            android.content.SharedPreferences$Editor r3 = r5.f24939g     // Catch:{ all -> 0x0060 }
            java.lang.String r4 = "app_settings_json"
            r3.putString(r4, r6)     // Catch:{ all -> 0x0060 }
            android.content.SharedPreferences$Editor r3 = r5.f24939g     // Catch:{ all -> 0x0060 }
            java.lang.String r4 = "app_settings_last_update_ms"
            r3.putLong(r4, r1)     // Catch:{ all -> 0x0060 }
            android.content.SharedPreferences$Editor r3 = r5.f24939g     // Catch:{ all -> 0x0060 }
            r3.apply()     // Catch:{ all -> 0x0060 }
        L_0x0034:
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ all -> 0x0060 }
            r3.<init>()     // Catch:{ all -> 0x0060 }
            java.lang.String r4 = "app_settings_json"
            r3.putString(r4, r6)     // Catch:{ all -> 0x0060 }
            java.lang.String r6 = "app_settings_last_update_ms"
            r3.putLong(r6, r1)     // Catch:{ all -> 0x0060 }
            r5.m26035a(r3)     // Catch:{ all -> 0x0060 }
            java.util.List<java.lang.Runnable> r6 = r5.f24935c     // Catch:{ all -> 0x0060 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0060 }
        L_0x004c:
            boolean r1 = r6.hasNext()     // Catch:{ all -> 0x0060 }
            if (r1 == 0) goto L_0x005c
            java.lang.Object r1 = r6.next()     // Catch:{ all -> 0x0060 }
            java.lang.Runnable r1 = (java.lang.Runnable) r1     // Catch:{ all -> 0x0060 }
            r1.run()     // Catch:{ all -> 0x0060 }
            goto L_0x004c
        L_0x005c:
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            return
        L_0x005e:
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            return
        L_0x0060:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            goto L_0x0064
        L_0x0063:
            throw r6
        L_0x0064:
            goto L_0x0063
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaxc.mo30203a(java.lang.String):void");
    }

    /* renamed from: k */
    public final zzawl mo30222k() {
        zzawl zzawl;
        m26036o();
        synchronized (this.f24933a) {
            zzawl = new zzawl(this.f24945m, this.f24946n);
        }
        return zzawl;
    }

    /* renamed from: a */
    public final void mo30202a(Runnable runnable) {
        this.f24935c.add(runnable);
    }

    /* renamed from: a */
    public final void mo30201a(long j) {
        m26036o();
        synchronized (this.f24933a) {
            if (this.f24947o != j) {
                this.f24947o = j;
                if (this.f24939g != null) {
                    this.f24939g.putLong("app_last_background_time_ms", j);
                    this.f24939g.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putLong("app_last_background_time_ms", j);
                m26035a(bundle);
            }
        }
    }

    /* renamed from: f */
    public final long mo30217f() {
        long j;
        m26036o();
        synchronized (this.f24933a) {
            j = this.f24947o;
        }
        return j;
    }

    /* renamed from: b */
    public final void mo30207b(int i) {
        m26036o();
        synchronized (this.f24933a) {
            if (this.f24949q != i) {
                this.f24949q = i;
                if (this.f24939g != null) {
                    this.f24939g.putInt("request_in_session_count", i);
                    this.f24939g.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putInt("request_in_session_count", i);
                m26035a(bundle);
            }
        }
    }

    /* renamed from: e */
    public final int mo30216e() {
        int i;
        m26036o();
        synchronized (this.f24933a) {
            i = this.f24949q;
        }
        return i;
    }

    /* renamed from: b */
    public final void mo30208b(long j) {
        m26036o();
        synchronized (this.f24933a) {
            if (this.f24948p != j) {
                this.f24948p = j;
                if (this.f24939g != null) {
                    this.f24939g.putLong("first_ad_req_time_ms", j);
                    this.f24939g.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putLong("first_ad_req_time_ms", j);
                m26035a(bundle);
            }
        }
    }

    /* renamed from: d */
    public final long mo30214d() {
        long j;
        m26036o();
        synchronized (this.f24933a) {
            j = this.f24948p;
        }
        return j;
    }

    /* renamed from: a */
    public final void mo30204a(String str, String str2, boolean z) {
        m26036o();
        synchronized (this.f24933a) {
            JSONArray optJSONArray = this.f24952t.optJSONArray(str);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            int length = optJSONArray.length();
            int i = 0;
            while (true) {
                if (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        if (!str2.equals(optJSONObject.optString("template_id"))) {
                            i++;
                        } else if (!z || !optJSONObject.optBoolean("uses_media_view", false)) {
                            length = i;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("template_id", str2);
                jSONObject.put("uses_media_view", z);
                jSONObject.put("timestamp_ms", zzk.zzln().mo27935b());
                optJSONArray.put(length, jSONObject);
                this.f24952t.put(str, optJSONArray);
            } catch (JSONException e) {
                zzbad.m26358c("Could not update native advanced settings", e);
            }
            if (this.f24939g != null) {
                this.f24939g.putString("native_advanced_settings", this.f24952t.toString());
                this.f24939g.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putString("native_advanced_settings", this.f24952t.toString());
            m26035a(bundle);
        }
    }

    /* renamed from: c */
    public final JSONObject mo30211c() {
        JSONObject jSONObject;
        m26036o();
        synchronized (this.f24933a) {
            jSONObject = this.f24952t;
        }
        return jSONObject;
    }

    /* renamed from: g */
    public final void mo30218g() {
        m26036o();
        synchronized (this.f24933a) {
            this.f24952t = new JSONObject();
            if (this.f24939g != null) {
                this.f24939g.remove("native_advanced_settings");
                this.f24939g.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putString("native_advanced_settings", "{}");
            m26035a(bundle);
        }
    }

    /* renamed from: a */
    public final String mo30199a() {
        String str;
        m26036o();
        synchronized (this.f24933a) {
            str = this.f24955w;
        }
        return str;
    }

    /* renamed from: b */
    public final void mo30209b(String str) {
        m26036o();
        synchronized (this.f24933a) {
            if (!TextUtils.equals(this.f24955w, str)) {
                this.f24955w = str;
                if (this.f24939g != null) {
                    this.f24939g.putString("display_cutout", str);
                    this.f24939g.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putString("display_cutout", str);
                m26035a(bundle);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo30226a(Context context, String str) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        Editor edit = sharedPreferences.edit();
        synchronized (this.f24933a) {
            this.f24938f = sharedPreferences;
            this.f24939g = edit;
            if (PlatformVersion.m22115i() && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                z = true;
            }
            this.f24940h = z;
            this.f24941i = this.f24938f.getBoolean("use_https", this.f24941i);
            this.f24953u = this.f24938f.getBoolean("content_url_opted_out", this.f24953u);
            this.f24942j = this.f24938f.getString("content_url_hashes", this.f24942j);
            this.f24944l = this.f24938f.getBoolean("auto_collect_location", this.f24944l);
            this.f24954v = this.f24938f.getBoolean("content_vertical_opted_out", this.f24954v);
            this.f24943k = this.f24938f.getString("content_vertical_hashes", this.f24943k);
            this.f24950r = this.f24938f.getInt(Updates.COLUMN_VERCODE, this.f24950r);
            this.f24945m = this.f24938f.getString("app_settings_json", this.f24945m);
            this.f24946n = this.f24938f.getLong("app_settings_last_update_ms", this.f24946n);
            this.f24947o = this.f24938f.getLong("app_last_background_time_ms", this.f24947o);
            this.f24949q = this.f24938f.getInt("request_in_session_count", this.f24949q);
            this.f24948p = this.f24938f.getLong("first_ad_req_time_ms", this.f24948p);
            this.f24951s = this.f24938f.getStringSet("never_pool_slots", this.f24951s);
            this.f24955w = this.f24938f.getString("display_cutout", this.f24955w);
            try {
                this.f24952t = new JSONObject(this.f24938f.getString("native_advanced_settings", "{}"));
            } catch (JSONException e) {
                zzbad.m26358c("Could not convert native advanced settings to json object", e);
            }
            m26035a(m26037p());
        }
    }
}
