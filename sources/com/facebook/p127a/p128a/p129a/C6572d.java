package com.facebook.p127a.p128a.p129a;

import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;

/* renamed from: com.facebook.a.a.a.d */
/* compiled from: SensitiveUserDataUtils */
public class C6572d {
    /* renamed from: a */
    public static boolean m13010a(View view) {
        boolean z = false;
        if (!(view instanceof TextView)) {
            return false;
        }
        TextView textView = (TextView) view;
        if (m13013c(textView) || m13011a(textView) || m13014d(textView) || m13016f(textView) || m13015e(textView) || m13012b(textView)) {
            z = true;
        }
        return z;
    }

    /* renamed from: c */
    private static boolean m13013c(TextView view) {
        if (view.getInputType() == 128) {
            return true;
        }
        return view.getTransformationMethod() instanceof PasswordTransformationMethod;
    }

    /* renamed from: b */
    private static boolean m13012b(TextView view) {
        if (view.getInputType() == 32) {
            return true;
        }
        String text = C6574f.m13030g(view);
        if (text == null || text.length() == 0) {
            return false;
        }
        return Patterns.EMAIL_ADDRESS.matcher(text).matches();
    }

    /* renamed from: d */
    private static boolean m13014d(TextView view) {
        return view.getInputType() == 96;
    }

    /* renamed from: f */
    private static boolean m13016f(TextView view) {
        return view.getInputType() == 112;
    }

    /* renamed from: e */
    private static boolean m13015e(TextView view) {
        return view.getInputType() == 3;
    }

    /* renamed from: a */
    private static boolean m13011a(TextView view) {
        String ccNumber = C6574f.m13030g(view).replaceAll("\\s", "");
        int length = ccNumber.length();
        boolean z = false;
        if (length < 12 || length > 19) {
            return false;
        }
        int sum = 0;
        boolean alternate = false;
        int i = length - 1;
        while (true) {
            boolean z2 = true;
            if (i >= 0) {
                char digit = ccNumber.charAt(i);
                if (digit < '0' || digit > '9') {
                    return false;
                }
                int n = digit - '0';
                if (alternate) {
                    n *= 2;
                    if (n > 9) {
                        n = (n % 10) + 1;
                    }
                }
                sum += n;
                if (alternate) {
                    z2 = false;
                }
                alternate = z2;
                i--;
            } else {
                if (sum % 10 == 0) {
                    z = true;
                }
                return z;
            }
        }
        return false;
    }
}
