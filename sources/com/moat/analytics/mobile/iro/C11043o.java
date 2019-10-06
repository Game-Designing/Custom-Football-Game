package com.moat.analytics.mobile.iro;

import android.os.Build.VERSION;
import android.util.Base64;
import android.util.Log;
import java.net.URLEncoder;
import java.util.Locale;

/* renamed from: com.moat.analytics.mobile.iro.o */
final class C11043o extends Exception {

    /* renamed from: ˋ */
    private static Exception f33757 = null;

    /* renamed from: ˎ */
    private static Long f33758;

    /* renamed from: ˏ */
    private static final Long f33759 = Long.valueOf(60000);

    C11043o(String str) {
        super(str);
    }

    /* renamed from: ॱ */
    static String m36350(String str, Exception exc) {
        if (exc instanceof C11043o) {
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

    /* renamed from: ॱ */
    static void m36351(Exception exc) {
        if (C11054t.m36390().f33796) {
            Log.e("MoatException", Log.getStackTraceString(exc));
            return;
        }
        m36349(exc);
    }

    /* renamed from: ˊ */
    private static void m36349(Exception exc) {
        String str;
        String str2;
        String str3 = "";
        try {
            if (C11054t.m36390().f33794 == C11060c.f33811) {
                int i = C11054t.m36390().f33792;
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
                    sb2.append(exc instanceof C11043o ? 1 : 0);
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
                    String str5 = "IRO";
                    try {
                        sb.append("&zMoatMMAKv=2bc3418b93f01686fcbd1ebebcc04694651821b2");
                        str2 = "2.4.0";
                        try {
                            C11047b r2 = C11044p.m36358();
                            StringBuilder sb6 = new StringBuilder("&zMoatMMAKan=");
                            sb6.append(r2.mo36122());
                            sb.append(sb6.toString());
                            str = r2.mo36121();
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
                    if (f33758 == null || valueOf.longValue() - f33758.longValue() > f33759.longValue()) {
                        new Thread(sb.toString()) {

                            /* renamed from: ˎ */
                            private /* synthetic */ String f33747;

                            {
                                this.f33747 = r1;
                            }

                            public final void run() {
                                try {
                                    C11035l.m36343(this.f33747);
                                } catch (Exception e) {
                                }
                            }
                        }.start();
                        f33758 = valueOf;
                    }
                    return;
                }
                return;
            }
            f33757 = exc;
        } catch (Exception e5) {
        }
    }

    /* renamed from: ˊ */
    static void m36348() {
        Exception exc = f33757;
        if (exc != null) {
            m36349(exc);
            f33757 = null;
        }
    }
}
