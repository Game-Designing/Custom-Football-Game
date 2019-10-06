package com.paypal.android.sdk;

import p005cm.aptoide.p006pt.deprecated.tables.Repo;

/* renamed from: com.paypal.android.sdk.xb */
public enum C12024xb {
    PreConnect("preconnect", "", false, false),
    DeviceCheck("devicecheck", "", false, false),
    PaymentMethodWindow("selectpaymentmethod", "", false, false),
    PaymentMethodCancel("selectpaymentmethod", "cancel", false, true),
    SelectPayPalPayment("selectpaymentmethod", "paypal", false, true),
    SelectCreditCardPayment("selectpaymentmethod", "card", false, true),
    ConfirmPaymentWindow("confirmpayment", "", false, false),
    ConfirmPayment("confirmpayment", "confirm", false, false),
    ConfirmPaymentCancel("confirmpayment", "cancel", false, true),
    PaymentSuccessful("paymentsuccessful", "", false, false),
    LoginWindow("login", Repo.COLUMN_PASSWORD, true, false),
    LoginPassword("login", Repo.COLUMN_PASSWORD, true, true),
    LoginPIN("login", "PIN", true, true),
    SignUp("login", Repo.COLUMN_PASSWORD, true, true),
    LoginForgotPassword("login", Repo.COLUMN_PASSWORD, true, true),
    LoginCancel("login", "cancel", true, true),
    ConsentWindow("authorizationconsent", "", false, false),
    ConsentAgree("authorizationconsent", "agree", false, true),
    ConsentCancel("authorizationconsent", "cancel", false, true),
    ConsentMerchantUrl("authorizationconsent", "merchanturl", false, true),
    ConsentPayPalPrivacyUrl("authorizationconsent", "privacy", false, true),
    AuthorizationSuccessful("authorizationsuccessful", "", false, false),
    LegalTextWindow("legaltext", "", false, false);
    

    /* renamed from: A */
    private boolean f37834A;

    /* renamed from: B */
    private boolean f37835B;

    /* renamed from: y */
    private String f37836y;

    /* renamed from: z */
    private String f37837z;

    private C12024xb(String str, String str2, boolean z, boolean z2) {
        this.f37836y = str;
        this.f37837z = str2;
        this.f37834A = z;
        this.f37835B = z2;
    }

    /* renamed from: a */
    public final String mo39210a() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f37836y);
        sb.append("::");
        sb.append(this.f37837z);
        return sb.toString();
    }

    /* renamed from: a */
    public final String mo39211a(String str, boolean z) {
        String str2 = this.f37834A ? z ? "returnuser" : "newuser" : "";
        StringBuilder sb = new StringBuilder();
        sb.append(C12020wb.f37802a);
        String str3 = ":";
        sb.append(str3);
        sb.append(str);
        sb.append(str3);
        sb.append(str2);
        return sb.toString();
    }

    /* renamed from: b */
    public final boolean mo39212b() {
        return this.f37835B;
    }
}
