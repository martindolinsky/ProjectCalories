package sk.itsovy.android.dolinsky.projectcalories.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import sk.itsovy.android.dolinsky.projectcalories.R;
import sk.itsovy.android.dolinsky.projectcalories.test.user.UserViewModel;

public class WeightDialogFragment extends Fragment {

	private UserViewModel userViewModel;

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.weight_dialog_view, null, false);

		NumberPicker picker = view.findViewById(R.id.pickerWeight);
		Button submit = view.findViewById(R.id.submitWeight);

		picker.setMaxValue(150);
		picker.setMinValue(20);
		picker.setWrapSelectorWheel(true);

		userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

		submit.setOnClickListener(v -> {
			userViewModel.setWeight(picker.getValue());
			getActivity().onBackPressed();
		});

		return view;
	}
}
