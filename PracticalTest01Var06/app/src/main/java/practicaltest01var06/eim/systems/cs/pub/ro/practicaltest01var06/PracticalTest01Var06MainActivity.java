package practicaltest01var06.eim.systems.cs.pub.ro.practicaltest01var06;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.NoCopySpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.EditText;
import android.text.TextWatcher;
import android.graphics.PorterDuff;

public class PracticalTest01Var06MainActivity extends ActionBarActivity {
    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private LinearLayout inv_layout;
    private int last_v = LinearLayout.VISIBLE;
    private String show_txt = "Less details";
    private Button hideButton, checkButton;
    private EditText url_text;

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.hide_show:
                    if(last_v == LinearLayout.INVISIBLE) {
                        last_v = LinearLayout.VISIBLE;
                        show_txt = "Less details";
                    } else {
                        last_v = LinearLayout.INVISIBLE;
                        show_txt = "More details";
                    }
                    inv_layout.setVisibility(last_v);
                    hideButton.setText(show_txt);
                    break;
            }
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_main);

        hideButton = (Button)findViewById(R.id.hide_show);
        hideButton.setOnClickListener(buttonClickListener);

        checkButton = (Button)findViewById(R.id.passButton);

        inv_layout = (LinearLayout) this.findViewById(R.id.laytwo);

        url_text = (EditText)findViewById(R.id.checkText);

        url_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
            }

            @Override
            public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
                if(var1.toString().startsWith("www.")) {
                    checkButton.setBackground(getApplicationContext().getResources().getDrawable(R.color.green));
                    checkButton.setText("Pass");
                } else {
                    checkButton.setBackground(getApplicationContext().getResources().getDrawable(R.color.red));
                    checkButton.setText("Fail");
                }
            }

            @Override
            public void afterTextChanged(Editable var1) {

            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_practical_test01_var06_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
