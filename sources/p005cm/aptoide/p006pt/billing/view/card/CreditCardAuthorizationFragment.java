package p005cm.aptoide.p006pt.billing.view.card;

import adyen.com.adyencse.encrypter.exception.EncrypterException;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.braintreepayments.cardform.view.CardForm;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.billing.Billing;
import p005cm.aptoide.p006pt.billing.BillingAnalytics;
import p005cm.aptoide.p006pt.billing.payment.Adyen;
import p005cm.aptoide.p006pt.billing.product.Product;
import p005cm.aptoide.p006pt.billing.view.BillingActivity;
import p005cm.aptoide.p006pt.billing.view.BillingNavigator;
import p005cm.aptoide.p006pt.navigator.ActivityResultNavigator;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.permission.PermissionServiceFragment;
import p005cm.aptoide.p006pt.view.BackButton.ClickHandler;
import p005cm.aptoide.p006pt.view.p080rx.RxAlertDialog;
import p005cm.aptoide.p006pt.view.p080rx.RxAlertDialog.Builder;
import p019d.p022i.p023b.C0100e;
import p019d.p022i.p296a.p305c.C13034a;
import p019d.p135a.p136a.p139c.C6878a;
import p019d.p135a.p136a.p139c.C6889d;
import p019d.p135a.p136a.p139c.p140a.C6879a;
import p019d.p135a.p136a.p139c.p140a.C6884d;
import p019d.p135a.p136a.p142e.C6901a;
import p019d.p135a.p136a.p142e.C6912j;
import p026rx.C0120S;
import p026rx.p387a.p389b.C14522a;
import p030a.p031a.p032a.p033a.C0138a;

/* renamed from: cm.aptoide.pt.billing.view.card.CreditCardAuthorizationFragment */
public class CreditCardAuthorizationFragment extends PermissionServiceFragment implements CreditCardAuthorizationView {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static final String TAG = CreditCardAuthorizationFragment.class.getSimpleName();

