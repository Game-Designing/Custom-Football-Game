package p005cm.aptoide.p006pt.dataprovider.model.p008v3;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/* renamed from: cm.aptoide.pt.dataprovider.model.v3.PaymentAuthorizationsResponse */
public class PaymentAuthorizationsResponse extends BaseV3Response {
    @JsonProperty("authorizations")
    private List<PaymentAuthorizationResponse> authorizations;

    public List<PaymentAuthorizationResponse> getAuthorizations() {
        return this.authorizations;
    }

    public void setAuthorizations(List<PaymentAuthorizationResponse> authorizations2) {
        this.authorizations = authorizations2;
    }

    public int hashCode() {
        int result = (1 * 59) + super.hashCode();
        Object $authorizations = getAuthorizations();
        return (result * 59) + ($authorizations == null ? 43 : $authorizations.hashCode());
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PaymentAuthorizationsResponse)) {
            return false;
        }
        PaymentAuthorizationsResponse other = (PaymentAuthorizationsResponse) o;
        if (!other.canEqual(this) || !super.equals(o)) {
            return false;
        }
        Object this$authorizations = getAuthorizations();
        Object other$authorizations = other.getAuthorizations();
        if (this$authorizations != null ? this$authorizations.equals(other$authorizations) : other$authorizations == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PaymentAuthorizationsResponse(authorizations=");
        sb.append(getAuthorizations());
        sb.append(")");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof PaymentAuthorizationsResponse;
    }
}
