package com.paypal.android.sdk;

import android.util.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* renamed from: com.paypal.android.sdk.Aa */
public abstract class C11703Aa {

    /* renamed from: a */
    private static final String f36562a = C11703Aa.class.getSimpleName();

    /* renamed from: b */
    private static long f36563b = 1;

    /* renamed from: c */
    private final Map f36564c = new LinkedHashMap();

    /* renamed from: d */
    private final C11707Ba f36565d;

    /* renamed from: e */
    private final C12027ya f36566e;

    /* renamed from: f */
    private final String f36567f;

    /* renamed from: g */
    private final long f36568g;

    /* renamed from: h */
    private String f36569h;

    /* renamed from: i */
    private String f36570i;

    /* renamed from: j */
    private C11789aa f36571j;

    /* renamed from: k */
    private Integer f36572k;

    /* renamed from: l */
    private String f36573l;

    public C11703Aa(C12027ya yaVar, C11707Ba ba, C11706B b, String str) {
        long j = f36563b;
        f36563b = 1 + j;
        this.f36568g = j;
        this.f36566e = yaVar;
        this.f36567f = str;
        this.f36565d = ba;
    }

    /* renamed from: k */
    public static void m38683k() {
    }

    /* renamed from: a */
    public String mo38496a(C12027ya yaVar) {
        String a = this.f36565d.mo38528a(yaVar);
        if (a == null) {
            StringBuilder sb = new StringBuilder("API ");
            sb.append(yaVar.toString());
            sb.append(" has no record for server ");
            sb.append(this.f36565d.mo38530c());
            throw new RuntimeException(sb.toString());
        } else if (this.f36567f == null) {
            return a;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(a);
            sb2.append(this.f36567f);
            return sb2.toString();
        }
    }

    /* renamed from: a */
    public final void mo38497a(C11789aa aaVar) {
        if (this.f36571j == null) {
            this.f36571j = aaVar;
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Multiple exceptions reported");
        String str = f36562a;
        StringBuilder sb = new StringBuilder("first mError=");
        sb.append(this.f36571j);
        Log.e(str, sb.toString());
        String str2 = f36562a;
        StringBuilder sb2 = new StringBuilder("second mError=");
        sb2.append(aaVar);
        Log.e(str2, sb2.toString());
        Log.e(f36562a, "", illegalStateException);
        throw illegalStateException;
    }

    /* renamed from: a */
    public final void mo38498a(Integer num) {
        this.f36572k = num;
    }

    /* renamed from: a */
    public final void mo38499a(String str) {
        this.f36569h = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo38500a(String str, String str2) {
        this.f36564c.put(str, str2);
    }

    /* renamed from: a */
    public final void mo38501a(String str, String str2, String str3) {
        mo38497a((C11789aa) new C11797ca(str, str2, str3));
    }

    /* renamed from: a */
    public boolean mo38502a() {
        return false;
    }

    /* renamed from: b */
    public abstract String mo38503b();

    /* renamed from: b */
    public final void mo38504b(String str) {
        this.f36570i = str;
    }

    /* renamed from: c */
    public abstract void mo38505c();

    /* renamed from: c */
    public final void mo38506c(String str) {
        this.f36573l = str;
    }

    /* renamed from: d */
    public abstract void mo38507d();

    /* renamed from: e */
    public abstract String mo38508e();

    /* renamed from: f */
    public final String mo38509f() {
        return this.f36569h;
    }

    /* renamed from: g */
    public final String mo38510g() {
        return this.f36570i;
    }

    /* renamed from: h */
    public final C12027ya mo38511h() {
        return this.f36566e;
    }

    /* renamed from: i */
    public final Map mo38512i() {
        return this.f36564c;
    }

    /* renamed from: j */
    public final String mo38513j() {
        return this.f36573l;
    }

    /* renamed from: l */
    public void mo38514l() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public final JSONObject mo38515m() {
        String str = this.f36570i;
        Object nextValue = new JSONTokener(str).nextValue();
        if (nextValue instanceof JSONObject) {
            return (JSONObject) nextValue;
        }
        StringBuilder sb = new StringBuilder("could not parse:");
        sb.append(str);
        sb.append("\nnextValue:");
        sb.append(nextValue);
        throw new JSONException(sb.toString());
    }

    /* renamed from: n */
    public final String mo38516n() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" SN:");
        sb.append(this.f36568g);
        return sb.toString();
    }

    /* renamed from: o */
    public final long mo38517o() {
        return this.f36568g;
    }

    /* renamed from: p */
    public final C11789aa mo38518p() {
        return this.f36571j;
    }

    /* renamed from: q */
    public final boolean mo38519q() {
        return this.f36571j == null;
    }

    /* renamed from: r */
    public final Integer mo38520r() {
        return this.f36572k;
    }

    /* renamed from: s */
    public final C11707Ba mo38521s() {
        return this.f36565d;
    }
}
