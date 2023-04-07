package ro.pub.cs.systems.eim.practicaltest01var07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var07MainActivity extends AppCompatActivity {

    private EditText edit_text_top_left;
    private EditText edit_text_top_right;
    private EditText edit_text_bottom_left;
    private EditText edit_text_bottom_right;
    private Button set_button;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.set_button:
                    if (edit_text_top_left.getText().toString().matches("[0-9]+") &&
                            edit_text_top_right.getText().toString().matches("[0-9]+") &&
                            edit_text_bottom_left.getText().toString().matches("[0-9]+") &&
                            edit_text_bottom_right.getText().toString().matches("[0-9]+")) {
                        int top_left = Integer.parseInt(edit_text_top_left.getText().toString());
                        int top_right = Integer.parseInt(edit_text_top_right.getText().toString());
                        int bottom_left = Integer.parseInt(edit_text_bottom_left.getText().toString());
                        int bottom_right = Integer.parseInt(edit_text_bottom_right.getText().toString());

                        Intent intent = new Intent(getApplicationContext(), PracticalTest01Var07SecondaryActivity.class);
                        intent.putExtra("top_left", top_left);
                        intent.putExtra("top_right", top_right);
                        intent.putExtra("bottom_left", bottom_left);
                        intent.putExtra("bottom_right", bottom_right);
                        startActivityForResult(intent, 1);
                    } else {
                        // display message with toast
                        Toast.makeText(getApplicationContext(), "Toate campurile trebuie completate cu numere!", Toast.LENGTH_LONG).show();
                    }
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_main);

        edit_text_top_left = (EditText)findViewById(R.id.edit_text_top_left);
        edit_text_top_right = (EditText)findViewById(R.id.edit_text_top_right);
        edit_text_bottom_left = (EditText)findViewById(R.id.edit_text_bottom_left);
        edit_text_bottom_right = (EditText)findViewById(R.id.edit_text_bottom_right);
        set_button = (Button)findViewById(R.id.set_button);
        set_button.setOnClickListener(buttonClickListener);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("edit_text_top_left")) {
                edit_text_top_left.setText(savedInstanceState.getString("edit_text_top_left"));
            }
            if (savedInstanceState.containsKey("edit_text_top_right")) {
                edit_text_top_right.setText(savedInstanceState.getString("edit_text_top_right"));
            }
            if (savedInstanceState.containsKey("edit_text_bottom_left")) {
                edit_text_bottom_left.setText(savedInstanceState.getString("edit_text_bottom_left"));
            }
            if (savedInstanceState.containsKey("edit_text_bottom_right")) {
                edit_text_bottom_right.setText(savedInstanceState.getString("edit_text_bottom_right"));
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("edit_text_top_left", edit_text_top_left.getText().toString());
        savedInstanceState.putString("edit_text_top_right", edit_text_top_right.getText().toString());
        savedInstanceState.putString("edit_text_bottom_left", edit_text_bottom_left.getText().toString());
        savedInstanceState.putString("edit_text_bottom_right", edit_text_bottom_right.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("edit_text_top_left")) {
            edit_text_top_left.setText(savedInstanceState.getString("edit_text_top_left"));
        }
        if (savedInstanceState.containsKey("edit_text_top_right")) {
            edit_text_top_right.setText(savedInstanceState.getString("edit_text_top_right"));
        }
        if (savedInstanceState.containsKey("edit_text_bottom_left")) {
            edit_text_bottom_left.setText(savedInstanceState.getString("edit_text_bottom_left"));
        }
        if (savedInstanceState.containsKey("edit_text_bottom_right")) {
            edit_text_bottom_right.setText(savedInstanceState.getString("edit_text_bottom_right"));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        switch (requestCode) {
            case 1:
                Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
                break;
        }
    }
}