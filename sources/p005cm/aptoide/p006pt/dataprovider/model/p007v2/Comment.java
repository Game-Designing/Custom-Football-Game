package p005cm.aptoide.p006pt.dataprovider.model.p007v2;

import java.util.ArrayList;

/* renamed from: cm.aptoide.pt.dataprovider.model.v2.Comment */
public class Comment {
    private Number answerto;
    private Number appid;
    private String appname;

    /* renamed from: id */
    private Number f6080id;
    private boolean isShowingSubcomments;
    private String lang;
    private String reponame;
    private ArrayList<Comment> subComments = new ArrayList<>();
    private String subject;
    private String text;
    private String timestamp;
    private String useravatar;
    private String useridhash;
    private String username;
    private Number votes;

    public Number getId() {
        return this.f6080id;
    }

    public void setId(Number id) {
        this.f6080id = id;
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String lang2) {
        this.lang = lang2;
    }

    public String getReponame() {
        return this.reponame;
    }

    public void setReponame(String reponame2) {
        this.reponame = reponame2;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject2) {
        this.subject = subject2;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text2) {
        this.text = text2;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(String timestamp2) {
        this.timestamp = timestamp2;
    }

    public String getUseridhash() {
        return this.useridhash;
    }

    public void setUseridhash(String useridhash2) {
        this.useridhash = useridhash2;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username2) {
        this.username = username2;
    }

    public Number getAnswerto() {
        return this.answerto;
    }

    public void setAnswerto(Number answerto2) {
        this.answerto = answerto2;
    }

    public ArrayList<Comment> getSubComments() {
        return this.subComments;
    }

    public void addSubComment(Comment subComment) {
        this.subComments.add(subComment);
    }

    public boolean hasSubComments() {
        return this.subComments.size() != 0;
    }

    public boolean isShowingSubcomments() {
        return this.isShowingSubcomments;
    }

    public void setShowingSubcomments(boolean isShowingSubcomments2) {
        this.isShowingSubcomments = isShowingSubcomments2;
    }

    public void clearSubcomments() {
        this.subComments.clear();
    }

    public Number getVotes() {
        return this.votes;
    }

    public String getAppname() {
        return this.appname;
    }

    public void setAppname(String appname2) {
        this.appname = appname2;
    }

    public String getUseravatar() {
        return this.useravatar;
    }

    public void setUseravatar(String useravatar2) {
        this.useravatar = useravatar2;
    }

    public Number getAppid() {
        return this.appid;
    }

    public void setAppid(Number appid2) {
        this.appid = appid2;
    }
}
