package p005cm.aptoide.p006pt.comments.view;

import android.support.design.widget.Snackbar;
import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Comment;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Comment.Access;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Comment.User;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.store.view.StoreFragment.OpenType;
import p005cm.aptoide.p006pt.view.FragmentProvider;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;

/* renamed from: cm.aptoide.pt.comments.view.CommentDisplayable */
public class CommentDisplayable extends Displayable {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Comment comment;
    private FragmentNavigator fragmentNavigator;
    private FragmentProvider fragmentProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3187320834481596490L, "cm/aptoide/pt/comments/view/CommentDisplayable", 13);
        $jacocoData = probes;
        return probes;
    }

    public CommentDisplayable(Comment comment2, FragmentNavigator fragmentNavigator2, FragmentProvider fragmentProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.comment = comment2;
        this.fragmentNavigator = fragmentNavigator2;
        this.fragmentProvider = fragmentProvider2;
        $jacocoInit[0] = true;
    }

    public CommentDisplayable() {
        boolean[] $jacocoInit = $jacocoInit();
        this.comment = null;
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
        return C1375R.layout.comment_layout;
    }

    public Comment getComment() {
        boolean[] $jacocoInit = $jacocoInit();
        Comment comment2 = this.comment;
        $jacocoInit[4] = true;
        return comment2;
    }

    public void itemClicked(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        User user = this.comment.getUser();
        $jacocoInit[5] = true;
        if (user.getAccess() == Access.PUBLIC) {
            $jacocoInit[6] = true;
            FragmentNavigator fragmentNavigator2 = this.fragmentNavigator;
            FragmentProvider fragmentProvider2 = this.fragmentProvider;
            User user2 = this.comment.getUser();
            $jacocoInit[7] = true;
            long id = user2.getId();
            OpenType openType = OpenType.GetHome;
            $jacocoInit[8] = true;
            fragmentNavigator2.navigateTo(fragmentProvider2.newStoreFragment(id, "DEFAULT", openType), true);
            $jacocoInit[9] = true;
        } else {
            Snackbar a = Snackbar.m1623a(view, (int) C1375R.string.stores_message_private_user, -1);
            $jacocoInit[10] = true;
            a.mo4690h();
            $jacocoInit[11] = true;
        }
        $jacocoInit[12] = true;
    }
}
