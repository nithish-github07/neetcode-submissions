class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String sorted = new String(array);

            List<String> list = map.getOrDefault(sorted, new ArrayList<>());
            list.add(str);
            map.put(sorted,list);
        }

        return new ArrayList<>(map.values());
        }
}
