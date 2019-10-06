package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.post;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.post.CardPreviewResponse */
public final class CardPreviewResponse extends BaseV7Response {
    CardPreview data;

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.post.CardPreviewResponse$CardPreview */
    public static class CardPreview {
        private TitleAndThumbnail data;
        private String type;

        public String getType() {
            return this.type;
        }

        public void setType(String type2) {
            this.type = type2;
        }

        public TitleAndThumbnail getData() {
            return this.data;
        }

        public void setData(TitleAndThumbnail data2) {
            this.data = data2;
        }

        public int hashCode() {
            String type2 = getType();
            int i = 43;
            int result = (1 * 59) + (type2 == null ? 43 : type2.hashCode());
            TitleAndThumbnail data2 = getData();
            int i2 = result * 59;
            if (data2 != null) {
                i = data2.hashCode();
            }
            return i2 + i;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof CardPreview;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof CardPreview)) {
                return false;
            }
            CardPreview other = (CardPreview) o;
            if (!other.canEqual(this)) {
                return false;
            }
            String type2 = getType();
            Object other$type = other.getType();
            if (type2 != null ? !type2.equals(other$type) : other$type != null) {
                return false;
            }
            TitleAndThumbnail data2 = getData();
            Object other$data = other.getData();
            if (data2 != null ? data2.equals(other$data) : other$data == null) {
                return true;
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("CardPreviewResponse.CardPreview(type=");
            sb.append(getType());
            sb.append(", data=");
            sb.append(getData());
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.post.CardPreviewResponse$TitleAndThumbnail */
    public static class TitleAndThumbnail {
        private String thumbnail;
        private String title;

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title2) {
            this.title = title2;
        }

        public String getThumbnail() {
            return this.thumbnail;
        }

        public void setThumbnail(String thumbnail2) {
            this.thumbnail = thumbnail2;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof TitleAndThumbnail;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof TitleAndThumbnail)) {
                return false;
            }
            TitleAndThumbnail other = (TitleAndThumbnail) o;
            if (!other.canEqual(this)) {
                return false;
            }
            String title2 = getTitle();
            Object other$title = other.getTitle();
            if (title2 != null ? !title2.equals(other$title) : other$title != null) {
                return false;
            }
            String thumbnail2 = getThumbnail();
            Object other$thumbnail = other.getThumbnail();
            if (thumbnail2 != null ? thumbnail2.equals(other$thumbnail) : other$thumbnail == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            String title2 = getTitle();
            int i = 43;
            int result = (1 * 59) + (title2 == null ? 43 : title2.hashCode());
            String thumbnail2 = getThumbnail();
            int i2 = result * 59;
            if (thumbnail2 != null) {
                i = thumbnail2.hashCode();
            }
            return i2 + i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("CardPreviewResponse.TitleAndThumbnail(title=");
            sb.append(getTitle());
            sb.append(", thumbnail=");
            sb.append(getThumbnail());
            sb.append(")");
            return sb.toString();
        }
    }

    public CardPreview getData() {
        return this.data;
    }

    public void setData(CardPreview data2) {
        this.data = data2;
    }

    public int hashCode() {
        CardPreview data2 = getData();
        return (1 * 59) + (data2 == null ? 43 : data2.hashCode());
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof CardPreviewResponse;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CardPreviewResponse)) {
            return false;
        }
        CardPreviewResponse other = (CardPreviewResponse) o;
        if (!other.canEqual(this)) {
            return false;
        }
        CardPreview data2 = getData();
        Object other$data = other.getData();
        if (data2 != null ? data2.equals(other$data) : other$data == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CardPreviewResponse(data=");
        sb.append(getData());
        sb.append(")");
        return sb.toString();
    }
}
