package uci.fvm.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uci.fvm.R;

/**
 * Created by Diosbel E. Lima on 08/04/2017.
 */

public class FragmentResource extends Fragment {

    public FragmentResource() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_resource, container, false);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
