package p005cm.aptoide.p006pt.app;

import java.util.Collections;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.ads.data.ApplicationAd;
import p005cm.aptoide.p006pt.ads.data.ApplicationAdError;
import p005cm.aptoide.p006pt.view.app.Application;
import p005cm.aptoide.p006pt.view.app.AppsList.Error;

/* renamed from: cm.aptoide.pt.app.SimilarAppsViewModel */
public class SimilarAppsViewModel {
    private static transient /* synthetic */ boolean[] $jacocoData;

    /* renamed from: ad */
    private final ApplicationAd f4676ad;
    private final ApplicationAdError adError;
    private boolean hasRecordedAdImpression;
    private final boolean loading;
    private final List<Application> recommendedApps;
    private final Error recommendedAppsError;
    private boolean shouldLoadNativeAds;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5949070225154681289L, "cm/aptoide/pt/app/SimilarAppsViewModel", 35);
        $jacocoData = probes;
        return probes;
    }

    public SimilarAppsViewModel(ApplicationAd ad, List<Application> recommendedApps2, boolean loading2, Error recommendedAppsError2, ApplicationAdError adResultError) {
        boolean[] $jacocoInit = $jacocoInit();
        this(ad, recommendedApps2, loading2, recommendedAppsError2, adResultError, false);
        $jacocoInit[0] = true;
    }

    public SimilarAppsViewModel(ApplicationAd ad, List<Application> recommendedApps2, boolean loading2, Error recommendedAppsError2, ApplicationAdError adResultError, boolean shouldLoadNativeAds2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.f4676ad = ad;
        this.recommendedApps = recommendedApps2;
        this.loading = loading2;
        this.recommendedAppsError = recommendedAppsError2;
        this.adError = adResultError;
        this.hasRecordedAdImpression = false;
        this.shouldLoadNativeAds = shouldLoadNativeAds2;
        $jacocoInit[1] = true;
    }

    public SimilarAppsViewModel() {
        boolean[] $jacocoInit = $jacocoInit();
        this.f4676ad = null;
        $jacocoInit[2] = true;
        this.recommendedApps = Collections.emptyList();
        this.loading = false;
        this.recommendedAppsError = null;
        this.adError = null;
        this.shouldLoadNativeAds = false;
        $jacocoInit[3] = true;
    }

    public ApplicationAd getAd() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationAd applicationAd = this.f4676ad;
        $jacocoInit[4] = true;
        return applicationAd;
    }

    public List<Application> getRecommendedApps() {
        boolean[] $jacocoInit = $jacocoInit();
        List<Application> list = this.recommendedApps;
        $jacocoInit[5] = true;
        return list;
    }

    public boolean isLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.loading;
        $jacocoInit[6] = true;
        return z;
    }

    public Error getRecommendedAppsError() {
        boolean[] $jacocoInit = $jacocoInit();
        Error error = this.recommendedAppsError;
        $jacocoInit[7] = true;
        return error;
    }

    public boolean hasSimilarApps() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (hasRecommendedAppsError()) {
            $jacocoInit[8] = true;
        } else if (this.recommendedApps.isEmpty()) {
            $jacocoInit[9] = true;
        } else {
            $jacocoInit[10] = true;
            z = true;
            $jacocoInit[12] = true;
            return z;
        }
        z = false;
        $jacocoInit[11] = true;
        $jacocoInit[12] = true;
        return z;
    }

    public boolean hasError() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.recommendedAppsError != null) {
            $jacocoInit[13] = true;
        } else if (this.adError != null) {
            $jacocoInit[14] = true;
        } else if (this.f4676ad == null) {
            $jacocoInit[15] = true;
        } else {
            z = false;
            $jacocoInit[17] = true;
            $jacocoInit[18] = true;
            return z;
        }
        $jacocoInit[16] = true;
        z = true;
        $jacocoInit[18] = true;
        return z;
    }

    public ApplicationAdError getAdError() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationAdError applicationAdError = this.adError;
        $jacocoInit[19] = true;
        return applicationAdError;
    }

    public boolean hasAd() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.f4676ad != null) {
            $jacocoInit[20] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[21] = true;
        }
        $jacocoInit[22] = true;
        return z;
    }

    public boolean hasRecommendedAppsError() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.recommendedAppsError != null) {
            $jacocoInit[23] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[24] = true;
        }
        $jacocoInit[25] = true;
        return z;
    }

    public boolean hasAdError() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.adError != null) {
            $jacocoInit[26] = true;
        } else if (this.f4676ad == null) {
            $jacocoInit[27] = true;
        } else {
            z = false;
            $jacocoInit[29] = true;
            $jacocoInit[30] = true;
            return z;
        }
        $jacocoInit[28] = true;
        z = true;
        $jacocoInit[30] = true;
        return z;
    }

    public void setHasRecordedAdImpression(boolean recorded) {
        boolean[] $jacocoInit = $jacocoInit();
        this.hasRecordedAdImpression = recorded;
        $jacocoInit[31] = true;
    }

    public boolean hasRecordedAdImpression() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.hasRecordedAdImpression;
        $jacocoInit[32] = true;
        return z;
    }

    public boolean shouldLoadNativeAds() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.shouldLoadNativeAds;
        $jacocoInit[33] = true;
        return z;
    }

    public void setShouldLoadNativeAds(boolean shouldLoadNativeAds2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.shouldLoadNativeAds = shouldLoadNativeAds2;
        $jacocoInit[34] = true;
    }
}
