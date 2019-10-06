package p005cm.aptoide.p006pt.store.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.p000v4.app.C0478k;
import android.support.p001v7.widget.SearchView;
import android.support.p001v7.widget.SearchView.C1011d;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.database.AccessorFactory;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.database.realm.Store;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.dataprovider.exception.AptoideWsV7Exception;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response.Error;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStoreMeta;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetStoreMetaRequest;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.navigator.ActivityResultNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.orientation.ScreenOrientationManager;
import p005cm.aptoide.p006pt.search.SuggestionCursorAdapter;
import p005cm.aptoide.p006pt.search.suggestions.SearchSuggestionManager;
import p005cm.aptoide.p006pt.store.StoreAnalytics;
import p005cm.aptoide.p006pt.store.StoreCredentialsProvider;
import p005cm.aptoide.p006pt.store.StoreCredentialsProviderImpl;
import p005cm.aptoide.p006pt.store.StoreError;
import p005cm.aptoide.p006pt.store.StoreUtils;
import p005cm.aptoide.p006pt.store.StoreUtilsProxy;
import p005cm.aptoide.p006pt.utils.AptoideUtils.StringU;
import p005cm.aptoide.p006pt.utils.GenericDialogs;
import p005cm.aptoide.p006pt.utils.design.ShowMessage;
import p005cm.aptoide.p006pt.view.fragment.BaseDialogFragment;
import p019d.p022i.p296a.p298b.p303c.p304a.C13025f;
import p019d.p022i.p296a.p298b.p303c.p304a.C13030k;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.Single;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p029i.C0136c;
import p026rx.p387a.p389b.C14522a;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.store.view.AddStoreDialog */
public class AddStoreDialog extends BaseDialogFragment {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int COMPLETION_THRESHOLD = 1;
    public static final int PRIVATE_STORE_ERROR_CODE = 22;
    public static final int PRIVATE_STORE_INVALID_CREDENTIALS_CODE = 21;
    private static final String TAG = AddStoreDialog.class.getName();
    private final int PRIVATE_STORE_REQUEST_CODE = 20;
    private AptoideAccountManager accountManager;
    private Button addStoreButton;
    private AnalyticsManager analyticsManager;
    private BodyInterceptor<BaseBody> baseBodyBodyInterceptor;
    private Factory converterFactory;
    private TextView errorMessage;
    private OkHttpClient httpClient;
    private Dialog loadingDialog;
    private NavigationTracker navigationTracker;
    private FragmentNavigator navigator;
    private ScreenOrientationManager orientationManager;
    private SearchSuggestionManager searchSuggestionManager;
    private SearchView searchView;
    private RelativeLayout searchViewLayout;
    private StoreAnalytics storeAnalytics;
    private StoreCredentialsProvider storeCredentialsProvider;
    private String storeName;
    private C0136c subscriptions;
    private TokenInvalidator tokenInvalidator;
    private Button topStoresButton;

