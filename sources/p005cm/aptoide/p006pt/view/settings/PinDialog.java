package p005cm.aptoide.p006pt.view.settings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.view.dialog.EditableTextDialog;
import p005cm.aptoide.p006pt.view.p080rx.RxAlertDialog;

/* renamed from: cm.aptoide.pt.view.settings.PinDialog */
public class PinDialog extends EditableTextDialog {
    private static transient /* synthetic */ boolean[] $jacocoData;

    /* renamed from: cm.aptoide.pt.view.settings.PinDialog$Builder */
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
            boolean[] probes = Offline.getProbes(8341925290131184816L, "cm/aptoide/pt/view/settings/PinDialog$Builder", 16);
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

        public PinDialog build() {
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
                PinDialog pinDialog = new PinDialog(this.builder.build(), pinEditText);
                $jacocoInit[14] = true;
                return pinDialog;
            } else {
                $jacocoInit[9] = true;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("View and edit text resource ids must be provided");
            $jacocoInit[15] = true;
            throw illegalArgumentException;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2612303791332792562L, "cm/aptoide/pt/view/settings/PinDialog", 3);
        $jacocoData = probes;
        return probes;
    }

    public PinDialog(RxAlertDialog dialog, EditText editText) {
        boolean[] $jacocoInit = $jacocoInit();
        super(dialog, editText);
        $jacocoInit[0] = true;
    }

    public void show() {
        boolean[] $jacocoInit = $jacocoInit();
        super.show();
        $jacocoInit[1] = true;
        setText("");
        $jacocoInit[2] = true;
    }
}
