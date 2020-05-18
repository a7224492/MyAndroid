package com.example.test;

import com.example.android1.R;
import com.example.dao.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestData {
    public static final TestUnitView[] UNIT_TITLE_ARRAY = {
        new TestUnitView("unit1_title", "unit1_lastmessage", R.drawable.ic_launcher_background),
        new TestUnitView("unit2_title", "unit2_lastmessage", R.drawable.ic_launcher_background),
        new TestUnitView("unit3_title", "unit3_lastmessage", R.drawable.ic_launcher_background),
        new TestUnitView("unit4_title", "unit4_lastmessage", R.drawable.ic_launcher_background),
        new TestUnitView("unit5_title", "unit5_lastmessage", R.drawable.ic_launcher_background),
        new TestUnitView("unit6_title", "unit6_lastmessage", R.drawable.ic_launcher_background),
        new TestUnitView("unit7_title", "unit7_lastmessage", R.drawable.ic_launcher_background),
        new TestUnitView("unit8_title", "unit8_lastmessage", R.drawable.ic_launcher_background),
        new TestUnitView("unit9_title", "unit9_lastmessage", R.drawable.ic_launcher_background)
    };

    public static List<User> FRIEND_LIST_VIEW = new ArrayList<>();

    static {
        FRIEND_LIST_VIEW.add(new User("姜桢"));
        FRIEND_LIST_VIEW.add(new User("源锅"));
        FRIEND_LIST_VIEW.add(new User("菠菜"));
        FRIEND_LIST_VIEW.add(new User("沈"));
        FRIEND_LIST_VIEW.add(new User("焕锅"));
        FRIEND_LIST_VIEW.add(new User("冬瓜"));
        FRIEND_LIST_VIEW.add(new User("石彦磊"));
        FRIEND_LIST_VIEW.add(new User("鼓声"));
        FRIEND_LIST_VIEW.add(new User("华锅"));
        FRIEND_LIST_VIEW.add(new User("杨哥"));

        FRIEND_LIST_VIEW.sort(Comparator.naturalOrder());
    }
}

