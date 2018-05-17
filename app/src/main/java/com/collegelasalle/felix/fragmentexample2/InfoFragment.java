package com.collegelasalle.felix.fragmentexample2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class InfoFragment extends Fragment {
    private static final String ARG_PARAM1 = "index";
    private int index;

    String[] INFOS = new String[]{
            "Brazil is the most successful national team in the history of the World Cup.",
            "The Germany national football team is one of the most successful national teams at the FIFA World Cup, winning four titles, earning second-place and third-place finishes four times each and one fourth-place finish.",
            "Italy is one of the most successful national teams in the history of the World Cup, having won four titles (1934, 1938, 1982, 2006), just one fewer than Brazil."};

    public InfoFragment() {
        // Required empty public constructor
    }

    public static InfoFragment newInstance(int index) {
        InfoFragment fragment = new InfoFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, index);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView text = getView().findViewById(R.id.infoTextView);
        text.setText(INFOS[index]);
    }

    public int getIndex() {
        return index;
    }
}
