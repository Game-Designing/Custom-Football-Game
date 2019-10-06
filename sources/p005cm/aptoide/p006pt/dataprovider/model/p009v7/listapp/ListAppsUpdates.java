package p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp;

import java.util.List;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.listapp.ListAppsUpdates */
public class ListAppsUpdates extends BaseV7Response {
    private List<App> list;

    public boolean isOk() {
        return super.isOk() || this.list != null;
    }

    public int hashCode() {
        int result = (1 * 59) + super.hashCode();
        Object $list = getList();
        return (result * 59) + ($list == null ? 43 : $list.hashCode());
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof ListAppsUpdates;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ListAppsUpdates)) {
            return false;
        }
        ListAppsUpdates other = (ListAppsUpdates) o;
        if (!other.canEqual(this) || !super.equals(o)) {
            return false;
        }
        Object this$list = getList();
        Object other$list = other.getList();
        if (this$list != null ? this$list.equals(other$list) : other$list == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ListAppsUpdates(list=");
        sb.append(getList());
        sb.append(")");
        return sb.toString();
    }

    public List<App> getList() {
        return this.list;
    }

    public void setList(List<App> list2) {
        this.list = list2;
    }
}
