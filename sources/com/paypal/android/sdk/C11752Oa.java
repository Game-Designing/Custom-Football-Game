package com.paypal.android.sdk;

import java.util.Collection;

/* renamed from: com.paypal.android.sdk.Oa */
public enum C11752Oa {
    GET_FUNDING_OPTIONS("https://uri.paypal.com/services/payments/funding-options"),
    PAYMENT_CODE("https://uri.paypal.com/services/pos/payments"),
    MIS_CUSTOMER("https://uri.paypal.com/services/mis/customer"),
    FINANCIAL_INSTRUMENTS("https://uri.paypal.com/services/wallet/financial-instruments/view"),
    SEND_MONEY("https://uri.paypal.com/services/wallet/sendmoney"),
    REQUEST_MONEY("https://uri.paypal.com/services/wallet/money-request/requests"),
    LOYALTY("https://uri.paypal.com/services/loyalty/memberships/update"),
    EXPRESS_CHECKOUT("https://uri.paypal.com/services/expresscheckout");
    

    /* renamed from: i */
    public static final Collection f36867i = null;

    /* renamed from: k */
    private String f36869k;

    static {
        f36867i = new C11755Pa();
    }

    private C11752Oa(String str) {
        this.f36869k = str;
    }

    /* renamed from: a */
    public final String mo38610a() {
        return this.f36869k;
    }
}
