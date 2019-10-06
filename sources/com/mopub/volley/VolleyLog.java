package com.mopub.volley;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class VolleyLog {
    public static boolean DEBUG = Log.isLoggable(TAG, 2);
    public static String TAG = "Volley";

    /* renamed from: a */
    private static final String f36461a = VolleyLog.class.getName();

    /* renamed from: com.mopub.volley.VolleyLog$a */
    static class C11684a {
        public static final boolean ENABLED = VolleyLog.DEBUG;

        /* renamed from: a */
        private final List<C11685a> f36462a = new ArrayList();

        /* renamed from: b */
        private boolean f36463b = false;

        /* renamed from: com.mopub.volley.VolleyLog$a$a */
        private static class C11685a {
            public final String name;
            public final long thread;
            public final long time;

            public C11685a(String name2, long thread2, long time2) {
                this.name = name2;
                this.thread = thread2;
                this.time = time2;
            }
        }

        C11684a() {
        }

        public synchronized void add(String name, long threadId) {
            if (!this.f36463b) {
                List<C11685a> list = this.f36462a;
                C11685a aVar = new C11685a(name, threadId, SystemClock.elapsedRealtime());
                list.add(aVar);
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        public synchronized void finish(String header) {
            synchronized (this) {
                this.f36463b = true;
                long duration = m38607a();
                if (duration > 0) {
                    long prevTime = ((C11685a) this.f36462a.get(0)).time;
                    VolleyLog.m38603d("(%-4d ms) %s", Long.valueOf(duration), header);
                    for (C11685a marker : this.f36462a) {
                        long thisTime = marker.time;
                        VolleyLog.m38603d("(+%-4d) [%2d] %s", Long.valueOf(thisTime - prevTime), Long.valueOf(marker.thread), marker.name);
                        prevTime = thisTime;
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() throws Throwable {
            if (!this.f36463b) {
                finish("Request on the loose");
                VolleyLog.m38604e("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }

        /* renamed from: a */
        private long m38607a() {
            if (this.f36462a.size() == 0) {
                return 0;
            }
            long first = ((C11685a) this.f36462a.get(0)).time;
            List<C11685a> list = this.f36462a;
            return ((C11685a) list.get(list.size() - 1)).time - first;
        }
    }

    public static void setTag(String tag) {
        m38603d("Changing log tag to %s", tag);
        TAG = tag;
        DEBUG = Log.isLoggable(TAG, 2);
    }

    /* renamed from: v */
    public static void m38606v(String format, Object... args) {
        if (DEBUG) {
            Log.v(TAG, m38602a(format, args));
        }
    }

    /* renamed from: d */
    public static void m38603d(String format, Object... args) {
        Log.d(TAG, m38602a(format, args));
    }

    /* renamed from: e */
    public static void m38604e(String format, Object... args) {
        Log.e(TAG, m38602a(format, args));
    }

    /* renamed from: e */
    public static void m38605e(Throwable tr, String format, Object... args) {
        Log.e(TAG, m38602a(format, args), tr);
    }

    public static void wtf(String format, Object... args) {
        Log.wtf(TAG, m38602a(format, args));
    }

    public static void wtf(Throwable tr, String format, Object... args) {
        Log.wtf(TAG, m38602a(format, args), tr);
    }

    /* renamed from: a */
    private static String m38602a(String format, Object... args) {
        String msg = args == null ? format : String.format(Locale.US, format, args);
        StackTraceElement[] trace = new Throwable().fillInStackTrace().getStackTrace();
        String caller = "<unknown>";
        int i = 2;
        while (true) {
            if (i >= trace.length) {
                break;
            } else if (!trace[i].getClassName().equals(f36461a)) {
                String callingClass = trace[i].getClassName();
                String callingClass2 = callingClass.substring(callingClass.lastIndexOf(46) + 1);
                String callingClass3 = callingClass2.substring(callingClass2.lastIndexOf(36) + 1);
                StringBuilder sb = new StringBuilder();
                sb.append(callingClass3);
                sb.append(".");
                sb.append(trace[i].getMethodName());
                caller = sb.toString();
                break;
            } else {
                i++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), caller, msg});
    }
}
