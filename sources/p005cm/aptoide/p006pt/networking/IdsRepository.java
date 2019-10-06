package p005cm.aptoide.p006pt.networking;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.security.SecureRandom;
import java.util.UUID;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.dataprovider.ads.AdNetworkUtils;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.utils.AptoideUtils.ThreadU;

/* renamed from: cm.aptoide.pt.networking.IdsRepository */
public class IdsRepository {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String ADVERTISING_ID_CLIENT = "advertisingIdClient";
    private static final String ANDROID_ID_CLIENT = "androidId";
    private static final String APTOIDE_CLIENT_UUID = "aptoide_client_uuid";
    private static final String GOOGLE_ADVERTISING_ID_CLIENT = "googleAdvertisingId";
    private static final String GOOGLE_ADVERTISING_ID_CLIENT_SET = "googleAdvertisingIdSet";
    private static final String TAG = IdsRepository.class.getSimpleName();
    private final String androidId;
    private final Context context;
    private final SharedPreferences sharedPreferences;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1523583857527698609L, "cm/aptoide/pt/networking/IdsRepository", 67);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[66] = true;
    }

    public IdsRepository(SharedPreferences sharedPreferences2, Context context2, String androidId2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.sharedPreferences = sharedPreferences2;
        this.context = context2;
        this.androidId = androidId2;
        $jacocoInit[0] = true;
    }

    public synchronized String getUniqueIdentifier() {
        boolean[] $jacocoInit = $jacocoInit();
        String aptoideId = this.sharedPreferences.getString(APTOIDE_CLIENT_UUID, null);
        $jacocoInit[1] = true;
        if (!TextUtils.isEmpty(aptoideId)) {
            $jacocoInit[2] = true;
            Logger instance = Logger.getInstance();
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("getUniqueIdentifier: in sharedPreferences: ");
            sb.append(aptoideId);
            String sb2 = sb.toString();
            $jacocoInit[3] = true;
            instance.mo2146v(str, sb2);
            $jacocoInit[4] = true;
            return aptoideId;
        }
        String aptoideId2 = getGoogleAdvertisingId();
        $jacocoInit[5] = true;
        if (TextUtils.isEmpty(aptoideId2)) {
            $jacocoInit[6] = true;
            aptoideId2 = getAndroidId();
            $jacocoInit[7] = true;
            if (TextUtils.isEmpty(aptoideId2)) {
                $jacocoInit[8] = true;
            } else {
                $jacocoInit[9] = true;
                Logger instance2 = Logger.getInstance();
                String str2 = TAG;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("getUniqueIdentifier: getAndroidId: ");
                sb3.append(aptoideId2);
                String sb4 = sb3.toString();
                $jacocoInit[10] = true;
                instance2.mo2146v(str2, sb4);
                $jacocoInit[11] = true;
            }
        } else {
            Logger instance3 = Logger.getInstance();
            String str3 = TAG;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getUniqueIdentifier: getGoogleAdvertisingId: ");
            sb5.append(aptoideId2);
            String sb6 = sb5.toString();
            $jacocoInit[12] = true;
            instance3.mo2146v(str3, sb6);
            $jacocoInit[13] = true;
        }
        if (!TextUtils.isEmpty(aptoideId2)) {
            $jacocoInit[14] = true;
        } else {
            $jacocoInit[15] = true;
            UUID randomUUID = UUID.randomUUID();
            $jacocoInit[16] = true;
            aptoideId2 = randomUUID.toString();
            $jacocoInit[17] = true;
            Logger instance4 = Logger.getInstance();
            String str4 = TAG;
            StringBuilder sb7 = new StringBuilder();
            sb7.append("getUniqueIdentifier: randomUUID: ");
            sb7.append(aptoideId2);
            String sb8 = sb7.toString();
            $jacocoInit[18] = true;
            instance4.mo2146v(str4, sb8);
            $jacocoInit[19] = true;
        }
        Editor edit = this.sharedPreferences.edit();
        String str5 = APTOIDE_CLIENT_UUID;
        $jacocoInit[20] = true;
        Editor putString = edit.putString(str5, aptoideId2);
        $jacocoInit[21] = true;
        putString.apply();
        $jacocoInit[22] = true;
        return aptoideId2;
    }

    public synchronized String getGoogleAdvertisingId() {
        boolean[] $jacocoInit = $jacocoInit();
        String googleAdvertisingId = this.sharedPreferences.getString(GOOGLE_ADVERTISING_ID_CLIENT, null);
        $jacocoInit[23] = true;
        if (!TextUtils.isEmpty(googleAdvertisingId)) {
            $jacocoInit[24] = true;
            return googleAdvertisingId;
        } else if (!ThreadU.isUiThread()) {
            if (!AdNetworkUtils.isGooglePlayServicesAvailable(this.context)) {
                $jacocoInit[27] = true;
            } else {
                try {
                    $jacocoInit[28] = true;
                    Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.context);
                    $jacocoInit[29] = true;
                    googleAdvertisingId = advertisingIdInfo.getId();
                    $jacocoInit[30] = true;
                } catch (Exception e) {
                    $jacocoInit[31] = true;
                    CrashReport instance = CrashReport.getInstance();
                    $jacocoInit[32] = true;
                    instance.log(e);
                    $jacocoInit[33] = true;
                }
            }
            Editor edit = this.sharedPreferences.edit();
            String str = GOOGLE_ADVERTISING_ID_CLIENT;
            $jacocoInit[34] = true;
            Editor putString = edit.putString(str, googleAdvertisingId);
            $jacocoInit[35] = true;
            putString.apply();
            $jacocoInit[36] = true;
            Editor edit2 = this.sharedPreferences.edit();
            String str2 = GOOGLE_ADVERTISING_ID_CLIENT_SET;
            $jacocoInit[37] = true;
            Editor putBoolean = edit2.putBoolean(str2, true);
            $jacocoInit[38] = true;
            putBoolean.apply();
            $jacocoInit[39] = true;
            return googleAdvertisingId;
        } else {
            $jacocoInit[25] = true;
            IllegalStateException illegalStateException = new IllegalStateException("You cannot run this method from the main thread");
            $jacocoInit[26] = true;
            throw illegalStateException;
        }
    }

    public synchronized String getAdvertisingId() {
        boolean[] $jacocoInit = $jacocoInit();
        String advertisingId = this.sharedPreferences.getString(ADVERTISING_ID_CLIENT, null);
        $jacocoInit[40] = true;
        if (!TextUtils.isEmpty(advertisingId)) {
            $jacocoInit[41] = true;
            return advertisingId;
        }
        String advertisingId2 = getGoogleAdvertisingId();
        $jacocoInit[42] = true;
        if (!TextUtils.isEmpty(advertisingId2)) {
            $jacocoInit[43] = true;
        } else {
            $jacocoInit[44] = true;
            advertisingId2 = generateRandomAdvertisingId();
            $jacocoInit[45] = true;
        }
        Editor edit = this.sharedPreferences.edit();
        String str = ADVERTISING_ID_CLIENT;
        $jacocoInit[46] = true;
        Editor putString = edit.putString(str, advertisingId2);
        $jacocoInit[47] = true;
        putString.apply();
        $jacocoInit[48] = true;
        return advertisingId2;
    }

    public synchronized String getAndroidId() {
        boolean[] $jacocoInit = $jacocoInit();
        String androidId2 = this.sharedPreferences.getString(ANDROID_ID_CLIENT, null);
        $jacocoInit[49] = true;
        if (!TextUtils.isEmpty(androidId2)) {
            $jacocoInit[50] = true;
            return androidId2;
        }
        String androidId3 = this.androidId;
        $jacocoInit[51] = true;
        if (this.sharedPreferences.getString(ANDROID_ID_CLIENT, null) == null) {
            Editor edit = this.sharedPreferences.edit();
            String str = ANDROID_ID_CLIENT;
            $jacocoInit[54] = true;
            Editor putString = edit.putString(str, androidId3);
            $jacocoInit[55] = true;
            putString.apply();
            $jacocoInit[56] = true;
            return androidId3;
        }
        $jacocoInit[52] = true;
        RuntimeException runtimeException = new RuntimeException("Android ID already set!");
        $jacocoInit[53] = true;
        throw runtimeException;
    }

    private String generateRandomAdvertisingId() {
        boolean[] $jacocoInit = $jacocoInit();
        byte[] data = new byte[16];
        String androidId2 = this.androidId;
        if (androidId2 != null) {
            $jacocoInit[57] = true;
        } else {
            $jacocoInit[58] = true;
            UUID randomUUID = UUID.randomUUID();
            $jacocoInit[59] = true;
            androidId2 = randomUUID.toString();
            $jacocoInit[60] = true;
        }
        SecureRandom secureRandom = new SecureRandom();
        $jacocoInit[61] = true;
        secureRandom.setSeed((long) androidId2.hashCode());
        $jacocoInit[62] = true;
        secureRandom.nextBytes(data);
        $jacocoInit[63] = true;
        UUID nameUUIDFromBytes = UUID.nameUUIDFromBytes(data);
        $jacocoInit[64] = true;
        String uuid = nameUUIDFromBytes.toString();
        $jacocoInit[65] = true;
        return uuid;
    }
}
