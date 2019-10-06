package p005cm.aptoide.p006pt.view.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.view.p080rx.RxAlertDialog;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.view.dialog.EditableTextDialog */
public class EditableTextDialog implements DialogInterface {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final RxAlertDialog dialog;
    private final EditText editText;

    /* renamed from: cm.aptoide.pt.view.dialog.EditableTextDialog$Builder */
    public static class Builder {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private final p005cm.aptoide.p006pt.view.p080rx.RxAlertDialog.Builder builder;
        private int editTextId;
        private final LayoutInflater layoutInflater;
        private int viewRes;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(2023566451021196706L, "cm/aptoide/pt/view/dialog/EditableTextDialog$Builder", 17);
            $jacocoData = probes;
            return probes;
        }

        public Builder(Context context) {
            boolean[] $jacocoInit = $jacocoInit();
            $jacocoInit[0] = true;
            this.builder = new p005cm.aptoide.p006pt.view.p080rx.RxAlertDialog.Builder(context);
            $jacocoInit[1] = true;
            this.layoutInflater = LayoutInflater.from(context);
            $jacocoInit[2] = true;
        }

        public Builder setEditText(int editTextId2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.editTextId = editTextId2;
            $jacocoInit[3] = true;
            return this;
        }

        public Builder setView(int viewRes2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.viewRes = viewRes2;
            $jacocoInit[4] = true;
            return this;
        }

        public Builder setMessage(int messageId) {
            boolean[] $jacocoInit = $jacocoInit();
            this.builder.setMessage(messageId);
            $jacocoInit[5] = true;
            return this;
        }

        public Builder setPositiveButton(int textId) {
            boolean[] $jacocoInit = $jacocoInit();
            this.builder.setPositiveButton(textId);
            $jacocoInit[6] = true;
            return this;
        }

        public Builder setNegativeButton(int textId) {
            boolean[] $jacocoInit = $jacocoInit();
            this.builder.setNegativeButton(textId);
            $jacocoInit[7] = true;
            return this;
        }

        public EditableTextDialog build() {
            boolean[] $jacocoInit = $jacocoInit();
            int i = this.viewRes;
            if (i == 0) {
                $jacocoInit[8] = true;
            } else if (this.editTextId != 0) {
                $jacocoInit[10] = true;
                View view = this.layoutInflater.inflate(i, null, false);
                $jacocoInit[11] = true;
                EditText pinEditText = (EditText) view.findViewById(this.editTextId);
                $jacocoInit[12] = true;
                this.builder.setView(view);
                $jacocoInit[13] = true;
                RxAlertDialog dialog = this.builder.build();
                $jacocoInit[14] = true;
                EditableTextDialog editableTextDialog = new EditableTextDialog(dialog, pinEditText);
                $jacocoInit[15] = true;
                return editableTextDialog;
            } else {
                $jacocoInit[9] = true;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("View and edit text resource ids must be provided");
            $jacocoInit[16] = true;
            throw illegalArgumentException;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4807390207268109864L, "cm/aptoide/pt/view/dialog/EditableTextDialog", 11);
        $jacocoData = probes;
        return probes;
    }

    public EditableTextDialog(RxAlertDialog dialog2, EditText editText2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.dialog = dialog2;
        this.editText = editText2;
        $jacocoInit[0] = true;
    }

    public void show() {
        boolean[] $jacocoInit = $jacocoInit();
        this.dialog.show();
        $jacocoInit[1] = true;
    }

    public void cancel() {
        boolean[] $jacocoInit = $jacocoInit();
        this.dialog.cancel();
        $jacocoInit[2] = true;
    }

    public void dismiss() {
        boolean[] $jacocoInit = $jacocoInit();
        this.dialog.dismiss();
        $jacocoInit[3] = true;
    }

    public C0120S<CharSequence> positiveClicks() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S positiveClicks = this.dialog.positiveClicks();
        C5333o oVar = new C5333o(this);
        $jacocoInit[4] = true;
        C0120S<CharSequence> j = positiveClicks.mo3669j(oVar);
        $jacocoInit[5] = true;
        return j;
    }

    /* renamed from: a */
    public /* synthetic */ CharSequence mo17179a(DialogInterface click) {
        boolean[] $jacocoInit = $jacocoInit();
        Editable text = this.editText.getText();
        $jacocoInit[10] = true;
        return text;
    }

    public C0120S<DialogInterface> negativeClicks() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<DialogInterface> negativeClicks = this.dialog.negativeClicks();
        $jacocoInit[6] = true;
        return negativeClicks;
    }

    public C0120S<DialogInterface> cancels() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<DialogInterface> cancels = this.dialog.cancels();
        $jacocoInit[7] = true;
        return cancels;
    }

    public C0120S<DialogInterface> dismisses() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<DialogInterface> dismisses = this.dialog.dismisses();
        $jacocoInit[8] = true;
        return dismisses;
    }

    /* access modifiers changed from: protected */
    public void setText(String text) {
        boolean[] $jacocoInit = $jacocoInit();
        this.editText.setText(text);
        $jacocoInit[9] = true;
    }
}
