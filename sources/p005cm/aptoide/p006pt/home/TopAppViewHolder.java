package p005cm.aptoide.p006pt.home;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.DecimalFormat;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.home.HomeEvent.Type;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.utils.AptoideUtils.StringU;
import p005cm.aptoide.p006pt.view.app.AppViewHolder;
import p005cm.aptoide.p006pt.view.app.Application;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.home.TopAppViewHolder */
public class TopAppViewHolder extends AppViewHolder {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final C14963c<HomeEvent> appClicks;
    private ImageView appIcon;
    private final AppSecondaryInfoViewHolder appInfoViewHolder;
    private TextView downloadNumber;
    private TextView name;
    private TextView topNumber;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4768557901350153901L, "cm/aptoide/pt/home/TopAppViewHolder", 21);
        $jacocoData = probes;
        return probes;
    }

    public TopAppViewHolder(View itemView, C14963c<HomeEvent> appClicks2, DecimalFormat oneDecimalFormatter) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        this.appClicks = appClicks2;
        $jacocoInit[0] = true;
        this.topNumber = (TextView) itemView.findViewById(C1375R.C1376id.top_number);
        $jacocoInit[1] = true;
        this.appIcon = (ImageView) itemView.findViewById(C1375R.C1376id.icon);
        $jacocoInit[2] = true;
        this.name = (TextView) itemView.findViewById(C1375R.C1376id.name_label);
        $jacocoInit[3] = true;
        this.downloadNumber = (TextView) itemView.findViewById(C1375R.C1376id.download_number_label);
        $jacocoInit[4] = true;
        this.appInfoViewHolder = new AppSecondaryInfoViewHolder(itemView, oneDecimalFormatter);
        $jacocoInit[5] = true;
        TextView rating = (TextView) itemView.findViewById(C1375R.C1376id.rating_label);
        $jacocoInit[6] = true;
        rating.setTextAppearance(itemView.getContext(), C1375R.style.Aptoide_TextView_Medium_XXS_Black);
        $jacocoInit[7] = true;
    }

    public void setApp(Application app, HomeBundle homeBundle, int position, int bundlePosition) {
        boolean[] $jacocoInit = $jacocoInit();
        ImageLoader with = ImageLoader.with(this.itemView.getContext());
        $jacocoInit[8] = true;
        with.loadWithRoundCorners(app.getIcon(), 8, this.appIcon, (int) C1375R.drawable.placeholder_square);
        $jacocoInit[9] = true;
        this.name.setText(app.getName());
        $jacocoInit[10] = true;
        this.topNumber.setText(String.valueOf(bundlePosition + 1));
        $jacocoInit[11] = true;
        this.appInfoViewHolder.setInfo(app.hasAppcBilling(), app.getRating(), true, true);
        TextView textView = this.downloadNumber;
        $jacocoInit[12] = true;
        View view = this.itemView;
        $jacocoInit[13] = true;
        Context context = view.getContext();
        $jacocoInit[14] = true;
        Resources resources = context.getResources();
        $jacocoInit[15] = true;
        Object[] objArr = {StringU.withSuffix((long) app.getDownloads()), resources.getString(C1375R.string.downloads)};
        $jacocoInit[16] = true;
        String format = String.format("%s %s", objArr);
        $jacocoInit[17] = true;
        textView.setText(format);
        $jacocoInit[18] = true;
        View view2 = this.itemView;
        C3908oe oeVar = new C3908oe(this, app, position, homeBundle, bundlePosition);
        view2.setOnClickListener(oeVar);
        $jacocoInit[19] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14563a(Application app, int position, HomeBundle homeBundle, int bundlePosition, View v) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<HomeEvent> cVar = this.appClicks;
        AppHomeEvent appHomeEvent = new AppHomeEvent(app, position, homeBundle, bundlePosition, Type.APP);
        cVar.onNext(appHomeEvent);
        $jacocoInit[20] = true;
    }
}
