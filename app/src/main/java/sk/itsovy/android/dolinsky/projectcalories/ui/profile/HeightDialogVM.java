package sk.itsovy.android.dolinsky.projectcalories.ui.profile;

import androidx.lifecycle.ViewModel;
import sk.itsovy.android.dolinsky.projectcalories.api.UserRepository;

public class HeightDialogVM extends ViewModel {
	private UserRepository repository = UserRepository.getInstance();

	public void setHeight(int height) {
		repository.setUserHeight(height);
	}

}
