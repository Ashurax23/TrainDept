package com.train.traindep.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.http.HttpResponse;
import java.util.Map;

@Service
public class TrainService {

    private String accessToken;
    private String url="http://20.244.56.144/train/trains";
    public ResponseEntity<String> getTrains(){

        String requestJson ="{ \"companyName\": \"Train Department\",\"clientID\": \"e8998099-c462-4e73-b345-817dbc184203\",\"ownerName\": \"Jaswanth\", \"rollNo\":\"20981a0597\",\"ownerEmail\":\"techiejaswanth@gmail.com\",\"clientSecret\": \"jrpEBlRzIZVSUAgx\"}";
        HttpHeaders headers1= new HttpHeaders();
        headers1.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers1);
        String result = new RestTemplate().postForObject("http://20.244.56.144/train/auth", entity, String.class);
        System.out.println(result);
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, String> map = mapper.readValue(result, Map.class);
            accessToken = map.get("access_token");
        }
        catch(Exception e){
            return null;
        }
        HttpHeaders headers = new HttpHeaders();
        RestTemplate restTemplate=new RestTemplate();
        headers.setBearerAuth(accessToken);
        try {
            return restTemplate.exchange(RequestEntity.get(new URI(url)).headers(headers).build(), String.class);
        }
        catch(Exception e){
            return null;
        }
    }

}
