package com.vungle.warren.model;

import android.util.Log;
import com.google.gson.C10191u;
import com.vungle.warren.persistence.Memorable;
import com.vungle.warren.persistence.MemoryUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Placement implements Memorable, Cloneable {
    private static final String TAG = "Placement";
    private final Set<String> advertisementIDs;
    private final boolean autoCached;
    private final String identifier;
    private final boolean incentivized;
    private long wakeupTime;

    public Placement(String identifier2) {
        this.identifier = identifier2;
        this.autoCached = false;
        this.incentivized = false;
        this.advertisementIDs = new LinkedHashSet();
    }

    public Placement(byte[] array) {
        if (array.length != 0) {
            ByteBuffer buffy = ByteBuffer.wrap(array);
            this.identifier = MemoryUtils.extractString(buffy);
            this.advertisementIDs = new LinkedHashSet(Arrays.asList(MemoryUtils.extractStringArray(buffy)));
            boolean z = false;
            this.incentivized = buffy.get() == 1;
            if (buffy.get() == 1) {
                z = true;
            }
            this.autoCached = z;
            this.wakeupTime = buffy.getLong();
            return;
        }
        throw new IllegalArgumentException("Cannot recreate from empty array!");
    }

    public Placement(C10191u jsonObject) throws IllegalArgumentException {
        String str = "reference_id";
        if (jsonObject.mo33473d(str)) {
            this.identifier = jsonObject.mo33466a(str).mo33439h();
            String str2 = "is_auto_cached";
            boolean z = true;
            this.autoCached = jsonObject.mo33473d(str2) && jsonObject.mo33466a(str2).mo33433a();
            String str3 = "is_incentivized";
            if (!jsonObject.mo33473d(str3) || !jsonObject.mo33466a(str3).mo33433a()) {
                z = false;
            }
            this.incentivized = z;
            this.advertisementIDs = new LinkedHashSet();
            return;
        }
        throw new IllegalArgumentException("Missing placement reference ID, cannot use placement!");
    }

    public void addAdvertisementID(String advertisementID) {
        this.advertisementIDs.add(advertisementID);
    }

    public boolean removeAdvertisementID(String advertisementID) {
        return this.advertisementIDs.remove(advertisementID);
    }

    public List<String> getAdvertisementIDs() {
        return new ArrayList(this.advertisementIDs);
    }

    public void snooze(long sleepTime) {
        this.wakeupTime = System.currentTimeMillis() + (1000 * sleepTime);
    }

    public long getWakeupTime() {
        return this.wakeupTime;
    }

    public byte[] toByteArray() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            MemoryUtils.writeString(this.identifier, out);
            MemoryUtils.writeStringArray((String[]) this.advertisementIDs.toArray(new String[this.advertisementIDs.size()]), out);
            int i = 1;
            out.write(this.incentivized ? 1 : 0);
            if (!this.autoCached) {
                i = 0;
            }
            out.write(i);
            out.write(MemoryUtils.toBytes(this.wakeupTime));
            return out.toByteArray();
        } catch (IOException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to write ");
            sb.append(this);
            sb.append(" to a byte array.");
            Log.e("Placement#toByteArray()", sb.toString());
            return new byte[0];
        }
    }

    public String getId() {
        return this.identifier;
    }

    public boolean equalsIgnoreAdvertisements(Object obj) {
        if (!(obj instanceof Placement)) {
            return false;
        }
        Placement wrap = (Placement) obj;
        if (wrap.identifier.equals(this.identifier) && wrap.incentivized == this.incentivized && wrap.autoCached == this.autoCached) {
            return true;
        }
        return false;
    }

    public boolean equals(Object o) {
        boolean z = true;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Placement placement = (Placement) o;
        if (this.autoCached != placement.autoCached || this.incentivized != placement.incentivized || this.wakeupTime != placement.wakeupTime) {
            return false;
        }
        String str = this.identifier;
        if (str == null ? placement.identifier != null : !str.equals(placement.identifier)) {
            return false;
        }
        Set<String> set = this.advertisementIDs;
        if (set != null) {
            z = set.equals(placement.advertisementIDs);
        } else if (placement.advertisementIDs != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        String str = this.identifier;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Set<String> set = this.advertisementIDs;
        if (set != null) {
            i = set.hashCode();
        }
        int result = (((((hashCode + i) * 31) + (this.autoCached ? 1 : 0)) * 31) + (this.incentivized ? 1 : 0)) * 31;
        long j = this.wakeupTime;
        return result + ((int) (j ^ (j >>> 32)));
    }

    public boolean isAutoCached() {
        return this.autoCached;
    }

    public boolean isIncentivized() {
        return this.incentivized;
    }

    public Placement copy() {
        try {
            return (Placement) clone();
        } catch (CloneNotSupportedException e) {
            Log.e(TAG, Log.getStackTraceString(e));
            return null;
        }
    }

    public static Placement restore(int oldVersion, int newVersion, byte[] data) {
        if (data == null || data.length <= 0) {
            return null;
        }
        return new Placement(Arrays.copyOfRange(data, 1, data.length));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Placement{identifier='");
        sb.append(this.identifier);
        sb.append('\'');
        sb.append(", advertisementIDs=");
        sb.append(this.advertisementIDs);
        sb.append(", autoCached=");
        sb.append(this.autoCached);
        sb.append(", incentivized=");
        sb.append(this.incentivized);
        sb.append(", wakeupTime=");
        sb.append(this.wakeupTime);
        sb.append('}');
        return sb.toString();
    }
}
