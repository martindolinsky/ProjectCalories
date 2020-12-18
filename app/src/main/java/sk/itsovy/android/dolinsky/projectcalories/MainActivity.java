package sk.itsovy.android.dolinsky.projectcalories;

import android.os.Bundle;

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
