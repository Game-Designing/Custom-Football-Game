package com.mopub.mraid;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import com.mopub.common.CloseableLayout.ClosePosition;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mraid.MraidBridge.MraidBridgeListener;
import java.net.URI;

/* renamed from: com.mopub.mraid.n */
/* compiled from: MraidController */
class C11497n implements MraidBridgeListener {

    /* renamed from: a */
    final /* synthetic */ MraidController f35574a;

    C11497n(MraidController this$0) {
        this.f35574a = this$0;
    }

    public void onPageLoaded() {
        this.f35574a.mo37652d();
        if (this.f35574a.f35503k != null) {
            this.f35574a.f35503k.onLoaded(this.f35574a.f35497e);
        }
    }

    public void onPageFailedToLoad() {
        if (this.f35574a.f35503k != null) {
            this.f35574a.f35503k.onFailedToLoad();
        }
    }

    public void onRenderProcessGone(MoPubErrorCode errorCode) {
        this.f35574a.mo37640a(errorCode);
    }

    public void onVisibilityChanged(boolean isVisible) {
        if (!this.f35574a.f35509q.mo37611b()) {
            this.f35574a.f35508p.mo37607a(isVisible);
        }
    }

    public boolean onJsAlert(String message, JsResult result) {
        return this.f35574a.mo37647a(message, result);
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return this.f35574a.mo37645a(consoleMessage);
    }

    public void onClose() {
        this.f35574a.mo37651c();
    }

    public void onResize(int width, int height, int offsetX, int offsetY, ClosePosition closePosition, boolean allowOffscreen) throws C11493j {
        this.f35574a.mo37639a(width, height, offsetX, offsetY, closePosition, allowOffscreen);
    }

    public void onExpand(URI uri, boolean shouldUseCustomClose) throws C11493j {
        this.f35574a.mo37642a(uri, shouldUseCustomClose);
    }

    public void onUseCustomClose(boolean shouldUseCustomClose) {
        this.f35574a.mo37643a(shouldUseCustomClose);
    }

    public void onSetOrientationProperties(boolean allowOrientationChange, C11472B forceOrientation) throws C11493j {
        this.f35574a.mo37644a(allowOrientationChange, forceOrientation);
    }

    public void onOpen(URI uri) {
        this.f35574a.mo37641a(uri.toString());
    }

    public void onPlayVideo(URI uri) {
        this.f35574a.mo37650b(uri.toString());
    }
}
