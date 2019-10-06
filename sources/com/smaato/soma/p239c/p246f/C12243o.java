package com.smaato.soma.p239c.p246f;

import android.content.Context;
import android.preference.PreferenceManager;
import com.smaato.soma.p239c.p246f.p247a.C12212a;
import com.smaato.soma.p239c.p252i.C12280f;

/* renamed from: com.smaato.soma.c.f.o */
/* compiled from: GdprFetcher */
class C12243o {
    /* renamed from: d */
    static String m40289d(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("IABConsent_SubjectToGDPR", C12212a.CMPGDPRUnknown.mo39543e());
    }

    /* renamed from: b */
    static String m40286b(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("IABConsent_ConsentString", "");
    }

    /* renamed from: e */
    static String m40290e(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("IABConsent_ParsedVendorConsents", "");
    }

    /* renamed from: c */
    static String m40288c(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("IABConsent_ParsedPurposeConsents", "");
    }

    /* renamed from: b */
    static boolean m40287b(Context context, int vendorId) {
        String vendors = m40290e(context);
        return vendors.length() >= vendorId && m40283a(vendors.charAt(vendorId + -1));
    }

    /* renamed from: a */
    static boolean m40285a(Context context, int purposeIds) {
        String purposes = m40288c(context);
        return purposes.length() >= purposeIds && m40283a(purposes.charAt(purposeIds + -1));
    }

    /* renamed from: a */
    static boolean m40284a(Context context) {
        return !m40292g(context) && !m40291f(context);
    }

    /* renamed from: a */
    private static boolean m40283a(char value) {
        return '1' == value;
    }

    /* renamed from: f */
    private static boolean m40291f(Context context) {
        String purposes = m40288c(context);
        return C12280f.m40428a((CharSequence) purposes) || !purposes.matches("[01]+");
    }

    /* renamed from: g */
    private static boolean m40292g(Context context) {
        String vendors = m40290e(context);
        return C12280f.m40428a((CharSequence) vendors) || !vendors.matches("[01]+");
    }
}
