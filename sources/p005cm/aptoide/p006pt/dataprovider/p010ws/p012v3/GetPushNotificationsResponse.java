package p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.BaseV3Response;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v3.GetPushNotificationsResponse */
public class GetPushNotificationsResponse extends BaseV3Response {
    private List<Notification> results;

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v3.GetPushNotificationsResponse$Notification */
    public static class Notification {

        /* renamed from: id */
        private int f56id;
        private Images images;
        private String message;
        @JsonProperty("target_url")
        private String targetUrl;
        private String title;
        @JsonProperty("track_url")
        private String trackUrl;

        /* renamed from: cm.aptoide.pt.dataprovider.ws.v3.GetPushNotificationsResponse$Notification$Images */
        public static class Images {
            @JsonProperty("banner_url")
            private String bannerUrl;
            @JsonProperty("icon_url")
            private String iconUrl;

            public String getBannerUrl() {
                return this.bannerUrl;
            }

            public void setBannerUrl(String bannerUrl2) {
                this.bannerUrl = bannerUrl2;
            }

            public String getIconUrl() {
                return this.iconUrl;
            }

            public void setIconUrl(String iconUrl2) {
                this.iconUrl = iconUrl2;
            }

            /* access modifiers changed from: protected */
            public boolean canEqual(Object other) {
                return other instanceof Images;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof Images)) {
                    return false;
                }
                Images other = (Images) o;
                if (!other.canEqual(this)) {
                    return false;
                }
                String bannerUrl2 = getBannerUrl();
                Object other$bannerUrl = other.getBannerUrl();
                if (bannerUrl2 != null ? !bannerUrl2.equals(other$bannerUrl) : other$bannerUrl != null) {
                    return false;
                }
                String iconUrl2 = getIconUrl();
                Object other$iconUrl = other.getIconUrl();
                if (iconUrl2 != null ? iconUrl2.equals(other$iconUrl) : other$iconUrl == null) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                String bannerUrl2 = getBannerUrl();
                int i = 43;
                int result = (1 * 59) + (bannerUrl2 == null ? 43 : bannerUrl2.hashCode());
                String iconUrl2 = getIconUrl();
                int i2 = result * 59;
                if (iconUrl2 != null) {
                    i = iconUrl2.hashCode();
                }
                return i2 + i;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("GetPushNotificationsResponse.Notification.Images(bannerUrl=");
                sb.append(getBannerUrl());
                sb.append(", iconUrl=");
                sb.append(getIconUrl());
                sb.append(")");
                return sb.toString();
            }
        }

        public int getId() {
            return this.f56id;
        }

        public void setId(int id) {
            this.f56id = id;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title2) {
            this.title = title2;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message2) {
            this.message = message2;
        }

        public String getTargetUrl() {
            return this.targetUrl;
        }

        public void setTargetUrl(String targetUrl2) {
            this.targetUrl = targetUrl2;
        }

        public String getTrackUrl() {
            return this.trackUrl;
        }

        public void setTrackUrl(String trackUrl2) {
            this.trackUrl = trackUrl2;
        }

        public Images getImages() {
            return this.images;
        }

        public void setImages(Images images2) {
            this.images = images2;
        }

        public int hashCode() {
            int result = (1 * 59) + getId();
            String title2 = getTitle();
            int i = 43;
            int result2 = (result * 59) + (title2 == null ? 43 : title2.hashCode());
            String message2 = getMessage();
            int result3 = (result2 * 59) + (message2 == null ? 43 : message2.hashCode());
            String targetUrl2 = getTargetUrl();
            int result4 = (result3 * 59) + (targetUrl2 == null ? 43 : targetUrl2.hashCode());
            String trackUrl2 = getTrackUrl();
            int result5 = (result4 * 59) + (trackUrl2 == null ? 43 : trackUrl2.hashCode());
            Images images2 = getImages();
            int i2 = result5 * 59;
            if (images2 != null) {
                i = images2.hashCode();
            }
            return i2 + i;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof Notification;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Notification)) {
                return false;
            }
            Notification other = (Notification) o;
            if (!other.canEqual(this) || getId() != other.getId()) {
                return false;
            }
            String title2 = getTitle();
            Object other$title = other.getTitle();
            if (title2 != null ? !title2.equals(other$title) : other$title != null) {
                return false;
            }
            String message2 = getMessage();
            Object other$message = other.getMessage();
            if (message2 != null ? !message2.equals(other$message) : other$message != null) {
                return false;
            }
            String targetUrl2 = getTargetUrl();
            Object other$targetUrl = other.getTargetUrl();
            if (targetUrl2 != null ? !targetUrl2.equals(other$targetUrl) : other$targetUrl != null) {
                return false;
            }
            String trackUrl2 = getTrackUrl();
            Object other$trackUrl = other.getTrackUrl();
            if (trackUrl2 != null ? !trackUrl2.equals(other$trackUrl) : other$trackUrl != null) {
                return false;
            }
            Images images2 = getImages();
            Object other$images = other.getImages();
            if (images2 != null ? images2.equals(other$images) : other$images == null) {
                return true;
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("GetPushNotificationsResponse.Notification(id=");
            sb.append(getId());
            sb.append(", title=");
            sb.append(getTitle());
            sb.append(", message=");
            sb.append(getMessage());
            sb.append(", targetUrl=");
            sb.append(getTargetUrl());
            sb.append(", trackUrl=");
            sb.append(getTrackUrl());
            sb.append(", images=");
            sb.append(getImages());
            sb.append(")");
            return sb.toString();
        }
    }

    public List<Notification> getResults() {
        return this.results;
    }

    public void setResults(List<Notification> results2) {
        this.results = results2;
    }

    public int hashCode() {
        int result = (1 * 59) + super.hashCode();
        Object $results = getResults();
        return (result * 59) + ($results == null ? 43 : $results.hashCode());
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof GetPushNotificationsResponse)) {
            return false;
        }
        GetPushNotificationsResponse other = (GetPushNotificationsResponse) o;
        if (!other.canEqual(this) || !super.equals(o)) {
            return false;
        }
        Object this$results = getResults();
        Object other$results = other.getResults();
        if (this$results != null ? this$results.equals(other$results) : other$results == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GetPushNotificationsResponse(results=");
        sb.append(getResults());
        sb.append(")");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof GetPushNotificationsResponse;
    }
}
