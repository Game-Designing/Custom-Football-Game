package com.mopub.network;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class ImpressionData implements Serializable {
    public static final String ADGROUP_ID = "adgroup_id";
    public static final String ADGROUP_NAME = "adgroup_name";
    public static final String ADGROUP_PRIORITY = "adgroup_priority";
    public static final String ADGROUP_TYPE = "adgroup_type";
    public static final String ADUNIT_FORMAT = "adunit_format";
    public static final String ADUNIT_ID = "adunit_id";
    public static final String ADUNIT_NAME = "adunit_name";
    public static final String COUNTRY = "country";
    public static final String CURRENCY = "currency";
    public static final String IMPRESSION_ID = "id";
    public static final String NETWORK_NAME = "network_name";
    public static final String NETWORK_PLACEMENT_ID = "network_placement_id";
    public static final String PRECISION = "precision";
    public static final String PUBLISHER_REVENUE = "publisher_revenue";

    /* renamed from: a */
    private C11664a f36350a;

    /* renamed from: com.mopub.network.ImpressionData$a */
    private static class C11664a extends JSONObject implements Serializable {
        C11664a(JSONObject json) throws JSONException {
            super(json.toString());
        }

        C11664a(String json) throws JSONException {
            super(json);
        }
    }

    private ImpressionData(JSONObject json) throws JSONException {
        this.f36350a = new C11664a(json);
    }

    /* renamed from: a */
    static ImpressionData m38534a(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        try {
            return new ImpressionData(jsonObject);
        } catch (Exception ex) {
            MoPubLog.log(SdkLogEvent.CUSTOM, ex.toString());
            return null;
        }
    }

    public String getAdUnitId() {
        return this.f36350a.optString(ADUNIT_ID, null);
    }

    public String getAdUnitName() {
        return this.f36350a.optString(ADUNIT_NAME, null);
    }

    public String getAdUnitFormat() {
        return this.f36350a.optString(ADUNIT_FORMAT, null);
    }

    public String getImpressionId() {
        return this.f36350a.optString("id", null);
    }

    public String getCurrency() {
        return this.f36350a.optString("currency", null);
    }

    public Double getPublisherRevenue() {
        try {
            return Double.valueOf(this.f36350a.getDouble(PUBLISHER_REVENUE));
        } catch (Exception e) {
            return null;
        }
    }

    public String getAdGroupId() {
        return this.f36350a.optString(ADGROUP_ID, null);
    }

    public String getAdGroupName() {
        return this.f36350a.optString(ADGROUP_NAME, null);
    }

    public String getAdGroupType() {
        return this.f36350a.optString(ADGROUP_TYPE, null);
    }

    public Integer getAdGroupPriority() {
        try {
            return Integer.valueOf(this.f36350a.getInt(ADGROUP_PRIORITY));
        } catch (Exception e) {
            return null;
        }
    }

    public String getCountry() {
        return this.f36350a.optString(COUNTRY, null);
    }

    public String getPrecision() {
        return this.f36350a.optString(PRECISION, null);
    }

    public String getNetworkName() {
        return this.f36350a.optString(NETWORK_NAME, null);
    }

    public String getNetworkPlacementId() {
        return this.f36350a.optString(NETWORK_PLACEMENT_ID, null);
    }

    public JSONObject getJsonRepresentation() {
        return this.f36350a;
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeUTF(this.f36350a.toString());
    }

    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException, JSONException {
        ois.defaultReadObject();
        this.f36350a = new C11664a(ois.readUTF());
    }
}
