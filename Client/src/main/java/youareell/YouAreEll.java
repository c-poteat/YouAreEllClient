package youareell;

import controllers.*;

public class YouAreEll {
    MessageController messageController;
    IdController idController;
    TransactionController t;


    public YouAreEll (TransactionController t,MessageController m, IdController j) {
        this.t = t;
        this.messageController = m;
        this.idController = j;
    }

    public static void main(String[] args) {
        // hmm: is this Dependency Injection?
        YouAreEll urlhandler = new YouAreEll(
            new TransactionController(), new MessageController(), new IdController());
        System.out.println(urlhandler.MakeURLCall("/ids", "GET", ""));
        urlhandler.idController.getIds();
        System.out.println(urlhandler.MakeURLCall("/messages", "GET", ""));
    }

    private String MakeURLCall(String s, String get, String s1) {
    return "";

    }
    public String get_ids() {
        return t.makecall("/ids", "GET", "");
    }

    public String get_messages() {
        return MakeURLCall("/messages", "GET", "");
    }

}
