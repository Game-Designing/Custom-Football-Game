package android.support.p001v7.widget;

import android.content.Context;
import android.support.p001v7.widget.RecyclerView.C0994s.C0995a;
import android.support.p001v7.widget.RecyclerView.C0997t;
import android.util.DisplayMetrics;
import android.view.View;

/* renamed from: android.support.v7.widget.gb */
/* compiled from: SnapHelper */
class C1061gb extends C1108ra {

    /* renamed from: a */
    final /* synthetic */ C1064hb f3525a;

    C1061gb(C1064hb this$0, Context context) {
        this.f3525a = this$0;
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onTargetFound(View targetView, C0997t state, C0995a action) {
        C1064hb hbVar = this.f3525a;
        RecyclerView recyclerView = hbVar.mRecyclerView;
        if (recyclerView != null) {
            int[] snapDistances = hbVar.calculateDistanceToFinalSnap(recyclerView.getLayoutManager(), targetView);
            int dx = snapDistances[0];
            int dy = snapDistances[1];
            int time = calculateTimeForDeceleration(Math.max(Math.abs(dx), Math.abs(dy)));
            if (time > 0) {
                action.mo7942a(dx, dy, time, this.mDecelerateInterpolator);
            }
        }
    }

    /* access modifiers changed from: protected */
    public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return 100.0f / ((float) displayMetrics.densityDpi);
    }
}
