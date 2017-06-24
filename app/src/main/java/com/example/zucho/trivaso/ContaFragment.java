package com.example.zucho.trivaso;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by jonas on 12/06/17.
 */

public class ContaFragment extends Fragment {

    private ImageView photoImageView;
    private TextView nameTextView;
    private TextView emailTextView;
    private TextView idTextView;
    private ArrayList<String> data;
    private static final String TAG = "ContaFragment";

    public ContaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_conta, container, false);

        MainActivity mainActivity = (MainActivity) getActivity();
        setData(mainActivity.getData());

        photoImageView = (ImageView) view.findViewById(R.id.photoImageView);
        nameTextView = (TextView) view.findViewById(R.id.nameTextView);
        emailTextView = (TextView) view.findViewById(R.id.emailTextView);
        idTextView = (TextView) view.findViewById(R.id.idTextView);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        nameTextView.setText(this.data.get(0));
        emailTextView.setText(this.data.get(1));
        Glide.with(this).load(this.data.get(2)).into(photoImageView);
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }
}