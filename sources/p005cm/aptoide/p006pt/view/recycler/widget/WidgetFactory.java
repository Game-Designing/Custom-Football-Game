package p005cm.aptoide.p006pt.view.recycler.widget;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.utils.AptoideUtils.MathU;
import p005cm.aptoide.p006pt.utils.AptoideUtils.ScreenU;
import p005cm.aptoide.p006pt.view.recycler.DisplayableWidgetMapping;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;

/* renamed from: cm.aptoide.pt.view.recycler.widget.WidgetFactory */
public class WidgetFactory {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static final String TAG = WidgetFactory.class.getName();
    private static int columnSize = -1;
    private static int orientation = -1;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-9204207305369419370L, "cm/aptoide/pt/view/recycler/widget/WidgetFactory", 22);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[21] = true;
    }

    private WidgetFactory() {
        $jacocoInit()[0] = true;
    }

    public static Widget newBaseViewHolder(ViewGroup parent, int viewType) {
        boolean[] $jacocoInit = $jacocoInit();
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        $jacocoInit[1] = true;
        View view = from.inflate(viewType, parent, false);
        $jacocoInit[2] = true;
        DisplayableWidgetMapping displayableWidgetMapping = AptoideApplication.getDisplayableWidgetMapping();
        $jacocoInit[3] = true;
        Widget w = displayableWidgetMapping.newWidget(view, viewType);
        $jacocoInit[4] = true;
        return w;
    }

    public static int getColumnSize(Resources resources, WindowManager windowManager) {
        boolean[] $jacocoInit = $jacocoInit();
        computeColumnSize(resources, windowManager);
        int i = columnSize;
        $jacocoInit[5] = true;
        return i;
    }

    private static void computeColumnSize(Resources resources, WindowManager windowManager) {
        boolean[] $jacocoInit = $jacocoInit();
        if (orientation != ScreenU.getCurrentOrientation(resources)) {
            $jacocoInit[6] = true;
        } else if (columnSize == -1) {
            $jacocoInit[7] = true;
        } else if (orientation != -1) {
            $jacocoInit[8] = true;
            $jacocoInit[13] = true;
        } else {
            $jacocoInit[9] = true;
        }
        $jacocoInit[10] = true;
        columnSize = MathU.leastCommonMultiple(getDisplayablesSizes(windowManager, resources));
        $jacocoInit[11] = true;
        orientation = ScreenU.getCurrentOrientation(resources);
        $jacocoInit[12] = true;
        $jacocoInit[13] = true;
    }

    private static int[] getDisplayablesSizes(WindowManager windowManager, Resources resources) {
        boolean[] $jacocoInit = $jacocoInit();
        DisplayableWidgetMapping displayableWidgetMapping = AptoideApplication.getDisplayableWidgetMapping();
        $jacocoInit[14] = true;
        List<Displayable> displayableList = displayableWidgetMapping.getCachedDisplayables();
        $jacocoInit[15] = true;
        int[] arr = new int[displayableList.size()];
        int i = 0;
        $jacocoInit[16] = true;
        $jacocoInit[17] = true;
        for (Displayable displayable : displayableList) {
            $jacocoInit[18] = true;
            int i2 = i + 1;
            arr[i] = displayable.getPerLineCount(windowManager, resources);
            $jacocoInit[19] = true;
            i = i2;
        }
        $jacocoInit[20] = true;
        return arr;
    }
}
