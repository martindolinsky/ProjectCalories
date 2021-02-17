package sk.itsovy.android.dolinsky.projectcalories.test.meal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import sk.itsovy.android.dolinsky.projectcalories.R;

public class MealsAdapter extends RecyclerView.Adapter<MealsViewHolder> {

	private List<Meal> cachedMeals;

	public void setCachedMeals(List<Meal> cachedMeals) {
		this.cachedMeals = cachedMeals;
		notifyDataSetChanged();
	}


	@NonNull
	@Override
	public MealsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		View itemLayout = inflater.inflate(R.layout.item_meal_layout, parent, false);
		return new MealsViewHolder(itemLayout);
	}


	@Override
	public void onBindViewHolder(@NonNull MealsViewHolder holder, int position) {
		holder.bind(cachedMeals.get(position));
	}

	@Override
	public int getItemCount() {
		if (cachedMeals == null) {
			return 0;
		}
		return cachedMeals.size();
	}
}

