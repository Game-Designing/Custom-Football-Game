package p005cm.aptoide.p006pt.dataprovider.model.p008v3;

import com.fasterxml.jackson.annotation.JsonProperty;

/* renamed from: cm.aptoide.pt.dataprovider.model.v3.PaymentServiceResponse */
public class PaymentServiceResponse {
    @JsonProperty("needsauth")
    private boolean authorizationRequired;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("description")
    private String description;
    @JsonProperty("id")

    /* renamed from: id */
    private int f42id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("price")
    private double price;
    @JsonProperty("sign")
    private String sign;
    @JsonProperty("tax_rate")
    private double taxRate;

    public int getId() {
        return this.f42id;
    }

    public void setId(int id) {
        this.f42id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description2) {
        this.description = description2;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price2) {
        this.price = price2;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency2) {
        this.currency = currency2;
    }

    public double getTaxRate() {
        return this.taxRate;
    }

    public void setTaxRate(double taxRate2) {
        this.taxRate = taxRate2;
    }

    public String getSign() {
        return this.sign;
    }

    public void setSign(String sign2) {
        this.sign = sign2;
    }

    public boolean isAuthorizationRequired() {
        return this.authorizationRequired;
    }

    public void setAuthorizationRequired(boolean authorizationRequired2) {
        this.authorizationRequired = authorizationRequired2;
    }

    public int hashCode() {
        int result = (1 * 59) + getId();
        String name2 = getName();
        int i = 43;
        int result2 = (result * 59) + (name2 == null ? 43 : name2.hashCode());
        String description2 = getDescription();
        int result3 = (result2 * 59) + (description2 == null ? 43 : description2.hashCode());
        long $price = Double.doubleToLongBits(getPrice());
        int result4 = (result3 * 59) + ((int) (($price >>> 32) ^ $price));
        String currency2 = getCurrency();
        int result5 = (result4 * 59) + (currency2 == null ? 43 : currency2.hashCode());
        long $taxRate = Double.doubleToLongBits(getTaxRate());
        int result6 = (result5 * 59) + ((int) (($taxRate >>> 32) ^ $taxRate));
        String sign2 = getSign();
        int i2 = result6 * 59;
        if (sign2 != null) {
            i = sign2.hashCode();
        }
        return ((i2 + i) * 59) + (isAuthorizationRequired() ? 79 : 97);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PaymentServiceResponse)) {
            return false;
        }
        PaymentServiceResponse other = (PaymentServiceResponse) o;
        if (!other.canEqual(this) || getId() != other.getId()) {
            return false;
        }
        String name2 = getName();
        Object other$name = other.getName();
        if (name2 != null ? !name2.equals(other$name) : other$name != null) {
            return false;
        }
        String description2 = getDescription();
        Object other$description = other.getDescription();
        if (description2 != null ? !description2.equals(other$description) : other$description != null) {
            return false;
        }
        if (Double.compare(getPrice(), other.getPrice()) != 0) {
            return false;
        }
        String currency2 = getCurrency();
        Object other$currency = other.getCurrency();
        if (currency2 != null ? !currency2.equals(other$currency) : other$currency != null) {
            return false;
        }
        if (Double.compare(getTaxRate(), other.getTaxRate()) != 0) {
            return false;
        }
        String sign2 = getSign();
        Object other$sign = other.getSign();
        if (sign2 != null ? !sign2.equals(other$sign) : other$sign != null) {
            return false;
        }
        if (isAuthorizationRequired() != other.isAuthorizationRequired()) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PaymentServiceResponse(id=");
        sb.append(getId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", price=");
        sb.append(getPrice());
        sb.append(", currency=");
        sb.append(getCurrency());
        sb.append(", taxRate=");
        sb.append(getTaxRate());
        sb.append(", sign=");
        sb.append(getSign());
        sb.append(", authorizationRequired=");
        sb.append(isAuthorizationRequired());
        sb.append(")");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof PaymentServiceResponse;
    }
}
