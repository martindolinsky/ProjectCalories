package sk.itsovy.android.dolinsky.projectcalories.test.user;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import sk.itsovy.android.dolinsky.projectcalories.R;

public class UserViewHolder extends RecyclerView.ViewHolder {

	private TextView txtTotal;

	public UserViewHolder(@NonNull View itemView) {
		super(itemView);
		txtTotal = itemView.findViewById(R.id.txtTotal);
	}

	public void bind(User user) {
		txtTotal.setText(user.getTodayTotal() + "");
		Log.d("BIND", user.getTodayTotal() + "");
	}
}
