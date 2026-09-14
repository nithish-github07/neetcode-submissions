class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>(); 
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num: nums){ 
            map.put(num, map.getOrDefault(num,0) + 1);
            if(map.size() > 2){
                HashMap<Integer,Integer> newMap = new HashMap<>();
                for(int key: map.keySet()){
                    if(map.get(key) > 1){
                        newMap.put(key,map.get(key) - 1);
                    }
                }
                map = newMap;
            }
        }

        int n = nums.length;
        for(int key: map.keySet()){
            int freq = 0;
            for(int num: nums){
                if(num == key) freq++;
            }
            if(freq > (n/3)){
                res.add(key);
            }
        }

        return res;
    }
}