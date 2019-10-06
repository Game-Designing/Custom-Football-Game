package com.google.android.gms.common;

import android.content.Intent;

public class UserRecoverableException extends Exception {

    /* renamed from: a */
    private final Intent f19540a;

    public UserRecoverableException(String str, Intent intent) {
        super(str);
        this.f19540a = intent;
    }
}
