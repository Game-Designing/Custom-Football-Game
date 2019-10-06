package p005cm.aptoide.p006pt.view.recycler;

import android.content.Context;
import android.content.res.Resources;
import android.support.p001v7.widget.GridLayoutManager;
import android.support.p001v7.widget.GridLayoutManager.C0938c;
import android.view.WindowManager;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.widget.WidgetFactory;

/* renamed from: cm.aptoide.pt.view.recycler.BaseGridLayoutManager */
public class BaseGridLayoutManager extends GridLayoutManager {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Resources resources;
    private final WindowManager windowManager;

    /* renamed from: cm.aptoide.pt.view.recycler.BaseGridLayoutManager$SpanSizeLookup */
    private class SpanSizeLookup extends C0938c {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private final BaseAdapter baseAdapter;
        final /* synthetic */ BaseGridLayoutManager this$0;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(2270403502644588825L, "cm/aptoide/pt/view/recycler/BaseGridLayoutManager$SpanSizeLookup", 9);
            $jacocoData = probes;
            return probes;
        }

        public SpanSizeLookup(BaseGridLayoutManager baseGridLayoutManager, BaseAdapter baseAdapter2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.this$0 = baseGridLayoutManager;
            this.baseAdapter = baseAdapter2;
            $jacocoInit[0] = true;
        }

        public int getSpanSize(int position) {
            boolean[] $jacocoInit = $jacocoInit();
            Displayable displayable = this.baseAdapter.getDisplayable(position);
            if (displayable == null) {
                $jacocoInit[1] = true;
                return 1;
            } else if (displayable.getSpanSize(BaseGridLayoutManager.access$000(this.this$0), BaseGridLayoutManager.access$100(this.this$0)) <= this.this$0.getSpanCount()) {
                $jacocoInit[2] = true;
                int spanSize = displayable.getSpanSize(BaseGridLayoutManager.access$000(this.this$0), BaseGridLayoutManager.access$100(this.this$0));
                $jacocoInit[3] = true;
                return spanSize;
            } else {
                CrashReport instance = CrashReport.getInstance();
                StringBuilder sb = new StringBuilder();
                sb.append("Displayable ");
                $jacocoInit[4] = true;
                Class cls = displayable.getClass();
                $jacocoInit[5] = true;
                sb.append(cls.getSimpleName());
                sb.append(" at position ");
                sb.append(position);
                sb.append(" spanSize > getSpanCount()! ");
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(sb.toString());
                $jacocoInit[6] = true;
                instance.log(illegalArgumentException);
                $jacocoInit[7] = true;
                int spanCount = this.this$0.getSpanCount();
                $jacocoInit[8] = true;
                return spanCount;
            }
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1458199241689575955L, "cm/aptoide/pt/view/recycler/BaseGridLayoutManager", 4);
        $jacocoData = probes;
        return probes;
    }

    static /* synthetic */ WindowManager access$000(BaseGridLayoutManager x0) {
        boolean[] $jacocoInit = $jacocoInit();
        WindowManager windowManager2 = x0.windowManager;
        $jacocoInit[2] = true;
        return windowManager2;
    }

    static /* synthetic */ Resources access$100(BaseGridLayoutManager x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Resources resources2 = x0.resources;
        $jacocoInit[3] = true;
        return resources2;
    }

    public BaseGridLayoutManager(Context context, BaseAdapter baseAdapter, Resources resources2, WindowManager windowManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(context, WidgetFactory.getColumnSize(resources2, windowManager2));
        this.resources = resources2;
        this.windowManager = windowManager2;
        $jacocoInit[0] = true;
        setSpanSizeLookup(new SpanSizeLookup(this, baseAdapter));
        $jacocoInit[1] = true;
    }
}
