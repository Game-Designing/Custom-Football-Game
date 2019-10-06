package p005cm.aptoide.p006pt.dataprovider.model.p009v7.store;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetStoreWidgets;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.store.StoreUserAbstraction */
public abstract class StoreUserAbstraction<T extends BaseV7Response> extends BaseV7Response {
    private Nodes<T> nodes;

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.store.StoreUserAbstraction$Nodes */
    public static class Nodes<T extends BaseV7Response> {
        private T meta;
        private GetStoreTabs tabs;
        private GetStoreWidgets widgets;

        public T getMeta() {
            return this.meta;
        }

        public void setMeta(T meta2) {
            this.meta = meta2;
        }

        public GetStoreTabs getTabs() {
            return this.tabs;
        }

        public void setTabs(GetStoreTabs tabs2) {
            this.tabs = tabs2;
        }

        public GetStoreWidgets getWidgets() {
            return this.widgets;
        }

        public void setWidgets(GetStoreWidgets widgets2) {
            this.widgets = widgets2;
        }

        public int hashCode() {
            BaseV7Response meta2 = getMeta();
            int i = 43;
            int result = (1 * 59) + (meta2 == null ? 43 : meta2.hashCode());
            GetStoreTabs tabs2 = getTabs();
            int result2 = (result * 59) + (tabs2 == null ? 43 : tabs2.hashCode());
            GetStoreWidgets widgets2 = getWidgets();
            int i2 = result2 * 59;
            if (widgets2 != null) {
                i = widgets2.hashCode();
            }
            return i2 + i;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Nodes)) {
                return false;
            }
            Nodes other = (Nodes) o;
            if (!other.canEqual(this)) {
                return false;
            }
            BaseV7Response meta2 = getMeta();
            Object other$meta = other.getMeta();
            if (meta2 != null ? !meta2.equals(other$meta) : other$meta != null) {
                return false;
            }
            GetStoreTabs tabs2 = getTabs();
            Object other$tabs = other.getTabs();
            if (tabs2 != null ? !tabs2.equals(other$tabs) : other$tabs != null) {
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
            sb.append("StoreUserAbstraction.Nodes(meta=");
            sb.append(getMeta());
            sb.append(", tabs=");
            sb.append(getTabs());
            sb.append(", widgets=");
            sb.append(getWidgets());
            sb.append(")");
            return sb.toString();
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof Nodes;
        }
    }

    public Nodes<T> getNodes() {
        return this.nodes;
    }

    public void setNodes(Nodes<T> nodes2) {
        this.nodes = nodes2;
    }

    public int hashCode() {
        int result = (1 * 59) + super.hashCode();
        Nodes nodes2 = getNodes();
        return (result * 59) + (nodes2 == null ? 43 : nodes2.hashCode());
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof StoreUserAbstraction;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof StoreUserAbstraction)) {
            return false;
        }
        StoreUserAbstraction other = (StoreUserAbstraction) o;
        if (!other.canEqual(this) || !super.equals(o)) {
            return false;
        }
        Nodes nodes2 = getNodes();
        Object other$nodes = other.getNodes();
        if (nodes2 != null ? nodes2.equals(other$nodes) : other$nodes == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StoreUserAbstraction(nodes=");
        sb.append(getNodes());
        sb.append(")");
        return sb.toString();
    }
}
