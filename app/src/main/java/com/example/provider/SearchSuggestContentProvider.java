package com.example.provider;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import androidx.lifecycle.LiveData;
import com.example.dao.Student;
import com.example.dao.StudentRepository;
import com.example.db.DatabaseVirtualTable;

import java.util.List;

import static android.app.SearchManager.SUGGEST_COLUMN_TEXT_1;
import static android.provider.BaseColumns._ID;

public class SearchSuggestContentProvider extends ContentProvider {
    private StudentRepository studentRepository;
    public static final String URI = "content://com.example.provider/search_suggest_query/?limit=50";

    public SearchSuggestContentProvider() {

    }

    @Override
    public void attachInfo(Context context, ProviderInfo info) {
        super.attachInfo(context, info);
        studentRepository = new StudentRepository((Application) context);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        String query = uri.getLastPathSegment();
        List<Student> studentList = studentRepository.queryNameLikeStudentSync(query + "%");

        MatrixCursor matrixCursor = new MatrixCursor(new String[]{_ID, SUGGEST_COLUMN_TEXT_1});
        for (Student student : studentList) {
            matrixCursor.addRow(new Object[]{student.getId(), student.getName()});
        }

        return matrixCursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
