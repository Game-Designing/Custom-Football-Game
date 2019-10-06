package p005cm.aptoide.p006pt.dataprovider.model.p009v7.store;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.List;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.store.Store */
public class Store {
    public static final String PUBLIC_ACCESS = "PUBLIC";
    private String access;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "UTC")
    private Date added;
    private Appearance appearance;
    private String avatar;
    private Badge badge;

    /* renamed from: id */
    private long f55id;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "UTC")
    private Date modified;
    private String name;
    @JsonProperty("links")
    private List<SocialChannel> socialChannels;
    private Stats stats;
    private String status;
    private Urls urls;

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.store.Store$Appearance */
    public static class Appearance {
        private String description;
        private String theme;

        public Appearance() {
        }

        public Appearance(String theme2, String description2) {
            this.theme = theme2;
            this.description = description2;
        }

        public String getTheme() {
            return this.theme;
        }

        public void setTheme(String theme2) {
            this.theme = theme2;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description2) {
            this.description = description2;
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.store.Store$Badge */
    public static class Badge {
        BadgeType name;

        public BadgeType getName() {
            return this.name;
        }

        public void setName(BadgeType name2) {
            this.name = name2;
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.store.Store$BadgeType */
    public enum BadgeType {
        NONE,
        BRONZE,
        SILVER,
        GOLD,
        PLATINUM
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.store.Store$SocialChannel */
    public static class SocialChannel {
        private String graphic;
        private String name;
        private SocialChannelType type;
        private String url;

        public SocialChannelType getType() {
            return this.type;
        }

        public void setType(SocialChannelType type2) {
            this.type = type2;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name2) {
            this.name = name2;
        }

        public String getGraphic() {
            return this.graphic;
        }

        public void setGraphic(String graphic2) {
            this.graphic = graphic2;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String url2) {
            this.url = url2;
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.store.Store$SocialChannelType */
    public enum SocialChannelType {
        FACEBOOK,
        TWITTER,
        YOUTUBE,
        TWITCH,
        BLOG
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.store.Store$Stats */
    public static class Stats {
        private int apps;
        private long downloads;
        private int subscribers;

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

        public long getDownloads() {
            return this.downloads;
        }

        public void setDownloads(long downloads2) {
            this.downloads = downloads2;
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.store.Store$Urls */
    public static class Urls {
        private String mobile;

        public String getMobile() {
            return this.mobile;
        }

        public void setMobile(String mobile2) {
            this.mobile = mobile2;
        }

        public int hashCode() {
            String mobile2 = getMobile();
            return (1 * 59) + (mobile2 == null ? 43 : mobile2.hashCode());
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
            String mobile2 = getMobile();
            Object other$mobile = other.getMobile();
            if (mobile2 != null ? mobile2.equals(other$mobile) : other$mobile == null) {
                return true;
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Store.Urls(mobile=");
            sb.append(getMobile());
            sb.append(")");
            return sb.toString();
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof Urls;
        }
    }

    public Badge getBadge() {
        return this.badge;
    }

    public void setBadge(Badge badge2) {
        this.badge = badge2;
    }

    public Urls getUrls() {
        return this.urls;
    }

    public void setUrls(Urls urls2) {
        this.urls = urls2;
    }

    public long getId() {
        return this.f55id;
    }

    public void setId(long id) {
        this.f55id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar2) {
        this.avatar = avatar2;
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

    public Appearance getAppearance() {
        return this.appearance;
    }

    public void setAppearance(Appearance appearance2) {
        this.appearance = appearance2;
    }

    public Stats getStats() {
        return this.stats;
    }

    public void setStats(Stats stats2) {
        this.stats = stats2;
    }

    public List<SocialChannel> getSocialChannels() {
        return this.socialChannels;
    }

    public void setSocialChannels(List<SocialChannel> socialChannels2) {
        this.socialChannels = socialChannels2;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status2) {
        this.status = status2;
    }

    public String getAccess() {
        return this.access;
    }

    public void setAccess(String access2) {
        this.access = access2;
    }
}
