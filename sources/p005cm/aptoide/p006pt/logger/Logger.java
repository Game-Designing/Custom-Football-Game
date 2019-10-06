package p005cm.aptoide.p006pt.logger;

import android.util.Log;

/* renamed from: cm.aptoide.pt.logger.Logger */
public class Logger {
    private static boolean DBG;
    private static Logger instance = null;

    public static synchronized Logger getInstance() {
        Logger logger;
        synchronized (Logger.class) {
            if (instance == null) {
                instance = new Logger();
            }
            logger = instance;
        }
        return logger;
    }

    public static void setDBG(boolean DBG2) {
        DBG = DBG2;
    }

    /* renamed from: v */
    public void mo2146v(String tag, String msg) {
        if (DBG && msg != null) {
            Log.v(tag, msg);
        }
    }

    /* renamed from: v */
    public void mo2147v(String tag, String msg, Throwable tr) {
        if (DBG && msg != null) {
            Log.v(tag, msg, tr);
        }
    }

    /* renamed from: d */
    public void mo2135d(Object object, String msg) {
        mo2136d(object.getClass().getSimpleName(), msg);
    }

    /* renamed from: d */
    public void mo2136d(String tag, String msg) {
        if (DBG && msg != null) {
            Log.d(tag, msg);
        }
    }

    /* renamed from: d */
    public void mo2137d(String tag, String msg, Throwable tr) {
        if (DBG && msg != null) {
            Log.d(tag, msg, tr);
        }
    }

    /* renamed from: i */
    public void mo2144i(Object object, String msg) {
        mo2145i(object.getClass().getSimpleName(), msg);
    }

    /* renamed from: i */
    public void mo2145i(String tag, String msg) {
        if (DBG && msg != null) {
            Log.i(tag, msg);
        }
    }

    /* renamed from: i */
    public void mo2143i(Class clz, String msg) {
        mo2145i(clz.getSimpleName(), msg);
    }

    /* renamed from: w */
    public void mo2148w(String TAG, String msg) {
        if (msg != null) {
            Log.w(TAG, msg);
        }
    }

    /* renamed from: w */
    public void mo2149w(String TAG, String msg, Throwable tr) {
        if (msg != null) {
            Log.w(TAG, msg, tr);
        }
    }

    /* renamed from: e */
    public void mo2138e(Object object, String msg) {
        mo2140e(object.getClass().getName(), msg);
    }

    /* renamed from: e */
    public void mo2140e(String TAG, String msg) {
        if (msg != null) {
            Log.e(TAG, msg);
        }
    }

    /* renamed from: e */
    public void mo2139e(Object object, Throwable tr) {
        mo2142e(object.getClass().getName(), tr);
    }

    /* renamed from: e */
    public void mo2142e(String TAG, Throwable tr) {
        Log.e(TAG, "", tr);
    }

    /* renamed from: e */
    public void mo2141e(String TAG, String msg, Throwable tr) {
        if (msg != null) {
            Log.e(TAG, msg, tr);
        }
    }
}
