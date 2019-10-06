package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.paypal.android.sdk.C11723Fa;
import java.math.BigDecimal;

public final class PayPalPayment implements Parcelable {
    public static final Creator CREATOR = new C11897T();

    /* renamed from: a */
    private static final String f37385a = PayPalPayment.class.getSimpleName();

    /* renamed from: b */
    private BigDecimal f37386b;

    /* renamed from: c */
    private String f37387c;

    /* renamed from: d */
    private String f37388d;

    /* renamed from: e */
    private String f37389e;

    /* renamed from: f */
    private PayPalPaymentDetails f37390f;

    /* renamed from: g */
    private String f37391g;

    /* renamed from: h */
    private PayPalItem[] f37392h;

    /* renamed from: i */
    private boolean f37393i;

    /* renamed from: j */
    private ShippingAddress f37394j;

    /* renamed from: k */
    private String f37395k;

    /* renamed from: l */
    private String f37396l;

    /* renamed from: m */
    private String f37397m;

    /* renamed from: n */
    private String f37398n;

    private PayPalPayment(Parcel parcel) {
        this.f37387c = parcel.readString();
        try {
            this.f37386b = new BigDecimal(parcel.readString());
        } catch (NumberFormatException e) {
        }
        this.f37388d = parcel.readString();
        this.f37391g = parcel.readString();
        this.f37389e = parcel.readString();
        this.f37390f = (PayPalPaymentDetails) parcel.readParcelable(PayPalPaymentDetails.class.getClassLoader());
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.f37392h = new PayPalItem[readInt];
            parcel.readTypedArray(this.f37392h, PayPalItem.CREATOR);
        }
        this.f37394j = (ShippingAddress) parcel.readParcelable(ShippingAddress.class.getClassLoader());
        boolean z = true;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.f37393i = z;
        this.f37395k = parcel.readString();
        this.f37396l = parcel.readString();
        this.f37397m = parcel.readString();
        this.f37398n = parcel.readString();
    }

    /* synthetic */ PayPalPayment(Parcel parcel, byte b) {
        this(parcel);
    }

    public PayPalPayment(BigDecimal bigDecimal, String str, String str2, String str3) {
        this.f37386b = bigDecimal;
        this.f37387c = str;
        this.f37388d = str2;
        this.f37391g = str3;
        this.f37390f = null;
        this.f37389e = null;
        toString();
    }

    /* renamed from: a */
    private static void m39337a(boolean z, String str) {
        if (!z) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" is invalid.  Please see the docs.");
            Log.e("paypal.sdk", sb.toString());
        }
    }

    /* renamed from: a */
    private static boolean m39338a(String str, String str2, int i) {
        if (!C11723Fa.m38822b((CharSequence) str) || str.length() <= i) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(" is too long (max ");
        sb.append(i);
        sb.append(")");
        Log.e("paypal.sdk", sb.toString());
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final BigDecimal mo38927a() {
        return this.f37386b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final String mo38928b() {
        return this.f37388d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final String mo38929c() {
        return this.f37391g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final String mo38930d() {
        return this.f37387c;
    }

    public final int describeContents() {
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public final String mo38932e() {
        return this.f37389e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public final String mo38933f() {
        return this.f37398n;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public final PayPalPaymentDetails mo38934g() {
        return this.f37390f;
    }

    /* renamed from: h */
    public final ShippingAddress mo38935h() {
        return this.f37394j;
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public final PayPalItem[] mo38936i() {
        return this.f37392h;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public final String mo38937j() {
        return this.f37395k;
    }

    /* renamed from: k */
    public final boolean mo38938k() {
        return this.f37393i;
    }

    /* renamed from: l */
    public final boolean mo38939l() {
        return !this.f37393i && this.f37394j == null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0095  */
    /* renamed from: m */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo38940m() {
        /*
            r13 = this;
            java.lang.String r0 = r13.f37387c
            boolean r0 = com.paypal.android.sdk.C11836jb.m39183a(r0)
            java.math.BigDecimal r1 = r13.f37386b
            java.lang.String r2 = r13.f37387c
            r3 = 1
            boolean r1 = com.paypal.android.sdk.C11836jb.m39184a(r1, r2, r3)
            java.lang.String r2 = r13.f37388d
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            r2 = r2 ^ r3
            java.lang.String r4 = r13.f37391g
            boolean r4 = com.paypal.android.sdk.C11723Fa.m38822b(r4)
            r5 = 0
            if (r4 == 0) goto L_0x003f
            java.lang.String r4 = r13.f37391g
            java.lang.String r6 = "sale"
            boolean r4 = r4.equals(r6)
            if (r4 != 0) goto L_0x003d
            java.lang.String r4 = r13.f37391g
            java.lang.String r6 = "authorize"
            boolean r4 = r4.equals(r6)
            if (r4 != 0) goto L_0x003d
            java.lang.String r4 = r13.f37391g
            java.lang.String r6 = "order"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x003f
        L_0x003d:
            r4 = 1
            goto L_0x0040
        L_0x003f:
            r4 = 0
        L_0x0040:
            com.paypal.android.sdk.payments.PayPalPaymentDetails r6 = r13.f37390f
            if (r6 != 0) goto L_0x0046
            r6 = 1
            goto L_0x004a
        L_0x0046:
            boolean r6 = r6.mo38948d()
        L_0x004a:
            java.lang.String r7 = r13.f37389e
            boolean r7 = com.paypal.android.sdk.C11723Fa.m38818a(r7)
            if (r7 == 0) goto L_0x0054
            r7 = 1
            goto L_0x005a
        L_0x0054:
            java.lang.String r7 = r13.f37389e
            boolean r7 = com.paypal.android.sdk.C11723Fa.m38825c(r7)
        L_0x005a:
            com.paypal.android.sdk.payments.PayPalItem[] r8 = r13.f37392h
            if (r8 == 0) goto L_0x0073
            int r9 = r8.length
            if (r9 != 0) goto L_0x0062
            goto L_0x0073
        L_0x0062:
            int r9 = r8.length
            r10 = 0
        L_0x0064:
            if (r10 >= r9) goto L_0x0073
            r11 = r8[r10]
            boolean r11 = r11.mo38918f()
            if (r11 != 0) goto L_0x0070
            r8 = 0
            goto L_0x0074
        L_0x0070:
            int r10 = r10 + 1
            goto L_0x0064
        L_0x0073:
            r8 = 1
        L_0x0074:
            java.lang.String r9 = r13.f37395k
            r10 = 256(0x100, float:3.59E-43)
            java.lang.String r11 = "invoiceNumber"
            boolean r9 = m39338a(r9, r11, r10)
            java.lang.String r11 = r13.f37396l
            java.lang.String r12 = "custom"
            boolean r10 = m39338a(r11, r12, r10)
            if (r10 != 0) goto L_0x0089
            r9 = 0
        L_0x0089:
            java.lang.String r10 = r13.f37397m
            r11 = 22
            java.lang.String r12 = "softDescriptor"
            boolean r10 = m39338a(r10, r12, r11)
            if (r10 != 0) goto L_0x0096
            r9 = 0
        L_0x0096:
            java.lang.String r10 = "currencyCode"
            m39337a(r0, r10)
            java.lang.String r10 = "amount"
            m39337a(r1, r10)
            java.lang.String r10 = "shortDescription"
            m39337a(r2, r10)
            java.lang.String r10 = "paymentIntent"
            m39337a(r4, r10)
            java.lang.String r10 = "details"
            m39337a(r6, r10)
            java.lang.String r10 = "bnCode"
            m39337a(r7, r10)
            java.lang.String r10 = "items"
            m39337a(r8, r10)
            if (r0 == 0) goto L_0x00ca
            if (r1 == 0) goto L_0x00ca
            if (r2 == 0) goto L_0x00ca
            if (r6 == 0) goto L_0x00ca
            if (r4 == 0) goto L_0x00ca
            if (r7 == 0) goto L_0x00ca
            if (r8 == 0) goto L_0x00ca
            if (r9 == 0) goto L_0x00ca
            return r3
        L_0x00ca:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paypal.android.sdk.payments.PayPalPayment.mo38940m():boolean");
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public final String mo38941n() {
        return this.f37396l;
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public final String mo38942o() {
        return this.f37397m;
    }

    public final String toString() {
        Object[] objArr = new Object[4];
        objArr[0] = this.f37388d;
        BigDecimal bigDecimal = this.f37386b;
        objArr[1] = bigDecimal != null ? bigDecimal.toString() : null;
        objArr[2] = this.f37387c;
        objArr[3] = this.f37391g;
        return String.format("PayPalPayment: {%s: $%s %s, %s}", objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f37387c);
        parcel.writeString(this.f37386b.toString());
        parcel.writeString(this.f37388d);
        parcel.writeString(this.f37391g);
        parcel.writeString(this.f37389e);
        parcel.writeParcelable(this.f37390f, 0);
        PayPalItem[] payPalItemArr = this.f37392h;
        if (payPalItemArr != null) {
            parcel.writeInt(payPalItemArr.length);
            parcel.writeTypedArray(this.f37392h, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.f37394j, 0);
        parcel.writeInt(this.f37393i ? 1 : 0);
        parcel.writeString(this.f37395k);
        parcel.writeString(this.f37396l);
        parcel.writeString(this.f37397m);
        parcel.writeString(this.f37398n);
    }
}
