package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.Locale;

public final class zzasf {

    /* renamed from: A */
    private int f24767A;

    /* renamed from: B */
    private String f24768B;

    /* renamed from: C */
    private boolean f24769C;

    /* renamed from: a */
    private int f24770a;

    /* renamed from: b */
    private boolean f24771b;

    /* renamed from: c */
    private boolean f24772c;

    /* renamed from: d */
    private int f24773d;

    /* renamed from: e */
    private int f24774e;

    /* renamed from: f */
    private int f24775f;

    /* renamed from: g */
    private String f24776g;

    /* renamed from: h */
    private int f24777h;

    /* renamed from: i */
    private int f24778i;

    /* renamed from: j */
    private int f24779j;

    /* renamed from: k */
    private boolean f24780k;

    /* renamed from: l */
    private int f24781l;

    /* renamed from: m */
    private double f24782m;

    /* renamed from: n */
    private boolean f24783n;

    /* renamed from: o */
    private String f24784o;

    /* renamed from: p */
    private String f24785p;

    /* renamed from: q */
    private boolean f24786q;

    /* renamed from: r */
    private boolean f24787r;

    /* renamed from: s */
    private String f24788s;

    /* renamed from: t */
    private boolean f24789t;

    /* renamed from: u */
    private final boolean f24790u;

    /* renamed from: v */
    private boolean f24791v;

    /* renamed from: w */
    private String f24792w;

    /* renamed from: x */
    private String f24793x;

    /* renamed from: y */
    private float f24794y;

    /* renamed from: z */
    private int f24795z;

    public zzasf(Context context) {
        PackageManager packageManager = context.getPackageManager();
        m25726a(context);
        m25727b(context);
        m25728c(context);
        Locale locale = Locale.getDefault();
        boolean z = true;
        this.f24786q = m25724a(packageManager, "geo:0,0?q=donuts") != null;
        if (m25724a(packageManager, "http://www.google.com") == null) {
            z = false;
        }
        this.f24787r = z;
        this.f24788s = locale.getCountry();
        zzyt.m31532a();
        this.f24789t = zzazt.m26311a();
        this.f24790u = DeviceProperties.m22092a(context);
        this.f24791v = DeviceProperties.m22093b(context);
        this.f24792w = locale.getLanguage();
        this.f24793x = m25725a(context, packageManager);
        this.f24768B = m25729d(context);
        Resources resources = context.getResources();
        if (resources != null) {
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            if (displayMetrics != null) {
                this.f24794y = displayMetrics.density;
                this.f24795z = displayMetrics.widthPixels;
                this.f24767A = displayMetrics.heightPixels;
            }
        }
    }

    public zzasf(Context context, zzase zzase) {
        m25726a(context);
        m25727b(context);
        m25728c(context);
        this.f24784o = Build.FINGERPRINT;
        this.f24785p = Build.DEVICE;
        this.f24769C = PlatformVersion.m22108b() && zzads.m24825a(context);
        this.f24786q = zzase.f24742b;
        this.f24787r = zzase.f24743c;
        this.f24788s = zzase.f24745e;
        this.f24789t = zzase.f24746f;
        this.f24790u = zzase.f24747g;
        this.f24791v = zzase.f24748h;
        this.f24792w = zzase.f24751k;
        this.f24793x = zzase.f24752l;
        this.f24768B = zzase.f24753m;
        this.f24794y = zzase.f24760t;
        this.f24795z = zzase.f24761u;
        this.f24767A = zzase.f24762v;
    }

    /* renamed from: a */
    private final void m25726a(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            try {
                this.f24770a = audioManager.getMode();
                this.f24771b = audioManager.isMusicActive();
                this.f24772c = audioManager.isSpeakerphoneOn();
                this.f24773d = audioManager.getStreamVolume(3);
                this.f24774e = audioManager.getRingerMode();
                this.f24775f = audioManager.getStreamVolume(2);
                return;
            } catch (Throwable th) {
                zzk.zzlk().mo30168a(th, "DeviceInfo.gatherAudioInfo");
            }
        }
        this.f24770a = -2;
        this.f24771b = false;
        this.f24772c = false;
        this.f24773d = 0;
        this.f24774e = 2;
        this.f24775f = 0;
    }

    @TargetApi(16)
    /* renamed from: b */
    private final void m25727b(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.f24776g = telephonyManager.getNetworkOperator();
        this.f24778i = telephonyManager.getNetworkType();
        this.f24779j = telephonyManager.getPhoneType();
        this.f24777h = -2;
        this.f24780k = false;
        this.f24781l = -1;
        zzk.zzlg();
        if (zzaxi.m26116a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                this.f24777h = activeNetworkInfo.getType();
                this.f24781l = activeNetworkInfo.getDetailedState().ordinal();
            } else {
                this.f24777h = -1;
            }
            if (VERSION.SDK_INT >= 16) {
                this.f24780k = connectivityManager.isActiveNetworkMetered();
            }
        }
    }

    /* renamed from: c */
    private final void m25728c(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            this.f24782m = (double) (((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
            this.f24783n = z;
            return;
        }
        this.f24782m = -1.0d;
        this.f24783n = false;
    }

    /* renamed from: d */
    private static String m25729d(Context context) {
        try {
            PackageInfo b = Wrappers.m22139a(context).mo27947b("com.android.vending", 128);
            if (b == null) {
                return null;
            }
            int i = b.versionCode;
            String str = b.packageName;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
            sb.append(i);
            sb.append(".");
            sb.append(str);
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    private static String m25725a(Context context, PackageManager packageManager) {
        ResolveInfo a = m25724a(packageManager, "market://details?id=com.google.android.gms.ads");
        if (a == null) {
            return null;
        }
        ActivityInfo activityInfo = a.activityInfo;
        if (activityInfo == null) {
            return null;
        }
        try {
            PackageInfo b = Wrappers.m22139a(context).mo27947b(activityInfo.packageName, 0);
            if (b == null) {
                return null;
            }
            int i = b.versionCode;
            String str = activityInfo.packageName;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
            sb.append(i);
            sb.append(".");
            sb.append(str);
            return sb.toString();
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    /* renamed from: a */
    private static ResolveInfo m25724a(PackageManager packageManager, String str) {
        try {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
        } catch (Throwable th) {
            zzk.zzlk().mo30168a(th, "DeviceInfo.getResolveInfo");
            return null;
        }
    }

    /* renamed from: a */
    public final zzase mo30044a() {
        zzase zzase = new zzase(this.f24770a, this.f24786q, this.f24787r, this.f24776g, this.f24788s, this.f24789t, this.f24790u, this.f24791v, this.f24771b, this.f24772c, this.f24792w, this.f24793x, this.f24768B, this.f24773d, this.f24777h, this.f24778i, this.f24779j, this.f24774e, this.f24775f, this.f24794y, this.f24795z, this.f24767A, this.f24782m, this.f24783n, this.f24780k, this.f24781l, this.f24784o, this.f24769C, this.f24785p);
        return zzase;
    }
}
