package p005cm.aptoide.p006pt.dataprovider.model.p008v3;

import java.util.List;

/* renamed from: cm.aptoide.pt.dataprovider.model.v3.BaseV3Response */
public class BaseV3Response {
    private List<ErrorResponse> errors;
    private String status;

    public boolean isOk() {
        String str = this.status;
        return str != null && str.equalsIgnoreCase("ok");
    }

    public boolean hasErrors() {
        List<ErrorResponse> list = this.errors;
        return list != null && !list.isEmpty();
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status2) {
        this.status = status2;
    }

    public List<ErrorResponse> getErrors() {
        return this.errors;
    }

    public void setErrors(List<ErrorResponse> errors2) {
        this.errors = errors2;
    }

    public int hashCode() {
        String status2 = getStatus();
        int i = 43;
        int result = (1 * 59) + (status2 == null ? 43 : status2.hashCode());
        Object $errors = getErrors();
        int i2 = result * 59;
        if ($errors != null) {
            i = $errors.hashCode();
        }
        return i2 + i;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BaseV3Response)) {
            return false;
        }
        BaseV3Response other = (BaseV3Response) o;
        if (!other.canEqual(this)) {
            return false;
        }
        String status2 = getStatus();
        Object other$status = other.getStatus();
        if (status2 != null ? !status2.equals(other$status) : other$status != null) {
            return false;
        }
        Object this$errors = getErrors();
        Object other$errors = other.getErrors();
        if (this$errors != null ? this$errors.equals(other$errors) : other$errors == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BaseV3Response(status=");
        sb.append(getStatus());
        sb.append(", errors=");
        sb.append(getErrors());
        sb.append(")");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof BaseV3Response;
    }
}
