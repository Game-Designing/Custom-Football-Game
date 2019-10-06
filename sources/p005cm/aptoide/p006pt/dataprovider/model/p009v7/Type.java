package p005cm.aptoide.p006pt.dataprovider.model.p009v7;

import android.content.res.Resources;
import android.view.WindowManager;
import p005cm.aptoide.p006pt.utils.AptoideUtils.ScreenU;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.Type */
public enum Type {
    _EMPTY(1, true),
    APPS_GROUP(3, false),
    STORES_GROUP(3, false),
    FOLLOW_STORE(3, false),
    DISPLAYS(2, true),
    ADS(3, false),
    HOME_META(1, true),
    COMMENTS_GROUP(1, true),
    APPCOINS_ADS(3, false),
    APPS_TOP_GROUP(3, false),
    REVIEWS_GROUP(1, false),
    STORE_META(1, true),
    MY_STORE_META(1, true),
    MY_STORES_SUBSCRIBED(3, false),
    STORES_RECOMMENDED(3, false),
    MY_STORE(1, true),
    APP_META(1, true),
    ACTION_ITEM(1, true);
    
    private int defaultPerLineCount;
    private boolean fixedPerLineCount;

    private Type(int defaultPerLineCount2, boolean fixedPerLineCount2) {
        this.defaultPerLineCount = defaultPerLineCount2;
        this.fixedPerLineCount = fixedPerLineCount2;
    }

    public int getPerLineCount(Resources resources, WindowManager windowManager) {
        int n;
        if (isFixedPerLineCount()) {
            n = getDefaultPerLineCount();
        } else {
            n = (int) ((ScreenU.getScreenWidthInDip(windowManager, resources) / 360.0f) * ((float) getDefaultPerLineCount()));
        }
        if (n > 0) {
            return n;
        }
        return 1;
    }

    public int getDefaultPerLineCount() {
        return this.defaultPerLineCount;
    }

    public boolean isFixedPerLineCount() {
        return this.fixedPerLineCount;
    }
}
