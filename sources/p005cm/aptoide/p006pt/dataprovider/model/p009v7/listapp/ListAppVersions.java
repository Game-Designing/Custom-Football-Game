package p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7EndlessListResponse;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.listapp.ListAppVersions */
public class ListAppVersions extends BaseV7EndlessListResponse<App> {
    public int hashCode() {
        return (1 * 59) + super.hashCode();
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof ListAppVersions;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if ((o instanceof ListAppVersions) && ((ListAppVersions) o).canEqual(this) && super.equals(o)) {
            return true;
        }
        return false;
    }
}
