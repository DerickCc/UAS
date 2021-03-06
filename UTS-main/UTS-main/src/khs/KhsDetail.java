package khs;

public class KhsDetail {
    public String kodeKHSDetail, kodeKHS;
    private Matakuliah mataKuliah;
    private String stringRetake = "";
    private int nilai = 0;

    public KhsDetail(String kodeKHSDetail, String kodeKHS, Matakuliah mataKuliah, int nilai, String stringRetake){
        this.kodeKHSDetail = kodeKHSDetail;
        this.kodeKHS = kodeKHS;
        this.mataKuliah = mataKuliah;
        this.nilai = nilai;
        this.stringRetake = stringRetake;
    }

    public String getStringRetake(){
        return this.stringRetake;
    }

    public void setStringRetake(String stringRetake){
        this.stringRetake = stringRetake;
    }

    public String getKodeKHSDetail() {
        return this.kodeKHSDetail;
    }

    public void setKodeKHSDetail(String kodeKHSDetail) {
        this.kodeKHSDetail = kodeKHSDetail;
    }

    public String getKodeKHS() {
        return this.kodeKHS;
    }

    public void setKodeKHS(String kodeKHS) {
        this.kodeKHS = kodeKHS;
    }

    public void setMataKuliah(Matakuliah mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public int getNilai() {
        return this.nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }

    public float konversiNilai(){
        if(nilai>=90 && nilai<=100){
            return 4.00f;
        }
		else if(nilai>=85 && nilai<=89.99){
            return 3.70f;
        }
        else if(nilai>=80 && nilai<=84.99){
            return 3.30f;
        } 
        else if (nilai >= 75 && nilai <= 79.99){
            return 3.00f;
        }
        else if(nilai>=70 && nilai<=74.99){
            return 2.70f;
        } 
        else if(nilai>=65 && nilai<=69.99){
            return 2.30f;
        } 
        else if (nilai >= 60 && nilai <= 64.99){
            return 2.00f;
        }
        else{
            return 0.0f;
        }
    }

    public String konversiNilaiHuruf(){
        if(nilai>=90 && nilai<=100){
            return "A";
        }
		else if(nilai>=85 && nilai<=89.99){
            return "A-";
        }
        else if(nilai>=80 && nilai<=84.99){
            return "B+";
        } 
        else if(nilai>=75 && nilai<=79.99){
            return "B";
        }
        else if(nilai>=70 && nilai<=74.99){
            return "B-";
        } 
        else if(nilai>=65 && nilai<=69.99){
            return "C+";
        } 
        else if(nilai>=60 && nilai<=64.99){
            return "C";
        }
        else{
            return "F";
        }
    } 

    public Matakuliah getDetailMatakuliah(){
        return mataKuliah;
    }
    
    public void tampilkanDetailKHS() {
        System.out.printf("%-20s %-30s %-5d\n", kodeKHSDetail, mataKuliah.getNamaMataKuliah(), nilai);
    } 
    
    public void tampilkanDetailKHSRetake() {
        System.out.printf("%-20s %-30s %-5d\n", kodeKHSDetail, mataKuliah.getNamaMataKuliah() + " (Retake)", nilai);
    } 
}
