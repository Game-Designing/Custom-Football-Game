package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@zzard
public final class zzaqx implements zzarb {

    /* renamed from: a */
    private static final Object f24587a = new Object();
    @VisibleForTesting

    /* renamed from: b */
    private static zzarb f24588b = null;
    @VisibleForTesting

    /* renamed from: c */
    private static zzarb f24589c = null;

    /* renamed from: d */
    private final Object f24590d;

    /* renamed from: e */
    private final Context f24591e;

    /* renamed from: f */
    private final WeakHashMap<Thread, Boolean> f24592f;

    /* renamed from: g */
    private final ExecutorService f24593g;

    /* renamed from: h */
    private final zzbai f24594h;

    /* renamed from: a */
    public static zzarb m25684a(Context context) {
        synchronized (f24587a) {
            if (f24588b == null) {
                if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24124l)).booleanValue()) {
                    f24588b = new zzaqx(context);
                } else {
                    f24588b = new zzarc();
                }
            }
        }
        return f24588b;
    }

    /* renamed from: a */
    public static zzarb m25685a(Context context, zzbai zzbai) {
        synchronized (f24587a) {
            if (f24589c == null) {
                if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24124l)).booleanValue()) {
                    zzaqx zzaqx = new zzaqx(context, zzbai);
                    Thread thread = Looper.getMainLooper().getThread();
                    if (thread != null) {
                        synchronized (zzaqx.f24590d) {
                            zzaqx.f24592f.put(thread, Boolean.valueOf(true));
                        }
                        thread.setUncaughtExceptionHandler(new C9640pb(zzaqx, thread.getUncaughtExceptionHandler()));
                    }
                    Thread.setDefaultUncaughtExceptionHandler(new C9618ob(zzaqx, Thread.getDefaultUncaughtExceptionHandler()));
                    f24589c = zzaqx;
                } else {
                    f24589c = new zzarc();
                }
            }
        }
        return f24589c;
    }

    private zzaqx(Context context) {
        this(context, zzbai.m26367a());
    }

    private zzaqx(Context context, zzbai zzbai) {
        this.f24590d = new Object();
        this.f24592f = new WeakHashMap<>();
        this.f24593g = Executors.newCachedThreadPool();
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.f24591e = context;
        this.f24594h = zzbai;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
        if (r3 == false) goto L_0x0043;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo30005a(java.lang.Thread r10, java.lang.Throwable r11) {
        /*
            r9 = this;
            r10 = 1
            r0 = 0
            if (r11 == 0) goto L_0x0042
            r1 = r11
            r2 = 0
            r3 = 0
        L_0x0009:
            if (r1 == 0) goto L_0x003d
            java.lang.StackTraceElement[] r4 = r1.getStackTrace()
            int r5 = r4.length
            r6 = r3
            r3 = r2
            r2 = 0
        L_0x0013:
            if (r2 >= r5) goto L_0x0036
            r7 = r4[r2]
            java.lang.String r8 = r7.getClassName()
            boolean r8 = com.google.android.gms.internal.ads.zzazt.m26315b(r8)
            if (r8 == 0) goto L_0x0022
            r3 = 1
        L_0x0022:
            java.lang.Class<com.google.android.gms.internal.ads.zzaqx> r8 = com.google.android.gms.internal.ads.zzaqx.class
            java.lang.String r8 = r8.getName()
            java.lang.String r7 = r7.getClassName()
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L_0x0033
            r6 = 1
        L_0x0033:
            int r2 = r2 + 1
            goto L_0x0013
        L_0x0036:
            java.lang.Throwable r1 = r1.getCause()
            r2 = r3
            r3 = r6
            goto L_0x0009
        L_0x003d:
            if (r2 == 0) goto L_0x0042
            if (r3 != 0) goto L_0x0042
            goto L_0x0043
        L_0x0042:
            r10 = 0
        L_0x0043:
            if (r10 == 0) goto L_0x004e
            r10 = 1065353216(0x3f800000, float:1.0)
            java.lang.String r0 = ""
            r9.mo30007a(r11, r0, r10)
        L_0x004e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqx.mo30005a(java.lang.Thread, java.lang.Throwable):void");
    }

    /* renamed from: a */
    public final void mo30006a(Throwable th, String str) {
        mo30007a(th, str, 1.0f);
    }

    /* renamed from: a */
    public final void mo30007a(Throwable th, String str, float f) {
        if (zzazt.m26307a(th) != null) {
            String name = th.getClass().getName();
            StringWriter stringWriter = new StringWriter();
            zzdmb.m29636a(th, new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            int i = 0;
            int i2 = 1;
            boolean z = Math.random() < ((double) f);
            if (f > 0.0f) {
                i2 = (int) (1.0f / f);
            }
            if (z) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(m25683a(name, stringWriter2, str, i2).toString());
                int size = arrayList.size();
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    this.f24593g.submit(new C9661qb(this, new zzbah(), (String) obj));
                }
            }
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    private final Builder m25683a(String str, String str2, String str3, int i) {
        boolean z;
        String str4;
        try {
            z = Wrappers.m22139a(this.f24591e).mo27945a();
        } catch (Throwable th) {
            zzbad.m26356b("Error fetching instant app info", th);
            z = false;
        }
        try {
            str4 = this.f24591e.getPackageName();
        } catch (Throwable th2) {
            zzbad.m26359d("Cannot obtain package name, proceeding.");
            str4 = "unknown";
        }
        String str5 = "os";
        String str6 = "api";
        Builder appendQueryParameter = new Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(z)).appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter(str5, VERSION.RELEASE).appendQueryParameter(str6, String.valueOf(VERSION.SDK_INT));
        String str7 = Build.MANUFACTURER;
        String str8 = Build.MODEL;
        if (!str8.startsWith(str7)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str7).length() + 1 + String.valueOf(str8).length());
            sb.append(str7);
            sb.append(" ");
            sb.append(str8);
            str8 = sb.toString();
        }
        String str9 = "session_id";
        String str10 = "sampling_rate";
        return appendQueryParameter.appendQueryParameter("device", str8).appendQueryParameter("js", this.f24594h.f25057a).appendQueryParameter("appid", str4).appendQueryParameter("exceptiontype", str).appendQueryParameter("stacktrace", str2).appendQueryParameter("eids", TextUtils.join(",", zzacu.m24781a())).appendQueryParameter("exceptionkey", str3).appendQueryParameter("cl", "248613007").appendQueryParameter("rc", "dev").appendQueryParameter(str9, zzyt.m31537f()).appendQueryParameter(str10, Integer.toString(i)).appendQueryParameter("pb_tm", String.valueOf(zzyt.m31536e().mo29599a(zzacu.f23949Ie)));
    }
}
