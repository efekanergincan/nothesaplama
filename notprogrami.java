import java.util.Scanner;
class notprogrami {
    int [][] dersnotlari =new int[50][50];
    void matris(int k,int n){
        int i,j;
        for(i=0;i<k;i++){
            for(j=1;j<=n;j++){
                System.out.println((i+1)+".öğrencinin"+" "+(j)+".dersinin notunu giriniz:");
                Scanner scanner=new Scanner(System.in);
                dersnotlari[i][j]=scanner.nextInt();
            }
        }
        int a,b,c;
        System.out.print("öğrenci no"+"    ");
        for(c=0;c<n;c++) {
            System.out.print((c+1)+". ders"+"     ");
        }
        System.out.println();
        for(a=0;a<k;a++){
            dersnotlari[a][0]=(int)(Math.random()*(100)+1);
            System.out.print("    "+dersnotlari[a][0]+"           ");
            for(b=1;b<=n;b++){

                System.out.print(dersnotlari[a][b]+"        ");
            }

            System.out.println();
        }
    }

    void aritmetik_ortalama(int k,int n){
        int r;
        int y;
        int top=0;
        int ort=0;
        for(y=1;y<=n;y++) {
            for (r=0; r < k; r++) {
                top += dersnotlari[r][y];
                ort = top / k;
            }
            top=0;
            System.out.println((y)+".dersin ortalaması:"+ort);
        }
    }

    void ogrenci_ortalama(int k,int n){
        int a,b;
        int sum=0;
        int c=0;
        int [] ortalama=new int[100];
        int enbüyük;
        int enkücük;
        int numara;
        int numara1;
        for(a=0;a<k;a++) {
            for (b = 1; b <= n; b++) {
                sum += dersnotlari[a][b];
                ortalama[a] = sum / n;
            }
            sum = 0;
            System.out.println(dersnotlari[a][0] + " " + "numaralı öğrencinin ortalaması:" + ortalama[a]);
        }
        enbüyük=ortalama[c];
        numara=dersnotlari[c][0];
        enkücük=ortalama[c];
        numara1=dersnotlari[c][0];
        for(c=0;c<k-1;c++) {
            if (enbüyük < ortalama[c + 1]) {
                enbüyük=ortalama[c+1];
                numara=dersnotlari[c+1][0];
            }
        }
        for(int g=0;g<k-1;g++){
            if(enkücük>ortalama[g+1]){
                enkücük=ortalama[g+1];
                numara1=dersnotlari[g+1][0];
            }
        }
        System.out.println("En başarılı öğrencinin ortalaması ve numarası:" + enbüyük + " " + numara);
        System.out.println("En başarısız öğrencinin ortalaması ve numarası:" + enkücük + " " + numara1);

    }

    void geometrik_ort(int k, int n){
        int a;
        int b;
        float carpim=1;
        float geo_ort;
        for(a=1;a<=n;a++){
            for(b=0;b<k;b++){
                carpim*=dersnotlari[b][a];
            }
            geo_ort=(float) Math.pow(carpim,1.0/k);
            carpim=1;
            System.out.println((a)+". dersin geometrik ortalaması:"+geo_ort);
        }
    }

    void harmonik_ort(int k,int n){
        int a;
        int b;
        float tp=0;
        float harmonikort;
        for(a=1;a<=n;a++){
            for(b=0;b<k;b++){
                tp+=1.0/dersnotlari[b][a];
            }
            harmonikort=k/tp;
            tp=0;
            System.out.println((a)+". dersin harmonik ortalaması:"+harmonikort);
        }
    }

    void fark(int k, int n){
        int a;
        int b=0;
        int c=0;
        int sonuc;
        for(a=1;a<=n;a++){
            int büyük=dersnotlari[b][a];
            int kücük=dersnotlari[c][a];
            for(b=1;b<k;b++) {
                if (büyük < dersnotlari[b][a]) {
                    büyük = dersnotlari[b][a];
                }
            }
            for(c=1;c<k;c++) {
                if (kücük > dersnotlari[c][a]) {
                    kücük = dersnotlari[c][a];
                }
            }
            b=0;
            c=0;
            sonuc=büyük-kücük;
            System.out.println(a+". dersin en büyük ve en küçük not farkı:"+sonuc);
        }


    }


    public static void main(String[] args){
        notprogrami hesapla=new notprogrami();
        Scanner giriş=new Scanner(System.in);
        System.out.println("öğrenci sayısını giriniz:");
        int k= giriş.nextInt();
        System.out.println("ders sayısını giriniz:");
        int n=giriş.nextInt();
        hesapla.matris(k,n);
        hesapla.aritmetik_ortalama(k,n);
        hesapla.geometrik_ort(k,n);
        hesapla.harmonik_ort(k,n);
        hesapla.ogrenci_ortalama(k,n);
        hesapla.fark(k,n);

    }
}

