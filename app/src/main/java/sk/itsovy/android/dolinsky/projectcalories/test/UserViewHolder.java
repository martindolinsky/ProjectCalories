package sk.itsovy.android.dolinsky.projectcalories.test;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {

//	private TextView textViewDrink;

	public UserViewHolder(@NonNull View itemView) {
		super(itemView);
//		textViewDrink = itemView.findViewById(R.id.textViewDrinkTitle);
	}

	public void bind(User user) {
//		textViewDrink.setText(user.getHeight() + "");
//		Log.d("uSER",user.getHeight() + "");
	}
}
