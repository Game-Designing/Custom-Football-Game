package p005cm.aptoide.p006pt.dataprovider.model.p009v7;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetUserSettings */
public class GetUserSettings extends BaseV7Response {
    private Data data;

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetUserSettings$Access */
    public static class Access {
        private boolean confirmed;

        public boolean isConfirmed() {
            return this.confirmed;
        }

        public void setConfirmed(boolean confirmed2) {
            this.confirmed = confirmed2;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof Access;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Access)) {
                return false;
            }
            Access other = (Access) o;
            if (other.canEqual(this) && isConfirmed() == other.isConfirmed()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (1 * 59) + (isConfirmed() ? 79 : 97);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("GetUserSettings.Access(confirmed=");
            sb.append(isConfirmed());
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetUserSettings$Data */
    public static class Data {
        private Access access;
        private boolean mature;

        public boolean isMature() {
            return this.mature;
        }

        public void setMature(boolean mature2) {
            this.mature = mature2;
        }

        public Access getAccess() {
            return this.access;
        }

        public void setAccess(Access access2) {
            this.access = access2;
        }

        public int hashCode() {
            int result = (1 * 59) + (isMature() ? 79 : 97);
            Access access2 = getAccess();
            return (result * 59) + (access2 == null ? 43 : access2.hashCode());
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof Data;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Data)) {
                return false;
            }
            Data other = (Data) o;
            if (!other.canEqual(this) || isMature() != other.isMature()) {
                return false;
            }
            Access access2 = getAccess();
            Object other$access = other.getAccess();
            if (access2 != null ? access2.equals(other$access) : other$access == null) {
                return true;
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("GetUserSettings.Data(mature=");
            sb.append(isMature());
            sb.append(", access=");
            sb.append(getAccess());
            sb.append(")");
            return sb.toString();
        }
    }

    public Data getData() {
        return this.data;
    }

    public void setData(Data data2) {
        this.data = data2;
    }

    public int hashCode() {
        Data data2 = getData();
        return (1 * 59) + (data2 == null ? 43 : data2.hashCode());
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof GetUserSettings;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof GetUserSettings)) {
            return false;
        }
        GetUserSettings other = (GetUserSettings) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Data data2 = getData();
        Object other$data = other.getData();
        if (data2 != null ? data2.equals(other$data) : other$data == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GetUserSettings(data=");
        sb.append(getData());
        sb.append(")");
        return sb.toString();
    }
}
