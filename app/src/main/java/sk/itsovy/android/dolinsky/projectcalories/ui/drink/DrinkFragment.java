package sk.itsovy.android.dolinsky.projectcalories.ui.drink;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import sk.itsovy.android.dolinsky.projectcalories.R;
import sk.itsovy.android.dolinsky.projectcalories.test.drink.Drink;
import sk.itsovy.android.dolinsky.projectcalories.test.drink.DrinkViewModel;
import sk.itsovy.android.dolinsky.projectcalories.test.drink.DrinksAdapter;

public class DrinkFragment extends Fragment {

	private MaterialButton btnAmount;
	private CardView cardViewDrink;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
							 @Nullable Bundle savedInstanceState) {

		View root = inflater.inflate(R.layout.drink_fragment, container, false);

		View viewItem = inflater.inflate(R.layout.item_drink_layout, container, false);
		cardViewDrink = viewItem.findViewById(R.id.card_view_drink);
		btnAmount = viewItem.findViewById(R.id.btnAmount);


		RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
		DrinksAdapter drinksAdapter = new DrinksAdapter();
		recyclerView.setAdapter(drinksAdapter);
		recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

		ViewModelProvider provider = new ViewModelProvider(this);
		DrinkViewModel drinkViewModel = provider.get(DrinkViewModel.class);

		cardViewDrink.setOnClickListener(v -> {
			showAmountFragment();
		});

		btnAmount.setOnClickListener(v -> {
			Log.d("AMOUNT", "CLICK");
			showAmountFragment();
		});


		drinkViewModel.getAllDrinks().observe(getViewLifecycleOwner(), new Observer<List<Drink>>() {
			@Override
			public void onChanged(List<Drink> drinks) {
				drinksAdapter.setCachedDrinks(drinks);
			}
		});

		return root;
	}

	public void showAmountFragment() {
		NavHostFragment navHostFragment = (NavHostFragment) getActivity()
				.getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
		NavController navController = navHostFragment.getNavController();
		navController.navigate(R.id.actionGetDrinkAmount);
	}


}
