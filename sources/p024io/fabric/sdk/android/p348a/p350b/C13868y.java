package p024io.fabric.sdk.android.p348a.p350b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import p024io.fabric.sdk.android.C0102l;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.C13929o;

/* renamed from: io.fabric.sdk.android.a.b.y */
/* compiled from: IdManager */
public class C13868y {

    /* renamed from: a */
    private static final Pattern f42068a = Pattern.compile("[^\\p{Alnum}]");

    /* renamed from: b */
    private static final String f42069b = Pattern.quote("/");

    /* renamed from: c */
    private final ReentrantLock f42070c = new ReentrantLock();

    /* renamed from: d */
    private final C13830A f42071d;

    /* renamed from: e */
    private final boolean f42072e;

    /* renamed from: f */
    private final boolean f42073f;

    /* renamed from: g */
    private final Context f42074g;

    /* renamed from: h */
    private final String f42075h;

    /* renamed from: i */
    private final String f42076i;

    /* renamed from: j */
    private final Collection<C0102l> f42077j;

    /* renamed from: k */
    C13842d f42078k;

    /* renamed from: l */
    C13840b f42079l;

    /* renamed from: m */
    boolean f42080m;

    /* renamed from: n */
    C13867x f42081n;

    /* renamed from: io.fabric.sdk.android.a.b.y$a */
    /* compiled from: IdManager */
    public enum C13869a {
        WIFI_MAC_ADDRESS(1),
        BLUETOOTH_MAC_ADDRESS(2),
        FONT_TOKEN(53),
        ANDROID_ID(100),
        ANDROID_DEVICE_ID(101),
        ANDROID_SERIAL(102),
        ANDROID_ADVERTISING_ID(103);
        

        /* renamed from: i */
        public final int f42090i;

        private C13869a(int pbufIndex) {
            this.f42090i = pbufIndex;
        }
    }

    public C13868y(Context appContext, String appIdentifier, String appInstallIdentifier, Collection<C0102l> kits) {
        if (appContext == null) {
            throw new IllegalArgumentException("appContext must not be null");
        } else if (appIdentifier == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        } else if (kits != null) {
            this.f42074g = appContext;
            this.f42075h = appIdentifier;
            this.f42076i = appInstallIdentifier;
            this.f42077j = kits;
            this.f42071d = new C13830A();
            this.f42078k = new C13842d(appContext);
            this.f42081n = new C13867x();
            this.f42072e = C13852l.m44040a(appContext, "com.crashlytics.CollectDeviceIdentifiers", true);
            String str = "Fabric";
            if (!this.f42072e) {
                C13929o e = C13920f.m44245e();
                StringBuilder sb = new StringBuilder();
                sb.append("Device ID collection disabled for ");
                sb.append(appContext.getPackageName());
                e.mo43326c(str, sb.toString());
            }
            this.f42073f = C13852l.m44040a(appContext, "com.crashlytics.CollectUserIdentifiers", true);
            if (!this.f42073f) {
                C13929o e2 = C13920f.m44245e();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("User information collection disabled for ");
                sb2.append(appContext.getPackageName());
                e2.mo43326c(str, sb2.toString());
            }
        } else {
            throw new IllegalArgumentException("kits must not be null");
        }
    }

    /* renamed from: a */
    public boolean mo43259a() {
        return this.f42073f;
    }

    /* renamed from: a */
    private String m44089a(String id) {
        if (id == null) {
            return null;
        }
        return f42068a.matcher(id).replaceAll("").toLowerCase(Locale.US);
    }

    /* renamed from: d */
    public String mo43262d() {
        String appInstallId = this.f42076i;
        if (appInstallId != null) {
            return appInstallId;
        }
        SharedPreferences prefs = C13852l.m44057i(this.f42074g);
        m44090a(prefs);
        String appInstallId2 = prefs.getString("crashlytics.installation.id", null);
        if (appInstallId2 == null) {
            return m44093b(prefs);
        }
        return appInstallId2;
    }

    /* renamed from: c */
    public String mo43261c() {
        return this.f42075h;
    }

    /* renamed from: j */
    public String mo43268j() {
        StringBuilder sb = new StringBuilder();
        sb.append(mo43267i());
        sb.append("/");
        sb.append(mo43266h());
        return sb.toString();
    }

    /* renamed from: i */
    public String mo43267i() {
        return m44094b(VERSION.RELEASE);
    }

    /* renamed from: h */
    public String mo43266h() {
        return m44094b(VERSION.INCREMENTAL);
    }

    /* renamed from: g */
    public String mo43265g() {
        return String.format(Locale.US, "%s/%s", new Object[]{m44094b(Build.MANUFACTURER), m44094b(Build.MODEL)});
    }

    /* renamed from: b */
    private String m44094b(String s) {
        return s.replaceAll(f42069b, "");
    }

    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: b */
    private String m44093b(SharedPreferences prefs) {
        String str = "crashlytics.installation.id";
        this.f42070c.lock();
        try {
            String uuid = prefs.getString(str, null);
            if (uuid == null) {
                uuid = m44089a(UUID.randomUUID().toString());
                prefs.edit().putString(str, uuid).commit();
            }
            return uuid;
        } finally {
            this.f42070c.unlock();
        }
    }

    /* renamed from: a */
    private void m44090a(SharedPreferences prefs) {
        C13840b newAdInfo = mo43260b();
        if (newAdInfo != null) {
            m44091a(prefs, newAdInfo.f42016a);
        }
    }

    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: a */
    private void m44091a(SharedPreferences prefs, String advertisingId) {
        String str = "crashlytics.advertising.id";
        this.f42070c.lock();
        try {
            if (!TextUtils.isEmpty(advertisingId)) {
                String oldId = prefs.getString(str, null);
                if (TextUtils.isEmpty(oldId)) {
                    prefs.edit().putString(str, advertisingId).commit();
                } else if (!oldId.equals(advertisingId)) {
                    prefs.edit().remove("crashlytics.installation.id").putString(str, advertisingId).commit();
                }
                this.f42070c.unlock();
            }
        } finally {
            this.f42070c.unlock();
        }
    }

    /* renamed from: e */
    public Map<C13869a, String> mo43263e() {
        Map<DeviceIdentifierType, String> ids = new HashMap<>();
        for (C0102l kit : this.f42077j) {
            if (kit instanceof C13860q) {
                for (Entry<DeviceIdentifierType, String> entry : ((C13860q) kit).mo19430e().entrySet()) {
                    m44092a(ids, (C13869a) entry.getKey(), (String) entry.getValue());
                }
            }
        }
        return Collections.unmodifiableMap(ids);
    }

    /* renamed from: f */
    public String mo43264f() {
        return this.f42071d.mo43202a(this.f42074g);
    }

    /* renamed from: k */
    public Boolean mo43269k() {
        if (mo43270l()) {
            return m44095m();
        }
        return null;
    }

    /* renamed from: a */
    private void m44092a(Map<C13869a, String> idMap, C13869a idKey, String idValue) {
        if (idValue != null) {
            idMap.put(idKey, idValue);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public boolean mo43270l() {
        return this.f42072e && !this.f42081n.mo43258e(this.f42074g);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public synchronized C13840b mo43260b() {
        if (!this.f42080m) {
            this.f42079l = this.f42078k.mo43224a();
            this.f42080m = true;
        }
        return this.f42079l;
    }

    /* renamed from: m */
    private Boolean m44095m() {
        C13840b advertisingInfo = mo43260b();
        if (advertisingInfo != null) {
            return Boolean.valueOf(advertisingInfo.f42017b);
        }
        return null;
    }
}
