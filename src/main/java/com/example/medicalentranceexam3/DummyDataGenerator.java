package com.example.medicalentranceexam3;

import com.example.medicalentranceexam3.alif.Accountant;
import com.example.medicalentranceexam3.alif.Applicant;
import com.example.medicalentranceexam3.utils.BinaryFileHelper;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class DummyDataGenerator {

    public static void main(String[] args) {
        addDummyApplicants();
        addDummyAccountants();
        System.out.println("Dummy data generated successfully!");
    }

    public static void addDummyApplicants() {
        ArrayList<Applicant> applicantList = new ArrayList<>();

//        applicantList.add(new Applicant("A001","", LocalDate.of(2003, 5, 12), "01837384", "sldkjflaj@gmail.com", ""))

        applicantList.add(new Applicant("A001", "Alice Rahman", LocalDate.of(2003, 5, 12), "01710000001", "alice@example.com" , "pass123"));
        applicantList.add(new Applicant("A002", "Bob Karim", LocalDate.of(2002, 3, 8), "01710000002", "bob@example.com", "bobpass"));
        applicantList.add(new Applicant("A003", "Charlie Ahmed", LocalDate.of(2001, 7, 20), "01710000003", "charlie@example.com", "charlie123"));
        applicantList.add(new Applicant("A004", "David Khan", LocalDate.of(2004, 11, 2), "01710000004", "david@example.com", "davidpass"));
        applicantList.add(new Applicant("A005", "Ema Chowdhury", LocalDate.of(2003, 9, 15), "01710000005", "ema@example.com", "emapass"));
        // Add more as needed up to 20

        File applicantFile = new File("data/applicants.bin");
        BinaryFileHelper.writeAllObjects(applicantFile, applicantList);
    }

    public static void addDummyAccountants() {
        ArrayList<Accountant> accountantList = new ArrayList<>();
        accountantList.add(new Accountant("AC001", "Rana Hasan", "rana@example.com", "01810000001", "pass123"));
        accountantList.add(new Accountant("AC002", "Sana Islam", "sana@example.com", "01810000002", "password"));
        accountantList.add(new Accountant("AC003", "Tariq Ahmed", "tariq@example.com", "01810000003", "123456"));
        // Add more as needed

        File accountantFile = new File("data/accountants.bin");
        BinaryFileHelper.writeAllObjects(accountantFile, accountantList);
    }
}
