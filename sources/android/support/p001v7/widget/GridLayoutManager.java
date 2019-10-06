package android.support.p001v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.p000v4.view.p038a.C0604b;
import android.support.p000v4.view.p038a.C0604b.C0606b;
import android.support.p001v7.widget.RecyclerView.C0981i;
import android.support.p001v7.widget.RecyclerView.C0981i.C0982a;
import android.support.p001v7.widget.RecyclerView.C0984j;
import android.support.p001v7.widget.RecyclerView.C0991p;
import android.support.p001v7.widget.RecyclerView.C0997t;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

/* renamed from: android.support.v7.widget.GridLayoutManager */
public class GridLayoutManager extends LinearLayoutManager {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_SPAN_COUNT = -1;
    private static final String TAG = "GridLayoutManager";
    int[] mCachedBorders;
    final Rect mDecorInsets = new Rect();
    boolean mPendingSpanCountChange = false;
    final SparseIntArray mPreLayoutSpanIndexCache = new SparseIntArray();
    final SparseIntArray mPreLayoutSpanSizeCache = new SparseIntArray();
    View[] mSet;
    int mSpanCount = -1;
    C0938c mSpanSizeLookup = new C0936a();

    /* renamed from: android.support.v7.widget.GridLayoutManager$a */
    public static final class C0936a extends C0938c {
        public int getSpanSize(int position) {
            return 1;
        }

        public int getSpanIndex(int position, int spanCount) {
            return position % spanCount;
        }
    }

    /* renamed from: android.support.v7.widget.GridLayoutManager$b */
    public static class C0937b extends C0984j {

        /* renamed from: e */
        int f2993e = -1;

        /* renamed from: f */
        int f2994f = 0;

        public C0937b(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        public C0937b(int width, int height) {
            super(width, height);
        }

        public C0937b(MarginLayoutParams source) {
            super(source);
        }

        public C0937b(LayoutParams source) {
            super(source);
        }

        /* renamed from: e */
        public int mo7276e() {
            return this.f2993e;
        }

        /* renamed from: f */
        public int mo7277f() {
            return this.f2994f;
        }
    }

    /* renamed from: android.support.v7.widget.GridLayoutManager$c */
    public static abstract class C0938c {
        private boolean mCacheSpanIndices = false;
        final SparseIntArray mSpanIndexCache = new SparseIntArray();

        public abstract int getSpanSize(int i);

        public void setSpanIndexCacheEnabled(boolean cacheSpanIndices) {
            this.mCacheSpanIndices = cacheSpanIndices;
        }

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        /* access modifiers changed from: 0000 */
        public int getCachedSpanIndex(int position, int spanCount) {
            if (!this.mCacheSpanIndices) {
                return getSpanIndex(position, spanCount);
            }
            int existing = this.mSpanIndexCache.get(position, -1);
            if (existing != -1) {
                return existing;
            }
            int value = getSpanIndex(position, spanCount);
            this.mSpanIndexCache.put(position, value);
            return value;
        }

        public int getSpanIndex(int position, int spanCount) {
            int span;
            int positionSpanSize = getSpanSize(position);
            if (positionSpanSize == spanCount) {
                return 0;
            }
            int span2 = 0;
            int startPos = 0;
            if (this.mCacheSpanIndices && this.mSpanIndexCache.size() > 0) {
                int prevKey = findReferenceIndexFromCache(position);
                if (prevKey >= 0) {
                    span2 = this.mSpanIndexCache.get(prevKey) + getSpanSize(prevKey);
                    startPos = prevKey + 1;
                }
            }
            for (int i = startPos; i < position; i++) {
                int size = getSpanSize(i);
                span += size;
                if (span == spanCount) {
                    span = 0;
                } else if (span > spanCount) {
                    span = size;
                }
            }
            if (span + positionSpanSize <= spanCount) {
                return span;
            }
            return 0;
        }

