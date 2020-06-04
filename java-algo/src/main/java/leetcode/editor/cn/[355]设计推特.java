package leetcode.editor.cn;
//设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个
//功能： 
//
// 
// postTweet(userId, tweetId): 创建一条新的推文 
// getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
// 
// follow(followerId, followeeId): 关注一个用户 
// unfollow(followerId, followeeId): 取消关注一个用户 
// 
//
// 示例: 
//
// 
//Twitter twitter = new Twitter();
//
//// 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
//twitter.postTweet(1, 5);
//
//// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//twitter.getNewsFeed(1);
//
//// 用户1关注了用户2.
//twitter.follow(1, 2);
//
//// 用户2发送了一个新推文 (推文id = 6).
//twitter.postTweet(2, 6);
//
//// 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
//// 推文id6应当在推文id5之前，因为它是在5之后发送的.
//twitter.getNewsFeed(1);
//
//// 用户1取消关注了用户2.
//twitter.unfollow(1, 2);
//
//// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//// 因为用户1已经不再关注用户2.
//twitter.getNewsFeed(1);
// 
// Related Topics 堆 设计 哈希表

import java.util.*;

class DesignTwitter {
    public static void main(String[] args) {

        Twitter twitter = new DesignTwitter().new Twitter();

// User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
        twitter.getNewsFeed(1);

// User 1 follows user 2.
        twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
        twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.getNewsFeed(1);

// User 1 unfollows user 2.
        twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
        twitter.getNewsFeed(1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Twitter {
        private int timeStamp = 0;
        private Map<Integer, User> userMap;

        private class Tweet {
            public int id;
            public int time;
            public Tweet next;

            public Tweet(int id) {
                this.id = id;
                time = timeStamp++;
                next = null;
            }
        }

        public class User {
            public int id;
            public Set<Integer> followed;
            public Tweet tweet_head;

            public User(int id) {
                this.id = id;
                followed = new HashSet<>();
                follow(id);// 首先跟着自己
                tweet_head = null;
            }

            public void follow(int id) {
                followed.add(id);
            }

            public void unfollow(int id) {
                followed.remove(id);
            }

            public void post(int id) {
                Tweet tweet = new Tweet(id);
                tweet.next = tweet_head;
                tweet_head = tweet;
            }
        }

        /**
         * Initialize your data structure here.
         */
        public Twitter() {
            userMap = new HashMap<Integer, User>();
        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            if (!userMap.containsKey(userId)) {
                User user = new User(userId);
                userMap.put(userId, user);
            }
            userMap.get(userId).post(tweetId);
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            List<Integer> res = new LinkedList<>();
            if (!userMap.containsKey(userId)) {
                return res;
            }
            Set<Integer> users = userMap.get(userId).followed;
            PriorityQueue<Tweet> queue = new PriorityQueue<>(users.size(), (a, b) -> (b.time - a.time));
            for (Integer user : users) {
                Tweet tweet = userMap.get(user).tweet_head;
                if (tweet != null) {
                    queue.add(tweet);
                }
            }
            int n = 0;
            while (!queue.isEmpty() && n < 10) {
                Tweet tweet = queue.poll();
                res.add(tweet.id);
                n++;
                if (tweet.next != null) {
                    queue.add(tweet.next);
                }
            }
            return res;
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {
            if (!userMap.containsKey(followerId)) {
                User user = new User(followerId);
                userMap.put(followerId, user);
            }
            if (!userMap.containsKey(followeeId)) {
                User user = new User(followeeId);
                userMap.put(followeeId, user);
            }
            userMap.get(followerId).follow(followeeId);
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {
            if (!userMap.containsKey(followerId) || followerId == followeeId) {
                return;
            }
            userMap.get(followerId).unfollow(followeeId);
        }
    }

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
//leetcode submit region end(Prohibit modification and deletion)

}