package p005cm.aptoide.p006pt.promotions;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.CrashLogger;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.home.HomePromotionsWrapper;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p026rx.C0120S;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.promotions.PromotionsHomeDialog */
public class PromotionsHomeDialog {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String HOME_PROMOTIONS_DIALOG_EVENT_LISTENER_IS_NULL = "HOME_PROMOTIONS_DIALOG_EVENT_LISTENER_IS_NULL";
    private Button cancel;
    private final CrashLogger crashReport = CrashReport.getInstance();
    private AlertDialog dialog;
    private View dialogView;
    private Button navigate;
    private C14963c<String> uiEvents;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3880248793960429977L, "cm/aptoide/pt/promotions/PromotionsHomeDialog", 38);
        $jacocoData = probes;
        return probes;
    }

    public PromotionsHomeDialog(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        $jacocoInit[1] = true;
        this.uiEvents = C14963c.m46753p();
        $jacocoInit[2] = true;
        LayoutInflater inflater = LayoutInflater.from(context);
        $jacocoInit[3] = true;
        this.dialog = new Builder(context).create();
        $jacocoInit[4] = true;
        this.dialogView = inflater.inflate(C1375R.layout.promotions_home_dialog, null);
        $jacocoInit[5] = true;
        this.dialog.setView(this.dialogView);
        $jacocoInit[6] = true;
        this.cancel = (Button) this.dialogView.findViewById(C1375R.C1376id.cancel_button);
        $jacocoInit[7] = true;
        this.navigate = (Button) this.dialogView.findViewById(C1375R.C1376id.navigate_button);
        $jacocoInit[8] = true;
        this.dialog.setCancelable(true);
        $jacocoInit[9] = true;
        this.dialog.setCanceledOnTouchOutside(true);
        $jacocoInit[10] = true;
        Window window = this.dialog.getWindow();
        if (window == null) {
            $jacocoInit[11] = true;
        } else {
            $jacocoInit[12] = true;
            window.setBackgroundDrawable(new ColorDrawable(0));
            $jacocoInit[13] = true;
        }
        this.navigate.setOnClickListener(new C4446Ha(this));
        $jacocoInit[14] = true;
        this.cancel.setOnClickListener(new C4449Ia(this));
        $jacocoInit[15] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15702a(View __) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<String> cVar = this.uiEvents;
        if (cVar != null) {
            $jacocoInit[34] = true;
            cVar.onNext("navigate");
            $jacocoInit[35] = true;
        } else {
            this.crashReport.log(HOME_PROMOTIONS_DIALOG_EVENT_LISTENER_IS_NULL, "");
            $jacocoInit[36] = true;
        }
        $jacocoInit[37] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo15703b(View __) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<String> cVar = this.uiEvents;
        if (cVar != null) {
            $jacocoInit[30] = true;
            cVar.onNext("cancel");
            $jacocoInit[31] = true;
        } else {
            this.crashReport.log(HOME_PROMOTIONS_DIALOG_EVENT_LISTENER_IS_NULL, "");
            $jacocoInit[32] = true;
        }
        $jacocoInit[33] = true;
    }

    public void showDialog(HomePromotionsWrapper promotions) {
        boolean[] $jacocoInit = $jacocoInit();
        this.dialog.show();
        $jacocoInit[16] = true;
        TextView description = (TextView) this.dialogView.findViewById(C1375R.C1376id.description);
        $jacocoInit[17] = true;
        Context context = this.dialogView.getContext();
        $jacocoInit[18] = true;
        Object[] objArr = {String.valueOf(promotions.getTotalAppcValue())};
        $jacocoInit[19] = true;
        String string = context.getString(C1375R.string.holidayspromotion_message_popup, objArr);
        $jacocoInit[20] = true;
        description.setText(string);
        $jacocoInit[21] = true;
        TextView titleView = (TextView) this.dialog.findViewById(C1375R.C1376id.promotion_title);
        $jacocoInit[22] = true;
        ImageView promotionGraphicView = (ImageView) this.dialog.findViewById(C1375R.C1376id.promotion_graphic);
        $jacocoInit[23] = true;
        titleView.setText(promotions.getTitle());
        $jacocoInit[24] = true;
        ImageLoader with = ImageLoader.with(this.dialog.getContext());
        $jacocoInit[25] = true;
        with.load(promotions.getFeatureGraphic(), promotionGraphicView);
        $jacocoInit[26] = true;
    }

    public void dismissDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        this.dialog.dismiss();
        $jacocoInit[27] = true;
    }

    public void destroyDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        dismissDialog();
        this.dialog = null;
        this.navigate = null;
        this.cancel = null;
        this.uiEvents = null;
        $jacocoInit[28] = true;
    }

    public C0120S<String> dialogClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<String> cVar = this.uiEvents;
        $jacocoInit[29] = true;
        return cVar;
    }
}
