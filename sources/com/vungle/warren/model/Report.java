package com.vungle.warren.model;

import android.text.TextUtils;
import android.util.Log;
import com.google.gson.C10185p;
import com.google.gson.C10188s;
import com.google.gson.C10191u;
import com.vungle.warren.persistence.Memorable;
import com.vungle.warren.persistence.MemoryUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import p005cm.aptoide.p006pt.app.view.donations.DonationsAnalytics;
import p005cm.aptoide.p006pt.reviews.RateAndReviewsFragment.BundleCons;

public class Report implements Memorable {
    private long adDuration;
    private final long adStartTime;
    private final String adToken;
    private final String adType;
    private final String advertisementID;
    private final String appId;
    private final String campaign;
    private final ArrayList<String> clickedThrough;
    private final ArrayList<String> errors;
    private final boolean incentivized;
    private final int ordinal;
    private final String placementId;
    private final String templateId;
    private final int ttDownload;
    private final String url;
    private final ArrayList<UserAction> userActions;
    private final String userID;
    private int videoViewed;
    private boolean wasCTAClicked;

    public static class UserAction implements Memorable {
        private final String action;
        private final long timestamp;
        private final String value;

        public UserAction(byte[] array) {
            ByteBuffer buffy = ByteBuffer.wrap(array);
            this.action = MemoryUtils.extractString(buffy);
            this.value = MemoryUtils.extractString(buffy);
            this.timestamp = buffy.getLong();
        }

        public UserAction(String action2, String value2, long timestamp2) {
            this.action = action2;
            this.value = value2;
            this.timestamp = timestamp2;
        }

        public byte[] toByteArray() {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            try {
                MemoryUtils.writeString(this.action, out);
                MemoryUtils.writeString(this.value, out);
                out.write(MemoryUtils.toBytes(this.timestamp));
                return out.toByteArray();
            } catch (IOException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to write ");
                sb.append(this);
                sb.append(" to a byte array");
                Log.e("Report.java", sb.toString());
                return new byte[0];
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof UserAction)) {
                return false;
            }
            UserAction wrap = (UserAction) obj;
            if (wrap.action.equals(this.action) && wrap.value.equals(this.value) && wrap.timestamp == this.timestamp) {
                return true;
            }
            return false;
        }

        public String getId() {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(this.timestamp);
            return sb.toString();
        }

