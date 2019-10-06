package com.flurry.sdk;

import com.flurry.sdk.C7554lc.C7555a;
import java.net.SocketTimeoutException;

/* renamed from: com.flurry.sdk.J */
class C7399J implements C7555a<byte[], String> {

    /* renamed from: a */
    final /* synthetic */ C7423N f14510a;

    /* renamed from: b */
    final /* synthetic */ C7440Q f14511b;

    /* renamed from: c */
    final /* synthetic */ C7404K f14512c;

    C7399J(C7404K k, C7423N n, C7440Q q) {
        this.f14512c = k;
        this.f14510a = n;
        this.f14511b = q;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo23837a(C7554lc lcVar, Object obj) {
        boolean z;
        String str = (String) obj;
        C7423N n = this.f14510a;
        String str2 = n.f14563s;
        C7505da daVar = n.f14558n;
        String str3 = daVar.f14792h;
        C7552la laVar = daVar.f14789e;
        String b = C7404K.f14517k;
        StringBuilder sb = new StringBuilder("Pulse report to ");
        sb.append(str2);
        sb.append(" for ");
        sb.append(str3);
        sb.append(", HTTP status code is: ");
        sb.append(lcVar.f15017x);
        C7513ec.m16639a(3, b, sb.toString());
        int i = lcVar.f15017x;
        C7440Q q = this.f14511b;
        int i2 = (int) lcVar.f15015v;
        if (i2 >= 0) {
            q.f14614l += (long) i2;
        } else if (q.f14614l <= 0) {
            q.f14614l = 0;
        }
        this.f14511b.f14608f = i;
        if (!lcVar.mo23989c()) {
            Exception exc = lcVar.f15016w;
            boolean z2 = true;
            if (exc == null || !(exc instanceof SocketTimeoutException)) {
                z = false;
            } else {
                z = true;
            }
            if (!lcVar.f14998B && !z) {
                z2 = false;
            }
            String str4 = ". Exception: ";
            if (z2) {
                if (lcVar.mo23990d()) {
                    String b2 = C7404K.f14517k;
                    StringBuilder sb2 = new StringBuilder("Timeout occurred when trying to connect to: ");
                    sb2.append(str2);
                    sb2.append(str4);
                    sb2.append(lcVar.f15016w.getMessage());
                    C7513ec.m16639a(3, b2, sb2.toString());
                } else {
                    C7513ec.m16639a(3, C7404K.f14517k, "Manually managed http request timeout occurred for: ".concat(String.valueOf(str2)));
                }
                C7404K.m16382a(this.f14512c, this.f14511b, this.f14510a);
            } else {
                String b3 = C7404K.f14517k;
                StringBuilder sb3 = new StringBuilder("Error occurred when trying to connect to: ");
                sb3.append(str2);
                sb3.append(str4);
                sb3.append(exc.getMessage());
                C7513ec.m16639a(3, b3, sb3.toString());
                C7404K.m16384a(this.f14512c, this.f14511b, this.f14510a, str);
            }
            C7405a.m16393b(str2, str3, laVar);
        } else if (i >= 200 && i < 300) {
            C7404K.m16386b(this.f14512c, this.f14511b, this.f14510a);
            C7405a.m16392a(str2, str3, laVar);
        } else if (i < 300 || i >= 400) {
            String b4 = C7404K.f14517k;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str3);
            sb4.append(" report failed sending to : ");
            sb4.append(str2);
            C7513ec.m16639a(3, b4, sb4.toString());
            C7404K.m16384a(this.f14512c, this.f14511b, this.f14510a, str);
            C7405a.m16393b(str2, str3, laVar);
        } else {
            C7404K.m16383a(this.f14512c, this.f14511b, this.f14510a, lcVar);
        }
    }
}
