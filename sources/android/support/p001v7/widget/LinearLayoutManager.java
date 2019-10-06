package android.support.p001v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p001v7.widget.RecyclerView.C0981i;
import android.support.p001v7.widget.RecyclerView.C0981i.C0982a;
import android.support.p001v7.widget.RecyclerView.C0981i.C0983b;
import android.support.p001v7.widget.RecyclerView.C0984j;
import android.support.p001v7.widget.RecyclerView.C0991p;
import android.support.p001v7.widget.RecyclerView.C0994s.C0996b;
import android.support.p001v7.widget.RecyclerView.C0997t;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.support.p001v7.widget.RecyclerView.ViewHolder;
import android.support.p001v7.widget.p040a.C1037a;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.List;

/* renamed from: android.support.v7.widget.LinearLayoutManager */
public class LinearLayoutManager extends C0981i implements C1037a, C0996b {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final C0955a mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final C0956b mLayoutChunkResult;
    private C0957c mLayoutState;
    int mOrientation;
    C0916Ba mOrientationHelper;
    SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    /* renamed from: android.support.v7.widget.LinearLayoutManager$SavedState */
    public static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new C1105qa();

        /* renamed from: a */
        int f3025a;

        /* renamed from: b */
        int f3026b;

        /* renamed from: c */
        boolean f3027c;

        public SavedState() {
        }

        SavedState(Parcel in) {
            this.f3025a = in.readInt();
            this.f3026b = in.readInt();
            boolean z = true;
            if (in.readInt() != 1) {
                z = false;
            }
            this.f3027c = z;
        }

        public SavedState(SavedState other) {
            this.f3025a = other.f3025a;
            this.f3026b = other.f3026b;
            this.f3027c = other.f3027c;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo7399a() {
            return this.f3025a >= 0;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo7400b() {
            this.f3025a = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.f3025a);
            dest.writeInt(this.f3026b);
            dest.writeInt(this.f3027c ? 1 : 0);
        }
    }

    /* renamed from: android.support.v7.widget.LinearLayoutManager$a */
    static class C0955a {

        /* renamed from: a */
        C0916Ba f3028a;

        /* renamed from: b */
        int f3029b;

        /* renamed from: c */
        int f3030c;

        /* renamed from: d */
        boolean f3031d;

        /* renamed from: e */
        boolean f3032e;

