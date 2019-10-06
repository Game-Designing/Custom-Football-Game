package p005cm.aptoide.p006pt.view.recycler.displayable;

import android.content.res.Resources;
import android.view.WindowManager;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;
import p005cm.aptoide.p006pt.view.recycler.widget.WidgetFactory;

/* renamed from: cm.aptoide.pt.view.recycler.displayable.DisplayableGroup */
public class DisplayableGroup extends Displayable {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final List<Displayable> children;
    private final Resources resources;
    private final WindowManager windowManager;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1586072804380571725L, "cm/aptoide/pt/view/recycler/displayable/DisplayableGroup", 20);
        $jacocoData = probes;
        return probes;
    }

    public DisplayableGroup(List<Displayable> children2, WindowManager windowManager2, Resources resources2) {
        boolean[] $jacocoInit = $jacocoInit();
        this(children2, true, windowManager2, resources2);
        $jacocoInit[0] = true;
    }

    DisplayableGroup(List<Displayable> children2, boolean computeLeftSpaces, WindowManager windowManager2, Resources resources2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.children = children2;
        this.windowManager = windowManager2;
        this.resources = resources2;
        $jacocoInit[1] = true;
        if (!computeLeftSpaces) {
            $jacocoInit[2] = true;
        } else {
            computeLeftSpaces();
            $jacocoInit[3] = true;
        }
        $jacocoInit[4] = true;
    }

    private void computeLeftSpaces() {
        boolean[] $jacocoInit = $jacocoInit();
        int columnSize = WidgetFactory.getColumnSize(this.resources, this.windowManager);
        int index = 0;
        $jacocoInit[5] = true;
        $jacocoInit[6] = true;
        for (Displayable displayable : this.children) {
            $jacocoInit[7] = true;
            if (displayable.getSpanSize(this.windowManager, this.resources) + index > columnSize) {
                $jacocoInit[8] = true;
                index = displayable.getSpanSize(this.windowManager, this.resources);
                $jacocoInit[9] = true;
            } else {
                index += displayable.getSpanSize(this.windowManager, this.resources);
                $jacocoInit[10] = true;
            }
            $jacocoInit[11] = true;
        }
        if (index >= columnSize) {
            $jacocoInit[12] = true;
        } else {
            $jacocoInit[13] = true;
            this.children.add(new EmptyDisplayable(columnSize - index));
            $jacocoInit[14] = true;
        }
        $jacocoInit[15] = true;
    }

    public int getDefaultPerLineCount() {
        boolean[] $jacocoInit = $jacocoInit();
        IllegalStateException illegalStateException = new IllegalStateException("getDefaultPerLineCount() on DisplayableGroup should not be called!");
        $jacocoInit[16] = true;
        throw illegalStateException;
    }

    /* access modifiers changed from: protected */
    public Configs getConfig() {
        boolean[] $jacocoInit = $jacocoInit();
        Configs configs = new Configs(this, 1, true);
        $jacocoInit[17] = true;
        return configs;
    }

    public int getViewLayout() {
        boolean[] $jacocoInit = $jacocoInit();
        IllegalStateException illegalStateException = new IllegalStateException("getViewLayout() on DisplayableGroup should not be called!");
        $jacocoInit[18] = true;
        throw illegalStateException;
    }

    public List<Displayable> getChildren() {
        boolean[] $jacocoInit = $jacocoInit();
        List<Displayable> list = this.children;
        $jacocoInit[19] = true;
        return list;
    }
}
