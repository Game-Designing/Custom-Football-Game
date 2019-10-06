package p005cm.aptoide.p006pt.app.view;

import android.util.Pair;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta;
import p005cm.aptoide.p006pt.store.StoreTheme;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;

/* renamed from: cm.aptoide.pt.app.view.OfficialAppDisplayable */
public class OfficialAppDisplayable extends Displayable {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Pair<String, GetAppMeta> messageGetApp;
    private final StoreTheme storeTheme;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3697571149045083714L, "cm/aptoide/pt/app/view/OfficialAppDisplayable", 6);
        $jacocoData = probes;
        return probes;
    }

    public OfficialAppDisplayable() {
        boolean[] $jacocoInit = $jacocoInit();
        this.messageGetApp = null;
        this.storeTheme = StoreTheme.DEFAULT;
        $jacocoInit[0] = true;
    }

    public OfficialAppDisplayable(Pair<String, GetAppMeta> messageGetApp2, StoreTheme storeTheme2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.messageGetApp = messageGetApp2;
        this.storeTheme = storeTheme2;
        $jacocoInit[1] = true;
    }

    public Pair<String, GetAppMeta> getMessageGetApp() {
        boolean[] $jacocoInit = $jacocoInit();
        Pair<String, GetAppMeta> pair = this.messageGetApp;
        $jacocoInit[2] = true;
        return pair;
    }

    /* access modifiers changed from: protected */
    public Configs getConfig() {
        boolean[] $jacocoInit = $jacocoInit();
        Configs configs = new Configs(this, 1, true);
        $jacocoInit[3] = true;
        return configs;
    }

    public int getViewLayout() {
        $jacocoInit()[4] = true;
        return C1375R.layout.official_app_displayable_layout;
    }

    public StoreTheme getStoreTheme() {
        boolean[] $jacocoInit = $jacocoInit();
        StoreTheme storeTheme2 = this.storeTheme;
        $jacocoInit[5] = true;
        return storeTheme2;
    }
}
