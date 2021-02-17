package sk.itsovy.android.dolinsky.projectcalories.test.drink;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import sk.itsovy.android.dolinsky.projectcalories.R;
import sk.itsovy.android.dolinsky.projectcalories.ui.amount.AmountFragment;

public class DrinksAdapter extends RecyclerView.Adapter<DrinksViewHolder> {

	private List<Drink> cachedDrinks;

	public void setCachedDrinks(List<Drink> cachedDrinks) {
		this.cachedDrinks = cachedDrinks;
		notifyDataSetChanged();
	}


	@NonNull
	@Override
	public DrinksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		View itemLayout = inflater.inflate(R.layout.item_drink_layout, parent, false);
		return new DrinksViewHolder(itemLayout);
	}


	@Override
	public void onBindViewHolder(@NonNull DrinksViewHolder holder, int position) {
		holder.bind(cachedDrinks.get(position));
		holder.itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				AppCompatActivity activity = (AppCompatActivity) view.getContext();
				AmountFragment amountFragment = new AmountFragment();
				activity.getSupportFragmentManager()
						.beginTransaction()
						.replace(R.id.recyclerViewDrinkLayout, amountFragment)
						.addToBackStack(null).commit();
			}
		});

	}

	@Override
	public int getItemCount() {
		if (cachedDrinks == null) {
			return 0;
		}
		return cachedDrinks.size();
	}
}