    /* renamed from: adyen reason: collision with root package name */
    private Adyen f44401adyen;
    private BillingAnalytics analytics;
    private C0100e<Void> backButton;
    private Billing billing;
    private Button buyButton;
    private Button cancelButton;
    private CardForm cardForm;
    private ClickHandler clickHandler;
    private boolean cvcOnly;
    private String generationTime;
    private C0100e<Void> keyboardBuyRelay;
    private BillingNavigator navigator;
    private RxAlertDialog networkErrorDialog;
    private View overlay;
    private C6889d paymentMethod;
    private TextView preAuthorizedCardText;
    private TextView productDescription;
    private ImageView productIcon;
    private TextView productName;
    private TextView productPrice;
    private View progressBar;
    private String publicKey;
    private CheckBox rememberCardCheckBox;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5588281954920650315L, "cm/aptoide/pt/billing/view/card/CreditCardAuthorizationFragment", 115);
        $jacocoData = probes;
        return probes;
    }

    public CreditCardAuthorizationFragment() {
        $jacocoInit()[0] = true;
    }

    static /* synthetic */ C0100e access$000(CreditCardAuthorizationFragment x0) {
        boolean[] $jacocoInit = $jacocoInit();
        C0100e<Void> eVar = x0.backButton;
        $jacocoInit[113] = true;
        return eVar;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[114] = true;
    }

    public static CreditCardAuthorizationFragment create(Bundle bundle) {
        boolean[] $jacocoInit = $jacocoInit();
        CreditCardAuthorizationFragment fragment = new CreditCardAuthorizationFragment();
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
        String string = getArguments().getString(BillingActivity.EXTRA_MERCHANT_NAME);
        $jacocoInit[5] = true;
        this.billing = aptoideApplication.getBilling(string);
        $jacocoInit[6] = true;
        this.navigator = ((ActivityResultNavigator) getActivity()).getBillingNavigator();
        $jacocoInit[7] = true;
        this.analytics = ((AptoideApplication) getContext().getApplicationContext()).getBillingAnalytics();
        $jacocoInit[8] = true;
        this.backButton = C0100e.m565o();
        $jacocoInit[9] = true;
        this.keyboardBuyRelay = C0100e.m565o();
        $jacocoInit[10] = true;
        this.f44401adyen = ((AptoideApplication) getContext().getApplicationContext()).getAdyen();
        $jacocoInit[11] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        $jacocoInit[12] = true;
        this.preAuthorizedCardText = (TextView) view.findViewById(C1375R.C1376id.fragment_credit_card_authorization_pre_authorized_card);
        $jacocoInit[13] = true;
        this.progressBar = view.findViewById(C1375R.C1376id.fragment_credit_card_authorization_progress_bar);
        $jacocoInit[14] = true;
        this.overlay = view.findViewById(C1375R.C1376id.fragment_credit_card_authorization_overlay);
        $jacocoInit[15] = true;
        this.productIcon = (ImageView) view.findViewById(C1375R.C1376id.include_payment_product_icon);
        $jacocoInit[16] = true;
        this.productName = (TextView) view.findViewById(C1375R.C1376id.include_payment_product_name);
        $jacocoInit[17] = true;
        this.productDescription = (TextView) view.findViewById(C1375R.C1376id.include_payment_product_description);
        $jacocoInit[18] = true;
        this.productPrice = (TextView) view.findViewById(C1375R.C1376id.include_payment_product_price);
        $jacocoInit[19] = true;
        this.cancelButton = (Button) view.findViewById(C1375R.C1376id.include_payment_buttons_cancel_button);
        $jacocoInit[20] = true;
        this.buyButton = (Button) view.findViewById(C1375R.C1376id.include_payment_buttons_buy_button);
        $jacocoInit[21] = true;
        this.rememberCardCheckBox = (CheckBox) view.findViewById(C1375R.C1376id.fragment_credit_card_authorization_remember_card_check_box);
        $jacocoInit[22] = true;
        this.buyButton.setVisibility(8);
        $jacocoInit[23] = true;
        this.cardForm = (CardForm) view.findViewById(C1375R.C1376id.fragment_braintree_credit_card_form);
        $jacocoInit[24] = true;
        Builder message = new Builder(getContext()).setMessage(C1375R.string.connection_error);
        $jacocoInit[25] = true;
        Builder positiveButton = message.setPositiveButton(C1375R.string.iab_button_ok);
        $jacocoInit[26] = true;
        this.networkErrorDialog = positiveButton.build();
        $jacocoInit[27] = true;
        this.clickHandler = new ClickHandler(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ CreditCardAuthorizationFragment this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(3444772340547478592L, "cm/aptoide/pt/billing/view/card/CreditCardAuthorizationFragment$1", 2);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public boolean handle() {
                boolean[] $jacocoInit = $jacocoInit();
                CreditCardAuthorizationFragment.access$000(this.this$0).call(null);
                $jacocoInit[1] = true;
                return true;
            }
        };
        $jacocoInit[28] = true;
        registerClickHandler(this.clickHandler);
        $jacocoInit[29] = true;
        this.cardForm.setOnCardFormValidListener(new C2412b(this));
        $jacocoInit[30] = true;
        this.cardForm.setOnCardFormSubmitListener(new C2414c(this));
        $jacocoInit[31] = true;
        String string = getArguments().getString(BillingActivity.EXTRA_SKU);
        Billing billing2 = this.billing;
        BillingNavigator billingNavigator = this.navigator;
        BillingAnalytics billingAnalytics = this.analytics;
        $jacocoInit[32] = true;
        String string2 = getArguments().getString(BillingActivity.EXTRA_SERVICE_NAME);
        Adyen adyen2 = this.f44401adyen;
        $jacocoInit[33] = true;
        CreditCardAuthorizationPresenter creditCardAuthorizationPresenter = new CreditCardAuthorizationPresenter(this, string, billing2, billingNavigator, billingAnalytics, string2, adyen2, C14522a.m46170a());
        $jacocoInit[34] = true;
        attachPresenter(creditCardAuthorizationPresenter);
        $jacocoInit[35] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11284a(boolean valid) {
        boolean[] $jacocoInit = $jacocoInit();
        if (valid) {
            $jacocoInit[109] = true;
            this.buyButton.setVisibility(0);
            $jacocoInit[110] = true;
        } else {
            this.buyButton.setVisibility(8);
            $jacocoInit[111] = true;
        }
        $jacocoInit[112] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo11285b() {
        boolean[] $jacocoInit = $jacocoInit();
        this.keyboardBuyRelay.call(null);
        $jacocoInit[108] = true;
    }

    public ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[36] = true;
        String simpleName = cls.getSimpleName();
        $jacocoInit[37] = true;
        ScreenTagHistory build = ScreenTagHistory.Builder.build(simpleName);
        $jacocoInit[38] = true;
        return build;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        View inflate = inflater.inflate(C1375R.layout.fragment_credit_card_authorization, container, false);
        $jacocoInit[39] = true;
        return inflate;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        unregisterClickHandler(this.clickHandler);
        this.progressBar = null;
        $jacocoInit[40] = true;
        this.networkErrorDialog.dismiss();
        this.networkErrorDialog = null;
        this.overlay = null;
        this.productIcon = null;
        this.productName = null;
        this.productDescription = null;
        this.productPrice = null;
        this.cancelButton = null;
        this.rememberCardCheckBox = null;
        this.buyButton = null;
        this.preAuthorizedCardText = null;
        $jacocoInit[41] = true;
        this.cardForm.setOnCardFormSubmitListener(null);
        $jacocoInit[42] = true;
        this.cardForm.setOnCardFormValidListener(null);
        this.cardForm = null;
        $jacocoInit[43] = true;
        super.onDestroyView();
        $jacocoInit[44] = true;
    }

    public void showProduct(Product product) {
        boolean[] $jacocoInit = $jacocoInit();
        ImageLoader with = ImageLoader.with(getContext());
        $jacocoInit[45] = true;
        with.load(product.getIcon(), this.productIcon);
        $jacocoInit[46] = true;
        this.productName.setText(product.getTitle());
        $jacocoInit[47] = true;
        this.productDescription.setText(product.getDescription());
        $jacocoInit[48] = true;
    }

    public void showLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        this.progressBar.setVisibility(0);
        $jacocoInit[49] = true;
    }

    public void hideLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        this.progressBar.setVisibility(8);
        $jacocoInit[50] = true;
    }

    public C0120S<Void> errorDismisses() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S dismisses = this.networkErrorDialog.dismisses();
        C2410a aVar = C2410a.f5573a;
        $jacocoInit[51] = true;
        C0120S<Void> j = dismisses.mo3669j(aVar);
        $jacocoInit[52] = true;
        return j;
    }

    /* renamed from: a */
    static /* synthetic */ Void m7052a(DialogInterface dialogInterface) {
        $jacocoInit()[107] = true;
        return null;
    }

    public C0120S<C6884d> creditCardDetailsEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S b = C0120S.m649b((C0120S<? extends T>) this.keyboardBuyRelay, C13034a.m42490a(this.buyButton));
        C2416d dVar = new C2416d(this);
        $jacocoInit[53] = true;
        C0120S<C6884d> j = b.mo3669j(dVar);
        $jacocoInit[54] = true;
        return j;
    }

    /* renamed from: a */
    public /* synthetic */ C6884d mo11283a(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        C6884d paymentDetails = getPaymentDetails(this.publicKey, this.generationTime);
        $jacocoInit[106] = true;
        return paymentDetails;
    }

    public void showNetworkError() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.networkErrorDialog.isShowing()) {
            $jacocoInit[55] = true;
        } else {
            $jacocoInit[56] = true;
            this.networkErrorDialog.show();
            $jacocoInit[57] = true;
        }
        $jacocoInit[58] = true;
    }

    public C0120S<Void> cancelEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C0120S.m637a(C13034a.m42490a(this.cancelButton), C13034a.m42490a(this.overlay), (C0120S<? extends T>) this.backButton);
        $jacocoInit[59] = true;
        return a;
    }

    public void showCvcView(C6878a amount, C6889d paymentMethod2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.cvcOnly = true;
        this.paymentMethod = paymentMethod2;
        $jacocoInit[60] = true;
        showProductPrice(amount);
        $jacocoInit[61] = true;
        this.preAuthorizedCardText.setVisibility(0);
        $jacocoInit[62] = true;
        this.preAuthorizedCardText.setText(paymentMethod2.mo22331e());
        $jacocoInit[63] = true;
        this.rememberCardCheckBox.setVisibility(8);
        $jacocoInit[64] = true;
        CardForm a = this.cardForm.mo18434a(false);
        $jacocoInit[65] = true;
        CardForm c = a.mo18439c(false);
        $jacocoInit[66] = true;
        CardForm b = c.mo18437b(true);
        $jacocoInit[67] = true;
        CardForm e = b.mo18441e(false);
        $jacocoInit[68] = true;
        CardForm d = e.mo18440d(false);
        $jacocoInit[69] = true;
        CardForm b2 = d.mo18436b(getString(C1375R.string.buy));
        $jacocoInit[70] = true;
        b2.setup(getActivity());
        $jacocoInit[71] = true;
    }

    public void showCreditCardView(C6889d paymentMethod2, C6878a amount, boolean cvcRequired, boolean allowSave, String publicKey2, String generationTime2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.paymentMethod = paymentMethod2;
        this.publicKey = publicKey2;
        this.generationTime = generationTime2;
        this.cvcOnly = false;
        $jacocoInit[72] = true;
        this.preAuthorizedCardText.setVisibility(8);
        $jacocoInit[73] = true;
        this.rememberCardCheckBox.setVisibility(0);
        $jacocoInit[74] = true;
        showProductPrice(amount);
        $jacocoInit[75] = true;
        CardForm a = this.cardForm.mo18434a(true);
        $jacocoInit[76] = true;
        CardForm c = a.mo18439c(true);
        $jacocoInit[77] = true;
        CardForm b = c.mo18437b(cvcRequired);
        $jacocoInit[78] = true;
        CardForm e = b.mo18441e(false);
        $jacocoInit[79] = true;
        CardForm d = e.mo18440d(false);
        $jacocoInit[80] = true;
        CardForm b2 = d.mo18436b(getString(C1375R.string.buy));
        $jacocoInit[81] = true;
        b2.setup(getActivity());
        $jacocoInit[82] = true;
    }

    private void showProductPrice(C6878a amount) {
        boolean[] $jacocoInit = $jacocoInit();
        TextView textView = this.productPrice;
        $jacocoInit[83] = true;
        String a = C6901a.m14038a(amount, true, C6912j.m14059a((Context) getActivity()));
        $jacocoInit[84] = true;
        textView.setText(a);
        $jacocoInit[85] = true;
    }

    private C6884d getPaymentDetails(String publicKey2, String generationTime2) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.cvcOnly) {
            $jacocoInit[86] = true;
            C6884d paymentDetails = new C6884d(this.paymentMethod.mo22327b());
            $jacocoInit[87] = true;
            paymentDetails.mo22320a("cardDetails.cvc", this.cardForm.getCvv());
            $jacocoInit[88] = true;
            return paymentDetails;
        }
        C6889d dVar = this.paymentMethod;
        $jacocoInit[89] = true;
        C6879a creditCardPaymentDetails = new C6879a(dVar.mo22327b());
        try {
            $jacocoInit[90] = true;
            try {
                JSONObject sensitiveData = new JSONObject();
                $jacocoInit[91] = true;
                sensitiveData.put("holderName", "Checkout Shopper Placeholder");
                $jacocoInit[92] = true;
                sensitiveData.put("number", this.cardForm.getCardNumber());
                $jacocoInit[93] = true;
                sensitiveData.put("expiryMonth", this.cardForm.getExpirationMonth());
                $jacocoInit[94] = true;
                sensitiveData.put("expiryYear", this.cardForm.getExpirationYear());
                $jacocoInit[95] = true;
                sensitiveData.put("generationtime", generationTime2);
                $jacocoInit[96] = true;
                sensitiveData.put("cvc", this.cardForm.getCvv());
                $jacocoInit[97] = true;
                C0138a aVar = new C0138a(publicKey2);
                $jacocoInit[98] = true;
                String a = aVar.mo3720a(sensitiveData.toString());
                $jacocoInit[99] = true;
                creditCardPaymentDetails.mo22302a(a);
                $jacocoInit[100] = true;
            } catch (JSONException e) {
                e = e;
                $jacocoInit[101] = true;
                Log.e(TAG, "JSON Exception occurred while generating token.", e);
                $jacocoInit[102] = true;
                creditCardPaymentDetails.mo22304a(this.rememberCardCheckBox.isChecked());
                $jacocoInit[105] = true;
                return creditCardPaymentDetails;
            } catch (EncrypterException e2) {
                e = e2;
                $jacocoInit[103] = true;
                Log.e(TAG, "EncrypterException occurred while generating token.", e);
                $jacocoInit[104] = true;
                creditCardPaymentDetails.mo22304a(this.rememberCardCheckBox.isChecked());
                $jacocoInit[105] = true;
                return creditCardPaymentDetails;
            }
        } catch (JSONException e3) {
            e = e3;
            $jacocoInit[101] = true;
            Log.e(TAG, "JSON Exception occurred while generating token.", e);
            $jacocoInit[102] = true;
            creditCardPaymentDetails.mo22304a(this.rememberCardCheckBox.isChecked());
            $jacocoInit[105] = true;
            return creditCardPaymentDetails;
        } catch (EncrypterException e4) {
            e = e4;
            $jacocoInit[103] = true;
            Log.e(TAG, "EncrypterException occurred while generating token.", e);
            $jacocoInit[104] = true;
            creditCardPaymentDetails.mo22304a(this.rememberCardCheckBox.isChecked());
            $jacocoInit[105] = true;
            return creditCardPaymentDetails;
        }
        creditCardPaymentDetails.mo22304a(this.rememberCardCheckBox.isChecked());
        $jacocoInit[105] = true;
        return creditCardPaymentDetails;
    }
}
