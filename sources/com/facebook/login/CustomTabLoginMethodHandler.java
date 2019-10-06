package com.facebook.login;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.p000v4.app.C0014p;
import com.facebook.C6665h;
import com.facebook.C6787r;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookServiceException;
import com.facebook.internal.C6670D;
import com.facebook.internal.C6694S;
import com.facebook.internal.C6697T;
import com.facebook.internal.C6738z;
import com.facebook.login.LoginClient.Request;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomTabLoginMethodHandler extends WebLoginMethodHandler {
    public static final Creator<CustomTabLoginMethodHandler> CREATOR = new C6756a();

    /* renamed from: d */
    private static final String[] f12347d = {"com.android.chrome", "com.chrome.beta", "com.chrome.dev"};

    /* renamed from: e */
    private String f12348e;

    /* renamed from: f */
    private String f12349f;

    CustomTabLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        this.f12349f = C6694S.m13401a(20);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo20000b() {
        return "custom_tab";
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public C6665h mo20003e() {
        return C6665h.CHROME_CUSTOM_TAB;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String mo20001d() {
        return "chrome_custom_tab";
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo19999a(Request request) {
        if (!m13618i()) {
            return false;
        }
        Bundle parameters = mo20087a(mo20089b(request), request);
        Intent intent = new Intent(this.f12406b.mo20048c(), CustomTabMainActivity.class);
        intent.putExtra(CustomTabMainActivity.f11763a, parameters);
        intent.putExtra(CustomTabMainActivity.f11764b, m13617h());
        this.f12406b.mo20053f().startActivityForResult(intent, 1);
        return true;
    }

    /* renamed from: i */
    private boolean m13618i() {
        return m13620k() && m13617h() != null && m13619j() && C6697T.m13464a(C6787r.m13815e());
    }

    /* renamed from: k */
    private boolean m13620k() {
        C6738z settings = C6670D.m13306b(C6694S.m13437c((Context) this.f12406b.mo20048c()));
        return settings != null && settings.mo19975c();
    }

    /* renamed from: h */
    private String m13617h() {
        String str = this.f12348e;
        if (str != null) {
            return str;
        }
        C0014p c = this.f12406b.mo20048c();
        List<ResolveInfo> resolveInfos = c.getPackageManager().queryIntentServices(new Intent("android.support.customtabs.action.CustomTabsService"), 0);
        if (resolveInfos != null) {
            Set<String> chromePackages = new HashSet<>(Arrays.asList(f12347d));
            for (ResolveInfo resolveInfo : resolveInfos) {
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                if (serviceInfo != null && chromePackages.contains(serviceInfo.packageName)) {
                    this.f12348e = serviceInfo.packageName;
                    return this.f12348e;
                }
            }
        }
        return null;
    }

    /* renamed from: j */
    private boolean m13619j() {
        if (!C6694S.m13444d((Context) this.f12406b.mo20048c())) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo19998a(int requestCode, int resultCode, Intent data) {
        if (requestCode != 1) {
            return super.mo19998a(requestCode, resultCode, data);
        }
        Request request = this.f12406b.mo20055i();
        if (resultCode == -1) {
            m13615a(data.getStringExtra(CustomTabMainActivity.f11765c), request);
            return true;
        }
        super.mo20088a(request, null, new FacebookOperationCanceledException());
        return false;
    }

    /* renamed from: a */
    private void m13615a(String url, Request request) {
        if (url != null && url.startsWith(CustomTabMainActivity.m12845a())) {
            Uri uri = Uri.parse(url);
            Bundle values = C6694S.m13443d(uri.getQuery());
            values.putAll(C6694S.m13443d(uri.getFragment()));
            if (!m13616a(values)) {
                super.mo20088a(request, null, new FacebookException("Invalid state parameter"));
                return;
            }
            String error = values.getString("error");
            if (error == null) {
                error = values.getString("error_type");
            }
            String errorMessage = values.getString("error_msg");
            if (errorMessage == null) {
                errorMessage = values.getString("error_message");
            }
            if (errorMessage == null) {
                errorMessage = values.getString("error_description");
            }
            String errorCodeString = values.getString("error_code");
            int errorCode = -1;
            if (!C6694S.m13436b(errorCodeString)) {
                try {
                    errorCode = Integer.parseInt(errorCodeString);
                } catch (NumberFormatException e) {
                    errorCode = -1;
                }
            }
            if (C6694S.m13436b(error) && C6694S.m13436b(errorMessage) && errorCode == -1) {
                super.mo20088a(request, values, null);
            } else if (error != null && (error.equals("access_denied") || error.equals("OAuthAccessDeniedException"))) {
                super.mo20088a(request, null, new FacebookOperationCanceledException());
            } else if (errorCode == 4201) {
                super.mo20088a(request, null, new FacebookOperationCanceledException());
            } else {
                super.mo20088a(request, null, new FacebookServiceException(new FacebookRequestError(errorCode, error, errorMessage), errorMessage));
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo19997a(JSONObject param) throws JSONException {
        param.put("7_challenge", this.f12349f);
    }

    /* renamed from: a */
    private boolean m13616a(Bundle values) {
        try {
            String stateString = values.getString("state");
            if (stateString == null) {
                return false;
            }
            return new JSONObject(stateString).getString("7_challenge").equals(this.f12349f);
        } catch (JSONException e) {
            return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    CustomTabLoginMethodHandler(Parcel source) {
        super(source);
        this.f12349f = source.readString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.f12349f);
    }
}