        /* access modifiers changed from: 0000 */
        public int findReferenceIndexFromCache(int position) {
            int lo = 0;
            int hi = this.mSpanIndexCache.size() - 1;
            while (lo <= hi) {
                int mid = (lo + hi) >>> 1;
                if (this.mSpanIndexCache.keyAt(mid) < position) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            int index = lo - 1;
            if (index < 0 || index >= this.mSpanIndexCache.size()) {
                return -1;
            }
            return this.mSpanIndexCache.keyAt(index);
        }

        public int getSpanGroupIndex(int adapterPosition, int spanCount) {
            int span = 0;
            int group = 0;
            int positionSpanSize = getSpanSize(adapterPosition);
            for (int i = 0; i < adapterPosition; i++) {
                int size = getSpanSize(i);
                span += size;
                if (span == spanCount) {
                    span = 0;
                    group++;
                } else if (span > spanCount) {
                    span = size;
                    group++;
                }
            }
            if (span + positionSpanSize > spanCount) {
                return group + 1;
            }
            return group;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setSpanCount(C0981i.getProperties(context, attrs, defStyleAttr, defStyleRes).f3187b);
    }

    public GridLayoutManager(Context context, int spanCount) {
        super(context);
        setSpanCount(spanCount);
    }

    public GridLayoutManager(Context context, int spanCount, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
        setSpanCount(spanCount);
    }

    public void setStackFromEnd(boolean stackFromEnd) {
        if (!stackFromEnd) {
            super.setStackFromEnd(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public int getRowCountForAccessibility(C0991p recycler, C0997t state) {
        if (this.mOrientation == 0) {
            return this.mSpanCount;
        }
        if (state.mo7945a() < 1) {
            return 0;
        }
        return getSpanGroupIndex(recycler, state, state.mo7945a() - 1) + 1;
    }

    public int getColumnCountForAccessibility(C0991p recycler, C0997t state) {
        if (this.mOrientation == 1) {
            return this.mSpanCount;
        }
        if (state.mo7945a() < 1) {
            return 0;
        }
        return getSpanGroupIndex(recycler, state, state.mo7945a() - 1) + 1;
    }

    public void onInitializeAccessibilityNodeInfoForItem(C0991p recycler, C0997t state, View host, C0604b info) {
        LayoutParams lp = host.getLayoutParams();
        if (!(lp instanceof C0937b)) {
            super.onInitializeAccessibilityNodeInfoForItem(host, info);
            return;
        }
        C0937b glp = (C0937b) lp;
        int spanGroupIndex = getSpanGroupIndex(recycler, state, glp.mo7864a());
        if (this.mOrientation == 0) {
            info.mo5588b((Object) C0606b.m2844a(glp.mo7276e(), glp.mo7277f(), spanGroupIndex, 1, this.mSpanCount > 1 && glp.mo7277f() == this.mSpanCount, false));
        } else {
            info.mo5588b((Object) C0606b.m2844a(spanGroupIndex, 1, glp.mo7276e(), glp.mo7277f(), this.mSpanCount > 1 && glp.mo7277f() == this.mSpanCount, false));
        }
    }

    public void onLayoutChildren(C0991p recycler, C0997t state) {
        if (state.mo7950d()) {
            cachePreLayoutSpanMapping();
        }
        super.onLayoutChildren(recycler, state);
        clearPreLayoutSpanMappingCache();
    }

    public void onLayoutCompleted(C0997t state) {
        super.onLayoutCompleted(state);
        this.mPendingSpanCountChange = false;
    }

    private void clearPreLayoutSpanMappingCache() {
        this.mPreLayoutSpanSizeCache.clear();
        this.mPreLayoutSpanIndexCache.clear();
    }

    private void cachePreLayoutSpanMapping() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            C0937b lp = (C0937b) getChildAt(i).getLayoutParams();
            int viewPosition = lp.mo7864a();
            this.mPreLayoutSpanSizeCache.put(viewPosition, lp.mo7277f());
            this.mPreLayoutSpanIndexCache.put(viewPosition, lp.mo7276e());
        }
    }

    public void onItemsAdded(RecyclerView recyclerView, int positionStart, int itemCount) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    public void onItemsRemoved(RecyclerView recyclerView, int positionStart, int itemCount) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    public void onItemsUpdated(RecyclerView recyclerView, int positionStart, int itemCount, Object payload) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    public void onItemsMoved(RecyclerView recyclerView, int from, int to, int itemCount) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    public C0984j generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new C0937b(-2, -1);
        }
        return new C0937b(-1, -2);
    }

    public C0984j generateLayoutParams(Context c, AttributeSet attrs) {
        return new C0937b(c, attrs);
    }

    public C0984j generateLayoutParams(LayoutParams lp) {
        if (lp instanceof MarginLayoutParams) {
            return new C0937b((MarginLayoutParams) lp);
        }
        return new C0937b(lp);
    }

    public boolean checkLayoutParams(C0984j lp) {
        return lp instanceof C0937b;
    }

    public void setSpanSizeLookup(C0938c spanSizeLookup) {
        this.mSpanSizeLookup = spanSizeLookup;
    }

    public C0938c getSpanSizeLookup() {
        return this.mSpanSizeLookup;
    }

