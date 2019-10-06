package com.unity3d.services.monetization.placementcontent.purchasing;

import com.unity3d.services.monetization.placementcontent.purchasing.PromoMetadata.Builder;
import com.unity3d.services.purchasing.core.Product;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class PromoMetadataUtilities {
    public static PromoMetadata createPromoMetadataFromParamsMap(Map<String, Object> params) {
        Builder builder = PromoMetadata.newBuilder();
        String str = "impressionDate";
        if (params.containsKey(str)) {
            builder.withImpressionDate(new Date(((Long) params.get(str)).longValue()));
        }
        String str2 = "offerDuration";
        if (params.containsKey(str2)) {
            builder.withOfferDuration(((Long) params.get(str2)).longValue());
        }
        String str3 = "costs";
        if (params.containsKey(str3)) {
            builder.withCosts(getItemListFromList((List) params.get(str3)));
        }
        String str4 = "payouts";
        if (params.containsKey(str4)) {
            builder.withPayouts(getItemListFromList((List) params.get(str4)));
        }
        String str5 = "product";
        if (params.containsKey(str5)) {
            builder.withPremiumProduct(createProductFromMap((Map) params.get(str5)));
        }
        String str6 = "userInfo";
        if (params.containsKey(str6)) {
            builder.withCustomInfo((Map) params.get(str6));
        }
        return builder.build();
    }

    private static List<Item> getItemListFromList(List<Map<String, Object>> itemsList) {
        List<Item> items = new ArrayList<>(itemsList.size());
        for (Map<String, Object> itemMap : itemsList) {
            items.add(createItemFromMap(itemMap));
        }
        return items;
    }

    private static Item createItemFromMap(Map<String, Object> itemMap) {
        Item.Builder itemBuilder = Item.newBuilder();
        String str = "itemId";
        if (itemMap.containsKey(str)) {
            itemBuilder.withItemId((String) itemMap.get(str));
        }
        String str2 = "quantity";
        if (itemMap.containsKey(str2)) {
            itemBuilder.withQuantity(((Number) itemMap.get(str2)).longValue());
        }
        String str3 = "type";
        if (itemMap.containsKey(str3)) {
            itemBuilder.withType((String) itemMap.get(str3));
        }
        return itemBuilder.build();
    }

    private static Product createProductFromMap(Map<String, Object> productParams) {
        Product.Builder productBuilder = Product.newBuilder();
        String str = "productId";
        if (productParams.containsKey(str)) {
            productBuilder.withProductId((String) productParams.get(str));
        }
        String str2 = "isoCurrencyCode";
        if (productParams.containsKey(str2)) {
            productBuilder.withIsoCurrencyCode((String) productParams.get(str2));
        }
        String str3 = "localizedPriceString";
        if (productParams.containsKey(str3)) {
            productBuilder.withLocalizedPriceString((String) productParams.get(str3));
        }
        String str4 = "localizedDescription";
        if (productParams.containsKey(str4)) {
            productBuilder.withLocalizedDescription((String) productParams.get(str4));
        }
        String str5 = "localizedTitle";
        if (productParams.containsKey(str5)) {
            productBuilder.withLocalizedTitle((String) productParams.get(str5));
        }
        String str6 = "localizedPrice";
        if (productParams.containsKey(str6)) {
            productBuilder.withLocalizedPrice(new Double(productParams.get(str6).toString()).doubleValue());
        }
        String str7 = "productType";
        if (productParams.containsKey(str7)) {
            productBuilder.withProductType((String) productParams.get(str7));
        }
        return productBuilder.build();
    }
}
