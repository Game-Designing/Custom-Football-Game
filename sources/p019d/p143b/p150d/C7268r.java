package p019d.p143b.p150d;

import android.content.Context;
import android.util.Log;
import p019d.p143b.p144a.p147c.C7209sc;

/* renamed from: d.b.d.r */
public class C7268r {

    /* renamed from: a */
    private boolean f14108a;

    /* renamed from: b */
    private boolean f14109b;

    /* renamed from: c */
    private long f14110c;

    /* renamed from: d */
    private String f14111d;

    /* renamed from: e */
    private String f14112e;

    /* renamed from: f */
    private boolean f14113f;

    public C7268r() {
        this(null);
    }

    protected C7268r(Context context) {
        this.f14109b = C7209sc.m15488d(context);
        this.f14108a = C7209sc.m15486c(context);
        this.f14110c = -1;
        StringBuilder sb = new StringBuilder();
        sb.append(C7257g.f14096c.mo23473b());
        String str = ",";
        sb.append(str);
        sb.append(C7257g.f14094a.mo23473b());
        sb.append(str);
        sb.append(C7257g.f14097d.mo23473b());
        this.f14111d = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(C7258h.f14103b.mo23476a());
        sb2.append(str);
        sb2.append(C7258h.f14102a.mo23476a());
        sb2.append(str);
        sb2.append(C7258h.f14104c.mo23476a());
        this.f14112e = sb2.toString();
    }

    @Deprecated
    /* renamed from: a */
    public String mo23480a() {
        return this.f14111d;
    }

    /* renamed from: a */
    public void mo23481a(boolean z) {
        this.f14108a = z;
    }

    @Deprecated
    /* renamed from: b */
    public String mo23482b() {
        return this.f14112e;
    }

    /* renamed from: b */
    public void mo23483b(boolean z) {
        if (C7209sc.m15476a()) {
            Log.e("AppLovinSdk", "[AppLovinSdkSettings] Ignoring setting of verbose logging - it is configured from Android manifest already or AppLovinSdkSettings was initialized without a context.");
        } else {
            this.f14109b = z;
        }
    }

    /* renamed from: c */
    public long mo23484c() {
        return this.f14110c;
    }

    /* renamed from: d */
    public boolean mo23485d() {
        return this.f14113f;
    }

    /* renamed from: e */
    public boolean mo23486e() {
        return this.f14108a;
    }

    /* renamed from: f */
    public boolean mo23487f() {
        return this.f14109b;
    }
}
