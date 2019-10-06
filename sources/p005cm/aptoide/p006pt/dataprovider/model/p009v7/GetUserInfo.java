package p005cm.aptoide.p006pt.dataprovider.model.p009v7;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetUserInfo */
public class GetUserInfo extends BaseV7Response {
    private Nodes nodes;

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetUserInfo$Nodes */
    public static class Nodes {
        private GetUserMeta meta;
        private GetUserSettings settings;

        public GetUserMeta getMeta() {
            return this.meta;
        }

        public void setMeta(GetUserMeta meta2) {
            this.meta = meta2;
        }

        public GetUserSettings getSettings() {
            return this.settings;
        }

        public void setSettings(GetUserSettings settings2) {
            this.settings = settings2;
        }

        public int hashCode() {
            GetUserMeta meta2 = getMeta();
            int i = 43;
            int result = (1 * 59) + (meta2 == null ? 43 : meta2.hashCode());
            GetUserSettings settings2 = getSettings();
            int i2 = result * 59;
            if (settings2 != null) {
                i = settings2.hashCode();
            }
            return i2 + i;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Nodes)) {
                return false;
            }
            Nodes other = (Nodes) o;
            if (!other.canEqual(this)) {
                return false;
            }
            GetUserMeta meta2 = getMeta();
            Object other$meta = other.getMeta();
            if (meta2 != null ? !meta2.equals(other$meta) : other$meta != null) {
                return false;
            }
            GetUserSettings settings2 = getSettings();
            Object other$settings = other.getSettings();
            if (settings2 != null ? settings2.equals(other$settings) : other$settings == null) {
                return true;
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("GetUserInfo.Nodes(meta=");
            sb.append(getMeta());
            sb.append(", settings=");
            sb.append(getSettings());
            sb.append(")");
            return sb.toString();
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof Nodes;
        }
    }

    public Nodes getNodes() {
        return this.nodes;
    }

    public void setNodes(Nodes nodes2) {
        this.nodes = nodes2;
    }

    public int hashCode() {
        Nodes nodes2 = getNodes();
        return (1 * 59) + (nodes2 == null ? 43 : nodes2.hashCode());
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof GetUserInfo;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof GetUserInfo)) {
            return false;
        }
        GetUserInfo other = (GetUserInfo) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Nodes nodes2 = getNodes();
        Object other$nodes = other.getNodes();
        if (nodes2 != null ? nodes2.equals(other$nodes) : other$nodes == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GetUserInfo(nodes=");
        sb.append(getNodes());
        sb.append(")");
        return sb.toString();
    }
}
