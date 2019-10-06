package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store;

import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBodyWithStore;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.store.GetStoreBody */
public class GetStoreBody extends BaseBodyWithStore {
    private StoreContext context;
    private final WidgetsArgs widgetsArgs;

    public GetStoreBody(StoreCredentials storeCredentials, WidgetsArgs widgetsArgs2) {
        super(storeCredentials);
        this.widgetsArgs = widgetsArgs2;
    }

    public StoreContext getContext() {
        return this.context;
    }

    public void setContext(StoreContext context2) {
        this.context = context2;
    }

    public WidgetsArgs getWidgetsArgs() {
        return this.widgetsArgs;
    }
}
