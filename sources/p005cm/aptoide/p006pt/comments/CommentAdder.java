package p005cm.aptoide.p006pt.comments;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Comment;

/* renamed from: cm.aptoide.pt.comments.CommentAdder */
public abstract class CommentAdder {
    private static transient /* synthetic */ boolean[] $jacocoData;
    protected final int itemIndex;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6841055653554636652L, "cm/aptoide/pt/comments/CommentAdder", 2);
        $jacocoData = probes;
        return probes;
    }

    public abstract void addComment(List<Comment> list);

    public CommentAdder(int itemIndex2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.itemIndex = itemIndex2;
        $jacocoInit[0] = true;
    }

    public void collapseComments() {
        $jacocoInit()[1] = true;
    }
}
