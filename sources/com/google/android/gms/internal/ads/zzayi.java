package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.BuildConfig;

@zzard
public final class zzayi {

    /* renamed from: a */
    private final Object f24984a = new Object();

    /* renamed from: b */
    private String f24985b;

    /* renamed from: c */
    private String f24986c;

    /* renamed from: d */
    private boolean f24987d;
    @VisibleForTesting

    /* renamed from: e */
    private String f24988e;

    public zzayi() {
        String str = "";
        this.f24985b = str;
        this.f24986c = str;
        this.f24987d = false;
        this.f24988e = str;
    }

    /* renamed from: a */
    public final void mo30279a(Context context, String str, String str2) {
        if (!m26230b(context, str, str2)) {
            m26229a(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
            return;
        }
        if ("2".equals(this.f24988e)) {
            zzbad.m26352a("Creative is not pushed for this device.");
            m26229a(context, "There was no creative pushed from DFP to the device.", false, false);
            return;
        }
        if ("1".equals(this.f24988e)) {
            zzbad.m26352a("The app is not linked for creative preview.");
            m26235e(context, str, str2);
            return;
        }
        if (BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID.equals(this.f24988e)) {
            zzbad.m26352a("Device is linked for in app preview.");
            m26229a(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    /* renamed from: a */
    public final void mo30280a(Context context, String str, String str2, String str3) {
        boolean b = mo30281b();
        if (m26232c(context, str, str2)) {
            if (!b && !TextUtils.isEmpty(str3)) {
                m26231c(context, str2, str3, str);
            }
            zzbad.m26352a("Device is linked for debug signals.");
            m26229a(context, "The device is successfully linked for troubleshooting.", false, true);
            return;
        }
        m26235e(context, str, str2);
    }

    @VisibleForTesting
    /* renamed from: b */
    private final boolean m26230b(Context context, String str, String str2) {
        String d = m26234d(context, m26233d(context, (String) zzyt.m31536e().mo29599a(zzacu.f23936Gd), str, str2).toString(), str2);
        if (TextUtils.isEmpty(d)) {
            zzbad.m26352a("Not linked for in app preview.");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(d.trim());
            String optString = jSONObject.optString("gct");
            this.f24988e = jSONObject.optString("status");
            synchronized (this.f24984a) {
                this.f24986c = optString;
            }
            return true;
        } catch (JSONException e) {
            zzbad.m26358c("Fail to get in app preview response json.", e);
            return false;
        }
    }

    @VisibleForTesting
    /* renamed from: c */
    private final boolean m26232c(Context context, String str, String str2) {
        String d = m26234d(context, m26233d(context, (String) zzyt.m31536e().mo29599a(zzacu.f23942Hd), str, str2).toString(), str2);
        if (TextUtils.isEmpty(d)) {
            zzbad.m26352a("Not linked for debug signals.");
            return false;
        }
        try {
            boolean equals = "1".equals(new JSONObject(d.trim()).optString("debug_mode"));
            synchronized (this.f24984a) {
                this.f24987d = equals;
            }
            return equals;
        } catch (JSONException e) {
            zzbad.m26358c("Fail to get debug mode response json.", e);
            return false;
        }
    }

    @VisibleForTesting
    /* renamed from: d */
    private static String m26234d(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", zzk.zzlg().mo30237b(context, str2));
        zzbbh a = new zzayu(context).mo30295a(str, hashMap);
        try {
            return (String) a.get((long) ((Integer) zzyt.m31536e().mo29599a(zzacu.f23954Jd)).intValue(), TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            String str3 = "Timeout while retriving a response from: ";
            String valueOf = String.valueOf(str);
            zzbad.m26356b(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3), e);
            a.cancel(true);
            return null;
        } catch (InterruptedException e2) {
            String str4 = "Interrupted while retriving a response from: ";
            String valueOf2 = String.valueOf(str);
            zzbad.m26356b(valueOf2.length() != 0 ? str4.concat(valueOf2) : new String(str4), e2);
            a.cancel(true);
            return null;
        } catch (Exception e3) {
            String str5 = "Error retriving a response from: ";
            String valueOf3 = String.valueOf(str);
            zzbad.m26356b(valueOf3.length() != 0 ? str5.concat(valueOf3) : new String(str5), e3);
            return null;
        }
    }

    /* renamed from: e */
    private final void m26235e(Context context, String str, String str2) {
        zzk.zzlg();
        zzaxi.m26110a(context, m26233d(context, (String) zzyt.m31536e().mo29599a(zzacu.f23930Fd), str, str2));
    }

    /* renamed from: b */
    public final boolean mo30282b(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || !zzk.zzlq().mo30281b()) {
            return false;
        }
        zzbad.m26352a("Sending troubleshooting signals to the server.");
        m26231c(context, str, str2, str3);
        return true;
    }

    /* renamed from: c */
    private final void m26231c(Context context, String str, String str2, String str3) {
        Builder buildUpon = m26233d(context, (String) zzyt.m31536e().mo29599a(zzacu.f23948Id), str3, str).buildUpon();
        buildUpon.appendQueryParameter("debugData", str2);
        zzk.zzlg();
        zzaxi.m26111a(context, str, buildUpon.build().toString());
    }

    /* renamed from: d */
    private final Uri m26233d(Context context, String str, String str2, String str3) {
        Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("linkedDeviceId", m26228a(context));
        buildUpon.appendQueryParameter("adSlotPath", str2);
        buildUpon.appendQueryParameter("afmaVersion", str3);
        return buildUpon.build();
    }

    /* renamed from: a */
    private final String m26228a(Context context) {
        String str;
        synchronized (this.f24984a) {
            if (TextUtils.isEmpty(this.f24985b)) {
                zzk.zzlg();
                this.f24985b = zzaxi.m26128c(context, "debug_signals_id.txt");
                if (TextUtils.isEmpty(this.f24985b)) {
                    zzk.zzlg();
                    this.f24985b = zzaxi.m26104a();
                    zzk.zzlg();
                    zzaxi.m26123b(context, "debug_signals_id.txt", this.f24985b);
                }
            }
            str = this.f24985b;
        }
        return str;
    }

    /* renamed from: a */
    public final String mo30278a() {
        String str;
        synchronized (this.f24984a) {
            str = this.f24986c;
        }
        return str;
    }

    /* renamed from: b */
    public final boolean mo30281b() {
        boolean z;
        synchronized (this.f24984a) {
            z = this.f24987d;
        }
        return z;
    }

    @VisibleForTesting
    /* renamed from: a */
    private final void m26229a(Context context, String str, boolean z, boolean z2) {
        if (!(context instanceof Activity)) {
            zzbad.m26357c("Can not create dialog without Activity Context");
            return;
        }
        Handler handler = zzaxi.f24961a;
        C9683rc rcVar = new C9683rc(this, context, str, z, z2);
        handler.post(rcVar);
    }
}
