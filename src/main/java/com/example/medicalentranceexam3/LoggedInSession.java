package com.example.medicalentranceexam3;

import com.example.medicalentranceexam3.alif.Accountant;
import com.example.medicalentranceexam3.alif.Applicant;
import com.example.medicalentranceexam3.ataul.Director;
import com.example.medicalentranceexam3.ataul.QuestionModerator;

public class LoggedInSession {
    static Applicant loggedInApplicant;
    static Accountant loggedInAccountant;
    static QuestionModerator loggedInQuestionModerator;
    static Director loggedInDirector;



    public static Applicant getLoggedInApplicant() {
        return loggedInApplicant;
    }

    public static void setLoggedInApplicant(Applicant loggedInApplicant) {
        LoggedInSession.loggedInApplicant = loggedInApplicant;
    }

    public static Accountant getLoggedInAccountant() {
        return loggedInAccountant;
    }

    public static void setLoggedInAccountant(Accountant loggedInAccountant) {
        LoggedInSession.loggedInAccountant = loggedInAccountant;
    }

    public static QuestionModerator getLoggedInQuestionModerator() {
        return loggedInQuestionModerator;
    }

    public static void setLoggedInQuestionModerator(QuestionModerator loggedInQuestionModerator) {
        LoggedInSession.loggedInQuestionModerator = loggedInQuestionModerator;
    }

    public static Director getLoggedInDirector() {
        return loggedInDirector;
    }

    public static void setLoggedInDirector(Director loggedInDirector) {
        LoggedInSession.loggedInDirector = loggedInDirector;
    }
}
