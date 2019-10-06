package p005cm.aptoide.p006pt.permission;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p000v4.app.C0478k;
import android.support.p000v4.app.Fragment;
import android.support.p001v7.app.C0774m;
import android.support.p001v7.app.C0774m.C0775a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import com.bumptech.glide.C5926c;
import com.bumptech.glide.C6029k;
import com.bumptech.glide.C6354n;
import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.permissions.ApkPermission;
import p005cm.aptoide.p006pt.permissions.ApkPermissionGroup;
import p005cm.aptoide.p006pt.util.AppUtils;
import p005cm.aptoide.p006pt.utils.AptoideUtils.SystemU;

/* renamed from: cm.aptoide.pt.permission.DialogPermissions */
public class DialogPermissions extends C0478k {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private String appName;
    private String icon;
    private String size;
    private List<String> usedPermissions;
    private String versionName;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2427939698685712570L, "cm/aptoide/pt/permission/DialogPermissions", 35);
        $jacocoData = probes;
        return probes;
    }

    public DialogPermissions() {
        $jacocoInit()[0] = true;
    }

    public static DialogPermissions newInstance(String appName2, String versionName2, String icon2, String size2, List<String> usedPermissions2) {
        boolean[] $jacocoInit = $jacocoInit();
        DialogPermissions dialog = new DialogPermissions();
        dialog.appName = appName2;
        dialog.versionName = versionName2;
        dialog.icon = icon2;
        dialog.size = size2;
        dialog.usedPermissions = usedPermissions2;
        $jacocoInit[1] = true;
        return dialog;
    }

    public void onPause() {
        boolean[] $jacocoInit = $jacocoInit();
        dismiss();
        $jacocoInit[2] = true;
        super.onPause();
        $jacocoInit[3] = true;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            $jacocoInit[4] = true;
            setStyle(0, 16974394);
            $jacocoInit[5] = true;
        } else if (i >= 11) {
            $jacocoInit[6] = true;
            setStyle(0, 16973934);
            $jacocoInit[7] = true;
        } else {
            setStyle(0, 16973835);
            $jacocoInit[8] = true;
        }
        $jacocoInit[9] = true;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        LayoutInflater from = LayoutInflater.from(getActivity());
        $jacocoInit[10] = true;
        View v = from.inflate(C1375R.layout.layout_dialog_permissions, null);
        $jacocoInit[11] = true;
        C0775a aVar = new C0775a(getActivity());
        aVar.mo6235b(v);
        $jacocoInit[12] = true;
        C0774m builder = aVar.mo6231a();
        $jacocoInit[13] = true;
        View findViewById = v.findViewById(C1375R.C1376id.dialog_ok_button);
        C4259a aVar2 = new C4259a(this);
        $jacocoInit[14] = true;
        findViewById.setOnClickListener(aVar2);
        $jacocoInit[15] = true;
        TextView tvAppInfo = (TextView) v.findViewById(C1375R.C1376id.dialog_app_info);
        $jacocoInit[16] = true;
        tvAppInfo.setText(getString(C1375R.string.dialog_version_size, this.versionName, this.size));
        $jacocoInit[17] = true;
        TextView tvAppName = (TextView) v.findViewById(C1375R.C1376id.dialog_app_name);
        $jacocoInit[18] = true;
        tvAppName.setText(this.appName);
        $jacocoInit[19] = true;
        C6354n a = C5926c.m10917a((Fragment) this);
        String str = this.icon;
        $jacocoInit[20] = true;
        C6029k a2 = a.mo19318a(str);
        $jacocoInit[21] = true;
        a2.mo18834a((ImageView) v.findViewById(C1375R.C1376id.dialog_appview_icon));
        $jacocoInit[22] = true;
        TableLayout tableLayout = (TableLayout) v.findViewById(C1375R.C1376id.dialog_table_permissions);
        $jacocoInit[23] = true;
        List<ApkPermission> apkPermissions = SystemU.parsePermissions(getContext(), this.usedPermissions);
        $jacocoInit[24] = true;
        ArrayList<ApkPermissionGroup> apkPermissionsGroup = AppUtils.fillPermissionsGroups(apkPermissions);
        $jacocoInit[25] = true;
        if (apkPermissionsGroup.size() == 0) {
            $jacocoInit[26] = true;
            TextView noPermissions = new TextView(getContext());
            $jacocoInit[27] = true;
            noPermissions.setText(getString(C1375R.string.no_permissions_required));
            $jacocoInit[28] = true;
            noPermissions.setPadding(5, 5, 5, 5);
            $jacocoInit[29] = true;
        } else {
            AppUtils.fillPermissionsForTableLayout(getContext(), tableLayout, apkPermissionsGroup);
            $jacocoInit[30] = true;
        }
        Window window = builder.getWindow();
        $jacocoInit[31] = true;
        ColorDrawable colorDrawable = new ColorDrawable(getResources().getColor(17170445));
        $jacocoInit[32] = true;
        window.setBackgroundDrawable(colorDrawable);
        $jacocoInit[33] = true;
        return builder;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15355a(View v1) {
        boolean[] $jacocoInit = $jacocoInit();
        dismiss();
        $jacocoInit[34] = true;
    }
}
