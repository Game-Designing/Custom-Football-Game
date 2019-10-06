package p019d.p273h.p276c.p280d;

import android.util.Log;
import p019d.p273h.p276c.p280d.C12800c.C12801a;

/* renamed from: d.h.c.d.a */
/* compiled from: ConsoleLogger */
public class C12798a extends C12800c {
    public C12798a(int debugLevel) {
        super("console", debugLevel);
    }

    /* renamed from: b */
    public void mo41427b(C12801a tag, String message, int logLevel) {
        String str = "";
        if (logLevel == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(tag);
            Log.v(sb.toString(), message);
        } else if (logLevel == 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(tag);
            Log.i(sb2.toString(), message);
        } else if (logLevel == 2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(tag);
            Log.w(sb3.toString(), message);
        } else if (logLevel == 3) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append(tag);
            Log.e(sb4.toString(), message);
        }
    }

    /* renamed from: a */
    public void mo41426a(C12801a tag, String message, Throwable e) {
        StringBuilder sb = new StringBuilder();
        sb.append(message);
        sb.append(":stacktrace[");
        sb.append(Log.getStackTraceString(e));
        sb.append("]");
        mo41427b(tag, sb.toString(), 3);
    }
}
