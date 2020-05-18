package com.example.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.android1.R;
import com.example.test.TestData;
import com.example.test.TestUnitView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WeiXinFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WeiXinFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WeiXinFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WeiXinFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WeiXinFragment newInstance(String param1, String param2) {
        WeiXinFragment fragment = new WeiXinFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_wei_xin, container, false);

        List<Map<String, Object>> listViewData = new ArrayList<>();
        for (TestUnitView testUnitView : TestData.UNIT_TITLE_ARRAY) {
            Map<String, Object> m = new HashMap<>();
            m.put("title", testUnitView.getTitle());
            m.put("lastMessage", testUnitView.getLastMessage());
            m.put("imageId", testUnitView.getImageId());

            listViewData.add(m);
        }

        // 设设adapter
        SimpleAdapter adapter = new SimpleAdapter(getActivity(), listViewData, R.layout.listview_layout_unit,
                new String[]{"title", "lastMessage", "imageId"},
                new int[]{R.id.textview_unit_title, R.id.textview_unit_last_message, R.id.imageview_unit_image});

        // 设置listview
        ListView listView = rootView.findViewById(R.id.listview);
        listView.setAdapter(adapter);

        return rootView;
    }
}
