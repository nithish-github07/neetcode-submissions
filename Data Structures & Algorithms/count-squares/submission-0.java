class CountSquares {
    HashMap<String,Integer> map;

    public CountSquares() {
        map = new HashMap<>();
    }
    
    public void add(int[] point) {
        String key = point[0] + "," + point[1];
        map.put(key,map.getOrDefault(key,0) + 1); 
    }
    
    public int count(int[] point) {
        int qx = point[0], qy = point[1];
        int res = 0;
        for(String key: map.keySet()){
            String[] pt = key.split(",");
            int x = Integer.parseInt(pt[0]), y = Integer.parseInt(pt[1]);
            if(Math.abs(qx - x) != Math.abs(qy - y) || x == qx || y == qy){
                continue;
            }
            String pt3 = x + "," + qy, pt4 = qx + "," + y;
            res += map.get(key) * map.getOrDefault(pt3, 0) * map.getOrDefault(pt4, 0);
        }
        return res;
    }
}
