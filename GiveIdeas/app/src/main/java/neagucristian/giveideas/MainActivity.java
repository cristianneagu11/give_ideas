package neagucristian.giveideas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.logging.Filter;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_BUDGET = "com.neagucristian.giveideas.BUDGET";
    public final static String EXTRA_SEX = "com.neagucristian.giveideas.SEX";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SeekBar budgetSeek;
        budgetSeek = (SeekBar) findViewById(R.id.budgetSeek);
        budgetSeek.setProgress(50);

        TextView budgetView;
        budgetView = (TextView) findViewById(R.id.budgetView);
        int progressBudget = (int) (10*budgetSeek.getProgress());
        String currency = getResources().getString(R.string.currency);
        budgetView.setText(Integer.toString(progressBudget) + " " + currency);
        budgetSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                TextView budgetView;
                budgetView = (TextView) findViewById(R.id.budgetView);
                int progressBudget = (int) (10 * progress);
                String currency = getResources().getString(R.string.currency);
                budgetView.setText(Integer.toString(progressBudget) + " " + currency);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "WIP!!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                startFilter(view);
            }
        });
    }

    public void startFilter(View view) {
        Intent intent = new Intent(this, FilterActivity.class);
        int budget = getBudget();
        intent.putExtra(EXTRA_BUDGET, budget);
        RadioButton r1 = (RadioButton) findViewById(R.id.male);
        RadioButton r2 = (RadioButton) findViewById(R.id.female);
        if(r1.isChecked())
            intent.putExtra(EXTRA_SEX, "male");
        if(r2.isChecked())
            intent.putExtra(EXTRA_SEX, "female");
        startActivity(intent);
    }

    public int getBudget() {
        int budget;
        SeekBar budgetSeek = (SeekBar) findViewById(R.id.budgetSeek);
        budget = budgetSeek.getProgress()*20;
        return budget;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
