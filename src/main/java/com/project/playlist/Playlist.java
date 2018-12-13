package com.project.playlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*This class is developed to shuffle and play songs. Also plays the song previous and next to any given input song id
It assumes that the playlist is populated by default with values 0 to 99 which are individually a song id.
*/
public class Playlist
{
    List<Integer> list=new ArrayList<Integer>();//playlist of songs
    static boolean test;
    int size; //size of playlist

    List<Integer> indexesVisited=new ArrayList<Integer>(); //it stores the list of song ids which have already been played
    void initialize()
    { //initialize the list with 0 to 99 in sequence
        for(int i=0;i<100;i++)
        {
            list.add(i);

        }
    }
    void setTest()
    {
        //make it to true to assure that the call to main() came from Test class
        test=true;
    }

    public List<Integer> getIndexesVisited() {
        return indexesVisited;
    }

    public List<Integer> getList() {
        return list;
    }


    void shuffle(){
        //Shuffle the songs by generating a random number which denotes song id

        size=list.size();
        int random=(int)(Math.random()*size);
        while(indexesVisited.contains(random))
        {
            //keep generating random number as long as the number is already in the played songs list
            random=(int)(Math.random()*size);
        }
        play(random);//plays the song
        indexesVisited.add(random); //update the list with song ids already played


    }
    void play(int index)
    {
        System.out.println("Playing song "+index);
    }
    void playPrevious(int index)
    {
        System.out.println("Playing previous of song "+index);
        int i=indexesVisited.indexOf(index);
        if(i-1 >=0 && i-1 <=99)
            play(indexesVisited.get(--i));
        else
            System.out.println("This is the song played in the beginning.Hence no previous.");

    }
    int getPrevious(int index)
    {
        System.out.println("Fetching previous of song "+index);
        int i=indexesVisited.indexOf(index);
        if(i-1 >=0 && i-1 <=99)
        return(indexesVisited.get(--i));
        else
            return -1;

    }
    void playNext(int index)
    {
        System.out.println("Playing next of song "+index);
        int i=indexesVisited.indexOf(index);
        if(i+1 >=0 && i+1 <=99)
         play(indexesVisited.get(++i));
        else
            System.out.println("This is the song played in the end.Hence no next.");
    }
    int  getNext(int index)
    {
        System.out.println("Fetching next of song "+index);
        int i=indexesVisited.indexOf(index);
        if(i+1 >=0 && i+1 <=99)
        return(indexesVisited.get(++i));
        else
            return -1;
    }
    public static void main(String args[]) {
        Playlist playlist = new Playlist();
        System.out.println("Initializing the playlist sequentially with values from 0 to 99");
        playlist.initialize();
        playlist.size = playlist.list.size();
        System.out.println("Invoking shuffle() to shuffle and play the songs");
        for (int j = 0; j < 100; j++)
            playlist.shuffle();
        System.out.println("Played all 100 songs");
        System.out.println("Enter any  song number from 0 to 99 to play its previous song");
        Scanner scanner=new Scanner(System.in);
        int prev=scanner.nextInt();
        if(prev>=0 && prev<=99)
        playlist.playPrevious(prev);
        else {
            System.out.println("Please enter a valid input");
            return;
        }
        if(test==false) {
            System.out.println("Enter any  song number from 0 to 99 to play its next song");
            int next = scanner.nextInt();
            if(next>=0 && next<=99)
                playlist.playNext(next);
            else {
                System.out.println("Please enter a valid input");
                return;
            }
        }
    }

}