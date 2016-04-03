package neagucristian.giveideas;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FilterActivity extends AppCompatActivity {

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        list = (ListView) findViewById(R.id.list);
        list.setChoiceMode(list.CHOICE_MODE_MULTIPLE);
        String[] items = new String[]{"Filtru 1",
                "Filtru 2",
                "Filtru 3",
                "Filtru 4",
                "Filtru 5",
                "Filtru 6",
                "Filtru 7",};

        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, android.R.id.text1, items);
        list.setAdapter(adapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabfilter1);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
