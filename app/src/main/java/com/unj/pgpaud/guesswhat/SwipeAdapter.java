package com.unj.pgpaud.guesswhat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Muhammad Ardiansyah on 12/28/2016.
 */

public class SwipeAdapter extends FragmentStatePagerAdapter{
    public SwipeAdapter(FragmentManager fm){
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        if(position == 0)
            fragment = new Tutorial1();
        else if (position == 1)
            fragment = new Tutorial2();
        else if(position == 2)
            fragment = new Tutorial3();
        else if(position == 3)
            fragment = new Tutorial4();

        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
