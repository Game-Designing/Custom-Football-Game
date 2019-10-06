package p005cm.aptoide.p006pt.dataprovider.model.p009v7.store;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7EndlessDataListResponse;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.store.ListStores */
public class ListStores extends BaseV7EndlessDataListResponse<Store> {
    public int hashCode() {
        return (1 * 59) + super.hashCode();
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof ListStores;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if ((o instanceof ListStores) && ((ListStores) o).canEqual(this) && super.equals(o)) {
            return true;
        }
        return false;
    }
}
