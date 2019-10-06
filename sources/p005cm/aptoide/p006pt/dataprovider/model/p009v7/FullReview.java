package p005cm.aptoide.p006pt.dataprovider.model.p009v7;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.App;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.FullReview */
public class FullReview extends Review {
    private AppData data;

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.FullReview$AppData */
    public static class AppData {
        private App app;

        public App getApp() {
            return this.app;
        }

        public void setApp(App app2) {
            this.app = app2;
        }

        public int hashCode() {
            App app2 = getApp();
            return (1 * 59) + (app2 == null ? 43 : app2.hashCode());
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof AppData)) {
                return false;
            }
            AppData other = (AppData) o;
            if (!other.canEqual(this)) {
                return false;
            }
            App app2 = getApp();
            Object other$app = other.getApp();
            if (app2 != null ? app2.equals(other$app) : other$app == null) {
                return true;
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("FullReview.AppData(app=");
            sb.append(getApp());
            sb.append(")");
            return sb.toString();
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof AppData;
        }
    }

    public AppData getData() {
        return this.data;
    }

    public void setData(AppData data2) {
        this.data = data2;
    }

    public int hashCode() {
        int result = (1 * 59) + super.hashCode();
        AppData data2 = getData();
        return (result * 59) + (data2 == null ? 43 : data2.hashCode());
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof FullReview;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof FullReview)) {
            return false;
        }
        FullReview other = (FullReview) o;
        if (!other.canEqual(this) || !super.equals(o)) {
            return false;
        }
        AppData data2 = getData();
        Object other$data = other.getData();
        if (data2 != null ? data2.equals(other$data) : other$data == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FullReview(data=");
        sb.append(getData());
        sb.append(")");
        return sb.toString();
    }
}
