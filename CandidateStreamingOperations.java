package com.task;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CandidateStreamingOperations {

    public static void main(String[] args) {


        List<Candidate> candidateList =  InterviewRepository.getCandidateList();

        //list candidate names from Pune city
        List<Candidate> listOfPuneCandidates = candidateList.stream().filter(candidate -> candidate.getCity().equalsIgnoreCase("pune")).collect(Collectors.toList());
        System.out.println("List of Pune Candidates:\n"+listOfPuneCandidates);
        CandidateStreamingOperations.printLine();

        //list city and count of candidates per city
        Map<String,Long> countPerCity =  candidateList.stream().
                collect(Collectors.groupingBy(Candidate::getCity, LinkedHashMap::new,Collectors.counting()));
        System.out.println("Candidate count per city\n"+countPerCity);
        CandidateStreamingOperations.printLine();

        //list technical expertise and count of candidates
        Map<String,Long> countPerTechnicalExpertise =  candidateList.stream().
                collect(Collectors.groupingBy(Candidate::getTechnicalExpertise, LinkedHashMap::new,Collectors.counting()));

        System.out.println("Candidate count by Technical Expertise\n"+countPerTechnicalExpertise);
        CandidateStreamingOperations.printLine();

        //list fresher candidates
        List<Candidate> fresherCandidateList = candidateList.stream().filter(c->c.getYearsOfExperience()==0).collect(Collectors.toList());
        System.out.println("Fresher Candidate list\n"+fresherCandidateList);
        CandidateStreamingOperations.printLine();

        //listing candidates with highest experience
        List<Candidate> sortCandidateListByExperience = candidateList.stream().sorted(Comparator.comparingInt(Candidate::getYearsOfExperience).reversed()).collect(Collectors.toList());
        System.out.println("Sorted List of Candidates by Experience\n"+sortCandidateListByExperience);
        printLine();

        //sort the candidates by city name
        List<Candidate> sortCandidateListByCity = candidateList.stream().sorted(Comparator.comparing(Candidate::getCity)).collect(Collectors.toList());
        CandidateStreamingOperations.printLine();
        System.out.println("Sorted List of Candidates by City Name\n"+sortCandidateListByCity);

    }

    private static void printLine() {
        // TODO Auto-generated method stub
        System.out.println("======================================================");
    }



}