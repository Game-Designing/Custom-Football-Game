package p005cm.aptoide.p006pt.install.view.remote;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.install.remote.ReceiverDevice;
import p005cm.aptoide.p006pt.install.remote.RemoteInstallationSenderListener;
import p005cm.aptoide.p006pt.install.remote.RemoteInstallationSenderManager;
import p005cm.aptoide.p006pt.view.fragment.BaseDialogFragment;

/* renamed from: cm.aptoide.pt.install.view.remote.RemoteInstallDialog */
public class RemoteInstallDialog extends BaseDialogFragment implements RemoteInstallationSenderListener {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String APP_ID_TAG = "appid";
    private ReceiverDeviceAdapter adapter;
    private String app;
    private TextView aptoideTVInstalledText;
    private LinearLayout errorLayout;
    private TextView errorText;
    private LinearLayout listLayout;
    private ListView listView;
    private ProgressBar pBar;
    private ImageButton refreshBtn;
    private RemoteInstallationSenderManager sManager;

    /* renamed from: cm.aptoide.pt.install.view.remote.RemoteInstallDialog$Error */
    private enum Error {
        NO_NETWORK,
        NO_DEVICES_FOUND;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8423584982840764541L, "cm/aptoide/pt/install/view/remote/RemoteInstallDialog", 81);
        $jacocoData = probes;
        return probes;
    }

    public RemoteInstallDialog() {
        $jacocoInit()[0] = true;
    }

    static /* synthetic */ RemoteInstallationSenderManager access$000(RemoteInstallDialog x0) {
        boolean[] $jacocoInit = $jacocoInit();
        RemoteInstallationSenderManager remoteInstallationSenderManager = x0.sManager;
        $jacocoInit[79] = true;
        return remoteInstallationSenderManager;
    }

    static /* synthetic */ String access$100(RemoteInstallDialog x0) {
        boolean[] $jacocoInit = $jacocoInit();
        String str = x0.app;
        $jacocoInit[80] = true;
        return str;
    }

    public static RemoteInstallDialog newInstance(long appid) {
        boolean[] $jacocoInit = $jacocoInit();
        RemoteInstallDialog frag = new RemoteInstallDialog();
        $jacocoInit[1] = true;
        Bundle args = new Bundle();
        $jacocoInit[2] = true;
        args.putLong(APP_ID_TAG, appid);
        $jacocoInit[3] = true;
        frag.setArguments(args);
        $jacocoInit[4] = true;
        return frag;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[5] = true;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(getArguments().getLong(APP_ID_TAG));
        this.app = sb.toString();
        $jacocoInit[6] = true;
        this.sManager = new RemoteInstallationSenderManager(getActivity());
        $jacocoInit[7] = true;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        $jacocoInit[8] = true;
        dialog.requestWindowFeature(1);
        $jacocoInit[9] = true;
        return dialog;
    }

    public void onDismiss(DialogInterface dialog) {
        boolean[] $jacocoInit = $jacocoInit();
        this.sManager.stopDiscoveringAptoideTVServices();
        $jacocoInit[10] = true;
        super.onDismiss(dialog);
        $jacocoInit[11] = true;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        if (getDialog() == null) {
            $jacocoInit[12] = true;
        } else {
            $jacocoInit[13] = true;
            if (getDialog().getWindow() == null) {
                $jacocoInit[14] = true;
            } else {
                $jacocoInit[15] = true;
                Window window = getDialog().getWindow();
                $jacocoInit[16] = true;
                if (window.getDecorView() == null) {
                    $jacocoInit[17] = true;
                } else {
                    $jacocoInit[18] = true;
                    Window window2 = getDialog().getWindow();
                    $jacocoInit[19] = true;
                    View decorView = window2.getDecorView();
                    $jacocoInit[20] = true;
                    Drawable background = decorView.getBackground();
                    $jacocoInit[21] = true;
                    background.setAlpha(0);
                    $jacocoInit[22] = true;
                }
            }
        }
        final View v = inflater.inflate(C1375R.layout.dialog_remote_install, container, false);
        $jacocoInit[23] = true;
        this.pBar = (ProgressBar) v.findViewById(C1375R.C1376id.progressBar);
        $jacocoInit[24] = true;
        this.errorLayout = (LinearLayout) v.findViewById(C1375R.C1376id.errorLayout);
        $jacocoInit[25] = true;
        this.errorText = (TextView) v.findViewById(C1375R.C1376id.no_connection_text);
        $jacocoInit[26] = true;
        this.listLayout = (LinearLayout) v.findViewById(C1375R.C1376id.listLayout);
        $jacocoInit[27] = true;
        Button helpBtn = (Button) v.findViewById(C1375R.C1376id.help_btn);
        $jacocoInit[28] = true;
        this.aptoideTVInstalledText = (TextView) v.findViewById(C1375R.C1376id.aptoidetv_installed_text);
        $jacocoInit[29] = true;
        this.refreshBtn = (ImageButton) v.findViewById(C1375R.C1376id.refreshButton);
        $jacocoInit[30] = true;
        helpBtn.setOnClickListener(new OnClickListener(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ RemoteInstallDialog this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-3570835411543270140L, "cm/aptoide/pt/install/view/remote/RemoteInstallDialog$1", 5);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public void onClick(View view) {
                boolean[] $jacocoInit = $jacocoInit();
                RemoteInstallDialog remoteInstallDialog = this.this$0;
                $jacocoInit[1] = true;
                Intent browserIntent = new Intent("android.intent.action.VIEW", Uri.parse(remoteInstallDialog.getContext().getString(C1375R.string.remote_install_help_url)));
                $jacocoInit[2] = true;
                browserIntent.setFlags(268435456);
                $jacocoInit[3] = true;
                this.this$0.startActivity(browserIntent);
                $jacocoInit[4] = true;
            }
        });
        $jacocoInit[31] = true;
        this.refreshBtn.setOnClickListener(new OnClickListener(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ RemoteInstallDialog this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-8269761829609802263L, "cm/aptoide/pt/install/view/remote/RemoteInstallDialog$2", 2);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public void onClick(View view) {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0.onRetryClick(v);
                $jacocoInit[1] = true;
            }
        });
        if (this.adapter != null) {
            $jacocoInit[32] = true;
        } else {
            $jacocoInit[33] = true;
            this.listView = (ListView) v.findViewById(C1375R.C1376id.listView);
            $jacocoInit[34] = true;
            this.listView.setEmptyView(v.findViewById(C1375R.C1376id.emptyListLayout));
            $jacocoInit[35] = true;
            this.listView.setOnItemClickListener(new OnItemClickListener(this) {
                private static transient /* synthetic */ boolean[] $jacocoData;
                final /* synthetic */ RemoteInstallDialog this$0;

                private static /* synthetic */ boolean[] $jacocoInit() {
                    boolean[] zArr = $jacocoData;
                    if (zArr != null) {
                        return zArr;
                    }
                    boolean[] probes = Offline.getProbes(1882898028744814160L, "cm/aptoide/pt/install/view/remote/RemoteInstallDialog$3", 5);
                    $jacocoData = probes;
                    return probes;
                }

                {
                    boolean[] $jacocoInit = $jacocoInit();
                    this.this$0 = this$0;
                    $jacocoInit[0] = true;
                }

                public void onItemClick(AdapterView<?> adapter, View v, int position, long arg3) {
                    boolean[] $jacocoInit = $jacocoInit();
                    ReceiverDevice device = (ReceiverDevice) adapter.getItemAtPosition(position);
                    $jacocoInit[1] = true;
                    if (RemoteInstallDialog.access$000(this.this$0) == null) {
                        $jacocoInit[2] = true;
                    } else {
                        RemoteInstallDialog.access$000(this.this$0).sendAppId(device, RemoteInstallDialog.access$100(this.this$0));
                        $jacocoInit[3] = true;
                    }
                    $jacocoInit[4] = true;
                }
            });
            $jacocoInit[36] = true;
            populateDeviceList();
            $jacocoInit[37] = true;
            onRetryClick(container);
            $jacocoInit[38] = true;
        }
        $jacocoInit[39] = true;
        return v;
    }

    public void onRetryClick(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        populateDeviceList();
        $jacocoInit[40] = true;
        this.sManager.discoverAptoideTVServices(this);
        $jacocoInit[41] = true;
    }

    private void populateDeviceList() {
        boolean[] $jacocoInit = $jacocoInit();
        List<ReceiverDevice> devices = new ArrayList<>();
        $jacocoInit[42] = true;
        this.adapter = new ReceiverDeviceAdapter(getActivity().getApplicationContext(), C1375R.layout.row_remote_install, devices);
        $jacocoInit[43] = true;
        this.listView.setAdapter(this.adapter);
        $jacocoInit[44] = true;
    }

    public void onDiscoveryStarted() {
        boolean[] $jacocoInit = $jacocoInit();
        this.refreshBtn.setVisibility(8);
        $jacocoInit[45] = true;
        this.pBar.setVisibility(0);
        $jacocoInit[46] = true;
        this.errorLayout.setVisibility(8);
        $jacocoInit[47] = true;
        this.listLayout.setVisibility(0);
        $jacocoInit[48] = true;
    }

    public void onDiscoveryStopped() {
        boolean[] $jacocoInit = $jacocoInit();
        this.pBar.setVisibility(8);
        $jacocoInit[49] = true;
        this.refreshBtn.setVisibility(0);
        $jacocoInit[50] = true;
        if (this.adapter.getCount() != 0) {
            $jacocoInit[51] = true;
        } else {
            $jacocoInit[52] = true;
            showErrorLayout(Error.NO_DEVICES_FOUND);
            $jacocoInit[53] = true;
        }
        $jacocoInit[54] = true;
    }

    public void onAptoideTVServiceLost(ReceiverDevice device) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapter.remove(device);
        $jacocoInit[55] = true;
    }

    public void onAptoideTVServiceFound(ReceiverDevice device) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapter.add(device);
        $jacocoInit[56] = true;
    }

    public void onAppSendSuccess() {
        boolean[] $jacocoInit = $jacocoInit();
        if (!isAdded()) {
            $jacocoInit[57] = true;
        } else {
            $jacocoInit[58] = true;
            Toast makeText = Toast.makeText(getContext(), C1375R.string.remote_install_success, 1);
            $jacocoInit[59] = true;
            makeText.show();
            $jacocoInit[60] = true;
            dismiss();
            $jacocoInit[61] = true;
        }
        $jacocoInit[62] = true;
    }

    public void onAppSendUnsuccess() {
        boolean[] $jacocoInit = $jacocoInit();
        if (!isAdded()) {
            $jacocoInit[63] = true;
        } else {
            $jacocoInit[64] = true;
            Toast makeText = Toast.makeText(getContext(), C1375R.string.remote_install_fail, 1);
            $jacocoInit[65] = true;
            makeText.show();
            $jacocoInit[66] = true;
            dismiss();
            $jacocoInit[67] = true;
        }
        $jacocoInit[68] = true;
    }

    public void onNoNetworkAccess() {
        boolean[] $jacocoInit = $jacocoInit();
        showErrorLayout(Error.NO_NETWORK);
        $jacocoInit[69] = true;
    }

    private void showErrorLayout(Error error) {
        boolean[] $jacocoInit = $jacocoInit();
        this.pBar.setVisibility(8);
        if (error == Error.NO_DEVICES_FOUND) {
            $jacocoInit[70] = true;
            this.aptoideTVInstalledText.setText(C1375R.string.remote_install_notinstallated);
            $jacocoInit[71] = true;
            this.errorText.setText(C1375R.string.remote_install_nodevices);
            $jacocoInit[72] = true;
        } else if (error != Error.NO_NETWORK) {
            $jacocoInit[73] = true;
        } else {
            $jacocoInit[74] = true;
            this.aptoideTVInstalledText.setText(C1375R.string.remote_install_nowifi_tip);
            $jacocoInit[75] = true;
            this.errorText.setText(C1375R.string.remote_install_nowifi);
            $jacocoInit[76] = true;
        }
        this.listLayout.setVisibility(8);
        $jacocoInit[77] = true;
        this.errorLayout.setVisibility(0);
        $jacocoInit[78] = true;
    }
}
