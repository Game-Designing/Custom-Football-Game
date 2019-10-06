package p005cm.aptoide.p006pt.editorialList;

import java.util.Collections;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.reactions.data.TopReaction;

/* renamed from: cm.aptoide.pt.editorialList.CurationCard */
public class CurationCard {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String captionColor;
    private final String date;
    private final String icon;

    /* renamed from: id */
    private final String f6615id;
    private int numberOfReactions;
    private List<TopReaction> reactions;
    private final String subTitle;
    private final String title;
    private final String type;
    private String userReaction;
    private final String views;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1786968013638363704L, "cm/aptoide/pt/editorialList/CurationCard", 17);
        $jacocoData = probes;
        return probes;
    }

    public CurationCard(String id, String subTitle2, String icon2, String title2, String views2, String type2, String date2, String captionColor2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.f6615id = id;
        this.subTitle = subTitle2;
        this.icon = icon2;
        this.title = title2;
        this.views = views2;
        this.type = type2;
        this.date = date2;
        this.captionColor = captionColor2;
        $jacocoInit[0] = true;
        this.reactions = Collections.emptyList();
        this.userReaction = "";
        this.numberOfReactions = -1;
        $jacocoInit[1] = true;
    }

    public CurationCard() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = "";
        this.f6615id = str;
        this.subTitle = str;
        this.icon = str;
        this.title = str;
        this.views = str;
        this.type = str;
        this.date = str;
        this.captionColor = str;
        $jacocoInit[2] = true;
    }

    public String getId() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.f6615id;
        $jacocoInit[3] = true;
        return str;
    }

    public String getSubTitle() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.subTitle;
        $jacocoInit[4] = true;
        return str;
    }

    public String getIcon() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.icon;
        $jacocoInit[5] = true;
        return str;
    }

    public String getTitle() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.title;
        $jacocoInit[6] = true;
        return str;
    }

    public String getViews() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.views;
        $jacocoInit[7] = true;
        return str;
    }

    public String getType() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.type;
        $jacocoInit[8] = true;
        return str;
    }

    public String getDate() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.date;
        $jacocoInit[9] = true;
        return str;
    }

    public List<TopReaction> getReactions() {
        boolean[] $jacocoInit = $jacocoInit();
        List<TopReaction> list = this.reactions;
        $jacocoInit[10] = true;
        return list;
    }

    public void setReactions(List<TopReaction> reactions2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.reactions = reactions2;
        $jacocoInit[11] = true;
    }

    public String getUserReaction() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.userReaction;
        $jacocoInit[12] = true;
        return str;
    }

    public void setUserReaction(String userReaction2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.userReaction = userReaction2;
        $jacocoInit[13] = true;
    }

    public int getNumberOfReactions() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.numberOfReactions;
        $jacocoInit[14] = true;
        return i;
    }

    public void setNumberOfReactions(int numberOfReactions2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.numberOfReactions = numberOfReactions2;
        $jacocoInit[15] = true;
    }

    public String getCaptionColor() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.captionColor;
        $jacocoInit[16] = true;
        return str;
    }
}
