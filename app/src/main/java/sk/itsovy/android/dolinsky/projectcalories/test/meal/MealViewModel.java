package sk.itsovy.android.dolinsky.projectcalories.test.meal;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class MealViewModel extends AndroidViewModel {

	private MealRepository repository;

	private LiveData<List<Meal>> meals;

	public MealViewModel(@NonNull Application application) {
		super(application);
		repository = new MealRepository(application);
		meals = repository.getAllMeals();
	}

	public LiveData<List<Meal>> getAllMeals() {
		return meals;
	}

	public void insert(Meal meal) {
		repository.insert(meal);
	}
}
