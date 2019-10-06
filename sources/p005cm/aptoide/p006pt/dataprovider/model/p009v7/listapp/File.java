package p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Malware;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.listapp.File */
public class File {
    private long filesize;
    private Malware malware;
    private String md5sum;
    private String path;
    private String pathAlt;
    private int vercode;
    private String vername;

    public String getVername() {
        return this.vername;
    }

    public void setVername(String vername2) {
        this.vername = vername2;
    }

    public int getVercode() {
        return this.vercode;
    }

    public void setVercode(int vercode2) {
        this.vercode = vercode2;
    }

    public String getMd5sum() {
        return this.md5sum;
    }

    public void setMd5sum(String md5sum2) {
        this.md5sum = md5sum2;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path2) {
        this.path = path2;
    }

    public String getPathAlt() {
        return this.pathAlt;
    }

    public void setPathAlt(String pathAlt2) {
        this.pathAlt = pathAlt2;
    }

    public long getFilesize() {
        return this.filesize;
    }

    public void setFilesize(long filesize2) {
        this.filesize = filesize2;
    }

    public Malware getMalware() {
        return this.malware;
    }

    public void setMalware(Malware malware2) {
        this.malware = malware2;
    }

    public int hashCode() {
        String vername2 = getVername();
        int i = 43;
        int result = (((1 * 59) + (vername2 == null ? 43 : vername2.hashCode())) * 59) + getVercode();
        String md5sum2 = getMd5sum();
        int result2 = (result * 59) + (md5sum2 == null ? 43 : md5sum2.hashCode());
        String path2 = getPath();
        int result3 = (result2 * 59) + (path2 == null ? 43 : path2.hashCode());
        String pathAlt2 = getPathAlt();
        int result4 = (result3 * 59) + (pathAlt2 == null ? 43 : pathAlt2.hashCode());
        long $filesize = getFilesize();
        int result5 = (result4 * 59) + ((int) (($filesize >>> 32) ^ $filesize));
        Malware malware2 = getMalware();
        int i2 = result5 * 59;
        if (malware2 != null) {
            i = malware2.hashCode();
        }
        return i2 + i;
    }

    public boolean equals(Object o) {
        Object obj = o;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof File)) {
            return false;
        }
        File other = (File) obj;
        if (!other.canEqual(this)) {
            return false;
        }
        String vername2 = getVername();
        Object other$vername = other.getVername();
        if (vername2 != null ? !vername2.equals(other$vername) : other$vername != null) {
            return false;
        }
        if (getVercode() != other.getVercode()) {
            return false;
        }
        String md5sum2 = getMd5sum();
        Object other$md5sum = other.getMd5sum();
        if (md5sum2 != null ? !md5sum2.equals(other$md5sum) : other$md5sum != null) {
            return false;
        }
        String path2 = getPath();
        Object other$path = other.getPath();
        if (path2 != null ? !path2.equals(other$path) : other$path != null) {
            return false;
        }
        String pathAlt2 = getPathAlt();
        Object other$pathAlt = other.getPathAlt();
        if (pathAlt2 != null ? !pathAlt2.equals(other$pathAlt) : other$pathAlt != null) {
            return false;
        }
        if (getFilesize() != other.getFilesize()) {
            return false;
        }
        Malware malware2 = getMalware();
        Object other$malware = other.getMalware();
        if (malware2 != null ? malware2.equals(other$malware) : other$malware == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("File(vername=");
        sb.append(getVername());
        sb.append(", vercode=");
        sb.append(getVercode());
        sb.append(", md5sum=");
        sb.append(getMd5sum());
        sb.append(", path=");
        sb.append(getPath());
        sb.append(", pathAlt=");
        sb.append(getPathAlt());
        sb.append(", filesize=");
        sb.append(getFilesize());
        sb.append(", malware=");
        sb.append(getMalware());
        sb.append(")");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof File;
    }
}
