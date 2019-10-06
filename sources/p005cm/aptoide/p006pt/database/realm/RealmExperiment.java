package p005cm.aptoide.p006pt.database.realm;

import p024io.realm.C0106Z;
import p024io.realm.C14009P;
import p024io.realm.internal.C7344p;

/* renamed from: cm.aptoide.pt.database.realm.RealmExperiment */
public class RealmExperiment extends C0106Z implements C14009P {
    public static String PRIMARY_KEY_NAME = "experimentName";
    private String assignment;
    private String experimentName;
    private boolean experimentOver;
    private boolean partOfExperiment;
    private String payload;
    private long requestTime;

    public String realmGet$assignment() {
        return this.assignment;
    }

    public String realmGet$experimentName() {
        return this.experimentName;
    }

    public boolean realmGet$experimentOver() {
        return this.experimentOver;
    }

    public boolean realmGet$partOfExperiment() {
        return this.partOfExperiment;
    }

    public String realmGet$payload() {
        return this.payload;
    }

    public long realmGet$requestTime() {
        return this.requestTime;
    }

    public void realmSet$assignment(String str) {
        this.assignment = str;
    }

    public void realmSet$experimentName(String str) {
        this.experimentName = str;
    }

    public void realmSet$experimentOver(boolean z) {
        this.experimentOver = z;
    }

    public void realmSet$partOfExperiment(boolean z) {
        this.partOfExperiment = z;
    }

    public void realmSet$payload(String str) {
        this.payload = str;
    }

    public void realmSet$requestTime(long j) {
        this.requestTime = j;
    }

    public RealmExperiment(String experimentName2, long requestTime2, String assignment2, String payload2, boolean partOfExperiment2, boolean experimentOver2) {
        if (this instanceof C7344p) {
            ((C7344p) this).mo23792b();
        }
        realmSet$experimentName(experimentName2);
        realmSet$requestTime(requestTime2);
        realmSet$assignment(assignment2);
        realmSet$payload(payload2);
        realmSet$partOfExperiment(partOfExperiment2);
        realmSet$experimentOver(experimentOver2);
    }

    public RealmExperiment() {
        if (this instanceof C7344p) {
            ((C7344p) this).mo23792b();
        }
    }

    public String getExperimentName() {
        return realmGet$experimentName();
    }

    public long getRequestTime() {
        return realmGet$requestTime();
    }

    public String getAssignment() {
        return realmGet$assignment();
    }

    public String getPayload() {
        return realmGet$payload();
    }

    public boolean isPartOfExperiment() {
        return realmGet$partOfExperiment();
    }

    public boolean isExperimentOver() {
        return realmGet$experimentOver();
    }
}
