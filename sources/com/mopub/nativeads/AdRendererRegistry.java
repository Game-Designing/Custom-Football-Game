package com.mopub.nativeads;

import com.mopub.common.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;

public class AdRendererRegistry {

    /* renamed from: a */
    private final ArrayList<MoPubAdRenderer> f35597a = new ArrayList<>();

    public void registerAdRenderer(MoPubAdRenderer moPubAdRenderer) {
        this.f35597a.add(moPubAdRenderer);
    }

    public int getAdRendererCount() {
        return this.f35597a.size();
    }

    public Iterable<MoPubAdRenderer> getRendererIterable() {
        return this.f35597a;
    }

    public int getViewTypeForAd(NativeAd nativeAd) {
        Preconditions.checkNotNull(nativeAd);
        for (int i = 0; i < this.f35597a.size(); i++) {
            if (nativeAd.getMoPubAdRenderer() == this.f35597a.get(i)) {
                return i + 1;
            }
        }
        return 0;
    }

    public MoPubAdRenderer getRendererForAd(BaseNativeAd nativeAd) {
        Preconditions.checkNotNull(nativeAd);
        Iterator it = this.f35597a.iterator();
        while (it.hasNext()) {
            MoPubAdRenderer moPubAdRenderer = (MoPubAdRenderer) it.next();
            if (moPubAdRenderer.supports(nativeAd)) {
                return moPubAdRenderer;
            }
        }
        return null;
    }

    public MoPubAdRenderer getRendererForViewType(int viewType) {
        try {
            return (MoPubAdRenderer) this.f35597a.get(viewType - 1);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
