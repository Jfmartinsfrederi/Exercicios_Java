public class UserAccount {
    private UserAccount user;
    private String userName;
    private String email;

    private Post[] myPosts;
    private Post[] myTimeLine;
    private UserAccount[] myFollowers;

    private int numMyFollowers;
    private int numMyPosts;

    public UserAccount(String userName, String email) {
        this.userName = userName;
        this.email = email;
        this.myPosts = new Post[100];
        this.myTimeLine = new Post[10];
        this.myFollowers = new UserAccount[100];
        this.numMyFollowers = 0;
        this.numMyPosts = 0;
    }

    public void publish(String quote){
        myPosts[numMyPosts++]= new Post(this.user,quote);

        for (int i = 0; i < numMyFollowers; i++) {
            

        }
    }

    public String getUserName() {
        return userName;
    }
}
