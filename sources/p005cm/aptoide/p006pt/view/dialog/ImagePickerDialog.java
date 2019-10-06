package p005cm.aptoide.p006pt.view.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.view.p080rx.RxAlertDialog;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.view.dialog.ImagePickerDialog */
public class ImagePickerDialog implements DialogInterface {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final int LAYOUT = 2131427438;
    private final RxAlertDialog dialog;
    private View selectFromCamera;
    private View selectFromGallery;

    /* renamed from: cm.aptoide.pt.view.dialog.ImagePickerDialog$1 */
    static /* synthetic */ class C53181 {
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-3369359858776930965L, "cm/aptoide/pt/view/dialog/ImagePickerDialog$1", 0);
            $jacocoData = probes;
            return probes;
        }
    }

    /* renamed from: cm.aptoide.pt.view.dialog.ImagePickerDialog$Builder */
    public static class Builder {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private final p005cm.aptoide.p006pt.view.p080rx.RxAlertDialog.Builder builder;
        private int cameraButtonRes;
        private int galleryButtonRes;
        private final LayoutInflater layoutInflater;
        private int viewRes;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-1721482131629197395L, "cm/aptoide/pt/view/dialog/ImagePickerDialog$Builder", 19);
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

        public Builder setViewRes(int viewRes2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.viewRes = viewRes2;
            $jacocoInit[3] = true;
            return this;
        }

        public Builder setCameraButton(int textRes) {
            boolean[] $jacocoInit = $jacocoInit();
            this.cameraButtonRes = textRes;
            $jacocoInit[4] = true;
            return this;
        }

        public Builder setGalleryButton(int textRes) {
            boolean[] $jacocoInit = $jacocoInit();
            this.galleryButtonRes = textRes;
            $jacocoInit[5] = true;
            return this;
        }

        public Builder setTitle(int titleId) {
            boolean[] $jacocoInit = $jacocoInit();
            this.builder.setTitle(titleId);
            $jacocoInit[6] = true;
            return this;
        }

        public Builder setNegativeButton(int textId) {
            boolean[] $jacocoInit = $jacocoInit();
            this.builder.setNegativeButton(textId);
            $jacocoInit[7] = true;
            return this;
        }

        public ImagePickerDialog build() {
            boolean[] $jacocoInit = $jacocoInit();
            int i = this.viewRes;
            if (i == 0) {
                $jacocoInit[8] = true;
            } else if (this.cameraButtonRes == 0) {
                $jacocoInit[9] = true;
            } else if (this.galleryButtonRes != 0) {
                $jacocoInit[11] = true;
                View view = this.layoutInflater.inflate(i, null, false);
                $jacocoInit[12] = true;
                TextView cameraButton = (TextView) view.findViewById(this.cameraButtonRes);
                $jacocoInit[13] = true;
                TextView galleryButton = (TextView) view.findViewById(this.galleryButtonRes);
                $jacocoInit[14] = true;
                this.builder.setView(view);
                $jacocoInit[15] = true;
                RxAlertDialog dialog = this.builder.build();
                $jacocoInit[16] = true;
                ImagePickerDialog imagePickerDialog = new ImagePickerDialog(dialog, cameraButton, galleryButton, null);
                $jacocoInit[17] = true;
                return imagePickerDialog;
            } else {
                $jacocoInit[10] = true;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("View and edit text resource ids must be provided");
            $jacocoInit[18] = true;
            throw illegalArgumentException;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7183300455618974903L, "cm/aptoide/pt/view/dialog/ImagePickerDialog", 12);
        $jacocoData = probes;
        return probes;
    }

    /* synthetic */ ImagePickerDialog(RxAlertDialog x0, TextView x1, TextView x2, C53181 x3) {
        boolean[] $jacocoInit = $jacocoInit();
        this(x0, x1, x2);
        $jacocoInit[11] = true;
    }

    private ImagePickerDialog(RxAlertDialog dialog2, TextView cameraButton, TextView galleryButton) {
        boolean[] $jacocoInit = $jacocoInit();
        this.dialog = dialog2;
        this.selectFromCamera = cameraButton;
        this.selectFromGallery = galleryButton;
        $jacocoInit[0] = true;
    }

    public void show() {
        boolean[] $jacocoInit = $jacocoInit();
        this.dialog.show();
        $jacocoInit[1] = true;
    }

    public C0120S<DialogInterface> cameraSelected() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.selectFromCamera);
        C5334p pVar = new C5334p(this);
        $jacocoInit[2] = true;
        C0120S<DialogInterface> j = a.mo3669j(pVar);
        $jacocoInit[3] = true;
        return j;
    }

    /* renamed from: a */
    public /* synthetic */ DialogInterface mo17194a(Void __) {
        $jacocoInit()[10] = true;
        return this;
    }

    public C0120S<DialogInterface> gallerySelected() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.selectFromGallery);
        C5335q qVar = new C5335q(this);
        $jacocoInit[4] = true;
        C0120S<DialogInterface> j = a.mo3669j(qVar);
        $jacocoInit[5] = true;
        return j;
    }

    /* renamed from: b */
    public /* synthetic */ DialogInterface mo17195b(Void __) {
        $jacocoInit()[9] = true;
        return this;
    }

    public C0120S<DialogInterface> cancelsSelected() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<DialogInterface> cancels = this.dialog.cancels();
        $jacocoInit[6] = true;
        return cancels;
    }

    public void cancel() {
        boolean[] $jacocoInit = $jacocoInit();
        this.dialog.cancel();
        $jacocoInit[7] = true;
    }

    public void dismiss() {
        boolean[] $jacocoInit = $jacocoInit();
        this.dialog.dismiss();
        $jacocoInit[8] = true;
    }
}
