package p024io.fabric.sdk.android.p348a.p350b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import p024io.fabric.sdk.android.C13920f;

/* renamed from: io.fabric.sdk.android.a.b.o */
/* compiled from: DataCollectionArbiter */
public class C13858o {

    /* renamed from: a */
    private static C13858o f42045a;

    /* renamed from: b */
    private static Object f42046b = new Object();

    /* renamed from: c */
    private final SharedPreferences f42047c;

    /* renamed from: d */
    private volatile boolean f42048d;

    /* renamed from: e */
    private volatile boolean f42049e;

    /* renamed from: f */
    private final C13865v f42050f;

    /* renamed from: g */
    private boolean f42051g = false;

    /* renamed from: a */
    public static C13858o m44068a(Context applicationContext) {
        C13858o oVar;
        synchronized (f42046b) {
            if (f42045a == null) {
                f42045a = new C13858o(applicationContext);
            }
            oVar = f42045a;
        }
        return oVar;
    }

    private C13858o(Context applicationContext) {
        boolean z = false;
        if (applicationContext != null) {
            this.f42047c = applicationContext.getSharedPreferences("com.google.firebase.crashlytics.prefs", 0);
            this.f42050f = C13866w.m44081a(applicationContext);
            boolean enabled = true;
            boolean explicitlySet = false;
            String str = "firebase_crashlytics_collection_enabled";
            if (this.f42047c.contains(str)) {
                enabled = this.f42047c.getBoolean(str, true);
                explicitlySet = true;
            } else {
                try {
                    PackageManager packageManager = applicationContext.getPackageManager();
                    if (packageManager != null) {
                        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128);
                        if (!(applicationInfo == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey(str))) {
                            enabled = applicationInfo.metaData.getBoolean(str);
                            explicitlySet = true;
                        }
                    }
                } catch (NameNotFoundException e) {
                    C13920f.m44245e().mo43327c("Fabric", "Unable to get PackageManager. Falling through", e);
                }
            }
            this.f42049e = enabled;
            this.f42048d = explicitlySet;
            if (C13852l.m44063o(applicationContext) != null) {
                z = true;
            }
            this.f42051g = z;
            return;
        }
        throw new RuntimeException("null context");
    }

    /* renamed from: a */
    public boolean mo43247a() {
        if (this.f42051g && this.f42048d) {
            return this.f42049e;
        }
        C13865v vVar = this.f42050f;
        if (vVar != null) {
            return vVar.mo43252a();
        }
        return true;
    }

    /* renamed from: b */
    public boolean mo43248b() {
        return this.f42049e;
    }
}
