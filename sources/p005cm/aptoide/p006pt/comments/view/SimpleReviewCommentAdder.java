package p005cm.aptoide.p006pt.comments.view;

import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.comments.CommentAdder;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Comment;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;

/* renamed from: cm.aptoide.pt.comments.view.SimpleReviewCommentAdder */
public class SimpleReviewCommentAdder extends CommentAdder {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final CommentAdderView commentAdderView;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6822716825286935503L, "cm/aptoide/pt/comments/view/SimpleReviewCommentAdder", 13);
        $jacocoData = probes;
        return probes;
    }

    public SimpleReviewCommentAdder(int reviewIndex, CommentAdderView commentAdderView2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(reviewIndex);
        this.commentAdderView = commentAdderView2;
        $jacocoInit[0] = true;
    }

    public void addComment(List<Comment> comments) {
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        CommentsAdapter adapter = this.commentAdderView.getAdapter();
        int i2 = this.itemIndex + 1;
        $jacocoInit[1] = true;
        int nextReviewPosition = adapter.getItemPosition(i2);
        $jacocoInit[2] = true;
        if (nextReviewPosition == -1) {
            CommentsAdapter adapter2 = this.commentAdderView.getAdapter();
            $jacocoInit[3] = true;
            i = adapter2.getItemCount();
            $jacocoInit[4] = true;
        } else {
            $jacocoInit[5] = true;
            i = nextReviewPosition;
        }
        int nextReviewPosition2 = i;
        $jacocoInit[6] = true;
        CommentsAdapter adapter3 = this.commentAdderView.getAdapter();
        int i3 = nextReviewPosition2 - 1;
        $jacocoInit[7] = true;
        adapter3.removeDisplayable(i3);
        $jacocoInit[8] = true;
        List<Displayable> displayableList = new ArrayList<>();
        $jacocoInit[9] = true;
        this.commentAdderView.createDisplayableComments(comments, displayableList);
        $jacocoInit[10] = true;
        CommentsAdapter adapter4 = this.commentAdderView.getAdapter();
        int i4 = nextReviewPosition2 - 1;
        $jacocoInit[11] = true;
        adapter4.addDisplayables(i4, displayableList);
        $jacocoInit[12] = true;
    }
}
