package crogersdev.abcs;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    private View.OnClickListener m_listener;
    private TextView m_numberTextView;
    private RelativeLayout m_rlObjectField;

    Integer m_counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_counter = 1;

        m_numberTextView = (TextView)findViewById(R.id.tv_numField);
        m_numberTextView.setOnClickListener(m_listener);
        m_rlObjectField = (RelativeLayout)findViewById(R.id.rl_objectField);
        final RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        m_listener = new View.OnClickListener() {
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "msg msg", Toast.LENGTH_SHORT).show();
                m_counter++;
                if (m_counter > 10) {
                    m_counter = 1;
                }

                m_numberTextView.setText(m_counter.toString());

                LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View circleView = vi.inflate(R.layout.activity_main, null);

                circleView.setBackgroundColor(Color.parseColor("#FF0000"));
                circleView.setLayoutParams(lp);
                circleView.setId(m_counter);

                m_rlObjectField.addView(circleView);
            }
        };


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
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
