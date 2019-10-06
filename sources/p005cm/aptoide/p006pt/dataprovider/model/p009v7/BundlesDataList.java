package p005cm.aptoide.p006pt.dataprovider.model.p009v7;

import java.util.List;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.BundlesDataList */
public class BundlesDataList {
    private int count;
    private Integer limit;
    private List<Bundle> list;
    private int next;
    private int offset;
    private int total;

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.BundlesDataList$Bundle */
    public static class Bundle {
        private List<App> apps;
        private String tag;
        private String title;
        private String type;

        public String getType() {
            return this.type;
        }

        public void setType(String type2) {
            this.type = type2;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title2) {
            this.title = title2;
        }

        public String getTag() {
            return this.tag;
        }

        public void setTag(String tag2) {
            this.tag = tag2;
        }

        public List<App> getApps() {
            return this.apps;
        }

        public void setApps(List<App> apps2) {
            this.apps = apps2;
        }
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total2) {
        this.total = total2;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count2) {
        this.count = count2;
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int offset2) {
        this.offset = offset2;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer limit2) {
        this.limit = limit2;
    }

    public int getNext() {
        return this.next;
    }

    public void setNext(int next2) {
        this.next = next2;
    }

    public List<Bundle> getList() {
        return this.list;
    }

    public void setList(List<Bundle> list2) {
        this.list = list2;
    }
}
