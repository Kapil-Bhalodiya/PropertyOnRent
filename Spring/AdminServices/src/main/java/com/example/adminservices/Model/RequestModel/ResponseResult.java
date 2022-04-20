package com.example.adminservices.Model.RequestModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@Service
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResult {

    private boolean Success;
    private boolean Error;
    private String Message;
}
