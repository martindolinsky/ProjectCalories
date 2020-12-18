package sk.itsovy.android.dolinsky.projectcalories.ui.profile;

import androidx.lifecycle.ViewModel;
import sk.itsovy.android.dolinsky.projectcalories.api.UserRepository;

public class WeightDialogVM extends ViewModel {

	private UserRepository repository = UserRepository.getInstance();

	public void setWeight(int weight) {
		repository.setUserWeight(weight);
	}
}
