package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.C11723Fa;
import com.paypal.android.sdk.C11774W;
import com.paypal.android.sdk.C11817ex;
import com.paypal.android.sdk.C12020wb;
import com.paypal.android.sdk.C12024xb;
import java.util.Map;

/* renamed from: com.paypal.android.sdk.payments.gb */
final class C11935gb extends C11938hb {
    public C11935gb(PayPalService payPalService) {
        super(new C11949la(payPalService));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final String mo39114a() {
        return "msdk";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo39115a(String str, Map map) {
        if (!mo39119b().mo39126a().f36741a.mo38702a()) {
            mo39119b().mo39126a().f36741a = new C11817ex();
        }
        map.put("v49", str);
        map.put("v51", mo39119b().mo39129c().mo38531d().mo38696d());
        StringBuilder sb = new StringBuilder();
        sb.append(C12020wb.f37802a);
        sb.append(" ");
        sb.append(C12020wb.f37804c);
        map.put("v52", sb.toString());
        map.put("v53", C12020wb.f37805d);
        map.put("clid", mo39119b().mo39128b());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(mo39119b().mo39129c().mo38531d().mo38694c());
        String str2 = "|";
        sb2.append(str2);
        sb2.append(str);
        sb2.append(str2);
        sb2.append(mo39119b().mo39132f());
        map.put("apid", sb2.toString());
        mo39119b().mo39127a(new C11774W(mo39119b().mo39126a().f36741a.mo38703b(), map));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo39116a(Map map, C12024xb xbVar, String str, String str2) {
        map.put("g", mo39119b().mo39131e());
        StringBuilder sb = new StringBuilder();
        sb.append(C12020wb.f37802a);
        String str3 = ":";
        sb.append(str3);
        sb.append(mo39119b().mo39130d());
        sb.append(str3);
        map.put("vers", sb.toString());
        String str4 = "msdk";
        map.put("srce", str4);
        String str5 = "mobile";
        map.put("sv", str5);
        map.put("bchn", str4);
        map.put("adte", "FALSE");
        map.put("bzsr", str5);
        if (C11723Fa.m38822b((CharSequence) str)) {
            map.put("calc", str);
        }
        if (C11723Fa.m38822b((CharSequence) str2)) {
            map.put("prid", str2);
        }
        map.put("e", xbVar.mo39212b() ? "cl" : "im");
    }
}
