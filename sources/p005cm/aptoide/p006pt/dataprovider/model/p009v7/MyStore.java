package p005cm.aptoide.p006pt.dataprovider.model.p009v7;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.MyStore */
public class MyStore extends BaseV7Response {
    GetStoreWidgets widgets;

    public GetStoreWidgets getWidgets() {
        return this.widgets;
    }

    public void setWidgets(GetStoreWidgets widgets2) {
        this.widgets = widgets2;
    }

    public int hashCode() {
        int result = (1 * 59) + super.hashCode();
        GetStoreWidgets widgets2 = getWidgets();
        return (result * 59) + (widgets2 == null ? 43 : widgets2.hashCode());
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof MyStore;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MyStore)) {
            return false;
        }
        MyStore other = (MyStore) o;
        if (!other.canEqual(this) || !super.equals(o)) {
            return false;
        }
        GetStoreWidgets widgets2 = getWidgets();
        Object other$widgets = other.getWidgets();
        if (widgets2 != null ? widgets2.equals(other$widgets) : other$widgets == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyStore(widgets=");
        sb.append(getWidgets());
        sb.append(")");
        return sb.toString();
    }
}
