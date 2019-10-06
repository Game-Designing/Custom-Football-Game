package com.facebook.p127a;

import android.preference.PreferenceManager;
import android.util.Log;
import com.facebook.C6787r;
import com.facebook.p127a.p130b.C6603i;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: com.facebook.a.e */
/* compiled from: AnalyticsUserIDStore */
class C6623e {

    /* renamed from: a */
    private static final String f12049a = C6623e.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static ReentrantReadWriteLock f12050b = new ReentrantReadWriteLock();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static String f12051c;

    /* renamed from: d */
    private static volatile boolean f12052d = false;

    C6623e() {
    }

    /* renamed from: e */
    public static void m13177e() {
        if (!f12052d) {
            C6647y.m13253b().execute(new C6621c());
        }
    }

    /* renamed from: b */
    public static void m13174b(String id) {
        C6603i.m13110b();
        if (!f12052d) {
            Log.w(f12049a, "initStore should have been called before calling setUserID");
            m13178f();
        }
        C6647y.m13253b().execute(new C6622d(id));
    }

    /* renamed from: d */
    public static String m13176d() {
        if (!f12052d) {
            Log.w(f12049a, "initStore should have been called before calling setUserID");
            m13178f();
        }
        f12050b.readLock().lock();
        try {
            return f12051c;
        } finally {
            f12050b.readLock().unlock();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static void m13178f() {
        if (!f12052d) {
            f12050b.writeLock().lock();
            try {
                if (!f12052d) {
                    f12051c = PreferenceManager.getDefaultSharedPreferences(C6787r.m13815e()).getString("com.facebook.appevents.AnalyticsUserIDStore.userID", null);
                    f12052d = true;
                    f12050b.writeLock().unlock();
                }
            } finally {
                f12050b.writeLock().unlock();
            }
        }
    }
}
