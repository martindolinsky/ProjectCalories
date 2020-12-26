package sk.itsovy.android.dolinsky.projectcalories.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import sk.itsovy.android.dolinsky.projectcalories.R;

public class HeightDialogFragment extends Fragment {

	private HeightDialogVM heightViewModel;

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.height_dialog_view,null, false);

		NumberPicker picker = view.findViewById(R.id.pickerHeight);
		Button submit = view.findViewById(R.id.submitHeight);

		picker.setMaxValue(300);
		picker.setMinValue(100);
		picker.setWrapSelectorWheel(true);

		heightViewModel = new ViewModelProvider(this).get(HeightDialogVM.class);

		submit.setOnClickListener(v -> {
			heightViewModel.setHeight(picker.getValue());
			getActivity().onBackPressed();
		});

		return view;
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		if (item.getItemId() == android.R.id.undo) {
			getActivity().finish();
		}
		return super.onOptionsItemSelected(item);
	}
}
