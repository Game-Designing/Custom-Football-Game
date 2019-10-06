package p005cm.aptoide.p006pt.home;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.home.HomeEvent.Type;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.view.app.AppViewHolder;
import p005cm.aptoide.p006pt.view.app.Application;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.home.RewardAppInBundleViewHolder */
public class RewardAppInBundleViewHolder extends AppViewHolder {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final C14963c<HomeEvent> appClicks;
    private final ImageView appIcon;
    private final TextView appName;
    private final TextView appReward;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8159052665727085217L, "cm/aptoide/pt/home/RewardAppInBundleViewHolder", 12);
        $jacocoData = probes;
        return probes;
    }

    public RewardAppInBundleViewHolder(View itemView, C14963c<HomeEvent> appClicks2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
        this.appIcon = (ImageView) itemView.findViewById(C1375R.C1376id.icon);
        $jacocoInit[1] = true;
        this.appName = (TextView) itemView.findViewById(C1375R.C1376id.name);
        $jacocoInit[2] = true;
        this.appReward = (TextView) itemView.findViewById(C1375R.C1376id.appc_text);
        this.appClicks = appClicks2;
        $jacocoInit[3] = true;
    }

    public void setApp(Application app, HomeBundle homeBundle, int position, int bundlePosition) {
        boolean[] $jacocoInit = $jacocoInit();
        ImageLoader with = ImageLoader.with(this.itemView.getContext());
        $jacocoInit[4] = true;
        with.loadWithRoundCorners(app.getIcon(), 8, this.appIcon, (int) C1375R.drawable.placeholder_square);
        $jacocoInit[5] = true;
        this.appName.setText(app.getName());
        $jacocoInit[6] = true;
        TextView textView = this.appReward;
        Resources resources = this.itemView.getResources();
        $jacocoInit[7] = true;
        String string = resources.getString(C1375R.string.appc_card_short);
        $jacocoInit[8] = true;
        textView.setText(string);
        $jacocoInit[9] = true;
        View view = this.itemView;
        C3896me meVar = new C3896me(this, app, position, homeBundle, bundlePosition);
        view.setOnClickListener(meVar);
        $jacocoInit[10] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14562a(Application app, int position, HomeBundle homeBundle, int bundlePosition, View v) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<HomeEvent> cVar = this.appClicks;
        AppHomeEvent appHomeEvent = new AppHomeEvent(app, position, homeBundle, bundlePosition, Type.REWARD_APP);
        cVar.onNext(appHomeEvent);
        $jacocoInit[11] = true;
    }
}
