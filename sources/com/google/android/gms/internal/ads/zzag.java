package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class zzag {

    /* renamed from: a */
    private static String f24299a;

    /* renamed from: b */
    public static boolean f24300b;

    /* renamed from: c */
    private static final String f24301c = zzag.class.getName();

    /* renamed from: com.google.android.gms.internal.ads.zzag$a */
    static class C9869a {

        /* renamed from: a */
        public static final boolean f24302a = zzag.f24300b;

        /* renamed from: b */
        private final List<C9827y> f24303b = new ArrayList();

        /* renamed from: c */
        private boolean f24304c = false;

        C9869a() {
        }

        /* renamed from: a */
        public final synchronized void mo29704a(String str, long j) {
            if (!this.f24304c) {
                List<C9827y> list = this.f24303b;
                C9827y yVar = new C9827y(str, j, SystemClock.elapsedRealtime());
                list.add(yVar);
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        /* renamed from: a */
        public final synchronized void mo29703a(String str) {
            long j;
            this.f24304c = true;
            if (this.f24303b.size() == 0) {
                j = 0;
            } else {
                j = ((C9827y) this.f24303b.get(this.f24303b.size() - 1)).f23512c - ((C9827y) this.f24303b.get(0)).f23512c;
            }
            if (j > 0) {
                long j2 = ((C9827y) this.f24303b.get(0)).f23512c;
                zzag.m24966a("(%-4d ms) %s", Long.valueOf(j), str);
                for (C9827y yVar : this.f24303b) {
                    long j3 = yVar.f23512c;
                    zzag.m24966a("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(yVar.f23511b), yVar.f23510a);
                    j2 = j3;
                }
            }
        }

        /* access modifiers changed from: protected */
        public final void finalize() throws Throwable {
            if (!this.f24304c) {
                mo29703a("Request on the loose");
                zzag.m24968b("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }
    }

    /* renamed from: c */
    public static void m24969c(String str, Object... objArr) {
        if (f24300b) {
            Log.v(f24299a, m24970d(str, objArr));
        }
    }

    /* renamed from: a */
    public static void m24966a(String str, Object... objArr) {
        Log.d(f24299a, m24970d(str, objArr));
    }

    /* renamed from: b */
    public static void m24968b(String str, Object... objArr) {
        Log.e(f24299a, m24970d(str, objArr));
    }

    /* renamed from: a */
    public static void m24967a(Throwable th, String str, Object... objArr) {
        Log.e(f24299a, m24970d(str, objArr), th);
    }

    /* renamed from: d */
    private static String m24970d(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i].getClassName().equals(f24301c)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                String substring2 = substring.substring(substring.lastIndexOf(36) + 1);
                String methodName = stackTrace[i].getMethodName();
                StringBuilder sb = new StringBuilder(String.valueOf(substring2).length() + 1 + String.valueOf(methodName).length());
                sb.append(substring2);
                sb.append(".");
                sb.append(methodName);
                str2 = sb.toString();
                break;
            } else {
                i++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, str});
    }

    static {
        String str = "Volley";
        f24299a = str;
        f24300b = Log.isLoggable(str, 2);
    }
}
