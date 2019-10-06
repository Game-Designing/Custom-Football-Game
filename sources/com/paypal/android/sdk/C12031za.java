package com.paypal.android.sdk;

import android.text.TextUtils;

/* renamed from: com.paypal.android.sdk.za */
public abstract class C12031za extends C11703Aa {
    static {
        C12031za.class.getSimpleName();
    }

    public C12031za(C12027ya yaVar, C11707Ba ba, C11706B b, String str) {
        this(yaVar, ba, b, str, null);
    }

    public C12031za(C12027ya yaVar, C11707Ba ba, C11706B b, String str, String str2) {
        super(yaVar, ba, b, str2);
        if (!TextUtils.isEmpty(str)) {
            mo38500a("Authorization", str);
        }
    }
}
