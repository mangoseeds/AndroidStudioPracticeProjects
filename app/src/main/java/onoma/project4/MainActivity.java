package onoma.project4;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.number.LocalizedNumberFormatter;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView insertText = findViewById(R.id.textInput);
        TextView countByte = findViewById(R.id.countByte);
        countByte.setText("0/80 Bytes");
//        insertText.setMaxLines(8);

        Button sendButton = findViewById(R.id.sendButton);
        Button closeButton = findViewById(R.id.closeButton);

        insertText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                int bytes = insertText.length();
                countByte.setText((int) bytes + "/80 Bytes");
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), insertText.getText(), Toast.LENGTH_LONG).show();
                insertText.setText("");
            }
        });

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}