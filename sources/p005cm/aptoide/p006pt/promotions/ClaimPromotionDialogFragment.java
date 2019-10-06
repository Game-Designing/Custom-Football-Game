package p005cm.aptoide.p006pt.promotions;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.graphics.Point;
import android.os.Bundle;
import android.text.Editable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.navigator.ActivityResultNavigator;
import p005cm.aptoide.p006pt.navigator.Result;
import p005cm.aptoide.p006pt.networking.IdsRepository;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.utils.AptoideUtils.SystemU;
import p005cm.aptoide.p006pt.view.fragment.BaseDialogView;
import p019d.p022i.p296a.p305c.C13034a;
import p019d.p022i.p296a.p306d.C13050e;
import p019d.p022i.p296a.p306d.C13051f;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.promotions.ClaimPromotionDialogFragment */
public class ClaimPromotionDialogFragment extends BaseDialogView implements ClaimPromotionDialogView {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String CAPTCHA = "captcha";
    private static final String CAPTCHA_ERROR = "captcha_error";
    private static final String CLAIMED = "claimed";
    private static final String GENERIC_ERROR = "error";
    private static final String PACKAGE_NAME = "package_name";
    private static final String SUCCESS = "success";
    private static final String VIEW = "view";
    private static final String WALLET = "wallet";
    private static final String WALLET_INTENT_EXTRA_KEY = "PERMISSION_NAME_KEY";
    private static final String WALLET_INTENT_EXTRA_VALUE = "WALLET_ADDRESS";
    private static final int WALLET_INTENT_REQUEST_CODE = 123;
    private static final String WALLET_INTENT_URI_ACTION = "appcoins://wallet/permissions/1";
    private static final String WALLET_PACKAGE = "com.appcoins.wallet";
    private ImageView captcha;
    private Button captchaCancelButton;
    private EditText captchaEdit;
    private View captchaErrorView;
    private ProgressBar captchaLoading;
    private Button captchaNextButton;
    private View captchaView;
    @Inject
    ClaimPromotionsManager claimPromotionsManager;
    private ClipboardManager clipboard;
    private Button genericErrorOkButton;
    private View genericErrorView;
    private TextView genericMessageBody;
    private TextView genericMessageButton;
    private TextView genericMessageTitle;
    private View genericMessageView;
    private Button getWalletAddressButton;
    @Inject
    IdsRepository idsRepository;
    private View insertWalletView;
    private ProgressBar loading;
    @Inject
    ClaimPromotionsNavigator navigator;
    @Inject
    ClaimPromotionDialogPresenter presenter;
    @Inject
    PromotionsAnalytics promotionsAnalytics;
    private ImageView refreshCaptchaButton;
    private EditText walletAddressEdit;
    private Button walletCancelButton;
    private View walletErrorView;
    private ImageView walletMessageIcon;
    private Button walletNextButton;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6620761855347299874L, "cm/aptoide/pt/promotions/ClaimPromotionDialogFragment", 225);
        $jacocoData = probes;
        return probes;
    }

    public ClaimPromotionDialogFragment() {
        $jacocoInit()[0] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        $jacocoInit[1] = true;
        this.loading = (ProgressBar) view.findViewById(C1375R.C1376id.loading);
        $jacocoInit[2] = true;
        this.walletAddressEdit = (EditText) view.findViewById(C1375R.C1376id.wallet_edit);
        $jacocoInit[3] = true;
        this.getWalletAddressButton = (Button) view.findViewById(C1375R.C1376id.get_wallet_button);
        $jacocoInit[4] = true;
        this.walletNextButton = (Button) view.findViewById(C1375R.C1376id.wallet_continue_button);
        $jacocoInit[5] = true;
        this.walletCancelButton = (Button) view.findViewById(C1375R.C1376id.wallet_cancel_button);
        $jacocoInit[6] = true;
        this.walletMessageIcon = (ImageView) view.findViewById(C1375R.C1376id.wallet_message_icon);
        $jacocoInit[7] = true;
        this.walletErrorView = view.findViewById(C1375R.C1376id.wallet_error_view);
        $jacocoInit[8] = true;
        this.captcha = (ImageView) view.findViewById(C1375R.C1376id.captcha_container);
        $jacocoInit[9] = true;
        this.captchaEdit = (EditText) view.findViewById(C1375R.C1376id.captcha_edit);
        $jacocoInit[10] = true;
        this.refreshCaptchaButton = (ImageView) view.findViewById(C1375R.C1376id.captcha_refresh);
        $jacocoInit[11] = true;
        this.captchaLoading = (ProgressBar) view.findViewById(C1375R.C1376id.captcha_progress);
        $jacocoInit[12] = true;
        this.captchaNextButton = (Button) view.findViewById(C1375R.C1376id.captcha_continue_button);
        $jacocoInit[13] = true;
        this.captchaCancelButton = (Button) view.findViewById(C1375R.C1376id.captcha_cancel_button);
        $jacocoInit[14] = true;
        this.captchaErrorView = view.findViewById(C1375R.C1376id.captcha_error_view);
        $jacocoInit[15] = true;
        this.genericMessageTitle = (TextView) view.findViewById(C1375R.C1376id.generic_message_title);
        $jacocoInit[16] = true;
        this.genericMessageBody = (TextView) view.findViewById(C1375R.C1376id.generic_message_body);
        $jacocoInit[17] = true;
        this.genericMessageButton = (TextView) view.findViewById(C1375R.C1376id.generic_message_button);
        $jacocoInit[18] = true;
        this.genericErrorOkButton = (Button) view.findViewById(C1375R.C1376id.error_ok_button);
        $jacocoInit[19] = true;
        this.insertWalletView = view.findViewById(C1375R.C1376id.insert_address_view);
        $jacocoInit[20] = true;
        this.captchaView = view.findViewById(C1375R.C1376id.captcha_view);
        $jacocoInit[21] = true;
        this.genericMessageView = view.findViewById(C1375R.C1376id.generic_message_view);
        $jacocoInit[22] = true;
        this.genericErrorView = view.findViewById(C1375R.C1376id.generic_error);
        $jacocoInit[23] = true;
        attachPresenter(this.presenter);
        $jacocoInit[24] = true;
        handleRestoreViewState(savedInstanceState);
        $jacocoInit[25] = true;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[26] = true;
        getFragmentComponent(savedInstanceState).inject(this);
        $jacocoInit[27] = true;
        this.clipboard = (ClipboardManager) getContext().getSystemService("clipboard");
        $jacocoInit[28] = true;
    }

    public void onResume() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onResume();
        $jacocoInit[29] = true;
        Window window = getDialog().getWindow();
        $jacocoInit[30] = true;
        Point size = new Point();
        $jacocoInit[31] = true;
        WindowManager windowManager = window.getWindowManager();
        $jacocoInit[32] = true;
        Display display = windowManager.getDefaultDisplay();
        $jacocoInit[33] = true;
        display.getSize(size);
        int width = size.x;
        $jacocoInit[34] = true;
        double d = (double) width;
        Double.isNaN(d);
        window.setLayout((int) (d * 0.9d), -2);
        $jacocoInit[35] = true;
        window.setGravity(17);
        $jacocoInit[36] = true;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onDestroyView();
        this.walletAddressEdit = null;
        this.getWalletAddressButton = null;
        this.walletNextButton = null;
        this.walletCancelButton = null;
        this.walletMessageIcon = null;
        this.walletErrorView = null;
        this.captcha = null;
        this.captchaEdit = null;
        this.captchaNextButton = null;
        this.captchaCancelButton = null;
        this.captchaErrorView = null;
        this.genericMessageTitle = null;
        this.genericMessageBody = null;
        this.genericMessageButton = null;
        this.genericErrorOkButton = null;
        this.insertWalletView = null;
        this.captchaView = null;
        this.genericMessageView = null;
        this.genericErrorView = null;
        $jacocoInit[37] = true;
        this.presenter.dispose();
        this.presenter = null;
        $jacocoInit[38] = true;
    }

    public void onDestroy() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onDestroy();
        $jacocoInit[39] = true;
    }

    public void onSaveInstanceState(Bundle outState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onSaveInstanceState(outState);
        $jacocoInit[40] = true;
        int visibility = this.insertWalletView.getVisibility();
        String str = VIEW;
        if (visibility == 0) {
            $jacocoInit[41] = true;
            outState.putString(str, WALLET);
            $jacocoInit[42] = true;
        } else {
            if (this.captchaView.getVisibility() != 0) {
                $jacocoInit[43] = true;
            } else {
                View view = this.walletErrorView;
                $jacocoInit[44] = true;
                if (view.getVisibility() == 0) {
                    $jacocoInit[45] = true;
                } else {
                    $jacocoInit[46] = true;
                    outState.putString(str, CAPTCHA);
                    $jacocoInit[47] = true;
                }
            }
            if (this.captchaView.getVisibility() != 0) {
                $jacocoInit[48] = true;
            } else {
                View view2 = this.walletErrorView;
                $jacocoInit[49] = true;
                if (view2.getVisibility() != 0) {
                    $jacocoInit[50] = true;
                } else {
                    $jacocoInit[51] = true;
                    outState.putString(str, CAPTCHA_ERROR);
                    $jacocoInit[52] = true;
                }
            }
            if (this.genericMessageView.getVisibility() != 0) {
                $jacocoInit[53] = true;
            } else {
                CharSequence text = this.genericMessageTitle.getText();
                $jacocoInit[54] = true;
                if (!text.equals(getResources().getString(C1375R.string.holidayspromotion_title_completed))) {
                    $jacocoInit[55] = true;
                } else {
                    $jacocoInit[56] = true;
                    outState.putString(str, "success");
                    $jacocoInit[57] = true;
                }
            }
            if (this.genericMessageView.getVisibility() != 0) {
                $jacocoInit[58] = true;
            } else {
                CharSequence text2 = this.genericMessageTitle.getText();
                $jacocoInit[59] = true;
                if (!text2.equals(getResources().getString(C1375R.string.holidayspromotion_title_error_claimed))) {
                    $jacocoInit[60] = true;
                } else {
                    $jacocoInit[61] = true;
                    outState.putString(str, CLAIMED);
                    $jacocoInit[62] = true;
                }
            }
            if (this.genericErrorView.getVisibility() != 0) {
                $jacocoInit[63] = true;
            } else {
                $jacocoInit[64] = true;
                outState.putString(str, GENERIC_ERROR);
                $jacocoInit[65] = true;
            }
        }
        $jacocoInit[66] = true;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreateView(inflater, container, savedInstanceState);
        $jacocoInit[67] = true;
        Window window = getDialog().getWindow();
        $jacocoInit[68] = true;
        window.requestFeature(1);
        $jacocoInit[69] = true;
        View inflate = inflater.inflate(C1375R.layout.promotions_claim_dialog, container, false);
        $jacocoInit[70] = true;
        return inflate;
    }

    public C0120S<String> getWalletClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.getWalletAddressButton);
        C4535h hVar = new C4535h(this);
        $jacocoInit[71] = true;
        C0120S<String> j = a.mo3669j(hVar);
        $jacocoInit[72] = true;
        return j;
    }

    /* renamed from: e */
    public /* synthetic */ String mo15505e(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        String string = getArguments().getString("package_name");
        $jacocoInit[224] = true;
        return string;
    }

    public C0120S<ClaimPromotionsClickWrapper> continueWalletClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.walletNextButton);
        C4527f fVar = new C4527f(this);
        $jacocoInit[73] = true;
        C0120S<ClaimPromotionsClickWrapper> j = a.mo3669j(fVar);
        $jacocoInit[74] = true;
        return j;
    }

    /* renamed from: b */
    public /* synthetic */ ClaimPromotionsClickWrapper mo15497b(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Editable text = this.walletAddressEdit.getText();
        $jacocoInit[222] = true;
        ClaimPromotionsClickWrapper claimPromotionsClickWrapper = new ClaimPromotionsClickWrapper(text.toString(), getArguments().getString("package_name"));
        $jacocoInit[223] = true;
        return claimPromotionsClickWrapper;
    }

    public C0120S<ClaimPromotionsSubmitWrapper> finishClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.captchaNextButton);
        C4523e eVar = new C4523e(this);
        $jacocoInit[75] = true;
        C0120S<ClaimPromotionsSubmitWrapper> j = a.mo3669j(eVar);
        $jacocoInit[76] = true;
        return j;
    }

    /* renamed from: d */
    public /* synthetic */ ClaimPromotionsSubmitWrapper mo15501d(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Editable text = this.captchaEdit.getText();
        $jacocoInit[220] = true;
        ClaimPromotionsSubmitWrapper claimPromotionsSubmitWrapper = new ClaimPromotionsSubmitWrapper(text.toString(), getArguments().getString("package_name"));
        $jacocoInit[221] = true;
        return claimPromotionsSubmitWrapper;
    }

    public C0120S<String> refreshCaptchaClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.refreshCaptchaButton);
        C4539i iVar = new C4539i(this);
        $jacocoInit[77] = true;
        C0120S<String> j = a.mo3669j(iVar);
        $jacocoInit[78] = true;
        return j;
    }

    /* renamed from: f */
    public /* synthetic */ String mo15507f(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        String string = getArguments().getString("package_name");
        $jacocoInit[219] = true;
        return string;
    }

    public void showLoadingCaptcha() {
        boolean[] $jacocoInit = $jacocoInit();
        this.refreshCaptchaButton.setVisibility(8);
        $jacocoInit[79] = true;
        this.captchaLoading.setVisibility(0);
        $jacocoInit[80] = true;
    }

    public void hideLoadingCaptcha(String captchaUrl) {
        boolean[] $jacocoInit = $jacocoInit();
        this.refreshCaptchaButton.setVisibility(0);
        $jacocoInit[81] = true;
        this.captchaLoading.setVisibility(8);
        $jacocoInit[82] = true;
        ImageLoader with = ImageLoader.with(getContext());
        ImageView imageView = this.captcha;
        $jacocoInit[83] = true;
        with.loadWithRoundCornersWithoutCacheAndPlaceholder(captchaUrl, 8, imageView);
        $jacocoInit[84] = true;
    }

    public void sendWalletIntent() {
        boolean[] $jacocoInit = $jacocoInit();
        SystemU.openApp(WALLET_PACKAGE, getContext().getPackageManager(), getContext());
        $jacocoInit[85] = true;
    }

    public void showCaptchaView(String captchaUrl) {
        boolean[] $jacocoInit = $jacocoInit();
        this.claimPromotionsManager.saveCaptchaUrl(captchaUrl);
        $jacocoInit[86] = true;
        this.captchaErrorView.setVisibility(8);
        $jacocoInit[87] = true;
        this.loading.setVisibility(8);
        $jacocoInit[88] = true;
        this.insertWalletView.setVisibility(8);
        $jacocoInit[89] = true;
        this.captchaView.setVisibility(0);
        $jacocoInit[90] = true;
        ImageLoader with = ImageLoader.with(getContext());
        ImageView imageView = this.captcha;
        $jacocoInit[91] = true;
        with.loadWithRoundCornersWithoutCacheAndPlaceholder(captchaUrl, 8, imageView);
        $jacocoInit[92] = true;
    }

    public void showGenericError() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loading.setVisibility(8);
        $jacocoInit[93] = true;
        this.genericErrorView.setVisibility(0);
        $jacocoInit[94] = true;
        this.captchaView.setVisibility(8);
        $jacocoInit[95] = true;
        this.insertWalletView.setVisibility(8);
        $jacocoInit[96] = true;
        this.genericMessageView.setVisibility(8);
        $jacocoInit[97] = true;
    }

    public void showLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        this.captchaView.setVisibility(4);
        $jacocoInit[98] = true;
        this.loading.setVisibility(0);
        $jacocoInit[99] = true;
        this.insertWalletView.setVisibility(8);
        $jacocoInit[100] = true;
        this.genericMessageView.setVisibility(8);
        $jacocoInit[101] = true;
    }

    public void showInvalidWalletAddress() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loading.setVisibility(8);
        $jacocoInit[102] = true;
        showWalletView();
        $jacocoInit[103] = true;
        this.walletAddressEdit.setText("");
        $jacocoInit[104] = true;
        this.walletMessageIcon.setVisibility(8);
        $jacocoInit[105] = true;
        this.walletErrorView.setVisibility(0);
        $jacocoInit[106] = true;
    }

    public void showPromotionAlreadyClaimed() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loading.setVisibility(8);
        $jacocoInit[107] = true;
        String string = getResources().getString(C1375R.string.holidayspromotion_title_error_claimed);
        $jacocoInit[108] = true;
        String string2 = getResources().getString(C1375R.string.holidayspromotion_short_error_claimed);
        $jacocoInit[109] = true;
        showGenericMessageView(string, string2);
        $jacocoInit[110] = true;
    }

    public void showInvalidCaptcha(String captcha2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.loading.setVisibility(8);
        $jacocoInit[111] = true;
        this.captchaEdit.setText("");
        $jacocoInit[112] = true;
        showCaptchaView(captcha2);
        $jacocoInit[113] = true;
        this.captchaErrorView.setVisibility(0);
        $jacocoInit[114] = true;
    }

    public void showClaimSuccess() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loading.setVisibility(8);
        $jacocoInit[115] = true;
        String string = getResources().getString(C1375R.string.holidayspromotion_title_completed);
        $jacocoInit[116] = true;
        String string2 = getResources().getString(C1375R.string.holidayspromotion_message_completed);
        $jacocoInit[117] = true;
        showGenericMessageView(string, string2);
        $jacocoInit[118] = true;
    }

    public C0120S<C13051f> editTextChanges() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<C13051f> a = C13050e.m42502a(this.walletAddressEdit);
        $jacocoInit[119] = true;
        return a;
    }

    public void handleEmptyEditText(Editable address) {
        boolean[] $jacocoInit = $jacocoInit();
        String obj = address.toString();
        $jacocoInit[120] = true;
        if (obj.equals("")) {
            $jacocoInit[121] = true;
            this.walletMessageIcon.setVisibility(8);
            $jacocoInit[122] = true;
        } else {
            this.walletMessageIcon.setVisibility(0);
            $jacocoInit[123] = true;
        }
        if (validateAddress(address.toString())) {
            $jacocoInit[124] = true;
            enableNextButton();
            $jacocoInit[125] = true;
            disableWalletButton();
            $jacocoInit[126] = true;
            setValidWalletMessage();
            $jacocoInit[127] = true;
        } else {
            disableNextButton();
            $jacocoInit[128] = true;
            enableWalletButton();
            $jacocoInit[129] = true;
            setInvalidWalletMessage();
            $jacocoInit[130] = true;
        }
        this.walletErrorView.setVisibility(8);
        $jacocoInit[131] = true;
    }

    public C0120S<Void> dismissGenericErrorClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.genericErrorOkButton);
        $jacocoInit[132] = true;
        return a;
    }

    public C0120S<String> walletCancelClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.walletCancelButton);
        C4531g gVar = new C4531g(this);
        $jacocoInit[133] = true;
        C0120S<String> j = a.mo3669j(gVar);
        $jacocoInit[134] = true;
        return j;
    }

    /* renamed from: g */
    public /* synthetic */ String mo15511g(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        String string = getArguments().getString("package_name");
        $jacocoInit[218] = true;
        return string;
    }

    public C0120S<String> captchaCancelClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.captchaCancelButton);
        C4515c cVar = new C4515c(this);
        $jacocoInit[135] = true;
        C0120S<String> j = a.mo3669j(cVar);
        $jacocoInit[136] = true;
        return j;
    }

    /* renamed from: a */
    public /* synthetic */ String mo15496a(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        String string = getArguments().getString("package_name");
        $jacocoInit[217] = true;
        return string;
    }

    public C0120S<ClaimDialogResultWrapper> dismissGenericMessage() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.genericMessageButton);
        C4519d dVar = new C4519d(this);
        $jacocoInit[137] = true;
        C0120S<ClaimDialogResultWrapper> j = a.mo3669j(dVar);
        $jacocoInit[138] = true;
        return j;
    }

    /* renamed from: c */
    public /* synthetic */ ClaimDialogResultWrapper mo15498c(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        CharSequence text = this.genericMessageTitle.getText();
        $jacocoInit[213] = true;
        String str = "package_name";
        if (text.equals(getResources().getString(C1375R.string.holidayspromotion_title_completed))) {
            $jacocoInit[214] = true;
            ClaimDialogResultWrapper claimDialogResultWrapper = new ClaimDialogResultWrapper(getArguments().getString(str), true);
            $jacocoInit[215] = true;
            return claimDialogResultWrapper;
        }
        ClaimDialogResultWrapper claimDialogResultWrapper2 = new ClaimDialogResultWrapper(getArguments().getString(str), false);
        $jacocoInit[216] = true;
        return claimDialogResultWrapper2;
    }

    public void dismissDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        dismiss();
        $jacocoInit[139] = true;
    }

    public void fetchWalletAddressByIntent() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.walletErrorView.getVisibility() == 0) {
            $jacocoInit[140] = true;
        } else {
            $jacocoInit[141] = true;
            this.navigator.fetchWalletAddressByIntent(WALLET_INTENT_URI_ACTION, 123, WALLET_INTENT_EXTRA_KEY, WALLET_INTENT_EXTRA_VALUE);
            $jacocoInit[142] = true;
        }
        $jacocoInit[143] = true;
    }

    public C0120S<Result> getActivityResults() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Result> results = ((ActivityResultNavigator) getContext()).results();
        $jacocoInit[144] = true;
        return results;
    }

    public void updateWalletText(String walletAddress) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!validateAddress(walletAddress)) {
            $jacocoInit[145] = true;
        } else {
            $jacocoInit[146] = true;
            this.walletAddressEdit.setText(walletAddress);
            $jacocoInit[147] = true;
        }
        $jacocoInit[148] = true;
    }

    public void fetchWalletAddressByClipboard() {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.clipboard.hasPrimaryClip()) {
            $jacocoInit[149] = true;
        } else {
            ClipDescription primaryClipDescription = this.clipboard.getPrimaryClipDescription();
            $jacocoInit[150] = true;
            if (!primaryClipDescription.hasMimeType("text/plain")) {
                $jacocoInit[151] = true;
            } else {
                $jacocoInit[152] = true;
                ClipData primaryClip = this.clipboard.getPrimaryClip();
                $jacocoInit[153] = true;
                Item item = primaryClip.getItemAt(0);
                $jacocoInit[154] = true;
                CharSequence text = item.getText();
                $jacocoInit[155] = true;
                String address = text.toString();
                $jacocoInit[156] = true;
                updateWalletText(address);
                $jacocoInit[157] = true;
            }
        }
        $jacocoInit[158] = true;
    }

    private boolean validateAddress(String address) {
        boolean[] $jacocoInit = $jacocoInit();
        if (address != null) {
            $jacocoInit[159] = true;
            boolean matches = address.matches("(^(0x))([0-9a-f]{40})$");
            $jacocoInit[160] = true;
            return matches;
        }
        $jacocoInit[161] = true;
        return false;
    }

    private void enableNextButton() {
        boolean[] $jacocoInit = $jacocoInit();
        this.walletNextButton.setClickable(true);
        $jacocoInit[162] = true;
        this.walletNextButton.setFocusable(true);
        $jacocoInit[163] = true;
        this.walletNextButton.setTextColor(getResources().getColor(C1375R.color.default_orange_gradient_end));
        $jacocoInit[164] = true;
    }

    private void disableNextButton() {
        boolean[] $jacocoInit = $jacocoInit();
        this.walletNextButton.setClickable(false);
        $jacocoInit[165] = true;
        this.walletNextButton.setFocusable(false);
        $jacocoInit[166] = true;
        this.walletNextButton.setTextColor(getResources().getColor(C1375R.color.grey_fog_light));
        $jacocoInit[167] = true;
    }

    private void disableWalletButton() {
        boolean[] $jacocoInit = $jacocoInit();
        this.getWalletAddressButton.setClickable(false);
        $jacocoInit[168] = true;
        this.getWalletAddressButton.setFocusable(false);
        $jacocoInit[169] = true;
        this.getWalletAddressButton.setBackgroundColor(getResources().getColor(C1375R.color.grey_fog_light));
        $jacocoInit[170] = true;
    }

    private void enableWalletButton() {
        boolean[] $jacocoInit = $jacocoInit();
        this.getWalletAddressButton.setClickable(true);
        $jacocoInit[171] = true;
        this.getWalletAddressButton.setFocusable(true);
        $jacocoInit[172] = true;
        this.getWalletAddressButton.setBackgroundResource(C1375R.drawable.aptoide_gradient);
        $jacocoInit[173] = true;
    }

    private void setValidWalletMessage() {
        boolean[] $jacocoInit = $jacocoInit();
        this.walletMessageIcon.setImageDrawable(getResources().getDrawable(C1375R.drawable.ic_check_green));
        $jacocoInit[174] = true;
    }

    private void setInvalidWalletMessage() {
        boolean[] $jacocoInit = $jacocoInit();
        this.walletMessageIcon.setImageDrawable(getResources().getDrawable(C1375R.drawable.ic_info));
        $jacocoInit[175] = true;
    }

    private void showWalletView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.walletErrorView.setVisibility(8);
        $jacocoInit[176] = true;
        this.loading.setVisibility(8);
        $jacocoInit[177] = true;
        this.genericMessageView.setVisibility(8);
        $jacocoInit[178] = true;
        this.captchaView.setVisibility(8);
        $jacocoInit[179] = true;
        this.insertWalletView.setVisibility(0);
        $jacocoInit[180] = true;
    }

    private void showGenericMessageView(String title, String body) {
        boolean[] $jacocoInit = $jacocoInit();
        this.walletErrorView.setVisibility(8);
        $jacocoInit[181] = true;
        this.loading.setVisibility(8);
        $jacocoInit[182] = true;
        this.captchaView.setVisibility(8);
        $jacocoInit[183] = true;
        this.insertWalletView.setVisibility(8);
        $jacocoInit[184] = true;
        this.genericMessageTitle.setText(title);
        $jacocoInit[185] = true;
        this.genericMessageBody.setText(body);
        $jacocoInit[186] = true;
        this.genericMessageView.setVisibility(0);
        $jacocoInit[187] = true;
    }

    private void handleRestoreViewState(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        if (savedInstanceState == null) {
            $jacocoInit[188] = true;
        } else {
            String str = VIEW;
            if (savedInstanceState.getString(str) == null) {
                $jacocoInit[189] = true;
            } else {
                $jacocoInit[190] = true;
                String show = savedInstanceState.getString(str);
                $jacocoInit[191] = true;
                char c = 65535;
                switch (show.hashCode()) {
                    case -1867169789:
                        if (show.equals("success")) {
                            $jacocoInit[202] = true;
                            c = 5;
                            break;
                        } else {
                            $jacocoInit[201] = true;
                            break;
                        }
                    case -795192327:
                        if (show.equals(WALLET)) {
                            $jacocoInit[194] = true;
                            c = 1;
                            break;
                        } else {
                            $jacocoInit[193] = true;
                            break;
                        }
                    case 96784904:
                        if (show.equals(GENERIC_ERROR)) {
                            $jacocoInit[204] = true;
                            c = 6;
                            break;
                        } else {
                            $jacocoInit[203] = true;
                            break;
                        }
                    case 552567418:
                        if (show.equals(CAPTCHA)) {
                            $jacocoInit[198] = true;
                            c = 3;
                            break;
                        } else {
                            $jacocoInit[197] = true;
                            break;
                        }
                    case 853317083:
                        if (show.equals(CLAIMED)) {
                            $jacocoInit[200] = true;
                            c = 4;
                            break;
                        } else {
                            $jacocoInit[199] = true;
                            break;
                        }
                    case 962556931:
                        if (show.equals(CAPTCHA_ERROR)) {
                            $jacocoInit[196] = true;
                            c = 2;
                            break;
                        } else {
                            $jacocoInit[195] = true;
                            break;
                        }
                    default:
                        $jacocoInit[192] = true;
                        break;
                }
                if (c == 2) {
                    showInvalidCaptcha(this.claimPromotionsManager.getCaptchaUrl());
                    $jacocoInit[207] = true;
                } else if (c == 3) {
                    $jacocoInit[205] = true;
                } else if (c == 4) {
                    showPromotionAlreadyClaimed();
                    $jacocoInit[209] = true;
                } else if (c == 5) {
                    showClaimSuccess();
                    $jacocoInit[210] = true;
                } else if (c != 6) {
                    showWalletView();
                    $jacocoInit[206] = true;
                } else {
                    showGenericError();
                    $jacocoInit[211] = true;
                }
                showCaptchaView(this.claimPromotionsManager.getCaptchaUrl());
                $jacocoInit[208] = true;
            }
        }
        $jacocoInit[212] = true;
    }
}
