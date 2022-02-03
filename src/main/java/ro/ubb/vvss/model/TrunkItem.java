package ro.ubb.vvss.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ro.ubb.vvss.model.base.Entity;

@Getter
@Setter
@ToString
public class TrunkItem extends Entity
{
    private String name;

    public TrunkItem(String name) {
        this.name = name;
    }
}
