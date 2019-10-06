package p005cm.aptoide.p006pt.dataprovider.model.p009v7;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.File;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.AppCoinsCampaign */
public class AppCoinsCampaign {
    private CampaignApp app;

    /* renamed from: id */
    private String f6083id;
    private String reward;

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.AppCoinsCampaign$CampaignApp */
    public static class CampaignApp {
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
        private Date added;
        private AppCoinsCampaignInfo appcoins;
        private File file;
        private String graphic;
        private boolean hasVersions;
        private String icon;

        /* renamed from: id */
        private long f43id;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
        private Date modified;
        private String name;
        private Obb obb;
        @JsonProperty("package")
        private String packageName;
        private long size;
        private Stats stats;
        private Store store;
        private String uname;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
        private Date updated;
        private String uptype;

        /* renamed from: cm.aptoide.pt.dataprovider.model.v7.AppCoinsCampaign$CampaignApp$AppCoinsCampaignInfo */
        public static class AppCoinsCampaignInfo {
            private boolean advertising;
            private ClickUrls clicks;

            /* renamed from: cm.aptoide.pt.dataprovider.model.v7.AppCoinsCampaign$CampaignApp$AppCoinsCampaignInfo$ClickUrls */
            public static class ClickUrls {
                private String click;
                private String download;

                public String getDownload() {
                    return this.download;
                }

                public void setDownload(String download2) {
                    this.download = download2;
                }

                public String getClick() {
                    return this.click;
                }

                public void setClick(String click2) {
                    this.click = click2;
                }
            }

            public boolean hasAdvertising() {
                return this.advertising;
            }

            public void setAdvertising(boolean advertising2) {
                this.advertising = advertising2;
            }

            public ClickUrls getClicks() {
                return this.clicks;
            }

            public void setClicks(ClickUrls clicks2) {
                this.clicks = clicks2;
            }
        }

        /* renamed from: cm.aptoide.pt.dataprovider.model.v7.AppCoinsCampaign$CampaignApp$Stats */
        public static class Stats {
            private int downloads;
            private int pdownloads;
            private Rating prating;
            private Rating rating;

            /* renamed from: cm.aptoide.pt.dataprovider.model.v7.AppCoinsCampaign$CampaignApp$Stats$Rating */
            public static class Rating {
                private float avg;
                private int total;

                public float getAvg() {
                    return this.avg;
                }

                public void setAvg(float avg2) {
                    this.avg = avg2;
                }

                public int getTotal() {
                    return this.total;
                }

                public void setTotal(int total2) {
                    this.total = total2;
                }
            }

            public int getDownloads() {
                return this.downloads;
            }

            public void setDownloads(int downloads2) {
                this.downloads = downloads2;
            }

            public int getPdownloads() {
                return this.pdownloads;
            }

            public void setPdownloads(int pdownloads2) {
                this.pdownloads = pdownloads2;
            }

            public Rating getRating() {
                return this.rating;
            }

            public void setRating(Rating rating2) {
                this.rating = rating2;
            }

            public Rating getPrating() {
                return this.prating;
            }

            public void setPrating(Rating prating2) {
                this.prating = prating2;
            }
        }

        public long getId() {
            return this.f43id;
        }

        public void setId(long id) {
            this.f43id = id;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name2) {
            this.name = name2;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public void setPackageName(String packageName2) {
            this.packageName = packageName2;
        }

        public String getUname() {
            return this.uname;
        }

        public void setUname(String uname2) {
            this.uname = uname2;
        }

        public long getSize() {
            return this.size;
        }

        public void setSize(long size2) {
            this.size = size2;
        }

        public String getIcon() {
            return this.icon;
        }

        public void setIcon(String icon2) {
            this.icon = icon2;
        }

        public String getGraphic() {
            return this.graphic;
        }

        public void setGraphic(String graphic2) {
            this.graphic = graphic2;
        }

        public Date getAdded() {
            return this.added;
        }

        public void setAdded(Date added2) {
            this.added = added2;
        }

        public Date getModified() {
            return this.modified;
        }

        public void setModified(Date modified2) {
            this.modified = modified2;
        }

        public Date getUpdated() {
            return this.updated;
        }

        public void setUpdated(Date updated2) {
            this.updated = updated2;
        }

        public String getUptype() {
            return this.uptype;
        }

        public void setUptype(String uptype2) {
            this.uptype = uptype2;
        }

        public Store getStore() {
            return this.store;
        }

        public void setStore(Store store2) {
            this.store = store2;
        }

        public File getFile() {
            return this.file;
        }

        public void setFile(File file2) {
            this.file = file2;
        }

        public boolean isHasVersions() {
            return this.hasVersions;
        }

        public void setHasVersions(boolean hasVersions2) {
            this.hasVersions = hasVersions2;
        }

        public Obb getObb() {
            return this.obb;
        }

        public void setObb(Obb obb2) {
            this.obb = obb2;
        }

        public Stats getStats() {
            return this.stats;
        }

        public void setStats(Stats stats2) {
            this.stats = stats2;
        }

        public AppCoinsCampaignInfo getAppcoins() {
            return this.appcoins;
        }

        public void setAppcoins(AppCoinsCampaignInfo appcoins2) {
            this.appcoins = appcoins2;
        }
    }

    public String getId() {
        return this.f6083id;
    }

    public void setId(String id) {
        this.f6083id = id;
    }

    public String getReward() {
        return this.reward;
    }

    public void setReward(String reward2) {
        this.reward = reward2;
    }

    public CampaignApp getApp() {
        return this.app;
    }

    public void setApp(CampaignApp app2) {
        this.app = app2;
    }
}
