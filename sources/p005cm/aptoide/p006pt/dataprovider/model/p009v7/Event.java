package p005cm.aptoide.p006pt.dataprovider.model.p009v7;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetStoreWidgets.WSWidget.Data;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.Event */
public class Event {
    private String action;
    private Data data;
    private Name name;
    private Type type;

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.Event$Name */
    public enum Name {
        listApps,
        listStores,
        getUser,
        getStore,
        getStoreWidgets,
        getMoreBundle,
        listReviews,
        listComments,
        getMyStoresSubscribed,
        getStoresRecommended,
        myStores,
        myUpdates,
        myExcludedUpdates,
        getAds,
        myDownloads,
        getAppCoinsAds,
        facebook,
        twitch,
        twitter,
        youtube,
        getReviews
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.Event$Type */
    public enum Type {
        API,
        CLIENT,
        v3
    }

    public Type getType() {
        return this.type;
    }

    public Event setType(Type type2) {
        this.type = type2;
        return this;
    }

    public Name getName() {
        return this.name;
    }

    public Event setName(Name name2) {
        this.name = name2;
        return this;
    }

    public String getAction() {
        return this.action;
    }

    public Event setAction(String action2) {
        this.action = action2;
        return this;
    }

    public Data getData() {
        return this.data;
    }

    public Event setData(Data data2) {
        this.data = data2;
        return this;
    }

    public int hashCode() {
        Type type2 = getType();
        int i = 43;
        int result = (1 * 59) + (type2 == null ? 43 : type2.hashCode());
        Name name2 = getName();
        int result2 = (result * 59) + (name2 == null ? 43 : name2.hashCode());
        String action2 = getAction();
        int result3 = (result2 * 59) + (action2 == null ? 43 : action2.hashCode());
        Data data2 = getData();
        int i2 = result3 * 59;
        if (data2 != null) {
            i = data2.hashCode();
        }
        return i2 + i;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Event)) {
            return false;
        }
        Event other = (Event) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Type type2 = getType();
        Object other$type = other.getType();
        if (type2 != null ? !type2.equals(other$type) : other$type != null) {
            return false;
        }
        Name name2 = getName();
        Object other$name = other.getName();
        if (name2 != null ? !name2.equals(other$name) : other$name != null) {
            return false;
        }
        String action2 = getAction();
        Object other$action = other.getAction();
        if (action2 != null ? !action2.equals(other$action) : other$action != null) {
            return false;
        }
        Data data2 = getData();
        Object other$data = other.getData();
        if (data2 != null ? data2.equals(other$data) : other$data == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Event(type=");
        sb.append(getType());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", action=");
        sb.append(getAction());
        sb.append(", data=");
        sb.append(getData());
        sb.append(")");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof Event;
    }
}
