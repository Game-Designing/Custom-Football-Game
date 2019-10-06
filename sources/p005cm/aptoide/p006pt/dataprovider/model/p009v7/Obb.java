package p005cm.aptoide.p006pt.dataprovider.model.p009v7;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.Obb */
public class Obb {
    private ObbItem main;
    private ObbItem patch;

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.Obb$ObbItem */
    public static class ObbItem {
        private String filename;
        private long filesize;
        private String md5sum;
        private String path;

        public String getPath() {
            return this.path;
        }

        public void setPath(String path2) {
            this.path = path2;
        }

        public String getMd5sum() {
            return this.md5sum;
        }

        public void setMd5sum(String md5sum2) {
            this.md5sum = md5sum2;
        }

        public long getFilesize() {
            return this.filesize;
        }

        public void setFilesize(long filesize2) {
            this.filesize = filesize2;
        }

        public String getFilename() {
            return this.filename;
        }

        public void setFilename(String filename2) {
            this.filename = filename2;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof ObbItem;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof ObbItem)) {
                return false;
            }
            ObbItem other = (ObbItem) o;
            if (!other.canEqual(this)) {
                return false;
            }
            String path2 = getPath();
            Object other$path = other.getPath();
            if (path2 != null ? !path2.equals(other$path) : other$path != null) {
                return false;
            }
            String md5sum2 = getMd5sum();
            Object other$md5sum = other.getMd5sum();
            if (md5sum2 != null ? !md5sum2.equals(other$md5sum) : other$md5sum != null) {
                return false;
            }
            if (getFilesize() != other.getFilesize()) {
                return false;
            }
            String filename2 = getFilename();
            Object other$filename = other.getFilename();
            if (filename2 != null ? filename2.equals(other$filename) : other$filename == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            String path2 = getPath();
            int i = 43;
            int result = (1 * 59) + (path2 == null ? 43 : path2.hashCode());
            String md5sum2 = getMd5sum();
            int result2 = (result * 59) + (md5sum2 == null ? 43 : md5sum2.hashCode());
            long $filesize = getFilesize();
            int result3 = (result2 * 59) + ((int) (($filesize >>> 32) ^ $filesize));
            String filename2 = getFilename();
            int i2 = result3 * 59;
            if (filename2 != null) {
                i = filename2.hashCode();
            }
            return i2 + i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Obb.ObbItem(path=");
            sb.append(getPath());
            sb.append(", md5sum=");
            sb.append(getMd5sum());
            sb.append(", filesize=");
            sb.append(getFilesize());
            sb.append(", filename=");
            sb.append(getFilename());
            sb.append(")");
            return sb.toString();
        }
    }

    public ObbItem getPatch() {
        return this.patch;
    }

    public void setPatch(ObbItem patch2) {
        this.patch = patch2;
    }

    public ObbItem getMain() {
        return this.main;
    }

    public void setMain(ObbItem main2) {
        this.main = main2;
    }

    public int hashCode() {
        ObbItem patch2 = getPatch();
        int i = 43;
        int result = (1 * 59) + (patch2 == null ? 43 : patch2.hashCode());
        ObbItem main2 = getMain();
        int i2 = result * 59;
        if (main2 != null) {
            i = main2.hashCode();
        }
        return i2 + i;
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof Obb;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Obb)) {
            return false;
        }
        Obb other = (Obb) o;
        if (!other.canEqual(this)) {
            return false;
        }
        ObbItem patch2 = getPatch();
        Object other$patch = other.getPatch();
        if (patch2 != null ? !patch2.equals(other$patch) : other$patch != null) {
            return false;
        }
        ObbItem main2 = getMain();
        Object other$main = other.getMain();
        if (main2 != null ? main2.equals(other$main) : other$main == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Obb(patch=");
        sb.append(getPatch());
        sb.append(", main=");
        sb.append(getMain());
        sb.append(")");
        return sb.toString();
    }
}
