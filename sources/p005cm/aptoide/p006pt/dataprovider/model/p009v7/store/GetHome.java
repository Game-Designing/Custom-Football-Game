package p005cm.aptoide.p006pt.dataprovider.model.p009v7.store;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.store.GetHome */
public class GetHome extends StoreUserAbstraction<GetHomeMeta> {
    public int hashCode() {
        return (1 * 59) + super.hashCode();
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof GetHome;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if ((o instanceof GetHome) && ((GetHome) o).canEqual(this) && super.equals(o)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "GetHome()";
    }
}
