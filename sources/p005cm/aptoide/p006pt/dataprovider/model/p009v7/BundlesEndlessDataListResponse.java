package p005cm.aptoide.p006pt.dataprovider.model.p009v7;

import com.fasterxml.jackson.annotation.JsonProperty;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.BundlesEndlessDataListResponse */
public class BundlesEndlessDataListResponse<T> extends BaseV7EndlessResponse {
    @JsonProperty("datalist")
    private BundlesDataList dataList;

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
        BundlesDataList bundlesDataList = this.dataList;
        return (bundlesDataList == null || bundlesDataList.getList() == null) ? false : true;
    }

    public BundlesDataList getDataList() {
        return this.dataList;
    }

    public void setDataList(BundlesDataList dataList2) {
        this.dataList = dataList2;
    }
}
