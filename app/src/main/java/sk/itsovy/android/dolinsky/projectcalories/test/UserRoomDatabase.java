package sk.itsovy.android.dolinsky.projectcalories.test;

import android.content.Context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {User.class}, version = 1, exportSchema = false)
//@TypeConverters({Converters.class})
public abstract class UserRoomDatabase extends RoomDatabase {

	private static volatile UserRoomDatabase INSTANCE;
	private static final int NUMBER_OF_THREADS = 4;
	static final ExecutorService databaseWriteExecutor =
			Executors.newFixedThreadPool(NUMBER_OF_THREADS);

	// abstract method
	public abstract UserDao userDao();


	// static method
	static UserRoomDatabase getDatabase(final Context context) {
		if (INSTANCE == null) {
			synchronized (UserRoomDatabase.class) {
				if (INSTANCE == null) {
					INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
							UserRoomDatabase.class, "user_database")
							.addCallback(callback)
							.build();
				}
			}
		}
		return INSTANCE;
	}

	private static RoomDatabase.Callback callback = new RoomDatabase.Callback() {

		@Override
		public void onOpen(@NonNull SupportSQLiteDatabase db) {
			super.onOpen(db);

			// If you want to keep data through app restarts,
			// comment out the following block
			databaseWriteExecutor.execute(() -> {
				// Populate the database in the background.
				// If you want to start with more words, just add them.
				UserDao dao = INSTANCE.userDao();
				//If not here, it creates that number of dbs how many threads exists
				dao.deleteAll();
				User u1 = new User();
				u1.setText("Test");
				dao.insert(u1);

				User u2 = new User();
				u1.setText("Test 2");
				dao.insert(u2);



			});
		}
	};
}
