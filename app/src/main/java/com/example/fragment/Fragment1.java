package com.example.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment1 extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_1, container, false);

        rootView.findViewById(R.id.button).setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        //프래그먼트를 포함하고 있는 메인액티비티를 참조해야함.
        //MainActivity 안에 내가 정의한 프래그먼트 전환 함수를 만들어 두고 호출해줘야함.
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.onFragmentChanged(0);

    }
}


