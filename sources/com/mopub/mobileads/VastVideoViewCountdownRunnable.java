package com.mopub.mobileads;

import android.os.Handler;
import com.mopub.common.Preconditions;

public class VastVideoViewCountdownRunnable extends RepeatingHandlerRunnable {

    /* renamed from: d */
    private final VastVideoViewController f35103d;

    public VastVideoViewCountdownRunnable(VastVideoViewController videoViewController, Handler handler) {
        super(handler);
        Preconditions.checkNotNull(handler);
        Preconditions.checkNotNull(videoViewController);
        this.f35103d = videoViewController;
    }

    public void doWork() {
        this.f35103d.mo37371n();
        if (this.f35103d.mo37370m()) {
            this.f35103d.mo37369l();
        }
    }
}
