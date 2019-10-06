package com.mopub.common;

import android.content.Context;

/* renamed from: com.mopub.common.K */
/* compiled from: UrlHandler */
class C11235K implements C11237a {

    /* renamed from: a */
    final /* synthetic */ Context f34327a;

    /* renamed from: b */
    final /* synthetic */ boolean f34328b;

    /* renamed from: c */
    final /* synthetic */ Iterable f34329c;

    /* renamed from: d */
    final /* synthetic */ String f34330d;

    /* renamed from: e */
    final /* synthetic */ UrlHandler f34331e;

    C11235K(UrlHandler this$0, Context context, boolean z, Iterable iterable, String str) {
        this.f34331e = this$0;
        this.f34327a = context;
        this.f34328b = z;
        this.f34329c = iterable;
        this.f34330d = str;
    }

    public void onSuccess(String resolvedUrl) {
        this.f34331e.f34364i = false;
        this.f34331e.handleResolvedUrl(this.f34327a, resolvedUrl, this.f34328b, this.f34329c);
    }

    public void onFailure(String message, Throwable throwable) {
        this.f34331e.f34364i = false;
        this.f34331e.m37046a(this.f34330d, null, message, throwable);
    }
}
