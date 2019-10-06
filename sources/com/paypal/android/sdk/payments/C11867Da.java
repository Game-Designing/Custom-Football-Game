package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.TextView;
import com.paypal.android.sdk.C11703Aa;
import com.paypal.android.sdk.C11706B;
import com.paypal.android.sdk.C11712Cb;
import com.paypal.android.sdk.C11715Da;
import com.paypal.android.sdk.C11723Fa;
import com.paypal.android.sdk.C11756Pb;
import com.paypal.android.sdk.C11757Q;
import com.paypal.android.sdk.C11761Rb;
import com.paypal.android.sdk.C11793ba;
import com.paypal.android.sdk.C11805ds;
import com.paypal.android.sdk.C12028yb;

/* renamed from: com.paypal.android.sdk.payments.Da */
class C11867Da implements C11706B {
    C11867Da() {
    }

    /* renamed from: a */
    static AlertDialog m39225a(Activity activity, C11761Rb rb, C11761Rb rb2, OnClickListener onClickListener) {
        return new Builder(activity).setIcon(17301543).setTitle(C11756Pb.m38949a(rb)).setMessage(C11756Pb.m38949a(rb2)).setPositiveButton(C11756Pb.m38949a(C11761Rb.OK), onClickListener).setNegativeButton(C11756Pb.m38949a(C11761Rb.CANCEL), null).create();
    }

    /* renamed from: a */
    private static AlertDialog m39226a(Context context, C11761Rb rb, String str, OnClickListener onClickListener) {
        String a = C11756Pb.m38949a(rb);
        return new Builder(context).setMessage(str).setCancelable(false).setTitle(a).setPositiveButton(C11756Pb.m38949a(C11761Rb.OK), onClickListener).create();
    }

    /* renamed from: a */
    static Dialog m39227a(Activity activity, OnClickListener onClickListener) {
        return new Builder(activity).setIcon(17301543).setCancelable(false).setTitle(C11756Pb.m38949a(C11761Rb.TRY_AGAIN)).setMessage(C11756Pb.m38949a(C11761Rb.SERVER_PROBLEM)).setPositiveButton(C11756Pb.m38949a(C11761Rb.TRY_AGAIN), onClickListener).setNegativeButton(C11756Pb.m38949a(C11761Rb.CANCEL), new C11932fb(activity)).create();
    }

    /* renamed from: a */
    static Dialog m39228a(Activity activity, C11761Rb rb, Bundle bundle) {
        return m39226a((Context) activity, rb, bundle.getString("alert_errors"), (OnClickListener) new C11917bb());
    }

    /* renamed from: a */
    static Dialog m39229a(Activity activity, C11761Rb rb, Bundle bundle, int i) {
        return m39226a((Context) activity, rb, bundle.getString("alert_errors"), (OnClickListener) new C11924db(activity, i));
    }

    /* renamed from: a */
    static Dialog m39230a(Activity activity, C11761Rb rb, Bundle bundle, OnClickListener onClickListener) {
        return m39226a((Context) activity, rb, bundle.getString("alert_errors"), onClickListener);
    }

