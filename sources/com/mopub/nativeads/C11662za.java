package com.mopub.nativeads;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.mopub.nativeads.za */
/* compiled from: NativeVideoViewController */
class C11662za implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ NativeVideoViewController f36272a;

    C11662za(NativeVideoViewController this$0) {
        this.f36272a = this$0;
    }

    public void onClick(View v) {
        this.f36272a.mo38056a(C11558a.PAUSED, true);
        this.f36272a.mo36923a().onFinish();
    }
}
