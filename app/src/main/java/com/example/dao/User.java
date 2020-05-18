package com.example.dao;

import com.example.util.Cn2Spell;

public class User implements Comparable<User>{
    private String name;
    private String pinYin;
    private String firstPinYinLetter;

    public User(String name) {
        this.name = name;
        this.name = name;
        pinYin = Cn2Spell.getPinYin(name);// 根据姓名获取拼音
        firstPinYinLetter = pinYin.substring(0, 1).toUpperCase(); // 获取拼音首字母并转成大写
        if (!firstPinYinLetter.matches("[A-Z]")) { // 如果不在A-Z中则默认为“#”
            firstPinYinLetter = "#";
        }
    }

    public String getName() {
        return name;
    }

    public String getFirstPinYinLetter() {
        return firstPinYinLetter;
    }

    public String getPinYin() {
        return pinYin;
    }

    @Override
    public int compareTo(User o) {
        if (firstPinYinLetter.equals("#") && !o.getFirstPinYinLetter().equals("#")) {
            return 1;
        } else if (!firstPinYinLetter.equals("#") && o.getFirstPinYinLetter().equals("#")){
            return -1;
        } else {
            return pinYin.compareToIgnoreCase(o.getPinYin());
        }
    }
}
