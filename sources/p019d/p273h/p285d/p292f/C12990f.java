package p019d.p273h.p285d.p292f;

import com.ironsource.sdk.data.C10888a;
import org.json.JSONObject;

/* renamed from: d.h.d.f.f */
/* compiled from: OnRewardedVideoListener */
public interface C12990f extends C12981a {
    void onRVAdClicked();

    void onRVAdClosed();

    void onRVAdCredited(int i);

    void onRVAdOpened();

    void onRVEventNotificationReceived(String str, JSONObject jSONObject);

    void onRVInitFail(String str);

    void onRVInitSuccess(C10888a aVar);

    void onRVNoMoreOffers();

    void onRVShowFail(String str);
}
