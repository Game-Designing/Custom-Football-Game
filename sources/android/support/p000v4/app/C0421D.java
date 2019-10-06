package android.support.p000v4.app;

import android.os.Parcelable;
import android.support.p000v4.view.C0642s;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v4.app.D */
/* compiled from: FragmentPagerAdapter */
public abstract class C0421D extends C0642s {
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentPagerAdapter";
    private C0424G mCurTransaction = null;
    private Fragment mCurrentPrimaryItem = null;
    private final C0486t mFragmentManager;

    public abstract Fragment getItem(int i);

    public C0421D(C0486t fm) {
        this.mFragmentManager = fm;
    }

    public void startUpdate(ViewGroup container) {
        if (container.getId() == -1) {
            StringBuilder sb = new StringBuilder();
            sb.append("ViewPager with adapter ");
            sb.append(this);
            sb.append(" requires a view id");
            throw new IllegalStateException(sb.toString());
        }
    }

    public Object instantiateItem(ViewGroup container, int position) {
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.mo4909a();
        }
        long itemId = getItemId(position);
        Fragment fragment = this.mFragmentManager.mo4908a(makeFragmentName(container.getId(), itemId));
        if (fragment != null) {
            this.mCurTransaction.mo5036a(fragment);
        } else {
            fragment = getItem(position);
            this.mCurTransaction.mo5035a(container.getId(), fragment, makeFragmentName(container.getId(), itemId));
        }
        if (fragment != this.mCurrentPrimaryItem) {
            fragment.setMenuVisibility(false);
            fragment.setUserVisibleHint(false);
        }
        return fragment;
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.mo4909a();
        }
        this.mCurTransaction.mo5042b((Fragment) object);
    }

    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        Fragment fragment = (Fragment) object;
        Fragment fragment2 = this.mCurrentPrimaryItem;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                this.mCurrentPrimaryItem.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.mCurrentPrimaryItem = fragment;
        }
    }

    public void finishUpdate(ViewGroup container) {
        C0424G g = this.mCurTransaction;
        if (g != null) {
            g.mo5045d();
            this.mCurTransaction = null;
        }
    }

    public boolean isViewFromObject(View view, Object object) {
        return ((Fragment) object).getView() == view;
    }

    public Parcelable saveState() {
        return null;
    }

    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    public long getItemId(int position) {
        return (long) position;
    }

    private static String makeFragmentName(int viewId, long id) {
        StringBuilder sb = new StringBuilder();
        sb.append("android:switcher:");
        sb.append(viewId);
        sb.append(":");
        sb.append(id);
        return sb.toString();
    }
}
