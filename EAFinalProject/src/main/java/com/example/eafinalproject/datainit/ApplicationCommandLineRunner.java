package com.example.eafinalproject.datainit;

import com.example.eafinalproject.entities.*;
import com.example.eafinalproject.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Transactional
@Profile("!test")
public class ApplicationCommandLineRunner implements CommandLineRunner {

    @Autowired
    ApplicationRepository applicationRepository;

    @Override
    public void run(String... args) throws Exception {
        initializeData();
    }

    private void initializeData() {

        List<Skill> skillList = new ArrayList<>();
        Skill skill1 = new Skill("frontend", 2, "Design and implementation of UI",
                "Angular");
        Skill skill2 = new Skill("frontend", 2, "Design and implementation of UI",
                "React");
        skillList.add(skill1);
        skillList.add(skill2);

        List<Client> clientList = new ArrayList<>();
        Client client1 = new Client("Morgan Stanley", new Address("RMZ EcoWorld", "Bangalore",
                "Karnataka", "560103"), "dedicated to local" +
                " and global communities since 1935", "Do the right thing",
                "https://www.morganstanley.com/");
        Client client2 = new Client("Goldman Sachs", new Address("Helios Tech Park", "Bangalore",
                "Karnataka", "560103"), " to advance sustainable " +
                "economic growth and financial opportunity across the globe", "Our people are our greatest " +
                "asset.", "https://www.goldmansachs.com/");
        Client client3 = new Client("JPMC", new Address("Prestige Tech Park", "Bangalore",
                "Karnataka", "560087"), " to enable more people to " +
                "contribute to and share in the rewards of a growing economy", "aspire to be the best" +
                "asset.", "https://www.jpmorganchase.com/");
        Client client4 = new Client("Wells Fargo", new Address("Embassy Tech Village", "Bangalore",
                "Karnataka", "560103"), " helping customers succeed financially.",
                "Creating solutions for stronger communities.", "https://www.wellsfargo.com/");
        clientList.add(client4);

        Recruiter recruiter1 = new Recruiter("Synechron", new Address("Global Technology Park",
                "Bangalore", "Karnataka", "560103"), clientList);


        //Interviews
        ScreeningInterview si = new ScreeningInterview(new Date(122, 01, 27), 6412330002L, "kale@miu.com",
                "KamalAle", "Pass");
        TechnicalInterview ti = new TechnicalInterview(new Date(122, 02, 02), 6412330002L, "kale@miu.com",
                12,
                Location.ONLINE,
                "implement a LinkedHashMap");
        ScreeningInterview si2 = new ScreeningInterview(new Date(122, 01, 27), 6412330002L, "kale@miu.com",
                "KamalAle", "Pass");
        TechnicalInterview ti2 = new TechnicalInterview(new Date(122, 02, 02), 6412330002L, "kale@miu.com",
                12,
                Location.ONLINE,
                "implement a LinkedHashMap");
        HiringManagerInterview hi = new HiringManagerInterview(new Date(122, 02, 24), 6412330002L,
                "kale@miu.com", 5, new Date(2022, 04, 01));
        List<Interview> interviewList = new ArrayList<>();
        interviewList.add(si);
        interviewList.add(ti);

        List<Interview> interviewList2 = new ArrayList<>();
        interviewList2.add(si2);
        interviewList2.add(ti2);

        Job job1 = new Job("Software Developer I", 60000, skillList, recruiter1, interviewList);
        Job job2 = new Job("Engineering Analyst", 90000, skillList, client1, null);
        Job job3 = new Job("Technology Analyst", 100000, skillList, client2, null);
        Job job4 = new Job("Technical Analyst", 80000, skillList, client3, null);


        Application application1 = new Application(job1, new Date(), 1.0);
        Application application2 = new Application(job2, new Date(), 1.0);
        Application application3 = new Application(job3, new Date(), 1.0);
        Application application4 = new Application(job4, new Date(), 1.0);


        applicationRepository.save(application1);
        applicationRepository.save(application2);
        applicationRepository.save(application3);
        applicationRepository.save(application4);

    }

}
