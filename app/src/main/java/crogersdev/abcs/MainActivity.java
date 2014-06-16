package crogersdev.abcs;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private View.OnClickListener m_listener;
    private TextView m_numberTextView;
    //private RelativeLayout m_rlObjectField;

    Integer m_counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_counter = 1;

        m_numberTextView = (TextView)findViewById(R.id.tv_numField);
        m_numberTextView.setOnClickListener(m_listener);
        /*m_rlObjectField = (RelativeLayout)findViewById(R.id.rl_objectField);
        final RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );*/

//        Log.d("FLOW:", "Got to this point");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        TextView tv = (TextView)findViewById(R.id.tv_numField);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_counter++;
                if (m_counter > 10) {
                    m_counter = 1;
                }

                m_numberTextView.setText(m_counter.toString());
            }
        });

        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
