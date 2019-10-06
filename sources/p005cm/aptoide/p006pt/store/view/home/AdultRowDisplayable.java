package p005cm.aptoide.p006pt.store.view.home;

import android.os.Bundle;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.view.ReloadInterface;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;

/* renamed from: cm.aptoide.pt.store.view.home.AdultRowDisplayable */
public class AdultRowDisplayable extends Displayable implements ReloadInterface {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ReloadInterface reloader;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1575714758226360188L, "cm/aptoide/pt/store/view/home/AdultRowDisplayable", 24);
        $jacocoData = probes;
        return probes;
    }

    public AdultRowDisplayable() {
        boolean[] $jacocoInit = $jacocoInit();
        this.reloader = null;
        $jacocoInit[0] = true;
    }

    public AdultRowDisplayable(ReloadInterface reloader2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.reloader = reloader2;
        $jacocoInit[1] = true;
    }

    /* access modifiers changed from: protected */
    public Configs getConfig() {
        boolean[] $jacocoInit = $jacocoInit();
        Configs configs = new Configs(this, 1, true);
        $jacocoInit[2] = true;
        return configs;
    }

    public int getViewLayout() {
        $jacocoInit()[3] = true;
        return C1375R.layout.row_adult_switch;
    }

    public void reload() {
        boolean[] $jacocoInit = $jacocoInit();
        ReloadInterface reloadInterface = this.reloader;
        if (reloadInterface == null) {
            $jacocoInit[4] = true;
        } else {
            $jacocoInit[5] = true;
            reloadInterface.reload();
            $jacocoInit[6] = true;
        }
        $jacocoInit[7] = true;
    }

    public void load(boolean create, boolean refresh, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        ReloadInterface reloadInterface = this.reloader;
        if (reloadInterface == null) {
            $jacocoInit[8] = true;
        } else {
            $jacocoInit[9] = true;
            reloadInterface.load(create, refresh, savedInstanceState);
            $jacocoInit[10] = true;
        }
        $jacocoInit[11] = true;
    }

    public int hashCode() {
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        ReloadInterface reloadInterface = this.reloader;
        if (reloadInterface != null) {
            i = reloadInterface.hashCode();
            $jacocoInit[12] = true;
        } else {
            i = 0;
            $jacocoInit[13] = true;
        }
        $jacocoInit[14] = true;
        return i;
    }

    public boolean equals(Object o) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this == o) {
            $jacocoInit[15] = true;
            return true;
        }
        boolean z = false;
        if (o == null) {
            $jacocoInit[16] = true;
        } else if (getClass() != o.getClass()) {
            $jacocoInit[17] = true;
        } else {
            AdultRowDisplayable that = (AdultRowDisplayable) o;
            $jacocoInit[19] = true;
            ReloadInterface reloadInterface = this.reloader;
            if (reloadInterface != null) {
                z = reloadInterface.equals(that.reloader);
                $jacocoInit[20] = true;
            } else if (that.reloader == null) {
                $jacocoInit[21] = true;
                z = true;
            } else {
                $jacocoInit[22] = true;
            }
            $jacocoInit[23] = true;
            return z;
        }
        $jacocoInit[18] = true;
        return false;
    }
}
