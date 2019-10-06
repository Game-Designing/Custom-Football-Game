package p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp;

import java.util.List;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.listapp.AppCoinsInfo */
public class AppCoinsInfo {
    private boolean advertising;
    private boolean billing;
    private List<String> flags;

    public boolean hasAdvertising() {
        return this.advertising;
    }

    public void setAdvertising(boolean advertising2) {
        this.advertising = advertising2;
    }

    public boolean hasBilling() {
        return this.billing;
    }

    public void setBilling(boolean billing2) {
        this.billing = billing2;
    }

    public List<String> getFlags() {
        return this.flags;
    }

    public void setFlags(List<String> flags2) {
        this.flags = flags2;
    }
}
