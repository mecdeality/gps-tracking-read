package com.team2.gpstrackingread;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class RestMapController {
    @Autowired
    private LocationServiceClass locationService;

    public static class RestResponse {
        private float latitude;
        private float longitude;

        public float getLatitude() {
            return latitude;
        }

        public float getLongitude() {
            return longitude;
        }

        public void setLatitude(float latitude) {
            this.latitude = latitude;
        }

        public void setLongitude(float longitude) {
            this.longitude = longitude;
        }
    }

    public RestResponse globalRes;


    @GetMapping(value = "/get-last-tracking", produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse lastTracking(Model model) throws JsonProcessingException {
//        String json = new ObjectMapper().writeValueAsString(globalRes);
        RestResponse response = new RestResponse();
        List<LocationDomain> l = locationService.findAll();

        LocationDomain x = l.get(l.size() - 1);

        response.setLatitude(x.getLatitude());
        response.setLongitude(x.getLongitude());

        return response;
    }
}
