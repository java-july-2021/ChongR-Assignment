public class StringManipulator {
    String trimAndConcat(String A, String B){
        return A.trim()+B.trim();
    }

    Integer getIndexOrNull(String word, char y){
        if(word.indexOf(y) == -1){
            return null;
        }
        return word.indexOf(y);
    }
    
    Integer getIndexOrNull(String phrase, String word){
        if(phrase.indexOf(word) == -1){
            return null;
        }
        return phrase.indexOf(word);
    }


    // String concatSubstring(String phrase1, int i, int j, String phrase2){
    //     char a = phrase1.charAt(i);
    //     System.out.println(a);
    //     char b = phrase1.charAt(j);
    //     System.out.println(b);
    //     return a.concat(b.concat(phrase2));
    //     return phrase1.charAt(i)+phrase1.charAt(j)+phrase2;
    // }

    String concatSubstring(String substringMe, int start, int end, String concatMe) {
        concatMe = substringMe.substring(start, end) + concatMe;
        return concatMe;
    }
}