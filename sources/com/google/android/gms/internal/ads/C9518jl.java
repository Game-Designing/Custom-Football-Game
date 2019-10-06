package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.ads.jl */
final /* synthetic */ class C9518jl implements zzcuz {

    /* renamed from: a */
    private final ArrayList f22622a;

    C9518jl(ArrayList arrayList) {
        this.f22622a = arrayList;
    }

    /* renamed from: a */
    public final void mo28065a(Object obj) {
        ((Bundle) obj).putStringArrayList("ad_types", this.f22622a);
    }
}
