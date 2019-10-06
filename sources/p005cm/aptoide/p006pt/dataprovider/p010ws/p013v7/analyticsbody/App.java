package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.analyticsbody;

import com.fasterxml.jackson.annotation.JsonProperty;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.analyticsbody.App */
public class App {
    private String mirror;
    @JsonProperty("package")
    private String packageName;
    private String url;

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String packageName2) {
        this.packageName = packageName2;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url2) {
        this.url = url2;
    }

    public String getMirror() {
        return this.mirror;
    }

    public void setMirror(String mirror2) {
        this.mirror = mirror2;
    }
}
