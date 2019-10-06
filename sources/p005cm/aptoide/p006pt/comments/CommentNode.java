package p005cm.aptoide.p006pt.comments;

import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Comment;

/* renamed from: cm.aptoide.pt.comments.CommentNode */
public class CommentNode {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final List<CommentNode> childComments;
    private Comment comment;
    private int level;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-627848318082048129L, "cm/aptoide/pt/comments/CommentNode", 12);
        $jacocoData = probes;
        return probes;
    }

    public CommentNode() {
        boolean[] $jacocoInit = $jacocoInit();
        this(null);
        $jacocoInit[0] = true;
    }

    public CommentNode(Comment comment2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.level = 1;
        this.comment = comment2;
        $jacocoInit[1] = true;
        this.childComments = new ArrayList();
        $jacocoInit[2] = true;
    }

    public Comment getComment() {
        boolean[] $jacocoInit = $jacocoInit();
        Comment comment2 = this.comment;
        $jacocoInit[3] = true;
        return comment2;
    }

    public void setComment(Comment comment2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.comment = comment2;
        $jacocoInit[4] = true;
    }

    public void addChild(CommentNode comment2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.childComments.add(comment2);
        $jacocoInit[5] = true;
    }

    public boolean hasChild() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.childComments.size() > 0) {
            $jacocoInit[6] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[7] = true;
        }
        $jacocoInit[8] = true;
        return z;
    }

    public List<CommentNode> getChildComments() {
        boolean[] $jacocoInit = $jacocoInit();
        List<CommentNode> list = this.childComments;
        $jacocoInit[9] = true;
        return list;
    }

    public int getLevel() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.level;
        $jacocoInit[10] = true;
        return i;
    }

    public void setLevel(int level2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.level = level2;
        $jacocoInit[11] = true;
    }
}
