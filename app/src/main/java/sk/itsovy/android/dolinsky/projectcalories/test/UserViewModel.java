package sk.itsovy.android.dolinsky.projectcalories.test;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class UserViewModel extends AndroidViewModel {

	private UserRepository repository;

	private LiveData<List<User>> users;

	public UserViewModel(@NonNull Application application) {
		super(application);
		repository = new UserRepository(application);
		users = repository.getAllUsers();
	}

	public LiveData<List<User>> getAllUsers() {
		return users;
	}

	public void insert(User user) {
		repository.insert(user);
	}
}
