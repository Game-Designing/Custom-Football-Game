package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.analyticsbody;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.analyticsbody.Obb */
public class Obb {
    private String mirror;
    private ObbType type;
    private String url;

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.analyticsbody.Obb$ObbType */
    public enum ObbType {
        MAIN,
        PATCH
    }

    public ObbType getType() {
        return this.type;
    }

    public void setType(ObbType type2) {
        this.type = type2;
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
