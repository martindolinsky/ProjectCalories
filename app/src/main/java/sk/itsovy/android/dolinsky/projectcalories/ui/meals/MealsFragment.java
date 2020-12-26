package sk.itsovy.android.dolinsky.projectcalories.ui.meals;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import sk.itsovy.android.dolinsky.projectcalories.R;

public class MealsFragment extends Fragment {

	private MealsViewModel mViewModel;

	public static MealsFragment newInstance() {
		return new MealsFragment();
	}

	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
							 @Nullable Bundle savedInstanceState) {

		mViewModel = new ViewModelProvider(this).get(MealsViewModel.class);

		View root = inflater.inflate(R.layout.meals_fragment, container, false);


		return root;
	}


}
