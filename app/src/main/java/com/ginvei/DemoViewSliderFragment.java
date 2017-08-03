package com.ginvei;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class DemoViewSliderFragment extends Fragment {


    public DemoViewSliderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_demo_view_slider, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupViewPager();
    }

    private void setupViewPager() {
        ViewPager viewPager= getView().findViewById(R.id.viewPager);
        TabLayout tabLayout = getView().findViewById(R.id.tabs);
        viewPager.setAdapter(new viewPagerAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setOffscreenPageLimit(3);
    }

    public class viewPagerAdapter extends FragmentPagerAdapter {

        public viewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: {
                    return new Demo23Fragment();
                }
                case 1: {
                    return new DemoForViewPagerFragment();
                }
                case 2: {
                    return new InventoryFragment();
                }
                default: {
                    return new Demo23Fragment();
                }
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0: {
                    return "Fragment 1";
                }
                case 1: {
                    return "Fragment 2";
                }
                case 2: {
                    return "Fragment 3";
                }
                default: {
                    return "Fra";
                }
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
