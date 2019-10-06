package com.facebook;

import android.content.Intent;
import android.support.p000v4.content.C0515e;
import com.facebook.internal.C6694S;
import com.facebook.internal.C6697T;

/* renamed from: com.facebook.G */
/* compiled from: ProfileManager */
public final class C6543G {

    /* renamed from: a */
    private static volatile C6543G f11798a;

    /* renamed from: b */
    private final C0515e f11799b;

    /* renamed from: c */
    private final C6540F f11800c;

    /* renamed from: d */
    private Profile f11801d;

    C6543G(C0515e localBroadcastManager, C6540F profileCache) {
        C6697T.m13461a((Object) localBroadcastManager, "localBroadcastManager");
        C6697T.m13461a((Object) profileCache, "profileCache");
        this.f11799b = localBroadcastManager;
        this.f11800c = profileCache;
    }

    /* renamed from: b */
    static C6543G m12869b() {
        if (f11798a == null) {
            synchronized (C6543G.class) {
                if (f11798a == null) {
                    f11798a = new C6543G(C0515e.m2597a(C6787r.m13815e()), new C6540F());
                }
            }
        }
        return f11798a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Profile mo19672a() {
        return this.f11801d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo19674c() {
        Profile profile = this.f11800c.mo19655b();
        if (profile == null) {
            return false;
        }
        m12868a(profile, false);
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19673a(Profile currentProfile) {
        m12868a(currentProfile, true);
    }

    /* renamed from: a */
    private void m12868a(Profile currentProfile, boolean writeToCache) {
        Profile oldProfile = this.f11801d;
        this.f11801d = currentProfile;
        if (writeToCache) {
            if (currentProfile != null) {
                this.f11800c.mo19654a(currentProfile);
            } else {
                this.f11800c.mo19653a();
            }
        }
        if (!C6694S.m13429a(oldProfile, currentProfile)) {
            m12867a(oldProfile, currentProfile);
        }
    }

    /* renamed from: a */
    private void m12867a(Profile oldProfile, Profile currentProfile) {
        Intent intent = new Intent("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_PROFILE", oldProfile);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_PROFILE", currentProfile);
        this.f11799b.mo5314a(intent);
    }
}
