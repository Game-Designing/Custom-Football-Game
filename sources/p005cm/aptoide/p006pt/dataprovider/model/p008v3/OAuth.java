package p005cm.aptoide.p006pt.dataprovider.model.p008v3;

import com.fasterxml.jackson.annotation.JsonProperty;

/* renamed from: cm.aptoide.pt.dataprovider.model.v3.OAuth */
public class OAuth extends BaseV3Response {
    private String accessToken;
    private String error;
    @JsonProperty("error_description")
    private String errorDescription;
    @JsonProperty("refresh_token")
    private String refreshToken;

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public String getErrorDescription() {
        return this.errorDescription;
    }

    public String getError() {
        return this.error;
    }

    public boolean hasErrors() {
        return super.hasErrors() || this.error != null;
    }
}
