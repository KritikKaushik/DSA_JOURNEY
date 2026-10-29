
import java.util.*;

class Solution {
    int[] tin,tout,depth,parent,size;
    int[][] up;
    ArrayList<Integer>[] graph;
    int log;
    BIT bit;

    public List<Boolean> palindromePath(int n,int[][] edges,String s,String[] queries) {
        graph=new ArrayList[n];
        for(int i=0;i<n;i++) graph[i]=new ArrayList<>();

        for(int[] e:edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        log=1;
        while((1<<log)<=n) log++;

        tin=new int[n];
        tout=new int[n];
        depth=new int[n];
        parent=new int[n];
        size=new int[n];
        up=new int[log][n];
        Arrays.fill(parent,-1);

        int[] order=new int[n];
        int[] st=new int[n];
        int top=0,cnt=0;
        st[top++]=0;
        parent[0]=0;

        while(top>0){
            int u=st[--top];
            tin[u]=cnt;
            order[cnt++]=u;

            for(int v:graph[u]){
                if(v==parent[u]) continue;
                parent[v]=u;
                depth[v]=depth[u]+1;
                st[top++]=v;
            }
        }

        for(int i=n-1;i>=0;i--){
            int u=order[i];
            size[u]++;
            if(u!=0) size[parent[u]]+=size[u];
        }

        for(int i=0;i<n;i++){
            tout[i]=tin[i]+size[i]-1;
            up[0][i]=parent[i];
        }

        for(int j=1;j<log;j++){
            for(int i=0;i<n;i++){
                up[j][i]=up[j-1][up[j-1][i]];
            }
        }

        bit=new BIT(n+1);
        char[] arr=s.toCharArray();

        for(int i=0;i<n;i++){
            int mask=1<<(arr[i]-'a');
            bit.update(tin[i],mask);
            bit.update(tout[i]+1,mask);
        }

        List<Boolean> ans=new ArrayList<>();

        for(String q:queries){
            String[] a=q.split(" ");

            if(a[0].equals("update")){
                int u=Integer.parseInt(a[1]);
                char c=a[2].charAt(0);

                if(arr[u]==c) continue;

                int mask=(1<<(arr[u]-'a'))^(1<<(c-'a'));
                bit.update(tin[u],mask);
                bit.update(tout[u]+1,mask);
                arr[u]=c;
            }else{
                int u=Integer.parseInt(a[1]);
                int v=Integer.parseInt(a[2]);
                int l=lca(u,v);

                int mask=bit.query(tin[u])^bit.query(tin[v])
                        ^(1<<(arr[l]-'a'));

                ans.add((mask&(mask-1))==0);
            }
        }

        return ans;
    }

    int lca(int u,int v){
        if(depth[u]<depth[v]){
            int t=u;
            u=v;
            v=t;
        }

        int d=depth[u]-depth[v];

        for(int i=0;i<log;i++){
            if((d&(1<<i))!=0) u=up[i][u];
        }

        if(u==v) return u;

        for(int i=log-1;i>=0;i--){
            if(up[i][u]!=up[i][v]){
                u=up[i][u];
                v=up[i][v];
            }
        }

        return parent[u];
    }

    class BIT{
        int[] tree;
        int n;

        BIT(int n){
            this.n=n;
            tree=new int[n+1];
        }

        void update(int i,int val){
            for(i++;i<=n;i+=i&-i) tree[i]^=val;
        }

        int query(int i){
            int ans=0;
            for(i++;i>0;i-=i&-i) ans^=tree[i];
            return ans;
        }
    }
}
