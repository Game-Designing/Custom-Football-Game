package p005cm.aptoide.p006pt.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.support.p001v7.app.C0774m;
import android.support.p001v7.app.C0774m.C0775a;
import android.view.View;
import p026rx.C0120S;
import p026rx.C0120S.C0122a;
import p026rx.C14980ia;
import p026rx.p029i.C14978f;
import p026rx.p387a.p389b.C14522a;

/* renamed from: cm.aptoide.pt.utils.GenericDialogs */
public class GenericDialogs {

    /* renamed from: cm.aptoide.pt.utils.GenericDialogs$EResponse */
    public enum EResponse {
        YES,
        NO,
        CANCEL
    }

    public static C0120S<EResponse> createGenericYesNoCancelMessage(Context context, String title, String message) {
        return C0120S.m634a((C0122a<T>) new C5204t<T>(context, title, message)).mo3634b(C14522a.m46170a());
    }

    /* renamed from: c */
    static /* synthetic */ void m9470c(Context context, String title, String message, C14980ia subscriber) {
        C0775a aVar = new C0775a(context);
        aVar.mo6236b((CharSequence) title);
        aVar.mo6226a((CharSequence) message);
        aVar.mo6239c(17039379, (OnClickListener) new C5206v(subscriber));
        aVar.mo6234b(17039369, (OnClickListener) new C5175E(subscriber));
        aVar.mo6221a((OnCancelListener) new C5205u(subscriber));
        C0774m dialog = aVar.mo6231a();
        subscriber.add(C14978f.m46781a(new C5180J(dialog)));
        dialog.show();
    }

    /* renamed from: a */
    static /* synthetic */ void m9465a(C14980ia subscriber, DialogInterface listener, int which) {
        subscriber.onNext(EResponse.YES);
        subscriber.onCompleted();
    }

    /* renamed from: b */
    static /* synthetic */ void m9469b(C14980ia subscriber, DialogInterface listener, int which) {
        subscriber.onNext(EResponse.NO);
        subscriber.onCompleted();
    }

    /* renamed from: b */
    static /* synthetic */ void m9468b(C14980ia subscriber, DialogInterface listener) {
        subscriber.onNext(EResponse.CANCEL);
        subscriber.onCompleted();
    }

    public static C0120S<EResponse> createGenericOkCancelMessage(Context context, String title, String message) {
        return C0120S.m634a((C0122a<T>) new C5203s<T>(context, title, message));
    }

    /* renamed from: b */
    static /* synthetic */ void m9466b(Context context, String title, String message, C14980ia subscriber) {
        C0775a aVar = new C0775a(context);
        aVar.mo6236b((CharSequence) title);
        aVar.mo6226a((CharSequence) message);
        aVar.mo6239c(17039370, (OnClickListener) new C5177G(subscriber));
        aVar.mo6234b(17039360, (OnClickListener) new C5199o(subscriber));
        C0774m dialog = aVar.mo6231a();
        subscriber.add(C14978f.m46781a(new C5179I(dialog)));
        dialog.show();
    }

    /* renamed from: i */
    static /* synthetic */ void m9482i(C14980ia subscriber, DialogInterface listener, int which) {
        subscriber.onNext(EResponse.YES);
        subscriber.onCompleted();
    }

    /* renamed from: j */
    static /* synthetic */ void m9483j(C14980ia subscriber, DialogInterface dialogInterface, int i) {
        subscriber.onNext(EResponse.CANCEL);
        subscriber.onCompleted();
    }

    public static C0120S<EResponse> createGenericOkCancelMessageWithCustomView(Context context, String title, String message, int layoutId) {
        return C0120S.m634a((C0122a<T>) new C5202r<T>(context, title, message, layoutId));
    }

    /* renamed from: a */
    static /* synthetic */ void m9461a(Context context, String title, String message, int layoutId, C14980ia subscriber) {
        C0775a aVar = new C0775a(context);
        aVar.mo6236b((CharSequence) title);
        aVar.mo6226a((CharSequence) message);
        aVar.mo6241d(layoutId);
        aVar.mo6239c(17039370, (OnClickListener) new C5201q(subscriber));
        aVar.mo6234b(17039360, (OnClickListener) new C5198n(subscriber));
        C0774m dialog = aVar.mo6231a();
        subscriber.add(C14978f.m46781a(new C5173C(dialog)));
        dialog.show();
    }

    /* renamed from: k */
    static /* synthetic */ void m9484k(C14980ia subscriber, DialogInterface listener, int which) {
        subscriber.onNext(EResponse.YES);
        subscriber.onCompleted();
    }

    /* renamed from: c */
    static /* synthetic */ void m9473c(C14980ia subscriber, DialogInterface dialogInterface, int i) {
        subscriber.onNext(EResponse.CANCEL);
        subscriber.onCompleted();
    }

