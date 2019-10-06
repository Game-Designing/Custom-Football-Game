package com.facebook.login;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.facebook.C6665h;
import com.facebook.internal.C6687L.C6688a;
import com.facebook.internal.C6694S;
import com.facebook.internal.C6694S.C6695a;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class GetTokenLoginMethodHandler extends LoginMethodHandler {
    public static final Creator<GetTokenLoginMethodHandler> CREATOR = new C6771p();

    /* renamed from: c */
    private C6768m f12373c;

    GetTokenLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo20000b() {
        return "get_token";
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo20031a() {
        C6768m mVar = this.f12373c;
        if (mVar != null) {
            mVar.mo19898a();
            this.f12373c.mo19901a((C6688a) null);
            this.f12373c = null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo19999a(Request request) {
        this.f12373c = new C6768m(this.f12406b.mo20048c(), request.mo20061a());
        if (!this.f12373c.mo19902b()) {
            return false;
        }
        this.f12406b.mo20056j();
        this.f12373c.mo19901a(new C6769n(this, request));
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo20033b(Request request, Bundle result) {
        C6768m mVar = this.f12373c;
        if (mVar != null) {
            mVar.mo19901a((C6688a) null);
        }
        this.f12373c = null;
        this.f12406b.mo20057k();
        if (result != null) {
            ArrayList<String> currentPermissions = result.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
            Set<String> permissions = request.mo20071h();
            if (currentPermissions == null || (permissions != null && !currentPermissions.containsAll(permissions))) {
                Set<String> newPermissions = new HashSet<>();
                for (String permission : permissions) {
                    if (!currentPermissions.contains(permission)) {
                        newPermissions.add(permission);
                    }
                }
                if (!newPermissions.isEmpty()) {
                    mo20083a("new_permissions", TextUtils.join(",", newPermissions));
                }
                request.mo20062a(newPermissions);
            } else {
                mo20032a(request, result);
                return;
            }
        }
        this.f12406b.mo20059m();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo20034c(Request request, Bundle result) {
        this.f12406b.mo20045b(Result.m13725a(this.f12406b.mo20055i(), LoginMethodHandler.m13733a(result, C6665h.FACEBOOK_APPLICATION_SERVICE, request.mo20061a())));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo20032a(Request request, Bundle result) {
        String userId = result.getString("com.facebook.platform.extra.USER_ID");
        if (userId == null || userId.isEmpty()) {
            this.f12406b.mo20056j();
            C6694S.m13421a(result.getString("com.facebook.platform.extra.ACCESS_TOKEN"), (C6695a) new C6770o(this, result, request));
            return;
        }
        mo20034c(request, result);
    }

    GetTokenLoginMethodHandler(Parcel source) {
        super(source);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
    }
}
