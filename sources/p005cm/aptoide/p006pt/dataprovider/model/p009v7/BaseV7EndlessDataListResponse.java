package p005cm.aptoide.p006pt.dataprovider.model.p009v7;

import com.fasterxml.jackson.annotation.JsonProperty;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessDataListResponse */
public class BaseV7EndlessDataListResponse<T> extends BaseV7EndlessResponse {
    @JsonProperty("datalist")
    private DataList<T> dataList;

    public int getTotal() {
        if (hasData()) {
            return this.dataList.getTotal();
        }
        return 0;
    }

    public int getNextSize() {
        if (hasData()) {
            return this.dataList.getNext();
        }
        return 0;
    }

    public boolean hasData() {
        DataList<T> dataList2 = this.dataList;
        return (dataList2 == null || dataList2.getList() == null) ? false : true;
    }

    public int hashCode() {
        int result = (1 * 59) + super.hashCode();
        DataList dataList2 = getDataList();
        return (result * 59) + (dataList2 == null ? 43 : dataList2.hashCode());
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof BaseV7EndlessDataListResponse;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BaseV7EndlessDataListResponse)) {
            return false;
        }
        BaseV7EndlessDataListResponse other = (BaseV7EndlessDataListResponse) o;
        if (!other.canEqual(this) || !super.equals(o)) {
            return false;
        }
        DataList dataList2 = getDataList();
        Object other$dataList = other.getDataList();
        if (dataList2 != null ? dataList2.equals(other$dataList) : other$dataList == null) {
            return true;
        }
        return false;
    }

    public DataList<T> getDataList() {
        return this.dataList;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BaseV7EndlessDataListResponse(dataList=");
        sb.append(getDataList());
        sb.append(")");
        return sb.toString();
    }
}
