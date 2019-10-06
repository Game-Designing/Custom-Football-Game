package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import com.google.android.gms.ads.internal.zzk;
import java.io.InputStream;
import java.util.Map;

@TargetApi(14)
@zzard
public class zzaxo {
    /* renamed from: a */
    public boolean mo30255a(View view) {
        return (view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true;
    }

    /* renamed from: a */
    public boolean mo30254a(Context context, WebSettings webSettings) {
        return ((Boolean) zzazl.m26284a(context, new C9487ic(context, webSettings))).booleanValue();
    }

    /* renamed from: a */
    public static boolean m26163a(zzbgz zzbgz) {
        if (zzbgz == null) {
            return false;
        }
        zzbgz.onPause();
        return true;
    }

    /* renamed from: b */
    public static boolean m26164b(zzbgz zzbgz) {
        if (zzbgz == null) {
            return false;
        }
        zzbgz.onResume();
        return true;
    }

    /* renamed from: a */
    public int mo30243a() {
        return 5;
    }

    /* renamed from: a */
    public String mo30249a(Context context) {
        return "";
    }

    /* renamed from: b */
    public void mo30258b(Context context) {
    }

    /* renamed from: a */
    public zzbha mo30247a(zzbgz zzbgz, zzwj zzwj, boolean z) {
        return new zzbhz(zzbgz, zzwj, z);
    }

    /* renamed from: a */
    public void mo30252a(ViewTreeObserver viewTreeObserver, OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
    }

    /* renamed from: b */
    public LayoutParams mo30257b() {
        return new LayoutParams(-2, -2);
    }

    /* renamed from: a */
    public void mo30251a(View view, Drawable drawable) {
        view.setBackgroundDrawable(drawable);
    }

    /* renamed from: a */
    public Drawable mo30245a(Context context, Bitmap bitmap, boolean z, float f) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    /* renamed from: c */
    public static boolean m26165c() {
        int myUid = Process.myUid();
        return myUid == 0 || myUid == 1000;
    }

    /* renamed from: c */
    public CookieManager mo30259c(Context context) {
        if (m26165c()) {
            return null;
        }
        try {
            CookieSyncManager.createInstance(context);
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzbad.m26356b("Failed to obtain CookieManager.", th);
            zzk.zzlk().mo30168a(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    /* renamed from: d */
    public int mo30260d() {
        return 1;
    }

    /* renamed from: a */
    public zzwx mo30248a(Context context, TelephonyManager telephonyManager) {
        return zzwx.ENUM_UNKNOWN;
    }

    /* renamed from: a */
    public int mo30244a(ContentResolver contentResolver) {
        return System.getInt(contentResolver, "wifi_on", 0);
    }

    /* renamed from: b */
    public int mo30256b(ContentResolver contentResolver) {
        return System.getInt(contentResolver, "airplane_mode_on", 0);
    }

    /* renamed from: a */
    public WebResourceResponse mo30246a(String str, String str2, int i, String str3, Map<String, String> map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, inputStream);
    }

    /* renamed from: a */
    public boolean mo30253a(Activity activity, Configuration configuration) {
        return false;
    }

    /* renamed from: a */
    public void mo30250a(Activity activity) {
    }

    private zzaxo() {
    }

    /* renamed from: a */
    public static zzaxo m26162a(int i) {
        if (i >= 28) {
            return new zzaxy();
        }
        if (i >= 26) {
            return new zzaxx();
        }
        if (i >= 24) {
            return new zzaxw();
        }
        if (i >= 21) {
            return new zzaxv();
        }
        if (i >= 19) {
            return new zzaxu();
        }
        if (i >= 18) {
            return new zzaxs();
        }
        if (i >= 17) {
            return new zzaxr();
        }
        if (i >= 16) {
            return new zzaxt();
        }
        return new zzaxo();
    }
}
