package p005cm.aptoide.p006pt;

import android.content.Context;
import p005cm.aptoide.p006pt.ads.GooglePlayServicesAvailabilityChecker;
import p005cm.aptoide.p006pt.dataprovider.ads.AdNetworkUtils;

/* renamed from: cm.aptoide.pt.L */
/* compiled from: lambda */
public final /* synthetic */ class C1373L implements GooglePlayServicesAvailabilityChecker {

    /* renamed from: a */
    public static final /* synthetic */ C1373L f4262a = new C1373L();

    private /* synthetic */ C1373L() {
    }

    public final boolean isAvailable(Context context) {
        return AdNetworkUtils.isGooglePlayServicesAvailable(context);
    }
}
