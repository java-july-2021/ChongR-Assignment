import java.util.HashMap;
import java.util.Set;

public class trackList{
    

    public String FindTrack(String title){

        HashMap<String, String> tracks = new HashMap<String, String>();
        tracks.put("SUPERMASSIVE BLACK HOLE", "Oh baby, don't you know I suffer?");
        tracks.put("Uprising", "The paranoia is in bloom");
        tracks.put("Faraway", "Far away. This ship is taking me far away");
        tracks.put("Feeling Good", "Birds flying high. You know how I feel");
        tracks.put("Time Is Running Out", "I think I'm drowning. Asphyxiated");
        tracks.put("Knights of Cydonia", "Come ride with me. Through the veins of history");
        
        Set<String> keys = tracks.keySet();
        for(String key : keys){
            System.out.println(key);
            System.out.println(tracks.get(key));
        }

        // for(HashMap.Entry<String, String> track: tracks.entrySet()){
        //     System.out.println("Title: " + track.getKey() + ", Lyrics: " + track.getValue());
        // }        //Another way to iterate through the hashmap

        return "Track title: "+ title + ", Lyrics: " + tracks.get(title) + "...";
    }
    
    
}