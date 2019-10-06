package com.integralads.avid.library.mopub.session.internal.jsbridge;

import android.os.Handler;
import android.webkit.JavascriptInterface;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSessionContext;

public class AvidJavascriptInterface {
    public static final String AVID_OBJECT = "avid";
    private final InternalAvidAdSessionContext avidAdSessionContext;
    /* access modifiers changed from: private */
    public AvidJavascriptInterfaceCallback callback;
    private final Handler handler = new Handler();

    public interface AvidJavascriptInterfaceCallback {
        void onAvidAdSessionContextInvoked();
    }

    class CallbackRunnable implements Runnable {
        CallbackRunnable() {
        }

        public void run() {
            if (AvidJavascriptInterface.this.callback != null) {
                AvidJavascriptInterface.this.callback.onAvidAdSessionContextInvoked();
                AvidJavascriptInterface.this.callback = null;
            }
        }
    }

    public AvidJavascriptInterface(InternalAvidAdSessionContext avidAdSessionContext2) {
        this.avidAdSessionContext = avidAdSessionContext2;
    }

    public AvidJavascriptInterfaceCallback getCallback() {
        return this.callback;
    }

    public void setCallback(AvidJavascriptInterfaceCallback callback2) {
        this.callback = callback2;
    }

    @JavascriptInterface
    public String getAvidAdSessionContext() {
        this.handler.post(new CallbackRunnable());
        return this.avidAdSessionContext.getStubContext().toString();
    }
}
