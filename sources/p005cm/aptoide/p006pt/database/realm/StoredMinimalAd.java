package p005cm.aptoide.p006pt.database.realm;

import p024io.realm.C0106Z;
import p024io.realm.C14074ma;
import p024io.realm.internal.C7344p;

/* renamed from: cm.aptoide.pt.database.realm.StoredMinimalAd */
public class StoredMinimalAd extends C0106Z implements C14074ma {
    public static final String CPI_URL = "cpiUrl";
    public static final String PACKAGE_NAME = "packageName";
    public static final String REFERRER = "referrer";
    private Long adId;
    private String cpcUrl;
    private String cpdUrl;
    private String cpiUrl;
    private String packageName;
    private String referrer;
    private Long timestamp;

    public Long realmGet$adId() {
        return this.adId;
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

    public String realmGet$packageName() {
        return this.packageName;
    }

    public String realmGet$referrer() {
        return this.referrer;
    }

    public Long realmGet$timestamp() {
        return this.timestamp;
    }

    public void realmSet$adId(Long l) {
        this.adId = l;
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

    public void realmSet$packageName(String str) {
        this.packageName = str;
    }

    public void realmSet$referrer(String str) {
        this.referrer = str;
    }

    public void realmSet$timestamp(Long l) {
        this.timestamp = l;
    }

    public StoredMinimalAd() {
        if (this instanceof C7344p) {
            ((C7344p) this).mo23792b();
        }
    }

    public StoredMinimalAd(String packageName2, String referrer2, String cpcUrl2, String cpdUrl2, String cpiUrl2, long adId2) {
        if (this instanceof C7344p) {
            ((C7344p) this).mo23792b();
        }
        realmSet$packageName(packageName2);
        realmSet$referrer(referrer2);
        realmSet$cpcUrl(cpcUrl2);
        realmSet$cpdUrl(cpdUrl2);
        realmSet$cpiUrl(cpiUrl2);
        realmSet$adId(Long.valueOf(adId2));
        realmSet$timestamp(Long.valueOf(System.currentTimeMillis()));
    }

    public String getPackageName() {
        return realmGet$packageName();
    }

    public void setPackageName(String packageName2) {
        realmSet$packageName(packageName2);
    }

    public String getReferrer() {
        return realmGet$referrer();
    }

    public void setReferrer(String referrer2) {
        realmSet$referrer(referrer2);
    }

    public String getCpcUrl() {
        return realmGet$cpcUrl();
    }

    public String getCpdUrl() {
        return realmGet$cpdUrl();
    }

    public void setCpdUrl(String cpdUrl2) {
        realmSet$cpdUrl(cpdUrl2);
    }

    public String getCpiUrl() {
        return realmGet$cpiUrl();
    }

    public void setCpiUrl(String cpiUrl2) {
        realmSet$cpiUrl(cpiUrl2);
    }

    public long getTimestamp() {
        return realmGet$timestamp().longValue();
    }

    public void setTimestamp(long timestamp2) {
        realmSet$timestamp(Long.valueOf(timestamp2));
    }

    public long getAdId() {
        return realmGet$adId().longValue();
    }

    public void setAdId(long adId2) {
        realmSet$adId(Long.valueOf(adId2));
    }
}
