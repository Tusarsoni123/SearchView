package com.example.administrator.searchview;

/**
 * Created by Administrator on 4/12/2017.
 */

public class Country
{
    private String name;
    private int flagid;

    public  Country(String name,int flagid)
    {
        this.setName(name);
        this.setFlagid(flagid);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlagid() {
        return flagid;
    }

    public void setFlagid(int flagid) {
        this.flagid = flagid;
    }
}
