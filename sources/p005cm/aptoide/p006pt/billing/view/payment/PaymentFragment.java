package p005cm.aptoide.p006pt.billing.view.payment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bumptech.glide.C5926c;
import com.bumptech.glide.C6029k;
import com.bumptech.glide.C6354n;
import com.bumptech.glide.p103f.p104a.C5974g;
import com.bumptech.glide.p103f.p105b.C5983b;
import java.util.HashSet;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.billing.Billing;
import p005cm.aptoide.p006pt.billing.BillingAnalytics;
import p005cm.aptoide.p006pt.billing.BillingIdManager;
import p005cm.aptoide.p006pt.billing.Price;
import p005cm.aptoide.p006pt.billing.payment.PaymentService;
import p005cm.aptoide.p006pt.billing.product.Product;
import p005cm.aptoide.p006pt.billing.view.BillingActivity;
import p005cm.aptoide.p006pt.billing.view.BillingNavigator;
import p005cm.aptoide.p006pt.navigator.ActivityResultNavigator;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.permission.PermissionServiceFragment;
import p005cm.aptoide.p006pt.utils.AptoideUtils.ScreenU;
import p005cm.aptoide.p006pt.view.p080rx.RxAlertDialog;
import p005cm.aptoide.p006pt.view.p080rx.RxAlertDialog.Builder;
import p005cm.aptoide.p006pt.view.spannable.SpannableFactory;
import p019d.p022i.p296a.p305c.C13034a;
import p019d.p022i.p296a.p306d.C13049d;
import p026rx.C0120S;
import p026rx.p027b.C0132p;
import p026rx.p387a.p389b.C14522a;

/* renamed from: cm.aptoide.pt.billing.view.payment.PaymentFragment */
public class PaymentFragment extends PermissionServiceFragment implements PaymentView {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private Billing billing;
    private BillingAnalytics billingAnalytics;
    private BillingIdManager billingIdManager;
    private BillingNavigator billingNavigator;
    private Button buyButton;
    private boolean buyLoading;
    private Button cancelButton;
    private RxAlertDialog networkErrorDialog;
    private TextView noPaymentsText;
    private View overlay;
    private boolean paymentLoading;
    private TextView productDescription;
    private ImageView productIcon;
    private TextView productName;
    private TextView productPrice;
    private View progressView;
    private ScrollView scroll;
    private RadioGroup serviceRadioGroup;
    private SpannableFactory spannableFactory;
    private boolean transactionLoading;
    private RxAlertDialog unknownErrorDialog;