        public C10191u toJson() {
            C10191u ret = new C10191u();
            ret.mo33470a("action", this.action);
            if (!this.value.isEmpty()) {
                ret.mo33470a(DonationsAnalytics.VALUE, this.value);
            }
            ret.mo33469a("timestamp_millis", (Number) Long.valueOf(this.timestamp));
            return ret;
        }
    }

    public Report(byte[] array) {
        if (array.length != 0) {
            this.advertisementID = "";
            ByteBuffer buffy = ByteBuffer.wrap(array);
            this.placementId = MemoryUtils.extractString(buffy);
            this.adToken = MemoryUtils.extractString(buffy);
            this.appId = MemoryUtils.extractString(buffy);
            boolean z = false;
            this.incentivized = buffy.get() == 1;
            this.adStartTime = buffy.getLong();
            this.url = MemoryUtils.extractString(buffy);
            this.adDuration = buffy.getLong();
            this.ttDownload = buffy.getInt();
            this.campaign = MemoryUtils.extractString(buffy);
            this.videoViewed = buffy.getInt();
            this.adType = MemoryUtils.extractString(buffy);
            this.templateId = MemoryUtils.extractString(buffy);
            if (buffy.get() == 1) {
                z = true;
            }
            this.wasCTAClicked = z;
            this.clickedThrough = new ArrayList<>(Arrays.asList(MemoryUtils.extractStringArray(buffy)));
            this.errors = new ArrayList<>(Arrays.asList(MemoryUtils.extractStringArray(buffy)));
            int userActionCount = buffy.getInt();
            this.userActions = new ArrayList<>(userActionCount);
            int x = 0;
            while (x < userActionCount) {
                try {
                    this.userActions.add(MemoryUtils.extractMemorable(buffy, UserAction.class));
                    x++;
                } catch (NoSuchMethodException noMethod) {
                    noMethod.printStackTrace();
                    throw new RuntimeException(noMethod);
                } catch (IllegalAccessException illegalAccess) {
                    illegalAccess.printStackTrace();
                    throw new RuntimeException(illegalAccess);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e2) {
                    e2.printStackTrace();
                    throw new RuntimeException(e2);
                }
            }
            this.userID = MemoryUtils.extractString(buffy);
            this.ordinal = buffy.getInt();
            return;
        }
        throw new IllegalArgumentException("Cannot create Report from empty array");
    }

    public Report(Advertisement advertisement, Placement placement, long startTime) {
        this(advertisement, placement, startTime, null);
    }

    public Report(Advertisement advertisement, Placement placement, long startTime, String userID2) {
        this.placementId = placement.getId();
        this.adToken = advertisement.getAdToken();
        this.advertisementID = advertisement.getId();
        this.appId = advertisement.getAppID();
        this.incentivized = placement.isIncentivized();
        this.adStartTime = startTime;
        this.url = advertisement.getUrl();
        this.ttDownload = -1;
        this.campaign = advertisement.getCampaign();
        int adType2 = advertisement.getAdType();
        if (adType2 == 0) {
            this.adType = "vungle_local";
        } else if (adType2 == 1) {
            this.adType = "vungle_mraid";
        } else {
            throw new IllegalArgumentException("Unknown ad type, cannot process!");
        }
        this.templateId = advertisement.getTemplateId();
        this.clickedThrough = new ArrayList<>();
        this.errors = new ArrayList<>();
        this.userActions = new ArrayList<>();
        if (userID2 == null) {
            this.userID = "";
        } else {
            this.userID = userID2;
        }
        this.ordinal = advertisement.getAdConfig().getOrdinal();
    }

    public void recordAction(String action, String value, long timestamp) {
        this.userActions.add(new UserAction(action, value, timestamp));
        this.clickedThrough.add(action);
        if (action.equals("download")) {
            this.wasCTAClicked = true;
        }
    }

    public void recordError(String description) {
        this.errors.add(description);
    }

    public void recordProgress(int viewed) {
        this.videoViewed = viewed;
    }

    public void setAdDuration(int duration) {
        this.adDuration = (long) duration;
    }

    public String getPlacementId() {
        return this.placementId;
    }

    public String getAdvertisementID() {
        return this.advertisementID;
    }

    public boolean isCTAClicked() {
        return this.wasCTAClicked;
    }

    public String getUserID() {
        return this.userID;
    }

    public C10191u toReportBody() {
        C10191u request = new C10191u();
        request.mo33470a("placement_reference_id", this.placementId);
        request.mo33470a("ad_token", this.adToken);
        request.mo33470a(BundleCons.APP_ID, this.appId);
        request.mo33469a("incentivized", (Number) Integer.valueOf(this.incentivized ? 1 : 0));
        request.mo33469a("adStartTime", (Number) Long.valueOf(this.adStartTime));
        request.mo33470a("url", this.url);
        request.mo33469a("adDuration", (Number) Long.valueOf(this.adDuration));
        request.mo33469a("ttDownload", (Number) Integer.valueOf(this.ttDownload));
        request.mo33470a("campaign", this.campaign);
        request.mo33470a("adType", this.adType);
        request.mo33470a("templateId", this.templateId);
        C10185p plays = new C10185p();
        C10191u playsObject = new C10191u();
        playsObject.mo33469a("startTime", (Number) Long.valueOf(this.adStartTime));
        int i = this.videoViewed;
        if (i > 0) {
            playsObject.mo33469a("videoViewed", (Number) Integer.valueOf(i));
            playsObject.mo33469a("videoLength", (Number) Long.valueOf(this.adDuration));
        }
        C10185p userActionJson = new C10185p();
        Iterator it = this.userActions.iterator();
        while (it.hasNext()) {
            userActionJson.mo33431a((C10188s) ((UserAction) it.next()).toJson());
        }
        playsObject.mo33467a("userActions", (C10188s) userActionJson);
        plays.mo33431a((C10188s) playsObject);
        request.mo33467a("plays", (C10188s) plays);
        C10185p errorsJson = new C10185p();
        Iterator it2 = this.errors.iterator();
        while (it2.hasNext()) {
            errorsJson.mo33432a((String) it2.next());
        }
        request.mo33467a("errors", (C10188s) errorsJson);
        C10185p clicked = new C10185p();
        Iterator it3 = this.clickedThrough.iterator();
        while (it3.hasNext()) {
            clicked.mo33432a((String) it3.next());
        }
        request.mo33467a("clickedThrough", (C10188s) clicked);
        if (this.incentivized && !TextUtils.isEmpty(this.userID)) {
            request.mo33470a("user", this.userID);
        }
        int i2 = this.ordinal;
        if (i2 > 0) {
            request.mo33469a("ordinal_view", (Number) Integer.valueOf(i2));
        }
        return request;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Report)) {
            return false;
        }
        Report wrap = (Report) obj;
        if (!wrap.placementId.equals(this.placementId) || !wrap.adToken.equals(this.adToken) || !wrap.appId.equals(this.appId) || wrap.incentivized != this.incentivized || wrap.adStartTime != this.adStartTime || !wrap.url.equals(this.url) || wrap.adDuration != this.adDuration || wrap.ttDownload != this.ttDownload || !wrap.campaign.equals(this.campaign) || !wrap.adType.equals(this.adType) || !wrap.templateId.equals(this.templateId) || wrap.wasCTAClicked != this.wasCTAClicked || !wrap.userID.equals(this.userID) || wrap.clickedThrough.size() != this.clickedThrough.size()) {
            return false;
        }
        for (int x = 0; x < this.clickedThrough.size(); x++) {
            if (!((String) wrap.clickedThrough.get(x)).equals(this.clickedThrough.get(x))) {
                return false;
            }
        }
        if (wrap.errors.size() != this.errors.size()) {
            return false;
        }
        for (int x2 = 0; x2 < this.errors.size(); x2++) {
            if (!((String) wrap.errors.get(x2)).equals(this.errors.get(x2))) {
                return false;
            }
        }
        if (wrap.userActions.size() != this.userActions.size()) {
            return false;
        }
        for (int x3 = 0; x3 < this.userActions.size(); x3++) {
            if (!((UserAction) wrap.userActions.get(x3)).equals(this.userActions.get(x3))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public byte[] toByteArray() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            MemoryUtils.writeString(this.placementId, out);
            MemoryUtils.writeString(this.adToken, out);
            MemoryUtils.writeString(this.appId, out);
            int i = 1;
            out.write(this.incentivized ? 1 : 0);
            out.write(MemoryUtils.toBytes(this.adStartTime));
            MemoryUtils.writeString(this.url, out);
            out.write(MemoryUtils.toBytes(this.adDuration));
            out.write(MemoryUtils.toBytes(this.ttDownload));
            MemoryUtils.writeString(this.campaign, out);
            out.write(MemoryUtils.toBytes(this.videoViewed));
            MemoryUtils.writeString(this.adType, out);
            MemoryUtils.writeString(this.templateId, out);
            if (!this.wasCTAClicked) {
                i = 0;
            }
            out.write(i);
            MemoryUtils.writeStringArray((String[]) this.clickedThrough.toArray(new String[this.clickedThrough.size()]), out);
            MemoryUtils.writeStringArray((String[]) this.errors.toArray(new String[this.errors.size()]), out);
            out.write(MemoryUtils.toBytes(this.userActions.size()));
            Iterator it = this.userActions.iterator();
            while (it.hasNext()) {
                MemoryUtils.writeMemorable((UserAction) it.next(), out);
            }
            MemoryUtils.writeString(this.userID, out);
            out.write(MemoryUtils.toBytes(this.ordinal));
            return out.toByteArray();
        } catch (IOException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to write ");
            sb.append(this);
            sb.append(" to a byte array");
            Log.e("Report.java", sb.toString());
            return new byte[0];
        }
    }

    public String getId() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.placementId);
        sb.append("_");
        sb.append(this.adStartTime);
        return sb.toString();
    }

    public long getAdStartTime() {
        return this.adStartTime;
    }

    public static Report restore(int oldVersion, int newVersion, byte[] data) {
        if (data == null || data.length <= 0) {
            return null;
        }
        return new Report(Arrays.copyOfRange(data, 1, data.length));
    }
}
