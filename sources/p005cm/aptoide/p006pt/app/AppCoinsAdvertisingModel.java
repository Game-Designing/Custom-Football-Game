package p005cm.aptoide.p006pt.app;

import kotlin.p376c.p378b.C14281f;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.app.AppCoinsAdvertisingModel */
/* compiled from: AppCoinsAdvertisingModel.kt */
public final class AppCoinsAdvertisingModel {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final boolean hasAdvertising;
    private final String reward;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3300489621114459697L, "cm/aptoide/pt/app/AppCoinsAdvertisingModel", 34);
        $jacocoData = probes;
        return probes;
    }

    public AppCoinsAdvertisingModel() {
        boolean[] $jacocoInit = $jacocoInit();
        this(null, false, 3, null);
        $jacocoInit[10] = true;
    }

    public static /* synthetic */ AppCoinsAdvertisingModel copy$default(AppCoinsAdvertisingModel appCoinsAdvertisingModel, String str, boolean z, int i, Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        if ((i & 1) == 0) {
            $jacocoInit[14] = true;
        } else {
            str = appCoinsAdvertisingModel.reward;
            $jacocoInit[15] = true;
        }
        if ((i & 2) == 0) {
            $jacocoInit[16] = true;
        } else {
            z = appCoinsAdvertisingModel.hasAdvertising;
            $jacocoInit[17] = true;
        }
        AppCoinsAdvertisingModel copy = appCoinsAdvertisingModel.copy(str, z);
        $jacocoInit[18] = true;
        return copy;
    }

    public final String component1() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.reward;
        $jacocoInit[11] = true;
        return str;
    }

    public final boolean component2() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.hasAdvertising;
        $jacocoInit[12] = true;
        return z;
    }

    public final AppCoinsAdvertisingModel copy(String str, boolean z) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(str, "reward");
        AppCoinsAdvertisingModel appCoinsAdvertisingModel = new AppCoinsAdvertisingModel(str, z);
        $jacocoInit[13] = true;
        return appCoinsAdvertisingModel;
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this == obj) {
            $jacocoInit[25] = true;
        } else {
            if (!(obj instanceof AppCoinsAdvertisingModel)) {
                $jacocoInit[26] = true;
            } else {
                AppCoinsAdvertisingModel appCoinsAdvertisingModel = (AppCoinsAdvertisingModel) obj;
                if (!C14281f.m45915a((Object) this.reward, (Object) appCoinsAdvertisingModel.reward)) {
                    $jacocoInit[27] = true;
                } else {
                    if (this.hasAdvertising == appCoinsAdvertisingModel.hasAdvertising) {
                        $jacocoInit[28] = true;
                        z = true;
                    } else {
                        $jacocoInit[29] = true;
                        z = false;
                    }
                    if (!z) {
                        $jacocoInit[30] = true;
                    } else {
                        $jacocoInit[31] = true;
                    }
                }
            }
            $jacocoInit[33] = true;
            return false;
        }
        $jacocoInit[32] = true;
        return true;
    }

    public int hashCode() {
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.reward;
        if (str != null) {
            i = str.hashCode();
            $jacocoInit[20] = true;
        } else {
            i = 0;
            $jacocoInit[21] = true;
        }
        int i2 = i * 31;
        boolean z = this.hasAdvertising;
        if (!z) {
            $jacocoInit[22] = true;
        } else {
            $jacocoInit[23] = true;
            z = true;
        }
        int i3 = i2 + (z ? 1 : 0);
        $jacocoInit[24] = true;
        return i3;
    }

    public String toString() {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append("AppCoinsAdvertisingModel(reward=");
        sb.append(this.reward);
        sb.append(", hasAdvertising=");
        sb.append(this.hasAdvertising);
        sb.append(")");
        String sb2 = sb.toString();
        $jacocoInit[19] = true;
        return sb2;
    }

    public AppCoinsAdvertisingModel(String reward2, boolean hasAdvertising2) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(reward2, "reward");
        $jacocoInit[2] = true;
        this.reward = reward2;
        this.hasAdvertising = hasAdvertising2;
        $jacocoInit[3] = true;
    }

    public /* synthetic */ AppCoinsAdvertisingModel(String str, boolean z, int i, C14280e eVar) {
        boolean[] $jacocoInit = $jacocoInit();
        if ((i & 1) == 0) {
            $jacocoInit[4] = true;
        } else {
            $jacocoInit[5] = true;
            str = "-1.0";
        }
        if ((i & 2) == 0) {
            $jacocoInit[6] = true;
        } else {
            $jacocoInit[7] = true;
            z = false;
            $jacocoInit[8] = true;
        }
        this(str, z);
        $jacocoInit[9] = true;
    }

    public final String getReward() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.reward;
        $jacocoInit[0] = true;
        return str;
    }

    public final boolean getHasAdvertising() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.hasAdvertising;
        $jacocoInit[1] = true;
        return z;
    }
}
