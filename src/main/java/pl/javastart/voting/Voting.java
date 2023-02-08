package pl.javastart.voting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Voting {

    public static void main(String[] args) {
        List<String> voters = new ArrayList<>();

        voters.add("Jan Kowalski");
        voters.add("Zbigniew Siobro");
        voters.add("Adam Nowak");

        Voting voting = new Voting();

        VotingResult votingResult = voting.executeVoting(voters, new Scanner(System.in));
        votingResult.printResults();
        votingResult.printVoteForVoter("Jan Kowalski");
        votingResult.printVoteForVoter("Zbigniew Siobro");
        votingResult.printVoteForVoter("Adam Nowak");
    }

    VotingResult executeVoting(List<String> voters, Scanner scanner) {
        List<Vote> votingList = new ArrayList<>();
        VotingResult votingResult = new VotingResult(votingList);

        for (String voter : voters) {
            System.out.println("Jak głosuje " + voter + "? (z - za, p - przeciw, w - wstrzymanie się)");
            switch (scanner.nextLine()) {
                case "z":
                    votingList.add(new Vote(voter, Boolean.TRUE));
                    break;
                case "p":
                    votingList.add(new Vote(voter, Boolean.FALSE));
                    break;
                default:
                    votingList.add(new Vote(voter, null));
                    break;
            }
        }
        return votingResult;
    }
}
