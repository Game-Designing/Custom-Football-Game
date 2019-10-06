package p005cm.aptoide.p006pt.view.p080rx;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.support.p001v7.app.C0774m;
import android.support.p001v7.app.C0774m.C0775a;
import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p019d.p022i.p023b.C0100e;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.view.rx.RxAlertDialog */
public class RxAlertDialog implements DialogInterface {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final CancelEvent cancelEvent;
    private final C0774m dialog;
    private final DismissEvent dismissEvent;
    private final DialogClick negativeClick;
    private final DialogClick positiveClick;
    private final View view;

    /* renamed from: cm.aptoide.pt.view.rx.RxAlertDialog$Builder */
    public static class Builder {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private final C0775a builder;
        private DialogClick negativeClick;
        private DialogClick positiveClick;
        private View view;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(1467724091382910461L, "cm/aptoide/pt/view/rx/RxAlertDialog$Builder", 16);
            $jacocoData = probes;
            return probes;
        }

        public Builder(Context context) {
            boolean[] $jacocoInit = $jacocoInit();
            $jacocoInit[0] = true;
            this.builder = new C0775a(context);
            $jacocoInit[1] = true;
        }

        public Builder setView(View view2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.view = view2;
            $jacocoInit[2] = true;
            this.builder.mo6235b(view2);
            $jacocoInit[3] = true;
            return this;
        }

        public Builder setTitle(int titleId) {
            boolean[] $jacocoInit = $jacocoInit();
            this.builder.mo6238c(titleId);
            $jacocoInit[4] = true;
            return this;
        }

        public Builder setMessage(int messageId) {
            boolean[] $jacocoInit = $jacocoInit();
            this.builder.mo6233b(messageId);
            $jacocoInit[5] = true;
            return this;
        }

        public Builder setPositiveButton(int textId) {
            boolean[] $jacocoInit = $jacocoInit();
            this.positiveClick = new DialogClick(-1, C0100e.m565o());
            $jacocoInit[6] = true;
            this.builder.mo6239c(textId, (OnClickListener) this.positiveClick);
            $jacocoInit[7] = true;
            return this;
        }

        public Builder setNegativeButton(int textId) {
            boolean[] $jacocoInit = $jacocoInit();
            this.negativeClick = new DialogClick(-2, C0100e.m565o());
            $jacocoInit[8] = true;
            this.builder.mo6234b(textId, (OnClickListener) this.negativeClick);
            $jacocoInit[9] = true;
            return this;
        }

