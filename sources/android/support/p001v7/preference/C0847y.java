package android.support.p001v7.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.p000v4.content.C0510b;

/* renamed from: android.support.v7.preference.y */
/* compiled from: PreferenceManager */
public class C0847y {

    /* renamed from: a */
    private Context f2550a;

    /* renamed from: b */
    private long f2551b = 0;

    /* renamed from: c */
    private SharedPreferences f2552c;

    /* renamed from: d */
    private C0830n f2553d;

    /* renamed from: e */
    private Editor f2554e;

    /* renamed from: f */
    private boolean f2555f;

    /* renamed from: g */
    private String f2556g;

    /* renamed from: h */
    private int f2557h;

    /* renamed from: i */
    private int f2558i = 0;

    /* renamed from: j */
    private PreferenceScreen f2559j;

    /* renamed from: k */
    private C0851d f2560k;

    /* renamed from: l */
    private C0850c f2561l;

    /* renamed from: m */
    private C0848a f2562m;

    /* renamed from: n */
    private C0849b f2563n;

    /* renamed from: android.support.v7.preference.y$a */
    /* compiled from: PreferenceManager */
    public interface C0848a {
        void onDisplayPreferenceDialog(Preference preference);
    }

    /* renamed from: android.support.v7.preference.y$b */
    /* compiled from: PreferenceManager */
    public interface C0849b {
        void onNavigateToScreen(PreferenceScreen preferenceScreen);
    }

    /* renamed from: android.support.v7.preference.y$c */
    /* compiled from: PreferenceManager */
    public interface C0850c {
        boolean onPreferenceTreeClick(Preference preference);
    }

    /* renamed from: android.support.v7.preference.y$d */
    /* compiled from: PreferenceManager */
    public static abstract class C0851d {
        /* renamed from: a */
        public abstract boolean mo6522a(Preference preference, Preference preference2);

        /* renamed from: b */
        public abstract boolean mo6523b(Preference preference, Preference preference2);
    }

    public C0847y(Context context) {
        this.f2550a = context;
        mo6512a(m3985a(context));
    }

    /* renamed from: a */
    public PreferenceScreen mo6507a(Context context, int resId, PreferenceScreen rootPreferences) {
        m3986a(true);
        PreferenceScreen rootPreferences2 = (PreferenceScreen) new C0846x(context, this).mo6501a(resId, (PreferenceGroup) rootPreferences);
        rootPreferences2.mo6351a(this);
        m3986a(false);
        return rootPreferences2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public long mo6514b() {
        long j;
        synchronized (this) {
            j = this.f2551b;
            this.f2551b = 1 + j;
        }
        return j;
    }

    /* renamed from: a */
    public void mo6512a(String sharedPreferencesName) {
        this.f2556g = sharedPreferencesName;
        this.f2552c = null;
    }

    /* renamed from: f */
    public C0830n mo6518f() {
        return this.f2553d;
    }

    /* renamed from: h */
    public SharedPreferences mo6520h() {
        Context storageContext;
        if (mo6518f() != null) {
            return null;
        }
        if (this.f2552c == null) {
            if (this.f2558i != 1) {
                storageContext = this.f2550a;
            } else {
                storageContext = C0510b.m2566a(this.f2550a);
            }
            this.f2552c = storageContext.getSharedPreferences(this.f2556g, this.f2557h);
        }
        return this.f2552c;
    }

    /* renamed from: a */
    private static String m3985a(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append("_preferences");
        return sb.toString();
    }

    /* renamed from: g */
    public PreferenceScreen mo6519g() {
        return this.f2559j;
    }

    /* renamed from: a */
    public boolean mo6513a(PreferenceScreen preferenceScreen) {
        PreferenceScreen preferenceScreen2 = this.f2559j;
        if (preferenceScreen == preferenceScreen2) {
            return false;
        }
        if (preferenceScreen2 != null) {
            preferenceScreen2.mo6335L();
        }
        this.f2559j = preferenceScreen;
        return true;
    }

    /* renamed from: a */
    public Preference mo6506a(CharSequence key) {
        PreferenceScreen preferenceScreen = this.f2559j;
        if (preferenceScreen == null) {
            return null;
        }
        return preferenceScreen.mo6397c(key);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Editor mo6505a() {
        if (this.f2553d != null) {
            return null;
        }
        if (!this.f2555f) {
            return mo6520h().edit();
        }
        if (this.f2554e == null) {
            this.f2554e = mo6520h().edit();
        }
        return this.f2554e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public boolean mo6521i() {
        return !this.f2555f;
    }

    /* renamed from: a */
    private void m3986a(boolean noCommit) {
        if (!noCommit) {
            Editor editor = this.f2554e;
            if (editor != null) {
                editor.apply();
            }
        }
        this.f2555f = noCommit;
    }

    /* renamed from: e */
    public C0851d mo6517e() {
        return this.f2560k;
    }

    /* renamed from: a */
    public void mo6509a(C0848a onDisplayPreferenceDialogListener) {
        this.f2562m = onDisplayPreferenceDialogListener;
    }

    /* renamed from: a */
    public void mo6508a(Preference preference) {
        C0848a aVar = this.f2562m;
        if (aVar != null) {
            aVar.onDisplayPreferenceDialog(preference);
        }
    }

    /* renamed from: a */
    public void mo6511a(C0850c listener) {
        this.f2561l = listener;
    }

    /* renamed from: d */
    public C0850c mo6516d() {
        return this.f2561l;
    }

    /* renamed from: a */
    public void mo6510a(C0849b listener) {
        this.f2563n = listener;
    }

    /* renamed from: c */
    public C0849b mo6515c() {
        return this.f2563n;
    }
}
