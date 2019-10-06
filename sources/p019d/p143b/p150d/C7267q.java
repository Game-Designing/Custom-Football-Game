package p019d.p143b.p150d;

import android.content.Context;
import android.util.Log;
import p019d.p143b.p144a.p147c.C7138b;
import p019d.p143b.p144a.p147c.C7142c;
import p019d.p143b.p149c.C7250d;

/* renamed from: d.b.d.q */
public abstract class C7267q {

    /* renamed from: a */
    protected static C7142c[] f14106a = new C7142c[0];

    /* renamed from: b */
    protected static final Object f14107b = new Object();

    /* renamed from: a */
    public static C7267q m15794a(Context context) {
        if (context != null) {
            return m15795a(C7269s.m15813a(context), new C7138b(context), context);
        }
        throw new IllegalArgumentException("No context specified");
    }

    /* renamed from: a */
    public static C7267q m15795a(String str, C7268r rVar, Context context) {
        C7142c[] cVarArr;
        if (rVar == null) {
            throw new IllegalArgumentException("No userSettings specified");
        } else if (context != null) {
            synchronized (f14107b) {
                if (f14106a.length != 1 || !f14106a[0].mo23079x().equals(str)) {
                    for (C7142c cVar : f14106a) {
                        if (cVar.mo23079x().equals(str)) {
                            return cVar;
                        }
                    }
                    try {
                        C7142c cVar2 = new C7142c();
                        cVar2.mo23055b(str, rVar, context);
                        cVar2.mo23056b(cVar2.mo23058c(context));
                        C7142c[] cVarArr2 = new C7142c[(f14106a.length + 1)];
                        System.arraycopy(f14106a, 0, cVarArr2, 0, f14106a.length);
                        cVarArr2[f14106a.length] = cVar2;
                        f14106a = cVarArr2;
                        return cVar2;
                    } catch (Throwable th) {
                        Log.e("AppLovinSdk", "Failed to build AppLovin SDK. Try cleaning application data and starting the application again.", th);
                        throw new RuntimeException("Unable to build AppLovin SDK");
                    }
                } else {
                    C7142c cVar3 = f14106a[0];
                    return cVar3;
                }
            }
        } else {
            throw new IllegalArgumentException("No context specified");
        }
    }

    /* renamed from: b */
    public static void m15796b(Context context) {
        if (context != null) {
            C7267q a = m15794a(context);
            if (a != null) {
                a.mo23060e();
            } else {
                Log.e("AppLovinSdk", "Unable to initialize AppLovin SDK: SDK object not created");
            }
        } else {
            throw new IllegalArgumentException("No context specified");
        }
    }

    /* renamed from: a */
    public abstract C7256f mo23037a();

    /* renamed from: a */
    public abstract void mo23045a(String str);

    /* renamed from: b */
    public abstract C7262l mo23049b();

    /* renamed from: b */
    public abstract void mo23054b(String str);

    /* renamed from: c */
    public abstract C7250d mo23057c();

    /* renamed from: d */
    public abstract boolean mo23059d();

    /* renamed from: e */
    public abstract void mo23060e();
}
