package com.example.projetsem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class ChooseYourPlace extends AppCompatActivity {

    //Buttons
    private Button Backbtn;



    //List View
    private ListView listView;
    private ArrayList<String> namesArray = new ArrayList<>(); //Store Places Name
    private ArrayList<Coordinats> locationsArray = new ArrayList<>(); // Store Place coordinates


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_your_place);

        Backbtn = findViewById(R.id.BackBtn);
        listView = findViewById(R.id.listView);

        Backbtn.setOnClickListener(v -> {
            finish();
        });

        //Add places to the list
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("key");
            switch (value){
                case "Amphi":
                    Amphis();
                    break;
                case "Salles":
                    Salles();
                    break;
                case "Faculty":
                    Faculty();
                    break;
            }
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, namesArray);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> arrayAdapter, View view, int position, long id) {
                startActivity(new Intent(ChooseYourPlace.this, Compass.class).putExtra("key1", locationsArray.get(position).getLatitude()).putExtra("key2", locationsArray.get(position).getLongitude()));
            }
        });




    }


    protected void Faculty(){
        //clearing previous data on array
        locationsArray.clear();
        namesArray.clear();

        //hardcoding location cuz too lazy to actually use google maps api and get the coordinates especially since internet at uni SUCKS sa race
        namesArray.add("Biologie 1");
        locationsArray.add(new Coordinats(36.71268305718414f, 3.1825495347899957f));
        namesArray.add("Biologie 2");
        locationsArray.add(new Coordinats(36.712723647067854f, 3.184952087742557f));
        namesArray.add("Chimi 1");
        locationsArray.add(new Coordinats(36.71329670469951f, 3.182500915221951f));
        namesArray.add("Chimi 2");
        locationsArray.add(new Coordinats(36.7132843202149f, 3.1849001540818023f));
        namesArray.add("Physique 1");
        locationsArray.add(new Coordinats(36.71394205413497f, 3.1825078461757963f));
        namesArray.add("Physique 2");
        locationsArray.add(new Coordinats(36.71397934874606f, 3.1848969880702356f));
        namesArray.add("Géni civil 1");
        locationsArray.add(new Coordinats(36.714492698496635f, 3.1822115619512434f));
        namesArray.add("Géni civil 2");
        locationsArray.add(new Coordinats(36.715560885163846f, 3.1841299033448696f));
        namesArray.add("Géni electrique 1");
        locationsArray.add(new Coordinats(36.71518728426987f, 3.1816064164869826f));
        namesArray.add("Géni electrique 2");
        locationsArray.add(new Coordinats(36.71688963758551f, 3.182510421447779f));
        namesArray.add("Science de la terre 1");
        locationsArray.add(new Coordinats(36.71540232424968f, 3.1809428565494344f));
        namesArray.add("Science de la terre 2");
        locationsArray.add(new Coordinats(36.71713061414517f, 3.1818479706205944f));
        namesArray.add("Génie mécanique 1");
        locationsArray.add(new Coordinats(36.71571107051627f, 3.180144309713075f));
        namesArray.add("Génie mécanique 2");
        locationsArray.add(new Coordinats(36.71739385355226f, 3.181069385953409f));
        namesArray.add("Mathématique");
        locationsArray.add(new Coordinats(36.717248075452744f, 3.183856873622327f));
        namesArray.add("Informatique");
        locationsArray.add(new Coordinats(36.71584137452138f, 3.185081205157544f));


    }

    protected void Amphis(){
        //clearing previous data on array
        locationsArray.clear();
        namesArray.clear();

        //hardcoding location cuz too lazy to actually use google maps api and get the coordinates especially since internet at uni SUCKS sa race
        namesArray.add("Amphitheatre A");
        locationsArray.add(new Coordinats(36.712053623104076f, 3.1804067578997417f));
        namesArray.add("Amphitheatre B");
        locationsArray.add(new Coordinats(36.71215423438469f, 3.180670164164957f));
        namesArray.add("Amphitheatre C");
        locationsArray.add(new Coordinats(36.71224242441122f, 3.1808917353174606f));
        namesArray.add("Amphitheatre D");
        locationsArray.add(new Coordinats(36.712093370783634f, 3.1808793397294206f));
        namesArray.add("Amphitheatre E");
        locationsArray.add(new Coordinats(36.71191947452238f, 3.1807058014841028f));
        namesArray.add("Amphitheatre F");
        locationsArray.add(new Coordinats(36.711653983695314f, 3.1802005658915236f));
        namesArray.add("Amphitheatre G");
        locationsArray.add(new Coordinats(36.71157937213939f, 3.1799813297170423f));
        namesArray.add("Amphitheatre H");
        locationsArray.add(new Coordinats(36.71167553813027f, 3.1797786396458316f));
        namesArray.add("Amphitheatre I");
        locationsArray.add(new Coordinats(36.71177170400185f, 3.1799482374411863f));
        namesArray.add("Amphitheatre J");
        locationsArray.add(new Coordinats(36.71185128945971f, 3.18012404003393f));
        namesArray.add("Amphitheatre K");
        locationsArray.add(new Coordinats(36.71137709155288f, 3.1796152466355734f));
        namesArray.add("Amphitheatre L");
        locationsArray.add(new Coordinats(36.71142517469048f, 3.179255368386896f));
        namesArray.add("Amphitheatre M");
        locationsArray.add(new Coordinats(36.7111040061575f, 3.1822305482368414f));
        namesArray.add("Amphitheatre N");
        locationsArray.add(new Coordinats(36.7108067164194f, 3.1820685712539296f));
        namesArray.add("Amphitheatre O");
        locationsArray.add(new Coordinats(36.71097985081226f, 3.181807134729245f));
        namesArray.add("Amphitheatre P");
        locationsArray.add(new Coordinats(36.71074634709859f, 3.1818099764306007f));
        namesArray.add("Amphitheatre Z");
        locationsArray.add(new Coordinats(36.7106461111404f, 3.181575536068791f));
        namesArray.add("Amphitheatre R");
        locationsArray.add(new Coordinats(36.71059665120714f, 3.1810434352338084f));
        namesArray.add("Amphitheatre S");
        locationsArray.add(new Coordinats(36.71033239197395f, 3.181091744151463f));
        namesArray.add("Amphitheatre T");
        locationsArray.add(new Coordinats(36.71049983219633f, 3.18081183656797f));
        namesArray.add("Amphitheatre U");
        locationsArray.add(new Coordinats(36.71021165253957f, 3.1808615663416866f));
        namesArray.add("Amphitheatre V");
        locationsArray.add(new Coordinats(36.71028569089445f, 3.1806328093825877f));
        namesArray.add("Amphitheatre W");
        locationsArray.add(new Coordinats(36.710144136109335f, 3.1805885106613614f));
        namesArray.add("Amphitheatre X");
        locationsArray.add(new Coordinats(36.71006649158906f, 3.1803028751021625f));



    }

    protected void Salles(){
        //clearing previous data on array
        locationsArray.clear();
        namesArray.clear();

        //hardcoding location cuz too lazy to actually use google maps api and get the coordinates especially since internet
        namesArray.add("Bloc 100/200 1");
        locationsArray.add(new Coordinats(36.71211260165351f, 3.181799273487491f));
        namesArray.add("Bloc 100/200 2");
        locationsArray.add(new Coordinats(36.71083639559162f, 3.1793579222199373f));
        namesArray.add("Bloc 300/400 1");
        locationsArray.add(new Coordinats(36.711612088653425f, 3.1822366383240412f));
        namesArray.add("Bloc 300/400 2");
        locationsArray.add(new Coordinats(36.71032384240712f, 3.179790880076175f));
        namesArray.add("Nouveau Blocs");
        locationsArray.add(new Coordinats(36.7099330055378f, 3.1824201467306983f));
        namesArray.add("Nouveau Nouveau Blocs");
        locationsArray.add(new Coordinats(36.70938817472637f, 3.1813432678155347f));
        namesArray.add("dummy test");
        locationsArray.add(new Coordinats(36.789490591185135f, 2.9071787495555994f));
    }


}