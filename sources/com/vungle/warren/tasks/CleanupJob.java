package com.vungle.warren.tasks;

import android.os.Bundle;
import android.util.Log;
import com.vungle.warren.Storage;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Placement;
import com.vungle.warren.persistence.Designer;
import com.vungle.warren.utility.FileUtility;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class CleanupJob implements Job {
    static final String TAG = CleanupJob.class.getCanonicalName();
    private Designer designer;
    private Storage storage;

    CleanupJob(Designer designer2, Storage storage2) {
        this.designer = designer2;
        this.storage = storage2;
    }

    public int onRunJob(Bundle bundle, JobRunner jobRunner) {
        File[] assets;
        File[] assets2;
        boolean z = true;
        if (this.designer == null) {
            JobRunner jobRunner2 = jobRunner;
        } else if (this.storage == null) {
            JobRunner jobRunner3 = jobRunner;
        } else {
            Log.d(TAG, "CleanupJob: Current directory snapshot");
            FileUtility.printDirectoryTree(this.designer.getCacheDirectory());
            File[] assets3 = this.designer.getCacheDirectory().listFiles();
            List<Advertisement> cachedAdvs = this.storage.loadAll(Advertisement.class);
            List<Placement> cachedPlacements = this.storage.loadAll(Placement.class);
            char c = 0;
            if (cachedPlacements.size() == 0) {
                return 0;
            }
            Collection<Placement> validPlacements = this.storage.loadValidPlacements();
            Set<String> validIds = new HashSet<>();
            for (Placement p : cachedPlacements) {
                if (validPlacements.isEmpty() || validPlacements.contains(p)) {
                    for (String advertisementId : p.getAdvertisementIDs()) {
                        Advertisement advertisement = (Advertisement) this.storage.load(advertisementId, Advertisement.class);
                        if (advertisement != null) {
                            if (advertisement.getExpireTime() > System.currentTimeMillis()) {
                                JobRunner jobRunner4 = jobRunner;
                                assets2 = assets3;
                            } else if (advertisement.getState() != 2) {
                                this.storage.removeAdvertisementFromPlacement(p.getId(), advertisementId);
                                try {
                                    this.designer.deleteAssets(advertisement.getId());
                                } catch (IOException e) {
                                    Log.e(TAG, Log.getStackTraceString(e));
                                }
                                this.storage.delete(advertisement);
                                if (p.isAutoCached()) {
                                    assets2 = assets3;
                                    jobRunner.execute(DownloadJob.makeJobInfo(p.getId(), z).setDelay(1000));
                                } else {
                                    JobRunner jobRunner5 = jobRunner;
                                    assets2 = assets3;
                                }
                            } else {
                                JobRunner jobRunner6 = jobRunner;
                                assets2 = assets3;
                            }
                            validIds.add(advertisement.getId());
                            String str = TAG;
                            StringBuilder sb = new StringBuilder();
                            sb.append("setting valid adv ");
                            sb.append(advertisementId);
                            sb.append(" for placement ");
                            sb.append(p.getId());
                            Log.w(str, sb.toString());
                        } else {
                            JobRunner jobRunner7 = jobRunner;
                            assets2 = assets3;
                            String str2 = TAG;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("removing adv ");
                            sb2.append(advertisementId);
                            sb2.append(" from placement ");
                            sb2.append(p.getId());
                            Log.w(str2, sb2.toString());
                            this.storage.removeAdvertisementFromPlacement(p.getId(), advertisementId);
                        }
                        assets3 = assets2;
                        z = true;
                    }
                } else {
                    String str3 = TAG;
                    Locale locale = Locale.ENGLISH;
                    Object[] objArr = new Object[(z ? 1 : 0)];
                    objArr[c] = p.getId();
                    Log.d(str3, String.format(locale, "Placement %s is no longer valid, deleting it and its advertisement", objArr));
                    this.storage.delete(p);
                }
                JobRunner jobRunner8 = jobRunner;
                assets3 = assets3;
                z = true;
                c = 0;
            }
            JobRunner jobRunner9 = jobRunner;
            File[] assets4 = assets3;
            for (Advertisement ad : cachedAdvs) {
                if (ad.getState() == 2) {
                    validIds.add(ad.getId());
                    String str4 = TAG;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("found adv in viewing state ");
                    sb3.append(ad.getId());
                    Log.d(str4, sb3.toString());
                } else if (!validIds.contains(ad.getId())) {
                    String str5 = TAG;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("delete ad ");
                    sb4.append(ad.getId());
                    Log.e(str5, sb4.toString());
                    this.storage.delete(ad);
                }
            }
            for (File f : assets4) {
                if (!validIds.contains(f.getName())) {
                    Log.v(TAG, String.format(Locale.ENGLISH, "Deleting assets under directory %s", new Object[]{f.getName()}));
                    try {
                        FileUtility.delete(f);
                    } catch (Throwable th) {
                        Log.e(TAG, "Failed to delete asset directory!", th);
                    }
                }
            }
            return 0;
        }
        return 1;
    }

    public static JobInfo makeJobInfo() {
        return new JobInfo(TAG).setPriority(0).setUpdateCurrent(true);
    }
}
