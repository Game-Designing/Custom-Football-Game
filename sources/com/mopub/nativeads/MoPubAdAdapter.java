package com.mopub.nativeads;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.VisibilityTracker;
import com.mopub.common.VisibleForTesting;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubServerPositioning;
import java.util.List;
import java.util.WeakHashMap;

public class MoPubAdAdapter extends BaseAdapter {

    /* renamed from: a */
    private final WeakHashMap<View, Integer> f35814a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Adapter f35815b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final MoPubStreamAdPlacer f35816c;

    /* renamed from: d */
    private final VisibilityTracker f35817d;

    /* renamed from: e */
    private MoPubNativeAdLoadedListener f35818e;

    public MoPubAdAdapter(Activity activity, Adapter originalAdapter) {
        this(activity, originalAdapter, MoPubNativeAdPositioning.serverPositioning());
    }

    public MoPubAdAdapter(Activity activity, Adapter originalAdapter, MoPubServerPositioning adPositioning) {
        this(new MoPubStreamAdPlacer(activity, adPositioning), originalAdapter, new VisibilityTracker(activity));
    }

    public MoPubAdAdapter(Activity activity, Adapter originalAdapter, MoPubClientPositioning adPositioning) {
        this(new MoPubStreamAdPlacer(activity, adPositioning), originalAdapter, new VisibilityTracker(activity));
    }

