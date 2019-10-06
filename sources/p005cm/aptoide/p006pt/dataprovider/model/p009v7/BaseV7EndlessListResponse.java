package p005cm.aptoide.p006pt.dataprovider.model.p009v7;

import java.util.List;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessListResponse */
public class BaseV7EndlessListResponse<T> extends BaseV7EndlessResponse {
    private List<T> list;

    public BaseV7EndlessListResponse() {
        super(false);
    }

    public int getTotal() {
        List<T> list2 = this.list;
        if (list2 != null) {
            return list2.size();
        }
        return 0;
    }

    public int getNextSize() {
        return this.list != null ? 10 : 0;
    }

    public boolean hasData() {
        return this.list != null;
    }

    public int hashCode() {
        int result = (1 * 59) + super.hashCode();
        Object $list = getList();
        return (result * 59) + ($list == null ? 43 : $list.hashCode());
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof BaseV7EndlessListResponse;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BaseV7EndlessListResponse)) {
            return false;
        }
        BaseV7EndlessListResponse other = (BaseV7EndlessListResponse) o;
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

    public List<T> getList() {
        return this.list;
    }

    public void setList(List<T> list2) {
        this.list = list2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BaseV7EndlessListResponse(list=");
        sb.append(getList());
        sb.append(")");
        return sb.toString();
    }
}
