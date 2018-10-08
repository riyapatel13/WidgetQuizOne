package com.example.a10016322.widgetquizone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    EditText pass, pass2;
    TextView text, text2, text3;
    Button button;
    Switch aSwitch;
    String word, word2;
    ArrayList<String> prevPass = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        pass = (EditText)(findViewById(R.id.Pass_id));
        pass2 = (EditText)(findViewById(R.id.Pass2_id));
        text = (TextView)(findViewById(R.id.textView_id));
        text2 = (TextView)(findViewById(R.id.textView2_id));
        text3 = (TextView)(findViewById(R.id.textView3_id));
        button = (Button)(findViewById(R.id.button_id));
        aSwitch = (Switch)(findViewById(R.id.switch_id));


        aSwitch.setTextOff("Does Not Match");
        aSwitch.setTextOn("Match");
        aSwitch.setEnabled(false);

        prevPass.add("password");
        prevPass.add("abc");
        prevPass.add("test");
        prevPass.add("123");


        pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                for (int i=0; i<prevPass.size(); i++)
                {
                    if((s.toString()).equals(prevPass.get(i))) {

                        text3.setText("Password Already Used");
                        break;
                    }
                    else
                        text3.setText("Password Not Used Previously");
                }
                word = s.toString();
            }
        });

        pass2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
               word2 = s.toString();
            }
        });
    }

    public void onClickGo(View v)
    {
        if ((text3.getText()).equals("Password Already Used"))
            aSwitch.setChecked(false);
        else if(word.equals(word2))
            aSwitch.setChecked(true);
        else
            aSwitch.setChecked(false);
    }
}
