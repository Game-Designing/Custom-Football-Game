package p005cm.aptoide.p006pt.app.view.donations.view;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.support.p000v4.app.C0478k;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.app.AppNavigator;
import p005cm.aptoide.p006pt.app.view.donations.DonationsAnalytics;
import p005cm.aptoide.p006pt.app.view.donations.WalletService;
import p005cm.aptoide.p006pt.app.view.donations.model.DonationsDialogResult;
import p005cm.aptoide.p006pt.app.view.donations.utils.GenericPaymentIntentBuilder;
import p005cm.aptoide.p006pt.app.view.donations.utils.GenericPaymentIntentBuilder.TransactionData;
import p005cm.aptoide.p006pt.store.StoreTheme;
import p005cm.aptoide.p006pt.view.ActivityComponent;
import p005cm.aptoide.p006pt.view.MainActivity;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.p029i.C0136c;
import p026rx.p387a.p389b.C14522a;

/* renamed from: cm.aptoide.pt.app.view.donations.view.DonateDialogFragment */
public class DonateDialogFragment extends C0478k implements DonateDialogView {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String HAS_WALLET = "wallet";
    private static final int MAX = 125000;
    private static final String PACKAGE_NAME = "package_name";
    private static final int RC_REQUEST = 666;
    private static final int SEEKBAR_MAX = 20;
    private static final int SEEKBAR_START = 2;
    @Inject
    AppNavigator appNavigator;
    private SeekBar appcSlider;
    private EditText appcValue;
    private Button cancelButton;
    private Button donateButton;
    @Inject
    DonationsAnalytics donationsAnalytics;
    private ProgressBar donationsProgress;
    private View donationsView;
    private InputFilter editTextFilter;
    private Button errorOkButton;
    private View errorView;
    private InputMethodManager imm;
    private EditText nickname;
    private Button noWalletCancelButton;
    private Button noWalletContinueButton;
    private View noWalletView;
    private String packageName;
    private DonateDialogPresenter presenter;
    boolean sliderUpdate;
    boolean textUpdate;
    private Button thankYouOkButton;
    private View thankYouView;
    @Inject
    String theme;
    @Inject
    WalletService walletService;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5158635730699490101L, "cm/aptoide/pt/app/view/donations/view/DonateDialogFragment", Opcodes.LUSHR);
        $jacocoData = probes;
        return probes;
    }

    public DonateDialogFragment() {
        $jacocoInit()[0] = true;
    }

    static /* synthetic */ EditText access$000(DonateDialogFragment x0) {
        boolean[] $jacocoInit = $jacocoInit();
        EditText editText = x0.appcValue;
        $jacocoInit[122] = true;
        return editText;
    }

    static /* synthetic */ SeekBar access$100(DonateDialogFragment x0) {
        boolean[] $jacocoInit = $jacocoInit();
        SeekBar seekBar = x0.appcSlider;
        $jacocoInit[123] = true;
        return seekBar;
    }

    static /* synthetic */ InputMethodManager access$200(DonateDialogFragment x0) {
        boolean[] $jacocoInit = $jacocoInit();
        InputMethodManager inputMethodManager = x0.imm;
        $jacocoInit[124] = true;
        return inputMethodManager;
    }

    public static DonateDialogFragment newInstance(String packageName2, boolean hasWallet) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle args = new Bundle();
        $jacocoInit[1] = true;
        DonateDialogFragment fragment = new DonateDialogFragment();
        $jacocoInit[2] = true;
        args.putString("package_name", packageName2);
        $jacocoInit[3] = true;
        args.putBoolean(HAS_WALLET, hasWallet);
        $jacocoInit[4] = true;
        fragment.setStyle(1, 0);
        $jacocoInit[5] = true;
        fragment.setArguments(args);
        $jacocoInit[6] = true;
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[7] = true;
        ActivityComponent activityComponent = ((MainActivity) getContext()).getActivityComponent();
        $jacocoInit[8] = true;
        activityComponent.inject(this);
        $jacocoInit[9] = true;
        this.packageName = getArguments().getString("package_name");
        $jacocoInit[10] = true;
        WalletService walletService2 = this.walletService;
        C0136c cVar = new C0136c();
        $jacocoInit[11] = true;
        DonateDialogPresenter donateDialogPresenter = new DonateDialogPresenter(this, walletService2, cVar, C14522a.m46170a(), this.appNavigator, this.donationsAnalytics);
        this.presenter = donateDialogPresenter;
        this.textUpdate = true;
        this.sliderUpdate = true;
        $jacocoInit[12] = true;
        handleValueInputFiltering();
        $jacocoInit[13] = true;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onDestroyView();
        this.nickname = null;
        this.appcValue = null;
        this.appcSlider = null;
        this.donateButton = null;
        this.cancelButton = null;
        this.donationsView = null;
        this.donationsProgress = null;
        $jacocoInit[14] = true;
    }

    private void handleValueInputFiltering() {
        boolean[] $jacocoInit = $jacocoInit();
        this.imm = (InputMethodManager) getContext().getSystemService("input_method");
        $jacocoInit[15] = true;
        this.editTextFilter = new InputFilter(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final int maxDigitsAfterDecimalPoint = 2;
            final int maxDigitsBeforeDecimalPoint = 6;
            final /* synthetic */ DonateDialogFragment this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-6309761676534580252L, "cm/aptoide/pt/app/view/donations/view/DonateDialogFragment$1", 10);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                boolean[] $jacocoInit = $jacocoInit();
                StringBuilder builder = new StringBuilder(dest);
                $jacocoInit[1] = true;
                CharSequence subSequence = source.subSequence(start, end);
                $jacocoInit[2] = true;
                String charSequence = subSequence.toString();
                $jacocoInit[3] = true;
                builder.replace(dstart, dend, charSequence);
                $jacocoInit[4] = true;
                String sb = builder.toString();
                $jacocoInit[5] = true;
                if (!sb.matches("(([1-9]{1})([0-9]{0,5})?)?(\\.[0-9]{0,2})?")) {
                    $jacocoInit[6] = true;
                    if (source.length() == 0) {
                        CharSequence subSequence2 = dest.subSequence(dstart, dend);
                        $jacocoInit[7] = true;
                        return subSequence2;
                    }
                    $jacocoInit[8] = true;
                    return "";
                }
                $jacocoInit[9] = true;
                return null;
            }
        };
        $jacocoInit[16] = true;
    }

    private void setValueInsertProperties() {
        boolean[] $jacocoInit = $jacocoInit();
        this.appcValue.setText(String.valueOf(2));
        $jacocoInit[17] = true;
        this.appcValue.setFilters(new InputFilter[]{this.editTextFilter});
        $jacocoInit[18] = true;
        this.appcValue.addTextChangedListener(new TextWatcher(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ DonateDialogFragment this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(7976717043740774802L, "cm/aptoide/pt/app/view/donations/view/DonateDialogFragment$2", 21);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                boolean[] $jacocoInit = $jacocoInit();
                Editable text = DonateDialogFragment.access$000(this.this$0).getText();
                $jacocoInit[1] = true;
                String obj = text.toString();
                $jacocoInit[2] = true;
                int intLength = obj.length();
                $jacocoInit[3] = true;
                DonateDialogFragment.access$000(this.this$0).setSelection(intLength);
                $jacocoInit[4] = true;
            }

            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                $jacocoInit()[5] = true;
            }

            public void afterTextChanged(Editable editable) {
                boolean[] $jacocoInit = $jacocoInit();
                float value = 0.0f;
                $jacocoInit[6] = true;
                String strValue = editable.toString();
                $jacocoInit[7] = true;
                if (strValue.equals("")) {
                    $jacocoInit[8] = true;
                } else {
                    $jacocoInit[9] = true;
                    String substring = strValue.substring(0, 1);
                    $jacocoInit[10] = true;
                    if (!substring.equals(".")) {
                        $jacocoInit[11] = true;
                    } else {
                        $jacocoInit[12] = true;
                        strValue = BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID.concat(strValue);
                        $jacocoInit[13] = true;
                    }
                    value = Float.parseFloat(strValue);
                    $jacocoInit[14] = true;
                }
                if (value > 0.0f) {
                    DonateDialogFragment donateDialogFragment = this.this$0;
                    donateDialogFragment.textUpdate = false;
                    if (!donateDialogFragment.sliderUpdate) {
                        $jacocoInit[15] = true;
                    } else {
                        $jacocoInit[16] = true;
                        DonateDialogFragment.access$100(donateDialogFragment).setProgress((int) Math.sqrt((double) ((value / 125000.0f) * 1000.0f * 1000.0f)));
                        $jacocoInit[17] = true;
                    }
                    this.this$0.textUpdate = true;
                    $jacocoInit[18] = true;
                } else {
                    DonateDialogFragment.access$100(this.this$0).setProgress(Math.round(value));
                    $jacocoInit[19] = true;
                }
                $jacocoInit[20] = true;
            }
        });
        $jacocoInit[19] = true;
    }

    private void setSliderProperties() {
        boolean[] $jacocoInit = $jacocoInit();
        this.appcSlider.setMax(20);
        $jacocoInit[20] = true;
        this.appcSlider.setProgress(2);
        $jacocoInit[21] = true;
        this.appcSlider.incrementProgressBy(1);
        $jacocoInit[22] = true;
        Drawable progressDrawable = this.appcSlider.getProgressDrawable();
        $jacocoInit[23] = true;
        Resources resources = getContext().getResources();
        String str = this.theme;
        $jacocoInit[24] = true;
        StoreTheme storeTheme = StoreTheme.get(str);
        $jacocoInit[25] = true;
        int darkerColor = storeTheme.getDarkerColor();
        $jacocoInit[26] = true;
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(resources.getColor(darkerColor), Mode.SRC_IN);
        $jacocoInit[27] = true;
        progressDrawable.setColorFilter(porterDuffColorFilter);
        if (VERSION.SDK_INT < 16) {
            $jacocoInit[28] = true;
        } else {
            $jacocoInit[29] = true;
            Drawable thumb = this.appcSlider.getThumb();
            $jacocoInit[30] = true;
            Resources resources2 = getContext().getResources();
            String str2 = this.theme;
            $jacocoInit[31] = true;
            StoreTheme storeTheme2 = StoreTheme.get(str2);
            $jacocoInit[32] = true;
            int darkerColor2 = storeTheme2.getDarkerColor();
            $jacocoInit[33] = true;
            int color = resources2.getColor(darkerColor2);
            Mode mode = Mode.SRC_IN;
            $jacocoInit[34] = true;
            thumb.setColorFilter(color, mode);
            $jacocoInit[35] = true;
        }
        this.appcSlider.setOnSeekBarChangeListener(new OnSeekBarChangeListener(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ DonateDialogFragment this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-2572017630261999908L, "cm/aptoide/pt/app/view/donations/view/DonateDialogFragment$3", 12);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                boolean[] $jacocoInit = $jacocoInit();
                DonateDialogFragment donateDialogFragment = this.this$0;
                donateDialogFragment.sliderUpdate = false;
                if (!donateDialogFragment.textUpdate) {
                    $jacocoInit[1] = true;
                } else {
                    $jacocoInit[2] = true;
                    DonateDialogFragment.access$000(donateDialogFragment).setText(String.valueOf(Math.round((((float) (i * i)) / 1000000.0f) * 125000.0f)));
                    $jacocoInit[3] = true;
                }
                this.this$0.sliderUpdate = true;
                $jacocoInit[4] = true;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                boolean[] $jacocoInit = $jacocoInit();
                if (DonateDialogFragment.access$200(this.this$0) == null) {
                    $jacocoInit[5] = true;
                } else {
                    $jacocoInit[6] = true;
                    InputMethodManager access$200 = DonateDialogFragment.access$200(this.this$0);
                    View rootView = this.this$0.getView().getRootView();
                    $jacocoInit[7] = true;
                    IBinder windowToken = rootView.getWindowToken();
                    $jacocoInit[8] = true;
                    access$200.hideSoftInputFromWindow(windowToken, 0);
                    $jacocoInit[9] = true;
                }
                $jacocoInit[10] = true;
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                $jacocoInit()[11] = true;
            }
        });
        $jacocoInit[36] = true;
    }

    public C0120S<DonationsDialogResult> donateClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.donateButton);
        C2046c cVar = new C2046c(this);
        $jacocoInit[37] = true;
        C0120S<DonationsDialogResult> j = a.mo3669j(cVar);
        $jacocoInit[38] = true;
        return j;
    }

    /* renamed from: b */
    public /* synthetic */ DonationsDialogResult mo10955b(Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.packageName;
        Editable text = this.nickname.getText();
        $jacocoInit[118] = true;
        String obj = text.toString();
        Editable text2 = this.appcValue.getText();
        $jacocoInit[119] = true;
        String obj2 = text2.toString();
        $jacocoInit[120] = true;
        DonationsDialogResult donationsDialogResult = new DonationsDialogResult(str, obj, Float.parseFloat(obj2));
        $jacocoInit[121] = true;
        return donationsDialogResult;
    }

    public C0120S<DonationsDialogResult> cancelClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.cancelButton);
        C2045b bVar = new C2045b(this);
        $jacocoInit[39] = true;
        C0120S<DonationsDialogResult> j = a.mo3669j(bVar);
        $jacocoInit[40] = true;
        return j;
    }

    /* renamed from: a */
    public /* synthetic */ DonationsDialogResult mo10953a(Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.packageName;
        Editable text = this.nickname.getText();
        $jacocoInit[114] = true;
        String obj = text.toString();
        Editable text2 = this.appcValue.getText();
        $jacocoInit[115] = true;
        String obj2 = text2.toString();
        $jacocoInit[116] = true;
        DonationsDialogResult donationsDialogResult = new DonationsDialogResult(str, obj, Float.parseFloat(obj2));
        $jacocoInit[117] = true;
        return donationsDialogResult;
    }

    public C0120S<Void> noWalletContinueClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.noWalletContinueButton);
        $jacocoInit[41] = true;
        return a;
    }

    public void sendWalletIntent(float value, String address, String packageName2, String nickname2) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[42] = true;
        PendingIntent intent = GenericPaymentIntentBuilder.buildBuyIntent(getContext(), "donation", String.valueOf(value), address, packageName2, TransactionData.TYPE_DONATION, nickname2, false);
        try {
            $jacocoInit[43] = true;
            try {
                startIntentSenderForResult(intent.getIntentSender(), RC_REQUEST, new Intent(), 0, 0, 0, null);
                $jacocoInit[44] = true;
            } catch (SendIntentException e) {
                e = e;
                $jacocoInit[45] = true;
                e.printStackTrace();
                $jacocoInit[46] = true;
                this.donationsProgress.setVisibility(8);
                $jacocoInit[47] = true;
            }
        } catch (SendIntentException e2) {
            e = e2;
            $jacocoInit[45] = true;
            e.printStackTrace();
            $jacocoInit[46] = true;
            this.donationsProgress.setVisibility(8);
            $jacocoInit[47] = true;
        }
        this.donationsProgress.setVisibility(8);
        $jacocoInit[47] = true;
    }

    public void showLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        this.donationsView.setVisibility(8);
        $jacocoInit[48] = true;
        this.donationsProgress.setVisibility(0);
        $jacocoInit[49] = true;
    }

    public void showNoWalletView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.donationsProgress.setVisibility(8);
        $jacocoInit[50] = true;
        this.noWalletView.setVisibility(0);
        $jacocoInit[51] = true;
    }

    public void dismissDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        dismiss();
        $jacocoInit[52] = true;
    }

    public void showErrorMessage() {
        boolean[] $jacocoInit = $jacocoInit();
        this.donationsProgress.setVisibility(8);
        $jacocoInit[53] = true;
        this.errorView.setVisibility(0);
        $jacocoInit[54] = true;
        this.errorOkButton.setOnClickListener(new C2047d(this));
        $jacocoInit[55] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo10957c(View click) {
        boolean[] $jacocoInit = $jacocoInit();
        dismiss();
        $jacocoInit[113] = true;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        boolean[] $jacocoInit = $jacocoInit();
        if (requestCode != RC_REQUEST) {
            $jacocoInit[56] = true;
        } else if (resultCode != 0) {
            $jacocoInit[57] = true;
        } else {
            $jacocoInit[58] = true;
            showErrorMessage();
            $jacocoInit[59] = true;
            $jacocoInit[63] = true;
        }
        if (requestCode != RC_REQUEST) {
            $jacocoInit[60] = true;
        } else if (resultCode != -1) {
            $jacocoInit[61] = true;
        } else {
            showThankYouMessage();
            $jacocoInit[62] = true;
        }
        $jacocoInit[63] = true;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreateView(inflater, container, savedInstanceState);
        $jacocoInit[64] = true;
        View inflate = inflater.inflate(C1375R.layout.appview_donations_dialog, container, false);
        $jacocoInit[65] = true;
        return inflate;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        $jacocoInit[66] = true;
        this.nickname = (EditText) view.findViewById(C1375R.C1376id.nickname);
        $jacocoInit[67] = true;
        this.nickname.setImeOptions(6);
        $jacocoInit[68] = true;
        this.nickname.setSingleLine();
        $jacocoInit[69] = true;
        this.appcValue = (EditText) view.findViewById(C1375R.C1376id.appc_value);
        $jacocoInit[70] = true;
        this.appcSlider = (SeekBar) view.findViewById(C1375R.C1376id.appc_slider);
        $jacocoInit[71] = true;
        this.donateButton = (Button) view.findViewById(C1375R.C1376id.donate_button);
        $jacocoInit[72] = true;
        this.cancelButton = (Button) view.findViewById(C1375R.C1376id.cancel_button);
        $jacocoInit[73] = true;
        this.donationsView = view.findViewById(C1375R.C1376id.donations_view);
        $jacocoInit[74] = true;
        this.donationsProgress = (ProgressBar) view.findViewById(C1375R.C1376id.donations_progress);
        $jacocoInit[75] = true;
        this.noWalletView = view.findViewById(C1375R.C1376id.no_wallet_layout);
        $jacocoInit[76] = true;
        this.noWalletCancelButton = (Button) view.findViewById(C1375R.C1376id.no_wallet_cancel_button);
        $jacocoInit[77] = true;
        this.noWalletContinueButton = (Button) view.findViewById(C1375R.C1376id.no_wallet_continue_button);
        $jacocoInit[78] = true;
        this.errorView = view.findViewById(C1375R.C1376id.error_layout);
        $jacocoInit[79] = true;
        this.errorOkButton = (Button) view.findViewById(C1375R.C1376id.error_ok_button);
        $jacocoInit[80] = true;
        this.thankYouView = view.findViewById(C1375R.C1376id.thank_you_layout);
        $jacocoInit[81] = true;
        this.thankYouOkButton = (Button) view.findViewById(C1375R.C1376id.thank_you_ok_button);
        $jacocoInit[82] = true;
        chooseViewToPresent(getArguments().getBoolean(HAS_WALLET, true));
        $jacocoInit[83] = true;
        this.presenter.present();
        $jacocoInit[84] = true;
    }

    public void onResume() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onResume();
        $jacocoInit[85] = true;
        Window window = getDialog().getWindow();
        $jacocoInit[86] = true;
        Point size = new Point();
        $jacocoInit[87] = true;
        WindowManager windowManager = window.getWindowManager();
        $jacocoInit[88] = true;
        Display display = windowManager.getDefaultDisplay();
        $jacocoInit[89] = true;
        display.getSize(size);
        int width = size.x;
        $jacocoInit[90] = true;
        double d = (double) width;
        Double.isNaN(d);
        window.setLayout((int) (d * 0.9d), -2);
        $jacocoInit[91] = true;
        window.setGravity(17);
        $jacocoInit[92] = true;
    }

    public void onDestroy() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onDestroy();
        this.packageName = null;
        $jacocoInit[93] = true;
        this.presenter.dispose();
        this.presenter = null;
        $jacocoInit[94] = true;
    }

    private void chooseViewToPresent(boolean hasWallet) {
        boolean[] $jacocoInit = $jacocoInit();
        this.donationsView.setOnClickListener(new C2048e(this));
        if (hasWallet) {
            $jacocoInit[95] = true;
            setSliderProperties();
            $jacocoInit[96] = true;
            setValueInsertProperties();
            $jacocoInit[97] = true;
        } else {
            this.donationsView.setVisibility(8);
            $jacocoInit[98] = true;
            showNoWalletView();
            $jacocoInit[99] = true;
            this.noWalletCancelButton.setOnClickListener(new C2049f(this));
            $jacocoInit[100] = true;
        }
        $jacocoInit[101] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10954a(View click) {
        boolean[] $jacocoInit = $jacocoInit();
        InputMethodManager inputMethodManager = this.imm;
        if (inputMethodManager == null) {
            $jacocoInit[107] = true;
        } else {
            $jacocoInit[108] = true;
            View rootView = getView().getRootView();
            $jacocoInit[109] = true;
            IBinder windowToken = rootView.getWindowToken();
            $jacocoInit[110] = true;
            inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
            $jacocoInit[111] = true;
        }
        $jacocoInit[112] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo10956b(View click) {
        boolean[] $jacocoInit = $jacocoInit();
        dismiss();
        $jacocoInit[106] = true;
    }

    private void showThankYouMessage() {
        boolean[] $jacocoInit = $jacocoInit();
        this.donationsProgress.setVisibility(8);
        $jacocoInit[102] = true;
        this.thankYouView.setVisibility(0);
        $jacocoInit[103] = true;
        this.thankYouOkButton.setOnClickListener(new C2044a(this));
        $jacocoInit[104] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo10959d(View click) {
        boolean[] $jacocoInit = $jacocoInit();
        dismiss();
        $jacocoInit[105] = true;
    }
}