    /* renamed from: a */
    static Dialog m39231a(Context context, C11761Rb rb, C11761Rb rb2) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(C11756Pb.m38949a(rb));
        progressDialog.setMessage(C11756Pb.m38949a(rb2));
        progressDialog.setCancelable(false);
        return progressDialog;
    }

    /* renamed from: a */
    public static Bitmap m39232a(Activity activity, Enum enumR) {
        Bitmap bitmap;
        try {
            bitmap = (Bitmap) m39233a("io.card.payment.CardType").cast(enumR).getClass().getMethod("imageBitmap", new Class[]{Context.class}).invoke(enumR, new Object[]{activity});
        } catch (Exception e) {
            bitmap = null;
        }
        return bitmap == null ? C11715Da.m38792c("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", (Context) activity) : bitmap;
    }

    /* renamed from: a */
    public static Class m39233a(String str) {
        try {
            return Class.forName(str);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    public static Enum m39234a(C11805ds dsVar) {
        try {
            return (Enum) m39233a("io.card.payment.CardType").getMethod("fromString", new Class[]{String.class}).invoke(null, new Object[]{dsVar.mo38733h().toString()});
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    public static Object m39235a(C11703Aa aa) {
        if (aa instanceof C12028yb) {
            C12028yb ybVar = (C12028yb) aa;
            ProofOfPayment proofOfPayment = new ProofOfPayment(ybVar.mo39215v(), ybVar.mo39213t(), ybVar.mo39216w(), ybVar.mo39217x(), ybVar.mo39218y());
            return proofOfPayment;
        } else if (aa instanceof C11712Cb) {
            C11712Cb cb = (C11712Cb) aa;
            ProofOfPayment proofOfPayment2 = new ProofOfPayment(cb.mo38585v(), cb.mo38586w(), cb.mo38588y(), cb.mo38587x(), cb.mo38589z());
            return proofOfPayment2;
        } else {
            throw new RuntimeException("Dev error");
        }
    }

    /* renamed from: a */
    public static String m39236a(Parcelable parcelable) {
        try {
            return (String) m39233a("io.card.payment.CreditCard").cast(parcelable).getClass().getMethod("getRedactedCardNumber", new Class[0]).invoke(parcelable, null);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m39237a(Parcelable parcelable, String str) {
        try {
            return (String) m39233a("io.card.payment.CreditCard").cast(parcelable).getClass().getField(str).get(parcelable);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m39238a(String str, String str2) {
        try {
            return (String) m39233a(str).getField(str2).get(null);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    static void m39239a(Activity activity, TextView textView, C11761Rb rb) {
        C11723Fa.m38814a(activity, textView, rb != null ? C11756Pb.m38949a(rb) : "", "PayPal - ", new BitmapDrawable(activity.getResources(), C11715Da.m38766a("iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyRpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNiAoTWFjaW50b3NoKSIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDpCNDMzRTRFQ0M2MjQxMUUzOURBQ0E3QTY0NjU3OUI5QiIgeG1wTU06RG9jdW1lbnRJRD0ieG1wLmRpZDpCNDMzRTRFREM2MjQxMUUzOURBQ0E3QTY0NjU3OUI5QiI+IDx4bXBNTTpEZXJpdmVkRnJvbSBzdFJlZjppbnN0YW5jZUlEPSJ4bXAuaWlkOkI0MzNFNEVBQzYyNDExRTM5REFDQTdBNjQ2NTc5QjlCIiBzdFJlZjpkb2N1bWVudElEPSJ4bXAuZGlkOkI0MzNFNEVCQzYyNDExRTM5REFDQTdBNjQ2NTc5QjlCIi8+IDwvcmRmOkRlc2NyaXB0aW9uPiA8L3JkZjpSREY+IDwveDp4bXBtZXRhPiA8P3hwYWNrZXQgZW5kPSJyIj8+Eyd0MQAABoFJREFUeNrMWl1M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", (Context) activity, 240)));
    }

    /* renamed from: a */
    static void m39240a(Activity activity, C11940ia iaVar, int i, int i2, int i3) {
        Integer num = iaVar.f37559a;
        boolean z = false;
        if ((num != null && num.intValue() >= 500) || iaVar.mo39122c()) {
            activity.showDialog(2);
            return;
        }
        if (iaVar.mo39120a()) {
            if ("invalid_client".equals(iaVar.f37560b)) {
                z = true;
            }
        }
        if (z) {
            m39241a(activity, C11756Pb.m38949a(C11761Rb.UNAUTHORIZED_MERCHANT_MESSAGE), 3);
        } else if (iaVar.f37560b.equals(C11793ba.DEVICE_OS_TOO_OLD.toString())) {
            m39241a(activity, C11756Pb.m38949a(C11761Rb.ANDROID_OS_TOO_OLD), 1);
        } else {
            m39241a(activity, C11756Pb.m38949a(C11761Rb.UNAUTHORIZED_DEVICE_MESSAGE), 1);
        }
    }

    /* renamed from: a */
    static void m39241a(Activity activity, String str, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("alert_errors", str);
        activity.removeDialog(i);
        activity.showDialog(i, bundle);
    }

    /* renamed from: a */
    static void m39242a(TextView textView, String str) {
        if (textView != null) {
            if (str == null || C11757Q.m38955c(str)) {
                textView.setVisibility(8);
            } else if (C11757Q.m38954b(str)) {
                textView.setText(C11756Pb.m38949a(C11761Rb.ENVIRONMENT_SANDBOX));
            } else if (C11757Q.m38953a(str)) {
                textView.setText(C11756Pb.m38949a(C11761Rb.ENVIRONMENT_MOCK_DATA));
            } else {
                textView.setText(str);
            }
        }
    }

    /* renamed from: a */
    static boolean m39243a(Activity activity) {
        String sb;
        String name = activity.getClass().getName();
        ComponentName callingActivity = activity.getCallingActivity();
        String str = "paypal.sdk";
        if (callingActivity == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(name);
            sb2.append(" called by a null activity, not allowed");
            sb = sb2.toString();
        } else {
            String className = callingActivity.getClassName();
            if (className.startsWith("com.paypal.android.sdk.payments.")) {
                return true;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(name);
            sb3.append(" called by ");
            sb3.append(className);
            sb3.append(" which is not part of the SDK, not allowed");
            sb = sb3.toString();
        }
        Log.e(str, sb);
        return false;
    }

    /* renamed from: b */
    public static int m39244b(Parcelable parcelable, String str) {
        try {
            return ((Integer) m39233a("io.card.payment.CreditCard").cast(parcelable).getClass().getField(str).get(parcelable)).intValue();
        } catch (Exception e) {
            return -1;
        }
    }

    /* renamed from: b */
    static Intent m39245b(Activity activity) {
        Intent intent = new Intent(activity.getApplicationContext(), PayPalService.class);
        intent.putExtra("initializingActivity", activity.getClass().getSimpleName());
        String str = "com.paypal.android.sdk.paypalConfiguration";
        if (activity.getIntent().hasExtra(str)) {
            intent.putExtra(str, activity.getIntent().getParcelableExtra(str));
        }
        return intent;
    }

    /* renamed from: b */
    public static Enum m39246b(Parcelable parcelable) {
        try {
            return (Enum) m39233a("io.card.payment.CreditCard").cast(parcelable).getClass().getMethod("getCardType", new Class[0]).invoke(parcelable, null);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: d */
    public static boolean m39247d() {
        try {
            Class.forName("io.card.payment.CardIOActivity");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: e */
    public static boolean m39248e() {
        try {
            return ((Boolean) m39233a("io.card.payment.CardIOActivity").getMethod("canReadCardWithCamera", new Class[0]).invoke(null, new Object[0])).booleanValue();
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a */
    public String mo38525a() {
        return "2.15.0";
    }

    /* renamed from: b */
    public String mo38526b() {
        String str = VERSION.RELEASE;
        StringBuilder sb = new StringBuilder();
        sb.append(Build.MANUFACTURER);
        String str2 = " ";
        sb.append(str2);
        sb.append(Build.MODEL);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        if (C11723Fa.m38822b((CharSequence) "")) {
            sb3.append(str2);
        }
        return String.format("PayPalSDK/%s %s (%s %s; %s; %s)", new Object[]{"PayPal-Android-SDK", "2.15.0", "Android", str, sb2, sb3.toString().trim()});
    }

    /* renamed from: c */
    public String mo38527c() {
        return "fbce47ddfec707dcb881d2c83dc915039faadff1";
    }
}
