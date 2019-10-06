package p005cm.aptoide.p006pt.dataprovider.model.p009v7;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Comment.User;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.SetComment */
public class SetComment extends BaseV7Response {
    private Data data;

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.SetComment$Data */
    public static class Data {
        private String body;

        /* renamed from: id */
        private long f6091id;
        private String mode;
        private String status;
        private User user;

        public long getId() {
            return this.f6091id;
        }

        public void setId(long id) {
            this.f6091id = id;
        }

        public String getBody() {
            return this.body;
        }

        public void setBody(String body2) {
            this.body = body2;
        }

        public User getUser() {
            return this.user;
        }

        public void setUser(User user2) {
            this.user = user2;
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String status2) {
            this.status = status2;
        }

        public String getMode() {
            return this.mode;
        }

        public void setMode(String mode2) {
            this.mode = mode2;
        }

        public int hashCode() {
            long $id = getId();
            int result = (1 * 59) + ((int) (($id >>> 32) ^ $id));
            String body2 = getBody();
            int i = 43;
            int result2 = (result * 59) + (body2 == null ? 43 : body2.hashCode());
            User user2 = getUser();
            int result3 = (result2 * 59) + (user2 == null ? 43 : user2.hashCode());
            String status2 = getStatus();
            int result4 = (result3 * 59) + (status2 == null ? 43 : status2.hashCode());
            String mode2 = getMode();
            int i2 = result4 * 59;
            if (mode2 != null) {
                i = mode2.hashCode();
            }
            return i2 + i;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Data)) {
                return false;
            }
            Data other = (Data) o;
            if (!other.canEqual(this) || getId() != other.getId()) {
                return false;
            }
            String body2 = getBody();
            Object other$body = other.getBody();
            if (body2 != null ? !body2.equals(other$body) : other$body != null) {
                return false;
            }
            User user2 = getUser();
            Object other$user = other.getUser();
            if (user2 != null ? !user2.equals(other$user) : other$user != null) {
                return false;
            }
            String status2 = getStatus();
            Object other$status = other.getStatus();
            if (status2 != null ? !status2.equals(other$status) : other$status != null) {
                return false;
            }
            String mode2 = getMode();
            Object other$mode = other.getMode();
            if (mode2 != null ? mode2.equals(other$mode) : other$mode == null) {
                return true;
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SetComment.Data(id=");
            sb.append(getId());
            sb.append(", body=");
            sb.append(getBody());
            sb.append(", user=");
            sb.append(getUser());
            sb.append(", status=");
            sb.append(getStatus());
            sb.append(", mode=");
            sb.append(getMode());
            sb.append(")");
            return sb.toString();
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof Data;
        }
    }

    public Data getData() {
        return this.data;
    }

    public void setData(Data data2) {
        this.data = data2;
    }

    public int hashCode() {
        int result = (1 * 59) + super.hashCode();
        Data data2 = getData();
        return (result * 59) + (data2 == null ? 43 : data2.hashCode());
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof SetComment;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SetComment)) {
            return false;
        }
        SetComment other = (SetComment) o;
        if (!other.canEqual(this) || !super.equals(o)) {
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
        sb.append("SetComment(data=");
        sb.append(getData());
        sb.append(")");
        return sb.toString();
    }
}
