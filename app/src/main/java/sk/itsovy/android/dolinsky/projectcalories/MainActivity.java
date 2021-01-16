package sk.itsovy.android.dolinsky.projectcalories;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		getSupportActionBar().hide();
		setContentView(R.layout.activity_main);
		BottomNavigationView navView = findViewById(R.id.nav_view);
		// Passing each menu ID as a set of Ids because each
		// menu should be considered as top level destinations.
		AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
				R.id.navigation_home, R.id.navigation_profile, R.id.navigation_notifications)
				.build();
		NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
		NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
		NavigationUI.setupWithNavController(navView, navController);

		try {
			SQLiteDatabase database = this.openOrCreateDatabase("ProjectCalories", MODE_PRIVATE, null);
			database.execSQL("CREATE TABLE IF NOT EXISTS users (" +
					"userId INT(3)," +
					"height INT(3)," +
					"weight FLOAT(3.2)," +
					"goal VARCHAR(100)" +
					")"
			);


//		database.execSQL("INSERT INTO users (userId, height, weight, goal) VALUES (3, 190, 90, 'Lose weight')");
//		database.execSQL("INSERT INTO users (userId, height, weight, goal) VALUES (4, 160, 60, 'Gain muscles')");


			Cursor cursor = database.rawQuery("SELECT * FROM users", null);

			int idIndex = cursor.getColumnIndex("userId");
			int heightIndex = cursor.getColumnIndex("height");
			int weightIndex = cursor.getColumnIndex("weight");
			int goalIndex = cursor.getColumnIndex("goal");

			cursor.moveToFirst();

			while (cursor != null) {
				Log.d("ID", cursor.getString(idIndex));
				Log.d("HEIGHT", cursor.getString(heightIndex));
				Log.d("WEIGHT", cursor.getString(weightIndex));
				Log.d("GOAL", cursor.getString(goalIndex));
				cursor.moveToNext();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


//		RecyclerView recyclerView = findViewById(R.id.recyclerView2);
//		UserAdapter adapter = new UserAdapter();
//		recyclerView.setAdapter(adapter);
//		recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//		ViewModelProvider provider = new ViewModelProvider(this);
//		UserViewModel userViewModel = provider.get(UserViewModel.class);
//		userViewModel.getAllUsers().observe(this, new Observer<List<User>>() {
//			@Override
//			public void onChanged(List<User> users) {
//				adapter.setCachedUsers(users);
//			}
//		});


    }



}
