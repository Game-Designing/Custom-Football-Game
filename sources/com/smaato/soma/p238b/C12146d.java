package com.smaato.soma.p238b;

import android.util.Log;

/* renamed from: com.smaato.soma.b.d */
/* compiled from: Debugger */
public class C12146d {

    /* renamed from: a */
    public static int f38074a = 1;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static String f38075b = "SOMA_";

    /* renamed from: c */
    private static boolean f38076c = true;

    /* renamed from: a */
    public static final void m39965a(C12147e message) {
        if (message.mo39383c() <= f38074a) {
            m39967b(message);
        }
    }

    /* renamed from: b */
    private static void m39967b(C12147e message) {
        switch (C12145c.f38073a[message.mo39381a().ordinal()]) {
            case 1:
                StringBuilder sb = new StringBuilder();
                sb.append(f38075b);
                sb.append(message.mo39385e());
                Log.d(sb.toString(), message.mo39384d());
                return;
            case 2:
                StringBuilder sb2 = new StringBuilder();
                sb2.append(f38075b);
                sb2.append(message.mo39385e());
                Log.e(sb2.toString(), message.mo39384d());
                return;
            case 3:
                StringBuilder sb3 = new StringBuilder();
                sb3.append(f38075b);
                sb3.append(message.mo39385e());
                Log.i(sb3.toString(), message.mo39384d());
                return;
            case 4:
                StringBuilder sb4 = new StringBuilder();
                sb4.append(f38075b);
                sb4.append(message.mo39385e());
                Log.v(sb4.toString(), message.mo39384d());
                return;
            case 5:
                StringBuilder sb5 = new StringBuilder();
                sb5.append(f38075b);
                sb5.append(message.mo39385e());
                Log.w(sb5.toString(), message.mo39384d());
                return;
            case 6:
                StringBuilder sb6 = new StringBuilder();
                sb6.append(f38075b);
                sb6.append(message.mo39385e());
                Log.e(sb6.toString(), "", message.mo39382b());
                return;
            default:
                StringBuilder sb7 = new StringBuilder();
                sb7.append(f38075b);
                sb7.append("DEBUG");
                Log.w(sb7.toString(), "Should not happen !!");
                return;
        }
    }

    /* renamed from: a */
    public static void m39966a(Object o) {
        if (f38074a == 3) {
            new C12144b(o).execute();
        }
    }
}
