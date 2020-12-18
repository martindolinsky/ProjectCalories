package sk.itsovy.android.dolinsky.projectcalories.test;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.LiveData;

public class UserRepository {

	private UserDao userDao;
	private LiveData<List<User>> users;

	UserRepository(Application application) {
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
}