        public RxAlertDialog build() {
            boolean[] $jacocoInit = $jacocoInit();
            C0774m dialog = this.builder.mo6231a();
            $jacocoInit[10] = true;
            CancelEvent cancelEvent = new CancelEvent(C0100e.m565o());
            $jacocoInit[11] = true;
            CancelEvent cancelEvent2 = cancelEvent;
            DismissEvent dismissEvent = new DismissEvent(C0100e.m565o());
            $jacocoInit[12] = true;
            DismissEvent dismissEvent2 = dismissEvent;
            dialog.setOnCancelListener(cancelEvent2);
            $jacocoInit[13] = true;
            dialog.setOnDismissListener(dismissEvent2);
            $jacocoInit[14] = true;
            RxAlertDialog rxAlertDialog = new RxAlertDialog(dialog, this.view, this.positiveClick, this.negativeClick, cancelEvent2, dismissEvent2);
            $jacocoInit[15] = true;
            return rxAlertDialog;
        }
    }

    /* renamed from: cm.aptoide.pt.view.rx.RxAlertDialog$CancelEvent */
    protected static class CancelEvent implements OnCancelListener {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private final C0100e<Void> subject;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(5062930813321940656L, "cm/aptoide/pt/view/rx/RxAlertDialog$CancelEvent", 3);
            $jacocoData = probes;
            return probes;
        }

        public CancelEvent(C0100e<Void> subject2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.subject = subject2;
            $jacocoInit[0] = true;
        }

        public void onCancel(DialogInterface dialog) {
            boolean[] $jacocoInit = $jacocoInit();
            this.subject.call(null);
            $jacocoInit[1] = true;
        }

        public C0120S<Void> cancels() {
            boolean[] $jacocoInit = $jacocoInit();
            C0100e<Void> eVar = this.subject;
            $jacocoInit[2] = true;
            return eVar;
        }
    }

    /* renamed from: cm.aptoide.pt.view.rx.RxAlertDialog$DialogClick */
    protected static class DialogClick implements OnClickListener {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private final C0100e<Void> subject;
        private final int which;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(3834201423316497155L, "cm/aptoide/pt/view/rx/RxAlertDialog$DialogClick", 6);
            $jacocoData = probes;
            return probes;
        }

        public DialogClick(int which2, C0100e<Void> subject2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.which = which2;
            this.subject = subject2;
            $jacocoInit[0] = true;
        }

        public void onClick(DialogInterface dialog, int which2) {
            boolean[] $jacocoInit = $jacocoInit();
            if (this.which != which2) {
                $jacocoInit[1] = true;
            } else {
                $jacocoInit[2] = true;
                this.subject.call(null);
                $jacocoInit[3] = true;
            }
            $jacocoInit[4] = true;
        }

        public C0120S<Void> clicks() {
            boolean[] $jacocoInit = $jacocoInit();
            C0100e<Void> eVar = this.subject;
            $jacocoInit[5] = true;
            return eVar;
        }
    }

    /* renamed from: cm.aptoide.pt.view.rx.RxAlertDialog$DismissEvent */
    protected static class DismissEvent implements OnDismissListener {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private final C0100e<Void> subject;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-7489945859640706158L, "cm/aptoide/pt/view/rx/RxAlertDialog$DismissEvent", 3);
            $jacocoData = probes;
            return probes;
        }

        public DismissEvent(C0100e<Void> subject2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.subject = subject2;
            $jacocoInit[0] = true;
        }

        public void onDismiss(DialogInterface dialog) {
            boolean[] $jacocoInit = $jacocoInit();
            this.subject.call(null);
            $jacocoInit[1] = true;
        }

        public C0120S<Void> dismisses() {
            boolean[] $jacocoInit = $jacocoInit();
            C0100e<Void> eVar = this.subject;
            $jacocoInit[2] = true;
            return eVar;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4454695591324591505L, "cm/aptoide/pt/view/rx/RxAlertDialog", 22);
        $jacocoData = probes;
        return probes;
    }

    protected RxAlertDialog(C0774m dialog2, View view2, DialogClick positiveClick2, DialogClick negativeClick2, CancelEvent cancelEvent2, DismissEvent dismissEvent2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.dialog = dialog2;
        this.view = view2;
        this.positiveClick = positiveClick2;
        this.negativeClick = negativeClick2;
        this.cancelEvent = cancelEvent2;
        this.dismissEvent = dismissEvent2;
        $jacocoInit[0] = true;
    }

    public View getDialogView() {
        boolean[] $jacocoInit = $jacocoInit();
        View view2 = this.view;
        $jacocoInit[1] = true;
        return view2;
    }

    public void show() {
        boolean[] $jacocoInit = $jacocoInit();
        this.dialog.show();
        $jacocoInit[2] = true;
    }

    public boolean isShowing() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean isShowing = this.dialog.isShowing();
        $jacocoInit[3] = true;
        return isShowing;
    }

    public void cancel() {
        boolean[] $jacocoInit = $jacocoInit();
        this.dialog.cancel();
        $jacocoInit[4] = true;
    }

    public void dismiss() {
        boolean[] $jacocoInit = $jacocoInit();
        this.dialog.dismiss();
        $jacocoInit[5] = true;
    }

    public C0120S<DialogInterface> positiveClicks() {
        boolean[] $jacocoInit = $jacocoInit();
        DialogClick dialogClick = this.positiveClick;
        if (dialogClick != null) {
            $jacocoInit[6] = true;
            C0120S clicks = dialogClick.clicks();
            C5392b bVar = new C5392b(this);
            $jacocoInit[7] = true;
            C0120S<DialogInterface> j = clicks.mo3669j(bVar);
            $jacocoInit[8] = true;
            return j;
        }
        C0120S<DialogInterface> c = C0120S.m651c();
        $jacocoInit[9] = true;
        return c;
    }

    /* renamed from: d */
    public /* synthetic */ DialogInterface mo17365d(Void click) {
        $jacocoInit()[21] = true;
        return this;
    }

    public C0120S<DialogInterface> negativeClicks() {
        boolean[] $jacocoInit = $jacocoInit();
        DialogClick dialogClick = this.negativeClick;
        if (dialogClick != null) {
            $jacocoInit[10] = true;
            C0120S clicks = dialogClick.clicks();
            C5394d dVar = new C5394d(this);
            $jacocoInit[11] = true;
            C0120S<DialogInterface> j = clicks.mo3669j(dVar);
            $jacocoInit[12] = true;
            return j;
        }
        C0120S<DialogInterface> c = C0120S.m651c();
        $jacocoInit[13] = true;
        return c;
    }

    /* renamed from: c */
    public /* synthetic */ DialogInterface mo17362c(Void click) {
        $jacocoInit()[20] = true;
        return this;
    }

    public C0120S<DialogInterface> cancels() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S cancels = this.cancelEvent.cancels();
        C5391a aVar = new C5391a(this);
        $jacocoInit[14] = true;
        C0120S<DialogInterface> j = cancels.mo3669j(aVar);
        $jacocoInit[15] = true;
        return j;
    }

    /* renamed from: a */
    public /* synthetic */ DialogInterface mo17360a(Void click) {
        $jacocoInit()[19] = true;
        return this;
    }

    public C0120S<DialogInterface> dismisses() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S dismisses = this.dismissEvent.dismisses();
        C5393c cVar = new C5393c(this);
        $jacocoInit[16] = true;
        C0120S<DialogInterface> j = dismisses.mo3669j(cVar);
        $jacocoInit[17] = true;
        return j;
    }

    /* renamed from: b */
    public /* synthetic */ DialogInterface mo17361b(Void click) {
        $jacocoInit()[18] = true;
        return this;
    }
}
