package sk.itsovy.android.dolinsky.projectcalories.test.drink;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;
import sk.itsovy.android.dolinsky.projectcalories.R;

public class DrinksViewHolder extends RecyclerView.ViewHolder {

	private TextView textViewDrink;
	private MaterialButton btnAmount;
	private MaterialCardView cardView;

	public DrinksViewHolder(@NonNull View itemView) {
		super(itemView);
		textViewDrink = itemView.findViewById(R.id.textViewDrinkTitle);
		btnAmount = itemView.findViewById(R.id.btnAmount);
		cardView = itemView.findViewById(R.id.card_view_drink);
	}

	public void bind(Drink drink) {
		textViewDrink.setText(drink.getTitle());
		Log.d("DRINK", drink.getId() + " "
				+ drink.getTitle() + " " + drink.getProteins() + "");

		btnAmount.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				showAmountFragment(view);
			}
		});
		cardView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				showAmountFragment(view);
			}
		});
	}

	private void showAmountFragment(View view) {
		Log.d("HOLDER", "CLICK");
		AppCompatActivity activity = (AppCompatActivity) view.getContext();
		NavHostFragment navHostFragment = (NavHostFragment)
				activity.getSupportFragmentManager()
						.findFragmentById(R.id.nav_host_fragment);
		NavController navController = navHostFragment.getNavController();
		navController.navigate(R.id.actionGetAmount);
	}
}
