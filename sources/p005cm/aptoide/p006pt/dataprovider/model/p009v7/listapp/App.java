package p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Obb;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.listapp.App */
public class App {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Date added;
    private AppCoinsInfo appcoins;
    private File file;
    private String graphic;
    private String icon;

    /* renamed from: id */
    private long f53id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Date modified;
    private String name;
    private Obb obb;
    @JsonProperty("package")
    private String packageName;
    private long size;
    private Stats stats;
    private Store store;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Date updated;
    private String uptype;

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.listapp.App$Stats */
    public static class Stats {
        private int apps;
        private int downloads;
        private int pdownloads;
        private Rating rating;
        private int subscribers;

        /* renamed from: cm.aptoide.pt.dataprovider.model.v7.listapp.App$Stats$Rating */
        public static class Rating {
            private float avg;
            private int total;

            public float getAvg() {
                return this.avg;
            }

            public void setAvg(float avg2) {
                this.avg = avg2;
            }

            public int getTotal() {
                return this.total;
            }

            public void setTotal(int total2) {
                this.total = total2;
            }

            /* access modifiers changed from: protected */
            public boolean canEqual(Object other) {
                return other instanceof Rating;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof Rating)) {
                    return false;
                }
                Rating other = (Rating) o;
                if (other.canEqual(this) && Float.compare(getAvg(), other.getAvg()) == 0 && getTotal() == other.getTotal()) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return (((1 * 59) + Float.floatToIntBits(getAvg())) * 59) + getTotal();
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("App.Stats.Rating(avg=");
                sb.append(getAvg());
                sb.append(", total=");
                sb.append(getTotal());
                sb.append(")");
                return sb.toString();
            }
        }

        public int getApps() {
            return this.apps;
        }

        public void setApps(int apps2) {
            this.apps = apps2;
        }

        public int getSubscribers() {
            return this.subscribers;
        }

        public void setSubscribers(int subscribers2) {
            this.subscribers = subscribers2;
        }

        public int getDownloads() {
            return this.downloads;
        }

        public void setDownloads(int downloads2) {
            this.downloads = downloads2;
        }

        public int getPdownloads() {
            return this.pdownloads;
        }

        public void setPdownloads(int pdownloads2) {
            this.pdownloads = pdownloads2;
        }

        public Rating getRating() {
            return this.rating;
        }

        public void setRating(Rating rating2) {
            this.rating = rating2;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof Stats;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Stats)) {
                return false;
            }
            Stats other = (Stats) o;
            if (!other.canEqual(this) || getApps() != other.getApps() || getSubscribers() != other.getSubscribers() || getDownloads() != other.getDownloads() || getPdownloads() != other.getPdownloads()) {
                return false;
            }
            Rating rating2 = getRating();
            Object other$rating = other.getRating();
            if (rating2 != null ? rating2.equals(other$rating) : other$rating == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int result = (((((((1 * 59) + getApps()) * 59) + getSubscribers()) * 59) + getDownloads()) * 59) + getPdownloads();
            Rating rating2 = getRating();
            return (result * 59) + (rating2 == null ? 43 : rating2.hashCode());
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("App.Stats(apps=");
            sb.append(getApps());
            sb.append(", subscribers=");
            sb.append(getSubscribers());
            sb.append(", downloads=");
            sb.append(getDownloads());
            sb.append(", pdownloads=");
            sb.append(getPdownloads());
            sb.append(", rating=");
            sb.append(getRating());
            sb.append(")");
            return sb.toString();
        }
    }

    public long getId() {
        return this.f53id;
    }

    public void setId(long id) {
        this.f53id = id;
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

    public long getSize() {
        return this.size;
    }

    public void setSize(long size2) {
        this.size = size2;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon2) {
        this.icon = icon2;
    }

    public String getGraphic() {
        return this.graphic;
    }

    public void setGraphic(String graphic2) {
        this.graphic = graphic2;
    }

    public Date getAdded() {
        return this.added;
    }

    public void setAdded(Date added2) {
        this.added = added2;
    }

    public Date getModified() {
        return this.modified;
    }

    public void setModified(Date modified2) {
        this.modified = modified2;
    }

    public Date getUpdated() {
        return this.updated;
    }

    public void setUpdated(Date updated2) {
        this.updated = updated2;
    }

    public String getUptype() {
        return this.uptype;
    }

    public void setUptype(String uptype2) {
        this.uptype = uptype2;
    }

    public Store getStore() {
        return this.store;
    }

    public void setStore(Store store2) {
        this.store = store2;
    }

    public File getFile() {
        return this.file;
    }

    public void setFile(File file2) {
        this.file = file2;
    }

    public Stats getStats() {
        return this.stats;
    }

    public void setStats(Stats stats2) {
        this.stats = stats2;
    }

    public Obb getObb() {
        return this.obb;
    }

    public void setObb(Obb obb2) {
        this.obb = obb2;
    }

    public int hashCode() {
        long $id = getId();
        int result = (1 * 59) + ((int) (($id >>> 32) ^ $id));
        String name2 = getName();
        int i = 43;
        int result2 = (result * 59) + (name2 == null ? 43 : name2.hashCode());
        String packageName2 = getPackageName();
        int result3 = (result2 * 59) + (packageName2 == null ? 43 : packageName2.hashCode());
        long $size = getSize();
        int result4 = (result3 * 59) + ((int) (($size >>> 32) ^ $size));
        String icon2 = getIcon();
        int result5 = (result4 * 59) + (icon2 == null ? 43 : icon2.hashCode());
        String graphic2 = getGraphic();
        int result6 = (result5 * 59) + (graphic2 == null ? 43 : graphic2.hashCode());
        Date added2 = getAdded();
        int result7 = (result6 * 59) + (added2 == null ? 43 : added2.hashCode());
        Date modified2 = getModified();
        int result8 = (result7 * 59) + (modified2 == null ? 43 : modified2.hashCode());
        Date updated2 = getUpdated();
        int result9 = (result8 * 59) + (updated2 == null ? 43 : updated2.hashCode());
        String uptype2 = getUptype();
        int result10 = (result9 * 59) + (uptype2 == null ? 43 : uptype2.hashCode());
        Object $store = getStore();
        int result11 = (result10 * 59) + ($store == null ? 43 : $store.hashCode());
        File file2 = getFile();
        int result12 = (result11 * 59) + (file2 == null ? 43 : file2.hashCode());
        Stats stats2 = getStats();
        int result13 = (result12 * 59) + (stats2 == null ? 43 : stats2.hashCode());
        Obb obb2 = getObb();
        int i2 = result13 * 59;
        if (obb2 != null) {
            i = obb2.hashCode();
        }
        return i2 + i;
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof App;
    }

    public AppCoinsInfo getAppcoins() {
        return this.appcoins;
    }

    public void setAppcoinsInfo(AppCoinsInfo appcoins2) {
        this.appcoins = appcoins2;
    }

    public boolean hasBilling() {
        return getAppcoins() != null && getAppcoins().hasBilling();
    }

    public boolean hasAdvertising() {
        return getAppcoins() != null && getAppcoins().hasAdvertising();
    }

    public boolean equals(Object o) {
        Object obj = o;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof App)) {
            return false;
        }
        App other = (App) obj;
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
        if (getSize() != other.getSize()) {
            return false;
        }
        String icon2 = getIcon();
        Object other$icon = other.getIcon();
        if (icon2 != null ? !icon2.equals(other$icon) : other$icon != null) {
            return false;
        }
        String graphic2 = getGraphic();
        Object other$graphic = other.getGraphic();
        if (graphic2 != null ? !graphic2.equals(other$graphic) : other$graphic != null) {
            return false;
        }
        Date added2 = getAdded();
        Object other$added = other.getAdded();
        if (added2 != null ? !added2.equals(other$added) : other$added != null) {
            return false;
        }
        Date modified2 = getModified();
        Object other$modified = other.getModified();
        if (modified2 != null ? !modified2.equals(other$modified) : other$modified != null) {
            return false;
        }
        Date updated2 = getUpdated();
        Date updated3 = other.getUpdated();
        if (updated2 != null ? !updated2.equals(updated3) : updated3 != null) {
            return false;
        }
        Date date = updated3;
        String uptype2 = getUptype();
        String uptype3 = other.getUptype();
        if (uptype2 != null ? !uptype2.equals(uptype3) : uptype3 != null) {
            return false;
        }
        String str = uptype2;
        Store store2 = getStore();
        String str2 = uptype3;
        Store store3 = other.getStore();
        if (store2 != null ? !store2.equals(store3) : store3 != null) {
            return false;
        }
        Store store4 = store2;
        File file2 = getFile();
        Store store5 = store3;
        File file3 = other.getFile();
        if (file2 != null ? !file2.equals(file3) : file3 != null) {
            return false;
        }
        File file4 = file2;
        Stats stats2 = getStats();
        File file5 = file3;
        Stats stats3 = other.getStats();
        if (stats2 != null ? !stats2.equals(stats3) : stats3 != null) {
            return false;
        }
        Stats stats4 = stats2;
        Obb obb2 = getObb();
        Stats stats5 = stats3;
        Object other$obb = other.getObb();
        if (obb2 != null ? obb2.equals(other$obb) : other$obb == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("App(id=");
        sb.append(getId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", packageName=");
        sb.append(getPackageName());
        sb.append(", size=");
        sb.append(getSize());
        sb.append(", icon=");
        sb.append(getIcon());
        sb.append(", graphic=");
        sb.append(getGraphic());
        sb.append(", added=");
        sb.append(getAdded());
        sb.append(", modified=");
        sb.append(getModified());
        sb.append(", updated=");
        sb.append(getUpdated());
        sb.append(", uptype=");
        sb.append(getUptype());
        sb.append(", store=");
        sb.append(getStore());
        sb.append(", file=");
        sb.append(getFile());
        sb.append(", stats=");
        sb.append(getStats());
        sb.append(", obb=");
        sb.append(getObb());
        sb.append(")");
        return sb.toString();
    }
}
