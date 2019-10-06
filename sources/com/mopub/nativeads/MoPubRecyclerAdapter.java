package com.mopub.nativeads;

import android.app.Activity;
import android.support.p001v7.widget.LinearLayoutManager;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.RecyclerView.C0970a;
import android.support.p001v7.widget.RecyclerView.C0972c;
import android.support.p001v7.widget.RecyclerView.C0981i;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.VisibilityTracker;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubServerPositioning;
import java.util.List;
import java.util.WeakHashMap;

public final class MoPubRecyclerAdapter extends C0970a<C1000w> {

    /* renamed from: a */
    private final C0972c f35881a;

    /* renamed from: b */
    private RecyclerView f35882b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final MoPubStreamAdPlacer f35883c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C0970a f35884d;

    /* renamed from: e */
    private final VisibilityTracker f35885e;

    /* renamed from: f */
    private final WeakHashMap<View, Integer> f35886f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ContentChangeStrategy f35887g;

    /* renamed from: h */
    private MoPubNativeAdLoadedListener f35888h;

    public enum ContentChangeStrategy {
        INSERT_AT_END,
        MOVE_ALL_ADS_WITH_CONTENT,
        KEEP_ADS_FIXED
    }

    public MoPubRecyclerAdapter(Activity activity, C0970a originalAdapter) {
        this(activity, originalAdapter, MoPubNativeAdPositioning.serverPositioning());
    }

    public MoPubRecyclerAdapter(Activity activity, C0970a originalAdapter, MoPubServerPositioning adPositioning) {
        this(new MoPubStreamAdPlacer(activity, adPositioning), originalAdapter, new VisibilityTracker(activity));
    }

    public MoPubRecyclerAdapter(Activity activity, C0970a originalAdapter, MoPubClientPositioning adPositioning) {
        this(new MoPubStreamAdPlacer(activity, adPositioning), originalAdapter, new VisibilityTracker(activity));
    }

    @VisibleForTesting
    MoPubRecyclerAdapter(MoPubStreamAdPlacer streamAdPlacer, C0970a originalAdapter, VisibilityTracker visibilityTracker) {
        this.f35887g = ContentChangeStrategy.INSERT_AT_END;
        this.f35886f = new WeakHashMap<>();
        this.f35884d = originalAdapter;
        this.f35885e = visibilityTracker;
        this.f35885e.setVisibilityTrackerListener(new C11588ba(this));
        m38285a(this.f35884d.hasStableIds());
        this.f35883c = streamAdPlacer;
        this.f35883c.setAdLoadedListener(new C11591ca(this));
        this.f35883c.setItemCount(this.f35884d.getItemCount());
        this.f35881a = new C11594da(this);
        this.f35884d.registerAdapterDataObserver(this.f35881a);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f35882b = recyclerView;
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.f35882b = null;
    }

    public void setAdLoadedListener(MoPubNativeAdLoadedListener listener) {
        this.f35888h = listener;
    }

    public void registerAdRenderer(MoPubAdRenderer adRenderer) {
        if (NoThrow.checkNotNull(adRenderer, "Cannot register a null adRenderer")) {
            this.f35883c.registerAdRenderer(adRenderer);
        }
    }

    public void loadAds(String adUnitId) {
        this.f35883c.loadAds(adUnitId);
    }

    public void loadAds(String adUnitId, RequestParameters requestParameters) {
        this.f35883c.loadAds(adUnitId, requestParameters);
    }

    public static int computeScrollOffset(LinearLayoutManager linearLayoutManager, C1000w holder) {
        if (holder == null) {
            return 0;
        }
        View view = holder.itemView;
        int offset = 0;
        if (linearLayoutManager.canScrollVertically()) {
            if (linearLayoutManager.getStackFromEnd()) {
                offset = view.getBottom();
            } else {
                offset = view.getTop();
            }
        } else if (linearLayoutManager.canScrollHorizontally()) {
            if (linearLayoutManager.getStackFromEnd()) {
                offset = view.getRight();
            } else {
                offset = view.getLeft();
            }
        }
        return offset;
    }

    public void refreshAds(String adUnitId) {
        refreshAds(adUnitId, null);
    }

