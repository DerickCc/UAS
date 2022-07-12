package khs;

public class Retake extends KhsDetail {
    private Tagihan tagihan;
    private Term retakeTerm;
    
    public Retake(String kodeKHSDetail, String kodeKHS, Matakuliah mataKuliah, int nilai, Term retakeTerm) {
        super(kodeKHSDetail, kodeKHS, mataKuliah, nilai);
        this.retakeTerm = retakeTerm;
    }

    public Term getTerm() {
        return this.retakeTerm;
    }

    public void tampilkanMataKuliahRetake() {
        System.out.printf("%-20s %-25s %-5d\n", getDetailMatakuliah().getKodeMataKuliah(), getDetailMatakuliah().getNamaMataKuliah(), getDetailMatakuliah().getSks());
    }   

    public float getJumlahTagihan(){
        setTagihan();
        return tagihan.jumlahTagihan();
    }

    public void setTagihan() {
        this.tagihan = new Tagihan(getDetailMatakuliah().getSks()*500000);
    }
    
}
