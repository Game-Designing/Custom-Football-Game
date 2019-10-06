package p005cm.aptoide.p006pt.app.view.donations.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.app.view.donations.data.BaseResponse */
public class BaseResponse {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private List<Error> errors;
    private Info info;

    /* renamed from: cm.aptoide.pt.app.view.donations.data.BaseResponse$Details */
    static class Details {
        private static transient /* synthetic */ boolean[] $jacocoData;
        @JsonProperty("store_links")
        private List<StoreLinks> storeLinks;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-7929868406745150588L, "cm/aptoide/pt/app/view/donations/data/BaseResponse$Details", 22);
            $jacocoData = probes;
            return probes;
        }

        Details() {
            $jacocoInit()[0] = true;
        }

        /* access modifiers changed from: 0000 */
        public List<StoreLinks> getStoreLinks() {
            boolean[] $jacocoInit = $jacocoInit();
            List<StoreLinks> list = this.storeLinks;
            $jacocoInit[1] = true;
            return list;
        }

        /* access modifiers changed from: 0000 */
        public void setStoreLinks(List<StoreLinks> storeLinks2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.storeLinks = storeLinks2;
            $jacocoInit[2] = true;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            boolean z = other instanceof Details;
            $jacocoInit()[3] = true;
            return z;
        }

        public boolean equals(Object o) {
            boolean[] $jacocoInit = $jacocoInit();
            if (o == this) {
                $jacocoInit[4] = true;
                return true;
            } else if (!(o instanceof Details)) {
                $jacocoInit[5] = true;
                return false;
            } else {
                Details other = (Details) o;
                $jacocoInit[6] = true;
                if (!other.canEqual(this)) {
                    $jacocoInit[7] = true;
                    return false;
                }
                Object this$storeLinks = getStoreLinks();
                $jacocoInit[8] = true;
                Object other$storeLinks = other.getStoreLinks();
                if (this$storeLinks != null) {
                    $jacocoInit[11] = true;
                    if (this$storeLinks.equals(other$storeLinks)) {
                        $jacocoInit[12] = true;
                    } else {
                        $jacocoInit[13] = true;
                        $jacocoInit[14] = true;
                        return false;
                    }
                } else if (other$storeLinks == null) {
                    $jacocoInit[9] = true;
                } else {
                    $jacocoInit[10] = true;
                    $jacocoInit[14] = true;
                    return false;
                }
                $jacocoInit[15] = true;
                return true;
            }
        }

        public int hashCode() {
            int i;
            boolean[] $jacocoInit = $jacocoInit();
            $jacocoInit[16] = true;
            Object $storeLinks = getStoreLinks();
            $jacocoInit[17] = true;
            int i2 = 1 * 59;
            if ($storeLinks == null) {
                i = 43;
                $jacocoInit[18] = true;
            } else {
                i = $storeLinks.hashCode();
                $jacocoInit[19] = true;
            }
            int result = i2 + i;
            $jacocoInit[20] = true;
            return result;
        }

        public String toString() {
            boolean[] $jacocoInit = $jacocoInit();
            StringBuilder sb = new StringBuilder();
            sb.append("BaseV7Response.Details(storeLinks=");
            sb.append(getStoreLinks());
            sb.append(")");
            String sb2 = sb.toString();
            $jacocoInit[21] = true;
            return sb2;
        }
    }

    /* renamed from: cm.aptoide.pt.app.view.donations.data.BaseResponse$Error */
    static class Error {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private String code;
        private String description;
        private Details details;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(9075333359317763797L, "cm/aptoide/pt/app/view/donations/data/BaseResponse$Error", 51);
            $jacocoData = probes;
            return probes;
        }

        Error() {
            $jacocoInit()[0] = true;
        }

        /* access modifiers changed from: 0000 */
        public String getCode() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.code;
            $jacocoInit[1] = true;
            return str;
        }

        /* access modifiers changed from: 0000 */
        public void setCode(String code2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.code = code2;
            $jacocoInit[2] = true;
        }

        /* access modifiers changed from: 0000 */
        public String getDescription() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.description;
            $jacocoInit[3] = true;
            return str;
        }

        /* access modifiers changed from: 0000 */
        public void setDescription(String description2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.description = description2;
            $jacocoInit[4] = true;
        }

        /* access modifiers changed from: 0000 */
        public Details getDetails() {
            boolean[] $jacocoInit = $jacocoInit();
            Details details2 = this.details;
            $jacocoInit[5] = true;
            return details2;
        }

        /* access modifiers changed from: 0000 */
        public void setDetails(Details details2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.details = details2;
            $jacocoInit[6] = true;
        }

        public boolean canEqual(Object other) {
            boolean z = other instanceof Error;
            $jacocoInit()[7] = true;
            return z;
        }

        public boolean equals(Object o) {
            boolean[] $jacocoInit = $jacocoInit();
            if (o == this) {
                $jacocoInit[8] = true;
                return true;
            } else if (!(o instanceof Error)) {
                $jacocoInit[9] = true;
                return false;
            } else {
                Error other = (Error) o;
                $jacocoInit[10] = true;
                if (!other.canEqual(this)) {
                    $jacocoInit[11] = true;
                    return false;
                }
                String code2 = getCode();
                $jacocoInit[12] = true;
                Object other$code = other.getCode();
                $jacocoInit[13] = true;
                if (code2 == null) {
                    if (other$code == null) {
                        $jacocoInit[14] = true;
                    } else {
                        $jacocoInit[15] = true;
                        $jacocoInit[18] = true;
                        return false;
                    }
                } else if (code2.equals(other$code)) {
                    $jacocoInit[16] = true;
                } else {
                    $jacocoInit[17] = true;
                    $jacocoInit[18] = true;
                    return false;
                }
                String description2 = getDescription();
                $jacocoInit[19] = true;
                Object other$description = other.getDescription();
                if (description2 != null) {
                    $jacocoInit[22] = true;
                    if (description2.equals(other$description)) {
                        $jacocoInit[23] = true;
                    } else {
                        $jacocoInit[24] = true;
                        $jacocoInit[25] = true;
                        return false;
                    }
                } else if (other$description == null) {
                    $jacocoInit[20] = true;
                } else {
                    $jacocoInit[21] = true;
                    $jacocoInit[25] = true;
                    return false;
                }
                Details details2 = getDetails();
                $jacocoInit[26] = true;
                Object other$details = other.getDetails();
                $jacocoInit[27] = true;
                if (details2 == null) {
                    if (other$details == null) {
                        $jacocoInit[28] = true;
                    } else {
                        $jacocoInit[29] = true;
                        $jacocoInit[32] = true;
                        return false;
                    }
                } else if (details2.equals(other$details)) {
                    $jacocoInit[30] = true;
                } else {
                    $jacocoInit[31] = true;
                    $jacocoInit[32] = true;
                    return false;
                }
                $jacocoInit[33] = true;
                return true;
            }
        }

        public int hashCode() {
            int i;
            int i2;
            boolean[] $jacocoInit = $jacocoInit();
            $jacocoInit[34] = true;
            String code2 = getCode();
            $jacocoInit[35] = true;
            int i3 = 1 * 59;
            int i4 = 43;
            if (code2 == null) {
                $jacocoInit[36] = true;
                i = 43;
            } else {
                i = code2.hashCode();
                $jacocoInit[37] = true;
            }
            int result = i3 + i;
            $jacocoInit[38] = true;
            String description2 = getDescription();
            $jacocoInit[39] = true;
            int i5 = result * 59;
            if (description2 == null) {
                $jacocoInit[40] = true;
                i2 = 43;
            } else {
                i2 = description2.hashCode();
                $jacocoInit[41] = true;
            }
            int result2 = i5 + i2;
            $jacocoInit[42] = true;
            Details details2 = getDetails();
            $jacocoInit[43] = true;
            int i6 = result2 * 59;
            if (details2 == null) {
                $jacocoInit[44] = true;
            } else {
                i4 = details2.hashCode();
                $jacocoInit[45] = true;
            }
            int result3 = i6 + i4;
            $jacocoInit[46] = true;
            return result3;
        }

        public String toString() {
            boolean[] $jacocoInit = $jacocoInit();
            StringBuilder sb = new StringBuilder();
            sb.append("BaseV7Response.Error(code=");
            $jacocoInit[47] = true;
            sb.append(getCode());
            sb.append(", description=");
            $jacocoInit[48] = true;
            sb.append(getDescription());
            sb.append(", details=");
            $jacocoInit[49] = true;
            sb.append(getDetails());
            sb.append(")");
            String sb2 = sb.toString();
            $jacocoInit[50] = true;
            return sb2;
        }
    }

    /* renamed from: cm.aptoide.pt.app.view.donations.data.BaseResponse$Info */
    static class Info {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private Status status;
        private Time time;

        /* renamed from: cm.aptoide.pt.app.view.donations.data.BaseResponse$Info$Status */
        enum Status {
            OK,
            QUEUED,
            FAIL,
            Processing;

            static {
                boolean[] $jacocoInit;
                $jacocoInit[3] = true;
            }
        }

        /* renamed from: cm.aptoide.pt.app.view.donations.data.BaseResponse$Info$Time */
        static class Time {
            private static transient /* synthetic */ boolean[] $jacocoData;
            private String human;
            private double seconds;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(6882211768875770L, "cm/aptoide/pt/app/view/donations/data/BaseResponse$Info$Time", 28);
                $jacocoData = probes;
                return probes;
            }

            Time() {
                $jacocoInit()[0] = true;
            }

            /* access modifiers changed from: 0000 */
            public double getSeconds() {
                boolean[] $jacocoInit = $jacocoInit();
                double d = this.seconds;
                $jacocoInit[1] = true;
                return d;
            }

            /* access modifiers changed from: 0000 */
            public void setSeconds(double seconds2) {
                boolean[] $jacocoInit = $jacocoInit();
                this.seconds = seconds2;
                $jacocoInit[2] = true;
            }

            /* access modifiers changed from: 0000 */
            public String getHuman() {
                boolean[] $jacocoInit = $jacocoInit();
                String str = this.human;
                $jacocoInit[3] = true;
                return str;
            }

            /* access modifiers changed from: 0000 */
            public void setHuman(String human2) {
                boolean[] $jacocoInit = $jacocoInit();
                this.human = human2;
                $jacocoInit[4] = true;
            }

            public boolean canEqual(Object other) {
                boolean z = other instanceof Time;
                $jacocoInit()[5] = true;
                return z;
            }

            public boolean equals(Object o) {
                boolean[] $jacocoInit = $jacocoInit();
                if (o == this) {
                    $jacocoInit[6] = true;
                    return true;
                } else if (!(o instanceof Time)) {
                    $jacocoInit[7] = true;
                    return false;
                } else {
                    Time other = (Time) o;
                    $jacocoInit[8] = true;
                    if (!other.canEqual(this)) {
                        $jacocoInit[9] = true;
                        return false;
                    } else if (Double.compare(getSeconds(), other.getSeconds()) != 0) {
                        $jacocoInit[10] = true;
                        return false;
                    } else {
                        String human2 = getHuman();
                        $jacocoInit[11] = true;
                        Object other$human = other.getHuman();
                        $jacocoInit[12] = true;
                        if (human2 == null) {
                            if (other$human == null) {
                                $jacocoInit[13] = true;
                            } else {
                                $jacocoInit[14] = true;
                                $jacocoInit[17] = true;
                                return false;
                            }
                        } else if (human2.equals(other$human)) {
                            $jacocoInit[15] = true;
                        } else {
                            $jacocoInit[16] = true;
                            $jacocoInit[17] = true;
                            return false;
                        }
                        $jacocoInit[18] = true;
                        return true;
                    }
                }
            }

            public int hashCode() {
                int i;
                boolean[] $jacocoInit = $jacocoInit();
                $jacocoInit[19] = true;
                long $seconds = Double.doubleToLongBits(getSeconds());
                int result = (1 * 59) + ((int) (($seconds >>> 32) ^ $seconds));
                $jacocoInit[20] = true;
                String human2 = getHuman();
                $jacocoInit[21] = true;
                int i2 = result * 59;
                if (human2 == null) {
                    i = 43;
                    $jacocoInit[22] = true;
                } else {
                    i = human2.hashCode();
                    $jacocoInit[23] = true;
                }
                int result2 = i2 + i;
                $jacocoInit[24] = true;
                return result2;
            }

            public String toString() {
                boolean[] $jacocoInit = $jacocoInit();
                StringBuilder sb = new StringBuilder();
                sb.append("BaseV7Response.Info.Time(seconds=");
                $jacocoInit[25] = true;
                sb.append(getSeconds());
                sb.append(", human=");
                $jacocoInit[26] = true;
                sb.append(getHuman());
                sb.append(")");
                String sb2 = sb.toString();
                $jacocoInit[27] = true;
                return sb2;
            }
        }

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-7190956132189359322L, "cm/aptoide/pt/app/view/donations/data/BaseResponse$Info", 36);
            $jacocoData = probes;
            return probes;
        }

        Info() {
            $jacocoInit()[0] = true;
        }

        Info(Status status2, Time time2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.status = status2;
            this.time = time2;
            $jacocoInit[1] = true;
        }

        /* access modifiers changed from: 0000 */
        public Status getStatus() {
            boolean[] $jacocoInit = $jacocoInit();
            Status status2 = this.status;
            $jacocoInit[2] = true;
            return status2;
        }

        /* access modifiers changed from: 0000 */
        public void setStatus(Status status2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.status = status2;
            $jacocoInit[3] = true;
        }

        /* access modifiers changed from: 0000 */
        public Time getTime() {
            boolean[] $jacocoInit = $jacocoInit();
            Time time2 = this.time;
            $jacocoInit[4] = true;
            return time2;
        }

        /* access modifiers changed from: 0000 */
        public void setTime(Time time2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.time = time2;
            $jacocoInit[5] = true;
        }

        public boolean canEqual(Object other) {
            boolean z = other instanceof Info;
            $jacocoInit()[6] = true;
            return z;
        }

        public boolean equals(Object o) {
            boolean[] $jacocoInit = $jacocoInit();
            if (o == this) {
                $jacocoInit[7] = true;
                return true;
            } else if (!(o instanceof Info)) {
                $jacocoInit[8] = true;
                return false;
            } else {
                Info other = (Info) o;
                $jacocoInit[9] = true;
                if (!other.canEqual(this)) {
                    $jacocoInit[10] = true;
                    return false;
                }
                Status status2 = getStatus();
                $jacocoInit[11] = true;
                Object other$status = other.getStatus();
                $jacocoInit[12] = true;
                if (status2 == null) {
                    if (other$status == null) {
                        $jacocoInit[13] = true;
                    } else {
                        $jacocoInit[14] = true;
                        $jacocoInit[17] = true;
                        return false;
                    }
                } else if (status2.equals(other$status)) {
                    $jacocoInit[15] = true;
                } else {
                    $jacocoInit[16] = true;
                    $jacocoInit[17] = true;
                    return false;
                }
                Time time2 = getTime();
                $jacocoInit[18] = true;
                Object other$time = other.getTime();
                $jacocoInit[19] = true;
                if (time2 == null) {
                    if (other$time == null) {
                        $jacocoInit[20] = true;
                    } else {
                        $jacocoInit[21] = true;
                        $jacocoInit[24] = true;
                        return false;
                    }
                } else if (time2.equals(other$time)) {
                    $jacocoInit[22] = true;
                } else {
                    $jacocoInit[23] = true;
                    $jacocoInit[24] = true;
                    return false;
                }
                $jacocoInit[25] = true;
                return true;
            }
        }

        public int hashCode() {
            int i;
            boolean[] $jacocoInit = $jacocoInit();
            $jacocoInit[26] = true;
            Status status2 = getStatus();
            $jacocoInit[27] = true;
            int i2 = 1 * 59;
            int i3 = 43;
            if (status2 == null) {
                $jacocoInit[28] = true;
                i = 43;
            } else {
                i = status2.hashCode();
                $jacocoInit[29] = true;
            }
            int result = i2 + i;
            $jacocoInit[30] = true;
            Time time2 = getTime();
            $jacocoInit[31] = true;
            int i4 = result * 59;
            if (time2 == null) {
                $jacocoInit[32] = true;
            } else {
                i3 = time2.hashCode();
                $jacocoInit[33] = true;
            }
            int result2 = i4 + i3;
            $jacocoInit[34] = true;
            return result2;
        }

        public String toString() {
            boolean[] $jacocoInit = $jacocoInit();
            StringBuilder sb = new StringBuilder();
            sb.append("BaseV7Response.Info(status=");
            sb.append(getStatus());
            sb.append(", time=");
            sb.append(getTime());
            sb.append(")");
            String sb2 = sb.toString();
            $jacocoInit[35] = true;
            return sb2;
        }
    }

    /* renamed from: cm.aptoide.pt.app.view.donations.data.BaseResponse$StoreLinks */
    static class StoreLinks {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private String error;
        private Type type;
        private String url;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(3473779118940013668L, "cm/aptoide/pt/app/view/donations/data/BaseResponse$StoreLinks", 51);
            $jacocoData = probes;
            return probes;
        }

        StoreLinks() {
            $jacocoInit()[0] = true;
        }

        /* access modifiers changed from: 0000 */
        public Type getType() {
            boolean[] $jacocoInit = $jacocoInit();
            Type type2 = this.type;
            $jacocoInit[1] = true;
            return type2;
        }

        /* access modifiers changed from: 0000 */
        public void setType(Type type2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.type = type2;
            $jacocoInit[2] = true;
        }

        /* access modifiers changed from: 0000 */
        public String getUrl() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.url;
            $jacocoInit[3] = true;
            return str;
        }

        /* access modifiers changed from: 0000 */
        public void setUrl(String url2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.url = url2;
            $jacocoInit[4] = true;
        }

        /* access modifiers changed from: 0000 */
        public String getError() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.error;
            $jacocoInit[5] = true;
            return str;
        }

        /* access modifiers changed from: 0000 */
        public void setError(String error2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.error = error2;
            $jacocoInit[6] = true;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            boolean z = other instanceof StoreLinks;
            $jacocoInit()[7] = true;
            return z;
        }

        public boolean equals(Object o) {
            boolean[] $jacocoInit = $jacocoInit();
            if (o == this) {
                $jacocoInit[8] = true;
                return true;
            } else if (!(o instanceof StoreLinks)) {
                $jacocoInit[9] = true;
                return false;
            } else {
                StoreLinks other = (StoreLinks) o;
                $jacocoInit[10] = true;
                if (!other.canEqual(this)) {
                    $jacocoInit[11] = true;
                    return false;
                }
                Type type2 = getType();
                $jacocoInit[12] = true;
                Object other$type = other.getType();
                $jacocoInit[13] = true;
                if (type2 == null) {
                    if (other$type == null) {
                        $jacocoInit[14] = true;
                    } else {
                        $jacocoInit[15] = true;
                        $jacocoInit[18] = true;
                        return false;
                    }
                } else if (type2.equals(other$type)) {
                    $jacocoInit[16] = true;
                } else {
                    $jacocoInit[17] = true;
                    $jacocoInit[18] = true;
                    return false;
                }
                String url2 = getUrl();
                $jacocoInit[19] = true;
                Object other$url = other.getUrl();
                $jacocoInit[20] = true;
                if (url2 == null) {
                    if (other$url == null) {
                        $jacocoInit[21] = true;
                    } else {
                        $jacocoInit[22] = true;
                        $jacocoInit[25] = true;
                        return false;
                    }
                } else if (url2.equals(other$url)) {
                    $jacocoInit[23] = true;
                } else {
                    $jacocoInit[24] = true;
                    $jacocoInit[25] = true;
                    return false;
                }
                String error2 = getError();
                $jacocoInit[26] = true;
                Object other$error = other.getError();
                $jacocoInit[27] = true;
                if (error2 == null) {
                    if (other$error == null) {
                        $jacocoInit[28] = true;
                    } else {
                        $jacocoInit[29] = true;
                        $jacocoInit[32] = true;
                        return false;
                    }
                } else if (error2.equals(other$error)) {
                    $jacocoInit[30] = true;
                } else {
                    $jacocoInit[31] = true;
                    $jacocoInit[32] = true;
                    return false;
                }
                $jacocoInit[33] = true;
                return true;
            }
        }

        public int hashCode() {
            int i;
            int i2;
            boolean[] $jacocoInit = $jacocoInit();
            $jacocoInit[34] = true;
            Type type2 = getType();
            $jacocoInit[35] = true;
            int i3 = 1 * 59;
            int i4 = 43;
            if (type2 == null) {
                $jacocoInit[36] = true;
                i = 43;
            } else {
                i = type2.hashCode();
                $jacocoInit[37] = true;
            }
            int result = i3 + i;
            $jacocoInit[38] = true;
            String url2 = getUrl();
            $jacocoInit[39] = true;
            int i5 = result * 59;
            if (url2 == null) {
                $jacocoInit[40] = true;
                i2 = 43;
            } else {
                i2 = url2.hashCode();
                $jacocoInit[41] = true;
            }
            int result2 = i5 + i2;
            $jacocoInit[42] = true;
            String error2 = getError();
            $jacocoInit[43] = true;
            int i6 = result2 * 59;
            if (error2 == null) {
                $jacocoInit[44] = true;
            } else {
                i4 = error2.hashCode();
                $jacocoInit[45] = true;
            }
            int result3 = i6 + i4;
            $jacocoInit[46] = true;
            return result3;
        }

        public String toString() {
            boolean[] $jacocoInit = $jacocoInit();
            StringBuilder sb = new StringBuilder();
            sb.append("BaseV7Response.StoreLinks(type=");
            $jacocoInit[47] = true;
            sb.append(getType());
            sb.append(", url=");
            $jacocoInit[48] = true;
            sb.append(getUrl());
            sb.append(", error=");
            $jacocoInit[49] = true;
            sb.append(getError());
            sb.append(")");
            String sb2 = sb.toString();
            $jacocoInit[50] = true;
            return sb2;
        }
    }

    /* renamed from: cm.aptoide.pt.app.view.donations.data.BaseResponse$Type */
    enum Type {
        FACEBOOK_1,
        FACEBOOK_2,
        TWITCH_1,
        TWITCH_2,
        TWITTER_1,
        TWITTER_2,
        YOUTUBE_1,
        YOUTUBE_2;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8864472197597246625L, "cm/aptoide/pt/app/view/donations/data/BaseResponse", 45);
        $jacocoData = probes;
        return probes;
    }

    BaseResponse() {
        $jacocoInit()[0] = true;
    }

    public Error getError() {
        boolean[] $jacocoInit = $jacocoInit();
        List<Error> list = this.errors;
        if (list == null) {
            $jacocoInit[1] = true;
        } else if (list.size() <= 0) {
            $jacocoInit[2] = true;
        } else {
            $jacocoInit[3] = true;
            Error error = (Error) this.errors.get(0);
            $jacocoInit[4] = true;
            return error;
        }
        $jacocoInit[5] = true;
        return null;
    }

    /* access modifiers changed from: 0000 */
    public boolean isOk() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        Info info2 = this.info;
        if (info2 == null) {
            $jacocoInit[6] = true;
        } else if (info2.getStatus() != Status.OK) {
            $jacocoInit[7] = true;
        } else {
            $jacocoInit[8] = true;
            z = true;
            $jacocoInit[10] = true;
            return z;
        }
        z = false;
        $jacocoInit[9] = true;
        $jacocoInit[10] = true;
        return z;
    }

    /* access modifiers changed from: 0000 */
    public Info getInfo() {
        boolean[] $jacocoInit = $jacocoInit();
        Info info2 = this.info;
        $jacocoInit[11] = true;
        return info2;
    }

    /* access modifiers changed from: 0000 */
    public void setInfo(Info info2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.info = info2;
        $jacocoInit[12] = true;
    }

    /* access modifiers changed from: 0000 */
    public List<Error> getErrors() {
        boolean[] $jacocoInit = $jacocoInit();
        List<Error> list = this.errors;
        $jacocoInit[13] = true;
        return list;
    }

    /* access modifiers changed from: 0000 */
    public void setErrors(List<Error> errors2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.errors = errors2;
        $jacocoInit[14] = true;
    }

    public int hashCode() {
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[15] = true;
        Info info2 = getInfo();
        $jacocoInit[16] = true;
        int i2 = 1 * 59;
        int i3 = 43;
        if (info2 == null) {
            $jacocoInit[17] = true;
            i = 43;
        } else {
            i = info2.hashCode();
            $jacocoInit[18] = true;
        }
        int result = i2 + i;
        $jacocoInit[19] = true;
        Object $errors = getErrors();
        $jacocoInit[20] = true;
        int i4 = result * 59;
        if ($errors == null) {
            $jacocoInit[21] = true;
        } else {
            i3 = $errors.hashCode();
            $jacocoInit[22] = true;
        }
        int result2 = i4 + i3;
        $jacocoInit[23] = true;
        return result2;
    }

    public boolean canEqual(Object other) {
        boolean z = other instanceof BaseResponse;
        $jacocoInit()[24] = true;
        return z;
    }

    public boolean equals(Object o) {
        boolean[] $jacocoInit = $jacocoInit();
        if (o == this) {
            $jacocoInit[25] = true;
            return true;
        } else if (!(o instanceof BaseResponse)) {
            $jacocoInit[26] = true;
            return false;
        } else {
            BaseResponse other = (BaseResponse) o;
            $jacocoInit[27] = true;
            if (!other.canEqual(this)) {
                $jacocoInit[28] = true;
                return false;
            }
            Info info2 = getInfo();
            $jacocoInit[29] = true;
            Object other$info = other.getInfo();
            $jacocoInit[30] = true;
            if (info2 == null) {
                if (other$info == null) {
                    $jacocoInit[31] = true;
                } else {
                    $jacocoInit[32] = true;
                    $jacocoInit[35] = true;
                    return false;
                }
            } else if (info2.equals(other$info)) {
                $jacocoInit[33] = true;
            } else {
                $jacocoInit[34] = true;
                $jacocoInit[35] = true;
                return false;
            }
            Object this$errors = getErrors();
            $jacocoInit[36] = true;
            Object other$errors = other.getErrors();
            $jacocoInit[37] = true;
            if (this$errors == null) {
                if (other$errors == null) {
                    $jacocoInit[38] = true;
                } else {
                    $jacocoInit[39] = true;
                    $jacocoInit[42] = true;
                    return false;
                }
            } else if (this$errors.equals(other$errors)) {
                $jacocoInit[40] = true;
            } else {
                $jacocoInit[41] = true;
                $jacocoInit[42] = true;
                return false;
            }
            $jacocoInit[43] = true;
            return true;
        }
    }

    public String toString() {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append("BaseV7Response(info=");
        sb.append(getInfo());
        sb.append(", errors=");
        sb.append(getErrors());
        sb.append(")");
        String sb2 = sb.toString();
        $jacocoInit[44] = true;
        return sb2;
    }
}
