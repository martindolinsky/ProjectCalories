package sk.itsovy.android.dolinsky.projectcalories.test;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface UserDao {

	@Insert(onConflict = OnConflictStrategy.IGNORE)
	void insert(User user);

	@Query("SELECT * FROM user")
	LiveData<List<User>> getAllUsers();

	@Query("SELECT * FROM user WHERE id = :id")
	LiveData<User> getById(int id);

	@Delete
	void deleteProfile(User user);

	@Query("DELETE FROM user")
	void deleteAll();
}
