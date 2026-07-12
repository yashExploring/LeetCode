class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] dup = new int[arr.length];
        for(int j = 0; j < arr.length; j++){
            dup[j] = arr[j];
        }
        Arrays.sort(dup);
        HashMap<Integer, Integer> map = new HashMap<>(arr.length);
        int[] rank = new int[arr.length];
        int p = 1;
        for(int i = 0; i < arr.length; i++){
            if(i > 0 && dup[i] == dup[i - 1]){
                continue;
            }else{
                map.put(dup[i], p);
                p++;
            }
        }
        for(int k = 0; k < arr.length; k++){
            rank[k] = map.get(arr[k]);
        }
        return rank;

    }
}