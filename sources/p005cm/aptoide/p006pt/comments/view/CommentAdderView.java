package p005cm.aptoide.p006pt.comments.view;

import java.util.List;
import p005cm.aptoide.p006pt.comments.view.CommentsAdapter;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Comment;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;

/* renamed from: cm.aptoide.pt.comments.view.CommentAdderView */
public interface CommentAdderView<Tadapter extends CommentsAdapter> {
    void createDisplayableComments(List<Comment> list, List<Displayable> list2);

    Tadapter getAdapter();
}
