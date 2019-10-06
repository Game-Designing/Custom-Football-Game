package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import com.fasterxml.jackson.annotation.JsonProperty;
import p005cm.aptoide.p006pt.dataprovider.p010ws.RefreshBody;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.BaseBody */
public class BaseBody implements RefreshBody {
    private String accessToken;
    @JsonProperty("aptoide_uid")
    private String aptoideId;
    private String aptoideMd5sum;
    private String aptoidePackage;
    private int aptoideVercode;
    private String cdn;
    private String country;
    private String lang;
    private boolean mature;

    /* renamed from: q */
    private String f57q;
    private boolean refresh;

    public boolean isRefresh() {
        return this.refresh;
    }

    public void setRefresh(boolean refresh2) {
        this.refresh = refresh2;
    }

    public String getAptoideId() {
        return this.aptoideId;
    }

    public void setAptoideId(String aptoideId2) {
        this.aptoideId = aptoideId2;
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

    public String getCdn() {
        return this.cdn;
    }

    public void setCdn(String cdn2) {
        this.cdn = cdn2;
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
        return this.f57q;
    }

    public void setQ(String q) {
        this.f57q = q;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country2) {
        this.country = country2;
    }
}
