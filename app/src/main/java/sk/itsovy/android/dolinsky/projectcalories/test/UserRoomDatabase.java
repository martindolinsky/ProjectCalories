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
import sk.itsovy.android.dolinsky.projectcalories.test.meal.Meal;
import sk.itsovy.android.dolinsky.projectcalories.test.meal.MealDao;

@Database(entities = {User.class, Drink.class, Meal.class}, version = 6, exportSchema = false)
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
				UserDao userDao = INSTANCE.userDao();
				//If not here, it creates that number of dbs how many threads exists
				userDao.deleteAll();

				User u1 = new User();
				u1.setHeight(180);
				userDao.insert(u1);

				User u2 = new User();
				u1.setHeight(200);
				userDao.insert(u2);

				User u3 = new User();
				u1.setHeight(220);
				userDao.insert(u3);

				User u4 = new User();
				u1.setHeight(240);
				userDao.insert(u4);

				DrinkDao drinkDao = INSTANCE.drinkDao();
				drinkDao.deleteAll();

				Drink d1 = new Drink();
				d1.setTitle("Milk");
				d1.setProteins(50);
				drinkDao.insert(d1);

				Drink d2 = new Drink();
				d2.setTitle("Apple Juice");
				d2.setProteins(20);
				drinkDao.insert(d2);

				Drink d3 = new Drink();
				d3.setTitle("Water");
				d3.setProteins(10);
				drinkDao.insert(d3);

				Drink d4 = new Drink();
				d4.setTitle("Orange juice");
				d4.setProteins(12);
				drinkDao.insert(d4);

				Drink d5 = new Drink();
				d5.setTitle("Black tea");
				d5.setProteins(9);
				drinkDao.insert(d5);

				Drink d6 = new Drink();
				d6.setTitle("Ice tea");
				d6.setProteins(18);
				drinkDao.insert(d6);

				Drink d7 = new Drink();
				d7.setTitle("Coca Cola");
				d7.setProteins(4);
				drinkDao.insert(d7);

				Drink d8 = new Drink();
				d8.setTitle("Pepsi");
				d8.setProteins(4);
				drinkDao.insert(d8);

				MealDao mealDao = INSTANCE.mealDao();
				mealDao.deleteAll();

				Meal m1 = new Meal();
				m1.setTitle("Rice");
				m1.setProteins(80);
				mealDao.insert(m1);

				Meal m2 = new Meal();
				m2.setTitle("Chicken breast");
				m2.setProteins(120);
				mealDao.insert(m2);

				Meal m3 = new Meal();
				m3.setTitle("Potatoes");
				m3.setProteins(80);
				mealDao.insert(m3);

				Meal m4 = new Meal();
				m4.setTitle("Beef Steak");
				m4.setProteins(200);
				mealDao.insert(m4);

				Meal m5 = new Meal();
				m5.setTitle("Pork Steak");
				m5.setProteins(200);
				mealDao.insert(m5);

				Meal m6 = new Meal();
				m6.setTitle("Chicken wings");
				m6.setProteins(110);
				mealDao.insert(m6);

				Meal m7 = new Meal();
				m7.setTitle("Lamb Steak");
				m7.setProteins(220);
				mealDao.insert(m7);

				Meal m8 = new Meal();
				m8.setTitle("Salmon Steak");
				m8.setProteins(240);
				mealDao.insert(m8);


			});
		}
	};

	public abstract DrinkDao drinkDao();

	public abstract MealDao mealDao();

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


}
