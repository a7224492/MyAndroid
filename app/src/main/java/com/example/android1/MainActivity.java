package com.example.android1;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.example.dao.Student;
import com.example.dao.StudentRepository;
import com.example.fragment.*;

public class MainActivity extends AppCompatActivity implements BottomFragment.BottomListener {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private static final Fragment[] FRAGMENTS = new Fragment[] {
            new WeiXinFragment(), new FriendFragment(), new FaXianFragment(), new MeFragment()
    };

    private StudentRepository studentRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = findViewById(R.id.searchview);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        // Create new fragment and transaction
        showFragment(0);
    }

    private void showFragment(int fragmentIndex) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_main, FRAGMENTS[fragmentIndex]);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBottomClick(View view, int index) {
        showFragment(index);
    }
}
