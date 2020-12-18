package sk.itsovy.android.dolinsky.projectcalories.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import sk.itsovy.android.dolinsky.projectcalories.R;
import sk.itsovy.android.dolinsky.projectcalories.test.UserViewHolder;

public class ProfileFragment extends Fragment {

	private static final String TAG = "ProfileFragment";

    private UserViewHolder viewHolder;
    private ProfileViewModel profileViewModel;
	private EditText editWeight;
	private EditText editGoal;
	public EditText editHeight;
	private TextInputEditText editText;



	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	public View onCreateView(@NonNull LayoutInflater inflater,
							 ViewGroup container, Bundle savedInstanceState) {
		profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);

		View root = inflater.inflate(R.layout.fragment_profile, container, false);

		editHeight = root.findViewById(R.id.textHeight);
		editWeight = root.findViewById(R.id.textWeight);
		editText = root.findViewById(R.id.textHeight1);

		editHeight.setOnClickListener(v -> {
			NavHostFragment navHostFragment = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
			NavController navController = navHostFragment.getNavController();
			navController.navigate(R.id.actionGetHeight);
		});

		profileViewModel.height.observe(getViewLifecycleOwner(), integer -> {
			editHeight.setText("Your height is: " + integer);
		});


		editWeight.setOnClickListener(v -> {
			NavHostFragment navHostFragment = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
			NavController navController = navHostFragment.getNavController();
			navController.navigate(R.id.actionGetWeight);
		});

		profileViewModel.weight.observe(getViewLifecycleOwner(), integer -> {
			editWeight.setText("Your weight is: " + integer);
		});



		editText.setOnClickListener(v -> {
			NavHostFragment navHostFragment = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
			NavController navController = navHostFragment.getNavController();
			navController.navigate(R.id.actionGetHeight);
		});

		profileViewModel.height.observe(getViewLifecycleOwner(), integer -> {
			editText.setHint(integer);
		});

		return root;
	}
}
