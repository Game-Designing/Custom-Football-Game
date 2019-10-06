package com.unity3d.services.monetization.core.placementcontent;

import com.unity3d.services.monetization.placementcontent.ads.ShowAdPlacementContent;
import com.unity3d.services.monetization.placementcontent.core.NoFillPlacementContent;
import com.unity3d.services.monetization.placementcontent.core.PlacementContent;
import com.unity3d.services.monetization.placementcontent.purchasing.PromoAdPlacementContent;
import java.util.Map;

public class PlacementContentResultFactory {

    /* renamed from: com.unity3d.services.monetization.core.placementcontent.PlacementContentResultFactory$1 */
    static /* synthetic */ class C126391 {

        /* renamed from: $SwitchMap$com$unity3d$services$monetization$core$placementcontent$PlacementContentResultFactory$PlacementContentResultType */
        static final /* synthetic */ int[] f39027x294a2897 = new int[PlacementContentResultType.values().length];

        static {
            try {
                f39027x294a2897[PlacementContentResultType.SHOW_AD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f39027x294a2897[PlacementContentResultType.PROMO_AD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f39027x294a2897[PlacementContentResultType.NO_FILL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f39027x294a2897[PlacementContentResultType.CUSTOM.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public enum PlacementContentResultType {
        SHOW_AD,
        PROMO_AD,
        NO_FILL,
        CUSTOM;

        static PlacementContentResultType parse(String type) {
            if (type == null) {
                return CUSTOM;
            }
            try {
                return valueOf(type);
            } catch (IllegalArgumentException e) {
                return CUSTOM;
            }
        }
    }

    public static PlacementContent create(String placementId, Map<String, Object> params) {
        int i = C126391.f39027x294a2897[PlacementContentResultType.parse((String) params.get("type")).ordinal()];
        if (i == 1) {
            return new ShowAdPlacementContent(placementId, params);
        }
        if (i == 2) {
            return new PromoAdPlacementContent(placementId, params);
        }
        if (i != 3) {
            return new PlacementContent(placementId, params);
        }
        return new NoFillPlacementContent(placementId, params);
    }
}
