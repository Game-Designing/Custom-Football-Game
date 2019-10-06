package p005cm.aptoide.p006pt.dataprovider.model.p009v7;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetUserMeta */
public class GetUserMeta extends BaseV7Response {
    private Data data;

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetUserMeta$Data */
    public static class Data {
        private String access;
        private String added;
        private String avatar;

        /* renamed from: id */
        private long f6089id;
        private Identity identity;
        private int level;
        private String modified;
        private String name;
        private Store store;

        public long getId() {
            return this.f6089id;
        }

        public void setId(long id) {
            this.f6089id = id;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name2) {
            this.name = name2;
        }

        public int getLevel() {
            return this.level;
        }

        public void setLevel(int level2) {
            this.level = level2;
        }

        public String getAvatar() {
            return this.avatar;
        }

        public void setAvatar(String avatar2) {
            this.avatar = avatar2;
        }

        public String getAdded() {
            return this.added;
        }

        public void setAdded(String added2) {
            this.added = added2;
        }

        public String getModified() {
            return this.modified;
        }

        public void setModified(String modified2) {
            this.modified = modified2;
        }

        public Identity getIdentity() {
            return this.identity;
        }

        public void setIdentity(Identity identity2) {
            this.identity = identity2;
        }

        public Store getStore() {
            return this.store;
        }

        public void setStore(Store store2) {
            this.store = store2;
        }

        public String getAccess() {
            return this.access;
        }

        public void setAccess(String access2) {
            this.access = access2;
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetUserMeta$Identity */
    public static class Identity {
        private String email;
        private String phone;
        private String username;

        public String getUsername() {
            return this.username;
        }

        public void setUsername(String username2) {
            this.username = username2;
        }

        public String getEmail() {
            return this.email;
        }

        public void setEmail(String email2) {
            this.email = email2;
        }

        public String getPhone() {
            return this.phone;
        }

        public void setPhone(String phone2) {
            this.phone = phone2;
        }
    }

    public Data getData() {
        return this.data;
    }

    public void setData(Data data2) {
        this.data = data2;
    }
}
