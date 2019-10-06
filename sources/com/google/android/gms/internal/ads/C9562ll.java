package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.ads.ll */
final /* synthetic */ class C9562ll implements zzcuz {

    /* renamed from: a */
    private final ArrayList f22723a;

    C9562ll(ArrayList arrayList) {
        this.f22723a = arrayList;
    }

    /* renamed from: a */
    public final void mo28065a(Object obj) {
        ((Bundle) obj).putStringArrayList("android_permissions", this.f22723a);
    }
}
