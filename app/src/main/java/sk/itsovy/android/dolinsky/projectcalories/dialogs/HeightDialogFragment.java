package sk.itsovy.android.dolinsky.projectcalories.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;

import com.google.android.material.textfield.TextInputEditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import sk.itsovy.android.dolinsky.projectcalories.R;
import sk.itsovy.android.dolinsky.projectcalories.test.User;
import sk.itsovy.android.dolinsky.projectcalories.test.UserViewModel;
import sk.itsovy.android.dolinsky.projectcalories.ui.profile.ProfileFragment;
import sk.itsovy.android.dolinsky.projectcalories.ui.profile.ProfileViewModel;

public class HeightDialogFragment extends DialogFragment {

	private static final String TAG = "HeightDialogFragment";

	private NumberPicker picker;
	private ProfileViewModel viewModel;


	@NonNull
	@Override
	public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
		LayoutInflater inflater = requireActivity().getLayoutInflater();
		View view = inflater.inflate(R.layout.height_dialog_view,null);

		ViewModelProvider provider = new ViewModelProvider(requireActivity());
		UserViewModel userViewModel = provider.get(UserViewModel.class);



		picker = view.findViewById(R.id.picker_height);
		picker.setValue(150);
		picker.setMinValue(100);
		picker.setMaxValue(300);
		picker.setWrapSelectorWheel(true);

		// Use the Builder class for convenient dialog construction
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setMessage("Enter height")
				.setView(view)
				.setPositiveButton("Save", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						int input = picker.getValue();
						if (input > 0) {
							ProfileFragment fragment = (ProfileFragment) getParentFragmentManager().findFragmentByTag("ProfileFragment");
							fragment.editHeight.setText(String.valueOf(input));
							User user = new User();
							user.setText(String.valueOf(input));
						}

					}
				})
				.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						// User cancelled the dialog
					}
				});
		// Create the AlertDialog object and return it
		return builder.create();
	}

	public String getSelectedHeight() {
		return String.valueOf(picker.getValue());
	}
}
