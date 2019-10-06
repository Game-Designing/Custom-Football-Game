package android.support.p000v4.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.app.SharedElementCallback.OnSharedElementsReadyListener;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.p000v4.app.C0469fa.C0470a;
import android.support.p000v4.content.C0510b;
import android.view.View;
import java.util.List;
import java.util.Map;

/* renamed from: android.support.v4.app.b */
/* compiled from: ActivityCompat */
public class C0453b extends C0510b {

    /* renamed from: c */
    private static C0454b f1555c;

    /* renamed from: android.support.v4.app.b$a */
    /* compiled from: ActivityCompat */
    public interface C0007a {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    /* renamed from: android.support.v4.app.b$c */
    /* compiled from: ActivityCompat */
    public interface C0008c {
        void validateRequestPermissionsRequestCode(int i);
    }

    /* renamed from: android.support.v4.app.b$b */
    /* compiled from: ActivityCompat */
    public interface C0454b {
        /* renamed from: a */
        boolean mo5129a(Activity activity, int i, int i2, Intent intent);

        /* renamed from: a */
        boolean mo5130a(Activity activity, String[] strArr, int i);
    }

    /* renamed from: android.support.v4.app.b$d */
    /* compiled from: ActivityCompat */
    private static class C0455d extends SharedElementCallback {

        /* renamed from: a */
        protected C0469fa f1556a;

        C0455d(C0469fa callback) {
            this.f1556a = callback;
        }

        public void onSharedElementStart(List<String> sharedElementNames, List<View> sharedElements, List<View> sharedElementSnapshots) {
            this.f1556a.mo5169b(sharedElementNames, sharedElements, sharedElementSnapshots);
        }

        public void onSharedElementEnd(List<String> sharedElementNames, List<View> sharedElements, List<View> sharedElementSnapshots) {
            this.f1556a.mo5167a(sharedElementNames, sharedElements, sharedElementSnapshots);
        }

        public void onRejectSharedElements(List<View> rejectedSharedElements) {
            this.f1556a.mo5165a(rejectedSharedElements);
        }

        public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
            this.f1556a.mo5168a(names, sharedElements);
        }

        public Parcelable onCaptureSharedElementSnapshot(View sharedElement, Matrix viewToGlobalMatrix, RectF screenBounds) {
            return this.f1556a.mo5163a(sharedElement, viewToGlobalMatrix, screenBounds);
        }

        public View onCreateSnapshotView(Context context, Parcelable snapshot) {
            return this.f1556a.mo5164a(context, snapshot);
        }
    }

    /* renamed from: android.support.v4.app.b$e */
    /* compiled from: ActivityCompat */
    private static class C0456e extends C0455d {
        C0456e(C0469fa callback) {
            super(callback);
        }

        public void onSharedElementsArrived(List<String> sharedElementNames, List<View> sharedElements, OnSharedElementsReadyListener listener) {
            this.f1556a.mo5166a(sharedElementNames, sharedElements, (C0470a) new C0458c(this, listener));
        }
    }

    /* renamed from: a */
    public static C0454b m2336a() {
        return f1555c;
    }

    /* renamed from: a */
    public static void m2338a(Activity activity, Intent intent, int requestCode, Bundle options) {
        if (VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, requestCode, options);
        } else {
            activity.startActivityForResult(intent, requestCode);
        }
    }

    /* renamed from: a */
    public static void m2339a(Activity activity, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws SendIntentException {
        if (VERSION.SDK_INT >= 16) {
            activity.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
        } else {
            activity.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags);
        }
    }

    /* renamed from: a */
    public static void m2337a(Activity activity) {
        if (VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    /* renamed from: b */
    public static void m2343b(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            activity.finishAfterTransition();
        } else {
            activity.finish();
        }
    }

    /* renamed from: a */
    public static void m2340a(Activity activity, C0469fa callback) {
        int i = VERSION.SDK_INT;
        SharedElementCallback sharedElementCallback = null;
        if (i >= 23) {
            if (callback != null) {
                sharedElementCallback = new C0456e(callback);
            }
            activity.setEnterSharedElementCallback(sharedElementCallback);
        } else if (i >= 21) {
            if (callback != null) {
                sharedElementCallback = new C0455d(callback);
            }
            activity.setEnterSharedElementCallback(sharedElementCallback);
        }
    }

    /* renamed from: b */
    public static void m2344b(Activity activity, C0469fa callback) {
        int i = VERSION.SDK_INT;
        SharedElementCallback sharedElementCallback = null;
        if (i >= 23) {
            if (callback != null) {
                sharedElementCallback = new C0456e(callback);
            }
            activity.setExitSharedElementCallback(sharedElementCallback);
        } else if (i >= 21) {
            if (callback != null) {
                sharedElementCallback = new C0455d(callback);
            }
            activity.setExitSharedElementCallback(sharedElementCallback);
        }
    }

    /* renamed from: c */
    public static void m2345c(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            activity.postponeEnterTransition();
        }
    }

    /* renamed from: d */
    public static void m2346d(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            activity.startPostponedEnterTransition();
        }
    }

    /* renamed from: a */
    public static void m2341a(Activity activity, String[] permissions, int requestCode) {
        C0454b bVar = f1555c;
        if (bVar == null || !bVar.mo5130a(activity, permissions, requestCode)) {
            if (VERSION.SDK_INT >= 23) {
                if (activity instanceof C0008c) {
                    ((C0008c) activity).validateRequestPermissionsRequestCode(requestCode);
                }
                activity.requestPermissions(permissions, requestCode);
            } else if (activity instanceof C0007a) {
                new Handler(Looper.getMainLooper()).post(new C0447a(permissions, activity, requestCode));
            }
        }
    }

    /* renamed from: a */
    public static boolean m2342a(Activity activity, String permission) {
        if (VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(permission);
        }
        return false;
    }
}
