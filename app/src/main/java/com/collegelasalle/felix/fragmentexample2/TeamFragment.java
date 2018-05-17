package com.collegelasalle.felix.fragmentexample2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TeamFragment extends ListFragment {

    String[] TEAMS = new String[]{"Brazil", "Germany", "Italy"};
    boolean isInfoActive;
    int currentIndex;

    public TeamFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, TEAMS));
        getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        View infoFrame = getActivity().findViewById(R.id.info);
        isInfoActive = infoFrame != null && infoFrame.getVisibility() == View.VISIBLE;
        if (isInfoActive) {
            showInfo(currentIndex);
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        showInfo(position);
    }

    void showInfo(int index) {
        currentIndex = index;
        if (isInfoActive) {
            getListView().setItemChecked(index, true);
            InfoFragment infoFragment = (InfoFragment) getFragmentManager().findFragmentById(R.id.info);

            if (infoFragment == null || infoFragment.getIndex() != index) {
                infoFragment = InfoFragment.newInstance(index);

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.info, infoFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        } else {
            Intent intent = new Intent();
            intent.setClass(getActivity(), InfoActivity.class);
            intent.putExtra(InfoFragment.INDEX_PARAM, index);
            startActivity(intent);
        }
    }

}
