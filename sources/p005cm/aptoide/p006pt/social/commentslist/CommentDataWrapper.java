package p005cm.aptoide.p006pt.social.commentslist;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;

/* renamed from: cm.aptoide.pt.social.commentslist.CommentDataWrapper */
public class CommentDataWrapper {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Long longAsId;
    private final Long previousCommentId;
    private final BaseV7Response response;
    private final String stringAsId;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1288442323604661330L, "cm/aptoide/pt/social/commentslist/CommentDataWrapper", 5);
        $jacocoData = probes;
        return probes;
    }

    public CommentDataWrapper(BaseV7Response response2, Long longAsId2, Long previousCommentId2, String stringAsId2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.response = response2;
        this.longAsId = longAsId2;
        this.previousCommentId = previousCommentId2;
        this.stringAsId = stringAsId2;
        $jacocoInit[0] = true;
    }

    public BaseV7Response getResponse() {
        boolean[] $jacocoInit = $jacocoInit();
        BaseV7Response baseV7Response = this.response;
        $jacocoInit[1] = true;
        return baseV7Response;
    }

    public Long getLongAsId() {
        boolean[] $jacocoInit = $jacocoInit();
        Long l = this.longAsId;
        $jacocoInit[2] = true;
        return l;
    }

    public Long getPreviousCommentId() {
        boolean[] $jacocoInit = $jacocoInit();
        Long l = this.previousCommentId;
        $jacocoInit[3] = true;
        return l;
    }

    public String getStringAsId() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.stringAsId;
        $jacocoInit[4] = true;
        return str;
    }
}
