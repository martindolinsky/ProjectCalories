package sk.itsovy.android.dolinsky.projectcalories.test;

import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

	private List<User> cachedUsers;

	public void setCachedUsers(List<User> cachedUsers) {
		this.cachedUsers = cachedUsers;
		notifyDataSetChanged();
	}


	@NonNull
	@Override
	public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//		View itemLayout = inflater.inflate(R.layout.item_drink_layout, parent, false);
//		return new UserViewHolder(itemLayout);
		return null;
	}

	@Override
	public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
		holder.bind(cachedUsers.get(position));

	}

	@Override
	public int getItemCount() {
		if (cachedUsers == null) {
			return 0;
		}
		return cachedUsers.size();
	}
}
