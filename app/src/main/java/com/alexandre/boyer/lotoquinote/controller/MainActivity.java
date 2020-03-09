package com.alexandre.boyer.lotoquinote.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.alexandre.boyer.lotoquinote.R;
import com.alexandre.boyer.lotoquinote.model.Tirage;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
<<<<<<< HEAD
    ListView mListView;
    Button mNewDrawButton;
    CheckBox mDrawCheckbox;
    ImageButton mDeleteButton;
    ImageButton mEditButton;
=======
    private ListView mListView;
    private Button mNewDrawButton;
    private CheckBox mDrawCheckbox;
    private ImageButton mDeleteButton;
>>>>>>> 4a969e8... Ajout de la liste sur l'interface graphique de activityDraw

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.listView);
        mNewDrawButton = findViewById(R.id.newDraw);
        mDrawCheckbox = findViewById(R.id.activity_main_tirage_checkbox);
        mDeleteButton = findViewById(R.id.deleteButton);
        mEditButton = findViewById(R.id.editButton);

        //On cache les ImageButton mDeleteButton et mEditButton
        mDeleteButton.setVisibility(View.GONE);
        mEditButton.setVisibility(View.GONE);

        final List<Tirage> draws = new ArrayList<>();

        mNewDrawButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Date today = new Date();
                Tirage mDraw = new Tirage("Suivi du tirage n° ",today);
                draws.add(mDraw);

                ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
                HashMap<String,String> map;

                // Ajout d'un item dans la listItem
                for (int i=0; i<draws.size();i++){
                    map = new HashMap<String,String>();
                    map.put("titre",draws.get(i).getTitle());
                    listItem.add(map);

                    SimpleAdapter adapter = new SimpleAdapter(MainActivity.this,
                            listItem,R.layout.liste_tirages_items, new String[] {"titre"},
                            new int[] {R.id.activity_main_name_tirage_txt});
                    mListView.setAdapter(adapter);
                }
                // Compter le nombre de tirages pour savoir quel numéro de tirage doit être crée
            }
        });

        mDeleteButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(mDrawCheckbox.isChecked())
                // /!\ ERREUR : java.lang.NullPointerException: Attempt to invoke virtual method 'boolean android.widget.CheckBox.isChecked()' on a null object reference
                {
                    int id = mDrawCheckbox.getId(); // Je ne sais pas si ça fonctionne correctement de récupérer l'Id
                    // Je pense que si ça fonctionne, il faut stocker les Id dans un tableau pour gérer le cas où plusieurs Checkbox sont cochées

                    // Suppression de l'item ou des items check de la ListView
                    draws.remove(id);
                }
            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                // Permet de lancer l'activité "DrawTackingActivity" qui affiche la vue de suivi de tirage
                Intent drawTrackingActivity = new Intent(MainActivity.this, DrawTrackingActivity.class);
                startActivity(drawTrackingActivity);
            }
        });

        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id){
                if(mDeleteButton.getVisibility() == View.GONE){
                    mEditButton.setVisibility(View.VISIBLE);
                    mDeleteButton.setVisibility(View.VISIBLE);
                    return false;
                }else{
                    mEditButton.setVisibility(View.GONE);
                    mDeleteButton.setVisibility(View.GONE);
                    return true;
                }
            }
        });
    }

}