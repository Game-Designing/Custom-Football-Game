package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import android.content.SharedPreferences;
import p005cm.aptoide.p006pt.preferences.managed.ManagerPreferences;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.BaseBodyWithAlphaBetaKey */
public class BaseBodyWithAlphaBetaKey extends BaseBody {
    private String notApkTags;

    protected BaseBodyWithAlphaBetaKey(SharedPreferences sharedPreferences) {
        if (ManagerPreferences.getUpdatesFilterAlphaBetaKey(sharedPreferences)) {
            this.notApkTags = "alpha,beta";
        }
    }

    public String getNotApkTags() {
        return this.notApkTags;
    }
}
