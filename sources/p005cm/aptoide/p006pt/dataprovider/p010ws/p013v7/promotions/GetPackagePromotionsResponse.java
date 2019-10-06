package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.promotions;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7EndlessDataListResponse;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.promotions.GetPackagePromotionsResponse */
public class GetPackagePromotionsResponse extends BaseV7EndlessDataListResponse<PromotionAppModel> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.promotions.GetPackagePromotionsResponse$PromotionAppModel */
    public static class PromotionAppModel {
        private float appc;
        private boolean claimed;
        private String packageName;
        private String promotionId;

        public boolean isClaimed() {
            return this.claimed;
        }

        public void setClaimed(boolean claimed2) {
            this.claimed = claimed2;
        }

        public float getAppc() {
            return this.appc;
        }

        public void setAppc(float appc2) {
            this.appc = appc2;
        }

        public String getPromotionId() {
            return this.promotionId;
        }

        public void setPromotionId(String promotionId2) {
            this.promotionId = promotionId2;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public void setPackageName(String packageName2) {
            this.packageName = packageName2;
        }
    }
}
