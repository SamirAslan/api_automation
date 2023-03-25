
package model.model;


import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class ApiResponse {

    @SerializedName("id")
    public int id;
    @SerializedName("category")
    public Category category;
    @SerializedName("name")
    public String name;
    @SerializedName("photoUrls")
    public List<String> photoUrls;
    @SerializedName("tags")
    public List<Tags> tags;
    @SerializedName("status")
    public String status;
}
