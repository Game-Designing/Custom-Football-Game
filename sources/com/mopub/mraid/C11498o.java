package com.mopub.mraid;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import com.mopub.common.CloseableLayout.ClosePosition;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mraid.MraidBridge.MraidBridgeListener;
import java.net.URI;

/* renamed from: com.mopub.mraid.o */
/* compiled from: MraidController */
class C11498o implements MraidBridgeListener {

    /* renamed from: a */
    final /* synthetic */ MraidController f35575a;

    C11498o(MraidController this$0) {
        this.f35575a = this$0;
    }

    public void onPageLoaded() {
        this.f35575a.mo37654e();
    }

    public void onPageFailedToLoad() {
    }

    public void onRenderProcessGone(MoPubErrorCode errorCode) {
        this.f35575a.mo37640a(errorCode);
    }

    public void onVisibilityChanged(boolean isVisible) {
        this.f35575a.f35508p.mo37607a(isVisible);
        this.f35575a.f35509q.mo37607a(isVisible);
    }

    public boolean onJsAlert(String message, JsResult result) {
        return this.f35575a.mo37647a(message, result);
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return this.f35575a.mo37645a(consoleMessage);
    }

    public void onResize(int width, int height, int offsetX, int offsetY, ClosePosition closePosition, boolean allowOffscreen) throws C11493j {
        throw new C11493j("Not allowed to resize from an expanded state");
    }

    public void onExpand(URI uri, boolean shouldUseCustomClose) {
    }

    public void onClose() {
        this.f35575a.mo37651c();
    }

    public void onUseCustomClose(boolean shouldUseCustomClose) {
        this.f35575a.mo37643a(shouldUseCustomClose);
    }

    public void onSetOrientationProperties(boolean allowOrientationChange, C11472B forceOrientation) throws C11493j {
        this.f35575a.mo37644a(allowOrientationChange, forceOrientation);
    }

    public void onOpen(URI uri) {
        this.f35575a.mo37641a(uri.toString());
    }

    public void onPlayVideo(URI uri) {
        this.f35575a.mo37650b(uri.toString());
    }
}
