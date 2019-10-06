package com.google.android.gms.common.logging;

import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;

@KeepForSdk
public class Logger {

    /* renamed from: a */
    private final String f20186a;

    /* renamed from: b */
    private final String f20187b;

    /* renamed from: c */
    private final GmsLogger f20188c;

    /* renamed from: d */
    private final int f20189d;

    @KeepForSdk
    public Logger(String str, String... strArr) {
        String str2;
        if (strArr.length == 0) {
            str2 = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (String str3 : strArr) {
                if (sb.length() > 1) {
                    sb.append(",");
                }
                sb.append(str3);
            }
            sb.append(']');
            sb.append(' ');
            str2 = sb.toString();
        }
        this(str, str2);
    }

    private Logger(String str, String str2) {
        this.f20187b = str2;
        this.f20186a = str;
        this.f20188c = new GmsLogger(str);
        int i = 2;
        while (7 >= i && !Log.isLoggable(this.f20186a, i)) {
            i++;
        }
        this.f20189d = i;
    }

    @KeepForSdk
    /* renamed from: a */
    public boolean mo27871a(int i) {
        return this.f20189d <= i;
    }

    @KeepForSdk
    /* renamed from: a */
    public void mo27870a(String str, Object... objArr) {
        if (mo27871a(3)) {
            Log.d(this.f20186a, m22008c(str, objArr));
        }
    }

    @KeepForSdk
    /* renamed from: b */
    public void mo27872b(String str, Object... objArr) {
        Log.e(this.f20186a, m22008c(str, objArr));
    }

    /* renamed from: c */
    private final String m22008c(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.f20187b.concat(str);
    }
}
