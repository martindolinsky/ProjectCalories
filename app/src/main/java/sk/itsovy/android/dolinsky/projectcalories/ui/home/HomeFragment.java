package sk.itsovy.android.dolinsky.projectcalories.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import sk.itsovy.android.dolinsky.projectcalories.R;
import sk.itsovy.android.dolinsky.projectcalories.test.user.UserViewModel;

public class HomeFragment extends Fragment {


	private UserViewModel userViewModel;
	private MaterialButton btnAddFood;
	private MaterialButton btnAddDrink;
	private MaterialCardView cardViewFood;
	private MaterialCardView cardViewDrink;
	private TextView txtTotal;


	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	public View onCreateView(@NonNull LayoutInflater inflater,
							 ViewGroup container, Bundle savedInstanceState) {

		userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

		View view = inflater.inflate(R.layout.fragment_home, container, false);

		btnAddFood = view.findViewById(R.id.btnAddFood);
		btnAddDrink = view.findViewById(R.id.btnAddDrink);
		cardViewFood = view.findViewById(R.id.card_view1);
		cardViewDrink = view.findViewById(R.id.card_view2);
		txtTotal = view.findViewById(R.id.txtTotal);

		cardViewFood.setOnClickListener(v -> {
			NavHostFragment navHostFragment = (NavHostFragment) getActivity()
					.getSupportFragmentManager()
					.findFragmentById(R.id.nav_host_fragment);
			NavController navController = navHostFragment.getNavController();
			navController.navigate(R.id.actionGetFood);
		});

		btnAddFood.setOnClickListener(v -> {
			NavHostFragment navHostFragment = (NavHostFragment) getActivity()
					.getSupportFragmentManager()
					.findFragmentById(R.id.nav_host_fragment);
			NavController navController = navHostFragment.getNavController();
			navController.navigate(R.id.actionGetFood);
		});

		cardViewDrink.setOnClickListener(v -> {
			NavHostFragment navHostFragment = (NavHostFragment) getActivity()
					.getSupportFragmentManager()
					.findFragmentById(R.id.nav_host_fragment);
			NavController navController = navHostFragment.getNavController();
			navController.navigate(R.id.actionGetDrink);
		});

		btnAddDrink.setOnClickListener(v -> {
			NavHostFragment navHostFragment = (NavHostFragment) getActivity()
					.getSupportFragmentManager()
					.findFragmentById(R.id.nav_host_fragment);
			NavController navController = navHostFragment.getNavController();
			navController.navigate(R.id.actionGetDrink);


		});
		return view;
	}

	@SuppressLint("SetTextI18n")
	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		userViewModel.getFirstUser().observe(requireActivity(), user -> {
			txtTotal.setText("Total: " + ((user.getTodayTotal())));
		});
	}

}


