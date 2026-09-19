class Solution {
    public String minWindow(String s, String t) {
    Map<Character, Integer> needT = new HashMap<>();
  for(char c: t.toCharArray()) { 
    needT.put(c, needT.getOrDefault(c,0)+1);
  }

  int left = 0; 
  int minLen = Integer.MAX_VALUE;
  int have = 0;
  int start = 0;

  Map<Character, Integer> window = new HashMap<>();

  for(int right = 0; right<s.length(); right++){
    char c = s.charAt(right);

    window.put(c,window.getOrDefault(c,0) +1);

    if(needT.containsKey(c) && window.get(c).intValue() == needT.get(c).intValue()){
      have++;
    }

    while(have == needT.size()){
      if(right - left +1<minLen){
        minLen = right-left+1;
        start = left;
      }
      char leftChar = s.charAt(left++);
      window.put(leftChar, window.get(leftChar)-1);
      if(needT.containsKey(leftChar) && window.get(leftChar)< needT.get(leftChar)){
        have--;
      }
    }
  }

  return minLen == Integer.MAX_VALUE ? "":s.substring(start, start+minLen);

    }
}
