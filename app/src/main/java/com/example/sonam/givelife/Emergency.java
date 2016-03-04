package com.example.sonam.givelife;

/**
 * Created by Sonam on 12/1/2015.
 */
public class Emergency {

    int mobile;
    String name, organ, venue, time, hproblem, username;

    public void setMobile(int mobile)
    {
        this.mobile = mobile;
    }
    public int getMobile()
    {
        return this.mobile;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }
    public String getUsername()
    {
        return this.username;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }


    public void setOrgan(String organ)
    {
        this.organ = organ;
    }
    public String getOrgan()
    {
        return this.organ;
    }

    public void setVenue(String venue)
    {
        this.venue = venue;
    }
    public String getVenue()
    {
        return this.venue;
    }

    public void setTime(String time)
    {
        this.time = time;
    }
    public String getTime()
    {
        return this.time;
    }

    public void setHproblem(String hproblem)
    {
        this.hproblem = hproblem;
    }
    public String getHproblem()
    {
        return this.hproblem;
    }

}
