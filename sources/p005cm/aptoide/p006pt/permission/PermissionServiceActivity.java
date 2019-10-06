package p005cm.aptoide.p006pt.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.p000v4.app.C0453b;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.content.C0510b;
import com.facebook.C6787r;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.actions.PermissionService;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.navigator.ActivityResultNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.preferences.managed.ManagerPreferences;
import p005cm.aptoide.p006pt.utils.AptoideUtils.SystemU;
import p005cm.aptoide.p006pt.utils.GenericDialogs;
import p005cm.aptoide.p006pt.utils.GenericDialogs.EResponse;
import p005cm.aptoide.p006pt.utils.SimpleSubscriber;
import p005cm.aptoide.p006pt.utils.design.ShowMessage;
import p005cm.aptoide.p006pt.view.FragmentProvider;
import p026rx.C0120S;
import p026rx.C14980ia;
import p026rx.p027b.C0128a;

@Deprecated
/* renamed from: cm.aptoide.pt.permission.PermissionServiceActivity */
public abstract class PermissionServiceActivity extends ActivityResultNavigator implements PermissionService {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int ACCESS_TO_ACCOUNTS_REQUEST_ID = 62;
    private static final int ACCESS_TO_EXTERNAL_FS_REQUEST_ID = 61;
    private static final int PERMISSIONS_REQUEST_ACCESS_CAMERA = 101;
    private static final String TAG = PermissionServiceActivity.class.getName();
    private ConnectivityManager connectivityManager;
    private SharedPreferences sharedPreferences;
    private C0128a toRunWhenAccessToAccountsIsDenied;
    private C0128a toRunWhenAccessToAccountsIsGranted;
    private C0128a toRunWhenAccessToFileSystemIsDenied;
    private C0128a toRunWhenAccessToFileSystemIsGranted;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2712148977098294500L, "cm/aptoide/pt/permission/PermissionServiceActivity", 92);
        $jacocoData = probes;
        return probes;
    }

    public PermissionServiceActivity() {
        $jacocoInit()[0] = true;
    }

    static /* synthetic */ C0128a access$000(PermissionServiceActivity x0) {
        boolean[] $jacocoInit = $jacocoInit();
        C0128a aVar = x0.toRunWhenAccessToAccountsIsDenied;
        $jacocoInit[89] = true;
        return aVar;
    }

    static /* synthetic */ C0128a access$100(PermissionServiceActivity x0) {
        boolean[] $jacocoInit = $jacocoInit();
        C0128a aVar = x0.toRunWhenAccessToFileSystemIsDenied;
        $jacocoInit[90] = true;
        return aVar;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[91] = true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[1] = true;
        this.connectivityManager = (ConnectivityManager) getSystemService("connectivity");
        $jacocoInit[2] = true;
        this.sharedPreferences = ((AptoideApplication) getApplicationContext()).getDefaultSharedPreferences();
        $jacocoInit[3] = true;
        if (C6787r.m13829s()) {
            $jacocoInit[4] = true;
        } else {
            $jacocoInit[5] = true;
            C6787r.m13813c(getApplicationContext());
            $jacocoInit[6] = true;
        }
        $jacocoInit[7] = true;
    }

    @TargetApi(23)
    public void requestAccessToAccounts(C0128a toRunWhenAccessIsGranted, C0128a toRunWhenAccessIsDenied) {
        boolean[] $jacocoInit = $jacocoInit();
        requestAccessToAccounts(true, toRunWhenAccessIsGranted, toRunWhenAccessIsDenied);
        $jacocoInit[8] = true;
    }

    @TargetApi(23)
    public void requestAccessToAccounts(boolean forceShowRationale, C0128a toRunWhenAccessIsGranted, C0128a toRunWhenAccessIsDenied) {
        boolean[] $jacocoInit = $jacocoInit();
        String str = "android.permission.GET_ACCOUNTS";
        if (C0510b.m2565a((Context) this, str) != 0) {
            this.toRunWhenAccessToAccountsIsGranted = toRunWhenAccessIsGranted;
            this.toRunWhenAccessToAccountsIsDenied = toRunWhenAccessIsDenied;
            $jacocoInit[9] = true;
            if (forceShowRationale) {
                $jacocoInit[10] = true;
            } else if (C0453b.m2342a((Activity) this, str)) {
                $jacocoInit[11] = true;
            } else {
                C0453b.m2341a(this, new String[]{str}, 62);
                $jacocoInit[15] = true;
                Logger instance = Logger.getInstance();
                String str2 = TAG;
                $jacocoInit[16] = true;
                instance.mo2146v(str2, "requesting permission to access accounts");
                $jacocoInit[17] = true;
                return;
            }
            Logger instance2 = Logger.getInstance();
            String str3 = TAG;
            $jacocoInit[12] = true;
            instance2.mo2146v(str3, "showing rationale and requesting permission to access accounts");
            $jacocoInit[13] = true;
            showMessageOKCancel((int) C1375R.string.access_to_get_accounts_rationale, (SimpleSubscriber<EResponse>) new SimpleSubscriber<EResponse>(this) {
                private static transient /* synthetic */ boolean[] $jacocoData;
                final /* synthetic */ PermissionServiceActivity this$0;

                private static /* synthetic */ boolean[] $jacocoInit() {
                    boolean[] zArr = $jacocoData;
                    if (zArr != null) {
                        return zArr;
                    }
                    boolean[] probes = Offline.getProbes(-2289809103159106355L, "cm/aptoide/pt/permission/PermissionServiceActivity$1", 8);
                    $jacocoData = probes;
                    return probes;
                }

                {
                    boolean[] $jacocoInit = $jacocoInit();
                    this.this$0 = this$0;
                    $jacocoInit[0] = true;
                }

                public /* bridge */ /* synthetic */ void onNext(Object obj) {
                    boolean[] $jacocoInit = $jacocoInit();
                    onNext((EResponse) obj);
                    $jacocoInit[7] = true;
                }

                public void onNext(EResponse eResponse) {
                    boolean[] $jacocoInit = $jacocoInit();
                    super.onNext(eResponse);
                    if (eResponse != EResponse.YES) {
                        $jacocoInit[1] = true;
                        if (PermissionServiceActivity.access$000(this.this$0) == null) {
                            $jacocoInit[2] = true;
                        } else {
                            $jacocoInit[3] = true;
                            PermissionServiceActivity.access$000(this.this$0).call();
                            $jacocoInit[4] = true;
                        }
                        $jacocoInit[5] = true;
                        return;
                    }
                    C0453b.m2341a(this.this$0, new String[]{"android.permission.GET_ACCOUNTS"}, 62);
                    $jacocoInit[6] = true;
                }
            });
            $jacocoInit[14] = true;
            return;
        }
        Logger instance3 = Logger.getInstance();
        String str4 = TAG;
        $jacocoInit[18] = true;
        instance3.mo2146v(str4, "already has permission to access accounts");
        if (toRunWhenAccessIsGranted == null) {
            $jacocoInit[19] = true;
        } else {
            $jacocoInit[20] = true;
            toRunWhenAccessIsGranted.call();
            $jacocoInit[21] = true;
        }
        $jacocoInit[22] = true;
    }

    public void requestDownloadAccess(C0128a toRunWhenAccessIsGranted, final C0128a toRunWhenAccessIsDenied, boolean allowDownloadOnMobileData) {
        boolean[] $jacocoInit = $jacocoInit();
        if (allowDownloadOnMobileData) {
            $jacocoInit[23] = true;
        } else {
            String connectionType = SystemU.getConnectionType(this.connectivityManager);
            $jacocoInit[24] = true;
            if (!connectionType.equals("mobile")) {
                $jacocoInit[25] = true;
            } else if (ManagerPreferences.getDownloadsWifiOnly(this.sharedPreferences)) {
                $jacocoInit[26] = true;
            } else {
                $jacocoInit[27] = true;
                showMessageOKCancel((int) C1375R.string.general_downloads_dialog_only_wifi_message, (SimpleSubscriber<EResponse>) new SimpleSubscriber<EResponse>(this) {
                    private static transient /* synthetic */ boolean[] $jacocoData;
                    final /* synthetic */ PermissionServiceActivity this$0;

                    private static /* synthetic */ boolean[] $jacocoInit() {
                        boolean[] zArr = $jacocoData;
                        if (zArr != null) {
                            return zArr;
                        }
                        boolean[] probes = Offline.getProbes(839269424158563385L, "cm/aptoide/pt/permission/PermissionServiceActivity$2", 10);
                        $jacocoData = probes;
                        return probes;
                    }

                    {
                        boolean[] $jacocoInit = $jacocoInit();
                        this.this$0 = this$0;
                        $jacocoInit[0] = true;
                    }

                    public /* bridge */ /* synthetic */ void onNext(Object obj) {
                        boolean[] $jacocoInit = $jacocoInit();
                        onNext((EResponse) obj);
                        $jacocoInit[9] = true;
                    }

                    public void onNext(EResponse eResponse) {
                        boolean[] $jacocoInit = $jacocoInit();
                        super.onNext(eResponse);
                        if (eResponse == EResponse.YES) {
                            $jacocoInit[1] = true;
                            FragmentNavigator fragmentNavigator = this.this$0.getFragmentNavigator();
                            FragmentProvider fragmentProvider = AptoideApplication.getFragmentProvider();
                            $jacocoInit[2] = true;
                            Fragment newSettingsFragment = fragmentProvider.newSettingsFragment();
                            $jacocoInit[3] = true;
                            fragmentNavigator.navigateTo(newSettingsFragment, true);
                            $jacocoInit[4] = true;
                        } else {
                            C0128a aVar = toRunWhenAccessIsDenied;
                            if (aVar == null) {
                                $jacocoInit[5] = true;
                            } else {
                                $jacocoInit[6] = true;
                                aVar.call();
                                $jacocoInit[7] = true;
                            }
                        }
                        $jacocoInit[8] = true;
                    }
                });
                $jacocoInit[28] = true;
                return;
            }
        }
        if (toRunWhenAccessIsGranted == null) {
            $jacocoInit[29] = true;
        } else {
            $jacocoInit[30] = true;
            toRunWhenAccessIsGranted.call();
            $jacocoInit[31] = true;
        }
        $jacocoInit[32] = true;
    }

    public void requestAccessToCamera(C0128a toRunWhenAccessIsGranted, C0128a toRunWhenAccessIsDenied) {
        boolean[] $jacocoInit = $jacocoInit();
        String str = "android.permission.CAMERA";
        if (C0510b.m2565a((Context) this, str) != 0) {
            this.toRunWhenAccessToFileSystemIsGranted = toRunWhenAccessIsGranted;
            this.toRunWhenAccessToFileSystemIsDenied = toRunWhenAccessIsDenied;
            $jacocoInit[33] = true;
            if (C0453b.m2342a((Activity) this, str)) {
                $jacocoInit[34] = true;
                Logger instance = Logger.getInstance();
                String str2 = TAG;
                $jacocoInit[35] = true;
                instance.mo2146v(str2, "showing rationale and requesting permission to access camera");
                $jacocoInit[36] = true;
                showMessageOKCancel((int) C1375R.string.camera_access_permission_request_message, (SimpleSubscriber<EResponse>) new SimpleSubscriber<EResponse>(this) {
                    private static transient /* synthetic */ boolean[] $jacocoData;
                    final /* synthetic */ PermissionServiceActivity this$0;

                    private static /* synthetic */ boolean[] $jacocoInit() {
                        boolean[] zArr = $jacocoData;
                        if (zArr != null) {
                            return zArr;
                        }
                        boolean[] probes = Offline.getProbes(1180114118762329396L, "cm/aptoide/pt/permission/PermissionServiceActivity$3", 8);
                        $jacocoData = probes;
                        return probes;
                    }

                    {
                        boolean[] $jacocoInit = $jacocoInit();
                        this.this$0 = this$0;
                        $jacocoInit[0] = true;
                    }

                    public /* bridge */ /* synthetic */ void onNext(Object obj) {
                        boolean[] $jacocoInit = $jacocoInit();
                        onNext((EResponse) obj);
                        $jacocoInit[7] = true;
                    }

                    public void onNext(EResponse eResponse) {
                        boolean[] $jacocoInit = $jacocoInit();
                        super.onNext(eResponse);
                        if (eResponse != EResponse.YES) {
                            $jacocoInit[1] = true;
                            if (PermissionServiceActivity.access$100(this.this$0) == null) {
                                $jacocoInit[2] = true;
                            } else {
                                $jacocoInit[3] = true;
                                PermissionServiceActivity.access$100(this.this$0).call();
                                $jacocoInit[4] = true;
                            }
                            $jacocoInit[5] = true;
                            return;
                        }
                        C0453b.m2341a(this.this$0, new String[]{"android.permission.CAMERA"}, 101);
                        $jacocoInit[6] = true;
                    }
                });
                $jacocoInit[37] = true;
                return;
            }
            C0453b.m2341a(this, new String[]{str}, 101);
            $jacocoInit[38] = true;
            Logger instance2 = Logger.getInstance();
            String str3 = TAG;
            $jacocoInit[39] = true;
            instance2.mo2146v(str3, "requesting permission to access camera");
            $jacocoInit[40] = true;
            return;
        }
        Logger instance3 = Logger.getInstance();
        String str4 = TAG;
        $jacocoInit[41] = true;
        instance3.mo2146v(str4, "already has permission to access camera");
        if (toRunWhenAccessIsGranted == null) {
            $jacocoInit[42] = true;
        } else {
            $jacocoInit[43] = true;
            toRunWhenAccessIsGranted.call();
            $jacocoInit[44] = true;
        }
        $jacocoInit[45] = true;
    }

    @TargetApi(23)
    public void requestAccessToExternalFileSystem(C0128a toRunWhenAccessIsGranted, C0128a toRunWhenAccessIsDennied) {
        boolean[] $jacocoInit = $jacocoInit();
        requestAccessToExternalFileSystem(true, toRunWhenAccessIsGranted, toRunWhenAccessIsDennied);
        $jacocoInit[46] = true;
    }

    @TargetApi(23)
    public void requestAccessToExternalFileSystem(boolean forceShowRationale, C0128a toRunWhenAccessIsGranted, C0128a toRunWhenAccessIsDenied) {
        boolean[] $jacocoInit = $jacocoInit();
        requestAccessToExternalFileSystem(forceShowRationale, C1375R.string.storage_access_permission_request_message, toRunWhenAccessIsGranted, toRunWhenAccessIsDenied);
        $jacocoInit[47] = true;
    }

    @TargetApi(23)
    public void requestAccessToExternalFileSystem(boolean forceShowRationale, int rationaleMessage, C0128a toRunWhenAccessIsGranted, C0128a toRunWhenAccessIsDenied) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[48] = true;
        String str = "android.permission.WRITE_EXTERNAL_STORAGE";
        if (C0510b.m2565a((Context) this, str) != 0) {
            this.toRunWhenAccessToFileSystemIsGranted = toRunWhenAccessIsGranted;
            this.toRunWhenAccessToFileSystemIsDenied = toRunWhenAccessIsDenied;
            $jacocoInit[49] = true;
            if (forceShowRationale) {
                $jacocoInit[50] = true;
            } else if (C0453b.m2342a((Activity) this, str)) {
                $jacocoInit[51] = true;
            } else {
                C0453b.m2341a(this, new String[]{str, "android.permission.READ_EXTERNAL_STORAGE"}, 61);
                $jacocoInit[55] = true;
                Logger instance = Logger.getInstance();
                String str2 = TAG;
                $jacocoInit[56] = true;
                instance.mo2146v(str2, "requesting permission to access external storage");
                $jacocoInit[57] = true;
                return;
            }
            Logger instance2 = Logger.getInstance();
            String str3 = TAG;
            $jacocoInit[52] = true;
            instance2.mo2146v(str3, "showing rationale and requesting permission to access external storage");
            $jacocoInit[53] = true;
            showMessageOKCancel(rationaleMessage, (SimpleSubscriber<EResponse>) new SimpleSubscriber<EResponse>(this) {
                private static transient /* synthetic */ boolean[] $jacocoData;
                final /* synthetic */ PermissionServiceActivity this$0;

                private static /* synthetic */ boolean[] $jacocoInit() {
                    boolean[] zArr = $jacocoData;
                    if (zArr != null) {
                        return zArr;
                    }
                    boolean[] probes = Offline.getProbes(3188550186728626913L, "cm/aptoide/pt/permission/PermissionServiceActivity$4", 8);
                    $jacocoData = probes;
                    return probes;
                }

                {
                    boolean[] $jacocoInit = $jacocoInit();
                    this.this$0 = this$0;
                    $jacocoInit[0] = true;
                }

                public /* bridge */ /* synthetic */ void onNext(Object obj) {
                    boolean[] $jacocoInit = $jacocoInit();
                    onNext((EResponse) obj);
                    $jacocoInit[7] = true;
                }

                public void onNext(EResponse eResponse) {
                    boolean[] $jacocoInit = $jacocoInit();
                    super.onNext(eResponse);
                    if (eResponse != EResponse.YES) {
                        $jacocoInit[1] = true;
                        if (PermissionServiceActivity.access$100(this.this$0) == null) {
                            $jacocoInit[2] = true;
                        } else {
                            $jacocoInit[3] = true;
                            PermissionServiceActivity.access$100(this.this$0).call();
                            $jacocoInit[4] = true;
                        }
                        $jacocoInit[5] = true;
                        return;
                    }
                    C0453b.m2341a(this.this$0, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 61);
                    $jacocoInit[6] = true;
                }
            });
            $jacocoInit[54] = true;
            return;
        }
        Logger instance3 = Logger.getInstance();
        String str4 = TAG;
        $jacocoInit[58] = true;
        instance3.mo2146v(str4, "already has permission to access external storage");
        if (toRunWhenAccessIsGranted == null) {
            $jacocoInit[59] = true;
        } else {
            $jacocoInit[60] = true;
            toRunWhenAccessIsGranted.call();
            $jacocoInit[61] = true;
        }
        $jacocoInit[62] = true;
    }

    private void showMessageOKCancel(int messageId, SimpleSubscriber<EResponse> subscriber) {
        boolean[] $jacocoInit = $jacocoInit();
        showMessageOKCancel(getString(messageId), subscriber);
        $jacocoInit[63] = true;
    }

    private void showMessageOKCancel(String message, SimpleSubscriber<EResponse> subscriber) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S createGenericOkCancelMessage = GenericDialogs.createGenericOkCancelMessage(this, "", message);
        $jacocoInit[64] = true;
        createGenericOkCancelMessage.mo3627a((C14980ia<? super T>) subscriber);
        $jacocoInit[65] = true;
    }

    @TargetApi(23)
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        boolean[] $jacocoInit = $jacocoInit();
        if (grantResults.length != 0) {
            $jacocoInit[66] = true;
        } else {
            $jacocoInit[67] = true;
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            $jacocoInit[68] = true;
        }
        if (requestCode != 61) {
            if (requestCode != 62) {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                $jacocoInit[87] = true;
            } else if (grantResults[0] == 0) {
                $jacocoInit[78] = true;
                Logger instance = Logger.getInstance();
                String str = TAG;
                $jacocoInit[79] = true;
                instance.mo2146v(str, "access to get accounts was granted");
                C0128a aVar = this.toRunWhenAccessToAccountsIsGranted;
                if (aVar == null) {
                    $jacocoInit[80] = true;
                } else {
                    $jacocoInit[81] = true;
                    aVar.call();
                    $jacocoInit[82] = true;
                }
            } else {
                C0128a aVar2 = this.toRunWhenAccessToAccountsIsDenied;
                if (aVar2 == null) {
                    $jacocoInit[83] = true;
                } else {
                    $jacocoInit[84] = true;
                    aVar2.call();
                    $jacocoInit[85] = true;
                }
                ShowMessage.asSnack(findViewById(16908290), "access to get accounts was denied");
                $jacocoInit[86] = true;
            }
        } else if (grantResults[0] == 0) {
            $jacocoInit[69] = true;
            Logger instance2 = Logger.getInstance();
            String str2 = TAG;
            $jacocoInit[70] = true;
            instance2.mo2146v(str2, "access to read and write to external storage was granted");
            C0128a aVar3 = this.toRunWhenAccessToFileSystemIsGranted;
            if (aVar3 == null) {
                $jacocoInit[71] = true;
            } else {
                $jacocoInit[72] = true;
                aVar3.call();
                $jacocoInit[73] = true;
            }
        } else {
            C0128a aVar4 = this.toRunWhenAccessToFileSystemIsDenied;
            if (aVar4 == null) {
                $jacocoInit[74] = true;
            } else {
                $jacocoInit[75] = true;
                aVar4.call();
                $jacocoInit[76] = true;
            }
            ShowMessage.asSnack(findViewById(16908290), "access to read and write to external storage was denied");
            $jacocoInit[77] = true;
        }
        $jacocoInit[88] = true;
    }
}
