package com.example.android1;

import android.app.SearchManager;
import android.content.Intent;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import com.example.dao.Student;
import com.example.dao.StudentRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchableActivity extends AppCompatActivity {
    private StudentRepository studentRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchable);

        studentRepository = new StudentRepository(this.getApplication());
        handleIntent(getIntent());
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            LiveData<List<Student>> listLiveData = studentRepository.queryNameLikeStudentAsync(query + "%");
            listLiveData.observeForever(studentList -> {
                // 设置adapter数据
                List<Map<String, String>> data = new ArrayList<>();
                for (Student student : studentList) {
                    Map<String, String> m = new HashMap<>();
                    m.put("WORD", student.getId());
                    m.put("DEFINITION", student.getName());
                    data.add(m);
                }

                // 设置adapter
                SimpleAdapter cursorAdapter = new SimpleAdapter(
                        this,
                        data,
                        R.layout.activity_searchable,
                        new String[]{"WORD", "DEFINITION"},
                        new int[]{R.id.listview_search_result_col_word, R.id.listview_search_result_col_definition});

                ListView listViewSearchResult = findViewById(R.id.listview_search_result);
                listViewSearchResult.setAdapter(cursorAdapter);
            });
        }
    }
}
