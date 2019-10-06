package com.paypal.android.sdk.payments;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import com.paypal.android.sdk.C11723Fa;
import com.paypal.android.sdk.C11757Q;
import p005cm.aptoide.p006pt.BuildConfig;

public final class PayPalConfiguration implements Parcelable {
    public static final Creator CREATOR = new C11880K();

    /* renamed from: a */
    private static final String f37350a = PayPalConfiguration.class.getSimpleName();

    /* renamed from: b */
    private String f37351b;

    /* renamed from: c */
    private String f37352c;

    /* renamed from: d */
    private String f37353d;

    /* renamed from: e */
    private String f37354e;

    /* renamed from: f */
    private String f37355f;

    /* renamed from: g */
    private boolean f37356g;

    /* renamed from: h */
    private String f37357h;

    /* renamed from: i */
    private String f37358i;

    /* renamed from: j */
    private boolean f37359j;

    /* renamed from: k */
    private String f37360k;

    /* renamed from: l */
    private String f37361l;

    /* renamed from: m */
    private Uri f37362m;

    /* renamed from: n */
    private Uri f37363n;

    /* renamed from: o */
    private boolean f37364o;

    public PayPalConfiguration() {
        this.f37359j = C11867Da.m39247d();
        this.f37364o = true;
    }

    private PayPalConfiguration(Parcel parcel) {
        this.f37359j = C11867Da.m39247d();
        boolean z = true;
        this.f37364o = true;
        this.f37352c = parcel.readString();
        this.f37351b = parcel.readString();
        this.f37353d = parcel.readString();
        this.f37354e = parcel.readString();
        this.f37355f = parcel.readString();
        this.f37356g = parcel.readByte() == 1;
        this.f37357h = parcel.readString();
        this.f37358i = parcel.readString();
        this.f37359j = parcel.readByte() == 1;
        this.f37360k = parcel.readString();
        this.f37361l = parcel.readString();
        this.f37362m = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f37363n = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        if (parcel.readByte() != 1) {
            z = false;
        }
        this.f37364o = z;
    }

    /* synthetic */ PayPalConfiguration(Parcel parcel, byte b) {
        this(parcel);
    }

    /* renamed from: a */
    private static void m39299a(boolean z, String str) {
        if (!z) {
            String str2 = f37350a;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" is invalid.  Please see the docs.");
            Log.e(str2, sb.toString());
        }
    }

    /* renamed from: a */
    public final PayPalConfiguration mo38885a(String str) {
        this.f37360k = str;
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final String mo38886a() {
        return this.f37351b;
    }

    /* renamed from: b */
    public final PayPalConfiguration mo38887b(String str) {
        this.f37352c = str;
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final String mo38888b() {
        if (TextUtils.isEmpty(this.f37352c)) {
            this.f37352c = BuildConfig.PAYPAL_ENVIRONMENT;
            Log.w("paypal.sdk", "defaulting to production environment");
        }
        return this.f37352c;
    }

    /* renamed from: c */
    public final PayPalConfiguration mo38889c(String str) {
        this.f37361l = str;
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final String mo38890c() {
        return this.f37353d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public final String mo38891d() {
        return this.f37354e;
    }

    public final int describeContents() {
        return 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public final String mo38893e() {
        return this.f37355f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public final boolean mo38894f() {
        return this.f37356g;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public final String mo38895g() {
        return this.f37357h;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public final String mo38896h() {
        return this.f37358i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public final boolean mo38897i() {
        return this.f37359j;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public final boolean mo38898j() {
        return this.f37364o;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public final String mo38899k() {
        return this.f37360k;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public final String mo38900l() {
        return this.f37361l;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public final Uri mo38901m() {
        return this.f37362m;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public final Uri mo38902n() {
        return this.f37363n;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: o */
    public final boolean mo38903o() {
        boolean z;
        String str = "environment";
        boolean a = C11723Fa.m38819a(f37350a, mo38888b(), str);
        m39299a(a, str);
        if (!a) {
            z = false;
        } else if (C11757Q.m38953a(mo38888b())) {
            z = true;
        } else {
            String str2 = "clientId";
            z = C11723Fa.m38819a(f37350a, this.f37360k, str2);
            m39299a(z, str2);
        }
        return a && z;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PayPalConfiguration.class.getSimpleName());
        sb.append(": {environment:%s, client_id:%s, languageOrLocale:%s}");
        return String.format(sb.toString(), new Object[]{this.f37352c, this.f37360k, this.f37351b});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f37352c);
        parcel.writeString(this.f37351b);
        parcel.writeString(this.f37353d);
        parcel.writeString(this.f37354e);
        parcel.writeString(this.f37355f);
        parcel.writeByte(this.f37356g ? (byte) 1 : 0);
        parcel.writeString(this.f37357h);
        parcel.writeString(this.f37358i);
        parcel.writeByte(this.f37359j ? (byte) 1 : 0);
        parcel.writeString(this.f37360k);
        parcel.writeString(this.f37361l);
        parcel.writeParcelable(this.f37362m, 0);
        parcel.writeParcelable(this.f37363n, 0);
        parcel.writeByte(this.f37364o ? (byte) 1 : 0);
    }
}
