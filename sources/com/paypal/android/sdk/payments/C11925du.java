package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.paypal.android.sdk.C11724Fb;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.paypal.android.sdk.payments.du */
final class C11925du implements Parcelable {
    public static final Creator CREATOR = new C11908Ya();

    /* renamed from: a */
    private List f37529a;

    /* renamed from: b */
    private String f37530b;

    /* renamed from: c */
    private String f37531c;

    /* renamed from: d */
    private String f37532d;

    C11925du() {
        this.f37529a = new ArrayList();
    }

    public C11925du(Parcel parcel) {
        this();
        if (parcel != null) {
            this.f37530b = parcel.readString();
            this.f37531c = parcel.readString();
            this.f37532d = parcel.readString();
            this.f37529a = new ArrayList();
            parcel.readList(this.f37529a, String.class.getClassLoader());
        }
    }

    C11925du(C11724Fb fb) {
        this.f37529a = m39528a(fb.mo38565t());
        this.f37530b = fb.mo38566u();
        this.f37531c = fb.mo38567v();
        this.f37532d = fb.mo38568w();
    }

    /* renamed from: a */
    private static List m39528a(Map map) {
        ArrayList arrayList = new ArrayList();
        for (String str : map.keySet()) {
            if (((String) map.get(str)).toUpperCase().equals("Y")) {
                arrayList.add(str.toLowerCase(Locale.US));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public final List mo39088a() {
        return this.f37529a;
    }

    /* renamed from: b */
    public final String mo39089b() {
        return this.f37530b;
    }

    /* renamed from: c */
    public final String mo39090c() {
        return this.f37531c;
    }

    /* renamed from: d */
    public final String mo39091d() {
        return this.f37532d;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f37530b);
        parcel.writeString(this.f37531c);
        parcel.writeString(this.f37532d);
        parcel.writeList(this.f37529a);
    }
}
