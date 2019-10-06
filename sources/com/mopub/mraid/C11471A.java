package com.mopub.mraid;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: com.mopub.mraid.A */
/* compiled from: MraidNativeCommandHandler */
class C11471A implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f35458a;

    /* renamed from: b */
    final /* synthetic */ String f35459b;

    /* renamed from: c */
    final /* synthetic */ C11483c f35460c;

    /* renamed from: d */
    final /* synthetic */ MraidNativeCommandHandler f35461d;

    C11471A(MraidNativeCommandHandler this$0, Context context, String str, C11483c cVar) {
        this.f35461d = this$0;
        this.f35458a = context;
        this.f35459b = str;
        this.f35460c = cVar;
    }

    public void onClick(DialogInterface dialog, int which) {
        this.f35461d.mo37678a(this.f35458a, this.f35459b, this.f35460c);
    }
}
