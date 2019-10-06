package com.mopub.volley;

import android.content.Intent;

public class AuthFailureError extends VolleyError {

    /* renamed from: b */
    private Intent f36407b;

    public AuthFailureError() {
    }

    public AuthFailureError(Intent intent) {
        this.f36407b = intent;
    }

    public AuthFailureError(NetworkResponse response) {
        super(response);
    }

    public AuthFailureError(String message) {
        super(message);
    }

    public AuthFailureError(String message, Exception reason) {
        super(message, reason);
    }

    public Intent getResolutionIntent() {
        return this.f36407b;
    }

    public String getMessage() {
        if (this.f36407b != null) {
            return "User needs to (re)enter credentials.";
        }
        return super.getMessage();
    }
}
