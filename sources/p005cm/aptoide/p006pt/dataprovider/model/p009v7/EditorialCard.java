package p005cm.aptoide.p006pt.dataprovider.model.p009v7;

import java.util.List;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.home.Appearance;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.EditorialCard */
public class EditorialCard extends BaseV7Response {
    private Data data;

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.EditorialCard$Action */
    public static class Action {
        private String title;
        private String url;

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title2) {
            this.title = title2;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String url2) {
            this.url = url2;
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.EditorialCard$Content */
    public static class Content {
        private Action action;
        private App app;
        private List<Media> media;
        private String message;
        private String title;
        private String type;

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

        public List<Media> getMedia() {
            return this.media;
        }

        public void setMedia(List<Media> media2) {
            this.media = media2;
        }

        public String getType() {
            return this.type;
        }

        public void setType(String type2) {
            this.type = type2;
        }

        public App getApp() {
            return this.app;
        }

        public void setApp(App app2) {
            this.app = app2;
        }

        public Action getAction() {
            return this.action;
        }

        public void setAction(Action action2) {
            this.action = action2;
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.EditorialCard$Data */
    public static class Data {
        private Appearance appearance;
        private String background;
        private String caption;
        private List<Content> content;
        private String title;
        private String type;

        public List<Content> getContent() {
            return this.content;
        }

        public void setContent(List<Content> content2) {
            this.content = content2;
        }

        public String getType() {
            return this.type;
        }

        public void setType(String type2) {
            this.type = type2;
        }

        public String getBackground() {
            return this.background;
        }

        public void setBackground(String background2) {
            this.background = background2;
        }

        public String getCaption() {
            return this.caption;
        }

        public void setCaption(String caption2) {
            this.caption = caption2;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title2) {
            this.title = title2;
        }

        public Appearance getAppearance() {
            return this.appearance;
        }

        public void setAppearance(Appearance appearance2) {
            this.appearance = appearance2;
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.EditorialCard$Media */
    public static class Media {
        private String description;
        private String image;
        private String thumbnail;
        private String type;

        public String getType() {
            return this.type;
        }

        public void setType(String type2) {
            this.type = type2;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description2) {
            this.description = description2;
        }

        public String getImage() {
            return this.image;
        }

        public void setImage(String image2) {
            this.image = image2;
        }

        public String getThumbnail() {
            return this.thumbnail;
        }

        public void setThumbnail(String thumbnail2) {
            this.thumbnail = thumbnail2;
        }
    }

    public Data getData() {
        return this.data;
    }

    public void setData(Data data2) {
        this.data = data2;
    }
}
