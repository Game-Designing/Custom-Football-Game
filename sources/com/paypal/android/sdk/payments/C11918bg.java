package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: com.paypal.android.sdk.payments.bg */
enum C11918bg implements Parcelable {
    EMAIL,
    PIN,
    EMAIL_LOGIN_IN_PROGRESS,
    PIN_LOGIN_IN_PROGRESS,
    EMAIL_LOGIN_FAILED,
    PIN_LOGIN_FAILED,
    TWO_FA_SEND_FIRST_SMS,
    TWO_FA_SEND_FIRST_SMS_IN_PROGRESS,
    TWO_FA_SEND_ANOTHER_SMS_IN_PROGRESS,
    TWO_FA_ENTER_OTP,
    TWO_FA_LOGIN_OTP_IN_PROGRESS,
    TWO_FA_SEND_SMS_FAILED,
    TWO_FA_LOGIN_OTP_FAILED;
    
    public static final Creator CREATOR = null;

    static {
        CREATOR = new C11876I();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this);
    }
}
