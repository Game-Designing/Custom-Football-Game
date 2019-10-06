package p005cm.aptoide.p006pt.dataprovider.model.p009v7;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.TimelineStats */
public class TimelineStats extends BaseV7Response {
    private StatusData data;

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.TimelineStats$StatusData */
    public static class StatusData {
        private long followers;
        private long following;

        public long getFollowers() {
            return this.followers;
        }

        public void setFollowers(long followers2) {
            this.followers = followers2;
        }

        public long getFollowing() {
            return this.following;
        }

        public void setFollowing(long following2) {
            this.following = following2;
        }

        public int hashCode() {
            long $followers = getFollowers();
            int result = (1 * 59) + ((int) (($followers >>> 32) ^ $followers));
            long $following = getFollowing();
            return (result * 59) + ((int) (($following >>> 32) ^ $following));
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof StatusData)) {
                return false;
            }
            StatusData other = (StatusData) o;
            if (other.canEqual(this) && getFollowers() == other.getFollowers() && getFollowing() == other.getFollowing()) {
                return true;
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("TimelineStats.StatusData(followers=");
            sb.append(getFollowers());
            sb.append(", following=");
            sb.append(getFollowing());
            sb.append(")");
            return sb.toString();
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof StatusData;
        }
    }

    public StatusData getData() {
        return this.data;
    }

    public void setData(StatusData data2) {
        this.data = data2;
    }

    public int hashCode() {
        int result = (1 * 59) + super.hashCode();
        StatusData data2 = getData();
        return (result * 59) + (data2 == null ? 43 : data2.hashCode());
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof TimelineStats;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TimelineStats)) {
            return false;
        }
        TimelineStats other = (TimelineStats) o;
        if (!other.canEqual(this) || !super.equals(o)) {
            return false;
        }
        StatusData data2 = getData();
        Object other$data = other.getData();
        if (data2 != null ? data2.equals(other$data) : other$data == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TimelineStats(data=");
        sb.append(getData());
        sb.append(")");
        return sb.toString();
    }
}
