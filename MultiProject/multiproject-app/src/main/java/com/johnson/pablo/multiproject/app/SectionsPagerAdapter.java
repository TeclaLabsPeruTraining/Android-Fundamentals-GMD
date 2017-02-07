package com.johnson.pablo.multiproject.app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.johnson.pablo.multiproject.location.LocationFragment;
import com.johnson.pablo.multiproject.payment.PaymentFragment;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 * Created by pjohnson on 23/10/2015.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return AppFragment.newInstance();
            case 1:
                return LocationFragment.newInstance();
            case 2:
                return PaymentFragment.newInstance();
        }
        return AppFragment.newInstance();
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "LANDING";
            case 1:
                return "LOCATION";
            case 2:
                return "PAYMENT";
        }
        return null;
    }
}
