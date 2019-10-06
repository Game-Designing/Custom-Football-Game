package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.BaseBodyWithStore */
public class BaseBodyWithStore extends BaseBody {
    private Long storeId;
    private String storeName;
    private String storePassSha1;
    private String storeUser;

    public BaseBodyWithStore() {
    }

    public BaseBodyWithStore(StoreCredentials storeCredentials) {
        this.storeId = storeCredentials.getId();
        this.storeName = storeCredentials.getName();
        this.storeUser = storeCredentials.getUsername();
        this.storePassSha1 = storeCredentials.getPasswordSha1();
    }

    public Long getStoreId() {
        return this.storeId;
    }

    public String getStoreName() {
        return this.storeName;
    }

    public String getStoreUser() {
        return this.storeUser;
    }

    public String getStorePassSha1() {
        return this.storePassSha1;
    }
}
