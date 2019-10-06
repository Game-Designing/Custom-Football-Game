package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.support.p000v4.app.C0014p;
import android.support.p000v4.app.C0448aa.C0450b;
import android.support.p000v4.app.C0448aa.C0451c;
import android.support.p000v4.app.C0448aa.C0452d;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import com.google.android.gms.base.C8625R;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.api.internal.zabr;
import com.google.android.gms.common.internal.ConnectionErrorMessages;
import com.google.android.gms.common.internal.DialogRedirect;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.base.zap;
import p005cm.aptoide.p006pt.downloadmanager.Constants;

public class GoogleApiAvailability extends GoogleApiAvailabilityLight {

    /* renamed from: c */
    private static final Object f19520c = new Object();

    /* renamed from: d */
    private static final GoogleApiAvailability f19521d = new GoogleApiAvailability();

    /* renamed from: e */
    public static final int f19522e = GoogleApiAvailabilityLight.f19526a;

    /* renamed from: f */
    private String f19523f;

    @SuppressLint({"HandlerLeak"})
    /* renamed from: com.google.android.gms.common.GoogleApiAvailability$a */
    private class C8627a extends zap {

        /* renamed from: b */
        private final Context f19524b;

        public C8627a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.f19524b = context.getApplicationContext();
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                StringBuilder sb = new StringBuilder(50);
                sb.append("Don't know how to handle this message: ");
                sb.append(i);
                Log.w("GoogleApiAvailability", sb.toString());
            } else {
                int isGooglePlayServicesAvailable = GoogleApiAvailability.this.isGooglePlayServicesAvailable(this.f19524b);
                if (GoogleApiAvailability.this.mo27307c(isGooglePlayServicesAvailable)) {
                    GoogleApiAvailability.this.mo27306c(this.f19524b, isGooglePlayServicesAvailable);
                }
            }
        }
    }

    public static GoogleApiAvailability getInstance() {
        return f19521d;
    }

    /* renamed from: a */
    public Dialog mo27295a(Activity activity, int i, int i2) {
        return mo27296a(activity, i, i2, (OnCancelListener) null);
    }

    /* renamed from: a */
    public Dialog mo27296a(Activity activity, int i, int i2, OnCancelListener onCancelListener) {
        return m21068a((Context) activity, i, DialogRedirect.m21807a(activity, mo27299a((Context) activity, i, "d"), i2), onCancelListener);
    }

    /* renamed from: a */
    public final boolean mo27301a(Activity activity, LifecycleFragment lifecycleFragment, int i, int i2, OnCancelListener onCancelListener) {
        Dialog a = m21068a((Context) activity, i, DialogRedirect.m21809a(lifecycleFragment, mo27299a((Context) activity, i, "d"), 2), onCancelListener);
        if (a == null) {
            return false;
        }
        m21070a(activity, a, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    /* renamed from: b */
    public boolean mo27304b(Activity activity, int i, int i2, OnCancelListener onCancelListener) {
        Dialog a = mo27296a(activity, i, i2, onCancelListener);
        if (a == null) {
            return false;
        }
        m21070a(activity, a, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    /* renamed from: c */
    public void mo27306c(Context context, int i) {
        m21071a(context, i, (String) null, mo27310a(context, i, 0, "n"));
    }

    /* renamed from: a */
    public final boolean mo27302a(Context context, ConnectionResult connectionResult, int i) {
        PendingIntent a = mo27298a(context, connectionResult);
        if (a == null) {
            return false;
        }
        m21071a(context, connectionResult.mo27275a(), (String) null, GoogleApiActivity.m21143a(context, a, i));
        return true;
    }

    /* renamed from: a */
    public static Dialog m21067a(Activity activity, OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        Builder builder = new Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(ConnectionErrorMessages.m21803b(activity, 18));
        builder.setPositiveButton("", null);
        AlertDialog create = builder.create();
        m21070a(activity, (Dialog) create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    /* renamed from: a */
    public final zabq mo27300a(Context context, zabr zabr) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme(Constants.PACKAGE);
        zabq zabq = new zabq(zabr);
        context.registerReceiver(zabq, intentFilter);
        zabq.mo27612a(context);
        if (mo27313a(context, "com.google.android.gms")) {
            return zabq;
        }
        zabr.mo27539a();
        zabq.mo27611a();
        return null;
    }

    /* renamed from: a */
    private final String m21069a() {
        String str;
        synchronized (f19520c) {
            str = this.f19523f;
        }
        return str;
    }

    @HideFirstParty
    public int isGooglePlayServicesAvailable(Context context) {
        return super.isGooglePlayServicesAvailable(context);
    }

    @ShowFirstParty
    @KeepForSdk
    /* renamed from: a */
    public int mo27294a(Context context, int i) {
        return super.mo27294a(context, i);
    }

    /* renamed from: c */
    public final boolean mo27307c(int i) {
        return super.mo27307c(i);
    }

    @ShowFirstParty
    @KeepForSdk
    /* renamed from: a */
    public Intent mo27299a(Context context, int i, String str) {
        return super.mo27299a(context, i, str);
    }

    /* renamed from: a */
    public PendingIntent mo27297a(Context context, int i, int i2) {
        return super.mo27297a(context, i, i2);
    }

    /* renamed from: a */
    public PendingIntent mo27298a(Context context, ConnectionResult connectionResult) {
        if (connectionResult.mo27279e()) {
            return connectionResult.mo27278d();
        }
        return mo27297a(context, connectionResult.mo27275a(), 0);
    }

    /* renamed from: b */
    public final String mo27303b(int i) {
        return super.mo27303b(i);
    }

    /* renamed from: a */
    static Dialog m21068a(Context context, int i, DialogRedirect dialogRedirect, OnCancelListener onCancelListener) {
        Builder builder = null;
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new Builder(context, 5);
        }
        if (builder == null) {
            builder = new Builder(context);
        }
        builder.setMessage(ConnectionErrorMessages.m21803b(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String a = ConnectionErrorMessages.m21799a(context, i);
        if (a != null) {
            builder.setPositiveButton(a, dialogRedirect);
        }
        String e = ConnectionErrorMessages.m21806e(context, i);
        if (e != null) {
            builder.setTitle(e);
        }
        return builder.create();
    }

    /* renamed from: a */
    static void m21070a(Activity activity, Dialog dialog, String str, OnCancelListener onCancelListener) {
        if (activity instanceof C0014p) {
            SupportErrorDialogFragment.m21106a(dialog, onCancelListener).show(((C0014p) activity).getSupportFragmentManager(), str);
            return;
        }
        ErrorDialogFragment.m21064a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    @TargetApi(20)
    /* renamed from: a */
    private final void m21071a(Context context, int i, String str, PendingIntent pendingIntent) {
        int i2;
        if (i == 18) {
            mo27305c(context);
        } else if (pendingIntent == null) {
            if (i == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
            }
        } else {
            String d = ConnectionErrorMessages.m21805d(context, i);
            String c = ConnectionErrorMessages.m21804c(context, i);
            Resources resources = context.getResources();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            C0451c cVar = new C0451c(context);
            cVar.mo5119b(true);
            cVar.mo5115a(true);
            cVar.mo5121c((CharSequence) d);
            C0450b bVar = new C0450b();
            bVar.mo5103a((CharSequence) c);
            cVar.mo5113a((C0452d) bVar);
            if (DeviceProperties.m22094c(context)) {
                Preconditions.m21867b(PlatformVersion.m22113g());
                cVar.mo5120c(context.getApplicationInfo().icon);
                cVar.mo5116b(2);
                if (DeviceProperties.m22095d(context)) {
                    cVar.mo5108a(C8625R.drawable.common_full_open_on_phone, (CharSequence) resources.getString(C8625R.string.common_open_on_phone), pendingIntent);
                } else {
                    cVar.mo5110a(pendingIntent);
                }
            } else {
                cVar.mo5120c(17301642);
                cVar.mo5123d(resources.getString(C8625R.string.common_google_play_services_notification_ticker));
                cVar.mo5109a(System.currentTimeMillis());
                cVar.mo5110a(pendingIntent);
                cVar.mo5118b((CharSequence) c);
            }
            if (PlatformVersion.m22117k()) {
                Preconditions.m21867b(PlatformVersion.m22117k());
                String a = m21069a();
                if (a == null) {
                    a = "com.google.android.gms.availability";
                    NotificationChannel notificationChannel = notificationManager.getNotificationChannel(a);
                    String b = ConnectionErrorMessages.m21802b(context);
                    if (notificationChannel == null) {
                        notificationManager.createNotificationChannel(new NotificationChannel(a, b, 4));
                    } else if (!b.contentEquals(notificationChannel.getName())) {
                        notificationChannel.setName(b);
                        notificationManager.createNotificationChannel(notificationChannel);
                    }
                }
                cVar.mo5114a(a);
            }
            Notification a2 = cVar.mo5105a();
            if (i == 1 || i == 2 || i == 3) {
                i2 = 10436;
                GooglePlayServicesUtilLight.sCanceledAvailabilityNotification.set(false);
            } else {
                i2 = 39789;
            }
            notificationManager.notify(i2, a2);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final void mo27305c(Context context) {
        new C8627a(context).sendEmptyMessageDelayed(1, 120000);
    }
}
