package p005cm.aptoide.p006pt.permission;

import android.content.Context;
import android.os.Bundle;
import android.support.p000v4.app.C0453b;
import android.support.p000v4.content.C0510b;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.permission.PermissionProvider.Permission;
import p019d.p022i.p023b.C0100e;
import p026rx.C0120S;
import p026rx.p027b.C0132p;
import p026rx.p027b.C14541q;

/* renamed from: cm.aptoide.pt.permission.PermissionProviderActivity */
public abstract class PermissionProviderActivity extends PermissionServiceActivity implements PermissionProvider {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private C0100e<Set<Permission>> permissionRelay;
    private SparseArray<Set<Permission>> requestedCodeGrantedPermissions;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3963760338773579745L, "cm/aptoide/pt/permission/PermissionProviderActivity", 40);
        $jacocoData = probes;
        return probes;
    }

    public PermissionProviderActivity() {
        $jacocoInit()[0] = true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[1] = true;
        this.permissionRelay = C0100e.m565o();
        $jacocoInit[2] = true;
        this.requestedCodeGrantedPermissions = new SparseArray<>();
        $jacocoInit[3] = true;
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissionNames, int[] grantResults) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        super.onRequestPermissionsResult(requestCode, permissionNames, grantResults);
        $jacocoInit[4] = true;
        Set<Permission> permissions = new HashSet<>();
        int i = 0;
        $jacocoInit[5] = true;
        while (i < permissionNames.length) {
            $jacocoInit[6] = true;
            String str = permissionNames[i];
            if (grantResults[i] == 0) {
                $jacocoInit[7] = true;
                z = true;
            } else {
                z = false;
                $jacocoInit[8] = true;
            }
            permissions.add(new Permission(requestCode, str, z));
            i++;
            $jacocoInit[9] = true;
        }
        this.permissionRelay.call(permissions);
        $jacocoInit[10] = true;
    }

    public void providePermissions(String[] permissions, int requestCode) {
        boolean[] $jacocoInit = $jacocoInit();
        Set<Permission> grantedPermissions = new HashSet<>();
        $jacocoInit[11] = true;
        List<String> notGrantedPermissions = new ArrayList<>();
        $jacocoInit[12] = true;
        this.requestedCodeGrantedPermissions.clear();
        int length = permissions.length;
        $jacocoInit[13] = true;
        int i = 0;
        while (i < length) {
            String permission = permissions[i];
            $jacocoInit[14] = true;
            if (C0510b.m2565a((Context) this, permission) == 0) {
                $jacocoInit[15] = true;
                grantedPermissions.add(new Permission(requestCode, permission, true));
                $jacocoInit[16] = true;
            } else {
                notGrantedPermissions.add(permission);
                $jacocoInit[17] = true;
            }
            i++;
            $jacocoInit[18] = true;
        }
        this.requestedCodeGrantedPermissions.put(requestCode, grantedPermissions);
        $jacocoInit[19] = true;
        if (notGrantedPermissions.isEmpty()) {
            $jacocoInit[20] = true;
            this.permissionRelay.call(grantedPermissions);
            $jacocoInit[21] = true;
        } else {
            C0453b.m2341a(this, (String[]) notGrantedPermissions.toArray(new String[0]), requestCode);
            $jacocoInit[22] = true;
        }
        $jacocoInit[23] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo2285a(int requestCode, Set permissions) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = C0120S.m652c(permissions);
        SparseArray<Set<Permission>> sparseArray = this.requestedCodeGrantedPermissions;
        $jacocoInit[25] = true;
        C0120S c2 = C0120S.m652c(sparseArray.get(requestCode));
        C4260b bVar = C4260b.f7841a;
        $jacocoInit[26] = true;
        C0120S b = C0120S.m650b(c, c2, (C14541q<? super T1, ? super T2, ? extends R>) bVar);
        C4264f fVar = C4264f.f7846a;
        $jacocoInit[27] = true;
        C0120S h = b.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) fVar);
        C4261c cVar = new C4261c(requestCode);
        $jacocoInit[28] = true;
        C0120S d = h.mo3653d((C0132p<? super T, Boolean>) cVar);
        $jacocoInit[29] = true;
        C0120S m = d.mo3675m();
        C4263e eVar = C4263e.f7845a;
        $jacocoInit[30] = true;
        C0120S d2 = m.mo3653d((C0132p<? super T, Boolean>) eVar);
        $jacocoInit[31] = true;
        return d2;
    }

    public C0120S<List<Permission>> permissionResults(int requestCode) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<List<Permission>> f = this.permissionRelay.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C4262d<Object,Object>(this, requestCode));
        $jacocoInit[24] = true;
        return f;
    }

    /* renamed from: a */
    static /* synthetic */ Set m479a(Set systemPermissions, Set savedPermissions) {
        boolean[] $jacocoInit = $jacocoInit();
        systemPermissions.addAll(savedPermissions);
        $jacocoInit[39] = true;
        return systemPermissions;
    }

    /* renamed from: a */
    static /* synthetic */ Iterable m478a(Set mergedPermissions) {
        $jacocoInit()[38] = true;
        return mergedPermissions;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m476a(int requestCode, Permission permission) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (requestCode == permission.getRequestCode()) {
            $jacocoInit[35] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[36] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[37] = true;
        return valueOf;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m477a(List permissionsList) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!permissionsList.isEmpty()) {
            $jacocoInit[32] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[33] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[34] = true;
        return valueOf;
    }
}
