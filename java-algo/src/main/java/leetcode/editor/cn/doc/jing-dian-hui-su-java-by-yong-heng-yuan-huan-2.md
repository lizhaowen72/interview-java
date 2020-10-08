```java
class Solution {
    public String[] permutation(String S) {
        Set<String> res = new HashSet<>();
        combination(res,S,new StringBuilder(),new boolean[S.length()]);
        return res.toArray(new String[res.size()]);
    }

    private void combination(Set<String> res, String s, StringBuilder sb, boolean[] marked){
        if(sb.length() == s.length()){
            res.add(sb.toString());
            return;
        }
        for(int i = 0;i<s.length();i++){
            if(!marked[i]){
                marked[i] = true;
                sb.append(s.charAt(i));
                combination(res,s,sb,marked);
                sb.deleteCharAt(sb.length()-1);
                marked[i] = false;
            }
        }
    }
}
```