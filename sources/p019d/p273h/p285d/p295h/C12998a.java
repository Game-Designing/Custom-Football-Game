package p019d.p273h.p285d.p295h;

import android.content.Context;
import p019d.p273h.p274a.C12725c;

/* renamed from: d.h.d.h.a */
/* compiled from: DeviceProperties */
public class C12998a {

    /* renamed from: a */
    private static C12998a f39957a = null;

    /* renamed from: b */
    private String f39958b = C12725c.m41098f();

    /* renamed from: c */
    private String f39959c = C12725c.m41096e();

    /* renamed from: d */
    private String f39960d = C12725c.m41099g();

    /* renamed from: e */
    private String f39961e = C12725c.m41088b();

    /* renamed from: f */
    private int f39962f = C12725c.m41081a();

    /* renamed from: g */
    private String f39963g;

    private C12998a(Context context) {
        this.f39963g = C12725c.m41103i(context);
    }

    /* renamed from: b */
    public static C12998a m42384b(Context context) {
        if (f39957a == null) {
            f39957a = new C12998a(context);
        }
        return f39957a;
    }

    /* renamed from: d */
    public String mo41885d() {
        return this.f39958b;
    }

    /* renamed from: c */
    public String mo41884c() {
        return this.f39959c;
    }

    /* renamed from: e */
    public String mo41886e() {
        return this.f39960d;
    }

    /* renamed from: f */
    public String mo41887f() {
        return this.f39961e;
    }

    /* renamed from: a */
    public int mo41882a() {
        return this.f39962f;
    }

    /* renamed from: b */
    public String mo41883b() {
        return this.f39963g;
    }

    /* renamed from: g */
    public static String m42385g() {
        return "5.61";
    }

    /* renamed from: a */
    public float mo41881a(Context context) {
        return C12725c.m41106k(context);
    }
}
