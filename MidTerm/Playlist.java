import java.util.Scanner;
import java.io.*;

public class Playlist 
{
    //file we are going to read from
    private static final String PLAYLIST_FILE = "playlist.txt";
    public static void main(String[]args) 
    {
       
        try{
        File f = new File(PLAYLIST_FILE);


        Scanner scanner = new Scanner(f);

        //number of videos
        int n = scanner.nextInt();
        System.out.print(n+" ");

        //number of topics
        int k = scanner.nextInt();
        System.out.println(k+" ");
        
        //array of our videos
        int[] playlistTable = new int[n];

        //array of our topics 
        int[] topicsTable = new int[k];

        
        //loops through all our videos and inserts them into 
        //our playlist table array
        for(int i = 0; i < n; i++)
        {
            playlistTable[i] = scanner.nextInt();
            System.out.print(playlistTable[i] + " ");
        }
        System.out.println();

        //make sure values are indeed in my table
        // for (int i = 0; i < n; i++) {
        //     System.out.print(playlistTable[i] + " ");
        // }
        //System.out.println();
        //loops through all our topics and inserts them into
        //our topics table array
        for(int j = 0; j < k; j++)
        {
            topicsTable[j] = scanner.nextInt();
            System.out.print(topicsTable[j]+ " ");
        }
        System.out.println();

     CalculatePlaylistClicks pC = new CalculatePlaylistClicks();
        
       
        System.out.println("Number of clicks: " + CalculatePlaylistClicks.numberOfClicks(playlistTable,topicsTable));

        scanner.close();
       }
       catch(FileNotFoundException e)
       {
        System.out.println("could not open this file " + PLAYLIST_FILE);
        e.printStackTrace();
       }

    }


}

class CalculatePlaylistClicks 
{
    
   
    // public CalculatePlaylistClicks(int[] playlistTable, int[]topicsTable)
    // {
    //     this.playlistTable = playlistTable;
    //     this.topicsTable = topicsTable;
    // }
   
    public static int numberOfClicks(int[]playlistTable,int[]topicsTable)
    {
       //int[] duplicateTable = new int[playlistTable.length];
        int clicks = -1;
        boolean isAchunk = false;
        for(int i = 0; i < topicsTable.length; i++)
        {
          int currentTopic = topicsTable[i];

           for(int j = 0; j < playlistTable.length; j++)
           {
             if(currentTopic == playlistTable[j])
             {
                
               playlistTable[i] = 0;
                isAchunk = true;
                
               
                
             }
             else if(isAchunk)
                {
                    clicks++;
                    isAchunk = false;
                }

             else
             {
                isAchunk = false;
                continue;
             }



              
           }
          
        }
        return clicks;
    }
   
        
    }

