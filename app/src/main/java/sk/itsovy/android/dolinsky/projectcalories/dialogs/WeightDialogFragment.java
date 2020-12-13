package sk.itsovy.android.dolinsky.projectcalories.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProviders;
import sk.itsovy.android.dolinsky.projectcalories.R;
import sk.itsovy.android.dolinsky.projectcalories.ui.profile.ProfileViewModel;

public class WeightDialogFragment extends DialogFragment {
	private NumberPicker picker;
	private ProfileViewModel viewModel;


	@NonNull
	@Override
	public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
		viewModel =
				ViewModelProviders.of(this).get(ProfileViewModel.class);
		final LayoutInflater inflater = requireActivity().getLayoutInflater();
		View view = inflater.inflate(R.layout.height_dialog_view, null);
		picker = view.findViewById(R.id.picker_height);

		picker.setMinValue(40);
		picker.setMaxValue(250);
		picker.setWrapSelectorWheel(true);

		// Use the Builder class for convenient dialog construction
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setMessage("Enter weight")
				.setView(view)
				.setPositiveButton("Save", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {

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

}
