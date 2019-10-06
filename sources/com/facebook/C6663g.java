package com.facebook;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.p000v4.content.C0515e;
import com.facebook.AccessToken.C6535a;
import com.facebook.C6814y.C6815a;
import com.facebook.GraphRequest.C6545b;
import com.facebook.internal.C6694S;
import com.facebook.internal.C6697T;
import java.util.Date;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import p005cm.aptoide.p006pt.notification.PullingContentService;

/* renamed from: com.facebook.g */
/* compiled from: AccessTokenManager */
public final class C6663g {

    /* renamed from: a */
    private static volatile C6663g f12141a;

    /* renamed from: b */
    private final C0515e f12142b;

    /* renamed from: c */
    private final C6649b f12143c;

    /* renamed from: d */
    private AccessToken f12144d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public AtomicBoolean f12145e = new AtomicBoolean(false);

    /* renamed from: f */
    private Date f12146f = new Date(0);

    /* renamed from: com.facebook.g$a */
    /* compiled from: AccessTokenManager */
    private static class C6664a {

        /* renamed from: a */
        public String f12147a;

        /* renamed from: b */
        public int f12148b;

        /* renamed from: c */
        public Long f12149c;

        private C6664a() {
        }

        /* synthetic */ C6664a(C6653c x0) {
            this();
        }
    }

    C6663g(C0515e localBroadcastManager, C6649b accessTokenCache) {
        C6697T.m13461a((Object) localBroadcastManager, "localBroadcastManager");
        C6697T.m13461a((Object) accessTokenCache, "accessTokenCache");
        this.f12142b = localBroadcastManager;
        this.f12143c = accessTokenCache;
    }

    /* renamed from: d */
    static C6663g m13290d() {
        if (f12141a == null) {
            synchronized (C6663g.class) {
                if (f12141a == null) {
                    f12141a = new C6663g(C0515e.m2597a(C6787r.m13815e()), new C6649b());
                }
            }
        }
        return f12141a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public AccessToken mo19871c() {
        return this.f12144d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public boolean mo19872e() {
        AccessToken accessToken = this.f12143c.mo19859b();
        if (accessToken == null) {
            return false;
        }
        m13286a(accessToken, false);
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19869a(AccessToken currentAccessToken) {
        m13286a(currentAccessToken, true);
    }

    /* renamed from: a */
    private void m13286a(AccessToken currentAccessToken, boolean saveToCache) {
        AccessToken oldAccessToken = this.f12144d;
        this.f12144d = currentAccessToken;
        this.f12145e.set(false);
        this.f12146f = new Date(0);
        if (saveToCache) {
            if (currentAccessToken != null) {
                this.f12143c.mo19858a(currentAccessToken);
            } else {
                this.f12143c.mo19857a();
                C6694S.m13415a(C6787r.m13815e());
            }
        }
        if (!C6694S.m13429a(oldAccessToken, currentAccessToken)) {
            m13285a(oldAccessToken, currentAccessToken);
            m13291f();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19867a() {
        AccessToken accessToken = this.f12144d;
        m13285a(accessToken, accessToken);
    }

    /* renamed from: a */
    private void m13285a(AccessToken oldAccessToken, AccessToken currentAccessToken) {
        Intent intent = new Intent(C6787r.m13815e(), CurrentAccessTokenExpirationBroadcastReceiver.class);
        intent.setAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN", oldAccessToken);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN", currentAccessToken);
        this.f12142b.mo5314a(intent);
    }

    /* renamed from: f */
    private void m13291f() {
        Context context = C6787r.m13815e();
        AccessToken accessToken = AccessToken.m12820c();
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (AccessToken.m12821m() && accessToken.mo19626g() != null && alarmManager != null) {
            Intent intent = new Intent(context, CurrentAccessTokenExpirationBroadcastReceiver.class);
            intent.setAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
            alarmManager.set(1, accessToken.mo19626g().getTime(), PendingIntent.getBroadcast(context, 0, intent, 0));
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo19870b() {
        if (m13292g()) {
            mo19868a((C6535a) null);
        }
    }

    /* renamed from: g */
    private boolean m13292g() {
        boolean z = false;
        if (this.f12144d == null) {
            return false;
        }
        Long now = Long.valueOf(new Date().getTime());
        if (this.f12144d.mo19630j().mo19873e() && now.longValue() - this.f12146f.getTime() > 3600000 && now.longValue() - this.f12144d.mo19627h().getTime() > PullingContentService.UPDATES_INTERVAL) {
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    private static GraphRequest m13288b(AccessToken accessToken, C6545b callback) {
        AccessToken accessToken2 = accessToken;
        GraphRequest graphRequest = new GraphRequest(accessToken2, "me/permissions", new Bundle(), C6534A.GET, callback);
        return graphRequest;
    }

    /* renamed from: a */
    private static GraphRequest m13283a(AccessToken accessToken, C6545b callback) {
        Bundle parameters = new Bundle();
        parameters.putString("grant_type", "fb_extend_sso_token");
        AccessToken accessToken2 = accessToken;
        GraphRequest graphRequest = new GraphRequest(accessToken2, "oauth/access_token", parameters, C6534A.GET, callback);
        return graphRequest;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19868a(C6535a callback) {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            m13289b(callback);
        } else {
            new Handler(Looper.getMainLooper()).post(new C6653c(this, callback));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m13289b(C6535a callback) {
        C6535a aVar = callback;
        AccessToken accessToken = this.f12144d;
        if (accessToken == null) {
            if (aVar != null) {
                aVar.mo19638a(new FacebookException("No current access token to refresh"));
            }
        } else if (!this.f12145e.compareAndSet(false, true)) {
            if (aVar != null) {
                aVar.mo19638a(new FacebookException("Refresh already in progress"));
            }
        } else {
            this.f12146f = new Date();
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet();
            AtomicBoolean permissionsCallSucceeded = new AtomicBoolean(false);
            C6664a refreshResult = new C6664a(null);
            C6660d dVar = new C6660d(this, permissionsCallSucceeded, hashSet, hashSet2, hashSet3);
            C6814y batch = new C6814y(m13288b(accessToken, dVar), m13283a(accessToken, (C6545b) new C6661e(this, refreshResult)));
            C6664a aVar2 = refreshResult;
            AccessToken accessToken2 = accessToken;
            C6662f fVar = new C6662f(this, accessToken, callback, permissionsCallSucceeded, refreshResult, hashSet, hashSet2, hashSet3);
            batch.mo20207a((C6815a) fVar);
            batch.mo20213c();
        }
    }
}
