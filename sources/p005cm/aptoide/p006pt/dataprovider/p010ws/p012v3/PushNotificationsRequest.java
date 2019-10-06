package p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3;

import android.content.SharedPreferences;
import android.text.TextUtils;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.preferences.managed.ManagerPreferences;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v3.PushNotificationsRequest */
public class PushNotificationsRequest extends C2847V3<GetPushNotificationsResponse> {
    protected PushNotificationsRequest(BaseBody baseBody, BodyInterceptor<BaseBody> bodyInterceptor, TokenInvalidator tokenInvalidator) {
        super("https://webservices.aptoide.com/webservices/3/", baseBody, bodyInterceptor, tokenInvalidator);
    }

    /* renamed from: of */
    public static PushNotificationsRequest m7453of(SharedPreferences sharedPreferences, String oemId, BodyInterceptor<BaseBody> bodyInterceptor, TokenInvalidator tokenInvalidator, int applicationVersionCode, int lastPushNotificationId, String countryCode) {
        BaseBody args = new BaseBody();
        args.put("oem_id", oemId);
        args.put("mode", "json");
        args.put("limit", "1");
        args.put("lang", countryCode);
        String str = "notification_type";
        if (ManagerPreferences.isDebug(sharedPreferences)) {
            String notificationType = ManagerPreferences.getNotificationType(sharedPreferences);
            args.put(str, TextUtils.isEmpty(notificationType) ? "aptoide_tests" : notificationType);
        } else {
            args.put(str, "aptoide_vanilla");
        }
        args.put("id", String.valueOf(lastPushNotificationId));
        args.put("aptoide_vercode", Integer.toString(applicationVersionCode));
        return new PushNotificationsRequest(args, bodyInterceptor, tokenInvalidator);
    }

    /* access modifiers changed from: protected */
    public C0120S<GetPushNotificationsResponse> loadDataFromNetwork(Service service, boolean bypassCache) {
        return service.getPushNotifications(this.map, bypassCache);
    }
}