    /* renamed from: cm.aptoide.pt.billing.view.payment.PaymentFragment$RadioButtonTarget */
    private static class RadioButtonTarget extends C5974g<Drawable> {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private RadioButton radioButton;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-5917170401202185890L, "cm/aptoide/pt/billing/view/payment/PaymentFragment$RadioButtonTarget", 5);
            $jacocoData = probes;
            return probes;
        }

        public /* bridge */ /* synthetic */ void onResourceReady(Object obj, C5983b bVar) {
            boolean[] $jacocoInit = $jacocoInit();
            onResourceReady((Drawable) obj, bVar);
            $jacocoInit[4] = true;
        }

        public RadioButtonTarget(int pixels, RadioButton radioButton2) {
            boolean[] $jacocoInit = $jacocoInit();
            super(pixels, pixels);
            this.radioButton = radioButton2;
            $jacocoInit[0] = true;
        }

        public void onResourceReady(Drawable glideDrawable, C5983b<? super Drawable> bVar) {
            boolean[] $jacocoInit = $jacocoInit();
            this.radioButton.setCompoundDrawablesWithIntrinsicBounds(null, null, glideDrawable.getCurrent(), null);
            $jacocoInit[1] = true;
        }

        public void onDestroy() {
            boolean[] $jacocoInit = $jacocoInit();
            this.radioButton = null;
            $jacocoInit[2] = true;
            super.onDestroy();
            $jacocoInit[3] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7913271068051160037L, "cm/aptoide/pt/billing/view/payment/PaymentFragment", 123);
        $jacocoData = probes;
        return probes;
    }

    public PaymentFragment() {
        $jacocoInit()[0] = true;
    }

    static /* synthetic */ ScrollView access$000(PaymentFragment x0) {
        boolean[] $jacocoInit = $jacocoInit();
        ScrollView scrollView = x0.scroll;
        $jacocoInit[122] = true;
        return scrollView;
    }

    public static Fragment create(Bundle bundle) {
        boolean[] $jacocoInit = $jacocoInit();
        PaymentFragment fragment = new PaymentFragment();
        $jacocoInit[1] = true;
        fragment.setArguments(bundle);
        $jacocoInit[2] = true;
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[3] = true;
        AptoideApplication aptoideApplication = (AptoideApplication) getContext().getApplicationContext();
        $jacocoInit[4] = true;
        Bundle arguments = getArguments();
        String str = BillingActivity.EXTRA_MERCHANT_NAME;
        String string = arguments.getString(str);
        $jacocoInit[5] = true;
        this.billing = aptoideApplication.getBilling(string);
        $jacocoInit[6] = true;
        this.billingAnalytics = ((AptoideApplication) getContext().getApplicationContext()).getBillingAnalytics();
        $jacocoInit[7] = true;
        this.billingNavigator = ((ActivityResultNavigator) getContext()).getBillingNavigator();
        $jacocoInit[8] = true;
        AptoideApplication aptoideApplication2 = (AptoideApplication) getContext().getApplicationContext();
        $jacocoInit[9] = true;
        String string2 = getArguments().getString(str);
        $jacocoInit[10] = true;
        this.billingIdManager = aptoideApplication2.getIdResolver(string2);
        $jacocoInit[11] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        $jacocoInit[12] = true;
        this.spannableFactory = new SpannableFactory();
        $jacocoInit[13] = true;
        this.overlay = view.findViewById(C1375R.C1376id.fragment_payment_overlay);
        $jacocoInit[14] = true;
        this.scroll = (ScrollView) view.findViewById(C1375R.C1376id.fragment_payment_scroll);
        $jacocoInit[15] = true;
        this.progressView = view.findViewById(C1375R.C1376id.fragment_payment_global_progress_bar);
        $jacocoInit[16] = true;
        this.noPaymentsText = (TextView) view.findViewById(C1375R.C1376id.fragment_payment_no_payments_text);
        $jacocoInit[17] = true;
        this.productIcon = (ImageView) view.findViewById(C1375R.C1376id.include_payment_product_icon);
        $jacocoInit[18] = true;
        this.productName = (TextView) view.findViewById(C1375R.C1376id.include_payment_product_name);
        $jacocoInit[19] = true;
        this.productDescription = (TextView) view.findViewById(C1375R.C1376id.include_payment_product_description);
        $jacocoInit[20] = true;
        this.productPrice = (TextView) view.findViewById(C1375R.C1376id.include_payment_product_price);
        $jacocoInit[21] = true;
        this.serviceRadioGroup = (RadioGroup) view.findViewById(C1375R.C1376id.fragment_payment_list);
        $jacocoInit[22] = true;
        this.cancelButton = (Button) view.findViewById(C1375R.C1376id.include_payment_buttons_cancel_button);
        $jacocoInit[23] = true;
        this.buyButton = (Button) view.findViewById(C1375R.C1376id.include_payment_buttons_buy_button);
        $jacocoInit[24] = true;
        Builder message = new Builder(getContext()).setMessage(C1375R.string.connection_error);
        $jacocoInit[25] = true;
        Builder positiveButton = message.setPositiveButton(17039370);
        $jacocoInit[26] = true;
        this.networkErrorDialog = positiveButton.build();
        $jacocoInit[27] = true;
        Builder message2 = new Builder(getContext()).setMessage(C1375R.string.all_message_general_error);
        $jacocoInit[28] = true;
        Builder positiveButton2 = message2.setPositiveButton(17039370);
        $jacocoInit[29] = true;
        this.unknownErrorDialog = positiveButton2.build();
        Billing billing2 = this.billing;
        BillingNavigator billingNavigator2 = this.billingNavigator;
        BillingAnalytics billingAnalytics2 = this.billingAnalytics;
        $jacocoInit[30] = true;
        String string = getArguments().getString(BillingActivity.EXTRA_MERCHANT_NAME);
        $jacocoInit[31] = true;
        String string2 = getArguments().getString(BillingActivity.EXTRA_SKU);
        $jacocoInit[32] = true;
        PaymentPresenter paymentPresenter = new PaymentPresenter(this, billing2, billingNavigator2, billingAnalytics2, string, string2, getArguments().getString(BillingActivity.EXTRA_DEVELOPER_PAYLOAD), new HashSet());
        $jacocoInit[33] = true;
        attachPresenter(paymentPresenter);
        $jacocoInit[34] = true;
    }

    public ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[35] = true;
        String simpleName = cls.getSimpleName();
        $jacocoInit[36] = true;
        ScreenTagHistory build = ScreenTagHistory.Builder.build(simpleName);
        $jacocoInit[37] = true;
        return build;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        View inflate = inflater.inflate(C1375R.layout.fragment_payment, container, false);
        $jacocoInit[38] = true;
        return inflate;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.scroll = null;
        this.spannableFactory = null;
        this.overlay = null;
        this.progressView = null;
        this.noPaymentsText = null;
        this.productIcon = null;
        this.productName = null;
        this.productDescription = null;
        this.productPrice = null;
        this.serviceRadioGroup = null;
        this.cancelButton = null;
        this.buyButton = null;
        $jacocoInit[39] = true;
        this.networkErrorDialog.dismiss();
        this.networkErrorDialog = null;
        $jacocoInit[40] = true;
        this.unknownErrorDialog.dismiss();
        this.unknownErrorDialog = null;
        this.paymentLoading = false;
        this.transactionLoading = false;
        this.buyLoading = false;
        $jacocoInit[41] = true;
        super.onDestroyView();
        $jacocoInit[42] = true;
    }

    public C0120S<String> selectServiceEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13049d.m42501a(this.serviceRadioGroup);
        C2578a aVar = C2578a.f5739a;
        $jacocoInit[43] = true;
        C0120S d = a.mo3653d((C0132p<? super T, Boolean>) aVar);
        C2580b bVar = new C2580b(this);
        $jacocoInit[44] = true;
        C0120S<String> j = d.mo3669j(bVar);
        $jacocoInit[45] = true;
        return j;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7218a(Integer serviceId) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (serviceId.intValue() != -1) {
            $jacocoInit[119] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[120] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[121] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ String mo11431b(Integer serviceId) {
        boolean[] $jacocoInit = $jacocoInit();
        String generateServiceId = this.billingIdManager.generateServiceId((long) serviceId.intValue());
        $jacocoInit[118] = true;
        return generateServiceId;
    }

    public C0120S<Void> cancelEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S b = C0120S.m649b(C13034a.m42490a(this.cancelButton), C13034a.m42490a(this.overlay));
        $jacocoInit[46] = true;
        C0120S b2 = b.mo3634b(C14522a.m46170a());
        $jacocoInit[47] = true;
        C0120S<Void> c = b2.mo3643c(C14522a.m46170a());
        $jacocoInit[48] = true;
        return c;
    }

    public C0120S<Void> buyEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.buyButton);
        $jacocoInit[49] = true;
        C0120S b = a.mo3634b(C14522a.m46170a());
        $jacocoInit[50] = true;
        C0120S<Void> c = b.mo3643c(C14522a.m46170a());
        $jacocoInit[51] = true;
        return c;
    }

    public void showPaymentLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        this.paymentLoading = true;
        $jacocoInit[52] = true;
        this.progressView.setVisibility(0);
        $jacocoInit[53] = true;
    }

    public void showPurchaseLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        this.transactionLoading = true;
        $jacocoInit[54] = true;
        this.progressView.setVisibility(0);
        $jacocoInit[55] = true;
    }

    public void showBuyLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        this.buyLoading = true;
        $jacocoInit[56] = true;
        this.progressView.setVisibility(0);
        $jacocoInit[57] = true;
    }

    public void showPayments(List<PaymentService> services, PaymentService selectedService) {
        CharSequence radioText;
        boolean[] $jacocoInit = $jacocoInit();
        this.serviceRadioGroup.removeAllViews();
        $jacocoInit[58] = true;
        this.noPaymentsText.setVisibility(8);
        $jacocoInit[59] = true;
        this.buyButton.setVisibility(0);
        $jacocoInit[60] = true;
        $jacocoInit[61] = true;
        for (PaymentService service : services) {
            $jacocoInit[62] = true;
            LayoutInflater layoutInflater = getActivity().getLayoutInflater();
            RadioGroup radioGroup = this.serviceRadioGroup;
            $jacocoInit[63] = true;
            RadioButton radioButton = (RadioButton) layoutInflater.inflate(C1375R.layout.payment_item, radioGroup, false);
            $jacocoInit[64] = true;
            radioButton.setId((int) this.billingIdManager.resolveServiceId(service.getId()));
            $jacocoInit[65] = true;
            C6354n a = C5926c.m10917a((Fragment) this);
            $jacocoInit[66] = true;
            C6029k a2 = a.mo19318a(service.getIcon());
            $jacocoInit[67] = true;
            a2.mo18832a(new RadioButtonTarget(ScreenU.getPixelsForDip(16, getResources()), radioButton));
            $jacocoInit[68] = true;
            if (TextUtils.isEmpty(service.getDescription())) {
                $jacocoInit[69] = true;
                radioText = service.getName();
                $jacocoInit[70] = true;
            } else {
                SpannableFactory spannableFactory2 = this.spannableFactory;
                Context context = getContext();
                StringBuilder sb = new StringBuilder();
                $jacocoInit[71] = true;
                sb.append(service.getName());
                sb.append("\n");
                sb.append(service.getDescription());
                String sb2 = sb.toString();
                String[] strArr = {service.getDescription()};
                $jacocoInit[72] = true;
                radioText = spannableFactory2.createTextAppearanceSpan(context, C1375R.style.TextAppearance_Aptoide_Caption, sb2, strArr);
                $jacocoInit[73] = true;
            }
            radioButton.setText(radioText);
            $jacocoInit[74] = true;
            String id = selectedService.getId();
            $jacocoInit[75] = true;
            boolean equals = id.equals(service.getId());
            $jacocoInit[76] = true;
            radioButton.setChecked(equals);
            $jacocoInit[77] = true;
            this.serviceRadioGroup.addView(radioButton);
            $jacocoInit[78] = true;
        }
        $jacocoInit[79] = true;
    }

    public void showProduct(Product product) {
        boolean[] $jacocoInit = $jacocoInit();
        ImageLoader with = ImageLoader.with(getContext());
        $jacocoInit[80] = true;
        with.load(product.getIcon(), this.productIcon);
        $jacocoInit[81] = true;
        this.productName.setText(product.getTitle());
        $jacocoInit[82] = true;
        this.productDescription.setText(product.getDescription());
        $jacocoInit[83] = true;
        TextView textView = this.productPrice;
        StringBuilder sb = new StringBuilder();
        Price price = product.getPrice();
        $jacocoInit[84] = true;
        sb.append(price.getCurrencySymbol());
        sb.append(" ");
        Price price2 = product.getPrice();
        $jacocoInit[85] = true;
        sb.append(price2.getAmount());
        String sb2 = sb.toString();
        $jacocoInit[86] = true;
        textView.setText(sb2);
        $jacocoInit[87] = true;
    }

    public void hidePaymentLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        this.paymentLoading = false;
        if (this.transactionLoading) {
            $jacocoInit[88] = true;
        } else if (this.buyLoading) {
            $jacocoInit[89] = true;
        } else {
            $jacocoInit[90] = true;
            this.progressView.setVisibility(8);
            $jacocoInit[91] = true;
        }
        $jacocoInit[92] = true;
    }

    public void hidePurchaseLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.transactionLoading) {
            $jacocoInit[93] = true;
        } else {
            $jacocoInit[94] = true;
            this.scroll.postDelayed(new Runnable(this) {
                private static transient /* synthetic */ boolean[] $jacocoData;
                final /* synthetic */ PaymentFragment this$0;

                private static /* synthetic */ boolean[] $jacocoInit() {
                    boolean[] zArr = $jacocoData;
                    if (zArr != null) {
                        return zArr;
                    }
                    boolean[] probes = Offline.getProbes(-5641981235149775472L, "cm/aptoide/pt/billing/view/payment/PaymentFragment$1", 5);
                    $jacocoData = probes;
                    return probes;
                }

                {
                    boolean[] $jacocoInit = $jacocoInit();
                    this.this$0 = this$0;
                    $jacocoInit[0] = true;
                }

                public void run() {
                    boolean[] $jacocoInit = $jacocoInit();
                    if (PaymentFragment.access$000(this.this$0) == null) {
                        $jacocoInit[1] = true;
                    } else {
                        $jacocoInit[2] = true;
                        PaymentFragment.access$000(this.this$0).fullScroll(Opcodes.IXOR);
                        $jacocoInit[3] = true;
                    }
                    $jacocoInit[4] = true;
                }
            }, 500);
            $jacocoInit[95] = true;
        }
        this.transactionLoading = false;
        if (this.paymentLoading) {
            $jacocoInit[96] = true;
        } else if (this.buyLoading) {
            $jacocoInit[97] = true;
        } else {
            $jacocoInit[98] = true;
            this.progressView.setVisibility(8);
            $jacocoInit[99] = true;
        }
        $jacocoInit[100] = true;
    }

    public void hideBuyLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        this.buyLoading = false;
        if (this.paymentLoading) {
            $jacocoInit[101] = true;
        } else if (this.transactionLoading) {
            $jacocoInit[102] = true;
        } else {
            $jacocoInit[103] = true;
            this.progressView.setVisibility(8);
            $jacocoInit[104] = true;
        }
        $jacocoInit[105] = true;
    }

    public void showPaymentsNotFoundMessage() {
        boolean[] $jacocoInit = $jacocoInit();
        this.noPaymentsText.setVisibility(0);
        $jacocoInit[106] = true;
        this.buyButton.setVisibility(8);
        $jacocoInit[107] = true;
    }

    public void showNetworkError() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.networkErrorDialog.isShowing()) {
            $jacocoInit[108] = true;
        } else if (this.unknownErrorDialog.isShowing()) {
            $jacocoInit[109] = true;
        } else {
            $jacocoInit[110] = true;
            this.networkErrorDialog.show();
            $jacocoInit[111] = true;
        }
        $jacocoInit[112] = true;
    }

    public void showUnknownError() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.networkErrorDialog.isShowing()) {
            $jacocoInit[113] = true;
        } else if (this.unknownErrorDialog.isShowing()) {
            $jacocoInit[114] = true;
        } else {
            $jacocoInit[115] = true;
            this.unknownErrorDialog.show();
            $jacocoInit[116] = true;
        }
        $jacocoInit[117] = true;
    }
}
