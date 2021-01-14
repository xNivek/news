/*
 * Copyright 2020 Jean Ramirez Castillo jean.ramirez@alumnos.ucn.cl
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package cl.ucn.disc.dsm.jramirez.news.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ModelAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import cl.ucn.disc.dsm.jramirez.news.R;
import cl.ucn.disc.dsm.jramirez.news.model.News;
import cl.ucn.disc.dsm.jramirez.news.services.Contracts;
import cl.ucn.disc.dsm.jramirez.news.services.ContractsImplNewsApi;

/**
 * The Main Class.
 *
 * @author  Jean Ramirez-Castillo.
 */
public class MainActivity extends AppCompatActivity {

    private Switch aSwitch;

    public static final String MyPREFERENCES="nightModePrefs";
    public static final String KEY_ISNIGHTMODE ="isNightMode";
    SharedPreferences sharedpreferences;

    /**
     * The Logger.
     */
    private static final Logger log = LoggerFactory.getLogger(MainActivity.class);



    /**
     * onCreate.
     *
     * @param savedInstanceState used to reload the app.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);


        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        aSwitch = findViewById(R.id.switchl);

        checkNightModeActivated();

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    saveNightModeState(true);
                    recreate();
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    saveNightModeState(false);
                    recreate();
                }
            }
        });



        // The toolbar
        //FIXME: ver caso
       // this.setSupportActionBar(findViewById(R.id.am_t_toolbar));

        // The FastAdapter
        ModelAdapter<News, NewsItem> newsAdapter = new ModelAdapter<>(NewsItem::new);
        FastAdapter<NewsItem> fastAdapter = FastAdapter.with(newsAdapter);
        fastAdapter.withSelectable(false);

        // The Recycler view
        RecyclerView recyclerView = findViewById(R.id.am_rv_news);
        recyclerView.setAdapter(fastAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        // Get the news in the background thread
        AsyncTask.execute(() -> {

            // Using the contracts to get the news
            Contracts contracts = new ContractsImplNewsApi("12f61cbf1bc6493ba98f729b95339461");

            // Get the News from NewsApi (internet!)
            List<News> listNews = contracts.retrieveNews(30);

            // Set the adapter!
            runOnUiThread(() -> {
                newsAdapter.add(listNews);
            });

        });
    }

    private void saveNightModeState(boolean nightMode) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(KEY_ISNIGHTMODE,nightMode);
        editor.apply();
    }

    public void checkNightModeActivated(){
        if(sharedpreferences.getBoolean(KEY_ISNIGHTMODE,false)){
            aSwitch.setChecked(true);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        }else{
            aSwitch.setChecked(false);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

}