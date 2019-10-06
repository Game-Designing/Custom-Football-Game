package p005cm.aptoide.p006pt.dataprovider.model.p009v7.store;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.store.HomeUser */
public class HomeUser {
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "UTC")
    private Date added;
    private String avatar;

    /* renamed from: id */
    private long f54id;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "UTC")
    private Date modified;
    private String name;

    public long getId() {
        return this.f54id;
    }

    public HomeUser setId(long id) {
        this.f54id = id;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public HomeUser setName(String name2) {
        this.name = name2;
        return this;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public HomeUser setAvatar(String avatar2) {
        this.avatar = avatar2;
        return this;
    }

    public Date getAdded() {
        return this.added;
    }

    public HomeUser setAdded(Date added2) {
        this.added = added2;
        return this;
    }

    public Date getModified() {
        return this.modified;
    }

    public HomeUser setModified(Date modified2) {
        this.modified = modified2;
        return this;
    }

    public int hashCode() {
        long $id = getId();
        int result = (1 * 59) + ((int) (($id >>> 32) ^ $id));
        String name2 = getName();
        int i = 43;
        int result2 = (result * 59) + (name2 == null ? 43 : name2.hashCode());
        String avatar2 = getAvatar();
        int result3 = (result2 * 59) + (avatar2 == null ? 43 : avatar2.hashCode());
        Date added2 = getAdded();
        int result4 = (result3 * 59) + (added2 == null ? 43 : added2.hashCode());
        Date modified2 = getModified();
        int i2 = result4 * 59;
        if (modified2 != null) {
            i = modified2.hashCode();
        }
        return i2 + i;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof HomeUser)) {
            return false;
        }
        HomeUser other = (HomeUser) o;
        if (!other.canEqual(this) || getId() != other.getId()) {
            return false;
        }
        String name2 = getName();
        Object other$name = other.getName();
        if (name2 != null ? !name2.equals(other$name) : other$name != null) {
            return false;
        }
        String avatar2 = getAvatar();
        Object other$avatar = other.getAvatar();
        if (avatar2 != null ? !avatar2.equals(other$avatar) : other$avatar != null) {
            return false;
        }
        Date added2 = getAdded();
        Object other$added = other.getAdded();
        if (added2 != null ? !added2.equals(other$added) : other$added != null) {
            return false;
        }
        Date modified2 = getModified();
        Object other$modified = other.getModified();
        if (modified2 != null ? modified2.equals(other$modified) : other$modified == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HomeUser(id=");
        sb.append(getId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", avatar=");
        sb.append(getAvatar());
        sb.append(", added=");
        sb.append(getAdded());
        sb.append(", modified=");
        sb.append(getModified());
        sb.append(")");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof HomeUser;
    }
}
