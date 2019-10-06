package p005cm.aptoide.p006pt.dataprovider.model.p008v3;

import com.fasterxml.jackson.annotation.JsonProperty;

/* renamed from: cm.aptoide.pt.dataprovider.model.v3.PaymentAuthorizationResponse */
public class PaymentAuthorizationResponse extends BaseV3Response {
    @JsonProperty("authorizationStatus")
    private String authorizationStatus;
    @JsonProperty("paymentTypeId")
    private int paymentId;
    @JsonProperty("successUrl")
    private String successUrl;
    @JsonProperty("url")
    private String url;

    public int getPaymentId() {
        return this.paymentId;
    }

    public void setPaymentId(int paymentId2) {
        this.paymentId = paymentId2;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url2) {
        this.url = url2;
    }

    public String getSuccessUrl() {
        return this.successUrl;
    }

    public void setSuccessUrl(String successUrl2) {
        this.successUrl = successUrl2;
    }

    public String getAuthorizationStatus() {
        return this.authorizationStatus;
    }

    public void setAuthorizationStatus(String authorizationStatus2) {
        this.authorizationStatus = authorizationStatus2;
    }

    public int hashCode() {
        int result = (((1 * 59) + super.hashCode()) * 59) + getPaymentId();
        String url2 = getUrl();
        int i = 43;
        int result2 = (result * 59) + (url2 == null ? 43 : url2.hashCode());
        String successUrl2 = getSuccessUrl();
        int result3 = (result2 * 59) + (successUrl2 == null ? 43 : successUrl2.hashCode());
        String authorizationStatus2 = getAuthorizationStatus();
        int i2 = result3 * 59;
        if (authorizationStatus2 != null) {
            i = authorizationStatus2.hashCode();
        }
        return i2 + i;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PaymentAuthorizationResponse)) {
            return false;
        }
        PaymentAuthorizationResponse other = (PaymentAuthorizationResponse) o;
        if (!other.canEqual(this) || !super.equals(o) || getPaymentId() != other.getPaymentId()) {
            return false;
        }
        String url2 = getUrl();
        Object other$url = other.getUrl();
        if (url2 != null ? !url2.equals(other$url) : other$url != null) {
            return false;
        }
        String successUrl2 = getSuccessUrl();
        Object other$successUrl = other.getSuccessUrl();
        if (successUrl2 != null ? !successUrl2.equals(other$successUrl) : other$successUrl != null) {
            return false;
        }
        String authorizationStatus2 = getAuthorizationStatus();
        Object other$authorizationStatus = other.getAuthorizationStatus();
        if (authorizationStatus2 != null ? authorizationStatus2.equals(other$authorizationStatus) : other$authorizationStatus == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PaymentAuthorizationResponse(paymentId=");
        sb.append(getPaymentId());
        sb.append(", url=");
        sb.append(getUrl());
        sb.append(", successUrl=");
        sb.append(getSuccessUrl());
        sb.append(", authorizationStatus=");
        sb.append(getAuthorizationStatus());
        sb.append(")");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof PaymentAuthorizationResponse;
    }
}
