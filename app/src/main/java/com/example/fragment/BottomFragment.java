package com.example.fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android1.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BottomFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BottomFragment extends Fragment implements View.OnClickListener {
    private final int[] BOTTOM_LAYOUT_IDS = {
            R.id.layout_bottom_weixin, R.id.layout_bottom_tongxun,
            R.id.layout_bottom_faxian, R.id.layout_bottom_me
    };

    private Drawable[] bottomLayoutBackgrounds = new Drawable[BOTTOM_LAYOUT_IDS.length];
    private BottomListener bottomListener;
    private View rootView;

    public interface BottomListener {
        void onBottomClick(View view, int index);
    }

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        bottomListener = (BottomListener) context;
    }

    public BottomFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FriendFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BottomFragment newInstance(String param1, String param2) {
        BottomFragment fragment = new BottomFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_bottom, container, false);
        for (int i = 0; i < BOTTOM_LAYOUT_IDS.length; ++i) {
            View layout = rootView.findViewById(BOTTOM_LAYOUT_IDS[i]);
            // 保存初始背景
            bottomLayoutBackgrounds[i] = layout.getBackground();
            // 设置监听
            layout.setOnClickListener(this);
        }

        showLayout(0);

        // Inflate the layout for this fragment
        return rootView;
    }

    /**
     * 显示某一个layout
     *
     * @param index
     */
    public void showLayout(int index) {
        // 设置默认背景
        for (int i = 0; i < BOTTOM_LAYOUT_IDS.length; ++i) {
            View layout = rootView.findViewById(BOTTOM_LAYOUT_IDS[i]);
            layout.setBackground(bottomLayoutBackgrounds[i]);
        }

        // 设置show背景
        View layout = rootView.findViewById(BOTTOM_LAYOUT_IDS[index]);
        layout.setBackgroundResource(R.drawable.ic_launcher_background);
    }

    @Override
    public void onClick(View v) {
        for (int i = 0; i < BOTTOM_LAYOUT_IDS.length; ++i) {
            if (BOTTOM_LAYOUT_IDS[i] == v.getId()) {
                showLayout(i);
                bottomListener.onBottomClick(v, i);
                break;
            }
        }
    }
}
