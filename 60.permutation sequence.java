class Solution {
    public String getPermutation(int n, int k) {
        String res;
        res=getper(n,k);
        res=change(res,n);
        return res;
    }
    
    public String change(String s,int n){
        int i;
        String ns="";
        int isfound[]=new int[n];
        for(i=0;i<n;i++){
            int ic=s.charAt(i)-48;
            int count=ic;
            int j=0;
            while(count!=0){
                if(isfound[j]==0){
                    count--;
                }
                j++;
            }
            isfound[j-1]=1;
            String sc=String.valueOf(j);
            ns=ns+sc;
        }
        return ns;
    }
    
    public String getper(int n, int k){
        if(n==0)
            return "";
        String onebit="";
        int oneBit;
        int rest;
        int nn=getNum(n-1);
        oneBit=k/nn;
        rest=k%nn;
        if (rest>0)
            oneBit++;
        if(rest==0)
            rest=nn;
        onebit=onebit+String.valueOf(oneBit)+getper(n-1,rest);
        
        return onebit;
    }
    
    public int getNum(int n){
        int i;
        int res=1;
        for(i=1;i<=n;i++){
            res=res*i;
        }
        return res;
    }
}
