package com.curios.textformatterdemo;

import androidx.appcompat.app.AppCompatActivity;
import com.curios.textformatter.FormatText;
import android.os.Bundle;
import android.widget.TextView;

import java.text.Format;

public class MainActivity extends AppCompatActivity {

    TextView boldTv,italicsTv,boldItalicsTv,colorForegroundTv,colorBackgroundTv;
    String boldText, italicsText, boldItalicsText, colorText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boldTv = findViewById(R.id.bold);
        italicsTv = findViewById(R.id.italic);
        boldItalicsTv = findViewById(R.id.bold_italic);
        colorBackgroundTv = findViewById(R.id.color_wrap1);
        colorForegroundTv = findViewById(R.id.color_wrap2);

        boldText = "*hello* world! Just *Coding*!!";
        italicsText = "_hello_ world! Just _Coding_!!";
        boldItalicsText = "_hello_ world! Just *Coding*!!";
        colorText = "hello world! #Just# Coding!!";

        boldTv.setText(FormatText.bold(boldText));
        italicsTv.setText(FormatText.italics(italicsText));
        boldItalicsTv.setText(FormatText.boldAndItalics(boldItalicsText));
        colorBackgroundTv.setText(FormatText.colorText(colorText,"#b5bf50",true));
        colorForegroundTv.setText(FormatText.colorText(colorText,"#cd001a",false));
    }
}