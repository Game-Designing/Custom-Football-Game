package com.mopub.nativeads;

import android.support.p001v7.widget.RecyclerView.C0972c;
import com.mopub.nativeads.MoPubRecyclerAdapter.ContentChangeStrategy;

/* renamed from: com.mopub.nativeads.da */
/* compiled from: MoPubRecyclerAdapter */
class C11594da extends C0972c {

    /* renamed from: a */
    final /* synthetic */ MoPubRecyclerAdapter f36131a;

    C11594da(MoPubRecyclerAdapter this$0) {
        this.f36131a = this$0;
    }

    public void onChanged() {
        this.f36131a.f35883c.setItemCount(this.f36131a.f35884d.getItemCount());
        this.f36131a.notifyDataSetChanged();
    }

    public void onItemRangeChanged(int positionStart, int itemCount) {
        int adjustedEndPosition = this.f36131a.f35883c.getAdjustedPosition((positionStart + itemCount) - 1);
        int adjustedStartPosition = this.f36131a.f35883c.getAdjustedPosition(positionStart);
        this.f36131a.notifyItemRangeChanged(adjustedStartPosition, (adjustedEndPosition - adjustedStartPosition) + 1);
    }

    public void onItemRangeInserted(int positionStart, int itemCount) {
        int adjustedStartPosition = this.f36131a.f35883c.getAdjustedPosition(positionStart);
        int newOriginalCount = this.f36131a.f35884d.getItemCount();
        this.f36131a.f35883c.setItemCount(newOriginalCount);
        boolean addingToEnd = positionStart + itemCount >= newOriginalCount;
        if (ContentChangeStrategy.KEEP_ADS_FIXED == this.f36131a.f35887g || (ContentChangeStrategy.INSERT_AT_END == this.f36131a.f35887g && addingToEnd)) {
            this.f36131a.notifyDataSetChanged();
            return;
        }
        for (int i = 0; i < itemCount; i++) {
            this.f36131a.f35883c.insertItem(positionStart);
        }
        this.f36131a.notifyItemRangeInserted(adjustedStartPosition, itemCount);
    }

    public void onItemRangeRemoved(int positionStart, int itemsRemoved) {
        int adjustedStartPosition = this.f36131a.f35883c.getAdjustedPosition(positionStart);
        int newOriginalCount = this.f36131a.f35884d.getItemCount();
        this.f36131a.f35883c.setItemCount(newOriginalCount);
        boolean removingFromEnd = positionStart + itemsRemoved >= newOriginalCount;
        if (ContentChangeStrategy.KEEP_ADS_FIXED == this.f36131a.f35887g || (ContentChangeStrategy.INSERT_AT_END == this.f36131a.f35887g && removingFromEnd)) {
            this.f36131a.notifyDataSetChanged();
            return;
        }
        int oldAdjustedCount = this.f36131a.f35883c.getAdjustedCount(newOriginalCount + itemsRemoved);
        for (int i = 0; i < itemsRemoved; i++) {
            this.f36131a.f35883c.removeItem(positionStart);
        }
        int itemsRemovedIncludingAds = oldAdjustedCount - this.f36131a.f35883c.getAdjustedCount(newOriginalCount);
        this.f36131a.notifyItemRangeRemoved(adjustedStartPosition - (itemsRemovedIncludingAds - itemsRemoved), itemsRemovedIncludingAds);
    }

    public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
        this.f36131a.notifyDataSetChanged();
    }
}
