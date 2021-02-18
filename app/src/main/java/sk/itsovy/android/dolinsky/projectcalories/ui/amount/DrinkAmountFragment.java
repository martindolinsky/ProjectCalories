package sk.itsovy.android.dolinsky.projectcalories.ui.amount;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import sk.itsovy.android.dolinsky.projectcalories.R;
import sk.itsovy.android.dolinsky.projectcalories.test.user.UserViewModel;

public class DrinkAmountFragment extends Fragment {

	private static final String ERROR_MESSAGE = "Amount should be more than 1 and less than 10000";
	private MaterialButton btnSave;
	private TextInputLayout textInputLayout;
	private TextInputEditText editAmount;

	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
							 @Nullable Bundle savedInstanceState) {
		ViewModelProvider provider = new ViewModelProvider(this);
		UserViewModel userViewModel = provider.get(UserViewModel.class);

		View root = inflater.inflate(R.layout.drink_amount_fragment, container, false);
		btnSave = root.findViewById(R.id.btnSave);
		editAmount = root.findViewById(R.id.textAmount);
		textInputLayout = root.findViewById(R.id.textFieldAmount);

		if (editAmount.getText().toString() != null || !editAmount.getText().toString().equals("")) {
			textInputLayout.setErrorEnabled(false);
			btnSave.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					try {

						if (!editAmount.getText().toString().equals("")
								&& Double.parseDouble(editAmount.getText().toString()) > 0
								&& Double.parseDouble(editAmount.getText().toString()) <= 9999) {
							double amount;
							amount = Double.parseDouble(editAmount.getText().toString());
							userViewModel.setTotalDrink(amount);
							Log.d("AMOUNT", String.valueOf(amount));
							editAmount.setFocusable(false);

							getActivity().onBackPressed();
							Toast.makeText(getContext(), "Amount added successfully", Toast.LENGTH_SHORT).show();
						} else {
							textInputLayout.setError(ERROR_MESSAGE);
						}
					} catch (Exception e) {
						textInputLayout.setError(ERROR_MESSAGE);
						e.printStackTrace();
					}

				}
			});
		}

		return root;
	}


}
