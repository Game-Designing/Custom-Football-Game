package p005cm.aptoide.p006pt.dataprovider.model.p009v7.search;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Obb;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.search.SearchApp */
public class SearchApp extends App {
    private boolean hasVersions;
    private Obb obb;

    public boolean hasVersions() {
        return this.hasVersions;
    }

    public void setHasVersions(boolean hasVersions2) {
        this.hasVersions = hasVersions2;
    }

    public Obb getObb() {
        return this.obb;
    }

    public void setObb(Obb obb2) {
        this.obb = obb2;
    }
}
