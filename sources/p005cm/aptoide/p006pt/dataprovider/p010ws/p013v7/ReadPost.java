package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import com.fasterxml.jackson.annotation.JsonProperty;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.ReadPost */
public class ReadPost {
    @JsonProperty("uid")
    private final String postId;
    @JsonProperty("type")
    private final String postType;

    public ReadPost(String postId2, String postType2) {
        this.postId = postId2;
        this.postType = postType2;
    }
}