    /* renamed from: cm.aptoide.pt.store.view.AddStoreDialog$2 */
    static /* synthetic */ class C49422 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$store$StoreError = new int[StoreError.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(7817293325094651183L, "cm/aptoide/pt/store/view/AddStoreDialog$2", 6);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                $SwitchMap$cm$aptoide$pt$store$StoreError[StoreError.PRIVATE_STORE_ERROR.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                try {
                    $jacocoInit[2] = true;
                } catch (NoSuchFieldError e2) {
                    $jacocoInit[4] = true;
                }
            }
            $SwitchMap$cm$aptoide$pt$store$StoreError[StoreError.STORE_DOESNT_EXIST.ordinal()] = 2;
            $jacocoInit[3] = true;
            $jacocoInit[5] = true;
        }
    }

    /* renamed from: cm.aptoide.pt.store.view.AddStoreDialog$BundleArgs */
    private enum BundleArgs {
        STORE_NAME;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8501427304662888495L, "cm/aptoide/pt/store/view/AddStoreDialog", 232);
        $jacocoData = probes;
        return probes;
    }

    public AddStoreDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
    }

    static /* synthetic */ SearchView access$000(AddStoreDialog x0) {
        boolean[] $jacocoInit = $jacocoInit();
        SearchView searchView2 = x0.searchView;
        $jacocoInit[230] = true;
        return searchView2;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[231] = true;
    }

    public void onAttach(Activity activity) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onAttach(activity);
        $jacocoInit[1] = true;
        if (ActivityResultNavigator.class.isAssignableFrom(activity.getClass())) {
            $jacocoInit[2] = true;
            this.navigator = ((ActivityResultNavigator) activity).getFragmentNavigator();
            this.orientationManager = new ScreenOrientationManager(activity, activity.getWindowManager());
            $jacocoInit[8] = true;
            return;
        }
        StringBuilder sb = new StringBuilder();
        $jacocoInit[3] = true;
        sb.append(AddStoreDialog.class.getSimpleName());
        sb.append(" must extend class ");
        $jacocoInit[4] = true;
        sb.append(ActivityResultNavigator.class.getSimpleName());
        IllegalStateException exception = new IllegalStateException(sb.toString());
        $jacocoInit[5] = true;
        Logger instance = Logger.getInstance();
        String str = TAG;
        $jacocoInit[6] = true;
        instance.mo2142e(str, (Throwable) exception);
        $jacocoInit[7] = true;
        throw exception;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[9] = true;
        this.subscriptions = new C0136c();
        $jacocoInit[10] = true;
        this.tokenInvalidator = ((AptoideApplication) getContext().getApplicationContext()).getTokenInvalidator();
        $jacocoInit[11] = true;
        this.converterFactory = WebService.getDefaultConverter();
        $jacocoInit[12] = true;
        this.accountManager = ((AptoideApplication) getContext().getApplicationContext()).getAccountManager();
        $jacocoInit[13] = true;
        this.httpClient = ((AptoideApplication) getContext().getApplicationContext()).getDefaultClient();
        $jacocoInit[14] = true;
        Context applicationContext = getContext().getApplicationContext();
        $jacocoInit[15] = true;
        $jacocoInit[16] = true;
        this.storeCredentialsProvider = new StoreCredentialsProviderImpl((StoreAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) applicationContext.getApplicationContext()).getDatabase(), Store.class));
        $jacocoInit[17] = true;
        this.baseBodyBodyInterceptor = ((AptoideApplication) getContext().getApplicationContext()).getAccountSettingsBodyInterceptorPoolV7();
        if (savedInstanceState == null) {
            $jacocoInit[18] = true;
        } else {
            $jacocoInit[19] = true;
            this.storeName = savedInstanceState.getString(BundleArgs.STORE_NAME.name());
            $jacocoInit[20] = true;
        }
        $jacocoInit[21] = true;
        AptoideApplication application = (AptoideApplication) getContext().getApplicationContext();
        $jacocoInit[22] = true;
        this.analyticsManager = application.getAnalyticsManager();
        $jacocoInit[23] = true;
        this.navigationTracker = application.getNavigationTracker();
        $jacocoInit[24] = true;
        this.storeAnalytics = new StoreAnalytics(this.analyticsManager, this.navigationTracker);
        $jacocoInit[25] = true;
        this.searchSuggestionManager = application.getSearchSuggestionManager();
        $jacocoInit[26] = true;
    }

    public void onResume() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onResume();
        $jacocoInit[27] = true;
        Dialog dialog = getDialog();
        $jacocoInit[28] = true;
        Rect rect = new Rect();
        $jacocoInit[29] = true;
        Window window = getActivity().getWindow();
        $jacocoInit[30] = true;
        View decorView = window.getDecorView();
        $jacocoInit[31] = true;
        decorView.getWindowVisibleDisplayFrame(rect);
        $jacocoInit[32] = true;
        double width = (double) rect.width();
        Double.isNaN(width);
        double width2 = width * 0.8d;
        if (dialog == null) {
            $jacocoInit[33] = true;
        } else {
            $jacocoInit[34] = true;
            if (getResources().getConfiguration().orientation == 2) {
                $jacocoInit[35] = true;
                Window window2 = dialog.getWindow();
                float f = (float) width2;
                $jacocoInit[36] = true;
                window2.setLayout(Math.round(f), -2);
                $jacocoInit[37] = true;
            } else {
                Window window3 = dialog.getWindow();
                $jacocoInit[38] = true;
                window3.setLayout(-1, -2);
                $jacocoInit[39] = true;
            }
        }
        $jacocoInit[40] = true;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        C0136c cVar = this.subscriptions;
        if (cVar == null) {
            $jacocoInit[41] = true;
        } else if (cVar.isUnsubscribed()) {
            $jacocoInit[42] = true;
        } else {
            $jacocoInit[43] = true;
            this.subscriptions.unsubscribe();
            $jacocoInit[44] = true;
        }
        super.onDestroyView();
        $jacocoInit[45] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        $jacocoInit[46] = true;
        bindViews(view);
        $jacocoInit[47] = true;
        setupSearch();
        $jacocoInit[48] = true;
        setupButtonHandlers();
        $jacocoInit[49] = true;
        dismissIfFocusIsLost();
        $jacocoInit[50] = true;
    }

    private void dismissIfFocusIsLost() {
        boolean[] $jacocoInit = $jacocoInit();
        C0136c cVar = this.subscriptions;
        C0120S b = C13034a.m42491b(this.searchView);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        $jacocoInit[51] = true;
        C0120S d = b.mo3648d(300, timeUnit);
        C5068q qVar = C5068q.f8757a;
        $jacocoInit[52] = true;
        C0120S d2 = d.mo3653d((C0132p<? super T, Boolean>) qVar);
        C5027l lVar = new C5027l(this);
        $jacocoInit[53] = true;
        C0137ja c = d2.mo3646c((C0129b<? super T>) lVar);
        $jacocoInit[54] = true;
        cVar.mo3713a(c);
        $jacocoInit[55] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m9272a(Boolean event) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!event.booleanValue()) {
            $jacocoInit[227] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[228] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[229] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16470b(Boolean event) {
        boolean[] $jacocoInit = $jacocoInit();
        Dialog dialog = getDialog();
        $jacocoInit[220] = true;
        if (dialog == null) {
            $jacocoInit[221] = true;
        } else if (!dialog.isShowing()) {
            $jacocoInit[222] = true;
        } else if (!isResumed()) {
            $jacocoInit[223] = true;
        } else {
            $jacocoInit[224] = true;
            dialog.dismiss();
            $jacocoInit[225] = true;
        }
        $jacocoInit[226] = true;
    }

    private void setupButtonHandlers() {
        boolean[] $jacocoInit = $jacocoInit();
        C0136c cVar = this.subscriptions;
        C0120S a = C13034a.m42490a(this.addStoreButton);
        C5062n nVar = new C5062n(this);
        $jacocoInit[56] = true;
        C0137ja c = a.mo3646c((C0129b<? super T>) nVar);
        $jacocoInit[57] = true;
        cVar.mo3713a(c);
        $jacocoInit[58] = true;
        C0136c cVar2 = this.subscriptions;
        C0120S a2 = C13034a.m42490a(this.topStoresButton);
        C4986d dVar = new C4986d(this);
        $jacocoInit[59] = true;
        C0137ja c2 = a2.mo3646c((C0129b<? super T>) dVar);
        $jacocoInit[60] = true;
        cVar2.mo3713a(c2);
        $jacocoInit[61] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16469a(Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        setDefaultState();
        $jacocoInit[217] = true;
        addStoreAction();
        $jacocoInit[218] = true;
        this.storeAnalytics.sendStoreTabInteractEvent("Add Store", true);
        $jacocoInit[219] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16472b(Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        topStoresAction();
        $jacocoInit[216] = true;
    }

    public void onSaveInstanceState(Bundle outState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onSaveInstanceState(outState);
        $jacocoInit[62] = true;
        outState.putString(BundleArgs.STORE_NAME.name(), this.storeName);
        $jacocoInit[63] = true;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 20) {
            $jacocoInit[64] = true;
        } else if (resultCode == -1) {
            dismiss();
            $jacocoInit[65] = true;
        } else if (resultCode != 21) {
            Snackbar a = Snackbar.m1623a((View) this.searchView, (int) C1375R.string.error_occured, -1);
            $jacocoInit[68] = true;
            a.mo4690h();
            $jacocoInit[69] = true;
        } else {
            Snackbar a2 = Snackbar.m1623a((View) this.searchView, (int) C1375R.string.ws_error_invalid_grant, -1);
            $jacocoInit[66] = true;
            a2.mo4690h();
            $jacocoInit[67] = true;
        }
        $jacocoInit[70] = true;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        Dialog dialog = getDialog();
        if (dialog == null) {
            $jacocoInit[71] = true;
        } else {
            $jacocoInit[72] = true;
            Window window = dialog.getWindow();
            $jacocoInit[73] = true;
            window.setLayout(-1, -1);
            $jacocoInit[74] = true;
            Window window2 = dialog.getWindow();
            $jacocoInit[75] = true;
            window2.requestFeature(1);
            $jacocoInit[76] = true;
            dialog.setCancelable(true);
            $jacocoInit[77] = true;
        }
        View inflate = inflater.inflate(C1375R.layout.dialog_add_store, container, false);
        $jacocoInit[78] = true;
        return inflate;
    }

    private void addStoreAction(String storeName2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeName = storeName2;
        $jacocoInit[79] = true;
        getStore(storeName2);
        $jacocoInit[80] = true;
        showLoadingDialog();
        $jacocoInit[81] = true;
    }

    @Deprecated
    private void addStoreAction() {
        boolean[] $jacocoInit = $jacocoInit();
        CharSequence query = this.searchView.getQuery();
        $jacocoInit[82] = true;
        String givenStoreName = query.toString();
        $jacocoInit[83] = true;
        if (givenStoreName.length() > 0) {
            this.storeName = givenStoreName;
            $jacocoInit[84] = true;
            getStore(givenStoreName);
            $jacocoInit[85] = true;
            showLoadingDialog();
            $jacocoInit[86] = true;
        } else {
            RelativeLayout relativeLayout = this.searchViewLayout;
            $jacocoInit[87] = true;
            Drawable drawable = getResources().getDrawable(C1375R.drawable.add_stores_dialog_seach_box_error);
            $jacocoInit[88] = true;
            relativeLayout.setBackground(drawable);
            $jacocoInit[89] = true;
            this.errorMessage.setVisibility(0);
            $jacocoInit[90] = true;
            this.errorMessage.setText(C1375R.string.add_store_dialog_no_query);
            $jacocoInit[91] = true;
        }
        $jacocoInit[92] = true;
    }

    private void bindViews(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        this.addStoreButton = (Button) view.findViewById(C1375R.C1376id.button_dialog_add_store);
        $jacocoInit[93] = true;
        this.topStoresButton = (Button) view.findViewById(C1375R.C1376id.button_top_stores);
        $jacocoInit[94] = true;
        this.searchView = (SearchView) view.findViewById(C1375R.C1376id.store_search_view);
        $jacocoInit[95] = true;
        this.searchViewLayout = (RelativeLayout) view.findViewById(C1375R.C1376id.search_box_layout);
        $jacocoInit[96] = true;
        this.errorMessage = (TextView) view.findViewById(C1375R.C1376id.error_message);
        SearchView searchView2 = this.searchView;
        $jacocoInit[97] = true;
        EditText searchEditText = (EditText) searchView2.findViewById(C1375R.C1376id.search_src_text);
        $jacocoInit[98] = true;
        searchEditText.setTextSize(2, 12.0f);
        $jacocoInit[99] = true;
        searchEditText.setHintTextColor(getResources().getColor(C1375R.color.grey));
        $jacocoInit[100] = true;
    }

    private void setupSearch() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[101] = true;
        final SuggestionCursorAdapter suggestionCursorAdapter = new SuggestionCursorAdapter(getContext());
        $jacocoInit[102] = true;
        this.searchView.setOnSuggestionListener(new C1011d(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ AddStoreDialog this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(7012703577946667818L, "cm/aptoide/pt/store/view/AddStoreDialog$1", 3);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public boolean onSuggestionSelect(int position) {
                $jacocoInit()[1] = true;
                return false;
            }

            public boolean onSuggestionClick(int position) {
                boolean[] $jacocoInit = $jacocoInit();
                AddStoreDialog.access$000(this.this$0).setQuery(suggestionCursorAdapter.getSuggestionAt(position), false);
                $jacocoInit[2] = true;
                return true;
            }
        });
        $jacocoInit[103] = true;
        this.searchView.setSuggestionsAdapter(suggestionCursorAdapter);
        SearchView searchView2 = this.searchView;
        $jacocoInit[104] = true;
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) searchView2.findViewById(C1375R.C1376id.search_src_text);
        $jacocoInit[105] = true;
        autoCompleteTextView.setThreshold(1);
        $jacocoInit[106] = true;
        handleEmptyQuery(suggestionCursorAdapter);
        $jacocoInit[107] = true;
        handleSubmittedQuery();
        $jacocoInit[108] = true;
        handleStoreRemoteQuery(suggestionCursorAdapter);
        $jacocoInit[109] = true;
    }

    private void handleStoreRemoteQuery(SuggestionCursorAdapter suggestionCursorAdapter) {
        boolean[] $jacocoInit = $jacocoInit();
        C0136c cVar = this.subscriptions;
        C0120S a = C13025f.m42483a(this.searchView);
        C4982b bVar = C4982b.f8645a;
        $jacocoInit[110] = true;
        C0120S d = a.mo3653d((C0132p<? super T, Boolean>) bVar);
        C5023j jVar = C5023j.f8704a;
        $jacocoInit[111] = true;
        C0120S j = d.mo3669j(jVar);
        C4988e eVar = C4988e.f8655a;
        $jacocoInit[112] = true;
        C0120S d2 = j.mo3653d((C0132p<? super T, Boolean>) eVar);
        C5064o oVar = new C5064o(this, suggestionCursorAdapter);
        $jacocoInit[113] = true;
        C0120S i = d2.mo3668i(oVar);
        $jacocoInit[114] = true;
        C0120S g = i.mo3662g();
        $jacocoInit[115] = true;
        C0137ja j2 = g.mo3670j();
        $jacocoInit[116] = true;
        cVar.mo3713a(j2);
        $jacocoInit[117] = true;
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m9277b(C13030k event) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!event.mo41920b()) {
            $jacocoInit[213] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[214] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[215] = true;
        return valueOf;
    }

    /* renamed from: c */
    static /* synthetic */ String m9278c(C13030k event) {
        boolean[] $jacocoInit = $jacocoInit();
        CharSequence c = event.mo41921c();
        $jacocoInit[211] = true;
        String charSequence = c.toString();
        $jacocoInit[212] = true;
        return charSequence;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m9273a(String query) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (query == null) {
            $jacocoInit[206] = true;
        } else if (query.length() < 1) {
            $jacocoInit[207] = true;
        } else {
            $jacocoInit[208] = true;
            z = true;
            Boolean valueOf = Boolean.valueOf(z);
            $jacocoInit[210] = true;
            return valueOf;
        }
        z = false;
        $jacocoInit[209] = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[210] = true;
        return valueOf2;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo16466a(SuggestionCursorAdapter suggestionCursorAdapter, String query) {
        boolean[] $jacocoInit = $jacocoInit();
        Single suggestionsForStore = this.searchSuggestionManager.getSuggestionsForStore(query);
        C4998h hVar = new C4998h(suggestionCursorAdapter);
        $jacocoInit[194] = true;
        Single e = suggestionsForStore.mo3699e(hVar);
        $jacocoInit[195] = true;
        Single a = e.mo3686a(C14522a.m46170a());
        C5021i iVar = new C5021i(suggestionCursorAdapter);
        $jacocoInit[196] = true;
        Single b = a.mo3695b((C0129b<? super T>) iVar);
        $jacocoInit[197] = true;
        return b;
    }

    /* renamed from: a */
    static /* synthetic */ Single m9274a(SuggestionCursorAdapter suggestionCursorAdapter, Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        if (err instanceof TimeoutException) {
            $jacocoInit[199] = true;
            Logger instance = Logger.getInstance();
            String str = TAG;
            $jacocoInit[200] = true;
            instance.mo2145i(str, "Timeout reached while waiting for store suggestions");
            $jacocoInit[201] = true;
            Single a = Single.m734a(suggestionCursorAdapter.getSuggestions());
            $jacocoInit[202] = true;
            return a;
        }
        Logger instance2 = Logger.getInstance();
        String str2 = TAG;
        $jacocoInit[203] = true;
        instance2.mo2149w(str2, "handleStoreRemoteQuery: ", err);
        $jacocoInit[204] = true;
        Single a2 = Single.m735a(err);
        $jacocoInit[205] = true;
        return a2;
    }

    /* renamed from: a */
    static /* synthetic */ void m9276a(SuggestionCursorAdapter suggestionCursorAdapter, List data) {
        boolean[] $jacocoInit = $jacocoInit();
        suggestionCursorAdapter.setData(data);
        $jacocoInit[198] = true;
    }

    private void handleSubmittedQuery() {
        boolean[] $jacocoInit = $jacocoInit();
        C0136c cVar = this.subscriptions;
        C0120S a = C13025f.m42483a(this.searchView);
        $jacocoInit[118] = true;
        C0120S a2 = a.mo3616a(C14522a.m46170a());
        C4984c cVar2 = C4984c.f8649a;
        $jacocoInit[119] = true;
        C0120S d = a2.mo3653d((C0132p<? super T, Boolean>) cVar2);
        C5029m mVar = C5029m.f8711a;
        $jacocoInit[120] = true;
        C0120S j = d.mo3669j(mVar);
        C5025k kVar = new C5025k(this);
        $jacocoInit[121] = true;
        C0120S b = j.mo3636b((C0129b<? super T>) kVar);
        $jacocoInit[122] = true;
        C0137ja j2 = b.mo3670j();
        $jacocoInit[123] = true;
        cVar.mo3713a(j2);
        $jacocoInit[124] = true;
    }

    /* renamed from: d */
    static /* synthetic */ Boolean m9279d(C13030k event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.mo41920b());
        $jacocoInit[193] = true;
        return valueOf;
    }

    /* renamed from: e */
    static /* synthetic */ String m9280e(C13030k event) {
        boolean[] $jacocoInit = $jacocoInit();
        CharSequence c = event.mo41921c();
        $jacocoInit[191] = true;
        String charSequence = c.toString();
        $jacocoInit[192] = true;
        return charSequence;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16471b(String query) {
        boolean[] $jacocoInit = $jacocoInit();
        addStoreAction(query);
        $jacocoInit[190] = true;
    }

    private void handleEmptyQuery(SuggestionCursorAdapter suggestionCursorAdapter) {
        boolean[] $jacocoInit = $jacocoInit();
        C0136c cVar = this.subscriptions;
        C0120S a = C13025f.m42483a(this.searchView);
        $jacocoInit[125] = true;
        C0120S a2 = a.mo3616a(C14522a.m46170a());
        C5066p pVar = C5066p.f8755a;
        $jacocoInit[126] = true;
        C0120S d = a2.mo3653d((C0132p<? super T, Boolean>) pVar);
        C4996g gVar = new C4996g(suggestionCursorAdapter);
        $jacocoInit[127] = true;
        C0120S b = d.mo3636b((C0129b<? super T>) gVar);
        $jacocoInit[128] = true;
        C0137ja j = b.mo3670j();
        $jacocoInit[129] = true;
        cVar.mo3713a(j);
        $jacocoInit[130] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m9271a(C13030k event) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        CharSequence c = event.mo41921c();
        $jacocoInit[186] = true;
        if (c.length() == 0) {
            $jacocoInit[187] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[188] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[189] = true;
        return valueOf;
    }

    /* renamed from: a */
    static /* synthetic */ void m9275a(SuggestionCursorAdapter suggestionCursorAdapter, C13030k __) {
        boolean[] $jacocoInit = $jacocoInit();
        suggestionCursorAdapter.setData(Collections.emptyList());
        $jacocoInit[185] = true;
    }

    private void getStore(String storeName2) {
        boolean[] $jacocoInit = $jacocoInit();
        executeRequest(buildRequest(storeName2));
        $jacocoInit[131] = true;
    }

    private void showLoadingDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.loadingDialog != null) {
            $jacocoInit[132] = true;
        } else {
            $jacocoInit[133] = true;
            this.loadingDialog = GenericDialogs.createGenericPleaseWaitDialog(getActivity());
            $jacocoInit[134] = true;
        }
        this.orientationManager.lock();
        $jacocoInit[135] = true;
        this.loadingDialog.show();
        $jacocoInit[136] = true;
    }

    private void topStoresAction() {
        boolean[] $jacocoInit = $jacocoInit();
        this.navigator.navigateTo(FragmentTopStores.newInstance(), true);
        $jacocoInit[137] = true;
        if (!isAdded()) {
            $jacocoInit[138] = true;
        } else {
            $jacocoInit[139] = true;
            dismiss();
            $jacocoInit[140] = true;
        }
        $jacocoInit[141] = true;
    }

    private GetStoreMetaRequest buildRequest(String storeName2) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreCredentialsProvider storeCredentialsProvider2 = this.storeCredentialsProvider;
        $jacocoInit[142] = true;
        StoreCredentials storeCredentials = StoreUtils.getStoreCredentials(storeName2, storeCredentialsProvider2);
        BodyInterceptor<BaseBody> bodyInterceptor = this.baseBodyBodyInterceptor;
        OkHttpClient okHttpClient = this.httpClient;
        Factory factory = this.converterFactory;
        TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
        $jacocoInit[143] = true;
        SharedPreferences defaultSharedPreferences = ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences();
        $jacocoInit[144] = true;
        GetStoreMetaRequest of = GetStoreMetaRequest.m264of(storeCredentials, bodyInterceptor, okHttpClient, factory, tokenInvalidator2, defaultSharedPreferences);
        $jacocoInit[145] = true;
        return of;
    }

    private void executeRequest(GetStoreMetaRequest getHomeMetaRequest) {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideAccountManager aptoideAccountManager = this.accountManager;
        BodyInterceptor<BaseBody> bodyInterceptor = this.baseBodyBodyInterceptor;
        StoreCredentialsProvider storeCredentialsProvider2 = this.storeCredentialsProvider;
        $jacocoInit[146] = true;
        Context applicationContext = getContext().getApplicationContext();
        $jacocoInit[147] = true;
        $jacocoInit[148] = true;
        StoreAccessor storeAccessor = (StoreAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) applicationContext.getApplicationContext()).getDatabase(), Store.class);
        OkHttpClient okHttpClient = this.httpClient;
        $jacocoInit[149] = true;
        Factory defaultConverter = WebService.getDefaultConverter();
        TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
        $jacocoInit[150] = true;
        StoreUtilsProxy storeUtilsProxy = new StoreUtilsProxy(aptoideAccountManager, bodyInterceptor, storeCredentialsProvider2, storeAccessor, okHttpClient, defaultConverter, tokenInvalidator2, ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences());
        storeUtilsProxy.subscribeStore(getHomeMetaRequest, new C4990f(this), new C5070r(this), this.storeName, this.accountManager);
        $jacocoInit[151] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16467a(GetStoreMeta getStoreMeta1) {
        boolean[] $jacocoInit = $jacocoInit();
        View view = getView();
        $jacocoInit[179] = true;
        Resources resources = getContext().getResources();
        Object[] objArr = {this.storeName};
        $jacocoInit[180] = true;
        String formattedString = StringU.getFormattedString(C1375R.string.store_followed, resources, objArr);
        $jacocoInit[181] = true;
        ShowMessage.asSnack(view, formattedString);
        $jacocoInit[182] = true;
        dismissLoadingDialog();
        $jacocoInit[183] = true;
        dismiss();
        $jacocoInit[184] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16468a(Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        dismissLoadingDialog();
        if (e instanceof AptoideWsV7Exception) {
            $jacocoInit[157] = true;
            BaseV7Response baseResponse = ((AptoideWsV7Exception) e).getBaseResponse();
            $jacocoInit[158] = true;
            Error error = baseResponse.getError();
            $jacocoInit[159] = true;
            int i = C49422.$SwitchMap$cm$aptoide$pt$store$StoreError[StoreUtils.getErrorType(error.getCode()).ordinal()];
            if (i == 1) {
                C0478k dialogFragment = PrivateStoreDialog.newInstance(this, 20, this.storeName, false);
                $jacocoInit[160] = true;
                dialogFragment.show(getFragmentManager(), PrivateStoreDialog.class.getName());
                $jacocoInit[161] = true;
            } else if (i != 2) {
                RelativeLayout relativeLayout = this.searchViewLayout;
                $jacocoInit[167] = true;
                Drawable drawable = getResources().getDrawable(C1375R.drawable.add_stores_dialog_seach_box_error);
                $jacocoInit[168] = true;
                relativeLayout.setBackground(drawable);
                $jacocoInit[169] = true;
                this.errorMessage.setVisibility(0);
                $jacocoInit[170] = true;
                this.errorMessage.setText(error.getDescription());
                $jacocoInit[171] = true;
            } else {
                RelativeLayout relativeLayout2 = this.searchViewLayout;
                $jacocoInit[162] = true;
                Drawable drawable2 = getResources().getDrawable(C1375R.drawable.add_stores_dialog_seach_box_error);
                $jacocoInit[163] = true;
                relativeLayout2.setBackground(drawable2);
                $jacocoInit[164] = true;
                this.errorMessage.setVisibility(0);
                $jacocoInit[165] = true;
                this.errorMessage.setText(error.getDescription());
                $jacocoInit[166] = true;
            }
            $jacocoInit[172] = true;
        } else {
            RelativeLayout relativeLayout3 = this.searchViewLayout;
            $jacocoInit[173] = true;
            Drawable drawable3 = getResources().getDrawable(C1375R.drawable.add_stores_dialog_seach_box_error);
            $jacocoInit[174] = true;
            relativeLayout3.setBackground(drawable3);
            $jacocoInit[175] = true;
            this.errorMessage.setVisibility(0);
            $jacocoInit[176] = true;
            this.errorMessage.setText(C1375R.string.error_occured);
            $jacocoInit[177] = true;
        }
        $jacocoInit[178] = true;
    }

    /* access modifiers changed from: 0000 */
    public void dismissLoadingDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        this.orientationManager.unlock();
        $jacocoInit[152] = true;
        this.loadingDialog.dismiss();
        $jacocoInit[153] = true;
    }

    private void setDefaultState() {
        boolean[] $jacocoInit = $jacocoInit();
        this.errorMessage.setVisibility(4);
        RelativeLayout relativeLayout = this.searchViewLayout;
        $jacocoInit[154] = true;
        Drawable drawable = getResources().getDrawable(C1375R.drawable.add_stores_dialog_search_box_border);
        $jacocoInit[155] = true;
        relativeLayout.setBackground(drawable);
        $jacocoInit[156] = true;
    }
}
