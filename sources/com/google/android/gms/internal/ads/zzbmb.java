package com.google.android.gms.internal.ads;

import java.util.Map;
import p005cm.aptoide.p006pt.app.view.donations.DonationsAnalytics;
import p005cm.aptoide.p006pt.database.realm.Notification;

public final class zzbmb implements zzbls {

    /* renamed from: a */
    private final zzaxb f25524a;

    public zzbmb(zzaxb zzaxb) {
        this.f25524a = zzaxb;
    }

    /* renamed from: a */
    public final void mo30727a(Map<String, String> map) {
        String str = (String) map.get(Notification.KEY);
        String str2 = (String) map.get(DonationsAnalytics.VALUE);
        if ("auto_collect_location".equals(str)) {
            this.f25524a.mo30213c(Boolean.parseBoolean(str2));
        }
    }
}
