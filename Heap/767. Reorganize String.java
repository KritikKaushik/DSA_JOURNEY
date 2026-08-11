class Pair{
    int freq;
    char ch;
    Pair(int freq,char ch){
        this.freq=freq;
        this.ch=ch;
    }
}


class Solution {
    public String reorganizeString(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);

        }

        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b)->{
                if(a.freq!=b.freq){
                    return b.freq-a.freq;
                }
                return Character.compare(a.ch,b.ch);
            }

        );
        
        for(char el:map.keySet()){
            int freq=map.get(el);
            Pair m=new Pair(freq,el);
            pq.add(m);
        }
        char res[]=new char[s.length()];
        int pos=0;

        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            if(pos==0 || res[pos-1]!=curr.ch){
                res[pos]=curr.ch;
                pos++;
                curr.freq--;
                if(curr.freq>0){
                    pq.add(curr);
                }
            }else{
                if(pq.isEmpty()){
                    return "";
                }else{
                    Pair sec=pq.poll();
                    res[pos]=sec.ch;
                    sec.freq--;
                    pos++;
                    if(sec.freq>0){
                        pq.add(sec);
                    }
                    pq.add(curr);
                }
            }

        }
        String ans=new String(res);
        return ans;
    }
}
