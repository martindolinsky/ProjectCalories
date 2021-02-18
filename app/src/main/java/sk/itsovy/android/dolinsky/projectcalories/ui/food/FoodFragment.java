package sk.itsovy.android.dolinsky.projectcalories.ui.food;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import sk.itsovy.android.dolinsky.projectcalories.R;

public class FoodFragment extends Fragment {

	private MaterialButton btnBreakfast;
	private MaterialButton btnBrunch;
	private MaterialButton btnElevenses;
	private MaterialButton btnLunch;
	private MaterialButton btnSupper;
	private MaterialButton btnDinner;

	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
							 @Nullable Bundle savedInstanceState) {

		View root = inflater.inflate(R.layout.food_fragment, container, false);

		btnBreakfast = root.findViewById(R.id.btnBreakfast);
		btnBrunch = root.findViewById(R.id.btnBrunch);
		btnElevenses = root.findViewById(R.id.btnElevenses);
		btnLunch = root.findViewById(R.id.btnLunch);
		btnSupper = root.findViewById(R.id.btnSupper);
		btnDinner = root.findViewById(R.id.btnDinner);

		btnBreakfast.setOnClickListener(v -> {
			NavHostFragment navHostFragment = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
			NavController navController = navHostFragment.getNavController();
			navController.navigate(R.id.actionGetMeals);
		});

		btnBrunch.setOnClickListener(v -> {
			NavHostFragment navHostFragment = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
			NavController navController = navHostFragment.getNavController();
			navController.navigate(R.id.actionGetMeals);
		});

		btnElevenses.setOnClickListener(v -> {
			NavHostFragment navHostFragment = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
			NavController navController = navHostFragment.getNavController();
			navController.navigate(R.id.actionGetMeals);
		});

		btnLunch.setOnClickListener(v -> {
			NavHostFragment navHostFragment = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
			NavController navController = navHostFragment.getNavController();
			navController.navigate(R.id.actionGetMeals);
		});

		btnSupper.setOnClickListener(v -> {
			NavHostFragment navHostFragment = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
			NavController navController = navHostFragment.getNavController();
			navController.navigate(R.id.actionGetMeals);
		});

		btnDinner.setOnClickListener(v -> {
			NavHostFragment navHostFragment = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
			NavController navController = navHostFragment.getNavController();
			navController.navigate(R.id.actionGetMeals);
		});

		return root;
	}


}
