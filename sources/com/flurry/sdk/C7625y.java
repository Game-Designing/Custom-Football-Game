package com.flurry.sdk;

import com.flurry.sdk.C7554lc.C7555a;
import java.util.List;

/* renamed from: com.flurry.sdk.y */
class C7625y implements C7555a<byte[], byte[]> {

    /* renamed from: a */
    final /* synthetic */ long f15136a;

    /* renamed from: b */
    final /* synthetic */ boolean f15137b;

    /* renamed from: c */
    final /* synthetic */ C7382G f15138c;

    C7625y(C7382G g, long j, boolean z) {
        this.f15138c = g;
        this.f15136a = j;
        this.f15137b = z;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo23837a(C7554lc lcVar, Object obj) {
        C7515f fVar;
        byte[] bArr = (byte[]) obj;
        int i = lcVar.f15017x;
        C7513ec.m16639a(3, C7382G.f14442a, "Proton config request: HTTP status code is:".concat(String.valueOf(i)));
        if (i == 400 || i == 406 || i == 412 || i == 415) {
            this.f15138c.f14454m = 10000;
            return;
        }
        C7515f fVar2 = null;
        if (lcVar.mo23989c() && bArr != null) {
            C7379Fb.m16300a().mo23817b(new C7620x(this, bArr));
            try {
                fVar = (C7515f) this.f15138c.f14444c.mo23963c(bArr);
            } catch (Exception e) {
                C7513ec.m16639a(5, C7382G.f14442a, "Failed to decode proton config response: ".concat(String.valueOf(e)));
                fVar = null;
            }
            if (C7382G.m16324b(fVar)) {
                fVar2 = fVar;
            }
            if (fVar2 != null) {
                this.f15138c.f14454m = 10000;
                this.f15138c.f14455n = this.f15136a;
                this.f15138c.f14456o = this.f15137b;
                this.f15138c.f14457p = fVar2;
                this.f15138c.m16332g();
                if (!this.f15138c.f14458q) {
                    this.f15138c.f14458q = true;
                    this.f15138c.m16323b("flurry.session_start", null);
                }
                this.f15138c.m16334h();
            }
        }
        if (fVar2 == null) {
            long j = this.f15138c.f14454m << 1;
            if (i == 429) {
                List a = lcVar.mo23987a("Retry-After");
                if (!a.isEmpty()) {
                    String str = (String) a.get(0);
                    C7513ec.m16639a(3, C7382G.f14442a, "Server returned retry time: ".concat(String.valueOf(str)));
                    try {
                        j = Long.parseLong(str) * 1000;
                    } catch (NumberFormatException e2) {
                        C7513ec.m16639a(3, C7382G.f14442a, "Server returned nonsensical retry time");
                    }
                }
            }
            this.f15138c.f14454m = j;
            String d = C7382G.f14442a;
            StringBuilder sb = new StringBuilder("Proton config request failed, backing off: ");
            sb.append(this.f15138c.f14454m);
            sb.append("ms");
            C7513ec.m16639a(3, d, sb.toString());
            C7379Fb.m16300a().mo23816a(this.f15138c.f14459r, this.f15138c.f14454m);
        }
    }
}
