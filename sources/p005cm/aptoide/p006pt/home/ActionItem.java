package p005cm.aptoide.p006pt.home;

import java.util.Collections;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.reactions.data.TopReaction;

/* renamed from: cm.aptoide.pt.home.ActionItem */
public class ActionItem {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String captionColor;
    private final String cardId;
    private final String date;
    private final String icon;
    private final String numberOfViews;
    private List<TopReaction> reactionList = Collections.emptyList();
    private final String subTitle;
    private final String title;
    private int total = -1;
    private final String type;
    private final String url;
    private String userReaction = "";

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1687758643546224227L, "cm/aptoide/pt/home/ActionItem", 17);
        $jacocoData = probes;
        return probes;
    }

    public ActionItem(String cardId2, String type2, String title2, String subTitle2, String icon2, String url2, String numberOfViews2, String date2, String captionColor2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.cardId = cardId2;
        this.type = type2;
        this.title = title2;
        this.subTitle = subTitle2;
        this.icon = icon2;
        this.url = url2;
        this.numberOfViews = numberOfViews2;
        this.date = date2;
        this.captionColor = captionColor2;
        $jacocoInit[0] = true;
        $jacocoInit[1] = true;
    }

    public String getCardId() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.cardId;
        $jacocoInit[2] = true;
        return str;
    }

    public String getType() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.type;
        $jacocoInit[3] = true;
        return str;
    }

    public String getTitle() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.title;
        $jacocoInit[4] = true;
        return str;
    }

    public String getSubTitle() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.subTitle;
        $jacocoInit[5] = true;
        return str;
    }

    public String getIcon() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.icon;
        $jacocoInit[6] = true;
        return str;
    }

    public String getUrl() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.url;
        $jacocoInit[7] = true;
        return str;
    }

    public String getNumberOfViews() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.numberOfViews;
        $jacocoInit[8] = true;
        return str;
    }

    public String getDate() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.date;
        $jacocoInit[9] = true;
        return str;
    }

    public void setReactions(List<TopReaction> topReactionList) {
        boolean[] $jacocoInit = $jacocoInit();
        this.reactionList = topReactionList;
        $jacocoInit[10] = true;
    }

    public void setNumberOfReactions(int total2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.total = total2;
        $jacocoInit[11] = true;
    }

    public List<TopReaction> getReactionList() {
        boolean[] $jacocoInit = $jacocoInit();
        List<TopReaction> list = this.reactionList;
        $jacocoInit[12] = true;
        return list;
    }

    public int getTotal() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.total;
        $jacocoInit[13] = true;
        return i;
    }

    public String getUserReaction() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.userReaction;
        $jacocoInit[14] = true;
        return str;
    }

    public void setUserReaction(String myReaction) {
        boolean[] $jacocoInit = $jacocoInit();
        this.userReaction = myReaction;
        $jacocoInit[15] = true;
    }

    public String getCaptionColor() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.captionColor;
        $jacocoInit[16] = true;
        return str;
    }
}
