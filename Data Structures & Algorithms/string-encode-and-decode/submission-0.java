class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            int length = str.length();
            sb.append(length).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) { // 5#Hello5#World
        List<String> list = new ArrayList<>();
        if(str.length() == 0) {
            return list;
        }
        int i = 0;
        while(i<str.length()){
            int length = 0;
            while(str.charAt(i) != '#'){
                length = length * 10 + (str.charAt(i++) - '0');
            }
            i++;
            StringBuilder strB = new StringBuilder();
            while(length > 0){
                strB.append(str.charAt(i++));
                length--;
            }
            list.add(strB.toString());
        }
        return list;
    }
}
