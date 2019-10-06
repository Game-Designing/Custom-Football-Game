package com.mopub.common.privacy;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.mopub.common.GpsHelper;
import com.mopub.common.GpsHelper.AdvertisingInfo;
import com.mopub.common.Preconditions;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.SdkInitializationListener;
import com.mopub.common.SharedPreferencesHelper;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.LogLevel;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.AsyncTasks;
import java.util.Calendar;

public class MoPubIdentifier {

    /* renamed from: a */
    private AdvertisingId f34457a;

    /* renamed from: b */
    private final Context f34458b;

    /* renamed from: c */
    private AdvertisingIdChangeListener f34459c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f34460d;

    /* renamed from: e */
    private boolean f34461e;

    /* renamed from: f */
    private volatile SdkInitializationListener f34462f;

    public interface AdvertisingIdChangeListener {
        void onIdChanged(AdvertisingId advertisingId, AdvertisingId advertisingId2);
    }

    /* renamed from: com.mopub.common.privacy.MoPubIdentifier$a */
    private class C11257a extends AsyncTask<Void, Void, Void> {
        private C11257a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voids) {
            MoPubIdentifier.this.mo36689a();
            MoPubIdentifier.this.f34460d = false;
            return null;
        }
    }

    public MoPubIdentifier(Context appContext) {
        this(appContext, null);
    }

    @VisibleForTesting
    MoPubIdentifier(Context appContext, AdvertisingIdChangeListener idChangeListener) {
        Preconditions.checkNotNull(appContext);
        this.f34458b = appContext;
        this.f34459c = idChangeListener;
        this.f34457a = m37106a(this.f34458b);
        if (this.f34457a == null) {
            this.f34457a = AdvertisingId.m37090a();
        }
        m37112c();
    }

    public AdvertisingId getAdvertisingInfo() {
        if (this.f34461e) {
            mo36692b();
        }
        AdvertisingId adInfo = this.f34457a;
        m37112c();
        return adInfo;
    }

    /* renamed from: c */
    private void m37112c() {
        if (!this.f34460d) {
            this.f34460d = true;
            AsyncTasks.safeExecuteOnExecutor(new C11257a(), new Void[0]);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36689a() {
        AdvertisingId newInfo;
        long time = Calendar.getInstance().getTimeInMillis();
        AdvertisingId oldInfo = this.f34457a;
        AdvertisingInfo googleAdInfo = GpsHelper.fetchAdvertisingInfoSync(this.f34458b);
        if (googleAdInfo == null || TextUtils.isEmpty(googleAdInfo.advertisingId)) {
            newInfo = m37111b(this.f34458b);
        } else {
            newInfo = new AdvertisingId(googleAdInfo.advertisingId, oldInfo.f34433c, googleAdInfo.limitAdTracking, oldInfo.f34431a.getTimeInMillis());
        }
        if (newInfo != null) {
            m37109a(newInfo.f34432b, oldInfo.mo36650e() ? AdvertisingId.m37092c() : oldInfo.f34433c, newInfo.f34434d, oldInfo.mo36650e() ? time : oldInfo.f34431a.getTimeInMillis());
        }
        mo36692b();
    }

    /* renamed from: a */
    static synchronized AdvertisingId m37106a(Context appContext) {
        synchronized (MoPubIdentifier.class) {
            Preconditions.checkNotNull(appContext);
            Calendar now = Calendar.getInstance();
            try {
                SharedPreferences preferences = SharedPreferencesHelper.getSharedPreferences(appContext, "com.mopub.settings.identifier");
                String ifa_id = preferences.getString("privacy.identifier.ifa", "");
                String mopub_id = preferences.getString("privacy.identifier.mopub", "");
                long time = preferences.getLong("privacy.identifier.time", now.getTimeInMillis());
                boolean limitTracking = preferences.getBoolean("privacy.limit.ad.tracking", false);
                if (!TextUtils.isEmpty(ifa_id) && !TextUtils.isEmpty(mopub_id)) {
                    AdvertisingId advertisingId = new AdvertisingId(ifa_id, mopub_id, limitTracking, time);
                    return advertisingId;
                }
            } catch (ClassCastException e) {
                MoPubLog.log(SdkLogEvent.CUSTOM, "Cannot read identifier from shared preferences");
            }
            return null;
        }
    }

    /* renamed from: a */
    private static synchronized void m37107a(Context context, AdvertisingId info) {
        synchronized (MoPubIdentifier.class) {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(info);
            Editor editor = SharedPreferencesHelper.getSharedPreferences(context, "com.mopub.settings.identifier").edit();
            editor.putBoolean("privacy.limit.ad.tracking", info.f34434d);
            editor.putString("privacy.identifier.ifa", info.f34432b);
            editor.putString("privacy.identifier.mopub", info.f34433c);
            editor.putLong("privacy.identifier.time", info.f34431a.getTimeInMillis());
            editor.apply();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo36692b() {
        if (this.f34457a.f34432b.endsWith("10ca1ad1abe1")) {
            MoPubLog.setLogLevel(LogLevel.DEBUG);
        }
        if (!this.f34457a.mo36650e()) {
            mo36691a(this.f34457a);
        } else {
            mo36691a(AdvertisingId.m37091b());
        }
    }

    /* renamed from: a */
    private void m37109a(String advertisingId, String mopubId, boolean limitAdTracking, long rotationTime) {
        Preconditions.checkNotNull(advertisingId);
        Preconditions.checkNotNull(mopubId);
        AdvertisingId advertisingId2 = new AdvertisingId(advertisingId, mopubId, limitAdTracking, rotationTime);
        mo36691a(advertisingId2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36691a(AdvertisingId newId) {
        AdvertisingId oldId = this.f34457a;
        this.f34457a = newId;
        m37107a(this.f34458b, this.f34457a);
        if (!this.f34457a.equals(oldId) || !this.f34461e) {
            m37108a(oldId, this.f34457a);
        }
        this.f34461e = true;
        m37113d();
    }

    public void setIdChangeListener(AdvertisingIdChangeListener idChangeListener) {
        this.f34459c = idChangeListener;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36690a(SdkInitializationListener initializationListener) {
        this.f34462f = initializationListener;
        if (this.f34461e) {
            m37113d();
        }
    }

    /* renamed from: d */
    private synchronized void m37113d() {
        SdkInitializationListener listener = this.f34462f;
        if (listener != null) {
            this.f34462f = null;
            listener.onInitializationFinished();
        }
    }

    /* renamed from: a */
    private void m37108a(AdvertisingId oldId, AdvertisingId newId) {
        Preconditions.checkNotNull(newId);
        AdvertisingIdChangeListener advertisingIdChangeListener = this.f34459c;
        if (advertisingIdChangeListener != null) {
            advertisingIdChangeListener.onIdChanged(oldId, newId);
        }
    }

    /* renamed from: b */
    private AdvertisingId m37111b(Context context) {
        NoThrow.checkNotNull(context);
        ContentResolver resolver = context.getContentResolver();
        int limitAdTracking = Secure.getInt(resolver, "limit_ad_tracking", -1);
        String advertisingId = Secure.getString(resolver, "advertising_id");
        if (limitAdTracking == -1 || TextUtils.isEmpty(advertisingId)) {
            return null;
        }
        boolean doNotTrack = limitAdTracking != 0;
        AdvertisingId oldId = this.f34457a;
        AdvertisingId advertisingId2 = new AdvertisingId(advertisingId, oldId.f34433c, doNotTrack, oldId.f34431a.getTimeInMillis());
        return advertisingId2;
    }
}
