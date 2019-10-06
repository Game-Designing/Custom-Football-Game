package p005cm.aptoide.p006pt.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.DecimalFormat;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.home.HomeEvent.Type;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.view.app.AppViewHolder;
import p005cm.aptoide.p006pt.view.app.Application;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.home.AppInBundleViewHolder */
public class AppInBundleViewHolder extends AppViewHolder {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final C14963c<HomeEvent> appClicks;
    private AppSecondaryInfoViewHolder appInfoViewHolder;
    private final ImageView iconView;
    private final TextView nameTextView;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1135069226590751008L, "cm/aptoide/pt/home/AppInBundleViewHolder", 10);
        $jacocoData = probes;
        return probes;
    }

    public AppInBundleViewHolder(View itemView, C14963c<HomeEvent> appClicks2, DecimalFormat oneDecimalFormatter) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
        this.appInfoViewHolder = new AppSecondaryInfoViewHolder(itemView, oneDecimalFormatter);
        $jacocoInit[1] = true;
        this.nameTextView = (TextView) itemView.findViewById(C1375R.C1376id.name);
        $jacocoInit[2] = true;
        this.iconView = (ImageView) itemView.findViewById(C1375R.C1376id.icon);
        this.appClicks = appClicks2;
        $jacocoInit[3] = true;
    }

    public void setApp(Application app, HomeBundle homeBundle, int bundlePosition, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        this.nameTextView.setText(app.getName());
        $jacocoInit[4] = true;
        ImageLoader with = ImageLoader.with(this.itemView.getContext());
        $jacocoInit[5] = true;
        with.loadWithRoundCorners(app.getIcon(), 8, this.iconView, (int) C1375R.drawable.placeholder_square);
        $jacocoInit[6] = true;
        this.appInfoViewHolder.setInfo(app.hasAppcBilling(), app.getRating(), true, false);
        $jacocoInit[7] = true;
        View view = this.itemView;
        C3861h hVar = new C3861h(this, app, position, homeBundle, bundlePosition);
        view.setOnClickListener(hVar);
        $jacocoInit[8] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14214a(Application app, int position, HomeBundle homeBundle, int bundlePosition, View v) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<HomeEvent> cVar = this.appClicks;
        AppHomeEvent appHomeEvent = new AppHomeEvent(app, position, homeBundle, bundlePosition, Type.APP);
        cVar.onNext(appHomeEvent);
        $jacocoInit[9] = true;
    }
}
