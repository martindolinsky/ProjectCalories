package sk.itsovy.android.dolinsky.projectcalories.test.user;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.LiveData;

public class UserRepository {

	private UserDao userDao;
	private LiveData<List<User>> users;


	public UserRepository(Application application) {
		UserRoomDatabase database = UserRoomDatabase.getDatabase(application);
		userDao = database.userDao();
		users = userDao.getAllUsers();
	}

	LiveData<List<User>> getAllUsers() {
		return users;
	}

	void insert(final User user) {
		UserRoomDatabase.databaseWriteExecutor.execute(
				() -> {
					userDao.insert(user);
				}
		);
	}

	void updateUser(User user) {
		UserRoomDatabase.databaseWriteExecutor.execute(
				() -> {
					userDao.update(user);
				}
		);
	}

	LiveData<User> getById(int id) {
		return userDao.getById(id);
	}

	LiveData<User> getFirstUser() {
		return userDao.getFirstUser();
	}

	void setTotal(int total) {
		UserRoomDatabase.databaseWriteExecutor.execute(
				() -> {
					userDao.setTotal(total);
				}
		);
	}

	void setTotalDrink(double total) {
		UserRoomDatabase.databaseWriteExecutor.execute(
				() -> {
					userDao.setTotalDrink(total);
				}
		);
	}

	void setHeight(int height) {
		UserRoomDatabase.databaseWriteExecutor.execute(
				() -> {
					userDao.setHeight(height);
				}
		);
	}

	void setWeight(int weight) {
		UserRoomDatabase.databaseWriteExecutor.execute(
				() -> {
					userDao.setWeight(weight);
				}
		);
	}
}
