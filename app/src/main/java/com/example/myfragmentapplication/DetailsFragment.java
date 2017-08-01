package com.example.myfragmentapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myfragmentapplication.dummy.DummyContent;



/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {

    public static final String ITEM = "item";
    TextView mTv;

    public DetailsFragment() {
        // Required empty public constructor
    }

    public void updateContent(DummyContent.DummyItem item) {
        if (mTv == null) {
            mTv = (TextView) getActivity().findViewById(R.id.detailsTextView);
        }
        mTv.setText(item.details);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();


        if (getArguments() != null) {
            DummyContent.DummyItem item =
                    (DummyContent.DummyItem) getArguments().getSerializable(ITEM);

            if (item != null) {
                updateContent(item);
            }
        }

    }
}
