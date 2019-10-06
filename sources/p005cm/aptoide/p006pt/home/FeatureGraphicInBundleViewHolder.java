package p005cm.aptoide.p006pt.home;

import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.DecimalFormat;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.home.HomeEvent.Type;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.view.app.FeatureGraphicApplication;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.home.FeatureGraphicInBundleViewHolder */
class FeatureGraphicInBundleViewHolder extends C1000w {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final C14963c<HomeEvent> appClickedEvents;
    private final ImageView appIcon;
    private final ImageView featureGraphic;
    private final TextView nameTextView = ((TextView) this.itemView.findViewById(C1375R.C1376id.app_name));
    private final DecimalFormat oneDecimalFormatter;
    private final TextView rating;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7198158308216877222L, "cm/aptoide/pt/home/FeatureGraphicInBundleViewHolder", 15);
        $jacocoData = probes;
        return probes;
    }

    public FeatureGraphicInBundleViewHolder(View view, DecimalFormat oneDecimalFormatter2, C14963c<HomeEvent> appClickedEvents2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(view);
        this.oneDecimalFormatter = oneDecimalFormatter2;
        this.appClickedEvents = appClickedEvents2;
        $jacocoInit[0] = true;
        $jacocoInit[1] = true;
        this.featureGraphic = (ImageView) this.itemView.findViewById(C1375R.C1376id.featured_graphic);
        $jacocoInit[2] = true;
        this.rating = (TextView) this.itemView.findViewById(C1375R.C1376id.rating_label);
        $jacocoInit[3] = true;
        this.appIcon = (ImageView) this.itemView.findViewById(C1375R.C1376id.app_icon);
        $jacocoInit[4] = true;
    }

    public void setFeatureGraphicApplication(FeatureGraphicApplication featureGraphicApplication, HomeBundle homeBundle, int bundlePosition, int graphicPosition) {
        boolean[] $jacocoInit = $jacocoInit();
        this.nameTextView.setText(featureGraphicApplication.getName());
        $jacocoInit[5] = true;
        ImageLoader with = ImageLoader.with(this.itemView.getContext());
        $jacocoInit[6] = true;
        with.load(featureGraphicApplication.getFeatureGraphic(), C1375R.drawable.placeholder_brick, this.featureGraphic);
        $jacocoInit[7] = true;
        ImageLoader with2 = ImageLoader.with(this.itemView.getContext());
        $jacocoInit[8] = true;
        with2.load(featureGraphicApplication.getIcon(), C1375R.drawable.placeholder_square, this.appIcon);
        $jacocoInit[9] = true;
        float rating2 = featureGraphicApplication.getRating();
        if (rating2 == 0.0f) {
            $jacocoInit[10] = true;
            this.rating.setText(C1375R.string.appcardview_title_no_stars);
            $jacocoInit[11] = true;
        } else {
            this.rating.setText(this.oneDecimalFormatter.format((double) rating2));
            $jacocoInit[12] = true;
        }
        View view = this.itemView;
        C3945v vVar = new C3945v(this, featureGraphicApplication, graphicPosition, homeBundle, bundlePosition);
        view.setOnClickListener(vVar);
        $jacocoInit[13] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14269a(FeatureGraphicApplication featureGraphicApplication, int graphicPosition, HomeBundle homeBundle, int bundlePosition, View v) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<HomeEvent> cVar = this.appClickedEvents;
        AppHomeEvent appHomeEvent = new AppHomeEvent(featureGraphicApplication, graphicPosition, homeBundle, bundlePosition, Type.APP);
        cVar.onNext(appHomeEvent);
        $jacocoInit[14] = true;
    }
}
