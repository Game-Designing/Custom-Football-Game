package p005cm.aptoide.p006pt.dataprovider.model.p009v7.store;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.store.GetHomeMeta */
public class GetHomeMeta extends BaseV7Response {
    private Data data;

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.store.GetHomeMeta$Data */
    public static class Data {
        private Stats stats;
        private Store store;
        private HomeUser user;

        public Store getStore() {
            return this.store;
        }

        public void setStore(Store store2) {
            this.store = store2;
        }

        public HomeUser getUser() {
            return this.user;
        }

        public void setUser(HomeUser user2) {
            this.user = user2;
        }

        public Stats getStats() {
            return this.stats;
        }

        public void setStats(Stats stats2) {
            this.stats = stats2;
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.store.GetHomeMeta$Stats */
    public static class Stats {
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
    }

    public Data getData() {
        return this.data;
    }

    public void setData(Data data2) {
        this.data = data2;
    }
}
