package p005cm.aptoide.p006pt.abtesting;

import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.abtesting.AbTestRepository */
public interface AbTestRepository {
    C0120S<Void> cacheExperiment(ExperimentModel experimentModel, String str);

    C0120S<Experiment> getExperiment(String str);

    C0120S<String> getExperimentId(String str);

    C0120S<Boolean> recordAction(String str);

    C0120S<Boolean> recordAction(String str, int i);

    C0120S<Boolean> recordImpression(String str);
}
