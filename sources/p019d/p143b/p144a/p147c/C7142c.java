package p019d.p143b.p144a.p147c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.List;
import p019d.p143b.p150d.C7261k;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7268r;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.c */
public class C7142c extends C7267q {

    /* renamed from: c */
    private static Context f13450c;

    /* renamed from: A */
    private final Object f13451A = new Object();

    /* renamed from: B */
    private boolean f13452B = false;

    /* renamed from: C */
    private boolean f13453C = false;

    /* renamed from: D */
    private boolean f13454D = false;

    /* renamed from: E */
    private boolean f13455E = false;

    /* renamed from: F */
    private boolean f13456F = false;

    /* renamed from: G */
    private String f13457G;

    /* renamed from: d */
    private String f13458d;

    /* renamed from: e */
    private C7268r f13459e;

    /* renamed from: f */
    private WeakReference<Activity> f13460f;

    /* renamed from: g */
    private long f13461g;

    /* renamed from: h */
    private C7262l f13462h;

    /* renamed from: i */
    private C7110Sb f13463i;

    /* renamed from: j */
    private C7208sb f13464j;

    /* renamed from: k */
    private C7190o f13465k;

    /* renamed from: l */
    private C7076J f13466l;

    /* renamed from: m */
    private C7072I f13467m;

    /* renamed from: n */
    private C7068H f13468n;

    /* renamed from: o */
    private C7237zc f13469o;

    /* renamed from: p */
    private C7109Sa f13470p;

    /* renamed from: q */
    private C7206s f13471q;

    /* renamed from: r */
    private C7220vb f13472r;

    /* renamed from: s */
    private C7067Gc f13473s;

    /* renamed from: t */
    private C7134a f13474t;

    /* renamed from: u */
    private C7115Ua f13475u;

    /* renamed from: v */
    private C7158g f13476v;

    /* renamed from: w */
    private C7146d f13477w;

    /* renamed from: x */
    private C7150e f13478x;

    /* renamed from: y */
    private C7144cb f13479y;

    /* renamed from: z */
    private C7188nb f13480z;

    /* renamed from: B */
    public static Context m15040B() {
        return f13450c;
    }

    /* renamed from: M */
    public static void m15041M() {
        synchronized (C7267q.f14107b) {
            for (C7142c l : C7267q.f14106a) {
                l.mo23067l();
            }
        }
    }

    /* renamed from: N */
    private static boolean m15042N() {
        return !VERSION.RELEASE.startsWith("1.") && !VERSION.RELEASE.startsWith("2.0") && !VERSION.RELEASE.startsWith("2.1");
    }

    /* renamed from: O */
    private void m15043O() {
        try {
            String str = "AppLovinSdk";
            if (((Integer) mo23041a(C7216ub.f13976c, (T) Integer.valueOf(0))).intValue() < 814) {
                Log.i(str, "SDK has been updated since last run. Continuing...");
                mo23026A().mo23256c();
                mo23026A().mo23250a();
            } else {
                Log.d(str, "SDK has not been updated since last run. Continuing...");
            }
        } catch (Exception e) {
            mo23049b().mo22917b("AppLovinSdkImpl", "Unable to check for SDK update", e);
        } catch (Throwable th) {
            mo23052b(C7216ub.f13976c, Integer.valueOf(814));
            throw th;
        }
        mo23052b(C7216ub.f13976c, Integer.valueOf(814));
    }

    /* renamed from: A */
    public C7208sb mo23026A() {
        return this.f13464j;
    }

    /* renamed from: C */
    public C7110Sb mo23027C() {
        return this.f13463i;
    }

    /* renamed from: D */
    public String mo23028D() {
        return C7205rc.m15417a();
    }

