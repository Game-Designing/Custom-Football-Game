package com.flurry.sdk;

import android.content.Context;
import com.flurry.sdk.C7607ud.C7608a;
import java.lang.Thread.UncaughtExceptionHandler;

/* renamed from: com.flurry.sdk.Kd */
public class C7409Kd implements C7530hc, C7608a, UncaughtExceptionHandler {

    /* renamed from: a */
    private static final String f14523a = C7409Kd.class.getSimpleName();

    /* renamed from: b */
    private boolean f14524b;

    /* renamed from: a */
    public void mo23850a(Context context) {
        C7602td a = C7602td.m16825a();
        this.f14524b = ((Boolean) a.mo24023a("CaptureUncaughtExceptions")).booleanValue();
        a.mo24024a("CaptureUncaughtExceptions", (C7608a) this);
        String str = f14523a;
        StringBuilder sb = new StringBuilder("initSettings, CrashReportingEnabled = ");
        sb.append(this.f14524b);
        C7513ec.m16639a(4, str, sb.toString());
        C7415Ld a2 = C7415Ld.m16411a();
        synchronized (a2.f14539c) {
            a2.f14539c.put(this, null);
        }
    }

    /* renamed from: a */
    public final void mo23820a(String str, Object obj) {
        if (str.equals("CaptureUncaughtExceptions")) {
            this.f14524b = ((Boolean) obj).booleanValue();
            String str2 = f14523a;
            StringBuilder sb = new StringBuilder("onSettingUpdate, CrashReportingEnabled = ");
            sb.append(this.f14524b);
            C7513ec.m16639a(4, str2, sb.toString());
            return;
        }
        C7513ec.m16639a(6, f14523a, "onSettingUpdate internal error!");
    }

    public void uncaughtException(Thread thread, Throwable th) {
        String str;
        th.printStackTrace();
        if (this.f14524b) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                StringBuilder sb = new StringBuilder();
                if (th.getMessage() != null) {
                    sb.append(" (");
                    sb.append(th.getMessage());
                    sb.append(")\n");
                }
                str = sb.toString();
            } else if (th.getMessage() != null) {
                str = th.getMessage();
            } else {
                str = "";
            }
            C7449Rd.m16479a().mo23893a("uncaught", str, th, null);
        }
        C7585qd.m16785a().mo24001b();
        C7547kb.m16712a().mo23967e();
    }
}
