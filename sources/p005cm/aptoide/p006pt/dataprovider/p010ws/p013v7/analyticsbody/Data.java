package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.analyticsbody;

import java.util.List;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.analyticsbody.Data */
public class Data {
    private String abTestGroup;
    private App app;
    private Integer campaignId;
    private String network;
    private List<Obb> obb;
    private DataOrigin origin;
    private String previousContext;
    private String previousTag;
    private Result result;
    private Root root;
    private String store;
    private String teleco;

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.analyticsbody.Data$DataOrigin */
    public enum DataOrigin {
        INSTALL,
        UPDATE,
        DOWNGRADE,
        UPDATE_ALL
    }

    public String getStore() {
        return this.store;
    }

    public void setStore(String store2) {
        this.store = store2;
    }

    public String getPreviousTag() {
        return this.previousTag;
    }

    public void setPreviousTag(String previousTag2) {
        this.previousTag = previousTag2;
    }

    public String getPreviousContext() {
        return this.previousContext;
    }

    public void setPreviousContext(String previousContext2) {
        this.previousContext = previousContext2;
    }

    public DataOrigin getOrigin() {
        return this.origin;
    }

    public void setOrigin(DataOrigin origin2) {
        this.origin = origin2;
    }

    public App getApp() {
        return this.app;
    }

    public void setApp(App app2) {
        this.app = app2;
    }

    public List<Obb> getObb() {
        return this.obb;
    }

    public void setObb(List<Obb> obb2) {
        this.obb = obb2;
    }

    public String getNetwork() {
        return this.network;
    }

    public void setNetwork(String network2) {
        this.network = network2;
    }

    public String getTeleco() {
        return this.teleco;
    }

    public void setTeleco(String teleco2) {
        this.teleco = teleco2;
    }

    public Result getResult() {
        return this.result;
    }

    public void setResult(Result result2) {
        this.result = result2;
    }

    public Root getRoot() {
        return this.root;
    }

    public void setRoot(Root root2) {
        this.root = root2;
    }

    public Integer getCampaignId() {
        return this.campaignId;
    }

    public void setCampaignId(int campaignId2) {
        this.campaignId = Integer.valueOf(campaignId2);
    }

    public String getAbTestGroup() {
        return this.abTestGroup;
    }

    public void setAbTestGroup(String abTestGroup2) {
        this.abTestGroup = abTestGroup2;
    }
}
