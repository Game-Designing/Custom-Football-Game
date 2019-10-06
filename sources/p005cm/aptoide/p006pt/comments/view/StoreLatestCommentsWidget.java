package p005cm.aptoide.p006pt.comments.view;

import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.p000v4.app.C0486t;
import android.support.p001v7.widget.LinearLayoutManager;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.RecyclerView.C0980h;
import android.view.View;
import android.view.View.OnClickListener;
import com.trello.rxlifecycle.p263a.C12543b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.account.AccountAnalytics.AccountOrigins;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.comments.CommentNode;
import p005cm.aptoide.p006pt.comments.ComplexComment;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Comment;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.DataList;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListComments;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.ListCommentsRequest;
import p005cm.aptoide.p006pt.navigator.ActivityResultNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.preferences.managed.ManagerPreferences;
import p005cm.aptoide.p006pt.store.view.StoreLatestCommentsDisplayable;
import p005cm.aptoide.p006pt.util.CommentOperations;
import p005cm.aptoide.p006pt.view.FragmentProvider;
import p005cm.aptoide.p006pt.view.custom.HorizontalDividerItemDecoration;
import p005cm.aptoide.p006pt.view.recycler.BaseAdapter;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.widget.Widget;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p029i.C0136c;
import p026rx.p387a.p389b.C14522a;
import p026rx.schedulers.Schedulers;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.comments.view.StoreLatestCommentsWidget */
public class StoreLatestCommentsWidget extends Widget<StoreLatestCommentsDisplayable> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private AptoideAccountManager accountManager;
    private AccountNavigator accountNavigator;
    private BodyInterceptor<BaseBody> baseBodyInterceptor;
    private Factory converterFactory;
    private OkHttpClient httpClient;
    private RecyclerView recyclerView;
    private long storeId;
    private String storeName;
    private TokenInvalidator tokenInvalidator;

    /* renamed from: cm.aptoide.pt.comments.view.StoreLatestCommentsWidget$CommentListAdapter */
    private static class CommentListAdapter extends BaseAdapter {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private final AptoideAccountManager accountManager;
        private AccountNavigator accountNavigator;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(2290868083990718648L, "cm/aptoide/pt/comments/view/StoreLatestCommentsWidget$CommentListAdapter", 29);
            $jacocoData = probes;
            return probes;
        }

        CommentListAdapter(long storeId, String storeName, List<Comment> comments, C0486t fragmentManager, View view, C0120S<Void> reloadComments, AptoideAccountManager accountManager2, AccountNavigator accountNavigator2, FragmentNavigator fragmentNavigator, FragmentProvider fragmentProvider) {
            boolean[] $jacocoInit = $jacocoInit();
            this.accountManager = accountManager2;
            this.accountNavigator = accountNavigator2;
            boolean z = true;
            $jacocoInit[0] = true;
            CommentOperations commentOperations = new CommentOperations();
            $jacocoInit[1] = true;
            List<CommentNode> sortedComments = commentOperations.flattenByDepth(commentOperations.transform(comments));
            $jacocoInit[2] = true;
            ArrayList arrayList = new ArrayList(sortedComments.size());
            $jacocoInit[3] = true;
            ArrayList arrayList2 = arrayList;
            $jacocoInit[4] = true;
            for (CommentNode commentNode : sortedComments) {
                $jacocoInit[5] = z;
                CommentOperations commentOperations2 = commentOperations;
                ArrayList arrayList3 = arrayList2;
                ComplexComment complexComment = new ComplexComment(commentNode, showStoreCommentFragment(storeId, commentNode.getComment(), storeName, fragmentManager, view, reloadComments));
                CommentDisplayable commentDisplayable = new CommentDisplayable(complexComment, fragmentNavigator, fragmentProvider);
                $jacocoInit[6] = true;
                arrayList3.add(commentDisplayable);
                $jacocoInit[7] = true;
                AptoideAccountManager aptoideAccountManager = accountManager2;
                AccountNavigator accountNavigator3 = accountNavigator2;
                arrayList2 = arrayList3;
                commentOperations = commentOperations2;
                z = true;
            }
            FragmentNavigator fragmentNavigator2 = fragmentNavigator;
            FragmentProvider fragmentProvider2 = fragmentProvider;
            CommentOperations commentOperations3 = commentOperations;
            addDisplayables(arrayList2);
            $jacocoInit[8] = true;
        }

        private C0117M showStoreCommentFragment(long storeId, Comment comment, String storeName, C0486t fragmentManager, View view, C0120S<Void> reloadComments) {
            boolean[] $jacocoInit = $jacocoInit();
            C0120S accountStatus = this.accountManager.accountStatus();
            $jacocoInit[9] = true;
            C0120S d = accountStatus.mo3647d();
            $jacocoInit[10] = true;
            Single n = d.mo3678n();
            C2693ga gaVar = new C2693ga(this, storeId, comment, storeName, fragmentManager, reloadComments, view);
            $jacocoInit[11] = true;
            C0117M b = n.mo3693b((C0132p<? super T, ? extends C0117M>) gaVar);
            $jacocoInit[12] = true;
            return b;
        }

        /* renamed from: a */
        public /* synthetic */ C0117M mo11632a(long storeId, Comment comment, String storeName, C0486t fragmentManager, C0120S reloadComments, View view, Account account) {
            boolean[] $jacocoInit = $jacocoInit();
            if (account.isLoggedIn()) {
                $jacocoInit[18] = true;
                CommentDialogFragment commentDialogFragment = CommentDialogFragment.newInstanceStoreCommentReply(storeId, comment.getId(), storeName);
                $jacocoInit[19] = true;
                C0120S lifecycle = commentDialogFragment.lifecycle();
                C2689ea eaVar = new C2689ea(commentDialogFragment, fragmentManager);
                $jacocoInit[20] = true;
                C0120S b = lifecycle.mo3635b((C0128a) eaVar);
                C2685ca caVar = C2685ca.f5867a;
                $jacocoInit[21] = true;
                C0120S d = b.mo3653d((C0132p<? super T, Boolean>) caVar);
                C2687da daVar = new C2687da(reloadComments);
                $jacocoInit[22] = true;
                C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) daVar);
                $jacocoInit[23] = true;
                C0117M l = f.mo3673l();
                $jacocoInit[24] = true;
                return l;
            }
            C0117M showSignInMessage = showSignInMessage(view);
            $jacocoInit[25] = true;
            return showSignInMessage;
        }

        /* renamed from: a */
        static /* synthetic */ void m7376a(CommentDialogFragment commentDialogFragment, C0486t fragmentManager) {
            boolean[] $jacocoInit = $jacocoInit();
            commentDialogFragment.show(fragmentManager, "fragment_comment_dialog_latest");
            $jacocoInit[28] = true;
        }

        /* renamed from: a */
        static /* synthetic */ Boolean m7374a(C12543b event) {
            boolean[] $jacocoInit = $jacocoInit();
            Boolean valueOf = Boolean.valueOf(event.equals(C12543b.DESTROY_VIEW));
            $jacocoInit[27] = true;
            return valueOf;
        }

        /* renamed from: a */
        static /* synthetic */ C0120S m7375a(C0120S reloadComments, C12543b event) {
            $jacocoInit()[26] = true;
            return reloadComments;
        }

        private C0117M showSignInMessage(View view) {
            boolean[] $jacocoInit = $jacocoInit();
            C0117M c = C0117M.m597c((C0128a) new C2691fa(this, view));
            $jacocoInit[13] = true;
            return c;
        }

        /* renamed from: b */
        public /* synthetic */ void mo11634b(View view) {
            boolean[] $jacocoInit = $jacocoInit();
            Snackbar a = Snackbar.m1623a(view, (int) C1375R.string.you_need_to_be_logged_in, 0);
            C2695ha haVar = new C2695ha(this);
            $jacocoInit[14] = true;
            a.mo4552a((int) C1375R.string.login, (OnClickListener) haVar);
            $jacocoInit[15] = true;
            a.mo4690h();
            $jacocoInit[16] = true;
        }

        /* renamed from: a */
        public /* synthetic */ void mo11633a(View snackView) {
            boolean[] $jacocoInit = $jacocoInit();
            this.accountNavigator.navigateToAccountView(AccountOrigins.LATEST_COMMENTS_STORE);
            $jacocoInit[17] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8286075485661952843L, "cm/aptoide/pt/comments/view/StoreLatestCommentsWidget", 38);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((StoreLatestCommentsDisplayable) displayable, i);
        $jacocoInit[31] = true;
    }

    public StoreLatestCommentsWidget(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: protected */
    public void assignViews(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.recyclerView = (RecyclerView) itemView.findViewById(C1375R.C1376id.comments);
        $jacocoInit[1] = true;
    }

    public void bindView(StoreLatestCommentsDisplayable displayable, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[2] = true;
        this.accountManager = ((AptoideApplication) getContext().getApplicationContext()).getAccountManager();
        $jacocoInit[3] = true;
        this.tokenInvalidator = ((AptoideApplication) getContext().getApplicationContext()).getTokenInvalidator();
        $jacocoInit[4] = true;
        this.baseBodyInterceptor = ((AptoideApplication) getContext().getApplicationContext()).getAccountSettingsBodyInterceptorPoolV7();
        $jacocoInit[5] = true;
        this.accountNavigator = ((ActivityResultNavigator) getContext()).getAccountNavigator();
        $jacocoInit[6] = true;
        this.httpClient = ((AptoideApplication) getContext().getApplicationContext()).getDefaultClient();
        $jacocoInit[7] = true;
        this.converterFactory = WebService.getDefaultConverter();
        $jacocoInit[8] = true;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.recyclerView.getContext());
        $jacocoInit[9] = true;
        this.recyclerView.setLayoutManager(layoutManager);
        $jacocoInit[10] = true;
        this.recyclerView.mo7527a((C0980h) new HorizontalDividerItemDecoration(getContext()));
        $jacocoInit[11] = true;
        this.storeId = displayable.getStoreId();
        $jacocoInit[12] = true;
        this.storeName = displayable.getStoreName();
        $jacocoInit[13] = true;
        setAdapter(displayable.getComments());
        $jacocoInit[14] = true;
    }

    private void setAdapter(List<Comment> comments) {
        boolean[] $jacocoInit = $jacocoInit();
        RecyclerView recyclerView2 = this.recyclerView;
        long j = this.storeId;
        String str = this.storeName;
        $jacocoInit[15] = true;
        C0486t supportFragmentManager = getContext().getSupportFragmentManager();
        RecyclerView recyclerView3 = this.recyclerView;
        C2699ja jaVar = new C2699ja(this);
        $jacocoInit[16] = true;
        C0120S a = C0120S.m633a((Callable<? extends T>) jaVar);
        AptoideAccountManager aptoideAccountManager = this.accountManager;
        AccountNavigator accountNavigator2 = this.accountNavigator;
        $jacocoInit[17] = true;
        FragmentNavigator fragmentNavigator = getFragmentNavigator();
        $jacocoInit[18] = true;
        AptoideApplication aptoideApplication = (AptoideApplication) getContext().getApplicationContext();
        CommentListAdapter commentListAdapter = new CommentListAdapter(j, str, comments, supportFragmentManager, recyclerView3, a, aptoideAccountManager, accountNavigator2, fragmentNavigator, AptoideApplication.getFragmentProvider());
        $jacocoInit[19] = true;
        recyclerView2.setAdapter(commentListAdapter);
        $jacocoInit[20] = true;
    }

    /* renamed from: h */
    public /* synthetic */ Void mo11631h() throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        Void reloadComments = reloadComments();
        $jacocoInit[37] = true;
        return reloadComments;
    }

    private Void reloadComments() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[21] = true;
        SharedPreferences defaultSharedPreferences = ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences();
        $jacocoInit[22] = true;
        ManagerPreferences.setForceServerRefreshFlag(true, defaultSharedPreferences);
        C0136c cVar = this.compositeSubscription;
        long j = this.storeId;
        BodyInterceptor<BaseBody> bodyInterceptor = this.baseBodyInterceptor;
        OkHttpClient okHttpClient = this.httpClient;
        Factory factory = this.converterFactory;
        TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
        $jacocoInit[23] = true;
        SharedPreferences defaultSharedPreferences2 = ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences();
        $jacocoInit[24] = true;
        ListCommentsRequest of = ListCommentsRequest.m7470of(j, 0, 3, false, bodyInterceptor, okHttpClient, factory, tokenInvalidator2, defaultSharedPreferences2);
        $jacocoInit[25] = true;
        C0120S observe = of.observe();
        $jacocoInit[26] = true;
        C0120S b = observe.mo3634b(Schedulers.m776io());
        $jacocoInit[27] = true;
        C0120S a = b.mo3616a(C14522a.m46170a());
        C2697ia iaVar = new C2697ia(this);
        C2701ka kaVar = C2701ka.f5894a;
        $jacocoInit[28] = true;
        C0137ja a2 = a.mo3626a((C0129b<? super T>) iaVar, (C0129b<Throwable>) kaVar);
        $jacocoInit[29] = true;
        cVar.mo3713a(a2);
        $jacocoInit[30] = true;
        return null;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11629a(ListComments listComments) {
        boolean[] $jacocoInit = $jacocoInit();
        DataList dataList = listComments.getDataList();
        $jacocoInit[34] = true;
        List list = dataList.getList();
        $jacocoInit[35] = true;
        setAdapter(list);
        $jacocoInit[36] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m7371a(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[32] = true;
        instance.log(err);
        $jacocoInit[33] = true;
    }
}
