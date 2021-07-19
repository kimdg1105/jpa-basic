package hellojpa.entity.inheritance;


import hellojpa.entity.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
//@DiscriminatorValue("M")
public class Movie extends Item {
    private String director;

    private String actor;
}
