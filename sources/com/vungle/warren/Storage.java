package com.vungle.warren;

import android.util.Log;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Advertisement.State;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.model.Placement;
import com.vungle.warren.model.Report;
import com.vungle.warren.persistence.Designer;
import com.vungle.warren.persistence.Memorable;
import com.vungle.warren.persistence.Persistor;
import com.vungle.warren.persistence.Persistor.MigrationCallback;
import com.vungle.warren.persistence.Persistor.Transformation;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Storage {
    public static final int DB_VERSION = 1;
    private static final String TAG = Storage.class.getSimpleName();
    private final Map<String, Advertisement> advMap = new ConcurrentHashMap();
    private final Designer designer;
    /* access modifiers changed from: private */
    public final Persistor persistor;
    private final Map<String, Placement> placementsMap = new ConcurrentHashMap();
    private List<String> validPlacements = new ArrayList();

    private class Migrator implements MigrationCallback {
        private Migrator() {
        }

        public void onUpgrade(int oldVersion, int newVersion) {
            if (oldVersion < 1) {
                Storage.this.persistor.migrateData(oldVersion, newVersion, Report.class, new Transformation<Report>() {
                    public Report transform(int oldVersion, int newVersion, byte[] data) {
                        return Report.restore(oldVersion, newVersion, data);
                    }
                });
                Storage.this.persistor.migrateData(oldVersion, newVersion, Cookie.class, new Transformation<Cookie>() {
                    public Cookie transform(int oldVersion, int newVersion, byte[] data) {
                        return Cookie.restore(oldVersion, newVersion, data);
                    }
                });
                Storage.this.persistor.migrateData(oldVersion, newVersion, Placement.class, new Transformation<Placement>() {
                    public Placement transform(int oldVersion, int newVersion, byte[] data) {
                        Placement placement = Placement.restore(oldVersion, newVersion, data);
                        if (placement != null) {
                            for (String advId : placement.getAdvertisementIDs()) {
                                placement.removeAdvertisementID(advId);
                            }
                        }
                        return placement;
                    }
                });
                Storage.this.persistor.migrateData(oldVersion, newVersion, Advertisement.class, new Transformation<Advertisement>() {
                    public Advertisement transform(int oldVersion, int newVersion, byte[] data) {
                        return null;
                    }
                });
            }
        }

        public void onDowngrade(int oldVersion, int newVersion) {
            Storage.this.clearAllData();
        }
    }

    private Storage(Persistor persistor2, Designer designer2) {
        this.persistor = persistor2;
        this.designer = designer2;
    }

    static Storage makeInstance(Persistor persistor2, Designer designer2) {
        return new Storage(persistor2, designer2);
    }

    public void init(int version) {
        this.placementsMap.clear();
        this.advMap.clear();
        this.persistor.init(version, new Migrator());
        List<Advertisement> advs = this.persistor.extractAll(Advertisement.class);
        if (advs != null && advs.size() > 0) {
            for (Advertisement adv : advs) {
                if (adv != null) {
                    if (adv.getState() == 2) {
                        adv.setState(3);
                        save(adv);
                        String str = TAG;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Advertisement ");
                        sb.append(adv.getId());
                        sb.append(" state marked as DONE, it stuck in VIEWING state");
                        Log.i(str, sb.toString());
                    } else if (adv.getState() == 1 && !hasValidAssets(adv)) {
                        delete(adv);
                        try {
                            this.designer.deleteAssets(adv.getId());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public void save(Memorable memorable) {
        if (memorable instanceof Placement) {
            this.placementsMap.put(memorable.getId(), (Placement) memorable);
        } else if (memorable instanceof Advertisement) {
            this.advMap.put(memorable.getId(), (Advertisement) memorable);
        }
        this.persistor.save(memorable);
    }

    public <T extends Memorable> T load(String id, Class<T> clazz) {
        Advertisement advertisement;
        Placement placement;
        if (Placement.class.isAssignableFrom(clazz)) {
            Placement placement2 = (Placement) this.placementsMap.get(id);
            if (placement2 != null) {
                placement = placement2.copy();
            } else {
                placement = (Placement) this.persistor.find(id, clazz);
                if (placement != null) {
                    this.placementsMap.put(id, placement);
                }
            }
            return placement;
        } else if (!Advertisement.class.isAssignableFrom(clazz)) {
            return this.persistor.find(id, clazz);
        } else {
            Advertisement advertisement2 = (Advertisement) this.advMap.get(id);
            if (advertisement2 != null) {
                advertisement = advertisement2.copy();
            } else {
                advertisement = (Advertisement) this.persistor.find(id, clazz);
                if (advertisement != null) {
                    this.advMap.put(id, advertisement);
                }
            }
            return advertisement;
        }
    }

    public <T extends Memorable> List<T> loadAll(Class<T> clazz) {
        return this.persistor.extractAll(clazz);
    }

    public void delete(Memorable memorable) {
        if (memorable instanceof Placement) {
            this.placementsMap.remove(memorable.getId());
        } else if (memorable instanceof Advertisement) {
            this.advMap.remove(memorable.getId());
        }
        this.persistor.delete(memorable);
    }

    public Advertisement findValidAdvertisementForPlacement(String placementId) {
        String str;
        Placement placement = (Placement) load(placementId, Placement.class);
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        String str3 = " Searching for valid adv for pl ";
        sb.append(str3);
        sb.append(placementId);
        Log.i(str2, sb.toString());
        if (placement == null || placement.getAdvertisementIDs() == null || placement.getAdvertisementIDs().isEmpty()) {
            return null;
        }
        String str4 = TAG;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str3);
        sb2.append(placementId);
        sb2.append(" all ids ");
        sb2.append(placement.getAdvertisementIDs());
        Log.i(str4, sb2.toString());
        Advertisement result = null;
        Iterator it = placement.getAdvertisementIDs().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Advertisement advertisement = (Advertisement) load((String) it.next(), Advertisement.class);
            if (advertisement != null) {
                boolean isNotExpired = false;
                boolean stateMatches = advertisement.getState() == 1 || advertisement.getState() == 0;
                if (advertisement.getExpireTime() > System.currentTimeMillis()) {
                    isNotExpired = true;
                }
                if (isNotExpired && stateMatches) {
                    result = advertisement;
                    break;
                }
            }
        }
        String str5 = TAG;
        if (result == null) {
            str = "Didn't find valid adv";
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Found valid adv ");
            sb3.append(result.getId());
            str = sb3.toString();
        }
        Log.i(str5, str);
        return result;
    }

    public boolean hasValidAssets(Advertisement advertisement) {
        return this.designer.hasAssetsFor(advertisement.getId(), advertisement.getDownloadableUrls().size());
    }

    public synchronized void setValidPlacements(List<Placement> placements) {
        this.validPlacements.clear();
        for (Placement placement : placements) {
            Placement disk = (Placement) load(placement.getId(), Placement.class);
            if (disk != null && !disk.equalsIgnoreAdvertisements(placement)) {
                String str = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("Placements data for ");
                sb.append(placement.getId());
                sb.append(" is different from disc, deleting old");
                Log.w(str, sb.toString());
                try {
                    for (String id : placement.getAdvertisementIDs()) {
                        Advertisement advertisement = (Advertisement) load(id, Advertisement.class);
                        if (advertisement != null) {
                            delete(advertisement);
                        }
                        this.designer.deleteAssets(id);
                    }
                    delete(disk);
                } catch (IOException e) {
                    Log.e("Vungle", "Failed to delete old assets, this could lead to disk space errors");
                    Log.e("Vungle", e.getMessage());
                }
            } else if (disk != null) {
                placement = disk;
            }
            save(placement);
            this.validPlacements.add(placement.getId());
        }
    }

    public void saveAndApplyState(Advertisement advertisement, String placementId, @State int state) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Setting ");
        sb.append(state);
        sb.append(" for adv ");
        sb.append(advertisement.getId());
        sb.append(" and pl ");
        sb.append(placementId);
        Log.i(str, sb.toString());
        advertisement.setState(state);
        save(advertisement);
        String advertisementId = advertisement.getId();
        if (state == 0 || state == 1) {
            addAdvertisementToPlacement(placementId, advertisementId);
        } else if (state == 2) {
            removeAdvertisementFromPlacement(placementId, advertisementId);
        } else if (state == 3 || state == 4) {
            removeAdvertisementFromPlacement(placementId, advertisementId);
            delete(advertisement);
            try {
                this.designer.deleteAssets(advertisementId);
            } catch (IOException ex) {
                String str2 = TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("error on deleting assets for ");
                sb2.append(advertisement.getId());
                Log.e(str2, sb2.toString(), ex);
            }
        }
    }

    public void clearAllData() {
        this.designer.clearCache();
        this.persistor.clearCache();
        this.advMap.clear();
        this.placementsMap.clear();
        Log.d(TAG, "Cache cleared.");
    }

    public synchronized Collection<Placement> loadValidPlacements() {
        List<Placement> placements;
        placements = new ArrayList<>();
        for (String id : this.validPlacements) {
            Placement placement = (Placement) load(id, Placement.class);
            if (placement != null) {
                placements.add(placement.copy());
            }
        }
        return placements;
    }

    public synchronized Collection<String> getValidPlacements() {
        return new ArrayList(this.validPlacements);
    }

    public File getAdvertisementAssetDirectory(String id) {
        return this.designer.getAssetDirectory(id);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void removeAdvertisementFromPlacement(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.Class<com.vungle.warren.model.Placement> r0 = com.vungle.warren.model.Placement.class
            com.vungle.warren.persistence.Memorable r0 = r2.load(r3, r0)     // Catch:{ all -> 0x001c }
            com.vungle.warren.model.Placement r0 = (com.vungle.warren.model.Placement) r0     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x001a
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x001c }
            if (r1 == 0) goto L_0x0012
            goto L_0x001a
        L_0x0012:
            r0.removeAdvertisementID(r4)     // Catch:{ all -> 0x001c }
            r2.save(r0)     // Catch:{ all -> 0x001c }
            monitor-exit(r2)
            return
        L_0x001a:
            monitor-exit(r2)
            return
        L_0x001c:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.Storage.removeAdvertisementFromPlacement(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void addAdvertisementToPlacement(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.Class<com.vungle.warren.model.Placement> r0 = com.vungle.warren.model.Placement.class
            com.vungle.warren.persistence.Memorable r0 = r2.load(r3, r0)     // Catch:{ all -> 0x001c }
            com.vungle.warren.model.Placement r0 = (com.vungle.warren.model.Placement) r0     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x001a
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x001c }
            if (r1 == 0) goto L_0x0012
            goto L_0x001a
        L_0x0012:
            r0.addAdvertisementID(r4)     // Catch:{ all -> 0x001c }
            r2.save(r0)     // Catch:{ all -> 0x001c }
            monitor-exit(r2)
            return
        L_0x001a:
            monitor-exit(r2)
            return
        L_0x001c:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.Storage.addAdvertisementToPlacement(java.lang.String, java.lang.String):void");
    }
}
