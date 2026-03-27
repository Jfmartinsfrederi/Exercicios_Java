package org.example;

public class Useraccont {

    private String userName;
    private String email;

    private Useraccont[] followers;
    private Post[] myPosts;
    private Post[] timeline;

    private int numOfFollowers;
    private int numOfMyPosts;
    private int numOfTimeLinePosts;

    public Useraccont(String userName, String email) {
        this.userName = userName;
        this.email = email;
        this.followers=new Useraccont[100];
        this.timeline=new Post[10];
        this.myPosts=new Post[100];
    }

    public void publish(String quote){
        final Post post=new Post(this,quote);
        myPosts[numOfMyPosts++]=post;

        for (int i=0;i<numOfFollowers;i++){
            followers[i].updateTimeLine(post);
        }

    }

    public void updateTimeLine(Post post){

        timeline[numOfTimeLinePosts%10]=post;
        numOfTimeLinePosts++;

    }

    public boolean delete(int postIndex){
        if (postIndex<0 || postIndex>=numOfMyPosts) return false;

        myPosts[postIndex]=myPosts[numOfMyPosts-1];
        myPosts[numOfMyPosts-1]=null;
        numOfMyPosts--;
        return true;
    }

    public void clapPost(int postIndex){
        if (isInvalidTimeLineIndex(postIndex)) return;
        timeline[postIndex].clap();


    }


    public void booPost(int postIndex){
        if (isInvalidTimeLineIndex(postIndex)) return;
        timeline[postIndex].boo();


    }

    private boolean isInvalidTimeLineIndex(int postIndex) {
        return postIndex < 0 || postIndex >= Math.min(numOfTimeLinePosts, 10);
    }

    public void acceptFollower(Useraccont follower){
        followers[numOfFollowers++]=follower;
    }

    public void blockFollower(Useraccont follower){
        if (follower==null) return;

        for (int i = 0; i < numOfFollowers; i++) {
            Useraccont useraccont = followers[i];
            if (useraccont.getUserName().equals(follower.getUserName())){
                followers[i]=followers[numOfFollowers-1];
                followers[numOfFollowers-1]=null;
                numOfFollowers--;

            }

        }
    }

    public String timeLIneAsString(){
        final StringBuilder builder=new StringBuilder("TimeLine: ");
        for (int i = 0; i < Math.min(numOfTimeLinePosts,10); i++) {
            Post post=timeline[i];
            builder.append(post.getAsString()).append("\n");


        }
        return builder.toString();
    }

    public String followersAsString(){
        final StringBuilder builder=new StringBuilder("Followers: ");
        for (int i = 0; i < numOfFollowers; i++) {

            builder.append(followers[i].getUserName()).append("\n");


        }
        return builder.toString();
    }

    public String myPostsAsString(){
        final StringBuilder builder=new StringBuilder("Posts: ");
        for (int i = 0; i < numOfMyPosts; i++) {

            builder.append(myPosts[i].getAsString()).append("\n");


        }
        return builder.toString();
    }



    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }
}
