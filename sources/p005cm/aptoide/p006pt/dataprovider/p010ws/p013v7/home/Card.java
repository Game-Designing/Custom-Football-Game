package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.home;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Review.User;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.home.Card */
public class Card {
    private App app;
    private String type;
    private String uid;
    private User user;

    public String getType() {
        return this.type;
    }

    public void setType(String type2) {
        this.type = type2;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String uid2) {
        this.uid = uid2;
    }

    public App getApp() {
        return this.app;
    }

    public void setApp(App app2) {
        this.app = app2;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user2) {
        this.user = user2;
    }

    public boolean hasUser() {
        return this.user != null;
    }
}
