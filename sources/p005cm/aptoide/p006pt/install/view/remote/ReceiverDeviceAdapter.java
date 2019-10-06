package p005cm.aptoide.p006pt.install.view.remote;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.install.remote.ReceiverDevice;

/* renamed from: cm.aptoide.pt.install.view.remote.ReceiverDeviceAdapter */
public class ReceiverDeviceAdapter extends ArrayAdapter<ReceiverDevice> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private Context context;
    private List<ReceiverDevice> devices;
    private int resource;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8737093127284875993L, "cm/aptoide/pt/install/view/remote/ReceiverDeviceAdapter", 23);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void add(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        add((ReceiverDevice) obj);
        $jacocoInit[22] = true;
    }

    public ReceiverDeviceAdapter(Context context2, int resource2, List<ReceiverDevice> devices2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(context2, resource2, devices2);
        this.context = context2;
        this.resource = resource2;
        this.devices = devices2;
        $jacocoInit[0] = true;
    }

    public void add(ReceiverDevice device) {
        boolean[] $jacocoInit = $jacocoInit();
        boolean replaced = false;
        $jacocoInit[1] = true;
        int i = 0;
        $jacocoInit[2] = true;
        while (i < this.devices.size()) {
            $jacocoInit[3] = true;
            ReceiverDevice dvc = (ReceiverDevice) this.devices.get(i);
            $jacocoInit[4] = true;
            if (!dvc.isSameDevice(device)) {
                $jacocoInit[5] = true;
            } else {
                $jacocoInit[6] = true;
                this.devices.set(i, device);
                replaced = true;
                $jacocoInit[7] = true;
                notifyDataSetChanged();
                $jacocoInit[8] = true;
            }
            i++;
            $jacocoInit[9] = true;
        }
        if (replaced) {
            $jacocoInit[10] = true;
        } else {
            $jacocoInit[11] = true;
            super.add(device);
            $jacocoInit[12] = true;
        }
        $jacocoInit[13] = true;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        boolean[] $jacocoInit = $jacocoInit();
        ReceiverDevice app = (ReceiverDevice) getItem(position);
        if (convertView != null) {
            $jacocoInit[14] = true;
        } else {
            $jacocoInit[15] = true;
            LayoutInflater from = LayoutInflater.from(getContext());
            $jacocoInit[16] = true;
            convertView = from.inflate(C1375R.layout.row_remote_install, parent, false);
            $jacocoInit[17] = true;
        }
        TextView deviceName = (TextView) convertView.findViewById(C1375R.C1376id.deviceNameText);
        $jacocoInit[18] = true;
        if (app == null) {
            $jacocoInit[19] = true;
        } else {
            deviceName.setText(app.getDeviceName());
            $jacocoInit[20] = true;
        }
        $jacocoInit[21] = true;
        return convertView;
    }
}
