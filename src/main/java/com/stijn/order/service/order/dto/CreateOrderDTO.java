package com.stijn.order.service.order.dto;

import java.util.List;

public class CreateOrderDTO {
    private List<CreateItemGroupDTO> listOfItemGroups;
    private final String userEmail;

    public CreateOrderDTO(List<CreateItemGroupDTO> listOfItemGroups, String userEmail) {
        this.listOfItemGroups = listOfItemGroups;
        this.userEmail = userEmail;
    }


    public List<CreateItemGroupDTO> getListOfItemGroups() {
        return listOfItemGroups;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
