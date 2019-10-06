package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.Fh */
final /* synthetic */ class C8852Fh implements Callable {

    /* renamed from: a */
    private final zzcaq f20862a;

    /* renamed from: b */
    private final zzcxu f20863b;

    /* renamed from: c */
    private final zzcxm f20864c;

    /* renamed from: d */
    private final JSONObject f20865d;

    C8852Fh(zzcaq zzcaq, zzcxu zzcxu, zzcxm zzcxm, JSONObject jSONObject) {
        this.f20862a = zzcaq;
        this.f20863b = zzcxu;
        this.f20864c = zzcxm;
        this.f20865d = jSONObject;
    }

    public final Object call() {
        zzcxu zzcxu = this.f20863b;
        zzcxm zzcxm = this.f20864c;
        JSONObject jSONObject = this.f20865d;
        zzbyt zzbyt = new zzbyt();
        zzbyt.mo30989a(jSONObject.optInt("template_id", -1));
        zzbyt.mo30997a(jSONObject.optString("custom_template_id"));
        zzcxv zzcxv = zzcxu.f27595a.f27589a;
        if (zzcxv.f27603g.contains(Integer.toString(zzbyt.mo31016n()))) {
            if (zzbyt.mo31016n() == 3) {
                if (zzbyt.mo31007e() == null) {
                    throw new zzcmw("No custom template id for custom template ad response.", 0);
                } else if (!zzcxv.f27604h.contains(zzbyt.mo31007e())) {
                    throw new zzcmw("Unexpected custom template id in the response.", 0);
                }
            }
            zzbyt.mo30988a(jSONObject.optDouble("rating", -1.0d));
            String str = "headline";
            String optString = jSONObject.optString(str, null);
            if (zzcxm.f27539E) {
                zzk.zzlg();
                String c = zzaxi.m26126c();
                StringBuilder sb = new StringBuilder(String.valueOf(c).length() + 3 + String.valueOf(optString).length());
                sb.append(c);
                sb.append(" : ");
                sb.append(optString);
                optString = sb.toString();
            }
            zzbyt.mo30999a(str, optString);
            String str2 = "body";
            zzbyt.mo30999a(str2, jSONObject.optString(str2, null));
            String str3 = "call_to_action";
            zzbyt.mo30999a(str3, jSONObject.optString(str3, null));
            String str4 = "store";
            zzbyt.mo30999a(str4, jSONObject.optString(str4, null));
            String str5 = "price";
            zzbyt.mo30999a(str5, jSONObject.optString(str5, null));
            String str6 = "advertiser";
            zzbyt.mo30999a(str6, jSONObject.optString(str6, null));
            return zzbyt;
        }
        int n = zzbyt.mo31016n();
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append("Invalid template ID: ");
        sb2.append(n);
        throw new zzcmw(sb2.toString(), 0);
    }
}
