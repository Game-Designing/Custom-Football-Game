package p005cm.aptoide.p006pt.dataprovider.model.p009v7.store;

import java.util.List;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Event;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.store.GetStoreTabs */
public class GetStoreTabs extends BaseV7Response {
    private List<Tab> list;

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.store.GetStoreTabs$Tab */
    public static class Tab {
        private Event event;
        private String label;
        private String tag;

        public String getLabel() {
            return this.label;
        }

        public void setLabel(String label2) {
            this.label = label2;
        }

        public String getTag() {
            return this.tag;
        }

        public void setTag(String tag2) {
            this.tag = tag2;
        }

        public Event getEvent() {
            return this.event;
        }

        public void setEvent(Event event2) {
            this.event = event2;
        }

        public int hashCode() {
            String label2 = getLabel();
            int i = 43;
            int result = (1 * 59) + (label2 == null ? 43 : label2.hashCode());
            String tag2 = getTag();
            int result2 = (result * 59) + (tag2 == null ? 43 : tag2.hashCode());
            Event event2 = getEvent();
            int i2 = result2 * 59;
            if (event2 != null) {
                i = event2.hashCode();
            }
            return i2 + i;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Tab)) {
                return false;
            }
            Tab other = (Tab) o;
            if (!other.canEqual(this)) {
                return false;
            }
            String label2 = getLabel();
            Object other$label = other.getLabel();
            if (label2 != null ? !label2.equals(other$label) : other$label != null) {
                return false;
            }
            String tag2 = getTag();
            Object other$tag = other.getTag();
            if (tag2 != null ? !tag2.equals(other$tag) : other$tag != null) {
                return false;
            }
            Event event2 = getEvent();
            Object other$event = other.getEvent();
            if (event2 != null ? event2.equals(other$event) : other$event == null) {
                return true;
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("GetStoreTabs.Tab(label=");
            sb.append(getLabel());
            sb.append(", tag=");
            sb.append(getTag());
            sb.append(", event=");
            sb.append(getEvent());
            sb.append(")");
            return sb.toString();
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof Tab;
        }
    }

    public List<Tab> getList() {
        return this.list;
    }

    public void setList(List<Tab> list2) {
        this.list = list2;
    }

    public int hashCode() {
        int result = (1 * 59) + super.hashCode();
        Object $list = getList();
        return (result * 59) + ($list == null ? 43 : $list.hashCode());
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof GetStoreTabs;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof GetStoreTabs)) {
            return false;
        }
        GetStoreTabs other = (GetStoreTabs) o;
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
        sb.append("GetStoreTabs(list=");
        sb.append(getList());
        sb.append(")");
        return sb.toString();
    }
}
