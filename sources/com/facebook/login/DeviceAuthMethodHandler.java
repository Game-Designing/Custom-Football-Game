package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.p000v4.app.C0014p;
import com.facebook.AccessToken;
import com.facebook.C6665h;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;

class DeviceAuthMethodHandler extends LoginMethodHandler {
    public static final Creator<DeviceAuthMethodHandler> CREATOR = new C6766k();

    /* renamed from: c */
    private static ScheduledThreadPoolExecutor f12370c;

    DeviceAuthMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo19999a(Request request) {
        m13663b(request);
        return true;
    }

    /* renamed from: b */
    private void m13663b(Request request) {
        C0014p activity = this.f12406b.mo20048c();
        if (activity != null && !activity.isFinishing()) {
            DeviceAuthDialog dialog = mo20025d();
            dialog.show(activity.getSupportFragmentManager(), "login_with_facebook");
            dialog.mo20009a(request);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public DeviceAuthDialog mo20025d() {
        return new DeviceAuthDialog();
    }

    /* renamed from: f */
    public void mo20027f() {
        this.f12406b.mo20045b(Result.m13726a(this.f12406b.mo20055i(), "User canceled log in."));
    }

    /* renamed from: a */
    public void mo20023a(Exception ex) {
        this.f12406b.mo20045b(Result.m13727a(this.f12406b.mo20055i(), null, ex.getMessage()));
    }

    /* renamed from: a */
    public void mo20024a(String accessToken, String applicationId, String userId, Collection<String> permissions, Collection<String> declinedPermissions, Collection<String> expiredPermissions, C6665h accessTokenSource, Date expirationTime, Date lastRefreshTime, Date dataAccessExpirationTime) {
        AccessToken token = new AccessToken(accessToken, applicationId, userId, permissions, declinedPermissions, expiredPermissions, accessTokenSource, expirationTime, lastRefreshTime, dataAccessExpirationTime);
        this.f12406b.mo20045b(Result.m13725a(this.f12406b.mo20055i(), token));
    }

    /* renamed from: e */
    public static synchronized ScheduledThreadPoolExecutor m13664e() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        synchronized (DeviceAuthMethodHandler.class) {
            if (f12370c == null) {
                f12370c = new ScheduledThreadPoolExecutor(1);
            }
            scheduledThreadPoolExecutor = f12370c;
        }
        return scheduledThreadPoolExecutor;
    }

    protected DeviceAuthMethodHandler(Parcel parcel) {
        super(parcel);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo20000b() {
        return "device_auth";
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
    }
}
