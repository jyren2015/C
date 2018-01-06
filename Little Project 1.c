#include <stdio.h>
//#include <string.h>
#define MAX 100
//# MIN 27
/*My age is less than 100.
I am 27years older than my son.
If reverse the numbers'place of my age,
it is right my son's age.
How many results my age are? */
int main(){
	int i;
	int j=0;
	for(i=27;i<MAX;i++){
		int e=i/10;
		int t=i-e*10;
		int m;
		m=i-t*10-e;
		if(m==27){
			j++;
		}   
	}
	printf("%d",j);
	return j;
}
