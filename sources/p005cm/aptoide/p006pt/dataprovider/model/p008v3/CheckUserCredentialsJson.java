package p005cm.aptoide.p006pt.dataprovider.model.p008v3;

import com.fasterxml.jackson.annotation.JsonProperty;

/* renamed from: cm.aptoide.pt.dataprovider.model.v3.CheckUserCredentialsJson */
public class CheckUserCredentialsJson extends BaseV3Response {
    public String access;
    @JsonProperty("access_confirmed")
    public boolean accessConfirmed;
    public String avatar;
    public String email;

    /* renamed from: id */
    public int f41id;
    public String ravatarHd;
    public String repo;
    public Settings settings;
    public String token;
    public String username;

    /* renamed from: cm.aptoide.pt.dataprovider.model.v3.CheckUserCredentialsJson$Settings */
    public static class Settings {
        @JsonProperty("matureswitch")
        public String matureswitch;

        public String getMatureswitch() {
            return this.matureswitch;
        }

        public void setMatureswitch(String matureswitch2) {
            this.matureswitch = matureswitch2;
        }

        public int hashCode() {
            String matureswitch2 = getMatureswitch();
            return (1 * 59) + (matureswitch2 == null ? 43 : matureswitch2.hashCode());
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Settings)) {
                return false;
            }
            Settings other = (Settings) o;
            if (!other.canEqual(this)) {
                return false;
            }
            String matureswitch2 = getMatureswitch();
            Object other$matureswitch = other.getMatureswitch();
            if (matureswitch2 != null ? matureswitch2.equals(other$matureswitch) : other$matureswitch == null) {
                return true;
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("CheckUserCredentialsJson.Settings(matureswitch=");
            sb.append(getMatureswitch());
            sb.append(")");
            return sb.toString();
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof Settings;
        }
    }

    public int getId() {
        return this.f41id;
    }

    public void setId(int id) {
        this.f41id = id;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token2) {
        this.token = token2;
    }

    public String getRepo() {
        return this.repo;
    }

    public void setRepo(String repo2) {
        this.repo = repo2;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar2) {
        this.avatar = avatar2;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username2) {
        this.username = username2;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email2) {
        this.email = email2;
    }

    public Settings getSettings() {
        return this.settings;
    }

    public void setSettings(Settings settings2) {
        this.settings = settings2;
    }

    public String getAccess() {
        return this.access;
    }

    public void setAccess(String access2) {
        this.access = access2;
    }

    public boolean isAccessConfirmed() {
        return this.accessConfirmed;
    }

    public void setAccessConfirmed(boolean accessConfirmed2) {
        this.accessConfirmed = accessConfirmed2;
    }

    public String getRavatarHd() {
        return this.ravatarHd;
    }

    public void setRavatarHd(String ravatarHd2) {
        this.ravatarHd = ravatarHd2;
    }

    public int hashCode() {
        int result = (((1 * 59) + super.hashCode()) * 59) + getId();
        String token2 = getToken();
        int i = 43;
        int result2 = (result * 59) + (token2 == null ? 43 : token2.hashCode());
        String repo2 = getRepo();
        int result3 = (result2 * 59) + (repo2 == null ? 43 : repo2.hashCode());
        String avatar2 = getAvatar();
        int result4 = (result3 * 59) + (avatar2 == null ? 43 : avatar2.hashCode());
        String username2 = getUsername();
        int result5 = (result4 * 59) + (username2 == null ? 43 : username2.hashCode());
        String email2 = getEmail();
        int result6 = (result5 * 59) + (email2 == null ? 43 : email2.hashCode());
        Settings settings2 = getSettings();
        int result7 = (result6 * 59) + (settings2 == null ? 43 : settings2.hashCode());
        String access2 = getAccess();
        int result8 = (((result7 * 59) + (access2 == null ? 43 : access2.hashCode())) * 59) + (isAccessConfirmed() ? 79 : 97);
        String ravatarHd2 = getRavatarHd();
        int i2 = result8 * 59;
        if (ravatarHd2 != null) {
            i = ravatarHd2.hashCode();
        }
        return i2 + i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c9 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00ca  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = 1
            if (r1 != r0) goto L_0x0008
            return r2
        L_0x0008:
            boolean r3 = r1 instanceof p005cm.aptoide.p006pt.dataprovider.model.p008v3.CheckUserCredentialsJson
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            r3 = r1
            cm.aptoide.pt.dataprovider.model.v3.CheckUserCredentialsJson r3 = (p005cm.aptoide.p006pt.dataprovider.model.p008v3.CheckUserCredentialsJson) r3
            boolean r5 = r3.canEqual(r0)
            if (r5 != 0) goto L_0x0018
            return r4
        L_0x0018:
            boolean r5 = super.equals(r21)
            if (r5 != 0) goto L_0x001f
            return r4
        L_0x001f:
            int r5 = r20.getId()
            int r6 = r3.getId()
            if (r5 == r6) goto L_0x002a
            return r4
        L_0x002a:
            java.lang.String r5 = r20.getToken()
            java.lang.String r6 = r3.getToken()
            if (r5 != 0) goto L_0x0037
            if (r6 == 0) goto L_0x003e
            goto L_0x003d
        L_0x0037:
            boolean r7 = r5.equals(r6)
            if (r7 != 0) goto L_0x003e
        L_0x003d:
            return r4
        L_0x003e:
            java.lang.String r7 = r20.getRepo()
            java.lang.String r8 = r3.getRepo()
            if (r7 != 0) goto L_0x004b
            if (r8 == 0) goto L_0x0052
            goto L_0x0051
        L_0x004b:
            boolean r9 = r7.equals(r8)
            if (r9 != 0) goto L_0x0052
        L_0x0051:
            return r4
        L_0x0052:
            java.lang.String r9 = r20.getAvatar()
            java.lang.String r10 = r3.getAvatar()
            if (r9 != 0) goto L_0x005f
            if (r10 == 0) goto L_0x0066
            goto L_0x0065
        L_0x005f:
            boolean r11 = r9.equals(r10)
            if (r11 != 0) goto L_0x0066
        L_0x0065:
            return r4
        L_0x0066:
            java.lang.String r11 = r20.getUsername()
            java.lang.String r12 = r3.getUsername()
            if (r11 != 0) goto L_0x0073
            if (r12 == 0) goto L_0x007a
            goto L_0x0079
        L_0x0073:
            boolean r13 = r11.equals(r12)
            if (r13 != 0) goto L_0x007a
        L_0x0079:
            return r4
        L_0x007a:
            java.lang.String r13 = r20.getEmail()
            java.lang.String r14 = r3.getEmail()
            if (r13 != 0) goto L_0x0087
            if (r14 == 0) goto L_0x008e
            goto L_0x008d
        L_0x0087:
            boolean r15 = r13.equals(r14)
            if (r15 != 0) goto L_0x008e
        L_0x008d:
            return r4
        L_0x008e:
            cm.aptoide.pt.dataprovider.model.v3.CheckUserCredentialsJson$Settings r15 = r20.getSettings()
            cm.aptoide.pt.dataprovider.model.v3.CheckUserCredentialsJson$Settings r2 = r3.getSettings()
            if (r15 != 0) goto L_0x009b
            if (r2 == 0) goto L_0x00a2
            goto L_0x00a1
        L_0x009b:
            boolean r17 = r15.equals(r2)
            if (r17 != 0) goto L_0x00a2
        L_0x00a1:
            return r4
        L_0x00a2:
            java.lang.String r4 = r20.getAccess()
            java.lang.String r0 = r3.getAccess()
            if (r4 != 0) goto L_0x00b2
            if (r0 == 0) goto L_0x00af
            goto L_0x00b8
        L_0x00af:
            r17 = 0
            goto L_0x00bd
        L_0x00b2:
            boolean r18 = r4.equals(r0)
            if (r18 != 0) goto L_0x00bb
        L_0x00b8:
            r17 = 0
            return r17
        L_0x00bb:
            r17 = 0
        L_0x00bd:
            r18 = r0
            boolean r0 = r20.isAccessConfirmed()
            boolean r1 = r3.isAccessConfirmed()
            if (r0 == r1) goto L_0x00ca
            return r17
        L_0x00ca:
            java.lang.String r0 = r20.getRavatarHd()
            java.lang.String r1 = r3.getRavatarHd()
            if (r0 != 0) goto L_0x00d7
            if (r1 == 0) goto L_0x00e0
            goto L_0x00dd
        L_0x00d7:
            boolean r19 = r0.equals(r1)
            if (r19 != 0) goto L_0x00e0
        L_0x00dd:
            r16 = 0
            return r16
        L_0x00e0:
            r16 = 1
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.dataprovider.model.p008v3.CheckUserCredentialsJson.equals(java.lang.Object):boolean");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CheckUserCredentialsJson(id=");
        sb.append(getId());
        sb.append(", token=");
        sb.append(getToken());
        sb.append(", repo=");
        sb.append(getRepo());
        sb.append(", avatar=");
        sb.append(getAvatar());
        sb.append(", username=");
        sb.append(getUsername());
        sb.append(", email=");
        sb.append(getEmail());
        sb.append(", settings=");
        sb.append(getSettings());
        sb.append(", access=");
        sb.append(getAccess());
        sb.append(", accessConfirmed=");
        sb.append(isAccessConfirmed());
        sb.append(", ravatarHd=");
        sb.append(getRavatarHd());
        sb.append(")");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof CheckUserCredentialsJson;
    }
}
