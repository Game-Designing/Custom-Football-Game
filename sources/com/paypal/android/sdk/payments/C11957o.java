package com.paypal.android.sdk.payments;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.EditText;

/* renamed from: com.paypal.android.sdk.payments.o */
final class C11957o implements Runnable {

    /* renamed from: a */
    private /* synthetic */ EditText f37594a;

    C11957o(LoginActivity loginActivity, EditText editText) {
        this.f37594a = editText;
    }

    public final void run() {
        this.f37594a.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, 9999.0f, 0.0f, 0));
        this.f37594a.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, 9999.0f, 0.0f, 0));
    }
}
