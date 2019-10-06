package p005cm.aptoide.p006pt.abtesting;

import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.abtesting.ExperimentPersistence */
public interface ExperimentPersistence {
    C0120S<ExperimentModel> get(String str);

    void save(String str, Experiment experiment);
}
