package p019d.p143b.p144a.p147c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import java.util.Set;
import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.c.vb */
public final class C7220vb {

    /* renamed from: a */
    private static SharedPreferences f13999a;

    /* renamed from: b */
    private final C7142c f14000b;

    /* renamed from: c */
    private final SharedPreferences f14001c;

    C7220vb(C7142c cVar) {
        this.f14000b = cVar;
        StringBuilder sb = new StringBuilder();
        sb.append("com.applovin.sdk.preferences.");
        sb.append(cVar.mo23079x());
        this.f14001c = cVar.mo23068m().getSharedPreferences(sb.toString(), 0);
    }

    /* renamed from: a */
    private static SharedPreferences m15586a(Context context) {
        if (f13999a == null) {
            f13999a = context.getSharedPreferences("com.applovin.sdk.shared", 0);
        }
        return f13999a;
    }

    /* renamed from: a */
    private static <T> T m15587a(String str, T t, Class cls, SharedPreferences sharedPreferences, C7142c cVar) {
        T t2;
        String str2 = "SharedPreferencesManager";
        ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (sharedPreferences.contains(str)) {
                if (Boolean.class.equals(cls)) {
                    t2 = Boolean.valueOf(t != null ? sharedPreferences.getBoolean(str, ((Boolean) t).booleanValue()) : sharedPreferences.getBoolean(str, false));
                } else if (Float.class.equals(cls)) {
                    t2 = Float.valueOf(t != null ? sharedPreferences.getFloat(str, ((Float) t).floatValue()) : sharedPreferences.getFloat(str, 0.0f));
                } else if (Integer.class.equals(cls)) {
                    t2 = Integer.valueOf(t != null ? sharedPreferences.getInt(str, ((Integer) t).intValue()) : sharedPreferences.getInt(str, 0));
                } else if (Long.class.equals(cls)) {
                    t2 = Long.valueOf(t != null ? sharedPreferences.getLong(str, ((Long) t).longValue()) : sharedPreferences.getLong(str, 0));
                } else if (String.class.equals(cls)) {
                    t2 = sharedPreferences.getString(str, (String) t);
                } else {
                    if (Set.class.isAssignableFrom(cls)) {
                        if (C7182m.m15322b()) {
                            t2 = sharedPreferences.getStringSet(str, (Set) t);
                        } else if (cVar != null) {
                            C7262l b = cVar.mo23049b();
                            StringBuilder sb = new StringBuilder();
                            sb.append("Attempting to get string set on older Android version for key: ");
                            sb.append(str);
                            b.mo22916b(str2, sb.toString());
                        }
                    }
                    t2 = t;
                }
                if (t2 != null) {
                    return cls.cast(t2);
                }
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return t;
            }
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return t;
        } catch (Throwable th) {
            if (cVar != null) {
                C7262l b2 = cVar.mo23049b();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error getting value for key: ");
                sb2.append(str);
                b2.mo22917b(str2, sb2.toString(), th);
            }
            return t;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    /* renamed from: a */
    private static void m15588a(Editor editor, C7142c cVar) {
        if (cVar == null || !((Boolean) cVar.mo23039a(C7196pb.f13816fd)).booleanValue()) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    /* renamed from: a */
    static <T> void m15589a(C7216ub<T> ubVar, T t, Context context) {
        m15590a(ubVar.mo23344a(), t, m15586a(context), (Editor) null, (C7142c) null);
    }

    /* renamed from: a */
    private static <T> void m15590a(String str, T t, SharedPreferences sharedPreferences, Editor editor, C7142c cVar) {
        boolean z = false;
        boolean z2 = editor != null;
        if (!z2) {
            editor = sharedPreferences.edit();
        }
        if (t instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) t).booleanValue());
        } else if (t instanceof Float) {
            editor.putFloat(str, ((Float) t).floatValue());
        } else if (t instanceof Integer) {
            editor.putInt(str, ((Integer) t).intValue());
        } else if (t instanceof Long) {
            editor.putLong(str, ((Long) t).longValue());
        } else if (t instanceof String) {
            editor.putString(str, (String) t);
        } else {
            String str2 = "SharedPreferencesManager";
            if (t instanceof Set) {
                if (C7182m.m15322b()) {
                    editor.putStringSet(str, (Set) t);
                } else if (cVar != null) {
                    C7262l b = cVar.mo23049b();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Attempting to put string set on older Android version for key: ");
                    sb.append(str);
                    sb.append(" and value: ");
                    sb.append(t);
                    b.mo22916b(str2, sb.toString());
                }
            } else if (cVar != null) {
                C7262l b2 = cVar.mo23049b();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to put default value of invalid type: ");
                sb2.append(t);
                b2.mo22916b(str2, sb2.toString());
            }
            if (z && !z2) {
                m15588a(editor, cVar);
                return;
            }
        }
        z = true;
        if (z) {
        }
    }

    /* renamed from: b */
    static <T> T m15591b(C7216ub<T> ubVar, T t, Context context) {
        return m15587a(ubVar.mo23344a(), t, ubVar.mo23345b(), m15586a(context), (C7142c) null);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public <T> T mo23356a(String str, T t, Class cls, SharedPreferences sharedPreferences) {
        return m15587a(str, t, cls, sharedPreferences, this.f14000b);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23357a(SharedPreferences sharedPreferences) {
        m15588a(sharedPreferences.edit().clear(), this.f14000b);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public <T> void mo23358a(C7216ub<T> ubVar) {
        m15588a(this.f14001c.edit().remove(ubVar.mo23344a()), this.f14000b);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public <T> void mo23359a(C7216ub<T> ubVar, T t) {
        mo23360a(ubVar, t, this.f14001c);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public <T> void mo23360a(C7216ub<T> ubVar, T t, SharedPreferences sharedPreferences) {
        mo23362a(ubVar.mo23344a(), t, sharedPreferences);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public <T> void mo23361a(String str, T t, Editor editor) {
        m15590a(str, t, (SharedPreferences) null, editor, this.f14000b);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public <T> void mo23362a(String str, T t, SharedPreferences sharedPreferences) {
        m15590a(str, t, sharedPreferences, (Editor) null, this.f14000b);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public <T> T mo23363b(C7216ub<T> ubVar, T t) {
        return mo23364b(ubVar, t, this.f14001c);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public <T> T mo23364b(C7216ub<T> ubVar, T t, SharedPreferences sharedPreferences) {
        return mo23356a(ubVar.mo23344a(), t, ubVar.mo23345b(), sharedPreferences);
    }
}
