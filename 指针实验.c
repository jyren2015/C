#include <stdio.h>

int main(){
    int a[]={2,7,11,9};
    int array[4];
    int* p=&a[0];
    int s;
    for(s=0;s<=4;s++){
   	    array[s]=*p;
		p=p+1;
    }
    printf("%d",array[1]);
}

