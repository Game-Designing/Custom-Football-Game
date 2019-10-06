package com.smaato.soma.p239c;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import com.smaato.soma.p239c.p246f.p249c.C12227j.C12228a;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

/* renamed from: com.smaato.soma.c.a */
/* compiled from: DefaultFactory */
class C12151a implements C12228a {

    /* renamed from: a */
    final Geocoder f38099a = new Geocoder(this.f38100b, new Locale("en", "US"));

    /* renamed from: b */
    final /* synthetic */ Context f38100b;

    /* renamed from: c */
    final /* synthetic */ C12187c f38101c;

    C12151a(C12187c this$0, Context context) {
        this.f38101c = this$0;
        this.f38100b = context;
    }

    /* renamed from: a */
    public List<Address> mo39387a(double latitude, double longitude, int maxResults) throws IOException {
        return this.f38099a.getFromLocation(latitude, longitude, maxResults);
    }
}
