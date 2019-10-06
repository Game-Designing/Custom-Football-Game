package com.facebook.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p000v4.app.C0014p;
import android.support.p000v4.app.Fragment;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.common.C6658d;
import com.facebook.internal.C6694S;
import com.facebook.internal.C6697T;
import com.facebook.internal.C6722l.C6724b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.install.installer.RootCommandOnSubscribe;

class LoginClient implements Parcelable {
    public static final Creator<LoginClient> CREATOR = new C6774s();

    /* renamed from: a */
    LoginMethodHandler[] f12374a;

    /* renamed from: b */
    int f12375b = -1;

    /* renamed from: c */
    Fragment f12376c;

    /* renamed from: d */
    C6754b f12377d;

    /* renamed from: e */
    C6753a f12378e;

    /* renamed from: f */
    boolean f12379f;

    /* renamed from: g */
    Request f12380g;

    /* renamed from: h */
    Map<String, String> f12381h;

    /* renamed from: i */
    Map<String, String> f12382i;

    /* renamed from: j */
    private C6780y f12383j;

    public static class Request implements Parcelable {
        public static final Creator<Request> CREATOR = new C6775t();

        /* renamed from: a */
        private final C6773r f12384a;

        /* renamed from: b */
        private Set<String> f12385b;

        /* renamed from: c */
        private final C6757b f12386c;

        /* renamed from: d */
        private final String f12387d;

        /* renamed from: e */
        private final String f12388e;

        /* renamed from: f */
        private boolean f12389f;

        /* renamed from: g */
        private String f12390g;

        /* renamed from: h */
        private String f12391h;

        /* renamed from: i */
        private String f12392i;

        /* synthetic */ Request(Parcel x0, C6774s x1) {
            this(x0);
        }

