package com.alexandre.boyer.lotoquinote.model;

import android.annotation.SuppressLint;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Alexandre BOYER on 07/03/2020.
 */
public class Tirage
{
    String title;
    String date;
    Date today = new Date();
    ArrayList <Number> draw;


    public Tirage(String title, Date today)
    {
        this.title = title;
        this.today = today;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        title = title;
    }

    @SuppressLint("SimpleDateFormat")
    public String getDate()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");
        date = formatter.format(today);
        return date;
    }

    public void setDate(Date today)
    {
        this.today = new Date();
    }

    // Ajouter un nombre à la liste
    public void addNumber(Number n, ArrayList<Number> draw)
    {
        draw.add(n);
    }

    // Supprimer le dernier nombre ajouté à la liste
    public void deleteNumber(ArrayList<Number> draw)
    {
        if(draw.size() > 0)
            draw.remove(draw.size() - 1);
    }

    // Récupérer un nombre situé à un index i
    public Number getNumber(int i, ArrayList<Number> draw)
    {
        return draw.get(i);
    }
}
