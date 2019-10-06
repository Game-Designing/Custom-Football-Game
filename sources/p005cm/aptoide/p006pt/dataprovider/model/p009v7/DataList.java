package p005cm.aptoide.p006pt.dataprovider.model.p009v7;

import java.util.List;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.DataList */
public class DataList<T> {
    private int count;
    private int hidden;
    private Integer limit;
    private List<T> list;
    private boolean loaded;
    private int next;
    private int offset;
    private int total;

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

    public int getHidden() {
        return this.hidden;
    }

    public void setHidden(int hidden2) {
        this.hidden = hidden2;
    }

    public boolean isLoaded() {
        return this.loaded;
    }

    public void setLoaded(boolean loaded2) {
        this.loaded = loaded2;
    }

    public List<T> getList() {
        return this.list;
    }

    public void setList(List<T> list2) {
        this.list = list2;
    }

    public int hashCode() {
        int result = (((((1 * 59) + getTotal()) * 59) + getCount()) * 59) + getOffset();
        Integer limit2 = getLimit();
        int i = 43;
        int result2 = (((((((result * 59) + (limit2 == null ? 43 : limit2.hashCode())) * 59) + getNext()) * 59) + getHidden()) * 59) + (isLoaded() ? 79 : 97);
        Object $list = getList();
        int i2 = result2 * 59;
        if ($list != null) {
            i = $list.hashCode();
        }
        return i2 + i;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof DataList)) {
            return false;
        }
        DataList other = (DataList) o;
        if (!other.canEqual(this) || getTotal() != other.getTotal() || getCount() != other.getCount() || getOffset() != other.getOffset()) {
            return false;
        }
        Integer limit2 = getLimit();
        Object other$limit = other.getLimit();
        if (limit2 != null ? !limit2.equals(other$limit) : other$limit != null) {
            return false;
        }
        if (getNext() != other.getNext() || getHidden() != other.getHidden() || isLoaded() != other.isLoaded()) {
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
        sb.append("DataList(total=");
        sb.append(getTotal());
        sb.append(", count=");
        sb.append(getCount());
        sb.append(", offset=");
        sb.append(getOffset());
        sb.append(", limit=");
        sb.append(getLimit());
        sb.append(", next=");
        sb.append(getNext());
        sb.append(", hidden=");
        sb.append(getHidden());
        sb.append(", loaded=");
        sb.append(isLoaded());
        sb.append(", list=");
        sb.append(getList());
        sb.append(")");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof DataList;
    }
}
