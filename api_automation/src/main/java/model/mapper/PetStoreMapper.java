package model.mapper;


import model.model.Category;
import model.model.ApiRequest;
import java.util.ArrayList;


public class PetStoreMapper {

    public static ApiRequest requestToAvailRQ(String id, String name) {
        int petId = Integer.parseInt(id);
        ApiRequest searchPriceRequestDto = new ApiRequest();

        searchPriceRequestDto.setId(petId);
        searchPriceRequestDto.setCategory(new Category());
        searchPriceRequestDto.getCategory().setId(1);
        searchPriceRequestDto.getCategory().setName("dogs");
        searchPriceRequestDto.setName(name);
        searchPriceRequestDto.setTags(new ArrayList<>());
        searchPriceRequestDto.setStatus("available");

        return searchPriceRequestDto;
    }
}
