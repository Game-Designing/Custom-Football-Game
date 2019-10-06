package p005cm.aptoide.p006pt.search;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MatrixCursor.RowBuilder;
import android.support.p000v4.widget.C0700j;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;

/* renamed from: cm.aptoide.pt.search.SuggestionCursorAdapter */
public class SuggestionCursorAdapter extends C0700j {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String[] COLUMN_NAMES = {"_id", "suggest_text_1"};
    private static final int ITEM_LAYOUT = 2131427633;
    private final List<String> suggestions;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3000007064878415806L, "cm/aptoide/pt/search/SuggestionCursorAdapter", 29);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[28] = true;
    }

    public SuggestionCursorAdapter(Context context, List<String> initialSuggestions) {
        boolean[] $jacocoInit = $jacocoInit();
        super(context, (Cursor) null, false);
        $jacocoInit[0] = true;
        this.suggestions = new LinkedList();
        $jacocoInit[1] = true;
        if (initialSuggestions == null) {
            $jacocoInit[2] = true;
        } else if (initialSuggestions.isEmpty()) {
            $jacocoInit[3] = true;
        } else {
            $jacocoInit[4] = true;
            setData(initialSuggestions);
            $jacocoInit[5] = true;
        }
        $jacocoInit[6] = true;
    }

    public SuggestionCursorAdapter(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        this(context, Collections.emptyList());
        $jacocoInit[7] = true;
    }

    public void setData(List<String> newSuggestions) {
        boolean[] $jacocoInit = $jacocoInit();
        this.suggestions.clear();
        $jacocoInit[8] = true;
        this.suggestions.addAll(newSuggestions);
        $jacocoInit[9] = true;
        changeCursor(getCursorFor(this.suggestions));
        $jacocoInit[10] = true;
    }

    private MatrixCursor getCursorFor(List<String> data) {
        boolean[] $jacocoInit = $jacocoInit();
        MatrixCursor cursor = new MatrixCursor(COLUMN_NAMES, data.size());
        int index = 0;
        $jacocoInit[11] = true;
        $jacocoInit[12] = true;
        for (String item : data) {
            $jacocoInit[13] = true;
            RowBuilder newRow = cursor.newRow();
            int index2 = index + 1;
            $jacocoInit[14] = true;
            RowBuilder add = newRow.add(Integer.toString(index));
            $jacocoInit[15] = true;
            add.add(item);
            $jacocoInit[16] = true;
            index = index2;
        }
        $jacocoInit[17] = true;
        return cursor;
    }

    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        boolean[] $jacocoInit = $jacocoInit();
        LayoutInflater from = LayoutInflater.from(context);
        $jacocoInit[18] = true;
        View inflate = from.inflate(C1375R.layout.simple_dropdown_item, parent, false);
        $jacocoInit[19] = true;
        return inflate;
    }

    public void bindView(View view, Context context, Cursor cursor) {
        boolean[] $jacocoInit = $jacocoInit();
        TextView textView = (TextView) view.findViewById(C1375R.C1376id.dropdown_text);
        $jacocoInit[20] = true;
        textView.setText(getSuggestionAtCurrentPosition(cursor));
        $jacocoInit[21] = true;
    }

    public List<String> getSuggestions() {
        boolean[] $jacocoInit = $jacocoInit();
        List<String> list = this.suggestions;
        $jacocoInit[22] = true;
        return list;
    }

    public CharSequence getSuggestionAt(int position) {
        boolean[] $jacocoInit = $jacocoInit();
        Cursor cursor = getCursor();
        $jacocoInit[23] = true;
        if (cursor.moveToPosition(position)) {
            $jacocoInit[24] = true;
            String suggestionAtCurrentPosition = getSuggestionAtCurrentPosition(cursor);
            $jacocoInit[25] = true;
            return suggestionAtCurrentPosition;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to find query at position ");
        sb.append(position);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(sb.toString());
        $jacocoInit[26] = true;
        throw unsupportedOperationException;
    }

    private String getSuggestionAtCurrentPosition(Cursor cursor) {
        boolean[] $jacocoInit = $jacocoInit();
        String string = cursor.getString(cursor.getColumnIndex("suggest_text_1"));
        $jacocoInit[27] = true;
        return string;
    }
}
