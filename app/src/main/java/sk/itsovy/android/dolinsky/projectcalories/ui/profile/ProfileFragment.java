package sk.itsovy.android.dolinsky.projectcalories.ui.profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import sk.itsovy.android.dolinsky.projectcalories.R;
import sk.itsovy.android.dolinsky.projectcalories.test.user.UserViewModel;

public class ProfileFragment extends Fragment {

	private static final String TAG = "ProfileFragment";

	private UserViewModel userViewModel;
	private TextInputEditText editWeight;
	private TextInputEditText editHeight;
	private TextInputLayout inputLayoutGoals;
	private AutoCompleteTextView autoCompleteTextViewGoals;
	private ArrayList<String> goals;
	private ArrayAdapter<String> arrayAdapter;


	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	public View onCreateView(@NonNull LayoutInflater inflater,
							 ViewGroup container, Bundle savedInstanceState) {
		userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

		View root = inflater.inflate(R.layout.fragment_profile, container, false);

		editWeight = root.findViewById(R.id.textWeight);
		editHeight = root.findViewById(R.id.textHeight);
		inputLayoutGoals = root.findViewById(R.id.textFieldGoals);
		autoCompleteTextViewGoals = root.findViewById(R.id.textViewGoals);

		showHeightFragment();
		userViewModel.getFirstUser().observe(requireActivity(), user -> {
			Log.d("OBSERVE HEIGHT2", String.valueOf(user.getHeight()));
			editHeight.setText(String.valueOf(user.getHeight()));
		});

		showWeightFragment();
		userViewModel.getFirstUser().observe(requireActivity(), user -> {
			Log.d("OBSERVE WEIGHT2", String.valueOf(user.getWeight()));
			editWeight.setText(String.valueOf(user.getWeight()));
		});

		return root;
	}

	private void showWeightFragment() {
		editWeight.setOnClickListener(v -> {
			NavHostFragment navHostFragment = (NavHostFragment) getActivity()
					.getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
			NavController navController = navHostFragment.getNavController();
			navController.navigate(R.id.actionGetWeight);
		});
	}

	private void showHeightFragment() {
		editHeight.setOnClickListener(v -> {
			NavHostFragment navHostFragment = (NavHostFragment) getActivity()
					.getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
			NavController navController = navHostFragment.getNavController();
			navController.navigate(R.id.actionGetHeight);
		});
	}

}
