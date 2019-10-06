package p005cm.aptoide.p006pt.view.recycler.displayable;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.WindowManager;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.utils.AptoideUtils.ScreenU;
import p005cm.aptoide.p006pt.view.LifecycleSchim;
import p005cm.aptoide.p006pt.view.recycler.widget.WidgetFactory;
import p026rx.p029i.C0136c;

/* renamed from: cm.aptoide.pt.view.recycler.displayable.Displayable */
public abstract class Displayable implements LifecycleSchim {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private int defaultPerLineCount;
    private boolean fixedPerLineCount;
    private boolean isVisible = false;
    private C0136c subscriptions;

    /* renamed from: cm.aptoide.pt.view.recycler.displayable.Displayable$Configs */
    public class Configs {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private final int defaultPerLineCount;
        private final boolean fixedPerLineCount;
        final /* synthetic */ Displayable this$0;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-2680215807876111997L, "cm/aptoide/pt/view/recycler/displayable/Displayable$Configs", 3);
            $jacocoData = probes;
            return probes;
        }

        public Configs(Displayable this$02, int defaultPerLineCount2, boolean fixedPerLineCount2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.this$0 = this$02;
            this.defaultPerLineCount = defaultPerLineCount2;
            this.fixedPerLineCount = fixedPerLineCount2;
            $jacocoInit[0] = true;
        }

        public int getDefaultPerLineCount() {
            boolean[] $jacocoInit = $jacocoInit();
            int i = this.defaultPerLineCount;
            $jacocoInit[1] = true;
            return i;
        }

        public boolean isFixedPerLineCount() {
            boolean[] $jacocoInit = $jacocoInit();
            boolean z = this.fixedPerLineCount;
            $jacocoInit[2] = true;
            return z;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2406997411127289783L, "cm/aptoide/pt/view/recycler/displayable/Displayable", 25);
        $jacocoData = probes;
        return probes;
    }

    /* access modifiers changed from: protected */
    public abstract Configs getConfig();

    public abstract int getViewLayout();

    public Displayable() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        this.subscriptions = new C0136c();
        $jacocoInit[1] = true;
        Configs config = getConfig();
        $jacocoInit[2] = true;
        this.fixedPerLineCount = config.isFixedPerLineCount();
        $jacocoInit[3] = true;
        this.defaultPerLineCount = config.getDefaultPerLineCount();
        $jacocoInit[4] = true;
    }

    public C0136c getSubscriptions() {
        boolean[] $jacocoInit = $jacocoInit();
        C0136c cVar = this.subscriptions;
        $jacocoInit[5] = true;
        return cVar;
    }

    public boolean isFixedPerLineCount() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.fixedPerLineCount;
        $jacocoInit[6] = true;
        return z;
    }

    public int getDefaultPerLineCount() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.defaultPerLineCount;
        $jacocoInit[7] = true;
        return i;
    }

    public boolean isVisible() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isVisible;
        $jacocoInit[8] = true;
        return z;
    }

    public void setVisible(boolean visible) {
        boolean[] $jacocoInit = $jacocoInit();
        this.isVisible = visible;
        $jacocoInit[9] = true;
    }

    public int getSpanSize(WindowManager windowManager, Resources resources) {
        int columnSize = WidgetFactory.getColumnSize(resources, windowManager) / getPerLineCount(windowManager, resources);
        $jacocoInit()[10] = true;
        return columnSize;
    }

    public int getPerLineCount(WindowManager windowManager, Resources resources) {
        int tmp;
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        if (isFixedPerLineCount()) {
            $jacocoInit[11] = true;
            tmp = getDefaultPerLineCount();
            $jacocoInit[12] = true;
        } else {
            float screenWidthInDip = ScreenU.getScreenWidthInDip(windowManager, resources) / 360.0f;
            $jacocoInit[13] = true;
            tmp = (int) (screenWidthInDip * ((float) getDefaultPerLineCount()));
            $jacocoInit[14] = true;
        }
        if (tmp != 0) {
            $jacocoInit[15] = true;
            i = tmp;
        } else {
            $jacocoInit[16] = true;
            i = 1;
        }
        $jacocoInit[17] = true;
        return i;
    }

    public void onResume() {
        boolean[] $jacocoInit = $jacocoInit();
        this.isVisible = true;
        $jacocoInit[18] = true;
    }

    public void onPause() {
        boolean[] $jacocoInit = $jacocoInit();
        this.isVisible = false;
        $jacocoInit[19] = true;
    }

    public void onViewCreated() {
        $jacocoInit()[20] = true;
    }

    public void onDestroyView() {
        $jacocoInit()[21] = true;
    }

    public void onSaveInstanceState(Bundle outState) {
        $jacocoInit()[22] = true;
    }

    public void onViewStateRestored(Bundle savedInstanceState) {
        $jacocoInit()[23] = true;
    }

    public Displayable setFullRow() {
        boolean[] $jacocoInit = $jacocoInit();
        this.defaultPerLineCount = 1;
        this.fixedPerLineCount = true;
        $jacocoInit[24] = true;
        return this;
    }
}
