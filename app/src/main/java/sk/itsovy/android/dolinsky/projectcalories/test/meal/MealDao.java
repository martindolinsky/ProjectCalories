package sk.itsovy.android.dolinsky.projectcalories.test.meal;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface MealDao {

	@Insert(onConflict = OnConflictStrategy.IGNORE)
	void insert(Meal meal);

	@Query("SELECT * FROM meals ORDER BY title")
	LiveData<List<Meal>> getAllMeals();

	@Query("SELECT * FROM meals WHERE id = :id")
	LiveData<Meal> getById(int id);

	@Delete
	void deleteMeal(Meal meal);

	@Query("DELETE FROM meals")
	void deleteAll();
}

