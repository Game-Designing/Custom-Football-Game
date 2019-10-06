package com.facebook.login;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.C6666i;
import com.facebook.C6742l;
import com.facebook.C6787r;
import com.facebook.FacebookActivity;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.internal.C6697T;
import com.facebook.internal.C6722l;
import com.facebook.internal.C6722l.C6724b;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: com.facebook.login.C */
/* compiled from: LoginManager */
public class C6745C {

    /* renamed from: a */
    private static final Set<String> f12339a = m13603c();

    /* renamed from: b */
    private static volatile C6745C f12340b;

    /* renamed from: c */
    private C6773r f12341c = C6773r.NATIVE_WITH_FALLBACK;

    /* renamed from: d */
    private C6757b f12342d = C6757b.FRIENDS;

    /* renamed from: e */
    private final SharedPreferences f12343e;

    /* renamed from: f */
    private String f12344f = "rerequest";

    /* renamed from: com.facebook.login.C$a */
    /* compiled from: LoginManager */
    private static class C6746a implements C6749E {

        /* renamed from: a */
        private final Activity f12345a;

        C6746a(Activity activity) {
            C6697T.m13461a((Object) activity, "activity");
            this.f12345a = activity;
        }

        public void startActivityForResult(Intent intent, int requestCode) {
            this.f12345a.startActivityForResult(intent, requestCode);
        }

        /* renamed from: a */
        public Activity mo19995a() {
            return this.f12345a;
        }
    }

    /* renamed from: com.facebook.login.C$b */
    /* compiled from: LoginManager */
    private static class C6747b {

        /* renamed from: a */
        private static C6780y f12346a;

        /* access modifiers changed from: private */
        /* renamed from: b */
        public static synchronized C6780y m13614b(Context context) {
            synchronized (C6747b.class) {
                Context context2 = context != null ? context : C6787r.m13815e();
                if (context2 == null) {
                    return null;
                }
                if (f12346a == null) {
                    f12346a = new C6780y(context2, C6787r.m13816f());
                }
                C6780y yVar = f12346a;
                return yVar;
            }
        }
    }

    C6745C() {
        C6697T.m13468c();
        this.f12343e = C6787r.m13815e().getSharedPreferences("com.facebook.loginManager", 0);
    }

    /* renamed from: a */
    public static C6745C m13592a() {
        if (f12340b == null) {
            synchronized (C6745C.class) {
                if (f12340b == null) {
                    f12340b = new C6745C();
                }
            }
        }
        return f12340b;
    }

