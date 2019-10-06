package com.flurry.sdk;

import android.content.Context;
import com.flurry.sdk.C7607ud.C7608a;
import java.lang.ref.WeakReference;

/* renamed from: com.flurry.sdk.Ca */
class C7361Ca implements C7452Sb<C7537id> {

    /* renamed from: a */
    final /* synthetic */ C7461Ua f14380a;

    C7361Ca(C7461Ua ua) {
        this.f14380a = ua;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo23509a(C7447Rb rb) {
        C7537id idVar = (C7537id) rb;
        if (this.f14380a.f14696q == null || idVar.f14884c == this.f14380a.f14696q.get()) {
            int i = C7456Ta.f14663a[idVar.f14885d - 1];
            if (i == 1) {
                C7461Ua ua = this.f14380a;
                C7531hd hdVar = idVar.f14884c;
                Context context = (Context) idVar.f14883b.get();
                ua.f14696q = new WeakReference<>(hdVar);
                C7602td a = C7602td.m16825a();
                String str = "LogEvents";
                ua.f14703x = ((Boolean) a.mo24023a(str)).booleanValue();
                a.mo24024a(str, (C7608a) ua);
                String str2 = C7461Ua.f14670a;
                StringBuilder sb = new StringBuilder("initSettings, LogEvents = ");
                sb.append(ua.f14703x);
                C7513ec.m16639a(4, str2, sb.toString());
                String str3 = "UserId";
                ua.f14704y = (String) a.mo24023a(str3);
                a.mo24024a(str3, (C7608a) ua);
                String str4 = C7461Ua.f14670a;
                StringBuilder sb2 = new StringBuilder("initSettings, UserId = ");
                sb2.append(ua.f14704y);
                C7513ec.m16639a(4, str4, sb2.toString());
                String str5 = "Gender";
                ua.f14705z = ((Byte) a.mo24023a(str5)).byteValue();
                a.mo24024a(str5, (C7608a) ua);
                String str6 = C7461Ua.f14670a;
                StringBuilder sb3 = new StringBuilder("initSettings, Gender = ");
                sb3.append(ua.f14705z);
                C7513ec.m16639a(4, str6, sb3.toString());
                String str7 = "Age";
                ua.f14676A = (Long) a.mo24023a(str7);
                a.mo24024a(str7, (C7608a) ua);
                String str8 = C7461Ua.f14670a;
                StringBuilder sb4 = new StringBuilder("initSettings, BirthDate = ");
                sb4.append(ua.f14676A);
                C7513ec.m16639a(4, str8, sb4.toString());
                String str9 = "analyticsEnabled";
                ua.f14683H = ((Boolean) a.mo24023a(str9)).booleanValue();
                a.mo24024a(str9, (C7608a) ua);
                String str10 = C7461Ua.f14670a;
                StringBuilder sb5 = new StringBuilder("initSettings, AnalyticsEnabled = ");
                sb5.append(ua.f14683H);
                C7513ec.m16639a(4, str10, sb5.toString());
                StringBuilder sb6 = new StringBuilder(".flurryagent.");
                sb6.append(Integer.toString(C7379Fb.m16300a().f14436h.hashCode(), 16));
                ua.f14697r = context.getFileStreamPath(sb6.toString());
                String str11 = ".yflurryreport.";
                StringBuilder sb7 = new StringBuilder(str11);
                sb7.append(Long.toString(C7354Ad.m16269f(C7379Fb.m16300a().f14436h), 16));
                ua.f14698s = new C7443Qb<>(context.getFileStreamPath(sb7.toString()), str11, 1, new C7366Da(ua));
                ua.f14682G = hdVar.mo23956a();
                ua.mo23903a(context);
                ua.mo23906a(true);
                if (C7449Rd.m16479a().f14637b != null) {
                    C7379Fb.m16300a().mo23817b(new C7373Ea(ua));
                }
                C7379Fb.m16300a().mo23817b(new C7378Fa(ua));
                C7379Fb.m16300a().mo23817b(new C7383Ga(ua));
                C7379Fb.m16300a().mo23817b(new C7388Ha(ua));
                if (C7517fb.m16656a().mo23947b()) {
                    C7379Fb.m16300a().mo23817b(new C7394Ia(ua));
                    return;
                }
                C7462Ub.m16528a().mo23910a("com.flurry.android.sdk.IdProviderFinishedEvent", ua.f14684I);
            } else if (i == 2) {
                C7461Ua ua2 = this.f14380a;
                idVar.f14883b.get();
                ua2.mo23901a();
            } else if (i == 3) {
                C7461Ua ua3 = this.f14380a;
                idVar.f14883b.get();
                ua3.mo23907b();
            } else if (i == 4) {
                C7462Ub.m16528a().mo23911b("com.flurry.android.sdk.FlurrySessionEvent", this.f14380a.f14685J);
                this.f14380a.mo23902a(idVar.f14886e);
            }
        }
    }
}
