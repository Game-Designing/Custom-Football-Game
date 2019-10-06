package com.smaato.soma.p239c;

import android.content.Context;
import android.location.LocationManager;
import android.webkit.WebView;
import com.smaato.soma.C12064Na;
import com.smaato.soma.C12322e;
import com.smaato.soma.C12369fa;
import com.smaato.soma.C12431j;
import com.smaato.soma.p236a.C12125n;
import com.smaato.soma.p236a.C12138y;
import com.smaato.soma.p239c.p246f.C12239k;
import com.smaato.soma.p239c.p246f.C12248t;
import com.smaato.soma.p239c.p246f.C12250u;
import com.smaato.soma.p239c.p246f.p249c.C12227j;
import com.smaato.soma.p239c.p246f.p249c.C12227j.C12228a;
import com.smaato.soma.p239c.p250g.C12259f;
import com.smaato.soma.p239c.p250g.C12262i;
import com.smaato.soma.p239c.p250g.C12263j;
import com.smaato.soma.p239c.p254k.C12301p;

/* renamed from: com.smaato.soma.c.c */
/* compiled from: DefaultFactory */
public class C12187c {

    /* renamed from: a */
    private static C12187c f38211a = null;

    /* renamed from: b */
    public static C12187c m40092b() {
        if (f38211a == null) {
            f38211a = new C12187c();
        }
        return f38211a;
    }

    /* renamed from: a */
    public C12322e mo39469a(Context context, C12369fa baseView) {
        return new C12239k(context, mo39468a(), mo39467a(context), baseView);
    }

    /* renamed from: a */
    public C12250u mo39468a() {
        return new C12248t(new C12262i(new C12259f()), new C12263j());
    }

    /* renamed from: a */
    public C12227j mo39467a(Context context) {
        return new C12227j(context.getApplicationContext(), (LocationManager) context.getSystemService("location"), m40093b(context));
    }

    /* renamed from: b */
    private C12228a m40093b(Context context) {
        return new C12151a(this, context);
    }

    /* renamed from: a */
    public C12125n mo39466a(C12431j adType) {
        if (adType == null) {
            return m40094c();
        }
        if (adType == C12431j.IMAGE) {
            return new C12138y();
        }
        return m40094c();
    }

    /* renamed from: a */
    public WebView mo39465a(Context context, C12064Na banner, C12369fa bannerView) {
        return new C12301p(context, banner, bannerView);
    }

    /* renamed from: c */
    private C12125n m40094c() {
        return new C12153b(this);
    }
}
