package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.home;

import com.fasterxml.jackson.annotation.JsonProperty;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.home.WalletAdsOfferResponse */
public class WalletAdsOfferResponse extends BaseV7Response {
    private WalletAdOffer data;

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.home.WalletAdsOfferResponse$WalletAdOffer */
    public class WalletAdOffer {
        @JsonProperty("remove_ads")
        private boolean isWalletOfferActive;

        public WalletAdOffer() {
        }

        public boolean isOfferActive() {
            return this.isWalletOfferActive;
        }

        public void setWalletOfferStatus(boolean isWalletOfferActive2) {
            this.isWalletOfferActive = isWalletOfferActive2;
        }
    }

    public WalletAdOffer getData() {
        return this.data;
    }

    public void setData(WalletAdOffer data2) {
        this.data = data2;
    }
}
