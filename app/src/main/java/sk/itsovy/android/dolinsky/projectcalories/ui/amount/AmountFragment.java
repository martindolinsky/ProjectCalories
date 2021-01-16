package sk.itsovy.android.dolinsky.projectcalories.ui.amount;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import sk.itsovy.android.dolinsky.projectcalories.R;

public class AmountFragment extends Fragment {

	private AmountViewModel mViewModel;

	public static AmountFragment newInstance() {
		return new AmountFragment();
	}

	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
							 @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.amount_fragment, container, false);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mViewModel = ViewModelProviders.of(this).get(AmountViewModel.class);
		// TODO: Use the ViewModel
	}

}
