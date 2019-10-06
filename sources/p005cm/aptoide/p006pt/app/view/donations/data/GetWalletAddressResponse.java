package p005cm.aptoide.p006pt.app.view.donations.data;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;

/* renamed from: cm.aptoide.pt.app.view.donations.data.GetWalletAddressResponse */
public class GetWalletAddressResponse extends BaseV7Response {
    private Data data;

    /* renamed from: cm.aptoide.pt.app.view.donations.data.GetWalletAddressResponse$Data */
    public class Data {
        private String address;

        public Data() {
        }

        public String getAddress() {
            return this.address;
        }

        public void setAddress(String address2) {
            this.address = address2;
        }
    }

    public Data getData() {
        return this.data;
    }

    public void setData(Data data2) {
        this.data = data2;
    }
}