    /* renamed from: a */
    public void mo19990a(C6666i callbackManager, C6742l<C6748D> callback) {
        if (callbackManager instanceof C6722l) {
            ((C6722l) callbackManager).mo19964a(C6724b.Login.mo19966e(), new C6781z(this, callback));
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo19991a(int resultCode, Intent data) {
        return mo19992a(resultCode, data, null);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo19992a(int resultCode, Intent data, C6742l<C6748D> callback) {
        Request originalRequest;
        Map<String, String> loggingExtras;
        C6752a code;
        boolean isCanceled;
        AccessToken newToken;
        int i = resultCode;
        Intent intent = data;
        FacebookException exception = null;
        AccessToken newToken2 = null;
        C6752a code2 = C6752a.ERROR;
        Map<String, String> loggingExtras2 = null;
        Request originalRequest2 = null;
        boolean isCanceled2 = false;
        if (intent != null) {
            Result result = (Result) intent.getParcelableExtra("com.facebook.LoginFragment:Result");
            if (result != null) {
                originalRequest2 = result.f12397e;
                code2 = result.f12393a;
                if (i == -1) {
                    if (result.f12393a == C6752a.SUCCESS) {
                        newToken2 = result.f12394b;
                    } else {
                        exception = new FacebookAuthorizationException(result.f12395c);
                    }
                } else if (i == 0) {
                    isCanceled2 = true;
                }
                loggingExtras2 = result.f12398f;
            }
        } else if (i == 0) {
            newToken = null;
            code = C6752a.CANCEL;
            loggingExtras = null;
            originalRequest = null;
            isCanceled = true;
            if (exception == null && newToken == null && !isCanceled) {
                exception = new FacebookException("Unexpected call to LoginManager.onActivityResult");
            }
            m13595a(null, code, loggingExtras, exception, true, originalRequest);
            m13596a(newToken, originalRequest, exception, isCanceled, callback);
            return true;
        }
        newToken = newToken2;
        code = code2;
        loggingExtras = loggingExtras2;
        originalRequest = originalRequest2;
        isCanceled = isCanceled2;
        exception = new FacebookException("Unexpected call to LoginManager.onActivityResult");
        m13595a(null, code, loggingExtras, exception, true, originalRequest);
        m13596a(newToken, originalRequest, exception, isCanceled, callback);
        return true;
    }

    /* renamed from: b */
    public void mo19993b() {
        AccessToken.m12819b(null);
        Profile.m12983a(null);
        m13598a(false);
    }

    /* renamed from: b */
    public void mo19994b(Activity activity, Collection<String> permissions) {
        m13601b(permissions);
        mo19989a(activity, permissions);
    }

    /* renamed from: a */
    public void mo19989a(Activity activity, Collection<String> permissions) {
        m13597a((C6749E) new C6746a(activity), mo19988a(permissions));
    }

    /* renamed from: b */
    private void m13601b(Collection<String> permissions) {
        if (permissions != null) {
            for (String permission : permissions) {
                if (m13600a(permission)) {
                    throw new FacebookException(String.format("Cannot pass a publish or manage permission (%s) to a request for read authorization", new Object[]{permission}));
                }
            }
        }
    }

    /* renamed from: a */
    static boolean m13600a(String permission) {
        return permission != null && (permission.startsWith("publish") || permission.startsWith("manage") || f12339a.contains(permission));
    }

    /* renamed from: c */
    private static Set<String> m13603c() {
        return Collections.unmodifiableSet(new C6743A<>());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Request mo19988a(Collection<String> permissions) {
        Request request = new Request(this.f12341c, Collections.unmodifiableSet(permissions != null ? new HashSet(permissions) : new HashSet()), this.f12342d, this.f12344f, C6787r.m13816f(), UUID.randomUUID().toString());
        request.mo20063a(AccessToken.m12821m());
        return request;
    }

    /* renamed from: a */
    private void m13597a(C6749E startActivityDelegate, Request request) throws FacebookException {
        m13594a((Context) startActivityDelegate.mo19995a(), request);
        C6722l.m13545b(C6724b.Login.mo19966e(), new C6744B(this));
        if (!m13602b(startActivityDelegate, request)) {
            FacebookException exception = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
            m13595a(startActivityDelegate.mo19995a(), C6752a.ERROR, null, exception, false, request);
            throw exception;
        }
    }

    /* renamed from: a */
    private void m13594a(Context context, Request loginRequest) {
        C6780y loginLogger = C6747b.m13614b(context);
        if (loginLogger != null && loginRequest != null) {
            loginLogger.mo20128a(loginRequest);
        }
    }

    /* renamed from: a */
    private void m13595a(Context context, C6752a result, Map<String, String> resultExtras, Exception exception, boolean wasLoginActivityTried, Request request) {
        C6780y loginLogger = C6747b.m13614b(context);
        if (loginLogger != null) {
            if (request == null) {
                loginLogger.mo20134c("fb_mobile_login_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.");
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put("try_login_activity", wasLoginActivityTried ? "1" : BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
                loginLogger.mo20132a(request.mo20064b(), hashMap, result, resultExtras, exception);
            }
        }
    }

    /* renamed from: b */
    private boolean m13602b(C6749E startActivityDelegate, Request request) {
        Intent intent = mo19987a(request);
        if (!m13599a(intent)) {
            return false;
        }
        try {
            startActivityDelegate.startActivityForResult(intent, LoginClient.m13688h());
            return true;
        } catch (ActivityNotFoundException e) {
            return false;
        }
    }

    /* renamed from: a */
    private boolean m13599a(Intent intent) {
        if (C6787r.m13815e().getPackageManager().resolveActivity(intent, 0) != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Intent mo19987a(Request request) {
        Intent intent = new Intent();
        intent.setClass(C6787r.m13815e(), FacebookActivity.class);
        intent.setAction(request.mo20070g().toString());
        Bundle extras = new Bundle();
        extras.putParcelable("request", request);
        intent.putExtra("com.facebook.LoginFragment:Request", extras);
        return intent;
    }

    /* renamed from: a */
    static C6748D m13593a(Request request, AccessToken newToken) {
        Set<String> requestedPermissions = request.mo20071h();
        Set<String> grantedPermissions = new HashSet<>(newToken.mo19629i());
        if (request.mo20073j()) {
            grantedPermissions.retainAll(requestedPermissions);
        }
        Set<String> deniedPermissions = new HashSet<>(requestedPermissions);
        deniedPermissions.removeAll(grantedPermissions);
        return new C6748D(newToken, grantedPermissions, deniedPermissions);
    }

    /* renamed from: a */
    private void m13596a(AccessToken newToken, Request origRequest, FacebookException exception, boolean isCanceled, C6742l<C6748D> callback) {
        if (newToken != null) {
            AccessToken.m12819b(newToken);
            Profile.m12984b();
        }
        if (callback != null) {
            C6748D loginResult = newToken != null ? m13593a(origRequest, newToken) : null;
            if (isCanceled || (loginResult != null && loginResult.mo20006b().size() == 0)) {
                callback.onCancel();
            } else if (exception != null) {
                callback.onError(exception);
            } else if (newToken != null) {
                m13598a(true);
                callback.onSuccess(loginResult);
            }
        }
    }

    /* renamed from: a */
    private void m13598a(boolean isExpressLoginAllowed) {
        Editor editor = this.f12343e.edit();
        editor.putBoolean("express_login_allowed", isExpressLoginAllowed);
        editor.apply();
    }
}
