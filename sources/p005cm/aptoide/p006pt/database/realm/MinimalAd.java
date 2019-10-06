package p005cm.aptoide.p006pt.database.realm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import p024io.realm.C0106Z;
import p024io.realm.C14089v;
import p024io.realm.internal.C7344p;

/* renamed from: cm.aptoide.pt.database.realm.MinimalAd */
public class MinimalAd extends C0106Z implements Parcelable, C14089v {
    public static final Creator<MinimalAd> CREATOR = new Creator<MinimalAd>() {
        public MinimalAd createFromParcel(Parcel source) {
            return new MinimalAd(source);
        }

        public MinimalAd[] newArray(int size) {
            return new MinimalAd[size];
        }
    };
    private Long adId;
    private Long appId;
    private String clickUrl;
    private String cpcUrl;
    private String cpdUrl;
    private String cpiUrl;
    private String description;
    private Integer downloads;
    private String iconPath;
    private Long modified;
    private String name;
    private Long networkId;
    private String packageName;
    private Integer stars;

    public Long realmGet$adId() {
        return this.adId;
    }

    public Long realmGet$appId() {
        return this.appId;
    }

    public String realmGet$clickUrl() {
        return this.clickUrl;
    }

    public String realmGet$cpcUrl() {
        return this.cpcUrl;
    }

    public String realmGet$cpdUrl() {
        return this.cpdUrl;
    }

    public String realmGet$cpiUrl() {
        return this.cpiUrl;
    }

    public String realmGet$description() {
        return this.description;
    }

    public Integer realmGet$downloads() {
        return this.downloads;
    }

    public String realmGet$iconPath() {
        return this.iconPath;
    }

    public Long realmGet$modified() {
        return this.modified;
    }

    public String realmGet$name() {
        return this.name;
    }

    public Long realmGet$networkId() {
        return this.networkId;
    }

    public String realmGet$packageName() {
        return this.packageName;
    }

    public Integer realmGet$stars() {
        return this.stars;
    }

    public void realmSet$adId(Long l) {
        this.adId = l;
    }

    public void realmSet$appId(Long l) {
        this.appId = l;
    }

    public void realmSet$clickUrl(String str) {
        this.clickUrl = str;
    }

    public void realmSet$cpcUrl(String str) {
        this.cpcUrl = str;
    }

    public void realmSet$cpdUrl(String str) {
        this.cpdUrl = str;
    }

    public void realmSet$cpiUrl(String str) {
        this.cpiUrl = str;
    }

    public void realmSet$description(String str) {
        this.description = str;
    }

    public void realmSet$downloads(Integer num) {
        this.downloads = num;
    }

    public void realmSet$iconPath(String str) {
        this.iconPath = str;
    }

    public void realmSet$modified(Long l) {
        this.modified = l;
    }

    public void realmSet$name(String str) {
        this.name = str;
    }

    public void realmSet$networkId(Long l) {
        this.networkId = l;
    }

    public void realmSet$packageName(String str) {
        this.packageName = str;
    }

    public void realmSet$stars(Integer num) {
        this.stars = num;
    }

    public MinimalAd() {
        if (this instanceof C7344p) {
            ((C7344p) this).mo23792b();
        }
    }

    public MinimalAd(String packageName2, long networkId2, String clickUrl2, String cpcUrl2, String cpdUrl2, long appId2, long adId2, String cpiUrl2, String name2, String iconPath2, String description2, int downloads2, int stars2, Long modified2) {
        if (this instanceof C7344p) {
            ((C7344p) this).mo23792b();
        }
        realmSet$packageName(packageName2);
        realmSet$networkId(Long.valueOf(networkId2));
        String str = clickUrl2;
        realmSet$clickUrl(clickUrl2);
        String str2 = cpcUrl2;
        realmSet$cpcUrl(cpcUrl2);
        String str3 = cpdUrl2;
        realmSet$cpdUrl(cpdUrl2);
        realmSet$appId(Long.valueOf(appId2));
        realmSet$adId(Long.valueOf(adId2));
        realmSet$cpiUrl(cpiUrl2);
        realmSet$name(name2);
        realmSet$iconPath(iconPath2);
        realmSet$description(description2);
        realmSet$downloads(Integer.valueOf(downloads2));
        realmSet$stars(Integer.valueOf(stars2));
        realmSet$modified(modified2);
    }

    protected MinimalAd(Parcel in) {
        if (this instanceof C7344p) {
            ((C7344p) this).mo23792b();
        }
        realmSet$description(in.readString());
        realmSet$packageName(in.readString());
        realmSet$networkId(Long.valueOf(in.readLong()));
        realmSet$clickUrl(in.readString());
        realmSet$cpcUrl(in.readString());
        realmSet$cpdUrl(in.readString());
        realmSet$appId(Long.valueOf(in.readLong()));
        realmSet$adId(Long.valueOf(in.readLong()));
        realmSet$cpiUrl(in.readString());
        realmSet$name(in.readString());
        realmSet$iconPath(in.readString());
        realmSet$downloads(Integer.valueOf(in.readInt()));
        realmSet$stars(Integer.valueOf(in.readInt()));
        realmSet$modified(Long.valueOf(in.readLong()));
    }

    public String getCpdUrl() {
        return realmGet$cpdUrl();
    }

    public void setCpdUrl(String cpdUrl2) {
        realmSet$cpdUrl(cpdUrl2);
    }

    public String getDescription() {
        return realmGet$description();
    }

    public String getPackageName() {
        return realmGet$packageName();
    }

    public Long getNetworkId() {
        return realmGet$networkId();
    }

    public String getClickUrl() {
        return realmGet$clickUrl();
    }

    public String getCpcUrl() {
        return realmGet$cpcUrl();
    }

    public Long getAppId() {
        return realmGet$appId();
    }

    public Long getAdId() {
        return realmGet$adId();
    }

    public String getCpiUrl() {
        return realmGet$cpiUrl();
    }

    public String getName() {
        return realmGet$name();
    }

    public String getIconPath() {
        return realmGet$iconPath();
    }

    public Integer getDownloads() {
        return realmGet$downloads();
    }

    public Integer getStars() {
        return realmGet$stars();
    }

    public Long getModified() {
        return realmGet$modified();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(realmGet$description());
        dest.writeString(realmGet$packageName());
        dest.writeLong(realmGet$networkId().longValue());
        dest.writeString(realmGet$clickUrl());
        dest.writeString(realmGet$cpcUrl());
        dest.writeString(realmGet$cpdUrl());
        dest.writeLong(realmGet$appId().longValue());
        dest.writeLong(realmGet$adId().longValue());
        dest.writeString(realmGet$cpiUrl());
        dest.writeString(realmGet$name());
        dest.writeString(realmGet$iconPath());
        dest.writeInt(realmGet$downloads().intValue());
        dest.writeInt(realmGet$stars().intValue());
        dest.writeLong(realmGet$modified().longValue());
    }
}
