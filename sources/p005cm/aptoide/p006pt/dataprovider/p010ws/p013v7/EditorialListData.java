package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7EndlessDataListResponse;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.home.Appearance;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.EditorialListData */
public class EditorialListData extends BaseV7EndlessDataListResponse {
    public Appearance appearance;
    public String caption;
    public String date;
    public String icon;

    /* renamed from: id */
    public String f6111id;
    public String title;
    public String type;
    public String views;

    public String getId() {
        return this.f6111id;
    }

    public String getType() {
        return this.type;
    }

    public String getTitle() {
        return this.title;
    }

    public String getCaption() {
        return this.caption;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getViews() {
        return this.views;
    }

    public String getDate() {
        return this.date;
    }

    public Appearance getAppearance() {
        return this.appearance;
    }
}
