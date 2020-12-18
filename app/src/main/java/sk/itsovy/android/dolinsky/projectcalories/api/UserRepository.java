package sk.itsovy.android.dolinsky.projectcalories.api;

import androidx.lifecycle.MutableLiveData;

public class UserRepository {
	static UserRepository INSTANCE = null;

	public static UserRepository getInstance() {
		if (INSTANCE == null) INSTANCE = new UserRepository();
		return INSTANCE;
	}


	public MutableLiveData<User> userData = new MutableLiveData();

	public void setUserHeight(int height) {
		User user = this.userData.getValue();
		if (user == null)
			user = new User();
		user.setHeight(height);
		this.userData.setValue(user);
	}

	public void setUserWeight(int weight) {
		User user = this.userData.getValue();
		if (user == null)
			user = new User();
		user.setWeight(weight);
		this.userData.setValue(user);
	}


}
