package flickr.imagesearch.model;

import com.google.gson.annotations.SerializedName;

public class Photo {
    @SerializedName("id")
    private String id;
    @SerializedName("owner")
    private String owner;
    @SerializedName("secret")
    private String secret;
    @SerializedName("server")
    private String server;
    @SerializedName("farm")
    private int farm;
    @SerializedName("title")
    private String title;
    @SerializedName("ispublic")
    private int ispublic;
    @SerializedName("isfriend")
    private int isfriend;
    @SerializedName("isfamily")
    private int isfamily;


    public Photo() {

    }

    public Photo(String id, String owner, String secret, String server, int farm, String title, int ispublic, int isfriend, int isfamily) {
        this.id = id;
        this.owner = owner;
        this.secret = secret;
        this.server = server;
        this.farm = farm;
        this.title = title;
        this.ispublic = ispublic;
        this.isfriend = isfriend;
        this.isfamily = isfamily;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSecret() {
        return this.secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getServer() {
        return this.server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getFarm() {
        return this.farm;
    }

    public void setFarm(int farm) {
        this.farm = farm;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublic() {
        return this.ispublic;
    }

    public void setPublic(int ispublic) {
        this.ispublic = ispublic;
    }

    public int getFriend() {
        return this.isfriend;
    }

    public void setFriend(int isfriend) {
        this.isfriend = isfriend;
    }

    public int getFamily() {
        return this.isfamily;
    }

    public void setFamily(int isfamily) {
        this.isfamily = isfamily;
    }
}