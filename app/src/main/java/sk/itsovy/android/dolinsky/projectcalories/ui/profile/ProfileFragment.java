package sk.itsovy.android.dolinsky.projectcalories.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import sk.itsovy.android.dolinsky.projectcalories.R;
import sk.itsovy.android.dolinsky.projectcalories.dialogs.HeightDialogFragment;
import sk.itsovy.android.dolinsky.projectcalories.test.User;
import sk.itsovy.android.dolinsky.projectcalories.test.UserAdapter;
import sk.itsovy.android.dolinsky.projectcalories.test.UserViewHolder;
import sk.itsovy.android.dolinsky.projectcalories.test.UserViewModel;

public class ProfileFragment extends Fragment {

	private static final String TAG = "ProfileFragment";

    private UserViewHolder viewHolder;
	private EditText editWeight;
	private EditText editGoal;
	public EditText editHeight;


	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}


	public View onCreateView(@NonNull LayoutInflater inflater,
							 ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        User user = new User();

		editHeight = view.findViewById(R.id.textHeight);

		editHeight.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Toast.makeText(getActivity(), "height", Toast.LENGTH_SHORT).show();
				DialogFragment dialogFragment = new HeightDialogFragment();
				dialogFragment.show(getParentFragmentManager(),"HeightDialogFragment");
			}
		});
		editHeight.setText(user.getText());

//		RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
//		UserAdapter adapter = new UserAdapter();
//
//		recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//		recyclerView.setAdapter(adapter);
//
//		ViewModelProvider provider = new ViewModelProvider(this);
//		UserViewModel userViewModel = provider.get(UserViewModel.class);
//
//		userViewModel.getAllUsers().observe(requireActivity(), new Observer<List<User>>() {
//			@Override
//			public void onChanged(List<User> users) {
//				adapter.setCachedUsers(users);
//
//			}
//		});

        return view;
    }

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);



//		editWeight = view.findViewById(R.id.text_weight);
//		editGoal = view.findViewById(R.id.text_goal);
//
//


//
//		editHeight.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View view) {
//				Toast.makeText(getActivity(), "height", Toast.LENGTH_SHORT).show();
//				DialogFragment dialogFragment = new HeightDialogFragment();
//				dialogFragment.show(getParentFragmentManager(),"height");
//
//			}
//		});
//
//		editGoal.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View view) {
//				Toast.makeText(getActivity(), "Goal", Toast.LENGTH_SHORT).show();
//				DialogFragment dialogFragment = new GoalDialogFragment();
//				dialogFragment.show(getParentFragmentManager(),"goal");
//			}
//		});
	}
}
