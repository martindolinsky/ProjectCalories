package sk.itsovy.android.dolinsky.projectcalories.test.meal;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import sk.itsovy.android.dolinsky.projectcalories.R;

public class MealsViewHolder extends RecyclerView.ViewHolder {

	private TextView textViewMeal;

	public MealsViewHolder(@NonNull View itemView) {
		super(itemView);
		textViewMeal = itemView.findViewById(R.id.textViewMealTitle);
	}

	public void bind(Meal meal) {
		textViewMeal.setText(meal.getTitle());
		Log.d("MEAL", meal.getId() + " "
				+ meal.getTitle() + " " + meal.getProteins() + "");
	}
}