    public void refreshAds(String adUnitId, RequestParameters requestParameters) {
        RecyclerView recyclerView = this.f35882b;
        if (recyclerView == null) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "This adapter is not attached to a RecyclerView and cannot be refreshed.");
            return;
        }
        C0981i layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Can't refresh ads when there is no layout manager on a RecyclerView.");
            return;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int firstPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int scrollOffset = computeScrollOffset(linearLayoutManager, this.f35882b.mo7555c(firstPosition));
            int startOfRange = Math.max(0, firstPosition - 1);
            while (this.f35883c.isAd(startOfRange) && startOfRange > 0) {
                startOfRange--;
            }
            int itemCount = getItemCount();
            int endOfRange = linearLayoutManager.findLastVisibleItemPosition();
            while (this.f35883c.isAd(endOfRange) && endOfRange < itemCount - 1) {
                endOfRange++;
            }
            int originalStartOfRange = this.f35883c.getOriginalPosition(startOfRange);
            this.f35883c.removeAdsInRange(this.f35883c.getOriginalPosition(endOfRange), this.f35884d.getItemCount());
            int numAdsRemoved = this.f35883c.removeAdsInRange(0, originalStartOfRange);
            if (numAdsRemoved > 0) {
                linearLayoutManager.scrollToPositionWithOffset(firstPosition - numAdsRemoved, scrollOffset);
            }
            loadAds(adUnitId, requestParameters);
        } else {
            MoPubLog.log(SdkLogEvent.CUSTOM, "This LayoutManager can't be refreshed.");
        }
    }

    public void clearAds() {
        this.f35883c.clearAds();
    }

    public boolean isAd(int position) {
        return this.f35883c.isAd(position);
    }

    public int getAdjustedPosition(int originalPosition) {
        return this.f35883c.getAdjustedPosition(originalPosition);
    }

    public int getOriginalPosition(int position) {
        return this.f35883c.getOriginalPosition(position);
    }

    public void setContentChangeStrategy(ContentChangeStrategy strategy) {
        if (NoThrow.checkNotNull(strategy)) {
            this.f35887g = strategy;
        }
    }

    public int getItemCount() {
        return this.f35883c.getAdjustedCount(this.f35884d.getItemCount());
    }

    public C1000w onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType < -56 || viewType > this.f35883c.getAdViewTypeCount() - 56) {
            return this.f35884d.onCreateViewHolder(parent, viewType);
        }
        MoPubAdRenderer adRenderer = this.f35883c.getAdRendererForViewType(viewType + 56);
        if (adRenderer != null) {
            return new MoPubRecyclerViewHolder(adRenderer.createAdView((Activity) parent.getContext(), parent));
        }
        MoPubLog.log(SdkLogEvent.CUSTOM, "No view binder was registered for ads in MoPubRecyclerAdapter.");
        return null;
    }

    public void onBindViewHolder(C1000w holder, int position) {
        Object adResponse = this.f35883c.getAdData(position);
        if (adResponse != null) {
            this.f35883c.bindAdView((NativeAd) adResponse, holder.itemView);
            return;
        }
        this.f35886f.put(holder.itemView, Integer.valueOf(position));
        this.f35885e.addView(holder.itemView, 0, null);
        this.f35884d.onBindViewHolder(holder, this.f35883c.getOriginalPosition(position));
    }

    public int getItemViewType(int position) {
        int type = this.f35883c.getAdViewType(position);
        if (type != 0) {
            return type - 56;
        }
        return this.f35884d.getItemViewType(this.f35883c.getOriginalPosition(position));
    }

    public void setHasStableIds(boolean hasStableIds) {
        m38285a(hasStableIds);
        this.f35884d.unregisterAdapterDataObserver(this.f35881a);
        this.f35884d.setHasStableIds(hasStableIds);
        this.f35884d.registerAdapterDataObserver(this.f35881a);
    }

    public void destroy() {
        this.f35884d.unregisterAdapterDataObserver(this.f35881a);
        this.f35883c.destroy();
        this.f35885e.destroy();
    }

    public long getItemId(int position) {
        if (!this.f35884d.hasStableIds()) {
            return -1;
        }
        Object adData = this.f35883c.getAdData(position);
        if (adData != null) {
            return (long) (-System.identityHashCode(adData));
        }
        return this.f35884d.getItemId(this.f35883c.getOriginalPosition(position));
    }

    public boolean onFailedToRecycleView(C1000w holder) {
        if (holder instanceof MoPubRecyclerViewHolder) {
            return super.onFailedToRecycleView(holder);
        }
        return this.f35884d.onFailedToRecycleView(holder);
    }

    public void onViewAttachedToWindow(C1000w holder) {
        if (holder instanceof MoPubRecyclerViewHolder) {
            super.onViewAttachedToWindow(holder);
        } else {
            this.f35884d.onViewAttachedToWindow(holder);
        }
    }

    public void onViewDetachedFromWindow(C1000w holder) {
        if (holder instanceof MoPubRecyclerViewHolder) {
            super.onViewDetachedFromWindow(holder);
        } else {
            this.f35884d.onViewDetachedFromWindow(holder);
        }
    }

    public void onViewRecycled(C1000w holder) {
        if (holder instanceof MoPubRecyclerViewHolder) {
            super.onViewRecycled(holder);
        } else {
            this.f35884d.onViewRecycled(holder);
        }
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public void mo37946a(int position) {
        MoPubNativeAdLoadedListener moPubNativeAdLoadedListener = this.f35888h;
        if (moPubNativeAdLoadedListener != null) {
            moPubNativeAdLoadedListener.onAdLoaded(position);
        }
        notifyItemInserted(position);
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: b */
    public void mo37947b(int position) {
        MoPubNativeAdLoadedListener moPubNativeAdLoadedListener = this.f35888h;
        if (moPubNativeAdLoadedListener != null) {
            moPubNativeAdLoadedListener.onAdRemoved(position);
        }
        notifyItemRemoved(position);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38284a(List<View> visibleViews, List<View> list) {
        int min = MoPubClientPositioning.NO_REPEAT;
        int max = 0;
        for (View view : visibleViews) {
            Integer pos = (Integer) this.f35886f.get(view);
            if (pos != null) {
                min = Math.min(pos.intValue(), min);
                max = Math.max(pos.intValue(), max);
            }
        }
        this.f35883c.placeAdsInRange(min, max + 1);
    }

    /* renamed from: a */
    private void m38285a(boolean hasStableIds) {
        super.setHasStableIds(hasStableIds);
    }
}
