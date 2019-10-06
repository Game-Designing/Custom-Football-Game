package p005cm.aptoide.p006pt.comments.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.comments.CommentAdder;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;

/* renamed from: cm.aptoide.pt.comments.view.CommentsReadMoreDisplayable */
public class CommentsReadMoreDisplayable extends Displayable {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final CommentAdder commentAdder;
    private final boolean isReview;
    private final int next;
    private final long resourceId;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4930680370458217926L, "cm/aptoide/pt/comments/view/CommentsReadMoreDisplayable", 8);
        $jacocoData = probes;
        return probes;
    }

    public CommentsReadMoreDisplayable() {
        boolean[] $jacocoInit = $jacocoInit();
        this(-1, true, 0, null);
        $jacocoInit[0] = true;
    }

    public CommentsReadMoreDisplayable(long resourceId2, boolean isReview2, int next2, CommentAdder commentAdder2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.commentAdder = commentAdder2;
        this.next = next2;
        this.resourceId = resourceId2;
        this.isReview = isReview2;
        $jacocoInit[1] = true;
    }

    /* access modifiers changed from: protected */
    public Configs getConfig() {
        boolean[] $jacocoInit = $jacocoInit();
        Configs configs = new Configs(this, 1, true);
        $jacocoInit[2] = true;
        return configs;
    }

    public int getViewLayout() {
        $jacocoInit()[3] = true;
        return C1375R.layout.comments_read_more_layout;
    }

    public long getResourceId() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.resourceId;
        $jacocoInit[4] = true;
        return j;
    }

    public int getNext() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.next;
        $jacocoInit[5] = true;
        return i;
    }

    public CommentAdder getCommentAdder() {
        boolean[] $jacocoInit = $jacocoInit();
        CommentAdder commentAdder2 = this.commentAdder;
        $jacocoInit[6] = true;
        return commentAdder2;
    }

    public boolean isReview() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isReview;
        $jacocoInit[7] = true;
        return z;
    }
}