    /* renamed from: E */
    public C7067Gc mo23029E() {
        return this.f13473s;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: F */
    public void mo23030F() {
        this.f13464j.mo23256c();
        this.f13464j.mo23250a();
        this.f13466l.mo22863a();
        this.f13467m.mo22854b();
        mo23067l();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: G */
    public void mo23031G() {
        this.f13480z.mo23207a(f13450c);
    }

    /* renamed from: H */
    public boolean mo23032H() {
        boolean z;
        synchronized (this.f13451A) {
            z = this.f13453C;
        }
        return z;
    }

    /* renamed from: I */
    public boolean mo23033I() {
        for (String equalsIgnoreCase : C7178l.m15309a((String) mo23039a(C7196pb.f13820gc))) {
            if (equalsIgnoreCase.equalsIgnoreCase(Build.MANUFACTURER)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: J */
    public boolean mo23034J() {
        return this.f13456F;
    }

    /* renamed from: K */
    public boolean mo23035K() {
        return this.f13480z.mo23209c();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: L */
    public boolean mo23036L() {
        return this.f13480z.mo23210d();
    }

    /* renamed from: a */
    public C7134a m15057a() {
        return this.f13474t;
    }

    /* renamed from: a */
    public <T> C7204rb mo23038a(String str, C7204rb<T> rbVar) {
        return this.f13464j.mo23248a(str, rbVar);
    }

    /* renamed from: a */
    public <T> T mo23039a(C7204rb<T> rbVar) {
        return this.f13464j.mo23249a(rbVar);
    }

    /* renamed from: a */
    public <T> T mo23040a(C7216ub<T> ubVar) {
        return mo23041a(ubVar, (T) null);
    }

    /* renamed from: a */
    public <T> T mo23041a(C7216ub<T> ubVar, T t) {
        return this.f13472r.mo23363b(ubVar, t);
    }

    /* renamed from: a */
    public <T> T mo23042a(C7216ub<T> ubVar, T t, SharedPreferences sharedPreferences) {
        return this.f13472r.mo23364b(ubVar, t, sharedPreferences);
    }

    /* renamed from: a */
    public <T> T mo23043a(String str, T t, Class cls, SharedPreferences sharedPreferences) {
        return this.f13472r.mo23356a(str, t, cls, sharedPreferences);
    }

    /* renamed from: a */
    public void mo23044a(SharedPreferences sharedPreferences) {
        this.f13472r.mo23357a(sharedPreferences);
    }

    /* renamed from: a */
    public void mo23045a(String str) {
        this.f13457G = str;
    }

    /* renamed from: a */
    public <T> void mo23046a(String str, T t, Editor editor) {
        this.f13472r.mo23361a(str, t, editor);
    }

    /* renamed from: a */
    public <T> void mo23047a(String str, T t, SharedPreferences sharedPreferences) {
        this.f13472r.mo23362a(str, t, sharedPreferences);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23048a(boolean z) {
        synchronized (this.f13451A) {
            this.f13452B = false;
            this.f13453C = z;
        }
        mo23027C().mo22972b();
    }

    /* renamed from: b */
    public C7262l mo23049b() {
        return this.f13462h;
    }

    /* renamed from: b */
    public List<String> mo23050b(C7204rb rbVar) {
        return this.f13464j.mo23254b(rbVar);
    }

    /* renamed from: b */
    public <T> void mo23051b(C7216ub<T> ubVar) {
        this.f13472r.mo23358a(ubVar);
    }

    /* renamed from: b */
    public <T> void mo23052b(C7216ub<T> ubVar, T t) {
        this.f13472r.mo23359a(ubVar, t);
    }

    /* renamed from: b */
    public <T> void mo23053b(C7216ub<T> ubVar, T t, SharedPreferences sharedPreferences) {
        this.f13472r.mo23360a(ubVar, t, sharedPreferences);
    }

    /* renamed from: b */
    public void mo23054b(String str) {
        this.f13464j.mo23251a(C7196pb.f13714K, (Object) str);
        this.f13464j.mo23250a();
    }

    /* renamed from: b */
    public void mo23055b(String str, C7268r rVar, Context context) {
        C7208sb sbVar;
        String str2 = "AppLovinSdk";
        this.f13458d = str;
        this.f13459e = rVar;
        this.f13461g = System.currentTimeMillis();
        f13450c = context.getApplicationContext();
        if (context instanceof Activity) {
            this.f13460f = new WeakReference<>((Activity) context);
        }
        ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            C7099Oc oc = new C7099Oc(this);
            this.f13462h = oc;
            this.f13472r = new C7220vb(this);
            this.f13464j = new C7208sb(this);
            this.f13464j.mo23255b();
            m15043O();
            this.f13463i = new C7110Sb(this);
            this.f13465k = new C7190o(this);
            this.f13466l = new C7076J(this);
            this.f13467m = new C7072I(this);
            this.f13468n = new C7068H(this);
            this.f13471q = new C7206s(this);
            this.f13473s = new C7067Gc(this);
            this.f13474t = new C7134a(this);
            this.f13475u = new C7115Ua(this);
            this.f13476v = new C7158g(this);
            this.f13477w = new C7146d(this);
            this.f13478x = new C7150e(this);
            this.f13479y = new C7144cb(this);
            this.f13469o = new C7237zc(this);
            this.f13470p = new C7109Sa(this);
            this.f13480z = new C7188nb(this);
            if (!m15042N()) {
                this.f13454D = true;
                Log.e(str2, "Unable to initialize AppLovin SDK: Android SDK version has to be at least level 8");
            }
            if (!C7269s.m15819a(str)) {
                this.f13455E = true;
                Log.e(str2, "Unable to find AppLovin SDK key. Please add     meta-data android:name=\"applovin.sdk.key\" android:value=\"YOUR_SDK_KEY_HERE\" into AndroidManifest.xml.");
                StringWriter stringWriter = new StringWriter();
                new Throwable("").printStackTrace(new PrintWriter(stringWriter));
                String stringWriter2 = stringWriter.toString();
                StringBuilder sb = new StringBuilder();
                sb.append("Called with an invalid SDK key from: ");
                sb.append(stringWriter2);
                Log.e(str2, sb.toString());
            }
            if (!mo23059d()) {
                if (rVar instanceof C7163ha) {
                    oc.mo22912a(((C7163ha) rVar).mo23159g());
                }
                if (rVar instanceof C7138b) {
                    this.f13464j.mo23251a(C7196pb.f13852n, (Object) Boolean.valueOf(rVar.mo23487f()));
                    sbVar = this.f13464j;
                } else {
                    if (((Boolean) this.f13464j.mo23249a(C7196pb.f13802d)).booleanValue()) {
                        rVar.mo23481a(C7209sc.m15486c(context));
                        rVar.mo23483b(C7209sc.m15488d(context));
                        this.f13464j.mo23252a(rVar);
                        sbVar = this.f13464j;
                    }
                    mo23067l();
                }
                sbVar.mo23250a();
                mo23067l();
            } else {
                mo23048a(false);
            }
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    /* renamed from: b */
    public void mo23056b(boolean z) {
        this.f13456F = z;
    }

    /* renamed from: c */
    public C7115Ua m15077c() {
        return this.f13475u;
    }

    /* renamed from: c */
    public boolean mo23058c(Context context) {
        String str = "AppLovinSdk";
        try {
            mo23049b().mo22918c(str, "Checking if SDK is initialized in main activity or application context...");
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setPackage(context.getPackageName());
            String stackTraceString = Log.getStackTraceString(new Throwable());
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities != null) {
                C7262l b = mo23049b();
                StringBuilder sb = new StringBuilder();
                sb.append("Found ");
                sb.append(queryIntentActivities.size());
                sb.append(" main activities for this application");
                b.mo22918c(str, sb.toString());
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    if (stackTraceString.contains(resolveInfo.activityInfo.name)) {
                        return true;
                    }
                }
            }
            if (stackTraceString.contains(mo23068m().getClass().getName())) {
                mo23049b().mo22918c(str, "SDK initialized in application context");
                return true;
            }
            mo23049b().mo22913a(str, "AppLovin SDK was initialized too late in session; SDK should always be initialized within main activity, application context, and/or any relevant entry points");
            C7262l b2 = mo23049b();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Initialization instead happened from: ");
            sb2.append(stackTraceString);
            b2.mo22913a(str, sb2.toString());
            return false;
        } catch (Throwable th) {
            mo23049b().mo22917b(str, "Error checking if SDK is initialized in main activity or application context...", th);
        }
    }

    /* renamed from: d */
    public boolean mo23059d() {
        return this.f13454D || this.f13455E;
    }

    /* renamed from: e */
    public void mo23060e() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public C7076J mo23061f() {
        return this.f13466l;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public C7072I mo23062g() {
        return this.f13467m;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public C7237zc mo23063h() {
        return this.f13469o;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public C7109Sa mo23064i() {
        return this.f13470p;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public boolean mo23065j() {
        boolean z;
        synchronized (this.f13451A) {
            z = this.f13452B;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public void mo23066k() {
        synchronized (this.f13451A) {
            if (!this.f13452B && !this.f13453C) {
                mo23067l();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public void mo23067l() {
        synchronized (this.f13451A) {
            this.f13452B = true;
            mo23027C().mo22968a();
            mo23027C().mo22970a((C7184mb) new C7078Jb(this), C7113Tb.MAIN);
        }
    }

    /* renamed from: m */
    public Context mo23068m() {
        return f13450c;
    }

    /* renamed from: n */
    public C7190o mo23069n() {
        return this.f13465k;
    }

    /* renamed from: o */
    public C7206s mo23070o() {
        return this.f13471q;
    }

    /* renamed from: p */
    public C7261k mo23071p() {
        return this.f13477w;
    }

    /* renamed from: q */
    public C7068H mo23072q() {
        return this.f13468n;
    }

    /* renamed from: r */
    public Activity mo23073r() {
        WeakReference<Activity> weakReference = this.f13460f;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    /* renamed from: s */
    public long mo23074s() {
        return this.f13461g;
    }

    /* renamed from: t */
    public String mo23075t() {
        return this.f13457G;
    }

    /* renamed from: u */
    public C7150e mo23076u() {
        return this.f13478x;
    }

    /* renamed from: v */
    public C7144cb mo23077v() {
        return this.f13479y;
    }

    /* renamed from: w */
    public C7158g mo23078w() {
        return this.f13476v;
    }

    /* renamed from: x */
    public String mo23079x() {
        return this.f13458d;
    }

    /* renamed from: y */
    public C7188nb mo23080y() {
        return this.f13480z;
    }

    /* renamed from: z */
    public C7268r mo23081z() {
        return this.f13459e;
    }
}
