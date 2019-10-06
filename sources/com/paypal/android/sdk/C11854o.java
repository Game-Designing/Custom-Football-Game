package com.paypal.android.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.List;

/* renamed from: com.paypal.android.sdk.o */
public class C11854o extends C11838k {

    /* renamed from: b */
    private static final String f37281b = C11854o.class.getSimpleName();

    /* renamed from: a */
    protected static Intent m39206a(String str, String str2) {
        Intent intent = new Intent(str);
        intent.setComponent(ComponentName.unflattenFromString(str2));
        intent.setPackage("com.paypal.android.p2pmobile");
        return intent;
    }

    /* renamed from: a */
    public final boolean mo38826a(Context context, String str, String str2) {
        boolean z = false;
        List queryIntentActivities = context.getPackageManager().queryIntentActivities(m39206a(str, str2), 0);
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            z = true;
        }
        if (!z) {
            StringBuilder sb = new StringBuilder("PayPal wallet app will not accept intent to: [action:");
            sb.append(str);
            sb.append(", class:");
            sb.append(str2);
            sb.append("]");
        }
        return z;
    }

    /* renamed from: a */
    public final boolean mo38827a(Context context, boolean z) {
        return mo38808a(context, z, "com.paypal.android.p2pmobile", "O=Paypal", "O=Paypal", 34172764);
    }
}
