package com.team2.gpstrackingread;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface LocationService {
    List<LocationDomain> findAll();
    public LocationDomain create(LocationDomain location);
}

