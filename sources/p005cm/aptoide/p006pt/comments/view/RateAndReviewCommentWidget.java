package p005cm.aptoide.p006pt.comments.view;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.p000v4.app.C0014p;
import android.support.p000v4.app.C0486t;
import android.support.p001v7.widget.AppCompatRatingBar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.trello.rxlifecycle.p263a.C12543b;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.account.AccountAnalytics.AccountOrigins;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.comments.CommentAdder;
import p005cm.aptoide.p006pt.comments.ReviewWithAppName;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response.Error;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Comment;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.DataList;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListComments;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Review;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Review.Stats;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Review.User;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.ListCommentsRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.SetReviewRatingRequest;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.navigator.ActivityResultNavigator;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.preferences.managed.ManagerPreferences;
import p005cm.aptoide.p006pt.utils.AptoideUtils.DateTimeU;
import p005cm.aptoide.p006pt.utils.AptoideUtils.StringU;
import p005cm.aptoide.p006pt.utils.design.ShowMessage;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.widget.Widget;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p029i.C0136c;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.comments.view.RateAndReviewCommentWidget */
public class RateAndReviewCommentWidget extends Widget<RateAndReviewCommentDisplayable> {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int DEFAULT_LIMIT = 3;
    public static final int FULL_COMMENTS_LIMIT = 3;
    private static final Locale LOCALE = Locale.getDefault();
    private static final String TAG = RateAndReviewCommentWidget.class.getSimpleName();
    private AptoideAccountManager accountManager;
    private AccountNavigator accountNavigator;
    private BodyInterceptor<BaseBody> bodyInterceptor;
    private Factory converterFactory;
    private TextView flagHelfull;
    private TextView flagNotHelfull;
    private View helpfullButtonLayout;
    private OkHttpClient httpClient;
    private boolean isCommentsCollapsed = false;
    private View notHelpfullButtonLayout;
    private AppCompatRatingBar ratingBar;
    private TextView reply;
    private TextView reviewDate;
    private TextView reviewText;
    private TextView reviewTitle;
    private TextView showHideReplies;
    private TokenInvalidator tokenInvalidator;
    private ImageView userImage;
    private TextView username;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3966864392663384406L, "cm/aptoide/pt/comments/view/RateAndReviewCommentWidget", Opcodes.IF_ACMPEQ);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((RateAndReviewCommentDisplayable) displayable, i);
        $jacocoInit[91] = true;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[163] = true;
        $jacocoInit[164] = true;
    }

    public RateAndReviewCommentWidget(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: protected */
    public void assignViews(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.reply = (TextView) itemView.findViewById(C1375R.C1376id.write_reply_btn);
        $jacocoInit[1] = true;
        this.showHideReplies = (TextView) itemView.findViewById(C1375R.C1376id.show_replies_btn);
        $jacocoInit[2] = true;
        this.flagHelfull = (TextView) itemView.findViewById(C1375R.C1376id.helpful_btn);
        $jacocoInit[3] = true;
        this.flagNotHelfull = (TextView) itemView.findViewById(C1375R.C1376id.not_helpful_btn);
        $jacocoInit[4] = true;
        this.ratingBar = (AppCompatRatingBar) itemView.findViewById(C1375R.C1376id.rating_bar);
        $jacocoInit[5] = true;
        this.reviewTitle = (TextView) itemView.findViewById(C1375R.C1376id.comment_title);
        $jacocoInit[6] = true;
        this.reviewDate = (TextView) itemView.findViewById(C1375R.C1376id.added_date);
        $jacocoInit[7] = true;
        this.reviewText = (TextView) itemView.findViewById(C1375R.C1376id.comment);
        $jacocoInit[8] = true;
        this.userImage = (ImageView) itemView.findViewById(C1375R.C1376id.user_icon);
        $jacocoInit[9] = true;
        this.username = (TextView) itemView.findViewById(C1375R.C1376id.user_name);
        $jacocoInit[10] = true;
        this.helpfullButtonLayout = itemView.findViewById(C1375R.C1376id.helpful_layout);
        $jacocoInit[11] = true;
        this.notHelpfullButtonLayout = itemView.findViewById(C1375R.C1376id.not_helpful_layout);
        $jacocoInit[12] = true;
    }

    public void bindView(RateAndReviewCommentDisplayable displayable, int position) {
        int color;
        boolean[] $jacocoInit = $jacocoInit();
        ReviewWithAppName reviewWithAppName = (ReviewWithAppName) displayable.getPojo();
        $jacocoInit[13] = true;
        Review review = reviewWithAppName.getReview();
        $jacocoInit[14] = true;
        ReviewWithAppName reviewWithAppName2 = (ReviewWithAppName) displayable.getPojo();
        $jacocoInit[15] = true;
        String appName = reviewWithAppName2.getAppName();
        $jacocoInit[16] = true;
        this.tokenInvalidator = ((AptoideApplication) getContext().getApplicationContext()).getTokenInvalidator();
        $jacocoInit[17] = true;
        this.httpClient = ((AptoideApplication) getContext().getApplicationContext()).getDefaultClient();
        $jacocoInit[18] = true;
        this.converterFactory = WebService.getDefaultConverter();
        $jacocoInit[19] = true;
        this.accountManager = ((AptoideApplication) getContext().getApplicationContext()).getAccountManager();
        $jacocoInit[20] = true;
        this.bodyInterceptor = ((AptoideApplication) getContext().getApplicationContext()).getAccountSettingsBodyInterceptorPoolV7();
        $jacocoInit[21] = true;
        this.accountNavigator = ((ActivityResultNavigator) getContext()).getAccountNavigator();
        $jacocoInit[22] = true;
        C0014p context = getContext();
        $jacocoInit[23] = true;
        ImageLoader with = ImageLoader.with(context);
        $jacocoInit[24] = true;
        User user = review.getUser();
        $jacocoInit[25] = true;
        String avatar = user.getAvatar();
        ImageView imageView = this.userImage;
        $jacocoInit[26] = true;
        with.loadWithCircleTransformAndPlaceHolderAvatarSize(avatar, imageView, C1375R.drawable.layer_1);
        $jacocoInit[27] = true;
        TextView textView = this.username;
        User user2 = review.getUser();
        $jacocoInit[28] = true;
        String name = user2.getName();
        $jacocoInit[29] = true;
        textView.setText(name);
        $jacocoInit[30] = true;
        AppCompatRatingBar appCompatRatingBar = this.ratingBar;
        Stats stats = review.getStats();
        $jacocoInit[31] = true;
        float rating = stats.getRating();
        $jacocoInit[32] = true;
        appCompatRatingBar.setRating(rating);
        $jacocoInit[33] = true;
        this.reviewTitle.setText(review.getTitle());
        $jacocoInit[34] = true;
        this.reviewText.setText(review.getBody());
        $jacocoInit[35] = true;
        TextView textView2 = this.reviewDate;
        DateTimeU instance = DateTimeU.getInstance(getContext());
        $jacocoInit[36] = true;
        Date added = review.getAdded();
        $jacocoInit[37] = true;
        long time = added.getTime();
        Resources resources = getContext().getResources();
        $jacocoInit[38] = true;
        String timeDiffString = instance.getTimeDiffString((Context) context, time, resources);
        $jacocoInit[39] = true;
        textView2.setText(timeDiffString);
        $jacocoInit[40] = true;
        Resources resources2 = context.getResources();
        $jacocoInit[41] = true;
        if (300 <= resources2.getDisplayMetrics().densityDpi) {
            $jacocoInit[42] = true;
        } else {
            $jacocoInit[43] = true;
            String str = "";
            this.flagHelfull.setText(str);
            $jacocoInit[44] = true;
            this.flagNotHelfull.setText(str);
            $jacocoInit[45] = true;
        }
        CommentAdder commentAdder = displayable.getCommentAdder();
        $jacocoInit[46] = true;
        long reviewId = review.getId();
        $jacocoInit[47] = true;
        C2661G g = r0;
        C0136c cVar = this.compositeSubscription;
        C0120S a = C13034a.m42490a(this.reply);
        C2661G g2 = new C2661G(this, context, review, appName, commentAdder, reviewId);
        $jacocoInit[48] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) g);
        C2673T t = C2673T.f5849a;
        C2668N n = C2668N.f5838a;
        $jacocoInit[49] = true;
        C0137ja a2 = f.mo3626a((C0129b<? super T>) t, (C0129b<Throwable>) n);
        $jacocoInit[50] = true;
        cVar.mo3713a(a2);
        $jacocoInit[51] = true;
        C0136c cVar2 = this.compositeSubscription;
        C0120S a3 = C13034a.m42490a(this.helpfullButtonLayout);
        C2667M m = new C2667M(this, review);
        $jacocoInit[52] = true;
        C0137ja c = a3.mo3646c((C0129b<? super T>) m);
        $jacocoInit[53] = true;
        cVar2.mo3713a(c);
        $jacocoInit[54] = true;
        C0136c cVar3 = this.compositeSubscription;
        C0120S a4 = C13034a.m42490a(this.notHelpfullButtonLayout);
        C2663I i = new C2663I(this, review);
        $jacocoInit[55] = true;
        C0137ja c2 = a4.mo3646c((C0129b<? super T>) i);
        $jacocoInit[56] = true;
        cVar3.mo3713a(c2);
        $jacocoInit[57] = true;
        C0136c cVar4 = this.compositeSubscription;
        C0120S a5 = C13034a.m42490a(this.showHideReplies);
        C2671Q q = new C2671Q(this, review, displayable);
        $jacocoInit[58] = true;
        C0137ja c3 = a5.mo3646c((C0129b<? super T>) q);
        $jacocoInit[59] = true;
        cVar4.mo3713a(c3);
        $jacocoInit[60] = true;
        Theme theme = context.getTheme();
        $jacocoInit[61] = true;
        Resources res = context.getResources();
        $jacocoInit[62] = true;
        if (getItemId() % 2 == 0) {
            color = C1375R.color.white;
            $jacocoInit[63] = true;
        } else {
            color = C1375R.color.displayable_rate_and_review_background;
            $jacocoInit[64] = true;
        }
        if (VERSION.SDK_INT >= 23) {
            $jacocoInit[65] = true;
            this.itemView.setBackgroundColor(res.getColor(color, theme));
            $jacocoInit[66] = true;
        } else {
            this.itemView.setBackgroundColor(res.getColor(color));
            $jacocoInit[67] = true;
        }
        int numberComments = displayable.getNumberComments();
        if (numberComments > 0) {
            $jacocoInit[68] = true;
            this.showHideReplies.setVisibility(0);
            TextView textView3 = this.showHideReplies;
            $jacocoInit[69] = true;
            Resources resources3 = getContext().getResources();
            Object[] objArr = {Integer.valueOf(numberComments)};
            $jacocoInit[70] = true;
            String formattedString = StringU.getFormattedString(C1375R.string.reviews_expand_button, resources3, objArr);
            $jacocoInit[71] = true;
            textView3.setText(formattedString);
            $jacocoInit[72] = true;
        } else {
            this.showHideReplies.setVisibility(8);
            $jacocoInit[73] = true;
        }
        $jacocoInit[74] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo11613a(C0014p context, Review review, String appName, CommentAdder commentAdder, long reviewId, Void a) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.accountManager.isLoggedIn()) {
            $jacocoInit[145] = true;
            C0486t fm = context.getSupportFragmentManager();
            $jacocoInit[146] = true;
            CommentDialogFragment commentDialogFragment = CommentDialogFragment.newInstanceReview(review.getId(), appName);
            $jacocoInit[147] = true;
            commentDialogFragment.show(fm, "fragment_comment_dialog");
            $jacocoInit[148] = true;
            C0120S lifecycle = commentDialogFragment.lifecycle();
            C2670P p = C2670P.f5842a;
            $jacocoInit[149] = true;
            C0120S d = lifecycle.mo3653d((C0132p<? super T, Boolean>) p);
            C2672S s = new C2672S(this, commentAdder, reviewId);
            $jacocoInit[150] = true;
            C0120S b = d.mo3636b((C0129b<? super T>) s);
            C2659E e = C2659E.f5821a;
            $jacocoInit[151] = true;
            C0120S f = b.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) e);
            $jacocoInit[152] = true;
            return f;
        }
        C0117M asObservableSnack = ShowMessage.asObservableSnack((View) this.ratingBar, (int) C1375R.string.you_need_to_be_logged_in, (int) C1375R.string.login, (OnClickListener) new C2665K(this));
        $jacocoInit[153] = true;
        C0120S f2 = asObservableSnack.mo3604f();
        $jacocoInit[154] = true;
        return f2;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7348a(C12543b event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(C12543b.DESTROY_VIEW));
        $jacocoInit[162] = true;
        return valueOf;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11616a(CommentAdder commentAdder, long reviewId, C12543b b) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[157] = true;
        SharedPreferences defaultSharedPreferences = ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences();
        $jacocoInit[158] = true;
        ManagerPreferences.setForceServerRefreshFlag(true, defaultSharedPreferences);
        $jacocoInit[159] = true;
        commentAdder.collapseComments();
        $jacocoInit[160] = true;
        loadCommentsForThisReview(reviewId, 3, commentAdder);
        $jacocoInit[161] = true;
    }

    /* renamed from: b */
    static /* synthetic */ C0120S m7351b(C12543b event) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = C0120S.m651c();
        $jacocoInit[156] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11615a(View snackView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountNavigator.navigateToAccountView(AccountOrigins.REPLY_REVIEW);
        $jacocoInit[155] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m7349a(Object a) {
        $jacocoInit()[144] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m7350a(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[142] = true;
        instance.log(err);
        $jacocoInit[143] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11619a(Review review, Void a) {
        boolean[] $jacocoInit = $jacocoInit();
        setReviewRating(review.getId(), true);
        $jacocoInit[141] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo11621b(Review review, Void a) {
        boolean[] $jacocoInit = $jacocoInit();
        setReviewRating(review.getId(), false);
        $jacocoInit[140] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11618a(Review review, RateAndReviewCommentDisplayable displayable, Void a) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.isCommentsCollapsed) {
            $jacocoInit[131] = true;
            long id = review.getId();
            $jacocoInit[132] = true;
            CommentAdder commentAdder = displayable.getCommentAdder();
            $jacocoInit[133] = true;
            loadCommentsForThisReview(id, 3, commentAdder);
            $jacocoInit[134] = true;
            this.showHideReplies.setCompoundDrawablesWithIntrinsicBounds(0, 0, C1375R.drawable.ic_up_arrow, 0);
            this.isCommentsCollapsed = false;
            $jacocoInit[135] = true;
        } else {
            CommentAdder commentAdder2 = displayable.getCommentAdder();
            $jacocoInit[136] = true;
            commentAdder2.collapseComments();
            $jacocoInit[137] = true;
            this.showHideReplies.setCompoundDrawablesWithIntrinsicBounds(0, 0, C1375R.drawable.ic_down_arrow, 0);
            this.isCommentsCollapsed = true;
            $jacocoInit[138] = true;
        }
        $jacocoInit[139] = true;
    }

    private void loadCommentsForThisReview(long reviewId, int limit, CommentAdder commentAdder) {
        boolean[] $jacocoInit = $jacocoInit();
        BodyInterceptor<BaseBody> bodyInterceptor2 = this.bodyInterceptor;
        OkHttpClient okHttpClient = this.httpClient;
        Factory factory = this.converterFactory;
        TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
        $jacocoInit[75] = true;
        SharedPreferences defaultSharedPreferences = ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences();
        $jacocoInit[76] = true;
        ListCommentsRequest of = ListCommentsRequest.m7471of(reviewId, limit, true, bodyInterceptor2, okHttpClient, factory, tokenInvalidator2, defaultSharedPreferences);
        C2664J j = new C2664J(this, commentAdder);
        C2666L l = new C2666L(this);
        $jacocoInit[77] = true;
        of.execute(j, l, true);
        $jacocoInit[78] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11617a(CommentAdder commentAdder, ListComments listComments) {
        boolean[] $jacocoInit = $jacocoInit();
        if (listComments.isOk()) {
            $jacocoInit[123] = true;
            DataList dataList = listComments.getDataList();
            $jacocoInit[124] = true;
            List<Comment> comments = dataList.getList();
            $jacocoInit[125] = true;
            commentAdder.addComment(comments);
            $jacocoInit[126] = true;
        } else {
            Logger instance = Logger.getInstance();
            String str = TAG;
            $jacocoInit[127] = true;
            instance.mo2140e(str, "error loading comments");
            $jacocoInit[128] = true;
            ShowMessage.asSnack((View) this.flagHelfull, (int) C1375R.string.unknown_error);
            $jacocoInit[129] = true;
        }
        $jacocoInit[130] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo11622b(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        String str = TAG;
        $jacocoInit[120] = true;
        instance.mo2142e(str, err);
        $jacocoInit[121] = true;
        ShowMessage.asSnack((View) this.flagHelfull, (int) C1375R.string.unknown_error);
        $jacocoInit[122] = true;
    }

    private void setReviewRating(long reviewId, boolean positive) {
        boolean[] $jacocoInit = $jacocoInit();
        setHelpButtonsClickable(false);
        $jacocoInit[79] = true;
        if (this.accountManager.isLoggedIn()) {
            BodyInterceptor<BaseBody> bodyInterceptor2 = this.bodyInterceptor;
            OkHttpClient okHttpClient = this.httpClient;
            Factory factory = this.converterFactory;
            TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
            $jacocoInit[80] = true;
            SharedPreferences defaultSharedPreferences = ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences();
            $jacocoInit[81] = true;
            SetReviewRatingRequest of = SetReviewRatingRequest.m7484of(reviewId, positive, bodyInterceptor2, okHttpClient, factory, tokenInvalidator2, defaultSharedPreferences);
            C2669O o = new C2669O(this, reviewId, positive);
            C2660F f = new C2660F(this);
            $jacocoInit[82] = true;
            of.execute(o, f, true);
            $jacocoInit[83] = true;
        } else {
            ShowMessage.asSnack((Activity) getContext(), (int) C1375R.string.you_need_to_be_logged_in, (int) C1375R.string.login, (OnClickListener) new C2662H(this), -1);
            $jacocoInit[84] = true;
            setHelpButtonsClickable(true);
            $jacocoInit[85] = true;
        }
        $jacocoInit[86] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11614a(long reviewId, boolean positive, BaseV7Response response) {
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        if (response == null) {
            $jacocoInit[97] = true;
            Logger instance = Logger.getInstance();
            String str2 = TAG;
            $jacocoInit[98] = true;
            instance.mo2140e(str2, "empty response");
            $jacocoInit[99] = true;
        } else if (response.getError() != null) {
            $jacocoInit[100] = true;
            Logger instance2 = Logger.getInstance();
            String str3 = TAG;
            $jacocoInit[101] = true;
            Error error = response.getError();
            $jacocoInit[102] = true;
            String description = error.getDescription();
            $jacocoInit[103] = true;
            instance2.mo2140e(str3, description);
            $jacocoInit[104] = true;
        } else {
            List<Error> errorList = response.getErrors();
            $jacocoInit[105] = true;
            if (errorList == null) {
                $jacocoInit[106] = true;
            } else if (errorList.isEmpty()) {
                $jacocoInit[107] = true;
            } else {
                $jacocoInit[108] = true;
                $jacocoInit[109] = true;
                for (Error error2 : errorList) {
                    $jacocoInit[110] = true;
                    Logger instance3 = Logger.getInstance();
                    String str4 = TAG;
                    $jacocoInit[111] = true;
                    instance3.mo2140e(str4, error2.getDescription());
                    $jacocoInit[112] = true;
                }
                $jacocoInit[113] = true;
                return;
            }
            Logger instance4 = Logger.getInstance();
            String str5 = TAG;
            Object[] objArr = new Object[2];
            $jacocoInit[114] = true;
            objArr[0] = Long.valueOf(reviewId);
            if (positive) {
                $jacocoInit[115] = true;
                str = "positive";
            } else {
                $jacocoInit[116] = true;
                str = "negative";
            }
            objArr[1] = str;
            instance4.mo2136d(str5, String.format("review %d was marked as %s", objArr));
            $jacocoInit[117] = true;
            setHelpButtonsClickable(true);
            $jacocoInit[118] = true;
            ShowMessage.asSnack((View) this.flagHelfull, (int) C1375R.string.thank_you_for_your_opinion);
            $jacocoInit[119] = true;
        }
    }

    /* renamed from: c */
    public /* synthetic */ void mo11624c(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        ShowMessage.asSnack((View) this.flagHelfull, (int) C1375R.string.unknown_error);
        $jacocoInit[93] = true;
        Logger instance = Logger.getInstance();
        String str = TAG;
        $jacocoInit[94] = true;
        instance.mo2142e(str, err);
        $jacocoInit[95] = true;
        setHelpButtonsClickable(true);
        $jacocoInit[96] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo11620b(View snackView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountNavigator.navigateToAccountView(AccountOrigins.REVIEW_FEEDBACK);
        $jacocoInit[92] = true;
    }

    private void setHelpButtonsClickable(boolean clickable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.flagHelfull.setClickable(clickable);
        $jacocoInit[87] = true;
        this.flagNotHelfull.setClickable(clickable);
        $jacocoInit[88] = true;
        this.notHelpfullButtonLayout.setClickable(clickable);
        $jacocoInit[89] = true;
        this.helpfullButtonLayout.setClickable(clickable);
        $jacocoInit[90] = true;
    }
}
