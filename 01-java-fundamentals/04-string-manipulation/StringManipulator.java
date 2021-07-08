public class StringManipulator {
    String trimAndConcat(String A, String B){
        return A.trim()+B.trim();
    }
    // Integer getIndexOrNull(String word, char y){
        /*
        String i = String.valueOf(word.indexOf(y));
        if(i == "-1"){
            return null;
        }
        */
    //    return word.indexOf(y);
    // }
    
    Integer getIndexOrNull(String phrase, String word){
        return phrase.indexOf(word);
    }

    String concatSubstring(String phrase1, int i, int j, String phrase2){
        // char a = phrase1.charAt(i);
        // System.out.println(a);
        // char b = phrase1.charAt(j);
        // System.out.println(b);
        // return a.concat(b.concat(phrase2));
        return phrase1.charAt(i)+phrase1.charAt(j)+phrase2;
    }
}