package com.flurry.sdk;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.flurry.sdk.Hc */
public abstract class C7390Hc {

    /* renamed from: a */
    protected final String f14482a;

    /* renamed from: b */
    protected String f14483b = "defaultDataKey_";

    /* renamed from: c */
    Set<String> f14484c = new HashSet();

    /* renamed from: d */
    C7448Rc f14485d;

    /* renamed from: e */
    private C7452Sb<C7553lb> f14486e = new C7358Bc(this);

    /* renamed from: com.flurry.sdk.Hc$a */
    public interface C7391a {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo23829a(byte[] bArr, String str, String str2);

    public C7390Hc(String str, String str2) {
        this.f14482a = str2;
        C7462Ub.m16528a().mo23910a("com.flurry.android.sdk.NetworkStateEvent", this.f14486e);
        C7379Fb.m16300a().mo23817b(new C7363Cc(this, str));
    }

    /* renamed from: b */
    public final void mo23831b(byte[] bArr, String str, String str2) {
        if (bArr == null || bArr.length == 0) {
            C7513ec.m16639a(6, this.f14482a, "Report that has to be sent is EMPTY or NULL");
            return;
        }
        C7379Fb.m16300a().mo23817b(new C7368Dc(this, bArr, str, str2));
        mo23827a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo23827a() {
        C7379Fb.m16300a().mo23817b(new C7375Ec(this));
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final void mo23833c(byte[] bArr, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f14483b);
        sb.append(str);
        sb.append("_");
        sb.append(str2);
        String sb2 = sb.toString();
        C7413Lc lc = new C7413Lc(bArr);
        String str3 = lc.f14534a;
        C7413Lc.m16408b(str3).mo23882a(lc);
        String str4 = this.f14482a;
        StringBuilder sb3 = new StringBuilder("Saving Block File ");
        sb3.append(str3);
        sb3.append(" at ");
        sb3.append(C7379Fb.m16300a().f14432d.getFileStreamPath(C7413Lc.m16407a(str3)));
        C7513ec.m16639a(5, str4, sb3.toString());
        this.f14485d.mo23887a(lc, sb2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo23830b() {
        if (!C7570ob.m16755a().f14971d) {
            C7513ec.m16639a(5, this.f14482a, "Reports were not sent! No Internet connection!");
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>(this.f14485d.f14635d.keySet());
        if (arrayList.isEmpty()) {
            C7513ec.m16639a(4, this.f14482a, "No more reports to send.");
            return;
        }
        for (String str : arrayList) {
            if (!m16357d()) {
                break;
            }
            List<String> a = this.f14485d.mo23886a(str);
            String str2 = this.f14482a;
            StringBuilder sb = new StringBuilder("Number of not sent blocks = ");
            sb.append(a.size());
            C7513ec.m16639a(4, str2, sb.toString());
            for (String str3 : a) {
                if (!this.f14484c.contains(str3)) {
                    if (!m16357d()) {
                        break;
                    }
                    C7413Lc lc = (C7413Lc) C7413Lc.m16408b(str3).mo23881a();
                    if (lc == null) {
                        C7513ec.m16639a(6, this.f14482a, "Internal ERROR! Cannot read!");
                        this.f14485d.mo23888a(str3, str);
                    } else {
                        byte[] bArr = lc.f14535b;
                        if (bArr == null || bArr.length == 0) {
                            C7513ec.m16639a(6, this.f14482a, "Internal ERROR! Report is empty!");
                            this.f14485d.mo23888a(str3, str);
                        } else {
                            C7513ec.m16639a(5, this.f14482a, "Reading block info ".concat(String.valueOf(str3)));
                            this.f14484c.add(str3);
                            mo23829a(bArr, str3, str);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: d */
    private boolean m16357d() {
        return m16358e() <= 5;
    }

    /* renamed from: e */
    private int m16358e() {
        return this.f14484c.size();
    }

    /* renamed from: c */
    public final void mo23832c() {
        mo23827a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23828a(String str, String str2, int i) {
        C7379Fb.m16300a().mo23817b(new C7380Fc(this, str, str2));
    }
}
