package com.unity3d.services.monetization.placementcontent.purchasing;

import com.unity3d.services.monetization.placementcontent.core.CustomEvent;
import java.util.HashMap;
import java.util.Map;

public class NativePromoAdapter {
    private static final String EVENT_SHOWN_SHOW_TYPE = "showType";
    private static final String EVENT_TYPE_CLICKED = "clicked";
    private static final String EVENT_TYPE_CLOSED = "closed";
    private static final String EVENT_TYPE_SHOWN = "shown";
    private PromoMetadata promoMetadata;
    private PromoAdPlacementContent promoPlacementContent;

    public NativePromoAdapter(PromoAdPlacementContent promoPlacementContent2) {
        this.promoPlacementContent = promoPlacementContent2;
        this.promoMetadata = promoPlacementContent2.getMetadata();
    }

    public PromoMetadata getPromoMetadata() {
        return this.promoMetadata;
    }

    public void onShown() {
        onShown(NativePromoShowType.FULL);
    }

    public void onShown(NativePromoShowType type) {
        Map<String, Object> eventData = new HashMap<>();
        eventData.put(EVENT_SHOWN_SHOW_TYPE, type.toString());
        this.promoPlacementContent.sendCustomEvent(new CustomEvent(EVENT_TYPE_SHOWN, eventData));
    }

    public void onClosed() {
        this.promoPlacementContent.sendCustomEvent(new CustomEvent(EVENT_TYPE_CLOSED));
    }

    public void onClicked() {
        this.promoPlacementContent.sendCustomEvent(new CustomEvent(EVENT_TYPE_CLICKED));
    }
}
