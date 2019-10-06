package p005cm.aptoide.p006pt.dataprovider.model.p008v3;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/* renamed from: cm.aptoide.pt.dataprovider.model.v3.TermsAndConditionsResponse */
public class TermsAndConditionsResponse extends BaseV3Response {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;
    @JsonProperty("privacy")
    private boolean privacy;
    @JsonProperty("tos")
    private boolean tos;

    public Date getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(Date birthDate) {
        this.birthdate = birthDate;
    }

    public boolean isTos() {
        return this.tos;
    }

    public void setTos(boolean tos2) {
        this.tos = tos2;
    }

    public boolean isPrivacy() {
        return this.privacy;
    }

    public void setPrivacy(boolean privacy2) {
        this.privacy = privacy2;
    }
}
