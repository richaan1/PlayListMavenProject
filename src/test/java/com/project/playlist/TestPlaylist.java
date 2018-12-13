package com.project.playlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class TestPlaylist {
    Playlist playlist;

    @Before
    public void setUp()
    {
        playlist=new Playlist();
        playlist.setTest();

    }
    @Test
    public void testInitialize()
    {
        playlist.initialize();
        Assert.assertEquals(100,playlist.getList().size());
    }
    @Test
    public void testShuffle()
    {
        playlist.initialize();
        for (int j = 0; j < 100; j++)
            playlist.shuffle();
        Assert.assertEquals(100,playlist.getIndexesVisited().size());
    }
    @Test
    public void testGetPrevious()
    {
        playlist.initialize();
        for (int j = 0; j < 100; j++)
            playlist.shuffle();
        int i=playlist.getIndexesVisited().indexOf(5);
        if(i-1 >=0 && i-1 <=99)
            Assert.assertEquals((int)playlist.getIndexesVisited().get(--i),playlist.getPrevious(5));
        else
            Assert.assertEquals(-1,playlist.getPrevious(5));
    }
    @Test
    public void testGetNext()
    {
        playlist.initialize();
        for (int j = 0; j < 100; j++)
            playlist.shuffle();
        int i=playlist.getIndexesVisited().indexOf(5);

        if(i+1 >=0 && i+1 <=99)
        Assert.assertEquals((int)playlist.getIndexesVisited().get(++i),playlist.getNext(5));
        else
            Assert.assertEquals(-1,playlist.getNext(5));
    }

    @Test
    public void testMain()
    {
        String arguement[]=new String[1];


        ByteArrayInputStream in = new ByteArrayInputStream("6".getBytes());
        System.setIn(in);
        System.setIn(System.in);

        playlist.main(arguement);
    }




}
