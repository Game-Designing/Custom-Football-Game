package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.AdReport;
import com.mopub.common.DataKeys;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdLogEvent;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import java.util.Map;

public abstract class ResponseBodyInterstitial extends CustomEventInterstitial {
    public static final String ADAPTER_NAME = ResponseBodyInterstitial.class.getSimpleName();

    /* renamed from: b */
    private EventForwardingBroadcastReceiver f34913b;

    /* renamed from: c */
    protected Context f34914c;

    /* renamed from: d */
    protected AdReport f34915d;

    /* renamed from: e */
    protected long f34916e;

    /* renamed from: f */
    protected Map<String, Object> f34917f;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo37027a(CustomEventInterstitialListener customEventInterstitialListener);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo37028a(Map<String, String> map);

    public abstract void showInterstitial();

    public void loadInterstitial(Context context, CustomEventInterstitialListener customEventInterstitialListener, Map<String, Object> localExtras, Map<String, String> serverExtras) {
        MoPubLog.log(AdLogEvent.LOAD_ATTEMPTED, ADAPTER_NAME);
        this.f34914c = context;
        this.f34917f = localExtras;
        if (m37521b(serverExtras)) {
            mo37028a(serverExtras);
            try {
                this.f34915d = (AdReport) localExtras.get(DataKeys.AD_REPORT_KEY);
                Long boxedBroadcastId = (Long) localExtras.get(DataKeys.BROADCAST_IDENTIFIER_KEY);
                if (boxedBroadcastId == null) {
                    MoPubLog.log(AdLogEvent.CUSTOM, "Broadcast Identifier was not set in localExtras");
                    MoPubLog.log(AdLogEvent.LOAD_FAILED, ADAPTER_NAME, Integer.valueOf(MoPubErrorCode.INTERNAL_ERROR.getIntCode()), MoPubErrorCode.INTERNAL_ERROR);
                    customEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.INTERNAL_ERROR);
                    return;
                }
                this.f34916e = boxedBroadcastId.longValue();
                this.f34913b = new EventForwardingBroadcastReceiver(customEventInterstitialListener, this.f34916e);
                EventForwardingBroadcastReceiver eventForwardingBroadcastReceiver = this.f34913b;
                eventForwardingBroadcastReceiver.register(eventForwardingBroadcastReceiver, context);
                mo37027a(customEventInterstitialListener);
                MoPubLog.log(AdLogEvent.LOAD_SUCCESS, ADAPTER_NAME);
            } catch (ClassCastException e) {
                MoPubLog.log(AdLogEvent.CUSTOM, "LocalExtras contained an incorrect type.");
                MoPubLog.log(AdLogEvent.LOAD_FAILED, ADAPTER_NAME, Integer.valueOf(MoPubErrorCode.INTERNAL_ERROR.getIntCode()), MoPubErrorCode.INTERNAL_ERROR);
                customEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.INTERNAL_ERROR);
            }
        } else {
            MoPubLog.log(AdLogEvent.LOAD_FAILED, ADAPTER_NAME, Integer.valueOf(MoPubErrorCode.NETWORK_INVALID_STATE.getIntCode()), MoPubErrorCode.NETWORK_INVALID_STATE);
            customEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
        }
    }

    public void onInvalidate() {
        EventForwardingBroadcastReceiver eventForwardingBroadcastReceiver = this.f34913b;
        if (eventForwardingBroadcastReceiver != null) {
            eventForwardingBroadcastReceiver.unregister(eventForwardingBroadcastReceiver);
            this.f34913b = null;
        }
    }

    /* renamed from: b */
    private boolean m37521b(Map<String, String> serverExtras) {
        return serverExtras.containsKey(DataKeys.HTML_RESPONSE_BODY_KEY);
    }
}
