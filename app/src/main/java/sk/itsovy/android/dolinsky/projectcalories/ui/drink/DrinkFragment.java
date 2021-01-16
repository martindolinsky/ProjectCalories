package sk.itsovy.android.dolinsky.projectcalories.ui.drink;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import sk.itsovy.android.dolinsky.projectcalories.R;
import sk.itsovy.android.dolinsky.projectcalories.test.drink.Drink;
import sk.itsovy.android.dolinsky.projectcalories.test.drink.DrinkViewModel;
import sk.itsovy.android.dolinsky.projectcalories.test.drink.DrinksAdapter;

public class DrinkFragment extends Fragment {

	private DrinkViewModel mViewModel;

	public static DrinkFragment newInstance() {
		return new DrinkFragment();
	}


	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
							 @Nullable Bundle savedInstanceState) {
//		mViewModel = new ViewModelProvider(this).get(DrinkViewModel.class);

		View root = inflater.inflate(R.layout.drink_fragment, container, false);


		RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
		DrinksAdapter drinksAdapter = new DrinksAdapter();
		recyclerView.setAdapter(drinksAdapter);
		recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

		ViewModelProvider provider = new ViewModelProvider(this);
		DrinkViewModel drinkViewModel = provider.get(DrinkViewModel.class);
		drinkViewModel.getAllDrinks().observe(getViewLifecycleOwner(), new Observer<List<Drink>>() {
			@Override
			public void onChanged(List<Drink> drinks) {
				drinksAdapter.setCachedDrinks(drinks);
			}
		});
		return root;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mViewModel = ViewModelProviders.of(this).get(DrinkViewModel.class);
	}

}
