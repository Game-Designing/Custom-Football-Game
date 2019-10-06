package p005cm.aptoide.p006pt.dataprovider;

import android.telephony.TelephonyManager;

/* renamed from: cm.aptoide.pt.dataprovider.NetworkOperatorManager */
public class NetworkOperatorManager {
    private final TelephonyManager telephonyManager;

    public NetworkOperatorManager(TelephonyManager telephonyManager2) {
        this.telephonyManager = telephonyManager2;
    }

    public String getMobileCountryCode() {
        String networkOperator = this.telephonyManager.getNetworkOperator();
        if (networkOperator == null) {
            return "";
        }
        return networkOperator.substring(0, codePortionLength(networkOperator));
    }

    private int codePortionLength(String networkOperator) {
        return Math.min(3, networkOperator.length());
    }

    public boolean isSimStateReady() {
        return this.telephonyManager.getSimState() == 5;
    }

    public String getMobileNetworkCode() {
        String networkOperator = this.telephonyManager.getNetworkOperator();
        if (networkOperator == null) {
            return "";
        }
        return networkOperator.substring(codePortionLength(networkOperator));
    }

    public String getSimCountryISO() {
        return this.telephonyManager.getSimCountryIso();
    }
}
