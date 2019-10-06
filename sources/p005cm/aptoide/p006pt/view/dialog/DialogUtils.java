package p005cm.aptoide.p006pt.view.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.design.widget.TextInputLayout;
import android.support.p001v7.widget.AppCompatRatingBar;
import android.text.Editable;
import android.text.SpannableString;
import android.text.style.BulletSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import java.util.Locale;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.account.AccountAnalytics.AccountOrigins;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.dataprovider.interfaces.ErrorRequestListener;
import p005cm.aptoide.p006pt.dataprovider.interfaces.SuccessRequestListener;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.PostReviewRequest;
import p005cm.aptoide.p006pt.install.InstalledRepository;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.preferences.managed.ManagerPreferences;
import p005cm.aptoide.p006pt.util.MarketResourceFormatter;
import p005cm.aptoide.p006pt.utils.AptoideUtils.SystemU;
import p005cm.aptoide.p006pt.utils.GenericDialogs.EResponse;
import p005cm.aptoide.p006pt.utils.design.ShowMessage;
import p026rx.C0120S;
import p026rx.C0120S.C0122a;
import p026rx.C14980ia;
import p026rx.p027b.C0128a;
import p026rx.p029i.C14978f;
import retrofit2.Converter.Factory;

@Deprecated
/* renamed from: cm.aptoide.pt.view.dialog.DialogUtils */
public class DialogUtils {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static final String TAG = DialogUtils.class.getSimpleName();
    private final Locale LOCALE = Locale.getDefault();
    private final AptoideAccountManager accountManager;
    private final AccountNavigator accountNavigator;
    private final BodyInterceptor<BaseBody> bodyInterceptor;
    private final Factory converterFactory;
    private final OkHttpClient httpClient;
    private final InstalledRepository installedRepository;
    private final String marketName;
    private final MarketResourceFormatter marketResourceFormatter;
    private final Resources resources;
    private final SharedPreferences sharedPreferences;
    private final TokenInvalidator tokenInvalidator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3285036891780588565L, "cm/aptoide/pt/view/dialog/DialogUtils", Opcodes.F2I);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[138] = true;
    }

    public DialogUtils(AptoideAccountManager accountManager2, AccountNavigator accountNavigator2, BodyInterceptor<BaseBody> bodyInterceptor2, OkHttpClient httpClient2, Factory converterFactory2, InstalledRepository installedRepository2, TokenInvalidator tokenInvalidator2, SharedPreferences sharedPreferences2, Resources resources2, String marketName2, MarketResourceFormatter marketResourceFormatter2) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        this.accountManager = accountManager2;
        this.accountNavigator = accountNavigator2;
        this.bodyInterceptor = bodyInterceptor2;
        this.httpClient = httpClient2;
        this.converterFactory = converterFactory2;
        this.installedRepository = installedRepository2;
        this.tokenInvalidator = tokenInvalidator2;
        this.sharedPreferences = sharedPreferences2;
        this.resources = resources2;
        this.marketName = marketName2;
        this.marketResourceFormatter = marketResourceFormatter2;
        $jacocoInit[1] = true;
    }

    public C0120S<EResponse> showRateDialog(Activity activity, String appName, String packageName, String storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        C5331m mVar = new C5331m(this, activity, appName, storeName, packageName);
        C0120S<EResponse> a = C0120S.m634a((C0122a<T>) mVar);
        $jacocoInit[2] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17171a(Activity activity, String appName, String storeName, String packageName, C14980ia subscriber) {
        Activity activity2 = activity;
        C14980ia iaVar = subscriber;
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.accountManager.isLoggedIn()) {
            $jacocoInit[55] = true;
            ShowMessage.asSnack(activity2, (int) C1375R.string.you_need_to_be_logged_in, (int) C1375R.string.login, (OnClickListener) new C5321c(this), -1);
            $jacocoInit[56] = true;
            iaVar.onNext(EResponse.CANCEL);
            $jacocoInit[57] = true;
            subscriber.onCompleted();
            $jacocoInit[58] = true;
            return;
        }
        LayoutInflater from = LayoutInflater.from(activity);
        $jacocoInit[59] = true;
        View view = from.inflate(C1375R.layout.dialog_rate_app, null);
        $jacocoInit[60] = true;
        TextView titleTextView = (TextView) view.findViewById(C1375R.C1376id.title);
        $jacocoInit[61] = true;
        AppCompatRatingBar reviewRatingBar = (AppCompatRatingBar) view.findViewById(C1375R.C1376id.rating_bar);
        $jacocoInit[62] = true;
        TextInputLayout reviewTextInputLayout = (TextInputLayout) view.findViewById(C1375R.C1376id.input_layout_review);
        $jacocoInit[63] = true;
        Button cancelBtn = (Button) view.findViewById(C1375R.C1376id.cancel_button);
        $jacocoInit[64] = true;
        Button rateBtn = (Button) view.findViewById(C1375R.C1376id.rate_button);
        $jacocoInit[65] = true;
        TextView highlightedReviewsExplained_1 = (TextView) view.findViewById(C1375R.C1376id.highlighted_reviews_explanation_1);
        $jacocoInit[66] = true;
        TextView highlightedReviewsExplained_2 = (TextView) view.findViewById(C1375R.C1376id.highlighted_reviews_explanation_2);
        $jacocoInit[67] = true;
        TextView highlightedReviewsExplained_3 = (TextView) view.findViewById(C1375R.C1376id.highlighted_reviews_explanation_3);
        $jacocoInit[68] = true;
        TextView highlightedReviewsExplained_4 = (TextView) view.findViewById(C1375R.C1376id.highlighted_reviews_explanation_4);
        $jacocoInit[69] = true;
        TextView highlightedReviewsExplained_42 = highlightedReviewsExplained_4;
        titleTextView.setText(String.format(this.LOCALE, activity2.getString(C1375R.string.rate_app), new Object[]{appName}));
        $jacocoInit[70] = true;
        Builder builder = new Builder(activity2).setView(view);
        $jacocoInit[71] = true;
        AlertDialog dialog = builder.create();
        $jacocoInit[72] = true;
        iaVar.add(C14978f.m46781a(new C5330l(dialog)));
        $jacocoInit[73] = true;
        cancelBtn.setOnClickListener(new C5326h(iaVar));
        $jacocoInit[74] = true;
        reviewRatingBar.setOnRatingBarChangeListener(new C5324f(view, activity2));
        $jacocoInit[75] = true;
        C5323e eVar = r0;
        TextView highlightedReviewsExplained_43 = highlightedReviewsExplained_42;
        AlertDialog dialog2 = dialog;
        TextView highlightedReviewsExplained_44 = highlightedReviewsExplained_43;
        TextView highlightedReviewsExplained_22 = highlightedReviewsExplained_2;
        TextView highlightedReviewsExplained_32 = highlightedReviewsExplained_3;
        TextView highlightedReviewsExplained_12 = highlightedReviewsExplained_1;
        View view2 = view;
        View view3 = view;
        Button rateBtn2 = rateBtn;
        Button button = cancelBtn;
        AppCompatRatingBar appCompatRatingBar = reviewRatingBar;
        TextView textView = titleTextView;
        C5323e eVar2 = new C5323e(this, activity, reviewTextInputLayout, reviewRatingBar, view2, dialog2, subscriber, storeName, packageName);
        rateBtn2.setOnClickListener(eVar);
        $jacocoInit[76] = true;
        Resources resources2 = activity.getResources();
        $jacocoInit[77] = true;
        String string = resources2.getString(C1375R.string.reviewappview_highlighted_reviews_explanation_1);
        $jacocoInit[78] = true;
        highlightedReviewsExplained_12.setText(string);
        $jacocoInit[79] = true;
        Resources resources3 = activity.getResources();
        $jacocoInit[80] = true;
        String string2 = resources3.getString(C1375R.string.reviewappview_highlighted_reviews_explanation_2);
        $jacocoInit[81] = true;
        setBulletText(highlightedReviewsExplained_22, string2);
        $jacocoInit[82] = true;
        Resources resources4 = activity.getResources();
        $jacocoInit[83] = true;
        String string3 = resources4.getString(C1375R.string.reviewappview_highlighted_reviews_explanation_3);
        $jacocoInit[84] = true;
        setBulletText(highlightedReviewsExplained_32, string3);
        MarketResourceFormatter marketResourceFormatter2 = this.marketResourceFormatter;
        $jacocoInit[85] = true;
        String formatString = marketResourceFormatter2.formatString(view3.getContext(), C1375R.string.reviewappview_highlighted_reviews_explanation_4, new String[0]);
        $jacocoInit[86] = true;
        setBulletText(highlightedReviewsExplained_44, formatString);
        $jacocoInit[87] = true;
        dialog2.show();
        $jacocoInit[88] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17174a(View snackView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountNavigator.navigateToAccountView(AccountOrigins.RATE_DIALOG);
        $jacocoInit[137] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9601a(AlertDialog dialog) {
        boolean[] $jacocoInit = $jacocoInit();
        if (dialog == null) {
            $jacocoInit[132] = true;
        } else if (!dialog.isShowing()) {
            $jacocoInit[133] = true;
        } else {
            $jacocoInit[134] = true;
            dialog.dismiss();
            $jacocoInit[135] = true;
        }
        $jacocoInit[136] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9604a(C14980ia subscriber, View v) {
        boolean[] $jacocoInit = $jacocoInit();
        subscriber.onNext(EResponse.CANCEL);
        $jacocoInit[130] = true;
        subscriber.onCompleted();
        $jacocoInit[131] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9603a(View view, Activity activity, RatingBar ratingBar, float v, boolean b) {
        boolean[] $jacocoInit = $jacocoInit();
        TextView textView = (TextView) view.findViewById(C1375R.C1376id.tap_to_rate);
        $jacocoInit[126] = true;
        Resources resources2 = activity.getResources();
        $jacocoInit[127] = true;
        int color = resources2.getColor(C1375R.color.grey_fog_dark);
        $jacocoInit[128] = true;
        textView.setTextColor(color);
        $jacocoInit[129] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17170a(Activity activity, TextInputLayout reviewTextInputLayout, AppCompatRatingBar reviewRatingBar, View view, AlertDialog dialog, C14980ia subscriber, String storeName, String packageName, View v) {
        Activity activity2 = activity;
        C14980ia iaVar = subscriber;
        String str = packageName;
        boolean[] $jacocoInit = $jacocoInit();
        SystemU.hideKeyboard(activity);
        $jacocoInit[89] = true;
        EditText editText = reviewTextInputLayout.getEditText();
        $jacocoInit[90] = true;
        Editable text = editText.getText();
        $jacocoInit[91] = true;
        String reviewText = text.toString();
        $jacocoInit[92] = true;
        int reviewRating = Math.round(reviewRatingBar.getRating());
        if (reviewRating == 0) {
            $jacocoInit[93] = true;
            TextView textView = (TextView) view.findViewById(C1375R.C1376id.tap_to_rate);
            Resources resources2 = activity.getResources();
            $jacocoInit[94] = true;
            int color = resources2.getColor(C1375R.color.red);
            $jacocoInit[95] = true;
            textView.setTextColor(color);
            $jacocoInit[96] = true;
            ShowMessage.asSnack(activity2, "Please choose a rating");
            $jacocoInit[97] = true;
            return;
        }
        View view2 = view;
        dialog.dismiss();
        $jacocoInit[98] = true;
        SuccessRequestListener<BaseV7Response> dVar = new C5322d<>(this, activity2, iaVar);
        $jacocoInit[99] = true;
        ErrorRequestListener bVar = new C5320b(activity2, iaVar);
        if (storeName != null) {
            $jacocoInit[100] = true;
            Integer valueOf = Integer.valueOf(reviewRating);
            BodyInterceptor<BaseBody> bodyInterceptor2 = this.bodyInterceptor;
            OkHttpClient okHttpClient = this.httpClient;
            Factory factory = this.converterFactory;
            $jacocoInit[101] = true;
            boolean isAppInstalled = isAppInstalled(str);
            TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
            SharedPreferences sharedPreferences2 = this.sharedPreferences;
            $jacocoInit[102] = true;
            TokenInvalidator tokenInvalidator3 = tokenInvalidator2;
            C5320b bVar2 = bVar;
            SuccessRequestListener<BaseV7Response> successRequestListener = dVar;
            PostReviewRequest of = PostReviewRequest.m7483of(storeName, packageName, reviewText, valueOf, bodyInterceptor2, okHttpClient, factory, isAppInstalled, tokenInvalidator3, sharedPreferences2);
            $jacocoInit[103] = true;
            C5320b bVar3 = bVar2;
            of.execute(successRequestListener, (ErrorRequestListener) bVar3);
            $jacocoInit[104] = true;
            C5320b bVar4 = bVar3;
        } else {
            SuccessRequestListener<BaseV7Response> successRequestListener2 = dVar;
            ErrorRequestListener errorRequestListener = bVar;
            Integer valueOf2 = Integer.valueOf(reviewRating);
            BodyInterceptor<BaseBody> bodyInterceptor3 = this.bodyInterceptor;
            OkHttpClient okHttpClient2 = this.httpClient;
            Factory factory2 = this.converterFactory;
            $jacocoInit[105] = true;
            boolean isAppInstalled2 = isAppInstalled(str);
            TokenInvalidator tokenInvalidator4 = this.tokenInvalidator;
            SharedPreferences sharedPreferences3 = this.sharedPreferences;
            $jacocoInit[106] = true;
            ErrorRequestListener errorRequestListener2 = errorRequestListener;
            PostReviewRequest of2 = PostReviewRequest.m7482of(packageName, reviewText, valueOf2, bodyInterceptor3, okHttpClient2, factory2, isAppInstalled2, tokenInvalidator4, sharedPreferences3);
            $jacocoInit[107] = true;
            of2.execute(successRequestListener2, errorRequestListener2);
            $jacocoInit[108] = true;
        }
        $jacocoInit[109] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17173a(Activity activity, C14980ia subscriber, BaseV7Response response) {
        boolean[] $jacocoInit = $jacocoInit();
        if (response.isOk()) {
            $jacocoInit[115] = true;
            Logger instance = Logger.getInstance();
            String str = TAG;
            $jacocoInit[116] = true;
            instance.mo2136d(str, "review added");
            $jacocoInit[117] = true;
            ShowMessage.asSnack(activity, (int) C1375R.string.review_success);
            $jacocoInit[118] = true;
            ManagerPreferences.setForceServerRefreshFlag(true, this.sharedPreferences);
            $jacocoInit[119] = true;
            subscriber.onNext(EResponse.YES);
            $jacocoInit[120] = true;
            subscriber.onCompleted();
            $jacocoInit[121] = true;
        } else {
            ShowMessage.asSnack(activity, (int) C1375R.string.error_occured);
            $jacocoInit[122] = true;
            subscriber.onNext(EResponse.CANCEL);
            $jacocoInit[123] = true;
            subscriber.onCompleted();
            $jacocoInit[124] = true;
        }
        $jacocoInit[125] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9600a(Activity activity, C14980ia subscriber, Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[110] = true;
        instance.log(e);
        $jacocoInit[111] = true;
        ShowMessage.asSnack(activity, (int) C1375R.string.error_occured);
        $jacocoInit[112] = true;
        subscriber.onNext(EResponse.CANCEL);
        $jacocoInit[113] = true;
        subscriber.onCompleted();
        $jacocoInit[114] = true;
    }

    public void setBulletText(TextView textView, String text) {
        boolean[] $jacocoInit = $jacocoInit();
        SpannableString spannable = new SpannableString(text);
        $jacocoInit[3] = true;
        BulletSpan bulletSpan = new BulletSpan(16, this.resources.getColor(C1375R.color.default_orange_gradient_end));
        $jacocoInit[4] = true;
        int length = text.length();
        $jacocoInit[5] = true;
        spannable.setSpan(bulletSpan, 0, length, 0);
        $jacocoInit[6] = true;
        textView.setText(spannable);
        $jacocoInit[7] = true;
    }

    private boolean isAppInstalled(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        boolean contains = this.installedRepository.contains(packageName);
        $jacocoInit[8] = true;
        return contains;
    }

    public void showRateDialog(Activity activity, String appName, String packageName, String storeName, C0128a onPositiveCallback) {
        Activity activity2 = activity;
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.accountManager.isLoggedIn()) {
            $jacocoInit[9] = true;
            ShowMessage.asSnack(activity2, (int) C1375R.string.you_need_to_be_logged_in, (int) C1375R.string.login, (OnClickListener) new C5325g(this), -1);
            $jacocoInit[10] = true;
            return;
        }
        LayoutInflater from = LayoutInflater.from(activity);
        $jacocoInit[11] = true;
        View view = from.inflate(C1375R.layout.dialog_rate_app, null);
        $jacocoInit[12] = true;
        TextView titleTextView = (TextView) view.findViewById(C1375R.C1376id.title);
        $jacocoInit[13] = true;
        AppCompatRatingBar reviewRatingBar = (AppCompatRatingBar) view.findViewById(C1375R.C1376id.rating_bar);
        $jacocoInit[14] = true;
        TextInputLayout reviewTextInputLayout = (TextInputLayout) view.findViewById(C1375R.C1376id.input_layout_review);
        $jacocoInit[15] = true;
        Button cancelBtn = (Button) view.findViewById(C1375R.C1376id.cancel_button);
        $jacocoInit[16] = true;
        Button rateBtn = (Button) view.findViewById(C1375R.C1376id.rate_button);
        $jacocoInit[17] = true;
        titleTextView.setText(String.format(this.LOCALE, activity2.getString(C1375R.string.rate_app), new Object[]{appName}));
        $jacocoInit[18] = true;
        Builder builder = new Builder(activity2).setView(view);
        $jacocoInit[19] = true;
        AlertDialog dialog = builder.create();
        $jacocoInit[20] = true;
        cancelBtn.setOnClickListener(new C5328j(dialog));
        $jacocoInit[21] = true;
        C5329k kVar = r0;
        AlertDialog dialog2 = dialog;
        Button rateBtn2 = rateBtn;
        Button button = cancelBtn;
        C5329k kVar2 = new C5329k(this, activity, reviewTextInputLayout, reviewRatingBar, dialog, onPositiveCallback, storeName, packageName);
        rateBtn2.setOnClickListener(kVar);
        $jacocoInit[22] = true;
        dialog2.show();
        $jacocoInit[23] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo17175b(View snackView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountNavigator.navigateToAccountView(AccountOrigins.RATE_DIALOG);
        $jacocoInit[54] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9602a(AlertDialog dialog, View v) {
        boolean[] $jacocoInit = $jacocoInit();
        dialog.dismiss();
        $jacocoInit[53] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17169a(Activity activity, TextInputLayout reviewTextInputLayout, AppCompatRatingBar reviewRatingBar, AlertDialog dialog, C0128a onPositiveCallback, String storeName, String packageName, View v) {
        Activity activity2 = activity;
        String str = packageName;
        boolean[] $jacocoInit = $jacocoInit();
        SystemU.hideKeyboard(activity);
        $jacocoInit[24] = true;
        EditText editText = reviewTextInputLayout.getEditText();
        $jacocoInit[25] = true;
        Editable text = editText.getText();
        $jacocoInit[26] = true;
        String reviewText = text.toString();
        $jacocoInit[27] = true;
        int reviewRating = Math.round(reviewRatingBar.getRating());
        $jacocoInit[28] = true;
        dialog.dismiss();
        $jacocoInit[29] = true;
        SuccessRequestListener<BaseV7Response> nVar = new C5332n<>(this, activity2, onPositiveCallback);
        $jacocoInit[30] = true;
        ErrorRequestListener iVar = new C5327i(activity2);
        if (storeName != null) {
            $jacocoInit[31] = true;
            Integer valueOf = Integer.valueOf(reviewRating);
            BodyInterceptor<BaseBody> bodyInterceptor2 = this.bodyInterceptor;
            OkHttpClient okHttpClient = this.httpClient;
            Factory factory = this.converterFactory;
            $jacocoInit[32] = true;
            boolean isAppInstalled = isAppInstalled(str);
            TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
            SharedPreferences sharedPreferences2 = this.sharedPreferences;
            $jacocoInit[33] = true;
            TokenInvalidator tokenInvalidator3 = tokenInvalidator2;
            C5327i iVar2 = iVar;
            SuccessRequestListener<BaseV7Response> successRequestListener = nVar;
            PostReviewRequest of = PostReviewRequest.m7483of(storeName, packageName, reviewText, valueOf, bodyInterceptor2, okHttpClient, factory, isAppInstalled, tokenInvalidator3, sharedPreferences2);
            $jacocoInit[34] = true;
            C5327i iVar3 = iVar2;
            of.execute(successRequestListener, (ErrorRequestListener) iVar3);
            $jacocoInit[35] = true;
            C5327i iVar4 = iVar3;
        } else {
            ErrorRequestListener errorRequestListener = iVar;
            Integer valueOf2 = Integer.valueOf(reviewRating);
            BodyInterceptor<BaseBody> bodyInterceptor3 = this.bodyInterceptor;
            OkHttpClient okHttpClient2 = this.httpClient;
            Factory factory2 = this.converterFactory;
            $jacocoInit[36] = true;
            boolean isAppInstalled2 = isAppInstalled(str);
            TokenInvalidator tokenInvalidator4 = this.tokenInvalidator;
            SharedPreferences sharedPreferences3 = this.sharedPreferences;
            $jacocoInit[37] = true;
            ErrorRequestListener errorRequestListener2 = errorRequestListener;
            PostReviewRequest of2 = PostReviewRequest.m7482of(packageName, reviewText, valueOf2, bodyInterceptor3, okHttpClient2, factory2, isAppInstalled2, tokenInvalidator4, sharedPreferences3);
            $jacocoInit[38] = true;
            of2.execute(nVar, errorRequestListener2);
            $jacocoInit[39] = true;
        }
        $jacocoInit[40] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17172a(Activity activity, C0128a onPositiveCallback, BaseV7Response response) {
        boolean[] $jacocoInit = $jacocoInit();
        if (response.isOk()) {
            $jacocoInit[44] = true;
            Logger instance = Logger.getInstance();
            String str = TAG;
            $jacocoInit[45] = true;
            instance.mo2136d(str, "review added");
            $jacocoInit[46] = true;
            ShowMessage.asSnack(activity, (int) C1375R.string.review_success);
            $jacocoInit[47] = true;
            ManagerPreferences.setForceServerRefreshFlag(true, this.sharedPreferences);
            if (onPositiveCallback == null) {
                $jacocoInit[48] = true;
            } else {
                $jacocoInit[49] = true;
                onPositiveCallback.call();
                $jacocoInit[50] = true;
            }
        } else {
            ShowMessage.asSnack(activity, (int) C1375R.string.error_occured);
            $jacocoInit[51] = true;
        }
        $jacocoInit[52] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9599a(Activity activity, Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[41] = true;
        instance.log(e);
        $jacocoInit[42] = true;
        ShowMessage.asSnack(activity, (int) C1375R.string.error_occured);
        $jacocoInit[43] = true;
    }
}
