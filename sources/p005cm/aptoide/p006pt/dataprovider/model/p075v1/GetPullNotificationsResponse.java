package p005cm.aptoide.p006pt.dataprovider.model.p075v1;

/* renamed from: cm.aptoide.pt.dataprovider.model.v1.GetPullNotificationsResponse */
public class GetPullNotificationsResponse {
    private String abTestingGroup;
    private Attr attr;
    private String body;
    private int campaignId;
    private Long expire;
    private String img;
    private String lang;
    private String title;
    private int type;
    private String url;
    private String urlTrack;
    private String urlTrackNc;

    public String getUrlTrackNc() {
        return this.urlTrackNc;
    }

    public void setUrlTrackNc(String urlTrackNc2) {
        this.urlTrackNc = urlTrackNc2;
    }

    public Long getExpire() {
        return this.expire;
    }

    public void setExpire(long expire2) {
        this.expire = Long.valueOf(expire2);
    }

    public String getAbTestingGroup() {
        return this.abTestingGroup;
    }

    public void setAbTestingGroup(String abTestingGroup2) {
        this.abTestingGroup = abTestingGroup2;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body2) {
        this.body = body2;
    }

    public int getCampaignId() {
        return this.campaignId;
    }

    public void setCampaignId(int campaignId2) {
        this.campaignId = campaignId2;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type2) {
        this.type = type2;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img2) {
        this.img = img2;
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String lang2) {
        this.lang = lang2;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title2) {
        this.title = title2;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url2) {
        this.url = url2;
    }

    public String getUrlTrack() {
        return this.urlTrack;
    }

    public void setUrlTrack(String urlTrack2) {
        this.urlTrack = urlTrack2;
    }

    public Attr getAttr() {
        return this.attr;
    }

    public void setAttr(Attr attr2) {
        this.attr = attr2;
    }
}
