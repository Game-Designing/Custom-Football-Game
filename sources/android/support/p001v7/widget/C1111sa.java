package android.support.p001v7.widget;

import android.graphics.PointF;
import android.support.p001v7.widget.RecyclerView.C0981i;
import android.support.p001v7.widget.RecyclerView.C0994s.C0996b;
import android.view.View;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

/* renamed from: android.support.v7.widget.sa */
/* compiled from: LinearSnapHelper */
public class C1111sa extends C1064hb {
    private static final float INVALID_DISTANCE = 1.0f;
    private C0916Ba mHorizontalHelper;
    private C0916Ba mVerticalHelper;

    public int[] calculateDistanceToFinalSnap(C0981i iVar, View view) {
        throw null;
    }

    public int findTargetSnapPosition(C0981i layoutManager, int velocityX, int velocityY) {
        int hDeltaJump;
        int vDeltaJump;
        if (!(layoutManager instanceof C0996b)) {
            return -1;
        }
        int itemCount = layoutManager.getItemCount();
        if (itemCount == 0) {
            return -1;
        }
        View currentView = findSnapView(layoutManager);
        if (currentView == null) {
            return -1;
        }
        int currentPosition = layoutManager.getPosition(currentView);
        if (currentPosition == -1) {
            return -1;
        }
        PointF vectorForEnd = ((C0996b) layoutManager).computeScrollVectorForPosition(itemCount - 1);
        if (vectorForEnd == null) {
            return -1;
        }
        if (layoutManager.canScrollHorizontally()) {
            hDeltaJump = estimateNextPositionDiffForFling(layoutManager, getHorizontalHelper(layoutManager), velocityX, 0);
            if (vectorForEnd.x < 0.0f) {
                hDeltaJump = -hDeltaJump;
            }
        } else {
            hDeltaJump = 0;
        }
        if (layoutManager.canScrollVertically()) {
            int vDeltaJump2 = estimateNextPositionDiffForFling(layoutManager, getVerticalHelper(layoutManager), 0, velocityY);
            if (vectorForEnd.y < 0.0f) {
                vDeltaJump = -vDeltaJump2;
            } else {
                vDeltaJump = vDeltaJump2;
            }
        } else {
            vDeltaJump = 0;
        }
        int deltaJump = layoutManager.canScrollVertically() ? vDeltaJump : hDeltaJump;
        if (deltaJump == 0) {
            return -1;
        }
        int targetPos = currentPosition + deltaJump;
        if (targetPos < 0) {
            targetPos = 0;
        }
        if (targetPos >= itemCount) {
            targetPos = itemCount - 1;
        }
        return targetPos;
    }

    public View findSnapView(C0981i layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return findCenterView(layoutManager, getVerticalHelper(layoutManager));
        }
        if (layoutManager.canScrollHorizontally()) {
            return findCenterView(layoutManager, getHorizontalHelper(layoutManager));
        }
        return null;
    }

    private int distanceToCenter(C0981i layoutManager, View targetView, C0916Ba helper) {
        int containerCenter;
        int childCenter = helper.mo6974d(targetView) + (helper.mo6970b(targetView) / 2);
        if (layoutManager.getClipToPadding()) {
            containerCenter = helper.mo6977f() + (helper.mo6979g() / 2);
        } else {
            containerCenter = helper.mo6966a() / 2;
        }
        return childCenter - containerCenter;
    }

    private int estimateNextPositionDiffForFling(C0981i layoutManager, C0916Ba helper, int velocityX, int velocityY) {
        int[] distances = calculateScrollDistance(velocityX, velocityY);
        float distancePerChild = computeDistancePerChild(layoutManager, helper);
        if (distancePerChild <= 0.0f) {
            return 0;
        }
        return Math.round(((float) (Math.abs(distances[0]) > Math.abs(distances[1]) ? distances[0] : distances[1])) / distancePerChild);
    }

    private View findCenterView(C0981i layoutManager, C0916Ba helper) {
        int center;
        int childCount = layoutManager.getChildCount();
        if (childCount == 0) {
            return null;
        }
        View closestChild = null;
        if (layoutManager.getClipToPadding()) {
            center = helper.mo6977f() + (helper.mo6979g() / 2);
        } else {
            center = helper.mo6966a() / 2;
        }
        int absClosest = MoPubClientPositioning.NO_REPEAT;
        for (int i = 0; i < childCount; i++) {
            View child = layoutManager.getChildAt(i);
            int absDistance = Math.abs((helper.mo6974d(child) + (helper.mo6970b(child) / 2)) - center);
            if (absDistance < absClosest) {
                absClosest = absDistance;
                closestChild = child;
            }
        }
        return closestChild;
    }

    private float computeDistancePerChild(C0981i layoutManager, C0916Ba helper) {
        View minPosView = null;
        View maxPosView = null;
        int minPos = MoPubClientPositioning.NO_REPEAT;
        int maxPos = LinearLayoutManager.INVALID_OFFSET;
        int childCount = layoutManager.getChildCount();
        if (childCount == 0) {
            return 1.0f;
        }
        for (int i = 0; i < childCount; i++) {
            View child = layoutManager.getChildAt(i);
            int pos = layoutManager.getPosition(child);
            if (pos != -1) {
                if (pos < minPos) {
                    minPos = pos;
                    minPosView = child;
                }
                if (pos > maxPos) {
                    maxPos = pos;
                    maxPosView = child;
                }
            }
        }
        if (minPosView == null || maxPosView == null) {
            return 1.0f;
        }
        int distance = Math.max(helper.mo6967a(minPosView), helper.mo6967a(maxPosView)) - Math.min(helper.mo6974d(minPosView), helper.mo6974d(maxPosView));
        if (distance == 0) {
            return 1.0f;
        }
        return (((float) distance) * 1.0f) / ((float) ((maxPos - minPos) + 1));
    }

    private C0916Ba getVerticalHelper(C0981i layoutManager) {
        C0916Ba ba = this.mVerticalHelper;
        if (ba == null || ba.f2921a != layoutManager) {
            this.mVerticalHelper = C0916Ba.m4404b(layoutManager);
        }
        return this.mVerticalHelper;
    }

    private C0916Ba getHorizontalHelper(C0981i layoutManager) {
        C0916Ba ba = this.mHorizontalHelper;
        if (ba == null || ba.f2921a != layoutManager) {
            this.mHorizontalHelper = C0916Ba.m4402a(layoutManager);
        }
        return this.mHorizontalHelper;
    }
}
