#include <stdio.h>

int main(){
	int n,k;//n为灯数目，k为人数 
	scanf("%d %d",&n,&k);
	int b[n];
	int i;
	for(i=0;i<n;i++){//初始化所有灯，1表示灯亮，0表示灯灭 
		b[i]=1;
	}
	int j;
	int p;
	for(j=2;j<=k;j++){
		for(p=j-1;p<n;p=p+j){
			if(b[p]==1){
				b[p]=0;
			}else if(b[p]==0){
				b[p]=1;
			}
		}
	}
	int u;
	for(u=0;u<n;u++){
		if(b[u]==1){
			printf("%d ",u+1);
		}
	}
}
