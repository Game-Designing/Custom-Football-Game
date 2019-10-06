package p005cm.aptoide.p006pt.comments.view;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.p000v4.app.C0014p;
import android.support.p000v4.app.C0486t;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.trello.rxlifecycle.p263a.C12543b;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.account.AccountAnalytics.AccountOrigins;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.navigator.ActivityResultNavigator;
import p005cm.aptoide.p006pt.store.StoreTheme;
import p005cm.aptoide.p006pt.store.view.StoreAddCommentDisplayable;
import p005cm.aptoide.p006pt.utils.design.ShowMessage;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.widget.Widget;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p029i.C0136c;

/* renamed from: cm.aptoide.pt.comments.view.StoreAddCommentWidget */
public class StoreAddCommentWidget extends Widget<StoreAddCommentDisplayable> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static final String TAG = StoreAddCommentWidget.class.getName();
    private AptoideAccountManager accountManager;
    private AccountNavigator accountNavigator;
    private Button commentStore;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8008361922610370963L, "cm/aptoide/pt/comments/view/StoreAddCommentWidget", 36);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((StoreAddCommentDisplayable) displayable, i);
        $jacocoInit[17] = true;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[35] = true;
    }

    public StoreAddCommentWidget(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: protected */
    public void assignViews(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.commentStore = (Button) itemView.findViewById(C1375R.C1376id.comment_store_button);
        $jacocoInit[1] = true;
    }

    public void bindView(StoreAddCommentDisplayable displayable, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        C0014p context = getContext();
        $jacocoInit[2] = true;
        this.accountManager = ((AptoideApplication) getContext().getApplicationContext()).getAccountManager();
        $jacocoInit[3] = true;
        this.accountNavigator = ((ActivityResultNavigator) getContext()).getAccountNavigator();
        $jacocoInit[4] = true;
        Button button = this.commentStore;
        Resources resources = getContext().getResources();
        $jacocoInit[5] = true;
        StoreTheme storeTheme = displayable.getStoreTheme();
        $jacocoInit[6] = true;
        int raisedButtonDrawable = storeTheme.getRaisedButtonDrawable();
        $jacocoInit[7] = true;
        Drawable drawable = resources.getDrawable(raisedButtonDrawable);
        $jacocoInit[8] = true;
        button.setBackgroundDrawable(drawable);
        $jacocoInit[9] = true;
        C0136c cVar = this.compositeSubscription;
        C0120S a = C13034a.m42490a(this.commentStore);
        C2674U u = new C2674U(this, displayable);
        $jacocoInit[10] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) u);
        C2679Z z = C2679Z.f5861a;
        C2681aa aaVar = C2681aa.f5863a;
        $jacocoInit[11] = true;
        C0137ja a2 = f.mo3626a((C0129b<? super T>) z, (C0129b<Throwable>) aaVar);
        $jacocoInit[12] = true;
        cVar.mo3713a(a2);
        $jacocoInit[13] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo11626a(StoreAddCommentDisplayable displayable, Void a) {
        boolean[] $jacocoInit = $jacocoInit();
        long storeId = displayable.getStoreId();
        String storeName = displayable.getStoreName();
        $jacocoInit[32] = true;
        C0486t supportFragmentManager = getContext().getSupportFragmentManager();
        Button button = this.commentStore;
        $jacocoInit[33] = true;
        C0120S showStoreCommentFragment = showStoreCommentFragment(storeId, storeName, supportFragmentManager, button);
        $jacocoInit[34] = true;
        return showStoreCommentFragment;
    }

    /* renamed from: a */
    static /* synthetic */ void m7366a(Void a) {
        $jacocoInit()[31] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m7365a(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[29] = true;
        instance.log(err);
        $jacocoInit[30] = true;
    }

    private C0120S<Void> showStoreCommentFragment(long storeId, String storeName, C0486t fragmentManager, View view) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = C0120S.m652c(Boolean.valueOf(this.accountManager.isLoggedIn()));
        C2676W w = new C2676W(this, storeId, storeName, fragmentManager, view);
        $jacocoInit[14] = true;
        C0120S<Void> f = c.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) w);
        $jacocoInit[15] = true;
        return f;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo11625a(long storeId, String storeName, C0486t fragmentManager, View view, Boolean isLoggedIn) {
        boolean[] $jacocoInit = $jacocoInit();
        if (isLoggedIn.booleanValue()) {
            $jacocoInit[19] = true;
            CommentDialogFragment commentDialogFragment = CommentDialogFragment.newInstanceStoreComment(storeId, storeName);
            $jacocoInit[20] = true;
            C0120S lifecycle = commentDialogFragment.lifecycle();
            C2678Y y = new C2678Y(commentDialogFragment, fragmentManager);
            $jacocoInit[21] = true;
            C0120S b = lifecycle.mo3635b((C0128a) y);
            C2677X x = C2677X.f5858a;
            $jacocoInit[22] = true;
            C0120S d = b.mo3653d((C0132p<? super T, Boolean>) x);
            C2683ba baVar = C2683ba.f5865a;
            $jacocoInit[23] = true;
            C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) baVar);
            $jacocoInit[24] = true;
            return f;
        }
        C0120S f2 = showSignInMessage(view).mo3604f();
        $jacocoInit[25] = true;
        return f2;
    }

    /* renamed from: a */
    static /* synthetic */ void m7364a(CommentDialogFragment commentDialogFragment, C0486t fragmentManager) {
        boolean[] $jacocoInit = $jacocoInit();
        commentDialogFragment.show(fragmentManager, "fragment_comment_dialog");
        $jacocoInit[28] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7363a(C12543b event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(C12543b.DESTROY_VIEW));
        $jacocoInit[27] = true;
        return valueOf;
    }

    /* renamed from: b */
    static /* synthetic */ C0120S m7367b(C12543b event) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = C0120S.m651c();
        $jacocoInit[26] = true;
        return c;
    }

    private C0117M showSignInMessage(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M asObservableSnack = ShowMessage.asObservableSnack(view, (int) C1375R.string.you_need_to_be_logged_in, (int) C1375R.string.login, (OnClickListener) new C2675V(this));
        $jacocoInit[16] = true;
        return asObservableSnack;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11627a(View snackView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountNavigator.navigateToAccountView(AccountOrigins.STORE_COMMENT);
        $jacocoInit[18] = true;
    }
}
