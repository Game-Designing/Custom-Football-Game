package p005cm.aptoide.p006pt.dataprovider.model.p009v7;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.Comment */
public class Comment {
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "UTC")
    private Date added;
    private String body;

    /* renamed from: id */
    private long f45id;
    private Parent parent;
    private Long parentReview;
    private User user;

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.Comment$Access */
    public enum Access {
        PUBLIC,
        PRIVATE,
        UNLISTED
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.Comment$Parent */
    public static class Parent {

        /* renamed from: id */
        private long f46id;

        public long getId() {
            return this.f46id;
        }

        public void setId(long id) {
            this.f46id = id;
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
            if (other.canEqual(this) && getId() == other.getId()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            long $id = getId();
            return (1 * 59) + ((int) (($id >>> 32) ^ $id));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Comment.Parent(id=");
            sb.append(getId());
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.Comment$User */
    public static class User {
        private Access access;
        private String avatar;

        /* renamed from: id */
        private long f47id;
        private String name;

        public long getId() {
            return this.f47id;
        }

        public void setId(long id) {
            this.f47id = id;
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

        public Access getAccess() {
            return this.access;
        }

        public void setAccess(Access access2) {
            this.access = access2;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof User;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof User)) {
                return false;
            }
            User other = (User) o;
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
            Access access2 = getAccess();
            Object other$access = other.getAccess();
            if (access2 != null ? access2.equals(other$access) : other$access == null) {
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
            String avatar2 = getAvatar();
            int result3 = (result2 * 59) + (avatar2 == null ? 43 : avatar2.hashCode());
            Access access2 = getAccess();
            int i2 = result3 * 59;
            if (access2 != null) {
                i = access2.hashCode();
            }
            return i2 + i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Comment.User(id=");
            sb.append(getId());
            sb.append(", name=");
            sb.append(getName());
            sb.append(", avatar=");
            sb.append(getAvatar());
            sb.append(", access=");
            sb.append(getAccess());
            sb.append(")");
            return sb.toString();
        }
    }

    public long getId() {
        return this.f45id;
    }

    public void setId(long id) {
        this.f45id = id;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body2) {
        this.body = body2;
    }

    public Date getAdded() {
        return this.added;
    }

    public void setAdded(Date added2) {
        this.added = added2;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user2) {
        this.user = user2;
    }

    public Long getParentReview() {
        return this.parentReview;
    }

    public void setParentReview(Long parentReview2) {
        this.parentReview = parentReview2;
    }

    public Parent getParent() {
        return this.parent;
    }

    public void setParent(Parent parent2) {
        this.parent = parent2;
    }

    public int hashCode() {
        long $id = getId();
        int result = (1 * 59) + ((int) (($id >>> 32) ^ $id));
        String body2 = getBody();
        int i = 43;
        int result2 = (result * 59) + (body2 == null ? 43 : body2.hashCode());
        Date added2 = getAdded();
        int result3 = (result2 * 59) + (added2 == null ? 43 : added2.hashCode());
        User user2 = getUser();
        int result4 = (result3 * 59) + (user2 == null ? 43 : user2.hashCode());
        Long parentReview2 = getParentReview();
        int result5 = (result4 * 59) + (parentReview2 == null ? 43 : parentReview2.hashCode());
        Parent parent2 = getParent();
        int i2 = result5 * 59;
        if (parent2 != null) {
            i = parent2.hashCode();
        }
        return i2 + i;
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof Comment;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Comment)) {
            return false;
        }
        Comment other = (Comment) o;
        if (!other.canEqual(this) || getId() != other.getId()) {
            return false;
        }
        String body2 = getBody();
        Object other$body = other.getBody();
        if (body2 != null ? !body2.equals(other$body) : other$body != null) {
            return false;
        }
        Date added2 = getAdded();
        Object other$added = other.getAdded();
        if (added2 != null ? !added2.equals(other$added) : other$added != null) {
            return false;
        }
        User user2 = getUser();
        Object other$user = other.getUser();
        if (user2 != null ? !user2.equals(other$user) : other$user != null) {
            return false;
        }
        Long parentReview2 = getParentReview();
        Object other$parentReview = other.getParentReview();
        if (parentReview2 != null ? !parentReview2.equals(other$parentReview) : other$parentReview != null) {
            return false;
        }
        Parent parent2 = getParent();
        Object other$parent = other.getParent();
        if (parent2 != null ? parent2.equals(other$parent) : other$parent == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Comment(id=");
        sb.append(getId());
        sb.append(", body=");
        sb.append(getBody());
        sb.append(", added=");
        sb.append(getAdded());
        sb.append(", user=");
        sb.append(getUser());
        sb.append(", parentReview=");
        sb.append(getParentReview());
        sb.append(", parent=");
        sb.append(getParent());
        sb.append(")");
        return sb.toString();
    }
}
