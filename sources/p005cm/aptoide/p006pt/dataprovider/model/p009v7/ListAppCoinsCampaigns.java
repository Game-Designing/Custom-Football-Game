package p005cm.aptoide.p006pt.dataprovider.model.p009v7;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.ListAppCoinsCampaigns */
public class ListAppCoinsCampaigns extends BaseV7EndlessListResponse<AppCoinsCampaign> {
    public int hashCode() {
        return (1 * 59) + super.hashCode();
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof ListAppCoinsCampaigns;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if ((o instanceof ListAppCoinsCampaigns) && ((ListAppCoinsCampaigns) o).canEqual(this) && super.equals(o)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "ListApps()";
    }
}
