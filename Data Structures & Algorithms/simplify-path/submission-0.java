class Solution {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        String[] dirs = path.split("/");
        for(String dir: dirs){
            if(dir.equals("") || dir.equals(".")){
                continue;
            }
            else if(dir.equals("..")){
                if(!s.isEmpty()) s.pop();
            }
            else{
                s.push(dir);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()){
            sb.insert(0,s.pop()).insert(0,"/");
        }
        if(sb.length() == 0) sb.append("/");
        return sb.toString();
    }
}