package p005cm.aptoide.p006pt.comments.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.p000v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.trello.rxlifecycle.p017b.p018a.C12549b;
import com.trello.rxlifecycle.p263a.C12543b;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.comments.CommentDialogCallbackContract;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.PostCommentForReview;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.PostCommentForStore;
import p005cm.aptoide.p006pt.dataprovider.util.CommentType;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.store.StoreAnalytics;
import p005cm.aptoide.p006pt.utils.AptoideUtils.StringU;
import p005cm.aptoide.p006pt.utils.design.ShowMessage;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.C0126V;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p387a.p389b.C14522a;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.comments.view.CommentDialogFragment */
public class CommentDialogFragment extends C12549b {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String APP_OR_STORE_NAME = "app_or_store_name";
    private static final String COMMENT_TYPE = "comment_type";
    private static final String PREVIOUS_COMMENT_ID = "previous_comment_id";
    private static final String RESOURCE_ID_AS_LONG = "resource_id_as_long";
    private static final String RESOURCE_ID_AS_STRING = "resource_id_as_string";
    private AnalyticsManager analyticsManager;
    private String appOrStoreName;
    private BodyInterceptor<BaseBody> baseBodyBodyInterceptor;
    private Button commentButton;
    private CommentDialogCallbackContract commentDialogCallbackContract;
    private CommentType commentType;
    private Factory converterFactory;
    private OkHttpClient httpClient;
    private long idAsLong;
    private String idAsString;
    private NavigationTracker navigationTracker;
    private String onEmptyTextError;
    private Long previousCommentId;
    private SharedPreferences sharedPreferences;
    private StoreAnalytics storeAnalytics;
    private TextInputLayout textInputLayout;
    private TokenInvalidator tokenInvalidator;

