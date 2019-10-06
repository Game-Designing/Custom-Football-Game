package p005cm.aptoide.p006pt.app;

import p005cm.aptoide.p006pt.ads.data.ApplicationAd;
import p005cm.aptoide.p006pt.ads.data.ApplicationAdError;

/* renamed from: cm.aptoide.pt.app.ApplicationAdResult */
public interface ApplicationAdResult {
    ApplicationAd getAd();

    ApplicationAdError getError();
}
