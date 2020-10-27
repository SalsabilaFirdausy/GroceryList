package mobile.firda.loginviewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.Toast;

import mobile.firda.loginviewmodel.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ViewModel loginViewModel = new ViewModel();
        binding.setLoginViewModel(loginViewModel);

        loginViewModel.getUser().observe(this, new Observer() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user.getEmail().length() > 0 || user.getPassword().length() > 0)
                    Toast.makeText(getApplicationContext(), "email : " + user.getEmail() + " password " + user.getPassword(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}