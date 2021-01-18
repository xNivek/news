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
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

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
import cl.ucn.disc.dsm.jramirez.news.model.Interface.JsonPlaceHoldelderApi;
import cl.ucn.disc.dsm.jramirez.news.model.News;
import cl.ucn.disc.dsm.jramirez.news.services.Contracts;
import cl.ucn.disc.dsm.jramirez.news.services.ContractsImplNewsApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * The Main Class.
 *
 * @author  Jean Ramirez-Castillo.
 */
public class MainActivity extends AppCompatActivity {
//this is a variable of the switch
    private Switch aSwitch;

    private static final String BASE_URL="http://192.168.1.9:8000/api/";//here is my base url+

    public static final String MyPREFERENCES="nightModePrefs";
    public static final String KEY_ISNIGHTMODE ="isNightMode";
    SharedPreferences sharedpreferences;

    /**
     * The Logger.
     */
    private static final Logger log = LoggerFactory.getLogger(MainActivity.class);

    private TextView mJsonTxtView;

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

        mJsonTxtView=findViewById(R.id.jsonText);


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
       /** RecyclerView recyclerView = findViewById(R.id.am_rv_news);
        recyclerView.setAdapter(fastAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        */
       //llama a la fun
        //getNews();
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

    private void getNews(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                //.baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHoldelderApi jsonPlaceHoldelderApi=retrofit.create(JsonPlaceHoldelderApi.class);

        Call<List<News>> call = jsonPlaceHoldelderApi.getNews();
        call.enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                if(!response.isSuccessful()){
                    mJsonTxtView.setText("codigo"+ response.code());
                    return;
                }

                List<News> newsList = response.body();
                for(News news: newsList){
                    String content="";
                    content+="id" + news.getId()+"\n";
                    content+="title" + news.getTitle()+"\n";
                    content+="author" + news.getAuthor()+"\n";
                    content+="source" + news.getSource()+"\n";
                    content+="url" + news.getUrl()+"\n";
                    content+="url_image" + news.getUrlImage()+"\n";
                    content+="description" + news.getDescription()+"\n";
                    content+="contenido" + news.getContent()+"\n";
                    content+="published_at" + news.getPublishedAt()+"\n";
                    mJsonTxtView.append(content);


                }


            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {

                mJsonTxtView.setText(t.getMessage());

            }
        });

    }
}