package p005cm.aptoide.p006pt.dataprovider.model.p009v7;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.ListApps */
public class ListApps extends BaseV7EndlessDataListResponse<App> {
    public int hashCode() {
        return (1 * 59) + super.hashCode();
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof ListApps;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if ((o instanceof ListApps) && ((ListApps) o).canEqual(this) && super.equals(o)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "ListApps()";
    }
}
