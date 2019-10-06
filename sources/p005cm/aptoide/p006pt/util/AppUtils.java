package p005cm.aptoide.p006pt.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Obb;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Obb.ObbItem;
import p005cm.aptoide.p006pt.permissions.ApkPermission;
import p005cm.aptoide.p006pt.permissions.ApkPermissionGroup;

/* renamed from: cm.aptoide.pt.util.AppUtils */
public final class AppUtils {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(348331800899145632L, "cm/aptoide/pt/util/AppUtils", 56);
        $jacocoData = probes;
        return probes;
    }

    public AppUtils() {
        $jacocoInit()[0] = true;
    }

    public static long sumFileSizes(long fileSize, Obb obb) {
        boolean[] $jacocoInit = $jacocoInit();
        if (obb == null) {
            $jacocoInit[1] = true;
        } else if (obb.getMain() == null) {
            $jacocoInit[2] = true;
        } else if (obb.getPatch() == null) {
            $jacocoInit[4] = true;
            ObbItem main = obb.getMain();
            $jacocoInit[5] = true;
            long filesize = main.getFilesize() + fileSize;
            $jacocoInit[6] = true;
            return filesize;
        } else {
            ObbItem main2 = obb.getMain();
            $jacocoInit[7] = true;
            long filesize2 = main2.getFilesize() + fileSize;
            ObbItem patch = obb.getPatch();
            $jacocoInit[8] = true;
            long filesize3 = filesize2 + patch.getFilesize();
            $jacocoInit[9] = true;
            return filesize3;
        }
        $jacocoInit[3] = true;
        return fileSize;
    }

    public static ArrayList<ApkPermissionGroup> fillPermissionsGroups(List<ApkPermission> permissions) {
        boolean[] $jacocoInit = $jacocoInit();
        ArrayList<ApkPermissionGroup> list = new ArrayList<>();
        String prevName = null;
        ApkPermissionGroup apkPermission = null;
        $jacocoInit[10] = true;
        int i = 0;
        $jacocoInit[11] = true;
        while (i <= permissions.size()) {
            $jacocoInit[12] = true;
            if (i >= permissions.size()) {
                $jacocoInit[13] = true;
                if (list.contains(apkPermission)) {
                    $jacocoInit[14] = true;
                } else {
                    $jacocoInit[15] = true;
                    list.add(apkPermission);
                    $jacocoInit[16] = true;
                }
            } else {
                ApkPermission permission = (ApkPermission) permissions.get(i);
                $jacocoInit[17] = true;
                String name = permission.getName();
                $jacocoInit[18] = true;
                if (!name.equals(prevName)) {
                    $jacocoInit[19] = true;
                    prevName = permission.getName();
                    $jacocoInit[20] = true;
                    apkPermission = new ApkPermissionGroup(permission.getName(), permission.getDescription());
                    $jacocoInit[21] = true;
                    list.add(apkPermission);
                    $jacocoInit[22] = true;
                } else {
                    apkPermission.setDescription(permission.getDescription());
                    $jacocoInit[23] = true;
                }
            }
            i++;
            $jacocoInit[24] = true;
        }
        $jacocoInit[25] = true;
        return list;
    }

    public static void fillPermissionsForTableLayout(Context context, TableLayout mPermissionsTable, List<ApkPermissionGroup> apkPermissions) {
        boolean z;
        Context context2 = context;
        TableLayout tableLayout = mPermissionsTable;
        boolean[] $jacocoInit = $jacocoInit();
        boolean z2 = false;
        boolean z3 = true;
        $jacocoInit[26] = true;
        TableRow tr = new TableRow(context2);
        $jacocoInit[27] = true;
        int i = -1;
        int i2 = -2;
        tr.setLayoutParams(new LayoutParams(-1, -2));
        int items = 0;
        $jacocoInit[28] = true;
        int i3 = 0;
        $jacocoInit[29] = true;
        while (i3 <= apkPermissions.size()) {
            $jacocoInit[30] = z3;
            if (i3 >= apkPermissions.size()) {
                $jacocoInit[31] = z3;
                if (tr.getChildCount() <= 0) {
                    $jacocoInit[32] = z3;
                } else {
                    $jacocoInit[33] = z3;
                    tr.setPadding(0, 0, 0, 20);
                    $jacocoInit[34] = z3;
                    tableLayout.addView(tr, new TableLayout.LayoutParams(i, i2));
                    $jacocoInit[35] = z3;
                }
                List<ApkPermissionGroup> list = apkPermissions;
                z = z2;
            } else {
                items++;
                $jacocoInit[36] = z3;
                ApkPermissionGroup apkPermission = (ApkPermissionGroup) apkPermissions.get(i3);
                if (apkPermission == null) {
                    $jacocoInit[37] = z3;
                    z = z2;
                } else {
                    $jacocoInit[38] = z3;
                    LayoutInflater from = LayoutInflater.from(context);
                    $jacocoInit[39] = z3;
                    LinearLayout linearLayout = (LinearLayout) from.inflate(C1375R.layout.row_permission, tr, false);
                    $jacocoInit[40] = z3;
                    TextView name = (TextView) linearLayout.findViewById(C1375R.C1376id.permission_name);
                    $jacocoInit[41] = z3;
                    name.setText(apkPermission.getName());
                    $jacocoInit[42] = z3;
                    $jacocoInit[43] = z3;
                    for (String s : apkPermission.getDescriptions()) {
                        $jacocoInit[44] = z3;
                        LayoutInflater from2 = LayoutInflater.from(context);
                        boolean z4 = z2;
                        $jacocoInit[45] = z3;
                        TextView description = (TextView) from2.inflate(C1375R.layout.row_description, linearLayout, false);
                        $jacocoInit[46] = true;
                        description.setText(s);
                        $jacocoInit[47] = true;
                        linearLayout.addView(description);
                        $jacocoInit[48] = true;
                        z2 = z4;
                        z3 = true;
                    }
                    z = z2;
                    tr.addView(linearLayout, new LayoutParams(0, -2, 1.0f));
                    if (items % 2 != 0) {
                        z3 = true;
                        $jacocoInit[49] = true;
                    } else {
                        z3 = true;
                        $jacocoInit[50] = true;
                        tableLayout.addView(tr, new TableLayout.LayoutParams(-1, -2));
                        $jacocoInit[51] = true;
                        TableRow tr2 = new TableRow(context2);
                        $jacocoInit[52] = true;
                        i = -1;
                        i2 = -2;
                        tr2.setLayoutParams(new LayoutParams(-1, -2));
                        $jacocoInit[53] = true;
                        tr = tr2;
                    }
                }
                i = -1;
                i2 = -2;
            }
            i3++;
            $jacocoInit[54] = z3;
            z2 = z;
        }
        List<ApkPermissionGroup> list2 = apkPermissions;
        boolean z5 = z2;
        $jacocoInit[55] = z3;
    }
}
