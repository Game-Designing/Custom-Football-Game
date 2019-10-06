package p005cm.aptoide.p006pt.dataprovider.model.p009v7;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.Review */
public class Review {
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "UTC")
    private Date added;
    private String body;
    private ListComments commentList;
    private Comments comments;

    /* renamed from: id */
    private long f51id;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "UTC")
    private Date modified;
    private Stats stats;
    private String title;
    private User user;

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.Review$Comments */
    public static class Comments {
        private long total;
        private String view;

        public long getTotal() {
            return this.total;
        }

        public void setTotal(long total2) {
            this.total = total2;
        }

        public String getView() {
            return this.view;
        }

        public void setView(String view2) {
            this.view = view2;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof Comments;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Comments)) {
                return false;
            }
            Comments other = (Comments) o;
            if (!other.canEqual(this) || getTotal() != other.getTotal()) {
                return false;
            }
            String view2 = getView();
            Object other$view = other.getView();
            if (view2 != null ? view2.equals(other$view) : other$view == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            long $total = getTotal();
            int result = (1 * 59) + ((int) (($total >>> 32) ^ $total));
            String view2 = getView();
            return (result * 59) + (view2 == null ? 43 : view2.hashCode());
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Review.Comments(total=");
            sb.append(getTotal());
            sb.append(", view=");
            sb.append(getView());
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.Review$Stats */
    public static class Stats {
        private long comments;
        private long likes;
        private long points;
        private float rating;

        public float getRating() {
            return this.rating;
        }

        public void setRating(float rating2) {
            this.rating = rating2;
        }

        public long getPoints() {
            return this.points;
        }

        public void setPoints(long points2) {
            this.points = points2;
        }

        public long getLikes() {
            return this.likes;
        }

        public void setLikes(long likes2) {
            this.likes = likes2;
        }

        public long getComments() {
            return this.comments;
        }

        public void setComments(long comments2) {
            this.comments = comments2;
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
            if (other.canEqual(this) && Float.compare(getRating(), other.getRating()) == 0 && getPoints() == other.getPoints() && getLikes() == other.getLikes() && getComments() == other.getComments()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int result = (1 * 59) + Float.floatToIntBits(getRating());
            long $points = getPoints();
            int result2 = (result * 59) + ((int) (($points >>> 32) ^ $points));
            long $likes = getLikes();
            int result3 = (result2 * 59) + ((int) (($likes >>> 32) ^ $likes));
            long $comments = getComments();
            return (result3 * 59) + ((int) (($comments >>> 32) ^ $comments));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Review.Stats(rating=");
            sb.append(getRating());
            sb.append(", points=");
            sb.append(getPoints());
            sb.append(", likes=");
            sb.append(getLikes());
            sb.append(", comments=");
            sb.append(getComments());
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.Review$User */
    public static class User {
        private String avatar;

        /* renamed from: id */
        private long f52id;
        private String name;

        public long getId() {
            return this.f52id;
        }

        public void setId(long id) {
            this.f52id = id;
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
            if (avatar2 != null ? avatar2.equals(other$avatar) : other$avatar == null) {
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
            int i2 = result2 * 59;
            if (avatar2 != null) {
                i = avatar2.hashCode();
            }
            return i2 + i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Review.User(id=");
            sb.append(getId());
            sb.append(", name=");
            sb.append(getName());
            sb.append(", avatar=");
            sb.append(getAvatar());
            sb.append(")");
            return sb.toString();
        }
    }

    public boolean hasComments() {
        ListComments listComments = this.commentList;
        return (listComments == null || listComments.getDataList() == null || this.commentList.getDataList().getList() == null || this.commentList.getDataList().getList().isEmpty()) ? false : true;
    }

    public long getId() {
        return this.f51id;
    }

    public void setId(long id) {
        this.f51id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title2) {
        this.title = title2;
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

    public Date getModified() {
        return this.modified;
    }

    public void setModified(Date modified2) {
        this.modified = modified2;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user2) {
        this.user = user2;
    }

    public Stats getStats() {
        return this.stats;
    }

    public void setStats(Stats stats2) {
        this.stats = stats2;
    }

    public Comments getComments() {
        return this.comments;
    }

    public void setComments(Comments comments2) {
        this.comments = comments2;
    }

    public ListComments getCommentList() {
        return this.commentList;
    }

    public void setCommentList(ListComments commentList2) {
        this.commentList = commentList2;
    }

    public int hashCode() {
        long $id = getId();
        int result = (1 * 59) + ((int) (($id >>> 32) ^ $id));
        String title2 = getTitle();
        int i = 43;
        int result2 = (result * 59) + (title2 == null ? 43 : title2.hashCode());
        String body2 = getBody();
        int result3 = (result2 * 59) + (body2 == null ? 43 : body2.hashCode());
        Date added2 = getAdded();
        int result4 = (result3 * 59) + (added2 == null ? 43 : added2.hashCode());
        Date modified2 = getModified();
        int result5 = (result4 * 59) + (modified2 == null ? 43 : modified2.hashCode());
        User user2 = getUser();
        int result6 = (result5 * 59) + (user2 == null ? 43 : user2.hashCode());
        Stats stats2 = getStats();
        int result7 = (result6 * 59) + (stats2 == null ? 43 : stats2.hashCode());
        Comments comments2 = getComments();
        int result8 = (result7 * 59) + (comments2 == null ? 43 : comments2.hashCode());
        ListComments commentList2 = getCommentList();
        int i2 = result8 * 59;
        if (commentList2 != null) {
            i = commentList2.hashCode();
        }
        return i2 + i;
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof Review;
    }

    public boolean equals(Object o) {
        Object obj = o;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Review)) {
            return false;
        }
        Review other = (Review) obj;
        if (!other.canEqual(this) || getId() != other.getId()) {
            return false;
        }
        String title2 = getTitle();
        Object other$title = other.getTitle();
        if (title2 != null ? !title2.equals(other$title) : other$title != null) {
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
        Date modified2 = getModified();
        Object other$modified = other.getModified();
        if (modified2 != null ? !modified2.equals(other$modified) : other$modified != null) {
            return false;
        }
        User user2 = getUser();
        Object other$user = other.getUser();
        if (user2 != null ? !user2.equals(other$user) : other$user != null) {
            return false;
        }
        Stats stats2 = getStats();
        Object other$stats = other.getStats();
        if (stats2 != null ? !stats2.equals(other$stats) : other$stats != null) {
            return false;
        }
        Comments comments2 = getComments();
        Comments comments3 = other.getComments();
        if (comments2 != null ? !comments2.equals(comments3) : comments3 != null) {
            return false;
        }
        Comments comments4 = comments3;
        ListComments commentList2 = getCommentList();
        Object other$commentList = other.getCommentList();
        if (commentList2 != null ? commentList2.equals(other$commentList) : other$commentList == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Review(id=");
        sb.append(getId());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", body=");
        sb.append(getBody());
        sb.append(", added=");
        sb.append(getAdded());
        sb.append(", modified=");
        sb.append(getModified());
        sb.append(", user=");
        sb.append(getUser());
        sb.append(", stats=");
        sb.append(getStats());
        sb.append(", comments=");
        sb.append(getComments());
        sb.append(", commentList=");
        sb.append(getCommentList());
        sb.append(")");
        return sb.toString();
    }
}