        Request(C6773r loginBehavior, Set<String> permissions, C6757b defaultAudience, String authType, String applicationId, String authId) {
            this.f12389f = false;
            this.f12384a = loginBehavior;
            this.f12385b = permissions != null ? permissions : new HashSet<>();
            this.f12386c = defaultAudience;
            this.f12391h = authType;
            this.f12387d = applicationId;
            this.f12388e = authId;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: h */
        public Set<String> mo20071h() {
            return this.f12385b;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo20062a(Set<String> permissions) {
            C6697T.m13461a((Object) permissions, "permissions");
            this.f12385b = permissions;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: g */
        public C6773r mo20070g() {
            return this.f12384a;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public C6757b mo20066d() {
            return this.f12386c;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public String mo20061a() {
            return this.f12387d;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public String mo20064b() {
            return this.f12388e;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: j */
        public boolean mo20073j() {
            return this.f12389f;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo20063a(boolean isRerequest) {
            this.f12389f = isRerequest;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: f */
        public String mo20069f() {
            return this.f12390g;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public String mo20068e() {
            return this.f12392i;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public String mo20065c() {
            return this.f12391h;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: i */
        public boolean mo20072i() {
            for (String permission : this.f12385b) {
                if (C6745C.m13600a(permission)) {
                    return true;
                }
            }
            return false;
        }

        private Request(Parcel parcel) {
            boolean z = false;
            this.f12389f = false;
            String enumValue = parcel.readString();
            C6757b bVar = null;
            this.f12384a = enumValue != null ? C6773r.valueOf(enumValue) : null;
            ArrayList<String> permissionsList = new ArrayList<>();
            parcel.readStringList(permissionsList);
            this.f12385b = new HashSet(permissionsList);
            String enumValue2 = parcel.readString();
            if (enumValue2 != null) {
                bVar = C6757b.valueOf(enumValue2);
            }
            this.f12386c = bVar;
            this.f12387d = parcel.readString();
            this.f12388e = parcel.readString();
            if (parcel.readByte() != 0) {
                z = true;
            }
            this.f12389f = z;
            this.f12390g = parcel.readString();
            this.f12391h = parcel.readString();
            this.f12392i = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            C6773r rVar = this.f12384a;
            String str = null;
            dest.writeString(rVar != null ? rVar.name() : null);
            dest.writeStringList(new ArrayList(this.f12385b));
            C6757b bVar = this.f12386c;
            if (bVar != null) {
                str = bVar.name();
            }
            dest.writeString(str);
            dest.writeString(this.f12387d);
            dest.writeString(this.f12388e);
            dest.writeByte(this.f12389f ? (byte) 1 : 0);
            dest.writeString(this.f12390g);
            dest.writeString(this.f12391h);
            dest.writeString(this.f12392i);
        }
    }

    public static class Result implements Parcelable {
        public static final Creator<Result> CREATOR = new C6776u();

        /* renamed from: a */
        final C6752a f12393a;

        /* renamed from: b */
        final AccessToken f12394b;

        /* renamed from: c */
        final String f12395c;

        /* renamed from: d */
        final String f12396d;

        /* renamed from: e */
        final Request f12397e;

        /* renamed from: f */
        public Map<String, String> f12398f;

        /* renamed from: g */
        public Map<String, String> f12399g;

        /* renamed from: com.facebook.login.LoginClient$Result$a */
        enum C6752a {
            SUCCESS(RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION),
            CANCEL("cancel"),
            ERROR("error");
            

            /* renamed from: e */
            private final String f12404e;

            private C6752a(String loggingValue) {
                this.f12404e = loggingValue;
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: e */
            public String mo20077e() {
                return this.f12404e;
            }
        }

        /* synthetic */ Result(Parcel x0, C6774s x1) {
            this(x0);
        }

        Result(Request request, C6752a code, AccessToken token, String errorMessage, String errorCode) {
            C6697T.m13461a((Object) code, "code");
            this.f12397e = request;
            this.f12394b = token;
            this.f12395c = errorMessage;
            this.f12393a = code;
            this.f12396d = errorCode;
        }

        /* renamed from: a */
        static Result m13725a(Request request, AccessToken token) {
            Result result = new Result(request, C6752a.SUCCESS, token, null, null);
            return result;
        }

        /* renamed from: a */
        static Result m13726a(Request request, String message) {
            Result result = new Result(request, C6752a.CANCEL, null, message, null);
            return result;
        }

        /* renamed from: a */
        static Result m13727a(Request request, String errorType, String errorDescription) {
            return m13728a(request, errorType, errorDescription, null);
        }

        /* renamed from: a */
        static Result m13728a(Request request, String errorType, String errorDescription, String errorCode) {
            String str = ": ";
            Request request2 = request;
            Result result = new Result(request2, C6752a.ERROR, null, TextUtils.join(str, C6694S.m13411a((T[]) new String[]{errorType, errorDescription})), errorCode);
            return result;
        }

        private Result(Parcel parcel) {
            this.f12393a = C6752a.valueOf(parcel.readString());
            this.f12394b = (AccessToken) parcel.readParcelable(AccessToken.class.getClassLoader());
            this.f12395c = parcel.readString();
            this.f12396d = parcel.readString();
            this.f12397e = (Request) parcel.readParcelable(Request.class.getClassLoader());
            this.f12398f = C6694S.m13413a(parcel);
            this.f12399g = C6694S.m13413a(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.f12393a.name());
            dest.writeParcelable(this.f12394b, flags);
            dest.writeString(this.f12395c);
            dest.writeString(this.f12396d);
            dest.writeParcelable(this.f12397e, flags);
            C6694S.m13419a(dest, this.f12398f);
            C6694S.m13419a(dest, this.f12399g);
        }
    }

    /* renamed from: com.facebook.login.LoginClient$a */
    interface C6753a {
        /* renamed from: a */
        void mo20078a();

        /* renamed from: b */
        void mo20079b();
    }

    /* renamed from: com.facebook.login.LoginClient$b */
    public interface C6754b {
        /* renamed from: a */
        void mo20080a(Result result);
    }

    public LoginClient(Fragment fragment) {
        this.f12376c = fragment;
    }

    /* renamed from: f */
    public Fragment mo20053f() {
        return this.f12376c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo20039a(Fragment fragment) {
        if (this.f12376c == null) {
            this.f12376c = fragment;
            return;
        }
        throw new FacebookException("Can't set fragment once it is already set.");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public C0014p mo20048c() {
        return this.f12376c.getActivity();
    }

    /* renamed from: i */
    public Request mo20055i() {
        return this.f12380g;
    }

    /* renamed from: h */
    public static int m13688h() {
        return C6724b.Login.mo19966e();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo20049c(Request request) {
        if (!mo20054g()) {
            mo20040a(request);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo20040a(Request request) {
        if (request != null) {
            if (this.f12380g != null) {
                throw new FacebookException("Attempted to authorize while a request is pending.");
            } else if (!AccessToken.m12821m() || mo20046b()) {
                this.f12380g = request;
                this.f12374a = mo20047b(request);
                mo20059m();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public boolean mo20054g() {
        return this.f12380g != null && this.f12375b >= 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo20038a() {
        if (this.f12375b >= 0) {
            mo20051d().mo20031a();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public LoginMethodHandler mo20051d() {
        int i = this.f12375b;
        if (i >= 0) {
            return this.f12374a[i];
        }
        return null;
    }

    /* renamed from: a */
    public boolean mo20044a(int requestCode, int resultCode, Intent data) {
        if (this.f12380g != null) {
            return mo20051d().mo19998a(requestCode, resultCode, data);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public LoginMethodHandler[] mo20047b(Request request) {
        ArrayList<LoginMethodHandler> handlers = new ArrayList<>();
        C6773r behavior = request.mo20070g();
        if (behavior.mo20115i()) {
            handlers.add(new GetTokenLoginMethodHandler(this));
        }
        if (behavior.mo20116j()) {
            handlers.add(new KatanaProxyLoginMethodHandler(this));
        }
        if (behavior.mo20114g()) {
            handlers.add(new FacebookLiteLoginMethodHandler(this));
        }
        if (behavior.mo20112e()) {
            handlers.add(new CustomTabLoginMethodHandler(this));
        }
        if (behavior.mo20117s()) {
            handlers.add(new WebViewLoginMethodHandler(this));
        }
        if (behavior.mo20113f()) {
            handlers.add(new DeviceAuthMethodHandler(this));
        }
        LoginMethodHandler[] result = new LoginMethodHandler[handlers.size()];
        handlers.toArray(result);
        return result;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo20046b() {
        if (this.f12379f) {
            return true;
        }
        if (mo20037a("android.permission.INTERNET") != 0) {
            Activity activity = mo20048c();
            mo20041a(Result.m13727a(this.f12380g, activity.getString(C6658d.com_facebook_internet_permission_error_title), activity.getString(C6658d.com_facebook_internet_permission_error_message)));
            return false;
        }
        this.f12379f = true;
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public void mo20059m() {
        if (this.f12375b >= 0) {
            m13684a(mo20051d().mo20000b(), "skipped", null, null, mo20051d().f12405a);
        }
        do {
            LoginMethodHandler[] loginMethodHandlerArr = this.f12374a;
            if (loginMethodHandlerArr != null) {
                int i = this.f12375b;
                if (i < loginMethodHandlerArr.length - 1) {
                    this.f12375b = i + 1;
                }
            }
            if (this.f12380g != null) {
                m13689n();
            }
            return;
        } while (!mo20058l());
    }

    /* renamed from: n */
    private void m13689n() {
        mo20041a(Result.m13727a(this.f12380g, "Login attempt failed.", null));
    }

    /* renamed from: a */
    private void m13685a(String key, String value, boolean accumulate) {
        if (this.f12381h == null) {
            this.f12381h = new HashMap();
        }
        if (this.f12381h.containsKey(key) && accumulate) {
            StringBuilder sb = new StringBuilder();
            sb.append((String) this.f12381h.get(key));
            sb.append(",");
            sb.append(value);
            value = sb.toString();
        }
        this.f12381h.put(key, value);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public boolean mo20058l() {
        LoginMethodHandler handler = mo20051d();
        if (!handler.mo20085c() || mo20046b()) {
            boolean tried = handler.mo19999a(this.f12380g);
            if (tried) {
                m13690o().mo20133b(this.f12380g.mo20064b(), handler.mo20000b());
            } else {
                m13690o().mo20129a(this.f12380g.mo20064b(), handler.mo20000b());
                m13685a("not_tried", handler.mo20000b(), true);
            }
            return tried;
        }
        m13685a("no_internet_permission", "1", false);
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo20045b(Result outcome) {
        if (outcome.f12394b == null || !AccessToken.m12821m()) {
            mo20041a(outcome);
        } else {
            mo20050c(outcome);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo20041a(Result outcome) {
        LoginMethodHandler handler = mo20051d();
        if (handler != null) {
            m13683a(handler.mo20000b(), outcome, handler.f12405a);
        }
        Map<String, String> map = this.f12381h;
        if (map != null) {
            outcome.f12398f = map;
        }
        Map<String, String> map2 = this.f12382i;
        if (map2 != null) {
            outcome.f12399g = map2;
        }
        this.f12374a = null;
        this.f12375b = -1;
        this.f12380g = null;
        this.f12381h = null;
        m13686d(outcome);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo20043a(C6754b onCompletedListener) {
        this.f12377d = onCompletedListener;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo20042a(C6753a backgroundProcessingListener) {
        this.f12378e = backgroundProcessingListener;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo20037a(String permission) {
        return mo20048c().checkCallingOrSelfPermission(permission);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo20050c(Result pendingResult) {
        Result result;
        if (pendingResult.f12394b != null) {
            AccessToken previousToken = AccessToken.m12820c();
            AccessToken newToken = pendingResult.f12394b;
            if (!(previousToken == null || newToken == null)) {
                try {
                    if (previousToken.mo19632l().equals(newToken.mo19632l())) {
                        result = Result.m13725a(this.f12380g, pendingResult.f12394b);
                        mo20041a(result);
                        return;
                    }
                } catch (Exception ex) {
                    mo20041a(Result.m13727a(this.f12380g, "Caught exception", ex.getMessage()));
                    return;
                }
            }
            result = Result.m13727a(this.f12380g, "User logged in as different Facebook user.", null);
            mo20041a(result);
            return;
        }
        throw new FacebookException("Can't validate without a token");
    }

    /* renamed from: o */
    private C6780y m13690o() {
        C6780y yVar = this.f12383j;
        if (yVar == null || !yVar.mo20127a().equals(this.f12380g.mo20061a())) {
            this.f12383j = new C6780y(mo20048c(), this.f12380g.mo20061a());
        }
        return this.f12383j;
    }

    /* renamed from: d */
    private void m13686d(Result outcome) {
        C6754b bVar = this.f12377d;
        if (bVar != null) {
            bVar.mo20080a(outcome);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public void mo20056j() {
        C6753a aVar = this.f12378e;
        if (aVar != null) {
            aVar.mo20078a();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public void mo20057k() {
        C6753a aVar = this.f12378e;
        if (aVar != null) {
            aVar.mo20079b();
        }
    }

    /* renamed from: a */
    private void m13683a(String method, Result result, Map<String, String> loggingExtras) {
        m13684a(method, result.f12393a.mo20077e(), result.f12395c, result.f12396d, loggingExtras);
    }

    /* renamed from: a */
    private void m13684a(String method, String result, String errorMessage, String errorCode, Map<String, String> loggingExtras) {
        if (this.f12380g == null) {
            m13690o().mo20130a("fb_mobile_login_method_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", method);
        } else {
            m13690o().mo20131a(this.f12380g.mo20064b(), method, result, errorMessage, errorCode, loggingExtras);
        }
    }

    /* renamed from: e */
    static String m13687e() {
        JSONObject e2e = new JSONObject();
        try {
            e2e.put("init", System.currentTimeMillis());
        } catch (JSONException e) {
        }
        return e2e.toString();
    }

    public LoginClient(Parcel source) {
        Object[] o = source.readParcelableArray(LoginMethodHandler.class.getClassLoader());
        this.f12374a = new LoginMethodHandler[o.length];
        for (int i = 0; i < o.length; i++) {
            LoginMethodHandler[] loginMethodHandlerArr = this.f12374a;
            loginMethodHandlerArr[i] = (LoginMethodHandler) o[i];
            loginMethodHandlerArr[i].mo20082a(this);
        }
        this.f12375b = source.readInt();
        this.f12380g = (Request) source.readParcelable(Request.class.getClassLoader());
        this.f12381h = C6694S.m13413a(source);
        this.f12382i = C6694S.m13413a(source);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelableArray(this.f12374a, flags);
        dest.writeInt(this.f12375b);
        dest.writeParcelable(this.f12380g, flags);
        C6694S.m13419a(dest, this.f12381h);
        C6694S.m13419a(dest, this.f12382i);
    }
}