    /* renamed from: cm.aptoide.pt.comments.view.CommentDialogFragment$2 */
    static /* synthetic */ class C26572 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$dataprovider$util$CommentType = new int[CommentType.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-5417092959684013239L, "cm/aptoide/pt/comments/view/CommentDialogFragment$2", 6);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                $SwitchMap$cm$aptoide$pt$dataprovider$util$CommentType[CommentType.REVIEW.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                try {
                    $jacocoInit[2] = true;
                } catch (NoSuchFieldError e2) {
                    $jacocoInit[4] = true;
                }
            }
            $SwitchMap$cm$aptoide$pt$dataprovider$util$CommentType[CommentType.STORE.ordinal()] = 2;
            $jacocoInit[3] = true;
            $jacocoInit[5] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1925285992306996057L, "cm/aptoide/pt/comments/view/CommentDialogFragment", 114);
        $jacocoData = probes;
        return probes;
    }

    public CommentDialogFragment() {
        $jacocoInit()[0] = true;
    }

    static /* synthetic */ void access$000(CommentDialogFragment x0) {
        boolean[] $jacocoInit = $jacocoInit();
        x0.disableError();
        $jacocoInit[113] = true;
    }

    public static CommentDialogFragment newInstanceStoreCommentReply(long storeId, long previousCommentId2, String storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle args = new Bundle();
        $jacocoInit[1] = true;
        args.putString(COMMENT_TYPE, CommentType.STORE.name());
        $jacocoInit[2] = true;
        args.putLong(RESOURCE_ID_AS_LONG, storeId);
        $jacocoInit[3] = true;
        args.putLong(PREVIOUS_COMMENT_ID, previousCommentId2);
        $jacocoInit[4] = true;
        if (TextUtils.isEmpty(storeName)) {
            $jacocoInit[5] = true;
        } else {
            $jacocoInit[6] = true;
            args.putString(APP_OR_STORE_NAME, storeName);
            $jacocoInit[7] = true;
        }
        CommentDialogFragment fragment = new CommentDialogFragment();
        $jacocoInit[8] = true;
        fragment.setArguments(args);
        $jacocoInit[9] = true;
        return fragment;
    }

    public static CommentDialogFragment newInstanceReview(long id, String appName) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle args = new Bundle();
        $jacocoInit[10] = true;
        args.putString(COMMENT_TYPE, CommentType.REVIEW.name());
        $jacocoInit[11] = true;
        args.putLong(RESOURCE_ID_AS_LONG, id);
        $jacocoInit[12] = true;
        if (TextUtils.isEmpty(appName)) {
            $jacocoInit[13] = true;
        } else {
            $jacocoInit[14] = true;
            args.putString(APP_OR_STORE_NAME, appName);
            $jacocoInit[15] = true;
        }
        CommentDialogFragment fragment = new CommentDialogFragment();
        $jacocoInit[16] = true;
        fragment.setArguments(args);
        $jacocoInit[17] = true;
        return fragment;
    }

    public static CommentDialogFragment newInstanceStoreComment(long storeId, String storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle args = new Bundle();
        $jacocoInit[18] = true;
        args.putString(COMMENT_TYPE, CommentType.STORE.name());
        $jacocoInit[19] = true;
        args.putLong(RESOURCE_ID_AS_LONG, storeId);
        $jacocoInit[20] = true;
        if (TextUtils.isEmpty(storeName)) {
            $jacocoInit[21] = true;
        } else {
            $jacocoInit[22] = true;
            args.putString(APP_OR_STORE_NAME, storeName);
            $jacocoInit[23] = true;
        }
        CommentDialogFragment fragment = new CommentDialogFragment();
        $jacocoInit[24] = true;
        fragment.setArguments(args);
        $jacocoInit[25] = true;
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[26] = true;
        AptoideApplication application = (AptoideApplication) getContext().getApplicationContext();
        $jacocoInit[27] = true;
        this.sharedPreferences = application.getDefaultSharedPreferences();
        $jacocoInit[28] = true;
        this.tokenInvalidator = application.getTokenInvalidator();
        $jacocoInit[29] = true;
        this.baseBodyBodyInterceptor = application.getAccountSettingsBodyInterceptorPoolV7();
        $jacocoInit[30] = true;
        this.httpClient = application.getDefaultClient();
        $jacocoInit[31] = true;
        this.converterFactory = WebService.getDefaultConverter();
        $jacocoInit[32] = true;
        this.onEmptyTextError = StringU.getResString(C1375R.string.ws_error_MARG_107, getContext().getResources());
        $jacocoInit[33] = true;
        this.analyticsManager = application.getAnalyticsManager();
        $jacocoInit[34] = true;
        this.navigationTracker = application.getNavigationTracker();
        $jacocoInit[35] = true;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        loadArguments();
        $jacocoInit[36] = true;
        View view = inflater.inflate(C1375R.layout.dialog_comment_on_review, container);
        $jacocoInit[37] = true;
        TextView titleTextView = (TextView) view.findViewById(C1375R.C1376id.title);
        $jacocoInit[38] = true;
        titleTextView.setVisibility(0);
        $jacocoInit[39] = true;
        int i = C26572.$SwitchMap$cm$aptoide$pt$dataprovider$util$CommentType[this.commentType.ordinal()];
        if (i == 1) {
            titleTextView.setText(getString(C1375R.string.dialog_title_comment));
            $jacocoInit[41] = true;
        } else if (i != 2) {
            $jacocoInit[40] = true;
        } else {
            String str2 = this.appOrStoreName;
            $jacocoInit[42] = true;
            if (TextUtils.isEmpty(str2)) {
                str = getString(C1375R.string.comment_store_title);
                $jacocoInit[43] = true;
            } else {
                Object[] objArr = {this.appOrStoreName};
                $jacocoInit[44] = true;
                str = getString(C1375R.string.commentlist_title_comment_on_store, objArr);
                $jacocoInit[45] = true;
            }
            titleTextView.setText(str);
            $jacocoInit[46] = true;
        }
        Button cancelButton = (Button) view.findViewById(C1375R.C1376id.cancel_button);
        $jacocoInit[47] = true;
        cancelButton.setOnClickListener(new C2680a(this));
        $jacocoInit[48] = true;
        this.textInputLayout = (TextInputLayout) view.findViewById(C1375R.C1376id.input_layout_title);
        $jacocoInit[49] = true;
        this.commentButton = (Button) view.findViewById(C1375R.C1376id.comment_button);
        $jacocoInit[50] = true;
        setupLogic();
        $jacocoInit[51] = true;
        this.storeAnalytics = new StoreAnalytics(this.analyticsManager, this.navigationTracker);
        $jacocoInit[52] = true;
        return view;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11573a(View a) {
        boolean[] $jacocoInit = $jacocoInit();
        dismiss();
        $jacocoInit[112] = true;
    }

    private void loadArguments() {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle args = getArguments();
        $jacocoInit[53] = true;
        this.appOrStoreName = args.getString(APP_OR_STORE_NAME, "");
        $jacocoInit[54] = true;
        this.commentType = CommentType.valueOf(args.getString(COMMENT_TYPE));
        $jacocoInit[55] = true;
        this.idAsString = args.getString(RESOURCE_ID_AS_STRING);
        $jacocoInit[56] = true;
        this.idAsLong = args.getLong(RESOURCE_ID_AS_LONG);
        $jacocoInit[57] = true;
        String str = PREVIOUS_COMMENT_ID;
        if (!args.containsKey(str)) {
            $jacocoInit[58] = true;
        } else {
            $jacocoInit[59] = true;
            this.previousCommentId = Long.valueOf(args.getLong(str));
            $jacocoInit[60] = true;
        }
        $jacocoInit[61] = true;
    }

    private void setupLogic() {
        boolean[] $jacocoInit = $jacocoInit();
        EditText editText = this.textInputLayout.getEditText();
        C26561 r2 = new TextWatcher(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ CommentDialogFragment this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(6589152495093497295L, "cm/aptoide/pt/comments/view/CommentDialogFragment$1", 7);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                $jacocoInit()[1] = true;
            }

            public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
                boolean[] $jacocoInit = $jacocoInit();
                if (charSequence.length() <= 0) {
                    $jacocoInit[2] = true;
                } else {
                    $jacocoInit[3] = true;
                    CommentDialogFragment.access$000(this.this$0);
                    $jacocoInit[4] = true;
                }
                $jacocoInit[5] = true;
            }

            public void afterTextChanged(Editable editable) {
                $jacocoInit()[6] = true;
            }
        };
        $jacocoInit[62] = true;
        editText.addTextChangedListener(r2);
        $jacocoInit[63] = true;
        C0120S a = C13034a.m42490a(this.commentButton);
        C2682b bVar = new C2682b(this);
        $jacocoInit[64] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) bVar);
        C2688e eVar = new C2688e(this);
        $jacocoInit[65] = true;
        C0120S d = f.mo3653d((C0132p<? super T, Boolean>) eVar);
        C2684c cVar = new C2684c(this);
        $jacocoInit[66] = true;
        C0120S f2 = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) cVar);
        C2690f fVar = new C2690f(this);
        C2692g gVar = C2692g.f5876a;
        $jacocoInit[67] = true;
        f2.mo3626a((C0129b<? super T>) fVar, (C0129b<Throwable>) gVar);
        $jacocoInit[68] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo11572a(Void a) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = C0120S.m652c(getText());
        $jacocoInit[111] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ Boolean mo11571a(String inputText) {
        boolean[] $jacocoInit = $jacocoInit();
        if (TextUtils.isEmpty(inputText)) {
            $jacocoInit[106] = true;
            enableError(this.onEmptyTextError);
            $jacocoInit[107] = true;
            Boolean valueOf = Boolean.valueOf(false);
            $jacocoInit[108] = true;
            return valueOf;
        }
        disableError();
        $jacocoInit[109] = true;
        Boolean valueOf2 = Boolean.valueOf(true);
        $jacocoInit[110] = true;
        return valueOf2;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo11576b(String inputText) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S submitComment = submitComment(inputText, this.idAsLong, this.previousCommentId);
        $jacocoInit[97] = true;
        C0126V a = C14522a.m46170a();
        $jacocoInit[98] = true;
        C0120S a2 = submitComment.mo3616a(a);
        C2686d dVar = new C2686d(this);
        $jacocoInit[99] = true;
        C0120S a3 = a2.mo3621a((C0129b<? super Throwable>) dVar);
        $jacocoInit[100] = true;
        C0120S g = a3.mo3662g();
        C12543b bVar = C12543b.DESTROY_VIEW;
        $jacocoInit[101] = true;
        C0120S a4 = g.mo3614a((C0121c<? super T, ? extends R>) bindUntilEvent(bVar));
        $jacocoInit[102] = true;
        return a4;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11575a(Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[103] = true;
        instance.log(e);
        $jacocoInit[104] = true;
        ShowMessage.asSnack((Fragment) this, (int) C1375R.string.error_occured);
        $jacocoInit[105] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11574a(BaseV7Response resp) {
        boolean[] $jacocoInit = $jacocoInit();
        if (resp.isOk()) {
            $jacocoInit[91] = true;
            dismiss();
            CommentDialogCallbackContract commentDialogCallbackContract2 = this.commentDialogCallbackContract;
            if (commentDialogCallbackContract2 == null) {
                $jacocoInit[92] = true;
            } else {
                $jacocoInit[93] = true;
                commentDialogCallbackContract2.okSelected(resp, this.idAsLong, this.previousCommentId, this.idAsString);
                $jacocoInit[94] = true;
            }
        } else {
            ShowMessage.asSnack((Fragment) this, (int) C1375R.string.error_occured);
            $jacocoInit[95] = true;
        }
        $jacocoInit[96] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m7318b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[89] = true;
        instance.log(throwable);
        $jacocoInit[90] = true;
    }

    private void disableError() {
        boolean[] $jacocoInit = $jacocoInit();
        this.textInputLayout.setErrorEnabled(false);
        $jacocoInit[69] = true;
    }

    private String getText() {
        boolean[] $jacocoInit = $jacocoInit();
        TextInputLayout textInputLayout2 = this.textInputLayout;
        if (textInputLayout2 != null) {
            $jacocoInit[70] = true;
            EditText editText = textInputLayout2.getEditText();
            $jacocoInit[71] = true;
            Editable editableText = editText.getEditableText();
            $jacocoInit[72] = true;
            String obj = editableText.toString();
            $jacocoInit[73] = true;
            return obj;
        }
        $jacocoInit[74] = true;
        return null;
    }

    private void enableError(String error) {
        boolean[] $jacocoInit = $jacocoInit();
        this.textInputLayout.setError(error);
        $jacocoInit[75] = true;
    }

    private C0120S<? extends BaseV7Response> submitComment(String inputText, long idAsLong2, Long previousCommentId2) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = C26572.$SwitchMap$cm$aptoide$pt$dataprovider$util$CommentType[this.commentType.ordinal()];
        if (i == 1) {
            PostCommentForReview of = PostCommentForReview.m7480of(idAsLong2, inputText, this.baseBodyBodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences);
            $jacocoInit[76] = true;
            C0120S<? extends BaseV7Response> observe = of.observe(true, true);
            $jacocoInit[77] = true;
            return observe;
        } else if (i != 2) {
            Logger instance = Logger.getInstance();
            $jacocoInit[85] = true;
            instance.mo2140e(getTag(), "Unable to create reply due to missing comment type");
            $jacocoInit[86] = true;
            C0120S<? extends BaseV7Response> c = C0120S.m651c();
            $jacocoInit[87] = true;
            return c;
        } else {
            String str = "Home";
            if (previousCommentId2 == null) {
                $jacocoInit[78] = true;
                this.storeAnalytics.sendStoreInteractEvent("Write a Comment", str, this.appOrStoreName);
                $jacocoInit[79] = true;
                PostCommentForStore of2 = PostCommentForStore.m7594of(idAsLong2, inputText, this.baseBodyBodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences);
                $jacocoInit[80] = true;
                C0120S<? extends BaseV7Response> observe2 = of2.observe(true, true);
                $jacocoInit[81] = true;
                return observe2;
            }
            this.storeAnalytics.sendStoreInteractEvent("Reply to Comment", str, this.appOrStoreName);
            $jacocoInit[82] = true;
            PostCommentForStore of3 = PostCommentForStore.m7593of(idAsLong2, previousCommentId2.longValue(), inputText, this.baseBodyBodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences);
            $jacocoInit[83] = true;
            C0120S<? extends BaseV7Response> observe3 = of3.observe(true, true);
            $jacocoInit[84] = true;
            return observe3;
        }
    }

    public void setCommentDialogCallbackContract(CommentDialogCallbackContract commentDialogCallbackContract2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.commentDialogCallbackContract = commentDialogCallbackContract2;
        $jacocoInit[88] = true;
    }
}
