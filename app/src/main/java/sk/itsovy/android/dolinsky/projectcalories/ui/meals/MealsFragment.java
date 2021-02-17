package sk.itsovy.android.dolinsky.projectcalories.ui.meals;

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
import sk.itsovy.android.dolinsky.projectcalories.test.meal.Meal;
import sk.itsovy.android.dolinsky.projectcalories.test.meal.MealViewModel;
import sk.itsovy.android.dolinsky.projectcalories.test.meal.MealsAdapter;

public class MealsFragment extends Fragment {

	private MealViewModel mViewModel;
	private MaterialButton btnAmount;
	private CardView cardViewMeal;

	public static MealsFragment newInstance() {
		return new MealsFragment();
	}

	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
							 @Nullable Bundle savedInstanceState) {

		mViewModel = new ViewModelProvider(this).get(MealViewModel.class);

		View root = inflater.inflate(R.layout.meals_fragment, container, false);

		View viewItem = inflater.inflate(R.layout.item_meal_layout, container, false);
		cardViewMeal = viewItem.findViewById(R.id.card_view_meal);
		btnAmount = viewItem.findViewById(R.id.btnAmount);

		RecyclerView recyclerView = root.findViewById(R.id.recyclerViewMeals);
		MealsAdapter mealsAdapter = new MealsAdapter();
		recyclerView.setAdapter(mealsAdapter);
		recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

		ViewModelProvider provider = new ViewModelProvider(this);
		MealViewModel mealViewModel = provider.get(MealViewModel.class);

		cardViewMeal.setOnClickListener(v -> {
			showAmountFragment();
		});

		btnAmount.setOnClickListener(v -> {
			Log.d("AMOUNT", "CLICK");
			showAmountFragment();
		});

		mealViewModel.getAllMeals().observe(getViewLifecycleOwner(), new Observer<List<Meal>>() {
			@Override
			public void onChanged(List<Meal> meals) {
				mealsAdapter.setCachedMeals(meals);
			}
		});

		return root;
	}

	public void showAmountFragment() {
		NavHostFragment navHostFragment = (NavHostFragment) getActivity()
				.getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
		NavController navController = navHostFragment.getNavController();
		navController.navigate(R.id.actionGetAmount);
	}
}
