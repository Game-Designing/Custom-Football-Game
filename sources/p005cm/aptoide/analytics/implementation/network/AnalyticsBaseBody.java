package p005cm.aptoide.analytics.implementation.network;

/* renamed from: cm.aptoide.analytics.implementation.network.AnalyticsBaseBody */
public class AnalyticsBaseBody {
    private String accessToken;
    private String aptoideMd5sum;
    private String aptoidePackage;
    private String aptoideUid;
    private int aptoideVercode;
    private String lang;
    private boolean mature;

    /* renamed from: q */
    private String f4251q;

    public String getAptoideUid() {
        return this.aptoideUid;
    }

    public void setAptoideUid(String aptoideUid2) {
        this.aptoideUid = aptoideUid2;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String accessToken2) {
        this.accessToken = accessToken2;
    }

    public int getAptoideVercode() {
        return this.aptoideVercode;
    }

    public void setAptoideVercode(int aptoideVercode2) {
        this.aptoideVercode = aptoideVercode2;
    }

    public String getAptoideMd5sum() {
        return this.aptoideMd5sum;
    }

    public void setAptoideMd5sum(String aptoideMd5sum2) {
        this.aptoideMd5sum = aptoideMd5sum2;
    }

    public String getAptoidePackage() {
        return this.aptoidePackage;
    }

    public void setAptoidePackage(String aptoidePackage2) {
        this.aptoidePackage = aptoidePackage2;
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String lang2) {
        this.lang = lang2;
    }

    public boolean isMature() {
        return this.mature;
    }

    public void setMature(boolean mature2) {
        this.mature = mature2;
    }

    public String getQ() {
        return this.f4251q;
    }

    public void setQ(String q) {
        this.f4251q = q;
    }
}
