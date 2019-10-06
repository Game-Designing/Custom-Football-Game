package p005cm.aptoide.p006pt.dataprovider.model.p009v7;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.BaseV7Response */
public class BaseV7Response {
    private List<Error> errors;
    private Info info;

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.BaseV7Response$Details */
    public static class Details {
        @JsonProperty("store_links")
        private List<StoreLinks> storeLinks;

        public List<StoreLinks> getStoreLinks() {
            return this.storeLinks;
        }

        public void setStoreLinks(List<StoreLinks> storeLinks2) {
            this.storeLinks = storeLinks2;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof Details;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Details)) {
                return false;
            }
            Details other = (Details) o;
            if (!other.canEqual(this)) {
                return false;
            }
            Object this$storeLinks = getStoreLinks();
            Object other$storeLinks = other.getStoreLinks();
            if (this$storeLinks != null ? this$storeLinks.equals(other$storeLinks) : other$storeLinks == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            Object $storeLinks = getStoreLinks();
            return (1 * 59) + ($storeLinks == null ? 43 : $storeLinks.hashCode());
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BaseV7Response.Details(storeLinks=");
            sb.append(getStoreLinks());
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.BaseV7Response$Error */
    public static class Error {
        private String code;
        private String description;
        private Details details;

        public String getCode() {
            return this.code;
        }

        public void setCode(String code2) {
            this.code = code2;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description2) {
            this.description = description2;
        }

        public Details getDetails() {
            return this.details;
        }

        public void setDetails(Details details2) {
            this.details = details2;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof Error;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Error)) {
                return false;
            }
            Error other = (Error) o;
            if (!other.canEqual(this)) {
                return false;
            }
            String code2 = getCode();
            Object other$code = other.getCode();
            if (code2 != null ? !code2.equals(other$code) : other$code != null) {
                return false;
            }
            String description2 = getDescription();
            Object other$description = other.getDescription();
            if (description2 != null ? !description2.equals(other$description) : other$description != null) {
                return false;
            }
            Details details2 = getDetails();
            Object other$details = other.getDetails();
            if (details2 != null ? details2.equals(other$details) : other$details == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            String code2 = getCode();
            int i = 43;
            int result = (1 * 59) + (code2 == null ? 43 : code2.hashCode());
            String description2 = getDescription();
            int result2 = (result * 59) + (description2 == null ? 43 : description2.hashCode());
            Details details2 = getDetails();
            int i2 = result2 * 59;
            if (details2 != null) {
                i = details2.hashCode();
            }
            return i2 + i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BaseV7Response.Error(code=");
            sb.append(getCode());
            sb.append(", description=");
            sb.append(getDescription());
            sb.append(", details=");
            sb.append(getDetails());
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.BaseV7Response$Info */
    public static class Info {
        private Status status;
        private Time time;

        /* renamed from: cm.aptoide.pt.dataprovider.model.v7.BaseV7Response$Info$Status */
        public enum Status {
            OK,
            QUEUED,
            FAIL,
            Processing
        }

        /* renamed from: cm.aptoide.pt.dataprovider.model.v7.BaseV7Response$Info$Time */
        public static class Time {
            private String human;
            private double seconds;

            public double getSeconds() {
                return this.seconds;
            }

            public void setSeconds(double seconds2) {
                this.seconds = seconds2;
            }

            public String getHuman() {
                return this.human;
            }

            public void setHuman(String human2) {
                this.human = human2;
            }

            /* access modifiers changed from: protected */
            public boolean canEqual(Object other) {
                return other instanceof Time;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof Time)) {
                    return false;
                }
                Time other = (Time) o;
                if (!other.canEqual(this) || Double.compare(getSeconds(), other.getSeconds()) != 0) {
                    return false;
                }
                String human2 = getHuman();
                Object other$human = other.getHuman();
                if (human2 != null ? human2.equals(other$human) : other$human == null) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                long $seconds = Double.doubleToLongBits(getSeconds());
                int result = (1 * 59) + ((int) (($seconds >>> 32) ^ $seconds));
                String human2 = getHuman();
                return (result * 59) + (human2 == null ? 43 : human2.hashCode());
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("BaseV7Response.Info.Time(seconds=");
                sb.append(getSeconds());
                sb.append(", human=");
                sb.append(getHuman());
                sb.append(")");
                return sb.toString();
            }
        }

        public Info() {
        }

        public Info(Status status2, Time time2) {
            this.status = status2;
            this.time = time2;
        }

        public Status getStatus() {
            return this.status;
        }

        public void setStatus(Status status2) {
            this.status = status2;
        }

        public Time getTime() {
            return this.time;
        }

        public void setTime(Time time2) {
            this.time = time2;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof Info;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Info)) {
                return false;
            }
            Info other = (Info) o;
            if (!other.canEqual(this)) {
                return false;
            }
            Status status2 = getStatus();
            Object other$status = other.getStatus();
            if (status2 != null ? !status2.equals(other$status) : other$status != null) {
                return false;
            }
            Time time2 = getTime();
            Object other$time = other.getTime();
            if (time2 != null ? time2.equals(other$time) : other$time == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            Status status2 = getStatus();
            int i = 43;
            int result = (1 * 59) + (status2 == null ? 43 : status2.hashCode());
            Time time2 = getTime();
            int i2 = result * 59;
            if (time2 != null) {
                i = time2.hashCode();
            }
            return i2 + i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BaseV7Response.Info(status=");
            sb.append(getStatus());
            sb.append(", time=");
            sb.append(getTime());
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.BaseV7Response$StoreLinks */
    public static class StoreLinks {
        private String error;
        private Type type;
        private String url;

        public Type getType() {
            return this.type;
        }

        public void setType(Type type2) {
            this.type = type2;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String url2) {
            this.url = url2;
        }

        public String getError() {
            return this.error;
        }

        public void setError(String error2) {
            this.error = error2;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof StoreLinks;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof StoreLinks)) {
                return false;
            }
            StoreLinks other = (StoreLinks) o;
            if (!other.canEqual(this)) {
                return false;
            }
            Type type2 = getType();
            Object other$type = other.getType();
            if (type2 != null ? !type2.equals(other$type) : other$type != null) {
                return false;
            }
            String url2 = getUrl();
            Object other$url = other.getUrl();
            if (url2 != null ? !url2.equals(other$url) : other$url != null) {
                return false;
            }
            String error2 = getError();
            Object other$error = other.getError();
            if (error2 != null ? error2.equals(other$error) : other$error == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            Type type2 = getType();
            int i = 43;
            int result = (1 * 59) + (type2 == null ? 43 : type2.hashCode());
            String url2 = getUrl();
            int result2 = (result * 59) + (url2 == null ? 43 : url2.hashCode());
            String error2 = getError();
            int i2 = result2 * 59;
            if (error2 != null) {
                i = error2.hashCode();
            }
            return i2 + i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BaseV7Response.StoreLinks(type=");
            sb.append(getType());
            sb.append(", url=");
            sb.append(getUrl());
            sb.append(", error=");
            sb.append(getError());
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.BaseV7Response$Type */
    public enum Type {
        FACEBOOK_1,
        FACEBOOK_2,
        TWITCH_1,
        TWITCH_2,
        TWITTER_1,
        TWITTER_2,
        YOUTUBE_1,
        YOUTUBE_2
    }

    public Error getError() {
        List<Error> list = this.errors;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return (Error) this.errors.get(0);
    }

    public boolean isOk() {
        Info info2 = this.info;
        return info2 != null && info2.getStatus() == Status.OK;
    }

    public Info getInfo() {
        return this.info;
    }

    public void setInfo(Info info2) {
        this.info = info2;
    }

    public List<Error> getErrors() {
        return this.errors;
    }

    public void setErrors(List<Error> errors2) {
        this.errors = errors2;
    }

    public int hashCode() {
        Info info2 = getInfo();
        int i = 43;
        int result = (1 * 59) + (info2 == null ? 43 : info2.hashCode());
        Object $errors = getErrors();
        int i2 = result * 59;
        if ($errors != null) {
            i = $errors.hashCode();
        }
        return i2 + i;
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof BaseV7Response;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BaseV7Response)) {
            return false;
        }
        BaseV7Response other = (BaseV7Response) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Info info2 = getInfo();
        Object other$info = other.getInfo();
        if (info2 != null ? !info2.equals(other$info) : other$info != null) {
            return false;
        }
        Object this$errors = getErrors();
        Object other$errors = other.getErrors();
        if (this$errors != null ? this$errors.equals(other$errors) : other$errors == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BaseV7Response(info=");
        sb.append(getInfo());
        sb.append(", errors=");
        sb.append(getErrors());
        sb.append(")");
        return sb.toString();
    }
}
