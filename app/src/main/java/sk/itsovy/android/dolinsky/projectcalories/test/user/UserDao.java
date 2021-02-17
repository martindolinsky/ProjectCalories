package sk.itsovy.android.dolinsky.projectcalories.test.user;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDao {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	void insert(User user);

	@Update
	void update(User user);

	@Query("SELECT * FROM users")
	LiveData<List<User>> getAllUsers();

	@Query("SELECT * FROM users WHERE id = :id")
	LiveData<User> getById(int id);

	@Query("SELECT * FROM users LIMIT 1")
	LiveData<User> getFirstUser();

	@Delete
	void deleteProfile(User user);

	@Query("DELETE FROM users")
	void deleteAll();


	@Query("UPDATE users SET todayTotal = todayTotal + :total")
	void setTotal(int total);

	@Query("UPDATE users SET height = :height")
	void setHeight(int height);

	@Query("UPDATE users SET weight = :weight")
	void setWeight(int weight);


}
