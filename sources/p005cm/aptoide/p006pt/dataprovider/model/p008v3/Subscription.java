package p005cm.aptoide.p006pt.dataprovider.model.p008v3;

/* renamed from: cm.aptoide.pt.dataprovider.model.v3.Subscription */
public class Subscription {
    private String avatar;
    private String avatarHd;
    private String description;
    private String downloads;

    /* renamed from: id */
    private Number f6082id;
    private String items;
    private String name;
    private String theme;
    private String view;

    public Number getId() {
        return this.f6082id;
    }

    public void setId(Number id) {
        this.f6082id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar2) {
        this.avatar = avatar2;
    }

    public String getDownloads() {
        return this.downloads;
    }

    public void setDownloads(String downloads2) {
        this.downloads = downloads2;
    }

    public String getTheme() {
        return this.theme;
    }

    public void setTheme(String theme2) {
        this.theme = theme2;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description2) {
        this.description = description2;
    }

    public String getItems() {
        return this.items;
    }

    public void setItems(String items2) {
        this.items = items2;
    }

    public String getView() {
        return this.view;
    }

    public void setView(String view2) {
        this.view = view2;
    }

    public String getAvatarHd() {
        return this.avatarHd;
    }

    public void setAvatarHd(String avatarHd2) {
        this.avatarHd = avatarHd2;
    }

    public int hashCode() {
        Object $id = getId();
        int i = 43;
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        String name2 = getName();
        int result2 = (result * 59) + (name2 == null ? 43 : name2.hashCode());
        String avatar2 = getAvatar();
        int result3 = (result2 * 59) + (avatar2 == null ? 43 : avatar2.hashCode());
        String downloads2 = getDownloads();
        int result4 = (result3 * 59) + (downloads2 == null ? 43 : downloads2.hashCode());
        String theme2 = getTheme();
        int result5 = (result4 * 59) + (theme2 == null ? 43 : theme2.hashCode());
        String description2 = getDescription();
        int result6 = (result5 * 59) + (description2 == null ? 43 : description2.hashCode());
        String items2 = getItems();
        int result7 = (result6 * 59) + (items2 == null ? 43 : items2.hashCode());
        String view2 = getView();
        int result8 = (result7 * 59) + (view2 == null ? 43 : view2.hashCode());
        String avatarHd2 = getAvatarHd();
        int i2 = result8 * 59;
        if (avatarHd2 != null) {
            i = avatarHd2.hashCode();
        }
        return i2 + i;
    }

    public boolean equals(Object o) {
        Object obj = o;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Subscription)) {
            return false;
        }
        Subscription other = (Subscription) obj;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$id = getId();
        Object other$id = other.getId();
        if (this$id != null ? !this$id.equals(other$id) : other$id != null) {
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
        String downloads2 = getDownloads();
        Object other$downloads = other.getDownloads();
        if (downloads2 != null ? !downloads2.equals(other$downloads) : other$downloads != null) {
            return false;
        }
        String theme2 = getTheme();
        Object other$theme = other.getTheme();
        if (theme2 != null ? !theme2.equals(other$theme) : other$theme != null) {
            return false;
        }
        String description2 = getDescription();
        Object other$description = other.getDescription();
        if (description2 != null ? !description2.equals(other$description) : other$description != null) {
            return false;
        }
        String items2 = getItems();
        String items3 = other.getItems();
        if (items2 != null ? !items2.equals(items3) : items3 != null) {
            return false;
        }
        String str = items3;
        String view2 = getView();
        String view3 = other.getView();
        if (view2 != null ? !view2.equals(view3) : view3 != null) {
            return false;
        }
        String str2 = view2;
        String avatarHd2 = getAvatarHd();
        String str3 = view3;
        Object other$avatarHd = other.getAvatarHd();
        if (avatarHd2 != null ? avatarHd2.equals(other$avatarHd) : other$avatarHd == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Subscription(id=");
        sb.append(getId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", avatar=");
        sb.append(getAvatar());
        sb.append(", downloads=");
        sb.append(getDownloads());
        sb.append(", theme=");
        sb.append(getTheme());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", items=");
        sb.append(getItems());
        sb.append(", view=");
        sb.append(getView());
        sb.append(", avatarHd=");
        sb.append(getAvatarHd());
        sb.append(")");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof Subscription;
    }
}
