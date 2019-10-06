package p019d.p273h.p285d.p292f;

import org.json.JSONObject;

/* renamed from: d.h.d.f.e */
/* compiled from: OnOfferWallListener */
public interface C12989e {
    void onGetOWCreditsFailed(String str);

    void onOWAdClosed();

    boolean onOWAdCredited(int i, int i2, boolean z);

    void onOWGeneric(String str, String str2);

    void onOWShowFail(String str);

    void onOWShowSuccess(String str);

    void onOfferwallEventNotificationReceived(String str, JSONObject jSONObject);

    void onOfferwallInitFail(String str);

    void onOfferwallInitSuccess();
}
