package p005cm.aptoide.p006pt.view.app;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.DecimalFormat;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.view.app.ApplicationViewHolder */
public class ApplicationViewHolder extends ListStoreAppViewHolder {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final C14963c<Application> appClicks;
    private final ImageView iconView;
    private final TextView nameTextView;
    private final TextView rating;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2695302076155021759L, "cm/aptoide/pt/view/app/ApplicationViewHolder", 12);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationViewHolder(View itemView, C14963c<Application> appClicks2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
        this.nameTextView = (TextView) itemView.findViewById(C1375R.C1376id.name);
        $jacocoInit[1] = true;
        this.iconView = (ImageView) itemView.findViewById(C1375R.C1376id.icon);
        $jacocoInit[2] = true;
        this.rating = (TextView) itemView.findViewById(C1375R.C1376id.rating_label);
        this.appClicks = appClicks2;
        $jacocoInit[3] = true;
    }

    public void setApp(Application app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.nameTextView.setText(app.getName());
        $jacocoInit[4] = true;
        ImageLoader with = ImageLoader.with(this.itemView.getContext());
        $jacocoInit[5] = true;
        with.load(app.getIcon(), this.iconView);
        $jacocoInit[6] = true;
        float rating2 = app.getRating();
        if (rating2 == 0.0f) {
            $jacocoInit[7] = true;
            this.rating.setText(C1375R.string.appcardview_title_no_stars);
            $jacocoInit[8] = true;
        } else {
            this.rating.setText(new DecimalFormat("0.0").format((double) rating2));
            $jacocoInit[9] = true;
        }
        this.itemView.setOnClickListener(new C5256Y(this, app));
        $jacocoInit[10] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17021a(Application app, View v) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appClicks.onNext(app);
        $jacocoInit[11] = true;
    }
}
