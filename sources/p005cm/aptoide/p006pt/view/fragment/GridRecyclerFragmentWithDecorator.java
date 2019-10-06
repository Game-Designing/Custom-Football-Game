package p005cm.aptoide.p006pt.view.fragment;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.p000v4.app.C0014p;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.RecyclerView.C0980h;
import android.support.p001v7.widget.RecyclerView.C0997t;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.view.recycler.BaseAdapter;

/* renamed from: cm.aptoide.pt.view.fragment.GridRecyclerFragmentWithDecorator */
public abstract class GridRecyclerFragmentWithDecorator<T extends BaseAdapter> extends AptoideBaseFragment<T> {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7863244089848513531L, "cm/aptoide/pt/view/fragment/GridRecyclerFragmentWithDecorator", 7);
        $jacocoData = probes;
        return probes;
    }

    public GridRecyclerFragmentWithDecorator() {
        $jacocoInit()[0] = true;
    }

    public void setupViews() {
        boolean[] $jacocoInit = $jacocoInit();
        super.setupViews();
        $jacocoInit[1] = true;
        C0980h itemDecoration = getItemDecoration();
        if (itemDecoration == null) {
            $jacocoInit[2] = true;
        } else {
            $jacocoInit[3] = true;
            getRecyclerView().mo7527a(itemDecoration);
            $jacocoInit[4] = true;
        }
        $jacocoInit[5] = true;
    }

    /* access modifiers changed from: protected */
    public C0980h getItemDecoration() {
        boolean[] $jacocoInit = $jacocoInit();
        C53441 r1 = new C0980h(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ GridRecyclerFragmentWithDecorator this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(9049759553724531897L, "cm/aptoide/pt/view/fragment/GridRecyclerFragmentWithDecorator$1", 12);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, C0997t state) {
                boolean[] $jacocoInit = $jacocoInit();
                int offset = 0;
                int top = 0;
                int bottom = 0;
                int left = 0;
                int right = 0;
                $jacocoInit[1] = true;
                C0014p activity = this.this$0.getActivity();
                if (activity == null) {
                    $jacocoInit[2] = true;
                } else {
                    $jacocoInit[3] = true;
                    Resources resources = activity.getResources();
                    $jacocoInit[4] = true;
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    $jacocoInit[5] = true;
                    offset = (int) TypedValue.applyDimension(1, 5.0f, displayMetrics);
                    top = offset;
                    bottom = offset;
                    left = offset;
                    right = offset;
                    $jacocoInit[6] = true;
                }
                if (view.getId() != C1375R.C1376id.brick_app_item) {
                    $jacocoInit[7] = true;
                } else {
                    top = offset / 2;
                    bottom = offset / 2;
                    left = offset / 2;
                    right = offset / 2;
                    $jacocoInit[8] = true;
                }
                if (view.getId() != C1375R.C1376id.message_white_bg) {
                    $jacocoInit[9] = true;
                } else {
                    top = 0;
                    left = offset;
                    right = offset;
                    bottom = offset;
                    $jacocoInit[10] = true;
                }
                outRect.set(left, top, right, bottom);
                $jacocoInit[11] = true;
            }
        };
        $jacocoInit[6] = true;
        return r1;
    }
}