    private void updateMeasurements() {
        int totalSpace;
        if (getOrientation() == 1) {
            totalSpace = (getWidth() - getPaddingRight()) - getPaddingLeft();
        } else {
            totalSpace = (getHeight() - getPaddingBottom()) - getPaddingTop();
        }
        calculateItemBorders(totalSpace);
    }

    public void setMeasuredDimension(Rect childrenBounds, int wSpec, int hSpec) {
        int width;
        int usedHeight;
        if (this.mCachedBorders == null) {
            super.setMeasuredDimension(childrenBounds, wSpec, hSpec);
        }
        int horizontalPadding = getPaddingLeft() + getPaddingRight();
        int verticalPadding = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            width = C0981i.chooseSize(hSpec, childrenBounds.height() + verticalPadding, getMinimumHeight());
            int[] iArr = this.mCachedBorders;
            usedHeight = C0981i.chooseSize(wSpec, iArr[iArr.length - 1] + horizontalPadding, getMinimumWidth());
        } else {
            int width2 = C0981i.chooseSize(wSpec, childrenBounds.width() + horizontalPadding, getMinimumWidth());
            int[] iArr2 = this.mCachedBorders;
            int i = width2;
            width = C0981i.chooseSize(hSpec, iArr2[iArr2.length - 1] + verticalPadding, getMinimumHeight());
            usedHeight = i;
        }
        setMeasuredDimension(usedHeight, width);
    }

    private void calculateItemBorders(int totalSpace) {
        this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, totalSpace);
    }

    static int[] calculateItemBorders(int[] cachedBorders, int spanCount, int totalSpace) {
        if (!(cachedBorders != null && cachedBorders.length == spanCount + 1 && cachedBorders[cachedBorders.length - 1] == totalSpace)) {
            cachedBorders = new int[(spanCount + 1)];
        }
        cachedBorders[0] = 0;
        int sizePerSpan = totalSpace / spanCount;
        int sizePerSpanRemainder = totalSpace % spanCount;
        int consumedPixels = 0;
        int additionalSize = 0;
        for (int i = 1; i <= spanCount; i++) {
            int itemSize = sizePerSpan;
            additionalSize += sizePerSpanRemainder;
            if (additionalSize > 0 && spanCount - additionalSize < sizePerSpanRemainder) {
                itemSize++;
                additionalSize -= spanCount;
            }
            consumedPixels += itemSize;
            cachedBorders[i] = consumedPixels;
        }
        return cachedBorders;
    }

