package pl.javastart.voting;

import java.util.List;

public class VotingResult {
    private List<Vote> voteList;

    public VotingResult(List<Vote> voteList) {
        this.voteList = voteList;
    }

    public void printResults() {
        double voteFor = 0;
        double voteAgains = 0;
        double withheld = 0;
        for (Vote vote : voteList) {
            if (Boolean.TRUE.equals(vote.getVote())) {
                voteFor++;
            } else if (Boolean.FALSE.equals(vote.getVote())) {
                voteAgains++;
            } else {
                withheld++;
            }
        }
        System.out.println("Wstrzymało się: " + String.format("%.2f", (withheld / voteList.size()) * 100) + "%");
        System.out.println("Głosów za: " + String.format("%.2f", (voteFor / voteList.size()) * 100) + "%");
        System.out.println("Głosów przeciw: " + String.format("%.2f", (voteAgains / voteList.size()) * 100) + "%\n");
    }

    public void printVoteForVoter(String voterName) {
        for (Vote vote : voteList) {
            if (voterName.equals(vote.getVoter())) {
                if (null != vote.getVote()) {
                    Boolean voteResult = vote.getVote();
                    if (voteResult.equals(Boolean.TRUE)) {
                        System.out.println(voterName + ": ZA");
                    } else {
                        System.out.println(voterName + ": PRZECIW");
                    }
                } else {
                    System.out.println(voterName + ": WSTRZYMAŁ SIĘ");
                }
            }
        }
    }
}

