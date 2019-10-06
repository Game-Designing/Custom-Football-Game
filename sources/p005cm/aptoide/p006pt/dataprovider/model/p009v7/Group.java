package p005cm.aptoide.p006pt.dataprovider.model.p009v7;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.Group */
public class Group {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Date added;
    private String graphic;
    private String icon;

    /* renamed from: id */
    private long f49id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Date modified;
    private String name;
    private Parent parent;
    private Stats stats;
    private String title;

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.Group$Parent */
    public static class Parent {
        private String graphic;
        private String icon;

        /* renamed from: id */
        private long f50id;
        private String name;
        private String title;

        public long getId() {
            return this.f50id;
        }

        public void setId(long id) {
            this.f50id = id;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name2) {
            this.name = name2;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title2) {
            this.title = title2;
        }

        public String getIcon() {
            return this.icon;
        }

        public void setIcon(String icon2) {
            this.icon = icon2;
        }

        public String getGraphic() {
            return this.graphic;
        }

        public void setGraphic(String graphic2) {
            this.graphic = graphic2;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof Parent;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Parent)) {
                return false;
            }
            Parent other = (Parent) o;
            if (!other.canEqual(this) || getId() != other.getId()) {
                return false;
            }
            String name2 = getName();
            Object other$name = other.getName();
            if (name2 != null ? !name2.equals(other$name) : other$name != null) {
                return false;
            }
            String title2 = getTitle();
            Object other$title = other.getTitle();
            if (title2 != null ? !title2.equals(other$title) : other$title != null) {
                return false;
            }
            String icon2 = getIcon();
            Object other$icon = other.getIcon();
            if (icon2 != null ? !icon2.equals(other$icon) : other$icon != null) {
                return false;
            }
            String graphic2 = getGraphic();
            Object other$graphic = other.getGraphic();
            if (graphic2 != null ? graphic2.equals(other$graphic) : other$graphic == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            long $id = getId();
            int result = (1 * 59) + ((int) (($id >>> 32) ^ $id));
            String name2 = getName();
            int i = 43;
            int result2 = (result * 59) + (name2 == null ? 43 : name2.hashCode());
            String title2 = getTitle();
            int result3 = (result2 * 59) + (title2 == null ? 43 : title2.hashCode());
            String icon2 = getIcon();
            int result4 = (result3 * 59) + (icon2 == null ? 43 : icon2.hashCode());
            String graphic2 = getGraphic();
            int i2 = result4 * 59;
            if (graphic2 != null) {
                i = graphic2.hashCode();
            }
            return i2 + i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Group.Parent(id=");
            sb.append(getId());
            sb.append(", name=");
            sb.append(getName());
            sb.append(", title=");
            sb.append(getTitle());
            sb.append(", icon=");
            sb.append(getIcon());
            sb.append(", graphic=");
            sb.append(getGraphic());
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.Group$Stats */
    public static class Stats {
        private int groups;
        private int items;

        public int getGroups() {
            return this.groups;
        }

        public void setGroups(int groups2) {
            this.groups = groups2;
        }

        public int getItems() {
            return this.items;
        }

        public void setItems(int items2) {
            this.items = items2;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof Stats;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Stats)) {
                return false;
            }
            Stats other = (Stats) o;
            if (other.canEqual(this) && getGroups() == other.getGroups() && getItems() == other.getItems()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((1 * 59) + getGroups()) * 59) + getItems();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Group.Stats(groups=");
            sb.append(getGroups());
            sb.append(", items=");
            sb.append(getItems());
            sb.append(")");
            return sb.toString();
        }
    }

    public long getId() {
        return this.f49id;
    }

    public void setId(long id) {
        this.f49id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title2) {
        this.title = title2;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon2) {
        this.icon = icon2;
    }

    public String getGraphic() {
        return this.graphic;
    }

    public void setGraphic(String graphic2) {
        this.graphic = graphic2;
    }

    public Date getAdded() {
        return this.added;
    }

    public void setAdded(Date added2) {
        this.added = added2;
    }

    public Date getModified() {
        return this.modified;
    }

    public void setModified(Date modified2) {
        this.modified = modified2;
    }

    public Parent getParent() {
        return this.parent;
    }

    public void setParent(Parent parent2) {
        this.parent = parent2;
    }

    public Stats getStats() {
        return this.stats;
    }

    public void setStats(Stats stats2) {
        this.stats = stats2;
    }

    public int hashCode() {
        long $id = getId();
        int result = (1 * 59) + ((int) (($id >>> 32) ^ $id));
        String name2 = getName();
        int i = 43;
        int result2 = (result * 59) + (name2 == null ? 43 : name2.hashCode());
        String title2 = getTitle();
        int result3 = (result2 * 59) + (title2 == null ? 43 : title2.hashCode());
        String icon2 = getIcon();
        int result4 = (result3 * 59) + (icon2 == null ? 43 : icon2.hashCode());
        String graphic2 = getGraphic();
        int result5 = (result4 * 59) + (graphic2 == null ? 43 : graphic2.hashCode());
        Date added2 = getAdded();
        int result6 = (result5 * 59) + (added2 == null ? 43 : added2.hashCode());
        Date modified2 = getModified();
        int result7 = (result6 * 59) + (modified2 == null ? 43 : modified2.hashCode());
        Parent parent2 = getParent();
        int result8 = (result7 * 59) + (parent2 == null ? 43 : parent2.hashCode());
        Stats stats2 = getStats();
        int i2 = result8 * 59;
        if (stats2 != null) {
            i = stats2.hashCode();
        }
        return i2 + i;
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof Group;
    }

    public boolean equals(Object o) {
        Object obj = o;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Group)) {
            return false;
        }
        Group other = (Group) obj;
        if (!other.canEqual(this) || getId() != other.getId()) {
            return false;
        }
        String name2 = getName();
        Object other$name = other.getName();
        if (name2 != null ? !name2.equals(other$name) : other$name != null) {
            return false;
        }
        String title2 = getTitle();
        Object other$title = other.getTitle();
        if (title2 != null ? !title2.equals(other$title) : other$title != null) {
            return false;
        }
        String icon2 = getIcon();
        Object other$icon = other.getIcon();
        if (icon2 != null ? !icon2.equals(other$icon) : other$icon != null) {
            return false;
        }
        String graphic2 = getGraphic();
        Object other$graphic = other.getGraphic();
        if (graphic2 != null ? !graphic2.equals(other$graphic) : other$graphic != null) {
            return false;
        }
        Date added2 = getAdded();
        Object other$added = other.getAdded();
        if (added2 != null ? !added2.equals(other$added) : other$added != null) {
            return false;
        }
        Date modified2 = getModified();
        Object other$modified = other.getModified();
        if (modified2 != null ? !modified2.equals(other$modified) : other$modified != null) {
            return false;
        }
        Parent parent2 = getParent();
        Parent parent3 = other.getParent();
        if (parent2 != null ? !parent2.equals(parent3) : parent3 != null) {
            return false;
        }
        Parent parent4 = parent3;
        Stats stats2 = getStats();
        Object other$stats = other.getStats();
        if (stats2 != null ? stats2.equals(other$stats) : other$stats == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Group(id=");
        sb.append(getId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", icon=");
        sb.append(getIcon());
        sb.append(", graphic=");
        sb.append(getGraphic());
        sb.append(", added=");
        sb.append(getAdded());
        sb.append(", modified=");
        sb.append(getModified());
        sb.append(", parent=");
        sb.append(getParent());
        sb.append(", stats=");
        sb.append(getStats());
        sb.append(")");
        return sb.toString();
    }
}
