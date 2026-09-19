class Solution {

    //delimeter -- length of the string to end up with a delimiter
    // 4+1 (string) #
    // 20# (string) # --
    //3,4,20,50# s1s2s3


    public String encode(List<String> strs) {
        if(strs.isEmpty()) return "";

        int[] length = new int[strs.size()];

        for(int i = 0;i < strs.size(); i++){
            length[i] = strs.get(i).length();
        }

        StringBuilder encoded = new StringBuilder();

        for(int l: length){
            encoded.append(l).append(',');
        }
        encoded.append('#');

        for(String str: strs){
            encoded.append(str);
        }

        return encoded.toString();

    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        if(str==""){
            return res;
        }

        int i = 0;
        List<Integer> count = new ArrayList<>();
        while(i<str.length()){

            //check if its hash - break
            if(str.charAt(i)=='#') break;
            int num = 0;

            int j = i; 
            while(str.charAt(j)!=',') j++;

            //add all numbers
            num = Integer.parseInt(str.substring(i,j));
            count.add(num);

            i=j;
            i++;
        }

        //i at hash position
        i++;

        for(int num: count){
            res.add(str.substring(i,num+i));
            i+=num;
        }

        return res;
    }
}
