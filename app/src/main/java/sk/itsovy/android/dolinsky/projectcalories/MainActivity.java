package sk.itsovy.android.dolinsky.projectcalories;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import sk.itsovy.android.dolinsky.projectcalories.dialogs.HeightDialogFragment;
import sk.itsovy.android.dolinsky.projectcalories.test.User;
import sk.itsovy.android.dolinsky.projectcalories.test.UserAdapter;
import sk.itsovy.android.dolinsky.projectcalories.test.UserViewModel;

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
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
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
