package com.paypal.android.sdk.payments;

import android.text.TextUtils;
import com.paypal.android.sdk.C11737Ja;
import com.paypal.android.sdk.C12020wb;
import com.paypal.android.sdk.C12024xb;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.paypal.android.sdk.payments.hb */
abstract class C11938hb {

    /* renamed from: a */
    private final C11949la f37553a;

    public C11938hb(C11949la laVar) {
        this.f37553a = laVar;
    }

    /* renamed from: a */
    private String m39560a(C12024xb xbVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(C12020wb.f37803b);
        String str = ":";
        sb.append(str);
        sb.append(mo39114a());
        sb.append(str);
        sb.append(xbVar.mo39210a());
        String sb2 = sb.toString();
        if (!z) {
            return sb2;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sb2);
        sb3.append("|error");
        return sb3.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract String mo39114a();

    /* renamed from: a */
    public void mo39118a(C12024xb xbVar, boolean z, String str, String str2, String str3) {
        C11737Ja.m38864a();
        String locale = Locale.getDefault().toString();
        HashMap hashMap = new HashMap();
        boolean z2 = !TextUtils.isEmpty(str);
        hashMap.put("gn", m39560a(xbVar, z2));
        hashMap.put("v31", m39560a(xbVar, z2));
        StringBuilder sb = new StringBuilder();
        sb.append(m39560a(xbVar, z2));
        sb.append(":");
        sb.append(xbVar.mo39211a(this.f37553a.mo39130d(), z));
        String sb2 = sb.toString();
        if (z2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append("|error");
            sb2 = sb3.toString();
        }
        hashMap.put("c25", sb2);
        hashMap.put("v25", "D=c25");
        StringBuilder sb4 = new StringBuilder();
        sb4.append(C12020wb.f37802a);
        sb4.append("::");
        hashMap.put("c37", sb4.toString());
        hashMap.put("c50", locale);
        hashMap.put("c35", "out");
        mo39116a(hashMap, xbVar, str2, str3);
        if (str != null) {
            hashMap.put("c29", str);
        }
        mo39115a("2.15.0", (Map) hashMap);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract void mo39115a(String str, Map map);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo39116a(Map map, C12024xb xbVar, String str, String str2);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C11949la mo39119b() {
        return this.f37553a;
    }
}
