package sk.itsovy.android.dolinsky.projectcalories.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import sk.itsovy.android.dolinsky.projectcalories.R;

public class HomeFragment extends Fragment {

	private MaterialButton btnAddFood;
	private MaterialButton btnAddDrink;
	private MaterialCardView cardViewFood;
	private MaterialCardView cardViewDrink;


	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	public View onCreateView(@NonNull LayoutInflater inflater,
							 ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_home, container, false);

		btnAddFood = view.findViewById(R.id.btnAddFood);
		btnAddDrink = view.findViewById(R.id.btnAddDrink);
		cardViewFood = view.findViewById(R.id.card_view1);
		cardViewDrink = view.findViewById(R.id.card_view2);

		ViewModelProvider provider = new ViewModelProvider(this);
		HomeViewModel homeViewModel = provider.get(HomeViewModel.class);

		cardViewFood.setOnClickListener(v -> {
			NavHostFragment navHostFragment = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
			NavController navController = navHostFragment.getNavController();
			navController.navigate(R.id.actionGetFood);
		});

		btnAddFood.setOnClickListener(v -> {
			NavHostFragment navHostFragment = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
			NavController navController = navHostFragment.getNavController();
			navController.navigate(R.id.actionGetFood);
		});

		cardViewDrink.setOnClickListener(v -> {
			NavHostFragment navHostFragment = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
			NavController navController = navHostFragment.getNavController();
			navController.navigate(R.id.actionGetDrink);
		});

		btnAddDrink.setOnClickListener(v -> {
			NavHostFragment navHostFragment = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
			NavController navController = navHostFragment.getNavController();
			navController.navigate(R.id.actionGetDrink);
		});

		homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
			@Override
			public void onChanged(@Nullable String s) {
//                textView.setText(s);
			}
		});

		return view;
	}

}
