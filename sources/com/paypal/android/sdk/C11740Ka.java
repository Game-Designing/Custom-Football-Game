package com.paypal.android.sdk;

/* renamed from: com.paypal.android.sdk.Ka */
public enum C11740Ka {
    FptiRequest(C11819fa.POST, null),
    PreAuthRequest(C11819fa.POST, "oauth2/token"),
    LoginRequest(C11819fa.POST, "oauth2/login"),
    LoginChallengeRequest(C11819fa.POST, "oauth2/login/challenge"),
    ConsentRequest(C11819fa.POST, "oauth2/consent"),
    CreditCardPaymentRequest(C11819fa.POST, r7),
    PayPalPaymentRequest(C11819fa.POST, r7),
    CreateSfoPaymentRequest(C11819fa.POST, "orchestration/msdk-create-sfo-payment"),
    ApproveAndExecuteSfoPaymentRequest(C11819fa.POST, "orchestration/msdk-approve-and-execute-sfo-payment"),
    TokenizeCreditCardRequest(C11819fa.POST, r11),
    DeleteCreditCardRequest(C11819fa.DELETE, r11),
    GetAppInfoRequest(C11819fa.GET, "apis/applications");
    

    /* renamed from: n */
    private C11819fa f36727n;

    /* renamed from: o */
    private String f36728o;

    private C11740Ka(C11819fa faVar, String str) {
        this.f36727n = faVar;
        this.f36728o = str;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final C11819fa mo38581a() {
        return this.f36727n;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final String mo38582b() {
        return this.f36728o;
    }
}
