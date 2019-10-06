package com.paypal.android.sdk;

/* renamed from: com.paypal.android.sdk.zb */
public abstract class C12032zb extends C12031za {
    public C12032zb(C11740Ka ka, C11707Ba ba, C11706B b, String str) {
        C11731Ha ha = new C11731Ha(ka);
        StringBuilder sb = new StringBuilder("Bearer ");
        sb.append(str);
        super(ha, ba, b, sb.toString());
        String str2 = "application/json";
        mo38500a("Content-Type", str2);
        mo38500a("Accept", str2);
    }
}
