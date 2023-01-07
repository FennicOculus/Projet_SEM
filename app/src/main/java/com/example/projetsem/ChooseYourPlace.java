package com.example.projetsem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import java.util.ArrayList;

public class ChooseYourPlace extends AppCompatActivity {

    //Buttons
    Button Backbtn;



    //List View
    ListView listView;
    ArrayList<String> namesArray = new ArrayList<>(); //Store Places Name
    ArrayList<Coordinats> locationsArray = new ArrayList<>(); // Store Place coordinates
    ArrayAdapter arrayAdapter;


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
                case "Buvettes":
                    Buvettes();
                    break;
                case "Discovery":
                    Discovery();
                    break;
            }
        }

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, namesArray);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> arrayAdapter, View view, int position, long id) {
                startActivity(new Intent(ChooseYourPlace.this, Compass.class).putExtra("key1", locationsArray.get(position).getLatitude()).putExtra("key2", locationsArray.get(position).getLongitude()));
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        namesArray.clear();
        locationsArray.clear();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Type here to search");


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }


    protected void Faculty(){
        //clearing previous data on array
        locationsArray.clear();
        namesArray.clear();

        //hardcoding location cuz too lazy to actually use google maps api and get the coordinates especially since internet is bad AND not all places
        //are on google maps
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

        //hardcoding location cuz too lazy to actually use google maps api and get the coordinates especially since internet is bad AND not all places
        //are on google maps
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

        //hardcoding location cuz too lazy to actually use google maps api and get the coordinates especially since internet is bad AND not all places
        //are on google maps
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
        namesArray.add("Salle de conférence Faculté Informatique");
        locationsArray.add(new Coordinats(36.71534138894215f, 3.1851521424791116f));
        namesArray.add("Centre des langues");
        locationsArray.add(new Coordinats(36.70996944294591f, 3.183422526696816f));
    }

    protected void Buvettes(){
        //clearing previous data on array
        locationsArray.clear();
        namesArray.clear();

        //hardcoding location cuz too lazy to actually use google maps api and get the coordinates especially since internet is bad AND not all places
        //are on google maps
        namesArray.add("Fast Food Faculté Informatique");
        locationsArray.add(new Coordinats(36.71492002322586f, 3.1852474623619766f));
        namesArray.add("Mécanicien");
        locationsArray.add(new Coordinats(36.70994975123639f, 3.1797288639380157f));
        namesArray.add("Buvette 1");
        locationsArray.add(new Coordinats(36.71124337840574f, 3.1783760181892218f));
        namesArray.add("Buvette 2");
        locationsArray.add(new Coordinats(36.71116536954654f, 3.178276311110557f));
        namesArray.add("Buvette 3");
        locationsArray.add(new Coordinats(36.711125052959595f, 3.178167011100341f));
        namesArray.add("Buvette 4");
        locationsArray.add(new Coordinats(36.71105955363696f, 3.1780489860104746f));
        namesArray.add("Restaurant Etudiant");
        locationsArray.add(new Coordinats(36.712133564043576f, 3.1765745747480443f));
        namesArray.add("Restaurant Enseignants");
        locationsArray.add(new Coordinats(36.71167341978842f, 3.1765534263484554f));
        namesArray.add("La marquise");
        locationsArray.add(new Coordinats(36.712617457335284f, 3.1761814058165605f));
        namesArray.add("Mc Kiffan");
        locationsArray.add(new Coordinats(36.71284981634486f, 3.1759952743816364f));
        namesArray.add("Kiosque Rectorat");
        locationsArray.add(new Coordinats(36.71270886918916f, 3.1777696445583845f));
        namesArray.add("Kiosque Faculté Informatique");
        locationsArray.add(new Coordinats(36.71515104571426f, 3.1851535057210634f));
        namesArray.add("Kiosque Cyber Espace");
        locationsArray.add(new Coordinats(36.71525660747472f, 3.18559787226526f));
        namesArray.add("Kiosque Mosqué");
        locationsArray.add(new Coordinats(36.70986038753656f, 3.179854163673416f));
        namesArray.add("Chemin des kiosques");
        locationsArray.add(new Coordinats(36.71088335673558f, 3.178764019791162f));
        namesArray.add("Kiosque Parking");
        locationsArray.add(new Coordinats(36.71183504131582f, 3.1824803171976055f));
        namesArray.add("Kiosque Kader");
        locationsArray.add(new Coordinats(36.7116274958815f, 3.1825270117906626f));
        namesArray.add("Sido");
        locationsArray.add(new Coordinats(36.712040928385065f, 3.1838115445226793f));
        namesArray.add("Kiosque Route Parking");
        locationsArray.add(new Coordinats(36.71174065488837f, 3.1843980115515365f));
    }

    protected void Discovery(){
        //clearing previous data on array
        locationsArray.clear();
        namesArray.clear();

        //hardcoding location cuz too lazy to actually use google maps api and get the coordinates especially since internet is bad AND not all places
        //are on google maps
        namesArray.add("Recorat");
        locationsArray.add(new Coordinats(36.71398611949572f, 3.1776769002775187f));
        namesArray.add("Rectorat Annexe");
        locationsArray.add(new Coordinats(36.7138674930489f, 3.177290074389978f));
        namesArray.add("English Speakers Club");
        locationsArray.add(new Coordinats(36.71360570441509f, 3.176374464971356f));
        namesArray.add("Maison de la Science");
        locationsArray.add(new Coordinats(36.71354765036708f, 3.1762725410354484f));
        namesArray.add("USTHB-Icosnet Startups Incubator");
        locationsArray.add(new Coordinats(36.71374646420998f, 3.176162949517256f));
        namesArray.add("Salle de sport");
        locationsArray.add(new Coordinats(36.71313239670855f, 3.1756141771746f));
        namesArray.add("Village Universitaire");
        locationsArray.add(new Coordinats(36.71221585513878f, 3.177500112975567f));
        namesArray.add("Bureau de bourse USTHB");
        locationsArray.add(new Coordinats(36.71182155359056f, 3.1764279174139305f));
        namesArray.add("Project Initiative Club");
        locationsArray.add(new Coordinats(36.711489610169046f, 3.1768327107935397f));
        namesArray.add("Club RO | ORS");
        locationsArray.add(new Coordinats(36.71117640508476f, 3.1771659522852373f));
        namesArray.add("Bureau de poste (approximative)");
        locationsArray.add(new Coordinats(36.71144706481668f, 3.177342371153263f));
        namesArray.add("Mosquée de L'université");
        locationsArray.add(new Coordinats(36.71025747164741f, 3.179199635336109f));
        namesArray.add("Infirmerie");
        locationsArray.add(new Coordinats(36.710367961165694f, 3.1836036547827913f));
        namesArray.add("Parking Etudiant");
        locationsArray.add(new Coordinats(36.711501825588705f, 3.1832846240109958f));
        namesArray.add("Arrêt Cous Université");
        locationsArray.add(new Coordinats(36.71088285108675f, 3.1829258581422546f));
        namesArray.add("Hall Technologique");
        locationsArray.add(new Coordinats(36.71434759581694f, 3.1869155019642474f));
        namesArray.add("Cyber Espace/Espace Internet");
        locationsArray.add(new Coordinats(36.71538640553778f, 3.1860779585445496f));
        namesArray.add("Micro Club");
        locationsArray.add(new Coordinats(36.71609510643058f, 3.185085392845442f));
        namesArray.add("Open Minds Club");
        locationsArray.add(new Coordinats(36.71596289975103f, 3.183005781243729f));
        namesArray.add("Campus Numérique Francophone Alger");
        locationsArray.add(new Coordinats(36.71603979347348f, 3.1832812560293164f));
        namesArray.add("Centre de Calcul");
        locationsArray.add(new Coordinats(36.716197523945326f, 3.183118922673524f));
        namesArray.add("Celec Club");
        locationsArray.add(new Coordinats(36.71632651911623f, 3.1820784371451585f));
        namesArray.add("Process Club");
        locationsArray.add(new Coordinats(36.71577949104755f, 3.180287038919218f));
        namesArray.add("Ozone Club");
        locationsArray.add(new Coordinats(36.71339646358549f, 3.182653001647617f));
        namesArray.add("Orbis Club");
        locationsArray.add(new Coordinats(36.71652516487551f, 3.1815306707626174f));
        namesArray.add("Club Génie Civil");
        locationsArray.add(new Coordinats(36.71463570590703f, 3.182161254612429f));
        namesArray.add("Bibliothèque");
        locationsArray.add(new Coordinats(36.71377523948523f, 3.1809531208495523f));
        namesArray.add("Auditorium");
        locationsArray.add(new Coordinats(36.714870183898476f, 3.1787441188266823f));
        namesArray.add("Lac Universitaire");
        locationsArray.add(new Coordinats(36.713897865031f, 3.1792766160968386f));
        namesArray.add("Lac Auditorium");
        locationsArray.add(new Coordinats(36.7149722426537f, 3.1783158399188687f));

    }

}