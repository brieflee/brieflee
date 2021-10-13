package com.brieflee.services;

import com.brieflee.beans.Author;
import com.brieflee.beans.BTag;
import com.brieflee.dto.BSampleFeed;
import com.brieflee.dto.BSampleRequest;
import com.brieflee.dto.BSampleResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SampleFeedServiceForIntegrationImpl implements SampleFeedServiceForIntegration {

    private static List<BTag> bTags = new ArrayList<>();
    private static Author author;
    private final String imageUrl = "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAoHCBUWFRgVFhUYGRgYGBgcGhoYGhgYGBwaHBgZGRwaGBkcIS4lHB4rHxgYJjgmKy8xNTU1GiQ7QDs0Py40NTEBDAwMEA8QHhISHjQrISs0NDQ0NDQ0NDQ0NDY0NTQ0NDQ0NDQ0NDQ0NDQ0PTQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NP/AABEIAKgBLAMBIgACEQEDEQH/xAAbAAADAQEBAQEAAAAAAAAAAAAAAQIDBAUHBv/EAD0QAAEDAQUGBAQDBwMFAAAAAAEAAhEhAxIxQVEEYXGBkfChscHRBRMi4TJT8QYUFSNCcpJSgsIWQ2Ki0v/EABoBAQEBAQEBAQAAAAAAAAAAAAABAgMEBQb/xAAmEQEBAQABBAECBwEAAAAAAAAAARECAxIhMUFRoQQUUnGRwfAT/9oADAMBAAIRAxEAPwDgThACcLi/LYUJpgJgKLhQqSCqEUoTKEIohCaAEAEIQgEQnCaAAQhCKEIThAgmAqQi4EIRCKQTATQi4EIhNRSTQAmEXChNCYCKRThATQCAgIUUIQhAwkhCmq4E4VIW3lCEIRQmEkwhhoTSQ0JhACcIFCaEIoQEIQCEwqQkTCpCUI0aEBNFKFUICSimkhNFwQnCEIoQmhAAJoQihCEKAAQhCmqEIQpqhOEkSpo40IQury4EBBwSBQw0pQ4pI1I0CoBZtctESzAUpTSzRIE0im1FwIQENRqQ5VKTimEXAU0JNRTlNQqlRcMoRCYCGAJhSAVSLgQEFBwUUwnKhUiiUJFMoYYQkELOqJQSlmhymqpIlSCiU0OUSpQVnRyhUolWKru8pSjBNZufKLIAmlKYGaNBascsZVMNULx1ughK+neRmcUhOErwxkIDhqjWKAQUNKHIoQi8BmgEIuKSKGIKhIaR1ReyUOOSNSNLNy1XMCtmvRbFoSvDVMFRMCcJwgoJUwqvDVJxCmtRLnQizdkoc0nJINIyU1cboSvhF4KahpOCLyV4arOiUBJxCTSpaqiVMocjmoOcCiJhJp+ybalel5w98BZyh+KSNyKAWo0U2QzVgIVm8QqaE3EZ6rS4hqSgnJaOaAJUsaC2UI+t7N8OsSxv8qz/AAj+hug3LT+GWP5Nn/g32XHt/wAXbs9jZvc0uvXWw2JktJmpw+kry3ftzZD/ALVp/wCn/wBLtsj7N6nS4+OVmv0H8MsPybP/AAb7IPw6x/Js/wDBvsuP4H8cZtIcWtc27dm9FZnCDuXnbT+2dkx7mGztCWuc0xc/pJBI+rCibFvPpyS3Mr0vivw+yFhakWbARZvIIY2QbpqKL5Yyq+m/xNtvsltaNa5ouWoh0TRp0K+bbLs73uDWAuc6YaIkwJOOgBXPn8Y8n4vLePb8suwqY6ar03/AdqArYkAYmW0AxzXmO88e/BZryXhZ7mC/KThSVTwtX7I9rWvc0hjjDSaBxiaZxTHCihJ9HIFu0q9j2N9o66xpc7RtabzkMKncttt2C1sSBaMLZwmIMYwRQo122zc8OWc1AfWU7UxzWMqJI7wULm2e0y6LdZqWYzdRRaGKLsbsj3Nc5rSWsEuOQHE57l5t5GpHTYvpGi0XEx8GV1gys1LCeFBWqgtKzqRE5JucgMRdKa0QqUOCd0pEEDBZ0Adlog2m5I0FE4Cmq5qoyorivHzUux7xXreeQPbI+yhgkrVhrGqbWweNUWXAglUFjaPy7hFk0nurK6NnfIjRcgK0sZmiNXj4abQ+sdVNlaRTI+azdmCodgUWcfGPtNpsVna2bG2jQ4ANcJ1uxPQnqvwu27FZjb/lBoDPmWQu5Q5rCR4nqvoWyfgZ/a3yC8i3/Z5rto/eL7gbzHRAj6Q0Aa/0rreOvp9bpd045POz+HhftQTsZsxs38oPDy+6B9RaWXZvThed1XZsp+HOa11obIvcAXEmpcQC4nfJK9T4/wDAW7SWEvc24HRABm9d1/t8V5X/AEJZ/nP6NUsuscunznK2SWfGvVixGyWvyLty5afhqJumfRfMrG2cxwc0lrhgWyHAERiDpRfSx8NGz7Ja2YcXC5amTANWmlF8zxE98Fnn8OX4nZ27Mr9l8W2i0+RsQ+a5vzAxr3BxBIc1gJJmuJNVfxrY9mbZ2zLjGljAWFrHB83aB74hwcYGPjh+S2vbnvYxrnFzWCGCBQQBFBOAGOi1tfje0OZcNs5zYqDdqNC6Lx5lO6J/243dnw/SbfstnZWTLNmyC2vWJJtADevQPqvAEjGYBGIhdWwuZ8jY2PsmWgebv1AED6XG8ARE0C/KN+L27bP5bbVwZEXRH4dA6LwG4FT/ABS2AYA8xZGWiG/TQiRSuJxTvhOtxl2T7P1nw2wDBtzbARaNJDQMQCwlgH+4ujkvHja3DZm7QCbI2zB9bReJvxD7xvVBdjiF4/8AE7ZtobZto4PP4nCK8REEboT2j4tbPc177Rzi0gtmAAQZBDQImQMlm85iXq8bMm/17fpPiXyP3lmzDZ7MAWtmXOAb9QLJLSIoPqGeW9La/hTGs293yWgNj5RuAR/KBNwxqcl+Y2ja3utPmlxLyW/VQGWwGkRhgOgW+3/Hdpe0tdbEtcLpbDII5NzTvizq8Luz9vT9bs+y7OHbNZnZrI/NsS5zrokFrGnTEya4rj2HZbNli+1FiLd3z3Wd0i9da15ZAEGDAx3hflB8atw5jvmm9ZtLWGGfS0gAgUrQDHRV8N+M29m55ZaObfJc78JBccXQRAJ3JecavV4bufZ+u+EWgZYbW42IAaZ+U6YH0/hM5LxP212OzY+ydZsawPs5LWgATwFBQ+C4v4law9t8xaVfMGTvJqo27bH2oaHuLrrYbIAgaUWLzmY53qy8e3P9rzCV0bO/LouWUNcsVzseikoD07y5sYpCj5gQHqVcWkpvJX1BJkO8koKb3SN+SbH0QYuOShpBxICbxAnrv78kXrowP3XscpCaQTUinmtGNBMjJQLSNefmmHRTXuUXDtHUXKXSttpbAEd71gXI3xngwQuuwZAnVcrHCROC9H5YUpycu0Nz6rBxovRNkCuG2bddHcJDj58Psuy/EbG4z+bZ/hb/AFt0G9dH7/Zfms/yb7r4dK79ncYAK6d72/m7J6fYv3+y/NZ/k33S/iFj+az/ACb7r5DfrgofaA5YKd9+ifm7+n7vqvxbbrI2FqBaMJNm8ABzZJummK+WNEAd71nenl3Pe9Wz6vIe6zy5a4dbq3qWWzEl1eKTnAUBFeyizdWYOlEfNkzXd33ks65qhuAjz5qyYWV/PuirEXuwBl3qspiQRgT10SJGEjju7omx0CYNfJS20zg95Kaq4BoI3qnxULK/mqeIE5575Uo5XUoVvZN15pOAABINK8VXzdxS1poEnlSXwlaiMM6c9e9ywjK0jFFgATJwC1e4ARB0UsfAAAKa18NmjNJxUh9YSeaga9981GVSMZQCFD7TKCi/NFFatGalxSY+TGimaxGCIHvGMhIBuZEofaVitE/nFFTZGanLD1Snplw7p+qbRLaUp46IukgRlgIjlivW5CyGIPYSIIJw65a96JSZEdjvyTtcs8zAimmO7wRcWyol2Y8O6rjc2DB70Xa/CRhQ8lntFmSL0zG7JF4uYLu2K1kXTiPJefNVTHlrgdEbvHY9hY7XZXmyMR3C1Y8EAjNUsuU8V5lgy9y7hdIJTuXTSADXCaqWv+queB71V1v20dQU71WLjnp5d1WrpnHKlJ4rNwjz9xyU0i7RtJHY1UAmbsRwOXRFk4xiAMpGXVFhiQccuGnJRVWp00rwy9v0UTWdaH0PorgyRIruy7lZvEAg19QcPZZ0i7VnCuPp6JMcSYyFfZAcbtSMNPWU7DMZzXfvTT4J5ru9cfukzHjhx7qmxpgic60zxnHms3zhnPj3VTRb2wcoqdK9+adk4mpyw49+qTySMRPD7qmVbSlI4FZtPhBNdww9emCdkKx04IDSQIOGAjlGPJSSZEY9zKmqHAgnCmFTh07hXZmRJzEcu/RRbEmKg8BFNMe4Vvq2mFDyUtETOPYyPqqsxIIOOfoQk8E1meWXdVIJvU55oAkiaCeJ9u5V/wBMnHHnl7KLQ1k1AiYpw6T4rS0GBnP9CgzNePr3RW0S2mPrp6JPacetM8vbops3GTFAd2ffkoEHERQTxz6LR9AIxy3zj7qGn6q5yBlX794q3g3gZypTPvyQQdRl4jP3WzGiMQsnNjn55j16qWOdFMOCAs3Qdx8/utcDuPmuYEYE96rVloHUJwx0Jy9+i9bHaLRkGdfPP36ouxzr7hUxjSZAEDOM+/NFqZET9iEBYug3eY9QtGUMdOGnL2XMHgjGCK8CO4WjHtdUxGQPifTki45dosrroyNR7LMLtNiHAkAD/Tl3K4HFHTj5d/w+2rcPJegvCYaiDVesLbgpWOXHy0tGXhC4yMjT0IXSLQxJhctu+s8j7rKRs115uhHgQgtvNjsELBtqGmZmaEeR9FZLYrBcd2J0Ci4lrJ15nMZHonOYxFR6haNaGjLyqVg99ZyPn91NHSXSA4cfcKbVl4AjKojRYstYMA/iw3HPlmqcG4AAk7q7yVDCDKTJpzpuRfgzpjw+y2JDYG6g4LmvAGOnDRTVdL/9XXhry91FvZ4O5GPBZstB+Caa/wDjpxyVOa1xgAb6DD7+6hmFdivL274JsfB3Gh45H0Wj3Co3eBXMHDAnd91ndI6jQ7j5/fvFY2rIM66HMdz1SZaB1CcMd+nuqa1pNAIGcZ9+iHpN2Odeenr1VWL4MZGo9R6otXAgifsQsb4Ixg+RCns9uptDHMeo71WL7ODFdRXvuE2WjXVMQMjrn7dU7NgJvADQQMe/RPR6TdinZBV2LsWnLxHdFNq6RTKvHcsvmCjgcPEZhXNX26WDFp/UZHvRYiz/AKZOmPiqD2n6jG6RgO6psaAC6AJ5QB34onpBGR4exHgVqx14QcRQ8dfVZWzs+R4aqRaBpmdx9Cpity280g/oe/ArGOPVXLYkwSd08h5K7NkDJVPTG/dbgdZpU9ewrDi1uB4mIrmarIurGVbvr7cFTXEC7llw05ey9SY2dQADE9z6rmfTDOn373LWwJkilBSTH09O4CbGCrjmMN33xQngrR8ANAIyy9+yVTjQCCAYGXoeSxBmQeHLLvVWXEiHZUPofJFxta/6RpXh3TqvP2ltaYHHj9/ddlm8wSYJBrU8oEdyh1kAw3s688gPAKas8MtlZmQa8MPuusmSAuZryRofI+3oqdaE7j5ELNK1tXdB33yXOw/VEEhuGHLHT2WgeS0UFaYmZzmmVTyRaNutAGIw3nOfEqagD5fgaVimOGqthl1aRkd+fp1XOw4FuWG8ZjvNN7z+IY+YOMeYUq40tK44VHuR3kVFg6SSQTFKRHGuqt8kBoiCMiTAGYpy5qdogYaQf7e/VTSfQ7J8kkA6DCmeufstLM4uOVOEa+fRYNcQZGkHhkeRSLq7iQHT4E86FSmLfqaZicow+/FFi+hcWmvCgGWKpzS4wYgVMEngMOf6qLZ31bqT/dl6eCzouwdSbprw6YqmO+m9rX0geSxa4iYwPgfuPJDCbwwgyYNPq7k9VKYLSlTjuznLyjgmH3WTBrXKp64eisNvOvGPpoIzP2w6rJzvqjKsf8u+KDRriG4HWaRxocFZo0AVJ88Z8ysWuIF3LEcMxyPmE7EkGKUH0ySKTXLh0CGM7Qxhiaff34rR74aAARll1x3q2MmXmKiN0ffHosA6ZBrl/ty5oN3mgEECgmlOhVWuF0aeHdFiXEi67KnEZFVZPIBJgkYmTMZQI7JKmGMnY3RUHGI59Y81paPkht0+GGmO7zVXIaSaE1pkcgOCxBnHGejvbDkqN3GSAQROsVjKndEWpkxkIn09+izc8ncfIjvoqY83cBJoambxxmncKYYyZ+KIJArSOQrpPktL8u/CaVimPVN7LrQBjNN5znlKyacC3EVG/UHj5qjoaZdWkCYO/P0UvJJoYHf6clk95P1DHLgcu9F0Mc6BAbEan2QcpadcMBShFI9Fu43gLuOPDIjmafohC9RWNwnOYrGEjMc10WhLm0OhpmMYQhSo5zP4pmPEZ+62tq1aaAVO418MeaEKVWTQQbxMxj6HkttokgGYg150B71QhSjFlHSTTA7tD6dFdoDMgwCY4nCfTkNUIUoVkCDJrNOB+8eG9VtEyDNIjniev/FCFkRYEA1OMwcIOJHr1ScDjMA1A9D589yEINNn+mmtRw05E+Km1DrxrjUYYYR180IWSexYOABBrSm8YRxmihzHChPrQ9kckIUG9gYF04jE6zgfTkud7TUFxxrhnUEd+SEKQ+WrHS27/VMc8Q715LMscaF1Z0FCM/XgUIQdFm43YFDEcD3VcpYcJwwwoRSPRNCkI2JvNAbjjwihB8v0WJYTmTFdJ1B44IQrCOl5Lm0zrxGY6LlM4zMV4jP3TQkI1tTNWmgFTuNY5Y/qs2tIN4mbuPDXfBqhCDa3kgGYg18p5LBtDJNMD6FCEhGlqCSSDAmOJwnhlyCmyBBvHOnA688EIQXtEyDMDDnj4x4KLAw6poeUHuvVCEnogcDiDANR6+/M6KPlHSfTcmhUf//Z";

    static {
        bTags.add(generateTag("B2C", "Industry", "#800000"));
        bTags.add(generateTag("IOT", "Technology", "#808000"));
        bTags.add(generateTag("Marketing", "Topic", "#008080"));

        author = new Author();
        author.setName("Tech Crunch");
    }

    @Override
    public BSampleResponse sampleBFeeds(BSampleRequest bSampleRequest) {
        // not using bSampleRequest for now as it will be used when paginated response is sent.

        // Making sample feed with static data.
        List<BSampleFeed> feeds = generateSampleFeeds();

        return BSampleResponse.builder()
                .feeds(feeds)
                .build();
    }

    private List<BSampleFeed> generateSampleFeeds() {
        List<BSampleFeed> bSampleFeeds = new ArrayList<>();

        // First feed
        BSampleFeed bSampleFeedFirst = new BSampleFeed();
        bSampleFeedFirst.setArticleUrl("https://techcrunch.com/2021/08/27/new-zealand-based-imagr-thinks-camera-based-ai-is-the-future-of-shopping-trolleys/");
        bSampleFeedFirst.setBody("\"1. Boosted by the pendamic era, The value of transactions processed by frictionless checkout technology is estimated to reach $387 billion by 2025\n" +
                "2. Amazon proved that the end user wants something frictionless, but Amazon’s walk-out tech is expected to cost retailers upwards of $1 million.\n" +
                "3. Imagr is building a modular method, tech that attaches to the trolley and uses cameras to detect and label products, adding them to a virtual cart.\n" +
                "4. Running the Imagr system in one store uses the same amount of data as streaming HD Netflix for a day whereas one might need to process 1.6TB of information every second to operate the walk out tech\n" +
                "5. Imagr is currently raising its Series A after it raised $9.5 million in seed funding at the end of November 2019 in a round led by Toshiba Tec. Chomley says Imagr has raised a total of $12.5 million to date.\n" +
                "6. Standard Cognition has copied Amazon’s style of walk-out tech to distribute to stores. Earlier this year, the San Francisco-based company, which is now valued at $1 billion, raised $150 million in a Series C and announced a partnership with Circle K\n" +
                "\"");
        bSampleFeedFirst.setTags(bTags);
        bSampleFeedFirst.setTitle("Boon of Contactless Shopping");
        bSampleFeedFirst.setAuthor(author);
        bSampleFeedFirst.setHeaderImageUrl(imageUrl);

        bSampleFeeds.add(bSampleFeedFirst);

        // Second Feed
        BSampleFeed bSampleFeedSecond = new BSampleFeed();
        bSampleFeedSecond.setArticleUrl("https://techcrunch.com/2021/08/27/making-a-splash-in-the-marketing-world/");
        bSampleFeedSecond.setBody("\"1. There are three common blunders that most SaaS marketers make time and again when it comes to clarity and high-converting content\n" +
                "1.1 Not differentiating from competitors. \n" +
                "2.1 Not humanizing ‘tech talk.’ \n" +
                "3.1 Not tuning their messaging to prospects’ stage of awareness at the appropriate stage of the funnel\n" +
                "2. By creating content for every stage of the funnel, you’ll address your prospects’ concerns at the appropriate point in the buyer journey and increase the chances that when they do come to make a purchase, it’s with you\n" +
                "3. When speaking about using content for carousels on Instagram and LinkedIn \"\"The first slide should grab attention — it can be a question. The second slide can be a link to the interview so that even if people don’t click it, it will be on their minds. Then you can have slides with insights\"\"\"");
        bSampleFeedSecond.setTags(bTags);
        bSampleFeedSecond.setTitle("Make a splash in Marketing World");
        bSampleFeedSecond.setAuthor(author);
        bSampleFeedSecond.setHeaderImageUrl(imageUrl);

        bSampleFeeds.add(bSampleFeedSecond);

        // Third feed
        BSampleFeed bSampleFeedThird = new BSampleFeed();
        bSampleFeedThird.setArticleUrl("https://techcrunch.com/2021/08/27/china-proposes-strict-control-of-algorithms/");
        bSampleFeedThird.setBody("\"1. China on Friday issued draft guidelines on regulating the algorithms firms run to make recommendations to users\n" +
                "2. the Cyberspace Administration of China (CAC) proposed forbidding companies from deploying algorithms that “encourage addiction or high consumption”\n" +
                "3. The guidelines also propose that users should be provided with the ability to easily turn off algorithm recommendations. 4. Algorithm providers who have the power to influence public opinion or mobilize the citizens need to get an approval from the CAC\n" +
                "5. Beijing-backed China Consumers Association said local internet companies had been “bullying” users into purchases and promotions and undermining their privacy rights.\n" +
                "6. Beijing’s recent data-security crackdown and tightening regulations around tutor services have spooked investors and wiped out hundreds of billions of dollars.\n" +
                "7. In recent years, several governments, including those in the U.S. and India, have attempted — to little to no success — to get better clarity on how these big tech companies’ algorithms work and put checks in place to prevent misuse.\"");
        bSampleFeedThird.setTags(bTags);
        bSampleFeedThird.setTitle("China proposes strict control of algorithms");
        bSampleFeedThird.setAuthor(author);
        bSampleFeedThird.setHeaderImageUrl(imageUrl);

        bSampleFeeds.add(bSampleFeedThird);

        return bSampleFeeds;
    }

    private static BTag generateTag(String name, String category, String color) {
        BTag bTag = new BTag();
        bTag.setName(name);
        bTag.setCategory(category);
        bTag.setColor(color);
        return bTag;
    }

}
