package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.post;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.post.PostInTimelineResponse */
public class PostInTimelineResponse extends BaseV7Response {
    private Data data;

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.post.PostInTimelineResponse$Data */
    public static class Data {
        private PostData data;

        public PostData getData() {
            return this.data;
        }

        public void setData(PostData data2) {
            this.data = data2;
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.post.PostInTimelineResponse$PostData */
    public static class PostData {
        private String uid;

        public String getUid() {
            return this.uid;
        }

        public void setUid(String uid2) {
            this.uid = uid2;
        }
    }

    public Data getData() {
        return this.data;
    }

    public void setData(Data data2) {
        this.data = data2;
    }
}
