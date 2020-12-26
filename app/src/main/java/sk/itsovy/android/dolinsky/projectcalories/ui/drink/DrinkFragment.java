package sk.itsovy.android.dolinsky.projectcalories.ui.drink;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import sk.itsovy.android.dolinsky.projectcalories.R;

public class DrinkFragment extends Fragment {

	private DrinkViewModel mViewModel;

	public static DrinkFragment newInstance() {
		return new DrinkFragment();
	}

	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
							 @Nullable Bundle savedInstanceState) {
		mViewModel = new ViewModelProvider(this).get(DrinkViewModel.class);

		View root = inflater.inflate(R.layout.drink_fragment, container, false);

		return root;
	}

//	@Override
//	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//		super.onActivityCreated(savedInstanceState);
//		mViewModel = ViewModelProviders.of(this).get(DrinkViewModel.class);
//		// TODO: Use the ViewModel
//	}

}
