package sk.itsovy.android.dolinsky.projectcalories.test.drink;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


public class DrinkViewModel extends AndroidViewModel {

	private DrinkRepository repository;

	private LiveData<List<Drink>> drinks;

	public DrinkViewModel(@NonNull Application application) {
		super(application);
		repository = new DrinkRepository(application);
		drinks = repository.getAllDrinks();
	}

	public LiveData<List<Drink>> getAllDrinks() {
		return drinks;
	}

	public void insert(Drink drink) {
		repository.insert(drink);
	}
}

