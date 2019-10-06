package p005cm.aptoide.p006pt.timeline;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.timeline.TimelineSocialActionData */
public class TimelineSocialActionData {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private String action;
    private String cardType;
    private String packageName;
    private String publisher;
    private String socialAction;
    private String title;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-184297341663264991L, "cm/aptoide/pt/timeline/TimelineSocialActionData", 7);
        $jacocoData = probes;
        return probes;
    }

    public TimelineSocialActionData(String cardType2, String action2, String socialAction2, String packageName2, String publisher2, String title2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.cardType = cardType2;
        this.action = action2;
        this.socialAction = socialAction2;
        this.packageName = packageName2;
        this.publisher = publisher2;
        this.title = title2;
        $jacocoInit[0] = true;
    }

    public String getCardType() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.cardType;
        $jacocoInit[1] = true;
        return str;
    }

    public String getAction() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.action;
        $jacocoInit[2] = true;
        return str;
    }

    public String getSocialAction() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.socialAction;
        $jacocoInit[3] = true;
        return str;
    }

    public String getPackageName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.packageName;
        $jacocoInit[4] = true;
        return str;
    }

    public String getPublisher() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.publisher;
        $jacocoInit[5] = true;
        return str;
    }

    public String getTitle() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.title;
        $jacocoInit[6] = true;
        return str;
    }
}
