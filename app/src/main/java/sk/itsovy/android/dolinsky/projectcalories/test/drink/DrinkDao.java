package sk.itsovy.android.dolinsky.projectcalories.test.drink;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface DrinkDao {

	@Insert(onConflict = OnConflictStrategy.IGNORE)
	void insert(Drink drink);

	@Query("SELECT * FROM drinks")
	LiveData<List<Drink>> getAllDrinks();

	@Query("SELECT * FROM drinks WHERE id = :id")
	LiveData<Drink> getById(int id);

	@Delete
	void deleteDrink(Drink drink);

	@Query("DELETE FROM drinks")
	void deleteAll();
}

