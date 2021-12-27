package com.example.lib.Model;


public class ProductInsertModel
{
    private String GroupName;

    private String Description;

    private String Price;

    private String Picture;

    private String Id;

    private String Name;

    public String getGroupName ()
    {
        return GroupName;
    }

    public void setGroupName (String GroupName)
    {
        this.GroupName = GroupName;
    }

    public String getDescription ()
    {
        return Description;
    }

    public void setDescription (String Description)
    {
        this.Description = Description;
    }

    public String getPrice ()
    {
        return Price;
    }

    public void setPrice (String Price)
    {
        this.Price = Price;
    }

    public String getPicture ()
    {
        return Picture;
    }

    public void setPicture (String Picture)
    {
        this.Picture = Picture;
    }

    public String getId ()
    {
        return Id;
    }

    public void setId (String Id)
    {
        this.Id = Id;
    }

    public String getName ()
    {
        return Name;
    }

    public void setName (String Name)
    {
        this.Name = Name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [GroupName = "+GroupName+", Description = "+Description+", Price = "+Price+", Picture = "+Picture+", Id = "+Id+", Name = "+Name+"]";
    }
}

