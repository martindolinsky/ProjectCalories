package sk.itsovy.android.dolinsky.projectcalories.test;

import android.content.Context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import sk.itsovy.android.dolinsky.projectcalories.test.drink.Drink;
import sk.itsovy.android.dolinsky.projectcalories.test.drink.DrinkDao;

@Database(entities = {User.class, Drink.class}, version = 5, exportSchema = false)
//@TypeConverters({Converters.class})
public abstract class UserRoomDatabase extends RoomDatabase {

	private static volatile UserRoomDatabase INSTANCE;
	private static final int NUMBER_OF_THREADS = 4;
	public static final ExecutorService databaseWriteExecutor =
			Executors.newFixedThreadPool(NUMBER_OF_THREADS);

	// abstract method
	public abstract UserDao userDao();

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
				u1.setHeight(180);
				dao.insert(u1);

				User u2 = new User();
				u1.setHeight(200);
				dao.insert(u2);

				User u3 = new User();
				u1.setHeight(220);
				dao.insert(u3);

				User u4 = new User();
				u1.setHeight(240);
				dao.insert(u4);

				DrinkDao dao1 = INSTANCE.drinkDao();
				dao1.deleteAll();

				Drink d1 = new Drink();
				d1.setTitle("Milk");
				d1.setProteins(50);
				dao1.insert(d1);

				Drink d2 = new Drink();
				d2.setTitle("Apple Juice");
				d2.setProteins(20);
				dao1.insert(d2);

				Drink d3 = new Drink();
				d3.setTitle("Water");
				d3.setProteins(10);
				dao1.insert(d3);

				Drink d4 = new Drink();
				d4.setTitle("Orange juice");
				d4.setProteins(12);
				dao1.insert(d4);

				Drink d5 = new Drink();
				d5.setTitle("Black tea");
				d5.setProteins(9);
				dao1.insert(d5);

				Drink d6 = new Drink();
				d6.setTitle("Ice tea");
				d6.setProteins(18);
				dao1.insert(d6);

				Drink d7 = new Drink();
				d7.setTitle("Coca Cola");
				d7.setProteins(4);
				dao1.insert(d7);

				Drink d8 = new Drink();
				d8.setTitle("Pepsi");
				d8.setProteins(4);
				dao1.insert(d8);

			});
		}
	};

	// static method
	public static UserRoomDatabase getDatabase(final Context context) {
		if (INSTANCE == null) {
			synchronized (UserRoomDatabase.class) {
				if (INSTANCE == null) {
					INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
							UserRoomDatabase.class, "user_database")
							.addCallback(callback)
							.fallbackToDestructiveMigration()
							.build();
				}
			}
		}
		return INSTANCE;
	}

	public abstract DrinkDao drinkDao();
}