        C0955a() {
            mo7406b();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo7406b() {
            this.f3029b = -1;
            this.f3030c = LinearLayoutManager.INVALID_OFFSET;
            this.f3031d = false;
            this.f3032e = false;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo7403a() {
            int i;
            if (this.f3031d) {
                i = this.f3028a.mo6969b();
            } else {
                i = this.f3028a.mo6977f();
            }
            this.f3030c = i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AnchorInfo{mPosition=");
            sb.append(this.f3029b);
            sb.append(", mCoordinate=");
            sb.append(this.f3030c);
            sb.append(", mLayoutFromEnd=");
            sb.append(this.f3031d);
            sb.append(", mValid=");
            sb.append(this.f3032e);
            sb.append('}');
            return sb.toString();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo7405a(View child, C0997t state) {
            C0984j lp = (C0984j) child.getLayoutParams();
            return !lp.mo7866c() && lp.mo7864a() >= 0 && lp.mo7864a() < state.mo7945a();
        }

        /* renamed from: b */
        public void mo7407b(View child, int position) {
            int spaceChange = this.f3028a.mo7142h();
            if (spaceChange >= 0) {
                mo7404a(child, position);
                return;
            }
            this.f3029b = position;
            if (this.f3031d) {
                int previousEndMargin = (this.f3028a.mo6969b() - spaceChange) - this.f3028a.mo6967a(child);
                this.f3030c = this.f3028a.mo6969b() - previousEndMargin;
                if (previousEndMargin > 0) {
                    int estimatedChildStart = this.f3030c - this.f3028a.mo6970b(child);
                    int layoutStart = this.f3028a.mo6977f();
                    int startMargin = estimatedChildStart - (Math.min(this.f3028a.mo6974d(child) - layoutStart, 0) + layoutStart);
                    if (startMargin < 0) {
                        this.f3030c += Math.min(previousEndMargin, -startMargin);
                    }
                }
            } else {
                int childStart = this.f3028a.mo6974d(child);
                int startMargin2 = childStart - this.f3028a.mo6977f();
                this.f3030c = childStart;
                if (startMargin2 > 0) {
                    int endMargin = (this.f3028a.mo6969b() - Math.min(0, (this.f3028a.mo6969b() - spaceChange) - this.f3028a.mo6967a(child))) - (this.f3028a.mo6970b(child) + childStart);
                    if (endMargin < 0) {
                        this.f3030c -= Math.min(startMargin2, -endMargin);
                    }
                }
            }
        }

        /* renamed from: a */
        public void mo7404a(View child, int position) {
            if (this.f3031d) {
                this.f3030c = this.f3028a.mo6967a(child) + this.f3028a.mo7142h();
            } else {
                this.f3030c = this.f3028a.mo6974d(child);
            }
            this.f3029b = position;
        }
    }

    /* renamed from: android.support.v7.widget.LinearLayoutManager$b */
    protected static class C0956b {

        /* renamed from: a */
        public int f3033a;

        /* renamed from: b */
        public boolean f3034b;

        /* renamed from: c */
        public boolean f3035c;

        /* renamed from: d */
        public boolean f3036d;

        protected C0956b() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo7409a() {
            this.f3033a = 0;
            this.f3034b = false;
            this.f3035c = false;
            this.f3036d = false;
        }
    }

    /* renamed from: android.support.v7.widget.LinearLayoutManager$c */
    static class C0957c {

        /* renamed from: a */
        boolean f3037a = true;

        /* renamed from: b */
        int f3038b;

        /* renamed from: c */
        int f3039c;

        /* renamed from: d */
        int f3040d;

        /* renamed from: e */
        int f3041e;

        /* renamed from: f */
        int f3042f;

        /* renamed from: g */
        int f3043g;

        /* renamed from: h */
        int f3044h = 0;

        /* renamed from: i */
        boolean f3045i = false;

        /* renamed from: j */
        int f3046j;

        /* renamed from: k */
        List<C1000w> f3047k = null;

        /* renamed from: l */
        boolean f3048l;

        C0957c() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo7413a(C0997t state) {
            int i = this.f3040d;
            return i >= 0 && i < state.mo7945a();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public View mo7410a(C0991p recycler) {
            if (this.f3047k != null) {
                return m4596b();
            }
            View view = recycler.mo7912d(this.f3040d);
            this.f3040d += this.f3041e;
            return view;
        }

        /* renamed from: b */
        private View m4596b() {
            int size = this.f3047k.size();
            for (int i = 0; i < size; i++) {
                View view = ((C1000w) this.f3047k.get(i)).itemView;
                C0984j lp = (C0984j) view.getLayoutParams();
                if (!lp.mo7866c() && this.f3040d == lp.mo7864a()) {
                    mo7412a(view);
                    return view;
                }
            }
            return null;
        }

        /* renamed from: a */
        public void mo7411a() {
            mo7412a((View) null);
        }

        /* renamed from: a */
        public void mo7412a(View ignore) {
            View closest = mo7414b(ignore);
            if (closest == null) {
                this.f3040d = -1;
            } else {
                this.f3040d = ((C0984j) closest.getLayoutParams()).mo7864a();
            }
        }

        /* renamed from: b */
        public View mo7414b(View ignore) {
            int size = this.f3047k.size();
            View closest = null;
            int closestDistance = MoPubClientPositioning.NO_REPEAT;
            for (int i = 0; i < size; i++) {
                View view = ((C1000w) this.f3047k.get(i)).itemView;
                C0984j lp = (C0984j) view.getLayoutParams();
                if (view != ignore && !lp.mo7866c()) {
                    int distance = (lp.mo7864a() - this.f3040d) * this.f3041e;
                    if (distance >= 0 && distance < closestDistance) {
                        closest = view;
                        closestDistance = distance;
                        if (distance == 0) {
                            break;
                        }
                    }
                }
            }
            return closest;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = INVALID_OFFSET;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new C0955a();
        this.mLayoutChunkResult = new C0956b();
        this.mInitialPrefetchItemCount = 2;
        setOrientation(orientation);
        setReverseLayout(reverseLayout);
    }

    public LinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = INVALID_OFFSET;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new C0955a();
        this.mLayoutChunkResult = new C0956b();
        this.mInitialPrefetchItemCount = 2;
        C0983b properties = C0981i.getProperties(context, attrs, defStyleAttr, defStyleRes);
        setOrientation(properties.f3186a);
        setReverseLayout(properties.f3188c);
        setStackFromEnd(properties.f3189d);
    }

    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public C0984j generateDefaultLayoutParams() {
        return new C0984j(-2, -2);
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public void setRecycleChildrenOnDetach(boolean recycleChildrenOnDetach) {
        this.mRecycleChildrenOnDetach = recycleChildrenOnDetach;
    }

    public void onDetachedFromWindow(RecyclerView view, C0991p recycler) {
        super.onDetachedFromWindow(view, recycler);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(recycler);
            recycler.mo7891a();
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        if (getChildCount() > 0) {
            event.setFromIndex(findFirstVisibleItemPosition());
            event.setToIndex(findLastVisibleItemPosition());
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState state = new SavedState();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean didLayoutFromEnd = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            state.f3027c = didLayoutFromEnd;
            if (didLayoutFromEnd) {
                View refChild = getChildClosestToEnd();
                state.f3026b = this.mOrientationHelper.mo6969b() - this.mOrientationHelper.mo6967a(refChild);
                state.f3025a = getPosition(refChild);
            } else {
                View refChild2 = getChildClosestToStart();
                state.f3025a = getPosition(refChild2);
                state.f3026b = this.mOrientationHelper.mo6974d(refChild2) - this.mOrientationHelper.mo6977f();
            }
        } else {
            state.mo7400b();
        }
        return state;
    }

    public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof SavedState) {
            this.mPendingSavedState = (SavedState) state;
            requestLayout();
        }
    }

    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    public void setStackFromEnd(boolean stackFromEnd) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd != stackFromEnd) {
            this.mStackFromEnd = stackFromEnd;
            requestLayout();
        }
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int orientation) {
        if (orientation == 0 || orientation == 1) {
            assertNotInLayoutOrScroll(null);
            if (orientation != this.mOrientation || this.mOrientationHelper == null) {
                this.mOrientationHelper = C0916Ba.m4403a(this, orientation);
                this.mAnchorInfo.f3028a = this.mOrientationHelper;
                this.mOrientation = orientation;
                requestLayout();
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("invalid orientation:");
        sb.append(orientation);
        throw new IllegalArgumentException(sb.toString());
    }

    private void resolveShouldLayoutReverse() {
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = !this.mReverseLayout;
        }
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public void setReverseLayout(boolean reverseLayout) {
        assertNotInLayoutOrScroll(null);
        if (reverseLayout != this.mReverseLayout) {
            this.mReverseLayout = reverseLayout;
            requestLayout();
        }
    }

    public View findViewByPosition(int position) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int viewPosition = position - getPosition(getChildAt(0));
        if (viewPosition >= 0 && viewPosition < childCount) {
            View child = getChildAt(viewPosition);
            if (getPosition(child) == position) {
                return child;
            }
        }
        return super.findViewByPosition(position);
    }

    /* access modifiers changed from: protected */
    public int getExtraLayoutSpace(C0997t state) {
        if (state.mo7949c()) {
            return this.mOrientationHelper.mo6979g();
        }
        return 0;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, C0997t state, int position) {
        C1108ra linearSmoothScroller = new C1108ra(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(position);
        startSmoothScroll(linearSmoothScroller);
    }

    public PointF computeScrollVectorForPosition(int targetPosition) {
        if (getChildCount() == 0) {
            return null;
        }
        boolean z = false;
        int i = 1;
        if (targetPosition < getPosition(getChildAt(0))) {
            z = true;
        }
        if (z != this.mShouldReverseLayout) {
            i = -1;
        }
        int direction = i;
        if (this.mOrientation == 0) {
            return new PointF((float) direction, 0.0f);
        }
        return new PointF(0.0f, (float) direction);
    }

    public void onLayoutChildren(C0991p recycler, C0997t state) {
        int extraForStart;
        int extraForEnd;
        int endOffset;
        int firstElement;
        int upcomingOffset;
        int firstLayoutDirection = -1;
        if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && state.mo7945a() == 0) {
            removeAndRecycleAllViews(recycler);
            return;
        }
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.mo7399a()) {
            this.mPendingScrollPosition = this.mPendingSavedState.f3025a;
        }
        ensureLayoutState();
        this.mLayoutState.f3037a = false;
        resolveShouldLayoutReverse();
        View focused = getFocusedChild();
        if (!this.mAnchorInfo.f3032e || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
            this.mAnchorInfo.mo7406b();
            C0955a aVar = this.mAnchorInfo;
            aVar.f3031d = this.mShouldReverseLayout ^ this.mStackFromEnd;
            updateAnchorInfoForLayout(recycler, state, aVar);
            this.mAnchorInfo.f3032e = true;
        } else if (focused != null && (this.mOrientationHelper.mo6974d(focused) >= this.mOrientationHelper.mo6969b() || this.mOrientationHelper.mo6967a(focused) <= this.mOrientationHelper.mo6977f())) {
            this.mAnchorInfo.mo7407b(focused, getPosition(focused));
        }
        int extra = getExtraLayoutSpace(state);
        if (this.mLayoutState.f3046j >= 0) {
            extraForEnd = extra;
            extraForStart = 0;
        } else {
            extraForStart = extra;
            extraForEnd = 0;
        }
        int extraForStart2 = extraForStart + this.mOrientationHelper.mo6977f();
        int extraForEnd2 = extraForEnd + this.mOrientationHelper.mo6971c();
        if (state.mo7950d()) {
            int i = this.mPendingScrollPosition;
            if (!(i == -1 || this.mPendingScrollPositionOffset == Integer.MIN_VALUE)) {
                View existing = findViewByPosition(i);
                if (existing != null) {
                    if (this.mShouldReverseLayout) {
                        upcomingOffset = (this.mOrientationHelper.mo6969b() - this.mOrientationHelper.mo6967a(existing)) - this.mPendingScrollPositionOffset;
                    } else {
                        upcomingOffset = this.mPendingScrollPositionOffset - (this.mOrientationHelper.mo6974d(existing) - this.mOrientationHelper.mo6977f());
                    }
                    if (upcomingOffset > 0) {
                        extraForStart2 += upcomingOffset;
                    } else {
                        extraForEnd2 -= upcomingOffset;
                    }
                }
            }
        }
        if (this.mAnchorInfo.f3031d) {
            if (this.mShouldReverseLayout) {
                firstLayoutDirection = 1;
            }
        } else if (!this.mShouldReverseLayout) {
            firstLayoutDirection = 1;
        }
        onAnchorReady(recycler, state, this.mAnchorInfo, firstLayoutDirection);
        detachAndScrapAttachedViews(recycler);
        this.mLayoutState.f3048l = resolveIsInfinite();
        this.mLayoutState.f3045i = state.mo7950d();
        C0955a aVar2 = this.mAnchorInfo;
        if (aVar2.f3031d) {
            updateLayoutStateToFillStart(aVar2);
            C0957c cVar = this.mLayoutState;
            cVar.f3044h = extraForStart2;
            fill(recycler, cVar, state, false);
            C0957c cVar2 = this.mLayoutState;
            int startOffset = cVar2.f3038b;
            int firstElement2 = cVar2.f3040d;
            int i2 = cVar2.f3039c;
            if (i2 > 0) {
                extraForEnd2 += i2;
            }
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            C0957c cVar3 = this.mLayoutState;
            cVar3.f3044h = extraForEnd2;
            cVar3.f3040d += cVar3.f3041e;
            fill(recycler, cVar3, state, false);
            C0957c cVar4 = this.mLayoutState;
            endOffset = cVar4.f3038b;
            if (cVar4.f3039c > 0) {
                int extraForStart3 = cVar4.f3039c;
                updateLayoutStateToFillStart(firstElement2, startOffset);
                C0957c cVar5 = this.mLayoutState;
                cVar5.f3044h = extraForStart3;
                fill(recycler, cVar5, state, false);
                startOffset = this.mLayoutState.f3038b;
            }
            firstElement = startOffset;
        } else {
            updateLayoutStateToFillEnd(aVar2);
            C0957c cVar6 = this.mLayoutState;
            cVar6.f3044h = extraForEnd2;
            fill(recycler, cVar6, state, false);
            C0957c cVar7 = this.mLayoutState;
            endOffset = cVar7.f3038b;
            int lastElement = cVar7.f3040d;
            int i3 = cVar7.f3039c;
            if (i3 > 0) {
                extraForStart2 += i3;
            }
            updateLayoutStateToFillStart(this.mAnchorInfo);
            C0957c cVar8 = this.mLayoutState;
            cVar8.f3044h = extraForStart2;
            cVar8.f3040d += cVar8.f3041e;
            fill(recycler, cVar8, state, false);
            C0957c cVar9 = this.mLayoutState;
            firstElement = cVar9.f3038b;
            if (cVar9.f3039c > 0) {
                int extraForEnd3 = cVar9.f3039c;
                updateLayoutStateToFillEnd(lastElement, endOffset);
                C0957c cVar10 = this.mLayoutState;
                cVar10.f3044h = extraForEnd3;
                fill(recycler, cVar10, state, false);
                endOffset = this.mLayoutState.f3038b;
            }
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int fixOffset = fixLayoutEndGap(endOffset, recycler, state, true);
                int startOffset2 = firstElement + fixOffset;
                int endOffset2 = endOffset + fixOffset;
                int fixOffset2 = fixLayoutStartGap(startOffset2, recycler, state, false);
                firstElement = startOffset2 + fixOffset2;
                endOffset = endOffset2 + fixOffset2;
            } else {
                int fixOffset3 = fixLayoutStartGap(firstElement, recycler, state, true);
                int startOffset3 = firstElement + fixOffset3;
                int endOffset3 = endOffset + fixOffset3;
                int fixOffset4 = fixLayoutEndGap(endOffset3, recycler, state, false);
                firstElement = startOffset3 + fixOffset4;
                endOffset = endOffset3 + fixOffset4;
            }
        }
        layoutForPredictiveAnimations(recycler, state, firstElement, endOffset);
        if (!state.mo7950d()) {
            this.mOrientationHelper.mo7143i();
        } else {
            this.mAnchorInfo.mo7406b();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    public void onLayoutCompleted(C0997t state) {
        super.onLayoutCompleted(state);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = INVALID_OFFSET;
        this.mAnchorInfo.mo7406b();
    }

    /* access modifiers changed from: 0000 */
    public void onAnchorReady(C0991p recycler, C0997t state, C0955a anchorInfo, int firstLayoutItemDirection) {
    }

    private void layoutForPredictiveAnimations(C0991p recycler, C0997t state, int startOffset, int endOffset) {
        C0991p pVar = recycler;
        C0997t tVar = state;
        if (!state.mo7951e() || getChildCount() == 0 || state.mo7950d()) {
            int i = startOffset;
            int i2 = endOffset;
        } else if (!supportsPredictiveItemAnimations()) {
            int i3 = startOffset;
            int i4 = endOffset;
        } else {
            int scrapExtraStart = 0;
            int scrapExtraEnd = 0;
            List<ViewHolder> scrapList = recycler.mo7916f();
            int scrapSize = scrapList.size();
            int firstChildPos = getPosition(getChildAt(0));
            for (int i5 = 0; i5 < scrapSize; i5++) {
                C1000w scrap = (C1000w) scrapList.get(i5);
                if (!scrap.isRemoved()) {
                    int direction = 1;
                    if ((scrap.getLayoutPosition() < firstChildPos) != this.mShouldReverseLayout) {
                        direction = -1;
                    }
                    if (direction == -1) {
                        scrapExtraStart += this.mOrientationHelper.mo6970b(scrap.itemView);
                    } else {
                        scrapExtraEnd += this.mOrientationHelper.mo6970b(scrap.itemView);
                    }
                }
            }
            this.mLayoutState.f3047k = scrapList;
            if (scrapExtraStart > 0) {
                updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), startOffset);
                C0957c cVar = this.mLayoutState;
                cVar.f3044h = scrapExtraStart;
                cVar.f3039c = 0;
                cVar.mo7411a();
                fill(pVar, this.mLayoutState, tVar, false);
            } else {
                int i6 = startOffset;
            }
            if (scrapExtraEnd > 0) {
                updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), endOffset);
                C0957c cVar2 = this.mLayoutState;
                cVar2.f3044h = scrapExtraEnd;
                cVar2.f3039c = 0;
                cVar2.mo7411a();
                fill(pVar, this.mLayoutState, tVar, false);
            } else {
                int i7 = endOffset;
            }
            this.mLayoutState.f3047k = null;
        }
    }

    private void updateAnchorInfoForLayout(C0991p recycler, C0997t state, C0955a anchorInfo) {
        if (!updateAnchorFromPendingData(state, anchorInfo) && !updateAnchorFromChildren(recycler, state, anchorInfo)) {
            anchorInfo.mo7403a();
            anchorInfo.f3029b = this.mStackFromEnd ? state.mo7945a() - 1 : 0;
        }
    }

    private boolean updateAnchorFromChildren(C0991p recycler, C0997t state, C0955a anchorInfo) {
        View referenceChild;
        int i;
        boolean notVisible = false;
        if (getChildCount() == 0) {
            return false;
        }
        View focused = getFocusedChild();
        if (focused != null && anchorInfo.mo7405a(focused, state)) {
            anchorInfo.mo7407b(focused, getPosition(focused));
            return true;
        } else if (this.mLastStackFromEnd != this.mStackFromEnd) {
            return false;
        } else {
            if (anchorInfo.f3031d) {
                referenceChild = findReferenceChildClosestToEnd(recycler, state);
            } else {
                referenceChild = findReferenceChildClosestToStart(recycler, state);
            }
            if (referenceChild == null) {
                return false;
            }
            anchorInfo.mo7404a(referenceChild, getPosition(referenceChild));
            if (!state.mo7950d() && supportsPredictiveItemAnimations()) {
                if (this.mOrientationHelper.mo6974d(referenceChild) >= this.mOrientationHelper.mo6969b() || this.mOrientationHelper.mo6967a(referenceChild) < this.mOrientationHelper.mo6977f()) {
                    notVisible = true;
                }
                if (notVisible) {
                    if (anchorInfo.f3031d) {
                        i = this.mOrientationHelper.mo6969b();
                    } else {
                        i = this.mOrientationHelper.mo6977f();
                    }
                    anchorInfo.f3030c = i;
                }
            }
            return true;
        }
    }

    private boolean updateAnchorFromPendingData(C0997t state, C0955a anchorInfo) {
        int i;
        boolean z = false;
        if (!state.mo7950d()) {
            int i2 = this.mPendingScrollPosition;
            if (i2 != -1) {
                if (i2 < 0 || i2 >= state.mo7945a()) {
                    this.mPendingScrollPosition = -1;
                    this.mPendingScrollPositionOffset = INVALID_OFFSET;
                    return false;
                }
                anchorInfo.f3029b = this.mPendingScrollPosition;
                SavedState savedState = this.mPendingSavedState;
                if (savedState != null && savedState.mo7399a()) {
                    anchorInfo.f3031d = this.mPendingSavedState.f3027c;
                    if (anchorInfo.f3031d) {
                        anchorInfo.f3030c = this.mOrientationHelper.mo6969b() - this.mPendingSavedState.f3026b;
                    } else {
                        anchorInfo.f3030c = this.mOrientationHelper.mo6977f() + this.mPendingSavedState.f3026b;
                    }
                    return true;
                } else if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                    View child = findViewByPosition(this.mPendingScrollPosition);
                    if (child == null) {
                        if (getChildCount() > 0) {
                            if ((this.mPendingScrollPosition < getPosition(getChildAt(0))) == this.mShouldReverseLayout) {
                                z = true;
                            }
                            anchorInfo.f3031d = z;
                        }
                        anchorInfo.mo7403a();
                    } else if (this.mOrientationHelper.mo6970b(child) > this.mOrientationHelper.mo6979g()) {
                        anchorInfo.mo7403a();
                        return true;
                    } else if (this.mOrientationHelper.mo6974d(child) - this.mOrientationHelper.mo6977f() < 0) {
                        anchorInfo.f3030c = this.mOrientationHelper.mo6977f();
                        anchorInfo.f3031d = false;
                        return true;
                    } else if (this.mOrientationHelper.mo6969b() - this.mOrientationHelper.mo6967a(child) < 0) {
                        anchorInfo.f3030c = this.mOrientationHelper.mo6969b();
                        anchorInfo.f3031d = true;
                        return true;
                    } else {
                        if (anchorInfo.f3031d) {
                            i = this.mOrientationHelper.mo6967a(child) + this.mOrientationHelper.mo7142h();
                        } else {
                            i = this.mOrientationHelper.mo6974d(child);
                        }
                        anchorInfo.f3030c = i;
                    }
                    return true;
                } else {
                    boolean z2 = this.mShouldReverseLayout;
                    anchorInfo.f3031d = z2;
                    if (z2) {
                        anchorInfo.f3030c = this.mOrientationHelper.mo6969b() - this.mPendingScrollPositionOffset;
                    } else {
                        anchorInfo.f3030c = this.mOrientationHelper.mo6977f() + this.mPendingScrollPositionOffset;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private int fixLayoutEndGap(int endOffset, C0991p recycler, C0997t state, boolean canOffsetChildren) {
        int gap = this.mOrientationHelper.mo6969b() - endOffset;
        if (gap <= 0) {
            return 0;
        }
        int fixOffset = -scrollBy(-gap, recycler, state);
        int endOffset2 = endOffset + fixOffset;
        if (canOffsetChildren) {
            int gap2 = this.mOrientationHelper.mo6969b() - endOffset2;
            if (gap2 > 0) {
                this.mOrientationHelper.mo6968a(gap2);
                return gap2 + fixOffset;
            }
        }
        return fixOffset;
    }

    private int fixLayoutStartGap(int startOffset, C0991p recycler, C0997t state, boolean canOffsetChildren) {
        int gap = startOffset - this.mOrientationHelper.mo6977f();
        if (gap <= 0) {
            return 0;
        }
        int fixOffset = -scrollBy(gap, recycler, state);
        int startOffset2 = startOffset + fixOffset;
        if (canOffsetChildren) {
            int gap2 = startOffset2 - this.mOrientationHelper.mo6977f();
            if (gap2 > 0) {
                this.mOrientationHelper.mo6968a(-gap2);
                return fixOffset - gap2;
            }
        }
        return fixOffset;
    }

    private void updateLayoutStateToFillEnd(C0955a anchorInfo) {
        updateLayoutStateToFillEnd(anchorInfo.f3029b, anchorInfo.f3030c);
    }

    private void updateLayoutStateToFillEnd(int itemPosition, int offset) {
        this.mLayoutState.f3039c = this.mOrientationHelper.mo6969b() - offset;
        this.mLayoutState.f3041e = this.mShouldReverseLayout ? -1 : 1;
        C0957c cVar = this.mLayoutState;
        cVar.f3040d = itemPosition;
        cVar.f3042f = 1;
        cVar.f3038b = offset;
        cVar.f3043g = INVALID_OFFSET;
    }

    private void updateLayoutStateToFillStart(C0955a anchorInfo) {
        updateLayoutStateToFillStart(anchorInfo.f3029b, anchorInfo.f3030c);
    }

    private void updateLayoutStateToFillStart(int itemPosition, int offset) {
        this.mLayoutState.f3039c = offset - this.mOrientationHelper.mo6977f();
        C0957c cVar = this.mLayoutState;
        cVar.f3040d = itemPosition;
        cVar.f3041e = this.mShouldReverseLayout ? 1 : -1;
        C0957c cVar2 = this.mLayoutState;
        cVar2.f3042f = -1;
        cVar2.f3038b = offset;
        cVar2.f3043g = INVALID_OFFSET;
    }

    /* access modifiers changed from: protected */
    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    /* access modifiers changed from: 0000 */
    public void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    /* access modifiers changed from: 0000 */
    public C0957c createLayoutState() {
        return new C0957c();
    }

    public void scrollToPosition(int position) {
        this.mPendingScrollPosition = position;
        this.mPendingScrollPositionOffset = INVALID_OFFSET;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.mo7400b();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int position, int offset) {
        this.mPendingScrollPosition = position;
        this.mPendingScrollPositionOffset = offset;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.mo7400b();
        }
        requestLayout();
    }

    public int scrollHorizontallyBy(int dx, C0991p recycler, C0997t state) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(dx, recycler, state);
    }

    public int scrollVerticallyBy(int dy, C0991p recycler, C0997t state) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(dy, recycler, state);
    }

    public int computeHorizontalScrollOffset(C0997t state) {
        return computeScrollOffset(state);
    }

    public int computeVerticalScrollOffset(C0997t state) {
        return computeScrollOffset(state);
    }

    public int computeHorizontalScrollExtent(C0997t state) {
        return computeScrollExtent(state);
    }

    public int computeVerticalScrollExtent(C0997t state) {
        return computeScrollExtent(state);
    }

    public int computeHorizontalScrollRange(C0997t state) {
        return computeScrollRange(state);
    }

    public int computeVerticalScrollRange(C0997t state) {
        return computeScrollRange(state);
    }

    private int computeScrollOffset(C0997t state) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return C0968Qa.m4696a(state, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollExtent(C0997t state) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return C0968Qa.m4695a(state, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollRange(C0997t state) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return C0968Qa.m4697b(state, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    public void setSmoothScrollbarEnabled(boolean enabled) {
        this.mSmoothScrollbarEnabled = enabled;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    private void updateLayoutState(int layoutDirection, int requiredSpace, boolean canUseExistingSpace, C0997t state) {
        int scrollingOffset;
        this.mLayoutState.f3048l = resolveIsInfinite();
        this.mLayoutState.f3044h = getExtraLayoutSpace(state);
        C0957c cVar = this.mLayoutState;
        cVar.f3042f = layoutDirection;
        int i = -1;
        if (layoutDirection == 1) {
            cVar.f3044h += this.mOrientationHelper.mo6971c();
            View child = getChildClosestToEnd();
            C0957c cVar2 = this.mLayoutState;
            if (!this.mShouldReverseLayout) {
                i = 1;
            }
            cVar2.f3041e = i;
            C0957c cVar3 = this.mLayoutState;
            int position = getPosition(child);
            C0957c cVar4 = this.mLayoutState;
            cVar3.f3040d = position + cVar4.f3041e;
            cVar4.f3038b = this.mOrientationHelper.mo6967a(child);
            scrollingOffset = this.mOrientationHelper.mo6967a(child) - this.mOrientationHelper.mo6969b();
        } else {
            View child2 = getChildClosestToStart();
            this.mLayoutState.f3044h += this.mOrientationHelper.mo6977f();
            C0957c cVar5 = this.mLayoutState;
            if (this.mShouldReverseLayout) {
                i = 1;
            }
            cVar5.f3041e = i;
            C0957c cVar6 = this.mLayoutState;
            int position2 = getPosition(child2);
            C0957c cVar7 = this.mLayoutState;
            cVar6.f3040d = position2 + cVar7.f3041e;
            cVar7.f3038b = this.mOrientationHelper.mo6974d(child2);
            scrollingOffset = (-this.mOrientationHelper.mo6974d(child2)) + this.mOrientationHelper.mo6977f();
        }
        C0957c cVar8 = this.mLayoutState;
        cVar8.f3039c = requiredSpace;
        if (canUseExistingSpace) {
            cVar8.f3039c -= scrollingOffset;
        }
        this.mLayoutState.f3043g = scrollingOffset;
    }

    /* access modifiers changed from: 0000 */
    public boolean resolveIsInfinite() {
        return this.mOrientationHelper.mo6973d() == 0 && this.mOrientationHelper.mo6966a() == 0;
    }

    /* access modifiers changed from: 0000 */
    public void collectPrefetchPositionsForLayoutState(C0997t state, C0957c layoutState, C0982a layoutPrefetchRegistry) {
        int pos = layoutState.f3040d;
        if (pos >= 0 && pos < state.mo7945a()) {
            layoutPrefetchRegistry.mo7863a(pos, Math.max(0, layoutState.f3043g));
        }
    }

    public void collectInitialPrefetchPositions(int adapterItemCount, C0982a layoutPrefetchRegistry) {
        boolean fromEnd;
        int anchorPos;
        SavedState savedState = this.mPendingSavedState;
        int direction = -1;
        if (savedState == null || !savedState.mo7399a()) {
            resolveShouldLayoutReverse();
            fromEnd = this.mShouldReverseLayout;
            anchorPos = this.mPendingScrollPosition == -1 ? fromEnd ? adapterItemCount - 1 : 0 : this.mPendingScrollPosition;
        } else {
            SavedState savedState2 = this.mPendingSavedState;
            fromEnd = savedState2.f3027c;
            anchorPos = savedState2.f3025a;
        }
        if (!fromEnd) {
            direction = 1;
        }
        int targetPos = anchorPos;
        for (int i = 0; i < this.mInitialPrefetchItemCount && targetPos >= 0 && targetPos < adapterItemCount; i++) {
            layoutPrefetchRegistry.mo7863a(targetPos, 0);
            targetPos += direction;
        }
    }

    public void setInitialPrefetchItemCount(int itemCount) {
        this.mInitialPrefetchItemCount = itemCount;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public void collectAdjacentPrefetchPositions(int dx, int dy, C0997t state, C0982a layoutPrefetchRegistry) {
        int delta = this.mOrientation == 0 ? dx : dy;
        if (getChildCount() != 0 && delta != 0) {
            ensureLayoutState();
            updateLayoutState(delta > 0 ? 1 : -1, Math.abs(delta), true, state);
            collectPrefetchPositionsForLayoutState(state, this.mLayoutState, layoutPrefetchRegistry);
        }
    }

    /* access modifiers changed from: 0000 */
    public int scrollBy(int dy, C0991p recycler, C0997t state) {
        if (getChildCount() == 0 || dy == 0) {
            return 0;
        }
        this.mLayoutState.f3037a = true;
        ensureLayoutState();
        int layoutDirection = dy > 0 ? 1 : -1;
        int absDy = Math.abs(dy);
        updateLayoutState(layoutDirection, absDy, true, state);
        C0957c cVar = this.mLayoutState;
        int consumed = cVar.f3043g + fill(recycler, cVar, state, false);
        if (consumed < 0) {
            return 0;
        }
        int scrolled = absDy > consumed ? layoutDirection * consumed : dy;
        this.mOrientationHelper.mo6968a(-scrolled);
        this.mLayoutState.f3046j = scrolled;
        return scrolled;
    }

    public void assertNotInLayoutOrScroll(String message) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(message);
        }
    }

    private void recycleChildren(C0991p recycler, int startIndex, int endIndex) {
        if (startIndex != endIndex) {
            if (endIndex > startIndex) {
                for (int i = endIndex - 1; i >= startIndex; i--) {
                    removeAndRecycleViewAt(i, recycler);
                }
            } else {
                for (int i2 = startIndex; i2 > endIndex; i2--) {
                    removeAndRecycleViewAt(i2, recycler);
                }
            }
        }
    }

    private void recycleViewsFromStart(C0991p recycler, int dt) {
        if (dt >= 0) {
            int limit = dt;
            int childCount = getChildCount();
            if (this.mShouldReverseLayout) {
                for (int i = childCount - 1; i >= 0; i--) {
                    View child = getChildAt(i);
                    if (this.mOrientationHelper.mo6967a(child) > limit || this.mOrientationHelper.mo6976e(child) > limit) {
                        recycleChildren(recycler, childCount - 1, i);
                        return;
                    }
                }
            } else {
                for (int i2 = 0; i2 < childCount; i2++) {
                    View child2 = getChildAt(i2);
                    if (this.mOrientationHelper.mo6967a(child2) > limit || this.mOrientationHelper.mo6976e(child2) > limit) {
                        recycleChildren(recycler, 0, i2);
                        return;
                    }
                }
            }
        }
    }

    private void recycleViewsFromEnd(C0991p recycler, int dt) {
        int childCount = getChildCount();
        if (dt >= 0) {
            int limit = this.mOrientationHelper.mo6966a() - dt;
            if (this.mShouldReverseLayout) {
                for (int i = 0; i < childCount; i++) {
                    View child = getChildAt(i);
                    if (this.mOrientationHelper.mo6974d(child) < limit || this.mOrientationHelper.mo6978f(child) < limit) {
                        recycleChildren(recycler, 0, i);
                        return;
                    }
                }
            } else {
                for (int i2 = childCount - 1; i2 >= 0; i2--) {
                    View child2 = getChildAt(i2);
                    if (this.mOrientationHelper.mo6974d(child2) < limit || this.mOrientationHelper.mo6978f(child2) < limit) {
                        recycleChildren(recycler, childCount - 1, i2);
                        return;
                    }
                }
            }
        }
    }

    private void recycleByLayoutState(C0991p recycler, C0957c layoutState) {
        if (layoutState.f3037a && !layoutState.f3048l) {
            if (layoutState.f3042f == -1) {
                recycleViewsFromEnd(recycler, layoutState.f3043g);
            } else {
                recycleViewsFromStart(recycler, layoutState.f3043g);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public int fill(C0991p recycler, C0957c layoutState, C0997t state, boolean stopOnFocusable) {
        int start = layoutState.f3039c;
        int i = layoutState.f3043g;
        if (i != Integer.MIN_VALUE) {
            int i2 = layoutState.f3039c;
            if (i2 < 0) {
                layoutState.f3043g = i + i2;
            }
            recycleByLayoutState(recycler, layoutState);
        }
        int remainingSpace = layoutState.f3039c + layoutState.f3044h;
        C0956b layoutChunkResult = this.mLayoutChunkResult;
        while (true) {
            if ((!layoutState.f3048l && remainingSpace <= 0) || !layoutState.mo7413a(state)) {
                break;
            }
            layoutChunkResult.mo7409a();
            layoutChunk(recycler, state, layoutState, layoutChunkResult);
            if (!layoutChunkResult.f3034b) {
                layoutState.f3038b += layoutChunkResult.f3033a * layoutState.f3042f;
                if (!layoutChunkResult.f3035c || this.mLayoutState.f3047k != null || !state.mo7950d()) {
                    int i3 = layoutState.f3039c;
                    int i4 = layoutChunkResult.f3033a;
                    layoutState.f3039c = i3 - i4;
                    remainingSpace -= i4;
                }
                int i5 = layoutState.f3043g;
                if (i5 != Integer.MIN_VALUE) {
                    layoutState.f3043g = i5 + layoutChunkResult.f3033a;
                    int i6 = layoutState.f3039c;
                    if (i6 < 0) {
                        layoutState.f3043g += i6;
                    }
                    recycleByLayoutState(recycler, layoutState);
                }
                if (stopOnFocusable && layoutChunkResult.f3036d) {
                    break;
                }
            } else {
                break;
            }
        }
        return start - layoutState.f3039c;
    }

    /* access modifiers changed from: 0000 */
    public void layoutChunk(C0991p recycler, C0997t state, C0957c layoutState, C0956b result) {
        int bottom;
        int right;
        int top;
        int left;
        int left2;
        int right2;
        C0957c cVar = layoutState;
        C0956b bVar = result;
        View view = cVar.mo7410a(recycler);
        if (view == null) {
            bVar.f3034b = true;
            return;
        }
        C0984j params = (C0984j) view.getLayoutParams();
        if (cVar.f3047k == null) {
            if (this.mShouldReverseLayout == (cVar.f3042f == -1)) {
                addView(view);
            } else {
                addView(view, 0);
            }
        } else {
            if (this.mShouldReverseLayout == (cVar.f3042f == -1)) {
                addDisappearingView(view);
            } else {
                addDisappearingView(view, 0);
            }
        }
        measureChildWithMargins(view, 0, 0);
        bVar.f3033a = this.mOrientationHelper.mo6970b(view);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                right2 = getWidth() - getPaddingRight();
                left2 = right2 - this.mOrientationHelper.mo6972c(view);
            } else {
                left2 = getPaddingLeft();
                right2 = this.mOrientationHelper.mo6972c(view) + left2;
            }
            if (cVar.f3042f == -1) {
                right = right2;
                bottom = cVar.f3038b;
                left = left2;
                top = cVar.f3038b - bVar.f3033a;
            } else {
                right = right2;
                top = cVar.f3038b;
                left = left2;
                bottom = cVar.f3038b + bVar.f3033a;
            }
        } else {
            int top2 = getPaddingTop();
            int bottom2 = this.mOrientationHelper.mo6972c(view) + top2;
            if (cVar.f3042f == -1) {
                top = top2;
                right = cVar.f3038b;
                bottom = bottom2;
                left = cVar.f3038b - bVar.f3033a;
            } else {
                top = top2;
                left = cVar.f3038b;
                bottom = bottom2;
                right = cVar.f3038b + bVar.f3033a;
            }
        }
        layoutDecoratedWithMargins(view, left, top, right, bottom);
        if (params.mo7866c() || params.mo7865b()) {
            bVar.f3035c = true;
        }
        bVar.f3036d = view.hasFocusable();
    }

    /* access modifiers changed from: 0000 */
    public boolean shouldMeasureTwice() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) ? false : true;
    }

    /* access modifiers changed from: 0000 */
    public int convertFocusDirectionToLayoutDirection(int focusDirection) {
        int i = -1;
        int i2 = 1;
        if (focusDirection != 1) {
            if (focusDirection != 2) {
                if (focusDirection == 17) {
                    if (this.mOrientation != 0) {
                        i = INVALID_OFFSET;
                    }
                    return i;
                } else if (focusDirection == 33) {
                    if (this.mOrientation != 1) {
                        i = INVALID_OFFSET;
                    }
                    return i;
                } else if (focusDirection == 66) {
                    if (this.mOrientation != 0) {
                        i2 = INVALID_OFFSET;
                    }
                    return i2;
                } else if (focusDirection != 130) {
                    return INVALID_OFFSET;
                } else {
                    if (this.mOrientation != 1) {
                        i2 = INVALID_OFFSET;
                    }
                    return i2;
                }
            } else if (this.mOrientation != 1 && isLayoutRTL()) {
                return -1;
            } else {
                return 1;
            }
        } else if (this.mOrientation != 1 && isLayoutRTL()) {
            return 1;
        } else {
            return -1;
        }
    }

    private View getChildClosestToStart() {
        return getChildAt(this.mShouldReverseLayout ? getChildCount() - 1 : 0);
    }

    private View getChildClosestToEnd() {
        return getChildAt(this.mShouldReverseLayout ? 0 : getChildCount() - 1);
    }

    private View findFirstVisibleChildClosestToStart(boolean completelyVisible, boolean acceptPartiallyVisible) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(getChildCount() - 1, -1, completelyVisible, acceptPartiallyVisible);
        }
        return findOneVisibleChild(0, getChildCount(), completelyVisible, acceptPartiallyVisible);
    }

    private View findFirstVisibleChildClosestToEnd(boolean completelyVisible, boolean acceptPartiallyVisible) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(0, getChildCount(), completelyVisible, acceptPartiallyVisible);
        }
        return findOneVisibleChild(getChildCount() - 1, -1, completelyVisible, acceptPartiallyVisible);
    }

    private View findReferenceChildClosestToEnd(C0991p recycler, C0997t state) {
        if (this.mShouldReverseLayout) {
            return findFirstReferenceChild(recycler, state);
        }
        return findLastReferenceChild(recycler, state);
    }

    private View findReferenceChildClosestToStart(C0991p recycler, C0997t state) {
        if (this.mShouldReverseLayout) {
            return findLastReferenceChild(recycler, state);
        }
        return findFirstReferenceChild(recycler, state);
    }

    private View findFirstReferenceChild(C0991p recycler, C0997t state) {
        return findReferenceChild(recycler, state, 0, getChildCount(), state.mo7945a());
    }

    private View findLastReferenceChild(C0991p recycler, C0997t state) {
        return findReferenceChild(recycler, state, getChildCount() - 1, -1, state.mo7945a());
    }

    /* access modifiers changed from: 0000 */
    public View findReferenceChild(C0991p recycler, C0997t state, int start, int end, int itemCount) {
        ensureLayoutState();
        View invalidMatch = null;
        View outOfBoundsMatch = null;
        int boundsStart = this.mOrientationHelper.mo6977f();
        int boundsEnd = this.mOrientationHelper.mo6969b();
        int diff = end > start ? 1 : -1;
        for (int i = start; i != end; i += diff) {
            View view = getChildAt(i);
            int position = getPosition(view);
            if (position >= 0 && position < itemCount) {
                if (((C0984j) view.getLayoutParams()).mo7866c()) {
                    if (invalidMatch == null) {
                        invalidMatch = view;
                    }
                } else if (this.mOrientationHelper.mo6974d(view) < boundsEnd && this.mOrientationHelper.mo6967a(view) >= boundsStart) {
                    return view;
                } else {
                    if (outOfBoundsMatch == null) {
                        outOfBoundsMatch = view;
                    }
                }
            }
        }
        return outOfBoundsMatch != null ? outOfBoundsMatch : invalidMatch;
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd(C0991p recycler, C0997t state) {
        if (this.mShouldReverseLayout) {
            return findFirstPartiallyOrCompletelyInvisibleChild(recycler, state);
        }
        return findLastPartiallyOrCompletelyInvisibleChild(recycler, state);
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart(C0991p recycler, C0997t state) {
        if (this.mShouldReverseLayout) {
            return findLastPartiallyOrCompletelyInvisibleChild(recycler, state);
        }
        return findFirstPartiallyOrCompletelyInvisibleChild(recycler, state);
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild(C0991p recycler, C0997t state) {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild(C0991p recycler, C0997t state) {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    public int findFirstVisibleItemPosition() {
        View child = findOneVisibleChild(0, getChildCount(), false, true);
        if (child == null) {
            return -1;
        }
        return getPosition(child);
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View child = findOneVisibleChild(0, getChildCount(), true, false);
        if (child == null) {
            return -1;
        }
        return getPosition(child);
    }

    public int findLastVisibleItemPosition() {
        View child = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (child == null) {
            return -1;
        }
        return getPosition(child);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View child = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (child == null) {
            return -1;
        }
        return getPosition(child);
    }

    /* access modifiers changed from: 0000 */
    public View findOneVisibleChild(int fromIndex, int toIndex, boolean completelyVisible, boolean acceptPartiallyVisible) {
        int preferredBoundsFlag;
        ensureLayoutState();
        int acceptableBoundsFlag = 0;
        if (completelyVisible) {
            preferredBoundsFlag = 24579;
        } else {
            preferredBoundsFlag = 320;
        }
        if (acceptPartiallyVisible) {
            acceptableBoundsFlag = 320;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.mo7233a(fromIndex, toIndex, preferredBoundsFlag, acceptableBoundsFlag);
        }
        return this.mVerticalBoundCheck.mo7233a(fromIndex, toIndex, preferredBoundsFlag, acceptableBoundsFlag);
    }

    /* access modifiers changed from: 0000 */
    public View findOnePartiallyOrCompletelyInvisibleChild(int fromIndex, int toIndex) {
        int acceptableBoundsFlag;
        int preferredBoundsFlag;
        View view;
        ensureLayoutState();
        int next = toIndex > fromIndex ? 1 : toIndex < fromIndex ? -1 : 0;
        if (next == 0) {
            return getChildAt(fromIndex);
        }
        if (this.mOrientationHelper.mo6974d(getChildAt(fromIndex)) < this.mOrientationHelper.mo6977f()) {
            preferredBoundsFlag = 16644;
            acceptableBoundsFlag = 16388;
        } else {
            preferredBoundsFlag = 4161;
            acceptableBoundsFlag = 4097;
        }
        if (this.mOrientation == 0) {
            view = this.mHorizontalBoundCheck.mo7233a(fromIndex, toIndex, preferredBoundsFlag, acceptableBoundsFlag);
        } else {
            view = this.mVerticalBoundCheck.mo7233a(fromIndex, toIndex, preferredBoundsFlag, acceptableBoundsFlag);
        }
        return view;
    }

    public View onFocusSearchFailed(View focused, int focusDirection, C0991p recycler, C0997t state) {
        View nextCandidate;
        View nextFocus;
        resolveShouldLayoutReverse();
        if (getChildCount() == 0) {
            return null;
        }
        int layoutDir = convertFocusDirectionToLayoutDirection(focusDirection);
        if (layoutDir == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        ensureLayoutState();
        updateLayoutState(layoutDir, (int) (((float) this.mOrientationHelper.mo6979g()) * MAX_SCROLL_FACTOR), false, state);
        C0957c cVar = this.mLayoutState;
        cVar.f3043g = INVALID_OFFSET;
        cVar.f3037a = false;
        fill(recycler, cVar, state, true);
        if (layoutDir == -1) {
            nextCandidate = findPartiallyOrCompletelyInvisibleChildClosestToStart(recycler, state);
        } else {
            nextCandidate = findPartiallyOrCompletelyInvisibleChildClosestToEnd(recycler, state);
        }
        if (layoutDir == -1) {
            nextFocus = getChildClosestToStart();
        } else {
            nextFocus = getChildClosestToEnd();
        }
        if (!nextFocus.hasFocusable()) {
            return nextCandidate;
        }
        if (nextCandidate == null) {
            return null;
        }
        return nextFocus;
    }

    private void logChildren() {
        String str = TAG;
        Log.d(str, "internal representation of views on the screen");
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            StringBuilder sb = new StringBuilder();
            sb.append("item ");
            sb.append(getPosition(child));
            sb.append(", coord:");
            sb.append(this.mOrientationHelper.mo6974d(child));
            Log.d(str, sb.toString());
        }
        Log.d(str, "==============");
    }

    /* access modifiers changed from: 0000 */
    public void validateChildOrder() {
        StringBuilder sb = new StringBuilder();
        sb.append("validating child count ");
        sb.append(getChildCount());
        Log.d(TAG, sb.toString());
        if (getChildCount() >= 1) {
            boolean z = false;
            int lastPos = getPosition(getChildAt(0));
            int lastScreenLoc = this.mOrientationHelper.mo6974d(getChildAt(0));
            String str = "detected invalid location";
            String str2 = "detected invalid position. loc invalid? ";
            if (this.mShouldReverseLayout) {
                int i = 1;
                while (i < getChildCount()) {
                    View child = getChildAt(i);
                    int pos = getPosition(child);
                    int screenLoc = this.mOrientationHelper.mo6974d(child);
                    if (pos < lastPos) {
                        logChildren();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str2);
                        if (screenLoc < lastScreenLoc) {
                            z = true;
                        }
                        sb2.append(z);
                        throw new RuntimeException(sb2.toString());
                    } else if (screenLoc <= lastScreenLoc) {
                        i++;
                    } else {
                        logChildren();
                        throw new RuntimeException(str);
                    }
                }
            } else {
                int i2 = 1;
                while (i2 < getChildCount()) {
                    View child2 = getChildAt(i2);
                    int pos2 = getPosition(child2);
                    int screenLoc2 = this.mOrientationHelper.mo6974d(child2);
                    if (pos2 < lastPos) {
                        logChildren();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str2);
                        if (screenLoc2 < lastScreenLoc) {
                            z = true;
                        }
                        sb3.append(z);
                        throw new RuntimeException(sb3.toString());
                    } else if (screenLoc2 >= lastScreenLoc) {
                        i2++;
                    } else {
                        logChildren();
                        throw new RuntimeException(str);
                    }
                }
            }
        }
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
    }

    public void prepareForDrop(View view, View target, int x, int y) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int myPos = getPosition(view);
        int targetPos = getPosition(target);
        int dropDirection = myPos < targetPos ? 1 : -1;
        if (this.mShouldReverseLayout) {
            if (dropDirection == 1) {
                scrollToPositionWithOffset(targetPos, this.mOrientationHelper.mo6969b() - (this.mOrientationHelper.mo6974d(target) + this.mOrientationHelper.mo6970b(view)));
            } else {
                scrollToPositionWithOffset(targetPos, this.mOrientationHelper.mo6969b() - this.mOrientationHelper.mo6967a(target));
            }
        } else if (dropDirection == -1) {
            scrollToPositionWithOffset(targetPos, this.mOrientationHelper.mo6974d(target));
        } else {
            scrollToPositionWithOffset(targetPos, this.mOrientationHelper.mo6967a(target) - this.mOrientationHelper.mo6970b(view));
        }
    }
}
