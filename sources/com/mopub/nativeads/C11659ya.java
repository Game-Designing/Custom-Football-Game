package com.mopub.nativeads;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.mopub.nativeads.ya */
/* compiled from: NativeVideoViewController */
class C11659ya implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ NativeVideoViewController f36267a;

    C11659ya(NativeVideoViewController this$0) {
        this.f36267a = this$0;
    }

    public void onClick(View v) {
        if (this.f36267a.f35999j) {
            this.f36267a.f35999j = false;
            this.f36267a.f35996g.resetProgress();
            this.f36267a.f35997h.seekTo(0);
        }
        this.f36267a.mo38055a(C11558a.PLAYING);
    }
}
