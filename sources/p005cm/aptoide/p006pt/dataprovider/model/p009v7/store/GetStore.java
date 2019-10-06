package p005cm.aptoide.p006pt.dataprovider.model.p009v7.store;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.store.GetStore */
public class GetStore extends StoreUserAbstraction<GetStoreMeta> {
    public int hashCode() {
        return (1 * 59) + super.hashCode();
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof GetStore;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if ((o instanceof GetStore) && ((GetStore) o).canEqual(this) && super.equals(o)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "GetStore()";
    }
}
