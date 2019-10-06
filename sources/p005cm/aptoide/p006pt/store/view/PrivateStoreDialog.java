package p005cm.aptoide.p006pt.store.view;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p001v7.app.C0774m;
import android.support.p001v7.app.C0774m.C0775a;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
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
import p005cm.aptoide.p006pt.store.StoreCredentialsProviderImpl;
import p005cm.aptoide.p006pt.store.StoreError;
import p005cm.aptoide.p006pt.store.StoreUtils;
import p005cm.aptoide.p006pt.store.StoreUtilsProxy;
import p005cm.aptoide.p006pt.utils.AptoideUtils.AlgorithmU;
import p005cm.aptoide.p006pt.utils.GenericDialogs;
import p005cm.aptoide.p006pt.view.fragment.BaseDialogFragment;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.store.view.PrivateStoreDialog */
public class PrivateStoreDialog extends BaseDialogFragment {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String TAG = "PrivateStoreDialog";
    private AptoideAccountManager accountManager;
    private BodyInterceptor<BaseBody> bodyInterceptor;
    private Factory converterFactory;
    private OkHttpClient httpClient;
    private boolean isInsideStore;
    private ProgressDialog loadingDialog;
    private String storeName;
    private String storePassSha1;
    private String storeUser;
    private StoreUtilsProxy storeUtilsProxy;
    private TokenInvalidator tokenInvalidator;

