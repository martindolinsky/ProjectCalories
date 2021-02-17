package sk.itsovy.android.dolinsky.projectcalories.test.meal;

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

public class MealsViewHolder extends RecyclerView.ViewHolder {

	private TextView textViewMeal;
	private MaterialButton btnAmount;
	private MaterialCardView cardView;

	public MealsViewHolder(@NonNull View itemView) {
		super(itemView);
		textViewMeal = itemView.findViewById(R.id.textViewMealTitle);
		btnAmount = itemView.findViewById(R.id.btnAmount);
		cardView = itemView.findViewById(R.id.card_view_meal);
	}

	public void bind(Meal meal) {
		textViewMeal.setText(meal.getTitle());
		Log.d("MEAL", meal.getId() + " "
				+ meal.getTitle() + " " + meal.getProteins() + "");

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