    /* access modifiers changed from: 0000 */
    public int getSpaceForSpanRange(int startSpan, int spanSize) {
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            int[] iArr = this.mCachedBorders;
            return iArr[startSpan + spanSize] - iArr[startSpan];
        }
        int[] iArr2 = this.mCachedBorders;
        int i = this.mSpanCount;
        return iArr2[i - startSpan] - iArr2[(i - startSpan) - spanSize];
    }

    /* access modifiers changed from: 0000 */
    public void onAnchorReady(C0991p recycler, C0997t state, C0955a anchorInfo, int itemDirection) {
        super.onAnchorReady(recycler, state, anchorInfo, itemDirection);
        updateMeasurements();
        if (state.mo7945a() > 0 && !state.mo7950d()) {
            ensureAnchorIsInCorrectSpan(recycler, state, anchorInfo, itemDirection);
        }
        ensureViewSet();
    }

    private void ensureViewSet() {
        View[] viewArr = this.mSet;
        if (viewArr == null || viewArr.length != this.mSpanCount) {
            this.mSet = new View[this.mSpanCount];
        }
    }

    public int scrollHorizontallyBy(int dx, C0991p recycler, C0997t state) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollHorizontallyBy(dx, recycler, state);
    }

    public int scrollVerticallyBy(int dy, C0991p recycler, C0997t state) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollVerticallyBy(dy, recycler, state);
    }

    private void ensureAnchorIsInCorrectSpan(C0991p recycler, C0997t state, C0955a anchorInfo, int itemDirection) {
        boolean layingOutInPrimaryDirection = itemDirection == 1;
        int span = getSpanIndex(recycler, state, anchorInfo.f3029b);
        if (layingOutInPrimaryDirection) {
            while (span > 0) {
                int i = anchorInfo.f3029b;
                if (i > 0) {
                    anchorInfo.f3029b = i - 1;
                    span = getSpanIndex(recycler, state, anchorInfo.f3029b);
                } else {
                    return;
                }
            }
            return;
        }
        int indexLimit = state.mo7945a() - 1;
        int pos = anchorInfo.f3029b;
        int bestSpan = span;
        while (pos < indexLimit) {
            int next = getSpanIndex(recycler, state, pos + 1);
            if (next <= bestSpan) {
                break;
            }
            pos++;
            bestSpan = next;
        }
        anchorInfo.f3029b = pos;
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
            if (position >= 0 && position < itemCount && getSpanIndex(recycler, state, position) == 0) {
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

    private int getSpanGroupIndex(C0991p recycler, C0997t state, int viewPosition) {
        if (!state.mo7950d()) {
            return this.mSpanSizeLookup.getSpanGroupIndex(viewPosition, this.mSpanCount);
        }
        int adapterPosition = recycler.mo7887a(viewPosition);
        if (adapterPosition != -1) {
            return this.mSpanSizeLookup.getSpanGroupIndex(adapterPosition, this.mSpanCount);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot find span size for pre layout position. ");
        sb.append(viewPosition);
        Log.w(TAG, sb.toString());
        return 0;
    }

    private int getSpanIndex(C0991p recycler, C0997t state, int pos) {
        if (!state.mo7950d()) {
            return this.mSpanSizeLookup.getCachedSpanIndex(pos, this.mSpanCount);
        }
        int cached = this.mPreLayoutSpanIndexCache.get(pos, -1);
        if (cached != -1) {
            return cached;
        }
        int adapterPosition = recycler.mo7887a(pos);
        if (adapterPosition != -1) {
            return this.mSpanSizeLookup.getCachedSpanIndex(adapterPosition, this.mSpanCount);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
        sb.append(pos);
        Log.w(TAG, sb.toString());
        return 0;
    }

    private int getSpanSize(C0991p recycler, C0997t state, int pos) {
        if (!state.mo7950d()) {
            return this.mSpanSizeLookup.getSpanSize(pos);
        }
        int cached = this.mPreLayoutSpanSizeCache.get(pos, -1);
        if (cached != -1) {
            return cached;
        }
        int adapterPosition = recycler.mo7887a(pos);
        if (adapterPosition != -1) {
            return this.mSpanSizeLookup.getSpanSize(adapterPosition);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
        sb.append(pos);
        Log.w(TAG, sb.toString());
        return 1;
    }

    /* access modifiers changed from: 0000 */
    public void collectPrefetchPositionsForLayoutState(C0997t state, C0957c layoutState, C0982a layoutPrefetchRegistry) {
        int remainingSpan = this.mSpanCount;
        for (int count = 0; count < this.mSpanCount && layoutState.mo7413a(state) && remainingSpan > 0; count++) {
            int pos = layoutState.f3040d;
            layoutPrefetchRegistry.mo7863a(pos, Math.max(0, layoutState.f3043g));
            remainingSpan -= this.mSpanSizeLookup.getSpanSize(pos);
            layoutState.f3040d += layoutState.f3041e;
        }
    }

    /* access modifiers changed from: 0000 */
    public void layoutChunk(C0991p recycler, C0997t state, C0957c layoutState, C0956b result) {
        int consumedSpanCount;
        int itemSpanSize;
        int maxSize;
        int bottom;
        int right;
        int left;
        int top;
        int otherDirSpecMode;
        float maxSizeInOther;
        int remainingSpan;
        int hSpec;
        int wSpec;
        C0991p pVar = recycler;
        C0997t tVar = state;
        C0957c cVar = layoutState;
        C0956b bVar = result;
        int otherDirSpecMode2 = this.mOrientationHelper.mo6975e();
        boolean z = false;
        boolean flexibleInOtherDir = otherDirSpecMode2 != 1073741824;
        int currentOtherDirSize = getChildCount() > 0 ? this.mCachedBorders[this.mSpanCount] : 0;
        if (flexibleInOtherDir) {
            updateMeasurements();
        }
        boolean layingOutInPrimaryDirection = cVar.f3041e == 1;
        int remainingSpan2 = this.mSpanCount;
        if (!layingOutInPrimaryDirection) {
            remainingSpan2 = getSpanIndex(pVar, tVar, cVar.f3040d) + getSpanSize(pVar, tVar, cVar.f3040d);
            itemSpanSize = 0;
            consumedSpanCount = 0;
        } else {
            itemSpanSize = 0;
            consumedSpanCount = 0;
        }
        while (itemSpanSize < this.mSpanCount && cVar.mo7413a(tVar) && remainingSpan2 > 0) {
            int pos = cVar.f3040d;
            int spanSize = getSpanSize(pVar, tVar, pos);
            if (spanSize <= this.mSpanCount) {
                remainingSpan2 -= spanSize;
                if (remainingSpan2 < 0) {
                    break;
                }
                View view = cVar.mo7410a(pVar);
                if (view == null) {
                    break;
                }
                consumedSpanCount += spanSize;
                this.mSet[itemSpanSize] = view;
                itemSpanSize++;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Item at position ");
                sb.append(pos);
                sb.append(" requires ");
                sb.append(spanSize);
                sb.append(" spans but GridLayoutManager has only ");
                sb.append(this.mSpanCount);
                sb.append(" spans.");
                throw new IllegalArgumentException(sb.toString());
            }
        }
        int remainingSpan3 = remainingSpan2;
        if (itemSpanSize == 0) {
            bVar.f3034b = true;
            return;
        }
        int count = itemSpanSize;
        int currentOtherDirSize2 = currentOtherDirSize;
        assignSpans(recycler, state, itemSpanSize, consumedSpanCount, layingOutInPrimaryDirection);
        int i = 0;
        int maxSize2 = 0;
        float maxSizeInOther2 = 0.0f;
        while (i < count) {
            View view2 = this.mSet[i];
            if (cVar.f3047k == null) {
                if (layingOutInPrimaryDirection) {
                    addView(view2);
                } else {
                    addView(view2, z);
                }
            } else if (layingOutInPrimaryDirection) {
                addDisappearingView(view2);
            } else {
                addDisappearingView(view2, z ? 1 : 0);
            }
            calculateItemDecorationsForChild(view2, this.mDecorInsets);
            measureChild(view2, otherDirSpecMode2, z);
            int size = this.mOrientationHelper.mo6970b(view2);
            if (size > maxSize2) {
                maxSize2 = size;
            }
            int maxSize3 = maxSize2;
            float otherSize = (((float) this.mOrientationHelper.mo6972c(view2)) * 1.0f) / ((float) ((C0937b) view2.getLayoutParams()).f2994f);
            if (otherSize > maxSizeInOther2) {
                maxSizeInOther2 = otherSize;
            }
            i++;
            maxSize2 = maxSize3;
            z = false;
        }
        if (flexibleInOtherDir) {
            guessMeasurement(maxSizeInOther2, currentOtherDirSize2);
            int maxSize4 = 0;
            for (int i2 = 0; i2 < count; i2++) {
                View view3 = this.mSet[i2];
                measureChild(view3, 1073741824, true);
                int size2 = this.mOrientationHelper.mo6970b(view3);
                if (size2 > maxSize4) {
                    maxSize4 = size2;
                }
            }
            maxSize = maxSize4;
        } else {
            maxSize = maxSize2;
        }
        int i3 = 0;
        while (i3 < count) {
            View view4 = this.mSet[i3];
            if (this.mOrientationHelper.mo6970b(view4) != maxSize) {
                C0937b lp = (C0937b) view4.getLayoutParams();
                Rect decorInsets = lp.f3191b;
                maxSizeInOther = maxSizeInOther2;
                int verticalInsets = decorInsets.top + decorInsets.bottom + lp.topMargin + lp.bottomMargin;
                int horizontalInsets = decorInsets.left + decorInsets.right + lp.leftMargin + lp.rightMargin;
                Rect rect = decorInsets;
                int totalSpaceInOther = getSpaceForSpanRange(lp.f2993e, lp.f2994f);
                otherDirSpecMode = otherDirSpecMode2;
                if (this.mOrientation == 1) {
                    remainingSpan = remainingSpan3;
                    wSpec = C0981i.getChildMeasureSpec(totalSpaceInOther, 1073741824, horizontalInsets, lp.width, false);
                    hSpec = MeasureSpec.makeMeasureSpec(maxSize - verticalInsets, 1073741824);
                    C0937b bVar2 = lp;
                } else {
                    remainingSpan = remainingSpan3;
                    wSpec = MeasureSpec.makeMeasureSpec(maxSize - horizontalInsets, 1073741824);
                    C0937b bVar3 = lp;
                    hSpec = C0981i.getChildMeasureSpec(totalSpaceInOther, 1073741824, verticalInsets, lp.height, false);
                }
                measureChildWithDecorationsAndMargin(view4, wSpec, hSpec, true);
            } else {
                maxSizeInOther = maxSizeInOther2;
                otherDirSpecMode = otherDirSpecMode2;
                remainingSpan = remainingSpan3;
            }
            i3++;
            C0991p pVar2 = recycler;
            C0997t tVar2 = state;
            remainingSpan3 = remainingSpan;
            maxSizeInOther2 = maxSizeInOther;
            otherDirSpecMode2 = otherDirSpecMode;
        }
        int i4 = otherDirSpecMode2;
        int i5 = remainingSpan3;
        bVar.f3033a = maxSize;
        int left2 = 0;
        int right2 = 0;
        int top2 = 0;
        int bottom2 = 0;
        if (this.mOrientation == 1) {
            if (cVar.f3042f == -1) {
                bottom2 = cVar.f3038b;
                top2 = bottom2 - maxSize;
            } else {
                top2 = cVar.f3038b;
                bottom2 = top2 + maxSize;
            }
        } else if (cVar.f3042f == -1) {
            right2 = cVar.f3038b;
            left2 = right2 - maxSize;
        } else {
            left2 = cVar.f3038b;
            right2 = left2 + maxSize;
        }
        int i6 = 0;
        while (i6 < count) {
            View view5 = this.mSet[i6];
            C0937b params = (C0937b) view5.getLayoutParams();
            if (this.mOrientation != 1) {
                left = left2;
                right = right2;
                int top3 = getPaddingTop() + this.mCachedBorders[params.f2993e];
                top = top3;
                bottom = this.mOrientationHelper.mo6972c(view5) + top3;
            } else if (isLayoutRTL()) {
                int i7 = left2;
                int i8 = right2;
                int right3 = getPaddingLeft() + this.mCachedBorders[this.mSpanCount - params.f2993e];
                left = right3 - this.mOrientationHelper.mo6972c(view5);
                top = top2;
                bottom = bottom2;
                right = right3;
            } else {
                int i9 = left2;
                int i10 = right2;
                int left3 = getPaddingLeft() + this.mCachedBorders[params.f2993e];
                left = left3;
                right = this.mOrientationHelper.mo6972c(view5) + left3;
                top = top2;
                bottom = bottom2;
            }
            int maxSize5 = maxSize;
            layoutDecoratedWithMargins(view5, left, top, right, bottom);
            if (params.mo7866c() || params.mo7865b()) {
                bVar.f3035c = true;
            }
            bVar.f3036d |= view5.hasFocusable();
            i6++;
            top2 = top;
            left2 = left;
            right2 = right;
            bottom2 = bottom;
            maxSize = maxSize5;
        }
        int i11 = right2;
        int i12 = maxSize;
        Arrays.fill(this.mSet, null);
    }

    private void measureChild(View view, int otherDirParentSpecMode, boolean alreadyMeasured) {
        int hSpec;
        int wSpec;
        C0937b lp = (C0937b) view.getLayoutParams();
        Rect decorInsets = lp.f3191b;
        int verticalInsets = decorInsets.top + decorInsets.bottom + lp.topMargin + lp.bottomMargin;
        int horizontalInsets = decorInsets.left + decorInsets.right + lp.leftMargin + lp.rightMargin;
        int availableSpaceInOther = getSpaceForSpanRange(lp.f2993e, lp.f2994f);
        if (this.mOrientation == 1) {
            wSpec = C0981i.getChildMeasureSpec(availableSpaceInOther, otherDirParentSpecMode, horizontalInsets, lp.width, false);
            hSpec = C0981i.getChildMeasureSpec(this.mOrientationHelper.mo6979g(), getHeightMode(), verticalInsets, lp.height, true);
        } else {
            hSpec = C0981i.getChildMeasureSpec(availableSpaceInOther, otherDirParentSpecMode, verticalInsets, lp.height, false);
            wSpec = C0981i.getChildMeasureSpec(this.mOrientationHelper.mo6979g(), getWidthMode(), horizontalInsets, lp.width, true);
        }
        measureChildWithDecorationsAndMargin(view, wSpec, hSpec, alreadyMeasured);
    }

    private void guessMeasurement(float maxSizeInOther, int currentOtherDirSize) {
        calculateItemBorders(Math.max(Math.round(((float) this.mSpanCount) * maxSizeInOther), currentOtherDirSize));
    }

    private void measureChildWithDecorationsAndMargin(View child, int widthSpec, int heightSpec, boolean alreadyMeasured) {
        boolean measure;
        C0984j lp = (C0984j) child.getLayoutParams();
        if (alreadyMeasured) {
            measure = shouldReMeasureChild(child, widthSpec, heightSpec, lp);
        } else {
            measure = shouldMeasureChild(child, widthSpec, heightSpec, lp);
        }
        if (measure) {
            child.measure(widthSpec, heightSpec);
        }
    }

    private void assignSpans(C0991p recycler, C0997t state, int count, int consumedSpanCount, boolean layingOutInPrimaryDirection) {
        int diff;
        int end;
        int start;
        if (layingOutInPrimaryDirection) {
            start = 0;
            end = count;
            diff = 1;
        } else {
            start = count - 1;
            end = -1;
            diff = -1;
        }
        int span = 0;
        for (int i = start; i != end; i += diff) {
            View view = this.mSet[i];
            C0937b params = (C0937b) view.getLayoutParams();
            params.f2994f = getSpanSize(recycler, state, getPosition(view));
            params.f2993e = span;
            span += params.f2994f;
        }
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public void setSpanCount(int spanCount) {
        if (spanCount != this.mSpanCount) {
            this.mPendingSpanCountChange = true;
            if (spanCount >= 1) {
                this.mSpanCount = spanCount;
                this.mSpanSizeLookup.invalidateSpanIndexCache();
                requestLayout();
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Span count should be at least 1. Provided ");
            sb.append(spanCount);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public View onFocusSearchFailed(View focused, int focusDirection, C0991p recycler, C0997t state) {
        int limit;
        int inc;
        int start;
        int focusableSpanGroupIndex;
        View prevFocusedChild;
        int focusableWeakCandidateOverlap;
        int focusableWeakCandidateSpanIndex;
        boolean assignAsWeek;
        boolean focusableWeakCandidateSpanIndex2;
        C0991p pVar = recycler;
        C0997t tVar = state;
        View prevFocusedChild2 = findContainingItemView(focused);
        if (prevFocusedChild2 == null) {
            return null;
        }
        C0937b lp = (C0937b) prevFocusedChild2.getLayoutParams();
        int prevSpanStart = lp.f2993e;
        int prevSpanEnd = lp.f2993e + lp.f2994f;
        View view = super.onFocusSearchFailed(focused, focusDirection, recycler, state);
        if (view == null) {
            return null;
        }
        int layoutDir = convertFocusDirectionToLayoutDirection(focusDirection);
        int ascend = (layoutDir == 1) != this.mShouldReverseLayout;
        if (ascend != 0) {
            start = getChildCount() - 1;
            inc = -1;
            limit = -1;
        } else {
            start = 0;
            inc = 1;
            limit = getChildCount();
        }
        boolean preferLastSpan = this.mOrientation == 1 && isLayoutRTL();
        View focusableWeakCandidate = null;
        View unfocusableWeakCandidate = null;
        int focusableSpanGroupIndex2 = getSpanGroupIndex(pVar, tVar, start);
        int i = start;
        C0937b bVar = lp;
        int focusableWeakCandidateSpanIndex3 = -1;
        View view2 = view;
        int focusableWeakCandidateOverlap2 = 0;
        int unfocusableWeakCandidateSpanIndex = layoutDir;
        int unfocusableWeakCandidateSpanIndex2 = -1;
        int unfocusableWeakCandidateOverlap = ascend;
        int unfocusableWeakCandidateOverlap2 = 0;
        while (true) {
            if (i == limit) {
                int i2 = focusableWeakCandidateSpanIndex3;
                int i3 = focusableWeakCandidateOverlap2;
                int i4 = focusableSpanGroupIndex2;
                int i5 = start;
                break;
            }
            int start2 = start;
            int spanGroupIndex = getSpanGroupIndex(pVar, tVar, i);
            View candidate = getChildAt(i);
            if (candidate == prevFocusedChild2) {
                View view3 = prevFocusedChild2;
                int i6 = focusableWeakCandidateSpanIndex3;
                int i7 = focusableWeakCandidateOverlap2;
                int i8 = focusableSpanGroupIndex2;
                break;
            }
            if (!candidate.hasFocusable() || spanGroupIndex == focusableSpanGroupIndex2) {
                C0937b candidateLp = (C0937b) candidate.getLayoutParams();
                prevFocusedChild = prevFocusedChild2;
                int candidateStart = candidateLp.f2993e;
                focusableSpanGroupIndex = focusableSpanGroupIndex2;
                int i9 = spanGroupIndex;
                int candidateEnd = candidateLp.f2993e + candidateLp.f2994f;
                if (candidate.hasFocusable() && candidateStart == prevSpanStart && candidateEnd == prevSpanEnd) {
                    return candidate;
                }
                if ((!candidate.hasFocusable() || focusableWeakCandidate != null) && (candidate.hasFocusable() || unfocusableWeakCandidate != null)) {
                    assignAsWeek = false;
                    int overlap = Math.min(candidateEnd, prevSpanEnd) - Math.max(candidateStart, prevSpanStart);
                    if (!candidate.hasFocusable()) {
                        focusableWeakCandidateSpanIndex = focusableWeakCandidateSpanIndex3;
                        if (focusableWeakCandidate == null) {
                            focusableWeakCandidateOverlap = focusableWeakCandidateOverlap2;
                            boolean z = false;
                            if (isViewPartiallyVisible(candidate, false, true)) {
                                if (overlap > unfocusableWeakCandidateOverlap2) {
                                    assignAsWeek = true;
                                } else if (overlap == unfocusableWeakCandidateOverlap2) {
                                    if (candidateStart > unfocusableWeakCandidateSpanIndex2) {
                                        z = true;
                                    }
                                    if (preferLastSpan == z) {
                                        assignAsWeek = true;
                                    }
                                }
                            }
                        } else {
                            focusableWeakCandidateOverlap = focusableWeakCandidateOverlap2;
                        }
                    } else if (overlap > focusableWeakCandidateOverlap2) {
                        assignAsWeek = true;
                        focusableWeakCandidateSpanIndex = focusableWeakCandidateSpanIndex3;
                        focusableWeakCandidateOverlap = focusableWeakCandidateOverlap2;
                    } else {
                        if (overlap == focusableWeakCandidateOverlap2) {
                            if (candidateStart > focusableWeakCandidateSpanIndex3) {
                                focusableWeakCandidateSpanIndex = focusableWeakCandidateSpanIndex3;
                                focusableWeakCandidateSpanIndex2 = true;
                            } else {
                                focusableWeakCandidateSpanIndex = focusableWeakCandidateSpanIndex3;
                                focusableWeakCandidateSpanIndex2 = false;
                            }
                            if (preferLastSpan == focusableWeakCandidateSpanIndex2) {
                                assignAsWeek = true;
                                focusableWeakCandidateOverlap = focusableWeakCandidateOverlap2;
                            }
                        } else {
                            focusableWeakCandidateSpanIndex = focusableWeakCandidateSpanIndex3;
                        }
                        focusableWeakCandidateOverlap = focusableWeakCandidateOverlap2;
                    }
                } else {
                    focusableWeakCandidateSpanIndex = focusableWeakCandidateSpanIndex3;
                    focusableWeakCandidateOverlap = focusableWeakCandidateOverlap2;
                    assignAsWeek = true;
                }
                if (assignAsWeek) {
                    if (candidate.hasFocusable()) {
                        focusableWeakCandidateOverlap = Math.min(candidateEnd, prevSpanEnd) - Math.max(candidateStart, prevSpanStart);
                        focusableWeakCandidate = candidate;
                        focusableWeakCandidateSpanIndex3 = candidateLp.f2993e;
                    } else {
                        View unfocusableWeakCandidate2 = candidate;
                        unfocusableWeakCandidateSpanIndex2 = candidateLp.f2993e;
                        unfocusableWeakCandidate = unfocusableWeakCandidate2;
                        unfocusableWeakCandidateOverlap2 = Math.min(candidateEnd, prevSpanEnd) - Math.max(candidateStart, prevSpanStart);
                        focusableWeakCandidateSpanIndex3 = focusableWeakCandidateSpanIndex;
                    }
                    i += inc;
                    pVar = recycler;
                    tVar = state;
                    focusableWeakCandidateOverlap2 = focusableWeakCandidateOverlap;
                    start = start2;
                    prevFocusedChild2 = prevFocusedChild;
                    focusableSpanGroupIndex2 = focusableSpanGroupIndex;
                }
            } else if (focusableWeakCandidate != null) {
                View view4 = prevFocusedChild2;
                int i10 = focusableWeakCandidateSpanIndex3;
                int i11 = focusableWeakCandidateOverlap2;
                int i12 = focusableSpanGroupIndex2;
                break;
            } else {
                prevFocusedChild = prevFocusedChild2;
                focusableWeakCandidateSpanIndex = focusableWeakCandidateSpanIndex3;
                focusableWeakCandidateOverlap = focusableWeakCandidateOverlap2;
                focusableSpanGroupIndex = focusableSpanGroupIndex2;
            }
            focusableWeakCandidateSpanIndex3 = focusableWeakCandidateSpanIndex;
            i += inc;
            pVar = recycler;
            tVar = state;
            focusableWeakCandidateOverlap2 = focusableWeakCandidateOverlap;
            start = start2;
            prevFocusedChild2 = prevFocusedChild;
            focusableSpanGroupIndex2 = focusableSpanGroupIndex;
        }
        return focusableWeakCandidate != null ? focusableWeakCandidate : unfocusableWeakCandidate;
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.mPendingSpanCountChange;
    }
}
