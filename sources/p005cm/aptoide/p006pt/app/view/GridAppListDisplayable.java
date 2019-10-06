package p005cm.aptoide.p006pt.app.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;
import p005cm.aptoide.p006pt.view.recycler.displayable.DisplayablePojo;

/* renamed from: cm.aptoide.pt.app.view.GridAppListDisplayable */
public class GridAppListDisplayable extends DisplayablePojo<App> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private String tag;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4714264839875339525L, "cm/aptoide/pt/app/view/GridAppListDisplayable", 5);
        $jacocoData = probes;
        return probes;
    }

    public GridAppListDisplayable() {
        $jacocoInit()[0] = true;
    }

    public GridAppListDisplayable(App pojo, String tag2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(pojo);
        this.tag = tag2;
        $jacocoInit[1] = true;
    }

    /* access modifiers changed from: protected */
    public Configs getConfig() {
        boolean[] $jacocoInit = $jacocoInit();
        Configs configs = new Configs(this, 1, false);
        $jacocoInit[2] = true;
        return configs;
    }

    public int getViewLayout() {
        $jacocoInit()[3] = true;
        return C1375R.layout.displayable_list_app;
    }

    public String getTag() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.tag;
        $jacocoInit[4] = true;
        return str;
    }
}
