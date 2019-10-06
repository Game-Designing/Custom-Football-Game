package p005cm.aptoide.accountmanager;

/* renamed from: cm.aptoide.accountmanager.Store */
public class Store {
    private final String avatar;
    private final long downloadCount;

    /* renamed from: id */
    private final long f4205id;
    private final String name;
    private final String password;
    private final boolean publicAccess;
    private final String theme;
    private final String username;

    public Store(long downloadCount2, String avatar2, long id, String name2, String theme2, String username2, String password2, boolean publicAccess2) {
        this.downloadCount = downloadCount2;
        this.avatar = avatar2;
        this.f4205id = id;
        this.name = name2;
        this.theme = theme2;
        this.username = username2;
        this.password = password2;
        this.publicAccess = publicAccess2;
    }

    private Store() {
        this.downloadCount = 0;
        String str = "";
        this.avatar = str;
        this.f4205id = 0;
        this.name = str;
        this.theme = "DEFAULT";
        this.username = str;
        this.password = str;
        this.publicAccess = true;
    }

    public static Store emptyStore() {
        return new Store();
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public long getDownloadCount() {
        return this.downloadCount;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public long getId() {
        return this.f4205id;
    }

    public String getName() {
        return this.name;
    }

    public String getTheme() {
        return this.theme;
    }

    public boolean hasPublicAccess() {
        return this.publicAccess;
    }
}
