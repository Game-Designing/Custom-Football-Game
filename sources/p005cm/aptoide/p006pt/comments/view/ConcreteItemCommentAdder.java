package p005cm.aptoide.p006pt.comments.view;

import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.comments.CommentAdder;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Comment;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;

/* renamed from: cm.aptoide.pt.comments.view.ConcreteItemCommentAdder */
public class ConcreteItemCommentAdder<T> extends CommentAdder {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ItemCommentAdderView commentAdderView;
    private final T review;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4684951678802341553L, "cm/aptoide/pt/comments/view/ConcreteItemCommentAdder", 18);
        $jacocoData = probes;
        return probes;
    }

    public ConcreteItemCommentAdder(int reviewIndex, ItemCommentAdderView commentAdderView2, T review2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(reviewIndex);
        this.commentAdderView = commentAdderView2;
        this.review = review2;
        $jacocoInit[0] = true;
    }

    public void addComment(List<Comment> comments) {
        boolean[] $jacocoInit = $jacocoInit();
        List<Displayable> displayableList = new ArrayList<>();
        $jacocoInit[1] = true;
        this.commentAdderView.createDisplayableComments(comments, displayableList);
        $jacocoInit[2] = true;
        CommentsAdapter adapter = this.commentAdderView.getAdapter();
        int i = this.itemIndex;
        $jacocoInit[3] = true;
        int reviewPosition = adapter.getItemPosition(i);
        $jacocoInit[4] = true;
        if (comments.size() <= 2) {
            $jacocoInit[5] = true;
        } else {
            $jacocoInit[6] = true;
            displayableList.add(this.commentAdderView.createReadMoreDisplayable(reviewPosition, this.review));
            $jacocoInit[7] = true;
        }
        CommentsAdapter adapter2 = this.commentAdderView.getAdapter();
        int i2 = reviewPosition + 1;
        $jacocoInit[8] = true;
        adapter2.addDisplayables(i2, displayableList);
        $jacocoInit[9] = true;
    }

    public void collapseComments() {
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        CommentsAdapter adapter = this.commentAdderView.getAdapter();
        $jacocoInit[10] = true;
        int reviewIndex = adapter.getItemPosition(this.itemIndex);
        $jacocoInit[11] = true;
        int nextReview = adapter.getItemPosition(this.itemIndex + 1);
        $jacocoInit[12] = true;
        if (nextReview == -1) {
            CommentsAdapter adapter2 = this.commentAdderView.getAdapter();
            $jacocoInit[13] = true;
            i = adapter2.getItemCount();
            $jacocoInit[14] = true;
        } else {
            $jacocoInit[15] = true;
            i = nextReview;
        }
        int nextReview2 = i;
        $jacocoInit[16] = true;
        adapter.removeDisplayables(reviewIndex + 1, nextReview2 - 1);
        $jacocoInit[17] = true;
    }
}
