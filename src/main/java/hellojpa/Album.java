package hellojpa;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//타입?을 정해준다

@Entity
@DiscriminatorValue("A")
public class Album extends Item{
        private String artist;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
