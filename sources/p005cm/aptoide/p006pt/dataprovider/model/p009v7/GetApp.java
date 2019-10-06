package p005cm.aptoide.p006pt.dataprovider.model.p009v7;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.ListAppVersions;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetApp */
public class GetApp extends BaseV7Response {
    private Nodes nodes;

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetApp$Nodes */
    public static class Nodes {
        private GroupDatalist groups;
        private GetAppMeta meta;
        private ListAppVersions versions;

        public GetAppMeta getMeta() {
            return this.meta;
        }

        public void setMeta(GetAppMeta meta2) {
            this.meta = meta2;
        }

        public ListAppVersions getVersions() {
            return this.versions;
        }

        public void setVersions(ListAppVersions versions2) {
            this.versions = versions2;
        }

        public GroupDatalist getGroups() {
            return this.groups;
        }

        public void setGroups(GroupDatalist groups2) {
            this.groups = groups2;
        }

        public int hashCode() {
            GetAppMeta meta2 = getMeta();
            int i = 43;
            int result = (1 * 59) + (meta2 == null ? 43 : meta2.hashCode());
            ListAppVersions versions2 = getVersions();
            int result2 = (result * 59) + (versions2 == null ? 43 : versions2.hashCode());
            GroupDatalist groups2 = getGroups();
            int i2 = result2 * 59;
            if (groups2 != null) {
                i = groups2.hashCode();
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
            GetAppMeta meta2 = getMeta();
            Object other$meta = other.getMeta();
            if (meta2 != null ? !meta2.equals(other$meta) : other$meta != null) {
                return false;
            }
            ListAppVersions versions2 = getVersions();
            Object other$versions = other.getVersions();
            if (versions2 != null ? !versions2.equals(other$versions) : other$versions != null) {
                return false;
            }
            GroupDatalist groups2 = getGroups();
            Object other$groups = other.getGroups();
            if (groups2 != null ? groups2.equals(other$groups) : other$groups == null) {
                return true;
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("GetApp.Nodes(meta=");
            sb.append(getMeta());
            sb.append(", versions=");
            sb.append(getVersions());
            sb.append(", groups=");
            sb.append(getGroups());
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
        int result = (1 * 59) + super.hashCode();
        Nodes nodes2 = getNodes();
        return (result * 59) + (nodes2 == null ? 43 : nodes2.hashCode());
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof GetApp;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof GetApp)) {
            return false;
        }
        GetApp other = (GetApp) o;
        if (!other.canEqual(this) || !super.equals(o)) {
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
        sb.append("GetApp(nodes=");
        sb.append(getNodes());
        sb.append(")");
        return sb.toString();
    }
}
