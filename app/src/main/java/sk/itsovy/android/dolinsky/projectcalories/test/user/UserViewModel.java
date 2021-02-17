package sk.itsovy.android.dolinsky.projectcalories.test.user;

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

	public void update(User user) {
		repository.updateUser(user);
	}

	public LiveData<User> getById(int id) {
		return repository.getById(id);
	}

	public LiveData<User> getFirstUser() {
		return repository.getFirstUser();
	}


	public void setTotal(int total) {
		repository.setTotal(total);
	}

	public void setHeight(int height) {
		repository.setHeight(height);
	}

	public void setWeight(int weight) {
		repository.setWeight(weight);
	}
}
