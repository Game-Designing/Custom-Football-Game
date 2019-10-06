package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.ChangeStoreSubscriptionResponse */
public class ChangeStoreSubscriptionResponse extends BaseV7Response {
    private StoreSubscriptionState status;
    private Store store;

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.ChangeStoreSubscriptionResponse$StoreSubscriptionState */
    public enum StoreSubscriptionState {
        UNSUBSCRIBED,
        SUBSCRIBED
    }

    public StoreSubscriptionState getStatus() {
        return this.status;
    }

    public void setStatus(StoreSubscriptionState status2) {
        this.status = status2;
    }

    public Store getStore() {
        return this.store;
    }

    public void setStore(Store store2) {
        this.store = store2;
    }
}
