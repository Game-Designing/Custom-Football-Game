package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import p005cm.aptoide.p006pt.BuildConfig;

public final class zzdae {

    /* renamed from: a */
    private final Executor f27728a;

    /* renamed from: b */
    private final zzbah f27729b;

    /* renamed from: c */
    private final zzcmu f27730c;

    /* renamed from: d */
    private final String f27731d;

    /* renamed from: e */
    private final String f27732e;

    /* renamed from: f */
    private final String f27733f;

    /* renamed from: g */
    private final Context f27734g;

    /* renamed from: h */
    private final Clock f27735h;

    public zzdae(Executor executor, zzbah zzbah, zzcmu zzcmu, zzbai zzbai, String str, String str2, Context context, Clock clock) {
        this.f27728a = executor;
        this.f27729b = zzbah;
        this.f27730c = zzcmu;
        this.f27731d = zzbai.f25057a;
        this.f27732e = str;
        this.f27733f = str2;
        this.f27734g = context;
        this.f27735h = clock;
    }

    /* renamed from: a */
    public final void mo31339a(zzcxu zzcxu, zzcxm zzcxm, List<String> list) {
        mo31341a(zzcxu, zzcxm, false, list);
    }

    /* renamed from: a */
    public final void mo31341a(zzcxu zzcxu, zzcxm zzcxm, boolean z, List<String> list) {
        ArrayList arrayList = new ArrayList();
        String str = z ? "1" : BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID;
        for (String a : list) {
            String a2 = m29071a(m29071a(m29071a(a, "@gw_adlocid@", zzcxu.f27595a.f27589a.f27602f), "@gw_adnetrefresh@", str), "@gw_sdkver@", this.f27731d);
            if (zzcxm != null) {
                String str2 = "@gw_allocid@";
                a2 = zzavx.m25931a(m29071a(m29071a(m29071a(a2, "@gw_qdata@", zzcxm.f27571v), "@gw_adnetid@", zzcxm.f27570u), str2, zzcxm.f27569t), this.f27734g, zzcxm.f27547M);
            }
            String str3 = "@gw_sessid@";
            arrayList.add(m29071a(m29071a(m29071a(a2, "@gw_adnetstatus@", this.f27730c.mo31211a()), "@gw_seqnum@", this.f27732e), str3, this.f27733f));
        }
        mo31343a((List<String>) arrayList);
    }

    /* renamed from: a */
    public final void mo31340a(zzcxu zzcxu, zzcxm zzcxm, List<String> list, zzasr zzasr) {
        long b = this.f27735h.mo27935b();
        try {
            String type = zzasr.getType();
            String num = Integer.toString(zzasr.getAmount());
            ArrayList arrayList = new ArrayList();
            String c = m29072c(zzcxu.f27595a.f27589a.f27606j);
            String c2 = m29072c(zzcxu.f27595a.f27589a.f27607k);
            for (String a : list) {
                String str = "@gw_rwd_custom_data@";
                String str2 = "@gw_tmstmp@";
                String str3 = "@gw_rwd_itm@";
                String str4 = "@gw_sdkver@";
                arrayList.add(zzavx.m25931a(m29071a(m29071a(m29071a(m29071a(m29071a(m29071a(a, "@gw_rwd_userid@", Uri.encode(c)), str, Uri.encode(c2)), str2, Long.toString(b)), str3, Uri.encode(type)), "@gw_rwd_amt@", num), str4, this.f27731d), this.f27734g, zzcxm.f27547M));
            }
            mo31343a((List<String>) arrayList);
        } catch (RemoteException e) {
        }
    }

    /* renamed from: a */
    public final void mo31343a(List<String> list) {
        for (String a : list) {
            mo31342a(a);
        }
    }

    /* renamed from: a */
    public final void mo31342a(String str) {
        this.f27728a.execute(new C8857Fm(this, str));
    }

    /* renamed from: a */
    private static String m29071a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    /* renamed from: c */
    private static String m29072c(String str) {
        if (TextUtils.isEmpty(str) || !zzazx.m26334a()) {
            return str;
        }
        return "fakeForAdDebugLog";
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ void mo31344b(String str) {
        this.f27729b.mo28178a(str);
    }
}
