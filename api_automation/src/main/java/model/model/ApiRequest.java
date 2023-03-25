package model.model;


import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class ApiRequest {
    public int id;

    public Category category;
    public String name;

    public List<String> photoUrls;
    public List<Tags> tags;

    public String status;


}
