package p005cm.aptoide.accountmanager;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.SocialChannelType;

/* renamed from: cm.aptoide.accountmanager.SocialLink */
public class SocialLink {
    SocialChannelType type;
    String url;

    public SocialLink() {
    }

    public SocialLink(SocialChannelType type2, String url2) {
        this.type = type2;
        this.url = url2;
    }

    public SocialChannelType getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }
}
