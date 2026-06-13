class TimeMap {
    HashMap<String,List<String[]>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new ArrayList<>());
        }
        map.get(key).add(new String[]{value,String.valueOf(timestamp)});
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        List<String[]> val = map.get(key);
        int low = 0, high = val.size() - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int time = Integer.parseInt(val.get(mid)[1]);
            if(time == timestamp){
                return val.get(mid)[0];
            }
            if(timestamp < time){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        if(high >= 0) return val.get(high)[0];
        else return "";
    }
}
