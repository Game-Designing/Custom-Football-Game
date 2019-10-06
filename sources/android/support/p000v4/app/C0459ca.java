package android.support.p000v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.os.Bundle;
import android.support.p000v4.app.C0448aa.C0449a;
import android.util.Log;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.List;

/* renamed from: android.support.v4.app.ca */
/* compiled from: NotificationCompatJellybean */
class C0459ca {

    /* renamed from: a */
    private static final Object f1567a = new Object();

    /* renamed from: b */
    private static Field f1568b;

    /* renamed from: c */
    private static boolean f1569c;

    /* renamed from: d */
    private static final Object f1570d = new Object();

    /* renamed from: a */
    public static SparseArray<Bundle> m2357a(List<Bundle> actionExtrasList) {
        SparseArray<Bundle> actionExtrasMap = null;
        int count = actionExtrasList.size();
        for (int i = 0; i < count; i++) {
            Bundle actionExtras = (Bundle) actionExtrasList.get(i);
            if (actionExtras != null) {
                if (actionExtrasMap == null) {
                    actionExtrasMap = new SparseArray<>();
                }
                actionExtrasMap.put(i, actionExtras);
            }
        }
        return actionExtrasMap;
    }

    /* renamed from: a */
    public static Bundle m2355a(Notification notif) {
        synchronized (f1567a) {
            if (f1569c) {
                return null;
            }
            try {
                if (f1568b == null) {
                    Field extrasField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(extrasField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f1569c = true;
                        return null;
                    }
                    extrasField.setAccessible(true);
                    f1568b = extrasField;
                }
                Bundle extras = (Bundle) f1568b.get(notif);
                if (extras == null) {
                    extras = new Bundle();
                    f1568b.set(notif, extras);
                }
                return extras;
            } catch (IllegalAccessException e) {
                Log.e("NotificationCompat", "Unable to access notification extras", e);
                f1569c = true;
                return null;
            } catch (NoSuchFieldException e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                f1569c = true;
                return null;
            }
        }
    }

    /* renamed from: a */
    public static Bundle m2354a(Builder builder, C0449a action) {
        builder.addAction(action.mo5100e(), action.mo5102g(), action.mo5096a());
        Bundle actionExtras = new Bundle(action.mo5099d());
        if (action.mo5101f() != null) {
            actionExtras.putParcelableArray("android.support.remoteInputs", m2358a(action.mo5101f()));
        }
        if (action.mo5098c() != null) {
            actionExtras.putParcelableArray("android.support.dataRemoteInputs", m2358a(action.mo5098c()));
        }
        actionExtras.putBoolean("android.support.allowGeneratedReplies", action.mo5097b());
        return actionExtras;
    }

    /* renamed from: a */
    private static Bundle m2356a(C0466ea remoteInput) {
        new Bundle();
        remoteInput.mo5145a();
        throw null;
    }

    /* renamed from: a */
    private static Bundle[] m2358a(C0466ea[] remoteInputs) {
        if (remoteInputs == null) {
            return null;
        }
        Bundle[] bundles = new Bundle[remoteInputs.length];
        if (0 >= remoteInputs.length) {
            return bundles;
        }
        m2356a(remoteInputs[0]);
        throw null;
    }
}
