package com.vungle.warren;

import android.support.p000v4.p037os.ResultReceiver;

public interface PublisherDirectDownload {
    ResultReceiver getPublisherReceiver();

    void setSDKCallbackReceiver(ResultReceiver resultReceiver);
}
