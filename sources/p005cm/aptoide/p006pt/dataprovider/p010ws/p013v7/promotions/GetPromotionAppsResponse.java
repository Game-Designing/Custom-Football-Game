package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.promotions;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7EndlessDataListResponse;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.App;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.promotions.GetPromotionAppsResponse */
public class GetPromotionAppsResponse extends BaseV7EndlessDataListResponse<PromotionAppModel> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.promotions.GetPromotionAppsResponse$PromotionAppModel */
    public static class PromotionAppModel {
        private App app;
        private float appc;
        private boolean claimed;
        private String promotionDescription;

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

        public App getApp() {
            return this.app;
        }

        public void setApp(App app2) {
            this.app = app2;
        }

        public String getPromotionDescription() {
            return this.promotionDescription;
        }

        public void setPromotionDescription(String description) {
            this.promotionDescription = description;
        }
    }
}
