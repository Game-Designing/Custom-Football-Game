package android.support.p001v7.widget;

import android.support.p001v7.widget.RecyclerView.C0981i;
import android.support.p001v7.widget.RecyclerView.C0986l;
import android.support.p001v7.widget.RecyclerView.C0988n;
import android.support.p001v7.widget.RecyclerView.C0994s;
import android.support.p001v7.widget.RecyclerView.C0994s.C0996b;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

/* renamed from: android.support.v7.widget.hb */
/* compiled from: SnapHelper */
public abstract class C1064hb extends C0986l {
    static final float MILLISECONDS_PER_INCH = 100.0f;
    private Scroller mGravityScroller;
    RecyclerView mRecyclerView;
    private final C0988n mScrollListener = new C1056fb(this);

    public abstract int[] calculateDistanceToFinalSnap(C0981i iVar, View view);

    public abstract View findSnapView(C0981i iVar);

    public abstract int findTargetSnapPosition(C0981i iVar, int i, int i2);

    public boolean onFling(int velocityX, int velocityY) {
        C0981i layoutManager = this.mRecyclerView.getLayoutManager();
        boolean z = false;
        if (layoutManager == null || this.mRecyclerView.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.mRecyclerView.getMinFlingVelocity();
        if ((Math.abs(velocityY) > minFlingVelocity || Math.abs(velocityX) > minFlingVelocity) && snapFromFling(layoutManager, velocityX, velocityY)) {
            z = true;
        }
        return z;
    }

    public void attachToRecyclerView(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                destroyCallbacks();
            }
            this.mRecyclerView = recyclerView;
            if (this.mRecyclerView != null) {
                setupCallbacks();
                this.mGravityScroller = new Scroller(this.mRecyclerView.getContext(), new DecelerateInterpolator());
                snapToTargetExistingView();
            }
        }
    }

    private void setupCallbacks() throws IllegalStateException {
        if (this.mRecyclerView.getOnFlingListener() == null) {
            this.mRecyclerView.mo7530a(this.mScrollListener);
            this.mRecyclerView.setOnFlingListener(this);
            return;
        }
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    private void destroyCallbacks() {
        this.mRecyclerView.mo7549b(this.mScrollListener);
        this.mRecyclerView.setOnFlingListener(null);
    }

    public int[] calculateScrollDistance(int velocityX, int velocityY) {
        this.mGravityScroller.fling(0, 0, velocityX, velocityY, LinearLayoutManager.INVALID_OFFSET, MoPubClientPositioning.NO_REPEAT, LinearLayoutManager.INVALID_OFFSET, MoPubClientPositioning.NO_REPEAT);
        return new int[]{this.mGravityScroller.getFinalX(), this.mGravityScroller.getFinalY()};
    }

    private boolean snapFromFling(C0981i layoutManager, int velocityX, int velocityY) {
        if (!(layoutManager instanceof C0996b)) {
            return false;
        }
        C0994s smoothScroller = createScroller(layoutManager);
        if (smoothScroller == null) {
            return false;
        }
        int targetPosition = findTargetSnapPosition(layoutManager, velocityX, velocityY);
        if (targetPosition == -1) {
            return false;
        }
        smoothScroller.setTargetPosition(targetPosition);
        layoutManager.startSmoothScroll(smoothScroller);
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void snapToTargetExistingView() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            C0981i layoutManager = recyclerView.getLayoutManager();
            if (layoutManager != null) {
                View snapView = findSnapView(layoutManager);
                if (snapView != null) {
                    int[] snapDistance = calculateDistanceToFinalSnap(layoutManager, snapView);
                    if (!(snapDistance[0] == 0 && snapDistance[1] == 0)) {
                        this.mRecyclerView.mo7619i(snapDistance[0], snapDistance[1]);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public C0994s createScroller(C0981i layoutManager) {
        return createSnapScroller(layoutManager);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public C1108ra createSnapScroller(C0981i layoutManager) {
        if (!(layoutManager instanceof C0996b)) {
            return null;
        }
        return new C1061gb(this, this.mRecyclerView.getContext());
    }
}
