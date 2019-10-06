package com.facebook.login;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.facebook.C6665h;
import com.facebook.FacebookException;
import com.facebook.internal.C6690N;
import com.facebook.internal.C6694S;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;

abstract class NativeAppLoginMethodHandler extends LoginMethodHandler {
    NativeAppLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    NativeAppLoginMethodHandler(Parcel source) {
        super(source);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo19998a(int requestCode, int resultCode, Intent data) {
        Result outcome;
        Request request = this.f12406b.mo20055i();
        if (data == null) {
            outcome = Result.m13726a(request, "Operation canceled");
        } else if (resultCode == 0) {
            outcome = m13746a(request, data);
        } else if (resultCode != -1) {
            outcome = Result.m13727a(request, "Unexpected resultCode from authorization.", null);
        } else {
            outcome = m13748b(request, data);
        }
        if (outcome != null) {
            this.f12406b.mo20045b(outcome);
        } else {
            this.f12406b.mo20059m();
        }
        return true;
    }

    /* renamed from: b */
    private Result m13748b(Request request, Intent data) {
        Bundle extras = data.getExtras();
        String error = m13747a(extras);
        String str = "error_code";
        String errorCode = extras.get(str) != null ? extras.get(str).toString() : null;
        String errorMessage = m13749b(extras);
        String e2e = extras.getString("e2e");
        if (!C6694S.m13436b(e2e)) {
            mo20084c(e2e);
        }
        if (error == null && errorCode == null && errorMessage == null) {
            try {
                return Result.m13725a(request, LoginMethodHandler.m13734a(request.mo20071h(), extras, C6665h.FACEBOOK_APPLICATION_WEB, request.mo20061a()));
            } catch (FacebookException ex) {
                return Result.m13727a(request, null, ex.getMessage());
            }
        } else if (C6690N.f12212b.contains(error)) {
            return null;
        } else {
            if (C6690N.f12213c.contains(error)) {
                return Result.m13726a(request, (String) null);
            }
            return Result.m13728a(request, error, errorMessage, errorCode);
        }
    }

    /* renamed from: a */
    private Result m13746a(Request request, Intent data) {
        Bundle extras = data.getExtras();
        String error = m13747a(extras);
        String str = "error_code";
        String errorCode = extras.get(str) != null ? extras.get(str).toString() : null;
        if ("CONNECTION_FAILURE".equals(errorCode)) {
            return Result.m13728a(request, error, m13749b(extras), errorCode);
        }
        return Result.m13726a(request, error);
    }

    /* renamed from: a */
    private String m13747a(Bundle extras) {
        String error = extras.getString("error");
        if (error == null) {
            return extras.getString("error_type");
        }
        return error;
    }

    /* renamed from: b */
    private String m13749b(Bundle extras) {
        String errorMessage = extras.getString("error_message");
        if (errorMessage == null) {
            return extras.getString("error_description");
        }
        return errorMessage;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo20086a(Intent intent, int requestCode) {
        if (intent == null) {
            return false;
        }
        try {
            this.f12406b.mo20053f().startActivityForResult(intent, requestCode);
            return true;
        } catch (ActivityNotFoundException e) {
            return false;
        }
    }
}
