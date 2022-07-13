import khs.Khs;
import khs.KhsDetail;
import khs.Krs;
import khs.Mahasiswa;
import khs.Matakuliah;
import khs.Retake;
import khs.Term;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {}
    }

    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int getIndexFromMataKuliah(ArrayList<Matakuliah> array, String kodeMatKul) {
        int index = 0;
        for (Matakuliah matakuliah : array) {
            if (matakuliah.getKodeMataKuliah().equals(kodeMatKul)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public static int getIndexFromMahasiswa(ArrayList<Mahasiswa> array, String studentID) {
        int index = 0;
        for (Mahasiswa mhs : array) {
            if (mhs.getStudentID().equals(studentID)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public static int getIndexFromTerm(ArrayList<Term> array, String kodeTerm) {
        int index = 0;
        for (Term term : array) {
            if (term.getKodeTerm().equals(kodeTerm)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public static int getIndexFromKhs(String studentID, String kodeKHS, ArrayList<Mahasiswa> mahasiswa) {
        int idx = getIndexFromMahasiswa(mahasiswa, studentID);
        int index = 0;
        for (Khs khs : mahasiswa.get(idx).getKHS()) {
            if (khs.getKodeKHS().equals(kodeKHS)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public static int cekKodeKhsRetake(String kodeKhsDetail, String studentID, ArrayList<Mahasiswa> mahasiswa) {
        int idx = getIndexFromMahasiswa(mahasiswa, studentID);
        for (Khs khs : mahasiswa.get(idx).getKHS()) {
            for (KhsDetail khsdetail : khs.getKhsDetails()) {
                if (khsdetail.kodeKHSDetail.equals(kodeKhsDetail)) return 1;
            }
        }
        return 2;
    }

    public static int getKodeKhsRetake(String kodeKhsDetail, String studentID, ArrayList<Mahasiswa> mahasiswa) {
        int idx = getIndexFromMahasiswa(mahasiswa, studentID);
        int index = 0;
        for (Khs khs : mahasiswa.get(idx).getKHS()) {
            for (KhsDetail khsdetail : khs.getKhsDetails()) {
                if (khsdetail.kodeKHSDetail.equals(kodeKhsDetail)) return index;
            }
            index++;
        }
        return -1;
    }

    public static int getKodeKhsDetailretake(String kodeKhsDetail, String studentID, ArrayList<Mahasiswa> mahasiswa) {
        int idx = getIndexFromMahasiswa(mahasiswa, studentID);
        int Idx = getKodeKhsRetake(kodeKhsDetail, studentID, mahasiswa);
        int Index = 0;
        for (KhsDetail khsdetail : mahasiswa.get(idx).getKHS().get(Idx).getKhsDetails()) {
            if (khsdetail.getKodeKHSDetail().equals(kodeKhsDetail)) {
                return Index;
            }
            Index++;
        }
        return -1;
    }

    public static ArrayList<Mahasiswa> initMahasiswa(ArrayList<Mahasiswa> mahasiswa){
        Mahasiswa mhs1 = new Mahasiswa("00001", "Marcello Stevin Halim", "Sistem Informasi", 2020);
        mahasiswa.add(mhs1);
        Mahasiswa mhs2 = new Mahasiswa("00002", "Brian", "Sistem Informasi", 2020);
        mahasiswa.add(mhs2);
        Mahasiswa mhs3 = new Mahasiswa("00003", "Angelo", "Hukum", 2020);
        mahasiswa.add(mhs3);
        return mahasiswa;
    }

    public static ArrayList<Term> initTerm(ArrayList<Term> term){
        Term term1 = new Term("01_term", 2021, "1", "Periode 2021/2022", "Semester Ganjil");
        term.add(term1);
        Term term2 = new Term("02_term", 2022, "2", "Periode 2021/2022", "Semester Genap");
        term.add(term2);
        Term term3 = new Term("03_term", 2022, "3", "Periode 2021/2022", "Semester Akselerasi");
        // System.out.printf("%-10s %-25s %-20s %4s\n", "03_term", "2021", "3", "Periode ****/****", "Semester Pendek");
        term.add(term3);
        return term;
    }

    public static ArrayList<Matakuliah> initMataKuliah(ArrayList<Matakuliah> matKul) {
        Matakuliah matKul1 = new Matakuliah("01_SD", "Struktur Data", 4);
        matKul.add(matKul1);
        Matakuliah matKul2 = new Matakuliah("02_AD", "Agama Dunia", 3);
        matKul.add(matKul2);
        Matakuliah matKul3 = new Matakuliah("03_BI", "Bahasa Indonesia", 2);
        matKul.add(matKul3);
        Matakuliah matKul4 = new Matakuliah("04_SS", "Soft Skill", 2);
        matKul.add(matKul4);
        Matakuliah matKul5 = new Matakuliah("05_AA", "Algoritma", 4);
        matKul.add(matKul5);
        Matakuliah matKul6 = new Matakuliah("06_ST", "Statistika", 3);
        matKul.add(matKul6);
        Matakuliah matKul7 = new Matakuliah("07_WD", "Wawasan Dunia", 3);
        matKul.add(matKul7);
        Matakuliah matKul8 = new Matakuliah("08_MD", "Matematika Diskrit", 3);
        matKul.add(matKul8);
        return matKul;
    }

/*      public static ArrayList<Khs> initKhs(ArrayList<Khs> khs, ArrayList<Mahas{
                
            }iswa> mahasiswas, ArrayList<Term> terms) {
        Khs khs1 = new Khs("002", "Sangat Baik", "Juara umum", mahasiswas.get(0), terms.get(0));
        khs.add(khs1);
        return khs;
    } 

    public static ArrayList<KhsDetail> initKhsDetail(ArrayList<KhsDetail> khsDetails, ArrayList<Matakuliah> matKul) {
        KhsDetail KhsDetails = new KhsDetail("005", "002", matKul.get(0), 90);
        Details.add(KhsDetails);
        return khsDetails;
    } */
    // ini kita bs validasi kode Matkul, kode Term, studentID
    public static int validasiStudentID(String studentID, ArrayList<Mahasiswa> mahasiswa) {
        int idx = getIndexFromMahasiswa(mahasiswa, studentID);
        if (idx == -1) { //21001
            if (studentID.length() == 5) {
                return 1;
            }
            else{
                return 2;
            }
        }
        else {
            return 3;       
        }
    }

    public static int validasiKodeMatKul(String kodeMatkul, ArrayList<Matakuliah> matakuliahs) {
        int idx = getIndexFromMataKuliah(matakuliahs, kodeMatkul);
        if (idx == -1) { //21001
            if (kodeMatkul.length() == 5) {
                return 1;
            }
            else{
                return 2;
            }
        }
        else {
            return 3;       
        }
    }

    public static int validasiSks(int sks) {
        if (sks <= 4 && sks > 1) {
            return 1;
        }
        else return 2;
    }

    public static int validasiTahunMasuk(int tahun) {
        if (tahun >= 1980 && tahun < 2023) {
            return 1;
        }
        else {
            return 2;
        }
    }

    public static int validasiTahunAjaran(int tahun) {
        if (tahun >= 1980 && tahun < 2023) {
            return 1;
        }
        else {
            return 2;
        }
    }

    public static int validasiKodeTerm(String kodeTerm, ArrayList<Term> term) {
        int idx = getIndexFromTerm(term, kodeTerm);
        if (idx == -1) { //01_term
            if (kodeTerm.length() == 7) {
                return 1;
            }
            else{
                return 2;
            }
        }
        else {
            return 3;       
        }
    }

    public static int validasiKodeKrs(String kodeKrs, String studentID, ArrayList<Mahasiswa> mahasiswa) {
        if (kodeKrs.length() == 6) {
            int idx = getIndexFromMahasiswa(mahasiswa, studentID);
            for (Krs krs : mahasiswa.get(idx).getKRS()) {
                if (krs.getKodeKrs().equals(kodeKrs)) return 1;
            }
            return 2;
        }
        else {
            return 3;
        }
    }

    public static int getIndexKrs(String kodeKrs, String studentID, ArrayList<Mahasiswa> mahasiswa) {
        int idx = getIndexFromMahasiswa(mahasiswa, studentID);
        int index = 0;
        for (Krs krs : mahasiswa.get(idx).getKRS()) {
            if (krs.getKodeKrs().equals(kodeKrs)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public static int validasiKodeKhs(String kodeKhs, String studentID, ArrayList<Mahasiswa> mahasiswa) {
        if (kodeKhs.length() == 6) {
            int idx = getIndexFromMahasiswa(mahasiswa, studentID);
            for (Khs khs : mahasiswa.get(idx).getKHS()) {
                if (khs.getKodeKHS().equals(kodeKhs)) return 1;
            }
            return 2;
        }
        else {
            return 3;
        }
    }

    public static int validasiKodeKhsDetail(String kodeKhsDetail, String kodeKhs, String studentID, ArrayList<Mahasiswa> mahasiswa) {
        if (kodeKhsDetail.length() == 7) { //01_khsd
            int idx = getIndexFromMahasiswa(mahasiswa, studentID);
            int index = 0;
            for (Khs khs : mahasiswa.get(idx).getKHS()) {
                if(khs.getKodeKHS().equals(kodeKhs)){
                    break;
                }
                index++;
            }
            for (KhsDetail khsd : mahasiswa.get(idx).getKHS().get(index).khsDetails) {
                if (khsd.getKodeKHSDetail().equals(kodeKhsDetail)) return 1;
            }
            return 2;
        }
        else {
            return 3;
        }
    }

    public static int validasiKodeTermKrs(String kodeTerm, String studentID, ArrayList<Mahasiswa> mahasiswa) {
        int idx = getIndexFromMahasiswa(mahasiswa, studentID);
        for (Krs krs : mahasiswa.get(idx).getKRS()) {
            if (krs.getTerm().getKodeTerm().equals(kodeTerm)) {
                return 1;
            }
        }
        return 2;
    }

    public static int validasiKodeTermKhs(String kodeTerm, String studentID, ArrayList<Mahasiswa> mahasiswa) {
        int idx = getIndexFromMahasiswa(mahasiswa, studentID);
        for (Khs khs : mahasiswa.get(idx).getKHS()) {
            if (khs.getTerm().getKodeTerm().equals(kodeTerm)) {
                return 1;
            }
        }
        return 2;
    }

    public static int validasiMatKulKrs(String kodeMatkul, String kodeKHS, String studentID, ArrayList<Mahasiswa> mahasiswa) {
        int idx = getIndexFromMahasiswa(mahasiswa, studentID);
        int index = getIndexFromKhs(studentID, kodeKHS, mahasiswa);
        int Index = 0;
        String kodeTermKrs = mahasiswa.get(idx).khs.get(index).getTerm().getKodeTerm();
        for (Krs krs : mahasiswa.get(idx).getKRS()) {
            if(krs.getTerm().getKodeTerm().equals(kodeTermKrs)) {
                for (Matakuliah matakuliah : mahasiswa.get(idx).getKRS().get(Index).daftarMataKuliah) {
                    if (kodeMatkul.equals(matakuliah.getKodeMataKuliah())) {
                        return 1;
                    }
                }
            }
            Index++;
        }
        return 2;    
    }

    public static int validasiKodeMatKulKhsd(String kodeMatkul, String kodeKHS, String studentID, ArrayList<Mahasiswa> mahasiswa){
        int idx = getIndexFromMahasiswa(mahasiswa, studentID);
        int index = getIndexFromKhs(studentID, kodeKHS, mahasiswa);
        for(KhsDetail khsd : mahasiswa.get(idx).khs.get(index).getKhsDetails()){
            if(khsd.getDetailMatakuliah().getKodeMataKuliah().equals(kodeMatkul)){
                return 1;
            }
        }
        return 2;
    }

    public static int validasiKodeMatKulRetake(String studentID, String kodeKHS, String kodeMatkul, ArrayList<Mahasiswa> mahasiswa) {
        int index = getIndexFromMahasiswa(mahasiswa, studentID);
        int Idx = getIndexFromKhs(studentID, kodeKHS, mahasiswa);
        if (kodeMatkul.length() == 5) {
            for (Retake retake : mahasiswa.get(index).getKHS().get(Idx).retake) {
                if (retake.getDetailMatakuliah().getKodeMataKuliah().equals(kodeMatkul)) {
                    if (retake.getNilai() < 60) {
                        return 1;
                    }
                    else {
                        return 2;
                    }
                }
            }
            return 3;
        }
        else return 4;
    }

    public static int getindexMatKulRetake(String studentID, String kodeKHS, String kodeMatkul, ArrayList<Mahasiswa> mahasiswa) {
        int index = getIndexFromMahasiswa(mahasiswa, studentID);
        int Idx = getIndexFromKhs(studentID, kodeKHS, mahasiswa);
        int idx = 0;
        for (Retake retake : mahasiswa.get(index).getKHS().get(Idx).retake) {
            if (retake.getDetailMatakuliah().getKodeMataKuliah().equals(kodeMatkul)) {
                return idx;
            }
            idx++;
        }
        return -1;
    }

    public static String getKrsDariTerm(String studentID, String kodeTerm, ArrayList<Mahasiswa> mahasiswa) {
        int idx = getIndexFromMahasiswa(mahasiswa, studentID);
        for (Krs krs : mahasiswa.get(idx).getKRS()) {
            if (krs.getTerm().getKodeTerm().equals(kodeTerm)) {
                return krs.getKodeKrs();
            }
        }
        return "";
    }

    public static int validasiTermRetake(String kodeTerm, String kodeTermRetake, ArrayList<Term> term) {
        int Idx = getIndexFromTerm(term, kodeTerm); //term krs
        int Index = getIndexFromTerm(term, kodeTermRetake); //term krs baru
        if (Idx >= Index) {
            return 1;
        }
        else {
            return 2;
        }
    }

    // public static int cekKodeDetailKhs(String kodeDetailKhs, String studentID, ArrayList<Mahasiswa> mahasiswa) {
    //     int Idx = getIndexFromMahasiswa(mahasiswa, studentID);
    //     int idx = getKodeKhsRetake(kodeDetailKhs, studentID, mahasiswa);
    //     for (int i = 0; i < idx; i++) {
    //         for (Khs khs : mahasiswa.get(Idx).getKHS().get(i)) {
    //             for (KhsDetail khsdetail : khs.getKhsDetails()) {
    //                 if (khsdetail.kodeKHSDetail.equals(kodeDetailKhs)) return 1;
    //             }
    //         }
    //     }
    //     return 2;
    // }

    public static void main(String[] args) throws Exception {
        ArrayList<Term> term = new ArrayList<Term>();
        ArrayList<Matakuliah> mataKuliah = new ArrayList<Matakuliah>();
        ArrayList<Mahasiswa> mahasiswa = new ArrayList<Mahasiswa>();
//        ArrayList<KhsDetail> khsDetails = new ArrayList<KhsDetail>();
//        ArrayList<Khs> KHS = new ArrayList<Khs>();
        
        initMahasiswa(mahasiswa);
        initTerm(term);
        initMataKuliah(mataKuliah);
//        initKhs(KHS, mahasiswa, term);
//        initKhsDetail(khsDetails, mataKuliah);

        Scanner keyboard = new Scanner(System.in);
        String yn = "y";
        while(yn.equalsIgnoreCase("y")){
            clearScreen();
            System.out.println(" Selamat datang! Kami akan melayani Anda, Para Dosen");
            System.out.println(" ---------------------------------------------------");
            System.out.println(" 1. Input/Cetak Mata Kuliah");
            System.out.println(" 2. Input/Cetak Data Mahasiswa");
            System.out.println(" 3. Input/Cetak Data Term/Semester");
            System.out.println(" 4. Input/Cetak Data KRS (Overall)");
            System.out.println(" 5. Input/Cetak Data KHS (Overall)");
            System.out.println(" 6. Input/Cetak Data Detail KHS (MatKul)");
            System.out.println(" 7. Cetak Mata Kuliah Retake");
            System.out.println(" 8. Cetak IP Mahasiswa");
            System.out.println(" 9. Cetak Transkrip (Sementara) Mahasiswa");
            System.out.println("10. Cetak Transkrip Pembayaran (Mahasiswa)");
            System.out.println("11. Keluar");
            System.out.print("Pilihan Anda [1/2/3/4/5/6/7/8/9/10/11] ? ");
            String pilihan = keyboard.next();
            
            clearScreen();
            if (pilihan.equals("1")) {
                System.out.println("Data Mata Kuliah");
                System.out.println("----------------");
                System.out.println("1. Input");
                System.out.println("2. Cetak Mata Kuliah (Kode MatKul)");
                System.out.println("3. Cetak Semua Mata Kuliah");
                System.out.print("Pilihan Anda [1/2/3] ? ");
                String opsi = keyboard.next();

                clearScreen();
                if (opsi.equals("1")) {
                    boolean check = false;
                    while (check == false) {
                        clearScreen();
                        System.out.println("Input Mata Kuliah Baru");
                        System.out.println("----------------------");
                        System.out.print("Masukkan kode mata kuliah : ");
                        String kodeMatKul = keyboard.next();
                        kodeMatKul+=keyboard.nextLine();
                        if (validasiKodeMatKul(kodeMatKul, mataKuliah) == 1) {
                            System.out.print("Masukkan nama mata kuliah : ");
                            String namaMatKul = keyboard.nextLine();
                            while (true) {
                                try {
                                    clearScreen();
                                    System.out.println("Input Mata Kuliah Baru");
                                    System.out.println("----------------------");
                                    System.out.print("Masukkan kode mata kuliah : " + kodeMatKul);
                                    System.out.print("\nMasukkan nama mata kuliah : " + namaMatKul);
                                    System.out.print("\nMasukkan jumlah sks       : ");
                                    int sksMatKul = keyboard.nextInt();
                                    if (validasiSks(sksMatKul) == 1) {
                                        mataKuliah.add(new Matakuliah(kodeMatKul, namaMatKul, sksMatKul));
                                        check = true;
                                        break;
                                    }
                                    else {
                                        System.out.println("\nJumlah Sks harus berupa angka [2-4]");
                                        sleep(2000);
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("\nJumlah sks harus berupa angka [2-4]");
                                    sleep(2000);
                                    keyboard.nextLine();
                                }
                            }
                        }
                        else if (validasiKodeMatKul(kodeMatKul, mataKuliah) == 2) {
                            System.out.println("\nKode Mata Kuliah harus berupa 5 digit!");
                            sleep(2000);
                            continue;
                        }
                        else {
                            System.out.println("\nKode Mata Kuliah telah terdaftar..");
                            sleep(2000);
                            continue;
                        }
                        keyboard.nextLine();
                    }
                }
                else if (opsi.equals("2")) {
                    System.out.println("Cetak Mata Kuliah");
                    System.out.println("-----------------");
                    System.out.print("Masukkan kode mata kuliah : ");
                    String kode = keyboard.next();
                    if (mataKuliah.size() > 0) {
                        int idx = getIndexFromMataKuliah(mataKuliah, kode);
                        if (idx == -1) {
                            System.out.println("Kode yang Anda masukkan invalid..");
                        }
                        else {
                            clearScreen();
                            System.out.println("Data Mata Kuliah");
                            System.out.println("----------------");
                            System.out.println("Kode  : " + mataKuliah.get(idx).getKodeMataKuliah());
                            System.out.println("Nama  : " + mataKuliah.get(idx).getNamaMataKuliah());
                            System.out.println("Sks   : " + mataKuliah.get(idx).getSks());
                        }
                    }
                    else {
                        System.out.println("Tidak ada data mata kuliah yang ditemukan..");
                    }
                }
                else if (opsi.equals("3")) {
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("\t\t\tData Mata Kuliah");
                    System.out.println("----------------------------------------------------------------");
                    System.out.printf("%-20s %-25s %-4s\n", "Kode MatKul", "Nama MatKul", "Sks");
                    System.out.println("----------------------------------------------------------------");
                    for (Matakuliah matKul : mataKuliah) {
                        matKul.tampilkanDataMataKuliah();
                    }
                    System.out.println("----------------------------------------------------------------");
                }
                else {
                    System.out.println("Pilihan tidak tersedia..");
                }
            }

            else if(pilihan.equals("2")) {
                System.out.println("Data Mahasiswa");
                System.out.println("--------------");
                System.out.println("1. Input");
                System.out.println("2. Cetak Mahasiswa (studentID)");
                System.out.println("3. Cetak Semua Data Mahasiswa");
                System.out.print("Pilihan Anda [1/2/3] ? ");
                String opsi = keyboard.next();

                clearScreen();
                if (opsi.equals("1")) {
                    boolean check = false;
                    while (check == false) {
                        clearScreen();
                        System.out.println("Input Mahasiswa Baru");
                        System.out.println("--------------------");
                        System.out.print("Masukkan studentID      : ");
                        String studentID = keyboard.next();
                        if (validasiStudentID(studentID, mahasiswa) == 1) {
                            System.out.print("Masukkan nama mahasiswa : ");
                            String namaMhsString = keyboard.nextLine();
                            namaMhsString += keyboard.nextLine();
                            System.out.print("Masukkan jurusan        : ");
                            String jurusanMhs = keyboard.nextLine();
                            while (true) {
                                clearScreen();
                                System.out.println("Input Mahasiswa Baru");
                                System.out.println("--------------------");
                                System.out.print("Masukkan studentID      : " + studentID);
                                System.out.print("\nMasukkan nama mahasiswa : " + namaMhsString);
                                System.out.print("\nMasukkan jurusan        : " + jurusanMhs);
                                try {
                                    System.out.print("\nMasukkan tahun masuk    : ");
                                    int tahunMasuk = keyboard.nextInt();
                                    if (validasiTahunMasuk(tahunMasuk) == 1) {
                                        mahasiswa.add(new Mahasiswa(studentID, namaMhsString, jurusanMhs, tahunMasuk));
                                        check = true;
                                        break;
                                    }
                                    else {
                                        throw new Exception("\nTahun masuk harus berupa [1980-2022]!");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("\nTahun masuk harus berupa [1980-2022]!");
                                    sleep(2000);
                                    keyboard.nextLine();
                                    continue;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                    sleep(2000);
                                }
                                keyboard.nextLine();
                            }
                        }
                        else if (validasiStudentID(studentID, mahasiswa) == 2){
                            System.out.println("\nStudentID harus berupa 5 digit");
                            sleep(2000);
                            continue;
                        }
                        else {
                            System.out.println("\nStudentID telah terdaftar..");
                            sleep(2000);
                            continue;
                        }
                        keyboard.nextLine();
                    }
                }
                else if (opsi.equals("2")) {
                    System.out.println("Cetak Data Mahasiswa");
                    System.out.println("--------------------");
                    System.out.print("Masukkan studentID : ");
                    String studentID = keyboard.next();
                    if (mahasiswa.size()>0) {
                        int idx = getIndexFromMahasiswa(mahasiswa, studentID);
                        if (idx == -1) {
                            System.out.println("Kode yang Anda masukkan invalid..");
                        }
                        else {
                            clearScreen();
                            System.out.println("Data Mahasiswa");
                            System.out.println("--------------");
                            System.out.println("Student ID    : " + mahasiswa.get(idx).getStudentID());
                            System.out.println("Nama          : " + mahasiswa.get(idx).getNama());
                            System.out.println("Jurusan       : " + mahasiswa.get(idx).getJurusan());
                            System.out.println("Tahun masuk   : " + mahasiswa.get(idx).getTahunMasuk());
                        }
                    }
                    else {
                        System.out.println("Tidak ada data yang ditemukan..");
                    }
                }
                else if (opsi.equals("3")) {
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println("\t\t\tData Mahasiswa");
                    System.out.println("------------------------------------------------------------------------");
                    System.out.printf("%-10s %-25s %-20s %4s\n", "StudentID", "Nama","Jurusan", "Tahun Masuk");
                    System.out.println("------------------------------------------------------------------------");  
                    for (Mahasiswa mhs : mahasiswa) {
                        mhs.tampilDataMahasiswa();
                    } 
                    System.out.println("------------------------------------------------------------------------");        
                }
                else {
                    System.out.println("Pilihan tidak tersedia..");
                }
            }

            else if (pilihan.equals("3")) {
                System.out.println("Data Term/Semester");
                System.out.println("------------------");
                System.out.println("1. Input");
                System.out.println("2. Cetak Term (kode term)");
                System.out.println("3. Cetak Semua Term");
                System.out.print("Pilihan Anda [1/2/3] ? ");
                String opsi = keyboard.next();

                clearScreen();
                if (opsi.equals("1")) {
                    boolean check = false;
                    while (check == false) {
                        clearScreen();
                        System.out.println("Input Data Term/Semester Baru");
                        System.out.println("-----------------------------");
                        System.out.print("Masukkan kode term          : ");
                        String kodeTerm = keyboard.next();
                        if (validasiKodeTerm(kodeTerm, term) == 1) {
                            boolean check1 = false;
                            while (check1 == false) {
                                clearScreen();
                                System.out.println("Input Data Term/Semester Baru");
                                System.out.println("-----------------------------");
                                System.out.print("Masukkan kode term          : " + kodeTerm);
                                try {
                                    System.out.print("\nMasukkan tahun ajaran       : ");
                                    int tahunAjaran = keyboard.nextInt();
                                    keyboard.nextLine();
                                    if (validasiTahunAjaran(tahunAjaran) == 1) {
                                        while (true) {
                                            clearScreen();
                                            System.out.println("Input Data Term/Semester Baru");
                                            System.out.println("-----------------------------");
                                            System.out.print("Masukkan kode term          : " + kodeTerm);
                                            System.out.print("\nMasukkan tahun ajaran       : " + tahunAjaran);
                                            try {
                                                System.out.print("\nMasukkan semester           : ");
                                                String semester = keyboard.nextLine();
                                                int Semester = Integer.parseInt(semester);
                                                System.out.print("Masukkan keterangan         : ");
                                                String keterangan = keyboard.next();
                                                keterangan += keyboard.nextLine();
                                                System.out.print("Masukkan keterangan singkat : ");
                                                String keteranganSingkat = keyboard.nextLine();
                                                term.add(new Term(kodeTerm, tahunAjaran, semester, keterangan, keteranganSingkat));
                                                check1 = true;
                                                check = true;
                                                break;                                                 
                                            } catch (Exception e) {
                                                System.out.println("\nSemester harus diinput dengan angka bulat!");
                                                sleep(2000);
                                                continue;
                                            }                                        
                                        }                                       
                                    }
                                    else {
                                        throw new Exception("\nTahun masuk harus berupa [1980-2022]!");
                                    }                                    
                                } catch (InputMismatchException e) {
                                    System.out.println("\nTahun masuk harus berupa [1980-2022]!");
                                    sleep(2000);
                                    keyboard.nextLine();
                                    continue;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                    sleep(2000);
                                }                                                              
                            }                            
                        }
                        else if (validasiKodeTerm(kodeTerm, term) == 2) {
                            System.out.println("\nKode Term harus berupa 7 digit");
                            sleep(2000);
                            keyboard.nextLine();
                            continue;
                        }
                        else {
                            System.out.println("\nKode term telah terdaftar..");
                            sleep(2000);
                            keyboard.nextLine();
                            continue;
                        }
                    }
                }
                else if (opsi.equals("2")) {
                    System.out.println("Cetak Data Term/Semester");
                    System.out.println("--------------------");
                    System.out.print("Masukkan kode term : ");
                    String kodeTerm = keyboard.nextLine();
                    kodeTerm += keyboard.nextLine();
                    if (mahasiswa.size()>0) {
                        int idx = getIndexFromTerm(term, kodeTerm);
                        if (idx == -1) {
                            System.out.println("Kode yang Anda masukkan invalid..");
                        }
                        else {
                            term.get(idx).tampilTerm();
                        }
                    }
                    else {
                        System.out.println("Tidak ada data yang ditemukan..");
                    }
                }
                else if (opsi.equals("3")) {
                    System.out.println("-------------------------------------------------------------------------------");
                    System.out.println("\t\t\t\tData Term");
                    System.out.println("-------------------------------------------------------------------------------");
                    System.out.printf("%-10s %-15s %-10s %-20s %-10s\n", "Kode", "Tahun Ajaran","Semester", "Keterangan", "Keterangan Singkat");
                    System.out.println("-------------------------------------------------------------------------------");                     
                    for (Term trm : term) {
                        trm.tampilTerm();
                    }
                    System.out.println("-------------------------------------------------------------------------------");
                }
                else {
                    System.out.println("Pilihan tidak tersedia..");
                }
            }

            else if (pilihan.equals("4")) {
                System.out.println("Data Kartu Rencana studi (KRS)");
                System.out.println("------------------------------");
                System.out.println("1. Input");
                System.out.println("2. Tambah Matkul (Kode KRS)");
                System.out.println("3. Cetak");
                System.out.print("Pilihan Anda [1/2/3] ? ");
                String opsi = keyboard.next();

                clearScreen();
                if (opsi.equals("1")) {
                    System.out.println("Input Data KRS Baru");
                    System.out.println("-------------------");
                    System.out.print("Masukkan studentID           : ");
                    String studentID = keyboard.next();
                    int index = getIndexFromMahasiswa(mahasiswa, studentID);
                    if (index == -1) {
                        System.out.println("\nstudentID yang Anda masukkan invalid..");
                    }
                    else {
                        boolean check = false;
                        while (check == false) {
                            clearScreen();
                            System.out.println("Input Data KRS Baru");
                            System.out.println("-------------------");
                            System.out.print("Masukkan studentID           : " + studentID);                            
                            try {
                                System.out.print("\nMasukkan kode KRS            : ");
                                String kodeKRS = keyboard.next();
                                if (validasiKodeKrs(kodeKRS, studentID, mahasiswa) == 1) {
                                    throw new Exception("\nKode KRS telah terdaftar pada mahasiswa dengan studentID (" + studentID + ")");
                                }
                                else if (validasiKodeKrs(kodeKRS, studentID, mahasiswa) == 2) {
                                    System.out.print("Masukkan kode term           : ");
                                    String kodeTerm = keyboard.nextLine();
                                    kodeTerm += keyboard.nextLine();
                                    int idx = getIndexFromTerm(term, kodeTerm);
                                    if (idx == -1) {
                                        System.out.println("\nKode term yang Anda masukkan invalid..");
                                    }
                                    else {
                                        try {
                                            if (validasiKodeTermKrs(kodeTerm, studentID, mahasiswa) == 1) {
                                                throw new Exception("\nAnda telah menginput KRS untuk term/semester tersebut..");
                                            }
                                            else if (validasiKodeTermKrs(kodeTerm, studentID, mahasiswa) == 2) {
                                                String yesNo = "y";
                                                while (yesNo.equalsIgnoreCase("y")) {
                                                    clearScreen();
                                                    System.out.println("Mata kuliah yang ingin diambil");
                                                    System.out.println("------------------------------");
                                                    System.out.print("Kode mata kuliah : ");
                                                    String kodeMatKul = keyboard.nextLine();
                                                    int Index = getIndexFromMataKuliah(mataKuliah, kodeMatKul);
                                                    if (Index == -1) {
                                                        System.out.println("\nKode mata kuliah yang Anda masukkan invalid..");
                                                    }
                                                    else {
                                                        mahasiswa.get(index).krs.add(new Krs(kodeKRS, term.get(idx)));
                                                        int Idx = 0;
                                                        for (Krs krs : mahasiswa.get(index).getKRS()) {
                                                            if (krs.getKodeKrs().equals(kodeKRS)) break;
                                                            Idx++;
                                                        }
                                                        mahasiswa.get(index).getKRS().get(Idx).getDaftarMataKuliah().add(new Matakuliah(mataKuliah.get(Index).getKodeMataKuliah(), mataKuliah.get(Index).getNamaMataKuliah(), mataKuliah.get(Index).getSks()));
                                                    }
                                                    System.out.print("\nApakah Anda ingin memasukkan data lainnya [y/n] ? ");
                                                    yesNo = keyboard.nextLine();
                                                }                                            
                                            }
                                        } catch (Exception e) {
                                            System.out.println(e.getMessage());
                                            sleep(2000);
                                            continue;
                                        }
                                    }
                                    check = true;
                                }   
                                else {
                                    throw new Exception("\nKode KRS harus berupa 6 digit");
                                }
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                sleep(2000);
                                continue;
                            }
                        }
                    }
                }
                else if (opsi.equals("2")) {
                    System.out.println("Tambah Matkul ke KRS");
                    System.out.println("--------------------");
                    System.out.print("Masukkan studentID : ");
                    String studentID = keyboard.nextLine();
                    studentID += keyboard.nextLine();
                    int index = getIndexFromMahasiswa(mahasiswa, studentID);
                    if (index == -1) {
                        System.out.println("\nStudentID yang Anda masukkan invalid..");
                    }
                    else {
                        System.out.print("Masukkan kode KRS  : ");
                        try{
                            String kodeKRS = keyboard.nextLine();
                            if (validasiKodeKrs(kodeKRS, studentID, mahasiswa) == 1) {
                                clearScreen();
                                String yesNo = "y";
                                while (yesNo.equalsIgnoreCase("y")) {
                                    clearScreen();
                                    System.out.println("Mata kuliah yang ingin diambil");
                                    System.out.println("------------------------------");
                                    System.out.print("Kode mata kuliah : ");
                                    String kodeMatKul = keyboard.nextLine();
                                    int Index = getIndexFromMataKuliah(mataKuliah, kodeMatKul);
                                    if (Index == -1) {
                                        System.out.println("\nKode mata kuliah yang Anda masukkan invalid..");
                                    }
                                    else {
                                        int Idx = 0;
                                        for (Krs krs : mahasiswa.get(index).getKRS()) {
                                            if (krs.getKodeKrs().equals(kodeKRS)) break;
                                            Idx++;
                                        }
                                        mahasiswa.get(index).getKRS().get(Idx).getDaftarMataKuliah().add(new Matakuliah(mataKuliah.get(Index).getKodeMataKuliah(), mataKuliah.get(Index).getNamaMataKuliah(), mataKuliah.get(Index).getSks()));
                                    }
                                    System.out.print("\nApakah Anda ingin memasukkan data lainnya [y/n] ? ");
                                    yesNo = keyboard.nextLine();
                                }                                                                
                            }
                            else if (validasiKodeKrs(kodeKRS, studentID, mahasiswa) == 2) {
                                throw new Exception("\nKode KRS belum terdaftar..");
                            }
                            else {
                                System.out.println("\nKode KRS harus berupa 7 digit!");
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            sleep(2000);
                            continue;
                        }
                        
                        
                    }
                }
                else if (opsi.equals("3")) {
                    System.out.println("Cetak Data KRS");
                    System.out.println("--------------");
                    System.out.print("Masukkan studentID : ");
                    String studentID = keyboard.next();
                    int index = getIndexFromMahasiswa(mahasiswa, studentID);
                    if (index == -1) {
                        System.out.println("\nStudentID yang Anda masukkan invalid..");
                    }
                    else {
                        System.out.print("Masukkan kode Krs  : ");
                        String kodeKrs = keyboard.next();
                        int idx = getIndexKrs(kodeKrs, studentID, mahasiswa);
                        if(idx == -1){
                            System.out.println("\nKode Krs tidak terdaftar..");
                        }
                        else {
                            clearScreen();
                            System.out.println("Data Kartu Rencana Studi (KRS)");
                            System.out.println("------------------------------");
                            System.out.println("Daftar Mata Kuliah yang diambil  : ");
                            System.out.println("---------------------------------------------------------------------------------------");
                            System.out.printf("%-10s %-20s %-13s %-30s %-10s\n", "Semester", "Keterangan", "Kode Matkul", "Nama Matkul", "Jumlah SKS");
                            System.out.println("---------------------------------------------------------------------------------------");
                            mahasiswa.get(index).krs.get(idx).tampilkanKrs();
                            System.out.println("---------------------------------------------------------------------------------------");
                        }
                    }
                }
                else {
                    System.out.println("Pilihan tidak tersedia..");
                }
            } // belom selesai

            else if (pilihan.equals("5")) {
                System.out.println("Data Kartu hasil studi (KHS)");
                System.out.println("---------------------------");
                System.out.println("1. Input");
                System.out.println("2. Cetak");
                System.out.print("Pilihan Anda [1/2] ? ");
                String opsi = keyboard.next();

                clearScreen();
                if (opsi.equals("1")) {
                    System.out.println("Input Data KHS Baru");
                    System.out.println("-------------------");
                    System.out.print("Masukkan studentID           : ");
                    String studentID = keyboard.next();
                    int index = getIndexFromMahasiswa(mahasiswa, studentID);
                    if (index == -1) {
                        System.out.println("studentID yang Anda masukkan invalid..");
                    }
                    else {
                        boolean check = false;
                        while (check == false) {
                            clearScreen();
                            System.out.println("Input Data KHS Baru");
                            System.out.println("-------------------");
                            System.out.print("Masukkan studentID           : " + studentID);
                            String kodeKHS = "";
                            try {
                                System.out.print("\nMasukkan kode KHS            : ");
                                kodeKHS = keyboard.next();
                                if (validasiKodeKhs(kodeKHS, studentID, mahasiswa) == 1) {
                                    throw new Exception("\nKode KHS telah terdaftar..");
                                }
                                else if (validasiKodeKhs(kodeKHS, studentID, mahasiswa) == 2) {
                                    while (true) {
                                        clearScreen();
                                        System.out.println("Input Data KHS Baru");
                                        System.out.println("-------------------");
                                        System.out.print("Masukkan studentID           : " + studentID);
                                        System.out.print("\nMasukkan kode KHS            : " + kodeKHS);
                                        System.out.print("\nMasukkan kode term           : ");
                                        
                                        String kodeTerm = keyboard.next();
                                        int idx = getIndexFromTerm(term, kodeTerm);
                                        if (idx == -1) {
                                            System.out.println("\nKode term yang Anda masukkan invalid..");
                                        }
                                        else {
                                            try{
                                                if (validasiKodeTermKhs(kodeTerm, studentID, mahasiswa) == 1) {
                                                throw new Exception("\nAnda telah menginput KHS untuk term/semester tersebut..");
                                                }
                                                else if (validasiKodeTermKhs(kodeTerm, studentID, mahasiswa) == 2) {
                                                    System.out.print("Masukkan keterangan          : ");
                                                    String keterangan = keyboard.next();
                                                    System.out.print("Masukkan keterangan singkat  : ");
                                                    String keteranganSingkat = keyboard.next();
                                                    mahasiswa.get(index).khs.add(new Khs(kodeKHS, keterangan, keteranganSingkat, mahasiswa.get(index), term.get(idx)));
                                                    check = true;
                                                    break; 
                                                }
                                            }
                                            catch (Exception e){
                                                System.out.println(e.getMessage());
                                                sleep(2000);
                                                continue;
                                            }
                                        }
                                    }
                                }
                                else {
                                    throw new Exception("\nKode KHS harus berupa 6 digit!");
                                }                                     
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                sleep(2000);
                                continue;
                            }
                        }
                    }
                }
                else if (opsi.equals("2")) {
                    System.out.println("Cetak Data KHS");
                    System.out.println("--------------");
                    System.out.print("Masukkan studentID : ");
                    String studentID = keyboard.nextLine();
                    studentID += keyboard.nextLine();
                    int index = getIndexFromMahasiswa(mahasiswa, studentID);
                    if (index == -1) {
                        System.out.println("\nStudentID yang Anda masukkan invalid..");
                    }
                    else {
                        System.out.print("Masukkan kode KHS  : ");
                        String kodeKHS = keyboard.next();
                        boolean temu = false;
                        int idx = 0;
                            
                        for (Khs khs1 : mahasiswa.get(index).getKHS()) {
                            if (khs1.getKodeKHS().equalsIgnoreCase(kodeKHS)) {
                                temu = true;
                                if (mahasiswa.get(index).khs.get(idx).getKhsDetails().size() == 0) {
                                    System.out.println("\nTidak ada Detail KHS yang ditemukan..");
                                }
                                else {
                                    clearScreen();
                                    mahasiswa.get(index).khs.get(idx).cetakKHS();
                                }
                                break;
                            }
                            idx++;
                        }
                        if(temu == false){
                            System.out.println("\nKode KHS yang Anda masukkan invalid..");
                        }
                    }
                }
                else {
                    System.out.println("\nPilihan tidak tersedia..");
                }
            }

            else if (pilihan.equals("6")) {
                System.out.println("Data Detail KHS (MatKul)");
                System.out.println("------------------------");
                System.out.println("1. Input");
                System.out.println("2. Cetak");
                System.out.print("Pilihan Anda [1/2] ? ");
                String opsi = keyboard.next();

                clearScreen();
                if (opsi.equals("1")) {
                    System.out.println("Input Data Detail KHS Baru");
                    System.out.println("-----------------------------");
                    System.out.print("Masukkan studentID        : ");
                    String studentID = keyboard.nextLine();
                    studentID += keyboard.nextLine();
                    int index = getIndexFromMahasiswa(mahasiswa, studentID);
                    if (index == -1) {
                        System.out.println("\nStudentID yang Anda masukkan invalid..");
                    }
                    else {
                        boolean check = false;
                        while (check == false) {
                            clearScreen();
                            System.out.println("Input Data Detail KHS Baru");
                            System.out.println("-----------------------------");
                            System.out.println("Masukkan studentID        : " + studentID);
                            System.out.print("Masukkan kode KHS         : ");
                            String kodeKHS = "";
                            try {
                                kodeKHS = keyboard.nextLine();
                                if (validasiKodeKhs(kodeKHS, studentID, mahasiswa) == 1){
                                    boolean check2 = false;
                                    while (check2 == false) {
                                        clearScreen();
                                        System.out.println("Input Data Detail KHS Baru");
                                        System.out.println("-----------------------------");
                                        System.out.println("Masukkan studentID        : " + studentID);
                                        System.out.println("Masukkan kode KHS         : " + kodeKHS);
                                        System.out.print("Masukkan kode detail KHS  : ");
                                        String kodeDetailKHS = "";
                                        try{
                                            kodeDetailKHS = keyboard.next(); 
                                            if (validasiKodeKhsDetail(kodeDetailKHS, kodeKHS, studentID, mahasiswa) == 1){
                                                throw new Exception("\nKode KHS detail telah terdaftar dalam KHS tersebut..");
                                            }
                                            else if (validasiKodeKhsDetail(kodeDetailKHS, kodeKHS, studentID, mahasiswa) == 2) {                                
                                                int Index = getIndexFromKhs(studentID, kodeKHS, mahasiswa);
                                                boolean temu = false;
                                                for (Khs khs : mahasiswa.get(index).getKHS()) {
                                                    if (khs.getKodeKHS().equals(kodeKHS)) {
                                                        temu = true;
                                                        boolean check3 = false;
                                                        while (check3 == false) {
                                                            clearScreen();
                                                            System.out.println("Input Data Detail KHS Baru");
                                                            System.out.println("-----------------------------");
                                                            System.out.println("Masukkan studentID        : " + studentID);
                                                            System.out.println("Masukkan kode KHS         : " + kodeKHS);
                                                            System.out.println("Masukkan kode detail KHS  : " + kodeDetailKHS);
                                                            System.out.print("Masukkan kode mata kuliah : ");
                                                            String matKul = keyboard.next();
                                                            int IDX = getIndexFromMataKuliah(mataKuliah, matKul);
                                                            try {
                                                                if (IDX != -1) {
                                                                    if (validasiMatKulKrs(matKul, kodeKHS, studentID, mahasiswa) == 1 && 
                                                                        validasiKodeMatKulKhsd(matKul, kodeKHS, studentID, mahasiswa) == 2) {
                                                                        while (true) {
                                                                            clearScreen();
                                                                            System.out.println("Input Data Detail KHS Baru");
                                                                            System.out.println("-----------------------------");
                                                                            System.out.println("Masukkan studentID        : " + studentID);
                                                                            System.out.println("Masukkan kode KHS         : " + kodeKHS);
                                                                            System.out.println("Masukkan kode detail KHS  : " + kodeDetailKHS);
                                                                            System.out.println("Masukkan kode mata kuliah : " + matKul);
                                                                            System.out.print("Masukkan nilai            : ");
                                                                            try {                                                
                                                                                int nilai = keyboard.nextInt();
                                                                                Mahasiswa mhs = mahasiswa.get(index);
                                                                                if (nilai >= 0 && nilai <= 100) {
                                                                                    //mhs.khs.get(Index).khsDetails.add(new KhsDetail(kodeDetailKHS, kodeKHS, mataKuliah.get(IDX), nilai));
                                                                                    if (nilai < 60 && nilai >= 0) {
                                                                                        System.out.print("\nTekan y untuk retake matakuliah ini: ");
                                                                                        String jwb = keyboard.next();
                                                                                        if(jwb.equalsIgnoreCase("y")) {
                                                                                            while (true) {
                                                                                                clearScreen();
                                                                                                System.out.println("Retake Mata Kuliah");
                                                                                                System.out.println("------------------");
                                                                                                System.out.print("Masukkan term untuk melakukan retake (Kode Term) : ");
                                                                                                try {
                                                                                                    String kodeTerm = keyboard.next();
                                                                                                    int idx = getIndexFromTerm(term, kodeTerm);
                                                                                                    if (idx == -1) {
                                                                                                        throw new Exception("\nKode term yang Anda masukkan invalid..");
                                                                                                    }
                                                                                                    else {
                                                                                                        int Idx = getIndexFromKhs(studentID, kodeKHS, mahasiswa);
                                                                                                        if (validasiTermRetake(mahasiswa.get(index).getKHS().get(Idx).getTerm().getKodeTerm(), kodeTerm, term) == 1){
                                                                                                            throw new Exception("\nRetake tidak dapat dilakukan pada term sebelum dan term saat ini..");
                                                                                                        }
                                                                                                        else {
                                                                                                            clearScreen();
                                                                                                            String kodeKrs = getKrsDariTerm(studentID, kodeTerm, mahasiswa);
                                                                                                            if (kodeKrs.equals("")) {
                                                                                                                while (true) {
                                                                                                                    try {
                                                                                                                        clearScreen();
                                                                                                                        System.out.println("Retake Mata Kuliah");
                                                                                                                        System.out.println("------------------");
                                                                                                                        System.out.println("Masukkan term untuk melakukan retake (Kode Term) : " + kodeTerm);
                                                                                                                        System.out.print("Masukkan kode Krs baru                           : ");
                                                                                                                        String kodeKrsBaru = keyboard.next();
                                                                                                                        if (validasiKodeKrs(kodeKrsBaru, studentID, mahasiswa) == 1) {
                                                                                                                            throw new Exception("\nKode Krs telah terdaftar..");
                                                                                                                        }
                                                                                                                        else if (validasiKodeKrs(kodeKrsBaru, studentID, mahasiswa) == 2) {
                                                                                                                            mhs.khs.get(Index).khsDetails.add(new KhsDetail(kodeDetailKHS, kodeKHS, mataKuliah.get(IDX), nilai));
                                                                                                                            mhs.getKRS().add(new Krs(kodeKrsBaru, term.get(idx)));
                                                                                                                            int indexKrs = getIndexKrs(kodeKrsBaru, studentID, mahasiswa);
                                                                                                                            mhs.getKRS().get(indexKrs).getDaftarMataKuliah().add(new Matakuliah(mataKuliah.get(IDX).getKodeMataKuliah(), mataKuliah.get(IDX).getNamaMataKuliah() + " (Retake)", mataKuliah.get(IDX).getSks()));
                                                                                                                            mhs.getKHS().get(Index).retake.add(new Retake(kodeDetailKHS, kodeKHS, mataKuliah.get(IDX), nilai, term.get(idx))); 
                                                                                                                            break;
                                                                                                                        }
                                                                                                                        else {
                                                                                                                            throw new Exception("\nKode KRS harus berupa 6 digit!");
                                                                                                                        }
                                                                                                                    } catch (Exception e) {
                                                                                                                        System.out.println(e.getMessage()); 
                                                                                                                        sleep(2000);                                                                                                               
                                                                                                                        continue;
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                            else {
                                                                                                                int indexKrs = getIndexKrs(kodeKrs, studentID, mahasiswa);
                                                                                                                mhs.getKRS().get(indexKrs).getDaftarMataKuliah().add(new Matakuliah(mataKuliah.get(IDX).getKodeMataKuliah(), mataKuliah.get(IDX).getNamaMataKuliah() + " (Retake)", mataKuliah.get(IDX).getSks()));
                                                                                                            }
                                                                                                            System.out.println("\nMatakuliah akan di-retake pada term yang telah ditentukan");
                                                                                                            break;
                                                                                                        }
                                                                                                    }                                                                                               
                                                                                                } catch (Exception e) {
                                                                                                    System.out.println(e.getMessage());
                                                                                                    sleep(2000);
                                                                                                    continue;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        else {
                                                                                            mhs.khs.get(Index).khsDetails.add(new KhsDetail(kodeDetailKHS, kodeKHS, mataKuliah.get(IDX), nilai));
                                                                                            System.out.println("\nMatakuliah ini tidak akan di-retake");
                                                                                        }
                                                                                    }
                                                                                    else {
                                                                                        if (cekKodeKhsRetake(kodeDetailKHS, studentID, mahasiswa) == 1) {
                                                                                            int idx = getKodeKhsRetake(kodeDetailKHS, studentID, mahasiswa);
                                                                                            mhs.khs.get(idx).retake.add(new Retake(kodeDetailKHS, kodeKHS, mataKuliah.get(IDX), nilai, mahasiswa.get(index).getKHS().get(idx).getTerm())); //salah
                                                                                        }
                                                                                        mhs.khs.get(Index).khsDetails.add(new KhsDetail(kodeDetailKHS, kodeKHS, mataKuliah.get(IDX), nilai));
                                                                                    }
                                                                                    check2 = true;
                                                                                    check3 = true;
                                                                                    break;
                                                                                }
                                                                                else {
                                                                                    throw new Exception("\nNilai harus berupa angka [1-100]!");
                                                                                }
                                                                            } catch (InputMismatchException e) {
                                                                                System.out.println("\nNilai harus berupa angka!");
                                                                                keyboard.nextLine();
                                                                                sleep(2000);
                                                                                continue;
                                                                            } catch(Exception e){
                                                                                System.out.println(e.getMessage());
                                                                                sleep(2000);
                                                                                continue;
                                                                            }
                                                                        }
                                                                    }
                                                                    else if(validasiMatKulKrs(matKul, kodeKHS, studentID, mahasiswa) == 2){
                                                                        throw new Exception("\nMatakuliah ini tidak terdaftar pada KRS Anda..");
                                                                    }  
                                                                    else if(validasiKodeMatKulKhsd(matKul, kodeKHS, studentID, mahasiswa) == 1){
                                                                        throw new Exception("\nMatakuliah ini sudah terdaftar pada KHS Anda..");
                                                                    }
                                                                }
                                                                else {
                                                                    if (matKul.length() == 5) {
                                                                        System.out.println("\nKode Mata Kuliah yang Anda masukkan invalid..");
                                                                    }
                                                                    else System.out.println("\nKode Mata Kuliah harus berupa 5 digit!");
                                                                    sleep(2000);
                                                                }    
                                                            } catch (Exception e) {
                                                                System.out.println(e.getMessage());
                                                                sleep(2000);
                                                                continue;
                                                            }
                                                        }
                                                        break;
                                                    }
                                                } 
                                                if(temu == false) {
                                                    System.out.println("\nKode KHS yang Anda masukkan invalid..");
                                                }
                                            }
                                            else {
                                                throw new Exception("\nKode Detail KHS harus berupa 7 digit!");
                                            }
                                        } catch(Exception e){
                                            System.out.println(e.getMessage());
                                            sleep(2000);
                                            continue;
                                        } 
                                    }                             
                                }   
                                else if(validasiKodeKhs(kodeKHS, studentID, mahasiswa) == 2) {
                                    throw new Exception("\nKode KHS belum terdaftar..");
                                } 
                                else{
                                    throw new Exception("\nKode KHS harus berupa 6 digit!");
                                }                           
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                sleep(2000);
                                continue;
                            } 
                            check = true;
                        }
                    }
                }
                else if (opsi.equals("2")) {
                    System.out.println("Cetak Data Detail KHS");
                    System.out.println("---------------------");
                    System.out.print("Masukkan studentID        : ");
                    String studentID = keyboard.nextLine();
                    studentID += keyboard.nextLine();
                    int index = getIndexFromMahasiswa(mahasiswa, studentID);
                    if (index == -1) {
                        System.out.println("\nStudentID yang Anda masukkan invalid..");
                    }
                    else {
                        System.out.print("Masukkan kode KHS         : ");
                        try {
                            String kodeKHS = keyboard.next();
                            if (validasiKodeKhs(kodeKHS, studentID, mahasiswa) == 1) {
                                boolean temu = false;
                                int idx = 0;
                                for (Khs khs : mahasiswa.get(index).getKHS()) {
                                    if (khs.getKodeKHS().equals(kodeKHS)) {
                                        temu = true;
                                        System.out.print("Masukkan kode detail KHS  : ");
                                        try {
                                            String kodeDetailKHS = keyboard.next();
                                            if (validasiKodeKhsDetail(kodeDetailKHS, kodeKHS, studentID, mahasiswa) == 1) {
                                                clearScreen();
                                                boolean ketemu = false;
                                                int Index = 0;
                                                System.out.println("-------------------------------------------------------------");
                                                System.out.printf("%-20s %-10s\n", " ","Detail KHS");
                                                System.out.println("-------------------------------------------------------------");
                                                System.out.printf("%-20s %-30s %-5s\n", "Kode Detail Khs", "Nama Matkul", "Nilai");
                                                System.out.println("-------------------------------------------------------------");
                                                for (KhsDetail khsDetail : mahasiswa.get(index).khs.get(idx).khsDetails) {
                                                    if (khsDetail.kodeKHSDetail.equals(kodeDetailKHS)) {
                                                        ketemu = true;
                                                        mahasiswa.get(index).khs.get(idx).khsDetails.get(Index).tampilkanDetailKHS();
                                                    }
                                                    Index++;
                                                }
                                                System.out.println("-------------------------------------------------------------");
                                                if(ketemu == false) {
                                                    System.out.println("\nKode detail KHS yang Anda masukkan invalid..");
                                                }
                                                break;                                            
                                            }
                                            else if (validasiKodeKhsDetail(kodeDetailKHS, kodeKHS, studentID, mahasiswa) == 2){
                                                throw new Exception("\nKode detail KHS tidak terdaftar..");
                                            }else{
                                                throw new Exception("\nKode detail KHS harus berupa 7 digit!");
                                            }
                                        } catch (Exception e) {
                                            System.out.println(e.getMessage());
                                            sleep(2000);
                                            continue;
                                        }
                                    }
                                    idx++;
                                }
                                if(temu == false) {
                                    System.out.println("Kode KHS yang Anda masukkan invalid..");
                                }
                            }
                            else if (validasiKodeKhs(kodeKHS, studentID, mahasiswa) == 2) {
                                throw new Exception("Kode KHS belum terdaftar..");
                            } else {
                                throw new Exception ("Kode KHS harus berupa 6 digit!");
                            }                           
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            sleep(2000);
                            continue;
                        }
                    }
                }
                else {
                    System.out.println("Pilihan tidak tersedia..");
                }
            }

            else if (pilihan.equals("7")) {
                System.out.println("Cetak Mata Kuliah Retake");
                System.out.println("-------------------------");
                System.out.print("Masukkan studentID : ");
                String studentID = keyboard.next();
                int index = getIndexFromMahasiswa(mahasiswa, studentID);
                if (index == -1) {
                    System.out.println("StudentID yang Anda masukkan invalid..");
                }
                else {
                    clearScreen();
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("\t\t     Data Mata Kuliah Retake");
                    System.out.println("----------------------------------------------------------------");
                    System.out.printf("%-20s %-30s %-4s\n", "Kode MatKul", "Nama MatKul", "Sks");
                    System.out.println("----------------------------------------------------------------");
                    int jumlahRetake = 0;
                    for (Khs khs : mahasiswa.get(index).getKHS()) {
                        jumlahRetake+=khs.retake.size();
                        for (Retake retake : khs.retake) {
                            retake.tampilkanMataKuliahRetake();
                        }
                    }
                    if (jumlahRetake == 0) {
                        System.out.println("Tidak ada data yang ditemukan..");
                    }
                    System.out.println("----------------------------------------------------------------");
                }
            }
            
            else if (pilihan.equals("8")) {
                System.out.println("Cetak IP Mahasiswa");
                System.out.println("------------------");
                System.out.println("1. IP Mahasiswa per Semester");
                System.out.println("2. IPK Sementara Mahasiswa");
                System.out.print("Pilihan Anda [1/2] ? ");
                String opsi = keyboard.next();

                clearScreen();
                if(opsi=="1"){
                    System.out.println("IP Mahasiswa per Semester");
                    System.out.println("--------------------------");
                    System.out.print("Masukkan studentID : ");
                    String studentID = keyboard.next();
                    int index = getIndexFromMahasiswa(mahasiswa, studentID);
                    if (index == -1) {
                        System.out.print("StudentID yang Anda masukkan invalid..");
                    }
                    else {
                        System.out.print("Masukkan kode term : ");
                        String kodeTerm = keyboard.next();
                        int idx = getIndexFromTerm(term, kodeTerm);
                        if (idx == -1) {
                            System.out.println("Kode term yang Anda masukkan invalid..");
                        }
                        else {
                            clearScreen();
                        System.out.println("----------------------------------------------------------------");
                        System.out.println("\t\t  IPK Mahasiswa per Semester");
                        System.out.println("----------------------------------------------------------------");
                        System.out.println("Nama          : " +  mahasiswa.get(index).getNama());
                        System.out.println("Student ID    : " +  mahasiswa.get(index).getStudentID());
                        System.out.println("Jurusan       : " +  mahasiswa.get(index).getJurusan()); 
                        System.out.println("Term          : " +  term.get(idx).getSemester());
                        System.out.println("IP Semester   : " +  String.format("%.2f",mahasiswa.get(index).getIPKTerm(term.get(idx))));
                        System.out.println("----------------------------------------------------------------");
                        }
                    }
                }
                else if(opsi == "2"){
                    System.out.println("IPK Sementara Mahasiswa");
                    System.out.println("-----------------------");
                    System.out.print("Masukkan studentID : ");
                    String studentID = keyboard.next();
                    int idx = getIndexFromMahasiswa(mahasiswa, studentID);
                    if (idx == -1) {
                        System.out.println("\nStudentID yang Anda masukkan invalid..");
                    }
                    else {
                        clearScreen();
                        System.out.println("----------------------------------------------------------------");
                        System.out.println("\t\t  IPK Sementara Mahasiswa");
                        System.out.println("----------------------------------------------------------------");
                        System.out.println("Nama          : " +  mahasiswa.get(idx).getNama());
                        System.out.println("Student ID    : " +  mahasiswa.get(idx).getStudentID());
                        System.out.println("Jurusan       : " +  mahasiswa.get(idx).getJurusan()); 
                        System.out.println("IPK Sementara : " +  String.format("%.2f",mahasiswa.get(idx).getIPK()));
                        System.out.println("----------------------------------------------------------------");
                    }
                }
                else{
                    System.out.println("\nPilihan tidak tersedia..");
                }
            }

            else if (pilihan.equals("9")) {
                System.out.println("Transkrip Nilai Mahasiswa");
                System.out.println("-------------------------");
                System.out.print("Masukkan studentID : ");
                String studentID = keyboard.next();
                int idx = getIndexFromMahasiswa(mahasiswa, studentID);
                if (idx == -1) {
                    System.out.println("\nstudentID yang Anda masukkan invalid..");
                }
                else {
                    clearScreen();
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.println("\t\t\tTranskrip Nilai Mahasiswa");
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.println("Nama        : " +  mahasiswa.get(idx).getNama());
                    System.out.println("Student ID  : " +  mahasiswa.get(idx).getStudentID());
                    System.out.println("Jurusan     : " +  mahasiswa.get(idx).getJurusan());
                    System.out.println("-------------------------------------------------------------------------");
                    
                    if (mahasiswa.get(idx).khs.size() == 0) {
                        System.out.println("\nData tidak ditemukan..");
                    }
                    else {
                        System.out.printf("%-5s %-13s %-20s %-6s %-7s %-7s %-7s\n", "Semester", "Kode MatKul", "Nama MatKul","Sks","Nilai Huruf", "Nilai Angka","Angka Kualitas");
                        System.out.println("-------------------------------------------------------------------------");
                        for (Khs khs : mahasiswa.get(idx).khs) {
                            String semester = khs.getDetailTerm().getSemester();
                            for (KhsDetail khsDetail : khs.getKhsDetails()) {
                                String kode = khsDetail.getDetailMatakuliah().getKodeMataKuliah();
                                String nama = khsDetail.getDetailMatakuliah().getNamaMataKuliah();
                                int sks = khsDetail.getDetailMatakuliah().getSks();
                                String huruf = khsDetail.konversiNilaiHuruf();
                                int nilai = khsDetail.getNilai();
                                float angka = khsDetail.getDetailMatakuliah().getSks() *khsDetail.konversiNilai();
                                System.out.printf("%-5s %-13s %-20s %-6d %-7s %-7d %-7.2f\n", semester, kode, nama, sks, huruf, nilai, angka);
                            }
                        }
                        System.out.println("-------------------------------------------------------------------------\n");
                    }
                }
            }

            else if (pilihan.equals("10")) {
                System.out.println("Cetak Transkrip Pembayaran");
                System.out.println("--------------------------");
                System.out.println("1. Biaya Tagihan per Semester");
                System.out.println("2. Biaya Tagihan Keseluruhan Semester");
                System.out.print("Pilihan Anda [1/2] ? ");
                String opsi = keyboard.next();

                clearScreen();
                if (opsi.equals("1")) {
                    System.out.println("Biaya Tagihan Semester Mahasiswa");
                    System.out.println("--------------------------------");
                    System.out.print("Masukkan studentID : ");
                    String studentID = keyboard.next();
                    int index = getIndexFromMahasiswa(mahasiswa, studentID);
                    if (index == -1) {
                        System.out.print("StudentID yang Anda masukkan invalid..");
                    }
                    else {
                        System.out.print("Masukkan kode term : ");
                        String kodeTerm = keyboard.next();
                        int idx = getIndexFromTerm(term, kodeTerm);
                        if (idx == -1) {
                            System.out.println("Kode term yang Anda masukkan invalid..");
                        }
                        else {
                            try{
                                int Index = 0;
                                for (Krs krs : mahasiswa.get(index).getKRS()) {
                                    if (krs.getTerm().getKodeTerm().equals(kodeTerm)) {
                                        break;
                                    }
                                    Index++;
                                }
                                mahasiswa.get(index).getKRS().get(Index).getTagihan().tampilkanPembayaran();
                            } catch(IndexOutOfBoundsException e){
                                System.out.println("\nBelum ada matakuliah yang terdaftar pada semester ini..");
                                sleep(2000);
                                continue;
                            }
                        }
                    } 
                } 
                else if(opsi.equals("2")) {
                    System.out.println("Biaya Tagihan Keseluruhan Semester Mahasiswa");
                    System.out.println("--------------------------------------------");
                    System.out.print("Masukkan studentID : ");
                    String studentID = keyboard.next();
                    int index = getIndexFromMahasiswa(mahasiswa, studentID);
                    if (index == -1) {
                        System.out.print("StudentID yang Anda masukkan invalid..");
                    }
                    else {
                        try{
                            mahasiswa.get(index).tampilkanPembayaran();;
                        } catch(IndexOutOfBoundsException e){
                            System.out.println("\nBelum ada matakuliah yang terdaftar pada semester ini..");
                            sleep(2000);
                            continue;
                        }
                    
                    }
                }
                else {
                    System.out.println("\nPilihan tidak tersedia..");
                }  
            }

            else if (pilihan.equals("11")) {
                break;
            }

            else {
                System.out.println("Pilihan tidak tersedia..");
            }

            System.out.print("\nKembali ke halaman utama [y/n] ? ");
            yn = keyboard.next();
        }

            clearScreen();
            System.out.println("\nTerima Kasih!\n");
            keyboard.close();
        }
}   
