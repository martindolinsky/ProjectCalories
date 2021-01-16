package sk.itsovy.android.dolinsky.projectcalories.test.meal;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.LiveData;
import sk.itsovy.android.dolinsky.projectcalories.test.UserRoomDatabase;

public class MealRepository {

	private MealDao mealDao;
	private LiveData<List<Meal>> meals;

	MealRepository(Application application) {
		UserRoomDatabase database = UserRoomDatabase.getDatabase(application);
		mealDao = database.mealDao();
		meals = mealDao.getAllMeals();
	}

	LiveData<List<Meal>> getAllMeals() {
		return meals;
	}

	void insert(final Meal meal) {
		UserRoomDatabase.databaseWriteExecutor.execute(
				() -> {
					mealDao.insert(meal);
				}
		);
	}
}

