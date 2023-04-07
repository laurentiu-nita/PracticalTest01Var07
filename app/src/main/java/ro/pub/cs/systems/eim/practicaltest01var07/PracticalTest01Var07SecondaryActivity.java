package ro.pub.cs.systems.eim.practicaltest01var07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var07SecondaryActivity extends AppCompatActivity {

    private EditText edit_text_top_left;
    private EditText edit_text_top_right;
    private EditText edit_text_bottom_left;
    private EditText edit_text_bottom_right;
    private Button sum_button;
    private Button product_button;

    private ButtonClickerListener buttonClickerListener = new ButtonClickerListener();
    private class ButtonClickerListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.sum_button:
                    int sum = Integer.parseInt(edit_text_top_left.getText().toString()) +
                            Integer.parseInt(edit_text_top_right.getText().toString()) +
                            Integer.parseInt(edit_text_bottom_left.getText().toString()) +
                            Integer.parseInt(edit_text_bottom_right.getText().toString());
                    setResult(sum);
                    break;
                case R.id.product_button:
                    int product = Integer.parseInt(edit_text_top_left.getText().toString()) *
                            Integer.parseInt(edit_text_top_right.getText().toString()) *
                            Integer.parseInt(edit_text_bottom_left.getText().toString()) *
                            Integer.parseInt(edit_text_bottom_right.getText().toString());
                    setResult(product);
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_secondary);

        edit_text_top_left = (EditText)findViewById(R.id.edit_text_top_left);
        edit_text_top_right = (EditText)findViewById(R.id.edit_text_top_right);
        edit_text_bottom_left = (EditText)findViewById(R.id.edit_text_bottom_left);
        edit_text_bottom_right = (EditText)findViewById(R.id.edit_text_bottom_right);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("top_left")) {
            int top_left = intent.getIntExtra("top_left", -1);
            edit_text_top_left.setText(String.valueOf(top_left));
        }

        if (intent != null && intent.getExtras().containsKey("top_right")) {
            int top_right = intent.getIntExtra("top_right", -1);
            edit_text_top_right.setText(String.valueOf(top_right));
        }

        if (intent != null && intent.getExtras().containsKey("bottom_left")) {
            int bottom_left = intent.getIntExtra("bottom_left", -1);
            edit_text_bottom_left.setText(String.valueOf(bottom_left));
        }

        if (intent != null && intent.getExtras().containsKey("bottom_right")) {
            int bottom_right = intent.getIntExtra("bottom_right", -1);
            edit_text_bottom_right.setText(String.valueOf(bottom_right));
        }

        sum_button = (Button)findViewById(R.id.sum_button);
        sum_button.setOnClickListener(buttonClickerListener);
        product_button = (Button)findViewById(R.id.product_button);
        product_button.setOnClickListener(buttonClickerListener);
    }
}