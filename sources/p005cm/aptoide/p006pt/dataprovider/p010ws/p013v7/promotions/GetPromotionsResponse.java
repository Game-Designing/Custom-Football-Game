package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.promotions;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7EndlessDataListResponse;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.promotions.GetPromotionsResponse */
public class GetPromotionsResponse extends BaseV7EndlessDataListResponse<PromotionModel> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.promotions.GetPromotionsResponse$PromotionModel */
    public static class PromotionModel {
        private String background;
        private String promotionId;
        private String title;
        private String type;

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title2) {
            this.title = title2;
        }

        public String getPromotionId() {
            return this.promotionId;
        }

        public void setPromotionId(String promotionId2) {
            this.promotionId = promotionId2;
        }

        public String getType() {
            return this.type;
        }

        public void setType(String type2) {
            this.type = type2;
        }

        public String getBackground() {
            return this.background;
        }

        public void setBackground(String background2) {
            this.background = background2;
        }
    }
}
