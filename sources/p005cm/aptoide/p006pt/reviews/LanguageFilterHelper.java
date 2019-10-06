package p005cm.aptoide.p006pt.reviews;

import android.content.res.Resources;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.utils.AptoideUtils.SystemU;

/* renamed from: cm.aptoide.pt.reviews.LanguageFilterHelper */
public class LanguageFilterHelper {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final LanguageFilter all = new LanguageFilter((int) C1375R.string.reviewappview_short_comments_by_language_all, Collections.emptyList());
    private final String currentCountryCode;
    private final LanguageFilter currentLanguageFirst;
    private final LanguageFilter english;

    /* renamed from: cm.aptoide.pt.reviews.LanguageFilterHelper$LanguageCode */
    public enum LanguageCode {
        en_GB;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    /* renamed from: cm.aptoide.pt.reviews.LanguageFilterHelper$LanguageFilter */
    public static class LanguageFilter {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private final List<String> countryCodes;
        private int position;
        private final int stringId;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(7613301860424070882L, "cm/aptoide/pt/reviews/LanguageFilterHelper$LanguageFilter", 14);
            $jacocoData = probes;
            return probes;
        }

        LanguageFilter(int stringId2, String countryCode) {
            boolean[] $jacocoInit = $jacocoInit();
            this(stringId2, Collections.singletonList(countryCode));
            $jacocoInit[0] = true;
        }

        LanguageFilter(int stringId2, List<String> countryCodes2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.position = 0;
            this.stringId = stringId2;
            this.countryCodes = countryCodes2;
            $jacocoInit[1] = true;
        }

        public LanguageFilter(LanguageFilter filter) {
            boolean[] $jacocoInit = $jacocoInit();
            this(filter.getStringId(), filter.getCountryCodes());
            $jacocoInit[2] = true;
        }

        public int getStringId() {
            boolean[] $jacocoInit = $jacocoInit();
            int i = this.stringId;
            $jacocoInit[3] = true;
            return i;
        }

        public List<String> getCountryCodes() {
            boolean[] $jacocoInit = $jacocoInit();
            List<String> list = this.countryCodes;
            $jacocoInit[4] = true;
            return list;
        }

        public int getPosition() {
            boolean[] $jacocoInit = $jacocoInit();
            int i = this.position;
            $jacocoInit[5] = true;
            return i;
        }

        public void setPosition(int position2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.position = position2;
            $jacocoInit[6] = true;
        }

        public LanguageFilter inc() {
            boolean[] $jacocoInit = $jacocoInit();
            this.position++;
            $jacocoInit[7] = true;
            return this;
        }

        public String getValue() {
            boolean[] $jacocoInit = $jacocoInit();
            if (this.countryCodes.size() > 0) {
                $jacocoInit[8] = true;
                String str = (String) this.countryCodes.get(this.position);
                $jacocoInit[9] = true;
                return str;
            }
            $jacocoInit[10] = true;
            return null;
        }

        public boolean hasMoreCountryCodes() {
            boolean z;
            boolean[] $jacocoInit = $jacocoInit();
            if (this.countryCodes.size() > this.position + 1) {
                $jacocoInit[11] = true;
                z = true;
            } else {
                z = false;
                $jacocoInit[12] = true;
            }
            $jacocoInit[13] = true;
            return z;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5112510457070744123L, "cm/aptoide/pt/reviews/LanguageFilterHelper", 19);
        $jacocoData = probes;
        return probes;
    }

    public LanguageFilterHelper(Resources resources) {
        List<String> countryCodes;
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        $jacocoInit[1] = true;
        this.currentCountryCode = SystemU.getCountryCode(resources);
        $jacocoInit[2] = true;
        if (this.currentCountryCode.startsWith("en")) {
            $jacocoInit[3] = true;
            countryCodes = Arrays.asList(new String[]{this.currentCountryCode});
            $jacocoInit[4] = true;
        } else {
            countryCodes = Arrays.asList(new String[]{this.currentCountryCode, LanguageCode.en_GB.toString()});
            $jacocoInit[5] = true;
        }
        this.currentLanguageFirst = new LanguageFilter((int) C1375R.string.reviewappview_short_comments_by_language_current_language_first, countryCodes);
        LanguageCode languageCode = LanguageCode.en_GB;
        $jacocoInit[6] = true;
        this.english = new LanguageFilter((int) C1375R.string.reviewappview_short_comments_by_language_english, languageCode.toString());
        $jacocoInit[7] = true;
    }

    public LanguageFilter getAll() {
        boolean[] $jacocoInit = $jacocoInit();
        LanguageFilter languageFilter = this.all;
        $jacocoInit[8] = true;
        return languageFilter;
    }

    public LanguageFilter getCurrentLanguageFirst() {
        boolean[] $jacocoInit = $jacocoInit();
        LanguageFilter languageFilter = this.currentLanguageFirst;
        $jacocoInit[9] = true;
        return languageFilter;
    }

    public LanguageFilter getEnglish() {
        boolean[] $jacocoInit = $jacocoInit();
        LanguageFilter languageFilter = this.english;
        $jacocoInit[10] = true;
        return languageFilter;
    }

    public String getCurrentCountryCode() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.currentCountryCode;
        $jacocoInit[11] = true;
        return str;
    }

    /* access modifiers changed from: 0000 */
    public List<LanguageFilter> getLanguageFilterList() {
        boolean[] $jacocoInit = $jacocoInit();
        List<LanguageFilter> languageFilterList = new LinkedList<>();
        $jacocoInit[12] = true;
        languageFilterList.add(this.all);
        $jacocoInit[13] = true;
        languageFilterList.add(this.currentLanguageFirst);
        $jacocoInit[14] = true;
        if (this.currentCountryCode.startsWith("en")) {
            $jacocoInit[15] = true;
        } else {
            $jacocoInit[16] = true;
            languageFilterList.add(this.english);
            $jacocoInit[17] = true;
        }
        $jacocoInit[18] = true;
        return languageFilterList;
    }
}
