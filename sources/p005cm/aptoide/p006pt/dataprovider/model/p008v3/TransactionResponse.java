package p005cm.aptoide.p006pt.dataprovider.model.p008v3;

import com.fasterxml.jackson.annotation.JsonProperty;

/* renamed from: cm.aptoide.pt.dataprovider.model.v3.TransactionResponse */
public class TransactionResponse extends BaseV3Response {
    @JsonProperty("paymentId")
    private long serviceId;
    @JsonProperty("payStatus")
    private String transactionStatus;

    public String getTransactionStatus() {
        return this.transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus2) {
        this.transactionStatus = transactionStatus2;
    }

    public long getServiceId() {
        return this.serviceId;
    }

    public void setServiceId(long serviceId2) {
        this.serviceId = serviceId2;
    }
}
