package p005cm.aptoide.p006pt.ads.data;

import android.view.View;

/* renamed from: cm.aptoide.pt.ads.data.ApplicationAd */
public interface ApplicationAd {

    /* renamed from: cm.aptoide.pt.ads.data.ApplicationAd$Network */
    public enum Network {
        SERVER("Server");
        
        private String name;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[4] = true;
        }

        private Network(String network) {
            boolean[] $jacocoInit = $jacocoInit();
            this.name = network;
            $jacocoInit[2] = true;
        }

        public String getName() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.name;
            $jacocoInit[3] = true;
            return str;
        }
    }

    String getAdTitle();

    String getIconUrl();

    Network getNetwork();

    String getPackageName();

    Integer getStars();

    void registerClickableView(View view);

    void setAdView(View view);
}
