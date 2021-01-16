package sk.itsovy.android.dolinsky.projectcalories.test.drink;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import sk.itsovy.android.dolinsky.projectcalories.R;

public class DrinksViewHolder extends RecyclerView.ViewHolder {

	private TextView textViewDrink;

	public DrinksViewHolder(@NonNull View itemView) {
		super(itemView);
		textViewDrink = itemView.findViewById(R.id.textViewDrinkTitle);
	}

	public void bind(Drink drink) {
		textViewDrink.setText(drink.getTitle());
		Log.d("DRINK", drink.getId() + " "
//				TODO: FIX DATABASE
				+ drink.getTitle() + " " + drink.getProteins() + "");
	}
}
