package p005cm.aptoide.p006pt.comments;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Comment;
import p026rx.C0117M;

/* renamed from: cm.aptoide.pt.comments.ComplexComment */
public class ComplexComment extends Comment {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final int level;
    private final C0117M onClickReplyAction;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7853634329485546403L, "cm/aptoide/pt/comments/ComplexComment", 13);
        $jacocoData = probes;
        return probes;
    }

    public ComplexComment(CommentNode commentNode, C0117M onClickReplyAction2) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        this.level = commentNode.getLevel();
        $jacocoInit[1] = true;
        Comment comment = commentNode.getComment();
        $jacocoInit[2] = true;
        setAdded(comment.getAdded());
        $jacocoInit[3] = true;
        setBody(comment.getBody());
        $jacocoInit[4] = true;
        setId(comment.getId());
        $jacocoInit[5] = true;
        if (comment.getParent() == null) {
            $jacocoInit[6] = true;
        } else {
            $jacocoInit[7] = true;
            setParent(comment.getParent());
            $jacocoInit[8] = true;
        }
        setParentReview(comment.getParentReview());
        $jacocoInit[9] = true;
        setUser(comment.getUser());
        this.onClickReplyAction = onClickReplyAction2;
        $jacocoInit[10] = true;
    }

    public C0117M observeReplySubmission() {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M m = this.onClickReplyAction;
        $jacocoInit[11] = true;
        return m;
    }

    public int getLevel() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.level;
        $jacocoInit[12] = true;
        return i;
    }
}
