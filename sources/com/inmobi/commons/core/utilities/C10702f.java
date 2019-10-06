package com.inmobi.commons.core.utilities;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;
import com.inmobi.commons.p217a.C10619a;

/* renamed from: com.inmobi.commons.core.utilities.f */
/* compiled from: PlayServicesUtils */
public final class C10702f {

    /* renamed from: a */
    private static final String f32657a = C10702f.class.getSimpleName();

    /* renamed from: a */
    public static boolean m35151a(String str) {
        Context b = C10619a.m34839b();
        if (b == null) {
            return false;
        }
        try {
            if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(b) == 0) {
                return true;
            }
            return false;
        } catch (NoClassDefFoundError e) {
            return false;
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder("Error in connecting to GooglePlayServices API for component ");
            sb.append(str);
            sb.append(" : (");
            sb.append(e2.getMessage());
            sb.append(")");
            return false;
        }
    }
}
