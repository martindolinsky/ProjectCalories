package sk.itsovy.android.dolinsky.projectcalories.test.drink;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.LiveData;
import sk.itsovy.android.dolinsky.projectcalories.test.user.UserRoomDatabase;

public class DrinkRepository {

	private DrinkDao drinkDao;
	private LiveData<List<Drink>> drinks;

	DrinkRepository(Application application) {
		UserRoomDatabase database = UserRoomDatabase.getDatabase(application);
		drinkDao = database.drinkDao();
		drinks = drinkDao.getAllDrinks();
	}

	LiveData<List<Drink>> getAllDrinks() {
		return drinks;
	}

	void insert(final Drink drink) {
		UserRoomDatabase.databaseWriteExecutor.execute(
				() -> {
					drinkDao.insert(drink);
				}
		);
	}
}
