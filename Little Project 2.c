#include <stdio.h>
/*生日蜡烛
某君从某年开始每年都举办一次生日party，并且每次都要吹熄与年龄相同根数的蜡烛。
现在算起来，他一共吹熄了236根蜡烛。
请问，他从多少岁开始过生日party的？*/ 
int main(){
	int i;
	int j;
	int e;
	int m;
	int sum=0;
	for(i=1;e!=236;i++){
		m=i;
		while(sum<236){
			sum=sum+m;
			m=m+1;
		}
		e=sum;
		sum=0;
	}
	printf("%d",i);
}
