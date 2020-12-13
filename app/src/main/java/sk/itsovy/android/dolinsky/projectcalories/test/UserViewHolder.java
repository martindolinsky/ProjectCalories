package sk.itsovy.android.dolinsky.projectcalories.test;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import sk.itsovy.android.dolinsky.projectcalories.R;

public class UserViewHolder extends RecyclerView.ViewHolder {

	private EditText editTextHeight;
	private TextView textView;

	public UserViewHolder(@NonNull View itemView) {
		super(itemView);
		editTextHeight = itemView.findViewById(R.id.textHeight);
		textView = itemView.findViewById(R.id.textView);
	}

	public void bind(User user) {
		editTextHeight.setText(user.getText());
//		textView.setText(user.getText());
	}
}
