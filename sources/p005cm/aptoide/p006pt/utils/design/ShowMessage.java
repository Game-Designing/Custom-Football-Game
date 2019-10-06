package p005cm.aptoide.p006pt.utils.design;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.support.design.widget.C0307r.C0308a;
import android.support.design.widget.Snackbar;
import android.support.design.widget.Snackbar.C0266a;
import android.support.p000v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import p005cm.aptoide.p006pt.logger.Logger;
import p026rx.C0117M;
import p026rx.C0117M.C0118a;
import p026rx.C14503O;

@Deprecated
/* renamed from: cm.aptoide.pt.utils.design.ShowMessage */
public class ShowMessage {
    private static final String TAG = ShowMessage.class.getSimpleName();

    public static void asSnack(View view, String msg, String actionMsg, OnClickListener action, int duration) {
        asSnackInternal(view, msg, actionMsg, action, duration).mo4690h();
    }

    private static Snackbar asSnackInternal(View view, String msg, String actionMsg, OnClickListener action, int duration) {
        Snackbar a = Snackbar.m1624a(view, (CharSequence) msg, duration);
        a.mo4555a((CharSequence) actionMsg, action);
        return a;
    }

    public static C0117M asObservableSnack(View view, String msg, String actionMsg, OnClickListener action) {
        return asSnackObservableInternal(asSnackInternal(view, msg, actionMsg, action, -1));
    }

    private static C0117M asSnackObservableInternal(final Snackbar snackbar) {
        return C0117M.m585a((C0118a) new C0118a() {
            public void call(final C14503O completableSubscriber) {
                snackbar.mo4678a((C0308a<B>) new C0266a() {
                    public void onShown(Snackbar snackbar) {
                        super.onShown(snackbar);
                    }

                    public void onDismissed(Snackbar snackbar, int event) {
                        super.onDismissed(snackbar, event);
                        snackbar.mo4680b((C0308a<B>) this);
                        completableSubscriber.onCompleted();
                    }
                });
                snackbar.mo4690h();
            }
        });
    }

    public static void asSnack(View view, String msg) {
        asSnackInternal(view, msg).mo4690h();
    }

    private static Snackbar asSnackInternal(View view, String msg) {
        return Snackbar.m1624a(view, (CharSequence) msg, -1);
    }

    public static C0117M asObservableSnack(View view, String msg) {
        return asSnackObservableInternal(asSnackInternal(view, msg));
    }

    public static void asSnack(View view, int msg, int actionMsg, OnClickListener action) {
        asSnackInternal(view, msg, actionMsg, action).mo4690h();
    }

    private static Snackbar asSnackInternal(View view, int msg, int actionMsg, OnClickListener action) {
        Snackbar a = Snackbar.m1623a(view, msg, -1);
        a.mo4552a(actionMsg, action);
        return a;
    }

    public static C0117M asObservableSnack(View view, int msg, int actionMsg, OnClickListener action) {
        return asSnackObservableInternal(asSnackInternal(view, msg, actionMsg, action));
    }

    public static void asSnack(View view, int msg) {
        asSnackInternal(view, msg).mo4690h();
    }

    private static Snackbar asSnackInternal(View view, int msg) {
        return Snackbar.m1623a(view, msg, -1);
    }

    public static C0117M asObservableSnack(View view, int msg) {
        return asSnackObservableInternal(asSnackInternal(view, msg));
    }

    public static void asLongSnack(Activity activity, String msg) {
        asSnackInternal(activity, msg, 0).mo4690h();
    }

    public static void asLongSnack(Fragment fragment, String msg) {
        asLongSnackInternal(fragment, msg).mo4690h();
    }

    public static void asLongSnack(Fragment fragment, int msg) {
        asLongSnackInternal(fragment, msg).mo4690h();
    }

    private static Snackbar asSnackInternal(Activity activity, String msg, int duration) {
        return Snackbar.m1624a(getViewFromActivity(activity), (CharSequence) msg, duration);
    }

