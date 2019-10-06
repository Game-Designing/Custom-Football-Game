package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.paypal.android.sdk.C11842l;
import java.util.ArrayList;
import java.util.List;

public final class PayPalOAuthScopes implements Parcelable {
    public static final Creator CREATOR = new C11895S();

    /* renamed from: a */
    public static final String f37377a = C11842l.FUTURE_PAYMENTS.mo38820a();

    /* renamed from: b */
    public static final String f37378b = C11842l.PROFILE.mo38820a();

    /* renamed from: c */
    public static final String f37379c = C11842l.PAYPAL_ATTRIBUTES.mo38820a();

    /* renamed from: d */
    public static final String f37380d = C11842l.EMAIL.mo38820a();

    /* renamed from: e */
    public static final String f37381e = C11842l.ADDRESS.mo38820a();

    /* renamed from: f */
    public static final String f37382f = C11842l.PHONE.mo38820a();

    /* renamed from: g */
    public static final String f37383g = C11842l.OPENID.mo38820a();

    /* renamed from: h */
    private final List f37384h;

    public PayPalOAuthScopes() {
        this.f37384h = new ArrayList();
    }

    private PayPalOAuthScopes(Parcel parcel) {
        this.f37384h = new ArrayList();
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            this.f37384h.add(parcel.readString());
        }
    }

    /* synthetic */ PayPalOAuthScopes(Parcel parcel, byte b) {
        this(parcel);
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.Set, code=java.util.Set<java.lang.String>, for r3v0, types: [java.util.Set, java.util.Set<java.lang.String>] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PayPalOAuthScopes(java.util.Set<java.lang.String> r3) {
        /*
            r2 = this;
            r2.<init>()
            java.util.Iterator r3 = r3.iterator()
        L_0x0007:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0019
            java.lang.Object r0 = r3.next()
            java.lang.String r0 = (java.lang.String) r0
            java.util.List r1 = r2.f37384h
            r1.add(r0)
            goto L_0x0007
        L_0x0019:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paypal.android.sdk.payments.PayPalOAuthScopes.<init>(java.util.Set):void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final List mo38922a() {
        return this.f37384h;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final String mo38923b() {
        return TextUtils.join(" ", this.f37384h);
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PayPalOAuthScopes.class.getSimpleName());
        sb.append(": {%s}");
        return String.format(sb.toString(), new Object[]{this.f37384h});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f37384h.size());
        for (int i2 = 0; i2 < this.f37384h.size(); i2++) {
            parcel.writeString((String) this.f37384h.get(i2));
        }
    }
}
