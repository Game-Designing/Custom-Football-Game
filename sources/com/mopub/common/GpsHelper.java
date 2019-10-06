package com.mopub.common;

import android.content.Context;
import android.os.AsyncTask;
import com.mopub.common.factories.MethodBuilderFactory;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.Reflection;
import java.lang.ref.WeakReference;

public class GpsHelper {
    public static final int GOOGLE_PLAY_SUCCESS_CODE = 0;
    public static final String IS_LIMIT_AD_TRACKING_ENABLED_KEY = "isLimitAdTrackingEnabled";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static String f34324a = "com.google.android.gms.ads.identifier.AdvertisingIdClient";

    public static class AdvertisingInfo {
        public final String advertisingId;
        public final boolean limitAdTracking;

        public AdvertisingInfo(String adId, boolean limitAdTrackingEnabled) {
            this.advertisingId = adId;
            this.limitAdTracking = limitAdTrackingEnabled;
        }
    }

    public interface GpsHelperListener {
        void onFetchAdInfoCompleted();
    }

    /* renamed from: com.mopub.common.GpsHelper$a */
    private static class C11231a extends AsyncTask<Void, Void, Void> {

        /* renamed from: a */
        private WeakReference<Context> f34325a;

        /* renamed from: b */
        private WeakReference<GpsHelperListener> f34326b;

        public C11231a(Context context, GpsHelperListener gpsHelperListener) {
            this.f34325a = new WeakReference<>(context);
            this.f34326b = new WeakReference<>(gpsHelperListener);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voids) {
            try {
                Context context = (Context) this.f34325a.get();
                if (context == null) {
                    return null;
                }
                Object execute = MethodBuilderFactory.create(null, "getAdvertisingIdInfo").setStatic(Class.forName(GpsHelper.f34324a)).addParam(Context.class, context).execute();
                return null;
            } catch (Exception e) {
                MoPubLog.log(SdkLogEvent.CUSTOM, "Unable to obtain Google AdvertisingIdClient.Info via reflection.");
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Void aVoid) {
            GpsHelperListener gpsHelperListener = (GpsHelperListener) this.f34326b.get();
            if (gpsHelperListener != null) {
                gpsHelperListener.onFetchAdInfoCompleted();
            }
        }
    }

    public static boolean isLimitAdTrackingEnabled(Context context) {
        return SharedPreferencesHelper.getSharedPreferences(context).getBoolean(IS_LIMIT_AD_TRACKING_ENABLED_KEY, false);
    }

    public static void fetchAdvertisingInfoAsync(Context context, GpsHelperListener gpsHelperListener) {
        m37012a(context, gpsHelperListener);
    }

    public static AdvertisingInfo fetchAdvertisingInfoSync(Context context) {
        if (context == null) {
            return null;
        }
        try {
            Object adInfo = MethodBuilderFactory.create(null, "getAdvertisingIdInfo").setStatic(Class.forName(f34324a)).addParam(Context.class, context).execute();
            return new AdvertisingInfo(m37011a(adInfo, (String) null), m37013a(adInfo, false));
        } catch (Exception e) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Unable to obtain Google AdvertisingIdClient.Info via reflection.");
            return null;
        }
    }

    /* renamed from: a */
    private static void m37012a(Context context, GpsHelperListener gpsHelperListener) {
        if (!Reflection.classFound(f34324a)) {
            if (gpsHelperListener != null) {
                gpsHelperListener.onFetchAdInfoCompleted();
            }
            return;
        }
        try {
            AsyncTasks.safeExecuteOnExecutor(new C11231a(context, gpsHelperListener), new Void[0]);
        } catch (Exception exception) {
            MoPubLog.log(SdkLogEvent.ERROR, "Error executing FetchAdvertisingInfoTask", exception);
            if (gpsHelperListener != null) {
                gpsHelperListener.onFetchAdInfoCompleted();
            }
        }
    }

    /* renamed from: a */
    static String m37011a(Object adInfo, String defaultValue) {
        try {
            return (String) MethodBuilderFactory.create(adInfo, "getId").execute();
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /* renamed from: a */
    static boolean m37013a(Object adInfo, boolean defaultValue) {
        try {
            Boolean result = (Boolean) MethodBuilderFactory.create(adInfo, IS_LIMIT_AD_TRACKING_ENABLED_KEY).execute();
            return result != null ? result.booleanValue() : defaultValue;
        } catch (Exception e) {
            return defaultValue;
        }
    }
}
