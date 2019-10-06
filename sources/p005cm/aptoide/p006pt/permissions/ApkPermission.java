package p005cm.aptoide.p006pt.permissions;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: cm.aptoide.pt.permissions.ApkPermission */
public class ApkPermission implements Parcelable {
    public static final Creator<ApkPermission> CREATOR = new Creator<ApkPermission>() {
        public ApkPermission createFromParcel(Parcel in) {
            return new ApkPermission(in);
        }

        public ApkPermission[] newArray(int size) {
            return new ApkPermission[size];
        }
    };
    private String description;
    private String name;

    public ApkPermission(String name2, String description2) {
        this.name = name2;
        this.description = description2;
    }

    protected ApkPermission(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description2) {
        this.description = description2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.description);
    }
}
