package p005cm.aptoide.p006pt.promotions;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.appview.PreferencesPersister;
import p005cm.aptoide.p006pt.preferences.managed.ManagedKeys;

/* renamed from: cm.aptoide.pt.promotions.PromotionsPreferencesManager */
public class PromotionsPreferencesManager {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private PreferencesPersister preferencesPersister;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3053407594800442093L, "cm/aptoide/pt/promotions/PromotionsPreferencesManager", 3);
        $jacocoData = probes;
        return probes;
    }

    public PromotionsPreferencesManager(PreferencesPersister preferencesPersister2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.preferencesPersister = preferencesPersister2;
        $jacocoInit[0] = true;
    }

    public boolean shouldShowPromotionsDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.preferencesPersister.get(ManagedKeys.SHOW_PROMOTIONS_DIALOG, true);
        $jacocoInit[1] = true;
        return z;
    }

    public void setPromotionsDialogShown() {
        boolean[] $jacocoInit = $jacocoInit();
        this.preferencesPersister.save(ManagedKeys.SHOW_PROMOTIONS_DIALOG, false);
        $jacocoInit[2] = true;
    }
}