    private static View getViewFromActivity(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = activity.findViewById(16908290);
        }
        if (view != null) {
            return view;
        }
        Logger.getInstance().mo2142e(TAG, (Throwable) new IllegalStateException("Unable to find a view to bind this snack too"));
        return null;
    }

    public static void asSnack(Activity activity, String msg) {
        asSnackInternal(activity, msg).mo4690h();
    }

    private static Snackbar asSnackInternal(Activity activity, String msg) {
        return asSnackInternal(activity, msg, -1);
    }

    public static C0117M asObservableSnack(Activity activity, String msg) {
        return asSnackObservableInternal(asSnackInternal(activity, msg));
    }

    public static void asSnack(Activity activity, int msg) {
        asSnackInternal(activity, msg).mo4690h();
    }

    private static Snackbar asSnackInternal(Activity activity, int msg) {
        return Snackbar.m1623a(getViewFromActivity(activity), msg, -1);
    }

    public static C0117M asObservableSnack(Activity activity, int msg) {
        return asSnackObservableInternal(asSnackInternal(activity, msg));
    }

    public static C0117M asLongObservableSnack(Activity activity, int msg) {
        return asSnackObservableInternal(asLongSnackInternal(activity, msg));
    }

    public static C0117M asLongObservableSnack(View view, int msg) {
        return asSnackObservableInternal(asLongSnackInternal(view, msg));
    }

    public static C0117M asLongObservableSnack(View view, String msg) {
        return asSnackObservableInternal(asLongSnackInternal(view, msg));
    }

    public static C0117M asLongObservableSnack(Fragment fragment, int msg) {
        return asSnackObservableInternal(asLongSnackInternal(fragment, msg));
    }

    private static Snackbar asLongSnackInternal(View view, String msg) {
        return Snackbar.m1624a(view, (CharSequence) msg, 0);
    }

    private static Snackbar asLongSnackInternal(View view, int msg) {
        return Snackbar.m1623a(view, msg, 0);
    }

    private static Snackbar asLongSnackInternal(Fragment fragment, int msg) {
        return asLongSnackInternal(fragment.getView(), msg);
    }

    private static Snackbar asLongSnackInternal(Fragment fragment, String msg) {
        return asLongSnackInternal(fragment.getView(), msg);
    }

    private static Snackbar asLongSnackInternal(Activity activity, int msg) {
        return asLongSnackInternal(getViewFromActivity(activity), msg);
    }

    public static void asSnack(Fragment fragment, String msg) {
        asSnackInternal(fragment, msg).mo4690h();
    }

    private static Snackbar asSnackInternal(Fragment fragment, String msg) {
        return Snackbar.m1624a(fragment.getView(), (CharSequence) msg, -1);
    }

    public static C0117M asObservableSnack(Fragment fragment, String msg) {
        return asSnackObservableInternal(asSnackInternal(fragment, msg));
    }

    public static void asSnack(Fragment fragment, int msg) {
        asSnackInternal(fragment, msg).mo4690h();
    }

    private static Snackbar asSnackInternal(Fragment fragment, int msg) {
        return Snackbar.m1623a(fragment.getView(), msg, -1);
    }

    public static C0117M asObservableSnack(Fragment fragment, int msg) {
        return asSnackObservableInternal(asSnackInternal(fragment, msg));
    }

    public static void asSnack(Activity activity, int msg, int actionMsg, OnClickListener action, int duration) {
        Snackbar snackbar = asSnackInternal(activity, msg, actionMsg, action, duration);
        if (snackbar != null) {
            snackbar.mo4690h();
        }
    }

    public static void asSnackIndefiniteTime(Activity activity, String msg, int actionMsg, OnClickListener action) {
        Snackbar snackbar = asSnackInternal(activity, msg, actionMsg, action, -2);
        if (snackbar != null) {
            snackbar.mo4690h();
        }
    }

    private static Snackbar asSnackInternal(Activity activity, String msg, int actionMsg, OnClickListener action, int duration) {
        View view = getViewFromActivity(activity);
        if (view == null) {
            return null;
        }
        Snackbar a = Snackbar.m1624a(view, (CharSequence) msg, duration);
        a.mo4552a(actionMsg, action);
        return a;
    }

    private static Snackbar asSnackInternal(Activity activity, int msg, int actionMsg, OnClickListener action, int duration) {
        View view = getViewFromActivity(activity);
        if (view == null) {
            return null;
        }
        Snackbar a = Snackbar.m1623a(view, msg, duration);
        a.mo4552a(actionMsg, action);
        return a;
    }

    public static C0117M asObservableSnack(Activity activity, int msg, int actionMsg, OnClickListener action) {
        Snackbar snackbar = asSnackInternal(activity, msg, actionMsg, action, -1);
        if (snackbar != null) {
            return asSnackObservableInternal(snackbar);
        }
        return C0117M.m591b((Throwable) new IllegalStateException("Extracted view from activity is null"));
    }

    public static void asSnack(android.app.Fragment fragment, int msg) {
        asSnackInternal(fragment, msg).mo4690h();
    }

    @TargetApi(11)
    private static Snackbar asSnackInternal(android.app.Fragment fragment, int msg) {
        return Snackbar.m1623a(fragment.getView(), msg, -1);
    }

    public static C0117M asObservableSnack(android.app.Fragment fragment, int msg) {
        return asSnackObservableInternal(asSnackInternal(fragment, msg));
    }

    @Deprecated
    public static void asToast(Context context, String msg) {
        Toast.makeText(context, msg, 0).show();
    }

    @Deprecated
    public static void asToast(Context context, int msg) {
        Toast.makeText(context, msg, 0).show();
    }
}
