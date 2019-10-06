package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7EndlessDataListResponse;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.post.RelatedAppResponse */
public final class RelatedAppResponse extends BaseV7EndlessDataListResponse<RelatedApp> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.post.RelatedAppResponse$RelatedApp */
    public static class RelatedApp {
        private String icon;

        /* renamed from: id */
        private long f59id;
        private String name;
        @JsonProperty("package")
        private String packageName;

        public long getId() {
            return this.f59id;
        }

        public void setId(long id) {
            this.f59id = id;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name2) {
            this.name = name2;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public void setPackageName(String packageName2) {
            this.packageName = packageName2;
        }

        public String getIcon() {
            return this.icon;
        }

        public void setIcon(String icon2) {
            this.icon = icon2;
        }

        public int hashCode() {
            long $id = getId();
            int result = (1 * 59) + ((int) (($id >>> 32) ^ $id));
            String name2 = getName();
            int i = 43;
            int result2 = (result * 59) + (name2 == null ? 43 : name2.hashCode());
            String packageName2 = getPackageName();
            int result3 = (result2 * 59) + (packageName2 == null ? 43 : packageName2.hashCode());
            String icon2 = getIcon();
            int i2 = result3 * 59;
            if (icon2 != null) {
                i = icon2.hashCode();
            }
            return i2 + i;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof RelatedApp)) {
                return false;
            }
            RelatedApp other = (RelatedApp) o;
            if (!other.canEqual(this) || getId() != other.getId()) {
                return false;
            }
            String name2 = getName();
            Object other$name = other.getName();
            if (name2 != null ? !name2.equals(other$name) : other$name != null) {
                return false;
            }
            String packageName2 = getPackageName();
            Object other$packageName = other.getPackageName();
            if (packageName2 != null ? !packageName2.equals(other$packageName) : other$packageName != null) {
                return false;
            }
            String icon2 = getIcon();
            Object other$icon = other.getIcon();
            if (icon2 != null ? icon2.equals(other$icon) : other$icon == null) {
                return true;
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("RelatedAppResponse.RelatedApp(id=");
            sb.append(getId());
            sb.append(", name=");
            sb.append(getName());
            sb.append(", packageName=");
            sb.append(getPackageName());
            sb.append(", icon=");
            sb.append(getIcon());
            sb.append(")");
            return sb.toString();
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof RelatedApp;
        }
    }
}