    public static C0120S<EResponse> createGenericOkMessage(Context context, String title, String message) {
        return createGenericContinueMessage(context, null, title, message, 17039370);
    }

    public static C0120S<EResponse> createGenericContinueMessage(Context context, View view, String title, String message, int buttonText) {
        C5200p pVar = new C5200p(context, title, message, buttonText, view);
        return C0120S.m634a((C0122a<T>) pVar);
    }

    /* renamed from: a */
    static /* synthetic */ void m9460a(Context context, String title, String message, int buttonText, View view, C14980ia subscriber) {
        C0775a aVar = new C0775a(context);
        aVar.mo6236b((CharSequence) title);
        aVar.mo6226a((CharSequence) message);
        C0775a builder = aVar.mo6239c(buttonText, (OnClickListener) new C5210z(subscriber));
        if (view != null) {
            builder.mo6235b(view);
        }
        C0774m alertDialog = builder.mo6231a();
        subscriber.add(C14978f.m46781a(new C5208x(alertDialog)));
        alertDialog.show();
    }

    /* renamed from: d */
    static /* synthetic */ void m9475d(C14980ia subscriber, DialogInterface dialogInterface, int i) {
        subscriber.onNext(EResponse.YES);
        subscriber.onCompleted();
    }

    public static C0120S<EResponse> createGenericContinueCancelMessage(Context context, String title, String message) {
        return C0120S.m634a((C0122a<T>) new C5170B<T>(context, title, message));
    }

    /* renamed from: a */
    static /* synthetic */ void m9462a(Context context, String title, String message, C14980ia subscriber) {
        C0775a aVar = new C0775a(context);
        aVar.mo6236b((CharSequence) title);
        aVar.mo6226a((CharSequence) message);
        aVar.mo6239c(17039370, (OnClickListener) new C5168A(subscriber));
        aVar.mo6234b(17039360, (OnClickListener) new C5197m(subscriber));
        aVar.mo6221a((OnCancelListener) new C5178H(subscriber));
        C0774m ad = aVar.mo6231a();
        subscriber.add(C14978f.m46781a(new C5174D(ad)));
        ad.show();
    }

    /* renamed from: e */
    static /* synthetic */ void m9477e(C14980ia subscriber, DialogInterface dialog, int which) {
        subscriber.onNext(EResponse.YES);
        subscriber.onCompleted();
    }

    /* renamed from: f */
    static /* synthetic */ void m9479f(C14980ia subscriber, DialogInterface dialogInterface, int i) {
        subscriber.onNext(EResponse.NO);
        subscriber.onCompleted();
    }

    /* renamed from: a */
    static /* synthetic */ void m9464a(C14980ia subscriber, DialogInterface dialog) {
        subscriber.onNext(EResponse.CANCEL);
        subscriber.onCompleted();
    }

    public static C0120S<EResponse> createGenericOkCancelMessage(Context context, String title, int message, int okMessage, int cancelMessage) {
        C5176F f = new C5176F(context, title, message, okMessage, cancelMessage);
        return C0120S.m634a((C0122a<T>) f);
    }

    /* renamed from: a */
    static /* synthetic */ void m9459a(Context context, String title, int message, int okMessage, int cancelMessage, C14980ia subscriber) {
        C0775a aVar = new C0775a(context);
        aVar.mo6236b((CharSequence) title);
        aVar.mo6233b(message);
        aVar.mo6239c(okMessage, (OnClickListener) new C5207w(subscriber));
        aVar.mo6234b(cancelMessage, (OnClickListener) new C5209y(subscriber));
        aVar.mo6221a((OnCancelListener) new C5195k(subscriber));
        C0774m ad = aVar.mo6231a();
        subscriber.add(C14978f.m46781a(new C5196l(ad)));
        ad.show();
    }

    /* renamed from: g */
    static /* synthetic */ void m9480g(C14980ia subscriber, DialogInterface dialog, int which) {
        subscriber.onNext(EResponse.YES);
        subscriber.onCompleted();
    }

    /* renamed from: h */
    static /* synthetic */ void m9481h(C14980ia subscriber, DialogInterface dialogInterface, int i) {
        subscriber.onNext(EResponse.NO);
        subscriber.onCompleted();
    }

    /* renamed from: c */
    static /* synthetic */ void m9472c(C14980ia subscriber, DialogInterface dialog) {
        subscriber.onNext(EResponse.CANCEL);
        subscriber.onCompleted();
    }

    public static C0120S<EResponse> createGenericContinueMessage(Context context, String title, String message) {
        return createGenericContinueMessage(context, null, title, message, C5181R.string.continue_option);
    }

    public static ProgressDialog createGenericPleaseWaitDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(context.getString(C5181R.string.please_wait));
        progressDialog.setCancelable(false);
        return progressDialog;
    }

    public static ProgressDialog createGenericPleaseWaitDialog(Context context, String string) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(string);
        progressDialog.setCancelable(false);
        return progressDialog;
    }
}
