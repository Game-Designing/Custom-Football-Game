package p005cm.aptoide.p006pt.database.accessors;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.unity3d.services.purchasing.core.TransactionDetailsUtilities;
import java.util.Iterator;
import p005cm.aptoide.p006pt.database.realm.Installed;
import p005cm.aptoide.p006pt.database.realm.Notification;
import p005cm.aptoide.p006pt.database.realm.Store;
import p005cm.aptoide.p006pt.database.realm.StoredMinimalAd;
import p005cm.aptoide.p006pt.database.realm.Update;
import p005cm.aptoide.p006pt.deprecated.tables.Repo;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.preferences.managed.ManagedKeys;
import p024io.realm.C14020X;
import p024io.realm.C14042ba;
import p024io.realm.C14042ba.C14045c;
import p024io.realm.C14054ea;
import p024io.realm.C14061h;
import p024io.realm.C14065j;
import p024io.realm.C14073m;

/* renamed from: cm.aptoide.pt.database.accessors.RealmToRealmDatabaseMigration */
public class RealmToRealmDatabaseMigration implements C14020X {
    private static final String TAG = RealmToRealmDatabaseMigration.class.getName();
    private final Context context;

    public RealmToRealmDatabaseMigration(Context context2) {
        this.context = context2;
    }

    public void migrate(C14061h realm, long oldVersion, long newVersion) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int i;
        C14061h hVar = realm;
        long oldVersion2 = oldVersion;
        Logger instance = Logger.getInstance();
        String str6 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("migrate(): from: ");
        sb.append(oldVersion2);
        sb.append(" to: ");
        sb.append(newVersion);
        instance.mo2148w(str6, sb.toString());
        C14054ea schema = realm.mo43546v();
        String str7 = "appId";
        String str8 = "Scheduled";
        String str9 = "md5";
        String str10 = "Download";
        if (oldVersion2 <= 8075) {
            schema.mo43721c(str8).mo43665e(str7);
            C14042ba c = schema.mo43721c("Rollback");
            c.mo43654a(str9, true);
            c.mo43665e(Update.FILE_SIZE);
            c.mo43665e("trustedBadge");
            hVar.mo43735a(str10);
            hVar.mo43735a("FileToDownload");
            C14042ba c2 = schema.mo43721c("FileToDownload");
            c2.mo43665e(str7);
            c2.mo43657b(str9);
            C14042ba c3 = schema.mo43721c(str10);
            c3.mo43665e(str7);
            c3.mo43653a(str9, String.class, C14073m.PRIMARY_KEY);
            oldVersion2 = 8075 + 1;
            Logger instance2 = Logger.getInstance();
            String str11 = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("DB migrated to version ");
            sb2.append(oldVersion2);
            instance2.mo2148w(str11, sb2.toString());
        }
        String str12 = "Update";
        if (oldVersion2 == 8076) {
            C14042ba scheduledSchema = schema.mo43721c(str8);
            if (scheduledSchema.mo43662d()) {
                scheduledSchema.mo43664e();
            }
            String previous_md5 = "";
            Iterator it = hVar.mo43736b(str8).mo43676a(str9).iterator();
            while (it.hasNext()) {
                C14065j dynamicRealmObject = (C14065j) it.next();
                String current_md5 = dynamicRealmObject.mo43753c(str9);
                if (TextUtils.equals(previous_md5, current_md5)) {
                    dynamicRealmObject.deleteFromRealm();
                }
                previous_md5 = current_md5;
            }
            scheduledSchema.mo43665e(str9);
            scheduledSchema.mo43653a(str9, String.class, C14073m.PRIMARY_KEY);
            hVar.mo43736b(str12).mo43681b().mo43485a();
            oldVersion2++;
            Logger instance3 = Logger.getInstance();
            String str13 = TAG;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("DB migrated to version ");
            sb3.append(oldVersion2);
            instance3.mo2148w(str13, sb3.toString());
        }
        String str14 = "packageName";
        if (oldVersion2 == 8077) {
            C14042ba scheduledSchema2 = schema.mo43721c(str8);
            scheduledSchema2.mo43664e();
            scheduledSchema2.mo43657b(str14);
            if (!scheduledSchema2.mo43661c("appAction")) {
                scheduledSchema2.mo43653a("appAction", String.class, new C14073m[0]);
            }
            if (schema.mo43715a("StoreMinimalAd")) {
                schema.mo43727g("StoreMinimalAd");
            }
            if (schema.mo43715a("MinimalAd")) {
                schema.mo43727g("MinimalAd");
            }
            C14042ba minimalAdSchema = schema.mo43717b("MinimalAd");
            C14073m[] mVarArr = new C14073m[0];
            minimalAdSchema.mo43653a(Repo.COLUMN_DESCRIPTION, String.class, mVarArr);
            minimalAdSchema.mo43653a(str14, String.class, new C14073m[0]);
            minimalAdSchema.mo43653a("networkId", Long.class, new C14073m[0]);
            minimalAdSchema.mo43653a("clickUrl", String.class, new C14073m[0]);
            minimalAdSchema.mo43653a("cpcUrl", String.class, new C14073m[0]);
            minimalAdSchema.mo43653a("cpdUrl", String.class, new C14073m[0]);
            minimalAdSchema.mo43653a(str7, Long.class, new C14073m[0]);
            minimalAdSchema.mo43653a("adId", Long.class, new C14073m[0]);
            C14073m[] mVarArr2 = new C14073m[0];
            minimalAdSchema.mo43653a(StoredMinimalAd.CPI_URL, String.class, mVarArr2);
            minimalAdSchema.mo43653a("name", String.class, new C14073m[0]);
            C14073m[] mVarArr3 = new C14073m[0];
            minimalAdSchema.mo43653a(Store.ICON_PATH, String.class, mVarArr3);
            C14042ba downloadSchema = schema.mo43721c(str10);
            if (!downloadSchema.mo43661c(str14)) {
                i = 0;
                downloadSchema.mo43653a(str14, String.class, new C14073m[0]);
            } else {
                i = 0;
            }
            if (!downloadSchema.mo43661c("versionCode")) {
                downloadSchema.mo43653a("versionCode", Integer.TYPE, new C14073m[i]);
            }
            if (!downloadSchema.mo43661c("action")) {
                downloadSchema.mo43653a("action", Integer.TYPE, new C14073m[0]);
            }
            if (!downloadSchema.mo43661c("scheduled")) {
                downloadSchema.mo43653a("scheduled", Boolean.TYPE, new C14073m[0]);
            }
            oldVersion2++;
            Logger instance4 = Logger.getInstance();
            String str15 = TAG;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("DB migrated to version ");
            sb4.append(oldVersion2);
            instance4.mo2148w(str15, sb4.toString());
        }
        String str16 = Installed.VERSION_NAME;
        if (oldVersion2 == 8078) {
            C14042ba downloadSchema2 = schema.mo43721c("FileToDownload");
            if (!downloadSchema2.mo43661c(str16)) {
                downloadSchema2.mo43653a(str16, String.class, new C14073m[0]);
            }
            C14042ba downloadSchema3 = schema.mo43721c(str10);
            if (!downloadSchema3.mo43661c(str16)) {
                downloadSchema3.mo43653a(str16, String.class, new C14073m[0]);
            }
            oldVersion2++;
        }
        String str17 = "PaymentAuthorization";
        String str18 = "type";
        String str19 = "status";
        String str20 = "PaymentConfirmation";
        if (oldVersion2 == 8079) {
            C14042ba c4 = schema.mo43721c(str20);
            str = str16;
            str2 = str12;
            c4.mo43653a(str19, String.class, C14073m.REQUIRED);
            c4.mo43651a((C14045c) C2757Ta.f5965a);
            c4.mo43664e();
            c4.mo43657b("productId");
            c4.mo43665e("paymentId");
            c4.mo43665e("price");
            c4.mo43665e("currency");
            c4.mo43665e("taxRate");
            c4.mo43665e("icon");
            c4.mo43665e("title");
            c4.mo43665e(Repo.COLUMN_DESCRIPTION);
            c4.mo43665e("priceDescription");
            c4.mo43665e("apiVersion");
            c4.mo43665e("sku");
            c4.mo43665e(str14);
            c4.mo43665e("developerPayload");
            c4.mo43665e(str18);
            c4.mo43665e(str7);
            c4.mo43665e("storeName");
            C14042ba b = schema.mo43717b(str17);
            String str21 = "paymentId";
            b.mo43653a(str21, Integer.class, C14073m.PRIMARY_KEY);
            b.mo43653a("url", String.class, new C14073m[0]);
            b.mo43653a("redirectUrl", String.class, new C14073m[0]);
            b.mo43653a(str19, String.class, C14073m.REQUIRED);
            oldVersion2++;
        } else {
            str = str16;
            str2 = str12;
        }
        if (oldVersion2 == 8080) {
            schema.mo43721c(str10).mo43653a("downloadError", Integer.TYPE, new C14073m[0]);
            hVar.mo43735a(str20);
            hVar.mo43735a(str17);
            String str22 = "payerId";
            schema.mo43721c(str20).mo43653a(str22, String.class, C14073m.REQUIRED);
            String str23 = "payerId";
            schema.mo43721c(str17).mo43653a(str23, String.class, C14073m.REQUIRED);
            oldVersion2++;
        }
        if (oldVersion2 == 8081) {
            if (schema.mo43715a("StoredMinimalAd")) {
                schema.mo43727g("StoredMinimalAd");
            }
            C14042ba b2 = schema.mo43717b("StoredMinimalAd");
            b2.mo43653a(str14, String.class, C14073m.PRIMARY_KEY, C14073m.REQUIRED);
            C14073m[] mVarArr4 = new C14073m[0];
            b2.mo43653a(StoredMinimalAd.REFERRER, String.class, mVarArr4);
            b2.mo43653a("cpcUrl", String.class, new C14073m[0]);
            b2.mo43653a("cpdUrl", String.class, new C14073m[0]);
            C14073m[] mVarArr5 = new C14073m[0];
            b2.mo43653a(StoredMinimalAd.CPI_URL, String.class, mVarArr5);
            b2.mo43653a("timestamp", Long.class, new C14073m[0]);
            b2.mo43653a("adId", Long.class, new C14073m[0]);
            oldVersion2++;
        }
        String str24 = "Notification";
        if (oldVersion2 == 8082) {
            C14042ba b3 = schema.mo43717b(str24);
            str3 = str14;
            C14073m[] mVarArr6 = {C14073m.PRIMARY_KEY};
            b3.mo43653a(Notification.KEY, String.class, mVarArr6);
            b3.mo43653a("abTestingGroup", String.class, new C14073m[0]);
            b3.mo43653a("body", String.class, new C14073m[0]);
            b3.mo43653a("campaignId", Integer.TYPE, new C14073m[0]);
            b3.mo43653a("img", String.class, new C14073m[0]);
            b3.mo43653a("lang", String.class, new C14073m[0]);
            b3.mo43653a("title", String.class, new C14073m[0]);
            b3.mo43653a("url", String.class, new C14073m[0]);
            b3.mo43653a("urlTrack", String.class, new C14073m[0]);
            b3.mo43653a(str18, Integer.TYPE, new C14073m[0]);
            b3.mo43653a("timeStamp", Long.TYPE, new C14073m[0]);
            b3.mo43653a("dismissed", Long.TYPE, new C14073m[0]);
            b3.mo43653a("appName", String.class, new C14073m[0]);
            b3.mo43653a("graphic", String.class, new C14073m[0]);
            oldVersion2++;
        } else {
            str3 = str14;
        }
        if (oldVersion2 == 8083) {
            C14042ba c5 = schema.mo43721c(str24);
            c5.mo43653a("ownerId", String.class, new C14073m[0]);
            c5.mo43651a((C14045c) C2742La.f5949a);
            oldVersion2++;
        }
        if (oldVersion2 == 8084) {
            hVar.mo43735a(str20);
            schema.mo43721c(str20).mo43653a("paymentMethodId", Integer.TYPE, new C14073m[0]);
            C14042ba c6 = schema.mo43721c("Installed");
            c6.mo43664e();
            c6.mo43653a("packageAndVersionCode", String.class, new C14073m[0]);
            c6.mo43651a((C14045c) C2746Na.f5953a);
            c6.mo43657b("packageAndVersionCode");
            c6.mo43653a(str19, Integer.TYPE, new C14073m[0]);
            c6.mo43651a((C14045c) C2748Oa.f5955a);
            c6.mo43653a(str18, Integer.TYPE, new C14073m[0]);
            c6.mo43651a((C14045c) C2752Qa.f5959a);
            oldVersion2++;
        }
        if (oldVersion2 == 8085) {
            C14042ba c7 = schema.mo43721c("MinimalAd");
            c7.mo43653a("downloads", Integer.class, new C14073m[0]);
            c7.mo43653a("stars", Integer.class, new C14073m[0]);
            c7.mo43653a("modified", Long.class, new C14073m[0]);
            oldVersion2++;
        }
        if (oldVersion2 == 8086) {
            hVar.mo43735a(str20);
            C14042ba c8 = schema.mo43721c(str20);
            c8.mo43665e("productId");
            String str25 = "id";
            c8.mo43653a(str25, String.class, C14073m.PRIMARY_KEY);
            String str26 = "productId";
            c8.mo43653a(str26, String.class, C14073m.REQUIRED);
            String str27 = "sellerId";
            c8.mo43653a(str27, String.class, C14073m.REQUIRED);
            c8.mo43653a("clientToken", String.class, new C14073m[0]);
            c8.mo43653a("successUrl", String.class, new C14073m[0]);
            c8.mo43653a("confirmationUrl", String.class, new C14073m[0]);
            c8.mo43653a("payload", String.class, new C14073m[0]);
            hVar.mo43735a(str17);
            oldVersion2++;
        }
        if (oldVersion2 == 8087) {
            C14042ba c9 = schema.mo43721c(str24);
            c9.mo43653a("expire", Long.class, new C14073m[0]);
            c9.mo43651a((C14045c) C2750Pa.f5957a);
            oldVersion2++;
        }
        if (oldVersion2 == 8088) {
            C14042ba c10 = schema.mo43721c(str24);
            c10.mo43653a("notificationCenterUrlTrack", String.class, new C14073m[0]);
            c10.mo43651a((C14045c) C2755Sa.f5963a);
            oldVersion2++;
        }
        if (oldVersion2 == 8089) {
            C14042ba c11 = schema.mo43721c(str24);
            c11.mo43653a("processed", Boolean.TYPE, new C14073m[0]);
            c11.mo43651a((C14045c) C2744Ma.f5951a);
            oldVersion2++;
        }
        if (oldVersion2 == 8090) {
            hVar.mo43735a(str20);
            C14042ba b4 = schema.mo43717b("RealmAuthorization");
            String str28 = "id";
            b4.mo43653a(str28, String.class, C14073m.PRIMARY_KEY);
            String str29 = "customerId";
            b4.mo43653a(str29, String.class, C14073m.REQUIRED);
            b4.mo43653a(str19, String.class, C14073m.REQUIRED);
            b4.mo43653a(str18, String.class, C14073m.REQUIRED);
            String str30 = "metadata";
            b4.mo43653a(str30, String.class, C14073m.REQUIRED);
            C14073m[] mVarArr7 = {C14073m.REQUIRED};
            b4.mo43653a(TransactionDetailsUtilities.TRANSACTION_ID, String.class, mVarArr7);
            C14073m[] mVarArr8 = new C14073m[0];
            b4.mo43653a(Repo.COLUMN_DESCRIPTION, String.class, mVarArr8);
            b4.mo43653a("amount", Double.TYPE, new C14073m[0]);
            b4.mo43653a("currency", String.class, new C14073m[0]);
            b4.mo43653a("currencySymbol", String.class, new C14073m[0]);
            oldVersion2++;
        }
        if (oldVersion2 == 8091) {
            C14042ba b5 = schema.mo43717b("RealmEvent");
            b5.mo43653a("timestamp", Long.TYPE, C14073m.PRIMARY_KEY);
            b5.mo43653a("eventName", String.class, new C14073m[0]);
            b5.mo43653a("action", Integer.TYPE, new C14073m[0]);
            b5.mo43653a("context", String.class, new C14073m[0]);
            b5.mo43653a("data", String.class, new C14073m[0]);
            oldVersion2++;
        }
        if (oldVersion2 == 8092) {
            hVar.mo43735a("Rollback");
            hVar.mo43735a(str8);
            schema.mo43721c(str10).mo43665e("scheduled");
            oldVersion2++;
        }
        if (oldVersion2 == 8093) {
            C14042ba b6 = schema.mo43717b("Installation");
            str4 = str3;
            b6.mo43653a(str4, String.class, C14073m.PRIMARY_KEY);
            b6.mo43653a("icon", String.class, new C14073m[0]);
            b6.mo43653a("name", String.class, new C14073m[0]);
            b6.mo43653a("versionCode", Integer.TYPE, new C14073m[0]);
            b6.mo43653a(str, String.class, new C14073m[0]);
            oldVersion2++;
        } else {
            str4 = str3;
        }
        if (oldVersion2 == 8094) {
            C14042ba b7 = schema.mo43717b("RealmExperiment");
            String str31 = "experimentName";
            b7.mo43653a(str31, String.class, C14073m.PRIMARY_KEY);
            b7.mo43653a("requestTime", Long.TYPE, new C14073m[0]);
            b7.mo43653a("assignment", String.class, new C14073m[0]);
            b7.mo43653a("payload", String.class, new C14073m[0]);
            b7.mo43653a("partOfExperiment", Boolean.TYPE, new C14073m[0]);
            b7.mo43653a("experimentOver", Boolean.TYPE, new C14073m[0]);
            oldVersion2++;
        }
        if (oldVersion2 == 8095) {
            PreferenceManager.getDefaultSharedPreferences(this.context).edit().putBoolean(ManagedKeys.UPDATES_FILTER_ALPHA_BETA_KEY, false).apply();
            oldVersion2++;
        }
        if (oldVersion2 == 8096) {
            str5 = str2;
            if (!schema.mo43721c(str5).mo43661c(Update.APPC_UPGRADE)) {
                C14042ba c12 = schema.mo43721c(str5);
                c12.mo43653a(Update.APPC_UPGRADE, Boolean.TYPE, new C14073m[0]);
                c12.mo43651a((C14045c) C2753Ra.f5960a);
            }
            oldVersion2++;
        } else {
            str5 = str2;
        }
        if (oldVersion2 == 8097) {
            schema.mo43721c(str10).mo43653a("hasAppc", Boolean.TYPE, new C14073m[0]);
            schema.mo43721c(str5).mo43653a("hasAppc", Boolean.TYPE, new C14073m[0]);
            oldVersion2++;
        }
        if (oldVersion2 == 8098) {
            C14042ba b8 = schema.mo43717b("RealmLocalNotificationSync");
            String str32 = "notificationId";
            b8.mo43653a(str32, String.class, C14073m.PRIMARY_KEY);
            b8.mo43653a("title", String.class, new C14073m[0]);
            b8.mo43653a("body", String.class, new C14073m[0]);
            b8.mo43653a("image", String.class, new C14073m[0]);
            b8.mo43653a("navigationUrl", String.class, new C14073m[0]);
            b8.mo43653a("trigger", Long.TYPE, new C14073m[0]);
            b8.mo43653a("id", String.class, new C14073m[0]);
            oldVersion2++;
        }
        if (oldVersion2 == 8099) {
            schema.mo43721c(str10).mo43653a("size", Long.TYPE, new C14073m[0]);
            oldVersion2++;
        }
        if (oldVersion2 == 8100) {
            C14042ba c13 = schema.mo43721c(str5);
            c13.mo43653a("size", Long.TYPE, new C14073m[0]);
            c13.mo43665e(Update.FILE_SIZE);
            oldVersion2++;
        }
        if (oldVersion2 == 8101) {
            schema.mo43717b("MigratedApp").mo43653a(str4, String.class, C14073m.PRIMARY_KEY, C14073m.REQUIRED);
            long oldVersion3 = oldVersion2 + 1;
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m7408c(C14065j obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(obj.mo43753c("packageName"));
        sb.append(obj.mo43738a("versionCode"));
        obj.mo43747a("packageAndVersionCode", sb.toString());
    }
}
