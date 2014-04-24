package hiof.android14.group26.peacekeeper;

import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.content.Intent;

public class LogOutActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
	}
	
	public void startLogInActivity(View view) {
		Intent intent = new Intent(this, LogInActivity.class);
		startActivity(intent);
	}
	
	public void startCreateAccountActivity(View view) {
		Intent intent = new Intent(this, CreateAccountActivity.class);
		startActivity(intent);
	}
}