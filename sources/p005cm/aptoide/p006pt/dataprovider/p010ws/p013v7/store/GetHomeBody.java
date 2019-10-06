package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store;

import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.store.GetHomeBody */
public class GetHomeBody extends GetStoreBody {
    private Long userId;

    public GetHomeBody(StoreCredentials storeCredentials, WidgetsArgs widgetsArgs, Long userId2) {
        super(storeCredentials, widgetsArgs);
        this.userId = userId2;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId2) {
        this.userId = userId2;
    }
}
