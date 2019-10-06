package com.moat.analytics.mobile.inm;

import android.os.Build.VERSION;
import android.util.Base64;
import android.util.Log;
import java.net.URLEncoder;
import java.util.Locale;

/* renamed from: com.moat.analytics.mobile.inm.m */
class C10960m extends Exception {

    /* renamed from: a */
    private static final Long f33519a = Long.valueOf(60000);

    /* renamed from: b */
    private static Long f33520b;

    /* renamed from: c */
    private static Exception f33521c = null;

    C10960m(String str) {
        super(str);
    }

    /* renamed from: a */
    static String m36075a(String str, Exception exc) {
        if (exc instanceof C10960m) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" failed: ");
            sb.append(exc.getMessage());
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" failed unexpectedly");
        return sb2.toString();
    }

    /* renamed from: a */
    static void m36076a() {
        Exception exc = f33521c;
        if (exc != null) {
            m36078b(exc);
            f33521c = null;
        }
    }

    /* renamed from: a */
    static void m36077a(Exception exc) {
        if (C10984w.m36151a().f33562b) {
            Log.e("MoatException", Log.getStackTraceString(exc));
            return;
        }
        m36078b(exc);
    }

    /* renamed from: b */
    private static void m36078b(Exception exc) {
        String str;
        String str2;
        String str3 = "";
        try {
            if (C10984w.m36151a().f33561a == C10992d.ON) {
                int i = C10984w.m36151a().f33565e;
                if (i != 0) {
                    if (i < 100) {
                        double d = (double) i;
                        Double.isNaN(d);
                        if (d / 100.0d < Math.random()) {
                            return;
                        }
                    }
                    StringBuilder sb = new StringBuilder("https://px.moatads.com/pixel.gif?e=0&i=MOATSDK1&ac=1");
                    StringBuilder sb2 = new StringBuilder("&zt=");
                    sb2.append(exc instanceof C10960m ? 1 : 0);
                    sb.append(sb2.toString());
                    StringBuilder sb3 = new StringBuilder("&zr=");
                    sb3.append(i);
                    sb.append(sb3.toString());
                    try {
                        StringBuilder sb4 = new StringBuilder("&zm=");
                        String str4 = "UTF-8";
                        sb4.append(exc.getMessage() == null ? "null" : URLEncoder.encode(Base64.encodeToString(exc.getMessage().getBytes(str4), 0), str4));
                        sb.append(sb4.toString());
                        StringBuilder sb5 = new StringBuilder("&k=");
                        sb5.append(URLEncoder.encode(Base64.encodeToString(Log.getStackTraceString(exc).getBytes(str4), 0), str4));
                        sb.append(sb5.toString());
                    } catch (Exception e) {
                    }
                    String str5 = "INM";
                    try {
                        sb.append("&zMoatMMAKv=c334ae83accfebb8da23104450c896463c9cfab7");
                        str2 = "2.5.0";
                        try {
                            C10974a d2 = C10972s.m36127d();
                            StringBuilder sb6 = new StringBuilder("&zMoatMMAKan=");
                            sb6.append(d2.mo35972a());
                            sb.append(sb6.toString());
                            str = d2.mo35973b();
                            try {
                                str3 = Integer.toString(VERSION.SDK_INT);
                            } catch (Exception e2) {
                            }
                        } catch (Exception e3) {
                            str = str3;
                        }
                    } catch (Exception e4) {
                        str2 = str3;
                        str = str2;
                    }
                    StringBuilder sb7 = new StringBuilder("&d=Android:");
                    sb7.append(str5);
                    sb7.append(":");
                    sb7.append(str);
                    sb7.append(":-");
                    sb.append(sb7.toString());
                    StringBuilder sb8 = new StringBuilder("&bo=");
                    sb8.append(str2);
                    sb.append(sb8.toString());
                    StringBuilder sb9 = new StringBuilder("&bd=");
                    sb9.append(str3);
                    sb.append(sb9.toString());
                    Long valueOf = Long.valueOf(System.currentTimeMillis());
                    StringBuilder sb10 = new StringBuilder("&t=");
                    sb10.append(valueOf);
                    sb.append(sb10.toString());
                    StringBuilder sb11 = new StringBuilder("&de=");
                    sb11.append(String.format(Locale.ROOT, "%.0f", new Object[]{Double.valueOf(Math.floor(Math.random() * Math.pow(10.0d, 12.0d)))}));
                    sb.append(sb11.toString());
                    sb.append("&cs=0");
                    if (f33520b == null || valueOf.longValue() - f33520b.longValue() > f33519a.longValue()) {
                        C10970q.m36120b(sb.toString());
                        f33520b = valueOf;
                    }
                    return;
                }
                return;
            }
            f33521c = exc;
        } catch (Exception e5) {
        }
    }
}
