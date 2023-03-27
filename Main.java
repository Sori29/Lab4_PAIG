package com.company;
import javax.swing.Timer;
public class Main {
    public static void Interclasează(int[] a,int p,int m,int q){
        int k=0;
        int i=p;
        int j=m;
        int[] c = new int[p+q+1];
        while(i<m && j < q+1){
            if(a[i] == a[j]) {
                c[k++] = a[i++];
                c[k++] = a[j++];
            }
            else if(a[i] < a[j])
                c[k++] = a[i++];
            else
                c[k++] = a[j++];
        }
        while(i < m)
            c[k++] = a[i++];
        while(j<q+1)
            c[k++] = a[j++];
        k=0;
        for(int l=p;l<q+1;l++)
            a[l] = c[k++];
    }
    public static void SortareInterclasare(int[] a,int p,int q){
        if(p<q){
            int m = (p+q) / 2;
            SortareInterclasare(a,p,m);
            SortareInterclasare(a,m+1,q);
            Interclasează(a,p,m,q);
        }
    }
    public static void QSort(int[] a,int p,int q){
        int i=p;
        int j=q;
        int x = a[(i+j)/2];
        while(a[i]<x) i++;
        while(x<a[j]) j--;
        if(i<=j)
        {
            int h = a[i];
            a[i] = a[j];
            a[j] = h;
            i++;
            j--;
        }
        while(i<=j){
            for(int l=p;i<q+1;l++)
                System.out.print(a[l] + " ");
            System.out.println();
            if(p<j) QSort(a,p,j);
            if(i<q) QSort(a,i,q);
        }
    }
    public static void main(String[] args) {
        int[] a={3,1,8,2,7,3,5};
        int n = 7;
        long startTime = System.nanoTime();
        //SortareInterclasare(a,0,n-1);
        QSort(a,0,n-1);
        for(int i=0;i<n;i++)
            System.out.print(a[i] + " ");
        System.out.println();
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Total execution time: " + totalTime + " nanoseconds");
    }
}
