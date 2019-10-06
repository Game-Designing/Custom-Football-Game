package com.unity3d.services.monetization.placementcontent.purchasing;

import com.unity3d.services.purchasing.core.Product;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class PromoMetadata {
    private List<Item> costs;
    private Map<String, Object> customInfo;
    private Date impressionDate;
    private long offerDuration;
    private List<Item> payouts;
    private Product premiumProduct;

    public static final class Builder {
        /* access modifiers changed from: private */
        public List<Item> costs;
        /* access modifiers changed from: private */
        public Map<String, Object> customInfo;
        /* access modifiers changed from: private */
        public Date impressionDate;
        /* access modifiers changed from: private */
        public long offerDuration;
        /* access modifiers changed from: private */
        public List<Item> payouts;
        /* access modifiers changed from: private */
        public Product premiumProduct;

        private Builder() {
        }

        public PromoMetadata build() {
            return new PromoMetadata(this);
        }

        public Builder withImpressionDate(Date impressionDate2) {
            this.impressionDate = impressionDate2;
            return this;
        }

        public Builder withOfferDuration(long val) {
            this.offerDuration = val;
            return this;
        }

        public Builder withPremiumProduct(Product product) {
            this.premiumProduct = product;
            return this;
        }

        public Builder withCosts(List<Item> costs2) {
            this.costs = costs2;
            return this;
        }

        public Builder withPayouts(List<Item> payouts2) {
            this.payouts = payouts2;
            return this;
        }

        public Builder withCustomInfo(Map<String, Object> info) {
            this.customInfo = info;
            return this;
        }
    }

    private PromoMetadata(Builder builder) {
        this.impressionDate = builder.impressionDate;
        this.offerDuration = builder.offerDuration;
        this.premiumProduct = builder.premiumProduct;
        this.costs = builder.costs;
        this.payouts = builder.payouts;
        this.customInfo = builder.customInfo;
    }

    public Date getImpressionDate() {
        return this.impressionDate;
    }

    public long getOfferDuration() {
        return this.offerDuration;
    }

    public List<Item> getCosts() {
        return this.costs;
    }

    public List<Item> getPayouts() {
        return this.payouts;
    }

    public Product getPremiumProduct() {
        return this.premiumProduct;
    }

    public Map<String, Object> getCustomInfo() {
        return this.customInfo;
    }

    public Item getCost() {
        List<Item> list = this.costs;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return (Item) this.costs.get(0);
    }

    public Item getPayout() {
        List<Item> list = this.payouts;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return (Item) this.payouts.get(0);
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
