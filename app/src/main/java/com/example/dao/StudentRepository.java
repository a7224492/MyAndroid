package com.example.dao;

import android.app.Application;
import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StudentRepository {
    private static final int NUMBER_OF_THREADS = 4;
    private static final ExecutorService databaseThreadPool =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private StudentDao dao;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    public StudentRepository(Application application) {
        StudentRoomDatabase database = StudentRoomDatabase.getDatabase(application);
        dao = database.studentDao();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<Student>> queryAllStudent() {
        return dao.queryAllStudent();
    }

    public LiveData<List<Student>> queryNameLikeStudentAsync(String queryName) {
        return dao.queryNameLikeStudentAsync(queryName);
    }

    public List<Student> queryNameLikeStudentSync(String queryName) {
        return dao.queryNameLikeStudentSync(queryName);
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    public void insert(Student student) {
        databaseThreadPool.execute(() -> {
            dao.insert(student);
        });
    }
}
