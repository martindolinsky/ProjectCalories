package sk.itsovy.android.dolinsky.projectcalories.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import sk.itsovy.android.dolinsky.projectcalories.api.UserRepository;

public class ProfileViewModel extends ViewModel {
	private UserRepository repo = UserRepository.getInstance();

	public LiveData<Integer> height = Transformations.map(repo.userData, input -> input.getHeight());
	public LiveData<Integer> weight = Transformations.map(repo.userData, input -> input.getWeight());
	public LiveData<String> goal = Transformations.map(repo.userData, input -> input.getGoal());
}
