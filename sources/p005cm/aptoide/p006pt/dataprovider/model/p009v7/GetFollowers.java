package p005cm.aptoide.p006pt.dataprovider.model.p009v7;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.TimelineStats.StatusData;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetFollowers */
public class GetFollowers extends BaseV7EndlessDataListResponse<TimelineUser> {

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetFollowers$TimelineUser */
    public static class TimelineUser {
        String avatar;

        /* renamed from: id */
        long f6087id;
        String name;
        StatusData stats;
        Store store;

        public long getId() {
            return this.f6087id;
        }

        public void setId(long id) {
            this.f6087id = id;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name2) {
            this.name = name2;
        }

        public String getAvatar() {
            return this.avatar;
        }

        public void setAvatar(String avatar2) {
            this.avatar = avatar2;
        }

        public Store getStore() {
            return this.store;
        }

        public void setStore(Store store2) {
            this.store = store2;
        }

        public StatusData getStats() {
            return this.stats;
        }

        public void setStats(StatusData stats2) {
            this.stats = stats2;
        }

        public int hashCode() {
            long $id = getId();
            int result = (1 * 59) + ((int) (($id >>> 32) ^ $id));
            String name2 = getName();
            int i = 43;
            int result2 = (result * 59) + (name2 == null ? 43 : name2.hashCode());
            String avatar2 = getAvatar();
            int result3 = (result2 * 59) + (avatar2 == null ? 43 : avatar2.hashCode());
            Object $store = getStore();
            int result4 = (result3 * 59) + ($store == null ? 43 : $store.hashCode());
            StatusData stats2 = getStats();
            int i2 = result4 * 59;
            if (stats2 != null) {
                i = stats2.hashCode();
            }
            return i2 + i;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof TimelineUser)) {
                return false;
            }
            TimelineUser other = (TimelineUser) o;
            if (!other.canEqual(this) || getId() != other.getId()) {
                return false;
            }
            String name2 = getName();
            Object other$name = other.getName();
            if (name2 != null ? !name2.equals(other$name) : other$name != null) {
                return false;
            }
            String avatar2 = getAvatar();
            Object other$avatar = other.getAvatar();
            if (avatar2 != null ? !avatar2.equals(other$avatar) : other$avatar != null) {
                return false;
            }
            Object this$store = getStore();
            Object other$store = other.getStore();
            if (this$store != null ? !this$store.equals(other$store) : other$store != null) {
                return false;
            }
            StatusData stats2 = getStats();
            Object other$stats = other.getStats();
            if (stats2 != null ? stats2.equals(other$stats) : other$stats == null) {
                return true;
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("GetFollowers.TimelineUser(id=");
            sb.append(getId());
            sb.append(", name=");
            sb.append(getName());
            sb.append(", avatar=");
            sb.append(getAvatar());
            sb.append(", store=");
            sb.append(getStore());
            sb.append(", stats=");
            sb.append(getStats());
            sb.append(")");
            return sb.toString();
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof TimelineUser;
        }
    }

    public int hashCode() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof GetFollowers;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if ((o instanceof GetFollowers) && ((GetFollowers) o).canEqual(this)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "GetFollowers()";
    }
}
