class Solution {

    //Approach 3, best apporach
    //Time Complexity: O(n), average time is better than other 2 approaches
    //Space Complexity: O(1), because we have 1-6 numbers only

    //Approach: here we are considering a fact that between top[i] and bottom[i], one of them is present to all other tops[i] or bottoms[i] if it's valid output, otherwise output is -1, that's why we are taking 2 possible candidates tops[0] and bottoms[0] and see the minimum rotation required for them, if we got answer which is not -1 for 1st candidate, then we don't have to check for 2nd candidate, result would be the same

    public int minDominoRotations(int[] tops, int[] bottoms) {

        if(tops == null || bottoms == null || tops.length == 0 || bottoms.length == 0) return 0;        //check for null case

        int result = check(tops, bottoms, tops[0]);                 //call the check function on tops[0], store in result

        if(result != -1) return result;                             //if result != -1, then return result

        return check(tops, bottoms, bottoms[0]);                    //otherwise call the check function on bottoms[0]
    }

    private int check(int[] tops, int[] bottoms, int candidate){

        int n = tops.length;                                        //n is length of top
        int topRotation = 0, bottomRotation = 0;                    //counter for top and bottom rotations

        for(int i=0; i<n; i++){                                     //iterate through array

            if(tops[i] != candidate && bottoms[i] != candidate) return -1;          //check if tops[i] != candidate and bottoms[i] != candidate, then return -1 as candidate is not present in either top or bottom positions

            if(tops[i] != candidate) topRotation++;                 //check if top[i] != candidate, then increament the topRotation

            if(bottoms[i] != candidate) bottomRotation++;           //check if bottoms[i] != candidate, then increament the bottomRotation
        }
        return Math.min(topRotation, bottomRotation);               //return the min value between topRotation, bottomRotation
    }




    //Approach 2
    //Time Complexity: O(n)
    //Space Complexity: O(1), because we have 1-6 numbers only

    // public int minDominoRotations(int[] tops, int[] bottoms) {

    //     if(tops == null || bottoms == null || tops.length == 0 || bottoms.length == 0) return 0;         //check for null case

    //     Map<Integer, Integer> map = new HashMap<>();                 //created a map to store the count of numbers which are present in top and bottom part of a tile

    //     int n = tops.length;
    //     int candidate = 0;                                           //possible candidate which we can be present in top or bottom part of tile

    //     for(int i=0; i<n; i++){                                      //iterate through array

    //         map.put(tops[i], map.getOrDefault(tops[i], 0) + 1);      //increament the frequency for top[i]

    //         if(map.get(tops[i]) >= n){                               //check if top[i] is present more than length of array, then, store the candidate value and break the loop
    //             candidate = tops[i];
    //             break;
    //         }

    //         map.put(bottoms[i], map.getOrDefault(bottoms[i], 0) + 1);        //increament the frequency for bottoms[i]

    //         if(map.get(bottoms[i]) >= n){                            //check if bottoms[i] is present more than length of array, then, store the candidate value and break the loop
    //             candidate = bottoms[i];
    //             break;
    //         }
    //     }

    //     int topRotation = 0, bottomRotation = 0;                      //counter for top and bottom rotations

    //     for(int i=0; i<n; i++){                                        //iterate through array

    //         if(tops[i] != candidate && bottoms[i] != candidate) return -1;        //check if tops[i] != candidate and bottoms[i] != candidate, then return -1 as candidate is not present in either top or bottom positions

    //         if(tops[i] != candidate) topRotation++;                      //check if top[i] != candidate, then increament the topRotation

    //         if(bottoms[i] != candidate) bottomRotation++;                //check if bottoms[i] != candidate, then increament the bottomRotation
    //     }
    //     return Math.min(topRotation, bottomRotation);                    //return the min value between topRotation, bottomRotation
    // }




    //Approach 1
    //Time Complexity: O(n)
    //Space Complexity: O(1), because we have 1-6 numbers only

    // public int minDominoRotations(int[] tops, int[] bottoms) {

    //     Map<Integer, Integer> map = new HashMap<>();
    //     int max = 0;
    //     int num = 0;

    //     for(int i=0; i<tops.length; i++){

    //         map.put(tops[i], map.getOrDefault(tops[i], 0) + 1);
    //         map.put(bottoms[i], map.getOrDefault(bottoms[i], 0) + 1);

    //         if(max < map.get(tops[i])){
    //             max = map.get(tops[i]);
    //             num = tops[i];
    //         }
    //         if(max < map.get(bottoms[i])){
    //             max = map.get(bottoms[i]);
    //             num = bottoms[i];
    //         }
    //     }

    //     if(max >= tops.length){

    //         int topCount = 0;
    //         int bottomCount = 0;
    //         int i = 0;

    //         while(i<tops.length){

    //             if(tops[i] == num && bottoms[i] == num){
    //                 i++;
    //                 continue;
    //             }
    //             else if(tops[i] == num){
    //                 bottomCount++;
    //             }
    //             else if(bottoms[i] == num){
    //                 topCount++;
    //             }
    //             else{
    //                 return -1;
    //             }
    //             i++;
    //         }
    //         return Math.min(topCount, bottomCount);
    //     }
    //     return -1;
    // }
}


public class MinimumDominoRotationsForEqualRowLC1007 {
}
