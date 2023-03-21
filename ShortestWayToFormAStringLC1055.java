public class ShortestWayToFormAStringLC1055 {
    //Approach 1
    //Time Complexity: O(m*n), m = length of t, n = length of s
    //Space Complexity: O(1)

//     public static int shortestWay(String s, String t){

//         int sl = s.length();
//         int tl = t.length();

//         if(sl==0 && tl==0) return 0;

//         int sp =0, tp = 0;
//         int count = 0;

//         while(tp<tl){
//             count++;
//             int pos = tp;

//             while(sp<sl && tp<tl){

//                 if(s.charAt(sp) == t.charAt(tp)){
//                     tp++;
//                 }
//                 sp++;
//             }
//             if(tp == pos) return -1;

//             sp = 0;
//         }
//         return count;
//     }



    //Approach 2
    //Time Complexity: O(m*n), m = length of t, n = length of s
    //Space Complexity: O(1)

//     public static int shortestWay(String s, String t){

//         int sl = s.length();
//         int tl = t.length();

//         if(sl==0 && tl==0) return 0;

//         Set<Character> set = new HashSet<>();

//         for(int i=0; i<s.length(); i++){
//             set.add(s.charAt(i));
//         }

//         int sp =0, tp = 0;
//         int count = 0;

//         while(tp<tl){

//             count++;
//             while(sp<sl && tp<tl){

//                 if(!set.contains(t.charAt(tp))) return -1;

//                 if(s.charAt(sp) == t.charAt(tp)){
//                     tp++;
//                 }
//                 sp++;
//             }
//             sp = 0;
//         }
//         return count;
//     }



    //Approach 3
    //Time Complexity: O(m*log(n)), m = length of t, n = length of s
    //Space Complexity: O(1)

    public static int shortestWay(String s, String t){

        int sl = s.length();                            //take the s length and t length
        int tl = t.length();

        if(sl==0 && tl==0) return 0;                    //check if both string's length is 0 then return 0

        Map<Character, List<Integer>> map = new HashMap<>();        //to store the List of index at which a character is present in s

        for(int i=0; i<s.length(); i++){                //iterate through s

            char c = s.charAt(i);                       //take the character at i

            if(!map.containsKey(c)){                    //check if map contains that character or not
                map.put(c, new ArrayList<>());          //if not then add that character in map
            }
            map.get(c).add(i);                          //add the index of that character in map
        }

        int count = 1;                                 //to store the total count required to make string t
        int sp =0, tp = 0;                               //sp, and tp are pointers of s and t strings

        while(tp<tl){                               //iterate till tp reaches to tl

            char tChar = t.charAt(tp);                  //take the character of t at tp

            if(!map.containsKey(tChar)) return -1;          //check if that character is present in the map(means character is present in the s), if it's not present then return -1

            List<Integer> li = map.get(tChar);              //if present, then get all the list of indexes at which that character is present in the tChar

            int k = Collections.binarySearch(li, sp);       //call the binarySearch on that list by passing list and sp

            if(k<0){                                        //check if k<0, means(character is present but its not exactly present at sp index)

                //if sp = 13 and li = [0,1,6,17,19] then Collections.binarySearch returns the -4, so we have to do the -k-1 = -(-4) -1 = 3
                //suppose if sp = 17, then it  Collections.binarySearch returns the 3, which is positive, so Collections.binarySearch is return the positive number if the number we are searching is present in the list, otherwise it returns the -k-1 value

                k = - k - 1;                                //convert it to the actual index
            }

            if(k == li.size()){                         //check if k ==  li.size() means that character is not present  at index which is earlier than sp, so we have to increament the count and restart the sp
                count++;
                sp = 0;
            }
            else{                                   //means, character is present at sp or far than sp
                sp = li.get(k);                     //so get the position where that character is present in the s, and assign it to the sp
                sp++;                               //increament the sp and tp
                tp++;
            }
        }
        return count;                               //return the count
    }
}
