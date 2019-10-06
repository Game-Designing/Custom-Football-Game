package p019d.p143b.p144a.p147c;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Point;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import com.applovin.adview.AppLovinInterstitialActivity;
import com.mopub.common.GpsHelper;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TimeZone;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.BuildConfig;
import p019d.p143b.p148b.C7241d;
import p019d.p143b.p148b.C7242e;
import p019d.p143b.p148b.C7243f;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.s */
class C7206s {

    /* renamed from: a */
    private static final Queue<String> f13940a = new LinkedList();

    /* renamed from: b */
    private static String f13941b;

    /* renamed from: c */
    private static String f13942c;

    /* renamed from: d */
    private static int f13943d;

    /* renamed from: e */
    private final C7142c f13944e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final C7262l f13945f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final Context f13946g;

    /* renamed from: h */
    private final Map<Class, Object> f13947h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final AtomicReference<C7218v> f13948i = new AtomicReference<>();

    static {
        f13940a.add("act");
        f13940a.add("acm");
        f13940a.add("adr");
        f13940a.add("build");
        f13940a.add("volume");
        f13940a.add("ua");
    }

    C7206s(C7142c cVar) {
        if (cVar != null) {
            this.f13944e = cVar;
            this.f13945f = cVar.mo23049b();
            this.f13946g = cVar.mo23068m();
            this.f13947h = Collections.synchronizedMap(new HashMap());
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /* renamed from: a */
    private C7230y m15419a(C7230y yVar) {
        if (yVar == null) {
            yVar = new C7230y();
        }
        yVar.f14046w = C7186n.m15335a(this.f13946g);
        yVar.f14047x = C7186n.m15339b(this.f13946g);
        yVar.f14041r = ((Boolean) this.f13944e.mo23039a(C7196pb.f13865pc)).booleanValue() ? m15433k() : null;
        if (((Boolean) this.f13944e.mo23039a(C7196pb.f13860oc)).booleanValue()) {
            yVar.f14040q = m15435m();
        }
        try {
            AudioManager audioManager = (AudioManager) this.f13946g.getSystemService("audio");
            if (audioManager != null) {
                yVar.f14042s = (int) (((float) audioManager.getStreamVolume(3)) * ((Float) this.f13944e.mo23039a(C7196pb.f13895vc)).floatValue());
            }
        } catch (Throwable th) {
            this.f13945f.mo22917b("DataCollector", "Unable to collect volume", th);
        }
        if (((Boolean) this.f13944e.mo23039a(C7196pb.f13910yc)).booleanValue()) {
            if (f13941b == null) {
                String q = m15439q();
                if (!C7269s.m15819a(q)) {
                    q = "";
                }
                f13941b = q;
            }
            if (C7269s.m15819a(f13941b)) {
                yVar.f14043t = f13941b;
            }
        }
        String str = (String) this.f13944e.mo23026A().mo23249a(C7196pb.f13850mc);
        String str2 = f13942c;
        if (str2 == null || !str.equalsIgnoreCase(str2)) {
            try {
                f13942c = str;
                PackageInfo packageInfo = this.f13946g.getPackageManager().getPackageInfo(str, 0);
                yVar.f14039p = packageInfo.versionCode;
                f13943d = packageInfo.versionCode;
            } catch (Throwable th2) {
                f13943d = 0;
            }
        } else {
            yVar.f14039p = f13943d;
        }
        return yVar;
    }

    /* renamed from: a */
    private String m15420a(C7241d dVar) {
        if (dVar == null) {
            return null;
        }
        return dVar.mo23466c();
    }

    /* renamed from: a */
    private void m15421a(Map<String, String> map) {
        Collection<C7241d> b = this.f13944e.mo23076u().mo23098b();
        if (b != null && !b.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (C7241d dVar : b) {
                if (dVar.mo23465b() == C7243f.READY) {
                    sb.append(dVar.mo23464a());
                    String a = m15420a(dVar);
                    if (!TextUtils.isEmpty(a)) {
                        sb.append(":");
                        sb.append(a);
                    }
                    sb.append(",");
                }
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            if (sb.length() > 0) {
                map.put("aa", sb.toString());
            }
        }
        C7242e c = this.f13944e.mo23076u().mo23099c();
        if (c != null) {
            map.put("lman", c.mo23468a());
            map.put("lmat", String.valueOf(c.mo23469b()));
        }
    }

    /* renamed from: a */
    static boolean m15422a(String str, Context context) {
        if (str == null) {
            throw new IllegalArgumentException("No permission name specified");
        } else if (context != null) {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } else {
            throw new IllegalArgumentException("No context specified");
        }
    }

    /* renamed from: a */
    private boolean m15423a(String str, C7204rb<String> rbVar) {
        for (String startsWith : C7178l.m15309a((String) this.f13944e.mo23039a(rbVar))) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private String m15425b(int i) {
        String str;
        JSONObject jSONObject = new JSONObject(m15428f());
        PriorityQueue priorityQueue = new PriorityQueue(f13940a);
        while (true) {
            String encodeToString = Base64.encodeToString(jSONObject.toString().getBytes(Charset.defaultCharset()), 2);
            if (encodeToString.length() <= i) {
                return encodeToString;
            }
            do {
                str = (String) priorityQueue.poll();
                if (jSONObject.has(str)) {
                    break;
                }
            } while (!priorityQueue.isEmpty());
            if (!TextUtils.isEmpty(str)) {
                jSONObject.remove(str);
            } else {
                C7262l lVar = this.f13945f;
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to generate base64 request parameters with max length: ");
                sb.append(i);
                lVar.mo22916b("DataCollector", sb.toString());
                return "";
            }
        }
    }

    /* renamed from: b */
    private String m15426b(String str) {
        int length = str.length();
        int[] iArr = {11, 12, 10, 3, 2, 1, 15, 10, 15, 14};
        int length2 = iArr.length;
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = str.charAt(i);
            for (int i2 = length2 - 1; i2 >= 0; i2--) {
                cArr[i] = (char) (cArr[i] ^ iArr[i2]);
            }
        }
        return new String(cArr);
    }

    /* renamed from: f */
    private Map<String, String> m15428f() {
        return mo23241a(null, false, true);
    }

    /* renamed from: g */
    private String m15429g() {
        String str = "custom_size,launch_app";
        if (!C7182m.m15325c() || !C7182m.m15320a(AppLovinInterstitialActivity.class, this.f13946g)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(",video");
        return sb.toString();
    }

    /* renamed from: h */
    private String m15430h() {
        String str = "none";
        try {
            int b = C7209sc.m15481b(this.f13946g);
            return b == 1 ? "portrait" : b == 2 ? "landscape" : str;
        } catch (Throwable th) {
            this.f13944e.mo23049b().mo22917b("DataCollector", "Encountered error while attempting to collect application orientation", th);
            return str;
        }
    }

    /* renamed from: i */
    private C7218v m15431i() {
        String str;
        C7262l lVar;
        String str2 = "DataCollector";
        try {
            ContentResolver contentResolver = this.f13946g.getContentResolver();
            String string = Secure.getString(contentResolver, "advertising_id");
            C7218v vVar = new C7218v();
            if (string == null) {
                string = "";
            }
            vVar.f13994b = string;
            vVar.f13993a = Secure.getInt(contentResolver, "limit_ad_tracking") != 0;
            return vVar;
        } catch (SettingNotFoundException e) {
            th = e;
            lVar = this.f13945f;
            str = "Unable to determine if FireOS limited ad tracking is turned on";
            lVar.mo22917b(str2, str, th);
            return null;
        } catch (Throwable th) {
            th = th;
            lVar = this.f13945f;
            str = "Unable to collect FireOS IDFA";
            lVar.mo22917b(str2, str, th);
            return null;
        }
    }

    /* renamed from: j */
    private C7218v m15432j() {
        String str = "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }";
        String str2 = "DataCollector";
        try {
            Class cls = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            if (cls != null) {
                Object invoke = cls.getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke(null, new Object[]{this.f13946g});
                if (invoke != null) {
                    Class cls2 = invoke.getClass();
                    Object invoke2 = cls2.getMethod(GpsHelper.IS_LIMIT_AD_TRACKING_ENABLED_KEY, null).invoke(invoke, null);
                    String str3 = (String) cls2.getMethod("getId", null).invoke(invoke, null);
                    if (str3 == null) {
                        str3 = "";
                    }
                    C7218v vVar = new C7218v();
                    vVar.f13993a = ((Boolean) invoke2).booleanValue();
                    vVar.f13994b = str3;
                    return vVar;
                }
            }
        } catch (ClassNotFoundException e) {
            this.f13945f.mo22919c(str2, str, e);
        } catch (Throwable th) {
            this.f13945f.mo22917b(str2, str, th);
        }
        return new C7218v();
    }

    /* renamed from: k */
    private C7226x m15433k() {
        try {
            C7226x xVar = new C7226x();
            Intent registerReceiver = this.f13946g.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int i = -1;
            int intExtra = registerReceiver != null ? registerReceiver.getIntExtra("level", -1) : -1;
            int intExtra2 = registerReceiver != null ? registerReceiver.getIntExtra("scale", -1) : -1;
            if (intExtra <= 0 || intExtra2 <= 0) {
                xVar.f14018b = -1;
            } else {
                xVar.f14018b = (int) ((((float) intExtra) / ((float) intExtra2)) * 100.0f);
            }
            if (registerReceiver != null) {
                i = registerReceiver.getIntExtra("status", -1);
            }
            xVar.f14017a = i;
            return xVar;
        } catch (Throwable th) {
            this.f13945f.mo22917b("DataCollector", "Unable to collect battery info", th);
            return null;
        }
    }

    /* renamed from: l */
    private double m15434l() {
        double offset = (double) TimeZone.getDefault().getOffset(new Date().getTime());
        Double.isNaN(offset);
        double round = (double) Math.round((offset * 10.0d) / 3600000.0d);
        Double.isNaN(round);
        return round / 10.0d;
    }

    /* renamed from: m */
    private boolean m15435m() {
        boolean z = false;
        try {
            if (m15436n() || m15437o()) {
                z = true;
            }
            return z;
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: n */
    private boolean m15436n() {
        String str = Build.TAGS;
        return str != null && str.contains(m15426b("lz}$blpz"));
    }

    /* renamed from: o */
    private boolean m15437o() {
        String[] strArr = {"&zpz}ld&hyy&Z|yl{|zl{'hyb", "&zk`g&z|", "&zpz}ld&k`g&z|", "&zpz}ld&qk`g&z|", "&mh}h&efjhe&qk`g&z|", "&mh}h&efjhe&k`g&z|", "&zpz}ld&zm&qk`g&z|", "&zpz}ld&k`g&oh`ezhol&z|", "&mh}h&efjhe&z|"};
        for (String b : strArr) {
            if (new File(m15426b(b)).exists()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: p */
    private boolean m15438p() {
        return m15423a(Build.DEVICE, C7196pb.f13875rc) || m15423a(Build.HARDWARE, C7196pb.f13870qc) || m15423a(Build.MANUFACTURER, C7196pb.f13880sc) || m15423a(Build.MODEL, C7196pb.f13885tc);
    }

    /* renamed from: q */
    private String m15439q() {
        AtomicReference atomicReference = new AtomicReference();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Handler(this.f13946g.getMainLooper()).post(new C7210t(this, atomicReference, countDownLatch));
        try {
            countDownLatch.await(((Long) this.f13944e.mo23039a(C7196pb.f13915zc)).longValue(), TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
        }
        return (String) atomicReference.get();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C7170j mo23239a(int i) {
        return new C7170j(m15425b(i), this.f13948i.get() != null);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C7230y mo23240a() {
        C7230y yVar;
        Object obj = this.f13947h.get(C7230y.class);
        if (obj != null) {
            yVar = (C7230y) obj;
        } else {
            yVar = new C7230y();
            yVar.f14034k = Locale.getDefault();
            yVar.f14024a = Build.MODEL;
            yVar.f14025b = VERSION.RELEASE;
            yVar.f14026c = mo23243b();
            yVar.f14027d = Build.MANUFACTURER;
            yVar.f14028e = Build.BRAND;
            yVar.f14029f = Build.HARDWARE;
            yVar.f14031h = VERSION.SDK_INT;
            yVar.f14030g = Build.DEVICE;
            yVar.f14035l = m15430h();
            yVar.f14038o = m15434l();
            yVar.f14044u = m15438p();
            try {
                yVar.f14045v = ((SensorManager) this.f13946g.getSystemService("sensor")).getDefaultSensor(4) != null;
            } catch (Throwable th) {
                this.f13945f.mo22917b("DataCollector", "Unable to retrieve gyroscope availability", th);
            }
            if (mo23242a("android.permission.READ_PHONE_STATE")) {
                TelephonyManager telephonyManager = (TelephonyManager) this.f13946g.getSystemService("phone");
                if (telephonyManager != null) {
                    yVar.f14032i = telephonyManager.getSimCountryIso().toUpperCase(Locale.ENGLISH);
                    String networkOperatorName = telephonyManager.getNetworkOperatorName();
                    try {
                        yVar.f14033j = URLEncoder.encode(networkOperatorName, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        yVar.f14033j = networkOperatorName;
                    }
                }
            }
            try {
                DisplayMetrics displayMetrics = this.f13946g.getResources().getDisplayMetrics();
                yVar.f14036m = displayMetrics.density;
                yVar.f14037n = displayMetrics.densityDpi;
            } catch (Throwable th2) {
            }
            this.f13947h.put(C7230y.class, yVar);
        }
        return m15419a(yVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Map<String, String> mo23241a(Map<String, String> map, boolean z, boolean z2) {
        C7218v vVar;
        HashMap hashMap = new HashMap();
        C7230y a = mo23240a();
        hashMap.put("brand", C7209sc.m15487d(a.f14027d));
        hashMap.put("brand_name", C7209sc.m15487d(a.f14028e));
        hashMap.put("hardware", C7209sc.m15487d(a.f14029f));
        hashMap.put("carrier", C7209sc.m15487d(a.f14033j));
        hashMap.put("country_code", C7209sc.m15487d(a.f14032i));
        hashMap.put("locale", C7209sc.m15487d(a.f14034k.toString()));
        hashMap.put("model", C7209sc.m15487d(a.f14024a));
        hashMap.put("os", C7209sc.m15487d(a.f14025b));
        hashMap.put("platform", C7209sc.m15487d(a.f14026c));
        hashMap.put("revision", C7209sc.m15487d(a.f14030g));
        hashMap.put("orientation_lock", a.f14035l);
        hashMap.put("tz_offset", String.valueOf(a.f14038o));
        hashMap.put("wvvc", String.valueOf(a.f14039p));
        hashMap.put("adns", String.valueOf(a.f14036m));
        hashMap.put("adnsd", String.valueOf(a.f14037n));
        boolean z3 = a.f14044u;
        String str = "1";
        String str2 = BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID;
        hashMap.put("sim", z3 ? str : str2);
        hashMap.put("gy", String.valueOf(a.f14045v));
        C7226x xVar = a.f14041r;
        if (xVar != null) {
            hashMap.put("act", String.valueOf(xVar.f14017a));
            hashMap.put("acm", String.valueOf(xVar.f14018b));
        }
        if (!a.f14040q) {
            str = str2;
        }
        hashMap.put("adr", str);
        hashMap.put("volume", String.valueOf(a.f14042s));
        String str3 = a.f14043t;
        if (C7269s.m15819a(str3)) {
            hashMap.put("ua", C7209sc.m15487d(str3));
        }
        Boolean bool = a.f14046w;
        if (bool != null) {
            hashMap.put("huc", bool.toString());
        }
        Boolean bool2 = a.f14047x;
        if (bool2 != null) {
            hashMap.put("aru", bool2.toString());
        }
        C7222w c = mo23244c();
        hashMap.put("accept", m15429g());
        hashMap.put("api_did", this.f13944e.mo23039a(C7196pb.f13822h));
        hashMap.put("app_version", C7209sc.m15487d(c.f14008b));
        hashMap.put("build", Integer.toString(103));
        hashMap.put("format", "json");
        hashMap.put("ia", Long.toString(c.f14011e));
        C7209sc.m15475a("mediation_provider", C7209sc.m15487d(this.f13944e.mo23075t()), (Map<String, String>) hashMap);
        hashMap.put("network", C7202r.m15398a(this.f13944e));
        C7209sc.m15475a("plugin_version", (String) this.f13944e.mo23039a(C7196pb.f13714K), (Map<String, String>) hashMap);
        hashMap.put("preloading", String.valueOf(z));
        hashMap.put("sc", this.f13944e.mo23039a(C7196pb.f13674C));
        hashMap.put("sdk_key", this.f13944e.mo23079x());
        hashMap.put("sdk_version", BuildConfig.APPLOVIN_SDK_VERSION);
        C7209sc.m15474a("test_ads", Boolean.valueOf(this.f13944e.mo23081z().mo23486e()), (Map<String, String>) hashMap);
        hashMap.put("installer_name", c.f14010d);
        hashMap.put("v1", Boolean.toString(C7182m.m15321a("android.permission.WRITE_EXTERNAL_STORAGE", this.f13946g)));
        hashMap.put("v2", Boolean.toString(C7182m.m15320a(AppLovinInterstitialActivity.class, this.f13946g)));
        hashMap.put("v3", Boolean.toString(C7182m.m15319a(this.f13946g)));
        hashMap.put("v4", Boolean.toString(C7182m.m15323b(this.f13946g)));
        if (((Boolean) this.f13944e.mo23039a(C7196pb.f13756T)).booleanValue()) {
            C7076J f = this.f13944e.mo23061f();
            hashMap.put("li", String.valueOf(f.mo22864b("ad_imp")));
            hashMap.put("si", String.valueOf(f.mo22864b("ad_imp_session")));
        }
        hashMap.put("vz", C7209sc.m15468a(this.f13946g.getPackageName(), this.f13944e));
        Point c2 = C7182m.m15324c(this.f13946g);
        hashMap.put("dx", Integer.toString(c2.x));
        hashMap.put("dy", Integer.toString(c2.y));
        if (this.f13944e.mo23035K()) {
            hashMap.put("pnr", Boolean.toString(this.f13944e.mo23036L()));
        }
        if (z2) {
            vVar = (C7218v) this.f13948i.get();
            if (vVar == null) {
                vVar = new C7218v();
                hashMap.put("inc", Boolean.toString(true));
            }
            mo23246e();
        } else {
            vVar = this.f13944e.mo23070o().mo23245d();
        }
        String str4 = vVar.f13994b;
        if (C7269s.m15819a(str4)) {
            hashMap.put("idfa", str4);
        }
        hashMap.put("dnt", Boolean.toString(vVar.f13993a));
        if (map != null) {
            hashMap.putAll(map);
        }
        m15421a((Map<String, String>) hashMap);
        return hashMap;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo23242a(String str) {
        return m15422a(str, this.f13946g);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo23243b() {
        return this.f13944e.mo23033I() ? "fireos" : "android";
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public C7222w mo23244c() {
        PackageInfo packageInfo;
        Object obj = this.f13947h.get(C7222w.class);
        if (obj != null) {
            return (C7222w) obj;
        }
        ApplicationInfo applicationInfo = this.f13946g.getApplicationInfo();
        long lastModified = new File(applicationInfo.sourceDir).lastModified();
        PackageManager packageManager = this.f13946g.getPackageManager();
        String str = null;
        try {
            packageInfo = packageManager.getPackageInfo(this.f13946g.getPackageName(), 0);
            try {
                str = packageManager.getInstallerPackageName(applicationInfo.packageName);
            } catch (NameNotFoundException e) {
            }
        } catch (NameNotFoundException e2) {
            packageInfo = null;
        }
        C7222w wVar = new C7222w();
        wVar.f14009c = applicationInfo.packageName;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        wVar.f14010d = str;
        wVar.f14011e = lastModified;
        wVar.f14007a = String.valueOf(packageManager.getApplicationLabel(applicationInfo));
        if (packageInfo != null) {
            str2 = packageInfo.versionName;
        }
        wVar.f14008b = str2;
        this.f13947h.put(C7222w.class, wVar);
        return wVar;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0052  */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p019d.p143b.p144a.p147c.C7218v mo23245d() {
        /*
            r3 = this;
            d.b.a.c.c r0 = r3.f13944e
            boolean r0 = r0.mo23033I()
            if (r0 == 0) goto L_0x0025
            d.b.a.c.v r0 = r3.m15431i()
            if (r0 != 0) goto L_0x0029
            d.b.a.c.c r0 = r3.f13944e
            d.b.a.c.rb<java.lang.Boolean> r1 = p019d.p143b.p144a.p147c.C7196pb.f13825hc
            java.lang.Object r0 = r0.mo23039a(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x001f
            goto L_0x0025
        L_0x001f:
            d.b.a.c.v r0 = new d.b.a.c.v
            r0.<init>()
            goto L_0x0029
        L_0x0025:
            d.b.a.c.v r0 = r3.m15432j()
        L_0x0029:
            d.b.a.c.c r1 = r3.f13944e
            d.b.a.c.rb<java.lang.Boolean> r2 = p019d.p143b.p144a.p147c.C7196pb.f13726Mb
            java.lang.Object r1 = r1.mo23039a(r2)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0052
            boolean r1 = r0.f13993a
            if (r1 == 0) goto L_0x0057
            d.b.a.c.c r1 = r3.f13944e
            d.b.a.c.rb<java.lang.Boolean> r2 = p019d.p143b.p144a.p147c.C7196pb.f13721Lb
            java.lang.Object r1 = r1.mo23039a(r2)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x0057
            java.lang.String r1 = ""
            r0.f13994b = r1
            goto L_0x0057
        L_0x0052:
            d.b.a.c.v r0 = new d.b.a.c.v
            r0.<init>()
        L_0x0057:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p143b.p144a.p147c.C7206s.mo23245d():d.b.a.c.v");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo23246e() {
        this.f13944e.mo23027C().mo22970a((C7184mb) new C7062Fb(this.f13944e, new C7214u(this)), C7113Tb.BACKGROUND);
    }
}
