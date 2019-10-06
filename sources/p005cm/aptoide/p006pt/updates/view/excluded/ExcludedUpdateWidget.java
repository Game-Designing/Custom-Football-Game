package p005cm.aptoide.p006pt.updates.view.excluded;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.database.realm.Update;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.widget.Widget;

/* renamed from: cm.aptoide.pt.updates.view.excluded.ExcludedUpdateWidget */
public class ExcludedUpdateWidget extends Widget<ExcludedUpdateDisplayable> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private ImageView icon;
    private CheckBox isExcluded;
    private TextView name;
    private TextView packageName;
    private TextView versionCode;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1663093190647136572L, "cm/aptoide/pt/updates/view/excluded/ExcludedUpdateWidget", 16);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((ExcludedUpdateDisplayable) displayable, i);
        $jacocoInit[14] = true;
    }

    public ExcludedUpdateWidget(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: protected */
    public void assignViews(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.icon = (ImageView) itemView.findViewById(C1375R.C1376id.icon);
        $jacocoInit[1] = true;
        this.name = (TextView) itemView.findViewById(C1375R.C1376id.name);
        $jacocoInit[2] = true;
        this.versionCode = (TextView) itemView.findViewById(C1375R.C1376id.version_code);
        $jacocoInit[3] = true;
        this.packageName = (TextView) itemView.findViewById(C1375R.C1376id.apk_id);
        $jacocoInit[4] = true;
        this.isExcluded = (CheckBox) itemView.findViewById(C1375R.C1376id.is_excluded);
        $jacocoInit[5] = true;
    }

    public void bindView(ExcludedUpdateDisplayable displayable, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        Update excludedUpdate = (Update) displayable.getPojo();
        $jacocoInit[6] = true;
        ImageLoader with = ImageLoader.with(getContext());
        $jacocoInit[7] = true;
        with.load(excludedUpdate.getIcon(), this.icon);
        $jacocoInit[8] = true;
        this.name.setText(excludedUpdate.getLabel());
        $jacocoInit[9] = true;
        this.versionCode.setText(excludedUpdate.getUpdateVersionName());
        $jacocoInit[10] = true;
        this.packageName.setText(excludedUpdate.getPackageName());
        $jacocoInit[11] = true;
        this.isExcluded.setOnCheckedChangeListener(new C5151a(displayable));
        $jacocoInit[12] = true;
        this.isExcluded.setChecked(displayable.isSelected());
        $jacocoInit[13] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9436a(ExcludedUpdateDisplayable displayable, CompoundButton buttonView, boolean isChecked) {
        boolean[] $jacocoInit = $jacocoInit();
        displayable.setSelected(isChecked);
        $jacocoInit[15] = true;
    }
}
