package p005cm.aptoide.p006pt.dataprovider.model.p009v7.store;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.store.GetStoreMeta */
public class GetStoreMeta extends BaseV7Response {
    private Store data;

    public Store getData() {
        return this.data;
    }

    public void setData(Store data2) {
        this.data = data2;
    }

    public int hashCode() {
        int result = (1 * 59) + super.hashCode();
        Object $data = getData();
        return (result * 59) + ($data == null ? 43 : $data.hashCode());
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof GetStoreMeta;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof GetStoreMeta)) {
            return false;
        }
        GetStoreMeta other = (GetStoreMeta) o;
        if (!other.canEqual(this) || !super.equals(o)) {
            return false;
        }
        Object this$data = getData();
        Object other$data = other.getData();
        if (this$data != null ? this$data.equals(other$data) : other$data == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GetStoreMeta(data=");
        sb.append(getData());
        sb.append(")");
        return sb.toString();
    }
}
