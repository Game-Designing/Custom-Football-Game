package p005cm.aptoide.p006pt.dataprovider.model.p007v2;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.List;

/* renamed from: cm.aptoide.pt.dataprovider.model.v2.GetAdsResponse */
public class GetAdsResponse {
    private List<C2842Ad> ads;
    private Options options;

    /* renamed from: cm.aptoide.pt.dataprovider.model.v2.GetAdsResponse$Data */
    public static class Data {
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
        private Date added;
        private String description;
        private int downloads;
        private String icon;

        /* renamed from: id */
        private long f40id;
        private String md5sum;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
        private Date modified;
        private String name;
        @JsonProperty("package")
        private String packageName;
        private String repo;
        private long size;
        private int stars;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
        private Date updated;
        private int vercode;
        private String vername;

        public long getId() {
            return this.f40id;
        }

        public void setId(long id) {
            this.f40id = id;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name2) {
            this.name = name2;
        }

        public String getRepo() {
            return this.repo;
        }

        public void setRepo(String repo2) {
            this.repo = repo2;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public void setPackageName(String packageName2) {
            this.packageName = packageName2;
        }

        public String getMd5sum() {
            return this.md5sum;
        }

        public void setMd5sum(String md5sum2) {
            this.md5sum = md5sum2;
        }

        public long getSize() {
            return this.size;
        }

        public void setSize(long size2) {
            this.size = size2;
        }

        public int getVercode() {
            return this.vercode;
        }

        public void setVercode(int vercode2) {
            this.vercode = vercode2;
        }

        public String getVername() {
            return this.vername;
        }

        public void setVername(String vername2) {
            this.vername = vername2;
        }

        public String getIcon() {
            return this.icon;
        }

        public void setIcon(String icon2) {
            this.icon = icon2;
        }

        public int getDownloads() {
            return this.downloads;
        }

        public void setDownloads(int downloads2) {
            this.downloads = downloads2;
        }

        public int getStars() {
            return this.stars;
        }

        public void setStars(int stars2) {
            this.stars = stars2;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description2) {
            this.description = description2;
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

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof Data;
        }

        public boolean equals(Object o) {
            Object obj = o;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Data)) {
                return false;
            }
            Data other = (Data) obj;
            if (!other.canEqual(this) || getId() != other.getId()) {
                return false;
            }
            String name2 = getName();
            Object other$name = other.getName();
            if (name2 != null ? !name2.equals(other$name) : other$name != null) {
                return false;
            }
            String repo2 = getRepo();
            Object other$repo = other.getRepo();
            if (repo2 != null ? !repo2.equals(other$repo) : other$repo != null) {
                return false;
            }
            String packageName2 = getPackageName();
            Object other$packageName = other.getPackageName();
            if (packageName2 != null ? !packageName2.equals(other$packageName) : other$packageName != null) {
                return false;
            }
            String md5sum2 = getMd5sum();
            Object other$md5sum = other.getMd5sum();
            if (md5sum2 != null ? !md5sum2.equals(other$md5sum) : other$md5sum != null) {
                return false;
            }
            if (getSize() != other.getSize() || getVercode() != other.getVercode()) {
                return false;
            }
            String vername2 = getVername();
            Object other$vername = other.getVername();
            if (vername2 != null ? !vername2.equals(other$vername) : other$vername != null) {
                return false;
            }
            String icon2 = getIcon();
            Object other$icon = other.getIcon();
            if (icon2 != null ? !icon2.equals(other$icon) : other$icon != null) {
                return false;
            }
            if (getDownloads() != other.getDownloads()) {
                return false;
            }
            if (getStars() != other.getStars()) {
                return false;
            }
            String description2 = getDescription();
            Object other$description = other.getDescription();
            if (description2 != null ? !description2.equals(other$description) : other$description != null) {
                return false;
            }
            String str = description2;
            Date added2 = getAdded();
            Date added3 = other.getAdded();
            if (added2 != null ? !added2.equals(added3) : added3 != null) {
                return false;
            }
            Date date = added2;
            Date modified2 = getModified();
            Date date2 = added3;
            Date modified3 = other.getModified();
            if (modified2 != null ? !modified2.equals(modified3) : modified3 != null) {
                return false;
            }
            Date date3 = modified2;
            Date updated2 = getUpdated();
            Date date4 = modified3;
            Object other$modified = other.getUpdated();
            if (updated2 != null ? updated2.equals(other$modified) : other$modified == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            long $id = getId();
            int result = (1 * 59) + ((int) (($id >>> 32) ^ $id));
            String name2 = getName();
            int i = 43;
            int result2 = (result * 59) + (name2 == null ? 43 : name2.hashCode());
            String repo2 = getRepo();
            int result3 = (result2 * 59) + (repo2 == null ? 43 : repo2.hashCode());
            String packageName2 = getPackageName();
            int result4 = (result3 * 59) + (packageName2 == null ? 43 : packageName2.hashCode());
            String md5sum2 = getMd5sum();
            int result5 = (result4 * 59) + (md5sum2 == null ? 43 : md5sum2.hashCode());
            long $size = getSize();
            int result6 = (((result5 * 59) + ((int) (($size >>> 32) ^ $size))) * 59) + getVercode();
            String vername2 = getVername();
            int result7 = (result6 * 59) + (vername2 == null ? 43 : vername2.hashCode());
            String icon2 = getIcon();
            int result8 = (((((result7 * 59) + (icon2 == null ? 43 : icon2.hashCode())) * 59) + getDownloads()) * 59) + getStars();
            String description2 = getDescription();
            int result9 = (result8 * 59) + (description2 == null ? 43 : description2.hashCode());
            Date added2 = getAdded();
            int result10 = (result9 * 59) + (added2 == null ? 43 : added2.hashCode());
            Date modified2 = getModified();
            int result11 = (result10 * 59) + (modified2 == null ? 43 : modified2.hashCode());
            Date updated2 = getUpdated();
            int i2 = result11 * 59;
            if (updated2 != null) {
                i = updated2.hashCode();
            }
            return i2 + i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("GetAdsResponse.Data(id=");
            sb.append(getId());
            sb.append(", name=");
            sb.append(getName());
            sb.append(", repo=");
            sb.append(getRepo());
            sb.append(", packageName=");
            sb.append(getPackageName());
            sb.append(", md5sum=");
            sb.append(getMd5sum());
            sb.append(", size=");
            sb.append(getSize());
            sb.append(", vercode=");
            sb.append(getVercode());
            sb.append(", vername=");
            sb.append(getVername());
            sb.append(", icon=");
            sb.append(getIcon());
            sb.append(", downloads=");
            sb.append(getDownloads());
            sb.append(", stars=");
            sb.append(getStars());
            sb.append(", description=");
            sb.append(getDescription());
            sb.append(", added=");
            sb.append(getAdded());
            sb.append(", modified=");
            sb.append(getModified());
            sb.append(", updated=");
            sb.append(getUpdated());
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v2.GetAdsResponse$Ad */
    public static class C2842Ad {
        private Data data;
        private Info info;
        private Partner partner;
        private Partner tracker;

        public Data getData() {
            return this.data;
        }

        public void setData(Data data2) {
            this.data = data2;
        }

        public Info getInfo() {
            return this.info;
        }

        public void setInfo(Info info2) {
            this.info = info2;
        }

        public Partner getPartner() {
            return this.partner;
        }

        public void setPartner(Partner partner2) {
            this.partner = partner2;
        }

        public Partner getTracker() {
            return this.tracker;
        }

        public void setTracker(Partner tracker2) {
            this.tracker = tracker2;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof C2842Ad;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C2842Ad)) {
                return false;
            }
            C2842Ad other = (C2842Ad) o;
            if (!other.canEqual(this)) {
                return false;
            }
            Data data2 = getData();
            Object other$data = other.getData();
            if (data2 != null ? !data2.equals(other$data) : other$data != null) {
                return false;
            }
            Info info2 = getInfo();
            Object other$info = other.getInfo();
            if (info2 != null ? !info2.equals(other$info) : other$info != null) {
                return false;
            }
            Partner partner2 = getPartner();
            Object other$partner = other.getPartner();
            if (partner2 != null ? !partner2.equals(other$partner) : other$partner != null) {
                return false;
            }
            Partner tracker2 = getTracker();
            Object other$tracker = other.getTracker();
            if (tracker2 != null ? tracker2.equals(other$tracker) : other$tracker == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            Data data2 = getData();
            int i = 43;
            int result = (1 * 59) + (data2 == null ? 43 : data2.hashCode());
            Info info2 = getInfo();
            int result2 = (result * 59) + (info2 == null ? 43 : info2.hashCode());
            Partner partner2 = getPartner();
            int result3 = (result2 * 59) + (partner2 == null ? 43 : partner2.hashCode());
            Partner tracker2 = getTracker();
            int i2 = result3 * 59;
            if (tracker2 != null) {
                i = tracker2.hashCode();
            }
            return i2 + i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("GetAdsResponse.Ad(data=");
            sb.append(getData());
            sb.append(", info=");
            sb.append(getInfo());
            sb.append(", partner=");
            sb.append(getPartner());
            sb.append(", tracker=");
            sb.append(getTracker());
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v2.GetAdsResponse$Info */
    public static class Info {
        private long adId;
        private String adType;
        private String cpcUrl;
        private String cpdUrl;
        private String cpiUrl;

        public long getAdId() {
            return this.adId;
        }

        public void setAdId(long adId2) {
            this.adId = adId2;
        }

        public String getAdType() {
            return this.adType;
        }

        public void setAdType(String adType2) {
            this.adType = adType2;
        }

        public String getCpcUrl() {
            return this.cpcUrl;
        }

        public void setCpcUrl(String cpcUrl2) {
            this.cpcUrl = cpcUrl2;
        }

        public String getCpiUrl() {
            return this.cpiUrl;
        }

        public void setCpiUrl(String cpiUrl2) {
            this.cpiUrl = cpiUrl2;
        }

        public String getCpdUrl() {
            return this.cpdUrl;
        }

        public void setCpdUrl(String cpdUrl2) {
            this.cpdUrl = cpdUrl2;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof Info;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Info)) {
                return false;
            }
            Info other = (Info) o;
            if (!other.canEqual(this) || getAdId() != other.getAdId()) {
                return false;
            }
            String adType2 = getAdType();
            Object other$adType = other.getAdType();
            if (adType2 != null ? !adType2.equals(other$adType) : other$adType != null) {
                return false;
            }
            String cpcUrl2 = getCpcUrl();
            Object other$cpcUrl = other.getCpcUrl();
            if (cpcUrl2 != null ? !cpcUrl2.equals(other$cpcUrl) : other$cpcUrl != null) {
                return false;
            }
            String cpiUrl2 = getCpiUrl();
            Object other$cpiUrl = other.getCpiUrl();
            if (cpiUrl2 != null ? !cpiUrl2.equals(other$cpiUrl) : other$cpiUrl != null) {
                return false;
            }
            String cpdUrl2 = getCpdUrl();
            Object other$cpdUrl = other.getCpdUrl();
            if (cpdUrl2 != null ? cpdUrl2.equals(other$cpdUrl) : other$cpdUrl == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            long $adId = getAdId();
            int result = (1 * 59) + ((int) (($adId >>> 32) ^ $adId));
            String adType2 = getAdType();
            int i = 43;
            int result2 = (result * 59) + (adType2 == null ? 43 : adType2.hashCode());
            String cpcUrl2 = getCpcUrl();
            int result3 = (result2 * 59) + (cpcUrl2 == null ? 43 : cpcUrl2.hashCode());
            String cpiUrl2 = getCpiUrl();
            int result4 = (result3 * 59) + (cpiUrl2 == null ? 43 : cpiUrl2.hashCode());
            String cpdUrl2 = getCpdUrl();
            int i2 = result4 * 59;
            if (cpdUrl2 != null) {
                i = cpdUrl2.hashCode();
            }
            return i2 + i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("GetAdsResponse.Info(adId=");
            sb.append(getAdId());
            sb.append(", adType=");
            sb.append(getAdType());
            sb.append(", cpcUrl=");
            sb.append(getCpcUrl());
            sb.append(", cpiUrl=");
            sb.append(getCpiUrl());
            sb.append(", cpdUrl=");
            sb.append(getCpdUrl());
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v2.GetAdsResponse$Options */
    public static class Options {
        private Boolean mediation = Boolean.valueOf(true);

        public Boolean getMediation() {
            return this.mediation;
        }

        public void setMediation(Boolean mediation2) {
            this.mediation = mediation2;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof Options;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Options)) {
                return false;
            }
            Options other = (Options) o;
            if (!other.canEqual(this)) {
                return false;
            }
            Boolean mediation2 = getMediation();
            Object other$mediation = other.getMediation();
            if (mediation2 != null ? mediation2.equals(other$mediation) : other$mediation == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            Boolean mediation2 = getMediation();
            return (1 * 59) + (mediation2 == null ? 43 : mediation2.hashCode());
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("GetAdsResponse.Options(mediation=");
            sb.append(getMediation());
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v2.GetAdsResponse$Partner */
    public static class Partner {
        private Data data;
        private Info info;

        /* renamed from: cm.aptoide.pt.dataprovider.model.v2.GetAdsResponse$Partner$Data */
        public static class Data {
            private String clickUrl;
            private String impressionUrl;

            public String getClickUrl() {
                return this.clickUrl;
            }

            public void setClickUrl(String clickUrl2) {
                this.clickUrl = clickUrl2;
            }

            public String getImpressionUrl() {
                return this.impressionUrl;
            }

            public void setImpressionUrl(String impressionUrl2) {
                this.impressionUrl = impressionUrl2;
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
                if (!other.canEqual(this)) {
                    return false;
                }
                String clickUrl2 = getClickUrl();
                Object other$clickUrl = other.getClickUrl();
                if (clickUrl2 != null ? !clickUrl2.equals(other$clickUrl) : other$clickUrl != null) {
                    return false;
                }
                String impressionUrl2 = getImpressionUrl();
                Object other$impressionUrl = other.getImpressionUrl();
                if (impressionUrl2 != null ? impressionUrl2.equals(other$impressionUrl) : other$impressionUrl == null) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                String clickUrl2 = getClickUrl();
                int i = 43;
                int result = (1 * 59) + (clickUrl2 == null ? 43 : clickUrl2.hashCode());
                String impressionUrl2 = getImpressionUrl();
                int i2 = result * 59;
                if (impressionUrl2 != null) {
                    i = impressionUrl2.hashCode();
                }
                return i2 + i;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("GetAdsResponse.Partner.Data(clickUrl=");
                sb.append(getClickUrl());
                sb.append(", impressionUrl=");
                sb.append(getImpressionUrl());
                sb.append(")");
                return sb.toString();
            }
        }

        /* renamed from: cm.aptoide.pt.dataprovider.model.v2.GetAdsResponse$Partner$Info */
        public static class Info {

            /* renamed from: id */
            private int f6081id;
            private String name;

            public int getId() {
                return this.f6081id;
            }

            public void setId(int id) {
                this.f6081id = id;
            }

            public String getName() {
                return this.name;
            }

            public void setName(String name2) {
                this.name = name2;
            }

            /* access modifiers changed from: protected */
            public boolean canEqual(Object other) {
                return other instanceof Info;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof Info)) {
                    return false;
                }
                Info other = (Info) o;
                if (!other.canEqual(this) || getId() != other.getId()) {
                    return false;
                }
                String name2 = getName();
                Object other$name = other.getName();
                if (name2 != null ? name2.equals(other$name) : other$name == null) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                int result = (1 * 59) + getId();
                String name2 = getName();
                return (result * 59) + (name2 == null ? 43 : name2.hashCode());
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("GetAdsResponse.Partner.Info(id=");
                sb.append(getId());
                sb.append(", name=");
                sb.append(getName());
                sb.append(")");
                return sb.toString();
            }
        }

        public Info getInfo() {
            return this.info;
        }

        public void setInfo(Info info2) {
            this.info = info2;
        }

        public Data getData() {
            return this.data;
        }

        public void setData(Data data2) {
            this.data = data2;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof Partner;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Partner)) {
                return false;
            }
            Partner other = (Partner) o;
            if (!other.canEqual(this)) {
                return false;
            }
            Info info2 = getInfo();
            Object other$info = other.getInfo();
            if (info2 != null ? !info2.equals(other$info) : other$info != null) {
                return false;
            }
            Data data2 = getData();
            Object other$data = other.getData();
            if (data2 != null ? data2.equals(other$data) : other$data == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            Info info2 = getInfo();
            int i = 43;
            int result = (1 * 59) + (info2 == null ? 43 : info2.hashCode());
            Data data2 = getData();
            int i2 = result * 59;
            if (data2 != null) {
                i = data2.hashCode();
            }
            return i2 + i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("GetAdsResponse.Partner(info=");
            sb.append(getInfo());
            sb.append(", data=");
            sb.append(getData());
            sb.append(")");
            return sb.toString();
        }
    }

    public List<C2842Ad> getAds() {
        return this.ads;
    }

    public void setAds(List<C2842Ad> ads2) {
        this.ads = ads2;
    }

    public Options getOptions() {
        return this.options;
    }

    public void setOptions(Options options2) {
        this.options = options2;
    }

    public int hashCode() {
        Object $ads = getAds();
        int i = 43;
        int result = (1 * 59) + ($ads == null ? 43 : $ads.hashCode());
        Options options2 = getOptions();
        int i2 = result * 59;
        if (options2 != null) {
            i = options2.hashCode();
        }
        return i2 + i;
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof GetAdsResponse;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof GetAdsResponse)) {
            return false;
        }
        GetAdsResponse other = (GetAdsResponse) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$ads = getAds();
        Object other$ads = other.getAds();
        if (this$ads != null ? !this$ads.equals(other$ads) : other$ads != null) {
            return false;
        }
        Options options2 = getOptions();
        Object other$options = other.getOptions();
        if (options2 != null ? options2.equals(other$options) : other$options == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GetAdsResponse(ads=");
        sb.append(getAds());
        sb.append(", options=");
        sb.append(getOptions());
        sb.append(")");
        return sb.toString();
    }
}
