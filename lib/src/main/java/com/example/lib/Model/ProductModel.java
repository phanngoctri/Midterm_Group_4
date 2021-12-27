package com.example.lib.Model;


import java.util.List;

public class ProductModel
{
    private List<Data> data;

    private String status;

    public List<Data> getData ()
    {
        return data;
    }

    public void setData (List<Data> data)
    {
        this.data = data;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString() { return "ClassPojo [data = "+data+", status = "+status+"]"; }

    public static class Data
    {
        private String groupName;

        private String price;

        private String name;

        private String description;

        private String id;

        private String picture;

        public String getGroupName ()
        {
            return groupName;
        }

        public void setGroupName (String groupName)
        {
            this.groupName = groupName;
        }

        public String getPrice ()
        {
            return price;
        }

        public void setPrice (String price)
        {
            this.price = price;
        }

        public String getName ()
        {
            return name;
        }

        public void setName (String name)
        {
            this.name = name;
        }

        public String getDescription ()
        {
            return description;
        }

        public void setDescription (String description)
        {
            this.description = description;
        }

        public String getId ()
        {
            return id;
        }

        public void setId (String id)
        {
            this.id = id;
        }

        public String getPicture ()
        {
            return picture;
        }

        public void setPicture (String picture)
        {
            this.picture = picture;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [groupName = "+groupName+", price = "+price+", name = "+name+", description = "+description+", id = "+id+", picture = "+picture+"]";
        }
    }
}