package p005cm.aptoide.p006pt.abtesting.experiments;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.abtesting.ABTestManager;
import p005cm.aptoide.p006pt.abtesting.Experiment;
import p005cm.aptoide.p006pt.ads.MoPubAnalytics;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.abtesting.experiments.MoPubNativeAdExperiment */
public class MoPubNativeAdExperiment {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String EXPERIMENT_ID = "ASV-1377-MoPub-Ads";
    private final ABTestManager abTestManager;
    private final MoPubAnalytics moPubAnalytics;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3357166729970252757L, "cm/aptoide/pt/abtesting/experiments/MoPubNativeAdExperiment", 21);
        $jacocoData = probes;
        return probes;
    }

    public MoPubNativeAdExperiment(ABTestManager abTestManager2, MoPubAnalytics moPubAnalytics2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.abTestManager = abTestManager2;
        this.moPubAnalytics = moPubAnalytics2;
        $jacocoInit[0] = true;
    }

    public Single<Boolean> shouldLoadNative() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S experiment = this.abTestManager.getExperiment("ASV-1377-MoPub-Ads");
        $jacocoInit[1] = true;
        Single n = experiment.mo3678n();
        C1387c cVar = new C1387c(this);
        $jacocoInit[2] = true;
        Single<Boolean> a = n.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) cVar);
        $jacocoInit[3] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo9541a(Experiment experiment) {
        boolean[] $jacocoInit = $jacocoInit();
        String experimentAssignment = BuildConfig.APTOIDE_THEME;
        $jacocoInit[4] = true;
        if (experiment.isExperimentOver()) {
            $jacocoInit[5] = true;
        } else if (!experiment.isPartOfExperiment()) {
            $jacocoInit[6] = true;
        } else {
            $jacocoInit[7] = true;
            experimentAssignment = experiment.getAssignment();
            $jacocoInit[8] = true;
        }
        char c = 65535;
        int hashCode = experimentAssignment.hashCode();
        if (hashCode != 104081947) {
            if (hashCode != 1215857949) {
                if (hashCode != 1544803905) {
                    $jacocoInit[9] = true;
                } else if (!experimentAssignment.equals(BuildConfig.APTOIDE_THEME)) {
                    $jacocoInit[10] = true;
                } else {
                    $jacocoInit[11] = true;
                    c = 0;
                }
            } else if (!experimentAssignment.equals("control_group")) {
                $jacocoInit[12] = true;
            } else {
                $jacocoInit[13] = true;
                c = 1;
            }
        } else if (!experimentAssignment.equals(com.integralads.avid.library.mopub.BuildConfig.SDK_NAME)) {
            $jacocoInit[14] = true;
        } else {
            $jacocoInit[15] = true;
            c = 2;
        }
        if (c == 0 || c == 1) {
            this.moPubAnalytics.setMoPubAbTestGroup(true);
            $jacocoInit[16] = true;
            Single a = Single.m734a(Boolean.valueOf(false));
            $jacocoInit[17] = true;
            return a;
        } else if (c != 2) {
            Single a2 = Single.m734a(Boolean.valueOf(false));
            $jacocoInit[20] = true;
            return a2;
        } else {
            this.moPubAnalytics.setMoPubAbTestGroup(false);
            $jacocoInit[18] = true;
            Single a3 = Single.m734a(Boolean.valueOf(true));
            $jacocoInit[19] = true;
            return a3;
        }
    }
}
