package com.example.dao;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Student.class}, version = 1, exportSchema = false)
public abstract class StudentRoomDatabase extends RoomDatabase {
    private static volatile StudentRoomDatabase INSTANCE;

    public abstract StudentDao studentDao();

    public static StudentRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (StudentRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            StudentRoomDatabase.class, "student_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
