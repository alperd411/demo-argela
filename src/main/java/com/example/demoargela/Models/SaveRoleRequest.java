package com.example.demoargela.Models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

@Data
@AllArgsConstructor
@Getter
@Setter
@JsonDeserialize
@NoArgsConstructor
public class SaveRoleRequest {
    private  String Role;



}
