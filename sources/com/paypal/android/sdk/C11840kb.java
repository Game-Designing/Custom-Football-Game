package com.paypal.android.sdk;

import java.util.Comparator;
import java.util.Currency;

/* renamed from: com.paypal.android.sdk.kb */
final class C11840kb implements Comparator {
    C11840kb() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((Currency) obj).getCurrencyCode().compareTo(((Currency) obj2).getCurrencyCode());
    }
}
