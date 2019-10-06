package p005cm.aptoide.p006pt.comments.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.comments.CommentAdder;
import p005cm.aptoide.p006pt.comments.ReviewWithAppName;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;
import p005cm.aptoide.p006pt.view.recycler.displayable.DisplayablePojo;

/* renamed from: cm.aptoide.pt.comments.view.RateAndReviewCommentDisplayable */
public class RateAndReviewCommentDisplayable extends DisplayablePojo<ReviewWithAppName> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private CommentAdder commentAdder;
    private int numberComments;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1391503178766948307L, "cm/aptoide/pt/comments/view/RateAndReviewCommentDisplayable", 6);
        $jacocoData = probes;
        return probes;
    }

    public RateAndReviewCommentDisplayable() {
        $jacocoInit()[0] = true;
    }

    public RateAndReviewCommentDisplayable(ReviewWithAppName pojo, CommentAdder commentAdder2, int numberComments2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(pojo);
        this.commentAdder = commentAdder2;
        this.numberComments = numberComments2;
        $jacocoInit[1] = true;
    }

    public CommentAdder getCommentAdder() {
        boolean[] $jacocoInit = $jacocoInit();
        CommentAdder commentAdder2 = this.commentAdder;
        $jacocoInit[2] = true;
        return commentAdder2;
    }

    public int getNumberComments() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.numberComments;
        $jacocoInit[3] = true;
        return i;
    }

    /* access modifiers changed from: protected */
    public Configs getConfig() {
        boolean[] $jacocoInit = $jacocoInit();
        Configs configs = new Configs(this, 1, true);
        $jacocoInit[4] = true;
        return configs;
    }

    public int getViewLayout() {
        $jacocoInit()[5] = true;
        return C1375R.layout.displayable_rate_and_review;
    }
}
