package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import android.content.SharedPreferences;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.BaseBodyWithApp */
public class BaseBodyWithApp extends BaseBodyWithAlphaBetaKey {
    private String storePassSha1;
    private String storeUser;

    public BaseBodyWithApp(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
    }

    public String getStoreUser() {
        return this.storeUser;
    }

    public void setStoreUser(String storeUser2) {
        this.storeUser = storeUser2;
    }

    public String getStorePassSha1() {
        return this.storePassSha1;
    }

    public void setStorePassSha1(String storePassSha12) {
        this.storePassSha1 = storePassSha12;
    }
}
