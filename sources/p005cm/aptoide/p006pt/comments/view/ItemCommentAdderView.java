package p005cm.aptoide.p006pt.comments.view;

import p005cm.aptoide.p006pt.comments.view.CommentsAdapter;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;

/* renamed from: cm.aptoide.pt.comments.view.ItemCommentAdderView */
public interface ItemCommentAdderView<Titem, Tadapter extends CommentsAdapter> extends CommentAdderView<Tadapter> {
    Displayable createReadMoreDisplayable(int i, Titem titem);
}
