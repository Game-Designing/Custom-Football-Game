package p005cm.aptoide.p006pt.home;

import java.util.List;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Event;

/* renamed from: cm.aptoide.pt.home.HomeBundle */
public interface HomeBundle {

    /* renamed from: cm.aptoide.pt.home.HomeBundle$BundleType */
    public enum BundleType {
        EDITORS,
        APPS,
        ADS,
        UNKNOWN,
        LOADING,
        STORE,
        INFO_BUNDLE,
        APPCOINS_ADS,
        EDITORIAL,
        SMALL_BANNER,
        WALLET_ADS_OFFER,
        TOP;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[10] = true;
        }

        public boolean isApp() {
            boolean z;
            boolean[] $jacocoInit = $jacocoInit();
            if (equals(APPS)) {
                $jacocoInit[3] = true;
            } else if (equals(EDITORS)) {
                $jacocoInit[4] = true;
            } else if (equals(ADS)) {
                $jacocoInit[5] = true;
            } else if (equals(APPCOINS_ADS)) {
                $jacocoInit[6] = true;
            } else {
                z = false;
                $jacocoInit[8] = true;
                $jacocoInit[9] = true;
                return z;
            }
            $jacocoInit[7] = true;
            z = true;
            $jacocoInit[9] = true;
            return z;
        }
    }

    List<?> getContent();

    Event getEvent();

    String getTag();

    String getTitle();

    BundleType getType();
}
