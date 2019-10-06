package com.inmobi.ads;

import android.app.Activity;
import android.view.View;
import java.util.Map;

public interface AdContainer {

    public static class RenderingProperties {

        /* renamed from: a */
        public PlacementType f31249a;

        public enum PlacementType {
            PLACEMENT_TYPE_INLINE,
            PLACEMENT_TYPE_FULLSCREEN
        }

        public RenderingProperties(PlacementType placementType) {
            this.f31249a = placementType;
        }
    }

    /* renamed from: com.inmobi.ads.AdContainer$a */
    public interface C10304a {
        /* renamed from: a */
        void mo33692a();

        /* renamed from: a */
        void mo33693a(Object obj);

        /* renamed from: b */
        void mo33694b(Object obj);
    }

    /* renamed from: a */
    void mo33678a();

    /* renamed from: a */
    void mo33679a(int i, Map<String, String> map);

    /* renamed from: b */
    void mo33680b();

    /* renamed from: c */
    boolean mo33681c();

    void destroy();

    C10590o getApkDownloader();

    Object getDataModel();

    C10304a getFullScreenEventsListener();

    String getMarkupType();

    RenderingProperties getRenderingProperties();

    View getVideoContainerView();

    C10503ca getViewableAd();

    void setFullScreenActivityContext(Activity activity);

    void setRequestedScreenOrientation();
}
