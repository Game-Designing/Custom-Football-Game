package p005cm.aptoide.p006pt.store.view.subscribed;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.database.realm.Store;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;
import p005cm.aptoide.p006pt.view.recycler.displayable.DisplayablePojo;

/* renamed from: cm.aptoide.pt.store.view.subscribed.SubscribedStoreDisplayable */
public class SubscribedStoreDisplayable extends DisplayablePojo<Store> {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7991031489768571695L, "cm/aptoide/pt/store/view/subscribed/SubscribedStoreDisplayable", 14);
        $jacocoData = probes;
        return probes;
    }

    public SubscribedStoreDisplayable() {
        $jacocoInit()[0] = true;
    }

    public SubscribedStoreDisplayable(Store pojo) {
        boolean[] $jacocoInit = $jacocoInit();
        super(pojo);
        $jacocoInit[1] = true;
    }

    /* access modifiers changed from: protected */
    public Configs getConfig() {
        boolean[] $jacocoInit = $jacocoInit();
        Configs configs = new Configs(this, 3, false);
        $jacocoInit[2] = true;
        return configs;
    }

    public int getViewLayout() {
        $jacocoInit()[3] = true;
        return C1375R.layout.displayable_grid_store_subscribed;
    }

    public int hashCode() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[4] = true;
        int result = (1 * 59) + super.hashCode();
        $jacocoInit[5] = true;
        return result;
    }

    public boolean equals(Object o) {
        boolean[] $jacocoInit = $jacocoInit();
        if (o == this) {
            $jacocoInit[6] = true;
            return true;
        } else if (!(o instanceof SubscribedStoreDisplayable)) {
            $jacocoInit[7] = true;
            return false;
        } else {
            SubscribedStoreDisplayable other = (SubscribedStoreDisplayable) o;
            $jacocoInit[8] = true;
            if (!other.canEqual(this)) {
                $jacocoInit[9] = true;
                return false;
            } else if (!super.equals(o)) {
                $jacocoInit[10] = true;
                return false;
            } else {
                $jacocoInit[11] = true;
                return true;
            }
        }
    }

    public String toString() {
        $jacocoInit()[12] = true;
        return "SubscribedStoreDisplayable()";
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        boolean z = other instanceof SubscribedStoreDisplayable;
        $jacocoInit()[13] = true;
        return z;
    }
}
