package com.mopub.nativeads;

import com.mopub.nativeads.NativeVideoController.NativeVideoProgressRunnable.ProgressListener;

/* renamed from: com.mopub.nativeads.Ca */
/* compiled from: NativeVideoViewController */
class C11518Ca implements ProgressListener {

    /* renamed from: a */
    final /* synthetic */ NativeVideoViewController f35623a;

    C11518Ca(NativeVideoViewController this$0) {
        this.f35623a = this$0;
    }

    public void updateProgress(int progressTenthPercent) {
        this.f35623a.f35996g.updateProgress(progressTenthPercent);
    }
}