    /* renamed from: cm.aptoide.pt.store.view.PrivateStoreDialog$1 */
    static /* synthetic */ class C49631 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$store$StoreError = new int[StoreError.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(8454268016604741116L, "cm/aptoide/pt/store/view/PrivateStoreDialog$1", 4);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                $SwitchMap$cm$aptoide$pt$store$StoreError[StoreError.PRIVATE_STORE_WRONG_CREDENTIALS.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                $jacocoInit[2] = true;
            }
            $jacocoInit[3] = true;
        }
    }

    /* renamed from: cm.aptoide.pt.store.view.PrivateStoreDialog$BundleArgs */
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
        boolean[] probes = Offline.getProbes(-6392578603693036297L, "cm/aptoide/pt/store/view/PrivateStoreDialog", 76);
        $jacocoData = probes;
        return probes;
    }

    public PrivateStoreDialog() {
        $jacocoInit()[0] = true;
    }

    public static PrivateStoreDialog newInstance(Fragment returnFragment, int requestCode, String storeName2, boolean isInsideStore2) {
        boolean[] $jacocoInit = $jacocoInit();
        PrivateStoreDialog fragment = new PrivateStoreDialog();
        $jacocoInit[1] = true;
        Bundle args = new Bundle();
        $jacocoInit[2] = true;
        args.putString(BundleArgs.STORE_NAME.name(), storeName2);
        $jacocoInit[3] = true;
        fragment.setArguments(args);
        $jacocoInit[4] = true;
        fragment.setIsInsideStore(isInsideStore2);
        $jacocoInit[5] = true;
        fragment.setRetainInstance(true);
        $jacocoInit[6] = true;
        fragment.setTargetFragment(returnFragment, requestCode);
        $jacocoInit[7] = true;
        return fragment;
    }

    public void setIsInsideStore(boolean isInsideStore2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.isInsideStore = isInsideStore2;
        $jacocoInit[8] = true;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[9] = true;
        this.tokenInvalidator = ((AptoideApplication) getContext().getApplicationContext()).getTokenInvalidator();
        $jacocoInit[10] = true;
        this.accountManager = ((AptoideApplication) getContext().getApplicationContext()).getAccountManager();
        $jacocoInit[11] = true;
        this.httpClient = ((AptoideApplication) getContext().getApplicationContext()).getDefaultClient();
        $jacocoInit[12] = true;
        this.converterFactory = WebService.getDefaultConverter();
        $jacocoInit[13] = true;
        this.bodyInterceptor = ((AptoideApplication) getContext().getApplicationContext()).getAccountSettingsBodyInterceptorPoolV7();
        AptoideAccountManager aptoideAccountManager = this.accountManager;
        BodyInterceptor<BaseBody> bodyInterceptor2 = this.bodyInterceptor;
        $jacocoInit[14] = true;
        Context applicationContext = getContext().getApplicationContext();
        $jacocoInit[15] = true;
        $jacocoInit[16] = true;
        StoreCredentialsProviderImpl storeCredentialsProviderImpl = new StoreCredentialsProviderImpl((StoreAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) applicationContext.getApplicationContext()).getDatabase(), Store.class));
        $jacocoInit[17] = true;
        Context applicationContext2 = getContext().getApplicationContext();
        $jacocoInit[18] = true;
        $jacocoInit[19] = true;
        StoreAccessor storeAccessor = (StoreAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) applicationContext2.getApplicationContext()).getDatabase(), Store.class);
        OkHttpClient okHttpClient = this.httpClient;
        $jacocoInit[20] = true;
        Factory defaultConverter = WebService.getDefaultConverter();
        TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
        $jacocoInit[21] = true;
        StoreUtilsProxy storeUtilsProxy2 = new StoreUtilsProxy(aptoideAccountManager, bodyInterceptor2, storeCredentialsProviderImpl, storeAccessor, okHttpClient, defaultConverter, tokenInvalidator2, ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences());
        this.storeUtilsProxy = storeUtilsProxy2;
        $jacocoInit[22] = true;
        Bundle args = getArguments();
        if (args == null) {
            $jacocoInit[23] = true;
        } else {
            $jacocoInit[24] = true;
            this.storeName = args.getString(BundleArgs.STORE_NAME.name());
            $jacocoInit[25] = true;
        }
        $jacocoInit[26] = true;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        Dialog dialog = getDialog();
        $jacocoInit[27] = true;
        if (dialog == null) {
            $jacocoInit[28] = true;
        } else if (!getRetainInstance()) {
            $jacocoInit[29] = true;
        } else {
            dialog.setDismissMessage(null);
            $jacocoInit[30] = true;
        }
        super.onDestroyView();
        $jacocoInit[31] = true;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = getActivity();
        $jacocoInit[32] = true;
        LayoutInflater from = LayoutInflater.from(context);
        $jacocoInit[33] = true;
        View rootView = from.inflate(C1375R.layout.dialog_add_pvt_store, null, false);
        $jacocoInit[34] = true;
        C0775a aVar = new C0775a(context);
        aVar.mo6238c(C1375R.string.subscribe_pvt_store);
        $jacocoInit[35] = true;
        aVar.mo6235b(rootView);
        C5028la laVar = new C5028la(this, rootView);
        $jacocoInit[36] = true;
        aVar.mo6239c(17039370, (OnClickListener) laVar);
        $jacocoInit[37] = true;
        C0774m a = aVar.mo6231a();
        $jacocoInit[38] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16569a(View rootView, DialogInterface dialogInterface, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        Editable text = ((EditText) rootView.findViewById(C1375R.C1376id.edit_store_username)).getText();
        $jacocoInit[53] = true;
        this.storeUser = text.toString();
        $jacocoInit[54] = true;
        Editable text2 = ((EditText) rootView.findViewById(C1375R.C1376id.edit_store_password)).getText();
        $jacocoInit[55] = true;
        String obj = text2.toString();
        $jacocoInit[56] = true;
        this.storePassSha1 = AlgorithmU.computeSha1(obj);
        $jacocoInit[57] = true;
        this.storeUtilsProxy.subscribeStore(buildRequest(), new C5024ja(this), new C5026ka(this), this.storeName, this.accountManager, this.storeUser, this.storePassSha1);
        $jacocoInit[58] = true;
        showLoadingDialog();
        $jacocoInit[59] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16570a(GetStoreMeta getStoreMeta) {
        boolean[] $jacocoInit = $jacocoInit();
        getTargetFragment().onActivityResult(getTargetRequestCode(), -1, null);
        $jacocoInit[73] = true;
        dismissLoadingDialog();
        $jacocoInit[74] = true;
        dismiss();
        $jacocoInit[75] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16571a(Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        dismissLoadingDialog();
        if (e instanceof AptoideWsV7Exception) {
            $jacocoInit[60] = true;
            BaseV7Response baseResponse = ((AptoideWsV7Exception) e).getBaseResponse();
            $jacocoInit[61] = true;
            int[] iArr = C49631.$SwitchMap$cm$aptoide$pt$store$StoreError;
            Error error = baseResponse.getError();
            $jacocoInit[62] = true;
            String code = error.getCode();
            $jacocoInit[63] = true;
            if (iArr[StoreUtils.getErrorType(code).ordinal()] != 1) {
                getTargetFragment().onActivityResult(getTargetRequestCode(), 22, null);
                $jacocoInit[66] = true;
                dismiss();
                $jacocoInit[67] = true;
            } else {
                this.storeUser = null;
                this.storePassSha1 = null;
                $jacocoInit[64] = true;
                getTargetFragment().onActivityResult(getTargetRequestCode(), 21, null);
                $jacocoInit[65] = true;
            }
            $jacocoInit[68] = true;
        } else {
            e.printStackTrace();
            $jacocoInit[69] = true;
            getTargetFragment().onActivityResult(getTargetRequestCode(), 22, null);
            $jacocoInit[70] = true;
            dismiss();
            $jacocoInit[71] = true;
        }
        $jacocoInit[72] = true;
    }

    public void onDismiss(DialogInterface dialog) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.isInsideStore) {
            $jacocoInit[39] = true;
        } else {
            $jacocoInit[40] = true;
            getActivity().onBackPressed();
            $jacocoInit[41] = true;
        }
        super.onDismiss(dialog);
        $jacocoInit[42] = true;
    }

    public void onSaveInstanceState(Bundle outState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onSaveInstanceState(outState);
        $jacocoInit[43] = true;
        outState.putString(BundleArgs.STORE_NAME.name(), this.storeName);
        $jacocoInit[44] = true;
    }

    private GetStoreMetaRequest buildRequest() {
        boolean[] $jacocoInit = $jacocoInit();
        StoreCredentials storeCredentials = new StoreCredentials(this.storeName, this.storeUser, this.storePassSha1);
        BodyInterceptor<BaseBody> bodyInterceptor2 = this.bodyInterceptor;
        OkHttpClient okHttpClient = this.httpClient;
        Factory factory = this.converterFactory;
        TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
        $jacocoInit[45] = true;
        SharedPreferences defaultSharedPreferences = ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences();
        $jacocoInit[46] = true;
        GetStoreMetaRequest of = GetStoreMetaRequest.m264of(storeCredentials, bodyInterceptor2, okHttpClient, factory, tokenInvalidator2, defaultSharedPreferences);
        $jacocoInit[47] = true;
        return of;
    }

    private void dismissLoadingDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loadingDialog.dismiss();
        $jacocoInit[48] = true;
    }

    private void showLoadingDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.loadingDialog != null) {
            $jacocoInit[49] = true;
        } else {
            $jacocoInit[50] = true;
            this.loadingDialog = GenericDialogs.createGenericPleaseWaitDialog(getActivity());
            $jacocoInit[51] = true;
        }
        this.loadingDialog.show();
        $jacocoInit[52] = true;
    }
}
