package p005cm.aptoide.p006pt.abtesting.experiments;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.abtesting.ABTestManager;
import p005cm.aptoide.p006pt.abtesting.Experiment;
import p005cm.aptoide.p006pt.ads.MoPubAnalytics;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.abtesting.experiments.MoPubInterstitialAdExperiment */
public class MoPubInterstitialAdExperiment {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String EXPERIMENT_ID = "ASV-1377-MoPub-Ads";
    private final ABTestManager abTestManager;
    private final MoPubAnalytics moPubAnalytics;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8692189015391404897L, "cm/aptoide/pt/abtesting/experiments/MoPubInterstitialAdExperiment", 25);
        $jacocoData = probes;
        return probes;
    }

    public MoPubInterstitialAdExperiment(ABTestManager abTestManager2, MoPubAnalytics moPubAnalytics2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.abTestManager = abTestManager2;
        this.moPubAnalytics = moPubAnalytics2;
        $jacocoInit[0] = true;
    }

    public Single<Boolean> shouldLoadInterstitial() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S experiment = this.abTestManager.getExperiment("ASV-1377-MoPub-Ads");
        $jacocoInit[1] = true;
        Single n = experiment.mo3678n();
        C1386b bVar = new C1386b(this);
        $jacocoInit[2] = true;
        Single<Boolean> a = n.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) bVar);
        $jacocoInit[3] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo9537a(Experiment experiment) {
        boolean[] $jacocoInit = $jacocoInit();
        String experimentAssignment = BuildConfig.APTOIDE_THEME;
        $jacocoInit[8] = true;
        if (experiment.isExperimentOver()) {
            $jacocoInit[9] = true;
        } else if (!experiment.isPartOfExperiment()) {
            $jacocoInit[10] = true;
        } else {
            $jacocoInit[11] = true;
            experimentAssignment = experiment.getAssignment();
            $jacocoInit[12] = true;
        }
        char c = 65535;
        int hashCode = experimentAssignment.hashCode();
        if (hashCode != 104081947) {
            if (hashCode != 1215857949) {
                if (hashCode != 1544803905) {
                    $jacocoInit[13] = true;
                } else if (!experimentAssignment.equals(BuildConfig.APTOIDE_THEME)) {
                    $jacocoInit[14] = true;
                } else {
                    $jacocoInit[15] = true;
                    c = 0;
                }
            } else if (!experimentAssignment.equals("control_group")) {
                $jacocoInit[16] = true;
            } else {
                $jacocoInit[17] = true;
                c = 1;
            }
        } else if (!experimentAssignment.equals(com.integralads.avid.library.mopub.BuildConfig.SDK_NAME)) {
            $jacocoInit[18] = true;
        } else {
            $jacocoInit[19] = true;
            c = 2;
        }
        if (c == 0 || c == 1) {
            this.moPubAnalytics.setMoPubAbTestGroup(true);
            $jacocoInit[20] = true;
            Single a = Single.m734a(Boolean.valueOf(false));
            $jacocoInit[21] = true;
            return a;
        } else if (c != 2) {
            Single a2 = Single.m734a(Boolean.valueOf(false));
            $jacocoInit[24] = true;
            return a2;
        } else {
            this.moPubAnalytics.setMoPubAbTestGroup(false);
            $jacocoInit[22] = true;
            Single a3 = Single.m734a(Boolean.valueOf(true));
            $jacocoInit[23] = true;
            return a3;
        }
    }

    public Single<Boolean> recordAdImpression() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S recordImpression = this.abTestManager.recordImpression("ASV-1377-MoPub-Ads");
        $jacocoInit[4] = true;
        Single<Boolean> n = recordImpression.mo3678n();
        $jacocoInit[5] = true;
        return n;
    }

    public Single<Boolean> recordAdClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S recordAction = this.abTestManager.recordAction("ASV-1377-MoPub-Ads");
        $jacocoInit[6] = true;
        Single<Boolean> n = recordAction.mo3678n();
        $jacocoInit[7] = true;
        return n;
    }
}
