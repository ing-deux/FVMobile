package uci.fvm.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uci.fvm.R;
import uci.fvm.adapter.ViewPagerAdapter;
import uci.fvm.fragment.tab.TabBook;
import uci.fvm.fragment.tab.TabResource;

/**
 * Created by Diosbel E. Lima on 08/04/2017.
 */

public class FragmentHome extends Fragment {
    private ViewPager viewPager;
    private Context context;
    private TabLayout tabs;

    public FragmentHome() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Falta Llamar adaptador
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        tabs=(TabLayout)rootView.findViewById(R.id.tab_home);

        viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
        configViewPager(viewPager);

        tabs.setupWithViewPager(viewPager);


        return rootView;
    }

    private void configViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFrag(new TabBook(), "Libros");
        adapter.addFrag(new TabResource(), "Recursos");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}