    @VisibleForTesting
    MoPubAdAdapter(MoPubStreamAdPlacer streamAdPlacer, Adapter originalAdapter, VisibilityTracker visibilityTracker) {
        this.f35815b = originalAdapter;
        this.f35816c = streamAdPlacer;
        this.f35814a = new WeakHashMap<>();
        this.f35817d = visibilityTracker;
        this.f35817d.setVisibilityTrackerListener(new C11524F(this));
        this.f35815b.registerDataSetObserver(new C11526G(this));
        this.f35816c.setAdLoadedListener(new C11530H(this));
        this.f35816c.setItemCount(this.f35815b.getCount());
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public void mo37882a(int position) {
        MoPubNativeAdLoadedListener moPubNativeAdLoadedListener = this.f35818e;
        if (moPubNativeAdLoadedListener != null) {
            moPubNativeAdLoadedListener.onAdLoaded(position);
        }
        notifyDataSetChanged();
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: b */
    public void mo37884b(int position) {
        MoPubNativeAdLoadedListener moPubNativeAdLoadedListener = this.f35818e;
        if (moPubNativeAdLoadedListener != null) {
            moPubNativeAdLoadedListener.onAdRemoved(position);
        }
        notifyDataSetChanged();
    }

    public final void registerAdRenderer(MoPubAdRenderer adRenderer) {
        if (NoThrow.checkNotNull(adRenderer, "Tried to set a null ad renderer on the placer.")) {
            this.f35816c.registerAdRenderer(adRenderer);
        }
    }

    public final void setAdLoadedListener(MoPubNativeAdLoadedListener listener) {
        this.f35818e = listener;
    }

    public void loadAds(String adUnitId) {
        this.f35816c.loadAds(adUnitId);
    }

    public void loadAds(String adUnitId, RequestParameters requestParameters) {
        this.f35816c.loadAds(adUnitId, requestParameters);
    }

    public boolean isAd(int position) {
        return this.f35816c.isAd(position);
    }

    public void clearAds() {
        this.f35816c.clearAds();
    }

    public void destroy() {
        this.f35816c.destroy();
        this.f35817d.destroy();
    }

    public boolean areAllItemsEnabled() {
        Adapter adapter = this.f35815b;
        return (adapter instanceof ListAdapter) && ((ListAdapter) adapter).areAllItemsEnabled();
    }

    public boolean isEnabled(int position) {
        if (!isAd(position)) {
            Adapter adapter = this.f35815b;
            if (!(adapter instanceof ListAdapter) || !((ListAdapter) adapter).isEnabled(this.f35816c.getOriginalPosition(position))) {
                return false;
            }
        }
        return true;
    }

    public int getCount() {
        return this.f35816c.getAdjustedCount(this.f35815b.getCount());
    }

    public Object getItem(int position) {
        Object ad = this.f35816c.getAdData(position);
        if (ad != null) {
            return ad;
        }
        return this.f35815b.getItem(this.f35816c.getOriginalPosition(position));
    }

    public long getItemId(int position) {
        Object adData = this.f35816c.getAdData(position);
        if (adData != null) {
            return (long) (-System.identityHashCode(adData));
        }
        return this.f35815b.getItemId(this.f35816c.getOriginalPosition(position));
    }

    public boolean hasStableIds() {
        return this.f35815b.hasStableIds();
    }

    public View getView(int position, View view, ViewGroup viewGroup) {
        View resultView;
        View adView = this.f35816c.getAdView(position, view, viewGroup);
        if (adView != null) {
            resultView = adView;
        } else {
            resultView = this.f35815b.getView(this.f35816c.getOriginalPosition(position), view, viewGroup);
        }
        this.f35814a.put(resultView, Integer.valueOf(position));
        this.f35817d.addView(resultView, 0, null);
        return resultView;
    }

    public int getItemViewType(int position) {
        int viewType = this.f35816c.getAdViewType(position);
        if (viewType != 0) {
            return (this.f35815b.getViewTypeCount() + viewType) - 1;
        }
        return this.f35815b.getItemViewType(this.f35816c.getOriginalPosition(position));
    }

    public int getViewTypeCount() {
        return this.f35815b.getViewTypeCount() + this.f35816c.getAdViewTypeCount();
    }

    public boolean isEmpty() {
        return this.f35815b.isEmpty() && this.f35816c.getAdjustedCount(0) == 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38212a(List<View> visibleViews) {
        int min = MoPubClientPositioning.NO_REPEAT;
        int max = 0;
        for (View view : visibleViews) {
            Integer pos = (Integer) this.f35814a.get(view);
            if (pos != null) {
                min = Math.min(pos.intValue(), min);
                max = Math.max(pos.intValue(), max);
            }
        }
        this.f35816c.placeAdsInRange(min, max + 1);
    }

    public int getOriginalPosition(int position) {
        return this.f35816c.getOriginalPosition(position);
    }

    public int getAdjustedPosition(int originalPosition) {
        return this.f35816c.getAdjustedPosition(originalPosition);
    }

    public void insertItem(int originalPosition) {
        this.f35816c.insertItem(originalPosition);
    }

    public void removeItem(int originalPosition) {
        this.f35816c.removeItem(originalPosition);
    }

    public void setOnClickListener(ListView listView, OnItemClickListener listener) {
        if (NoThrow.checkNotNull(listView, "You called MoPubAdAdapter.setOnClickListener with a null ListView")) {
            if (listener == null) {
                listView.setOnItemClickListener(null);
            } else {
                listView.setOnItemClickListener(new C11532I(this, listener));
            }
        }
    }

    public void setOnItemLongClickListener(ListView listView, OnItemLongClickListener listener) {
        if (NoThrow.checkNotNull(listView, "You called MoPubAdAdapter.setOnItemLongClickListener with a null ListView")) {
            if (listener == null) {
                listView.setOnItemLongClickListener(null);
            } else {
                listView.setOnItemLongClickListener(new C11537J(this, listener));
            }
        }
    }

    public void setOnItemSelectedListener(ListView listView, OnItemSelectedListener listener) {
        if (NoThrow.checkNotNull(listView, "You called MoPubAdAdapter.setOnItemSelectedListener with a null ListView")) {
            if (listener == null) {
                listView.setOnItemSelectedListener(null);
            } else {
                listView.setOnItemSelectedListener(new C11539K(this, listener));
            }
        }
    }

    public void setSelection(ListView listView, int originalPosition) {
        if (NoThrow.checkNotNull(listView, "You called MoPubAdAdapter.setSelection with a null ListView")) {
            listView.setSelection(this.f35816c.getAdjustedPosition(originalPosition));
        }
    }

    public void smoothScrollToPosition(ListView listView, int originalPosition) {
        if (NoThrow.checkNotNull(listView, "You called MoPubAdAdapter.smoothScrollToPosition with a null ListView")) {
            listView.smoothScrollToPosition(this.f35816c.getAdjustedPosition(originalPosition));
        }
    }

    public void refreshAds(ListView listView, String adUnitId) {
        refreshAds(listView, adUnitId, null);
    }

    public void refreshAds(ListView listView, String adUnitId, RequestParameters requestParameters) {
        if (NoThrow.checkNotNull(listView, "You called MoPubAdAdapter.refreshAds with a null ListView")) {
            View firstView = listView.getChildAt(0);
            int offsetY = firstView == null ? 0 : firstView.getTop();
            int firstPosition = listView.getFirstVisiblePosition();
            int startRange = Math.max(firstPosition - 1, 0);
            while (this.f35816c.isAd(startRange) && startRange > 0) {
                startRange--;
            }
            int lastPosition = listView.getLastVisiblePosition();
            while (this.f35816c.isAd(lastPosition) && lastPosition < getCount() - 1) {
                lastPosition++;
            }
            int originalStartRange = this.f35816c.getOriginalPosition(startRange);
            this.f35816c.removeAdsInRange(this.f35816c.getOriginalCount(lastPosition + 1), this.f35816c.getOriginalCount(getCount()));
            int numAdsRemoved = this.f35816c.removeAdsInRange(0, originalStartRange);
            if (numAdsRemoved > 0) {
                listView.setSelectionFromTop(firstPosition - numAdsRemoved, offsetY);
            }
            loadAds(adUnitId, requestParameters);
        }
    }
}
