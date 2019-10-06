package com.google.android.gms.internal.ads;

import android.text.TextUtils;

public final class zzl {

    /* renamed from: a */
    private final String f28768a;

    /* renamed from: b */
    private final String f28769b;

    public zzl(String str, String str2) {
        this.f28768a = str;
        this.f28769b = str2;
    }

    /* renamed from: a */
    public final String mo31933a() {
        return this.f28768a;
    }

    /* renamed from: b */
    public final String mo31934b() {
        return this.f28769b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzl.class != obj.getClass()) {
            return false;
        }
        zzl zzl = (zzl) obj;
        if (!TextUtils.equals(this.f28768a, zzl.f28768a) || !TextUtils.equals(this.f28769b, zzl.f28769b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (this.f28768a.hashCode() * 31) + this.f28769b.hashCode();
    }

    public final String toString() {
        String str = this.f28768a;
        String str2 = this.f28769b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 20 + String.valueOf(str2).length());
        sb.append("Header[name=");
        sb.append(str);
        sb.append(",value=");
        sb.append(str2);
        sb.append("]");
        return sb.toString();
    }
}
