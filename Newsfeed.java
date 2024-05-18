package NewsFeed;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Newsfeed {
    List<NewsfeedEntity> newsList = new ArrayList<>();
    void storeNewsfeedEntity(String id, String postTimeISO){
        NewsfeedEntity newNews = new NewsfeedEntity(id,postTimeISO);
        newsList.add(newNews);
    }

    NewsfeedEntity[] getLatestNewsfeedEntities(int K){
        List<NewsfeedEntity> latestNews = newsList;
        List<NewsfeedEntity> resultList = new ArrayList<>();
        latestNews.sort((o1, o2) -> o2.getPostDate().compareTo(o1.getPostDate()));

        if(newsList.isEmpty()){
            return null;
        } else if (latestNews.size() < K) {
            for (int i = 0; i < K; i++) {
                resultList.add(latestNews.get(i));
                K--;
            }
            while (K!=0)
            {
                resultList.add(null);
                K--;
            }
        }
        else{
            for (int i = 0; i < K; i++) {
                resultList.add(latestNews.get(i));
            }
        }


        NewsfeedEntity[] result = new NewsfeedEntity[latestNews.size()];
        result = latestNews.toArray(result);
        return result;
    }
    NewsfeedEntity[] getLatestNewsfeedEntities(int K, String beforeTime){
        List<NewsfeedEntity> latestNews = new ArrayList<>();
        Instant beforeTimeLimit = Instant.parse(beforeTime);

        for (NewsfeedEntity entity : newsList)
        {
            if (entity.getPostDate().isBefore(beforeTimeLimit))
            {
                latestNews.add(entity);
            }
        }

        latestNews.sort((o1, o2) -> o2.getPostDate().compareTo(o1.getPostDate()));

        NewsfeedEntity[] result = new NewsfeedEntity[latestNews.size()];
        result = latestNews.toArray(result);
        return result;
    }
}
