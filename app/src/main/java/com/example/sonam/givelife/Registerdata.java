package com.example.sonam.givelife;

import java.util.Date;

/**
 * Created by Sonam on 11/29/2015.
 */
public class Registerdata {

    String venue, camname, sponsor, data;

    public void setCamname(String camname)
    {
        this.camname = camname;
    }
    public String getCamname()
    {
        return this.camname;
    }
    public void setVenue(String venue)
    {
        this.venue = venue;
    }
    public String getVenue()
    {
        return this.venue;
    }
    public void setSponsor(String sponsor)
    {
        this.sponsor = sponsor;
    }
    public String getSponsor()
    {
        return this.sponsor;
    }
    public void setData(String data )
    {
        this.data = data;
    }
    public String getData()
    {
        return this.data;
    }

}
