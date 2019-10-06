package p005cm.aptoide.p006pt.dataprovider.model.p009v7;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.AppCoinsInfo;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.File;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetAppMeta */
public class GetAppMeta extends BaseV7Response {
    private App data;

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetAppMeta$App */
    public static class App {
        private String added;
        private Age age;
        private AppCoinsInfo appcoins;
        private Developer developer;
        private GetAppMetaFile file;
        private String graphic;
        private String icon;

        /* renamed from: id */
        private long f48id;
        private Media media;
        private String modified;
        private String name;
        private Obb obb;
        @JsonProperty("package")
        private String packageName;
        private Pay pay;
        private long size;
        private Stats stats;
        private Store store;
        private Urls urls;

        public Age getAge() {
            return this.age;
        }

        public void setAge(Age age2) {
            this.age = age2;
        }

        public boolean isPaid() {
            Pay pay2 = this.pay;
            return pay2 != null && pay2.getPrice() > 0.0d;
        }

        public String getMd5() {
            GetAppMetaFile getAppMetaFile = this.file;
            return getAppMetaFile == null ? "" : getAppMetaFile.getMd5sum();
        }

        public long getId() {
            return this.f48id;
        }

        public void setId(long id) {
            this.f48id = id;
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

        public Developer getDeveloper() {
            return this.developer;
        }

        public void setDeveloper(Developer developer2) {
            this.developer = developer2;
        }

        public Store getStore() {
            return this.store;
        }

        public void setStore(Store store2) {
            this.store = store2;
        }

        public GetAppMetaFile getFile() {
            return this.file;
        }

        public void setFile(GetAppMetaFile file2) {
            this.file = file2;
        }

        public Media getMedia() {
            return this.media;
        }

        public void setMedia(Media media2) {
            this.media = media2;
        }

        public Urls getUrls() {
            return this.urls;
        }

        public void setUrls(Urls urls2) {
            this.urls = urls2;
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

        public Pay getPay() {
            return this.pay;
        }

        public void setPay(Pay pay2) {
            this.pay = pay2;
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
            String added2 = getAdded();
            int result7 = (result6 * 59) + (added2 == null ? 43 : added2.hashCode());
            String modified2 = getModified();
            int result8 = (result7 * 59) + (modified2 == null ? 43 : modified2.hashCode());
            Developer developer2 = getDeveloper();
            int result9 = (result8 * 59) + (developer2 == null ? 43 : developer2.hashCode());
            Object $store = getStore();
            int result10 = (result9 * 59) + ($store == null ? 43 : $store.hashCode());
            GetAppMetaFile file2 = getFile();
            int result11 = (result10 * 59) + (file2 == null ? 43 : file2.hashCode());
            Media media2 = getMedia();
            int result12 = (result11 * 59) + (media2 == null ? 43 : media2.hashCode());
            Urls urls2 = getUrls();
            int result13 = (result12 * 59) + (urls2 == null ? 43 : urls2.hashCode());
            Stats stats2 = getStats();
            int result14 = (result13 * 59) + (stats2 == null ? 43 : stats2.hashCode());
            Obb obb2 = getObb();
            int result15 = (result14 * 59) + (obb2 == null ? 43 : obb2.hashCode());
            Pay pay2 = getPay();
            int i2 = result15 * 59;
            if (pay2 != null) {
                i = pay2.hashCode();
            }
            return i2 + i;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof App;
        }

        public boolean hasBilling() {
            AppCoinsInfo appCoinsInfo = this.appcoins;
            return appCoinsInfo != null && appCoinsInfo.hasBilling();
        }

        public void setAppcoins(AppCoinsInfo appcoins2) {
            this.appcoins = appcoins2;
        }

        public boolean hasAdvertising() {
            AppCoinsInfo appCoinsInfo = this.appcoins;
            return appCoinsInfo != null && appCoinsInfo.hasAdvertising();
        }

        public List<String> getBdsFlags() {
            return this.appcoins.getFlags();
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
            String added2 = getAdded();
            Object other$added = other.getAdded();
            if (added2 != null ? !added2.equals(other$added) : other$added != null) {
                return false;
            }
            String modified2 = getModified();
            Object other$modified = other.getModified();
            if (modified2 != null ? !modified2.equals(other$modified) : other$modified != null) {
                return false;
            }
            Developer developer2 = getDeveloper();
            Developer developer3 = other.getDeveloper();
            if (developer2 != null ? !developer2.equals(developer3) : developer3 != null) {
                return false;
            }
            Developer developer4 = developer3;
            Store store2 = getStore();
            Store store3 = other.getStore();
            if (store2 != null ? !store2.equals(store3) : store3 != null) {
                return false;
            }
            Store store4 = store2;
            GetAppMetaFile file2 = getFile();
            Store store5 = store3;
            GetAppMetaFile file3 = other.getFile();
            if (file2 != null ? !file2.equals(file3) : file3 != null) {
                return false;
            }
            GetAppMetaFile getAppMetaFile = file2;
            Media media2 = getMedia();
            GetAppMetaFile getAppMetaFile2 = file3;
            Media media3 = other.getMedia();
            if (media2 != null ? !media2.equals(media3) : media3 != null) {
                return false;
            }
            Media media4 = media2;
            Urls urls2 = getUrls();
            Media media5 = media3;
            Urls urls3 = other.getUrls();
            if (urls2 != null ? !urls2.equals(urls3) : urls3 != null) {
                return false;
            }
            Urls urls4 = urls2;
            Stats stats2 = getStats();
            Urls urls5 = urls3;
            Stats stats3 = other.getStats();
            if (stats2 != null ? !stats2.equals(stats3) : stats3 != null) {
                return false;
            }
            Stats stats4 = stats2;
            Obb obb2 = getObb();
            Stats stats5 = stats3;
            Obb obb3 = other.getObb();
            if (obb2 != null ? !obb2.equals(obb3) : obb3 != null) {
                return false;
            }
            Obb obb4 = obb2;
            Pay pay2 = getPay();
            Obb obb5 = obb3;
            Object other$pay = other.getPay();
            if (pay2 != null ? pay2.equals(other$pay) : other$pay == null) {
                return true;
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("GetAppMeta.App(id=");
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
            sb.append(", developer=");
            sb.append(getDeveloper());
            sb.append(", store=");
            sb.append(getStore());
            sb.append(", file=");
            sb.append(getFile());
            sb.append(", media=");
            sb.append(getMedia());
            sb.append(", urls=");
            sb.append(getUrls());
            sb.append(", stats=");
            sb.append(getStats());
            sb.append(", obb=");
            sb.append(getObb());
            sb.append(", pay=");
            sb.append(getPay());
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetAppMeta$Stats */
    public static class Stats {
        private int downloads;
        @JsonProperty("prating")
        private Rating globalRating;
        private int pdownloads;
        private Rating rating;

        /* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetAppMeta$Stats$Rating */
        public static class Rating {
            private float avg;
            private int total;
            private List<Vote> votes;

            /* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetAppMeta$Stats$Rating$Vote */
            public static class Vote {
                private int count;
                private int value;

                public int getValue() {
                    return this.value;
                }

                public void setValue(int value2) {
                    this.value = value2;
                }

                public int getCount() {
                    return this.count;
                }

                public void setCount(int count2) {
                    this.count = count2;
                }

                /* access modifiers changed from: protected */
                public boolean canEqual(Object other) {
                    return other instanceof Vote;
                }

                public boolean equals(Object o) {
                    if (o == this) {
                        return true;
                    }
                    if (!(o instanceof Vote)) {
                        return false;
                    }
                    Vote other = (Vote) o;
                    if (other.canEqual(this) && getValue() == other.getValue() && getCount() == other.getCount()) {
                        return true;
                    }
                    return false;
                }

                public int hashCode() {
                    return (((1 * 59) + getValue()) * 59) + getCount();
                }

                public String toString() {
                    StringBuilder sb = new StringBuilder();
                    sb.append("GetAppMeta.Stats.Rating.Vote(value=");
                    sb.append(getValue());
                    sb.append(", count=");
                    sb.append(getCount());
                    sb.append(")");
                    return sb.toString();
                }
            }

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

            public List<Vote> getVotes() {
                return this.votes;
            }

            public void setVotes(List<Vote> votes2) {
                this.votes = votes2;
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
                if (!other.canEqual(this) || Float.compare(getAvg(), other.getAvg()) != 0 || getTotal() != other.getTotal()) {
                    return false;
                }
                Object this$votes = getVotes();
                Object other$votes = other.getVotes();
                if (this$votes != null ? this$votes.equals(other$votes) : other$votes == null) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                int result = (((1 * 59) + Float.floatToIntBits(getAvg())) * 59) + getTotal();
                Object $votes = getVotes();
                return (result * 59) + ($votes == null ? 43 : $votes.hashCode());
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("GetAppMeta.Stats.Rating(avg=");
                sb.append(getAvg());
                sb.append(", total=");
                sb.append(getTotal());
                sb.append(", votes=");
                sb.append(getVotes());
                sb.append(")");
                return sb.toString();
            }
        }

        public Rating getRating() {
            return this.rating;
        }

        public void setRating(Rating rating2) {
            this.rating = rating2;
        }

        public Rating getGlobalRating() {
            return this.globalRating;
        }

        public void setGlobalRating(Rating globalRating2) {
            this.globalRating = globalRating2;
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
            if (!other.canEqual(this)) {
                return false;
            }
            Rating rating2 = getRating();
            Object other$rating = other.getRating();
            if (rating2 != null ? !rating2.equals(other$rating) : other$rating != null) {
                return false;
            }
            Rating globalRating2 = getGlobalRating();
            Object other$globalRating = other.getGlobalRating();
            if (globalRating2 != null ? !globalRating2.equals(other$globalRating) : other$globalRating != null) {
                return false;
            }
            if (getDownloads() == other.getDownloads() && getPdownloads() == other.getPdownloads()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            Rating rating2 = getRating();
            int i = 43;
            int result = (1 * 59) + (rating2 == null ? 43 : rating2.hashCode());
            Rating globalRating2 = getGlobalRating();
            int i2 = result * 59;
            if (globalRating2 != null) {
                i = globalRating2.hashCode();
            }
            return ((((i2 + i) * 59) + getDownloads()) * 59) + getPdownloads();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("GetAppMeta.Stats(rating=");
            sb.append(getRating());
            sb.append(", globalRating=");
            sb.append(getGlobalRating());
            sb.append(", downloads=");
            sb.append(getDownloads());
            sb.append(", pdownloads=");
            sb.append(getPdownloads());
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetAppMeta$Age */
    public static class Age {
        private String name;
        private String pegi;
        private int rating;
        private String title;

        public String getName() {
            return this.name;
        }

        public void setName(String name2) {
            this.name = name2;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title2) {
            this.title = title2;
        }

        public String getPegi() {
            return this.pegi;
        }

        public void setPegi(String pegi2) {
            this.pegi = pegi2;
        }

        public int getRating() {
            return this.rating;
        }

        public void setRating(int rating2) {
            this.rating = rating2;
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetAppMeta$Developer */
    public static class Developer {
        private String email;
        private String name;
        private String privacy;
        private String website;

        public String getName() {
            return this.name;
        }

        public void setName(String name2) {
            this.name = name2;
        }

        public String getWebsite() {
            return this.website;
        }

        public void setWebsite(String website2) {
            this.website = website2;
        }

        public String getEmail() {
            return this.email;
        }

        public void setEmail(String email2) {
            this.email = email2;
        }

        public String getPrivacy() {
            return this.privacy;
        }

        public void setPrivacy(String privacy2) {
            this.privacy = privacy2;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof Developer;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Developer)) {
                return false;
            }
            Developer other = (Developer) o;
            if (!other.canEqual(this)) {
                return false;
            }
            String name2 = getName();
            Object other$name = other.getName();
            if (name2 != null ? !name2.equals(other$name) : other$name != null) {
                return false;
            }
            String website2 = getWebsite();
            Object other$website = other.getWebsite();
            if (website2 != null ? !website2.equals(other$website) : other$website != null) {
                return false;
            }
            String email2 = getEmail();
            Object other$email = other.getEmail();
            if (email2 != null ? !email2.equals(other$email) : other$email != null) {
                return false;
            }
            String privacy2 = getPrivacy();
            Object other$privacy = other.getPrivacy();
            if (privacy2 != null ? privacy2.equals(other$privacy) : other$privacy == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            String name2 = getName();
            int i = 43;
            int result = (1 * 59) + (name2 == null ? 43 : name2.hashCode());
            String website2 = getWebsite();
            int result2 = (result * 59) + (website2 == null ? 43 : website2.hashCode());
            String email2 = getEmail();
            int result3 = (result2 * 59) + (email2 == null ? 43 : email2.hashCode());
            String privacy2 = getPrivacy();
            int i2 = result3 * 59;
            if (privacy2 != null) {
                i = privacy2.hashCode();
            }
            return i2 + i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("GetAppMeta.Developer(name=");
            sb.append(getName());
            sb.append(", website=");
            sb.append(getWebsite());
            sb.append(", email=");
            sb.append(getEmail());
            sb.append(", privacy=");
            sb.append(getPrivacy());
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetAppMeta$GetAppMetaFile */
    public static class GetAppMetaFile extends File {
        private Flags flags;
        private Hardware hardware;
        private Malware malware;
        private Signature signature;
        private List<String> tags;
        private List<String> usedFeatures;
        private List<String> usedPermissions;

        /* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetAppMeta$GetAppMetaFile$Flags */
        public static class Flags {
            public static final String GOOD = "GOOD";
            public String review;
            private List<Vote> votes;

            /* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetAppMeta$GetAppMetaFile$Flags$Vote */
            public static class Vote {
                private int count;
                private Type type;

                /* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetAppMeta$GetAppMetaFile$Flags$Vote$Type */
                public enum Type {
                    FAKE,
                    FREEZE,
                    GOOD,
                    LICENSE,
                    VIRUS
                }

                public Type getType() {
                    return this.type;
                }

                public void setType(Type type2) {
                    this.type = type2;
                }

                public int getCount() {
                    return this.count;
                }

                public void setCount(int count2) {
                    this.count = count2;
                }

                /* access modifiers changed from: protected */
                public boolean canEqual(Object other) {
                    return other instanceof Vote;
                }

                public boolean equals(Object o) {
                    if (o == this) {
                        return true;
                    }
                    if (!(o instanceof Vote)) {
                        return false;
                    }
                    Vote other = (Vote) o;
                    if (!other.canEqual(this)) {
                        return false;
                    }
                    Type type2 = getType();
                    Object other$type = other.getType();
                    if (type2 != null ? !type2.equals(other$type) : other$type != null) {
                        return false;
                    }
                    if (getCount() != other.getCount()) {
                        return false;
                    }
                    return true;
                }

                public int hashCode() {
                    Type type2 = getType();
                    return (((1 * 59) + (type2 == null ? 43 : type2.hashCode())) * 59) + getCount();
                }

                public String toString() {
                    StringBuilder sb = new StringBuilder();
                    sb.append("GetAppMeta.GetAppMetaFile.Flags.Vote(type=");
                    sb.append(getType());
                    sb.append(", count=");
                    sb.append(getCount());
                    sb.append(")");
                    return sb.toString();
                }
            }

            public String getReview() {
                return this.review;
            }

            public void setReview(String review2) {
                this.review = review2;
            }

            public List<Vote> getVotes() {
                return this.votes;
            }

            public void setVotes(List<Vote> votes2) {
                this.votes = votes2;
            }

            /* access modifiers changed from: protected */
            public boolean canEqual(Object other) {
                return other instanceof Flags;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof Flags)) {
                    return false;
                }
                Flags other = (Flags) o;
                if (!other.canEqual(this)) {
                    return false;
                }
                String review2 = getReview();
                Object other$review = other.getReview();
                if (review2 != null ? !review2.equals(other$review) : other$review != null) {
                    return false;
                }
                Object this$votes = getVotes();
                Object other$votes = other.getVotes();
                if (this$votes != null ? this$votes.equals(other$votes) : other$votes == null) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                String review2 = getReview();
                int i = 43;
                int result = (1 * 59) + (review2 == null ? 43 : review2.hashCode());
                Object $votes = getVotes();
                int i2 = result * 59;
                if ($votes != null) {
                    i = $votes.hashCode();
                }
                return i2 + i;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("GetAppMeta.GetAppMetaFile.Flags(review=");
                sb.append(getReview());
                sb.append(", votes=");
                sb.append(getVotes());
                sb.append(")");
                return sb.toString();
            }
        }

        /* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetAppMeta$GetAppMetaFile$Hardware */
        public static class Hardware {
            private List<String> cpus;
            private List<List<Integer>> densities;
            private int gles;
            private String screen;
            private int sdk;

            public int getSdk() {
                return this.sdk;
            }

            public void setSdk(int sdk2) {
                this.sdk = sdk2;
            }

            public String getScreen() {
                return this.screen;
            }

            public void setScreen(String screen2) {
                this.screen = screen2;
            }

            public int getGles() {
                return this.gles;
            }

            public void setGles(int gles2) {
                this.gles = gles2;
            }

            public List<String> getCpus() {
                return this.cpus;
            }

            public void setCpus(List<String> cpus2) {
                this.cpus = cpus2;
            }

            public List<List<Integer>> getDensities() {
                return this.densities;
            }

            public void setDensities(List<List<Integer>> densities2) {
                this.densities = densities2;
            }

            /* access modifiers changed from: protected */
            public boolean canEqual(Object other) {
                return other instanceof Hardware;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof Hardware)) {
                    return false;
                }
                Hardware other = (Hardware) o;
                if (!other.canEqual(this) || getSdk() != other.getSdk()) {
                    return false;
                }
                String screen2 = getScreen();
                Object other$screen = other.getScreen();
                if (screen2 != null ? !screen2.equals(other$screen) : other$screen != null) {
                    return false;
                }
                if (getGles() != other.getGles()) {
                    return false;
                }
                Object this$cpus = getCpus();
                Object other$cpus = other.getCpus();
                if (this$cpus != null ? !this$cpus.equals(other$cpus) : other$cpus != null) {
                    return false;
                }
                Object this$densities = getDensities();
                Object other$densities = other.getDensities();
                if (this$densities != null ? this$densities.equals(other$densities) : other$densities == null) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                int result = (1 * 59) + getSdk();
                String screen2 = getScreen();
                int i = 43;
                int result2 = (((result * 59) + (screen2 == null ? 43 : screen2.hashCode())) * 59) + getGles();
                Object $cpus = getCpus();
                int result3 = (result2 * 59) + ($cpus == null ? 43 : $cpus.hashCode());
                Object $densities = getDensities();
                int i2 = result3 * 59;
                if ($densities != null) {
                    i = $densities.hashCode();
                }
                return i2 + i;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("GetAppMeta.GetAppMetaFile.Hardware(sdk=");
                sb.append(getSdk());
                sb.append(", screen=");
                sb.append(getScreen());
                sb.append(", gles=");
                sb.append(getGles());
                sb.append(", cpus=");
                sb.append(getCpus());
                sb.append(", densities=");
                sb.append(getDensities());
                sb.append(")");
                return sb.toString();
            }
        }

        /* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetAppMeta$GetAppMetaFile$Signature */
        public static class Signature {
            private String owner;
            private String sha1;

            public String getSha1() {
                return this.sha1;
            }

            public void setSha1(String sha12) {
                this.sha1 = sha12;
            }

            public String getOwner() {
                return this.owner;
            }

            public void setOwner(String owner2) {
                this.owner = owner2;
            }

            /* access modifiers changed from: protected */
            public boolean canEqual(Object other) {
                return other instanceof Signature;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof Signature)) {
                    return false;
                }
                Signature other = (Signature) o;
                if (!other.canEqual(this)) {
                    return false;
                }
                String sha12 = getSha1();
                Object other$sha1 = other.getSha1();
                if (sha12 != null ? !sha12.equals(other$sha1) : other$sha1 != null) {
                    return false;
                }
                String owner2 = getOwner();
                Object other$owner = other.getOwner();
                if (owner2 != null ? owner2.equals(other$owner) : other$owner == null) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                String sha12 = getSha1();
                int i = 43;
                int result = (1 * 59) + (sha12 == null ? 43 : sha12.hashCode());
                String owner2 = getOwner();
                int i2 = result * 59;
                if (owner2 != null) {
                    i = owner2.hashCode();
                }
                return i2 + i;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("GetAppMeta.GetAppMetaFile.Signature(sha1=");
                sb.append(getSha1());
                sb.append(", owner=");
                sb.append(getOwner());
                sb.append(")");
                return sb.toString();
            }
        }

        public boolean isGoodApp() {
            Flags flags2 = this.flags;
            if (flags2 != null) {
                String str = flags2.review;
                if (str != null && str.equalsIgnoreCase(Flags.GOOD)) {
                    return true;
                }
            }
            return false;
        }

        public Signature getSignature() {
            return this.signature;
        }

        public void setSignature(Signature signature2) {
            this.signature = signature2;
        }

        public Hardware getHardware() {
            return this.hardware;
        }

        public void setHardware(Hardware hardware2) {
            this.hardware = hardware2;
        }

        public Malware getMalware() {
            return this.malware;
        }

        public void setMalware(Malware malware2) {
            this.malware = malware2;
        }

        public int hashCode() {
            int result = (1 * 59) + super.hashCode();
            Signature signature2 = getSignature();
            int i = 43;
            int result2 = (result * 59) + (signature2 == null ? 43 : signature2.hashCode());
            Hardware hardware2 = getHardware();
            int result3 = (result2 * 59) + (hardware2 == null ? 43 : hardware2.hashCode());
            Malware malware2 = getMalware();
            int result4 = (result3 * 59) + (malware2 == null ? 43 : malware2.hashCode());
            Flags flags2 = getFlags();
            int result5 = (result4 * 59) + (flags2 == null ? 43 : flags2.hashCode());
            Object $usedFeatures = getUsedFeatures();
            int result6 = (result5 * 59) + ($usedFeatures == null ? 43 : $usedFeatures.hashCode());
            Object $usedPermissions = getUsedPermissions();
            int result7 = (result6 * 59) + ($usedPermissions == null ? 43 : $usedPermissions.hashCode());
            Object $tags = getTags();
            int i2 = result7 * 59;
            if ($tags != null) {
                i = $tags.hashCode();
            }
            return i2 + i;
        }

        public boolean equals(Object o) {
            Object obj = o;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GetAppMetaFile)) {
                return false;
            }
            GetAppMetaFile other = (GetAppMetaFile) obj;
            if (!other.canEqual(this) || !super.equals(o)) {
                return false;
            }
            Signature signature2 = getSignature();
            Object other$signature = other.getSignature();
            if (signature2 != null ? !signature2.equals(other$signature) : other$signature != null) {
                return false;
            }
            Hardware hardware2 = getHardware();
            Object other$hardware = other.getHardware();
            if (hardware2 != null ? !hardware2.equals(other$hardware) : other$hardware != null) {
                return false;
            }
            Malware malware2 = getMalware();
            Object other$malware = other.getMalware();
            if (malware2 != null ? !malware2.equals(other$malware) : other$malware != null) {
                return false;
            }
            Flags flags2 = getFlags();
            Object other$flags = other.getFlags();
            if (flags2 != null ? !flags2.equals(other$flags) : other$flags != null) {
                return false;
            }
            Object this$usedFeatures = getUsedFeatures();
            Object other$usedFeatures = other.getUsedFeatures();
            if (this$usedFeatures != null ? !this$usedFeatures.equals(other$usedFeatures) : other$usedFeatures != null) {
                return false;
            }
            Object this$usedPermissions = getUsedPermissions();
            Object other$usedPermissions = other.getUsedPermissions();
            if (this$usedPermissions != null ? !this$usedPermissions.equals(other$usedPermissions) : other$usedPermissions != null) {
                return false;
            }
            Object this$tags = getTags();
            Object other$tags = other.getTags();
            if (this$tags != null ? this$tags.equals(other$tags) : other$tags == null) {
                return true;
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("GetAppMeta.GetAppMetaFile(signature=");
            sb.append(getSignature());
            sb.append(", hardware=");
            sb.append(getHardware());
            sb.append(", malware=");
            sb.append(getMalware());
            sb.append(", flags=");
            sb.append(getFlags());
            sb.append(", usedFeatures=");
            sb.append(getUsedFeatures());
            sb.append(", usedPermissions=");
            sb.append(getUsedPermissions());
            sb.append(", tags=");
            sb.append(getTags());
            sb.append(")");
            return sb.toString();
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof GetAppMetaFile;
        }

        public Flags getFlags() {
            return this.flags;
        }

        public void setFlags(Flags flags2) {
            this.flags = flags2;
        }

        public List<String> getUsedFeatures() {
            return this.usedFeatures;
        }

        public void setUsedFeatures(List<String> usedFeatures2) {
            this.usedFeatures = usedFeatures2;
        }

        public List<String> getUsedPermissions() {
            return this.usedPermissions;
        }

        public void setUsedPermissions(List<String> usedPermissions2) {
            this.usedPermissions = usedPermissions2;
        }

        public List<String> getTags() {
            return this.tags;
        }

        public void setTags(List<String> tags2) {
            this.tags = tags2;
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetAppMeta$Media */
    public static class Media {
        private String description;
        private List<String> keywords;
        private String news;
        private List<Screenshot> screenshots;
        private List<Video> videos;

        /* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetAppMeta$Media$Screenshot */
        public static class Screenshot {
            private int height;
            private String url;
            private int width;

            public String getOrientation() {
                return this.height > this.width ? "portrait" : "landscape";
            }

            public String getUrl() {
                return this.url;
            }

            public void setUrl(String url2) {
                this.url = url2;
            }

            public int getHeight() {
                return this.height;
            }

            public void setHeight(int height2) {
                this.height = height2;
            }

            public int getWidth() {
                return this.width;
            }

            public void setWidth(int width2) {
                this.width = width2;
            }

            /* access modifiers changed from: protected */
            public boolean canEqual(Object other) {
                return other instanceof Screenshot;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof Screenshot)) {
                    return false;
                }
                Screenshot other = (Screenshot) o;
                if (!other.canEqual(this)) {
                    return false;
                }
                String url2 = getUrl();
                Object other$url = other.getUrl();
                if (url2 != null ? !url2.equals(other$url) : other$url != null) {
                    return false;
                }
                if (getHeight() == other.getHeight() && getWidth() == other.getWidth()) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                String url2 = getUrl();
                return (((((1 * 59) + (url2 == null ? 43 : url2.hashCode())) * 59) + getHeight()) * 59) + getWidth();
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("GetAppMeta.Media.Screenshot(url=");
                sb.append(getUrl());
                sb.append(", height=");
                sb.append(getHeight());
                sb.append(", width=");
                sb.append(getWidth());
                sb.append(")");
                return sb.toString();
            }
        }

        /* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetAppMeta$Media$Video */
        public static class Video {
            private String thumbnail;
            private String type;
            private String url;

            public String getType() {
                return this.type;
            }

            public void setType(String type2) {
                this.type = type2;
            }

            public String getUrl() {
                return this.url;
            }

            public void setUrl(String url2) {
                this.url = url2;
            }

            public String getThumbnail() {
                return this.thumbnail;
            }

            public void setThumbnail(String thumbnail2) {
                this.thumbnail = thumbnail2;
            }

            /* access modifiers changed from: protected */
            public boolean canEqual(Object other) {
                return other instanceof Video;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof Video)) {
                    return false;
                }
                Video other = (Video) o;
                if (!other.canEqual(this)) {
                    return false;
                }
                String type2 = getType();
                Object other$type = other.getType();
                if (type2 != null ? !type2.equals(other$type) : other$type != null) {
                    return false;
                }
                String url2 = getUrl();
                Object other$url = other.getUrl();
                if (url2 != null ? !url2.equals(other$url) : other$url != null) {
                    return false;
                }
                String thumbnail2 = getThumbnail();
                Object other$thumbnail = other.getThumbnail();
                if (thumbnail2 != null ? thumbnail2.equals(other$thumbnail) : other$thumbnail == null) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                String type2 = getType();
                int i = 43;
                int result = (1 * 59) + (type2 == null ? 43 : type2.hashCode());
                String url2 = getUrl();
                int result2 = (result * 59) + (url2 == null ? 43 : url2.hashCode());
                String thumbnail2 = getThumbnail();
                int i2 = result2 * 59;
                if (thumbnail2 != null) {
                    i = thumbnail2.hashCode();
                }
                return i2 + i;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("GetAppMeta.Media.Video(type=");
                sb.append(getType());
                sb.append(", url=");
                sb.append(getUrl());
                sb.append(", thumbnail=");
                sb.append(getThumbnail());
                sb.append(")");
                return sb.toString();
            }
        }

        public List<String> getKeywords() {
            return this.keywords;
        }

        public void setKeywords(List<String> keywords2) {
            this.keywords = keywords2;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description2) {
            this.description = description2;
        }

        public String getNews() {
            return this.news;
        }

        public void setNews(String news2) {
            this.news = news2;
        }

        public List<Screenshot> getScreenshots() {
            return this.screenshots;
        }

        public void setScreenshots(List<Screenshot> screenshots2) {
            this.screenshots = screenshots2;
        }

        public List<Video> getVideos() {
            return this.videos;
        }

        public void setVideos(List<Video> videos2) {
            this.videos = videos2;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof Media;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Media)) {
                return false;
            }
            Media other = (Media) o;
            if (!other.canEqual(this)) {
                return false;
            }
            Object this$keywords = getKeywords();
            Object other$keywords = other.getKeywords();
            if (this$keywords != null ? !this$keywords.equals(other$keywords) : other$keywords != null) {
                return false;
            }
            String description2 = getDescription();
            Object other$description = other.getDescription();
            if (description2 != null ? !description2.equals(other$description) : other$description != null) {
                return false;
            }
            String news2 = getNews();
            Object other$news = other.getNews();
            if (news2 != null ? !news2.equals(other$news) : other$news != null) {
                return false;
            }
            Object this$screenshots = getScreenshots();
            Object other$screenshots = other.getScreenshots();
            if (this$screenshots != null ? !this$screenshots.equals(other$screenshots) : other$screenshots != null) {
                return false;
            }
            Object this$videos = getVideos();
            Object other$videos = other.getVideos();
            if (this$videos != null ? this$videos.equals(other$videos) : other$videos == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            Object $keywords = getKeywords();
            int i = 43;
            int result = (1 * 59) + ($keywords == null ? 43 : $keywords.hashCode());
            String description2 = getDescription();
            int result2 = (result * 59) + (description2 == null ? 43 : description2.hashCode());
            String news2 = getNews();
            int result3 = (result2 * 59) + (news2 == null ? 43 : news2.hashCode());
            Object $screenshots = getScreenshots();
            int result4 = (result3 * 59) + ($screenshots == null ? 43 : $screenshots.hashCode());
            Object $videos = getVideos();
            int i2 = result4 * 59;
            if ($videos != null) {
                i = $videos.hashCode();
            }
            return i2 + i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("GetAppMeta.Media(keywords=");
            sb.append(getKeywords());
            sb.append(", description=");
            sb.append(getDescription());
            sb.append(", news=");
            sb.append(getNews());
            sb.append(", screenshots=");
            sb.append(getScreenshots());
            sb.append(", videos=");
            sb.append(getVideos());
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetAppMeta$Pay */
    public static class Pay {
        private String currency;
        private double price;
        private String status;
        private String symbol;

        public boolean isPaid() {
            return "OK".equalsIgnoreCase(this.status);
        }

        public void setPaid() {
            this.status = "OK";
        }

        public double getPrice() {
            return this.price;
        }

        public void setPrice(double price2) {
            this.price = price2;
        }

        public String getSymbol() {
            return this.symbol;
        }

        public void setSymbol(String symbol2) {
            this.symbol = symbol2;
        }

        public String getCurrency() {
            return this.currency;
        }

        public void setCurrency(String currency2) {
            this.currency = currency2;
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String status2) {
            this.status = status2;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof Pay;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Pay)) {
                return false;
            }
            Pay other = (Pay) o;
            if (!other.canEqual(this) || Double.compare(getPrice(), other.getPrice()) != 0) {
                return false;
            }
            String symbol2 = getSymbol();
            Object other$symbol = other.getSymbol();
            if (symbol2 != null ? !symbol2.equals(other$symbol) : other$symbol != null) {
                return false;
            }
            String currency2 = getCurrency();
            Object other$currency = other.getCurrency();
            if (currency2 != null ? !currency2.equals(other$currency) : other$currency != null) {
                return false;
            }
            String status2 = getStatus();
            Object other$status = other.getStatus();
            if (status2 != null ? status2.equals(other$status) : other$status == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            long $price = Double.doubleToLongBits(getPrice());
            int result = (1 * 59) + ((int) (($price >>> 32) ^ $price));
            String symbol2 = getSymbol();
            int i = 43;
            int result2 = (result * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
            String currency2 = getCurrency();
            int result3 = (result2 * 59) + (currency2 == null ? 43 : currency2.hashCode());
            String status2 = getStatus();
            int i2 = result3 * 59;
            if (status2 != null) {
                i = status2.hashCode();
            }
            return i2 + i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("GetAppMeta.Pay(price=");
            sb.append(getPrice());
            sb.append(", symbol=");
            sb.append(getSymbol());
            sb.append(", currency=");
            sb.append(getCurrency());
            sb.append(", status=");
            sb.append(getStatus());
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetAppMeta$Urls */
    public static class Urls {

        /* renamed from: m */
        private String f6085m;

        /* renamed from: w */
        private String f6086w;

        public String getW() {
            return this.f6086w;
        }

        public void setW(String w) {
            this.f6086w = w;
        }

        public String getM() {
            return this.f6085m;
        }

        public void setM(String m) {
            this.f6085m = m;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof Urls;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Urls)) {
                return false;
            }
            Urls other = (Urls) o;
            if (!other.canEqual(this)) {
                return false;
            }
            String w = getW();
            Object other$w = other.getW();
            if (w != null ? !w.equals(other$w) : other$w != null) {
                return false;
            }
            String m = getM();
            Object other$m = other.getM();
            if (m != null ? m.equals(other$m) : other$m == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            String w = getW();
            int i = 43;
            int result = (1 * 59) + (w == null ? 43 : w.hashCode());
            String m = getM();
            int i2 = result * 59;
            if (m != null) {
                i = m.hashCode();
            }
            return i2 + i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("GetAppMeta.Urls(w=");
            sb.append(getW());
            sb.append(", m=");
            sb.append(getM());
            sb.append(")");
            return sb.toString();
        }
    }

    public App getData() {
        return this.data;
    }

    public void setData(App data2) {
        this.data = data2;
    }

    public int hashCode() {
        int result = (1 * 59) + super.hashCode();
        App data2 = getData();
        return (result * 59) + (data2 == null ? 43 : data2.hashCode());
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof GetAppMeta;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof GetAppMeta)) {
            return false;
        }
        GetAppMeta other = (GetAppMeta) o;
        if (!other.canEqual(this) || !super.equals(o)) {
            return false;
        }
        App data2 = getData();
        Object other$data = other.getData();
        if (data2 != null ? data2.equals(other$data) : other$data == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GetAppMeta(data=");
        sb.append(getData());
        sb.append(")");
        return sb.toString();
    }
}
